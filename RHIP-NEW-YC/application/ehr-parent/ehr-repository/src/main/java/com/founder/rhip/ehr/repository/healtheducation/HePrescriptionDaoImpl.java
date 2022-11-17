package com.founder.rhip.ehr.repository.healtheducation;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HePrescription;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HealthPrescription
 * 
 */
@Repository("hePrescriptionDao")
public class HePrescriptionDaoImpl extends AbstractDao<HePrescription, Long> implements IHePrescriptionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}