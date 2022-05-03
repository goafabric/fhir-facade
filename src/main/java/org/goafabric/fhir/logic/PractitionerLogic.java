package org.goafabric.fhir.logic;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
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
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("practioner not found");
        }

        return practitionerAdapter.getPractitioner(idType.getId());
    }

}
