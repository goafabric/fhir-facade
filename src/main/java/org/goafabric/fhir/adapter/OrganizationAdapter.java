package org.goafabric.fhir.adapter;

import org.goafabric.fhir.pojo.r4.Organization;

public interface OrganizationAdapter {
    Organization getOrganization(String id);
}
