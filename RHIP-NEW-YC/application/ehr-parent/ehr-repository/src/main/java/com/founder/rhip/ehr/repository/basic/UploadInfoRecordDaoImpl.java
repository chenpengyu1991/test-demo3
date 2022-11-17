package com.founder.rhip.ehr.repository.basic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;

/**
 * DAO implement of UploadInfoRecord
 * 
 */
@Repository("uploadInfoRecordDao")
public class UploadInfoRecordDaoImpl extends AbstractDao<UploadInfoRecord, Long> implements IUploadInfoRecordDao {
	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;

}