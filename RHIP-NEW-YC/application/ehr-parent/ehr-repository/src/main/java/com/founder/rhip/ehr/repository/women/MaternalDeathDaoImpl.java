package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.women.MaternalDeath;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("maternalDeathDao")
public class MaternalDeathDaoImpl extends AbstractDao<MaternalDeath, Long>
		implements IMaternalDeathDao {
	
	 @Resource(name = "msdbJDBCTemplate")
	    private SimpleJdbcTemplate simpleJdbcTemplate;


}
