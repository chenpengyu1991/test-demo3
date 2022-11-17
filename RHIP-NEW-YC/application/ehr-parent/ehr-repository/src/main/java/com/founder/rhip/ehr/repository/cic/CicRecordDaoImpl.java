package com.founder.rhip.ehr.repository.cic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.repository.cic.ICicRecordDao;
import com.founder.rhip.ehr.entity.cic.CicRecord;

/**
 * DAO implement of CicRecord
 * 
 */
@Repository("cicRecordDao")
public class CicRecordDaoImpl extends AbstractDao<CicRecord, Long> implements ICicRecordDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}