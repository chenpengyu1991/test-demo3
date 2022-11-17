package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.SurgeryHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of SurgeryHistory
 * 
 */
@Repository("surgeryHistoryDao")
public class SurgeryHistoryDaoImpl extends AbstractDao<SurgeryHistory, String> implements ISurgeryHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}