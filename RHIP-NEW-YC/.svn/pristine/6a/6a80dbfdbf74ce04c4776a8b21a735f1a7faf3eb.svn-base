package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.PastHistory;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of PastHistory
 * 
 */
@Repository("pastHistoryDao")
public class PastHistoryDaoImpl extends AbstractDao<PastHistory, Integer> implements IPastHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}