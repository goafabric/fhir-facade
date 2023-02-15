package org.goafabric.fhir.controller;

import org.goafabric.fhir.controller.dto.metadata.Implementation;
import org.goafabric.fhir.controller.dto.metadata.MetaData;
import org.goafabric.fhir.controller.dto.metadata.Software;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping(value = "fhir/metadata", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class MetaDataController {

    @GetMapping
    public MetaData getMetadata() {
        return MetaData.builder()
                .resourceType("CapabilityStatement")
                .id("0")
                .name("fhir-facade")
                .status("active")
                .date(new Date().toString())
                .publisher("Not Provided")
                .kind("instance")
                .fhirVersion("4.0.1")
                .software(Software.builder().name("fhir-facade").version("1.0.0").build())
                .implementation(Implementation.builder().description("fhir-facade").url("/fhir"). build())
                .format(Arrays.asList(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/fhir+json"))
                .build();
    }
}
