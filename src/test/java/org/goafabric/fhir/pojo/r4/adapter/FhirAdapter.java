package org.goafabric.fhir.pojo.r4.adapter;

import org.goafabric.fhir.controller.dto.*;
import org.goafabric.fhir.controller.dto.coverage.Beneficiary;
import org.goafabric.fhir.controller.dto.coverage.Coverage;
import org.goafabric.fhir.controller.dto.coverage.Payor;
import org.goafabric.fhir.controller.dto.coverage.Type;
import org.goafabric.fhir.controller.dto.custom.TIConfigurationPojo;
import org.goafabric.fhir.controller.dto.extension.Extension;
import org.goafabric.fhir.controller.dto.extension.ExtensionWrapper;
import org.goafabric.fhir.controller.dto.observation.Observation;
import org.goafabric.fhir.controller.dto.observation.Origin;
import org.goafabric.fhir.controller.dto.observation.Subject;
import org.goafabric.fhir.controller.dto.observation.ValueSampledData;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RegisterReflectionForBinding(
        {Patient.class, Practitioner.class, Organization.class, TIConfigurationPojo.class,
         Coverage.class, Beneficiary.class, Payor.class, Type.class,
         Observation.class, Origin.class, Subject.class, ValueSampledData.class,
         Address.class, Bundle.class, HumanName.class, Identifier.class, Meta.class, Telecom.class, Text.class,
         Extension.class, ExtensionWrapper.class})
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
