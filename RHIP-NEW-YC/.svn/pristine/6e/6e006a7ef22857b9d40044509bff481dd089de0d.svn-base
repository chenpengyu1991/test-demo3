package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.IntegrationLog;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("integrationLogDao")
public class IntegrationLogDaoImpl extends AbstractDao<IntegrationLog, Long> implements
		IIntegrationLogDao {
	@Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
