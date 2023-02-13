package org.goafabric.fhir.adapter;

import org.goafabric.fhir.pojo.r4.Bundle;
import org.goafabric.fhir.pojo.r4.Patient;

public interface PatientAdapter {
    Patient getPatient(String id);

    Bundle findyFirstName(String firstName);

    Bundle findyByLastName(String lastName);

    void sayMyName(String homer);
}
