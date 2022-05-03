package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PractitionerAdapter;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public Practitioner getPractitioner(String id) {
        final Practitioner practitioner = new Practitioner()
                .setName(asList(new HumanName()
                        .setGiven(asList(new StringType("Monty")))
                        .setFamily("Burns")
                ))
                .setAddress(asList(MockUtil.createAddress()))
                .setTelecom(asList(MockUtil.createTelecom()));

        practitioner.setId(id);
        return practitioner;
    }

    @Override
    public List<Practitioner> findPractitioner(String firstName) {
        final Practitioner practitioner = new Practitioner()
                .setName(asList(new HumanName()
                        .setGiven(asList(new StringType("Monty")))
                        .setFamily("Burns")
                ))
                .setAddress(asList(MockUtil.createAddress()))
                .setTelecom(asList(MockUtil.createTelecom()));

        practitioner.setId("1");
        return asList(practitioner);
    }
}
