package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DmHighriskRiskFactors;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DmHighriskRiskFactors
 * 
 */
@Repository("dmHighriskRiskFactorsDao")
public class DmHighriskRiskFactorsDaoImpl extends AbstractDao<DmHighriskRiskFactors, Long> implements IDmHighriskRiskFactorsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}