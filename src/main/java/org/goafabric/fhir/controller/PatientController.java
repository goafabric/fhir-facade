package org.goafabric.fhir.controller;


import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.controller.dto.Patient;
import org.goafabric.fhir.logic.PatientLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Patient", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/fhir+json"})
public class PatientController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PatientLogic patientLogic;

    public PatientController(PatientLogic patientLogic) {
        this.patientLogic = patientLogic;
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id) {
        patientLogic.sayMyName("Homer"); //just for showcase
        return patientLogic.getPatient(id);
    }

    @GetMapping
    public Bundle findPatients(@RequestParam(value = "family", required = false) String familyName,
                               @RequestParam(value = "name", required = false) String name) {
        log.info("name: {}, familyName: {}", name, familyName);

        return patientLogic.findyByLastName(familyName);
    }


}
