package com.founder.rhip.hm.service;

import com.founder.rhip.ehr.entity.pbusiness.student.StudentInfo;

import java.util.List;

public interface IStudentInfoService {
	/**
	 * 导入学生信息
	 * @return
	 * @param studentList
	 * @param actionType 
	 */
	public int importStudents(List<StudentInfo> studentList, int actionType);

	/**
	 * 
	 * @param idCard
	 * @return
	 */
	public StudentInfo queryStudent(String idCard);
	
	/**
	 * 根据学生ID删除学生信息
	 * @param studentId
	 */
	public void deleteStudent(Long studentId);
	
}
