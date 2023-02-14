package org.goafabric.fhir.logic;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.goafabric.fhir.controller.dto.Bundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@DurationLog
public class BundleLogic {
    @Autowired
    PatientLogic patientLogic;

    @Autowired
    PractitionerLogic practitionerLogic;

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
