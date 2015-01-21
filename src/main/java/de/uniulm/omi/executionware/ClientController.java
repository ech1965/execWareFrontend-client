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
import de.uniulm.omi.executionware.entities.internal.Path;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by daniel on 21.01.15.
 */
public class ClientController<T extends Entity> {

    private final WebTarget webTarget;
    private final Class<T> type;

    public ClientController(String url, Class<T> clazz) {
        this.type = clazz;
        checkState(type.isAnnotationPresent(Path.class));
        url = url + "/" + type.getAnnotation(Path.class).value() + "/";

        webTarget = ClientBuilder.newBuilder().register(JacksonJsonProvider.class).register(LoggingFilter.class).build().target(url);
    }

    public T get(long id) {
        return this.webTarget.path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get(this.type);
    }

    public List<T> getList() {
        return new ArrayList<T>();
    }

    public T put(T t) {
        return null;
    }

    public T post(T t) {
        return null;
    }

    public void delete(T t) {

    }


}
