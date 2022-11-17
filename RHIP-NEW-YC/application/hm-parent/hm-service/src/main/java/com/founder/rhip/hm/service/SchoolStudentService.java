package com.founder.rhip.hm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.pbusiness.student.SchoolStudent;
import com.founder.rhip.ehr.repository.pbusiness.student.ISchoolStudentDao;

@Service("schoolStudentService")
public class SchoolStudentService implements ISchoolStudentService {
	
	@Resource
	private ISchoolStudentDao schoolStudentDao;

	@Override
	public SchoolStudent querySchoolStudent(String year, String schoolCode) {
		Criteria criteria = new Criteria("year", year);
		criteria.add("schoolCode", schoolCode);
		return schoolStudentDao.get(criteria);
	}

	@Override
	public void save(SchoolStudent studentInfo) {
		Long id = studentInfo.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			schoolStudentDao.insertWithSeq(studentInfo, "SEQ_SCHOOL_STUDENT");
		} else {
			schoolStudentDao.update(studentInfo);
		}
	}
}
