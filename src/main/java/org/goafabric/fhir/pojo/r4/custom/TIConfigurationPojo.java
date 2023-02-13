package org.goafabric.fhir.pojo.r4.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.fhir.pojo.r4.Organization;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TIConfigurationPojo {
    //Custom Fields
    private String clientSystemId;
    private String mandantId;
    private String workplaceId;

    //Standard FHIR Resource Organization
    private Organization organization;
}