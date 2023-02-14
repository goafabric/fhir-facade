
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
public class Address {
    public String id;

    public String city;
    public String state;
    public String postalCode;
    public String country;
    public String use;

    public List<String> line;

}
