package org.goafabric.fhir.controller;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.Create;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.ResourceParam;
import ca.uhn.fhir.rest.api.MethodOutcome;
import org.goafabric.fhir.logic.BundleLogic;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.IdType;
import org.springframework.stereotype.Component;

@Component
public class BundleController extends AbstractJaxRsResourceProvider<Bundle> {
    private final BundleLogic bundleLogic;

    public BundleController(FhirContext fhirContext, BundleLogic bundleLogic) {
        super(fhirContext);
        this.bundleLogic = bundleLogic;
    }

    @Override
    public Class<Bundle> getResourceType() {
        return Bundle.class;
    }

    @Read
    public Bundle getBundle(@IdParam final IdType idType) {
        return bundleLogic.getBundle(idType);
    }

    @Create
    public MethodOutcome createBundle(@ResourceParam Bundle bundle) {
        return bundleLogic.createBundle(bundle);
    }
}
