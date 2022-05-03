package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mock")
@Component
public class OrganizationMockAdapter implements OrganizationAdapter {
    @Override
    public Organization getOrganization(IdType idType) {
        final Organization organization = new Organization()
                .setName("Krusty Burger")
                .addAddress(createAddress());

        organization.setId(idType.getId());
        return organization;
    }

    private Address createAddress() {
        final Address address = new Address()
                .setCity("Springfield")
                .setPostalCode("78313")
                .setCountry("US")
                .addLine("Clownstreet 452")
                .setUse(Address.AddressUse.WORK);
        address.setId("22");
        return address;
    }
}
