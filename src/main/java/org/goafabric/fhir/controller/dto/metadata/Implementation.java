
package org.goafabric.fhir.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Implementation {

    @JsonProperty("description")
    public String description;
    @JsonProperty("url")
    public String url;

}
