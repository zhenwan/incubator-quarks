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
package quarks.oplet.core;

import quarks.oplet.Oplet;
import quarks.oplet.OpletContext;

public abstract class AbstractOplet<I, O> implements Oplet<I, O> {

    private OpletContext<I, O> context;

    @Override
    public void initialize(OpletContext<I, O> context) {
        this.context = context;
    }

    public final OpletContext<I, O> getOpletContext() {
        return context;
    }
}
