package org.goafabric.fhir.adapter;

import org.hl7.fhir.r4.model.Patient;

import java.util.List;

public interface PatientAdapter {
    Patient getPatient(String id);
    List<Patient> findPatient(String firstName);
}
