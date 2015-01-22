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
@Path("communication")
public class Communication extends AbstractEntity {

    private Long provider;
    private Long consumer;

    public Communication(@Nullable List<Link> links, Long provider, Long consumer) {
        super(links);
        this.provider = provider;
        this.consumer = consumer;
    }

    public Communication(Long provider, Long consumer) {
        this(null, provider, consumer);
    }

    protected Communication() {
    }

    public Long getProvider() {
        return provider;
    }

    public void setProvider(Long provider) {
        this.provider = provider;
    }

    public Long getConsumer() {
        return consumer;
    }

    public void setConsumer(Long consumer) {
        this.consumer = consumer;
    }
}
