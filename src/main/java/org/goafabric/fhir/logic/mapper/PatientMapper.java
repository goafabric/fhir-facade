package org.goafabric.fhir.logic.mapper;

import org.goafabric.fhir.adapter.Person;
import org.hl7.fhir.r4.model.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.util.Arrays.asList;

public class PatientMapper {
    public static List<Patient> map(List<Person> person) {
        return asList(map(person.get(0)));
    }

    public static Patient map(Person person) {
        Patient patient = new Patient();
        patient.setId(person.getId());
        patient.setName(
                asList(new HumanName()
                        .setGiven(asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName())
        ));

        patient.setAddress(asList(createAddress()));
        patient.setTelecom(asList(createTelecom()));
        return patient;
    }

    @NotNull
    private static Address createAddress() {
        return new Address()
                .setCity("Springfield")
                .setPostalCode("78313")
                .setCountry("US")
                .setLine(asList(new StringType("Evergreen Terrace 742")))
                .setUse(Address.AddressUse.HOME);
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
