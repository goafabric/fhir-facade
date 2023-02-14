package org.goafabric.fhir.controller;


import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.logic.PatientLogic;
import org.goafabric.fhir.controller.dto.Bundle;
import org.goafabric.fhir.controller.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Patient", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
@Slf4j
public class PatientController {
    @Autowired
    private PatientLogic patientLogic;


    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id) {
        patientLogic.sayMyName("Homer"); //just for showcase
        return patientLogic.getPatient(id);
    }

    @GetMapping
    public Bundle findPatientsByFamilyName(@RequestParam(value = "family", required = false) String familyName,
                                                  @RequestParam(value = "name", required = false) String name) {
        log.info("name: {}, familyName: {}", name, familyName);

        return patientLogic.findyByLastName(familyName);
    }


}
