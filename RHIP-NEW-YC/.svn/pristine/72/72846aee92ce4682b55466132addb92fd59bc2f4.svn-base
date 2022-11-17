package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HealthPrescription;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HealthPrescription
 * 
 */
@Repository("healthPrescriptionDao")
public class HealthPrescriptionDaoImpl extends AbstractDao<HealthPrescription, Long> implements IHealthPrescriptionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}