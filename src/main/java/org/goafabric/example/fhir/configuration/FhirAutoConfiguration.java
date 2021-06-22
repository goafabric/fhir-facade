package org.goafabric.example.fhir.configuration;

/*-
 * #%L
 * hapi-fhir-spring-boot-autoconfigure
 * %%
 * Copyright (C) 2014 - 2021 Smile CDR, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsProvider;
import ca.uhn.fhir.rest.server.HardcodedServerAddressStrategy;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import java.util.List;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for HAPI FHIR.
 *
 * @author Mathieu Ouellet
 */
@Configuration
@ConditionalOnClass(AbstractJaxRsProvider.class)
@ConfigurationProperties("hapi.fhir.rest")
@AutoConfigureAfter({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class FhirAutoConfiguration extends RestfulServer {
    @Autowired
    private FhirContext fhirContext;

    @Autowired
    private List<IResourceProvider> resourceProviders;

    @Value("${hapi.fhir.server.path}")
    private String serverPath;

    @Bean
    public ServletRegistrationBean fhirServerRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(this, serverPath);
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Override
    protected void initialize() throws ServletException {
        super.initialize();

        setFhirContext(this.fhirContext);
        setResourceProviders(this.resourceProviders);

        setServerAddressStrategy(new HardcodedServerAddressStrategy(serverPath));

        registerInterceptor(new ExceptionHandler());
        registerInterceptor(new TenantIdInterceptor());
    }
}