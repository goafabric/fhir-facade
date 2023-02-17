package org.goafabric.fhir.controller;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


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

        assertThat(patient.getName()).hasSize(1);
        assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        assertThat(patient.getName().get(0).getGiven().get(0).toString()).isEqualTo("Homer");

        assertThat(patient.getAddress()).hasSize(1);
        var address = patient.getAddress().get(0);
        assertThat(address.getCity()).isEqualTo("Springfield");
        assertThat(address.getPostalCode()).isEqualTo("78313");
        assertThat(address.getCountry()).isEqualTo("US");

        assertThat(address.getUse().toCode()).isEqualTo("home");

        assertThat(address.getLine()).hasSize(1);
        assertThat(address.getLine().get(0).toString()).isEqualTo("Evergreen Terrace 742");

        assertThat(patient.getTelecom()).hasSize(1);
        var contactPoint = patient.getTelecom().get(0);
        assertThat(contactPoint.getValue()).isEqualTo("0245-33553");
        assertThat(contactPoint.getUse().toCode()).isEqualTo("home");
        assertThat(contactPoint.getSystem().toCode()).isEqualTo("phone");
    }

    @Test
    void findPatient() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Bundle bundle =
                client.search()
                        .forResource(Patient.class)
                        .where(Patient.FAMILY.matches().value("Simpson"))
                        .returnBundle(Bundle.class)
                        .execute();

        assertThat(bundle).isNotNull();
        final Patient patient = (Patient) bundle.getEntry().get(0).getResource();

        assertThat(patient.getName()).hasSize(1);
        assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        assertThat(patient.getName().get(0).getGiven().get(0).toString()).isEqualTo("Homer");

        assertThat(patient.getAddress()).hasSize(1);
        var address = patient.getAddress().get(0);
        assertThat(address.getCity()).isEqualTo("Springfield");
        assertThat(address.getPostalCode()).isEqualTo("78313");
        assertThat(address.getCountry()).isEqualTo("US");

        assertThat(address.getUse().toCode()).isEqualTo("home");

        assertThat(address.getLine()).hasSize(1);
        assertThat(address.getLine().get(0).toString()).isEqualTo("Evergreen Terrace 742");

        assertThat(patient.getTelecom()).hasSize(1);
        var contactPoint = patient.getTelecom().get(0);
        assertThat(contactPoint.getValue()).isEqualTo("0245-33553");
        assertThat(contactPoint.getUse().toCode()).isEqualTo("home");
        assertThat(contactPoint.getSystem().toCode()).isEqualTo("phone");
    }

}