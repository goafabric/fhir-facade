package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.StringType;

import static java.util.Arrays.asList;

public class OrganizationMockAdapter implements OrganizationAdapter {
    @Override
    public Organization getOrganization(String id) {
        final Organization organization = new Organization()
                .setAddress(asList(createAddress()));
        organization.setId(id);

        return organization;
    }

    private Address createAddress() {
        final Address address = new Address()
                .setCity("Springfield")
                .setPostalCode("78313")
                .setCountry("US")
                .setLine(asList(new StringType("Evergreen Terrace 742")))
                .setUse(Address.AddressUse.WORK);
        address.setId("22");
        return address;
    }
}
