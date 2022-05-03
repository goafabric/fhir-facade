package org.goafabric.fhir.adapter;

import org.hl7.fhir.r4.model.Organization;

public interface OrganizationAdapter {
    Organization getOrganization(String id);
}
