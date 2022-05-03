package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.adapter.remote.client.PersonServiceClient;
import org.goafabric.fhir.adapter.remote.mapper.PatientMapper;
import org.hl7.fhir.r4.model.Patient;
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

    public Patient getPatient(String id) {
        return patientMapper.map(
            personServiceClient.findByFirstName("Homer").get(0)
        );
    }

}
