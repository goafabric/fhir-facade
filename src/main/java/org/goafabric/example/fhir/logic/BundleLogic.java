package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
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

        final Bundle.BundleEntryComponent patientEntry = new Bundle.BundleEntryComponent();
        patientEntry.setResource(patientLogic.getPatient(idType));
        patientEntry.setFullUrl(Patient.class.getSimpleName() + "/" + idType.getIdPart());
        bundle.addEntry(patientEntry);

        final Bundle.BundleEntryComponent practitionerEntry = new Bundle.BundleEntryComponent();
        practitionerEntry.setResource(practitionerLogic.getPractitioner(idType));
        practitionerEntry.setFullUrl(Practitioner.class.getSimpleName() + "/" + idType.getIdPart());
        bundle.addEntry(practitionerEntry);

        return bundle;
    }

}
