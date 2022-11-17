package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.SignLog;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of SignLog
 * 
 */
@Repository("signLogDao")
public class SignLogDaoImpl extends AbstractDao<SignLog, Long> implements ISignLogDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}