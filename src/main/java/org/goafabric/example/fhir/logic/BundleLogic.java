package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.IdType;

public class BundleLogic {
    public Bundle getBundle(IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("bundle not found");
        }

        Bundle bundle = new Bundle();
        //bundle.addEntry(new Bundle.BundleEntryComponent().)
        return null;
    }
}
