
package org.goafabric.fhir.pojo.r4.dto.coverage;

import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;

import java.util.List;

@Data
public class Coverage {


    private String id;
    public Meta meta;
    private String resourceType;

    private String status;
    public Type type;
    private String subscriberId;
    public Beneficiary beneficiary;

    private List<Payor> payor;

}
