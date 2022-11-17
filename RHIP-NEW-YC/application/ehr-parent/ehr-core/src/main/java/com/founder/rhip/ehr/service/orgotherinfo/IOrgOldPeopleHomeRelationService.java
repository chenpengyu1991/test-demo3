package com.founder.rhip.ehr.service.orgotherinfo;

import com.founder.rhip.ehr.entity.basic.OrganizationOldPeopleHomeRelation;

public interface IOrgOldPeopleHomeRelationService {
    public void createOrgOldPeopleHomeRelation(OrganizationOldPeopleHomeRelation OrgOldPeopleHomeRelation);

    public void deleteOrgOldPeopleHomeRelation(Integer organizationId);

    public void updateOrgOldPeopleHomeRelation(OrganizationOldPeopleHomeRelation OrgOldPeopleHomeRelation);
}
