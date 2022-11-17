package com.founder.rhip.ehr.repository.pbusiness.student;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;

public interface IStudentExamQueryDao {
	
	public PageList<StudentExam> getStudentExams(Page page, Criteria criteria);

	/**
	 * 统计体检进度列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStudentExamProgressList(Page page,Criteria criteria);
}
