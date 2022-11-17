package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.Doctor;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of Doctor
 * 
 */
@Repository("doctorDao")
public class DoctorDaoImpl extends AbstractDao<Doctor, Long> implements IDoctorDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}