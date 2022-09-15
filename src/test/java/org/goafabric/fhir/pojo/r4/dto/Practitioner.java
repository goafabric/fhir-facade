
package org.goafabric.fhir.pojo.r4.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Practitioner {

    public String id;
    public Meta meta;
    public String resourceType;

    public Boolean active;
    public String gender;
    public String birthDate;

    public List<Name> name = null;
    public List<Identifier> identifier = null;
    public List<Telecom> telecom = null;
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
