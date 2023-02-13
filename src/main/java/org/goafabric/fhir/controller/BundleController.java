package org.goafabric.fhir.controller;

import org.goafabric.fhir.logic.BundleLogic;
import org.goafabric.fhir.pojo.r4.Bundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fhir/Bundle", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class BundleController {
    @Autowired
    private BundleLogic bundleLogic;

    @GetMapping("{id}")
    public Bundle getBundle(String id) {
        return bundleLogic.getBundle(id);
    }

    /*
    public MethodOutcome createBundle(@ResourceParam Bundle bundle) {
        return bundleLogic.createBundle(bundle);
    }

     */
}
