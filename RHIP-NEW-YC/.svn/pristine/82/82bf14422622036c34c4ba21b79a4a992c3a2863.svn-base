package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentInfo;
import com.founder.rhip.ehr.repository.pbusiness.student.IStudentInfoDao;
import com.founder.rhip.ehr.service.IIsStudentService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements IStudentInfoService, IIsStudentService {

	@Resource
	private IStudentInfoDao studentInfoDao;

	@Resource
	private IPlatformService platformService;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	//@Transactional
	@Override
	public int importStudents(List<StudentInfo> studentList, int actionType) {
		if (ObjectUtil.isNullOrEmpty(studentList)) {
			return 0;
		}
		if (actionType == 0) {
			//覆盖导入
			String schoolCode = studentList.get(0).getSchoolCode();
			studentInfoDao.delete(new Criteria("schoolCode", schoolCode));
		}
		
		List<StudentInfo> createList = new ArrayList<StudentInfo>();
		List<StudentInfo> updateList = new ArrayList<StudentInfo>();
		for (StudentInfo studentInfo : studentList) {
			PersonInfo personInfo = studentToPersonInfo(studentInfo);
			String personInfoId = platformService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, false);
			studentInfo.setPersonInfoId(personInfoId);
			
			StudentInfo dbInfo = studentInfoDao.get(new Criteria("idcard", studentInfo.getIdcard()));
			if (dbInfo == null) {
				studentInfo.setStudentId(studentInfoDao.getSequenceNextVal("SEQ_CLASS_INFO", Long.class));
				createList.add(studentInfo);
			} else {
				studentInfo.setStudentId(dbInfo.getStudentId());
				updateList.add(studentInfo);
			}
		}
		studentInfoDao.batchInsert(createList);
		studentInfoDao.batchUpdate(updateList);
		return studentList.size();
	}

	@Override
	public StudentInfo queryStudent(String idcard) {
		Criteria criteria = new Criteria("idcard", idcard);
		List<StudentInfo> students = studentInfoDao.getList(criteria, new Order("OPERATE_TIME", false));
		if (students == null || students.size() == 0) {
			return null;
		}
		return students.get(0);
	}

	private PersonInfo studentToPersonInfo(StudentInfo studentInfo) {
		Calendar calendar = Calendar.getInstance();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setIdcard(studentInfo.getIdcard());
		personInfo.setName(studentInfo.getName());
		personInfo.setGender(studentInfo.getGender());
		personInfo.setBirthday(studentInfo.getBirthday());
		//personInfo.setNation(studentInfo.getNation());//TODO 需要做字典装换
		//personInfo.setAboBloodType(studentInfo.getAboBloodType()); //TODO 需要做字典装换
		personInfo.setHrstreet(studentInfo.getAddress());
		personInfo.setHrpostCode(studentInfo.getPostCode());
		personInfo.setFirstGuardian(studentInfo.getGuardian());
		personInfo.setPhoneNumber(studentInfo.getPhone());
		personInfo.setIdcardVas(studentInfo.getIdcardVas());
		personInfo.setUpdateName(studentInfo.getOperator());
		personInfo.setUpdateOrganCode(studentInfo.getOperateType());
		personInfo.setUpdateDate(calendar.getTime());
		return personInfo;
	}

	@Override
	public boolean isStudent(String idCard) {
		if (StringUtil.isNullOrEmpty(idCard)) {
			return false;
		}
		StudentInfo student = queryStudent(idCard);
		return student != null;
	}
	
	/**
	 * 根据学生ID删除学生信息
	 * @param studentId
	 */
	@Override
	public void deleteStudent(Long studentId) {
		studentInfoDao.delete(studentId);
	}
}
