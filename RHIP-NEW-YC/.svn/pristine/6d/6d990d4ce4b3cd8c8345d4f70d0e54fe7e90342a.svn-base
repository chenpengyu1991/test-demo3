package com.founder.rhip.portal.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.Interaction;

/**
 * @author Zhou Yang
 *
 */
public interface IInteractionService {
	/**
	 * 获取分页式的列表数据
	 * @param criteria
	 * @param page
	 * @return
	 */
	PageList<Interaction> getList(Page page, Criteria criteria);
	
	/**
     * 获取Interaction对象
     * @param criteria
     * @return
     */
	public Interaction getInteraction(Criteria criteria);
	
	/**
	 * 获取
	 * @param idTemp
	 * @return
	 */
	public Interaction get(Long idTemp);
	
	public void insert(Interaction interaction);
	
	/**
	 * 删除
	 * @param Interaction
	 * @return
	 */
	public int delete(Interaction interaction);
	
	
	/**
	 * 更新
	 * @param Interaction
	 * @return
	 */
	int update(Interaction i,String... properties);
	
	/**
	 * 更新状态
	 * @param column
	 * @param value
	 * @param criteria
	 * @return
	 */
	/*int update(String column,String value,Criteria criteria);*/
	int update(Parameters params,Criteria criteria);
	
	/**
	 * 获取医院的列表
	 * @param column
	 * @param value
	 * @param criteria
	 * @return
	 */
	public HospitalInfo getHospitalInfos(Criteria criteria);
	
	public List<HospitalInfo> getList(Criteria criteria);
	
	/**
     * Gets reports.
     *
     * @param criteria the criteria
     * @return the reports
     */
    /*public List<Map<String, Object>> getDetailReportCardMapList(Criteria criteria);*/
}
