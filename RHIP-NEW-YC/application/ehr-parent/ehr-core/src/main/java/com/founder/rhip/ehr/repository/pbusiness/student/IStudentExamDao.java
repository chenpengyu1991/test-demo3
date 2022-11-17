package com.founder.rhip.ehr.repository.pbusiness.student;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;

public interface IStudentExamDao extends IDao<StudentExam, Long> {
	
	public PageList<StudentExam> getStudentExams(Page page, Criteria criteria);
	
	public List<StudentExam> getStudentExams(String examYear, String school, String grade);
	
	public StudentExam getStudentExamInfo(String examYear, String idcard);
	
	public List<StudentExam> getStudentExamInfo(String examYear, List<String> idcards);
	
	public List<Map<String, Object>> reportBaseData(String examYear, String[] schools, String[] grades,boolean mergeFlag);
	
	public List<Map<String, Object>> reportAgeAt12Data(String examYear, String[] schools, String[] grades,boolean mergeFlag);
	
	public List<Map<String, Object>> reportLastYearNormalData(String examYear, String[] schools, String[] grades,boolean mergeFlag);
	
	public List<Map<String, Object>> reportNewPoorVisionData(String examYear, String[] schools, String[] grades,boolean mergeFlag);
	
	public List<Map<String, Object>> exportStudentExams(Page page, Criteria criteria);
}
