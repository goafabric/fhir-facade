package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.hl7.fhir.r4.model.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public Practitioner getPractitioner(IdType idType) {
        final Practitioner practitioner = new Practitioner()
                .addName(createName())
                .addAddress(createAddress())
                .addTelecom(createTelecom());

        practitioner.setId(idType.getId());
        return practitioner;
    }

    private HumanName createName() {
        return new HumanName()
                .addGiven("Monty")
                .setFamily("Burns");
    }
    private Address createAddress() {
        final Address address = new Address()
                .setCity("Springfield")
                .setPostalCode("78313")
                .setCountry("US")
                .addLine("Evergreen Terrace 742")
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
