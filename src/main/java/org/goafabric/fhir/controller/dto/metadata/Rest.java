
package org.goafabric.fhir.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Rest {

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("resource")
    private List<Resource> resource;

}
