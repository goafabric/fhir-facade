
package org.goafabric.fhir.pojo.r4.dto.observation;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "origin",
    "period",
    "factor",
    "lowerLimit",
    "upperLimit",
    "dimensions",
    "data"
})
@Generated("jsonschema2pojo")
public class ValueSampledData {

    @JsonProperty("origin")
    public Origin origin;
    @JsonProperty("period")
    public Integer period;
    @JsonProperty("factor")
    public Double factor;
    @JsonProperty("lowerLimit")
    public Integer lowerLimit;
    @JsonProperty("upperLimit")
    public Integer upperLimit;
    @JsonProperty("dimensions")
    public Integer dimensions;
    @JsonProperty("data")
    public String data;
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
