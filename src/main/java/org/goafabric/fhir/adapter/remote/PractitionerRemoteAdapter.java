package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.adapter.remote.client.PersonServiceClient;
import org.goafabric.fhir.adapter.remote.mapper.PractionerMapper;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("remote")
@Component
public class PractitionerRemoteAdapter implements PractitionerAdapter {
    @Autowired
    PersonServiceClient personServiceClient;

    @Override
    public Practitioner getPractitioner(String id) {
        return PractionerMapper.map(
            personServiceClient.findByFirstName("Monty").get(0)
        );
    }

    @Override
    public List<Practitioner> findPractitioner(String firstName) {
        return PractionerMapper.map(
                personServiceClient.findByFirstName("Monty")
        );
    }
}
