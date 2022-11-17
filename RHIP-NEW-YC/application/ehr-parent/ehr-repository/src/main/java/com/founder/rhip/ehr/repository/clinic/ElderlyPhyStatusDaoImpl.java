package com.founder.rhip.ehr.repository.clinic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyStatus;

@Repository("elderlyPhyStatusDao")
public class ElderlyPhyStatusDaoImpl extends AbstractDao<ElderlyPhyStatus, Long> implements IElderlyPhyStatusDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
}
