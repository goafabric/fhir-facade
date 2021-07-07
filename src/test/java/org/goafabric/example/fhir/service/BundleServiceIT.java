package org.goafabric.example.fhir.service;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.goafabric.example.fhir.adapter.Person;
import org.goafabric.example.fhir.logic.mapper.PatientMapper;
import org.goafabric.example.fhir.logic.mapper.PractionerMapper;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BundleServiceIT {
    @LocalServerPort
    private String port;

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

        final Patient patient = PatientMapper.map(
                Person.builder().id("1")
                        .firstName("Homer").lastName("Simpson").build());

        final Practitioner practioner = PractionerMapper.map(
                Person.builder().id("1")
                        .firstName("Homer").lastName("Simpson").build());

        final Bundle bundle = new Bundle();
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(patient));
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(practioner));

        client.create()
                .resource(bundle)
                .execute();
    }

    @Test
    void createMyPatientBundle() {
        final IGenericClient client = ClientFactory.createClient(port);

        final MyPatient myPatient = new MyPatient();
        myPatient.setId("4711");
        myPatient.setActive(new BooleanType(true));

        final Bundle bundle = new Bundle();
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(myPatient));

        client.create()
                .resource(bundle)
                .execute();
    }
}