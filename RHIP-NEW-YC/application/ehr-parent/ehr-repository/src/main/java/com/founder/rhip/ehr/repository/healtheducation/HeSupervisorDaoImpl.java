package com.founder.rhip.ehr.repository.healtheducation;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HeSupervisor;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HealthSupervisor
 * 
 */
@Repository("heSupervisorDao")
public class HeSupervisorDaoImpl extends AbstractDao<HeSupervisor, Long> implements IHeSupervisorDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}