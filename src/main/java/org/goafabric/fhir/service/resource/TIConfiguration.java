package org.goafabric.fhir.service.resource;

import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;

import java.util.List;

/**
 * Custom Resource
 * See https://hapifhir.io/hapi-fhir/docs/model/custom_structures.html#custom-resource-structure
 */
@ResourceDef(name = "TIConfiguration", profile = "http://hl7.org/fhir/profiles/custom-resource")
@Getter
@Setter
public class TIConfiguration extends DomainResource {

    private static final long serialVersionUID = 1L;


    @Child(name = "clientSystemId", min=0, max=1, order=1)
    private StringType clientSystemId;

    @Child(name = "mandantId", min=0, max=1, order=2)
    private StringType mandantId;

    @Child(name = "workplaceId", min=0, max=1, order=3)
    private StringType workplaceId;

    @Child(name="examples", min=1, max=Child.MAX_UNLIMITED, order=4)
    private List<Type> examples;

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
        TIConfiguration retVal = new TIConfiguration();
        super.copyValues(retVal);
        retVal.clientSystemId = clientSystemId;
        retVal.mandantId = mandantId;
        retVal.workplaceId = workplaceId;
        retVal.examples = examples;
        return retVal;
    }

    @Override
    public boolean isEmpty() {
        return ElementUtil.isEmpty(clientSystemId, mandantId, workplaceId, examples);
    }

}