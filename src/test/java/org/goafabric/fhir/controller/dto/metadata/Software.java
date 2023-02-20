
package org.goafabric.fhir.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Software {

    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private String version;

}
