package com.founder.rhip.ehr.repository.ep;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ep.SaltSamplingRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of SaltSamplingRecord
 * 
 */
@Repository("saltSamplingRecordDao")
public class SaltSamplingRecordDaoImpl extends AbstractDao<SaltSamplingRecord, Long> implements ISaltSamplingRecordDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<SaltSamplingRecord> getPageList(Page page, String year) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM EP_SALT_SAMPLING_RECORD ")
				.append("WHERE TO_CHAR(SAMPLING_TIME, 'YYYY') = '" + year + "'");
		return getPageList(page, sql.toString(), null);
	}
}