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
import dtos.CloudImageDto;
import dtos.builders.CloudImageDtoBuilder;
import dtos.convert.impl.BaseConverter;
import models.Cloud;
import models.CloudImage;
import models.Image;
import models.service.impl.CloudServiceImpl;
import models.service.impl.ImageServiceImpl;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by daniel seybold on 10.12.2014.
 */
public class CloudImageConverter extends BaseConverter<CloudImage, CloudImageDto> {

    private final CloudServiceImpl cloudServiceImpl;
    private final ImageServiceImpl imageServiceImpl;

    @Inject
    CloudImageConverter(CloudServiceImpl cloudServiceImpl, ImageServiceImpl imageServiceImpl) {

        checkNotNull(cloudServiceImpl);
        checkNotNull(imageServiceImpl);

        this.cloudServiceImpl = cloudServiceImpl;
        this.imageServiceImpl = imageServiceImpl;
    }

    @Override
    public CloudImage toModel(CloudImageDto dto, CloudImage model) {
        checkNotNull(dto);
        checkNotNull(model);
        model.setCloudUuid(dto.getCloudUuid());

        Cloud cloud = cloudServiceImpl.getById(dto.getCloud());
        checkState(cloud != null, "Could not retrieve cloud for id: " + dto.getCloud());
        model.setCloud(cloud);

        Image image = imageServiceImpl.getById(dto.getImage());
        checkState(image != null, "Could not retrieve image for id: " + dto.getImage());
        model.setImage(image);

        return model;
    }

    @Override
    public CloudImageDto toDto(CloudImage model) {
        checkNotNull(model);
        return new CloudImageDtoBuilder()
                .cloudUuid(model.getCloudUuid())
                .cloud(model.getCloud().getId())
                .image(model.getImage().getId())
                .build();

    }
}
