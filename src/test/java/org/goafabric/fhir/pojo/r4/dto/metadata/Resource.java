
package org.goafabric.fhir.pojo.r4.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Resource {

    @JsonProperty("type")
    private String type;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("interaction")
    private List<Interaction> interaction;
    @JsonProperty("searchInclude")
    private List<String> searchInclude;
    @JsonProperty("searchParam")
    private List<SearchParam> searchParam;

}
