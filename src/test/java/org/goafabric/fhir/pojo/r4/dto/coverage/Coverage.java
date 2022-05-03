
package org.goafabric.fhir.pojo.r4.dto.coverage;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
