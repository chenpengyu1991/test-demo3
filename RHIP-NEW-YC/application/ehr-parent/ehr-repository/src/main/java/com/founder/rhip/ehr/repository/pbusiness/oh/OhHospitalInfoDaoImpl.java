package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhHospitalInfo;
import com.founder.rhip.ehr.repository.oh.IOhHospitalInfoDao;

@Repository("ohHospitalInfoDao")
public class OhHospitalInfoDaoImpl extends AbstractDao<OhHospitalInfo, Integer>
		implements IOhHospitalInfoDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
