package org.goafabric.fhir.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.goafabric.fhir.service.resource.TIConfiguration;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

@Component
public class TIConfigurationService extends AbstractJaxRsResourceProvider<TIConfiguration> {

    public TIConfigurationService(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<TIConfiguration> getResourceType() {
        return TIConfiguration.class;
    }

    @Read
    public TIConfiguration getTIConfiguration(@IdParam final IdType idType) {
        final TIConfiguration configuration =  new TIConfiguration();
        configuration.setClientSystemId(new StringType("Secret Client"));
        configuration.setMandantId(new StringType("42"));
        configuration.setWorkplaceId(new StringType("Special Workplace"));
        return configuration;
    }

}
