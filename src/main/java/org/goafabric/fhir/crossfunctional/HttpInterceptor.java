package org.goafabric.fhir.crossfunctional;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Interceptor
@Slf4j
public class HttpInterceptor {
    private static final ThreadLocal<String> tenantId = new ThreadLocal<>();
    private static final ThreadLocal<String> userName = new ThreadLocal<>();

    public static String getTenantId() { return tenantId.get(); }
    public static String getUserName() { return userName.get(); }
    public static void   setTenantId(String tenantId) { HttpInterceptor.tenantId.set(tenantId); }

    @Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_HANDLED)
    public void preHandle(RequestDetails request) {
        tenantId.set(request.getHeader("X-TenantId") != null ? request.getHeader("X-TenantId") : "0"); //TODO
        userName.set(request.getHeader("X-Auth-Request-Preferred-Username") != null ? request.getHeader("X-Auth-Request-Preferred-Username")
                :  SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Hook(Pointcut.SERVER_PROCESSING_COMPLETED)
    public void afterCompletion(RequestDetails request) {
        tenantId.remove();
        userName.remove();
    }

}