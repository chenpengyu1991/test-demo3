package com.founder.rhip.ehr.repository.pbusiness.student;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository("studentExamDao")
public class StudentExamDaoImpl extends AbstractDao<StudentExam, Long> implements IStudentExamDao{

	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}
	
	@Override
	public List<Map<String, Object>> exportStudentExams(Page page, Criteria criteria) {
		PageList<Map<String, Object>> pageList = getPageMapList(page, criteria, new Order("SCHOOL_CODE").asc("GRADE_CODE").asc("CLASS_CODE").desc("EXAM_DATE"));
		List<Map<String, Object>>  result = (null == pageList ? null : pageList.getList());
		if (null==result) {
			result=Collections.emptyList();
		}
		return result;
	}
	
	@Override
	public PageList<StudentExam> getStudentExams(Page page, Criteria criteria) {
		return getPageList(page, criteria, new Order("SCHOOL_CODE").asc("GRADE_CODE").asc("CLASS_CODE").desc("EXAM_DATE"));
	}

	@Override
	public List<StudentExam> getStudentExams(String examYear, String school, String grade) {
		StringBuffer sql = new StringBuffer(" SELECT * FROM STUDENT_EXAM WHERE TO_CHAR(EXAM_DATE, 'YYYY') = :examYear ");
		Criteria criteria = new Criteria("examYear", examYear);
		if (StringUtil.isNotEmpty(grade)) {
			criteria.add("grade", grade);
			sql.append(" AND GRADE_CODE = :grade ");
		}
		if (StringUtil.isNotEmpty(school)) {
			criteria.add("school", school);
			sql.append(" AND SCHOOL_CODE = :school ");
		}
		return getList(sql.toString(), criteria);
	}
	
	@Override
	public StudentExam getStudentExamInfo(String examYear, String idcard) {
		final Criteria criteria = new Criteria("examYear", examYear);
		criteria.add("idcard", idcard);
		final String sql = "SELECT * FROM STUDENT_EXAM WHERE TO_CHAR(EXAM_DATE, 'YYYY') = :examYear AND IDCARD = :idcard";
		StudentExam exam = get(sql, criteria);
		return exam;
	}
	
	@Override
	public List<StudentExam> getStudentExamInfo(String examYear, List<String> idcards) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("examYear", examYear);
		parameters.addValue("idcard", idcards);
		final String sql = "SELECT * FROM STUDENT_EXAM WHERE TO_CHAR(EXAM_DATE, 'YYYY') = :examYear AND IDCARD IN (:idcard)";
		List<StudentExam> exams = getList(getTClass(), sql, parameters);
		return exams;
	}

	@Override
	public List<Map<String, Object>> reportBaseData(String examYear, String[] schools, String[] grades,boolean mergeFlag) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("examYear", examYear);
		String sql = " SELECT ";
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE ";
            }
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("grades", Arrays.asList(grades));
            sql += " GRADE_CODE ";
        }
		if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            parameters.addValue("grades", Arrays.asList(grades));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE, GRADE_CODE ";
            }else{
            	sql += " GRADE_CODE ";
            }
		}
		sql += " , GENDER, COUNT(STUDENT_EXAM_ID) EXAM_NUMBER, SUM(TOTAL_RESULT) NORMAL_NUMBER "
				+ " , SUM(DECODE(WEIGHT_CATAGORY, '超重', 1, 0)) OVERWEIGHT_NUMBER, SUM(DECODE(WEIGHT_CATAGORY, '肥胖', 1, 0)) OBESITY_NUMBER "
				+ " , SUM(DECODE(WEIGHT_CATAGORY, '中重度消瘦', 1, 0)) MODERATE_THIN_NUMBER, SUM(DECODE(WEIGHT_CATAGORY, '轻度消瘦', 1, 0)) MILD_THIN_NUMBER "
				+ " , SUM(DECODE(HEIGHT_CATAGORY, '生长迟缓', 1, 0)) SLOW_GROWTH_NUMBER, SUM(DECODE(HEIGHT_CATAGORY, '身材矮小', 1, 0)) SMALL_NUMBER "
				+ " , SUM(CASE WHEN 4.9<=LEAST(L_NAKED_EYE, R_NAKED_EYE) AND LEAST(L_NAKED_EYE, R_NAKED_EYE)<5.0 THEN 1 ELSE 0 END) MILD_POOR_VISION_NUMBER "//--轻度视力不良
				+ " , SUM(CASE WHEN 4.6<=LEAST(L_NAKED_EYE, R_NAKED_EYE) AND LEAST(L_NAKED_EYE, R_NAKED_EYE)<4.9 THEN 1 ELSE 0 END) MODERATE_POOR_VISION_NUMBER "//--中度视力不良
				+ " , SUM(CASE WHEN LEAST(L_NAKED_EYE, R_NAKED_EYE)<4.6 THEN 1 ELSE 0 END) SEVERE_POOR_VISION_NUMBER "//--重度视力不良
				+ " , SUM(CASE WHEN (L_TRACHOMA_EYE + R_TRACHOMA_EYE)>0 THEN 1 ELSE 0 END) TRACHOMA_EYE_NUMBER "//--沙眼
				+ " , SUM(CASE WHEN (NVL(DECAYED_TOOTH_NO_UPL,0) + NVL(MISSING_TOOTH_NO_UPL,0) + NVL(FILL_TOOTH_NO_UPL,0))>0 THEN 1 ELSE 0 END) BABY_EURODONTICUS_NUMBER "//--乳牙龋患人数
				+ " , SUM(NVL(DECAYED_TOOTH_NO_UPL,0) + NVL(MISSING_TOOTH_NO_UPL,0) + NVL(FILL_TOOTH_NO_UPL,0)) BABY_DENTAL_CARIES_NUMBER "//--乳牙龋齿数
				+ " , SUM(NVL(FILL_TOOTH_NO_UPL,0)) BABY_CARIES_FILLING_NUMBER "//--乳牙龋补数
				+ " , SUM(CASE WHEN (NVL(DECAYED_TOOTH_NO_UPR,0) + NVL(MISSING_TOOTH_NO_UPR,0) + NVL(FILL_TOOTH_NO_UPR,0))>0 THEN 1 ELSE 0 END) PER_EURODONTICUS_NUMBER "//--恒牙龋患人数
				+ " , SUM(NVL(DECAYED_TOOTH_NO_UPR,0) + NVL(MISSING_TOOTH_NO_UPR,0) + NVL(FILL_TOOTH_NO_UPR,0)) PER_DENTAL_CARIES_NUMBER "//--恒牙龋齿数
				+ " , SUM(NVL(FILL_TOOTH_NO_UPR,0)) PER_CARIES_FILLING_NUMBER "//--恒牙龋补数
				+ " , SUM(PERIODONTAL_CEHCK_RESULT) PERIODONTAL_DISEASE_NUMBER "//--牙周病
				+ " , SUM(DECODE(HEART_CHECK_RESULT, '杂音', 1, '早搏', 1, 0)) HEART_DISEASE_NUMBER "
				+ " , SUM(DECODE(LUNGS_CHECK_RESULT, '哮鸣音', 1, 0)) LUNG_DISEASE_NUMBER "
				+ " , SUM(DECODE(LIVER_CHECK_RESULT, '肝大', 1, DECODE(SPLEEN_CHECK_RESULT, '脾大', 1, 0))) SPLEEN_DISEASE_NUMBER "
				+ " , SUM(DECODE(NECK_CHECK_RESULT, '甲状腺肿大', 1, 0)) NECK_DISEASE_NUMBER "
				+ " , SUM(DECODE(LYMPH_NODE_CHECK_RESULT, '淋巴结肿大', 1, 0)) LIMBS_DISEASE_NUMBER "
				+ " , SUM(DECODE(SPINE_CHECK_RESULT, '脊柱弯曲', 1, 0)) SPINE_DISEASE_NUMBER "
				+ " , SUM(DECODE(SKIN_CHECK_RESULT, '异常', 1, 0)) SKIN_DISEASE_NUMBER "//--皮肤病
				+ " FROM STUDENT_EXAM "
				+ " WHERE TO_CHAR(EXAM_DATE, 'YYYY') = :examYear ";
		if (ObjectUtil.isNotEmpty(schools)) {
			sql += " AND SCHOOL_CODE IN (:schools) ";
		}
        if (ObjectUtil.isNotEmpty(grades)) {
            sql += " AND GRADE_CODE IN (:grades) ";
        }

        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GENDER "
	                    + " ORDER BY GENDER ";        		
        	}
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            sql += " GROUP BY GRADE_CODE, GENDER "
                    + " ORDER BY GRADE_CODE, GENDER ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
        		sql += " GROUP BY SCHOOL_CODE, GRADE_CODE, GENDER "
        				+ " ORDER BY SCHOOL_CODE, GRADE_CODE, GENDER ";
        	}else{
        		sql += " GROUP BY GRADE_CODE, GENDER "
        				+ " ORDER BY GRADE_CODE, GENDER ";
        	}
        }
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
	
	public List<Map<String, Object>> reportAgeAt12Data(String examYear, String[] schools, String[] grades,boolean mergeFlag) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("examYear", examYear);
		String sql = " SELECT ";
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE ";
            }
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("grades", Arrays.asList(grades));
            sql += " GRADE_CODE ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            parameters.addValue("grades", Arrays.asList(grades));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE, GRADE_CODE ";
            }else{
            	sql += " GRADE_CODE ";
            }
        }
		sql += " , GENDER "
				+ " , SUM(CASE WHEN (NVL(DECAYED_TOOTH_NO_UPR,0) + NVL(MISSING_TOOTH_NO_UPR,0) + NVL(FILL_TOOTH_NO_UPR,0))>0 THEN 1 ELSE 0 END) EURODONTICUS_NUMBER "//--恒牙龋患人数(12周岁)
				+ " , SUM(NVL(DECAYED_TOOTH_NO_UPR,0) + NVL(MISSING_TOOTH_NO_UPR,0) + NVL(FILL_TOOTH_NO_UPR,0)) DENTAL_CARIES_NUMBER "//--恒牙龋齿数(12周岁)
				+ " , SUM(NVL(FILL_TOOTH_NO_UPR,0)) CARIES_FILLING_NUMBER "//--恒牙龋补数(12周岁)
				+ " FROM STUDENT_EXAM "
				//+ " WHERE TRUNC(MONTHS_BETWEEN(EXAM_DATE, BIRTHDAY)/12)=12 "
				+ " WHERE TRUNC(AGE)=12 "
				+ " AND TO_CHAR(EXAM_DATE, 'YYYY') = :examYear ";
        if (ObjectUtil.isNotEmpty(schools)) {
            sql += " AND SCHOOL_CODE IN (:schools) ";
        }
        if (ObjectUtil.isNotEmpty(grades)) {
            sql += " AND GRADE_CODE IN (:grades) ";
        }

        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GENDER "
	                    + " ORDER BY GENDER ";        		
        	}
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            sql += " GROUP BY GRADE_CODE, GENDER "
                    + " ORDER BY GRADE_CODE, GENDER ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GRADE_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GRADE_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GRADE_CODE, GENDER "
	                    + " ORDER BY GRADE_CODE, GENDER ";        		
        	}
        }
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
	
	public List<Map<String, Object>> reportLastYearNormalData(String examYear, String[] schools, String[] grades,boolean mergeFlag) {
		String lastYear = String.valueOf(Integer.parseInt(examYear) - 1);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("lastYear", lastYear);
		String sql = " SELECT ";
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE ";
            }
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("grades", Arrays.asList(grades));
            sql += " GRADE_CODE ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            parameters.addValue("grades", Arrays.asList(grades));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE, GRADE_CODE ";
            }else{
            	sql += " GRADE_CODE ";
            }
        }
		sql += " , GENDER, COUNT(STUDENT_EXAM_ID) NORMAL_VISION_LAST_YEAR_NUMBER "//--去年正常数
				+ " FROM STUDENT_EXAM "
				+ " WHERE LEAST(L_NAKED_EYE, R_NAKED_EYE)>=5.0 "
				+ " AND TO_CHAR(EXAM_DATE, 'YYYY') = :lastYear " ;
        if (ObjectUtil.isNotEmpty(schools)) {
            sql += " AND SCHOOL_CODE IN (:schools) ";
        }
        if (ObjectUtil.isNotEmpty(grades)) {
            sql += " AND GRADE_CODE IN (:grades) ";
        }

        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GENDER "
	                    + " ORDER BY GENDER ";        		
        	}
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            sql += " GROUP BY GRADE_CODE, GENDER "
                    + " ORDER BY GRADE_CODE, GENDER ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GRADE_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GRADE_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GRADE_CODE, GENDER "
	                    + " ORDER BY GRADE_CODE, GENDER ";        		
        	}
        }
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
	
	public List<Map<String, Object>> reportNewPoorVisionData(String examYear, String[] schools, String[] grades,boolean mergeFlag) {
		String lastYear = String.valueOf(Integer.parseInt(examYear) - 1);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("examYear", examYear);
		parameters.addValue("lastYear", lastYear);
		String sql = " SELECT ";
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE ";
            }
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("grades", Arrays.asList(grades));
            sql += " GRADE_CODE ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            parameters.addValue("schools", Arrays.asList(schools));
            parameters.addValue("grades", Arrays.asList(grades));
            if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
            	sql += " SCHOOL_CODE, GRADE_CODE ";
            }else{
            	sql += " GRADE_CODE ";
            }
        }
		sql += " , GENDER, COUNT(IDCARD) NEW_POOR_VISION_NUMBER " //--今年新发数
						+ " FROM ( "
							+ " SELECT SCHOOL_CODE, GRADE_CODE, GENDER, IDCARD "
							+ " FROM STUDENT_EXAM "
							+ " WHERE LEAST(L_NAKED_EYE, R_NAKED_EYE) < 5.0 "
							+ " AND TO_CHAR(EXAM_DATE, 'YYYY') = :examYear ";
                            if (ObjectUtil.isNotEmpty(schools)) {
                                sql += " AND SCHOOL_CODE IN (:schools) ";
                            }
                            if (ObjectUtil.isNotEmpty(grades)) {
                                sql += " AND GRADE_CODE IN (:grades) ";
                            }
			sql += " ) CURRENT_YEAR WHERE EXISTS ( "
							+ " SELECT * FROM ( "
								+ " SELECT SCHOOL_CODE, GRADE_CODE, GENDER, IDCARD "
								+ " FROM STUDENT_EXAM "
								+ " WHERE LEAST(L_NAKED_EYE, R_NAKED_EYE) >= 5.0 "
								+ " AND  TO_CHAR(EXAM_DATE, 'YYYY') = :lastYear ";
                                if (ObjectUtil.isNotEmpty(schools)) {
                                    sql += " AND SCHOOL_CODE IN (:schools) ";
                                }
                                if (ObjectUtil.isNotEmpty(grades)) {
                                    sql += " AND GRADE_CODE IN (:grades) ";
                                }
					sql += " ) LAST_YEAR "
						+ " WHERE LAST_YEAR.IDCARD = CURRENT_YEAR.IDCARD "
						+ " ) ";
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNullOrEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GENDER "
	                    + " ORDER BY GENDER ";        		
        	}
        }
        if (ObjectUtil.isNullOrEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
            sql += " GROUP BY GRADE_CODE, GENDER "
                    + " ORDER BY GRADE_CODE, GENDER ";
        }
        if (ObjectUtil.isNotEmpty(schools) && ObjectUtil.isNotEmpty(grades)) {
        	if(!mergeFlag){//当不选择学校时，把所有学校的相同年级的数据合并在一起
	            sql += " GROUP BY SCHOOL_CODE, GRADE_CODE, GENDER "
	                    + " ORDER BY SCHOOL_CODE, GRADE_CODE, GENDER ";
        	}else{
	            sql += " GROUP BY GRADE_CODE, GENDER "
	                    + " ORDER BY GRADE_CODE, GENDER ";       		
        	}
        }
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}

}
