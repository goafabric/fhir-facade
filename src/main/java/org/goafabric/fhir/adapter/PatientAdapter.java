package org.goafabric.fhir.adapter;

import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;

public interface PatientAdapter {
    Patient getPatient(IdType idType);

    Patient findyFirstName(String firstName);

    Patient findyByLastName(String lastName);

    void sayMyName(String name);
}
