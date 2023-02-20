
package org.goafabric.fhir.pojo.r4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telecom {
    private String id;

    private String system;
    private String value;
    private String use;

}
