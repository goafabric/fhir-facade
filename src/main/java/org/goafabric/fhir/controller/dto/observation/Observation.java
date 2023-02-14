
package org.goafabric.fhir.controller.dto.observation;

import lombok.Data;
import org.goafabric.fhir.controller.dto.Meta;
import org.goafabric.fhir.controller.dto.Text;

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
