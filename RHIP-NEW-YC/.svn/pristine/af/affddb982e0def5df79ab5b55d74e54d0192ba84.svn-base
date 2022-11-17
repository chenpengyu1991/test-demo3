package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.ehr.entity.basic.ElderlyHealthStatistics;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("elderlyHealthStatisticsDao")
public class ElderlyHealthStatisticsDaoImpl extends AbstractDao<ElderlyHealthStatistics, Long>
		implements IElderlyHealthStatisticsDao {
	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;


	private static final String ALL_QUANTITY_SQL = "SELECT "
			+ " SUM(SHOULD_EXAM_QUANTITY) shouldExamQuantity"
			+ " ,SUM(ACTUAL_EXAM_QUANTITY) actualExamQuantity"
			+ " ,NVL(DECODE(SIGN(SUM(SHOULD_EXAM_QUANTITY)),0,0,ROUND(SUM(ACTUAL_EXAM_QUANTITY)/SUM(SHOULD_EXAM_QUANTITY),4)),0) physicalExamRate"
			+ " ,SUM(BLOOD_BIO_QUANTITY) bloodBioQuantity"
			+ " ,SUM(URINE_ROUTINE_QUANTITY) urineRoutineQuantity"
			+ " ,SUM(ECG_QUANTITY) ecgQuantity"
			+ " ,SUM(B_ULTRASONIC_QUANTITY) bUltrasonicQuantity"
			+ " ,SUM(X_RAY_QUANTITY) xRayQuantity"
			+ " ,SUM(BPV_QUANTITY) bpvQuantity"
			+ " ,SUM(IFG_QUANTITY) ifgQuantity"
			+ " ,SUM(DYSLIPIDEMIA_QUANTITY) dyslipidemiaQuantity"
			+ " ,SUM(LIVER_ABNORMAL_QUANTITY) liverAbnormalQuantity"
			+ " ,SUM(RENAL_ABNORMAL_QUANTITY) renalAbnormalQuantity"
			+ " ,SUM(X_RAY_ABNORMAL_QUANTITY) xRayAbnormalQuantity"
			+ " ,SUM(HEPATIC_CYST_QUANTITY) hepaticCystQuantity"
			+ " ,SUM(FATTY_LIVER_QUANTITY) fattyLiverQuantity"
			+ " ,SUM(GALL_STONE_QUANTITY) gallStoneQuantity"
			+ " ,SUM(CHOLECYSTITIS_QUANTITY) cholecystitisQuantity"
			+ " ,SUM(RENAL_CYST_QUANTITY) renalCystQuantity"
			+ " ,SUM(KIDNEY_STONE_QUANTITY) kidneyStoneQuantity"
			+ " ,SUM(TUMOR_QUANTITY) tumorQuantity"
			+ " ,SUM(TUBERCULOSIS_QUANTITY) tuberculosisQuantity"
			+ " FROM ECH_ELDERLY_HEALTH_STATISTICS ";
	
	private static final String ELDERLY_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS organ_code,"
			+ " sum(NVL(should_exam_quantity, 0))should_exam_quantity,sum(NVL(actual_exam_quantity, 0))actual_exam_quantity,"
            + " sum(NVL(olderNum,0)) older_num,"
			+ " decode(sum(NVL(olderNum, 0)),0,0,decode(sum(NVL(should_exam_quantity, 0)),0,0,sum(NVL(should_exam_quantity, 0))/sum(NVL(olderNum, 1))))examRate,"
			+ " sum(NVL(blood_bio_quantity, 0))blood_bio_quantity,sum(NVL(urine_routine_quantity, 0))urine_routine_quantity,"
			+ " sum(NVL(ecg_quantity, 0))ecg_quantity,sum(NVL(b_ultrasonic_quantity, 0))b_ultrasonic_quantity,"
			+ " sum(NVL(x_ray_quantity, 0))x_ray_quantity,sum(NVL(bpv_quantity, 0))bpv_quantity,"
			+ " sum(NVL(ifg_quantity, 0))ifg_quantity,sum(NVL(dyslipidemia_quantity, 0))dyslipidemia_quantity,"
			+ " sum(NVL(liver_abnormal_quantity, 0))liver_abnormal_quantity,sum(NVL(renal_abnormal_quantity, 0))renal_abnormal_quantity,"
			+ " sum(NVL(x_ray_abnormal_quantity, 0))x_ray_abnormal_quantity,sum(NVL(hepatic_cyst_quantity, 0))hepatic_cyst_quantity,"
			+ " sum(NVL(fatty_liver_quantity, 0))fatty_liver_quantity,sum(NVL(gall_stone_quantity, 0))gall_stone_quantity,"
			+ " sum(NVL(cholecystitis_quantity, 0))cholecystitis_quantity,sum(NVL(renal_cyst_quantity, 0))renal_cyst_quantity,"
			+ " sum(NVL(kidney_stone_quantity, 0))kidney_stone_quantity,sum(NVL(tumor_quantity, 0))tumor_quantity,"
			+ " sum(NVL(tuberculosis_quantity, 0))tuberculosis_quantity"
			+ " from (select org.gb_code,org.parent_code,org.organ_code, t.*,po.*"
			+ " from V_MDM_ORGANIZATION_STATISTICS org"
			+ " left join (select ehs.org_code orgCode, ehs.should_exam_quantity,ehs.actual_exam_quantity,ehs.blood_bio_quantity,"
			+ " ehs.urine_routine_quantity,ehs.ecg_quantity,ehs.b_ultrasonic_quantity,ehs.x_ray_quantity,ehs.bpv_quantity,ehs.ifg_quantity,"
			+ " ehs.dyslipidemia_quantity,ehs.liver_abnormal_quantity,ehs.renal_abnormal_quantity,ehs.x_ray_abnormal_quantity,"
			+ " ehs.hepatic_cyst_quantity,ehs.fatty_liver_quantity,ehs.gall_stone_quantity,ehs.cholecystitis_quantity,ehs.renal_cyst_quantity,"
			+ " ehs.kidney_stone_quantity,ehs.tumor_quantity,ehs.tuberculosis_quantity"
			+ " from ECH_elderly_health_statistics ehs %2$s) t on t.orgCode =org.organ_code "
            +" left join (select nvl((p.household_great_sixf_num+p.un_household_great_sixf_num),0) olderNum ,p.organ_code orgCode from bi_populace p ) po "
            +" on org.organ_code = po.orgCode "
            + " where genre_code in('B100','B200') %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s )";
	
	private static final String ELDERLY_STATISTICS_SQL1 = "SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE ORG_CODE," +
			" NVL(fpg_count, 0) fpg_count,NVL(blood_count, 0) blood_count," +
			" NVL(urine_count, 0) urine_count,NVL(dyslipidemia_count, 0) dyslipidemia_count," +
			" NVL(LIVER_count, 0) LIVER_count,NVL(RENAL_count, 0) RENAL_count," +
			" NVL(B_count, 0) B_count,NVL(ECG_count, 0) ECG_count," +
			" NVL(older_num, 0) older_num" +
			" FROM mdm_organization V LEFT JOIN ("+
			" SELECT ORG_CODE,"+
			" NVL(count(DISTINCT fpg_person), 0) fpg_count, " +
			" NVL(count(DISTINCT blood_person), 0) blood_count, " +
			" NVL(count(DISTINCT urine_person), 0) urine_count, " +
			" NVL(count(DISTINCT dyslipidemia_person),0) dyslipidemia_count, " +
			" NVL(count(DISTINCT LIVER_person),0) LIVER_count, " +
			" NVL(count(DISTINCT RENAL_person),0) RENAL_count, " +
			" NVL(count(DISTINCT B_person),0) B_count, " +
			" NVL(count(DISTINCT ECG_person),0) ECG_count, " +
			" NVL(sum(older_num),0) older_num " +
			" FROM  ("
			+ " select r.INPUT_ORGAN_CODE ORG_CODE,"
			//空腹血糖检查人数
			+ " case when FPG_MMOL is not null or FPG_MG is not null then r.person_id else null end fpg_person,"
			//血常规检查人数
			+ " case when HEMOGLOBIN_VALUE is not null and LEUKOCYTE_COUNT is not null and PLATELET_COUNT is not null then r.person_id else null end blood_person,"
			//尿常规
			+ " case when URINE_PRO_QUANTITATIVE_VALUE is not null and KET_QUANTITATIVE_VALUE is not null and URINE_SUG_QUANTITATIVE_VALUE is not null and ERY_QUANTITATIVE_VALUE is not null then r.person_id else null end urine_person,"
			//血脂四项检查人数
			+ " case when (TC is not null or TRIGLYCERIDE_VALUE is not null or LDLC_DETECT_VALUE is not null or HDLC_DETECT_VALUE is not null) then r.person_id else null end dyslipidemia_person,"
			//肝功能三项检查人数     
			+ " case when (SERUM_GPT_VALUE is not null or SERUM_AST_VALUE is not null or TOTAL_BILIRUBIN is not null) then r.person_id else null end LIVER_person,"
			//肾功能二项检查人数     
			+ " case when (creatinine is not null or BLOOD_UREA_NITROGEN_VALUE is not null) then r.person_id else null end RENAL_person,"
			//B超检查人数
			+ " case when BMODE_ANOMALYF_FLAG='1' or BMODE_ANOMALYF_FLAG='0' or BMODE_OTHER_ANOMALYF_FLAG='1' or BMODE_OTHER_ANOMALYF_FLAG='0' then r.person_id else null end B_person,"
			//心电图检查人数 
			+ " case when ECG_ANOMALY_FLAG='1' or ECG_ANOMALY_FLAG='0' then r.person_id else null end ECG_person,"
			+ " 0 older_num"
			+ " from ECH_ELDERLY_PHY_EXAMINATION ep left join ECH_PHYSICAL_EXAM_RECORD r on ep.PERSON_ID=r.PERSON_ID"
			+ " where ep.PHYSICAL_EXAM_TYPE='31' and ep.id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p GROUP BY p.PERSON_ID) %2$s %6$s %4$s"
			//老年人人数
			+ " UNION ALL SELECT "
			+ " P.organ_code ORG_CODE,null fpg_person,null blood_person,null urine_person,null dyslipidemia_person,null LIVER_person,null RENAL_person,null B_person,null ECG_person, "
			+ " nvl(p.household_great_sixf_num,0) + nvl(P .un_household_great_sixf_num,0) olderNum "
			+ " FROM bi_populace P WHERE 1=1 %1$s %3$s) "
			+ " GROUP BY ORG_CODE ) T ON V.ORGAN_CODE=T.ORG_CODE WHERE STATUS=1  %3$s ORDER BY V.GENRE_CODE,NLSSORT(V.ORGAN_NAME,'NLS_SORT=SCHINESE_PINYIN_M')";

	private static final String ELDERLY_STATISTICS_SQL2 = "WITH st AS (\n" +
			"	SELECT\n" +
			"		r.PERSON_ID PERSON_ID, r.EXAM_YEAR EXAM_YEAR,\n" +
			"		r.INPUT_ORGAN_CODE ORG_CODE,\n" +
			"		NVL (IS_CRITERION_EXAMINATION, 0) IS_CRITERION_EXAMINATION,\n" +
			"		NVL (IS_ESTIMATE_STATUS, 0) IS_ESTIMATE_STATUS,\n" +
			"		NVL (IS_EXAM, 0) IS_EXAM,\n" +
			"		NVL (IS_HEALTH_GUIDE_STATUS, 0) IS_HEALTH_GUIDE_STATUS\n" +
			"	FROM\n" +
			"		ECH_PHYSICAL_EXAM_RECORD r\n" +
			"	LEFT JOIN (\n" +
			"		SELECT\n" +
			"			PERSON_ID,\n" +
			"			SUM (CRITERION_EXAMINATION) IS_CRITERION_EXAMINATION,\n" +
			"			SUM (ESTIMATE_STATUS) IS_ESTIMATE_STATUS,\n" +
			"			SUM (HEALTH_GUIDE_STATUS) IS_HEALTH_GUIDE_STATUS,\n" +
			"			COUNT (PERSON_ID) IS_EXAM\n" +
			"		FROM\n" +
			"			ECH_ELDERLY_PHY_STATUS\n" +
			"		WHERE\n" +
			"			1 = 1 %6$s  GROUP BY PERSON_ID ) s ON r.PERSON_ID = s.PERSON_ID )\n" +
			"SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE ORG_CODE," +
			" NVL(ESTIMATE_SUM, 0) ESTIMATE_SUM,NVL(EXAM_COUNT, 0) EXAM_COUNT," +
			" NVL(EXAM_SUM, 0) EXAM_SUM,NVL(MANAGE_SUM, 0) MANAGE_SUM," +
			" NVL(GUIDE_SUM, 0) GUIDE_SUM,NVL(FILL_COUNT, 0) FILL_COUNT," +
			" NVL(OLDER_NUM, 0) OLDER_NUM, " +
			" NVL(TCM_COUNT, 0) TCM_COUNT " +
			" FROM mdm_organization V LEFT JOIN ("+
			" SELECT ORG_CODE,"+
			" NVL(SUM(ESTIMATE_SUM), 0) ESTIMATE_SUM, " +
			" NVL(sum(EXAM_PERSON), 0) EXAM_COUNT, " +
			" NVL(sum(EXAM_ID), 0) EXAM_SUM, " +
			" NVL(sum(MANAGE_PERSON),0) MANAGE_SUM, " +
			" NVL(SUM(GUIDE_SUM),0) GUIDE_SUM, " +
			" NVL(SUM(FILL_PERSON),0) FILL_COUNT, " +
			" NVL(SUM(HOUSEHOLD_SUM),0) OLDER_NUM, " +
			" NVL(SUM(TCM_PERSON),0) TCM_COUNT " +
			" FROM  (" +
			//---------------------健康评估人数--------------------------
			"SELECT ORG_CODE, " +
			//评估人数
			" count(tmp.PERSON_ID) ESTIMATE_SUM, " +
			//体检人数
			" 0 EXAM_PERSON, " +
			//体检人次数
			" 0 EXAM_ID, " +
			" null MANAGE_PERSON, 0 GUIDE_SUM,null FILL_PERSON,0 HOUSEHOLD_SUM," +
			//中医辨识人数
			" null TCM_PERSON " +
			" from  (SELECT distinct PERSON_ID,ORG_CODE,IS_ESTIMATE_STATUS from st WHERE st.IS_ESTIMATE_STATUS >= 1 %9$s  %8$s ) tmp   GROUP BY ORG_CODE " +
			//------------------------------体检人数---------------------
			" UNION ALL \n"+
			"SELECT\n" +
			"	b.INPUT_ORGAN_CODE ORG_CODE,\n" +
			"	0 ESTIMATE_SUM,\n" +
			"	count(DISTINCT b.ID) EXAM_PERSON,\n" +
			"	0 EXAM_ID,\n" +
			"	0 MANAGE_PERSON,\n" +
			"	0 GUIDE_SUM,\n" +
			"	0 FILL_PERSON,\n" +
			"	0 HOUSEHOLD_SUM,\n" +
			"	0 TCM_person\n" +
			"FROM bi_person_info b inner JOIN  (select person_id from ECH_ELDERLY_PHY_EXAMINATION where  %11$s " +
			" and physical_exam_type='31' group by person_id) ec ON b.ID = ec.person_id WHERE b.filing_Flag = '1'  GROUP BY b.INPUT_ORGAN_CODE	 "+
			//------------------体检人次数----------------------------------
			" UNION ALL \n"+
			"SELECT\n" +
			"	ORG_CODE,\n" +
			"	0 ESTIMATE_SUM,\n" +
			"	0 EXAM_PERSON,\n" +
			"	sum(IS_EXAM) EXAM_ID,\n" +
			"	0 MANAGE_PERSON,\n" +
			"	0 GUIDE_SUM,\n" +
			"	0 FILL_PERSON,\n" +
			"	0 HOUSEHOLD_SUM,\n" +
			"	0 TCM_person\n" +
			"FROM st WHERE st.IS_EXAM >= 1  %9$s  %8$s	 GROUP BY ORG_CODE " +
			//健康指导老年人数
			" UNION ALL SELECT " +
			" r.INPUT_ORGAN_CODE ORG_CODE, 0 ESTIMATE_SUM,null EXAM_PERSON,null EXAM_ID,null MANAGE_PERSON, " +
			" NVL2(PHYSICAL_EXAM_CODE, 1, 0) GUIDE_SUM, null FILL_PERSON,0 HOUSEHOLD_SUM, NULL TCM_person " +
			" FROM ( SELECT PHYSICAL_EXAM_CODE,person_id FROM ECH_ELDERLY_PHY_EXAMINATION WHERE (" +
			"NVL(GUIDE_INTO_CHRONIC_DISEASE,0)" +//健康指导纳入慢性病患者健康管理
			"+NVL(GUIDE_SUGGESTION_REVIEW,0)" +//健康指导建议复查
			"+NVL(GUIDE_SUGGESTION_REFERRAL,0)" +//--健康指导建议转诊
			"+NVL(PREVENTION_OSTEOPOROSIS,0) " +//--骨质疏松预防
			"+NVL(PREVENTION_TUMBLE,0) " +//--防跌倒措施
			"+NVL(PREVENTION_INJURY,0) " +//--意外伤害预防
			")>0 AND PHYSICAL_EXAM_TYPE='31' and id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p GROUP BY p.PERSON_ID) %6$s ) T, " +
			" ECH_PHYSICAL_EXAM_RECORD r " +
			" WHERE 1=1 %2$s and t.person_id=r.person_id %4$s" +
			//管理人数
			" UNION ALL SELECT " +
			" ORG_CODE, 0 ESTIMATE_SUM,null EXAM_PERSON,null EXAM_ID,COUNT(tmp.PERSON_ID) MANAGE_PERSON, " +
			" 0 GUIDE_SUM, null FILL_PERSON,0 HOUSEHOLD_SUM, NULL TCM_PERSON " +
			" FROM (SELECT distinct PERSON_ID,ORG_CODE from st where 1=1 %9$s  %8$s ) tmp GROUP BY ORG_CODE " +
//			" left join bi_person_info b on b.id=r.person_id " +
//			" left join ECH_ELDERLY_PHY_EXAMINATION ep on ep.PHYSICAL_EXAM_CODE=r.EXAM_NUMBER and ep.person_id=r.person_id "+
//			" WHERE b.filing_Flag = '1' AND b.STAR = '3' " +
//			" and r.EXAM_STATUS='1' and ep.PHYSICAL_EXAM_TYPE='31' " +
//			" and (FPG_MMOL is not null or FPG_MG is not null) " +//--空腹血糖检查人数
//			" and (HEMOGLOBIN_VALUE is not null and LEUKOCYTE_COUNT is not null and PLATELET_COUNT is not null) " +//--血常规检查人数
//			" and (URINE_PRO_QUANTITATIVE_VALUE is not null and KET_QUANTITATIVE_VALUE is not null and URINE_SUG_QUANTITATIVE_VALUE is not null and ERY_QUANTITATIVE_VALUE is not null) " +//--尿常规
//			" and (TC is not null or TRIGLYCERIDE_VALUE is not null or LDLC_DETECT_VALUE is not null or HDLC_DETECT_VALUE is not null) " +//--血脂四项检查人数
//			" and (SERUM_GPT_VALUE is not null or SERUM_AST_VALUE is not null or TOTAL_BILIRUBIN is not null) " +//--肝功能三项检查人数
//			" and (creatinine is not null or BLOOD_UREA_NITROGEN_VALUE is not null) " +//--肾功能二项检查人数
//			" and (BMODE_ANOMALYF_FLAG='1' or BMODE_ANOMALYF_FLAG='0' or BMODE_OTHER_ANOMALYF_FLAG='1' or BMODE_OTHER_ANOMALYF_FLAG='0') " +//--B超检查人数
//			" and (ECG_ANOMALY_FLAG='1' or ECG_ANOMALY_FLAG='0') %2$s %6$s %4$s" +
			//中医辨识人数
			" UNION ALL SELECT " +
			" INPUT_ORGAN_CODE ORG_CODE, 0 ESTIMATE_SUM,null EXAM_PERSON,null EXAM_ID,null MANAGE_PERSON, " +
			" 0 GUIDE_SUM, null FILL_PERSON,0 HOUSEHOLD_SUM, count(r.person_id) TCM_PERSON " +
			" FROM ECH_PHYSICAL_EXAM_RECORD r "+
			"LEFT JOIN (SELECT PERSON_ID,SUM (NVL(IS_TCM, 0)) IS_TCM FROM\n" +
			"(SELECT PERSON_ID, COUNT (1) IS_TCM FROM ECH_IDENTIFICATION WHERE\n" +
			" %10$s GROUP BY PERSON_ID \n" +
			"UNION ALL\n" +
			"SELECT PERSON_ID, COUNT (1) IS_TCM  FROM ECH_ELDERLY_PHY_EXAMINATION WHERE\n" +
			" %11$s \n" +
			"AND IDENTIFICATION_ID IS NOT NULL AND IDENTIFICATION_ID <> 0 GROUP BY PERSON_ID) GROUP BY PERSON_ID\n" +
			") status ON status.PERSON_ID = r .PERSON_ID"+
			" WHERE %12$s AND is_tcm >=1  %4$s GROUP BY INPUT_ORGAN_CODE" +
			//建档数 
			" UNION ALL SELECT INPUT_ORGAN_CODE ORG_CODE, 0 ESTIMATE_SUM,null EXAM_PERSON,null EXAM_ID,null MANAGE_PERSON,0 GUIDE_SUM, " +
			" count(ID) FILL_PERSON,0 HOUSEHOLD_SUM, NULL TCM_person " +
			" FROM BI_PERSON_INFO " +
			" WHERE filing_Flag = '1' AND STAR >= '2' %13$s %7$s  GROUP BY  INPUT_ORGAN_CODE" +
			//65岁以上老年人数
			" UNION ALL SELECT organ_code ORG_CODE, 0 ESTIMATE_SUM,null EXAM_PERSON,null EXAM_ID,null MANAGE_PERSON,0 GUIDE_SUM,null FILL_PERSON, " +
			" NVL(HOUSEHOLD_GREAT_SIXF_NUM, 0) + NVL ( UN_HOUSEHOLD_GREAT_SIXF_NUM, 0 ) HOUSEHOLD_SUM, NULL TCM_person " +
			" FROM BI_POPULACE WHERE 1=1 %1$s %3$s) " + 
			" GROUP BY ORG_CODE ) T ON V.ORGAN_CODE=T.ORG_CODE WHERE status=1 %3$s ORDER BY V.GENRE_CODE,NLSSORT(V.ORGAN_NAME,'NLS_SORT=SCHINESE_PINYIN_M')";

	private static final String ELDERLY_PAADDRESS_SQL1 = "select parent_code,item_name,item_code,NVL(fpg_count, 0) fpg_count,  " + 
			" NVL(blood_count, 0) blood_count,  " + 
			" NVL(urine_count, 0) urine_count,  " + 
			" NVL(dyslipidemia_count, 0) dyslipidemia_count,  " + 
			" NVL(LIVER_count, 0) LIVER_count,  " + 
			" NVL(RENAL_count, 0) RENAL_count,  " + 
			" NVL(B_count, 0) B_count,  " + 
			" NVL(ECG_count, 0) ECG_count,0 older_num from DIC_ITEM left join  (" +
			" SELECT %1$s, " + 
			" NVL (COUNT (DISTINCT fpg_person),0) fpg_count, " + 
			" NVL (COUNT (DISTINCT blood_person),0) blood_count, " + 
			" NVL (COUNT (DISTINCT urine_person),0) urine_count, " + 
			" NVL (COUNT (DISTINCT dyslipidemia_person),0) dyslipidemia_count, " + 
			" NVL (COUNT (DISTINCT LIVER_person),0) LIVER_count, " + 
			" NVL (COUNT (DISTINCT RENAL_person),0) RENAL_count, " + 
			" NVL (COUNT(DISTINCT B_person), 0) B_count, " + 
			" NVL (COUNT(DISTINCT ECG_person),0) ECG_count " + 
			" FROM( SELECT " + 
			" b.PATOWN_SHIP,b.PASTREET,b.pa_group, " + 
			" CASE WHEN FPG_MMOL IS NOT NULL OR FPG_MG IS NOT NULL THEN R.person_id ELSE NULL END fpg_person, " + 
			" CASE WHEN HEMOGLOBIN_VALUE IS NOT NULL AND LEUKOCYTE_COUNT IS NOT NULL AND PLATELET_COUNT IS NOT NULL THEN R.person_id ELSE NULL END blood_person, " + 
			" CASE WHEN URINE_PRO_QUANTITATIVE_VALUE IS NOT NULL AND KET_QUANTITATIVE_VALUE IS NOT NULL AND URINE_SUG_QUANTITATIVE_VALUE IS NOT NULL AND ERY_QUANTITATIVE_VALUE IS NOT NULL THEN R.person_id ELSE NULL END urine_person, " + 
			" CASE WHEN (TC IS NOT NULL	or TRIGLYCERIDE_VALUE IS NOT NULL or LDLC_DETECT_VALUE IS NOT NULL or HDLC_DETECT_VALUE IS NOT NULL) THEN R.person_id ELSE NULL END dyslipidemia_person, " +
			" CASE WHEN (SERUM_GPT_VALUE IS NOT NULL or SERUM_AST_VALUE IS NOT NULL or TOTAL_BILIRUBIN IS NOT NULL) THEN R.person_id ELSE NULL END LIVER_person, " +
			" CASE WHEN (creatinine IS NOT NULL or BLOOD_UREA_NITROGEN_VALUE IS NOT NULL) THEN R.person_id ELSE NULL END RENAL_person, " +
			" CASE WHEN BMODE_ANOMALYF_FLAG = '1' OR BMODE_ANOMALYF_FLAG = '0' OR BMODE_OTHER_ANOMALYF_FLAG = '1' OR BMODE_OTHER_ANOMALYF_FLAG = '0' THEN R.person_id ELSE NULL END B_person, " + 
			" CASE WHEN ECG_ANOMALY_FLAG = '1' OR ECG_ANOMALY_FLAG = '0' THEN R.person_id ELSE NULL END ECG_person " + 
			" FROM ECH_ELDERLY_PHY_EXAMINATION ep " +
			" LEFT JOIN ECH_PHYSICAL_EXAM_RECORD r on ep.person_id = r.person_id" +
			" left join BI_PERSON_INFO b on b.id=EP.PERSON_ID " + 
			" WHERE EP.PHYSICAL_EXAM_TYPE = '31'  and ep.id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p GROUP BY p.PERSON_ID) %2$s %3$s %4$s" +
			" )GROUP BY %1$s) on item_code = %1$s where dic_code='FS990001' and status =1 %6$s ORDER BY item_code";

	private static final String ELDERLY_PAADDRESS_SQL2 ="WITH st AS (\n" +
			"	SELECT\n" +
			"		r.PERSON_ID PERSON_ID, r.EXAM_YEAR EXAM_YEAR,\n" +
			"		r.INPUT_ORGAN_CODE ORG_CODE,\n" +
			"		NVL (IS_CRITERION_EXAMINATION, 0) IS_CRITERION_EXAMINATION,\n" +
			"		NVL (IS_ESTIMATE_STATUS, 0) IS_ESTIMATE_STATUS,\n" +
			"		NVL (IS_EXAM, 0) IS_EXAM,\n" +
			"		NVL (IS_HEALTH_GUIDE_STATUS, 0) IS_HEALTH_GUIDE_STATUS\n" +
			"	FROM\n" +
			"		ECH_PHYSICAL_EXAM_RECORD r\n" +
			"	LEFT JOIN (\n" +
			"		SELECT\n" +
			"			PERSON_ID,\n" +
			"			SUM (CRITERION_EXAMINATION) IS_CRITERION_EXAMINATION,\n" +
			"			SUM (ESTIMATE_STATUS) IS_ESTIMATE_STATUS,\n" +
			"			SUM (HEALTH_GUIDE_STATUS) IS_HEALTH_GUIDE_STATUS,\n" +
			"			COUNT (PERSON_ID) IS_EXAM\n" +
			"		FROM\n" +
			"			ECH_ELDERLY_PHY_STATUS\n" +
			"		WHERE\n" +
			"			1 = 1 %3$s  GROUP BY PERSON_ID ) s ON r.PERSON_ID = s.PERSON_ID )\n" +
			"select parent_code,item_name,item_code," +
			" NVL(FILL_COUNT, 0) FILL_COUNT,NVL(ESTIMATE_SUM, 0) ESTIMATE_SUM,NVL(EXAM_COUNT, 0) EXAM_COUNT," +
			" NVL(EXAM_SUM, 0) EXAM_SUM,NVL(MANAGE_SUM, 0) MANAGE_SUM,NVL(TCM_COUNT, 0) TCM_COUNT,NVL(GUIDE_SUM, 0) GUIDE_SUM, 0 older_num " + 
				" from DIC_ITEM left join  ( SELECT %1$s, " +
			" NVL (COUNT(DISTINCT FILL_PERSON), 0) FILL_count, " + //建档人数
			" NVL (COUNT(ESTIMATE_PERSON), 0 ) ESTIMATE_SUM, " + //评估人数
			" NVL (COUNT(EXAM_PERSON), 0 ) EXAM_COUNT, " + //体检人数
			" NVL (SUM(EXAM_ID), 0 ) EXAM_SUM, " + //体检人次数
			" NVL (COUNT(MANAGE_PERSON), 0 ) MANAGE_SUM, " + //管理人数
			" NVL (COUNT(TCM_PERSON), 0 ) TCM_COUNT, " + //中医辨识人数
			" NVL (COUNT(DISTINCT GUIDE_person), 0 ) GUIDE_SUM " +  //健康指导老年人数
			" FROM (SELECT b.PATOWN_SHIP, b.PASTREET, b.pa_group,  " + 
			" FILL_PERSON, ESTIMATE_PERSON,  EXAM_PERSON, EXAM_ID,  MANAGE_PERSON,  TCM_PERSON,GUIDE_person " + 
			" FROM BI_PERSON_INFO  b left join ( " +
			//-健康评估人数
			"SELECT PERSON_ID, " +
			" tmp.PERSON_ID ESTIMATE_PERSON, " +
			" NULL EXAM_PERSON, " +
			" NULL EXAM_ID, " +
			" NULL TCM_PERSON, null MANAGE_PERSON " +
			" from  (SELECT distinct PERSON_ID,ORG_CODE,IS_ESTIMATE_STATUS from st WHERE st.IS_ESTIMATE_STATUS >= 1 %9$s  %8$s ) tmp   " +
			//--体检人数--
			" UNION ALL \n"+
			"SELECT\n" +
			"	b.ID PERSON_ID,\n" +
			"	NULL ESTIMATE_PERSON,\n" +
			"	b.ID EXAM_PERSON,\n" +
			"	NULL EXAM_ID,\n" +
			"	NULL TCM_person, null MANAGE_PERSON\n" +
			"FROM bi_person_info b inner JOIN  (select person_id from ECH_ELDERLY_PHY_EXAMINATION where  %11$s group by person_id ) ec ON b.ID = ec.person_id WHERE b.filing_Flag = '1' " +
			//-体检人次数---
			" UNION ALL \n"+
			"SELECT\n" +
			"	st.PERSON_ID,\n" +
			"	NULL ESTIMATE_PERSON,\n" +
			"	NULL EXAM_PERSON,\n" +
			"	st.IS_EXAM EXAM_ID,\n" +
			"	NULL TCM_person , null MANAGE_PERSON\n" +
			"FROM st WHERE st.IS_EXAM >= 1  %9$s  %8$s " +
			//健康管理人数
			" UNION ALL SELECT PERSON_ID," +
			" null ESTIMATE_PERSON,null EXAM_PERSON,null EXAM_ID,NULL TCM_person,tmp.PERSON_ID MANAGE_PERSON " +
			" FROM (SELECT distinct PERSON_ID,ORG_CODE from st where 1=1 %9$s  %8$s ) tmp  " +
			//中医辨识人数
			" UNION ALL SELECT " +
			" r.person_id PERSON_ID, null ESTIMATE_PERSON,null EXAM_PERSON,null EXAM_ID," +
			" r.person_id TCM_PERSON, null MANAGE_PERSON" +
			" FROM ECH_PHYSICAL_EXAM_RECORD r "+
			"LEFT JOIN (SELECT PERSON_ID,SUM (NVL(IS_TCM, 0)) IS_TCM FROM\n" +
			"(SELECT PERSON_ID, COUNT (1) IS_TCM FROM ECH_IDENTIFICATION WHERE\n" +
			" %10$s GROUP BY PERSON_ID \n" +
			"UNION ALL\n" +
			"SELECT PERSON_ID, COUNT (1) IS_TCM  FROM ECH_ELDERLY_PHY_EXAMINATION WHERE\n" +
			" %11$s \n" +
			"AND IDENTIFICATION_ID IS NOT NULL AND IDENTIFICATION_ID <> 0 GROUP BY PERSON_ID) GROUP BY PERSON_ID\n" +
			") status ON status.PERSON_ID = r .PERSON_ID"+
			" WHERE %12$s AND is_tcm >=1  %4$s " +
			") ech on ech.person_id=b.id " +
			" left join (  SELECT R.Person_id, " + 
			" DECODE(NVL2(PHYSICAL_EXAM_CODE, 1, 0), 1, R.PERSON_ID, null) GUIDE_person " + 
			" FROM ( SELECT PHYSICAL_EXAM_CODE,PERSON_ID FROM ECH_ELDERLY_PHY_EXAMINATION WHERE (" +
			"NVL(GUIDE_INTO_CHRONIC_DISEASE,0)" +//健康指导纳入慢性病患者健康管理
			"+NVL(GUIDE_SUGGESTION_REVIEW,0)" +//健康指导建议复查
			"+NVL(GUIDE_SUGGESTION_REFERRAL,0)" +//--健康指导建议转诊
			"+NVL(PREVENTION_OSTEOPOROSIS,0) " +//--骨质疏松预防
			"+NVL(PREVENTION_TUMBLE,0) " +//--防跌倒措施
			"+NVL(PREVENTION_INJURY,0) " +//--意外伤害预防
			")>0 AND PHYSICAL_EXAM_TYPE='31' and id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p GROUP BY p.PERSON_ID) %3$s) T, " +
			" ECH_PHYSICAL_EXAM_RECORD R  " + 
			" WHERE 1=1 AND T.PERSON_ID=R.PERSON_ID %2$s %4$s) guide on b.id=guide.person_id " +
			" left join ( select ID FILL_PERSON from BI_PERSON_INFO " + 
			" WHERE filing_Flag = '1' AND STAR >= '2' %5$s )bi on bi.FILL_PERSON=b.id" + 
			" ) GROUP BY %1$s) on item_code = %1$s where dic_code='FS990001' and status =1 %6$s  ORDER BY item_code";
	
	@Override
	public Long getElderlyHealthStatistics(String orgCode, String year) {
		if (ObjectUtil.isNullOrEmpty(orgCode)) {
			return null;
		}
		StringBuilder sqlBuilder = new StringBuilder("SELECT ID  FROM ELDERLY_HEALTH_STATISTICS WHERE ORG_CODE='");
		sqlBuilder.append(orgCode);
		sqlBuilder.append("'");
		sqlBuilder.append(" AND TO_CHAR(EXAM_YEAR, 'YYYY')='");
		sqlBuilder.append(ObjectUtil.isNullOrEmpty(year) ? DateUtil.getCurrentYear() : year);
		sqlBuilder.append("'");
		List<Map<String, Object>> mapList = getMapList(sqlBuilder.toString(), (Criteria) null);
		if (ObjectUtil.isNotEmpty(mapList)) {
			return Long.valueOf(String.valueOf(mapList.get(0).get("ID")));
		}
		return null;
	}
	
	@Override
	public Map<String,Object> getStatisticsMap(Criteria criteria){
		Map<String,Object> result = null;
		StringBuilder sql = new StringBuilder(ALL_QUANTITY_SQL);
		if(ObjectUtil.isNotEmpty(criteria)){
			SqlBuilder.buildWhereStatement(ElderlyHealthStatistics.class, sql, criteria);
			result = getMap(sql.toString(), criteria);
		}
		return result;
	}

	@Override
	public List<Map<String,Object>> getElderlyStatisticsMapList(
			Map<String, String> paramMap, List<String> organList) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		String examYear = paramMap.get("examYear");
//		String orgCode = paramMap.get("orgCode");
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria, "examYear", DateUtil.makeDateToZero(DateUtil.parseSimpleDate(examYear, "yyyy")), DateUtil.parseSimpleDate(examYear, "yyyy"));
		SqlBuilder.buildWhereStatement(ElderlyHealthStatistics.class,sqlBuilder, criteria);
		StringBuilder orgConditionBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(organList)) {
//			orgConditionBuilder.append(" and organ_code= '" + orgCode + "'");
			orgConditionBuilder.append(" and organ_code in (:orgCode)");
			criteria.add("orgCode", organList);
		}
		String having = "having grouping_id(gb_code,parent_code)!=1";
		String sql=String.format(ELDERLY_STATISTICS_SQL1, sqlBuilder,orgConditionBuilder);
		return getMapList(sql, criteria);
	}

	@Override
	public List<Map<String, Object>> getElderlyStatisticsMapList(Criteria c, List<String> organList, Integer type) {
		String orgCode = (String)c.get("orgCode");
		String beginTime = (String)c.get("beginTime");
		String endTime = (String)c.get("endTime");
		
		Criteria criteria = new Criteria();
		String sql = null;
		StringBuilder sqlBuilder_1 = new StringBuilder();
		StringBuilder sqlBuilder_2 = new StringBuilder();
		StringBuilder sqlBuilder_3 = new StringBuilder();
		StringBuilder sqlBuilder_4 = new StringBuilder();
		StringBuilder sqlBuilder_5 = new StringBuilder();
		StringBuilder sqlBuilder_6 = new StringBuilder();
		StringBuilder sqlBuilder_7 = new StringBuilder();
		StringBuilder sqlBuilder_8 = new StringBuilder();
		StringBuilder sqlBuilder_9 = new StringBuilder();
		StringBuilder sqlBuilder_10 = new StringBuilder();
		StringBuilder sqlBuilder_11 = new StringBuilder();
		StringBuilder sqlBuilder_12 = new StringBuilder();
		StringBuilder sqlBuilder_13 = new StringBuilder();
		sqlBuilder_1.append(" and count_year = :year");
		sqlBuilder_2.append(" and TO_CHAR(r.EXAM_YEAR, 'YYYY') = :year");
		criteria.add("year",endTime.split("/")[0]);
		String lastDayOfYear =endTime.split("/")[0] +"/12/31";
		
		if(ObjectUtil.isNotEmpty(beginTime)){
			sqlBuilder_5.append(" and to_char(").append("EXAM_YEAR").append(",'yyyy/mm/dd') >= :beginTime");
			sqlBuilder_6.append(" and to_char(").append("examination_date").append(",'yyyy/mm/dd') >= :beginTime");
			sqlBuilder_10.append(" TO_CHAR (create_date, 'yyyy/mm/dd') >= :beginTime");
			sqlBuilder_11.append(" TO_CHAR (EXAMINATION_DATE, 'yyyy/mm/dd') >= :beginTime");
			criteria.add("beginTime",beginTime);
		}
		if(ObjectUtil.isNotEmpty(endTime)){
			sqlBuilder_5.append(" and to_char(").append("EXAM_YEAR").append(",'yyyy/mm/dd') <= :endTime");
			sqlBuilder_6.append(" and to_char(").append("examination_date").append(",'yyyy/mm/dd') <= :endTime");
			sqlBuilder_7.append(" and to_char(CREATE_DATE,'yyyy/mm/dd') <= :endTime AND TO_CHAR(BIRTHDAY, 'YYYY') <= :year - 65");
			//sqlBuilder_8.append(" and TO_CHAR(st.EXAM_YEAR, 'yyyy/mm/dd') <= :endTime"); 可能有补录的情况 所以不加上被管理日期的条件
			sqlBuilder_10.append(" and TO_CHAR (create_date, 'yyyy/mm/dd') <= :endTime");
			sqlBuilder_11.append(" and TO_CHAR (EXAMINATION_DATE, 'yyyy/mm/dd') <= :endTime");
			sqlBuilder_12.append(" to_char(").append("r.EXAM_YEAR").append(",'yyyy/mm/dd') < '").append(lastDayOfYear).append("'");
			criteria.add("endTime",endTime);
		}
		
		if (ObjectUtil.isNotEmpty(organList)) {
			sqlBuilder_3.append(" and organ_code in (:organList)");
			sqlBuilder_4.append(" and r.input_organ_code in (:organList)");
			sqlBuilder_9.append(" and st.ORG_CODE in (:organList)");
			sqlBuilder_13.append(" and input_organ_code in (:organList)");
			criteria.add("organList", organList);
		}else if(StringUtil.isNotEmpty(orgCode)) {
			sqlBuilder_3.append(" and organ_code =:orgCode");
			sqlBuilder_4.append(" and r.input_organ_code =:orgCode");
			sqlBuilder_9.append(" and st.ORG_CODE =:orgCode");
			sqlBuilder_13.append(" and input_organ_code =:orgCode");
			criteria.add("orgCode", orgCode);
		}
		
		sql=String.format(type==1 ? ELDERLY_STATISTICS_SQL1 : ELDERLY_STATISTICS_SQL2, sqlBuilder_1, sqlBuilder_2, sqlBuilder_3, sqlBuilder_4, sqlBuilder_5, sqlBuilder_6, sqlBuilder_7,sqlBuilder_8,sqlBuilder_9,sqlBuilder_10,sqlBuilder_11,sqlBuilder_12,sqlBuilder_13);
			return getMapList(sql, criteria);
	}

	@Override
	public List<Map<String, Object>> getElderlyStatisticsByPaAddress(Criteria c, List<String> organList, Integer type) {
		String orgCode = (String)c.get("orgCode");
		String beginTime = (String)c.get("beginTime");
		String endTime = (String)c.get("endTime");
		String patownShip = (String) c.get("patownShip");
		String pastreet = (String) c.get("pastreet");
		
		Criteria criteria = new Criteria();
		String sql = null;
		StringBuilder sqlBuilder_2 = new StringBuilder();
		StringBuilder sqlBuilder_3 = new StringBuilder();
		StringBuilder sqlBuilder_4 = new StringBuilder();
		StringBuilder sqlBuilder_5 = new StringBuilder();
		StringBuilder sqlBuilder_7 = new StringBuilder();
		StringBuilder sqlBuilder_8 = new StringBuilder();
		StringBuilder sqlBuilder_9 = new StringBuilder();
		StringBuilder sqlBuilder_10 = new StringBuilder();
		StringBuilder sqlBuilder_11 = new StringBuilder();
		StringBuilder sqlBuilder_12 = new StringBuilder();
		
		sqlBuilder_2.append(" AND TO_CHAR(r.EXAM_YEAR, 'YYYY') = :year");
		sqlBuilder_8.append(" and TO_CHAR(st.EXAM_YEAR, 'YYYY') <= :year");
		sqlBuilder_10.append(" TO_CHAR (create_date, 'yyyy') = :year");
		sqlBuilder_11.append(" EXAM_YEAR = :year");
		criteria.add("year",endTime.split("/")[0]);
		String lastDayOfYear =endTime.split("/")[0] +"/12/31";
		if(ObjectUtil.isNotEmpty(beginTime)){
			sqlBuilder_3.append(" and to_char(").append("examination_date").append(",'yyyy/mm/dd') >= :beginTime");
			sqlBuilder_7.append(" and to_char(").append("EXAM_YEAR").append(",'yyyy/mm/dd') >= :beginTime");
			criteria.add("beginTime",beginTime);
		}
		if(ObjectUtil.isNotEmpty(endTime)){
			sqlBuilder_3.append(" and to_char(").append("examination_date").append(",'yyyy/mm/dd') <= :endTime");
			sqlBuilder_7.append(" and to_char(").append("EXAM_YEAR").append(",'yyyy/mm/dd') <= :endTime");
			sqlBuilder_5.append(" and to_char(CREATE_DATE,'yyyy/mm/dd') <= :endTime AND TO_CHAR(BIRTHDAY, 'YYYY') <= :year - 65");
			sqlBuilder_12.append(" to_char(").append("r.EXAM_YEAR").append(",'yyyy/mm/dd') < '").append(lastDayOfYear).append("'");
			criteria.add("endTime",endTime);
		}
		
		if (ObjectUtil.isNotEmpty(organList)) {
			sqlBuilder_4.append(" and ").append("R.INPUT_ORGAN_CODE").append(" in (:organList)");
			sqlBuilder_5.append(" and ").append("INPUT_ORGAN_CODE").append(" in (:organList)");
			sqlBuilder_9.append(" and st.ORG_CODE in (:organList)");
			criteria.add("organList", organList);
		}else if(StringUtil.isNotEmpty(orgCode)) {
			sqlBuilder_4.append(" and ").append("R.INPUT_ORGAN_CODE").append(" =:orgCode");
			sqlBuilder_5.append(" and ").append("INPUT_ORGAN_CODE").append(" =:orgCode");
			sqlBuilder_9.append(" and st.ORG_CODE =:orgCode");
			criteria.add("orgCode", orgCode);
		}
		
		String groupCol = "patown_ship";
		String sqlBuilder_6 = "and parent_code='411481000000'";
		if(StringUtil.isNotEmpty(pastreet)){
			groupCol = "pastreet";
			sqlBuilder_6 = "and item_code='"+pastreet+"'";
			criteria.add("pastreet", pastreet);
		}else if(StringUtil.isNotEmpty(patownShip)){
			groupCol = "pastreet";
			sqlBuilder_6 = "and parent_code='"+patownShip+"'";
			criteria.add("patownShip", patownShip);
		}
		
		sql=String.format(type==1 ? ELDERLY_PAADDRESS_SQL1 : ELDERLY_PAADDRESS_SQL2, groupCol, sqlBuilder_2, sqlBuilder_3, sqlBuilder_4, sqlBuilder_5, sqlBuilder_6, sqlBuilder_7,sqlBuilder_8,sqlBuilder_9,sqlBuilder_10,sqlBuilder_11,sqlBuilder_12);
		return getMapList(sql, criteria);
	}
}
