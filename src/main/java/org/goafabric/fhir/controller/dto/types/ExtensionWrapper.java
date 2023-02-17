package org.goafabric.fhir.controller.dto.types;

import lombok.Data;
import org.goafabric.fhir.controller.dto.Extension;

import java.util.ArrayList;
import java.util.List;

@Data
//private final ExtensionWrapper _family = new ExtensionWrapper().addExtension("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2", "the 3rd");
public class ExtensionWrapper {

    private List<Extension> extensions;

    public ExtensionWrapper addExtension(String url, String valueString) {
        if (extensions == null) {
            extensions = new ArrayList<>();
        }
        extensions.add(new Extension(url, valueString));
        return this;

    }
}
