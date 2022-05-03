package org.goafabric.fhir.adapter;

import org.hl7.fhir.r4.model.Practitioner;

import java.util.List;

public interface PractitionerAdapter {
    Practitioner getPractitioner(String id);

    List<Practitioner> findPractitioner(String firstName);
}
