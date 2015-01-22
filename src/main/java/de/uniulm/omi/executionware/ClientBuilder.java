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

package de.uniulm.omi.executionware;

import de.uniulm.omi.executionware.entities.internal.Entity;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 21.01.15.
 */
public class ClientBuilder {

    private final String url;

    private ClientBuilder(String url) {
        this.url = url;
    }

    public static ClientBuilder getNew(String url) {
        return new ClientBuilder(url);
    }

    public <T extends Entity> ClientController<T> build(Class<T> clazz) {
        final Client client = javax.ws.rs.client.ClientBuilder.newBuilder().register(JacksonJsonProvider.class).register(LoggingFilter.class).build();
        return new ClientController<T>(client, this.url, clazz);
    }

}
