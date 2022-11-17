package com.founder.rhip.ehr.service.orgotherinfo;

public interface IOrgGarbageRelationService {
    public void createOrgGarbageRelation(Integer organizationId, String garbageCode);

    public void deleteOrgGarbageRelation(Integer organizationId);
}
