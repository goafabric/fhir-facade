package org.goafabric.fhir.logic;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientLogic implements PatientAdapter {
    private final PatientAdapter patientAdapter;

    public PatientLogic(PatientAdapter patientAdapter) {
        this.patientAdapter = patientAdapter;
    }


    @Override
    public Patient getPatient(IdType idType) {
        return patientAdapter.getPatient(idType);
    }

    @Override
    public Patient findyFirstName(String firstName) {
        return patientAdapter.findyFirstName(firstName);
    }

    @Override
    public Patient findyByLastName(String lastName) {
        return patientAdapter.findyByLastName(lastName);
    }

    @Override
    public void sayMyName(String name) {
        patientAdapter.sayMyName(name);

    }
}
