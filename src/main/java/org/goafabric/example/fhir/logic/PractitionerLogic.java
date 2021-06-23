package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.param.StringParam;
import org.goafabric.example.fhir.logic.builder.PractionerBuilder;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PractitionerLogic {

    public Practitioner getPractitioner(final IdType idType) {
        return PractionerBuilder
                .build(idType,"Bruce", "Banner");
    }

    public List<Practitioner> findPractitioner(StringParam searchParamName) {
        return Arrays.asList(PractionerBuilder
                .build(new IdType(),"Bruce", "Banner"));
    }

}
