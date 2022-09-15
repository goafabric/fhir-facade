package org.goafabric.fhir.pojo.r4.dto.custom;

import lombok.Data;
import org.hl7.fhir.r4.model.StringType;

@Data
public class TIConfigurationPojo {
    private StringType clientSystemId;
    private StringType mandantId;
    private StringType workplaceId;
}