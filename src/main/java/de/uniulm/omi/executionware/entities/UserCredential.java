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
@Path("userCredential")
public class UserCredential extends AbstractEntity {

    private Long cloudApi;
    private Long credential;
    private Long frontendUser;

    public UserCredential(@Nullable List<Link> links, Long cloudApi, Long credential, Long frontendUser) {
        super(links);
        this.cloudApi = cloudApi;
        this.credential = credential;
        this.frontendUser = frontendUser;
    }

    public UserCredential(Long cloudApi, Long credential, Long frontendUser) {
        this(null, cloudApi, credential, frontendUser);
    }

    protected UserCredential() {
    }

    public Long getCloudApi() {
        return cloudApi;
    }

    public void setCloudApi(Long cloudApi) {
        this.cloudApi = cloudApi;
    }

    public Long getCredential() {
        return credential;
    }

    public void setCredential(Long credential) {
        this.credential = credential;
    }

    public Long getFrontendUser() {
        return frontendUser;
    }

    public void setFrontendUser(Long frontendUser) {
        this.frontendUser = frontendUser;
    }
}
