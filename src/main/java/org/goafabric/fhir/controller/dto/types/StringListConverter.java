package org.goafabric.fhir.controller.dto.types;


import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter extends StdConverter<List<String>, List<StringType>> {

    @Override
    public List<StringType> convert(List<String> value) {
        if (value == null) {
            return null;
        }

        return value.stream().map(v -> new StringType(v)).collect(Collectors.toList());
    }
}
