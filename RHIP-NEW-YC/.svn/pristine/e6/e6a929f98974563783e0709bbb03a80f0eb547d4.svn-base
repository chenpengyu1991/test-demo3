package com.founder.rhip.ehr.repository.basic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.DeptStaffRelation;
import com.founder.rhip.ehr.repository.basic.IDeptStaffRelationDao;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of DeptStaffRelation
 * 
 */
@Repository("deptStaffRelationDao")
public class DeptStaffRelationDaoImpl extends AbstractDao<DeptStaffRelation, String> implements IDeptStaffRelationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}