package com.founder.rhip.ehr.repository.ep;

import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.ep.IodineNutritionMonitor;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO implement of IodineNutritionMonitor
 * 
 */
@Repository("iodineNutritionMonitorDao")
public class IodineNutritionMonitorDaoImpl extends AbstractDao<IodineNutritionMonitor, Long> implements IIodineNutritionMonitorDao {

	@Resource(name = "phbdbJDBCTemplate")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
	public String getMax(Long samplingId) {
		final String sql = "SELECT MAX(SURVEY_NO) FROM EP_IODINE_NUTRITION_MONITOR WHERE SAMPLING_ID=?";
		String surveyNo = simpleJdbcTemplate.queryForObject(sql, String.class, samplingId);
		return surveyNo;
	}
	
	public IodineNutritionMonitor getCurrentYearDetailBySurveyNo(String surveyNo) {
		final String sql = "SELECT * FROM EP_IODINE_NUTRITION_MONITOR WHERE SURVEY_NO=:surveyNo AND TO_CHAR(INVESTIGATE_TIME, 'YYYY')=:year AND DELETE_FLAG=0";
		Criteria criteria = new Criteria("surveyNo", surveyNo);
		criteria.add("year", DateUtil.getCurrentYear());
		IodineNutritionMonitor monitor = get(sql, criteria);
		return monitor;
	}
}