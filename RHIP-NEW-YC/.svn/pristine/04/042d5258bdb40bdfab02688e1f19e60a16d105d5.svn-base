package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of 妇幼保健(绩效)
 */
@Repository("performanceDao")
public class PerformanceDaoImpl extends AbstractDao<IdmReport, Long> implements IPerformanceDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String DRUG_STATISTICS_SQL = "";

    public List<Map<String, Object>> getTrainingPerformance(Map<String, String> paramMap) {

        String trainingYear = paramMap.get("trainingYear");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String gbCode = paramMap.get("gbCode");
        String searchOrg = "";
        String searchSuperOrg = "";
        if("A1".equals(genreCode)){ //按市级医院
            if(StringUtil.isNotEmpty(superOrganCode)){
                searchOrg = superOrganCode;
            }
        }
        if("B1".equals(genreCode)){ //卫生院
            if(StringUtil.isNotEmpty(superOrganCode)){
                searchOrg = superOrganCode;
            }
        }
        if("B2".equals(genreCode)){ //社区卫生服务站
            if(StringUtil.isNotEmpty(superOrganCode)){
                searchSuperOrg = superOrganCode;
            }
            if(StringUtil.isNotEmpty(organCode)){
                searchOrg = organCode;
            }
        }

        StringBuilder sql = new StringBuilder("SELECT PS.RECORD_YEAR, ORGS.ORGAN_CODE, PS.PASS_NUM, ORGS.STAFF_NUM, ROUND(PS.PASS_NUM / ORGS.STAFF_NUM, 4) AS percent\n" +
                "  FROM (SELECT ORGAN_CODE, RECORD_YEAR, COUNT(PASS) AS PASS_NUM\n" +
                "          FROM (select CE.smpi_id, CE.record_year, CE.T_CA, CE.T_CB, STF.ORGAN_CODE, STF.GB_CODE, STF.TECHNICAL,\n" +
                "                       CASE\n" +
                "                         WHEN TECHNICAL BETWEEN 4 AND 5 AND T_CA + T_CB >= 25 THEN 'T'\n" +
                "                         WHEN TECHNICAL = 3 AND T_CA >= 15 AND T_CB >= 10 THEN 'T'\n" +
                "                         WHEN TECHNICAL BETWEEN 1 AND 2 AND T_CA >= 15 AND T_CB >= 10 THEN 'T'\n" +
                "                         ELSE ''\n" +
                "                       end AS PASS\n" +
                "                  from (select smpi_id, record_year, sum(credit_a) as T_CA, sum(credit_b) as T_CB\n" +
                "                          from V_PCBM_CONTINUE_EDUCATION\n" +
                "                         where record_year = "+trainingYear+"\n" +
                "                         group by smpi_id, record_year) CE,\n" +
                "                       V_MDM_STAFF STF\n" +
                "                 WHERE CE.SMPI_ID = STF.SMPI_ID) OP\n" +
                "         --WHERE PASS = 'T'\n" +
                "         GROUP BY ORGAN_CODE, RECORD_YEAR) PS,\n" +
                "       (SELECT ORG.ORGAN_CODE, OS.STAFF_NUM\n" +
                "          FROM V_MDM_ORGANIZATION_NOSUB ORG,\n" +
                "               (SELECT ORGAN_CODE, COUNT(1) AS STAFF_NUM\n" +
                "                  FROM V_MDM_STAFF S\n" +
                "                 GROUP BY ORGAN_CODE) OS\n" +
                "         WHERE ORG.ORGAN_CODE = OS.ORGAN_CODE \n");
        if(StringUtil.isNotEmpty(genreCode)){
            sql.append(" AND ORG.GENRE_CODE = '"+genreCode+"' ");
        }
        if(StringUtil.isNotEmpty(gbCode)){
            sql.append(" AND ORG.GB_CODE = '"+gbCode+"' ");
        }
        if(StringUtil.isNotEmpty(searchSuperOrg)){
            sql.append(" AND ORG.PARENT_CODE = '"+searchSuperOrg+"' ");
        }
        if(StringUtil.isNotEmpty(searchOrg)){
            sql.append(" AND ORG.ORGAN_CODE = '"+searchOrg+"' ");
        }
                sql.append("        ) ORGS\n" +
                " WHERE ORGS.ORGAN_CODE = PS.ORGAN_CODE(+)\n");

        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    @Override
    public List<Map<String, Object>> getVaccinationPerformance(Map<String, String> paramMap) {
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String gbCode = paramMap.get("gbCode");
        String searchOrg = "";
        String searchSuperOrg = "";
        if("A1".equals(genreCode)){ //按市级医院
            if(StringUtil.isNotEmpty(superOrganCode)){
                searchOrg = superOrganCode;
            }
        }
        if("B1".equals(genreCode)){ //卫生院
            if(StringUtil.isNotEmpty(superOrganCode)){
                searchOrg = superOrganCode;
            }
        }
        if("B2".equals(genreCode)){ //社区卫生服务站
            if(StringUtil.isNotEmpty(superOrganCode)){
                searchSuperOrg = superOrganCode;
            }
            if(StringUtil.isNotEmpty(organCode)){
                searchOrg = organCode;
            }
        }
        StringBuilder sql = new StringBuilder("SELECT O.ORGAN_CODE,  O.ORGAN_NAME, V.UNITCOUNT  FROM\n" +
                "(SELECT IMMU_UNIT_ID, COUNT(1) AS UNITCOUNT FROM SY_RDMDB_DC_VACCINATION_INFO\n" +
                " WHERE VACCINATION_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/dd') AND VACCINATION_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/dd')\n");
        sql.append("GROUP BY IMMU_UNIT_ID) V,\n" +
                "(SELECT ORGAN_CODE, ORGAN_NAME FROM V_MDM_ORGANIZATION_NOSUB \n" +
                " WHERE 1 =1 \n" );
        if(StringUtil.isNotEmpty(genreCode)){
            sql.append(" AND GENRE_CODE = '"+genreCode+"' ");
        }
        if(StringUtil.isNotEmpty(gbCode)){
            sql.append(" AND GB_CODE = '"+gbCode+"' ");
        }
        if(StringUtil.isNotEmpty(searchSuperOrg)){
            sql.append(" AND PARENT_CODE = '"+searchSuperOrg+"' ");
        }
        if(StringUtil.isNotEmpty(searchOrg)){
            sql.append(" AND ORGAN_CODE = '"+searchOrg+"' ");
        }
        sql.append(" )O ");
        sql.append("WHERE O.ORGAN_CODE = V.IMMU_UNIT_ID(+)");

        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    public List<Map<String, Object>> getHealthExamPerformance(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, GENRE_CODE\n" +
                "    FROM V_MDM_ORGANIZATION_NOSUB\n" +
                "   WHERE GENRE_CODE = '"+genreCode+"'\n");
        if(StringUtil.isNotEmpty(gbCode)) {
            sql.append(" AND GB_CODE = '" + gbCode + "' ");
        }
        if(StringUtil.isNotEmpty(superOrganCode)) {
            sql.append(" AND ORGAN_CODE = '" + superOrganCode + "' ");
        }
                sql.append("  ),\n" +
                "HE AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS HECOUNT\n" +
                "    FROM SY_RMSDB_MS_HEALTH_EXAM\n" +
                "   WHERE EXAMINATION_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND EXAMINATION_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "ITEM AS\n" +
                " (SELECT HOSPITAL_CODE, INSPECTION_ITEM_CODE,APPLY_ROOM_CODE\n" +
                "    FROM MS_STUDY_EVENT\n" +
                "   WHERE AUDIT_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND AUDIT_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')),\n" +
                "BC AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BCCOUNT\n" +
                "    FROM ITEM\n" +
                "   WHERE APPLY_ROOM_CODE = '0009'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XT AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XTCOUNT\n" +
                "    FROM ITEM\n" +
                "   WHERE APPLY_ROOM_CODE = '0010'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XDT AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XDTCOUNT\n" +
                "    FROM ITEM\n" +
                "   WHERE APPLY_ROOM_CODE = '0008'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "CT AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) CTCOUNT\n" +
                "    FROM ITEM\n" +
                "   WHERE INSPECTION_ITEM_CODE = 'CT'\n" +
                "   GROUP BY HOSPITAL_CODE)\n" +
                "SELECT ORG.ORGAN_CODE, HE.HECOUNT, BC.BCCOUNT, XT.XTCOUNT, XDT.XDTCOUNT, CT.CTCOUNT\n" +
                "  FROM ORG, HE, BC, XT, XDT, CT\n" +
                " WHERE ORG.ORGAN_CODE = BC.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = HE.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XT.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XDT.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = CT.HOSPITAL_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

	@Override
	public PageList<Map<String, Object>> getAntibacterials(Map<String, String> paramMap, Page page) {
		PageList<Map<String, Object>> pageList = new PageList<>();
		if (paramMap == null) {
			return pageList;
		}
        String beginDate = paramMap.get("beginDateA");
        String endDate = paramMap.get("endDateA");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");// 镇
        
		StringBuilder sqlBuilder = new StringBuilder(" SELECT REFERRAL_HOSPITAL_CODE ORG_CODE, DRUG_MEDICARE_CODE DRUG_CODE, COUNT(1) ALL_NUM, MAX(DRUG_GENERIC_NAME) DRUG_NAME FROM MS_DRUG_USAGE DU " +
				"WHERE DU.DRUG_MEDICARE_CODE IS NOT NULL  AND DU.DOCTOR_NAME IS NOT NULL AND DU.ANTIBACTERIALS_FLAG = '1' ");
		
		StringBuilder orgSqlBuilder = new StringBuilder("  AND  DU.REFERRAL_HOSPITAL_CODE IN (SELECT V.ORGAN_CODE FROM V_MDM_ORGANIZATION_NOSUB V WHERE V.GENRE_CODE='").append(genreCode).append("'");
		if (ObjectUtil.isNotEmpty(superOrganCode)) {
			orgSqlBuilder.append(" AND V.PARENT_CODE ='").append(superOrganCode).append("'");
		}
		if (ObjectUtil.isNotEmpty(gbCode)) {
			orgSqlBuilder.append("  AND V.GB_CODE ='").append(gbCode).append("'");
		}
		orgSqlBuilder.append(")");
		
		if (((StringUtils.equals("A100", genreCode) || StringUtils.equals("B100", genreCode)) && ObjectUtil.isNullOrEmpty(superOrganCode))
				|| (StringUtils.equals("B200", genreCode) && ObjectUtil.isNullOrEmpty(organCode))) {
			sqlBuilder.append(orgSqlBuilder);
		}

		if (((StringUtils.equals("A100", genreCode) || StringUtils.equals("B100", genreCode)) && ObjectUtil.isNotEmpty(superOrganCode))) {
			sqlBuilder.append(" AND DU.REFERRAL_HOSPITAL_CODE ='");
			sqlBuilder.append(superOrganCode);
			sqlBuilder.append("' ");
		}
		if (StringUtils.equals("B200", genreCode) && ObjectUtil.isNotEmpty(organCode)) {
			sqlBuilder.append(" AND DU.REFERRAL_HOSPITAL_CODE ='");
			sqlBuilder.append(organCode);
			sqlBuilder.append("' ");
		}

		sqlBuilder.append(organizeDateCondition(beginDate, endDate, "DU.START_DATE"));

		sqlBuilder.append(" GROUP BY DU.DRUG_MEDICARE_CODE, DU.REFERRAL_HOSPITAL_CODE ");
		return getPageMapList(page, sqlBuilder.toString(), (Criteria) null);
	}

	@Override
	public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA, String endDateA) {
		List<Map<String, Object>> results = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(orgCode) || ObjectUtil.isNullOrEmpty(medicalCode)) {
			return results;
		}
		StringBuilder sqlBuilder = new StringBuilder("SELECT  NAME, ALLNUM  FROM (SELECT DOCTOR_NAME NAME, COUNT(1) ALLNUM  FROM MS_DRUG_USAGE  WHERE DOCTOR_NAME IS NOT NULL AND  REFERRAL_HOSPITAL_CODE='")
											.append(orgCode).append("' AND DRUG_MEDICARE_CODE='")
											.append(medicalCode).append("' ").append(organizeDateCondition(beginDateA, endDateA, "START_DATE")).append(" GROUP BY DOCTOR_NAME ORDER BY ALLNUM DESC) WHERE ROWNUM <=10");
		return getMapList(sqlBuilder.toString(), (Criteria) null);
	}

	@Override
	public PageList<Map<String, Object>> getInpatientMedicalRecord(Map<String, String> paramMap, Page page) {
		PageList<Map<String, Object>> list = new PageList<Map<String, Object>>();
		if (paramMap == null) {
			return list;
		}
        String beginDate = paramMap.get("beginDateA");
        String endDate = paramMap.get("endDateA");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");// 镇
        String quality = paramMap.get("quality"); // 病案质量

		StringBuilder sqlBuilder = new StringBuilder(" SELECT IMR.HOSPITAL_CODE ORG_CODE,SUM(DECODE(IMR.INHOS_MEDICAL_QUALITY_CODE, '1', 1, 0)) A,SUM(DECODE(IMR.INHOS_MEDICAL_QUALITY_CODE, '2', 1, 0)) B,SUM(DECODE(IMR.INHOS_MEDICAL_QUALITY_CODE, '3', 1, 0)) C,SUM(DECODE(IMR.INHOS_MEDICAL_QUALITY_CODE, '1', 1, 0)) + SUM(DECODE(IMR.INHOS_MEDICAL_QUALITY_CODE, '2', 1, 0)) + SUM(DECODE(IMR.INHOS_MEDICAL_QUALITY_CODE, '3', 1, 0)) D  FROM MS_INPATIENT_MEDICAL_RECORD IMR " +
				"WHERE IMR.INHOS_MEDICAL_QUALITY_CODE IS NOT NULL ");
		if (ObjectUtil.isNotEmpty(quality)) {
			sqlBuilder.append(" AND IMR.INHOS_MEDICAL_QUALITY_CODE='");
			sqlBuilder.append(quality);
			sqlBuilder.append("'");
		}
		StringBuilder orgSqlBuilder = new StringBuilder("  AND  IMR.HOSPITAL_CODE IN (SELECT ORG.ORGAN_CODE FROM SY_MDM_ORGANIZATION ORG WHERE ORG.GENRE_CODE='").append(genreCode).append("'");
		if (ObjectUtil.isNotEmpty(superOrganCode)) {
			orgSqlBuilder.append(" AND ORG.PARENT_CODE ='").append(superOrganCode).append("'");
		}
		if (ObjectUtil.isNotEmpty(gbCode)) {
			orgSqlBuilder.append("  AND ORG.GB_CODE ='").append(gbCode).append("'");
		}
		orgSqlBuilder.append(")");

		if (((StringUtils.equals("A100", genreCode) || StringUtils.equals("B100", genreCode)) && ObjectUtil.isNullOrEmpty(superOrganCode))
				|| (StringUtils.equals("B200", genreCode) && ObjectUtil.isNullOrEmpty(organCode))) {
			sqlBuilder.append(orgSqlBuilder);
		}

		if (((StringUtils.equals("A100", genreCode) || StringUtils.equals("B100", genreCode)) && ObjectUtil.isNotEmpty(superOrganCode))) {
			sqlBuilder.append(" AND IMR.HOSPITAL_CODE ='");
			sqlBuilder.append(superOrganCode);
			sqlBuilder.append("' ");
		}
		if (StringUtils.equals("B200", genreCode) && ObjectUtil.isNotEmpty(organCode)) {
			sqlBuilder.append(" AND IMR.HOSPITAL_CODE ='");
			sqlBuilder.append(organCode);
			sqlBuilder.append("' ");
		}

		sqlBuilder.append(organizeDateCondition(beginDate, endDate, "IMR.OUT_HOSPITAL_DATE"));

		sqlBuilder.append(" GROUP BY  IMR.HOSPITAL_CODE ");
		
		StringBuilder orgStatistics = new StringBuilder("with orgstatistics as(select organ_code from sy_mdm_organization o where o.status=1 %1$s %2$s %3$s %4$s),ret as(");
		orgStatistics.append(sqlBuilder.toString());
		orgStatistics.append(") select o.organ_code org_code,r.A,r.B,r.C,r.D from orgstatistics o left join ret r on o.organ_code=r.org_code");
		String orgTypeCondition = "";
//		if (StringUtils.equals("A100", genreCode)) {
//			orgTypeCondition = " and o.genre_code='A100' ";
//		} else if (StringUtils.equals("B100", genreCode)) {
//			orgTypeCondition = " and o.genre_code='B100' ";
//		}  else if (StringUtils.equals("B200", genreCode)) {
//			orgTypeCondition = " and o.genre_code='B200' ";
//		}
//		
//		StringBuilder gbCodeBuilder = new StringBuilder();
//		if (ObjectUtil.isNotEmpty(gbCode)) {
//			gbCodeBuilder.append(" and o.gb_code='").append(gbCode).append("' ");
//		}
//		
//		StringBuilder orgConditionBuilder = new StringBuilder();
//		if (ObjectUtil.isNotEmpty(organCode)) {
//			orgConditionBuilder.append(" and o.organ_code='").append(organCode).append("' ");
//		}
//		
//		StringBuilder parentOrgConditionBuilder = new StringBuilder();
//		if (ObjectUtil.isNotEmpty(superOrganCode)) {
//			parentOrgConditionBuilder.append(" and o.parent_code='").append(superOrganCode).append("' ");
//		}
		
		if(StringUtil.isNotEmpty(genreCode)){
			orgTypeCondition=" AND o.GENRE_CODE = '" + genreCode + "'";
		}
		StringBuilder gbCodeBuilder = new StringBuilder();
		if(StringUtil.isNotEmpty(gbCode)){
			gbCodeBuilder.append(" AND o.GB_CODE = '"+gbCode+"' ");
		}
		StringBuilder orgConditionBuilder = new StringBuilder();
		StringBuilder parentOrgConditionBuilder = new StringBuilder();
		if(("A100".equals(genreCode) ||"B100".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
			orgConditionBuilder.append(" AND o.ORGAN_CODE = '"+superOrganCode+"'");
		}
		
		if("B200".equals(genreCode) ){
			if(StringUtil.isNotEmpty(superOrganCode)){
				parentOrgConditionBuilder.append(" AND o.PARENT_CODE = '"+superOrganCode+"'");
			}
			if(StringUtil.isNotEmpty(organCode)){
				orgConditionBuilder.append(" AND o.ORGAN_CODE = '"+organCode+"'");
			}
		}
		String destSql = String.format(orgStatistics.toString(), orgTypeCondition, orgConditionBuilder.toString(), gbCodeBuilder.toString(), parentOrgConditionBuilder.toString());
		return getPageMapList(page, destSql, (Criteria) null);
	}

	/**
	 * 组织时间查询条件
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	private StringBuilder organizeDateCondition(String beginDate, String endDate, String dateColumn) {
		StringBuilder sqlBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(beginDate) && ObjectUtil.isNotEmpty(endDate)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(dateColumn);
			sqlBuilder.append(" >= TO_DATE('");
			sqlBuilder.append(beginDate);
			sqlBuilder.append("', 'YYYY/MM/dd')");
			sqlBuilder.append(" AND ");
			sqlBuilder.append(dateColumn);
			sqlBuilder.append("<= TO_DATE('");
			sqlBuilder.append(endDate);
			sqlBuilder.append("', 'YYYY/MM/dd')");
		}
		if (ObjectUtil.isNotEmpty(beginDate) && ObjectUtil.isNullOrEmpty(endDate)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(dateColumn);
			sqlBuilder.append(" >= TO_DATE('");
			sqlBuilder.append(beginDate);
			sqlBuilder.append("', 'YYYY/MM/dd')");
		}
		if (ObjectUtil.isNullOrEmpty(beginDate) && ObjectUtil.isNotEmpty(endDate)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(dateColumn);
			sqlBuilder.append(" <= TO_DATE('");
			sqlBuilder.append(endDate);
			sqlBuilder.append("', 'YYYY/MM/dd')");
		}
		return sqlBuilder;
	}

	@Override
	public List<Map<String, Object>> getAntibacterialPrescriptions(Map<String, String> paramMap) {
		List<Map<String, Object>> list = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return list;
		}
        String beginDate = paramMap.get("beginDateA");
        String endDate = paramMap.get("endDateA");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");// 镇
        
		/*StringBuilder sqlBuilder = new StringBuilder(" SELECT V.ORGAN_CODE  ORGAN_CODE,SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '1', 1, 0) ) NUM1, " +
				"SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '1', 1, 0) )+SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '0', 1, 0) ) NUM2, " +
				"TO_CHAR(decode(SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '1', 1, 0) )+SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '0', 1, 0) ),0,0,SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '1', 1, 0) )/(SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '1', 1, 0) )+SUM(DECODE(SMOP.ANTIBIOTIC_FLAG, '0', 1, 0) ))),'99D99')*100||'%' RST " +
				" FROM mdm_organization V  LEFT JOIN (SELECT ANTIBIOTIC_FLAG,HOSPITAL_CODE FROM  MS_OUTPATIENT_PRESCRIPTION  WHERE 1=1 " );
		
		sqlBuilder.append(organizeDateCondition(beginDate, endDate, "PRESCRIBE_DATE"));
		sqlBuilder.append(") SMOP  ON V.ORGAN_CODE = SMOP.HOSPITAL_CODE  WHERE 1=1 ");
		
		if (ObjectUtil.isNotEmpty(genreCode)) {
			sqlBuilder.append(" AND V.ORGAN_TYPE ='");
			sqlBuilder.append(genreCode);
			sqlBuilder.append("' ");
		}
		
		if (ObjectUtil.isNotEmpty(superOrganCode) && genreCode.equalsIgnoreCase("B2")) {//站
			sqlBuilder.append(" AND V.PARENT_CODE ='");
			sqlBuilder.append(superOrganCode);
			sqlBuilder.append("' ");
		}

        if (ObjectUtil.isNotEmpty(superOrganCode) && (genreCode.equalsIgnoreCase("A1") || genreCode.equalsIgnoreCase("B1"))) {//市级医院，卫生院
            sqlBuilder.append(" AND V.ORGAN_CODE ='");
            sqlBuilder.append(superOrganCode);
            sqlBuilder.append("' ");
        }
		
		if (ObjectUtil.isNotEmpty(organCode) && !StringUtils.equals(genreCode, "A1")) {
			sqlBuilder.append(" AND V.ORGAN_CODE ='");
			sqlBuilder.append(organCode);
			sqlBuilder.append("' ");
		}
		
		if (ObjectUtil.isNotEmpty(gbCode)) {
			sqlBuilder.append(" AND V.GB_CODE ='");
			sqlBuilder.append(gbCode);
			sqlBuilder.append("' ");
		}
		sqlBuilder.append("  GROUP BY V.ORGAN_CODE ");*/
        StringBuilder sqlBuilder = new StringBuilder(" SELECT REFERRAL_HOSPITAL_CODE ORG_CODE, DRUG_MEDICARE_CODE DRUG_CODE, COUNT(1) ALL_NUM, MAX(DRUG_GENERIC_NAME) DRUG_NAME FROM MS_DRUG_USAGE DU " +
                "WHERE DU.DRUG_MEDICARE_CODE IS NOT NULL  AND DU.DOCTOR_NAME IS NOT NULL AND DU.ANTIBACTERIALS_FLAG = '1' ");

        StringBuilder orgSqlBuilder = new StringBuilder("  AND  DU.REFERRAL_HOSPITAL_CODE IN (SELECT ORGAN_CODE FROM SY_PHB_MDM_ORGANIZATION  WHERE genre_code='").append(genreCode).append("'");
        if (ObjectUtil.isNotEmpty(superOrganCode)) {
            orgSqlBuilder.append(" AND PARENT_CODE ='").append(superOrganCode).append("'");
        }
        if (ObjectUtil.isNotEmpty(gbCode)) {
            orgSqlBuilder.append("  AND GB_CODE ='").append(gbCode).append("'");
        }
        orgSqlBuilder.append(")");

        if (((StringUtils.equals("A100", genreCode) || StringUtils.equals("B100", genreCode)) && ObjectUtil.isNullOrEmpty(superOrganCode))
                || (StringUtils.equals("B200", genreCode) && ObjectUtil.isNullOrEmpty(organCode))) {
            sqlBuilder.append(orgSqlBuilder);
        }

        if (((StringUtils.equals("A100", genreCode) || StringUtils.equals("B100", genreCode)) && ObjectUtil.isNotEmpty(superOrganCode))) {
            sqlBuilder.append(" AND DU.REFERRAL_HOSPITAL_CODE ='");
            sqlBuilder.append(superOrganCode);
            sqlBuilder.append("' ");
        }
        if (StringUtils.equals("B200", genreCode) && ObjectUtil.isNotEmpty(organCode)) {
            sqlBuilder.append(" AND DU.REFERRAL_HOSPITAL_CODE ='");
            sqlBuilder.append(organCode);
            sqlBuilder.append("' ");
        }
        sqlBuilder.append(organizeDateCondition(beginDate, endDate, "DU.START_DATE"));
        sqlBuilder.append(" GROUP BY DU.DRUG_MEDICARE_CODE, DU.REFERRAL_HOSPITAL_CODE ORDER BY ALL_NUM DESC");
		return getMapList(sqlBuilder.toString(), (Criteria) null);
	}
}