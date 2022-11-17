package com.founder.rhip.ehr.repository.pbusiness.dmbc;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcChildInstMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcChildInstMonitorDao;

/**
 * DAO implement of DmbcChildInstMonitor
 * 
 */
@Repository("dmbcChildInstMonitorDao")
public class DmbcChildInstMonitorDaoImpl extends AbstractDao<DmbcChildInstMonitor, Long> implements IDmbcChildInstMonitorDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}