
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
public class Organization {


    private String id;
    public Meta meta;
    private final String resourceType = "Organization";

    public Boolean active;
    private String name;

    private List<Identifier> identifier;
    private List<Telecom> telecom;
    private List<Address> address;

}
