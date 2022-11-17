package com.founder.rhip.ehr.repository.wsMonitor;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of WsOperationLog
 * 
 */
@Repository("wsOperationLogDao")
public class WsOperationLogDaoImpl extends AbstractDao<WsOperationLog, Long> implements IWsOperationLogDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}