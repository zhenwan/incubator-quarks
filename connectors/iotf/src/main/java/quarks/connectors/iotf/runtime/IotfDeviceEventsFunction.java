/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

package quarks.connectors.iotf.runtime;

import com.google.gson.JsonObject;

import quarks.function.Consumer;
import quarks.function.Function;
import quarks.function.UnaryOperator;

/**
 * Consumer that publishes stream tuples as IoTf device events with a fixed
 * event identifier and qos.
 *
 */
public class IotfDeviceEventsFunction implements Consumer<JsonObject> {

    private static final long serialVersionUID = 1L;
    private final IotfConnector connector;
    private final Function<JsonObject, String> eventId;
    private UnaryOperator<JsonObject> payload;
    private final Function<JsonObject, Integer> qos;

    public IotfDeviceEventsFunction(IotfConnector connector, Function<JsonObject, String> eventId,
            UnaryOperator<JsonObject> payload,
            Function<JsonObject, Integer> qos) {
        this.connector = connector;
        this.payload = payload;
        this.eventId = eventId;
        this.qos = qos;
    }

    @Override
    public void accept(JsonObject event) {
        connector.publishEvent(eventId.apply(event), payload.apply(event), qos.apply(event));
    }
}
