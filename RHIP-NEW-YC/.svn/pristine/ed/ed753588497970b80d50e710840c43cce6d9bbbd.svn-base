package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmSign;
import com.founder.rhip.ehr.repository.management.mhm.IMhmSignDao;

/**
 * DAO implement of MhmSign
 * 
 */
@Repository("mhmSignDao")
public class MhmSignDaoImpl extends AbstractDao<MhmSign, Long> implements IMhmSignDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}