package com.founder.rhip.ehr.repository.women;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.women.PrenatalScreenDiagnosis;
import com.founder.fasf.repository.AbstractDao;

/**
 * DAO implement of PrenatalScreenDiagnosis
 * 
 */
@Repository("prenatalScreenDiagnosisDao")
public class PrenatalScreenDiagnosisDaoImpl extends AbstractDao<PrenatalScreenDiagnosis, String> implements IPrenatalScreenDiagnosisDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}