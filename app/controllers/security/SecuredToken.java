/*
 * Copyright (c) 2014-2015 University of Ulm
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package controllers.security;

import com.google.inject.Inject;
import com.google.inject.Provider;
import models.FrontendUser;
import models.service.api.ApiAccessTokenService;
import models.service.api.FrontendUserService;
import play.db.jpa.JPA;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import javax.persistence.EntityManager;

/**
 * Created by daniel on 19.12.14.
 */

public class SecuredToken extends Security.Authenticator {

    public static class References {

        @Inject
        public static Provider<ApiAccessTokenService> apiAccessTokenServiceProvider;

        @Inject
        public static Provider<FrontendUserService> frontendUserServiceInterfaceProvider;
    }

    @Override
    public String getUsername(final Http.Context context) {

        final String token = context.request().getHeader("X-Auth-Token");

        long userId;
        try {
            userId = Long.parseLong(context.request().getHeader("X-Auth-UserId"));
        } catch (NumberFormatException e) {
            return null;
        }

        if (token == null || token.isEmpty()) {
            return null;
        }
        if (userId == 0) {
            return null;
        }

        //remember the entity manager
        //workaround for https://github.com/playframework/playframework/pull/3388
        final EntityManager em = JPA.em();
        final FrontendUser frontendUser;
        try {
            frontendUser = JPA.withTransaction(() -> References.frontendUserServiceInterfaceProvider.get().getById(userId));
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        //workaround continue. Bind the old one.
        JPA.bindForCurrentThread(em);

        if (frontendUser == null) {
            return null;
        }

        //remember the entity manager
        //workaround for https://github.com/playframework/playframework/pull/3388
        final EntityManager em1 = JPA.em();
        final String mail;
        try {
            if (JPA.withTransaction(() -> References.apiAccessTokenServiceProvider.get().isValid(token, frontendUser))) {
                mail = frontendUser.getMail();
            } else {
                mail = null;
            }
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        //workaround continue. Bind the old one.
        JPA.bindForCurrentThread(em1);

        return mail;
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        return unauthorized();
    }
}
