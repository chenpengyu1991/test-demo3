package com.founder.rhip.ehr.repository.pbusiness.student;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.pbusiness.student.SchoolStudent;

@Repository("schoolStudentDao")
public class SchoolStudentDao extends AbstractDao<SchoolStudent, Long> implements ISchoolStudentDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}
}
