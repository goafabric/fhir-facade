package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PatientMockAdapter implements PatientAdapter {
    public Patient getPatient(String id) {
        Patient patient = new Patient()
                .setName(asList(new HumanName()
                        .setGiven(asList(new StringType("Homer")))
                        .setFamily("Simpson")
                ))
                .setAddress(asList(MockUtil.createAddress()))
                .setTelecom(asList(MockUtil.createTelecom()));

        patient.setId(id);
        return patient;
    }

    @Override
    public List<Patient> findPatient(String firstName) {
        Patient patient = new Patient()
                .setName(asList(new HumanName()
                        .setGiven(asList(new StringType("Homer")))
                        .setFamily("Simpson")
                ))
                .setAddress(asList(MockUtil.createAddress()))
                .setTelecom(asList(MockUtil.createTelecom()));

        patient.setId("1");
        return asList(patient);
    }
}
