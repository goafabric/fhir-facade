package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.goafabric.fhir.adapter.mock.OrganizationMockAdapter;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class OrganizationRemoteAdapter implements OrganizationAdapter {
    private final OrganizationMockAdapter organizationMockAdapter = new OrganizationMockAdapter();

    @Override
    public Organization getOrganization(IdType idType) {
        return organizationMockAdapter.getOrganization(idType);
    }
}
