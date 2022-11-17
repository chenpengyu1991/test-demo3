package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PharmacyReturnDetail;

/**
 * DAO implement of PharmacyReturnDetail
 * 
 */
@Repository("pharmacyReturnDetailDao")
public class PharmacyReturnDetailDaoImpl extends AbstractDao<PharmacyReturnDetail, Long> implements IPharmacyReturnDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}