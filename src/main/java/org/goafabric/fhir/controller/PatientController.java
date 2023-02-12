package org.goafabric.fhir.controller;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.logic.PatientLogic;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class PatientController extends AbstractJaxRsResourceProvider<Patient> {
    @Autowired
    private PatientLogic patientLogic;

    public PatientController(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }

    @Read
    public Patient getPatient(@IdParam final IdType idType) {
        patientLogic.sayMyName("Homer"); //just for showcase
        return patientLogic.getPatient(idType);
    }

    @Search
    public List<Patient> findPatientsByFamilyName(@OptionalParam(name = Patient.SP_FAMILY) StringType familyName) {
        log.info("familyName: {}", familyName);
        IdType idType = new IdType();
        idType.setId("1");
        return Arrays.asList(patientLogic.getPatient(idType));
    }


}
