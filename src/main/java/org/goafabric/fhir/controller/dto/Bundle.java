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
public class Bundle<T> {
    public String id;
    private final String resourceType = "Bundle";

    private final List<BundleEntryComponent<T>> entry = new ArrayList<>();

    public void addEntry(BundleEntryComponent bundleEntry) {
        entry.add(bundleEntry);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BundleEntryComponent<T> {
        private String fullUrl;
        private T resource;
    }

}
