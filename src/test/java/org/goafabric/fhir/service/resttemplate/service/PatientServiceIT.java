package org.goafabric.fhir.service.resttemplate.service;

import org.goafabric.fhir.service.resttemplate.dto.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientServiceIT {
    @LocalServerPort
    private String port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void test() {
        Patient patient = restTemplate.getForObject("http://localhost:" + port + "/fhir/Patient/1", Patient.class);
        int x = 5;
    }

}
