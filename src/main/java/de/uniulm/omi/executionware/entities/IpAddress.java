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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by frank on 21.01.15.
 */
@Path("ip")
public class IpAddress extends AbstractEntity {

    private final ArrayList<String> allowed = new ArrayList<String>(Arrays.asList("PRIVATE", "PUBLIC"));

    private String ip;
    private Long virtualMachine;
    private String ipType;

    public IpAddress(@Nullable List<Link> links, String ip, Long virtualMachine, String ipType) throws Exception {
        super(links);
        this.ip = ip;
        this.virtualMachine = virtualMachine;
        this.setIpType(ipType);
    }

    public IpAddress(String ip, Long virtualMachine, String ipType) throws Exception {
        this(null, ip, virtualMachine, ipType);
    }

    protected IpAddress() {
    }

    public Long getVirtualMachine() {
        return virtualMachine;
    }

    public void setVirtualMachine(Long virtualMachine) {
        this.virtualMachine = virtualMachine;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) throws Exception {
        if (!allowed.contains(ipType)) {
            throw new Exception("Wrong IP-Type!");
        }
        this.ipType = ipType;
    }
}
