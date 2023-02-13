package org.goafabric.fhir.controller;


import org.goafabric.fhir.pojo.r4.custom.TIConfigurationPojo;
import org.springframework.stereotype.Component;

//Controller for a proprietary non standard FHIR Resource
@Component
public class TIConfigurationController {

    public TIConfigurationPojo getTIConfiguration(String id) {
        return TIConfigurationPojo.builder()
                .clientSystemId("Secret Client")
                .mandantId("42")
                .workplaceId("Special Workplace")
                //.organization(Organization. setName("Compuglobal Hyper Mega Net"))
                .build();
    }

}
