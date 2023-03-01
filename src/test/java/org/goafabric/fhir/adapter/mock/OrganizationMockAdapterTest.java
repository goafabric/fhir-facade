package org.goafabric.fhir.adapter.mock;

import org.hl7.fhir.r4.model.IdType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrganizationMockAdapterTest {
    OrganizationMockAdapter adapter = new OrganizationMockAdapter();

    @Test
    void getOrganization() {
        var organization = adapter.getOrganization(new IdType());
        assertThat(organization).isNotNull();
        assertThat(organization.getName()).isEqualTo("Krusty Burger");
    }

    @Test
    void createAddress() {
        var address = adapter.createAddress();
        assertThat(address).isNotNull();
        assertThat(address.getCity()).isEqualTo("Springfield");
    }
}