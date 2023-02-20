
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
public class Address {
    private String id;

    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String use;

    private List<String> line;

}
