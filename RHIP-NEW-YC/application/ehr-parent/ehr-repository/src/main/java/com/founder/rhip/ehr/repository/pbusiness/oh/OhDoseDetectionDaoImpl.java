package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhDoseDetection;
import com.founder.rhip.ehr.repository.oh.IOhDoseDetectionDao;

@Repository("ohDoseDetectionDao")
public class OhDoseDetectionDaoImpl extends
		AbstractDao<OhDoseDetection, Integer> implements IOhDoseDetectionDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
