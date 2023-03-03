package org.goafabric.fhir.controller;


import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.controller.dto.Patient;
import org.goafabric.fhir.logic.PatientLogic;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Patient", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/fhir+json"})
@Slf4j
public class PatientController {
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
