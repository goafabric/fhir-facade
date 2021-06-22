package org.goafabric.example.fhir.logic;

import ca.uhn.fhir.rest.param.StringParam;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PractitionerLogic {

    public Practitioner getPractitioner(final IdType idType) {
        Practitioner practitioner = new Practitioner();
        practitioner.setId(idType);
        practitioner.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType("Bruce")))
                        .setFamily("Banner"))
        );
        return practitioner;
    }

    public List<Practitioner> findPractitioner(StringParam searchParamName) {
        final Practitioner practitioner = new Practitioner();
        practitioner.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType("Bruce")))
                        .setFamily("Banner"))
        );
        return Arrays.asList(practitioner);
    }

}
