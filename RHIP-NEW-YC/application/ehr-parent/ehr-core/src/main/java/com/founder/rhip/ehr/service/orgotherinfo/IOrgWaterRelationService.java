package com.founder.rhip.ehr.service.orgotherinfo;

public interface IOrgWaterRelationService {

    public void createOrgWaterRelation(Integer organizationId, String WaterCodes);

    public void deleteOrgWaterRelation(Integer organizationId);
}
