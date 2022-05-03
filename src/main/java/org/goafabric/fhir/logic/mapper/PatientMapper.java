package org.goafabric.fhir.logic.mapper;

import org.goafabric.fhir.adapter.Person;
import org.hl7.fhir.r4.model.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class PatientMapper {
    public static List<Patient> map(List<Person> person) {
        return Arrays.asList(map(person.get(0)));
    }

    public static Patient map(Person person) {
        Patient patient = new Patient();
        patient.setId(person.getId());
        patient.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName())
        ));

        patient.setAddress(Arrays.asList(createAddress()));

        ContactPoint telecom = createTelecom();

        patient.setTelecom(Arrays.asList(telecom));
        return patient;
    }

    @NotNull
    private static Address createAddress() {
        final Address address = new Address();
        address.setCity("Springfield");
        address.setPostalCode("78313");
        address.setCountry("US");
        address.setLine(Arrays.asList(new StringType("Evergreen Terrace 742")));
        address.setUse(Address.AddressUse.HOME);
        return address;
    }

    @NotNull
    private static ContactPoint createTelecom() {
        ContactPoint telecom = new ContactPoint();
        telecom.setSystem(ContactPoint.ContactPointSystem.PHONE);
        telecom.setUse(ContactPoint.ContactPointUse.HOME);
        telecom.setValue("0245-33553");
        return telecom;
    }

}
