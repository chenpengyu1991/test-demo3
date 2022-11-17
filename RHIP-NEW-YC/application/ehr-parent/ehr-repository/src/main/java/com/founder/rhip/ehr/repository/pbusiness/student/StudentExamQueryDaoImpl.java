package com.founder.rhip.ehr.repository.pbusiness.student;

import java.util.Date;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentInfo;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("studentExamQueryDao")
public class StudentExamQueryDaoImpl extends AbstractDao<StudentExam, Long> implements IStudentExamQueryDao {
	
	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}
    /**
     * 统计学生体检进度
     */
    private static final String PROGRESS_SQL = " SELECT EXAM.*,INFO.SCHOOL_NAME schoolName FROM( SELECT COUNT(STUDENT_ID) shouldNum"//应检人数
    		+ " ,COUNT(STUDENT_EXAM_ID) actualNum"//录入人数
    		+ " ,ROUND(DECODE(SIGN(COUNT(STUDENT_ID)),0,0,COUNT(STUDENT_EXAM_ID)/NVL(COUNT(STUDENT_ID),0)),4) examRate"//录入率
    		+ " ,NVL(SUM(PRINT_COUNT),0) printCount"//打印人数
    		+ " ,ROUND(DECODE(SIGN(COUNT(STUDENT_ID)),0,0,NVL(SUM(PRINT_COUNT),0)/NVL(COUNT(STUDENT_ID),0)),4) printRate"//打印率    		
    		+ " ,SCHOOL_CODE schoolCode"//学校编码
    		+ " FROM ( "

    		+ " SELECT S.SCHOOL_CODE,S.IDCARD,S.IN_YEAR,S.STUDENT_ID,E.STUDENT_EXAM_ID,E.PRINT_COUNT"
    		+ " FROM MDM_STUDENT_INFO S"
    		+ " LEFT JOIN "
			+ " (SELECT STUDENT_EXAM_ID,SCHOOL_CODE,IDCARD,DECODE(NVL(PRINT_DATE,NULL),NULL,0,PRINT_DATE,1) PRINT_COUNT "
			+ " FROM STUDENT_EXAM"
			+ " %1$s) "//实际体检条件
			+ " E"
    		+ " ON S.IDCARD  = E.IDCARD"
    		+ " %2$s"//应检条件
    		+ " )GROUP BY SCHOOL_CODE ) EXAM"
    		+ " LEFT JOIN (SELECT DISTINCT SCHOOL_CODE,SCHOOL_NAME FROM STUDENT_INFO) INFO ON INFO.SCHOOL_CODE = EXAM.schoolCode ";
    
	@Override
	public PageList<StudentExam> getStudentExams(Page page, Criteria criteria) {
		Object year = criteria.get("year");
		criteria.remove("year");
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM ( ");
		sb.append("   SELECT S.STUDENT_ID EXAM_ID, ");
		sb.append("     DECODE(E.NAME, NULL, S.NAME, E.NAME) NAME, ");
		sb.append("     DECODE(E.GENDER, NULL, S.GENDER, E.GENDER) GENDER, ");
		sb.append("     DECODE(E.BIRTHDAY, NULL, S.BIRTHDAY, E.BIRTHDAY) BIRTHDAY, ");
		sb.append("     DECODE(E.IDCARD, NULL, S.IDCARD, E.IDCARD) IDCARD, ");
		sb.append("     DECODE(E.SCHOOL_CODE, NULL, S.SCHOOL_CODE, E.SCHOOL_CODE) SCHOOL_CODE, ");
		sb.append("     DECODE(E.SCHOOL_NAME, NULL, S.SCHOOL_NAME, E.SCHOOL_NAME) SCHOOL_NAME, ");
		sb.append("     DECODE(E.GRADE_CODE, NULL, S.GRADE_CODE, E.GRADE_CODE) GRADE_CODE, ");
		sb.append("     DECODE(E.CLASS_CODE, NULL, S.CLASS_CODE, E.CLASS_CODE) CLASS_CODE, ");
		sb.append("     E.STUDENT_EXAM_ID, ");
		sb.append("     E.EXAM_DATE, ");
		sb.append("     E.PRINT_DATE ");
		sb.append("   FROM STUDENT_INFO S ");
		sb.append("   LEFT JOIN (SELECT * FROM STUDENT_EXAM ");
		if (ObjectUtil.isNotEmpty(year)) {
			sb.append(" WHERE TO_CHAR(EXAM_DATE, 'YYYY') = '" + year + "'");
		}
		sb.append("   )E ");
		sb.append("   ON S.IDCARD=E.IDCARD ");
		sb.append("   ) ");
		SqlBuilder.buildWhereStatement(getTClass(), sb, criteria);
		sb.append(" ORDER BY SCHOOL_CODE, GRADE_CODE, CLASS_CODE, EXAM_DATE DESC ");
		PageList<StudentExam> pageList = getPageList(page, sb.toString(), criteria);
		return pageList;
	}
	
	/**
	 * 统计体检进度列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getStudentExamProgressList(Page page,Criteria criteria){
		Object year = criteria.get("year");//体检日期
		criteria.remove("year");
		
		StringBuilder sql = new StringBuilder(PROGRESS_SQL);
		StringBuilder  where1SQL = new StringBuilder();
		StringBuilder  where2SQL = new StringBuilder();
		
		Criteria ca1 = new Criteria().addAll(criteria);//实际体检条件
		ca1.remove("S.SCHOOL_CODE");
        Date startExamDate = DateUtil.parseSimpleDate(year + "/01/01", null);
        Date endExamDate = DateUtil.parseSimpleDate(year + "/12/31", null);
        DateUtil.getCriteriaByDateRange(ca1, "EXAM_DATE", startExamDate,endExamDate);

        Criteria ca2 = new Criteria().addAll(criteria);//实际体检条件
        ca2.remove("schoolCode");
        SqlBuilder.buildWhereStatement(StudentExam.class, where1SQL, ca1);
		SqlBuilder.buildWhereStatement(StudentInfo.class, where2SQL, ca2);
		
		String lastSql = String.format(sql.toString(),where1SQL.toString(),where2SQL.toString());
		return this.getPageMapList(page, lastSql, ca1);
	}	
}
