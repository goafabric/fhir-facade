
package org.goafabric.fhir.pojo.r4.dto.observation;

import lombok.Data;
import org.goafabric.fhir.pojo.r4.dto.Meta;
import org.goafabric.fhir.pojo.r4.dto.Text;

@Data
public class Observation {

    private String id;
    public Meta meta;
    private String resourceType;

    public Text text;
    private String status;
    public Subject subject;
    private String effectiveDateTime;
    public ValueSampledData valueSampledData;

}
