package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ConsumableOut;

/**
 * DAO implement of ConsumableOut
 * 
 */
@Repository("consumableOutDao")
public class ConsumableOutDaoImpl extends AbstractDao<ConsumableOut, Long> implements IConsumableOutDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}