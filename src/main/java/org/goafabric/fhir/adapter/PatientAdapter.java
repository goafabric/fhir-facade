package org.goafabric.fhir.adapter;

import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.controller.dto.Patient;

public interface PatientAdapter {
    Patient getPatient(String id);

    Bundle findyFirstName(String firstName);

    Bundle findyByLastName(String lastName);

    void sayMyName(String homer);
}
