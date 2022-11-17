package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhCautionAlarm;
import com.founder.rhip.ehr.repository.oh.IOhCautionAlarmDao;

@Repository("ohCautionAlarmDao")
public class OhCautionAlarmDaoImpl extends AbstractDao<OhCautionAlarm, Integer>
		implements IOhCautionAlarmDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
