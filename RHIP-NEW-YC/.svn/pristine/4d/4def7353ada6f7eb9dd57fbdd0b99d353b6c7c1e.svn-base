package com.founder.rhip.ehr.repository.basic;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ServiceSyncLog;

@Repository("serviceSyncLogDao" )
public class ServiceSyncLogDaoImpl extends AbstractDao<ServiceSyncLog, Long> implements IServiceSyncLogDao {
	Logger log = Logger.getLogger(getClass());
	
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    
}
