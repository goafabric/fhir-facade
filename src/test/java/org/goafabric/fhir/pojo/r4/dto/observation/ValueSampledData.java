
package org.goafabric.fhir.pojo.r4.dto.observation;

import lombok.Data;

@Data
public class ValueSampledData {

    public Origin origin;
    public Integer period;
    public Double factor;
    public Integer lowerLimit;
    public Integer upperLimit;
    public Integer dimensions;
    public String data;
}
