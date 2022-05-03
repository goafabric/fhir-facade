package org.goafabric.fhir.logic;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PractitionerLogic {
    @Autowired
    PractitionerAdapter practitionerAdapter;

    public Practitioner getPractitioner(final IdType idType) {
        return practitionerAdapter.getPractitioner(idType);
    }

}
