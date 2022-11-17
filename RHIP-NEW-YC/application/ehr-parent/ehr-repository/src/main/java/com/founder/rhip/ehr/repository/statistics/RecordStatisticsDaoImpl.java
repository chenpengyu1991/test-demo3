package com.founder.rhip.ehr.repository.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.statistics.RecordStatistics;
import com.founder.rhip.ehr.service.statistics.StarStatistics;

/**
 * 档案和星级统计
 * @author liuk
 * 
 */
@Repository("recordStatisticsDao")
public class RecordStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements IRecordStatisticsDao {

	@SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<StarStatistics> getStarStatisticsData(Criteria criteria) {
		String sql = buildStarSqlAndParam(criteria);
		List<StarStatistics> starStatisticss = new ArrayList<>();
		List<Map<String, Object>> data = this.getMapList(sql, criteria);
		for (Map<String, Object> map : data) {
			StarStatistics starStatistics = new StarStatistics();
			convertToStarStatistics(starStatistics, map);
			starStatisticss.add(starStatistics);
		}
		return starStatisticss;
	}
	
	
	@Override
	public List<RecordStatistics> getRecordStatisticsData(Criteria criteria) {
		String sql = buildRecordSqlAndParam(criteria);
		List<Map<String, Object>> data = this.getMapList(sql, criteria);
		List<RecordStatistics> recordStatisticss = new ArrayList<>();
		for (Map<String, Object> map : data) {
			RecordStatistics recordStatistics = new RecordStatistics();
			convertToRecordStatistics(recordStatistics, map);
			recordStatisticss.add(recordStatistics);
		}
		return recordStatisticss;
	}

	/**
	 * 根据条件组合档案统计sql
	 * 
	 * @param criteria
	 * @return
	 */
	private String buildRecordSqlAndParam(Criteria criteria) {
		Assert.notNull(criteria, "参数不能为空");
		String sql = null;
		StringBuilder builder = new StringBuilder();

		if (criteria.contains("orgCode")) {
			sql = RecordStatisticsSql.ORG_RECORD_STATIC_SQL;
		} else {
			sql = RecordStatisticsSql.RECORD_STATIC_SQL_CENTERE;
		}

		if (criteria.contains("endDate")) {
			builder.append(" and INPUT_DATE<=:endDate ");
		}
		if (criteria.contains("startDate")) {
			builder.append(" and INPUT_DATE>=:startDate ");
		}
		if (criteria.contains("birthDayStart")) {
			builder.append(" and BIRTHDAY>=:birthDayStart ");
		}
		if (criteria.contains("birthDayEnd")) {
			builder.append(" and BIRTHDAY<=:birthDayEnd ");
		}
		if (criteria.contains("gender")) {
			builder.append(" and GENDER=:gender ");
		}

		if (!criteria.contains("countYear")) {
			criteria.add("countYear", String.valueOf(DateUtil.getCurrentYear()));
		}
		return String.format(sql, builder.toString());
	}

	/**
	 * 根据条件组合星级统计sql
	 * 
	 * @param criteria
	 * @return
	 */
	private String buildStarSqlAndParam(Criteria criteria) {
		Assert.notNull(criteria, "参数不能为空");
		String sql = null;
		if (criteria.contains("orgCode")) {
			sql = RecordStatisticsSql.ORG_STAR_STATISTICS_SQL;
		} else {
			sql = RecordStatisticsSql.ADMIN_STAR_DATA_SQL_CENTER;
		}
		StringBuilder condition = new StringBuilder();	// 常住类型
		String personCountSumString = "NVL( SUM (HOUSEHOLD_NUM) , 0)+ NVL(SUM (UN_HOUSE_HOLD_NUM), 0) ";	// 常住类型不同,人数统计方式同
		Object houseType = criteria.get("houseType");
		if (null != houseType) {
			if (EHRConstants.UN_HOUSE_HOLDER.equals(houseType)) {
				/* 非户籍 */
				condition.append("and HOUSEHOLD_TYPE=:houseType");
				personCountSumString = "\"SUM\" (UN_HOUSE_HOLD_NUM)";
			} else if (EHRConstants.HOUSE_HOLDER.equals(houseType)) {
				/* 户籍 */
				condition.append("and HOUSEHOLD_TYPE!=:houseType");
				criteria.remove("houseType");
				criteria.add("houseType", EHRConstants.UN_HOUSE_HOLDER);// 只要不是非户籍,都是认为是户籍类型
				personCountSumString = "\"SUM\" (HOUSEHOLD_NUM) ";
			}
		}

		if (criteria.contains("startDate")) {
			condition.append(" and INPUT_DATE>=:startDate ");
		}

		if (criteria.contains("endDate")) {
			condition.append(" and INPUT_DATE<=:endDate ");
		}
		if (!criteria.contains("countYear")) {
			criteria.add("countYear", String.valueOf(DateUtil.getCurrentYear()));
		}
		return String.format(sql, personCountSumString, condition.toString());
	}

	/**
	 * @param recordStatistics
	 * @param map
	 */
	private void convertToRecordStatistics(RecordStatistics recordStatistics, Map<String, Object> map) {
		recordStatistics.setCode(getString(map, "CODE"));
		String title = getString(map, "TITLE");
		/*人数*/
		recordStatistics.setPersonCount(getLong(map, "PERSON_COUNT"));
		recordStatistics.setHouseholdPersonCount(getLong(map, "HOUSEHOLD_PERSON_COUNT"));
		recordStatistics.setUnhouseholdPersonCount(getLong(map, "UNHOUSEHOLD_PERSON_COUNT"));
		/*建档率*/
		recordStatistics.setRecordOccupancy(getBigDecimal(map, "RECORD_OCCUPANCY"));
		recordStatistics.setHouseholdRecordOccupancy(getBigDecimal(map, "HOUSEHOLD_RECORD_OCCUPANCY"));
		recordStatistics.setUnhouseholdPecordOccupancy(getBigDecimal(map, "UNHOUSEHOLD_RECORD_OCCUPANCY"));
		/*档案数*/
		recordStatistics.setRecordCount(getLong(map, "RECORD_COUNT"));
		recordStatistics.setHouseholdRecordCount(getLong(map, "HOUSEHOLD_RECORD_COUNT"));
		recordStatistics.setUnhouseholdRecordCount(getLong(map, "UNHOUSEHOLD_RECORD_COUNT"));
	}

	/**
	 * @param starStatistics
	 * @param map
	 */
	private void convertToStarStatistics(StarStatistics starStatistics, Map<String, Object> map) {
		starStatistics.setPersonCount(getLong(map, "PERSON_COUNT"));
		starStatistics.setCode(getString(map, "CODE"));
		String title = getString(map, "TITLE");
		/* 档案数量 */
		starStatistics.setRecordCount(getLong(map, "RECORD_COUNT"));
		starStatistics.setOneStarRecordCount(getLong(map, "ONE_STAR_RECORD_COUNT"));
		starStatistics.setTwoStarRecordCount(getLong(map, "TWO_STAR_RECORD_COUNT"));
		starStatistics.setThreeStarRecordCount(getLong(map, "THREE_STAR_RECORD_COUNT"));

		/*建档率*/
		starStatistics.setRecordOccupancy(getBigDecimal(map, "RECORD_OCCUPANCY"));
		starStatistics.setOneStarRecordOccupancy(getBigDecimal(map, "ONE_STAR_RECORD_OCCUPANCY"));
		starStatistics.setTwoStarRecordOccupancy(getBigDecimal(map, "TWO_STAR_RECORD_OCCUPANCY"));
		starStatistics.setThreeStarRecordOccupancy(getBigDecimal(map, "THREE_STAR_RECORD_OCCUPANCY"));

		 /*完整数*/
		starStatistics.setRecordComCount(getLong(map, "STAR_RECORD_COM_COUNT"));
		starStatistics.setOneStarRecordComCount(getLong(map, "ONE_STAR_RECORD_COM_COUNT"));
		starStatistics.setTwoStarRecordComCount(getLong(map, "TWO_STAR_RECORD_COM_COUNT"));
		starStatistics.setThreeStarRecordComCount(getLong(map, "THREE_STAR_RECORD_COM_COUNT"));
		starStatistics.setTwoAboveStarRecordComCount(getLong(map, "TWOA_STAR_RECORD_COM_COUNT"));

		 /*完整度*/
		starStatistics.setRecordIntegrity(getBigDecimal(map, "RECORD_INTEGRITY"));// TODO
		starStatistics.setOneStarRecordIntegrity(getBigDecimal(map, "ONE_STAR_RECORD_INTEGRITY"));
		starStatistics.setTwoStarRecordIntegrity(getBigDecimal(map, "TWO_STAR_RECORD_INTEGRITY"));
		starStatistics.setThreeStarRecordIntegrity(getBigDecimal(map, "THREE_STAR_RECORD_INTEGRITY"));

		/*二星级以上*/
		starStatistics.setTwoAboveStarRecordCount(getLong(map, "TWOA_STAR_RECORD_COUNT"));
		starStatistics.setTwoAboveStarRecordIntegrity(getBigDecimal(map, "TWOA_STAR_RECORD_INTEGRITY"));// TODO
		starStatistics.setTwoAboveStarRecordOccupancy(getBigDecimal(map, "TWOA_STAR_RECORD_OCCUPANCY"));

	}
	

	private BigDecimal getBigDecimal(Map<String, Object> map, String key) {
		Object val = map.get(key);
		BigDecimal value = null;
		if (null == val) {
			value = BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		} else {
			value = new BigDecimal(val.toString());
		}
		value = value.setScale(EHRConstants.STATISTICS_PRECISION, BigDecimal.ROUND_HALF_DOWN);
		return value;
	}

	private Long getLong(Map<String, Object> map, String key) {
		Object val = map.get(key);
		if (null == val) {
			return 0L;
		}
		return Long.parseLong(val.toString());
	}

	private String getString(Map<String, Object> map, String key) {
		Object val = map.get(key);
		if (null == val) {
			return "";
		}
		return val.toString();
	}

}
