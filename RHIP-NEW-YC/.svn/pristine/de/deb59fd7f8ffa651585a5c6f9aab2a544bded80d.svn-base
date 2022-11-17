package com.founder.rhip.ehr.repository.control;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of DeathMedicineCertificate
 * 
 */
@Repository("deathMedicineCertificateDao")
public class DeathMedicineCertificateDaoImpl extends AbstractDao<DeathMedicineCertificate, Integer> implements IDeathMedicineCertificateDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}