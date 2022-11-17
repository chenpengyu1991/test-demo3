package com.founder.rhip.ehr.service.report;

import java.util.List;
import java.util.Map;

public interface IRpVaccinationService {
	
	/**
	 * 保存机构接种疫苗统计
	 * @param dateStr
	 */
	void saveOrganizationVaccinationStatistics(String dateStr);
	
	/**
	 * 查询机构接种疫苗统计
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getOrganizaitonVaccinationMapList(Map<String, String> paramMap);

}
