package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.RiskFactorMgmt;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of RiskFactorMgmt
 * 
 */
@Repository("riskFactorMgmtDao")
public class RiskFactorMgmtDaoImpl extends AbstractDao<RiskFactorMgmt, String> implements IRiskFactorMgmtDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}