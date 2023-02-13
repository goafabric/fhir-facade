package org.goafabric.fhir.pojo.r4.custom;

import lombok.Builder;
import lombok.Data;
import org.goafabric.fhir.pojo.r4.Organization;

@Data
@Builder
public class TIConfigurationPojo {
    //Custom Fields
    private String clientSystemId;
    private String mandantId;
    private String workplaceId;

    //Standard FHIR Resource Organization
    private Organization organization;
}