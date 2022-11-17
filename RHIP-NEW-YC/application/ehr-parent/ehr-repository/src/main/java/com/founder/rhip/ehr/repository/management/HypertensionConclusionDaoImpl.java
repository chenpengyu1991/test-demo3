package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.HypertensionConclusion;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HypertensionConclusion
 * 
 */
@Repository("hypertensionConclusionDao")
public class HypertensionConclusionDaoImpl extends AbstractDao<HypertensionConclusion, String> implements IHypertensionConclusionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}