package org.goafabric.example.fhir.logic.builder;

import org.hl7.fhir.r4.model.*;

import java.util.Arrays;

public class PractionerBuilder {
    public static Practitioner build(IdType idType, String givenName, String familyName) {
        final Practitioner practitioner = new Practitioner();
        practitioner.setId(idType);
        practitioner.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType(givenName)))
                        .setFamily(familyName))
        );
        return practitioner;
    }
}
