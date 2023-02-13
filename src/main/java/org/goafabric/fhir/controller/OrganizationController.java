package org.goafabric.fhir.controller;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.goafabric.fhir.logic.OrganizationLogic;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationController extends AbstractJaxRsResourceProvider<Organization> {
    @Autowired
    private OrganizationLogic organizationLogic;

    public OrganizationController(FhirContext fhirContext) {
        super(fhirContext);
    }
    
    @Override
    public Class<Organization> getResourceType() {
        return Organization.class;
    }

    @Read
    public Organization getOrganization(@IdParam final IdType idType) {
        return organizationLogic.getOrganization(idType);
    }
}
