package org.goafabric.example.fhir.logic.builder;

import org.goafabric.example.fhir.adapter.Person;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import java.util.Arrays;

public class PatientMapper {
    public static Patient map(Person person) {
        Patient patient = new Patient();
        patient.setId(person.getId());
        patient.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName())
        ));
        return patient;
    }
}
