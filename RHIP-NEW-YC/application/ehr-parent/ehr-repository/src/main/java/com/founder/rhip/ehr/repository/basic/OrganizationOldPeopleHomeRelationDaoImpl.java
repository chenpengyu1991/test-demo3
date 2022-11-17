package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationOldPeopleHomeRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;


@Repository("organizationOldPeopleHomedRelationDao")
public class OrganizationOldPeopleHomeRelationDaoImpl extends AbstractDao<OrganizationOldPeopleHomeRelation,Integer> implements IOrganizationOldPeopleHomedRelationDao{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
