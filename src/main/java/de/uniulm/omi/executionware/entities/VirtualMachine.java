/*
 * Copyright (c) 2015 University of Ulm
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

package de.uniulm.omi.executionware.entities;

import de.uniulm.omi.executionware.entities.internal.AbstractEntity;
import de.uniulm.omi.executionware.entities.internal.Link;
import de.uniulm.omi.executionware.entities.internal.NamedEntity;
import de.uniulm.omi.executionware.entities.internal.Path;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by frank on 21.01.15.
 */
@Path("virtualMachine")
public class VirtualMachine extends NamedEntity {

    private Long cloud;
    private Long cloudImage;
    private Long cloudHardware;
    private Long cloudLocation;

    public VirtualMachine(@Nullable List<Link> links, String name, Long cloud, Long cloudImage, Long cloudHardware, Long cloudLocation) {
        super(links, name);
        this.cloud = cloud;
        this.cloudImage = cloudImage;
        this.cloudHardware = cloudHardware;
        this.cloudLocation = cloudLocation;
    }

    public VirtualMachine(String name, Long cloud, Long cloudImage, Long cloudHardware, Long cloudLocation) {
        this(null, name, cloud, cloudImage, cloudHardware, cloudLocation);
    }

    protected VirtualMachine() {
    }

    public Long getCloud() {
        return cloud;
    }

    public void setCloud(Long cloud) {
        this.cloud = cloud;
    }

    public Long getCloudImage() {
        return cloudImage;
    }

    public void setCloudImage(Long cloudImage) {
        this.cloudImage = cloudImage;
    }

    public Long getCloudHardware() {
        return cloudHardware;
    }

    public void setCloudHardware(Long cloudHardware) {
        this.cloudHardware = cloudHardware;
    }

    public Long getCloudLocation() {
        return cloudLocation;
    }

    public void setCloudLocation(Long cloudLocation) {
        this.cloudLocation = cloudLocation;
    }
}
