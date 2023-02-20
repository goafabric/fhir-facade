package org.goafabric.fhir.controller.dto.extension;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExtensionWrapper {

    private List<Extension> extension;

    public ExtensionWrapper addExtension(String url, String valueString) {
        if (extension == null) {
            extension = new ArrayList<>();
        }
        extension.add(new Extension(url, valueString));
        return this;
    }
}
