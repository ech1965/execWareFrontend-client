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

package de.uniulm.omi.executionware.entities.internal;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by daniel on 21.01.15.
 */
public abstract class AbstractEntity implements Entity {

    @JsonIgnore
    @Nullable
    private List<Link> links;

    @JsonIgnore
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty
    public void setLinks(@Nullable List<Link> links) {
        this.links = links;
    }

    public AbstractEntity(@Nullable List<Link> links) {
        this.links = links;
    }

    public AbstractEntity() {

    }

    @Override
    public String getSelfLink() {
        checkNotNull(this.links);
        for (Link link : this.links) {
            if (link.getRel().equals("self")) {
                return link.getHref();
            }
        }
        throw new IllegalStateException("self link not present in entity");
    }
}
