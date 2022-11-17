package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationEnvironmentRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationWaterRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;


@Repository("organizationEnvironmentRelationDao")
public class OrganizationEnvironmentRelationDaoImpl extends AbstractDao<OrganizationEnvironmentRelation,Integer> implements IOrganizationEnvironmentRelationDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
