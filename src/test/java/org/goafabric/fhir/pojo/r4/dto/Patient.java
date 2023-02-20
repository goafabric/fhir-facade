
package org.goafabric.fhir.pojo.r4.dto;

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
    private String id;
    public Meta meta;
    private final String resourceType = "Patient";

    private String gender;
    private String birthDate;

    private List<Identifier> identifier;
    private List<HumanName> name;
    private List<Telecom> telecom;
    private List<Address> address;

}
