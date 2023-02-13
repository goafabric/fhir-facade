package org.goafabric.fhir.pojo.r4;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
public class Bundle {
    public String id;
    private final String resourceType = "Bundle";

    public List<Entry> entry;


    static class Entry {
        private String fullUrl;
        //private Resource resource;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    }

}
