package org.goafabric.fhir.adapter;

public interface PatientAdapter {
    org.goafabric.fhir.pojo.r4.Patient getPatient(String id);

    org.goafabric.fhir.pojo.r4.Patient findyFirstName(String firstName);

    org.goafabric.fhir.pojo.r4.Patient findyByLastName(String lastName);

    void sayMyName(String homer);
}
