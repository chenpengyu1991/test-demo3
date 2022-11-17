package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationItemRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

@Repository("organizationItemRelationDao")
public class OrganizationItemRelationDaoImpl extends AbstractDao<OrganizationItemRelation, Long> implements
		IOrganizationItemRelationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
