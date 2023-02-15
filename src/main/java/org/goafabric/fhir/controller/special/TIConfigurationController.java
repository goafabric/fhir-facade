package org.goafabric.fhir.controller.special;


import org.goafabric.fhir.controller.dto.Organization;
import org.goafabric.fhir.controller.dto.custom.TIConfigurationPojo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller for a proprietary non standard FHIR Resource
@Component
@RestController
@RequestMapping(value = "fhir/TIConfiguration", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/fhir+json"})
public class TIConfigurationController {

    @GetMapping("/{id}")
    public TIConfigurationPojo getTIConfiguration(@PathVariable String id) {
        return TIConfigurationPojo.builder()
                .clientSystemId("Secret Client")
                .mandantId("42")
                .workplaceId("Special Workplace")
                .organization(Organization.builder().name("Compuglobal Hyper Mega Net").build())
                .build();
    }

}
