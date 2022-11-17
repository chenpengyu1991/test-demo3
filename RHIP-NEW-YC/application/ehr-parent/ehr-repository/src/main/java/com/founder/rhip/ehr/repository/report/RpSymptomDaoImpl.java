package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpSymptom;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RpSymptom
 * 
 */
@Repository("rpSymptomDao")
public class RpSymptomDaoImpl extends AbstractDao<RpSymptom, Long> implements IRpSymptomDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,center_code,*/

	private static final String SYMPTOM_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(FEVER_NUM,0))	FEVER_NUM,"
			+ " sum(NVL(SYSTEMIC_PAIN_NUM,0))	SYSTEMIC_PAIN_NUM,"
			+ " sum(NVL(DISCOMFORT_FATIGUE_NUM,0))	DISCOMFORT_FATIGUE_NUM,"
			+ " sum(NVL(ENLARGED_LYMPH_NUM,0))	ENLARGED_LYMPH_NUM,"
			+ " sum(NVL(MOUTH_BREATHING_NUM,0))	MOUTH_BREATHING_NUM,"
			+ " sum(NVL(SNEEZE_NUM,0))	SNEEZE_NUM,"
			+ " sum(NVL(SORE_THROAT_NUM,0))	SORE_THROAT_NUM,"
			+ " sum(NVL(COUGH_NUM,0))	COUGH_NUM,"
			+ " sum(NVL(ABNORMAL_SPUTUM_NUM,0))	ABNORMAL_SPUTUM_NUM,"
			+ " sum(NVL(BREATHING_CHEST_PAIN_NUM,0))	BREATHING_CHEST_PAIN_NUM,"
			+ " sum(NVL(DYSPNEA_NUM,0))	DYSPNEA_NUM,"
			+ " sum(NVL(NAUSEA_VOMITING_NUM,0))	NAUSEA_VOMITING_NUM,"
			+ " sum(NVL(ABDOMINAL_PAIN_NUM,0))	ABDOMINAL_PAIN_NUM,"
			+ " sum(NVL(DIARRHEA_NUM,0))	DIARRHEA_NUM,"
			+ " sum(NVL(CONSTIPATION_NUM,0))	CONSTIPATION_NUM,"
			+ " sum(NVL(FLATULENCE_NUM,0))	FLATULENCE_NUM,"
			+ " sum(NVL(APPETITE_LACK_NUM,0))	APPETITE_LACK_NUM,"
			+ " sum(NVL(RASH_MACULA_NUM,0))	RASH_MACULA_NUM,"
			+ " sum(NVL(POPULAR_URTICARIA_NUM,0))	POPULAR_URTICARIA_NUM,"
			+ " sum(NVL(URTICARIAL_NUM,0))	URTICARIAL_NUM,"
			+ " sum(NVL(ERYTHEMA_MULTIFORME_NUM,0))	ERYTHEMA_MULTIFORME_NUM,"
			+ " sum(NVL(SPONTANEOUS_STASIS_NUM,0))	SPONTANEOUS_STASIS_NUM,"
			+ " sum(NVL(PURPURA_NUM,0))	PURPURA_NUM,"
			+ " sum(NVL(WATER_HERPES_NUM,0))	WATER_HERPES_NUM,"
			+ " sum(NVL(HEMATEMESIS_NUM,0))	HEMATEMESIS_NUM,"
			+ " sum(NVL(NASAL_BLEEDING_NUM,0))	NASAL_BLEEDING_NUM,"
			+ " sum(NVL(HEMOPTYSIS_NUM,0))	HEMOPTYSIS_NUM,"
			+ " sum(NVL(HEMATURIA_NUM,0))	HEMATURIA_NUM,"
			+ " sum(NVL(STOMACH_BLOOD_NUM,0))	STOMACH_BLOOD_NUM,"
			+ " sum(NVL(FECAL_OCCULT_BLOOD_NUM,0))	FECAL_OCCULT_BLOOD_NUM,"
			+ " sum(NVL(VAGINAL_BLEEDING_NUM,0))	VAGINAL_BLEEDING_NUM,"
			+ " sum(NVL(HEADACHE_NUM,0))	HEADACHE_NUM,"
			+ " sum(NVL(DIZZINESS_VERTIGO_NUM,0))	DIZZINESS_VERTIGO_NUM,"
			+ " sum(NVL(COMA_NUM,0))	COMA_NUM,"
			+ " sum(NVL(FEBRILE_CONVULSION_NUM,0))	FEBRILE_CONVULSION_NUM,"
			+ " sum(NVL(TREMOR_NUM,0))	TREMOR_NUM,"
			+ " sum(NVL(TETANY_NUM,0))	TETANY_NUM,"
			+ " sum(NVL(ATAXIA_NUM,0))	ATAXIA_NUM,"
			+ " sum(NVL(ANOMALOUS_REFLECTION_NUM,0))	ANOMALOUS_REFLECTION_NUM,"
			+ " sum(NVL(CRAMPS_SPASMS_NUM,0))	CRAMPS_SPASMS_NUM,"
			+ " sum(NVL(BLURRED_VISION_NUM,0))	BLURRED_VISION_NUM,"
			+ " sum(NVL(DIPLOPIA_NUM,0))	DIPLOPIA_NUM,"
			+ " sum(NVL(DYSPHONIA_NUM,0))	DYSPHONIA_NUM,"
			+ " sum(NVL(SPEECH_DISORDERS_NUM,0))	SPEECH_DISORDERS_NUM,"
			+ " sum(NVL(DYSPHAGIA_NUM,0))	DYSPHAGIA_NUM,"
			+ " sum(NVL(DRY_MOUTH_NUM,0))	DRY_MOUTH_NUM,"
			+ " sum(NVL(MYASTHENIA_GRAVIS_NUM,0))	MYASTHENIA_GRAVIS_NUM,"
			+ " sum(NVL(NO_URINE_OLIGURIA_NUM,0))	NO_URINE_OLIGURIA_NUM,"
			+ " sum(NVL(HYPERHIDROSIS_NUM,0))	HYPERHIDROSIS_NUM,"
			+ " sum(NVL(SKIN_REDNESS_NUM,0))	SKIN_REDNESS_NUM,"
			+ " sum(NVL(WAIST_PAIN_NUM,0))	WAIST_PAIN_NUM,"
			+ " sum(NVL(EYE_PAIN_NUM,0))	EYE_PAIN_NUM,"
			+ " sum(NVL(CONJUNCTIVA_BLOOD_NUM,0))	CONJUNCTIVA_BLOOD_NUM"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.FEVER_NUM, rp.SYSTEMIC_PAIN_NUM, rp.DISCOMFORT_FATIGUE_NUM, rp.ENLARGED_LYMPH_NUM, rp.MOUTH_BREATHING_NUM, rp.SNEEZE_NUM, rp.SORE_THROAT_NUM, rp.COUGH_NUM, rp.ABNORMAL_SPUTUM_NUM, rp.BREATHING_CHEST_PAIN_NUM, rp.DYSPNEA_NUM, rp.NAUSEA_VOMITING_NUM, rp.ABDOMINAL_PAIN_NUM, rp.DIARRHEA_NUM, rp.CONSTIPATION_NUM, rp.FLATULENCE_NUM, rp.APPETITE_LACK_NUM, rp.RASH_MACULA_NUM, rp.POPULAR_URTICARIA_NUM, rp.URTICARIAL_NUM, rp.ERYTHEMA_MULTIFORME_NUM, rp.SPONTANEOUS_STASIS_NUM, rp.PURPURA_NUM, rp.WATER_HERPES_NUM, rp.HEMATEMESIS_NUM, rp.NASAL_BLEEDING_NUM, rp.HEMOPTYSIS_NUM, rp.HEMATURIA_NUM, rp.STOMACH_BLOOD_NUM, rp.FECAL_OCCULT_BLOOD_NUM, rp.VAGINAL_BLEEDING_NUM, rp.HEADACHE_NUM, rp.DIZZINESS_VERTIGO_NUM, rp.COMA_NUM, rp.FEBRILE_CONVULSION_NUM, rp.TREMOR_NUM, rp.TETANY_NUM, rp.ATAXIA_NUM, rp.ANOMALOUS_REFLECTION_NUM, rp.CRAMPS_SPASMS_NUM, rp.BLURRED_VISION_NUM, rp.DIPLOPIA_NUM, rp.DYSPHONIA_NUM, rp.SPEECH_DISORDERS_NUM, rp.DYSPHAGIA_NUM, rp.DRY_MOUTH_NUM, rp.MYASTHENIA_GRAVIS_NUM, rp.NO_URINE_OLIGURIA_NUM, rp.HYPERHIDROSIS_NUM, rp.SKIN_REDNESS_NUM, rp.WAIST_PAIN_NUM, rp.EYE_PAIN_NUM, rp.CONJUNCTIVA_BLOOD_NUM"
			+ " from rp_symptom rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	/**
	 * 查询就诊记录中统计症状-50症状
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<RpSymptom> getSymptom(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, SYMPTOM_SQL);
	}

	/**
	 * 1年内按月统计
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getSymptomMonth(Map<String, String> paramMap){
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		String organCode = paramMap.get("organCode");
		String gbCode = paramMap.get("gbCode");
		String type = paramMap.get("type");
		StringBuilder sql = new StringBuilder("SELECT PMONTH, SUM("+type+"_NUM) as ABCOUNT\n" +
				"  FROM (SELECT TO_CHAR(rp_date, 'YYYY/MM') AS PMONTH, "+type+"_NUM \n" +
				"          FROM RP_SYMPTOM\n" +
				"         WHERE rp_date >= TO_DATE('"+beginDate+"', 'YYYY/MM')\n" +
				"           AND rp_date <= TO_DATE('"+endDate+"', 'YYYY/MM')\n");
		if(!organCode.isEmpty()){
			sql.append(" AND ORGAN_CODE='"+organCode+"'\n");
		}
		sql.append("	AND GB_CODE='"+gbCode+"')\n" +
				" GROUP BY PMONTH\n");
		List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
		return result;
	}

	/**
	 * 查询就诊记录中统计症状-50症状-基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<RpSymptom> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = this.getCondition(paramMap);
		String sql = "";
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = this.getCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpSymptom.class, whereSQL1, criteria);

		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(conditionSql, "gb_code",whereSQL1,whereSQL2,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(conditionSql, "gb_code,center_code,organ_code",whereSQL1,whereSQL2,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(conditionSql, "gb_code,organ_code",whereSQL1,whereSQL2,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}

		return this.getList(sql, criteria);
	}

	/**
	 * 依据时期并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private Criteria getCriteria(Map<String, String> paramMap){
		Criteria criteria = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
		String endDateStr = paramMap.get("endDate");
		Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate,endDate);
		return criteria;
	}

	/**
	 * 依据机构并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private StringBuilder getCondition(Map<String, String> paramMap) {
		StringBuilder whereSQL = new StringBuilder();
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
		String organCode = paramMap.get("organCode");//站
		String gbCode = paramMap.get("gbCode");// 镇
		String genreCode = paramMap.get("genreCode");

		if(ObjectUtil.isNotEmpty(genreCode) && !StringUtils.equals("0", genreCode)){
			whereSQL.append(" and organ_Type= '" + genreCode + "'");
		}
		if(ObjectUtil.isNotEmpty(superOrganCode) && ObjectUtil.isNullOrEmpty(organCode)){
			whereSQL.append(" and organ_Code= '" + superOrganCode + "'");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			whereSQL.append(" and organ_Code= '" + organCode + "'");
		}
		if(ObjectUtil.isNotEmpty(gbCode)){
			whereSQL.append(" and GB_CODE= '" + gbCode + "'");
		}
		return whereSQL;
	}

}