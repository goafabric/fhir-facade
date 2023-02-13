package org.goafabric.fhir.controller;


import org.goafabric.fhir.logic.PatientLogic;
import org.goafabric.fhir.pojo.r4.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fhir/Patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
    @Autowired
    private PatientLogic patientLogic;


    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id) {
        patientLogic.sayMyName("Homer"); //just for showcase
        return patientLogic.getPatient(id);
    }

    /*
    @Search
    public List<Patient> findPatientsByFamilyName(@OptionalParam(name = Patient.SP_FAMILY) StringType familyName,
                                                  @OptionalParam(name = Patient.SP_NAME) StringType name) {
        log.info("name: {}, familyName: {}", name, familyName);
        IdType idType = new IdType();
        idType.setId("1");
        return Arrays.asList(patientLogic.findyByLastName(familyName.getValue()));
    }

     */


}
