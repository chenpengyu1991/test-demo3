package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of DhsDrugAllergyHistory
 * 
 */
@Repository("drugAllergyHistoryDao")
public class DrugAllergyHistoryDaoImpl extends AbstractDao<DrugAllergyHistory, Long> implements IDrugAllergyHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}