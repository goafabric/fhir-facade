package org.goafabric.fhir.crossfunctional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseUrlBean {
    private String baseUrl;
    private Boolean multiTenancyEnabled;

    public BaseUrlBean(@Value("${adapter.personservice.url}") String baseUrl,
                       @Value("${multi.tenancy.enabled:false}") Boolean multiTenancyEnabled) {
        this.baseUrl = baseUrl;
        this.multiTenancyEnabled = multiTenancyEnabled;
    }

    public String getUrl() {
        return multiTenancyEnabled
                ? baseUrl.replaceAll("%TENANT_ID%", HttpInterceptor.getTenantId())
                : baseUrl;
    }

    public String getCBName() {
        final String tenantId = multiTenancyEnabled ? HttpInterceptor.getTenantId() : "none";
        return "personservice-tenant-" + tenantId;
    }
}
