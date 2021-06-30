package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.goafabric.example.fhir.adapter.PersonServiceAdapter;
import org.goafabric.example.fhir.crossfunctional.DurationLog;
import org.goafabric.example.fhir.logic.mapper.PatientMapper;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        personServiceAdapter.sayMyName("Homer"); //just for showcasing
        
        return PatientMapper.map(
                personServiceAdapter.findByFirstName("Homer").get(0));
    }

    @Search
    public List<Patient> findPatient(StringParam given,
                                     StringParam name) {
        return PatientMapper.map(
                personServiceAdapter.findByFirstName("Homer"));
    }

}
