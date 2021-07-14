package org.goafabric.fhir.logic;

import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.goafabric.fhir.adapter.PersonServiceAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.goafabric.fhir.logic.mapper.PractionerMapper;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@DurationLog
public class PractitionerLogic {
    final PersonServiceAdapter personServiceAdapter;

    public Practitioner getPractitioner(final IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("practioner not found");
        }

        return PractionerMapper.map(
                personServiceAdapter.findByFirstName("Monty").get(0));
    }

    public List<Practitioner> findPractitioner(StringParam given,
                                               StringParam name) {
        return PractionerMapper.map(
                personServiceAdapter.findByFirstName("Monty"));
    }

}
