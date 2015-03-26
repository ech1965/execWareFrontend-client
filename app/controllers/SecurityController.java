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

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import components.security.Password;
import dtos.LoginDto;
import models.ApiAccessToken;
import models.service.api.ApiAccessTokenService;
import models.service.api.FrontendUserService;
import models.service.impl.ApiAccessTokenServiceImpl;
import models.service.impl.FrontendUserServiceImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by daniel on 19.12.14.
 */
public class SecurityController extends Controller {

    private final static Form<LoginDto> loginForm = Form.form(LoginDto.class);
    private final FrontendUserService frontendUserService;
    private final ApiAccessTokenService apiAccessTokenService;

    public Result login() {
        return ok(views.html.site.login.render(loginForm));
    }

    @Inject
    public SecurityController(FrontendUserServiceImpl frontendUserService, ApiAccessTokenServiceImpl apiAccessTokenService) {
        this.frontendUserService = frontendUserService;
        this.apiAccessTokenService = apiAccessTokenService;
    }

    @Transactional(readOnly = true)
    public Result authenticate() {
        Form<LoginDto> filledForm = loginForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(views.html.site.login.render(filledForm));
        } else {
            session().clear();
            session("email", filledForm.get().getEmail());
            return redirect(routes.SiteController.index());
        }
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result authenticateApi() {
        final Form<LoginDto> filledForm = loginForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(filledForm.errorsAsJson());
        }
        //generate a new token
        ApiAccessToken apiAccessToken = new ApiAccessToken(this.frontendUserService.getByMail(filledForm.get().getEmail()), Password.getInstance().generateToken());
        this.apiAccessTokenService.save(apiAccessToken);

        ObjectNode result = Json.newObject();
        result.put("createdOn", apiAccessToken.getCreatedOn());
        result.put("expiresAt", apiAccessToken.getExpiresAt());
        result.put("token", apiAccessToken.getToken());
        result.put("userId", apiAccessToken.getFrontendUser().getId());
        return ok(result);
    }

    public Result logout() {
        session().clear();
        flash("success", "You have been successfully logged out.");
        return redirect(routes.SecurityController.login());
    }


}
