package com.founder.rhip.ehr.repository.pbusiness.student;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("studentInfoDao")
public class StudentInfoDaoImpl extends AbstractDao<StudentInfo, Long> implements IStudentInfoDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

}
