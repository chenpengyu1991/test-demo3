package com.founder.rhip.ehr.service.basic;

import java.util.List;

import com.founder.rhip.ehr.entity.basic.OrganizationItemRelation;
import com.founder.fasf.beans.Criteria;

public interface IOrganizationItemRelationService {
    public List<OrganizationItemRelation> getOrganizationItemRelation(Criteria criteria);

    public int delete(Criteria criteria);

    public int save(List<OrganizationItemRelation> orgItems);
}
