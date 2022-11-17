package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhProtectiveEquipment;
import com.founder.rhip.ehr.repository.oh.IOhProtectiveEquipmentDao;

@Repository("ohProtectiveEquipmentDao")
public class OhProtectiveEquipmentDaoImpl extends
		AbstractDao<OhProtectiveEquipment, Integer> implements
		IOhProtectiveEquipmentDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
