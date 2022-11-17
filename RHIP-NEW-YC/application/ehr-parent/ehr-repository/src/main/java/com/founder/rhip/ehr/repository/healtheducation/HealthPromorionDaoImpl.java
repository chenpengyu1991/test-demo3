package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HealthPromorion;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by chen.q on 15-6-9.
 */
@Repository("healthPromorionDao")
public class HealthPromorionDaoImpl extends AbstractDao<HealthPromorion, Long> implements IHealthPromorionDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
