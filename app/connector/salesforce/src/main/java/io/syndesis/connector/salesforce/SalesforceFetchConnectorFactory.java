/*
 * Copyright (C) 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.connector.salesforce;

import io.syndesis.integration.component.proxy.ComponentDefinition;
import io.syndesis.integration.component.proxy.ComponentProxyComponent;
import io.syndesis.integration.component.proxy.ComponentProxyFactory;
import org.apache.camel.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SalesforceFetchConnectorFactory implements ComponentProxyFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesforceFetchConnectorFactory.class);

    @Override
    public ComponentProxyComponent newInstance(String componentId, String componentScheme) {
        LOGGER.info("Entered...");
        return new SalesforceFetchConnector(componentId, componentScheme);
    }

    private static class SalesforceFetchConnector extends ComponentProxyComponent {
        private static final Logger LOGGER = LoggerFactory.getLogger(SalesforceFetchConnector.class);

        SalesforceFetchConnector(String componentId, String componentScheme) {
            super(componentId, componentScheme);
        }

        @Override
        protected Endpoint createDelegateEndpoint(ComponentDefinition definition, String scheme, Map<String, String> options) {
            LOGGER.info("Entered...");
            return super.createDelegateEndpoint(definition, scheme, options);
        }
    }
}
