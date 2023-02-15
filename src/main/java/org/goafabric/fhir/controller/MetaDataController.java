package org.goafabric.fhir.controller;

import org.goafabric.fhir.controller.dto.metadata.MetaData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "fhir/metadata", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class MetaDataController {

    @GetMapping
    public MetaData getMetadata() {
        return MetaData.builder()
                .date(new Date().toString())
                .fhirVersion("CapabilityStatement")
                .build();
    }
}
