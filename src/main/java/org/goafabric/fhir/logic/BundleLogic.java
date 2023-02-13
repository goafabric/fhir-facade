package org.goafabric.fhir.logic;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.goafabric.fhir.pojo.r4.Bundle;
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
        final Bundle.BundleEntryComponent bundleEntry = new Bundle.BundleEntryComponent();
        bundleEntry.setResource(resource);
        bundleEntry.setFullUrl(resource.getClass().getSimpleName() + "/" + id);
        return bundleEntry;
    }


}
