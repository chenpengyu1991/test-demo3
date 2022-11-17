package com.founder.rhip.ehr.repository.basic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.OrganizationStaff;
import com.founder.rhip.ehr.repository.basic.IOrganizationStaffDao;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of OrganizationStaff
 * 
 */
@Repository("organizationStaffDao")
public class OrganizationStaffDaoImpl extends AbstractDao<OrganizationStaff, String> implements IOrganizationStaffDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}