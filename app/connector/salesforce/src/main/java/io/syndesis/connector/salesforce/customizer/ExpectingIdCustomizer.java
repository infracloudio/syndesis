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
package io.syndesis.connector.salesforce.customizer;

import java.util.Map;

import io.syndesis.connector.salesforce.SalesforceIdentifier;
import io.syndesis.integration.component.proxy.ComponentProxyComponent;
import io.syndesis.integration.component.proxy.ComponentProxyCustomizer;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpectingIdCustomizer implements ComponentProxyCustomizer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpectingIdCustomizer.class);

    @Override
    public void customize(ComponentProxyComponent component, Map<String, Object> options) {
        LOGGER.info("Entered...");
        component.setBeforeProducer(this::beforeProducer);
    }

    public void beforeProducer(final Exchange exchange) {
        final Message in = exchange.getIn();
        final SalesforceIdentifier id = in.getBody(SalesforceIdentifier.class);

        if (id != null) {
            in.setBody(id.getId());
        }
    }
}
