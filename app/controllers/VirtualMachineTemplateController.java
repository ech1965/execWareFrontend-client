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
import controllers.generic.GenericApiController;
import dtos.VirtualMachineTemplateDto;
import dtos.convert.api.ModelDtoConversionService;
import models.VirtualMachineTemplate;
import models.service.api.VirtualMachineTemplateService;
import models.service.api.generic.ModelServiceInterface;

/**
 * Created by daniel on 12.02.15.
 */
public class VirtualMachineTemplateController extends GenericApiController<VirtualMachineTemplate, VirtualMachineTemplateDto> {

    /**
     * Constructs a GenericApiController.
     *
     * @param virtualMachineTemplateService      the model service for retrieving the models.
     * @param conversionService the conversion service for converting models and dtos.
     */
    @Inject
    protected VirtualMachineTemplateController(VirtualMachineTemplateService virtualMachineTemplateService, ModelDtoConversionService conversionService) {
        super(virtualMachineTemplateService, conversionService);
    }

    @Override
    protected String getSelfRoute(Long id) {
        return controllers.routes.VirtualMachineTemplateController.get(id).absoluteURL(request());
    }
}
