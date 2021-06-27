package org.goafabric.example.fhir.adapter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("mock")
public class PersonServiceMockAdapter implements PersonServiceAdapter{
    @Override
    public Person getById(String id) {
        return Person.builder().id(id)
                .firstName("Homer").lastName("Simpson").build();
    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        return Arrays.asList(Person.builder().id("0")
                .firstName("Homer").lastName("Simpson").build());
    }

    @Override
    public Boolean isAlive() {
        return Boolean.TRUE;
    }
}
