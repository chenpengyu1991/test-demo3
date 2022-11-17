package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.OutDoctor;

import java.util.List;
import java.util.Map;

/***
 * 
 * @author zhou yang
 *
 */
public interface IOutDoctorService {

	/***
	 * 获取outDoctor里的所有医院名称
	 * @return
	 */
	List<OutDoctor> getOutHospitals(Criteria criteria);
	
	/***
	 * 根据搜索条件查询outDoctor里所有科室名称
	 * @param criteria
	 * @return
	 */
	List<OutDoctor> getHotClinics(Criteria criteria);
	
	/***
	 * 根据搜索条件查询职称
	 * @param criteria
	 * @return
	 */
	List<OutDoctor> getHotEmpTits(Criteria criteria);
	
	/***
	 * 根据搜索条件查询所有医生
	 * @param criteria
	 * @return
	 */
	List<OutDoctor> getHotDoctors(Criteria criteria);

	/***
	 * 根据搜索条件查询outDoctor里的某个职称
	 * @param criteria
	 * @return
	 */
	OutDoctor getOutEmpTit(Criteria criteria);

	/***
	 * 根据搜索条件分页查询所有医生
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<OutDoctor> showHotDoctors(Page page, String searchContent, Criteria criteria);

	List<OutDoctor> getOutDoctors(Criteria add);

	/***
	 * 根据搜索条件查询outDoctor里的某个科室名称
	 * @param criteria
	 * @return
	 */
	OutDoctor getOutClinic(Criteria criteria);

	/**
	 * 分页查询出诊医生
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<OutDoctor> getOutDoctors(Page page, Criteria criteria);

	/**
	 * 获取出诊医生对象
	 * @param criteria
	 * @return
	 */
	OutDoctor getOutDoctor(Criteria criteria);

	/**
	 * 根据条件删除相应的出诊医生
	 * @param criteria
	 * @return
	 */
	Integer deleteOutDoctor(Criteria criteria);

	/**
	 * 根据条件更新相应的字段
	 * @param criteria
	 * @param parameters
	 * @return
	 */
	Integer updateOutDoctor(Parameters parameters,  Criteria criteria);

	/**
	 * 更新专家信息
	 * @param outDoctor
	 * @return
	 */
	Integer updateOutDoctor(OutDoctor outDoctor, Map<String, String> map, String createUserCode);
}
