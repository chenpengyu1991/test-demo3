package com.founder.rhip.ihm.service;

import javax.annotation.Resource;

import com.founder.rhip.ehr.repository.ihm.IEhrPopulationStatisticsDao;
import com.founder.rhip.ehr.repository.ihm.IEhrStarStatisticsDao;
import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.ihm.IEhrRecordStatisticsDao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuk
 * @since 2014/5/21 16:11
 */
@Service("ehrRecordStatisticsService")
public class EhrRecordStatisticsServiceImpl implements IEhrRecordStatisticsService {
	@Resource(name = "ehrRecordStatisticsDao")
	private IEhrRecordStatisticsDao ehrRecordStatisticsDao;

	@Resource(name = "ehrStarStatisticsDao")
	private IEhrStarStatisticsDao ehrStarStatisticsDao;

	@Resource(name = "ehrPopulationStatisticsDao")
	private IEhrPopulationStatisticsDao ehrPopulationStatisticsDao;

	@Override
	public List<Map<String, Object>> getRecordStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender) {
		return ehrRecordStatisticsDao.getRecordStatisticsData(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, ageDateBegin, ageDateEnd, gender);
	}

	@Override
	public List<Map<String, Object>> getStarStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType) {
		return ehrStarStatisticsDao.getStarStatisticsData(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, householdType);
	}

	@Override
	public List<Map<String, Object>> getPopulationStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType, String gender) {
		return ehrPopulationStatisticsDao.getPopulationStatisticsData(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate, householdType, gender);
	}

    public Map<String, Object> getIndexChartData(){
        return ehrPopulationStatisticsDao.getIndexChartData();
    }

}
