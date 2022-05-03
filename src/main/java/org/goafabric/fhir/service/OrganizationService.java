package org.goafabric.fhir.service;

import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationService extends AbstractJaxRsResourceProvider<Organization> {
    @Override
    public Class<Organization> getResourceType() {
        return Organization.class;
    }


}
