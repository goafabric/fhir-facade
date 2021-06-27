package org.goafabric.example.fhir.logic.builder;


import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.StringType;

import java.util.Arrays;

public class PractionerMapper {
    public static Practitioner map(org.goafabric.example.fhir.adapter.Person person) {
        final Practitioner practitioner = new Practitioner();
        practitioner.setId(person.getId());
        practitioner.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName()))
        );
        return practitioner;
    }
}
