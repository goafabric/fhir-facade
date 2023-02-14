package org.goafabric.fhir.controller;

import org.goafabric.fhir.controller.dto.Practitioner;
import org.goafabric.fhir.logic.PractitionerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fhir/Practitioner", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class PractitionerController {
	@Autowired
	private PractitionerLogic practitionerLogic;

	@GetMapping("/{id}")
	public Practitioner getPractitioner(@PathVariable String id) {
		return practitionerLogic.getPractitioner(id);
	}

}
