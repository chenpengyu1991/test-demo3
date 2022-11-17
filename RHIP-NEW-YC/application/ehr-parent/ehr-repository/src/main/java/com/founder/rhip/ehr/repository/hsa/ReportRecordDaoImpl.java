package com.founder.rhip.ehr.repository.hsa;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;

/**
 * @author liuk DAO implement of ReportRecord
 * 
 */
@Repository("hasReportRecordDao")
public class ReportRecordDaoImpl extends AbstractDao<ReportRecord, Long> implements IReportRecordDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}