package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.pojo.r4.HumanName;
import org.hl7.fhir.r4.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PatientMockAdapter implements PatientAdapter {
    public Patient getPatient(IdType idType) {
        Patient patient = createPatient(idType);
        return patient;
    }

    private void pat() {
        org.goafabric.fhir.pojo.r4.Address.builder().city()
    }

    @Override
    public Patient findyFirstName(String firstName) {
        IdType idType = new IdType();
        idType.setId("1");
        return createPatient(idType);
    }

    @Override
    public Patient findyByLastName(String lastName) {
        IdType idType = new IdType();
        idType.setId("1");
        return createPatient(idType);
    }

    @Override
    public void sayMyName(String homer) {
    }

    @NotNull
    private Patient createPatient(IdType idType) {
        Patient patient = new Patient()
                .addName(createName())
                .addAddress(createAddress())
                .addTelecom(createTelecom());

        patient.setId(idType.getId());
        return patient;
    }


    private HumanName createName() {
        var humanName = org.goafabric.fhir.pojo.r4.HumanName.builder()
                .given(Arrays.asList("Homer"))
                .family("Simpson")
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
                .use(Address.AddressUse.HOME.name())
                .build();
    }

    public static ContactPoint createTelecom() {
        final ContactPoint telecom = new ContactPoint()
                .setSystem(ContactPoint.ContactPointSystem.PHONE)
                .setUse(ContactPoint.ContactPointUse.HOME)
                .setValue("0245-33553");
        telecom.setId("45");
        return telecom;
    }
}
