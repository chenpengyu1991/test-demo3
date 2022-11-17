package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ExposureHistory;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ExposureHistory
 * 
 */
@Repository("exposureHistoryDao")
public class ExposureHistoryDaoImpl extends AbstractDao<ExposureHistory, Integer> implements IExposureHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}