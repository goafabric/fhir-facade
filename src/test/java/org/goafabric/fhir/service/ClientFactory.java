package org.goafabric.fhir.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.api.IHttpRequest;
import ca.uhn.fhir.rest.client.api.IHttpResponse;

import java.io.IOException;
import java.util.Base64;

public class ClientFactory {
    private ClientFactory() {
    }

    public static IGenericClient createClient(String port) {
        final IGenericClient client = FhirContext.forR4().newRestfulGenericClient(
                "http://localhost:" + port + "/fhir");
        client.registerInterceptor(new IClientInterceptor() {
            @Override
            public void interceptRequest(IHttpRequest theRequest) {
                theRequest.addHeader("Authorization", "Basic "
                        + Base64.getEncoder().encodeToString("admin:admin".getBytes()));
            }

            @Override
            public void interceptResponse(IHttpResponse theResponse) throws IOException {
            }
        });
        return client;
    }
}
