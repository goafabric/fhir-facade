package org.goafabric.example.fhir.service.dstu3;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import org.goafabric.example.fhir.logic.dstu3.PractitionerLogic;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PractitionerService extends AbstractJaxRsResourceProvider<Practitioner> {
	@Autowired
	private PractitionerLogic practitionerLogic;

	public PractitionerService(FhirContext fhirContextDstu3) {
		super(fhirContextDstu3);
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
	public List<Practitioner> findPractitioner(@OptionalParam(name = Practitioner.SP_FAMILY) StringParam searchParamName) {
		return Arrays.asList(new Practitioner());
	}
}
