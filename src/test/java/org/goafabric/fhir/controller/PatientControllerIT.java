package org.goafabric.fhir.controller;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientControllerIT {
    @LocalServerPort
    private String port;

    @Test
    void getPatient() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Patient patient =
                client.read()
                        .resource(Patient.class)
                        .withId("1").execute();

        assertThat(patient).isNotNull();
        assertThat(patient.getName().get(0).getGiven().get(0).getValue()).isEqualTo("Homer");
        assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
    }

}