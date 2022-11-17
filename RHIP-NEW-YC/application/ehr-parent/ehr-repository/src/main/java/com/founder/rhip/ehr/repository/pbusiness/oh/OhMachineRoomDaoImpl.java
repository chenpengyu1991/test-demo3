package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhMachineRoom;
import com.founder.rhip.ehr.repository.oh.IOhMachineRoomDao;

@Repository("ohMachineRoomDao")
public class OhMachineRoomDaoImpl extends AbstractDao<OhMachineRoom, Integer>
		implements IOhMachineRoomDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}
