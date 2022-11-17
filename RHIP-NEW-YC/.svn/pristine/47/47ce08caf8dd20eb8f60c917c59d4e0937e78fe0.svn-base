package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.pbusiness.student.ClassInfo;
import com.founder.rhip.ehr.repository.pbusiness.student.IClassInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("classInfoService")
public class ClassInfoServiceImpl implements IClassInfoService {

	private final String CLASS_ID = "classId";

	@Resource
	private IClassInfoDao classInfoDao;

	@Override
	public List<ClassInfo> getClasses(Criteria criteria) {
		return classInfoDao.getList(criteria, new Order("CLASS_NAME", true));
	}

	@Transactional
	@Override
	public int importClasses(List<ClassInfo> classList) {
		if (ObjectUtil.isNullOrEmpty(classList)) {
			return 0;
		}
		String schoolCode = classList.get(0).getSchoolCode();
		classInfoDao.delete(new Criteria("schoolCode", schoolCode));
		for (ClassInfo classInfo : classList) {
			classInfo.setClassId(classInfoDao.getSequenceNextVal("SEQ_CLASS_INFO", Long.class));
		}
		classInfoDao.batchInsert(classList);
		return classList.size();
	}

	@Override
	public List<String> getGradeList(String schoolCode) {
		List<ClassInfo> classes = classInfoDao.getList(new Criteria("schoolCode", schoolCode), new Order("GRADE_NAME", true), "DISTINCT GRADE_NAME");
		if (ObjectUtil.isNullOrEmpty(classes)) {
			return null;
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < classes.size(); i++) {
			list.add(classes.get(i).getGradeName());
		}
		return list;
	}

	@Override
	public List<String> getClassList(String schoolCode, String gradeName) {
		Criteria criteria = new Criteria("schoolCode", schoolCode).add("gradeName", gradeName);
		List<ClassInfo> classes = getClasses(criteria);
		if (ObjectUtil.isNullOrEmpty(classes)) {
			return null;
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < classes.size(); i++) {
			list.add(classes.get(i).getClassName());
		}
		return list;
	}
}
