package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.HbpManageMonthReport;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository("cdControlReportDao")
public class CdControlReportDaoImpl extends AbstractDao<PersonInfo, Long> implements ICdControlReportDao{
	
	@SuppressWarnings("unused")
	@Resource(name="queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<HbpManageMonthReport> getHbpManageMonthReport(String town, String center,String station, String mouth){
		String orgStatus = null;
		String orgCondition="";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		if (ObjectUtil.isNotEmpty(station)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND ORGAN_CODE=:station";
			sqlParameterSource.addValue("station", station);
		}else if (ObjectUtil.isNotEmpty(center)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND PARENT_CODE=:center";
			sqlParameterSource.addValue("center", center);
		}else if (ObjectUtil.isNotEmpty(town)) {
			orgStatus = "PARENT_CODE";
			orgCondition=" AND GB_CODE=:town";
			sqlParameterSource.addValue("town", town);
		}  else {
			orgStatus = "GB_CODE";
		}
		StringBuilder sql = new StringBuilder("SELECT NVL("+orgStatus+",'合计')AS ORGAN_CODE,");
		sql.append("SUM(CASE WHEN TO_CHAR(CREATE_DATE,'yyyy/mm')='"+mouth+"' THEN 1 ELSE 0 END )AS ADD_PATIENT,");
		sql.append("COUNT(*) AS PATIENT_COUNT,SUM(CASE WHEN HBP_CEREBROVASCULAR_FLAG IS NOT NULL AND HBP_CEREBROVASCULAR_FLAG !='4' OR HBP_HEART_FLAG IS NOT NULL AND HBP_HEART_FLAG!='4' OR HBP_VASCULAR_FLAG IS NOT NULL AND HBP_VASCULAR_FLAG !='3' THEN 1 ELSE 0 END)AS EVENT_TOTAL");
		sql.append(" FROM (SELECT * FROM V_DM_DISEASE_INFO LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON V_DM_DISEASE_INFO.CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE)WHERE HBP_FLAG='2' AND STATUS != '2' AND GENRE_CODE ='B2' ");
		sql.append(orgCondition);
		
		sql.append(" GROUP BY ROLLUP("+orgStatus+")");
		return this.getList(HbpManageMonthReport.class,sql.toString(),sqlParameterSource);
	}
	@Override
	public List<HbpManageMonthReport> followupCompletedWithinDate(String town, String center,String station, String mouth){
		String orgStatus = null;
		String orgCondition="";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		if (ObjectUtil.isNotEmpty(station)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND ORGAN_CODE=:station";
			sqlParameterSource.addValue("station", station);
		}else if (ObjectUtil.isNotEmpty(center)) {
			orgStatus = "ORGAN_CODE";
			orgCondition=" AND PARENT_CODE=:center";
			sqlParameterSource.addValue("center", center);
		}else if (ObjectUtil.isNotEmpty(town)) {
			orgStatus = "PARENT_CODE";
			orgCondition=" AND GB_CODE=:town";
			sqlParameterSource.addValue("town", town);
		}  else {
			orgStatus = "GB_CODE";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = format.parse(mouth);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.MONTH, -3);
		String threeMonths = format.format(calendar.getTime());
		calendar.add(Calendar.MONTH, -3);
		String sixMonths =format.format( calendar.getTime());
		calendar.add(Calendar.MONTH, -3);
		String nineMonths = format.format(calendar.getTime());
		calendar.add(Calendar.MONTH, -3);
		String twelveMonths = format.format(calendar.getTime());
		StringBuilder sql = new StringBuilder("SELECT NVL("+orgStatus+",'合计') AS ORGAN_CODE,");
		sql.append("SUM(CASE WHEN TO_CHAR(VISIT_DATE,'yyyy/mm')<='"+mouth+"' AND TO_CHAR(VISIT_DATE,'yyyy/mm')>'"+threeMonths+"' THEN 1 ELSE 0 END ) AS THREE_MONTHS_TOTAL,");
		sql.append("SUM(CASE WHEN TO_CHAR(VISIT_DATE,'yyyy/mm')<='"+mouth+"' AND TO_CHAR(VISIT_DATE,'yyyy/mm')>'"+sixMonths+"' THEN 1 ELSE 0 END ) AS SIX_MONTHS_TOTAL,");
		sql.append("SUM(CASE WHEN TO_CHAR(VISIT_DATE,'yyyy/mm')<='"+mouth+"' AND TO_CHAR(VISIT_DATE,'yyyy/mm')>'"+nineMonths+"' THEN 1 ELSE 0 END ) AS NINE_MONTHS_TOTAL,");
		sql.append("SUM(CASE WHEN TO_CHAR(VISIT_DATE,'yyyy/mm')<='"+mouth+"' AND TO_CHAR(VISIT_DATE,'yyyy/mm')>'"+twelveMonths+"' THEN 1 ELSE 0 END ) AS TWELVE_MONTHS_TOTAL");
		sql.append(" FROM (SELECT * FROM DM_HYPERTENSION_FOLLOWUP LEFT JOIN V_MDM_ORGANIZATION_NOSUB ON DM_HYPERTENSION_FOLLOWUP.CREATE_ORGAN_CODE=V_MDM_ORGANIZATION_NOSUB.ORGAN_CODE)");
	
		sql.append(" WHERE  GENRE_CODE ='B2' ");
		sql.append(orgCondition);
		
		sql.append(" GROUP BY ROLLUP("+orgStatus+")");
		return this.getList(HbpManageMonthReport.class,sql.toString(),sqlParameterSource);
	}
}
