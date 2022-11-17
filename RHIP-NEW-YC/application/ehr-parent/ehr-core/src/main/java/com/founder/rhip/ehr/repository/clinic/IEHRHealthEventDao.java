package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of EhrIndex
 */
public interface IEHRHealthEventDao extends IDao<EHRHealthEvent, Long> {

	/**
	 * 获取某人事件所有相关的机构
	 * @param personId
	 * @return
	 */
	List<String> getRelationOrganCodes(Long personId);
	
	Long getHealthEventId(Long personId);

	/**
	 * @Title: getCountBy
	 * @Description: 统计
	 * @param @param criteria
	 * @param @return
	 * @return Integer
	 * @throws
	 */
	Integer getCountBy(Criteria criteria);

	List<Map<String, Object>> getCountByOrgCode(Criteria criteria);
}