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

package models.service.impl.generic;

import models.generic.Model;
import models.repository.api.generic.ModelRepository;
import models.service.api.generic.ModelServiceInterface;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by daniel on 31.10.14.
 */
public abstract class ModelService<T extends Model> implements ModelServiceInterface<T> {

    protected final ModelRepository<T> modelRepository;

    public ModelService(ModelRepository<T> modelRepository) {
        checkNotNull(modelRepository);
        this.modelRepository = modelRepository;
    }

    @Override
    @Nullable
    public T getById(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public List<T> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public void save(T entity) {
        this.modelRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        this.modelRepository.delete(entity);
    }
}
