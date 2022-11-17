package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.Pharmacy;

/**
 * DAO implement of Pharmacy
 * 
 */
@Repository("pharmacyDao")
public class PharmacyDaoImpl extends AbstractDao<Pharmacy, Long> implements IPharmacyDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}