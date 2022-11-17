package com.founder.rhip.ehr.repository.pbusiness.student;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.pbusiness.student.ClassInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("classInfoDao")
public class ClassInfoDaoImpl extends AbstractDao<ClassInfo, Long> implements IClassInfoDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

}
