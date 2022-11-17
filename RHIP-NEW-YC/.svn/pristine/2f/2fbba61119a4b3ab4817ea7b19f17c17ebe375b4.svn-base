package com.founder.rhip.ehr.service.statistics;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 统计慢病信息
 * @author ggf
 *
 */
public interface IIdmStatisticsService {
	
	/**
	 * 卫生局查看
	 * @return
	 */
	public List<Map<String, Long>> getStaticticsByAdmin(Date startDate, Date endDate,String gbCode);
	
	/**
	 * 中心查看
	 * @return
	 */
	public List<Map<String, Long>> getStaticticsByCenter(String centerOrganCode, Date startDate, Date endDate);
	
	/**
	 * 站查看
	 * @return
	 */
	public List<Map<String, Long>> getStaticticsByStation(String stationOrganCode, Date startDate, Date endDate);
}
