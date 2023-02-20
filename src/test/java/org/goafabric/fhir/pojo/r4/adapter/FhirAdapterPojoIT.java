package org.goafabric.fhir.pojo.r4.adapter;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.controller.dto.Organization;
import org.goafabric.fhir.controller.dto.Patient;
import org.goafabric.fhir.controller.dto.Practitioner;
import org.goafabric.fhir.controller.dto.custom.TIConfigurationPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class FhirAdapterPojoIT {
    @Autowired
    private FhirAdapter fhirAdapter;

    @Test
    public void getPatient() {
        final Patient patient = fhirAdapter.getPatient("1");
        log.info(patient.toString());
        assertThat(patient).isNotNull();

        Assertions.assertThat(patient.getName()).hasSize(1);
        Assertions.assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        Assertions.assertThat(patient.getName().get(0).getGiven().get(0).toString()).isEqualTo("Homer");

        Assertions.assertThat(patient.getAddress()).hasSize(1);
        var address = patient.getAddress().get(0);
        Assertions.assertThat(address.getCity()).isEqualTo("Springfield");
        Assertions.assertThat(address.getPostalCode()).isEqualTo("78313");
        Assertions.assertThat(address.getCountry()).isEqualTo("US");

        Assertions.assertThat(address.getUse().toString()).isEqualTo("home");

        Assertions.assertThat(address.getLine()).hasSize(1);
        Assertions.assertThat(address.getLine().get(0).toString()).isEqualTo("Evergreen Terrace 742");

        Assertions.assertThat(patient.getTelecom()).hasSize(1);
        var contactPoint = patient.getTelecom().get(0);
        Assertions.assertThat(contactPoint.getValue()).isEqualTo("0245-33553");
        Assertions.assertThat(contactPoint.getUse()).isEqualTo("home");
        Assertions.assertThat(contactPoint.getSystem()).isEqualTo("phone");
    }

    @Test
    public void findPatient() {
        var bundle = fhirAdapter.findPatient("Simpson");
        //log.info(bundle.toString());
        assertThat(bundle).isNotNull();

        assertThat(bundle.getEntry()).hasSize(1);
        Patient patient = bundle.getEntry().get(0).getResource();

        assertThat(patient).isNotNull();

        Assertions.assertThat(patient.getName()).hasSize(1);
        Assertions.assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        Assertions.assertThat(patient.getName().get(0).getGiven().get(0).toString()).isEqualTo("Homer");

        Assertions.assertThat(patient.getAddress()).hasSize(1);
        var address = patient.getAddress().get(0);
        Assertions.assertThat(address.getCity()).isEqualTo("Springfield");
        Assertions.assertThat(address.getPostalCode()).isEqualTo("78313");
        Assertions.assertThat(address.getCountry()).isEqualTo("US");
    }

    @Test
    public void getPractitioner() {
        final Practitioner practitioner = fhirAdapter.getPractitioner("1");
        log.info(practitioner.toString());
        assertThat(practitioner).isNotNull();
        assertThat(practitioner.getName().get(0).getFamily()).isEqualTo("Burns");
        assertThat(practitioner.getName().get(0).getGiven().get(0)).isEqualTo("Monty");
    }

    @Test
    public void getOrganization() {
        final Organization organization = fhirAdapter.getOrganization("1");
        log.info(organization.toString());
        assertThat(organization).isNotNull();
    }

    @Test
    public void getTIConfiguration() {
        final TIConfigurationPojo tiConfiguration = fhirAdapter.getTIConfiguration("1");
        assertThat(tiConfiguration).isNotNull();
        assertThat(tiConfiguration.getClientSystemId()).isEqualTo("Secret Client");
        assertThat(tiConfiguration.getMandantId()).isEqualTo("42");
        assertThat(tiConfiguration.getWorkplaceId()).isEqualTo("Special Workplace");
        assertThat(tiConfiguration.getOrganization().getName()).isEqualTo("Compuglobal Hyper Mega Net");
    }

    @Test
    public void getBundle() {
        final Bundle<Object> bundle = fhirAdapter.getBundle("1");
        log.info(bundle.toString());
        assertThat(bundle).isNotNull();

        assertThat(bundle.getEntry()).hasSize(2);
        Object resource =  bundle.getEntry().get(0).getResource();

        assertThat(resource).isNotNull();
        int x = 5;

    }

}
