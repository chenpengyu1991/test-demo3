package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalApparatus;
import com.founder.rhip.ehr.repository.oh.IOhRadiologicalApparatusDao;

@Repository("ohRadiologicalApparatusDao")
public class OhRadiologicalApparatusDaoImpl extends
		AbstractDao<OhRadiologicalApparatus, Integer> implements
		IOhRadiologicalApparatusDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}