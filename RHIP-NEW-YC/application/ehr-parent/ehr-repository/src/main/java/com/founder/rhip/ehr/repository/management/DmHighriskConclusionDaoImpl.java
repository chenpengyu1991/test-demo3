package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DmHighriskConclusion;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DmHighriskConclusion
 * 
 */
@Repository("dmHighriskConclusionDao")
public class DmHighriskConclusionDaoImpl extends AbstractDao<DmHighriskConclusion, Long> implements IDmHighriskConclusionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}