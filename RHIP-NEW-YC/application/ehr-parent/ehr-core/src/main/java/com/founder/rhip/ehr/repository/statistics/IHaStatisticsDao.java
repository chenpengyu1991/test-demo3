package com.founder.rhip.ehr.repository.statistics;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of HaStatistics
 * 
 */
public interface IHaStatisticsDao extends IDao<HaStatistics,Long> {

	List<HaStatistics> getCommunityArchiveManagementList(Map<String, Object> paramMap);
	
	List<HaStatistics> getCdcArchiveManagementList(Map<String, Object> paramMap);
	
	List<HaStatistics> getAdminArchiveManagementList(Map<String, Object> paramMap);
	
	List<HaStatistics> getCommunityMajorCrowdList(Map<String, Object> paramMap);
	
	List<HaStatistics> getCdcMajorCrowdList(Map<String, Object> paramMap);
	
	List<HaStatistics> getAdminMajorCrowdList(Map<String, Object> paramMap);
	
	List<HaStatistics> getCdmList(Map<String, Object> paramMap);
	
	/**
	 * 根据机构CODE和日期查询记录数
	 * @param paramMap
	 * @return
	 */
	Integer getCountByDateAndOrgcode(Criteria cr);
	
	HaStatistics getEntityByDateAndOrgcode(Criteria cr);
	
	HaStatistics getQuickJob(Criteria criteria);

	List<HaStatistics> getTownDistribution(Map<String, Object> paramMap);
	
	List<HaStatistics> getCommunityDistribution(Criteria cr);

	List<String> getOrgCodes();
}