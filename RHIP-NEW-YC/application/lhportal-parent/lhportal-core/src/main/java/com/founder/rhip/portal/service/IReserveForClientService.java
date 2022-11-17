package com.founder.rhip.portal.service;

import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.portal.dto.GetYYAllDepartmentInfo;
import com.founder.rhip.portal.dto.GetYYClinicDateByDepartment;
import com.founder.rhip.portal.dto.GetYYDoctorByDepartment;
import com.founder.rhip.portal.dto.GetYYDoctorInfo;
import com.founder.rhip.portal.dto.GetYYDoctorInfoByDoctor;


public interface IReserveForClientService {

	/** 
	* @Title: getClinicByType 
	* @Description: 获取List
	* @param @param getYYAllDepartmentInfo
	* @param @return
	* @return String
	* @throws 
	*/
	String getClinicByType(GetYYAllDepartmentInfo getYYAllDepartmentInfo);
	
	/** 
	* @Title: getDoctorByClinic 
	* @Description: 根据科室类型查询医生 
	* @param @param getYYDoctorByDepartment
	* @param @return
	* @return String
	* @throws 
	*/
	String getDoctorByClinic(GetYYDoctorByDepartment getYYDoctorByDepartment);


	/** 
	* @Title: getScheduleByClinic 
	* @Description: 根据科室查询排班列表
	* @param @param getYYDoctorInfo
	* @param @return
	* @return String
	* @throws 
	*/
	String getScheduleByClinic(GetYYDoctorInfo getYYDoctorInfo);
	
	
	/** 
	* @Title: getScheduleByDoctor 
	* @Description: 根据医生查询排班列表
	* @param @param getYYDoctorInfo
	* @param @return
	* @return String
	* @throws 
	*/
	String getScheduleByDoctor(GetYYDoctorInfoByDoctor getYYDoctorInfoByDoctor);

	/** 
	* @Title: getRequestDate 
	* @Description: 根据条件查询日期
	* @param @param getYYClinicDateByDepartment
	* @param @return
	* @return String
	* @throws 
	*/
	String getRequestDate(GetYYClinicDateByDepartment getYYClinicDateByDepartment);

	/** 
	* @Title: saveRegister 
	* @Description: 保存预约
	* @param @param reserveRegister
	* @param @return
	* @return String
	* @throws 
	*/
	String saveRegister(ReserveRegister reserveRegister);
}
