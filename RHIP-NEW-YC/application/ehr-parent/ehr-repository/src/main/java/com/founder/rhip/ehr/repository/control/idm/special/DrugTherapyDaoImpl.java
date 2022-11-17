package com.founder.rhip.ehr.repository.control.idm.special;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.DrugTherapy;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmDrugTherapy
 * 
 */
@Repository("drugTherapyDao")
public class DrugTherapyDaoImpl extends AbstractDao<DrugTherapy, Long> implements IDrugTherapyDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}