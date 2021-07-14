package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.goafabric.example.fhir.crossfunctional.DurationLog;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@DurationLog
public class BundleLogic {
    final PatientLogic patientLogic;

    final PractitionerLogic practitionerLogic;

    public Bundle getBundle(IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("bundle not found");
        }

        final Bundle bundle = new Bundle();
        bundle.addEntry(createBundleEntry(
                patientLogic.getPatient(idType)));
        bundle.addEntry(createBundleEntry(
                practitionerLogic.getPractitioner(idType)));

        return bundle;
    }

    private Bundle.BundleEntryComponent createBundleEntry(Resource resource) {
        final Bundle.BundleEntryComponent bundleEntry = new Bundle.BundleEntryComponent();
        bundleEntry.setResource(resource);
        bundleEntry.setFullUrl(resource.getClass().getSimpleName() + "/" + resource.getId());
        return bundleEntry;
    }

    public MethodOutcome createBundle(Bundle bundle) {
        log.info(FhirContext.forR4().newJsonParser().encodeResourceToString(bundle));
        return new MethodOutcome();
    }
}
