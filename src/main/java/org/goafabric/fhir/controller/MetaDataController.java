package org.goafabric.fhir.controller;

import org.goafabric.fhir.controller.dto.Meta;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fhir/metadata", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class MetaDataController {

    @GetMapping
    public Meta getMetadata() {
        return new Meta();
    }
}
