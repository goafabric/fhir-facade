package org.goafabric.example.fhir.adapter;

import java.util.List;

public interface PersonServiceAdapter {

    Person getById(String id);

    List<Person> findByFirstName(String firstName);

    Boolean isAlive();
}
