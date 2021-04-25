package org.goafabric.example.fhir.configuration;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import lombok.extern.slf4j.Slf4j;

@Interceptor
@Slf4j
public class TenantIdInterceptor {

    @Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_HANDLED)
    public void logRequests(RequestDetails theRequest) {
        log.info("Request of type {} with request ID: {}", theRequest.getOperation(), theRequest.getRequestId());
    }

}