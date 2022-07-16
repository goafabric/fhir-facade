package org.goafabric.fhir.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import org.goafabric.fhir.logic.PatientLogic;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientService extends AbstractJaxRsResourceProvider<Patient> {
    @Autowired
    private PatientLogic patientLogic;

    public PatientService(FhirContext fhirContext) {
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
    
}
