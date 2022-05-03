package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class OrganizationRemoteAdapter implements OrganizationAdapter {
    @Override
    public Organization getOrganization(String id) {
        return null;
    }
}
