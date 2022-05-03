package org.goafabric.fhir.logic;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class OrganizationLogic {
    @Autowired
    OrganizationAdapter organizationAdapter;

    public Organization getOrganization(final IdType idType) {
        return organizationAdapter.getOrganization(idType.getId());
    }
}
