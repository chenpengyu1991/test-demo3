package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.portal.dto.QueryReserve;
import com.founder.rhip.portal.dto.SearchReserve;
import com.founder.rhip.portal.dto.UpdateResource;

public interface IReserveHisService {

	/** 
	* @Title: updateSchedule 
	* @Description: 获取资源
	* @param @param updateResource
	* @return void
	* @throws 
	*/
	String updateSchedule(UpdateResource updateResource);

	/** 
	* @Title: getReserve 
	* @Description: 查询预约挂号
	* @param @param queryReserve
	* @param @return
	* @return String
	* @throws 
	*/
	String getReserve(SearchReserve searchReserve);

	/** 
	* @Title: updateReserveStatus 
	* @Description: 刷新到诊状态
	* @param @param queryReserve
	* @param @return
	* @return String
	* @throws 
	*/
	String updateReserveStatus(QueryReserve queryReserve,String reserveStauts);

	/** 
	* @Title: stopingDoctor 
	* @Description: 停诊医生
	* @param @param stopDoctor
	* @param @return
	* @return String
	* @throws 
	*/
	String stopingDoctor(StopDoctor stopDoctor);

	/** 
	* @Title: cancelingDoctor 
	* @Description: 取消停诊
	* @param @param stopDoctor
	* @param @return
	* @return String
	* @throws 
	*/
	String cancelingDoctor(StopDoctor stopDoctor);

	/** 
	* @Title: searchReserves 
	* @Description: 查询LIST
	* @param @param searchReserve
	* @param @return
	* @return String
	* @throws 
	*/
	String searchReserves(SearchReserve searchReserve);

	/** 
	* @Title: queryReserveRegister 
	* @Description: 查询预约挂号LIST
	* @param @param searchReserve
	* @param @return
	* @return String
	* @throws 
	*/
	String queryReserveRegister(SearchReserve searchReserve, Criteria criteria);
	
	/** 
	* @Title: updateScheduleByTime 
	* @Description: 获取分时段的预约资源
	* @param  updateResource
	* @return String
	* @throws 
	*/
	String updateScheduleByTime(String xml);
	
	/** 
	* @Title: getContants 
	* @Description: 获取常用联系人
	* @param  Contants 
	* @return String
	* @throws 
	*/
	String getContants(String xml);

	/** 
	* @Title: getContants 
	* @Description: 新增或修改常用联系人
	* @param  Contants 
	* @return String
	* @throws 
	*/
	String updateContants(FrequentContacts FreContacts);

	/** 
	* @Title: getHotExpert 
	* @Description: 获取热门专家信息
	* @param  hospitalCode 
	* @return String
	* @throws 
	*/
	String getHotExpert(String hospitalCode);

	/** 
	* @Title: getUserReserve 
	* @Description: 获取用户预约信息包括常用联系人
	* @param  信息类 
	* @return String
	* @throws 
	*/
	String getUserReserve(SearchReserve searchReserve);
}
