package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.TransBloodHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of TransBloodHistory
 * 
 */
@Repository("transBloodHistoryDao")
public class TransBloodHistoryDaoImpl extends AbstractDao<TransBloodHistory, String> implements ITransBloodHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}