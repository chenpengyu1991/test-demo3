package com.founder.rhip.ehr.repository.statistics;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.TumorMonthSeasonReport;

/**
 * 慢病和肿瘤月报和季报
 * @author liuk
 * 
 */
public interface ICdMonthSeasonStatisticsDao extends IDao<PersonInfo, Long> {
	List<Map<String, Object>> getCdMonthReport(String type,String gbCode, String orgCode, String month, String year);

	List<Map<String, Object>> getTumorAllIcdCodeAndType();

	List<Map<String, Object>> getCdSeasonReport(String type,String gbCode,  String orgCode, String season, String year);

	TumorMonthSeasonReport getTumorMonthReport(String type,String gbCode,  String orgCode, String month, String year);

	TumorMonthSeasonReport getTumorSeasonReport(String type, String gbCode, String orgCode, String season, String year);
}
