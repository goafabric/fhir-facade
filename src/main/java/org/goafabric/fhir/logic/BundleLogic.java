package org.goafabric.fhir.logic;

import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class BundleLogic {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PatientLogic patientLogic;

    private final PractitionerLogic practitionerLogic;

    public BundleLogic(PatientLogic patientLogic, PractitionerLogic practitionerLogic) {
        this.patientLogic = patientLogic;
        this.practitionerLogic = practitionerLogic;
    }

    public Bundle getBundle(String id) {

        final Bundle bundle = new Bundle();
        bundle.addEntry(createBundleEntry(
                patientLogic.getPatient(id), id));
        bundle.addEntry(createBundleEntry(
                practitionerLogic.getPractitioner(id), id));

        return bundle;
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }


    public void createBundle(Bundle bundle) {
        log.info("create bundle : {}", bundle.toString() );
    }
}
