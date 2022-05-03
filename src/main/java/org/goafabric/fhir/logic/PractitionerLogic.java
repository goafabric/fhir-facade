package org.goafabric.fhir.logic;

import lombok.experimental.Delegate;
import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PractitionerLogic {
    @Autowired
    @Delegate
    PractitionerAdapter practitionerAdapter;
}
