
package org.goafabric.fhir.pojo.r4.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Resource {

    @JsonProperty("type")
    public String type;
    @JsonProperty("profile")
    public String profile;
    @JsonProperty("interaction")
    public List<Interaction> interaction;
    @JsonProperty("searchInclude")
    public List<String> searchInclude;
    @JsonProperty("searchParam")
    public List<SearchParam> searchParam;

}
