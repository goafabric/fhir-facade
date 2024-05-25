package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.adapter.remote.client.PersonServiceClient;
import org.goafabric.fhir.adapter.remote.mapper.PatientMapper;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class PatientRemoteAdapter implements PatientAdapter {

    private final PatientMapper patientMapper;
    private final PersonServiceClient personServiceClient;

    public PatientRemoteAdapter(PatientMapper patientMapper, PersonServiceClient personServiceClient) {
        this.patientMapper = patientMapper;
        this.personServiceClient = personServiceClient;
    }

    public Patient getPatient(IdType idType) {
        return patientMapper.map(
            personServiceClient.findByFirstName("Homer").get(0)
        );
    }

    @Override
    public Patient findyFirstName(String firstName) {
        return patientMapper.map(
                personServiceClient.findByFirstName(firstName).get(0)
        );
    }

    @Override
    public Patient findyByLastName(String lastName) {
        return patientMapper.map(
                personServiceClient.findByLastName(lastName).get(0)
        );
    }


    @Override
    public void sayMyName(String name) {
        personServiceClient.sayMyName(name);
    }

}
