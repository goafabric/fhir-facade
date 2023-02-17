package org.goafabric.fhir.controller.dto.types;


import com.fasterxml.jackson.databind.util.StdConverter;

public class StringConverter extends StdConverter<String, StringType> {
    @Override
    public StringType convert(String value) {
        return new StringType(value);
    }
}
