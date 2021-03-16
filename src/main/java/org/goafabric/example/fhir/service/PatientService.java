package org.goafabric.example.fhir.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.StringParam;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PatientService extends AbstractJaxRsResourceProvider<Patient> {

    public PatientService(FhirContext fhirContext) {
        super(fhirContext);
    }

    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }

    @Read
    public Patient getPatient(@IdParam final IdType idType) {
        return new Patient();
    }

    @Search
    public List<Patient> findPatient(@OptionalParam(name = Patient.SP_FAMILY) StringParam name,
        @OptionalParam(name = Patient.SP_GIVEN) StringParam given,
        @OptionalParam(name = Patient.SP_BIRTHDATE) DateParam birthday) {
        return Arrays.asList(new Patient());
    }
}
