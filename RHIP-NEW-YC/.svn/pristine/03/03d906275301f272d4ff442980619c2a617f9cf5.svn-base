package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.RecordSerialNumber;
import com.founder.rhip.ehr.repository.basic.IRecordSerialNumberDao;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of User
 * 
 */
@Repository("recordSerialNumberDao")
public class RecordSerialNumberDaoImpl extends AbstractDao<RecordSerialNumber, Long> implements IRecordSerialNumberDao
{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

} 
