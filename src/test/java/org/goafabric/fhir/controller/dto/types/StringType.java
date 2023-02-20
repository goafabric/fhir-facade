package org.goafabric.fhir.controller.dto.types;

import lombok.Getter;

@Getter
public class StringType {
    private char[] value; //need char here otherwise infinite recursion

    public StringType(String value) {
        this.value = value.toCharArray();
    }

    /*
    private List<Extension> extension = null;

    public StringType addExtension(Extension extension) {
        if (this.extension == null) {
            this.extension = new ArrayList<>();
        }
        this.extension.add(extension);
        return this;
    }
    */

}

