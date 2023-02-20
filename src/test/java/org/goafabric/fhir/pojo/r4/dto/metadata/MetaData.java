
package org.goafabric.fhir.pojo.r4.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class MetaData {

    @JsonProperty("resourceType")
    private String resourceType;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("date")
    private String date;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("software")
    public Software software;
    @JsonProperty("implementation")
    public Implementation implementation;
    @JsonProperty("fhirVersion")
    private String fhirVersion;
    @JsonProperty("format")
    private List<String> format;
    @JsonProperty("rest")
    private List<Rest> rest;

}
