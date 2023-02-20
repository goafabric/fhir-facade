package org.goafabric.fhir.pojo.r4.adapter;

import org.goafabric.fhir.pojo.r4.dto.Bundle;
import org.goafabric.fhir.pojo.r4.dto.Organization;
import org.goafabric.fhir.pojo.r4.dto.Patient;
import org.goafabric.fhir.pojo.r4.dto.Practitioner;
import org.goafabric.fhir.pojo.r4.dto.coverage.Coverage;
import org.goafabric.fhir.pojo.r4.dto.custom.TIConfigurationPojo;
import org.goafabric.fhir.pojo.r4.dto.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FhirAdapter {
    @Autowired
    private RestTemplate restTemplate;

    private final String baseUri = "http://localhost:50700/fhir/";

    public Patient getPatient(String id) {
        return restTemplate.getForObject(baseUri + "Patient" + "/" + id, Patient.class);
    }

    public Bundle<Patient> findPatient(String familyName) {
        return restTemplate.exchange(baseUri + "Patient" + "?family=" + familyName, HttpMethod.GET, null, new ParameterizedTypeReference<Bundle<Patient>>(){}).getBody();
    }

    public Practitioner getPractitioner(String id) {
        return restTemplate.getForObject(baseUri + "Practitioner" + "/" + id, Practitioner.class);
    }

    public Organization getOrganization(String id) {
        return restTemplate.getForObject(baseUri + "Organization" + "/" + id, Organization.class);
    }

    public Coverage getCoverage(String id) {
        return restTemplate.getForObject(baseUri + "Coverage" + "/" + id, Coverage.class);
    }

    public Observation getObservation(String id) {
        return restTemplate.getForObject(baseUri + "Observation" + "/" + id, Observation.class);
    }

    public TIConfigurationPojo getTIConfiguration (String id) {
        return restTemplate.getForObject(baseUri + "TIConfiguration" + "/" + id, TIConfigurationPojo.class);
    }

}
