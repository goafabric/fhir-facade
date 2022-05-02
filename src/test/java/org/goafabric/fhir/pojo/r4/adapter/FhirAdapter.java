package org.goafabric.fhir.pojo.r4.adapter;

import org.goafabric.fhir.pojo.r4.dto.Patient;
import org.goafabric.fhir.pojo.r4.dto.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Practitioner getPractitioner(String id) {
        return restTemplate.getForObject(baseUri + "Practitioner" + "/" + id, Practitioner.class);
    }

    /*
    public Organization getOrganization(String id) {
        return restTemplate.getForObject(baseUri + "Organization" + "/" + id, Organization.class);
    }
    
     */

}
