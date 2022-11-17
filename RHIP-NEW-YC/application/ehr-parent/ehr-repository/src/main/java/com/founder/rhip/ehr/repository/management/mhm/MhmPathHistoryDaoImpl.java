package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmPathHistory;
import com.founder.rhip.ehr.repository.management.mhm.IMhmPathHistoryDao;

/**
 * DAO implement of MhmPathHistory
 * 
 */
@Repository("mhmPathHistoryDao")
public class MhmPathHistoryDaoImpl extends AbstractDao<MhmPathHistory, Long> implements IMhmPathHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}