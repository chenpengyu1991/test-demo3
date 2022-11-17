package com.founder.rhip.ehr.repository.portal;
import java.util.Date;
import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;

/**
 * DAO interface of Schedual
 * 
 */
public interface IRegisterScheduleDao extends IDao<RegisterSchedule,String> {


	PageList<RegisterSchedule> getRegisterSchedules(Criteria criteria, Page page);
	

	/** 
	* @Title: getRegisterSchedules 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param criteria
	* @param @return
	* @return List<RegisterSchedule>
	* @throws 
	*/
	List<RegisterSchedule> getRegisterSchedules(Criteria criteria);

	/** 
	* @Title: getRequestDate 
	* @Description: 查询可以预约的日期
	* @param @param criteria
	* @param @return
	* @return List<Date>
	* @throws 
	*/
	List<Date> getRequestDate(Criteria criteria);
	
	/**
	 * 预约挂号更新资源表已预约人数字段
	 * @param id 资源表ID
	 * @return
	 */
	int updateRegisterSchedule(Long id);
	
	/***
	 * 预约快速搜索，获取资源表中的hospitalcode,deptSn,deptName
	 * @param criteria
	 * @return
	 */
	PageList<RegisterSchedule> getSearchRegisterSchedulePageLists(Page page, String deptName);
	
	
	/***
	 * 从资源表里去重复hospitalCode
	 * @param criteria
	 * @return
	 */
	public List<RegisterSchedule> getDisHosRegisterScheduleList(Criteria criteria);


	List<RegisterSchedule> getNoPageRegisterSchedule(Criteria criteria);


	List<RegisterSchedule> getDeptName(Criteria criteria);


	List<RegisterSchedule> getHosByDeptName(Criteria deptSnCriteria);
	
}