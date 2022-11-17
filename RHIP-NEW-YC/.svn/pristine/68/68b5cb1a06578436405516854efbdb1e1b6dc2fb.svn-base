package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ClinicalManifestations;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ClinicalManifestations
 * 
 */
@Repository("clinicalManifestationsDao")
public class ClinicalManifestationsDaoImpl extends AbstractDao<ClinicalManifestations, Integer> implements IClinicalManifestationsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}