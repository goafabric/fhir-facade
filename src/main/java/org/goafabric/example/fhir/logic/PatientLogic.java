package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.goafabric.example.fhir.adapter.Person;
import org.goafabric.example.fhir.adapter.PersonServiceAdapter;
import org.goafabric.example.fhir.crossfunctional.DurationLog;
import org.goafabric.example.fhir.logic.builder.PatientBuilder;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@DurationLog
public class PatientLogic {
    @Autowired
    private PersonServiceAdapter personServiceAdapter;

    @Read
    public Patient getPatient(final IdType idType) {
        if (!"1".equals(idType.getIdPart())) {
            throw new ResourceNotFoundException("patient not found");
        }

        final List<Person> persons = personServiceAdapter.findByFirstName("Homer");
        return PatientBuilder.build(idType,
                persons.get(0).getFirstName(), persons.get(0).getLastName());
        //return PatientBuilder.build(idType,"Homer", "Simpson");
    }

    @Search
    public List<Patient> findPatient(StringParam name,
                                     StringParam given,
                                     DateParam birthday) {
        return Arrays.asList(PatientBuilder.build(new IdType(),"Homer", "Simpson"));
    }

}
