package org.goafabric.fhir.controller.dto.extension;

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
    private List<Extension> extension = null;

    private StringType addExtension(Extension extension) {
        if (this.extension == null) {
            this.extension = new ArrayList<>();
        }
        this.extension.add(extension);
        return this;
    }

     */

}

