package org.goafabric.fhir.logic;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PatientLogic {
    @Autowired
    PatientAdapter patientAdapter;

    public Patient getPatient(final IdType idType) {
        return patientAdapter.getPatient(idType);
    }

}
