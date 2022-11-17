package com.founder.rhip.ehr.repository.statistics;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.ElderlyStatistical;

public interface IElderlyStatisticalDao {
	ElderlyStatistical getElderlyStatistical(Criteria criteria);
	
	List<ElderlyStatistical> getElderlyStatisticalSum(Criteria criteria, List<String> organCodeList);
	
	List<ElderlyStatistical> getElderlyStatisticalSum1(Criteria criteria, List<String> organCodeList);

	/**
	 * add by Kevin Ro 老年人健康管理报表统计
	 * @param criteria
	 * @return
	 */
	List<Map<String,Object>> getElderlyManagementSum(Criteria criteria,List<String> orgCodes);
}
