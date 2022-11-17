package com.founder.rhip.portal.service;


import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;

public interface IReserveService {

	public static final String REG_PORTAL = "1";
	public static final String REG_PHONE = "2";
	public static final String REG_WS = "3";
	//爱常熟APP
	public static final String REG_WS_CSAPP = "31";
	//省预约平台
	public static final String REG_WS_JS = "32";
	public static final String REG_CSWS = "4";
	
	
	/** 
	* @Title: getOutHospital 
	* @Description: 获取医院的列表
	* @param @return
	* @return List<Organization>
	* @throws 
	*/
	List<HospitalInfo> getOutHospitals();

	/** 
	* @Title: getOutClinic 
	* @Description: 获取科室的列表 
	* @param @param page
	* @param @param criteria
	* @param @return
	* @return PageList<OutClinic>
	* @throws 
	*/
	PageList<OutClinic> getPageOutClinic(Page page,Criteria criteria);
	
	/** 
	* @Title: getOutClinic 
	* @Description: 获取科室的列表 
	* @param @param page
	* @param @param criteria
	* @param @return
	* @return PageList<OutClinic>
	* @throws 
	*/
	List<OutClinic> getOutClinicList(Criteria criteria);

	/** 
	* @Title: getReserveRegister 
	* @Description: 获取预约挂号的列表
	* @param @param criteria
	* @param @param page
	* @param @return
	* @return PageList<ReserveRegister>
	* @throws 
	*/
	PageList<ReserveRegister> getReserveRegister(Criteria criteria, Page page);

	/**
	 * 返回数据
	 * @param regId
	 * @return HashMap 里面包含预约信息，挂号者信息，患者信息的MAP
	 *  reserveRegister
	 */
	ReserveRegister getReserveRegister(Long regId);
	
	/**
	 * @param p
	 * @param scheduleId
	 * @return
	 * RESULT_FULL 已挂满
	 * RESULT_REPEAT 重复预约
	 * RESULT_OVER 次数超过限制
	 * RESULT_OK 预约成功
	 */
	String saveReserveRegister(PersonInfo p, Long scheduleId, Long scheduleTimeId,String submitOrg, Long submitUser,String regFrom);

	/** 
	* @Title: cancelRegister 
	* @Description: 取消预约挂号
	* @param @param regId
	* @param @return
	* @return String
	* @throws 
	*/
	String cancelRegister(ReserveRegister reserveRegister);

	/**
	 * 保存患者，根据需要判断是更新还是新增
	 * */
	//PersonInfo savePersonInfo(PersonInfo p);

	/** 
	* @Title: getReserveRegisters 
	* @Description: 获取预约列表
	* @param @param criteria
	* @param @return
	* @return List<ReserveRegister>
	* @throws 
	*/
	List<ReserveRegister> getReserveRegisters(Criteria criteria);

	/** 
	* @Title: getReserveRegisterByIdCard 
	* @Description:根据身份证查询最近一条预约
	* @param @param idcard
	* @param @return
	* @return ReserveRegister
	* @throws 
	*/
	ReserveRegister getReserveRegisterByIdCard(String idcard);

	/** 
	* @Title: saveReserveRegister 
	* @Description: 创建预约
	* @param @param reserveRegister
	* @param @param scheduleId
	* @param @return
	* @return String
	* @throws 
	*/
	String saveReserveRegister(ReserveRegister reserveRegister, Long scheduleId, Long scheduleTimeId);

	/** 
	* @Title: getOutClinic 
	* @Description: 查询列表
	* @param @param criteria
	* @param @return
	* @return List<OutClinic>
	* @throws 
	*/
	List<OutClinic> getOutClinics(Criteria criteria);

	/** 
	* @Title: getOutClinic 
	* @Description: 获取科室
	* @param @param criteria
	* @param @return
	* @return OutClinic
	* @throws 
	*/
	OutClinic getOutClinic(Criteria criteria);

	/** 
	* @Title: getOutDoctors 
	* @Description: 查询医生
	* @param @param criteria
	* @param @return
	* @return List<OutDoctor>
	* @throws 
	*/
	List<OutDoctor> getOutDoctors(Criteria criteria);

	/** 
	* @Title: getOutDoctors 
	* @Description: 查询医生的所属医院信息
	* @param @param criteria
	* @param @return
	* @return List<OutDoctor>
	* @throws 
	*/
	List<OutDoctor> getHosInfosByDoctor(Criteria criteria);
	
	/** 
	* @Title: getOutDoctor 
	* @Description: 查询医生 
	* @param @param criteria
	* @param @return
	* @return OutDoctor
	* @throws 
	*/
	OutDoctor getOutDoctor(Criteria criteria);

	/** 
	* @Title: overDate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param 
	* @return void
	* @throws 
	*/
	void overDate();
	
	public List<ReserveRegister> getRegisterTargetList(Criteria criteria);
	
	/****
	* @Title: getRegisterScheduleTimeLists 
	* @Description: 根据排班信息的id查询排班时段信息 
	* @param @param registerScheduleId
	* @param @return
	* @return List<RegisterScheduleTime>
	* @throws  
	*/
	public List<RegisterScheduleTime> getRegisterScheduleTimeLists(Criteria criteria);
	
	
	/***
	 * 平台预约发送短信
	 * @param reserveRegister
	 */
	public void sendSMS(ReserveRegister reserveRegister, String modeType);

	/***
	 * 去重资源表里的科室名称
	 * @return
	 */
	List<RegisterSchedule> getDeptName(Criteria criteria);

	/***
	 * 根据科室名称获取医院code和name
	 * @param deptSnCriteria
	 * @return
	 */
	List<RegisterSchedule> getHosByDeptName(Criteria deptSnCriteria);

	/***
	 * 门户查找自身和常用联系人的所有预约信息
	 * @param criteria
	 * @param page
	 * @return
	 */
	PageList<ReserveRegister> getResRegByFreContacts(Long accountId,Criteria criteria,
			Page page);
}
