
package org.goafabric.fhir.pojo.r4.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SearchParam {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("documentation")
    private String documentation;

}
