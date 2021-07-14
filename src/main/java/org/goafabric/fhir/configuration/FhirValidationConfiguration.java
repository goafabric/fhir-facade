package org.goafabric.fhir.configuration;

import ca.uhn.fhir.rest.server.interceptor.RequestValidatingInterceptor;
import ca.uhn.fhir.rest.server.interceptor.ResponseValidatingInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ResourceCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@Conditional(FhirValidationConfiguration.SchemaAvailableCondition.class)
@ConditionalOnProperty(name = "hapi.fhir.validation.enabled", matchIfMissing = true)
public class FhirValidationConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RequestValidatingInterceptor requestValidatingInterceptor() {
        return new RequestValidatingInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "hapi.fhir.validation.request-only", havingValue = "false")
    public ResponseValidatingInterceptor responseValidatingInterceptor() {
        return new ResponseValidatingInterceptor();
    }

    static class SchemaAvailableCondition extends ResourceCondition {

        SchemaAvailableCondition() {
            super("ValidationSchema",
                    "hapi.fhir.validation",
                    "schema-location",
                    "classpath:/org/hl7/fhir/instance/model/schema",
                    "classpath:/org/hl7/fhir/dstu2016may/model/schema",
                    "classpath:/org/hl7/fhir/dstu3/model/schema");
        }
    }
}
