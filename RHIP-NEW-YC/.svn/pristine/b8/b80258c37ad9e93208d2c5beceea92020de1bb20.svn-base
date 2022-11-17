package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.HypertensionMgmt;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HypertensionMgmt
 * 
 */
@Repository("hypertensionMgmtDao")
public class HypertensionMgmtDaoImpl extends AbstractDao<HypertensionMgmt, String> implements IHypertensionMgmtDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}