package com.founder.rhip.ep.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ep.IodineNutritionMonitor;

public interface IIodineNutritionMonitorService {

	/**
	 * 获取碘营养和碘缺乏调查监测列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<IodineNutritionMonitor> getPageList(Page page, Criteria criteria);
	
	/**
	 * 获取碘营养和碘缺乏调查监测列表
	 * @param criteria
	 * @return
	 */
	public List<IodineNutritionMonitor> getList(Criteria criteria);

	/**
	 * 获取碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public IodineNutritionMonitor getDetail(Long id);
	
	/**
	 * 获取碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public IodineNutritionMonitor getDetail(Criteria criteria);
	
	/**
	 * 保存碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public void save(IodineNutritionMonitor monitor);
	
	/**
	 * 删除碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public void delete(IodineNutritionMonitor monitor);

	/**
	 * 获取抽样对应的最大调查编号
	 * @param samplingId
	 * @return
	 */
	public Long getMaxMonitorId(Long samplingId);

	/**
	 * 通过编号取得今年监测记录
	 * @param surveyNo
	 * @return
	 */
	public IodineNutritionMonitor getCurrentYearDetailBySurveyNo(String surveyNo);

	/**
	 * 删除碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public void delete(Long id);

}
