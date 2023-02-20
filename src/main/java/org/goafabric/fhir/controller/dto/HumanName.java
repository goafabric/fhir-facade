
package org.goafabric.fhir.controller.dto;

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

    private ExtensionWrapper _family;
    public ExtensionWrapper getFamilyExtension() {return _family; }

}
