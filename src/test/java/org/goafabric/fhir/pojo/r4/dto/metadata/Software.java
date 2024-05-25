
package org.goafabric.fhir.pojo.r4.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Software {

    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private String version;

}
