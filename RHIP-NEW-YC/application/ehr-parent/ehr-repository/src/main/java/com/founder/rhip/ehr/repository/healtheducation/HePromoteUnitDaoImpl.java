package com.founder.rhip.ehr.repository.healtheducation;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HePromoteUnit;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HealthPromoteUnit
 * 
 */
@Repository("hePromoteUnitDao")
public class HePromoteUnitDaoImpl extends AbstractDao<HePromoteUnit, Long> implements IHePromoteUnitDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}