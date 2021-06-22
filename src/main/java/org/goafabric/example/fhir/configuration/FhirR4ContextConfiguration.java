package org.goafabric.example.fhir.configuration;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FhirR4ContextConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public FhirContext fhirContext() {
        return new FhirContext(FhirVersionEnum.R4);
    }
}
