package org.goafabric.fhir.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bundle {
    public String id;
    private final String resourceType = "Bundle";

    private final List<BundleEntryComponent> entry = new ArrayList<>();

    public void addEntry(BundleEntryComponent bundleEntry) {
        entry.add(bundleEntry);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BundleEntryComponent {
        private String fullUrl;
        private Object resource;
        //private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    }

}
