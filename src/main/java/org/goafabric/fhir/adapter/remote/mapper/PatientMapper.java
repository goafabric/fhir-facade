package org.goafabric.fhir.adapter.remote.mapper;

import org.goafabric.fhir.adapter.remote.client.Person;
import org.goafabric.fhir.controller.dto.HumanName;
import org.goafabric.fhir.controller.dto.Patient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class PatientMapper {
    public List<Patient> map(List<Person> person) {
        return asList(map(person.get(0)));
    }

    public Patient map(Person person) {
        Patient patient = Patient.builder()
                .name(createName(person)).build();

        patient.setId(person.getId());
        return patient;
    }

    private List<HumanName> createName(Person person) {
        return Arrays.asList(HumanName.builder()
                .given(Arrays.asList(person.getFirstName()))
                .family(person.getLastName())
                .build());
    }
}
