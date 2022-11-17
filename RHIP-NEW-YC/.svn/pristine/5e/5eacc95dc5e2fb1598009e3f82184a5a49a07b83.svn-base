package com.founder.rhip.ep.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ep.IodineNutritionSampling;

public interface IIodineNutritionService {

	/**
	 * 获取抽样列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IodineNutritionSampling> getPageList(Page page, Criteria criteria);
	
	/**
	 * 获取抽样列表
	 * @param criteria
	 * @return
	 */
	public List<IodineNutritionSampling> getList(Criteria criteria);
	
	/**
	 * 获取本年度抽样列表
	 * @param criteria
	 * @return
	 */
	public List<IodineNutritionSampling> getCurrentYearSampling(String gbCode, String type);

	/**
	 * 获取抽样详细
	 * @param id
	 * @return
	 */
	public IodineNutritionSampling getDetail(Long id);
	
	/**
	 * 获取抽样详细
	 * @param id
	 * @return
	 */
	public IodineNutritionSampling getDetail(Criteria criteria);
	
	/**
	 * 保存抽样详细
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public void save(IodineNutritionSampling sampling) throws Exception;
	
	/**
	 * 删除抽样详细
	 * @param id
	 * @return
	 */
	public void delete(Long id) throws Exception;


}
