
package org.goafabric.fhir.pojo.r4.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Patient {

    @JsonProperty("resourceType")
    public String resourceType;
    @JsonProperty("id")
    public String id;
    @JsonProperty("meta")
    public Meta meta;
    @JsonProperty("identifier")
    public List<Identifier> identifier = null;
    @JsonProperty("name")
    public List<Name> name = null;
    @JsonProperty("telecom")
    public List<Telecom> telecom = null;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("birthDate")
    public String birthDate;
    @JsonProperty("address")
    public List<Address> address = null;
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
