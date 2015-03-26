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

package models.generic;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created by daniel on 08.01.15.
 */
@MappedSuperclass
public abstract class Resource {

    @Column(unique = true, nullable = false, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    /**
     * Empty constructor for hibernate.
     */
    protected Resource() {
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Resource)) {
            return false;
        }

        Resource resource = (Resource) o;

        return this.getUuid().equals(resource.getUuid());

    }

    @Override
    public int hashCode() {
        return this.getUuid().hashCode();
    }

    @Override
    public String toString() {
        return String.format("Resource{uuid='%s'}", uuid);
    }
}
