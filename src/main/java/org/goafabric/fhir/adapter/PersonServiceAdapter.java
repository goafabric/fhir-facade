package org.goafabric.fhir.adapter;

import java.util.List;

public interface PersonServiceAdapter {

    Person getById(String id);

    List<Person> findByFirstName(String firstName);

    Person sayMyName(String name);
}
