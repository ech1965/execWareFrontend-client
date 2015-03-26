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

package models.service.impl;

import com.google.inject.Inject;
import models.Cloud;
import models.CloudHardware;
import models.Hardware;
import models.repository.api.CloudHardwareRepository;
import models.service.api.CloudHardwareService;
import models.service.impl.generic.ModelService;

/**
 * Created by daniel on 03.11.14.
 */
public class CloudHardwareServiceImpl extends ModelService<CloudHardware> implements CloudHardwareService {

    @Inject
    public CloudHardwareServiceImpl(CloudHardwareRepository cloudHardwareRepository) {
        super(cloudHardwareRepository);
    }

    @Override
    public CloudHardware getByCloudAndHardwareFlavor(final Cloud cloud, final Hardware hardware) {
        return ((CloudHardwareRepository) this.modelRepository).findByCloudAndHardwareFlavor(cloud, hardware);
    }
}
