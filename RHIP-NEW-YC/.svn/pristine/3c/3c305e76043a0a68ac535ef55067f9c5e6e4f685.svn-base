package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PharmacyOut;

/**
 * DAO implement of PharmacyOut
 * 
 */
@Repository("pharmacyOutDao")
public class PharmacyOutDaoImpl extends AbstractDao<PharmacyOut, Long> implements IPharmacyOutDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}