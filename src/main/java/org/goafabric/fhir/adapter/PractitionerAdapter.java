package org.goafabric.fhir.adapter;

import org.goafabric.fhir.controller.dto.Practitioner;

public interface PractitionerAdapter {
    Practitioner getPractitioner(String id);

}
