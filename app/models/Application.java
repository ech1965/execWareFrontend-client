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

import models.generic.NamedModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by daniel on 12.12.14.
 */
@Entity
public class Application extends NamedModel {

    @OneToMany(mappedBy = "application")
    private List<ApplicationComponent> applicationComponents;

    /**
     * Empty constructor for hibernate.
     */
    private Application(){
    }

    public Application(String name){
        super(name);
    }

    public List<ApplicationComponent> getApplicationComponents() {
        return applicationComponents;
    }

    public void setApplicationComponents(List<ApplicationComponent> applicationComponents) {
        this.applicationComponents = applicationComponents;
    }
}
