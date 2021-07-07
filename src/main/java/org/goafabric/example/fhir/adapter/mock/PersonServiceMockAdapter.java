package org.goafabric.example.fhir.adapter.mock;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.goafabric.example.fhir.adapter.Person;
import org.goafabric.example.fhir.adapter.PersonServiceAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("mock")
public class PersonServiceMockAdapter implements PersonServiceAdapter {
    @Override
    public Person getById(String id) {
        return Person.builder().id(id)
                .firstName("Homer").lastName("Simpson").build();
    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        if ("Homer".equals(firstName)) {
            return Arrays.asList(Person.builder().id("0")
                    .firstName("Homer").lastName("Simpson").build());
        } else if ("Monty".equals(firstName)) {
            return Arrays.asList(Person.builder().id("0")
                    .firstName("Monty").lastName("Burns").build());
        }  else {
            throw new ResourceNotFoundException("Person not found");
        }
    }

    @Override
    public Person sayMyName(String name) {
        return Person.builder().firstName(name).build();
    }

}
