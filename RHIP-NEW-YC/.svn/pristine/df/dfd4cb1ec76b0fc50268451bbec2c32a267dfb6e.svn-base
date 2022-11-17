package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhPoisonReport;
import com.founder.rhip.ehr.repository.oh.IOhPoisonReportDao;

@Repository("ohPoisonReportDao")
public class OhPoisonReportDaoImpl extends AbstractDao<OhPoisonReport, Integer> implements
		IOhPoisonReportDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
