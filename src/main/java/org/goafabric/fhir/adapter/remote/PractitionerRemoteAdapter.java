package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.adapter.remote.client.PersonServiceClient;
import org.goafabric.fhir.adapter.remote.mapper.PractionerMapper;
import org.goafabric.fhir.controller.dto.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class PractitionerRemoteAdapter implements PractitionerAdapter {
    @Autowired
    PersonServiceClient personServiceClient;

    @Autowired
    PractionerMapper practionerMapper;

    @Override
    public Practitioner getPractitioner(String idType) {
        return practionerMapper.map(
            personServiceClient.findByFirstName("Monty").get(0)
        );
    }
    
}
