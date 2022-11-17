package com.founder.rhip.ehr.repository.clinic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.StatisticsByMonth;
import com.founder.rhip.ehr.repository.basic.IStatisticsByMonthDao;

/**
 * 公卫月报
 * @author ggf
 *
 */
@Repository("statisticsByMonthDao")
public class StatisticsByMonthDaoImpl extends AbstractDao<StatisticsByMonth, Long> implements IStatisticsByMonthDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}