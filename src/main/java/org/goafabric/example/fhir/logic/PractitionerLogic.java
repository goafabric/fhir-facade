package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.param.StringParam;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PractitionerLogic {

    public Practitioner getPractitioner(final IdType idType) {
        Practitioner practitioner = new Practitioner();
        practitioner.setId(idType);
        return practitioner;
    }

    public List<Practitioner> findPractitioner(StringParam searchParamName) {
        return Arrays.asList(new Practitioner());
    }

}
