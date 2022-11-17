package com.founder.rhip.ehr.repository.basic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.ServiceSyncTemp;

@Repository("serviceSyncTempDao")
public class ServiceSyncTempDaoImpl  extends AbstractDao<ServiceSyncTemp, Long> implements IServiceSyncTempDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
