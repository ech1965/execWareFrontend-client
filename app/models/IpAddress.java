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

package models;

import models.generic.Model;

import javax.persistence.*;

/**
 * Created by daniel on 12.03.15.
 */
@Entity
public class IpAddress extends Model {

    @Column(updatable = false)
    private String ip;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private IpType ipType;

    @ManyToOne(optional = false)
    private VirtualMachine virtualMachine;

    /**
     * Empty constructor for hibernate.
     */
    private IpAddress() {
    }

    public IpAddress(String ip, IpType ipType) {
        this.ip = ip;
        this.ipType = ipType;
    }

    public String getIp() {
        return ip;
    }

    public IpType getIpType() {
        return ipType;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setIpType(IpType ipType) {
        this.ipType = ipType;
    }

    public VirtualMachine getVirtualMachine() {
        return virtualMachine;
    }

    public void setVirtualMachine(VirtualMachine virtualMachine) {
        this.virtualMachine = virtualMachine;
    }
}
