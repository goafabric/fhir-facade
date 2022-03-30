package org.goafabric.fhir.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

@Component
public class CustomResourceService extends AbstractJaxRsResourceProvider<CustomConfiguration> {

    public CustomResourceService(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<CustomConfiguration> getResourceType() {
        return CustomConfiguration.class;
    }

    @Read
    public CustomConfiguration getCustomResource(@IdParam final IdType idType) {
        final CustomConfiguration cust =  new CustomConfiguration();
        cust.setDogs(new StringType("Snoopy"));
        return cust;
    }

}
