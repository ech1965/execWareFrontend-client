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
import de.uniulm.omi.executionware.entities.internal.Path;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by frank on 21.01.15.
 */
@Path("hardware")
public class Hardware extends AbstractEntity {

    private Integer numberOfCpu;
    private Long mbOfRam;
    private Long localDiskSpace;

    public Hardware(@Nullable List<Link> links, Integer numberOfCpu, Long mbOfRam, Long localDiskSpace) {
        super(links);
        this.numberOfCpu = numberOfCpu;
        this.mbOfRam = mbOfRam;
        this.localDiskSpace = localDiskSpace;
    }

    public Hardware(Integer numberOfCpu, Long mbOfRam, Long localDiskSpace) {
        this(null, numberOfCpu, mbOfRam, localDiskSpace);
    }

    protected Hardware() {
    }

    public Integer getNumberOfCpu() {
        return numberOfCpu;
    }

    public void setNumberOfCpu(Integer numberOfCpu) {
        this.numberOfCpu = numberOfCpu;
    }

    public Long getMbOfRam() {
        return mbOfRam;
    }

    public void setMbOfRam(Long mbOfRam) {
        this.mbOfRam = mbOfRam;
    }

    public Long getLocalDiskSpace() {
        return localDiskSpace;
    }

    public void setLocalDiskSpace(Long localDiskSpace) {
        this.localDiskSpace = localDiskSpace;
    }
}
