package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhWorkload;
import com.founder.rhip.ehr.repository.oh.IOhWorkloadDao;

@Repository("ohWorkloadDao")
public class OhWorkloadDaoImpl extends AbstractDao<OhWorkload, Integer> implements
		IOhWorkloadDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
