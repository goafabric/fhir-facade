
package org.goafabric.fhir.pojo.r4.dto.observation;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;
import org.goafabric.fhir.pojo.r4.dto.Text;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceType",
    "id",
    "meta",
    "text",
    "status",
    "subject",
    "effectiveDateTime",
    "valueSampledData"
})
@Generated("jsonschema2pojo")
@Data
public class Oberservation {

    @JsonProperty("resourceType")
    public String resourceType;
    @JsonProperty("id")
    public String id;
    @JsonProperty("meta")
    public Meta meta;
    @JsonProperty("text")
    public Text text;
    @JsonProperty("status")
    public String status;
    @JsonProperty("subject")
    public Subject subject;
    @JsonProperty("effectiveDateTime")
    public String effectiveDateTime;
    @JsonProperty("valueSampledData")
    public ValueSampledData valueSampledData;
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
