package com.founder.rhip.ehr.service.report;

import java.util.Map;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IRpPaVaccinationService {
	/**
	 * 保存医生接种工作量
	 * @param dateStr
	 */
	void savePaVaccinationStatistics(String dateStr);
	
	/**
	 * 查询医生工作量
	 * @param paramMap
	 * @param page
	 * @return
	 */
	PageList<Map<String, Object>> getPaVaccinationPageList(Map<String, String> paramMap, Page page);
}
