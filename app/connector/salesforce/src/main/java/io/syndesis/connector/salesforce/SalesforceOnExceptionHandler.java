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

import io.syndesis.common.util.Properties;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class SalesforceOnExceptionHandler implements Processor, Properties {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesforceOnExceptionHandler.class);

    @Override
    public void process(Exchange exchange) {
        LOGGER.info("Entered...");
        LOGGER.error("Exception: ", exchange.getException());

        exchange.getOut().setBody("Setting OUT body: " + exchange.getException());
        exchange.getIn().setBody("Setting IN body: " + exchange.getException());
    }

    @Override
    public void setProperties(Map<String, String> configuredProperties) {
        LOGGER.info("configuredProperties: " + configuredProperties != null ? configuredProperties.toString() : "null");
    }
}
