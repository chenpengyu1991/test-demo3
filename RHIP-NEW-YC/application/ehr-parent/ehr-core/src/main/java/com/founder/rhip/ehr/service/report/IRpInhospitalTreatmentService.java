package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpInhospitalTreatmentService {
	/**
	 * 保存18种病住院治疗监测统计
	 * @param dateStr 日期格式(yyyy,N)年份加季度用逗号分开，如：2014,1为2014年第1季度
	 */
	void saveInhospitalTreatmentStatistics(String dateStr);
	
	/**
	 * 获取住院治疗监测统计信息
	 * @param paramMap 查询参数
	 * @return
	 */
	List<Map<String, Object>> getHospitalTreatmentMapList(Map<String, String> paramMap);

}
