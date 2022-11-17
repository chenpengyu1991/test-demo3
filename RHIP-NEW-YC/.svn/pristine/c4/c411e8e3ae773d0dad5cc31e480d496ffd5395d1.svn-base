package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ConsumableStore;

/**
 * DAO implement of ConsumableStore
 * 
 */
@Repository("consumableStoreDao")
public class ConsumableStoreDaoImpl extends AbstractDao<ConsumableStore, Long> implements IConsumableStoreDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}