package org.goafabric.fhir.pojo.r4.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.goafabric.fhir.pojo.r4.dto.Bundle;
import org.goafabric.fhir.pojo.r4.dto.Organization;
import org.goafabric.fhir.pojo.r4.dto.Patient;
import org.goafabric.fhir.pojo.r4.dto.Practitioner;
import org.goafabric.fhir.pojo.r4.dto.custom.TIConfigurationPojo;
import org.goafabric.fhir.pojo.r4.dto.extension.Extension;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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

        List<Extension> familyExtension = patient.getName().get(0).getFamilyExtension().getExtension();

        assertThat(familyExtension).hasSize(1);
        assertThat(familyExtension.get(0).getValueString()).isEqualTo("The 3rd");
        assertThat(familyExtension.get(0).getUrl()).isEqualTo("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2");
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
    public void getBundle() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();

        final Bundle<Object> bundle = fhirAdapter.getBundle("1");
        log.info(bundle.toString());
        assertThat(bundle).isNotNull();

        assertThat(bundle.getEntry()).hasSize(2);

        for (Bundle.BundleEntryComponent<Object> entry : bundle.getEntry()) {
            final String resourceType = ((LinkedHashMap<String, String>) entry.getResource()).get("resourceType");
            if (Patient.class.getSimpleName().equals(resourceType)) {
                Patient patient = mapper.convertValue(entry.getResource(), Patient.class);
                log.info(patient.toString());
            }
            if (Practitioner.class.getSimpleName().equals(resourceType)) {
                Practitioner practitioner = mapper.convertValue(entry.getResource(), Practitioner.class);
                log.info(practitioner.toString());
            }

        }

    }


}
