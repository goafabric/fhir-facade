
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
public class HumanName {

    public String use;

    //@JsonSerialize(converter = StringConverter.class)
    public String family;
    public List<String> given;

    //private final ExtensionWrapper _family = new ExtensionWrapper().addExtension("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2", "the 3rd");
}
