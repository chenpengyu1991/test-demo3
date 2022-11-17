package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PharmacyOutDetail;

/**
 * DAO implement of PharmacyOutDetail
 * 
 */
@Repository("pharmacyOutDetailDao")
public class PharmacyOutDetailDaoImpl extends AbstractDao<PharmacyOutDetail, Long> implements IPharmacyOutDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}