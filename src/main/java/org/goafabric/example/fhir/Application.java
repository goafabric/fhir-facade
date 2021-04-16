package org.goafabric.example.fhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@TypeHint(typeNames = {
        "org.hl7.fhir.dstu3.hapi.ctx.FhirDstu3",
        "ca.uhn.fhir.rest.param.StringParam",
        "ca.uhn.fhir.rest.param.DateParam",
        "org.hl7.fhir.dstu3.model.BooleanType",
        "org.hl7.fhir.dstu3.model.Coding",
        "org.hl7.fhir.dstu3.model.DataRequirement",

}, access = AccessBits.ALL)
 */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
