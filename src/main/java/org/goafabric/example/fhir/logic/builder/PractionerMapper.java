package org.goafabric.example.fhir.logic.builder;


import org.goafabric.example.fhir.adapter.Person;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.StringType;

import java.util.Arrays;
import java.util.List;

public class PractionerMapper {
    public static List<Practitioner> map(List<Person> person) {
        return Arrays.asList(map(person.get(0)));
    }
    public static Practitioner map(Person person) {
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
