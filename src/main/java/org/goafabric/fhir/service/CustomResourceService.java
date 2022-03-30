package org.goafabric.fhir.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

@Component
public class CustomResourceService extends AbstractJaxRsResourceProvider<CustomResource> {

    public CustomResourceService(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<CustomResource> getResourceType() {
        return CustomResource.class;
    }

    @Read
    public CustomResource getCustomResource(@IdParam final IdType idType) {
        final CustomResource cust =  new CustomResource();
        cust.setDogs(new StringType("Snoopy"));
        return cust;
    }

}
