package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.ServiceRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of ServiceRecord
 * 
 */
@Repository("serviceRecordDao")
public class ServiceRecordDaoImpl extends AbstractDao<ServiceRecord, Long> implements IServiceRecordDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}