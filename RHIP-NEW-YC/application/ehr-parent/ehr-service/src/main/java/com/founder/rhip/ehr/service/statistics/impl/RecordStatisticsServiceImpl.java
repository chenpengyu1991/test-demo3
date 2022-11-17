package com.founder.rhip.ehr.service.statistics.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.rhip.ehr.repository.statistics.IHaStatisticsDao;
import com.founder.rhip.ehr.repository.statistics.IRecordStatisticsDao;
import com.founder.rhip.ehr.service.statistics.IRecordStatisticsService;
import com.founder.rhip.ehr.service.statistics.RecordStatistics;
import com.founder.rhip.ehr.service.statistics.StarStatistics;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;

/**
 * 档案统计
 * 
 * @author liuk
 * 
 */
@Service("recordStatisticsService")
public class RecordStatisticsServiceImpl implements IRecordStatisticsService {
	@Resource(name = "recordStatisticsDao")
	private IRecordStatisticsDao recordStatisticsDao;

	@Resource(name = "haStatisticsDao")
	private IHaStatisticsDao haStatisticsDao;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;  

	@Override
	public List<StarStatistics> getStarStatisticsData(Criteria criteria) {
		List<StarStatistics> data = recordStatisticsDao.getStarStatisticsData(criteria);
		return calStatisticsResult(data);
	}

	@Override
	public List<RecordStatistics> getRecordStatisticsData(Criteria criteria) {
		List<RecordStatistics> data = recordStatisticsDao.getRecordStatisticsData(criteria);
		return calRecordStatisticsResult(data);
	}

	/**
	 * 档案统计结果计算
	 * 
	 * @param data
	 * @return
	 */
	private List<RecordStatistics> calRecordStatisticsResult(List<RecordStatistics> recordStatisticss) {
		Long personCount = 0L;
		Long householdPersonCount = 0L;
		Long unhouseholdPersonCount = 0L;

		Long recordCount = 0L;
		Long householdRecordCount = 0L;
		Long unhouseholdRecordCount = 0L;

		for (RecordStatistics recordStatistics : recordStatisticss) {
			recordStatistics.setTitle(getTitle(recordStatistics.getCode()));
			personCount += recordStatistics.getPersonCount();
			householdPersonCount += recordStatistics.getHouseholdPersonCount();
			unhouseholdPersonCount += recordStatistics.getUnhouseholdPersonCount();

			recordCount += recordStatistics.getRecordCount();
			householdRecordCount += recordStatistics.getHouseholdRecordCount();
			unhouseholdRecordCount += recordStatistics.getUnhouseholdRecordCount();
		}

		RecordStatistics total = new RecordStatistics();
		total.setPersonCount(personCount);
		total.setHouseholdPersonCount(householdPersonCount);
		total.setUnhouseholdPersonCount(unhouseholdPersonCount);

		total.setRecordCount(recordCount);
		total.setHouseholdRecordCount(householdRecordCount);
		total.setUnhouseholdRecordCount(unhouseholdRecordCount);

		/* 计算合计的档率 */
		total.setRecordOccupancy(divide(recordCount, personCount));
		total.setHouseholdRecordOccupancy(divide(householdRecordCount, householdPersonCount));
		total.setUnhouseholdPecordOccupancy(divide(unhouseholdRecordCount, unhouseholdPersonCount));

		total.setTitle(EHRConstants.STATISTICS_TOTAL_CHS);

		recordStatisticss.add(total);
		return recordStatisticss;
	}

	/**
	 * 星级统计结果计算
	 * 
	 * @param data
	 * @return
	 */
	private List<StarStatistics> calStatisticsResult(List<StarStatistics> starStatisticss) {
		/* 总计行 */
		StarStatistics total = new StarStatistics();
		Long personCount = 0L;
		Long recordCount = 0L;
		Long oneStarRecordCount = 0L;
		Long twoStarRecordCount = 0L;
		Long threeStarRecordCount = 0L;
		Long twoAboveStarRecordCount = 0L;
		Long recordComCount = 0L;
		Long oneStarRecordComCount = 0L;
		Long twoStarRecordComCount = 0L;
		Long threeStarRecordComCount = 0L;
		Long twoAboveStarRecordComCount = 0L;

		for (StarStatistics starStatistics : starStatisticss) {
			starStatistics.setTitle(getTitle(starStatistics.getCode()));
			personCount += starStatistics.getPersonCount();
			recordCount += starStatistics.getRecordCount();
			oneStarRecordCount += starStatistics.getOneStarRecordCount();
			threeStarRecordCount += starStatistics.getThreeStarRecordCount();
			twoStarRecordCount += starStatistics.getTwoStarRecordCount();
			twoAboveStarRecordCount += starStatistics.getTwoAboveStarRecordCount();
			recordComCount += starStatistics.getRecordComCount();
			oneStarRecordComCount += starStatistics.getOneStarRecordComCount();
			twoStarRecordComCount += starStatistics.getTwoStarRecordComCount();
			threeStarRecordComCount += starStatistics.getThreeStarRecordComCount();
			twoAboveStarRecordComCount += starStatistics.getTwoAboveStarRecordComCount();
		}

		total.setPersonCount(personCount);
		total.setRecordCount(recordCount);
		total.setOneStarRecordCount(oneStarRecordCount);
		total.setTwoStarRecordCount(twoStarRecordCount);
		total.setThreeStarRecordCount(threeStarRecordCount);
		total.setTwoAboveStarRecordCount(twoAboveStarRecordCount);

		total.setRecordComCount(recordComCount);
		total.setOneStarRecordComCount(oneStarRecordComCount);
		total.setTwoAboveStarRecordComCount(twoAboveStarRecordComCount);
		total.setThreeStarRecordComCount(threeStarRecordComCount);
		total.setTwoAboveStarRecordComCount(twoAboveStarRecordComCount);

		/* 建档率 */
		total.setRecordOccupancy(divide(recordCount, personCount));
		total.setOneStarRecordOccupancy(divide(oneStarRecordCount, personCount));
		total.setTwoStarRecordOccupancy(divide(twoStarRecordCount, personCount));
		total.setThreeStarRecordOccupancy(divide(threeStarRecordCount, personCount));
		total.setTwoAboveStarRecordOccupancy(divide(twoAboveStarRecordCount, personCount));
		/* 完整率 */
		total.setRecordIntegrity(divide(oneStarRecordComCount, recordCount));
		total.setOneStarRecordIntegrity(divide(oneStarRecordComCount, oneStarRecordCount));
		total.setTwoStarRecordIntegrity(divide(twoStarRecordComCount, twoStarRecordCount));
		total.setThreeStarRecordIntegrity(divide(threeStarRecordComCount, threeStarRecordCount));
		total.setTwoAboveStarRecordIntegrity(divide(twoAboveStarRecordComCount, twoAboveStarRecordCount));
		total.setTitle(EHRConstants.STATISTICS_TOTAL_CHS);
		starStatisticss.add(total);
		return starStatisticss;
	}

	private String getTitle(String code) {
		DicItem titleItem=dictionaryApp.queryDicItem(EHRConstants.CS_TOWN_DICT_TYPE, code);
		if (null!=titleItem) {
			return titleItem.getItemName();
		}else{
			return organizationApp.queryOrganName(code);
		}
	}

	/**
	 * 相除
	 * 
	 * @param recordCount
	 * @param personCount
	 * @return
	 */
	private BigDecimal divide(Long recordCount, Long personCount) {
		if (null == recordCount || null == personCount || 0 == recordCount || 0 == personCount) {
			return BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		}
		return new BigDecimal(recordCount).divide(new BigDecimal(personCount), EHRConstants.STATISTICS_PRECISION, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public List<HaStatistics> getHaStatistics(Criteria criteria) {
		return haStatisticsDao.getList(criteria);
	}

}
