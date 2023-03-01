package org.goafabric.fhir.logic;

import lombok.experimental.Delegate;
import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PractitionerLogic {
    @Delegate
    private final PractitionerAdapter practitionerAdapter;

    public PractitionerLogic(PractitionerAdapter practitionerAdapter) {
        this.practitionerAdapter = practitionerAdapter;
    }
}
