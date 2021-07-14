package org.goafabric.fhir.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import org.goafabric.fhir.logic.PractitionerLogic;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PractitionerService extends AbstractJaxRsResourceProvider<Practitioner> {
	@Autowired
	private PractitionerLogic practitionerLogic;

	public PractitionerService(FhirContext fhirContext) {
		super(fhirContext);
	}

	@Override
	public Class<Practitioner> getResourceType() {
		return Practitioner.class;
	}

	@Read
	public Practitioner getPractitioner(@IdParam final IdType idType) {
		return practitionerLogic.getPractitioner(idType);
	}

	@Search
	public List<Practitioner> findPractitioner(
			@OptionalParam(name = Patient.SP_GIVEN) StringParam given,
			@OptionalParam(name = Patient.SP_FAMILY) StringParam name) {
		return practitionerLogic.findPractitioner(given, name);
	}

}
