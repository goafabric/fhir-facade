package org.goafabric.fhir.pojo.r4.service;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.pojo.r4.adapter.FhirAdapter;
import org.goafabric.fhir.pojo.r4.dto.Organization;
import org.goafabric.fhir.pojo.r4.dto.Patient;
import org.goafabric.fhir.pojo.r4.dto.Practitioner;
import org.goafabric.fhir.pojo.r4.dto.custom.TIConfigurationPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class FhirAdapterIT {
    @Autowired
    private FhirAdapter fhirAdapter;

    @Test
    public void getPatient() {
        final Patient patient = fhirAdapter.getPatient("1");
        log.info(patient.toString());
        assertThat(patient).isNotNull();
        assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        assertThat(patient.getName().get(0).getGiven().get(0)).isEqualTo("Homer");
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
    }
    
}
