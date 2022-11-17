package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationGarbageRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationWaterRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;


@Repository("organizationGarbageRelationDao")
public class OrganizationGarbageRelationDaoImpl extends AbstractDao<OrganizationGarbageRelation,Integer> implements IOrganizationGarbageRelationDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
