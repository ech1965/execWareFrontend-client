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

import de.uniulm.omi.executionware.entities.Cloud;
import de.uniulm.omi.executionware.entities.PaasageModel;

import java.util.Base64;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {

    public static Random random = new Random();

    public static void main(String[] args) {

        //An example
        exampleModel();
        //get the controller for the cloud entity
        final ClientController<Cloud> controller =
                ClientBuilder.getNew()
                        // the base url
                        .url("http://localhost:9000/api")
                                // the login credentials
                        .credentials("john.doe@example.com", "admin")
                                // the entity to get the controller for.
                        .build(Cloud.class);


        //create a new Cloud
        controller.create(new Cloud("MyCloud-"+random.nextInt(100)));
        //fetch all clouds
        List<Cloud> clouds = controller.getList();

        //fetch the first cloud from the list
        Cloud cloud = clouds.get(0);

        //update a cloud
        cloud.setName("MyNewName-"+random.nextInt(100));
        controller.update(cloud);

        //delete a cloud
        controller.delete(cloud);
    }

    private static void exampleModel() {
        //An example

        //get the controller for the cloud entity
        final ClientController<PaasageModel> controller =
                ClientBuilder.getNew()
                        // the base url
                        .url("http://localhost:9000/api")
                                // the login credentials
                        .credentials("john.doe@example.com", "admin")
                                // the entity to get the controller for.
                        .build(PaasageModel.class);

        //fetch all clouds
        List<PaasageModel> models = controller.getList();


        PaasageModel model = new PaasageModel("NAME_1"+random.nextInt(100), "CREATE" ,"CREATED", "empty", "UNCHANGED");

        model = controller.create(model);

        //update a cloud
        model.setAction(PaasageModel.Action.UPLOAD_XMI.toString());
        String modelContents = "BIDON";

        model.encodeXmiModel(modelContents);
        controller.update(model);

        //delete a cloud
        controller.delete(model);

    }
}
