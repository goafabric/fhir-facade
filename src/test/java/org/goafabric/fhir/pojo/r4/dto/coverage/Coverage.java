
package org.goafabric.fhir.pojo.r4.dto.coverage;

import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;

import java.util.List;

@Data
public class Coverage {


    public String id;
    public Meta meta;
    public String resourceType;

    public String status;
    public Type type;
    public String subscriberId;
    public Beneficiary beneficiary;

    public List<Payor> payor;

}
