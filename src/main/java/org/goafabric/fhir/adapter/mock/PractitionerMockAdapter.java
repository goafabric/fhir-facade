package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.pojo.r4.Telecom;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public org.goafabric.fhir.pojo.r4.Practitioner getPractitioner(String id) {
        return org.goafabric.fhir.pojo.r4.Practitioner.builder()
                .id(id)
                .name(Arrays.asList(createName()))
                .address(Arrays.asList(createAddress()))
                .telecom(Arrays.asList(createTelecom()))
                .build();
    }

    private org.goafabric.fhir.pojo.r4.Patient createPatient(String id) {
        return org.goafabric.fhir.pojo.r4.Patient.builder()
                .id(id)
                .name(Arrays.asList(createName()))
                .address(Arrays.asList(createAddress()))
                .telecom(Arrays.asList(createTelecom()))
                .build();
    }


    private org.goafabric.fhir.pojo.r4.HumanName createName() {
        var humanName = org.goafabric.fhir.pojo.r4.HumanName.builder()
                .given(Arrays.asList("Monty"))
                .family("Burns")
                .build();

        return humanName;
    }

    private org.goafabric.fhir.pojo.r4.Address createAddress() {
        return org.goafabric.fhir.pojo.r4.Address.builder()
                .id("42")
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(asList("Evergreen Terrace 742"))
                .use("home")
                .build();
    }

    public static Telecom createTelecom() {
        return org.goafabric.fhir.pojo.r4.Telecom.builder()
                .id("45")
                .system("phone")
                .use("home")
                .value("0245-33553")
                .build();
    }
}
