package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.DaConfig;

/**
 * DAO implement of DaConfig
 * 
 */
@Repository("daConfigDao")
public class DaConfigDaoImpl extends AbstractDao<DaConfig, Long> implements IDaConfigDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}