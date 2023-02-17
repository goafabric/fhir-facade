
package org.goafabric.fhir.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    //@JacksonXmlProperty(isAttribute = true) private final String xmlns = "http://hl7.org/fhir";

    public String id;
    public Meta meta;
    private final String resourceType = "Patient";

    public String gender;
    public String birthDate;

    public List<Identifier> identifier;
    public List<HumanName> name;
    public List<Telecom> telecom;
    public List<Address> address;

}
