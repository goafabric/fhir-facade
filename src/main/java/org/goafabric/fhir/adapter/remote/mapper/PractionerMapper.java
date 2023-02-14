package org.goafabric.fhir.adapter.remote.mapper;


import org.goafabric.fhir.adapter.remote.client.Person;
import org.goafabric.fhir.controller.dto.HumanName;
import org.goafabric.fhir.controller.dto.Practitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class PractionerMapper {
    public List<Practitioner> map(List<Person> person) {
        return asList(map(person.get(0)));
    }

    public  Practitioner map(Person person) {
        final Practitioner practitioner = Practitioner.builder()
                .name(createName(person))
                        .build();

        practitioner.setId(person.getId());
        return practitioner;
    }

    private List<HumanName> createName(Person person) {
        return Arrays.asList(HumanName.builder()
                .given(Arrays.asList(person.getFirstName()))
                .family(person.getLastName())
                .build());
    }
}
