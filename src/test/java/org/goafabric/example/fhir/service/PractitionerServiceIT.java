package org.goafabric.example.fhir.service;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Practitioner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PractitionerServiceIT {
    @LocalServerPort
    private String port;

    @Test
    void getPractitioner() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Practitioner practitioner =
                client.read()
                        .resource(Practitioner.class)
                        .withId("1").execute();

        assertThat(practitioner).isNotNull();
    }
}