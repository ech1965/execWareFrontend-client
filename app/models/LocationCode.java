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
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by daniel on 10.11.14.
 */
@Entity
public class LocationCode extends Model {

    @ManyToMany(mappedBy = "locationCodes")
    private List<Location> locations;

    private String iso3166Alpha2;

    /**
     * Empty constructor for hibernate.
     */
    private LocationCode() {
    }

    public String getIso3166Alpha2() {
        return iso3166Alpha2;
    }

    public void setIso3166Alpha2(String iso3166Alpha2) {
        this.iso3166Alpha2 = iso3166Alpha2;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
