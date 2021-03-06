/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.oozie.fluentjob.api.mapping;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Instantiates and configures a {@link DozerBeanMapper} to use custom mapping files.
 */
public class DozerBeanMapperSingleton {
    private static DozerBeanMapper mapper;

    private static void init() {
        final List<String> mappingFiles = new ArrayList<>();
        mappingFiles.add("dozer_config.xml");
        mappingFiles.add("mappingGraphToWORKFLOWAPP.xml");
        mappingFiles.add("action_mappings.xml");
        mapper = (DozerBeanMapper)DozerBeanMapperBuilder.create().withMappingFiles(mappingFiles).build();
    }

    public static DozerBeanMapper instance() {
        if (mapper == null) {
            init();
        }

        return mapper;
    }
}
