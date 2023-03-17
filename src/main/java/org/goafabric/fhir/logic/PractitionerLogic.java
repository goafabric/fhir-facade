package org.goafabric.fhir.logic;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PractitionerLogic implements PractitionerAdapter {
    private final PractitionerAdapter practitionerAdapter;

    public PractitionerLogic(PractitionerAdapter practitionerAdapter) {
        this.practitionerAdapter = practitionerAdapter;
    }

    @Override
    public Practitioner getPractitioner(IdType idType) {
        return practitionerAdapter.getPractitioner(idType);
    }
}
