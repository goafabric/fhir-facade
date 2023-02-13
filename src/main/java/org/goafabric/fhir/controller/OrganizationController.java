package org.goafabric.fhir.controller;

import org.goafabric.fhir.logic.OrganizationLogic;
import org.goafabric.fhir.pojo.r4.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationController  {
    @Autowired
    private OrganizationLogic organizationLogic;


    public Organization getOrganization(String id) {
        return organizationLogic.getOrganization(id);
    }
}
