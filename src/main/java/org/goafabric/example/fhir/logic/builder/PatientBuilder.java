package org.goafabric.example.fhir.logic.builder;

import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import java.util.Arrays;

public class PatientBuilder {
    public static Patient build(IdType idType, String givenName, String familyName) {
        Patient patient = new Patient();
        patient.setId(idType);
        patient.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType(givenName)))
                        .setFamily(familyName))
        );
        return patient;
    }
}
