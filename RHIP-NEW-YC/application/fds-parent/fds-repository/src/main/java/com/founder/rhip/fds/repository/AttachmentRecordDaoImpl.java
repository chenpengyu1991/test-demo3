package com.founder.rhip.fds.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.fds.entity.AttachmentRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of AttachmentRecord
 * 
 */
@Repository("attachmentRecordDao")
public class AttachmentRecordDaoImpl extends AbstractDao<AttachmentRecord, Long> implements IAttachmentRecordDao {
	
	 @Resource(name = "fdsdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;

}