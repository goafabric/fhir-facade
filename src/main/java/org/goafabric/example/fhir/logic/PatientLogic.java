package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.StringParam;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PatientLogic {
    @Read
    public Patient getPatient(final IdType idType) {
        final Patient patient = new Patient();
        patient.setId(idType);
        return patient;
    }

    @Search
    public List<Patient> findPatient(StringParam name,
                                     StringParam given,
                                     DateParam birthday) {
        return Arrays.asList(new Patient());
    }

}
