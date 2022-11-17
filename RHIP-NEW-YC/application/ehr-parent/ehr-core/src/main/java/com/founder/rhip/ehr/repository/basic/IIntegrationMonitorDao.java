package com.founder.rhip.ehr.repository.basic;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.IntegrationMonitor;

import java.util.Map;


public interface IIntegrationMonitorDao extends IDao<IntegrationMonitor, Long> {
	
	IntegrationMonitor getIntegrationMonitor(Criteria criteria);

	/**
	 * 综合统计
	 * @param criteria
	 * @return
	 */
	Map<String, Object> getIntegrationMonitorNum(Criteria criteria);
}
