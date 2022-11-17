package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ConsumableBreakage;

/**
 * DAO implement of ConsumableBreakage
 * 
 */
@Repository("consumableBreakageDao")
public class ConsumableBreakageDaoImpl extends AbstractDao<ConsumableBreakage, Long> implements IConsumableBreakageDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}