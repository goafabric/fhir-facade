package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.hl7.fhir.r4.model.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PatientMockAdapter implements PatientAdapter {
    public Patient getPatient(String id) {
        Patient patient = new Patient()
                .setName(asList(createName()))
                .setAddress(asList(createAddress()))
                .setTelecom(asList(createTelecom()));

        patient.setId(id);
        return patient;
    }

    private HumanName createName() {
        return new HumanName()
                .setGiven(asList(new StringType("Homer")))
                .setFamily("Simpson");
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
        telecom.setId("42");
        return telecom;
    }
}
