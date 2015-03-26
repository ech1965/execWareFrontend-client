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
import models.CloudHardware;
import models.Hardware;
import models.repository.api.CloudHardwareRepository;
import models.repository.impl.generic.ModelRepositoryJpa;

import static models.util.JpaResultHelper.*;

/**
 * Created by daniel on 31.10.14.
 */
public class CloudHardwareRepositoryJpa extends ModelRepositoryJpa<CloudHardware> implements CloudHardwareRepository {

    /**
     * Searches the concrete hardware flavor based on the given cloud and the hardware
     *
     * @param cloud          the cloud
     * @param hardware the hardware flavor
     * @return the unique cloud hardware if any, otherwise null.
     */
    @Override
    public CloudHardware findByCloudAndHardwareFlavor(final Cloud cloud, final Hardware hardware) {

        return (CloudHardware) getSingleResultOrNull(em()
                .createQuery("from CloudHardwareFlavor ch where cloud = :cloud and hardwareFlavor = :hardwareFlavor")
                .setParameter("cloud", cloud)
                .setParameter("hardwareFlavor", hardware));

    }
}
