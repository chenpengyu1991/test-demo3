package com.founder.rhip.ehr.repository.ihm;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

/**
 * DAO interface of 计划生育
 */
public interface IFamilyPlanningDao{
	
	/**
	 * 获取育龄妇女登记列表
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public PageList<Map<String, Object>> getChildBearingList(Page page,Criteria criteria);
	
	/**
	 * 获取妇女病筛查列表
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public PageList<Map<String, Object>> getWomenDiseaseList(Page page,Criteria criteria);	
	
	/**
	 * 获取婚检登记列表
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public PageList<Map<String, Object>> getPremaritalHealthList(Page page,Criteria criteria);	
	
	/**
	 * 获取育龄妇女登记
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public Object getChildBearing(String id);
	
	/**
	 * 获取妇女病筛查
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public Object getWomenDisease(String id);	
	
	/**
	 * 获取婚检登记
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 */
	public Object getPremaritalHealth(String id);	
}