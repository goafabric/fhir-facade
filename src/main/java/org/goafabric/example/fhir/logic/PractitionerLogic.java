package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.goafabric.example.fhir.adapter.Person;
import org.goafabric.example.fhir.adapter.PersonServiceAdapter;
import org.goafabric.example.fhir.crossfunctional.DurationLog;
import org.goafabric.example.fhir.logic.builder.PractionerBuilder;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

        final List<Person> persons = personServiceAdapter.findByFirstName("Monty");
        return PractionerBuilder.build(idType,
                persons.get(0).getFirstName(), persons.get(0).getLastName());
        //return PractionerBuilder.build(idType,"Monty", "Burns");
    }

    public List<Practitioner> findPractitioner(StringParam given,
                                               StringParam name) {
        final List<Person> persons = personServiceAdapter.findByFirstName("Monty");
        return Arrays.asList(PractionerBuilder.build(new IdType(persons.get(0).getId()),
                persons.get(0).getFirstName(), persons.get(0).getLastName()));
        //return Arrays.asList(PractionerBuilder.build(new IdType(),"Monty", "Burns"));
    }

}
