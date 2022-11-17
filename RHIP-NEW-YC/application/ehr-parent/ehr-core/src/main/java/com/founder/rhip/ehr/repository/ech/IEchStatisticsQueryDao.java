package com.founder.rhip.ehr.repository.ech;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of EchIdentification
 * 
 */
public interface IEchStatisticsQueryDao {

	/**
	 * 健康管理-按站统计
	 *
	 * @param page
	 * @param year
	 * @param parentCode：中心编码
	 * @param organCode:站编码
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getStatisticsStationResult(String year,String parentCode,String organCode);
	
	/**
	 * 健康管理-按中心统计
	 *
	 * @param page
	 * @param year
	 * @param gbCode：镇编码
	 * @param parentCode :中心编码
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getStatisticsCentreResult(String year,String gbCode,String parentCode);	
	

	/**
	 * 综合管理-老年人保健-指标
	 *
	 * @param examYear:体检年份
	 * @param genreCode：机构类型
	 * @param gbCode：镇编码
	 * @param parentCode：中心编码
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getTargetData(Integer examYear,String genreCode,String gbCode,String parentCode);
	
	/**
	 * 综合管理-老年人保健-管理率
	 *
	 * @param examYear:体检年份
	 * @param genreCode：机构类型
	 * @param gbCode：镇编码
	 * @param parentCode：中心编码
	 * @param parentCode：站编码
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getRateData(Integer examYear,String genreCode,String gbCode,String parentCode,String organCode);
}