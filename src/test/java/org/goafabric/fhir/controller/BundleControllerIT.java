package org.goafabric.fhir.controller;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.goafabric.fhir.adapter.remote.client.Person;
import org.goafabric.fhir.adapter.remote.mapper.PatientMapper;
import org.goafabric.fhir.adapter.remote.mapper.PractionerMapper;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BundleControllerIT {
    @LocalServerPort
    private String port;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private PractionerMapper practionerMapper;

    @Test
    void getBundle() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Bundle Bundle =
                client.read()
                        .resource(Bundle.class)
                        .withId("1").execute();

        assertThat(Bundle).isNotNull();
    }

    @Test
    void createPatientBundle() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Patient patient = patientMapper.map(
                new Person("1", "Homer", "Simpson"));

        final Practitioner practioner = practionerMapper.map(
                new Person("1", "Homer", "Simpson"));

        final Bundle bundle = new Bundle();
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(patient));
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(practioner));

        client.create()
                .resource(bundle)
                .execute();
    }
}