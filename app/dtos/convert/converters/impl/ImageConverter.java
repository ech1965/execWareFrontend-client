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

import com.google.inject.Inject;
import dtos.ImageDto;
import dtos.convert.impl.BaseConverter;
import models.Image;
import models.OperatingSystem;
import models.service.impl.OperatingSystemServiceImpl;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by daniel seybold on 10.12.2014.
 */
public class ImageConverter extends BaseConverter<Image, ImageDto> {

    private final OperatingSystemServiceImpl operatingSystemServiceImpl;

    @Inject
    ImageConverter(OperatingSystemServiceImpl operatingSystemServiceImpl) {

        checkNotNull(operatingSystemServiceImpl);

        this.operatingSystemServiceImpl = operatingSystemServiceImpl;

    }

    @Override
    public Image toModel(ImageDto dto, Image model) {
        checkNotNull(dto);
        checkNotNull(model);
        model.setName(dto.getName());

        OperatingSystem operatingSystem = operatingSystemServiceImpl.getById(dto.getOperatingSystem());
        checkState(operatingSystem != null, "Could not retrieve operating system for id: " + dto.getOperatingSystem());
        model.setOperatingSystem(operatingSystem);

        return model;
    }

    @Override
    public ImageDto toDto(Image model) {
        checkNotNull(model);
        return new ImageDto(model.getName(), model.getOperatingSystem().getId());
    }
}
