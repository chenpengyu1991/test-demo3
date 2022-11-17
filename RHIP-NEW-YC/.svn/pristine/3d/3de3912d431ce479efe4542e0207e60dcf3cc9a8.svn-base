package com.founder.rhip.ncp.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ncp.entity.NcpMonitor;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("ncpMonitorDao")
public class MonitorDaoImpl extends AbstractDao<NcpMonitor,Long> implements IMonitorDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
