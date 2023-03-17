package org.goafabric.fhir.adapter.remote.mapper;

import org.goafabric.fhir.adapter.remote.client.Person;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class PatientMapper {
    public List<Patient> map(List<Person> person) {
        return asList(map(person.get(0)));
    }

    public Patient map(Person person) {
        Patient patient = new Patient()
                .addName(createName(person));

        patient.setId(person.id());
        return patient;
    }

    private HumanName createName(Person person) {
        return new HumanName()
                .addGiven(person.firstName())
                .setFamily(person.lastName());
    }
}
