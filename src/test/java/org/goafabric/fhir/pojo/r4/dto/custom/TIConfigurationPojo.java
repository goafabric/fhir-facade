package org.goafabric.fhir.pojo.r4.dto.custom;

import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Organization;

@Data
public class TIConfigurationPojo {
    //Custom Fields
    private String clientSystemId;
    private String mandantId;
    private String workplaceId;

    //Standard FHIR Resource Organization
    private Organization organization;
}