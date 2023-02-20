
package org.goafabric.fhir.controller.dto.observation;

import lombok.Data;
import org.goafabric.fhir.controller.dto.Meta;
import org.goafabric.fhir.controller.dto.Text;

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
