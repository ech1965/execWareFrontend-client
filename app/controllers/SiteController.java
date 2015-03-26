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

package controllers;

import com.google.inject.Inject;
import controllers.security.SecuredSessionOrToken;
import models.service.api.FrontendUserService;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Site controller.
 * <p>
 * Provides basic actions for the side like login, logout and the main index page.
 *
 * @author Daniel Baur
 */
@Security.Authenticated(SecuredSessionOrToken.class)
public class SiteController extends Controller {

    private final FrontendUserService frontendUserService;

    @Inject
    public SiteController(final FrontendUserService frontendUserService) {
        this.frontendUserService = frontendUserService;
    }

    @Transactional(readOnly = true)
    public Result index() {
        return ok(views.html.site.index.render(this.frontendUserService.getByMail(request().username())));
    }

    public Result manage() {
        return ok(views.html.site.management.render());
    }

    public Result help() {
        return ok(views.html.site.help.render());
    }
}
