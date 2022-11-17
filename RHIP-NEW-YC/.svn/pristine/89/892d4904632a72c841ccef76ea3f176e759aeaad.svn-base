package com.founder.rhip.ehr.repository.basic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.Department;
import com.founder.rhip.ehr.repository.basic.IDepartmentDao;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of Department
 * 
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Department, String> implements IDepartmentDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}