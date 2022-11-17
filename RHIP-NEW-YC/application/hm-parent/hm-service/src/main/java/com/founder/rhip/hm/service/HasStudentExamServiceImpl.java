package com.founder.rhip.hm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;
import com.founder.rhip.ehr.service.IHasStudentExamSerivce;

@Service("hasStudentExamService")
public class HasStudentExamServiceImpl implements IHasStudentExamSerivce {
	
	@Autowired
	private IStudentExamService studentExamService;

	/**
	 * 是否有学生体检信息
	 */
	@Override
	public boolean hasStudentExam(String idcard) {
		Criteria criteria = new Criteria("idcard", idcard);
		boolean has = false;
		List<StudentExam> list = studentExamService.getExamList(criteria);
		if(ObjectUtil.isNotEmpty(list)){
			has = true;
		}
		return has;
	}
}
