package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PharmacyCancel;

/**
 * DAO implement of PharmacyCancel
 * 
 */
@Repository("pharmacyCancelDao")
public class PharmacyCancelDaoImpl extends AbstractDao<PharmacyCancel, Long> implements IPharmacyCancelDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}