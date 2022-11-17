package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.dto.MedicineCensus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("medicineCensusDao")
public class MedicineCensusDaoImpl extends AbstractDao<MedicineCensus, Long> implements IMedicineCensusDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";
	
			
	private static final String MEDICINE_CENSUS_SQL1 = "SELECT ORGAN_CODE ORG_CODE, SUM(HOUSEHOLD_GREAT_SIXF_NUM) HOUSEHOLD_GREAT_SIXF_NUM, 0 MEDICINE_GREAT_SIXF_NUM, 0 DI_COUNT, 0 HBP_COUNT,0 HBP_MANANG_COUNT,0 DI_MANAGE_COUNT, 0 WOMEN_COUNT,0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT,0 CHILD_SERVE_COUNT " +
			"FROM BI_POPULACE WHERE 1=1 %s GROUP BY ORGAN_CODE";
	
	private static final String MEDICINE_CENSUS_SQL2 = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 HOUSEHOLD_GREAT_SIXF_NUM, COUNT(DISTINCT (ECH.PERSON_ID)) MEDICINE_GREAT_SIXF_NUM, 0 DI_COUNT, 0 HBP_COUNT, 0 HBP_MANANG_COUNT,0 DI_MANAGE_COUNT, 0 WOMEN_COUNT,0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT,0 CHILD_SERVE_COUNT  " +
			"FROM ECH_PHYSICAL_EXAM_RECORD RECORD LEFT JOIN ECH_IDENTIFICATION ECH ON ECH.PERSON_ID = RECORD.PERSON_ID WHERE LOGOFF = 0 %s  "
			+"AND (\n" +
			"(ECH.tcm_qi_quality = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0  END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			" AND (\n" +
			"  ECH.qi_quality_guidance = '1,2,3,4,5'\n" +
			"  OR ECH.qi_quality_guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			"OR (\n" +
			"ECH.tcm_yang_quality = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			" AND (\n" +
			"  ECH.yang_quality_guidance = '1,2,3,4,5'\n" +
			"  OR ECH.yang_quality_guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			" ECH.tcm_Yin_Deficiency = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			" )\n" +
			" AND (\n" +
			"  ECH.yin_Deficiency_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.yin_Deficiency_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			" ECH.tcm_Phlegm_Wetness = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality  ELSE 0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			" AND (\n" +
			"  ECH.phlegm_Wetness_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.phlegm_Wetness_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			" ECH.tcm_Heat_Medium = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			" AND (\n" +
			"  ECH.heat_Medium_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.heat_Medium_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			" ECH.tcm_blood_quality = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE  0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			" AND (\n" +
			"  ECH.blood_Quality_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.blood_Quality_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			" ECH.tcm_Qi_Stagnation = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE  0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			" AND (\n" +
			"  ECH.qi_Stagnation_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.qi_Stagnation_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			"(\n" +
			"  ECH.tcm_Peaceful_Quality = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE  0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			")\n" +
			" AND (\n" +
			"  ECH.peaceful_Quality_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.peaceful_Quality_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			" OR (\n" +
			"(\n" +
			"  ECH.tcm_Special_Quality = GREATEST (\n" +
			"CASE WHEN ECH.qi_flag > 0 THEN ECH.tcm_qi_quality ELSE  0 END,\n" +
			"CASE WHEN ECH.yang_flag > 0 THEN ECH.tcm_yang_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.blood_flag > 0 THEN ECH.tcm_blood_quality ELSE 0 END,\n" +
			"CASE WHEN ECH.yin_deficiency_flag > 0 THEN ECH.tcm_Yin_Deficiency ELSE 0 END,\n" +
			"CASE WHEN ECH.phle_gmwetness_flag > 0 THEN ECH.tcm_Phlegm_Wetness ELSE 0 END,\n" +
			"CASE WHEN ECH.heat_medium_flag > 0 THEN ECH.tcm_Heat_Medium ELSE 0 END,\n" +
			"CASE WHEN ECH.qi_stagnation_flag > 0 THEN ECH.tcm_Qi_Stagnation ELSE 0 END,\n" +
			"CASE WHEN ECH.special_flag > 0 THEN ECH.tcm_Special_Quality ELSE 0 END,\n" +
			"CASE WHEN ECH.peaceful_flag > 0 THEN ECH.tcm_Peaceful_Quality ELSE 0 END\n" +
			")\n" +
			")\n" +
			" AND (\n" +
			"  ECH.special_Quality_Guidance = '1,2,3,4,5'\n" +
			"  OR ECH.special_Quality_Guidance = '1,2,3,4,5,6'\n" +
			")\n" +
			")\n" +
			")"
			+"GROUP BY INPUT_ORGAN_CODE";
	
	private static final String MEDICINE_CENSUS_SQL3 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,  0 HOUSEHOLD_GREAT_SIXF_NUM,  0 MEDICINE_GREAT_SIXF_NUM , COUNT(DECODE(DI_FLAG, 2, 1, NULL)) DI_COUNT, COUNT(DECODE(HBP_FLAG, 2, 1, NULL)) HBP_COUNT,0 HBP_MANANG_COUNT,0 DI_MANAGE_COUNT, 0 WOMEN_COUNT,0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT,0 CHILD_SERVE_COUNT  " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID WHERE DMDI.STATUS = 1 AND DMP.TYPE=2 %s GROUP BY DMDI.CREATE_ORGAN_CODE";
	
	private static final String MEDICINE_CENSUS_SQL4 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,  0 HOUSEHOLD_GREAT_SIXF_NUM,  0 MEDICINE_GREAT_SIXF_NUM , 0 DI_COUNT, 0 HBP_COUNT, COUNT(DISTINCT DMDI.PERSON_ID) HBP_MANANG_COUNT, 0 DI_MANAGE_COUNT, 0 WOMEN_COUNT,0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT,0 CHILD_SERVE_COUNT  " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID INNER JOIN  ECH_ELDERLY_PHY_EXAMINATION MS ON MS.PERSON_ID=DMP.PERSON_ID WHERE (HBP_FLAG = 2) AND DMDI.STATUS = 1 AND DMP.TYPE = 2 AND (MS.HYIN_EMPTY_YANG_HYPER IS NOT NULL OR MS.HQI_BLOOD_EMPTY IS NOT NULL OR MS.HPHLEGM_BLOOD_STASIS IS NOT NULL OR MS.HSPERM_DEFICIENCY IS NOT NULL OR MS.HYANG_EMPTY IS NOT NULL OR MS.HAN_OFFSET IS NOT NULL) AND DMDI.LAST_PHY_EXAMINATION_YEAR  IS NOT NULL %s GROUP BY DMDI.CREATE_ORGAN_CODE ";
	
	private static final String MEDICINE_CENSUS_SQL5 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,  0 HOUSEHOLD_GREAT_SIXF_NUM,  0 MEDICINE_GREAT_SIXF_NUM , 0 DI_COUNT, 0 HBP_COUNT, 0 HBP_MANANG_COUNT, COUNT(DISTINCT DMDI.PERSON_ID) DI_MANAGE_COUNT, 0 WOMEN_COUNT,0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT,0 CHILD_SERVE_COUNT  " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID INNER JOIN  ECH_ELDERLY_PHY_EXAMINATION MS ON MS.PERSON_ID=DMDI.PERSON_ID WHERE (DI_FLAG = 2) AND DMDI.STATUS = 1 AND DMP.TYPE = 2 AND (MS.DYIN_EMPTY_HOT IS NOT NULL OR  MS.DQI_YIN_EMPTY IS NOT NULL OR MS.DYIN_YANG_EMPTY IS NOT NULL) AND DMDI.LAST_PHY_EXAMINATION_YEAR  IS NOT NULL %s GROUP BY DMDI.CREATE_ORGAN_CODE";
	
	private static final String MEDICINE_CENSUS_SQL6 = "SELECT ORG_CODE, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 MEDICINE_GREAT_SIXF_NUM, 0 DI_COUNT, 0 HBP_COUNT, 0 HBP_MANANG_COUNT,  0 DI_MANAGE_COUNT, COUNT(1) WOMEN_COUNT, 0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT,0 CHILD_SERVE_COUNT " +
			"FROM v_ms_women_child_health WHERE IS_DELETE = 0 AND IDENTITY_TYPE = 2 %s GROUP BY ORG_CODE";
	
	private static final String MEDICINE_CENSUS_SQL7 = "SELECT ORG_CODE, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 MEDICINE_GREAT_SIXF_NUM, 0 DI_COUNT, 0 HBP_COUNT, 0 HBP_MANANG_COUNT, 0 DI_MANAGE_COUNT, 0 WOMEN_COUNT, 0 WOMEN_SERVE_COUNT, COUNT (1) CHILD_COUNT,0 CHILD_SERVE_COUNT " +
			"FROM v_ms_women_child_health W WHERE IS_DELETE = 0 AND IDENTITY_TYPE = 1 AND MONTHS_BETWEEN(SYSDATE, CHILD_BIRTHDAY) <= 36 %s GROUP BY ORG_CODE";
	
	private static final String MEDICINE_CENSUS_SQL8 = "SELECT ORG_CODE, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 MEDICINE_GREAT_SIXF_NUM, 0 DI_COUNT, 0 HBP_COUNT, 0 HBP_MANANG_COUNT, 0 DI_MANAGE_COUNT, 0 WOMEN_COUNT, 0 WOMEN_SERVE_COUNT, 0 CHILD_COUNT, COUNT (1) CHILD_SERVE_COUNT " +
			"FROM v_ms_women_child_health W JOIN (SELECT PERSON_ID, COUNT(DISTINCT C_PHYSICAL_EXAM_AGE) SERVE_COUNT FROM CH_CHILD_HEALTH_EXAMINATION@DL_MS WHERE TCM_HEALTH_MANAGE_SERVICE IS NOT NULL AND (IS_DELETE <> 1 OR IS_DELETE IS NULL) AND C_PHYSICAL_EXAM_AGE IN ('6月龄', '12月龄', '18月龄', '24月龄', '30月龄', '3岁') GROUP BY PERSON_ID) SERVE ON W.PERSON_ID = SERVE.PERSON_ID  WHERE IS_DELETE = 0 AND IDENTITY_TYPE = 1 AND MONTHS_BETWEEN(SYSDATE, CHILD_BIRTHDAY) <= 36 AND SERVE.SERVE_COUNT = SHOULDSERVECOUNT(W.CHILD_BIRTHDAY) %s GROUP BY ORG_CODE";
			
	private static final String WHPRENATAL_SQL1 = "SELECT DISTINCT PERSON_ID,CREATE_ORGAN_CODE ORG_CODE FROM WH_PRENATAL_FOLLOWUP@DL_MS WHERE 1=1 %s ";
	private static final String WHPRENATAL_SQL2 = "SELECT DISTINCT PERSON_ID,CREATE_ORGAN_CODE ORG_CODE FROM WH_PRENATAL_FOLLOWUP_OTHER@DL_MS WHERE 1=1 %s";
	private static final String WHPRENATAL_SQL3 = "SELECT DISTINCT PERSON_ID,CREATE_ORGAN_CODE ORG_CODE FROM WH_POSTNATAL_FOLLOWUP@DL_MS WHERE 1=1 %s";
	private static final String WHPRENATAL_SQL4 = "SELECT DISTINCT PERSON_ID,CREATE_ORGAN_CODE ORG_CODE FROM WH_POSTPARTUM_DAYS_HEALTH_INFO@DL_MS WHERE 1=1 %s";
	
	private String buildWHSql(Criteria criteria, List<String> organCodeList) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");
		Map<String, Object> map;
		
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","VISIT_DATE", null, "CM_HEALTH_MANAGE", orgCode, year,  month, organCodeList,new MapSqlParameterSource(), 2);
		String sql1 = String.format(WHPRENATAL_SQL1, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","INPUT_DATE_TWO", null, "TCM_HEALTH_SIGN_TWO", orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		String sql2 = String.format(WHPRENATAL_SQL2, map.get(SqlBuilder.WHERE));

		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","INPUT_DATE_THREE", null, "TCM_HEALTH_SIGN_THREE", orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		String sql3 = String.format(WHPRENATAL_SQL2, map.get(SqlBuilder.WHERE));

		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","INPUT_DATE_FOUR", null, "TCM_HEALTH_SIGN_FOUR", orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		String sql4 = String.format(WHPRENATAL_SQL2, map.get(SqlBuilder.WHERE));
	
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","INPUT_DATE_FIVE", null, "TCM_HEALTH_SIGN_FIVE", orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		String sql5 = String.format(WHPRENATAL_SQL2, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","VISIT_DATE", null, "CMEDICI_MANAGE_FLAG", orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		String sql6 = String.format(WHPRENATAL_SQL3, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("CREATE_ORGAN_CODE","SUPERVISION_DATE", null, "CM_HEALTH_MANAGE", orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		String sql7 = String.format(WHPRENATAL_SQL4, map.get(SqlBuilder.WHERE));
		
		StringBuilder finalSql = new StringBuilder();
		finalSql.append("SELECT ORG_CODE, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 MEDICINE_GREAT_SIXF_NUM, 0 DI_COUNT, 0 HBP_COUNT, 0 HBP_MANANG_COUNT, 0 DI_MANAGE_COUNT, 0 WOMEN_COUNT, COUNT(DISTINCT PERSON_ID) WOMEN_SERVE_COUNT, 0 CHILD_COUNT, 0 CHILD_SERVE_COUNT FROM (")
				.append(sql1)
				.append(" UNION ALL ")
				.append(sql2)
				.append(" UNION ALL ")
				.append(sql3)
				.append(" UNION ALL ")
				.append(sql4)
				.append(" UNION ALL ")
				.append(sql5)
				.append(" UNION ALL ")
				.append(sql6)
				.append(" UNION ALL ")
				.append(sql7)
				.append(" ) GROUP BY ORG_CODE ");
		
		return finalSql.toString();
	}

	private void buildSql(Criteria criteria, StringBuilder finalSql, List<String> list) {
		StringBuilder sqlb = new StringBuilder();
		for(String sql :list){
			if(sqlb.length()==0){
				sqlb.append("(").append(sql);
			}else{
				sqlb.append(" UNION ALL ").append(sql);
			}
		}
		sqlb.append(")");
			
		finalSql.append("SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE ORG_CODE," +
				" NVL(HOUSEHOLD_GREAT_SIXF_NUM,0) HOUSEHOLD_GREAT_SIXF_NUM," +
				" NVL(MEDICINE_GREAT_SIXF_NUM,0) MEDICINE_GREAT_SIXF_NUM," +
				" NVL(DI_COUNT,0) DI_COUNT," +
				" NVL(HBP_COUNT,0) HBP_COUNT," +
				" NVL(HBP_SERVE_COUNT,0) HBP_SERVE_COUNT," +
				" NVL(DI_MANAGE_COUNT,0) DI_MANAGE_COUNT," +
				" NVL(WOMEN_COUNT,0) WOMEN_COUNT," +
				" NVL(WOMEN_SERVE_COUNT,0) WOMEN_SERVE_COUNT," +
				" NVL(CHILD_COUNT,0) CHILD_COUNT," +
				" NVL(CHILD_SERVE_COUNT,0) CHILD_SERVE_COUNT" +
				" FROM mdm_organization V LEFT JOIN (")
				
		.append("SELECT ORG_CODE,")
		.append(" NVL(SUM(HOUSEHOLD_GREAT_SIXF_NUM), 0) HOUSEHOLD_GREAT_SIXF_NUM, " +
				" NVL(SUM(MEDICINE_GREAT_SIXF_NUM), 0) MEDICINE_GREAT_SIXF_NUM, " +
				" NVL(SUM(DI_COUNT), 0) DI_COUNT, NVL(SUM(HBP_COUNT), 0) HBP_COUNT," +
				" NVL(SUM(HBP_MANANG_COUNT),0) HBP_SERVE_COUNT, NVL(SUM(DI_MANAGE_COUNT),0) DI_MANAGE_COUNT," +
				" NVL(SUM(WOMEN_COUNT),0) WOMEN_COUNT, NVL(SUM(WOMEN_SERVE_COUNT),0) WOMEN_SERVE_COUNT," +
				" NVL(SUM(CHILD_COUNT), 0) CHILD_COUNT, NVL(SUM(CHILD_SERVE_COUNT), 0) CHILD_SERVE_COUNT " +
				" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE) T ON V.ORGAN_CODE=T.ORG_CODE WHERE 1=1 %s ORDER BY V.GENRE_CODE,V.ORGAN_NAME");
	}

	@Override
	public List<MedicineCensus> getMedicineCensusList(Criteria criteria, List<String> organCodeList) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");
		
		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();
		Map<String, Object> map;
		
		map = SqlBuilder.buildOrganCondition("ORGAN_CODE","COUNT_YEAR", null, null, orgCode, year, null, organCodeList, new MapSqlParameterSource(), 3);
		String sql = String.format(MEDICINE_CENSUS_SQL1, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("INPUT_ORGAN_CODE","ECH.CREATE_DATE", null, null, orgCode, year, month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		sql = String.format(MEDICINE_CENSUS_SQL2, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("DMDI.CREATE_ORGAN_CODE","DMDI.HBP_MANAGED_DATE", null, null, orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		sql = String.format(MEDICINE_CENSUS_SQL3, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("DMDI.CREATE_ORGAN_CODE","DMDI.HBP_MANAGED_DATE", null, null, orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		sql = String.format(MEDICINE_CENSUS_SQL4, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("DMDI.CREATE_ORGAN_CODE","DMDI.HBP_MANAGED_DATE", null, null, orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		sql = String.format(MEDICINE_CENSUS_SQL5, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("ORG_CODE","CREATE_DATE", null, null, orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		sql = String.format(MEDICINE_CENSUS_SQL6, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("ORG_CODE","CREATE_DATE", null, null, orgCode, year,  month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		sql= String.format(MEDICINE_CENSUS_SQL7, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("ORG_CODE","CREATE_DATE", null, null, orgCode, year, month, organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 2);
		sql= String.format(MEDICINE_CENSUS_SQL8, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		
		sql = buildWHSql(criteria, organCodeList);
		sqlList.add(sql);
		
		map = SqlBuilder.buildOrganCondition("V.ORGAN_CODE",null, null, null, orgCode, null, null, organCodeList, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 0);
		
		buildSql(criteria, finalSql, sqlList);
		
		return getList(MedicineCensus.class, String.format(finalSql.toString(), map.get(SqlBuilder.WHERE)), (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}
}
