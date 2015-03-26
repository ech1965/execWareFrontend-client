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

package models.repository.impl;

import models.Cloud;
import models.CloudImage;
import models.Image;
import models.repository.api.CloudImageRepository;
import models.repository.impl.generic.ModelRepositoryJpa;

import static models.util.JpaResultHelper.*;

/**
 * Created by daniel on 31.10.14.
 */
public class CloudImageRepositoryJpa extends ModelRepositoryJpa<CloudImage> implements CloudImageRepository {

    /**
     * Searches the concrete image on the given cloud and the image
     *
     * @param cloud the cloud
     * @param image the image
     * @return the unique cloud image if any, otherwise null.
     */
    @Override
    public CloudImage findByCloudAndImage(final Cloud cloud, final Image image) {

        return (CloudImage) getSingleResultOrNull(em()
                .createQuery("from Image i where cloud = :cloud and image = :image")
                .setParameter("cloud", cloud)
                .setParameter("image", image));

    }
}
