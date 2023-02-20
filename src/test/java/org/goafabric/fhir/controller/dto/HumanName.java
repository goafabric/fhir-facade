
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

    public String use;
    public String family;
    public List<String> given;

    public ExtensionWrapper _family;
    public ExtensionWrapper getFamilyExtension() {return _family; }

}
