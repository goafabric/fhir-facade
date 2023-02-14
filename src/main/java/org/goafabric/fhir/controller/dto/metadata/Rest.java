
package org.goafabric.fhir.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Rest {

    @JsonProperty("mode")
    public String mode;
    @JsonProperty("resource")
    public List<Resource> resource;

}
