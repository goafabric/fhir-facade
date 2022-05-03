package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.hl7.fhir.r4.model.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public Practitioner getPractitioner(String id) {
        final Practitioner practitioner = new Practitioner()
                .setName(asList(new HumanName()
                        .setGiven(asList(new StringType("Monty")))
                        .setFamily("Burns")
                ))
                .setAddress(asList(createAddress()))
                .setTelecom(asList(createTelecom()));

        practitioner.setId(id);
        return practitioner;
    }

    public static Address createAddress() {
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
