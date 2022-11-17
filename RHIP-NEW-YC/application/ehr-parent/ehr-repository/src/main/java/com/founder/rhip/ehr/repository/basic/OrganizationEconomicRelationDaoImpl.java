package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationEconomicRelation;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;


@Repository("organizationEconomicRelationDao")
public class OrganizationEconomicRelationDaoImpl extends AbstractDao<OrganizationEconomicRelation,Integer> implements IOrganizationEconomicRelationDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
