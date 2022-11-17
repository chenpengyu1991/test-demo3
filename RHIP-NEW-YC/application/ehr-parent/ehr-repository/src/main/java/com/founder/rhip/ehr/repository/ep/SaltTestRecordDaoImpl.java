package com.founder.rhip.ehr.repository.ep;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ep.SaltTestRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 *  DAO implementation of SaltTestRecord
 */
@Repository("saltTestRecordDao")
public class SaltTestRecordDaoImpl extends AbstractDao<SaltTestRecord, Long> implements ISaltTestRecordDao {

	@Resource(name = "phbdbJDBCTemplate")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}
