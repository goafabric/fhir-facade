
package org.goafabric.fhir.pojo.r4.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "system",
    "value",
    "use"
})
@Generated("jsonschema2pojo")
@Data
public class Telecom {

    @JsonProperty("system")
    public String system;
    @JsonProperty("value")
    public String value;
    @JsonProperty("use")
    public String use;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
