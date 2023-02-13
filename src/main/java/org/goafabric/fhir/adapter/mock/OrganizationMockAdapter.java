package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.goafabric.fhir.pojo.r4.Organization;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class OrganizationMockAdapter implements OrganizationAdapter {
    public Organization getOrganization(String id) {
        return org.goafabric.fhir.pojo.r4.Organization.builder()
                .id(id)
                .name("Krust Burger")
                .address(Arrays.asList(createAddress()))
                .build();
    }


    private org.goafabric.fhir.pojo.r4.Address createAddress() {
        return org.goafabric.fhir.pojo.r4.Address.builder()
                .id("22")
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(asList("Clownstreet 452"))
                .use("HOME")
                .build();
    }

}
