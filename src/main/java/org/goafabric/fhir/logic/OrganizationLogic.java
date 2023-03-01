package org.goafabric.fhir.logic;

import lombok.experimental.Delegate;
import org.goafabric.fhir.adapter.OrganizationAdapter;
import org.goafabric.fhir.crossfunctional.DurationLog;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class OrganizationLogic {
    @Delegate
    private final OrganizationAdapter organizationAdapter;

    public OrganizationLogic(OrganizationAdapter organizationAdapter) {
        this.organizationAdapter = organizationAdapter;
    }
}
