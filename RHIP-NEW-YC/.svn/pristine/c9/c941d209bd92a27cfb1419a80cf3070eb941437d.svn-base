package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.ChildStatistical;
import com.founder.rhip.ehr.dto.ElderlyStatistical;
import com.founder.rhip.ehr.dto.Tuberculosis;

public interface IchildStatisticalService {
	List<ChildStatistical> childStatisticalServiceList(Criteria criteria);

	ChildStatistical childStatisticalServiceListSum(Criteria criteria);
	List<ElderlyStatistical> elderlyStatisticalServiceListSum(Criteria criteria);
	List<ElderlyStatistical> elderlyStatisticalServiceList(Criteria criteria);

	/**
	 * add Kevin Ro 2018-07-24 老年人健康管理报表统计
	 * @param criteria
	 * @return
	 */
	List<Map<String,Object>> getElderlyManagementSum(Criteria criteria,List<String> orgCodes);
}
