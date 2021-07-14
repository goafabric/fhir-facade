package org.goafabric.fhir.adapter.mock;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.goafabric.fhir.adapter.Person;
import org.goafabric.fhir.adapter.PersonServiceAdapter;
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
            return Arrays.asList(Person.builder().id("1")
                    .firstName("Homer").lastName("Simpson").build());
        } else if ("Monty".equals(firstName)) {
            return Arrays.asList(Person.builder().id("1")
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
