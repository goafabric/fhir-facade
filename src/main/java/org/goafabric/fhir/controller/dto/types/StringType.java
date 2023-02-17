package org.goafabric.fhir.controller.dto.types;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

@Getter
public class StringType {
    @JacksonXmlProperty(isAttribute = true)
    private char[] value; //need char here otherwise infinite recursion

    public StringType(String value) {
        this.value = value.toCharArray();
    }

    /*
    private List<Extension> extensions = null;

    public StringType addExtension(Extension extension) {
        if (extensions == null) {
            extensions = new ArrayList<>();
        }
        extensions.add(extension);
        return this;
    }
     */

}

