package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.pbusiness.student.ClassInfo;

import java.util.List;

public interface IClassInfoService {

	/**
	 * 获取班级
	 * @param criteria
	 * @return
	 */
	public List<ClassInfo> getClasses(Criteria criteria);

	/**
	 * 导入班级
	 *
	 * @param classList
	 * @return
	 */
	public int importClasses(List<ClassInfo> classList);

	/**
	 * 取得年级列表
	 * @param schoolCode
	 * @return
	 */
	public List<String> getGradeList(String schoolCode);

	/**
	 * 取得班级列表
	 * @param schoolCode
	 * @return
	 */
	public List<String> getClassList(String schoolCode, String gradeName);
}
