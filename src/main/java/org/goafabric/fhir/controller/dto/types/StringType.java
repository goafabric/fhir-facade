package org.goafabric.fhir.controller.dto.types;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

@Getter
public class StringType {

    public StringType(String value) {
        this.value = value.toCharArray();
    }

    public StringType() {
    }


    @JacksonXmlProperty(isAttribute = true)
    private char[] value;

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
