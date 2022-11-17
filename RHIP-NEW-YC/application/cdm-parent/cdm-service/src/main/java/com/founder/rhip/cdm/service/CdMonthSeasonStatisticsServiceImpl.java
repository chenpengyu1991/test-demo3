package com.founder.rhip.cdm.service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.statistics.ICdMonthSeasonStatisticsDao;
import com.founder.rhip.ehr.statisticsdto.TumorMonthSeasonReport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 慢病,肿瘤季报和月报
 * @author liuk
 *
 */
@Service("cdMonthSeasonStatisticsService")
public class CdMonthSeasonStatisticsServiceImpl extends AbstractService implements ICdMonthSeasonStatisticsService {


	@Resource(name = "cdMonthSeasonStatisticsDao")
	private ICdMonthSeasonStatisticsDao cdMonthSeasonStatisticsDao;
	

	@Override
	public List<Map<String, Object>> getCdMonthReport(String type, String gbCode, String orgCode, String month, String year) {
		List<Map<String, Object>> reports = cdMonthSeasonStatisticsDao.getCdMonthReport(type,gbCode, orgCode, month, year);
		return reports;
	}

	@Override
	public List<Map<String, Object>> getCdSeasonReport(String type,String gbCode,  String orgCode, String season, String year) {
		List<Map<String, Object>> reports = cdMonthSeasonStatisticsDao.getCdSeasonReport( type,gbCode, orgCode, season, year);
		return reports;
	}
	
	@Override
	public TumorMonthSeasonReport getTumorMonthReport(String type, String gbCode, String orgCode, String month, String year) {
		
		TumorMonthSeasonReport reports = cdMonthSeasonStatisticsDao.getTumorMonthReport(type,gbCode, orgCode, month, year);
		return reports;
	}

	@Override
	public TumorMonthSeasonReport getTumorSeasonReport(String type, String gbCode, String orgCode, String season, String year) {
		TumorMonthSeasonReport reports = cdMonthSeasonStatisticsDao.getTumorSeasonReport( type,gbCode, orgCode, season, year);
		return reports;
	}


}
