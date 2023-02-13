package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.hl7.fhir.r4.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PatientMockAdapter implements PatientAdapter {
    public Patient getPatient(IdType idType) {
        Patient patient = createPatient(idType);
        return patient;
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
        final HumanName humanName = new HumanName()
                .addGiven("Homer")
                .setFamily("Simpson");

        humanName.getFamilyElement()
                .addExtension(new Extension("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2", new StringType("The 3rd")));
        return humanName;
    }

    private Address createAddress() {
        final Address address = new Address()
                .setCity("Springfield")
                .setPostalCode("78313")
                .setCountry("US")
                .setLine(asList(new StringType("Evergreen Terrace 742")))
                .setUse(Address.AddressUse.HOME);
        address.setId("42");
        return address;
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
