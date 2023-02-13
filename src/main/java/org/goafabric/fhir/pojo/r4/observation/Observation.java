
package org.goafabric.fhir.pojo.r4.observation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.goafabric.fhir.pojo.r4.Meta;
import org.goafabric.fhir.pojo.r4.Text;

import java.util.HashMap;
import java.util.Map;

@Data
public class Observation {

    public String id;
    public Meta meta;
    public String resourceType;

    public Text text;
    public String status;
    public Subject subject;
    public String effectiveDateTime;
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
