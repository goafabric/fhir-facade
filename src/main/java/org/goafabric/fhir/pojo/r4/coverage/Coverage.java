
package org.goafabric.fhir.pojo.r4.coverage;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.goafabric.fhir.pojo.r4.Meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Coverage {


    public String id;
    public Meta meta;
    public String resourceType;

    public String status;
    public Type type;
    public String subscriberId;
    public Beneficiary beneficiary;

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
