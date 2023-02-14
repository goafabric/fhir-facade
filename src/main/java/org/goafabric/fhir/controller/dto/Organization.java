
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
public class Organization {


    public String id;
    public Meta meta;
    private final String resourceType = "Organization";

    public Boolean active;
    public String name;

    public List<Identifier> identifier;
    public List<Telecom> telecom;
    public List<Address> address;

}
