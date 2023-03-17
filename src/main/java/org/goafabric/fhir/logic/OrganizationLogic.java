package org.goafabric.fhir.logic;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class OrganizationLogic {
    private final OrganizationAdapter organizationAdapter;

    public OrganizationLogic(OrganizationAdapter organizationAdapter) {
        this.organizationAdapter = organizationAdapter;
    }

    public Organization getOrganization(IdType idType) {
        return organizationAdapter.getOrganization(idType);
    }
}
