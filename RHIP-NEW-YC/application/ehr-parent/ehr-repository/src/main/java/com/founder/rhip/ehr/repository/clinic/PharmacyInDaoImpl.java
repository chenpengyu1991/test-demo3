package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PharmacyIn;

/**
 * DAO implement of PharmacyIn
 * 
 */
@Repository("pharmacyInDao")
public class PharmacyInDaoImpl extends AbstractDao<PharmacyIn, Long> implements IPharmacyInDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}