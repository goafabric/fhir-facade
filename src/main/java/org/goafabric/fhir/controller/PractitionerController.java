package org.goafabric.fhir.controller;

import org.goafabric.fhir.logic.PractitionerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PractitionerController {
	@Autowired
	private PractitionerLogic practitionerLogic;

	public org.goafabric.fhir.pojo.r4.Practitioner getPractitioner(String idType) {
		return practitionerLogic.getPractitioner(idType);
	}

}
