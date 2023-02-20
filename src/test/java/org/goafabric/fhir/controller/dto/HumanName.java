
package org.goafabric.fhir.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.fhir.controller.dto.types.ExtensionWrapper;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HumanName {

    private String use;
    private String family;
    private List<String> given;

    //extensions have to be defined like this, look at a json example and you will see why
    private ExtensionWrapper _family;
    public ExtensionWrapper getFamilyExtension() {return _family; }

}
