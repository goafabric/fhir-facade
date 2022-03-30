package org.goafabric.fhir.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.goafabric.fhir.service.resource.CustomConfiguration;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

@Component
public class CustomConfigurationService extends AbstractJaxRsResourceProvider<CustomConfiguration> {

    public CustomConfigurationService(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<CustomConfiguration> getResourceType() {
        return CustomConfiguration.class;
    }

    @Read
    public CustomConfiguration getCustomResource(@IdParam final IdType idType) {
        final CustomConfiguration configuration =  new CustomConfiguration();
        configuration.setClientSystemId(new StringType("Secret Client"));
        configuration.setMandantId(new StringType("42"));
        configuration.setWorkplaceId(new StringType("Special Workplace"));
        return configuration;
    }

}
