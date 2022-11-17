package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.SignPerson;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of SignPerson
 * 
 */
@Repository("signPersonDao")
public class SignPersonDaoImpl extends AbstractDao<SignPerson, Long> implements ISignPersonDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}