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

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by daniel on 31.10.14.
 */
@Entity
public class UserCredential extends Model {

    /**
     * Serial Version.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The associated CloudApi
     */
    @ManyToOne(optional = false)
    private CloudApi cloudApi;

    /**
     * The associated Credentials
     */
    @ManyToOne(optional = false)
    private Credential credential;

    /**
     * The associated FrontendUser
     */
    @ManyToOne(optional = false)
    private FrontendUser frontendUser;

    /**
     * Empty constructor for hibernate.
     */
    private UserCredential() {
    }

    public CloudApi getCloudApi() {
        return cloudApi;
    }

    public void setCloudApi(CloudApi cloudApi) {
        checkNotNull(cloudApi);
        this.cloudApi = cloudApi;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        checkNotNull(credential);
        this.credential = credential;
    }

    public FrontendUser getFrontendUser() {
        return frontendUser;
    }

    public void setFrontendUser(FrontendUser frontendUser) {
        checkNotNull(frontendUser);
        this.frontendUser = frontendUser;
    }
}
