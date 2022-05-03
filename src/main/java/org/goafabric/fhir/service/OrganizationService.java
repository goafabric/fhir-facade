package org.goafabric.fhir.service;

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
public class OrganizationService extends AbstractJaxRsResourceProvider<Organization> {
    @Autowired
    private OrganizationLogic organizationLogic;

    public OrganizationService(FhirContext fhirContext) {
        super(fhirContext);
    }
    
    @Override
    public Class<Organization> getResourceType() {
        return Organization.class;
    }

    @Read
    public Organization getPatient(@IdParam final IdType idType) {
        return organizationLogic.getOrganization(idType);
    }
}
