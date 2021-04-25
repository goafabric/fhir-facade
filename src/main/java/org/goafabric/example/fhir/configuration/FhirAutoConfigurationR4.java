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
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsProvider;
import ca.uhn.fhir.rest.server.HardcodedServerAddressStrategy;
import ca.uhn.fhir.rest.server.IPagingProvider;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import ca.uhn.fhir.rest.server.interceptor.IServerInterceptor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import javax.servlet.ServletException;
import java.util.List;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for HAPI FHIR.
 *
 * @author Mathieu Ouellet
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class FhirAutoConfigurationR4 {

	@Bean
	@ConditionalOnMissingBean
	public FhirContext fhirContextR4() {
		FhirContext fhirContext = new FhirContext(FhirVersionEnum.R4);
		return fhirContext;
	}


	@Configuration(proxyBeanMethods = false)
	@ConditionalOnClass(AbstractJaxRsProvider.class)
	@ConfigurationProperties("hapi.fhir.rest")
	@SuppressWarnings("serial")
	static class FhirRestfulServerConfiguration extends RestfulServer {

		private final FhirContext fhirContextR4;

		private final List<IResourceProvider> resourceProviders;

		private final IPagingProvider pagingProvider;

		private final List<FhirRestfulServerCustomizer> customizers;

		public FhirRestfulServerConfiguration(
				FhirContext fhirContextR4,
				ObjectProvider<List<IResourceProvider>> resourceProviders,
				ObjectProvider<IPagingProvider> pagingProvider,
				ObjectProvider<List<IServerInterceptor>> interceptors,
				ObjectProvider<List<FhirRestfulServerCustomizer>> customizers) {
			this.fhirContextR4 = fhirContextR4;
			this.resourceProviders = resourceProviders.getIfAvailable();
			this.pagingProvider = pagingProvider.getIfAvailable();
			this.customizers = customizers.getIfAvailable();
		}

		@Bean
		public ServletRegistrationBean fhirServerRegistrationBean() {
			ServletRegistrationBean registration = new ServletRegistrationBean(this, "/fhir/r4/*");
			registration.setLoadOnStartup(1);
			return registration;
		}

		@Override
		protected void initialize() throws ServletException {
			super.initialize();

			setFhirContext(this.fhirContextR4);
			setResourceProviders(this.resourceProviders);
			setPagingProvider(this.pagingProvider);

			setServerAddressStrategy(new HardcodedServerAddressStrategy("/fhir/r4/*"));

			customize();
			this.registerInterceptor(new TenantIdInterceptor());
		}

		private void customize() {
			if (this.customizers != null) {
				AnnotationAwareOrderComparator.sort(this.customizers);
				for (FhirRestfulServerCustomizer customizer : this.customizers) {
					customizer.customize(this);
				}
			}
		}

	}
	
}