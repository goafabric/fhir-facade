package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.goafabric.fhir.adapter.mock.OrganizationMockAdapter;
import org.goafabric.fhir.controller.dto.Organization;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class OrganizationRemoteAdapter implements OrganizationAdapter {
    private OrganizationMockAdapter organizationMockAdapter = new OrganizationMockAdapter();

    @Override
    public Organization getOrganization(String idType) {
        return organizationMockAdapter.getOrganization(idType);
    }


}
