package org.goafabric.fhir.controller;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.goafabric.fhir.controller.resource.TIConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TIConfigurationServiceIT {
    @LocalServerPort
    private String port;

    @Test
    void getTIConfiguration() {
        final IGenericClient client = ClientFactory.createClient(port);

        final TIConfiguration tiConfiguration =
                client.read()
                        .resource(TIConfiguration.class)
                        .withId("1").execute();

        assertThat(tiConfiguration).isNotNull();
        assertThat(tiConfiguration.getClientSystemId().getValue()).isEqualTo("Secret Client");
        assertThat(tiConfiguration.getMandantId().getValue()).isEqualTo("42");
        assertThat(tiConfiguration.getWorkplaceId().getValue()).isEqualTo("Special Workplace");
        assertThat(tiConfiguration.getOrganization().getName()).isEqualTo("Compuglobal Hyper Mega Net");
    }

}