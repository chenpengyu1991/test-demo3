package com.founder.rhip.ehr.service.report;

import com.founder.rhip.ehr.entity.report.RpDiseases;

import java.util.List;
import java.util.Map;

public interface IRpDiseasesService {
	
	/**
	 * 统计指定日期的A类传染病、和B类传染病将数据插入表RpDiseases
	 * dateStr若为空则去前一天的日期
	 * @param dateStr 格式"yyyy/MM/dd"
	 */
	void insertDiseasesStatistics(String dateStr);

	/**
	 * 查询诊断记录中统计传染病
	 * @param paramMap
	 * @return
	 */
	public List<RpDiseases> getDiseases(Map<String, String> paramMap);

	/**
	 * 1年内按月统计A、B类型传染病
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap);
	
	/**
	 * 查询指定机构疾病数量排名
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getDiseaseMapList(Map<String, String> paramMap);

}
