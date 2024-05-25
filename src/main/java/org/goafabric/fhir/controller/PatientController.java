package org.goafabric.fhir.controller;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import org.goafabric.fhir.logic.PatientLogic;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PatientController extends AbstractJaxRsResourceProvider<Patient> {
    private final PatientLogic patientLogic;

    public PatientController(FhirContext fhirContext, PatientLogic patientLogic) {
        super(fhirContext);
        this.patientLogic = patientLogic;
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
    public List<Patient> findPatientsByFamilyName(@OptionalParam(name = Patient.SP_FAMILY) StringType familyName,
                                                  @OptionalParam(name = Patient.SP_NAME) StringType name) {
        IdType idType = new IdType();
        idType.setId("1");
        return Arrays.asList(patientLogic.findyByLastName(familyName.getValue()));
    }

}
