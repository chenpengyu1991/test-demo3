package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChildDeath;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("childDeathDao")
public class ChildDeathDaoImpl extends AbstractDao<ChildDeath, Long> implements
        IChildDeathDao {
	
	 @Resource(name = "msdbJDBCTemplate")
	    private SimpleJdbcTemplate simpleJdbcTemplate;

}
