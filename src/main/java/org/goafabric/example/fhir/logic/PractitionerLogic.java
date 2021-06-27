package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.goafabric.example.fhir.adapter.PersonServiceAdapter;
import org.goafabric.example.fhir.crossfunctional.DurationLog;
import org.goafabric.example.fhir.logic.builder.PractionerMapper;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DurationLog
public class PractitionerLogic {
    @Autowired
    private PersonServiceAdapter personServiceAdapter;

    public Practitioner getPractitioner(final IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("practioner not found");
        }

        return PractionerMapper.map(personServiceAdapter.findByFirstName("Monty").get(0));
        //return PractionerMapper.map(Person.builder().id("0").firstName("Monty").lastName("Burns").build());
    }

    public List<Practitioner> findPractitioner(StringParam given,
                                               StringParam name) {
        return PractionerMapper.map(personServiceAdapter.findByFirstName("Monty"));
        //return Arrays.asList(PractionerMapper.map(Person.builder().id("0").firstName("Monty").lastName("Burns").build());
    }

}
