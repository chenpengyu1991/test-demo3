package com.founder.rhip.ehr.repository.statistics;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.ElderlyHealthStatistics;


public interface IElderlyHealthStatisticsDao extends IDao<ElderlyHealthStatistics, Long> {
	Long getElderlyHealthStatistics(String orgCode, String year);
	/**
	 * 综合管理，老年人保健-指标
	 *
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public Map<String,Object> getStatisticsMap(Criteria criteria);
	
	/**
	 * 老年人健康管理：健康指标统计
	 * @param paramMap 查询条件
	 * @param organList 
	 * @return
	 */
	public List<Map<String,Object>> getElderlyStatisticsMapList(Map<String, String> paramMap, List<String> organList);
	
	List<Map<String, Object>> getElderlyStatisticsMapList(Criteria criteria,List<String> organList, Integer type);
	List<Map<String, Object>> getElderlyStatisticsByPaAddress(Criteria criteria,List<String> organList, Integer type);
}
