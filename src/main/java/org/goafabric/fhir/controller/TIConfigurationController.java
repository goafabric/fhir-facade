package org.goafabric.fhir.controller;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.goafabric.fhir.controller.resource.TIConfiguration;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

@Component
public class TIConfigurationController extends AbstractJaxRsResourceProvider<TIConfiguration> {

    public TIConfigurationController(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<TIConfiguration> getResourceType() {
        return TIConfiguration.class;
    }

    @Read
    public TIConfiguration getTIConfiguration(@IdParam final IdType idType) {
        return TIConfiguration.builder()
                .clientSystemId(new StringType("Secret Client"))
                .mandantId(new StringType("42"))
                .workplaceId(new StringType("Special Workplace"))
                .organization(new Organization().setName("Compuglobal Hyper Mega Net"))
                .build();
    }

}
