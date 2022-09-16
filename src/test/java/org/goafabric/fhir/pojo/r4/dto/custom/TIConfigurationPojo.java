package org.goafabric.fhir.pojo.r4.dto.custom;

import lombok.Data;

@Data
public class TIConfigurationPojo {
    private String clientSystemId;
    private String mandantId;
    private String workplaceId;
}