package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.HealthSummary;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of HealthSummary
 * 
 */
@Repository("healthSummaryDao")
public class HealthSummaryDaoImpl extends AbstractDao<HealthSummary, String> implements IHealthSummaryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}