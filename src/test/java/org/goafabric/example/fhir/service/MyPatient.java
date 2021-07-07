package org.goafabric.example.fhir.service;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.ResourceType;

import java.util.List;

@ResourceDef(
        name = "MyPatient",
        profile = "http://hl7.org/fhir/StructureDefinition/MyPatient"
)
public class MyPatient extends DomainResource {
    @Child(
            name = "identifier",
            type = {Identifier.class},
            order = 0,
            min = 0,
            max = -1,
            modifier = false,
            summary = true
    )
    @Description(
            shortDefinition = "An identifier for this patient",
            formalDefinition = "An identifier for this patient."
    )
    protected List<Identifier> identifier;

    @Override
    public DomainResource copy() {
        return null;
    }

    @Override
    public ResourceType getResourceType() {
        return null;
    }
}
