package com.founder.rhip.ehr.repository.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.util.ObjectUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.dto.HbpDiCensus;

@Repository("hbpDiCensusDao")
public class HbpDiCensusDaoImpl extends AbstractDao<HbpDiCensus, Long> implements IHbpDiCensusDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";


	private static final String HBP_CENSUS_SQL1 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, SUM(DECODE(HBP_FLAG, 2, 1, NULL)) HBP_COUNT, 0 HBP_MANAGE_COUNT, 0 HBP_BP_COUNT, 0 HBP_SIGN_COUNT, 0 HBP_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID WHERE DMDI.STATUS = 1 AND DMP.TYPE = 2 %s GROUP BY DMDI.CREATE_ORGAN_CODE";

	//获取有实际随访时间 并且规范的患者数
	private static final String HBP_CENSUS_SQL2 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 HBP_COUNT, SUM(1) HBP_MANAGE_COUNT, 0 HBP_BP_COUNT, 0 HBP_SIGN_COUNT, 0 HBP_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID WHERE DMDI.STATUS = 1 AND DMP.TYPE = 2 AND HBP_FLAG = 2 %2$s "+
			"and exists (select 1 from DM_HYPERTENSION_FOLLOWUP where person_id = DMP.PERSON_ID and TO_CHAR(VISIT_DATE, 'yyyy') = %4$s ) GROUP BY DMDI.CREATE_ORGAN_CODE";
	/*private static final String HBP_CENSUS_SQL2 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 HBP_COUNT, SUM(1) HBP_MANAGE_COUNT, 0 HBP_BP_COUNT, 0 HBP_SIGN_COUNT, 0 HBP_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMPE ON DMDI.PERSON_ID = DMPE.PERSON_ID INNER JOIN (SELECT T1.PERSON_ID,COUNT(1) PLAN_C, SUM(CASE WHEN T1.FOLLOWUP_DATE IS NOT NULL AND TRUNC(T1.FOLLOWUP_DATE) <= TRUNC(T1.PLAN_DATE + 7) AND TRUNC(T1.FOLLOWUP_DATE) >= TRUNC(T1.PLAN_DATE - 7) %3$s THEN 1 ELSE 0 END) FOLLOWUP_C  FROM DM_FOLLOWUP_PLAN T1 WHERE TRUNC(T1.PLAN_DATE) <= TRUNC(SYSDATE) AND T1.DIS_TYPE = '1' %1$s GROUP BY T1.PERSON_ID) TT2 ON TT2.PERSON_ID = DMDI.PERSON_ID WHERE PLAN_C=FOLLOWUP_C AND DMDI.STATUS = 1 AND DMPE.TYPE = 2 AND HBP_FLAG = 2 %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";
*/
	private static final String HBP_CENSUS_SQL3 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 HBP_COUNT, 0 HBP_MANAGE_COUNT, SUM(1) HBP_BP_COUNT, 0 HBP_SIGN_COUNT, 0 HBP_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID INNER JOIN (SELECT TT2.PERSON_ID FROM (SELECT T1.PERSON_ID, T1.SBP, T1.DBP, T1.VISIT_DATE, ROW_NUMBER() OVER(PARTITION BY T1.PERSON_ID ORDER BY T1.VISIT_DATE DESC) GROUPSEQ FROM DM_HYPERTENSION_FOLLOWUP T1 WHERE 1=1 %1$s ) TT2 JOIN BI_PERSON_INFO BI on BI.ID = TT2.PERSON_ID WHERE TT2.GROUPSEQ = '1' AND ((TT2.SBP < 140 AND TT2.DBP < 90) OR (TT2.SBP < 150 AND TT2.DBP < 90 AND TO_CHAR(TT2.VISIT_DATE, 'yyyy') - TO_CHAR(bi.BIRTHDAY, 'yyyy') >= 65))) TC1 ON DMDI.PERSON_ID = TC1.PERSON_ID WHERE (HBP_FLAG = 2) AND DMDI.STATUS = 1 AND DMP.TYPE = 2 %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";

	private static final String HBP_CENSUS_SQL4 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 HBP_COUNT,  0 HBP_MANAGE_COUNT, 0 HBP_BP_COUNT, COUNT(DECODE(HBP_FLAG, 2, 1, NULL)) HBP_SIGN_COUNT, 0 HBP_SHOULD_COUNT " +
			"FROM  DM_DISEASE_INFO DMDI INNER JOIN  SIGN@DL_FDS SIGN ON DMDI.IDCARD = SIGN.PERSON_IDCARD INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID WHERE DMDI.STATUS = 1 AND DMP.TYPE = 2 AND SIGN.PAID_FLAG = '1' AND SIGN.VALID = '1' AND SIGN.RESCIND_FLAG = '0' %1$s %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";

	private static final String HBP_CENSUS_SQL5 = "SELECT ORGAN_CODE ORG_CODE, 0 HBP_COUNT,  0 HBP_MANAGE_COUNT, 0 HBP_BP_COUNT, 0 HBP_SIGN_COUNT, SUM(NVL(HOUSEHOLD_NUM,0) + NVL(UN_HOUSE_HOLD_NUM,0)) HBP_SHOULD_COUNT FROM BI_POPULACE WHERE 1=1 %s  GROUP BY ORGAN_CODE";

	private static final String HBP_CENSUS_SQL6 = "SELECT CREATE_ORGAN_CODE ORG_CODE,0 HBP_COUNT, SUM(1) HBP_MANAGE_COUNT, 0 HBP_BP_COUNT, 0 HBP_SIGN_COUNT, 0 HBP_SHOULD_COUNT FROM(SELECT DMDISEASEINFO. ID,DMDISEASEINFO.PERSON_ID,DMDISEASEINFO.CREATE_ORGAN_CODE FROM DM_DISEASE_INFO dmDiseaseInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.PERSON_ID JOIN MDM_ORGANIZATION org ON org.organ_code = dmDiseaseInfo.create_Organ_Code INNER JOIN (SELECT * FROM(SELECT ROW_NUMBER () OVER (PARTITION BY DF.person_id ORDER BY DF.PLAN_TYPE DESC) RN,DF.person_id,DF.FOLLOWUP_DATE,DF.PLAN_DATE FROM DM_FOLLOWUP_PLAN DF WHERE DF.DIS_TYPE = '1' AND PLAN_YEAR = '%1$s' AND IS_DELETE = '0' AND FOLLOWUP_DATE IS NOT NULL ORDER BY DF .PLAN_TYPE DESC)WHERE RN = 4)R ON R.person_id = DMDISEASEINFO.PERSON_ID WHERE(dmDiseaseInfo.hbp_flag ='2')AND dmDiseaseInfo.STATUS ='1' %2$s AND (HBP_FLAG ='2' OR DI_FLAG ='2')AND dmPersonInfo. TYPE ='2' AND EXISTS (SELECT 1 FROM SY_MS_HEALTH_EXAM EX WHERE PHYSICAL_EXAM_TYPE = '39' AND EX.PERSON_ID = dmDiseaseInfo.Person_Id AND TO_CHAR (EX.EXAMINATION_DATE, 'YYYY') = '%1$s') AND (STROKE_MANAGED_FLAG <> 0 OR STROKE_MANAGED_FLAG IS NULL)AND (CORONARY_MANAGED_FLAG <> 0 OR CORONARY_MANAGED_FLAG IS NULL)ORDER BY dmDiseaseInfo.UPDATE_DATE DESC,dmDiseaseInfo. ID DESC)GROUP BY CREATE_ORGAN_CODE";

//	private static final String HBP_CENSUS_SQL7 = "SELECT ORG_CODE,0 HBP_COUNT,SUM (1) HBP_MANAGE_COUNT,0 HBP_BP_COUNT,0 HBP_SIGN_COUNT,0 HBP_SHOULD_COUNT"
//			+ " FROM(SELECT DISTINCT dmDiseaseInfo.ID,dmDiseaseInfo.create_organ_code ORG_CODE FROM"
//			+ " dm_followup_plan dfp inner join DM_DISEASE_INFO dmDiseaseInfo "
//			+ "on dmDiseaseInfo.person_id = dfp.person_id WHERE (TO_CHAR (dfp.FOLLOWUP_DATE, 'yyyy') = '%1$s' %2$s %3$s  "
//			+ "AND dfp.DIS_TYPE = '1' AND dfp.is_delete = '0' ))GROUP BY ORG_CODE";
	
	private static final String HBP_CENSUS_SQL7 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,0 HBP_COUNT,SUM (1) HBP_MANAGE_COUNT,0 HBP_BP_COUNT,0 HBP_SIGN_COUNT,0 HBP_SHOULD_COUNT"
			+ " FROM DM_DISEASE_INFO DMDI  INNER JOIN DM_PERSON_INFO DMP  ON DMDI.PERSON_ID = DMP.PERSON_ID "
			+ " LEFT JOIN (SELECT PERSON_ID, COUNT(1) FOLLOWUP_COUNT_HBP  FROM DM_HYPERTENSION_FOLLOWUP where 1=1 AND " + 
			"                       TO_CHAR (VISIT_DATE, 'yyyy') ='%1$s'  %3$s  GROUP BY PERSON_ID)  FOLLOWUPCOUNT ON FOLLOWUPCOUNT.PERSON_ID =DMP.PERSON_ID"
			+ " where 1=1 %2$s and DMDI.STATUS = 1 AND DMP.TYPE = 2  and DMDI.HBP_FLAG = 2  AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_HBP, 0) >= 1"
			+ " GROUP BY DMDI.CREATE_ORGAN_CODE";
	
	private static final String HBP_CENSUS_SQL74 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,0 HBP_COUNT,SUM (1) HBP_MANAGE_COUNT,0 HBP_BP_COUNT,0 HBP_SIGN_COUNT,0 HBP_SHOULD_COUNT"
			+ " FROM DM_DISEASE_INFO DMDI  INNER JOIN DM_PERSON_INFO DMP  ON DMDI.PERSON_ID = DMP.PERSON_ID "
			+ " LEFT JOIN (SELECT PERSON_ID, COUNT(1) FOLLOWUP_COUNT_HBP  FROM DM_HYPERTENSION_FOLLOWUP where 1=1 AND " + 
			"                       TO_CHAR (VISIT_DATE, 'yyyy') ='%1$s'  %3$s  GROUP BY PERSON_ID)  FOLLOWUPCOUNT ON FOLLOWUPCOUNT.PERSON_ID =DMP.PERSON_ID"
			+ " where 1=1 %2$s AND EXISTS(SELECT mhe.PERSON_ID FROM MS_HEALTH_EXAMINATION@DL_MS mhe  WHERE mhe.PERSON_ID=DMP.PERSON_ID AND mhe.PHYSICAL_EXAM_TYPE = 39 and  TO_CHAR(mhe.EXAMINATION_DATE, 'YYYY') ='%1$s' )  and DMDI.STATUS = 1 AND DMP.TYPE = 2  and DMDI.HBP_FLAG = 2  AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_HBP, 0) >= 1"
			+ " GROUP BY DMDI.CREATE_ORGAN_CODE";
	

	private static final String DI_CENSUS_SQL1 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, SUM(DECODE(DI_FLAG, 2, 1, NULL)) DI_COUNT, 0 DI_MANAGE_COUNT, 0 DI_BS_COUNT, 0 DI_TWOHOUR_COUNT , 0 DI_SIGN_COUNT, 0 DI_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID  WHERE DMDI.STATUS = '1' AND DMDI.DI_FLAG = '2' AND DMP.TYPE = '2' %s GROUP BY DMDI.CREATE_ORGAN_CODE";

	//获取有实际随访时间 并且规范的患者数
	private static final String DI_CENSUS_SQL2 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 DI_COUNT, COUNT(1) DI_MANAGE_COUNT, 0 DI_BS_COUNT, 0 DI_TWOHOUR_COUNT, 0 DI_SIGN_COUNT, 0 DI_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID INNER JOIN ( SELECT T1.PERSON_ID, COUNT(1) PLAN_C, SUM(CASE WHEN T1.FOLLOWUP_DATE IS NOT NULL AND TRUNC(T1.FOLLOWUP_DATE) <= TRUNC(T1.PLAN_DATE + 7) AND TRUNC(T1.FOLLOWUP_DATE) >= TRUNC(T1.PLAN_DATE - 7) %3$s THEN 1 ELSE 0 END) FOLLOWUP_C  FROM DM_FOLLOWUP_PLAN T1 WHERE TRUNC(T1.PLAN_DATE) <= TRUNC(SYSDATE) AND T1.DIS_TYPE = '2' %1$s GROUP BY T1.PERSON_ID) TT2 ON TT2.PERSON_ID= DMDI.PERSON_ID WHERE PLAN_C=FOLLOWUP_C AND DMDI.STATUS = 1 AND DMP.TYPE = 2 AND DI_FLAG = 2 %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";

	private static final String DI_CENSUS_SQL3 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 DI_COUNT, 0 DI_MANAGE_COUNT, SUM(1) DI_BS_COUNT, 0 DI_TWOHOUR_COUNT, 0 DI_SIGN_COUNT, 0 DI_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID INNER JOIN (SELECT TT2.PERSON_ID FROM (SELECT T1.PERSON_ID, T1.FPG, ROW_NUMBER() OVER(PARTITION BY T1.PERSON_ID ORDER BY T1.VISIT_DATE DESC) GROUPSEQ FROM DM_DIABETIC_FOLLOWUP T1 WHERE 1 = 1 %1$s) TT2 WHERE TT2.GROUPSEQ = '1' AND TT2.FPG<7 AND TT2.FPG>0) TC1  ON DMDI.PERSON_ID = TC1.PERSON_ID WHERE (DI_FLAG = 2) AND DMDI.STATUS = 1 AND DMP.TYPE = 2 %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";

	private static final String DI_CENSUS_SQL6 ="SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 DI_COUNT, 0 DI_MANAGE_COUNT, 0 DI_BS_COUNT, SUM(1) DI_TWOHOUR_COUNT, 0 DI_SIGN_COUNT, 0 DI_SHOULD_COUNT " +
			"FROM DM_DISEASE_INFO DMDI INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID INNER JOIN (SELECT TT4.PERSON_ID FROM (SELECT T1.PERSON_ID, T1.GLU_VALUE, ROW_NUMBER() OVER(PARTITION BY T1.PERSON_ID ORDER BY T1.VISIT_DATE DESC) GROUPSEQ FROM DM_DIABETIC_FOLLOWUP T1 WHERE 1 = 1 %1$s) TT4 WHERE TT4.GROUPSEQ = '1' AND TT4.GLU_VALUE<10 AND TT4.GLU_VALUE>0) TC3  ON DMDI.PERSON_ID = TC3.PERSON_ID WHERE (DI_FLAG = 2) AND DMDI.STATUS = 1 AND DMP.TYPE = 2 %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";

	private static final String DI_CENSUS_SQL4 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE, 0 DI_COUNT,  0 DI_MANAGE_COUNT, 0 DI_BS_COUNT, 0 DI_TWOHOUR_COUNT, COUNT(DECODE(DI_FLAG, 2, 1, NULL)) DI_SIGN_COUNT, 0 DI_SHOULD_COUNT " +
			"FROM  DM_DISEASE_INFO DMDI INNER JOIN  SIGN@DL_FDS SIGN ON DMDI.IDCARD = SIGN.PERSON_IDCARD INNER JOIN DM_PERSON_INFO DMP ON DMDI.PERSON_ID = DMP.PERSON_ID WHERE DMDI.DI_FLAG = '2' AND DMDI.STATUS = '1' AND DMP.TYPE = '2' AND SIGN.PAID_FLAG = '1' AND SIGN.VALID = '1' AND SIGN.RESCIND_FLAG = '0' %1$s %2$s GROUP BY DMDI.CREATE_ORGAN_CODE";

	private static final String DI_CENSUS_SQL5 = "SELECT ORGAN_CODE ORG_CODE, 0 DI_COUNT, 0 DI_MANAGE_COUNT, 0 DI_BS_COUNT, 0 DI_TWOHOUR_COUNT, 0 DI_SIGN_COUNT, SUM(NVL(HOUSEHOLD_NUM, 0)+NVL(UN_HOUSE_HOLD_NUM, 0)) DI_SHOULD_COUNT FROM BI_POPULACE WHERE 1=1 %s  GROUP BY ORGAN_CODE";

	private static final String DI_CENSUS_SQL7 = "SELECT CREATE_ORGAN_CODE ORG_CODE,0 DI_COUNT,COUNT (1) DI_MANAGE_COUNT,0 DI_BS_COUNT,0 DI_TWOHOUR_COUNT,0 DI_SIGN_COUNT,0 DI_SHOULD_COUNT FROM(SELECT DMDISEASEINFO. ID,DMDISEASEINFO.PERSON_ID,DMDISEASEINFO.CREATE_ORGAN_CODE FROM DM_DISEASE_INFO dmDiseaseInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.PERSON_ID JOIN MDM_ORGANIZATION org ON org.organ_code = dmDiseaseInfo.create_Organ_Code INNER JOIN (SELECT * FROM(SELECT ROW_NUMBER () OVER (PARTITION BY DF.person_id ORDER BY DF.PLAN_TYPE DESC) RN,DF.person_id,DF.FOLLOWUP_DATE,DF.PLAN_DATE FROM DM_FOLLOWUP_PLAN DF WHERE DF.DIS_TYPE = '2' AND PLAN_YEAR = '%1$s' AND IS_DELETE = '0' AND FOLLOWUP_DATE IS NOT NULL ORDER BY DF .PLAN_TYPE DESC)WHERE RN = 4)R ON R.person_id = DMDISEASEINFO.PERSON_ID WHERE(dmDiseaseInfo.di_flag ='2')AND dmDiseaseInfo.STATUS ='1'  %2$s AND (HBP_FLAG ='2' OR DI_FLAG ='2')AND dmPersonInfo. TYPE ='2' AND EXISTS (SELECT 1 FROM SY_MS_HEALTH_EXAM EX WHERE PHYSICAL_EXAM_TYPE = '39' AND EX.PERSON_ID = dmDiseaseInfo.Person_Id AND TO_CHAR (EX.EXAMINATION_DATE, 'YYYY') = '%1$s') AND (STROKE_MANAGED_FLAG <> 0 OR STROKE_MANAGED_FLAG IS NULL)AND (CORONARY_MANAGED_FLAG <> 0 OR CORONARY_MANAGED_FLAG IS NULL)ORDER BY dmDiseaseInfo.UPDATE_DATE DESC,dmDiseaseInfo. ID DESC)GROUP BY CREATE_ORGAN_CODE";

	//private static final String DI_CENSUS_SQL8 = "SELECT ORG_CODE,0 DI_COUNT, COUNT (1)  DI_MANAGE_COUNT,0 DI_BS_COUNT,0 DI_TWOHOUR_COUNT,0 DI_SIGN_COUNT,0 DI_SHOULD_COUNT FROM(SELECT DISTINCT bi. ID,bi. NAME,bi.input_organ_code ORG_CODE FROM dm_followup_plan dfp INNER JOIN bi_person_info bi ON bi. ID = dfp.person_id WHERE(TO_CHAR (dfp.FOLLOWUP_DATE, 'yyyy') = '%1$s' %2$s %3$s  AND dfp.DIS_TYPE = '2' AND dfp.is_delete = '0' AND bi.filing_flag = '1'))GROUP BY ORG_CODE";

	private static final String DI_CENSUS_SQL8 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,0 DI_COUNT,SUM (1) DI_MANAGE_COUNT,0 DI_BS_COUNT,0 DI_TWOHOUR_COUNT,0 DI_SIGN_COUNT,0 DI_SHOULD_COUNT"
			+ " FROM DM_DISEASE_INFO DMDI  INNER JOIN DM_PERSON_INFO DMP  ON DMDI.PERSON_ID = DMP.PERSON_ID "
			+ " LEFT JOIN (SELECT PERSON_ID, COUNT(1) FOLLOWUP_COUNT_DI  FROM DM_DIABETIC_FOLLOWUP where 1=1 AND " + 
			"                       TO_CHAR (VISIT_DATE, 'yyyy') ='%1$s'  %3$s  GROUP BY PERSON_ID)  FOLLOWUPCOUNT ON FOLLOWUPCOUNT.PERSON_ID =DMP.PERSON_ID"
			+ " where 1=1 %2$s and DMDI.STATUS = 1 AND DMP.TYPE = 2  and DMDI.DI_FLAG = 2  AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_DI, 0) >= 1"
			+ " GROUP BY DMDI.CREATE_ORGAN_CODE";
	
	private static final String DI_CENSUS_SQL84 = "SELECT DMDI.CREATE_ORGAN_CODE ORG_CODE,0 DI_COUNT,SUM (1) DI_MANAGE_COUNT,0 DI_BS_COUNT,0 DI_TWOHOUR_COUNT,0 DI_SIGN_COUNT,0 DI_SHOULD_COUNT"
			+ " FROM DM_DISEASE_INFO DMDI  INNER JOIN DM_PERSON_INFO DMP  ON DMDI.PERSON_ID = DMP.PERSON_ID "
			+ " LEFT JOIN (SELECT PERSON_ID, COUNT(1) FOLLOWUP_COUNT_DI  FROM DM_DIABETIC_FOLLOWUP where 1=1 AND " + 
			"                       TO_CHAR (VISIT_DATE, 'yyyy') ='%1$s'  %3$s  GROUP BY PERSON_ID)  FOLLOWUPCOUNT ON FOLLOWUPCOUNT.PERSON_ID =DMP.PERSON_ID"
			+ " where 1=1 %2$s AND EXISTS(SELECT mhe.PERSON_ID FROM MS_HEALTH_EXAMINATION@DL_MS mhe  WHERE mhe.PERSON_ID=DMP.PERSON_ID AND mhe.PHYSICAL_EXAM_TYPE = 39 and  TO_CHAR(mhe.EXAMINATION_DATE, 'YYYY') ='%1$s' ) and DMDI.STATUS = 1 AND DMP.TYPE = 2  and DMDI.DI_FLAG = 2  AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_DI, 0) >= 1"
			+ " GROUP BY DMDI.CREATE_ORGAN_CODE";
	
	private void builHbpDiSql(Criteria criteria, StringBuilder finalSql, List<String> list, boolean flag) {
		StringBuilder sqlb = new StringBuilder();
		for(String sql :list){
			if(sqlb.length()==0){
				sqlb.append("(").append(sql);
			}else{
				sqlb.append(" UNION ALL ").append(sql);
			}
		}
		sqlb.append(")");

		if(flag){
			finalSql.append("SELECT ORG_CODE,")
					.append(" NVL(SUM(HBP_COUNT), 0) HBP_COUNT, " +
							" NVL(SUM(HBP_MANAGE_COUNT), 0) HBP_MANAGE_COUNT, " +
							" NVL(SUM(HBP_BP_COUNT), 0) HBP_BP_COUNT," +
							" NVL(SUM(HBP_SIGN_COUNT),0) HBP_SIGN_COUNT," +
							" NVL(SUM(HBP_SHOULD_COUNT),0) HBP_SHOULD_COUNT" +
							" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE");
		}else{
			finalSql.append("SELECT ORG_CODE,")
					.append(" NVL(SUM(DI_COUNT), 0) DI_COUNT, " +
							" NVL(SUM(DI_MANAGE_COUNT), 0) DI_MANAGE_COUNT, " +
							" NVL(SUM(DI_BS_COUNT), 0) DI_BS_COUNT," +
							" NVL (SUM(DI_TWOHOUR_COUNT), 0) DI_TWOHOUR_COUNT," +
							" NVL(SUM(DI_SIGN_COUNT),0) DI_SIGN_COUNT," +
							" NVL(SUM(DI_SHOULD_COUNT), 0) DI_SHOULD_COUNT" +
							" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE");
		}
	}

	@Override
	public List<HbpDiCensus> getHbpCensusList(Criteria criteria, List<String> organCodeList) {
		String gbcode=(String)criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");
		String searchOrgColumn="";
		String organColumn="";
		String poSeachColumn="";
		String poOrgColumn="";
		if(ObjectUtil.isNotEmpty(orgCode)) {
			searchOrgColumn="DMP.CREATE_ORGAN_CODE";
			poSeachColumn="ORGAN_CODE";
		}else if(ObjectUtil.isNullOrEmpty(orgCode)&&ObjectUtil.isNotEmpty(centerOrgCode)) {
			searchOrgColumn="DMP.CREATE_CENTER_ORGAN_CODE";
			organColumn="DMP.CREATE_ORGAN_CODE";
			poSeachColumn="ORGAN_PARENT_CODE";
			poOrgColumn="ORGAN_CODE";
		}else if(ObjectUtil.isNullOrEmpty(orgCode)&&ObjectUtil.isNullOrEmpty(centerOrgCode)&&ObjectUtil.isNotEmpty(gbcode)) {
			searchOrgColumn="DMP.CREATE_GBCODE";
			poSeachColumn="GBCODE";
		}
		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();
		Map<String, Object> map;
		Map<String, Object> map1;
		Map<String, Object> map2;

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,"DMDI.HBP_MANAGED_DATE", year,  month, new MapSqlParameterSource(), 5);
		String sql = String.format(HBP_CENSUS_SQL1, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn, "DMDI.HBP_MANAGED_DATE", year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 5);
		map1 = SqlBuilder.buildOrganCondition(criteria,null,null, "T1.PLAN_DATE",  year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 5);
		map2 = SqlBuilder.buildOrganCondition(criteria,null,null, "T1.FOLLOWUP_DATE", year,  month, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 5);

//		if("04".equals(month)){
//			map = SqlBuilder.buildOrganCondition("INPUT_ORGAN_CODE",null, null, null, null, null, null, organCodeList, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), null);
//			sql = String.format(HBP_CENSUS_SQL6,year, map.get(SqlBuilder.WHERE));
//			sqlList.add(sql);
//		}else 
		if(ObjectUtil.isNotEmpty(month)){
			map2 = SqlBuilder.buildOrganCondition(criteria,null,null, "VISIT_DATE", year,  month, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 6);
			map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,null, null, null, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), null);
			if("04".equals(month)) {
				sql = String.format(HBP_CENSUS_SQL74, year, map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE));
			}else {
				sql = String.format(HBP_CENSUS_SQL7, year, map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE));
			}
			sqlList.add(sql);
		}else {
//			sql = String.format(HBP_CENSUS_SQL2, map1.get(SqlBuilder.WHERE), map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE),year);
//			sqlList.add(sql);
			map2 = SqlBuilder.buildOrganCondition(criteria,null, null,"VISIT_DATE",  year,  "04", (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 6);
			map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,null, null, null, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), null);
			sql = String.format(HBP_CENSUS_SQL74, year, map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE));
			sqlList.add(sql);
		}

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn, "DMDI.HBP_MANAGED_DATE",  year,  month, (MapSqlParameterSource) map2.get(SqlBuilder.SOURCE), 5);
		map1 = SqlBuilder.buildOrganCondition(criteria,null,null,"T1.VISIT_DATE",  year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		sql = String.format(HBP_CENSUS_SQL3, map1.get(SqlBuilder.WHERE), map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,"DMDI.HBP_MANAGED_DATE",  year,  month, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 5);
		/*-------设置签约时间查询条件 开始-----------*/
		//获取时间段的日期
		MapSqlParameterSource sqlParameterSource = (MapSqlParameterSource) map.get(SqlBuilder.SOURCE);
		StringBuilder signSql = new StringBuilder();
		//day1为开始时间 day2为结束时间
		String day1 = "";
		String day2 = "";
		if (sqlParameterSource.hasValue("day1") && sqlParameterSource.hasValue("day2")){
			//按季度查询
			day1 = (String) sqlParameterSource.getValue("day1");
			day2 = (String) sqlParameterSource.getValue("day2");
		}else if (sqlParameterSource.hasValue("year")){
			//按年查询 year为年份
			String signYear = (String) sqlParameterSource.getValue("year");
			day1 = year+"0101";
			day2 = year+"1231";
		}
		//签约生效时间小于结束时间 且 签约失效时间大于开始时间
		signSql.append(" AND TO_CHAR(SIGN.EFFECTIVE_START_DATE, 'YYYYMMDD') <= '").append(day2).append("'");
		signSql.append(" AND TO_CHAR(SIGN.EFFECTIVE_END_DATE, 'YYYYMMDD') >= '").append(day1).append("'") ;
		/*-------设置签约时间查询条件 结束-----------*/
		sql = String.format(HBP_CENSUS_SQL4, map.get(SqlBuilder.WHERE), signSql.toString());
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition(criteria, poSeachColumn, poOrgColumn,"COUNT_YEAR",  year, null, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 3);
		sql = String.format(HBP_CENSUS_SQL5, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		builHbpDiSql(criteria, finalSql, sqlList, true);

		return getList(HbpDiCensus.class, finalSql.toString(), (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

	@Override
	public List<HbpDiCensus> getDiCensusList(Criteria criteria, List<String> organCodeList) {
		String gbcode=(String)criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");
		String searchOrgColumn="";
		String organColumn="";
		String poSeachColumn="";
		String poOrgColumn="";
		if(ObjectUtil.isNotEmpty(orgCode)) {
			searchOrgColumn="DMP.CREATE_ORGAN_CODE";
			poSeachColumn="ORGAN_CODE";
		}else if(ObjectUtil.isNullOrEmpty(orgCode)&&ObjectUtil.isNotEmpty(centerOrgCode)) {
			organColumn="DMP.CREATE_ORGAN_CODE";
			searchOrgColumn="DMP.CREATE_CENTER_ORGAN_CODE";
			poSeachColumn="ORGAN_PARENT_CODE";
			poOrgColumn="ORGAN_CODE";
		}else if(ObjectUtil.isNullOrEmpty(orgCode)&&ObjectUtil.isNullOrEmpty(centerOrgCode)&&ObjectUtil.isNotEmpty(gbcode)) {
			searchOrgColumn="DMP.CREATE_GBCODE";
			poSeachColumn="GBCODE";
		}
		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();
		Map<String, Object> map;
		Map<String, Object> map1;
		Map<String, Object> map2;

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,"DMDI.DI_MANAGED_DATE",  year,  month, new MapSqlParameterSource(), 5);
		String sql = String.format(DI_CENSUS_SQL1, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn, "DMDI.DI_MANAGED_DATE", year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 5);
		map1 = SqlBuilder.buildOrganCondition(criteria,null,null, "T1.PLAN_DATE",  year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 5);
		map2 = SqlBuilder.buildOrganCondition(criteria,null,null, "T1.FOLLOWUP_DATE", year,  month, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 5);

//		if("04".equals(month)){
//			map = SqlBuilder.buildOrganCondition(null,"INPUT_ORGAN_CODE",null, null, null, null, null, null, organCodeList, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), null);
//			sql = String.format(DI_CENSUS_SQL7, year, map.get(SqlBuilder.WHERE));
//			sqlList.add(sql);
//		}else 
		if(ObjectUtil.isNotEmpty(month)){
			map2 = SqlBuilder.buildOrganCondition(criteria,null,null, "VISIT_DATE", year,  month, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 7);
			map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,null, null, null, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), null);
			if("04".equals(month)) {
				sql = String.format(DI_CENSUS_SQL84, year, map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE));
			}else {
				sql = String.format(DI_CENSUS_SQL8, year, map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE));
			}
			
			sqlList.add(sql);
		}else {
			map2 = SqlBuilder.buildOrganCondition(criteria,null,null, "VISIT_DATE",  year,  "04", (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 7);
			map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,null, null, null, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), null);
			sql = String.format(DI_CENSUS_SQL84, year, map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE));
			sqlList.add(sql);
		}
		/*
		 * else { sql = String.format(DI_CENSUS_SQL2, map1.get(SqlBuilder.WHERE),
		 * map.get(SqlBuilder.WHERE), map2.get(SqlBuilder.WHERE)); sqlList.add(sql); }
		 */

		map = SqlBuilder.buildOrganCondition(criteria, searchOrgColumn, organColumn, "DMDI.DI_MANAGED_DATE", year,  month, (MapSqlParameterSource) map2.get(SqlBuilder.SOURCE), 5);
		map1 = SqlBuilder.buildOrganCondition(criteria,null,null, "T1.VISIT_DATE", year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		sql = String.format(DI_CENSUS_SQL3, map1.get(SqlBuilder.WHERE), map.get(SqlBuilder.WHERE));
		sqlList.add(sql);


		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn,"DMDI.DI_MANAGED_DATE", year,  month, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 5);
		/*-------设置签约时间查询条件 开始-----------*/
		//获取时间段的日期
		MapSqlParameterSource sqlParameterSource = (MapSqlParameterSource) map.get(SqlBuilder.SOURCE);
		StringBuilder signSql = new StringBuilder();
		//day1为开始时间 day2为结束时间
		String day1 = "";
		String day2 = "";
		if (sqlParameterSource.hasValue("day1") && sqlParameterSource.hasValue("day2")){
			//按季度查询
			day1 = (String) sqlParameterSource.getValue("day1");
			day2 = (String) sqlParameterSource.getValue("day2");
		}else if (sqlParameterSource.hasValue("year")){
			//按年查询 year为年份
			String signYear = (String) sqlParameterSource.getValue("year");
			day1 = year+"0101";
			day2 = year+"1231";
		}
		//签约生效时间小于结束时间 且 签约失效时间大于开始时间
		signSql.append(" AND TO_CHAR(SIGN.EFFECTIVE_START_DATE, 'YYYYMMDD') <= '").append(day2).append("'");
		signSql.append(" AND TO_CHAR(SIGN.EFFECTIVE_END_DATE, 'YYYYMMDD') >= '").append(day1).append("'") ;
		/*-------设置签约时间查询条件 结束-----------*/
		sql = String.format(DI_CENSUS_SQL4, map.get(SqlBuilder.WHERE), signSql.toString());
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition(criteria,searchOrgColumn,organColumn, "DMDI.DI_MANAGED_DATE", year,  month, (MapSqlParameterSource) map2.get(SqlBuilder.SOURCE), 5);
		map1 = SqlBuilder.buildOrganCondition(criteria,null,null, "T1.VISIT_DATE", year,  month, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 5);
		sql = String.format(DI_CENSUS_SQL6, map1.get(SqlBuilder.WHERE), map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition(criteria,poSeachColumn, poOrgColumn,"COUNT_YEAR", year, null, (MapSqlParameterSource) map1.get(SqlBuilder.SOURCE), 3);
		sql = String.format(DI_CENSUS_SQL5, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		builHbpDiSql(criteria, finalSql, sqlList, false);
		List<HbpDiCensus> list = getList(HbpDiCensus.class, finalSql.toString(), (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
		return list;
	}
}
