package com.founder.rhip.ehr.repository.pbusiness.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.pbusiness.student.ClassInfo;
import com.founder.rhip.ehr.entity.pbusiness.student.FissureSealant;

@Repository("fissureSealantDao")
public class FissureSealantDao extends AbstractDao<FissureSealant, Long> implements IFissureSealantDao {
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	@Override
	public List<ClassInfo> getClasses(Date beginDate, Date endDate, String school) {
		final String sql = "SELECT DISTINCT GRADE_CODE, CLASS_CODE FROM FISSURE_SEALANT WHERE CLOSE_DATE BETWEEN ? AND ? AND SCHOOL_CODE = ?";
		List<Map<String, Object>> rows = simpleJdbcTemplate.queryForList(sql, beginDate, endDate, school);
		List<ClassInfo> classes = new ArrayList<ClassInfo>();
		for (Map<String, Object> row : rows) {
			ClassInfo info = new ClassInfo();
			info.setGradeCode(row.get("GRADE_CODE").toString());
			info.setClassCode(row.get("CLASS_CODE").toString());
			classes.add(info);
		}
		return classes;
	}

	@Override
	public List<Map<String, Object>> report(Date beginDate, Date endDate, String[] schoolCodes) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("beginDate", beginDate);
		parameters.addValue("endDate", endDate);
		parameters.addValue("schoolCodes", Arrays.asList(schoolCodes));
		String sql = " SELECT SCHOOL_CODE,NATIVE_STUDENT,GENDER, "
		+ " COUNT(FISSURE_SEALANT_ID) CHECK_NUMBER, SUM(TEETH_NUMBER) TEETH_NUMBER, SUM(DECODE(HAS_DENTAL_CARIES, '1', 1, 0)) HAS_DENTAL_CARIES_NUMBER, "
		+ " SUM(DENTAL_CARIES) DENTAL_CARIES_NUMBER, SUM(REAL_NUMBER) CLOSE_NUMBER "
		+ " FROM FISSURE_SEALANT "
		+ " WHERE CLOSE_DATE BETWEEN :beginDate AND :endDate AND SCHOOL_CODE IN (:schoolCodes) GROUP BY SCHOOL_CODE,NATIVE_STUDENT,GENDER "
		+ " ORDER BY SCHOOL_CODE,NATIVE_STUDENT,GENDER "
		//+ " WHERE CLOSE_DATE BETWEEN :beginDate AND :endDate AND SCHOOL_CODE IN (:schoolCodes) GROUP BY SCHOOL_CODE,GRADE_CODE,CLASS_CODE,NATIVE_STUDENT,GENDER "
		//+ " ORDER BY SCHOOL_CODE,GRADE_CODE,CLASS_CODE,NATIVE_STUDENT,GENDER "
		;
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
	
}
