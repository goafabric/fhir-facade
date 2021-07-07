package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.IdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BundleLogic {
    @Autowired
    private PatientLogic patientLogic;

    @Autowired
    private PractitionerLogic practitionerLogic;

    public Bundle getBundle(IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("bundle not found");
        }

        final Bundle bundle = new Bundle();
        bundle.addEntry(new Bundle.BundleEntryComponent()
                .setResource(patientLogic.getPatient(idType)));

        bundle.addEntry(new Bundle.BundleEntryComponent()
                .setResource(practitionerLogic.getPractitioner(idType)));

        return bundle;
    }
}
