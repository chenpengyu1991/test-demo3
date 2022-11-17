package com.founder.rhip.ehr.repository.ep;

import javax.annotation.Resource;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ep.SaltMonitorRecord;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO implement of SaltMonitorRecord
 * 
 */
@Repository("saltMonitorRecordDao")
public class SaltMonitorRecordDaoImpl extends AbstractDao<SaltMonitorRecord, Long> implements ISaltMonitorRecordDao {

	@Resource(name = "phbdbJDBCTemplate")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}