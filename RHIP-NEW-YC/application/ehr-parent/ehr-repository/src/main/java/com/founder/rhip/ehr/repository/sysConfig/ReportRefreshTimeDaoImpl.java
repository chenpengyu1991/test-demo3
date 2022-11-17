package com.founder.rhip.ehr.repository.sysConfig;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.sysConfig.ReportRefreshTime;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 */
@Repository("reportRefreshTimeDao")
public class ReportRefreshTimeDaoImpl extends AbstractDao<ReportRefreshTime, Long> implements IReportRefreshTimeDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}