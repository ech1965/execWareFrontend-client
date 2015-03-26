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

package dtos.convert.converters.impl;

import dtos.LifecycleComponentDto;
import dtos.builders.LifecycleComponentDtoBuilder;
import dtos.convert.impl.BaseConverter;
import models.LifecycleComponent;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by daniel seybold on 16.12.2014.
 */
public class LifecycleComponentConverter extends BaseConverter<LifecycleComponent, LifecycleComponentDto> {

    @Override
    public LifecycleComponent toModel(LifecycleComponentDto dto, LifecycleComponent model) {
        checkNotNull(dto);
        checkNotNull(model);
        model.setName(dto.getName());
        model.setDownload(dto.getDownload());
        model.setInstall(dto.getInstall());
        model.setStart(dto.getStart());
        model.setStop(dto.getStop());

        return model;
    }

    @Override
    public LifecycleComponentDto toDto(LifecycleComponent model) {
        return new LifecycleComponentDtoBuilder()
                .name(model.getName())
                .download(model.getDownload())
                .install(model.getInstall())
                .start(model.getStart())
                .stop(model.getStop())
                .build();
    }
}
