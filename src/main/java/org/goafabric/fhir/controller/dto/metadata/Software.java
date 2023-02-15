
package org.goafabric.fhir.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Software {

    @JsonProperty("name")
    public String name;
    @JsonProperty("version")
    public String version;

}
