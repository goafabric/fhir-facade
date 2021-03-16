package org.goafabric.example.fhir.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PractitionerService extends AbstractJaxRsResourceProvider<Practitioner> {

	public PractitionerService(FhirContext fhirContext) {
		super(fhirContext);
	}

	@Override
	public Class<Practitioner> getResourceType() {
		return Practitioner.class;
	}

	@Read
	public Practitioner getPractitioner(@IdParam final IdType idType) {
		return new Practitioner();
	}

	@Search
	public List<Practitioner> findPractitioner(@OptionalParam(name = Practitioner.SP_FAMILY) StringParam searchParamName) {
		return Arrays.asList(new Practitioner());
	}
}
