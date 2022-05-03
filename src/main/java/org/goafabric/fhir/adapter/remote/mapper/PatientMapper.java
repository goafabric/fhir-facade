package org.goafabric.fhir.adapter.remote.mapper;

import org.goafabric.fhir.adapter.remote.client.Person;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import java.util.List;

import static java.util.Arrays.asList;

public class PatientMapper {
    public static List<Patient> map(List<Person> person) {
        return asList(map(person.get(0)));
    }

    public static Patient map(Person person) {
        Patient patient = new Patient()
            .setName(asList(new HumanName()
                        .setGiven(asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName())
                    ));

        patient.setId(person.getId());
        return patient;
    }

}
