package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.StringParam;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PatientLogic {
    @Read
    public Patient getPatient(final IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new IllegalStateException("patient not found");
        }
        
        final Patient patient = new Patient();
        patient.setId(idType);
        patient.setName(
             Arrays.asList(new HumanName()
                     .setFamily("Simpson"))
        );
        return patient;
    }

    @Search
    public List<Patient> findPatient(StringParam name,
                                     StringParam given,
                                     DateParam birthday) {
        final Patient patient = new Patient();
        patient.setName(
                Arrays.asList(new HumanName()
                        .setFamily("Simpson"))
        );
        return Arrays.asList(patient);
    }

}
