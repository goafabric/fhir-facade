package org.goafabric.fhir.logic;

import lombok.experimental.Delegate;
import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PatientLogic {
    @Delegate
    private final PatientAdapter patientAdapter;

    public PatientLogic(PatientAdapter patientAdapter) {
        this.patientAdapter = patientAdapter;
    }
}
