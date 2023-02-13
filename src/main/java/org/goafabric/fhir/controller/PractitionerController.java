package org.goafabric.fhir.controller;

import org.goafabric.fhir.logic.PractitionerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(value = "Practitioner", produces = MediaType.APPLICATION_JSON_VALUE)
public class PractitionerController {
	@Autowired
	private PractitionerLogic practitionerLogic;

	@GetMapping("/{id}")
	public org.goafabric.fhir.pojo.r4.Practitioner getPractitioner(@PathVariable String id) {
		return practitionerLogic.getPractitioner(id);
	}

}
