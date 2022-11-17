package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.DrugUpkeep;

/**
 * DAO implement of DrugUpkeep
 * 
 */
@Repository("drugUpkeepDao")
public class DrugUpkeepDaoImpl extends AbstractDao<DrugUpkeep, Long> implements IDrugUpkeepDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}