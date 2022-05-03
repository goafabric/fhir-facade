package org.goafabric.fhir.adapter.remote.mapper;


import org.goafabric.fhir.adapter.remote.client.Person;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class PractionerMapper {
    public List<Practitioner> map(List<Person> person) {
        return asList(map(person.get(0)));
    }

    public  Practitioner map(Person person) {
        final Practitioner practitioner = new Practitioner()
                .addName(createName(person));

        practitioner.setId(person.getId());
        return practitioner;
    }

    private HumanName createName(Person person) {
        return new HumanName()
                .addGiven(person.getFirstName())
                .setFamily(person.getLastName());
    }
}
