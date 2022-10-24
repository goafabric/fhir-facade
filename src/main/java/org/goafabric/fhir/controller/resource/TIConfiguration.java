package org.goafabric.fhir.controller.resource;

import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import lombok.*;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StringType;

/**
 * Custom Resource
 * See https://hapifhir.io/hapi-fhir/docs/model/custom_structures.html#custom-resource-structure
 */
@ResourceDef(name = "TIConfiguration", profile = "http://hl7.org/fhir/profiles/custom-resource")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TIConfiguration extends DomainResource {

    private static final long serialVersionUID = 1L;

    //Custom Fields
    @Child(name = "clientSystemId")
    private StringType clientSystemId;

    @Child(name = "mandantId")
    private StringType mandantId;

    @Child(name = "workplaceId")
    private StringType workplaceId;

    //Standard FHIR Resource Organization
    @Child(name = "organization", type = {Organization.class})
    private Organization organization;

    @Override
    public ResourceType getResourceType() {
        return null;
    }

    @Override
    public FhirVersionEnum getStructureFhirVersionEnum() {
        return FhirVersionEnum.R4;
    }

    @Override
    public TIConfiguration copy() {
        TIConfiguration dst = new TIConfiguration();
        super.copyValues(dst);
        return dst;
    }

    /*
    @Override
    public boolean isEmpty() {
        return ElementUtil.isEmpty(clientSystemId, mandantId, workplaceId, organization);
    }
     */

}