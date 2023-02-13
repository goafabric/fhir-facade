package org.goafabric.fhir.controller;


import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BundleControllerIT {
    @LocalServerPort
    private String port;

    @Test
    void getBundle() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Bundle bundle =
                client.read()
                        .resource(Bundle.class)
                        .withId("1").execute();

        assertThat(bundle).isNotNull();
        assertThat(bundle.getEntry().size()).isEqualTo(2);
        //assertThat(bundle).isNotNull();
    }

    @Test
    void createPatientBundle() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Bundle bundle = new Bundle();
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(new Patient().setId("Homer Simpson")));
        bundle.addEntry(new Bundle.BundleEntryComponent().setResource(new Practitioner().setId("Monty Burns")));

        client.create()
                .resource(bundle)
                .execute();
    }

}