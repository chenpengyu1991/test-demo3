package com.founder.rhip.ehr.service.statistics;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.basic.EhrDocLevel;
import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.rhip.mdm.entity.Organization;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-1-8
 * Time: 下午1:47
 * To change this template use File | Settings | File Templates.
 */
public interface IStatisticsService {
	
	/**
	 * 社区档案管理统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getCommunityArchiveManagementList(Map<String, Object> paramMap);
	
	/**
	 * 中心档案管理统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getCdcArchiveManagementList(Map<String, Object> paramMap);
	
	/**
	 * 管理员档案管理统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getAdminArchiveManagementList(Map<String, Object> paramMap);
	
	/**
	 * 社区重点人群统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getCommunityMajorCrowdList(Map<String, Object> paramMap);
	
	/**
	 * 中心重点人群统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getCdcMajorCrowdList(Map<String, Object> paramMap);
	
	/**
	 * 管理员重点人群统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getAdminMajorCrowdList(Map<String, Object> paramMap);
	
	/**
	 * 慢病管理统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getCdmList(Map<String, Object> paramMap);
	
	/**
	 * 档案首页-快捷办公
	 * @param paramMap
	 * @return
	 */
	HaStatistics getQuickJob(Criteria criteria);
	
	/**
	 * 同步统计数据
	 * @param org 机构实体（Organization）
	 * @param type 需要同步的列（StatisticsUtil字典中定义）
	 * @param operation 统计数据加、减操作符（StatisticsUtil字典中定义）
	 * @return true：同步成功 false：同步失败
	 */
	boolean syncStatisticsData(Organization org, String column, String operation);
	
	/**
	 * 镇区分布统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getTownDistributionList(Map<String, Object> paramMap);
	
	/**
	 * 社区分布统计
	 * @param paramMap
	 * @return
	 */
	List<HaStatistics> getCommunityDistributionList(Criteria cr);

	/**
	 * 镇区分布统计
	 * @return
	 */
	List<HaStatistics> getHaStatisticsByTown();

	List<HaStatistics> getHaStatisticsByCenter(String centerCode);

	/** 
	* @Title: getArchiveManagementList 
	* @Description: 查询所有镇的统计数据
	* @param @param startDate
	* @param @param endDate
	* @return void
	* @throws 
	*/
	void getArchiveManagementList(Date startDate, Date endDate);

	/** 
	* @Title: getArchiveManagementList 
	* @Description: 查询统计数据
	* @param @param startDate
	* @param @param endDate
	* @param @param code 中心或者站的编码
	* @param @param type 0为中心，1为社区站
	* @return void
	* @throws 
	*/
	Map<String,Long> getArchiveManagementList(String dateType,Organization organization,Integer type);
	
	/**
	 * 统计总档案数
	 * @param criteria
	 * @return
	 */
	Long getAllCreatePerson(Criteria criteria);

	/**
	 * 统计单个卫管区域下所有中心的档案数
	 * @param organizations
	 * @return
	 */
	public List<HaStatistics> getHaStatisticsEveryTown(List<Organization> organizations);

	/**
	 * 同步工作量统计数据
	 * @param entity 实体（EhrDocLevel）
	 */
	boolean syncWorkStatisticsData(EhrDocLevel entity);
}
