package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.adapter.remote.client.PersonServiceClient;
import org.goafabric.fhir.adapter.remote.mapper.PatientMapper;
import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.controller.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class PatientRemoteAdapter implements PatientAdapter {
    @Autowired
    PersonServiceClient personServiceClient;

    @Autowired
    PatientMapper patientMapper;

    public Patient getPatient(String idType) {
        return patientMapper.map(
            personServiceClient.findByFirstName("Homer").get(0)
        );
    }

    @Override
    public Bundle findyFirstName(String firstName) {
        Bundle bundle = new Bundle();
        var patient = patientMapper.map(
                personServiceClient.findByFirstName(firstName).get(0)
        );
        bundle.addEntry(createBundleEntry(patient, patient.getId()));
        return bundle;
    }

    @Override
    public Bundle findyByLastName(String lastName) {
        Bundle bundle = new Bundle();
        var patient = patientMapper.map(
                personServiceClient.findByLastName(lastName).get(0)
        );
        bundle.addEntry(createBundleEntry(patient, patient.getId()));
        return bundle;
    }


    @Override
    public void sayMyName(String name) {
        personServiceClient.sayMyName(name);
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }
}
