package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationSchoolRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;


@Repository("organizationSchoolRelationDao")
public class OrganizationSchoolRelationDaoImpl extends AbstractDao<OrganizationSchoolRelation,Integer> implements IOrganizationSchoolRelationDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
