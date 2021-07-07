package org.goafabric.example.fhir.service;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
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
    void createBundle() {
        final IGenericClient client = ClientFactory.createClient(port);

        client.create()
                .resource(new Bundle())
                .execute();
    }
}