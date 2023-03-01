package org.goafabric.fhir.adapter.mock;

import org.hl7.fhir.r4.model.IdType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrganizationMockAdapterTest {
    OrganizationMockAdapter adapter = new OrganizationMockAdapter();

    @Test
    void getOrganization() {
        var organization = adapter.getOrganization(new IdType());
        assertThat(organization).isNotNull();
        assertThat(organization.getName()).isEqualTo("Krusty Burger");
    }

    @Test
    void getOrganizationNull() {
        assertThatThrownBy(() -> adapter.getOrganization(null)).isInstanceOf(Exception.class);
    }

    @Test
    void createAddress() {
        var address = adapter.createAddress();
        assertThat(address).isNotNull();
        assertThat(address.getCity()).isEqualTo("Springfield");
    }
}