
package org.goafabric.fhir.pojo.r4.dto.observation;

import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;
import org.goafabric.fhir.pojo.r4.dto.Text;

@Data
public class Observation {

    public String id;
    public Meta meta;
    public String resourceType;

    public Text text;
    public String status;
    public Subject subject;
    public String effectiveDateTime;
    public ValueSampledData valueSampledData;

}
