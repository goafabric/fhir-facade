package org.goafabric.fhir.service.resource;

import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
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
    @Child(name = "clientSystemId", min=0, max=1, order=1)
    private StringType clientSystemId;

    @Child(name = "mandantId", min=0, max=1, order=2)
    private StringType mandantId;

    @Child(name = "workplaceId", min=0, max=1, order=3)
    private StringType workplaceId;


    //Standard FHIR Resource Organization
    @Child(name = "organization", type = {Organization.class}, min = 0, max = 1, order = 5)
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
        return TIConfiguration.builder()
                .clientSystemId(this.clientSystemId)
                .mandantId(this.mandantId)
                .workplaceId(this.workplaceId)
                .organization(this.organization)
                .build();
    }

    @Override
    public boolean isEmpty() {
        return ElementUtil.isEmpty(clientSystemId, mandantId, workplaceId, organization);
    }

}