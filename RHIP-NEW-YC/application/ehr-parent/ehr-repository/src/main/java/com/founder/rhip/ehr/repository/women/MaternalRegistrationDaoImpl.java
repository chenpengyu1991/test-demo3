package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.women.MaternalRegistration;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MaternalRegistration
 * 
 */
@Repository("maternalRegistrationDao")
public class MaternalRegistrationDaoImpl extends AbstractDao<MaternalRegistration, Long> implements IMaternalRegistrationDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}