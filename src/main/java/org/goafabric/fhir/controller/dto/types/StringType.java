package org.goafabric.fhir.controller.dto.types;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import org.goafabric.fhir.controller.dto.Extension;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StringType {

    public StringType(String value) {
        this.value = value;
    }

    public StringType() {
    }


    @JacksonXmlProperty(isAttribute = true)
    private String value;

    private List<Extension> extensions = null;

    public StringType addExtension(Extension extension) {
        if (extensions == null) {
            extensions = new ArrayList<>();
        }
        extensions.add(extension);
        return this;
    }

}
