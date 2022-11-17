package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PharmacyReturn;

/**
 * DAO implement of PharmacyReturn
 * 
 */
@Repository("pharmacyReturnDao")
public class PharmacyReturnDaoImpl extends AbstractDao<PharmacyReturn, Long> implements IPharmacyReturnDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}