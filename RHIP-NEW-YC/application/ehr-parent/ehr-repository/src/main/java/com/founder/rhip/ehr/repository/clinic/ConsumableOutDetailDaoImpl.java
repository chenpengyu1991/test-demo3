package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ConsumableOutDetail;

/**
 * DAO implement of ConsumableOutDetail
 * 
 */
@Repository("consumableOutDetailDao")
public class ConsumableOutDetailDaoImpl extends AbstractDao<ConsumableOutDetail, Long> implements IConsumableOutDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}