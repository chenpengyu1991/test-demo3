package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalPostion;
import com.founder.rhip.ehr.repository.oh.IOhRadiologicalPostionDao;

@Repository("ohRadiologicalPostionDao")
public class OhRadiologicalPostionDaoImpl extends AbstractDao<OhRadiologicalPostion, Integer> implements
		IOhRadiologicalPostionDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
