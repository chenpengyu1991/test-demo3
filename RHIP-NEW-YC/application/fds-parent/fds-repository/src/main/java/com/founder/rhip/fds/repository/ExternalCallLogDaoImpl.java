package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.ExternalCallLog;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of ExternalCallLog
 * 
 */
@Repository("externalCallLogDao")
public class ExternalCallLogDaoImpl extends AbstractDao<ExternalCallLog, Integer> implements IExternalCallLogDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}