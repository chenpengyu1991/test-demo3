package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.annotation.Resource;

/**
 * DAO implement of 医疗服务
 * 
 */
@Repository("medicalTargetDao")
public class MedicalTargetDaoImpl extends	AbstractDao<OutpatientInfo, Long> implements IMedicalTargetDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 住院病案首页字典
     * 是否实施临床路径、诊断符合标识
     */
    private static final String true_flag = "0";

    private static final String select_gb_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE";
    private static final String select_parent_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    private static final String select_organ_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    
    private static final String ORG_SQL="WITH MDM_ORGANIZATION_V AS("
    		+ " SELECT GB_CODE,PARENT_CODE,ORGAN_CODE,GENRE_CODE"
    		+ " FROM MDM_ORGANIZATION"
    		+ " %1$s )";//机构条件
    
    private static final String OUTPATIENT_DRUG_USAGE_SQL = " ,OUTPATIENT_DRUG_USAGE AS("
    		+ " SELECT CLINIC_ORGAN_CODE,EHR_ID,PERSON_ID"
    		+ " ,CLINIC_DATE,MANA_DOCTOR_NO,VISIT_STATUS,OBSERVED_PATIENT_FLAG"
    		+ " ,MEDICAL_COST_PAY_WAY,MEDICAL_INSURANCE_COST_SUM,PERSONAL_EXPENSES,OTHER_SUBSIDIES_COST_SUM,OUTPATIENT_COST_SUM"
    		+ ",PRESCRIPTION_COUNT,PRESCRIPTION_ROUTE_COUNT"
    		+ " FROM SY_RMSDB_MS_OUTPATIENT_INFO OUTPATIENT"
    		+ " WHERE %7$s"//机构条件   		
    		+ "  AND (CLINIC_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('%3$s','yyyy/MM/dd')))";;

    private static final String OUTPATIENT_SQL = " SELECT medical.* "
    		+ " ,ROUND(DECODE(medical.doctorNum,0,0,NVL(medical.visitNum,0)/doctorNum),4) workload"
    /*		+ " ,ROUND(DECODE(medical.prescriptionCount,0,0,NVL(medical.useRouteCount,0)/medical.prescriptionCount),4) prescriptionRate"*/
    		+ " FROM(SELECT %5$s"
    		+ "         ,SUM(outpatient.registerNum) registerNum,SUM(outpatient.visitNum) visitNum"
    		+ "         ,SUM(outpatient.MEDICAL01) MEDICAL01,SUM(outpatient.MEDICAL02) MEDICAL02,SUM(outpatient.MEDICAL03) MEDICAL03"
/*    		+ "         ,SUM(outpatient.MEDICAL04) MEDICAL04,SUM(outpatient.MEDICAL05) MEDICAL05,SUM(outpatient.MEDICAL06) MEDICAL06"
    		+ "         ,SUM(outpatient.MEDICAL07) MEDICAL07,SUM(outpatient.MEDICAL99) MEDICAL99"*/
    		+ "         ,SUM(outpatient.personalCost) personalCost"
     /*       + "         ,SUM(outpatient.otherCost) otherCost"*/
    		+ "         ,SUM(outpatient.outpatientCost) outpatientCost"
     /*       + "         ,SUM(surgery.surgeryNum) surgeryNum"*/
    		+ "         ,NVL(SUM(outpatient.PRESCRIPTION_COUNT),0) prescriptionCount"
/*    		+ "         ,NVL(SUM(outpatient.USE_ROUTE_COUNT),0) useRouteCount"*/
    		+ "         ,NVL(SUM(STAFF.STAFF_COUNT),0) doctorNum"//医生人数
    		+ "         ,NVL(SUM(outpatient.observedNum),0) observedNum"//留观人次数
    		+ " FROM MDM_ORGANIZATION_V ORG"
    		+ " LEFT JOIN("
    		+ "     SELECT CLINIC_ORGAN_CODE"
    		+ "         ,COUNT(1) registerNum"//挂号人次数
    		+ "         ,COUNT(DECODE(VISIT_STATUS,2,1,NULL)) visitNum"//就诊人次数
    		+ "         ,COUNT(DECODE(OBSERVED_PATIENT_FLAG,1,1,NULL)) observedNum"//留观人次数
    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='01' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL01"//城镇职工基本医疗保险
    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='02' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL02"//城镇居民基本医疗保险
    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='03' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL03"//新型农村合作医疗
//    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='04' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL04"//贫困救助
//    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='05' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL05"//商业医疗保险
//    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='06' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL06"//全公费
//    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='07' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL07"//全自费
//    		+ "         ,SUM(CASE WHEN MEDICAL_COST_PAY_WAY='99' THEN MEDICAL_INSURANCE_COST_SUM ELSE 0 END) MEDICAL99"//其他
    		+ "         ,SUM(PERSONAL_EXPENSES) personalCost"//个人费用
//    		+ "         ,SUM(OTHER_SUBSIDIES_COST_SUM) otherCost"//其他补助金额
    		+ "         ,SUM(OUTPATIENT_COST_SUM) outpatientCost"//合计费用
    		+ "         ,SUM(PRESCRIPTION_COUNT) PRESCRIPTION_COUNT "//处方数
    /*		+ "         ,SUM(PRESCRIPTION_ROUTE_COUNT) USE_ROUTE_COUNT "//静滴处方数*/
    		+ "     FROM OUTPATIENT_DRUG_USAGE"
    		+ "     GROUP BY CLINIC_ORGAN_CODE"
    		+ " )outpatient on org.ORGAN_CODE = outpatient.CLINIC_ORGAN_CODE"
    /*		+ " LEFT JOIN("
    		+ "     SELECT HOSPITAL_CODE"
    		+ "         ,COUNT(DECODE(OP_EM_HP_MARK,1,1,2,1,NULL)) surgeryNum"//手术人数
    		+ " FROM V_RMSDB_SURGERY_INFO"
    		+ " WHERE %8$s"//机构条件
    		+ "  AND (OPERTATION_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND OPERTATION_DATE <= TO_DATE('%3$s','yyyy/MM/dd'))"
    		+ " GROUP BY HOSPITAL_CODE"
    		+ " )surgery on org.ORGAN_CODE = surgery.HOSPITAL_CODE"*/
    		+ " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = org.ORGAN_CODE"
    		+ " GROUP BY %4$s) medical";
    
    /**
     * 综合管理-住院信息-住院摘要(原先从住院病案首页获取)
     */
    private static final String INPATIENT_RECORD_SQL = " ,INPATIENT_RECORD AS(SELECT REFERRAL_HOSPITAL_CODE,EHR_ID,INHOS_DATE,OUT_HOSPITAL_DATE"
    		+ " ,CASE WHEN (INHOS_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND INHOS_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) THEN 1 ELSE 0 END INHOS_FLAG"
    		+ " ,CASE WHEN (OUT_HOSPITAL_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND OUT_HOSPITAL_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) THEN 1 ELSE 0 END OUTHOS_FLAG"
            + " ,CASE WHEN (INHOS_DATE <=TO_DATE('%3$s','yyyy/MM/dd') AND OUT_HOSPITAL_DATE >=TO_DATE('%3$s','yyyy/MM/dd')) THEN 1 ELSE 0 END ATHOS_FLAG"//在院
    		+ " ,PERSONAL_EXPENSES"//个人承担费用(元)
    		+ " ,MEDICAL_INSURANCE_COST_SUM"//医疗保险金额(元)
    		+ " ,OTHER_SUBSIDIES_COST_SUM"//其他补助金额(元)
    		+ " ,INHOS_COST_SUM"//总费用
            + " ,DECODE(INHOS_DAYS,NULL,DECODE(OUT_HOSPITAL_DATE,NULL,0,TRUNC(OUT_HOSPITAL_DATE)-TRUNC(INHOS_DATE)),INHOS_DAYS) IN_DAYS"//住院日数
    		+ " FROM SY_RMSDB_MS_INPATIENT_INFO"
            + " WHERE %7$s AND (INHOS_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND INHOS_DATE<=TO_DATE('%3$s','yyyy/MM/dd')))";
            /*+ " OR (OUT_HOSPITAL_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND OUT_HOSPITAL_DATE<=TO_DATE('%3$s','yyyy/MM/dd')))"*/
    /**
     * 综合管理-住院信息
     */
    private static final String INPATIENT_SQL = " SELECT medical.* "
    		+ " ,ROUND(DECODE(medical.doctorNum,0,0,NVL(medical.outHosNum,0)/medical.doctorNum),4) workload"//住院人均工作量=出院人次/医务人员数
            + " ,ROUND(DECODE(medical.outHosNum,0,0,NVL(medical.TOTALCOST,0)/medical.outHosNum),4) outCostAvg"//平均住院费用=总费用/病人数(出院)
            + " ,ROUND(DECODE(medical.outHosNum,0,0,NVL(medical.inDays,0)/medical.outHosNum),4) inDaysAvg"//平均住院日=总住院日/病人数(出院)
    		+ " FROM(SELECT %5$s"
    		+ " ,SUM(inpatient.inHosNum) inHosNum,SUM(inpatient.outHosNum) outHosNum"
            + " ,SUM(surgeryNum) AS surgeryNum "//出院病人手术数，根据手术费用判断 从V_RMSDB_SURGERY_INFO取
            + " ,SUM(anesthesiaNum) AS anesthesiaNum "//出院病人麻醉数，根据麻醉费判断 从V_RMSDB_SURGERY_INFO取
            + " ,SUM(inpatient.PERSONAL_EXPENSES) AS PCOST "//个人费用 取自MS_INPATIENT_INFO
            + " ,SUM(inpatient.MEDICAL_INSURANCE_COST_SUM) AS YBCOST "//医保费用 取自MS_INPATIENT_INFO
            + " ,SUM(inpatient.OTHER_SUBSIDIES_COST_SUM) AS OCOST "//其他补助金额 取自MS_INPATIENT_INFO
            + " ,SUM(inpatient.INHOS_COST_SUM) AS TOTALCOST "//合计费用 取自MS_INPATIENT_INFO
    		+ " ,SUM(SICKBED_COUNT) sickbedCount"//在院病人数
    		+ " ,NVL(SUM(STAFF.STAFF_COUNT),0) doctorNum"//医生人数
            + " ,SUM(IN_DAYS) inDays"//住院日数,病人已经出院
    		+ " FROM MDM_ORGANIZATION ORG"
    		+ " LEFT JOIN("
    		+ " 	SELECT REFERRAL_HOSPITAL_CODE"
    		+ " 		,COUNT(DECODE(INHOS_FLAG,1,1,0,NULL,NULL)) inHosNum"//入院病人数
       		+ " 		,COUNT(DECODE(OUTHOS_FLAG,1,1,0,NULL,NULL)) outHosNum"//出院病人数
            + " 		,COUNT(DECODE(ATHOS_FLAG,1,1,0,NULL,NULL)) SICKBED_COUNT"//在院病人数
            + "         ,SUM(DECODE(OUTHOS_FLAG,1,IN_DAYS,0)) IN_DAYS"//住院日数,病人已经出院
    		+ " "//住院人均工作量
    		+ " 		,SUM(DECODE(OUTHOS_FLAG,1,PERSONAL_EXPENSES,0)) PERSONAL_EXPENSES"//个人费用
    		+ " 		,SUM(DECODE(OUTHOS_FLAG,1,MEDICAL_INSURANCE_COST_SUM)) MEDICAL_INSURANCE_COST_SUM"//医保费用    		
    		+ " 		,SUM(DECODE(OUTHOS_FLAG,1,OTHER_SUBSIDIES_COST_SUM)) OTHER_SUBSIDIES_COST_SUM"//其他补助金额
    		+ " 		,SUM(DECODE(OUTHOS_FLAG,1,INHOS_COST_SUM)) INHOS_COST_SUM"//合计费用
    		+ " 	FROM INPATIENT_RECORD"//住院摘要表
    		+ " 	GROUP BY REFERRAL_HOSPITAL_CODE"
    		+ " )inpatient on org.ORGAN_CODE = inpatient.REFERRAL_HOSPITAL_CODE"
    		+ " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = org.ORGAN_CODE"
    		//关联手术表
    		+ " LEFT JOIN("
    		+ " 	SELECT HOSPITAL_CODE"
    		+ "			,COUNT(DECODE(OP_EM_HP_MARK,3,1,NULL)) surgeryNum"//出院病人手术数
    		+ "			,COUNT(DECODE(OP_EM_HP_MARK,3,DECODE(ANESTHESIA_METHOD_CODE,NULL,NULL,1),NULL)) anesthesiaNum"//出院病人麻醉数
    		+ "		FROM V_RMSDB_SURGERY_INFO"
    		+ " 	WHERE %8$s AND (OPERTATION_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND OPERTATION_DATE<=TO_DATE('%3$s','yyyy/MM/dd'))"
    		+ " 	GROUP BY HOSPITAL_CODE"
    		+ " ) SURINFO ON org.ORGAN_CODE = SURINFO.HOSPITAL_CODE "
    		+ " GROUP BY %4$s) medical";
 
    /**
     * 综合管理-住院信息-床位使用情况
     */
    private static final String SICKBED_STATE_SQL = ",SICKBED AS(SELECT HOSPITAL_CODE,COUNT(1) SICKBED_COUNT FROM V_RMSDB_MS_SICKBED_STATE"
    		+ " WHERE (CREATE_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND CREATE_DATE<=TO_DATE('%3$s','yyyy/MM/dd'))"
    		+ " GROUP BY HOSPITAL_CODE)";
    
    private static final String DRUG_USAGE_SQL = ",DRUG AS(SELECT EHR_ID,PERSON_ID,REFERRAL_HOSPITAL_CODE"
    		+ " ,CM_TYPE,DRUG_TYPE,DRUG_MEDICARE_CODE,BASE_DRUG_FLAG"
    		+ " ,UNIT_PRICE*QUANTITY DRUG_COST,CLINIC_DATE,START_DATE"
    		+ " FROM SY_RMSDB_MS_DRUG_USAGE"
    		+ " WHERE %9$s"
    		+ " AND (START_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND START_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) %7$s)";
    
    /**
     * 费用明细
     */
    private static final String EXPENSE_DETAIL_SQL = ",EXPENSE_DETAIL AS (SELECT EHR_ID,PERSON_ID,HOSPITAL_CODE,CLINIC_DATE"
    		+ " ,MEDICARE_CODE,CLINIC_MARK,EXPENSE_TYPE,COST_NUMBER"
    		+ " ,DETAIL_ITEM_QUANTITY,DETAIL_ITEM_PRICE"
    		+ " ,NVL(DETAIL_ITEM_QUANTITY*DETAIL_ITEM_PRICE,0) AMOUNT"
    		+ " FROM V_RMSDB_MS_EXPENSE_DETAIL"
    		+ " WHERE 1=1 %6$s)";

   
    /**
     * 费用表
     */
    private static final String EXPENSE_SQL = ",EXPENSE AS (SELECT EHR_ID,PERSON_ID,HOSPITAL_CODE,COST_NUMBER,SETTLEMENT_DATE"
    		+ " ,COST_TYPE_CODE,TOTAL_COST,OP_EM_HP_MARK"
       		+ " FROM SY_RMSDB_MS_EXPENSE_INFO"
    		+ " WHERE (SETTLEMENT_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND SETTLEMENT_DATE <= TO_DATE('%3$s','yyyy/MM/dd')) %6$s  %8$s)" ;
    

    private static final String HOSPITAL_COST_SQL = " SELECT medical.* FROM("
    		+ " SELECT %5$s,SUM(hospital.COST01) COST01,SUM(hospital.COST02) COST02,SUM(hospital.COST03) COST03"
    		+ " 	,SUM(DRUG_USAGE.COST04) COST04,SUM(DRUG_USAGE.COST05) COST05"
    		+ " 	,SUM(hospital.COST06) COST06,SUM(hospital.COST07) COST07"
    		+ " 	,SUM(hospital.COST08) COST08,SUM(hospital.COST09) COST09"
    		+ " 	,SUM(hospital.COST10) COST10,SUM(hospital.COST11) COST11"
    		+ " 	,SUM(hospital.COST12) COST12,SUM(hospital.COST13) COST13,SUM(hospital.COST99) COST99"
    		+ " 	,SUM(hospital.diagnosticAmount) diagnosticAmount,SUM(hospital.inspectionAmount) inspectionAmount"
    		+ " FROM MDM_ORGANIZATION_V ORG"
    		//费用表:统计诊查费,检查费,中药,中成药,西药
    		+ " LEFT JOIN("
    		+ " 	SELECT HOSPITAL_CODE"
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '04' THEN TOTAL_COST ELSE 0 END) diagnosticAmount"//诊查费
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '05' THEN TOTAL_COST ELSE 0 END) inspectionAmount"//检查费
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '03' THEN TOTAL_COST ELSE 0 END) COST01"//中药
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '02' THEN TOTAL_COST ELSE 0 END) COST02"//中成药
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '01' THEN TOTAL_COST ELSE 0 END) COST03"//西药
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '06' THEN TOTAL_COST ELSE 0 END) COST06"//化验费    		
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '07' THEN TOTAL_COST ELSE 0 END) COST07"//放射费    	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '08' THEN TOTAL_COST ELSE 0 END) COST08"//治疗费   	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '09' THEN TOTAL_COST ELSE 0 END) COST09"//手术费   	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '10' THEN TOTAL_COST ELSE 0 END) COST10"//输血费   	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '11' THEN TOTAL_COST ELSE 0 END) COST11"//床位费 	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '12' THEN TOTAL_COST ELSE 0 END) COST12"//护理费    	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '13' THEN TOTAL_COST ELSE 0 END) COST13"//麻醉费   	
    		+ " 		,SUM(CASE WHEN COST_TYPE_CODE = '99' THEN TOTAL_COST ELSE 0 END) COST99"//其他    	
    		+ " 	FROM EXPENSE"
    		+ "		GROUP BY HOSPITAL_CODE"
    		+ " )hospital on org.ORGAN_CODE = hospital.HOSPITAL_CODE"
    		//用药表,统计药品收入:基药,非基药
    		+ " LEFT JOIN("
    		+ " 	SELECT REFERRAL_HOSPITAL_CODE"
    		+ " 	,SUM(CASE WHEN BASE_DRUG_FLAG = '1' THEN DRUG_COST ELSE 0 END) COST04"//基药
    		+ " 	,SUM(CASE WHEN BASE_DRUG_FLAG = '0' THEN DRUG_COST ELSE 0 END) COST05"//非基药    		
    		+ "		FROM DRUG"
    		+ " 	WHERE (START_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND START_DATE <= TO_DATE('%3$s','yyyy/MM/dd'))"
    		+ " 	GROUP BY REFERRAL_HOSPITAL_CODE"
    		+ " ) DRUG_USAGE on org.ORGAN_CODE = DRUG_USAGE.REFERRAL_HOSPITAL_CODE"
    		+ " GROUP BY %4$s) medical";
    
    /**
     * 机构医务人员数
     */
    private static final String STAFF_SQL = ",STAFF AS(SELECT ORGAN_CODE,COUNT(1) STAFF_COUNT FROM V_MDM_STAFF WHERE %6$s GROUP BY ORGAN_CODE)";
    
    /**
     * 绩效指标：门诊相关绩效指标
     */
    private static final String OUTPATIENT_PERFORMANCE_SQL = ",OUTPATIENT AS("
    		+ " SELECT CLINIC_ORGAN_CODE,VISIT_NUM,OUTPATIENT_COST,PRESCRIPTION_COUNT,USE_ROUTE_COUNT,PRESCRIPTION_TOTAL_COST"
    		+ " FROM("
    		+ " SELECT CLINIC_ORGAN_CODE"
    		+ " ,COUNT(DECODE(VISIT_STATUS,2,1,NULL)) VISIT_NUM"//就诊人数
    		+ " ,SUM(OUTPATIENT_COST_SUM) OUTPATIENT_COST"//就诊总费用
    		+ " ,SUM(PRESCRIPTION_COUNT) PRESCRIPTION_COUNT"//处方数
    		+ " ,SUM(PRESCRIPTION_ROUTE_COUNT) USE_ROUTE_COUNT"//静滴处方数
    		+ " ,SUM(PRESCRIPTION_TOTAL_COST) PRESCRIPTION_TOTAL_COST"//处方总费用
     		+ " FROM ("
     		+ " 	SELECT CLINIC_ORGAN_CODE,OUTPATIENT.EHR_ID,VISIT_STATUS"
     		+ " 		,OUTPATIENT_COST_SUM,CLINIC_DATE"
     		+ " 		,PRESCRIPTION_COUNT,PRESCRIPTION_ROUTE_COUNT"//处方数,静滴处方数
     		+ "			,PRESCRIPTION.PRESCRIPTION_TOTAL_COST"
     		+ " 	FROM ("
     		+ "				 SELECT CLINIC_ORGAN_CODE,CLINIC_DATE,EHR_ID,VISIT_STATUS,OUTPATIENT_COST_SUM"
     		+ "					,PRESCRIPTION_COUNT,PRESCRIPTION_ROUTE_COUNT"
     		+ "				 FROM SY_RMSDB_MS_OUTPATIENT_INFO"
     		+ " 			 WHERE %7$s AND (CLINIC_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) "//门诊摘要表条件
     		+ "		)OUTPATIENT"
    		+ " 	LEFT JOIN ("
     		+ " 		SELECT HOSPITAL_CODE,EHR_ID"
     		+ "				,SUM(PRESCRIPTION_TOTAL_COST) PRESCRIPTION_TOTAL_COST "//处方总费用
     		+ "			FROM SY_RMSDB_MS_OUT_PRESCRIPTION "
     		+ "			WHERE %9$s AND (PRESCRIBE_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND PRESCRIBE_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) "//处方表条件
     		+ "			GROUP BY HOSPITAL_CODE,EHR_ID "
    		+ " 	)PRESCRIPTION ON (OUTPATIENT.EHR_ID = PRESCRIPTION.EHR_ID AND OUTPATIENT.PRESCRIPTION_COUNT > 0)"
    		
     		+ "	)"
    		+ " GROUP BY CLINIC_ORGAN_CODE) OUT_INFO)";
     
    /**
     * 绩效指标：住院部分
     */
    private static final String INPATIENT_PERFORMANCE_SQL = " ,INPATIENT AS("
    		+ " SELECT REFERRAL_HOSPITAL_CODE"
    		//+ " ,SUM(DECODE(INHOS_DATE,NULL,0,DECODE(OUT_HOSPITAL_DATE,NULL,0,TRUNC(OUT_HOSPITAL_DATE)-TRUNC(INHOS_DATE)))) IN_DAYS"//住院日数
    		+ " ,SUM(DECODE(INHOS_DAYS,NULL,DECODE(OUT_HOSPITAL_DATE,NULL,0,TRUNC(OUT_HOSPITAL_DATE)-TRUNC(INHOS_DATE)),INHOS_DAYS)) IN_DAYS"//住院日数
    		+ " ,COUNT(1) OUT_NUM"//出院人次数
    		+ " ,SUM(INHOS_COST_SUM) IN_COST"//住院总费用
    		+ " FROM SY_RMSDB_MS_INPATIENT_INFO"
    		+ " WHERE %8$s AND OUT_HOSPITAL_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND OUT_HOSPITAL_DATE<=TO_DATE('%3$s','yyyy/MM/dd') "
    		+ " GROUP BY REFERRAL_HOSPITAL_CODE)";
    
    /**
     * 药品费编码
     */
    private static final String DRUG_TYPE_CODE = "'01','02','03'";
    /**
     * 绩效指标：药占比
     */
    private static final String EXPENSE_PERFORMANCE_SQL = ",EXPENSE AS ("
    		+ " SELECT HOSPITAL_CODE"
    		+ " 	,SUM(TOTAL_COST) AMOUNT"//总费用
    		+ " 	,SUM(CASE WHEN COST_TYPE_CODE IN("+ DRUG_TYPE_CODE +") THEN TOTAL_COST ELSE 0 END) DRUG_AMOUNT"//药品总费用
    		+ " FROM SY_RMSDB_MS_EXPENSE_INFO"
    		+ " WHERE %9$s AND SETTLEMENT_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND SETTLEMENT_DATE<=TO_DATE('%3$s','yyyy/MM/dd') "
    		+ " GROUP BY HOSPITAL_CODE)";

    private static final String PERFORMANCE_SQL = " SELECT medical.*"
    		+ " ,ROUND(DECODE(SIGN(NVL(STAFF_COUNT,0)),0,0,NVL(VISIT_NUM,0)/STAFF_COUNT),2) outpatientCount"//人均门急诊人次数
    		+ " ,ROUND(DECODE(SIGN(NVL(VISIT_NUM,0)),0,0,NVL(OUTPATIENT_COST,0)/VISIT_NUM),2) outpatientCost"//门急诊次均费用
    		+ " ,ROUND(DECODE(SIGN(NVL(STAFF_COUNT,0)),0,0,NVL(IN_DAYS,0)/STAFF_COUNT),2) avgDays"//人均出院病人床日数=出院病人总床日数/医务人员数
    		+ " ,ROUND(DECODE(SIGN(NVL(OUT_NUM,0)),0,0,NVL(IN_COST,0)/OUT_NUM),2) inpatientCost"//出院病人次均费用=住院总费用/出院人次数
    		+ " ,ROUND(DECODE(SIGN(NVL(AMOUNT,0)),0,0,NVL(DRUG_AMOUNT,0)/AMOUNT),4) amountRate"//药占比
    		+ " ,ROUND(DECODE(PRESCRIPTION_COUNT,0,0,NVL(USE_ROUTE_COUNT,0)/PRESCRIPTION_COUNT),4) prescriptionRate"//门急诊点滴处方比例
    		+ " ,ROUND(DECODE(PRESCRIPTION_COUNT,0,0,NVL(PRESCRIPTION_TOTAL_COST,0)/PRESCRIPTION_COUNT),4) prescriptionTotalAvg"//平均处方费用
    		+ " FROM(SELECT %5$s"
    		+ " ,NVL(SUM(OUTPATIENT.VISIT_NUM),0) VISIT_NUM,SUM(OUTPATIENT.OUTPATIENT_COST) OUTPATIENT_COST,NVL(SUM(STAFF.STAFF_COUNT),0) STAFF_COUNT"
    		+ " ,SUM(INPATIENT.IN_DAYS) IN_DAYS,NVL(SUM(INPATIENT.OUT_NUM),0) OUT_NUM,SUM(INPATIENT.IN_COST) IN_COST"
    		+ " ,SUM(EXPENSE.AMOUNT) AMOUNT,SUM(EXPENSE.DRUG_AMOUNT) DRUG_AMOUNT"
    		+ " ,NVL(SUM(OUTPATIENT.PRESCRIPTION_COUNT),0) PRESCRIPTION_COUNT"//处方数
    		+ " ,SUM(OUTPATIENT.USE_ROUTE_COUNT) USE_ROUTE_COUNT"//静滴处方数    	
    		+ " ,SUM(OUTPATIENT.PRESCRIPTION_TOTAL_COST) PRESCRIPTION_TOTAL_COST"//处方总费用
    		+ " FROM MDM_ORGANIZATION_V ORG"
    		+ " LEFT JOIN OUTPATIENT ON OUTPATIENT.CLINIC_ORGAN_CODE = ORG.ORGAN_CODE"
    		+ " LEFT JOIN INPATIENT ON INPATIENT.REFERRAL_HOSPITAL_CODE = ORG.ORGAN_CODE"
    		+ " LEFT JOIN EXPENSE ON EXPENSE.HOSPITAL_CODE = ORG.ORGAN_CODE"
    		+ " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = ORG.ORGAN_CODE"
    		+ " GROUP BY %4$s) medical";
    
    /**
     * 绩效指标-个人指标-医疗考核：门诊相关绩效指标
     */
    private static final String PERSON_OUTPATIENT_SQL = " SELECT CLINIC_ORGAN_CODE organCode,MANA_DOCTOR_NO doctorNo"//挂号次数
    		+ ",DECODE(MANA_DOCTOR_NAME,NULL,MANA_DOCTOR_NO,MANA_DOCTOR_NAME) doctorName"
    		+ ",COUNT(1) registerNum"
       		+ " FROM V_RMSDB_OUTPATIENT_INFO "
    		+ " WHERE (CLINIC_DATE>=TO_DATE('%1$s','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('%2$s','yyyy/MM/dd')) %3$s"
    		+ " GROUP BY CLINIC_ORGAN_CODE,MANA_DOCTOR_NO,MANA_DOCTOR_NAME"
    		+ " ORDER BY CLINIC_ORGAN_CODE,MANA_DOCTOR_NAME,MANA_DOCTOR_NO";
 
    /**
     * 绩效指标-个人指标-医疗考核：处方相关绩效指标
     */
    private static final String PERSON_PRESCRIPTION_SQL = " SELECT HOSPITAL_CODE organCode,PRESCRIBE_DOCTOR_NO doctorNo"
    		+ ",COUNT(1) prescriptionNum "//处方量
    		+ ",DECODE(PRESCRIBE_DOCTOR_NAME,NULL,PRESCRIBE_DOCTOR_NO,PRESCRIBE_DOCTOR_NAME) doctorName"    		
    		+ " ,COUNT(DECODE(IF_CHARGE,1,1,NULL)) chargeNum"//收费处方
    		+ " ,ROUND(AVG(PRESCRIPTION_TOTAL_COST),2) avgTotalCost"//平均处方数量
       		+ " FROM SY_RMSDB_MS_OUT_PRESCRIPTION "
    		+ " WHERE (PRESCRIBE_DATE>=TO_DATE('%1$s','yyyy/MM/dd') AND PRESCRIBE_DATE<=TO_DATE('%2$s','yyyy/MM/dd')) %3$s"
    		+ " GROUP BY HOSPITAL_CODE,PRESCRIBE_DOCTOR_NO,PRESCRIBE_DOCTOR_NAME"
    		+ " ORDER BY HOSPITAL_CODE,PRESCRIBE_DOCTOR_NAME,PRESCRIBE_DOCTOR_NO";
    
    /**
     * 监测状态统计
     */
    private static final String SYMPTOM_SQL = " SELECT symptom.* FROM(SELECT %2$s"
    		+ " FROM MDM_ORGANIZATION ORG"
    		+ " GROUP BY %3$s) symptom";
    
    private String getOrgSql(String genreCode, String gbCode, String parentCode, String organCode){
    	StringBuilder result = new StringBuilder(" SELECT ORGAN_CODE FROM MDM_ORGANIZATION");
    	result.append(" WHERE 1=1 ");
    	if(StringUtil.isNotEmpty(genreCode) && !"0".equals(genreCode)){
    		result.append(" AND GENRE_CODE = '" + genreCode + "'");
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		result.append(" AND GB_CODE = '" + gbCode + "'");
    	}
    	if(StringUtil.isNotEmpty(parentCode)){
    		result.append(" AND PARENT_CODE = '" + parentCode + "'");
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		result.append(" AND ORGAN_CODE = '" + organCode + "'");
    	}    	
    	return result.toString();
    }
    /**
     * 个人绩效-医疗考核,type=1,门诊摘要,type=2,处方
     *
     * @param paramMap
     * @param type
     * @return
     * @author Ye jianfei
     */
    private String getMedicalSql(Map<String, String> paramMap,String type){
        String organCode = paramMap.get("organCode");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
    	String orgWhere = "";
    	StringBuilder sql = new StringBuilder();
    	if("1".equals(type)){
    		sql.append(PERSON_OUTPATIENT_SQL);
   			orgWhere = StringUtil.isNotEmpty(organCode)?" AND CLINIC_ORGAN_CODE='" + organCode.toString() + "'":"";
    	}else if("2".equals(type)){
    		sql.append(PERSON_PRESCRIPTION_SQL);
    		orgWhere = StringUtil.isNotEmpty(organCode)?" AND HOSPITAL_CODE='" + organCode.toString() + "'":"";
    	}
     	return String.format(sql.toString(),beginDate,endDate,orgWhere);
    }
    
    private String getInpatientSql(String beginDate
    		, String endDate
    		, String genreCode
    		, Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + INPATIENT_RECORD_SQL + STAFF_SQL +  INPATIENT_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	Object gbCodeObj = ca.get("GB_CODE");
    	String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
    	Object parentCodeObj = ca.get("PARENT_CODE");
    	String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";
    	Object organCodeObj = ca.get("organ_Code");
    	String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";
    	String organCodeWhere = " REFERRAL_HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	String staffOrganCode = " ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	String surinfoOrganCode = " HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,staffOrganCode,organCodeWhere,surinfoOrganCode);
    }
    
    private String getOutpatientSql(String beginDate
    		, String endDate
    		, String genreCode
    		, Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + OUTPATIENT_DRUG_USAGE_SQL + STAFF_SQL +  OUTPATIENT_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	Object organCodeObj = ca.get("organ_Code");
    	String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";

    	Object gbCodeObj = ca.get("GB_CODE");
    	String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
    	Object parentCodeObj = ca.get("PARENT_CODE");
    	String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";
    	String organCodeWhere = " CLINIC_ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	String staffOrganCode = " ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	String surgeryOrganCode = " HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,staffOrganCode,organCodeWhere,surgeryOrganCode);
    }
    
    private String getHospitalCostsSql(String beginDate
    		, String endDate
    		, String genreCode
    		, String opEmHpMark
    		, Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + DRUG_USAGE_SQL + EXPENSE_SQL +  HOSPITAL_COST_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	Object organCodeObj = ca.get("organ_Code");
    	String expenseOrganCode = ObjectUtil.isNotEmpty(organCodeObj)?"AND HOSPITAL_CODE='" + organCodeObj.toString() + "'":"";
    	String expenseMark = "";//费用表门急诊标志条件
    	String drugUsageMark = "";//用药表门急诊标志条件
    	if("1".equals(opEmHpMark)){
    		drugUsageMark = " AND CLINIC_MARK IN('1','2') ";
    		expenseMark = " AND OP_EM_HP_MARK IN('1','2') ";
    	}else if("2".equals(opEmHpMark)){
    		drugUsageMark = " AND CLINIC_MARK IN('3') ";
    		expenseMark = " AND OP_EM_HP_MARK IN('3') ";
    	}
    	String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";
    	Object gbCodeObj = ca.get("GB_CODE");
    	String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
    	Object parentCodeObj = ca.get("PARENT_CODE");
    	String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";
    	String organCodeWhere = " REFERRAL_HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,expenseOrganCode,drugUsageMark,expenseMark,organCodeWhere);
    }
    
    private String getServiceCapacitySql(String beginDate
    		, String endDate
    		, String genreCode
    		, Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + STAFF_SQL 
    			+ OUTPATIENT_PERFORMANCE_SQL +  INPATIENT_PERFORMANCE_SQL
    			+ EXPENSE_PERFORMANCE_SQL + PERFORMANCE_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	String staffOrgWhere = "";
    	String outpatientOrgWhere = "";
    	String expenseOrgWhere = "";
    	String inpatientOrgWhere = "";
    	String prescriptionWhere = "";
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	Object organCodeObj = ca.get("organ_Code");
    	String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";
    	Object gbCodeObj = ca.get("GB_CODE");
    	String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
    	Object parentCodeObj = ca.get("PARENT_CODE");
    	String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";    	
    	staffOrgWhere = " ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";//医务人员机构条件
    	outpatientOrgWhere =  " CLINIC_ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	expenseOrgWhere =  " HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	inpatientOrgWhere =  " REFERRAL_HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	prescriptionWhere = " HOSPITAL_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
    	return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,staffOrgWhere,outpatientOrgWhere,inpatientOrgWhere,expenseOrgWhere,prescriptionWhere);
    }
    
    private String getSymptomSql(String genreCode,Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + SYMPTOM_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
       	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);  
    	return String.format(sql.toString(),orgWhere.toString(),orgField,orgSelectField);
    }
    private Criteria getOrgCriteria(String genreCode,String gbCode,String parentCode,String organCode){
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(genreCode) && (!"0".equals(genreCode))){
    		ca.add("genre_Code",genreCode);
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("gb_Code",gbCode);
    	}
    	if(StringUtil.isNotEmpty(parentCode)){
    		if(OrgGenreCode.STATION.getValue().equals(genreCode)){
    			ca.add("parent_Code",parentCode);
    		}else{
    			ca.add("organ_Code",parentCode);
    		}
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		ca.add("organ_Code",organCode);
    	}
    	ca.add("GB_CODE",OP.UEMPTY,"");
    	ca.add("organ_Code",OP.UEMPTY,"");
    	return ca;
    }
    
    private String getOrgField(String genreCode,boolean isSelect){
    	String result = "";
    	switch(genreCode){
    		case "0":
    			result = isSelect?select_gb_code:"ROLLUP(GB_CODE)";
    			break;
    		case "B100":
    			result = isSelect?select_parent_code:"ROLLUP(GB_CODE,ORG.organ_code),parent_Code";
    			break;
    		case "B200":
    			result = isSelect?select_organ_code:"ROLLUP(GB_CODE,parent_Code,ORG.organ_Code)";
    			break;
    		case "A100":
    			result = isSelect?select_organ_code:"ROLLUP(GB_CODE,ORG.organ_code),parent_Code";
    			break;

    	}
    	return result;
    }
	@Override
	public List<Map<String, Object>> getOutpatientList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getOutpatientSql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	} 
	
	@Override
	public List<Map<String, Object>> getInpatientList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getInpatientSql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getHospitalCostsList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode,String opEmHpMark) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getHospitalCostsSql(beginDate,endDate,genreCode,opEmHpMark,ca);
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getServiceCapacityList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getServiceCapacitySql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	}

	@Override
	public PageList<Map<String, Object>> getPersonRegisterPerformance(Map<String, String> paramMap, Page page){
		String sql = getMedicalSql(paramMap,"1");
		return getPageMapList(page, sql.toString(), new Criteria());
	}
	
	@Override
	public PageList<Map<String, Object>> getPersonPrescriptionPerformance(Map<String, String> paramMap, Page page){
		String sql = getMedicalSql(paramMap,"2");
		return getPageMapList(page, sql.toString(), new Criteria());
	}
	
	@Override
	public List<Map<String, Object>> getSymptomList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode){
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
//		String sql = getSymptomSql(genreCode,ca);
        StringBuilder sql = new StringBuilder("SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, GENRE_CODE\n" +
                "    FROM MDM_ORGANIZATION");
        sql.append(" WHERE 1 = 1");
        if(StringUtil.isNotEmpty(genreCode) && !"0".equals(genreCode)){
            sql.append(" AND GENRE_CODE = '"+genreCode+"' ");
        }
        if(StringUtil.isNotEmpty(gbCode)){
            sql.append(" AND GB_CODE = '"+gbCode+"' ");
        }
        if(("A1".equals(genreCode) ||"B1".equals(genreCode)) && StringUtil.isNotEmpty(parentCode)){
            sql.append(" AND ORGAN_CODE = '"+parentCode+"'");
        }
        if("B2".equals(genreCode) ){
            if(StringUtil.isNotEmpty(parentCode)){
                sql.append(" AND PARENT_CODE = '"+parentCode+"'");
            }
            if(StringUtil.isNotEmpty(organCode)){
                sql.append(" AND ORGAN_CODE = '"+organCode+"'");
            }
        }
		return this.getMapList(sql.toString(),ca);
	}
    /**
     * 公共卫生服务项目指标
     */
    @Override
    public List<Map<String, Object>> getServiceProjectPerformance(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode){
        Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
        String sql = getServiceProjectSql(beginDate,endDate,genreCode,ca);
        return this.getMapList(sql,ca);
    }

    private static final String STAFF_SQL4 = ",STAFF AS(SELECT ORGAN_CODE,COUNT(*) STAFF_COUNT FROM V_MDM_STAFF GROUP BY ORGAN_CODE)";

    private String getServiceProjectSql(String beginDate
            , String endDate
            , String genreCode
            , Criteria ca){
        StringBuilder sql = new StringBuilder(ORG_SQL + STAFF_SQL4
                + VAC_SQL + OUTPATIENT_PERFORMANCE_SQL4 + HBP_DIS_SQL + DI_DIS_SQL + WOMAN_DISEASE_SQL+ OCK_SQL + PERFORMANCE_SQL4);
        //机构条件
        StringBuilder orgWhere =  new StringBuilder();
        //机构字段
        String orgField = getOrgField(genreCode,false);
        //SELECT字段
        String orgSelectField = getOrgField(genreCode,true);
        SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
        //儿保标识 MEDICAL_ROOM_CODE IN ('010101020509', '0052')
        String erBaoFlag = "'010101020509', '0052'";
        return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,erBaoFlag);
    }

    /**
     * 机构绩效指标：人均儿保门诊人数
     */
    private static final String OUTPATIENT_PERFORMANCE_SQL4 = ",OUTPATIENT AS("
            + " SELECT CLINIC_ORGAN_CODE, STAFF.STAFF_COUNT, ERBAO_COUNT "
            + " FROM("
            + " SELECT CLINIC_ORGAN_CODE, COUNT(1) AS ERBAO_COUNT "
            + " FROM V_RMSDB_OUTPATIENT_INFO OUT_INFO"
            + " WHERE (CLINIC_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND CLINIC_DATE<=TO_DATE('%3$s','yyyy/MM/dd'))"
            + " AND MEDICAL_ROOM_CODE IN (%6$s) " //儿保
            + " GROUP BY CLINIC_ORGAN_CODE) OUT_INFO"
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = OUT_INFO.CLINIC_ORGAN_CODE)";

    /**
     * 机构绩效指标：人均管理糖尿病人数
     */
    private static final String DI_DIS_SQL = ",DI AS("
            + " SELECT CREATE_ORGAN_CODE, STAFF.STAFF_COUNT,DI_COUNT "
            + " FROM("
            + " SELECT DIS.CREATE_ORGAN_CODE, COUNT(1) AS DI_COUNT "
            + " FROM SY_DMD_DM_DISEASE_INFO DIS, SY_DMD_DM_PERSON_INFO PER "
            + " WHERE PER.TYPE = 2 AND DI_FLAG = 2 AND DIS.IS_DELETE = 0 AND PER.PERSON_ID = DIS.PERSON_ID "
            + " AND (DIS.CREATE_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND DIS.CREATE_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) "
            + " GROUP BY DIS.CREATE_ORGAN_CODE) DI_DIS"
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = DI_DIS.CREATE_ORGAN_CODE)";


    /**
     * 机构绩效指标：人均妇女病普查人数
     */
    private static final String WOMAN_DISEASE_SQL = ", WD AS("
            + " SELECT CREATE_ORGAN_CODE, STAFF.STAFF_COUNT, WD_COUNT "
            + " FROM("
            + " SELECT CREATE_ORGAN_CODE, COUNT(1) AS WD_COUNT "
            + " FROM SY_WHCH_WH_WOM_DIS_CENSUS "
            + " WHERE (CHECK_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND CHECK_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) "
            + " GROUP BY CREATE_ORGAN_CODE) WDC"
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = WDC.CREATE_ORGAN_CODE)";

    /**
     * 机构绩效指标：人均管理高血压人数
     */
    private static final String HBP_DIS_SQL = ",HBP AS("
            + " SELECT CREATE_ORGAN_CODE, STAFF.STAFF_COUNT,HBP_COUNT "
            + " FROM("
            + " SELECT DIS.CREATE_ORGAN_CODE, COUNT(1) AS HBP_COUNT "
            + " FROM SY_DMD_DM_DISEASE_INFO DIS, SY_DMD_DM_PERSON_INFO PER "
            + " WHERE PER.TYPE = 2 AND HBP_FLAG = 2 AND DIS.IS_DELETE = 0 AND PER.PERSON_ID = DIS.PERSON_ID "
            + " AND (DIS.CREATE_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND DIS.CREATE_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) "
            + " GROUP BY DIS.CREATE_ORGAN_CODE) HBP_DIS"
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = HBP_DIS.CREATE_ORGAN_CODE)";

    /**
     * 机构绩效指标：人均预防接种人次数
     */
    private static final String VAC_SQL = ", VAC AS("
            + " SELECT IMMU_UNIT_ID, STAFF.STAFF_COUNT, VAC_COUNT "
            + " FROM("
            + " SELECT IMMU_UNIT_ID, COUNT(1) AS VAC_COUNT "
            + " FROM SY_RDMDB_DC_VACCINATION_INFO "
            + " WHERE (VACCINATION_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND VACCINATION_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) "
            + " GROUP BY IMMU_UNIT_ID) VACC"
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = VACC.IMMU_UNIT_ID)";

    /**
     * 机构绩效指标：人均老年人管理（健康体检）人数
     */
    private static final String OCK_SQL = ",OCK AS("
            + " SELECT INPUT_SUPER_ORGAN_CODE, STAFF.STAFF_COUNT, OCK_COUNT "
            + " FROM("
            + " SELECT INPUT_SUPER_ORGAN_CODE, COUNT(1) AS OCK_COUNT "
            + " FROM ECH_PHYSICAL_EXAM_RECORD "
            + " WHERE EXAM_STATUS = 1 AND CONFIRM = 1 "
            + " AND (EXAM_YEAR>=TO_DATE('%2$s','yyyy/MM/dd') AND EXAM_YEAR<=TO_DATE('%3$s','yyyy/MM/dd')) "
            + " GROUP BY INPUT_SUPER_ORGAN_CODE) OCKG"
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = OCKG.INPUT_SUPER_ORGAN_CODE)";

    private static final String PERFORMANCE_SQL4 = " SELECT PER.*"
            + " , ROUND(VAC_COUNT / STAFF_COUNT, 0) AS VAC_AVG "//人均预防接种人数
            + " , ROUND(ERBAO_COUNT/STAFF_COUNT,0) AS EB_AVG "//人均儿保门诊人数
            + " , ROUND(HBP_COUNT / STAFF_COUNT, 0) AS HBP_AVG "//人均管理高血压人数
            + " , ROUND(DI_COUNT / STAFF_COUNT, 0) AS DI_AVG "//人均管理糖尿病人数
            + " , ROUND(WD_COUNT / STAFF_COUNT, 0) AS WD_AVG "//人均管理糖尿病人数
            + " , ROUND(OCK_COUNT / STAFF_COUNT, 0) AS OCK_AVG "//人均老年人管理（健康体检）人数
            + " FROM(SELECT %5$s "
            + " ,SUM(OUTPATIENT.ERBAO_COUNT) AS ERBAO_COUNT "
            + " ,SUM(HBP.HBP_COUNT) AS HBP_COUNT "
            + " ,SUM(VAC.VAC_COUNT) AS VAC_COUNT "
            + " ,SUM(DI.DI_COUNT) AS DI_COUNT "
            + " ,SUM(WD.WD_COUNT) AS WD_COUNT "
            + " ,SUM(OCK.OCK_COUNT) AS OCK_COUNT "
            + " ,SUM(STAFF.STAFF_COUNT) STAFF_COUNT "
            + " FROM MDM_ORGANIZATION ORG"
            + " LEFT JOIN VAC ON VAC.IMMU_UNIT_ID = ORG.ORGAN_CODE "
            + " LEFT JOIN OUTPATIENT ON OUTPATIENT.CLINIC_ORGAN_CODE = ORG.ORGAN_CODE"
            + " LEFT JOIN HBP ON HBP.CREATE_ORGAN_CODE = ORG.ORGAN_CODE "
            + " LEFT JOIN DI ON DI.CREATE_ORGAN_CODE = ORG.ORGAN_CODE "
            + " LEFT JOIN WD ON WD.CREATE_ORGAN_CODE = ORG.ORGAN_CODE "
            + " LEFT JOIN OCK ON OCK.INPUT_SUPER_ORGAN_CODE = ORG.ORGAN_CODE "
            + " LEFT JOIN STAFF ON STAFF.ORGAN_CODE = ORG.ORGAN_CODE "
            + " GROUP BY %4$s) PER";


    public List<Map<String, Object>> getClinicalPathwayStatistics(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
//        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
//                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
//                "    FROM MDM_ORGANIZATION\n" +
//                "   WHERE GENRE_CODE = 'A1'\n");
//        if(StringUtil.isNotEmpty(superOrganCode)){
//            sql.append(" AND ORGAN_CODE = '"+superOrganCode+"' ");
//        }
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
                "    FROM MDM_ORGANIZATION\n" +
                "   WHERE GENRE_CODE = '"+genreCode+"' \n");
                if(StringUtil.isNotEmpty(gbCode)){
                    sql.append(" AND GB_CODE = '"+gbCode+"' ");
                }
                if(("A100".equals(genreCode) ||"B100".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
                  sql.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
                }
                if("B200".equals(genreCode) ){
                    if(StringUtil.isNotEmpty(superOrganCode)){
                        sql.append(" AND PARENT_CODE = '"+superOrganCode+"'");
                    }
                    if(StringUtil.isNotEmpty(organCode)){
                        sql.append(" AND ORGAN_CODE = '"+organCode+"'");
                    }
                }
                sql.append("), CP AS\n" +
                " (SELECT HOSPITAL_CODE, DEPARTMENT_CODE, INTO_TIME, QUIT_TIME, COMPLETE_TIME, CURE_MARK, DEATH_MARK\n" +
                "    FROM SY_RMSDB_MS_CLINICAL_PATHWAY\n" +
                "   WHERE CREATE_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND CREATE_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')),\n" +
                "INP AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS INPCOUNT\n" +
                "    FROM CP\n" +
                "   WHERE CP.INTO_TIME IS NOT NULL\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "QUIT AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS QUITCOUNT\n" +
                "    FROM CP\n" +
                "   WHERE CP.QUIT_TIME IS NOT NULL\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "COMP AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS COMCOUNT\n" +
                "    FROM CP\n" +
                "   WHERE CP.COMPLETE_TIME IS NOT NULL\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "CURE AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS CURECOUNT\n" +
                "    FROM CP\n" +
                "   WHERE CP.CURE_MARK = '1'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "DEATH AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS DEATHCOUNT\n" +
                "    FROM CP\n" +
                "   WHERE CP.DEATH_MARK = '1'\n" +
                "   GROUP BY HOSPITAL_CODE)\n" +
                "SELECT ORG.ORGAN_CODE, ORG.GB_CODE,ORG.PARENT_CODE, ORG.ORGAN_NAME, INP.INPCOUNT, QUIT.QUITCOUNT, COMP.COMCOUNT, CURE.CURECOUNT, DEATH.DEATHCOUNT\n" +
                "  FROM ORG, INP, QUIT, COMP, CURE, DEATH\n" +
                " WHERE ORG.ORGAN_CODE = INP.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = QUIT.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = COMP.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = CURE.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = DEATH.HOSPITAL_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    /**
     * 治疗质量统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getCureResultAnalys(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
                "    FROM MDM_ORGANIZATION\n" +
                "   WHERE GENRE_CODE = '"+genreCode+"' \n");
                if(StringUtil.isNotEmpty(gbCode)){
                    sql.append(" AND GB_CODE = '"+gbCode+"' ");
                }
                if(("A1".equals(genreCode) ||"B1".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
                  sql.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
                }
                if("B2".equals(genreCode) ){
                    if(StringUtil.isNotEmpty(superOrganCode)){
                        sql.append(" AND PARENT_CODE = '"+superOrganCode+"'");
                    }
                    if(StringUtil.isNotEmpty(organCode)){
                        sql.append(" AND ORGAN_CODE = '"+organCode+"'");
                    }
                }
                sql.append(" ), ZYSW AS\n" +
                " (SELECT REFERRAL_HOSPITAL_CODE, COUNT(1) AS ZYSWNUM\n" +
                "    FROM SY_RMSDB_MS_INPATIENT_INFO --住院死亡数\n" +
                "   WHERE INHOS_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND INHOS_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD') AND DEATH_DATE IS NOT NULL\n" +
                "   GROUP BY REFERRAL_HOSPITAL_CODE),\n" +
                "ZDCY AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS ZDCYNUM\n" +
                "    FROM SY_RMSDB_MS_INP_MED_RECORD --自动出院数\n" +
                "   WHERE INHOS_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND INHOS_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD') AND OUTHOS_METHOD <> '4'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "ZYSS AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS ZYSSNUM\n" +
                "    FROM SY_RMSDB_MS_SURGERY_INFO --住院手术数\n" +
                "   WHERE OPERTATION_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND OPERTATION_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD') AND EHR_ID LIKE 'zy%'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "SSSW AS\n" +
                " (SELECT INPUT_ORGANCODE, COUNT(1) AS SSSWNUM\n" +
                "    FROM PERSON_DEATH_RECORD --手术死亡数\n" +
                "   WHERE DEATH_ICD = 'Y69' AND DEATH_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND DEATH_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')  \n" +
                "   GROUP BY INPUT_ORGANCODE),\n" +
                "WZQJ AS\n" +
                " (SELECT HOSPITAL_CODE, SUM(INHOS_RESCUE_TIMES) AS WZQJNUM\n" +
                "    FROM SY_RMSDB_MS_INP_MED_RECORD --危重抢救数\n" +
                "    WHERE INHOS_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND INHOS_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "WZSW AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS WZSWNUM\n" +
                "    FROM SY_RMSDB_MS_INP_MED_RECORD --危重死亡数\n" +
                "   WHERE INHOS_CONDITION = '1'\n" +
                "     AND OUTHOS_METHOD = '5'\n" +
                "     AND INHOS_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND INHOS_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XSESW AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XSESWNUM\n" +
                "    FROM SY_RMSDB_MS_INP_MED_RECORD --新生儿死亡人数\n" +
                "   WHERE MONTH_AGE <= 1\n" +
                "     AND INHOS_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND INHOS_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "     AND AGE IS NULL\n" +
                "     AND OUTHOS_METHOD = '5'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XSER AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XSERNUM\n" +
                "    FROM SY_RMSDB_MS_INP_MED_RECORD --新生儿人数\n" +
                "   WHERE MONTH_AGE <= 1\n" +
                "     AND INHOS_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND INHOS_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "     AND AGE IS NULL\n" +
                "   GROUP BY HOSPITAL_CODE)\n" +
                "SELECT ORG.ORGAN_CODE, ORG.ORGAN_NAME, ZYSW.ZYSWNUM, ZDCY.ZDCYNUM, ZYSS.ZYSSNUM, SSSW.SSSWNUM, WZQJ.WZQJNUM, WZSW.WZSWNUM, ROUND(XSESW.XSESWNUM/XSER.XSERNUM, 4) AS XSRDP\n" +
                "  FROM ORG, ZYSW, ZDCY, ZYSS, SSSW, WZQJ, WZSW, XSESW, XSER\n" +
                " WHERE ORG.ORGAN_CODE = ZYSW.REFERRAL_HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = ZDCY.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = ZYSS.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = SSSW.INPUT_ORGANCODE(+)\n" +
                "   AND ORG.ORGAN_CODE = WZQJ.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = WZSW.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XSESW.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XSER.HOSPITAL_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    /**
     * 检查结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getStudyAnalys(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
                "    FROM MDM_ORGANIZATION\n" +
                "   WHERE GENRE_CODE = '"+genreCode+"' \n" );
                if(StringUtil.isNotEmpty(gbCode)){
                    sql.append(" AND GB_CODE = '"+gbCode+"' ");
                }
                if(("A1".equals(genreCode) ||"B1".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
                    sql.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
                }
                if("B2".equals(genreCode) ){
                    if(StringUtil.isNotEmpty(superOrganCode)){
                        sql.append(" AND PARENT_CODE = '"+superOrganCode+"'");
                    }
                    if(StringUtil.isNotEmpty(organCode)){
                        sql.append(" AND ORGAN_CODE = '"+organCode+"'");
                    }
                }
                sql.append(" ), STUDY AS\n" +
                "( SELECT HOSPITAL_CODE, inspection_item_code, APPLY_ROOM_CODE FROM ms_study_event@DL_MS \n" +
                "  WHERE AUDIT_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND AUDIT_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "),   \n" +
                "BUS AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BUSNUM\n" +
                "    FROM STUDY --B超\n" +
                "   WHERE APPLY_ROOM_CODE = '0009'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "CXR AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS CXRNUM\n" +
                "    FROM STUDY --胸透\n" +
                "   WHERE APPLY_ROOM_CODE = '0010'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "ECG AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS ECGNUM\n" +
                "    FROM STUDY --心电图\n" +
                "   WHERE APPLY_ROOM_CODE = '0008'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "CT AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS CTNUM\n" +
                "    FROM STUDY --CT\n" +
                "   WHERE inspection_item_code = 'CT'\n" +
                "   GROUP BY HOSPITAL_CODE)   \n" +
                "SELECT ORG.GB_CODE,ORG.PARENT_CODE,ORG.ORGAN_CODE,\n" +
                "       ORG.ORGAN_NAME,\n" +
                "       BUS.BUSNUM,\n" +
                "       CXR.CXRNUM,       \n" +
                "       ECG.ECGNUM,\n" +
                "       CT.CTNUM\n" +
                "  FROM ORG, BUS, CXR, ECG, CT\n" +
                " WHERE ORG.ORGAN_CODE = BUS.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = CXR.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = ECG.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = CT.HOSPITAL_CODE(+)\n" +
                "   ");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }
    /**
     * 检验结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getExamAnalys(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
                "    FROM MDM_ORGANIZATION\n" +
                "   WHERE GENRE_CODE = '"+genreCode+"'\n");
                if(StringUtil.isNotEmpty(gbCode)){
                    sql.append(" AND GB_CODE = '"+gbCode+"' ");
                }
                if(("A1".equals(genreCode) ||"B1".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
                    sql.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
                }
                if("B2".equals(genreCode) ){
                    if(StringUtil.isNotEmpty(superOrganCode)){
                        sql.append(" AND PARENT_CODE = '"+superOrganCode+"'");
                    }
                    if(StringUtil.isNotEmpty(organCode)){
                        sql.append(" AND ORGAN_CODE = '"+organCode+"'");
                    }
                }
                sql.append(" ), EXAM AS\n" +
                "( SELECT HOSPITAL_CODE, inspection_item_code, prompt FROM ms_examine_detail@dl_ms\n" +
                "  WHERE check_date >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND check_date <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "),   \n" +
                "BXB AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BXBNUM\n" +
                "    FROM EXAM --白细胞计数\n" +
                "   WHERE inspection_item_code = '1010030101'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "BXBUP AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BXBUPNUM\n" +
                "    FROM EXAM --白细胞计数UP\n" +
                "   WHERE inspection_item_code = '1010030101'\n" +
                "     AND prompt = '↑'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "BXBDOWN AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BXBDOWNNUM\n" +
                "    FROM EXAM --白细胞计数UP\n" +
                "   WHERE inspection_item_code = '1010030101'\n" +
                "     AND prompt = '↓'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "HXB AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS HXBNUM\n" +
                "    FROM EXAM --红细胞计数\n" +
                "   WHERE inspection_item_code = '1010020101'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "HXBUP AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS HXBUPNUM\n" +
                "    FROM EXAM --红细胞计数UP\n" +
                "   WHERE inspection_item_code = '1010020101'\n" +
                "     AND prompt = '↑'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "HXBDOWN AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS HXBDOWNNUM\n" +
                "    FROM EXAM --红细胞计数DOWN\n" +
                "   WHERE inspection_item_code = '1010020101'\n" +
                "     AND prompt = '↓'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XXB AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XXBNUM\n" +
                "    FROM EXAM --血小板计数\n" +
                "   WHERE inspection_item_code = '1010190101'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XXBUP AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XXBUPNUM\n" +
                "    FROM EXAM --血小板计数UP\n" +
                "   WHERE inspection_item_code = '1010190101'\n" +
                "     AND prompt = '↑'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "XXBDOWN AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS XXBDOWNNUM\n" +
                "    FROM EXAM --血小板计数DOWN\n" +
                "   WHERE inspection_item_code = '1010190101'\n" +
                "     AND prompt = '↓'\n" +
                "   GROUP BY HOSPITAL_CODE)\n" +
                "SELECT ORG.GB_CODE,ORG.ORGAN_CODE,\n" +
                "       ORG.ORGAN_NAME,\n" +
                "       BXB.BXBNUM,\n" +
                "       BXBUP.BXBUPNUM,\n" +
                "       BXBDOWN.BXBDOWNNUM,\n" +
                "       ROUND((NVL(BXBUP.BXBUPNUM,0) + NVL(BXBDOWN.BXBDOWNNUM,0))/BXB.BXBNUM, 4) AS BXBP,\n" +
                "       HXB.HXBNUM,\n" +
                "       HXBUP.HXBUPNUM,\n" +
                "       HXBDOWN.HXBDOWNNUM, \n" +
                "       ROUND((NVL(HXBUP.HXBUPNUM,0) + NVL(HXBDOWN.HXBDOWNNUM,0))/HXB.HXBNUM, 4) AS HXBP, \n" +
                "       XXB.XXBNUM,\n" +
                "       XXBUP.XXBUPNUM,\n" +
                "       XXBDOWN.XXBDOWNNUM,\n" +
                "       ROUND((NVL(XXBUP.XXBUPNUM,0) + NVL(XXBDOWN.XXBDOWNNUM,0))/XXB.XXBNUM, 4) AS XXBP\n" +
                "  FROM ORG, BXB, BXBUP, BXBDOWN, HXB, HXBUP, HXBDOWN, XXB, XXBUP, XXBDOWN\n" +
                " WHERE ORG.ORGAN_CODE = BXB.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = BXBUP.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = BXBDOWN.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = HXB.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = HXBUP.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = HXBDOWN.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XXB.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XXBUP.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = XXBDOWN.HOSPITAL_CODE(+)");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    /**
     * A、B类型传染病统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseType(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
                "    FROM MDM_ORGANIZATION\n" +
                "   WHERE GENRE_CODE = '"+genreCode+"'\n");
                if(StringUtil.isNotEmpty(gbCode)){
                    sql.append(" AND GB_CODE = '"+gbCode+"' ");
                }
                if(("A1".equals(genreCode) ||"B1".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
                    sql.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
                }
                if("B2".equals(genreCode) ){
                    if(StringUtil.isNotEmpty(superOrganCode)){
                        sql.append(" AND PARENT_CODE = '"+superOrganCode+"'");
                    }
                    if(StringUtil.isNotEmpty(organCode)){
                        sql.append(" AND ORGAN_CODE = '"+organCode+"'");
                    }
                }
                sql.append(" ), AD AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS ACOUNT\n" +
                "    FROM SY_RMSDB_MS_DIS_DIA_INFO\n" +
                "   WHERE DIAGNOSIS_CODE LIKE 'A%'\n" +
                "     AND DIAGNOSE_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND DIAGNOSE_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "BD AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BCOUNT\n" +
                "    FROM SY_RMSDB_MS_DIS_DIA_INFO\n" +
                "   WHERE DIAGNOSIS_CODE LIKE 'B%'\n" +
                "     AND DIAGNOSE_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
                "     AND DIAGNOSE_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                "   GROUP BY HOSPITAL_CODE)\n" +
                "SELECT ORG.ORGAN_CODE, ORG.ORGAN_NAME, AD.ACOUNT, BD.BCOUNT\n" +
                "  FROM ORG, AD, BD\n" +
                " WHERE ORG.ORGAN_CODE = AD.HOSPITAL_CODE(+)\n" +
                "   AND ORG.ORGAN_CODE = BD.HOSPITAL_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    /**
     * 1年内按月统计A、B类型传染病
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap){
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        String organCode = paramMap.get("organCode");
        String type = paramMap.get("type");
        StringBuilder sql = new StringBuilder("SELECT PMONTH, COUNT(1) AS ABCOUNT\n" +
                "  FROM (SELECT TO_CHAR(DIAGNOSE_DATE, 'YYYY/MM') AS PMONTH\n" +
                "          FROM SY_RMSDB_MS_DIS_DIA_INFO\n" +
                "         WHERE DIAGNOSIS_CODE LIKE '"+type+"%'\n" );
                sql.append("           AND DIAGNOSE_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM')\n" +
                "           AND DIAGNOSE_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM')\n" +
                "           AND HOSPITAL_CODE = '"+organCode+"')\n" +
                " GROUP BY PMONTH\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    @Override
    public List<Map<String, Object>> getRpMapList(String dateStr) {
        StringBuilder sql = new StringBuilder();
        sql.append(" WITH mdm_organization AS( SELECT GB_CODE,PARENT_CODE,ORGAN_CODE,GENRE_CODE FROM MDM_ORGANIZATION  WHERE GB_CODE IS NOT NULL AND PARENT_CODE IS NOT NULL AND ORGAN_CODE IS NOT NULL ) ,OUTPATIENT_DRUG_USAGE AS( SELECT  CLINIC_ORGAN_CODE,EHR_ID,PERSON_ID ,CLINIC_DATE,MANA_DOCTOR_NO,VISIT_STATUS,OBSERVED_PATIENT_FLAG ,MEDICAL_COST_PAY_WAY,MEDICAL_INSURANCE_COST_SUM,PERSONAL_EXPENSES,OTHER_SUBSIDIES_COST_SUM,OUTPATIENT_COST_SUM,PRESCRIPTION_COUNT,PRESCRIPTION_ROUTE_COUNT FROM SY_RMSDB_MS_OUTPATIENT_INFO OUTPATIENT  WHERE  CLINIC_ORGAN_CODE IN(  SELECT ORGAN_CODE FROM MDM_ORGANIZATION WHERE 1=1 ) ");
        sql.append(" AND to_char(CLINIC_DATE,'yyyy/mm/dd') ='"+dateStr+"' ),");
        sql.append(" STAFF AS(SELECT ORGAN_CODE,COUNT(1) STAFF_COUNT FROM V_MDM_STAFF WHERE  ORGAN_CODE IN( SELECT ORGAN_CODE FROM MDM_ORGANIZATION WHERE 1=1 ) GROUP BY ORGAN_CODE) ");
        sql.append(" SELECT ORG.ORGAN_CODE ,NVL(OUTPATIENT.registerNum,0) registerNum,NVL( OUTPATIENT.visitNum,0) visitNum ,NVL(OUTPATIENT.observedNum,0) observedNum ");
        sql.append(" FROM MDM_ORGANIZATION ORG ");
        sql.append(" LEFT JOIN   ");
        sql.append(" (  SELECT CLINIC_ORGAN_CODE ,COUNT(1) registerNum , COUNT(DECODE(VISIT_STATUS,2,1,NULL)) visitNum   ,COUNT(DECODE(OBSERVED_PATIENT_FLAG,1,1,NULL)) observedNum");
        sql.append(" FROM OUTPATIENT_DRUG_USAGE");
        sql.append(" GROUP BY CLINIC_ORGAN_CODE ");
        sql.append(" ) OUTPATIENT on ORG.ORGAN_CODE = OUTPATIENT.CLINIC_ORGAN_CODE LEFT JOIN STAFF ON STAFF.ORGAN_CODE = ORG.ORGAN_CODE");
        Criteria ca =new Criteria();
        return this.getMapList(sql.toString(),ca);
    }
    
    /**
	 * 检验人数
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getExamCount(Map<String, String> paramMap){
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		String genreCode = paramMap.get("genreCode");
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
		String organCode = paramMap.get("organCode");//站
		String gbCode = paramMap.get("gbCode");
		String orgCodeReal = superOrganCode;
		StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
				" (SELECT GB_CODE, PARENT_CODE, ORGAN_CODE, ORGAN_NAME, GENRE_CODE\n" +
				"    FROM MDM_ORGANIZATION WHERE STATUS = '1' \n");
		if (!"0".equals(genreCode)){
			sql.append("  AND  GENRE_CODE = '"+genreCode+"'\n");
		}
		if(StringUtil.isNotEmpty(gbCode)){
			sql.append(" AND GB_CODE = '"+gbCode+"' ");
		}
		if(("A100".equals(genreCode) ||"B100".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
			sql.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
		}
		if("B200".equals(genreCode) ){
			orgCodeReal = organCode;
			if(StringUtil.isNotEmpty(superOrganCode)){
				sql.append(" AND PARENT_CODE = '"+superOrganCode+"'");
			}
			if(StringUtil.isNotEmpty(organCode)){
				sql.append(" AND ORGAN_CODE = '"+organCode+"'");
			}
		}
		sql.append(" ), EXAM AS\n" +
				" (SELECT HOSPITAL_CODE, COUNT(1) AS NUM\n" +
				"    FROM MS_EXAMINE_EVENT@dl_ms\n" +
				"   WHERE CHECK_DATE >= TO_DATE('"+beginDate+"', 'YYYY/MM/DD')\n" +
				"     AND CHECK_DATE <= TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" );
			if(StringUtil.isNotEmpty(orgCodeReal)){
				sql.append("     AND HOSPITAL_CODE = '"+orgCodeReal+"'\n");
			}
				sql.append("   GROUP BY HOSPITAL_CODE)\n" +
				"SELECT ORG.ORGAN_NAME,ORG.ORGAN_CODE, EXAM.NUM\n" +
				"  FROM ORG, EXAM\n" +
				" WHERE ORG.ORGAN_CODE = EXAM.HOSPITAL_CODE(+)");
		List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
		return result;
	}
}