package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationWaterRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;


@Repository("organizationWaterRelationDao")
public class OrganizationWaterRelationDaoImpl extends AbstractDao<OrganizationWaterRelation,Integer> implements IOrganizationWaterRelationDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
