package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhTraining;
import com.founder.rhip.ehr.repository.oh.IOhTrainingDao;

@Repository("ohTrainingDao")
public class OhTrainingDaoImpl extends AbstractDao<OhTraining, Integer> implements
		IOhTrainingDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
