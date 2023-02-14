package org.goafabric.fhir.adapter;

import org.goafabric.fhir.controller.dto.Organization;

public interface OrganizationAdapter {
    Organization getOrganization(String id);
}
