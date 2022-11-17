package com.founder.rhip.portal.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.SmsRecord;
import com.founder.rhip.ehr.repository.portal.ISmsRecordDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of Interaction
 * 
 */
@Repository("smsRecordDao")
public class SmsRecordDaoImpl extends AbstractDao<SmsRecord, Long> implements ISmsRecordDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}