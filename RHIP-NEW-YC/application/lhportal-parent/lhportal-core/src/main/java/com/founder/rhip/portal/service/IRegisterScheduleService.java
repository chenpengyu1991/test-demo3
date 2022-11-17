package com.founder.rhip.portal.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.RegisterScheduleDTO;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;

public interface IRegisterScheduleService {

	/**
	 * 获取预约排班资源，根据医院，科室，医生，号别分组
	 * @param criteria
	 * @param page
	 * @return
	 */
	PageList<RegisterSchedule> getRegisterSchedule(Criteria criteria, Page page);
	
	/**
	 * 获取某一个医生7天的预约排班资源，根据医院，科室，医生查询，无分页
	 * @param criteria
	 * @param page
	 * @return
	 */
	List<RegisterSchedule> getNoPageRegisterSchedule(Criteria criteria);
	
	/**
	 * 根据医院，科室，医生，号别,开始结束时间，获取排班详细信息
	 * @param hospitalCode
	 * @param deptSn
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JAXBException 
	 * @throws UnsupportedEncodingException 
	 */
	RegisterScheduleDTO getRegisterScheduleDetail(String hospitalCode, String deptSn, Date startDate, Date endDate) throws UnsupportedEncodingException, JAXBException;

	/**
	 * 获取开始结束时间之前的日期
	 * @return
	 */
	List<Date> getBetweenDate(Date startDate, Date endDate);

	/**
	 * 获取预约排班资源
	 * @param criteria
	 * @return
	 */
	RegisterSchedule getRegisterSchedule(Criteria criteria);
	public List<RegisterScheduleTime> getRegisterScheduleTimeLists(Criteria criteria );

	/**
	 * 通过时段表id获取单条预约排班资源
	 * @param criteria
	 * @return
	 */
	RegisterScheduleTime getRegisterScheduleTime(Criteria criteria);
	
	/**
	 * 根据预约挂号获取排班资源
	 * @param reserveRegister
	 * @return
	 */
	RegisterSchedule getRegisterSchedule(ReserveRegister reserveRegister);
	
	/***
	 * 预约快速搜索
	 * 获取资源表中的hospitalcode,deptSn,deptName
	 * @param criteria
	 * @return
	 */
	PageList<RegisterSchedule> getSearchRegisterSchedulePageLists(Page page, String deptName);
	
}
