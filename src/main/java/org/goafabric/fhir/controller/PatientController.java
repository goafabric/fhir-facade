package org.goafabric.fhir.controller;


import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.logic.PatientLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PatientController {
    @Autowired
    private PatientLogic patientLogic;


    public org.goafabric.fhir.pojo.r4.Patient getPatient(String id) {
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
