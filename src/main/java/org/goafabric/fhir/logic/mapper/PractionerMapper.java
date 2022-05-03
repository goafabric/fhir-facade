package org.goafabric.fhir.logic.mapper;


import org.goafabric.fhir.adapter.Person;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.StringType;

import java.util.List;

import static java.util.Arrays.asList;

public class PractionerMapper {
    public static List<Practitioner> map(List<Person> person) {
        return asList(map(person.get(0)));
    }
    public static Practitioner map(Person person) {
        final Practitioner practitioner = new Practitioner()
                .setName(asList(new HumanName()
                        .setGiven(asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName())
                        ))
                .setAddress(asList(MockUtil.createAddress()))
                .setTelecom(asList(MockUtil.createTelecom()));

        practitioner.setId(person.getId());
        return practitioner;
    }
}
