
package org.goafabric.fhir.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.fhir.controller.dto.extension.ExtensionWrapper;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HumanName {

    private String use;
    private String family;
    private List<String> given;
    @JsonProperty("_family") //extensions have to be defined like this, look at a json example and you will see why
    private ExtensionWrapper familyExtension;

}
