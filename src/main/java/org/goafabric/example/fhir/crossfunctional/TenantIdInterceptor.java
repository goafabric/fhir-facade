package org.goafabric.example.fhir.crossfunctional;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import lombok.extern.slf4j.Slf4j;

@Interceptor
@Slf4j
public class TenantIdInterceptor {
    private static final ThreadLocal<String> tenantIdThreadLocal = new ThreadLocal<>();

    @Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_HANDLED)
    public void preHandle(RequestDetails request) {
        final String tenantId = request.getHeader("X-TenantId");
        log.info("#interceptor got tenant id {}", tenantId);
        tenantIdThreadLocal.set(request.getHeader("X-TenantId"));
    }

    @Hook(Pointcut.SERVER_PROCESSING_COMPLETED)
    public void afterCompletion(RequestDetails request) {
        tenantIdThreadLocal.remove();
    }

    public static String getTenantId() {
        final String tenantId = tenantIdThreadLocal.get();
        return tenantId == null ? "0" : tenantId;  //Todo: should throw exception
    }
}