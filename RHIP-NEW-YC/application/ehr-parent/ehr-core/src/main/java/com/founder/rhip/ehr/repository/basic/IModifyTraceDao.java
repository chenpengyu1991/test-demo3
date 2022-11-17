package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.basic.ModifyTrace;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of ModifyTrace
 */
public interface IModifyTraceDao extends IDao<ModifyTrace, Long> {

	/**
	 * 档案更新率统计
	 * @param dateStr
	 * @return
	 */
	public List<Map<String, Object>> getModifyTraceStatistics(String dateStr);
}