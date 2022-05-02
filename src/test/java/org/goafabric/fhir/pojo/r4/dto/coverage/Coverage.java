
package org.goafabric.fhir.pojo.r4.dto.coverage;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceType",
    "id",
    "meta",
    "status",
    "type",
    "subscriberId",
    "beneficiary",
    "payor"
})
@Generated("jsonschema2pojo")
@Data
public class Coverage {

    @JsonProperty("resourceType")
    public String resourceType;
    @JsonProperty("id")
    public String id;
    @JsonProperty("meta")
    public Meta meta;
    @JsonProperty("status")
    public String status;
    @JsonProperty("type")
    public Type type;
    @JsonProperty("subscriberId")
    public String subscriberId;
    @JsonProperty("beneficiary")
    public Beneficiary beneficiary;
    @JsonProperty("payor")
    public List<Payor> payor = null;
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
