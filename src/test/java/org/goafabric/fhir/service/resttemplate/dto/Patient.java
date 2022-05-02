
package org.goafabric.fhir.service.resttemplate.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceType",
    "id",
    "meta",
    "text",
    "identifier",
    "name",
    "telecom",
    "gender",
    "birthDate",
    "address"
})
@Generated("jsonschema2pojo")
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
