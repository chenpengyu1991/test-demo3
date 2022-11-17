package com.founder.rhip.ehr.repository.hsa;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.hsa.InspGuideRecord;

/**
 * @author liuk DAO implement of InspGuideRecord
 * 
 */
@Repository("hasInspGuideRecordDao")
public class InspGuideRecordDaoImpl extends AbstractDao<InspGuideRecord, Long> implements IInspGuideRecordDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}