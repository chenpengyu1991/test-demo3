package com.founder.rhip.ehr.repository.clinic;

import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 12-12-13
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
@Repository("healthEvaluateAnomalyDao")
public class HealthEvaluateAnomalyDaoImpl extends AbstractDao<HealthEvaluateAnomaly,Long> implements IHealthEvaluateAnomalyDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
