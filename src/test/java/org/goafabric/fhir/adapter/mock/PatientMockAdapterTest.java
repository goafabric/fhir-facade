package org.goafabric.fhir.adapter.mock;

import org.assertj.core.api.Assertions;
import org.hl7.fhir.r4.model.IdType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PatientMockAdapterTest {
    PatientMockAdapter adapter = new PatientMockAdapter();

    @Test
    void getPatient() {
        var patient = adapter.getPatient(new IdType());
        assertThat(patient).isNotNull();
    }

    @Test
    void findyFirstName() {
        var patient = adapter.findyFirstName("Homer");
        Assertions.assertThat(patient.getName()).hasSize(1);
        Assertions.assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        Assertions.assertThat(patient.getName().get(0).getGiven().get(0).toString()).isEqualTo("Homer");
    }

    @Test
    void findyByLastName() {
        var patient = adapter.findyByLastName("Simpson");
        Assertions.assertThat(patient.getName()).hasSize(1);
        Assertions.assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        Assertions.assertThat(patient.getName().get(0).getGiven().get(0).toString()).isEqualTo("Homer");
    }

    @Test
    void sayMyName() {
    }

    @Test
    void createTelecom() {
    }
}