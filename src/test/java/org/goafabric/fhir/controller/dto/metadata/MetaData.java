
package org.goafabric.fhir.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class MetaData {

    @JsonProperty("resourceType")
    public String resourceType;
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("status")
    public String status;
    @JsonProperty("date")
    public String date;
    @JsonProperty("publisher")
    public String publisher;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("software")
    public Software software;
    @JsonProperty("implementation")
    public Implementation implementation;
    @JsonProperty("fhirVersion")
    public String fhirVersion;
    @JsonProperty("format")
    public List<String> format;
    @JsonProperty("rest")
    public List<Rest> rest;

}
