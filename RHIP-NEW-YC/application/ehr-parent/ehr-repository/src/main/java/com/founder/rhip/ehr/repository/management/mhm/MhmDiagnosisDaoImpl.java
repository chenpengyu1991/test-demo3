package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDiagnosis;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDiagnosisDao;

/**
 * DAO implement of MhmDiagnosis
 * 
 */
@Repository("mhmDiagnosisDao")
public class MhmDiagnosisDaoImpl extends AbstractDao<MhmDiagnosis, Long> implements IMhmDiagnosisDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}