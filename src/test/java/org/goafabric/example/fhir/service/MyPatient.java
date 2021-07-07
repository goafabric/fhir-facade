package org.goafabric.example.fhir.service;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.ResourceType;

import java.util.List;

@ResourceDef(name = "StructureDefinition")
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

    @Child(
            name = "active",
            type = {BooleanType.class},
            order = 1,
            min = 0,
            max = 1,
            modifier = true,
            summary = true
    )
    @Description(
            shortDefinition = "Whether this patient's record is in active use",
            formalDefinition = "Whether this patient record is in active use. \nMany systems use this property to mark as non-current patients, such as those that have not been seen for a period of time based on an organization's business rules.\n\nIt is often used to filter patient lists to exclude inactive patients\n\nDeceased patients may also be marked as inactive for the same reasons, but may be active for some time after death."
    )
    protected BooleanType active;

    public void setActive(BooleanType active) {
        this.active = active;
    }

    @Override
    public DomainResource copy() {
        return null;
    }

    @Override
    public ResourceType getResourceType() {
        return null;
    }
}
