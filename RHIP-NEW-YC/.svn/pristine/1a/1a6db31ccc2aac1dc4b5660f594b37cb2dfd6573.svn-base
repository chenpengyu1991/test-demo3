package com.founder.rhip.ehr.repository.summary;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.summary.DrugHistory;

/**
 * DAO implement of SurgeryHistory
 * 
 */
@Repository("drugHistoryDao")
public class DrugHistoryDaoImpl extends AbstractDao<DrugHistory, String> implements IDrugHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}