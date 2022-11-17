package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DiabeticConclusion;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DiabeticConclusion
 * 
 */
@Repository("diabeticConclusionDao")
public class DiabeticConclusionDaoImpl extends AbstractDao<DiabeticConclusion, String> implements IDiabeticConclusionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}