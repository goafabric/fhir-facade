package org.goafabric.fhir.adapter.remote;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.goafabric.fhir.adapter.remote.client.PersonServiceClient;
import org.goafabric.fhir.adapter.remote.mapper.PractionerMapper;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("remote")
@Component
public class PractitionerRemoteAdapter implements PractitionerAdapter {
    private final PractionerMapper practionerMapper;

    private final PersonServiceClient personServiceClient;

    public PractitionerRemoteAdapter(PractionerMapper practionerMapper, PersonServiceClient personServiceClient) {
        this.practionerMapper = practionerMapper;
        this.personServiceClient = personServiceClient;
    }

    @Override
    public Practitioner getPractitioner(IdType idType) {
        return practionerMapper.map(
            personServiceClient.findByFirstName("Monty").get(0)
        );
    }
    
}
