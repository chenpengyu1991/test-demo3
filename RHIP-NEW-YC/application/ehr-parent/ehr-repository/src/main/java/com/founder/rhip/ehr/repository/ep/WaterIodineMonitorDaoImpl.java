package com.founder.rhip.ehr.repository.ep;

import javax.annotation.Resource;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ep.WaterIodineMonitor;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO implement of WaterIodineMonitor
 * 
 */
@Repository("waterIodineMonitorDao")
public class WaterIodineMonitorDaoImpl extends AbstractDao<WaterIodineMonitor, Long> implements IWaterIodineMonitorDao {

	@Resource(name = "phbdbJDBCTemplate")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}