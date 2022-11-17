package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.RiskFactorFollowup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of RiskFactorFollowup
 * 
 */
@Repository("riskFactorFollowupDao")
public class RiskFactorFollowupDaoImpl extends AbstractDao<RiskFactorFollowup, Integer> implements IRiskFactorFollowupDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}