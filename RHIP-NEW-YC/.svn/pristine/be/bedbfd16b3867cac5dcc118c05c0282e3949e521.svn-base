package com.founder.rhip.ehr.repository.clinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 老年人和慢病体检
 * 
 * @author liuk
 * 
 */
@Repository("elderlyPhyExaminationDao")
public class ElderlyPhyExaminationDaoImpl extends AbstractDao<ElderlyPhyExamination, Long> implements IElderlyPhyExaminationDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String ELDERLY_PHYSICAL_EXAM_STATISTICS_SQL = "select examination_organ_code orgCode,sum(case when LEUKOCYTE_COUNT "
			+ " is not null or PLATELET_COUNT is not null or HEMOGLOBIN_VALUE is not null or TC is not null"
			+ " or TRIGLYCERIDE_VALUE is not null or SERUM_AST_VALUE is not null or SERUM_GPT_VALUE is not null "
			+ " or TOTAL_BILIRUBIN is not null then 1 else 0 end) bloodBioQuantity,"
			+ " sum(case when ERY_QUANTITATIVE_VALUE is not null or KET_QUANTITATIVE_VALUE is not null or URINE_PRO_QUANTITATIVE_VALUE is not null"
			+ " or URINE_SUG_QUANTITATIVE_VALUE is not null or BLOOD_UREA_NITROGEN_VALUE is not null or UREA is not null then 1 else 0 end)urineRoutineQuantity,"
			+ " sum(case when ECG_ANOMALY_FLAG != '2' then 1 else 0 end)ecgQuantity,"
			+ " sum(case when BMODE_ANOMALYF_FLAG != '2' then 1 else 0 end)bUltrasonicQuantity,"
			+ " sum(case when CHEST_X_ANOMALYF_FLAG !='2' then 1 else 0 end)xRayQuantity,"
			+ " sum(case when HYPERTENSION_FLAG ='1' then 1 else 0 end)bpvQuantity,"
			+ " sum(case when BLOOD_GLU_ASSESSMENT ='1' then 1 else 0 end)ifgQuantity,"
			+ " sum(case when DYSLIPIDEMIA_FLAG ='1' then 1 else 0 end)dyslipidemiaQuantity,"
			+ " sum(case when ABNORMAL_LIVER_FLAG ='1' then 1 else 0 end)liverAbnormalQuantity,"
			+ " sum(case when RENAL_FUNCTION_FLAG ='1' then 1 else 0 end)renalAbnormalQuantity,"
			+ " sum(case when ECG_ANOMALY_FLAG ='1' then 1 else 0 end)xRayAbnormalQuantity,"
			+ " sum(case when HEPATIC_CYST_FLAG ='1' then 1 else 0 end)hepaticCystQuantity,"
			+ " sum(case when FATTY_LIVER_FLAG ='1' then 1 else 0 end)fattyLiverQuantity,"
			+ " sum(case when GALL_STONE_FLAG ='1' then 1 else 0 end)gallStoneQuantity,"
			+ " sum(case when CHOLECYSTITIS_FLAG ='1' then 1 else 0 end)cholecystitisQuantity,"
			+ " sum(case when RENAL_CYST_FLAG ='1' then 1 else 0 end)renalCystQuantity,"
			+ " sum(case when KIDNEY_STONE_FLAG ='1' then 1 else 0 end)kidneyStoneQuantity,"
			+ " sum(case when TUMOR_FLAG ='1' then 1 else 0 end)tumorQuantity,"
			+ " sum(case when TUBERCULOSIS_FLAG ='1' then 1 else 0 end)tuberculosisQuantity"
			+ " from ECH_elderly_phy_examination t where physical_exam_type = '31' %1$s group by examination_organ_code";

    private static final String PHY_EXAMINATION_STATISTICS_ORG_SQL = "with \n" +
            "temp as (\n" +
            "        select \n" +
            "        d.person_id,d.idcard,p.examination_organ_code create_organ_code, p.mana_doctor_id create_doctor_code,\n" +
            "        info.patown_ship, info.pastreet,\n" +
            "        p.examination_date,d.hbp_flag,\n" +
            "        d.di_flag,fpg_mmol,fpg_mg\n" +
            "        from dm_disease_info d \n" +
            "        left join bi_person_info info on info.id=d.person_id\n" +
            "        left join ech_elderly_phy_examination p on d.person_id = p.person_id and physical_exam_type='39'\n" +
            "        where (d.hbp_flag = '2' or d.di_flag = '2')\n" +
            "        and exists(select t.id from ech_elderly_phy_examination t where d.person_id = t.person_id and t.physical_exam_type='39')\n" +
            "        %3$s\n" +
            "        %4$s\n"+
            "        %5$s\n"+
            "),\n" +
            "phy as(\n" +
            "    select \n" +
            "         create_organ_code, create_doctor_code,\n" +
            "        sum(hbp_phy_num)hbp_phy_num,\n" +
            "        sum(di_phy_num)di_phy_num\n" +
            "    from(\n" +
            "        select \n" +
            "        distinct person_id, create_organ_code, create_doctor_code,\n" +
            "        patown_ship, pastreet,\n" +
            "        case when to_char(examination_date, 'yyyy/mm/dd') <= '%2$s'\n" +
            "              and hbp_flag = '2' then 1 else 0 end hbp_phy_num,--累计高血压体检\n" +
            "        case when to_char(examination_date, 'yyyy/mm/dd') <= '%2$s'\n" +
            "              and di_flag = '2' then 1 else 0 end di_phy_num--累计糖尿病体检\n" +
            "        from temp \n" +
            "    ) group by create_organ_code, create_doctor_code\n" +
            "),\n" +
            "phy_fpg as (\n" +
            "    select \n" +
            "         create_organ_code, create_doctor_code,\n" +
            "        sum(di_fpg_num)di_fpg_num\n" +
            "    from(\n" +
            "        select \n" +
            "        person_id, create_organ_code, create_doctor_code,\n" +
            "        patown_ship, pastreet,\n" +
            "        case when to_char(examination_date, 'yyyy/mm/dd') >= '%1$s'\n" +
            "              and to_char(examination_date, 'yyyy/mm/dd') <= '%2$s'\n" +
            "             -- and di_flag = '2'\n" +
            "              and(fpg_mmol is not null or fpg_mg is not null) then 1 else 0 end di_fpg_num--体检空血检查人次数\n" +
            "        from temp\n" +
            "    ) group by create_organ_code, create_doctor_code\n" +
            ")\n" +
            "    \n" +
            "select phy.create_organ_code, phy.create_doctor_code, hbp_phy_num, di_phy_num, di_fpg_num\n" +
            "from phy\n" +
            "left join phy_fpg on phy_fpg.create_organ_code = phy.create_organ_code and phy_fpg.create_doctor_code=phy.create_doctor_code\n" +
            "where 1=1 order by  create_organ_code, create_doctor_code";

    private static final String PHY_EXAMINATION_STATISTICS_VILLAGE_SQL = "with \n" +
            "temp as (\n" +
            "        select \n" +
            "        d.person_id,d.idcard,p.examination_organ_code create_organ_code, p.mana_doctor_id create_doctor_code,\n" +
            "        info.patown_ship, info.pastreet,\n" +
            "        p.examination_date,d.hbp_flag,\n" +
            "        d.di_flag,fpg_mmol,fpg_mg\n" +
            "        from dm_disease_info d \n" +
            "        left join bi_person_info info on info.id=d.person_id\n" +
            "        left join ech_elderly_phy_examination p on d.person_id = p.person_id and physical_exam_type='39'\n" +
            "        where (d.hbp_flag = '2' or d.di_flag = '2')\n" +
            "        and exists(select t.id from ech_elderly_phy_examination t where d.person_id = t.person_id and t.physical_exam_type='39')\n" +
            "        %3$s\n" +
            "        %4$s\n"+
            "        %5$s\n"+
            "),\n" +
            "phy as(\n" +
            "    select \n" +
            "        patown_ship, pastreet,\n" +
            "        sum(hbp_phy_num)hbp_phy_num,\n" +
            "        sum(di_phy_num)di_phy_num\n" +
            "    from(\n" +
            "        select \n" +
            "        distinct person_id, create_organ_code, create_doctor_code,\n" +
            "        patown_ship, pastreet,\n" +
            "        case when to_char(examination_date, 'yyyy/mm/dd') <= '%2$s'\n" +
            "              and hbp_flag = '2' then 1 else 0 end hbp_phy_num,--累计高血压体检\n" +
            "        case when to_char(examination_date, 'yyyy/mm/dd') <= '%2$s'\n" +
            "              and di_flag = '2' then 1 else 0 end di_phy_num--累计糖尿病体检\n" +
            "        from temp \n" +
            "    ) group by patown_ship, pastreet\n" +
            "),\n" +
            "phy_fpg as (\n" +
            "    select \n" +
            "        patown_ship, pastreet,\n" +
            "        sum(di_fpg_num)di_fpg_num\n" +
            "    from(\n" +
            "        select \n" +
            "        person_id, create_organ_code, create_doctor_code,\n" +
            "        patown_ship, pastreet,\n" +
            "        case when to_char(examination_date, 'yyyy/mm/dd') >= '%1$s'\n" +
            "              and to_char(examination_date, 'yyyy/mm/dd') <= '%2$s'\n" +
            "              --and di_flag = '2'\n" +
            "              and(fpg_mmol is not null or fpg_mg is not null) then 1 else 0 end di_fpg_num--体检空血检查人次数\n" +
            "        from temp\n" +
            "    ) group by patown_ship, pastreet\n" +
            ")\n" +
            "    \n" +
            "select phy.patown_ship, phy.pastreet, hbp_phy_num, di_phy_num, di_fpg_num\n" +
            "from phy\n" +
            "left join phy_fpg on phy_fpg.patown_ship = phy.patown_ship and phy_fpg.pastreet=phy.pastreet\n" +
            "where 1=1 order by  patown_ship, pastreet";
 
    private static final String PHY_CENSUS_ORG_SQL = "with \n" +
            "org as ( select organ_code,GB_CODE,ORGAN_NAME,genre_code,decode(genre_code,'B200',parent_code,organ_code) parent_code from mdm_organization where genre_code in ('B100','B200') and STATUS=1 %3$s)"+ 
            ",phy as (\n" +
            "        select %4$s create_organ_code,sum(decode(d.hbp_flag,'2',1,0)) hbp_phy_num,sum(decode(d.di_flag,'2',1,0)) di_phy_num" +
            "        from dm_disease_info d \n" +
            "        left join bi_person_info info on info.id=d.person_id\n" +
            "        left join ech_elderly_phy_examination p on d.person_id = p.person_id and physical_exam_type='39'\n" +
            "        left join org on p.examination_organ_code=org.organ_code"+
            "		 where (d.hbp_flag = '2' or d.di_flag = '2')\n" +
            "        and exists(select t.id from ech_elderly_phy_examination t where d.person_id = t.person_id and t.physical_exam_type='39')\n" +
            "  		and to_char(examination_date, 'yyyy/mm/dd') >= '%1$s' "+
            "		and to_char(examination_date, 'yyyy/mm/dd') <= '%2$s' group by %4$s),\n" +
			"hbp_followup as(select create_organ_code,sum(hbp_num) hbp_num from (\n" +
			"		select decode(sign(count(person_id)-6),1,6,count(person_id)) hbp_num, %4$s create_organ_code\n" +
			"		from dm_hypertension_followup h left join org on h.create_organ_code=org.organ_code\n" +
			"		where person_id is not null and to_char(visit_date, 'yyyy/mm/dd') >= '%1$s' \n" +
			"		and to_char(visit_date, 'yyyy/mm/dd') <= '%2$s' group by %4$s,person_id) GROUP BY create_organ_code),\n" +
			"di_followup as (select create_organ_code, sum(di_num) di_num from (\n" +
			"		select decode(sign(count(person_id)-6),1,6,count(person_id)) di_num, %4$s create_organ_code\n" +
			"		from dm_diabetic_followup h left join org on h.create_organ_code=org.organ_code\n" +
			"		where person_id is not null and to_char(visit_date, 'yyyy/mm/dd') >= '%1$s' \n" +
			"		and to_char(visit_date, 'yyyy/mm/dd') <= '%2$s' group by %4$s,person_id) GROUP BY create_organ_code),\n" +
			"followup_result as ( select \n" +
			"    	case when hf.create_organ_code is not null then hf.create_organ_code else df.create_organ_code end create_organ_code,\n" +
			"    	hbp_num, di_num\n" +
			"    	from hbp_followup hf full join di_followup df on hf.create_organ_code = df.create_organ_code )\n" +
			"select create_organ_code,hbp_phy_num,di_phy_num,hbp_fllowup_times_num,di_fllowup_times_num from ("+ 
			"		select decode(grouping(%4$s), 1, '合计', %4$s) create_organ_code,\n" +
			"		sum(nvl(hbp_phy_num,0)) hbp_phy_num,\n" +
			"		sum(nvl(di_phy_num,0)) di_phy_num,\n" +
			"		sum(nvl(hbp_num,0)) hbp_fllowup_times_num,\n" +
			"		sum(nvl(di_num,0)) di_fllowup_times_num\n" +
			"		from  org left join phy on phy.create_organ_code=org.organ_code left join followup_result result on result.create_organ_code = org.organ_code\n" +
			"		group by rollup(%4$s)) t left join org on org.organ_code=t.create_organ_code order by GB_CODE, genre_code,nlssort(organ_name,'NLS_SORT=SCHINESE_PINYIN_M')";
    
	@Override
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	@Override
	public ElderlyPhyExamination getElderlyPhyExamination(Long personId, int year, String type) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT * ");
		sqlBuilder.append(" FROM ECH_ELDERLY_PHY_EXAMINATION WHERE PERSON_ID = ");
		sqlBuilder.append(personId);
		sqlBuilder.append("  AND TO_CHAR(EXAMINATION_DATE,'YYYY')='");
		sqlBuilder.append(year);
		sqlBuilder.append("'");
		sqlBuilder.append(" AND PHYSICAL_EXAM_TYPE='");
		sqlBuilder.append(type);
		sqlBuilder.append("'");
		return get(sqlBuilder.toString(), (Criteria)null);
	}

	@Override
	public List<Map<String, Object>> getElderlyExaminationStatisticsMapList(String dateStr) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			return mapList;
		}
		String dateConditonSql = new StringBuilder(" and to_char(examination_date, 'yyyy')='").append(dateStr).append("'").toString();
		String sql = String.format(ELDERLY_PHYSICAL_EXAM_STATISTICS_SQL, dateConditonSql);
		return getMapList(sql, new Criteria());
	}

    @Override
    public PageList<ElderlyPhyExamination> getPhysiqueExaminationTableList(Page page, Criteria criteria,String examinationDateStart, String examinationDateEnd,String year){
        Date date1=DateUtil.parseSimpleDate(examinationDateStart, "yyyy/MM/dd");
        Date date2=DateUtil.parseSimpleDate(examinationDateEnd, "yyyy/MM/dd");
        StringBuilder sqlBuilder = new StringBuilder();
        criteria.get("pt.examination_date");
        String criterionExamination = (String)criteria.get("criterionExamination");
        criteria.remove("criterionExamination");
        criteria.remove("examYearStr");
        sqlBuilder.append("SELECT ep.*,pi.phone_number FROM ECH_PHYSICAL_EXAM_RECORD record");

        if(ObjectUtil.isNotEmpty(date1) || ObjectUtil.isNotEmpty(date2)){
            String sql1="  right join (select distinct(pe.person_id) person_id from ECH_ELDERLY_PHY_EXAMINATION pe"
                    + " where 1=1 "+toDateSql(date1,date2,"pe.examination_date")+") pt  on record.person_id=pt.person_id  ";
            sqlBuilder.append(sql1);
        }

        sqlBuilder.append(" right join MS_HEALTH_EXAMINATION@DL_MS he on he.person_id=record.person_id");
        if(ObjectUtil.isNotEmpty(year)){
            sqlBuilder.append(" AND TO_CHAR(he.EXAMINATION_DATE, 'YYYY') = '" + year + "'");
        }
        sqlBuilder.append( " right join ECH_ELDERLY_PHY_EXAMINATION ep on ep.ehr_Id=he.ehr_Id"
                + " inner join bi_person_info pi on ep.PERSON_ID= pi.id ");





        SqlBuilder.buildWhereStatement(PhysicalExamRecord.class, sqlBuilder, criteria);

        if(StringUtil.isNotEmpty(criterionExamination)){
            String sql=" (SELECT 1 FROM ECH_ELDERLY_PHY_EXAMINATION P WHERE RECORD.PERSON_ID = P.PERSON_ID" +
                    //血常规
                    " AND (P.HEMOGLOBIN_VALUE IS NOT NULL OR  P.LEUKOCYTE_COUNT IS NOT NULL OR P.PLATELET_COUNT IS NOT NULL OR P.BLOOD_ROUTINE_OTHER_DESC IS NOT NULL)" +
                    //尿常规
                    " AND (P.URINE_PRO_QUANTITATIVE_VALUE IS NOT NULL OR  P.URINE_SUG_QUANTITATIVE_VALUE IS NOT NULL OR P.KET_QUANTITATIVE_VALUE IS NOT NULL OR  P.ERY_QUANTITATIVE_VALUE IS NOT NULL OR P.URINE_ROUTINES_OTHER_DESC IS NOT NULL)" +
                    //肝功能
                    " AND (P.SERUM_GPT_VALUE IS NOT NULL OR  P.SERUM_AST_VALUE IS NOT NULL OR P.TOTAL_BILIRUBIN IS NOT NULL)" +
                    //肾功能
                    " AND (P.CREATININE IS NOT NULL OR  P.BLOOD_UREA_NITROGEN_VALUE IS NOT NULL)" +
                    //空腹血糖
                    " AND (P.FPG_MMOL IS NOT NULL OR FPG_MG IS NOT NULL)" +
                    //血脂
                    " AND (P.TC IS NOT NULL OR P.TRIGLYCERIDE_VALUE IS NOT NULL OR  P.LDLC_DETECT_VALUE IS NOT NULL OR P.HDLC_DETECT_VALUE IS NOT NULL)" +
                    //心电图检测
                    " AND (P.ECG_ANOMALY_FLAG IS NOT NULL AND P.ECG_ANOMALY_FLAG <> 2)" +
                    //腹部B超
                    " AND (P.BMODE_ANOMALYF_FLAG IS NOT NULL AND P.BMODE_ANOMALYF_FLAG <> 2)" +
                    //自我评估
                    " AND P.HEALTH_SELF_ASSESSMENT IS NOT NULL AND P.LIFE_ABILITY_SELF_ASSESSMENT IS NOT NULL AND P.EATING_ASSESSMENT IS NOT NULL AND P.CLEANING_ASSESSMENT IS NOT NULL AND P.CLOTHING_ASSESSMENT IS NOT NULL AND P.DEFECATION_ASSESSMENT IS NOT NULL AND P.EXERCISE_ASSESSMENT IS NOT NULL AND P.COGNITION_SCREEN_RESULT IS NOT NULL AND P.EMOTION_SCREEN_RESULT IS NOT NULL" +
                    //中医体质辨识
                    " AND (P.TCM_PEACEFUL_QUALITY IS NOT NULL OR P.TCM_QI_QUALITY IS NOT NULL OR P.TCM_YANG_QUALITY IS NOT NULL OR P.TCM_YIN_DEFICIENCY IS NOT NULL OR P.TCM_PHLEGM_WETNESS IS NOT NULL OR P.TCM_HEAT_MEDIUM IS NOT NULL OR P.TCM_BLOOD_QUALITY IS NOT NULL OR P.TCM_QI_STAGNATION IS NOT NULL OR P.TCM_SPECIAL_QUALITY IS NOT NULL)" +
                    //中医健康指导
                    " AND RECORD.HEALTH_GUIDE_STATUS = 1)";

            sqlBuilder.append((criterionExamination.equals("0")?" AND NOT EXISTS ":" AND EXISTS ") + sql);
        }

        SqlBuilder.buildOrderStatement(sqlBuilder, "ep.examination_date desc");
        return this.getPageList (page, sqlBuilder.toString(), criteria);
    }

    @Override
    public PageList<Map<String, Object>> getPageMapTableList(Page page, Criteria criteria, String examinationDateStart,
                                                             String examinationDateEnd, String year) {

        Date date1= DateUtil.parseSimpleDate(examinationDateStart, "yyyy/MM/dd");
        Date date2=DateUtil.parseSimpleDate(examinationDateEnd, "yyyy/MM/dd");
        StringBuilder sqlBuilder = new StringBuilder();
        criteria.get("pt.examination_date");
        String criterionExamination = (String)criteria.get("criterionExamination");
        criteria.remove("criterionExamination");
        sqlBuilder.append("SELECT ep.*,pi.phone_number FROM PHYSICAL_EXAM_RECORD record");
        if(ObjectUtil.isNotEmpty(date1) || ObjectUtil.isNotEmpty(date2)){
            String sql1="  right join (select distinct(pe.person_id) person_id from ECH_ELDERLY_PHY_EXAMINATION pe"
                    + " where 1=1 "+toDateSql(date1,date2,"pe.examination_date")+") pt  on record.person_id=pt.person_id  ";
            sqlBuilder.append(sql1);
        }

        sqlBuilder.append(" right join MS_HEALTH_EXAMINATION@DL_MS he on he.person_id=record.person_id");
        if(ObjectUtil.isNotEmpty(year)){
            sqlBuilder.append(" AND TO_CHAR(he.EXAMINATION_DATE, 'YYYY') = '" + year + "'");
        }
        sqlBuilder.append( " right join ECH_ELDERLY_PHY_EXAMINATION ep on ep.ehr_Id=he.ehr_Id"
                + " inner join bi_person_info pi on ep.PERSON_ID= pi.id ");





        SqlBuilder.buildWhereStatement(PhysicalExamRecord.class, sqlBuilder, criteria);

        if(StringUtil.isNotEmpty(criterionExamination)){
            String sql=" (SELECT 1 FROM ECH_ELDERLY_PHY_EXAMINATION P WHERE RECORD.PERSON_ID = P.PERSON_ID" +
                    //血常规
                    " AND (P.HEMOGLOBIN_VALUE IS NOT NULL OR  P.LEUKOCYTE_COUNT IS NOT NULL OR P.PLATELET_COUNT IS NOT NULL OR P.BLOOD_ROUTINE_OTHER_DESC IS NOT NULL)" +
                    //尿常规
                    " AND (P.URINE_PRO_QUANTITATIVE_VALUE IS NOT NULL OR  P.URINE_SUG_QUANTITATIVE_VALUE IS NOT NULL OR P.KET_QUANTITATIVE_VALUE IS NOT NULL OR  P.ERY_QUANTITATIVE_VALUE IS NOT NULL OR P.URINE_ROUTINES_OTHER_DESC IS NOT NULL)" +
                    //肝功能
                    " AND (P.SERUM_GPT_VALUE IS NOT NULL OR  P.SERUM_AST_VALUE IS NOT NULL OR P.TOTAL_BILIRUBIN IS NOT NULL)" +
                    //肾功能
                    " AND (P.CREATININE IS NOT NULL OR  P.BLOOD_UREA_NITROGEN_VALUE IS NOT NULL)" +
                    //空腹血糖
                    " AND (P.FPG_MMOL IS NOT NULL OR FPG_MG IS NOT NULL)" +
                    //血脂
                    " AND (P.TC IS NOT NULL OR P.TRIGLYCERIDE_VALUE IS NOT NULL OR  P.LDLC_DETECT_VALUE IS NOT NULL OR P.HDLC_DETECT_VALUE IS NOT NULL)" +
                    //心电图检测
                    " AND (P.ECG_ANOMALY_FLAG IS NOT NULL AND P.ECG_ANOMALY_FLAG <> 2)" +
                    //腹部B超
                    " AND (P.BMODE_ANOMALYF_FLAG IS NOT NULL AND P.BMODE_ANOMALYF_FLAG <> 2)" +
                    //自我评估
                    " AND P.HEALTH_SELF_ASSESSMENT IS NOT NULL AND P.LIFE_ABILITY_SELF_ASSESSMENT IS NOT NULL AND P.EATING_ASSESSMENT IS NOT NULL AND P.CLEANING_ASSESSMENT IS NOT NULL AND P.CLOTHING_ASSESSMENT IS NOT NULL AND P.DEFECATION_ASSESSMENT IS NOT NULL AND P.EXERCISE_ASSESSMENT IS NOT NULL AND P.COGNITION_SCREEN_RESULT IS NOT NULL AND P.EMOTION_SCREEN_RESULT IS NOT NULL" +
                    //中医体质辨识
                    " AND (P.TCM_PEACEFUL_QUALITY IS NOT NULL OR P.TCM_QI_QUALITY IS NOT NULL OR P.TCM_YANG_QUALITY IS NOT NULL OR P.TCM_YIN_DEFICIENCY IS NOT NULL OR P.TCM_PHLEGM_WETNESS IS NOT NULL OR P.TCM_HEAT_MEDIUM IS NOT NULL OR P.TCM_BLOOD_QUALITY IS NOT NULL OR P.TCM_QI_STAGNATION IS NOT NULL OR P.TCM_SPECIAL_QUALITY IS NOT NULL)" +
                    //中医健康指导
                    " AND RECORD.HEALTH_GUIDE_STATUS = 1)";

            sqlBuilder.append((criterionExamination.equals("0")?" AND NOT EXISTS ":" AND EXISTS ") + sql);
        }

        SqlBuilder.buildOrderStatement(sqlBuilder, "ep.examination_date desc");
        return this.getPageMapList(page, sqlBuilder.toString(), criteria);

    }

    private String toDateSql(Date beginDate,Date endDate,String columnName){
        StringBuffer sql = new StringBuffer(100);
        if (null != beginDate && null == endDate) {
            sql.append( " AND "+columnName+">=to_date('"+DateUtil.toDateString(beginDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
        } else if (null == beginDate && null != endDate) {
            sql.append(" AND "+columnName+"<=to_date('"+DateUtil.toDateString(endDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
        }
        else if (null != beginDate && null != endDate) {
            sql.append(" AND "+columnName+">=to_date('"+DateUtil.toDateString(beginDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
            sql.append(" AND "+columnName+"<=to_date('"+DateUtil.toDateString(endDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
        }else{
            return "";
        }
        return sql.toString();
    }

    /**
     * 慢病体检统计
     * @param page
     * @param form
     * @return
     */
    @Override
    public PageList<Map<String, Object>> getPhyExaminationStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
        String sql = PHY_EXAMINATION_STATISTICS_ORG_SQL;
        if(ObjectUtil.equals("2", form.getSearchType())) {
            sql = PHY_EXAMINATION_STATISTICS_VILLAGE_SQL;
        }
        String lastSql = this.getLastSql(form, sql, currentOrg);
        PageList<Map<String,Object>> list = this.getPageMapList(page, lastSql, new Criteria());
        return list;
    }

    /**
     * 根据条件获取最终sql
     * @param form
     * @param targetSql
     * @return
     */
    private String getLastSql(ReportQueryForm form, String targetSql, Organization currentOrg) {
        String beginStr = form.getBeginDate();
        String endStr = form.getEndDate();
        String orgSql = "";
        String roleSql = "";
        String staffSql = "";
        //按机构查询
        if (ObjectUtil.isNotEmpty(form.getStationCode())) {//站
            orgSql = " and (p.examination_organ_code = '" + form.getStationCode() + "')";
        } else if (ObjectUtil.isNotEmpty(form.getCentreCode())) {//卫生院
            orgSql = " and (p.examination_organ_code in (select organ_code from mdm_organization " +
                    "where organ_code = '" + form.getCentreCode() + "' or parent_code = '" + form.getCentreCode() + "'))";
        }else if (ObjectUtil.isNotEmpty(form.getTownCode())) {//镇
            orgSql = " and (p.examination_organ_code in (select organ_code from mdm_organization " +
                    "where gb_code = '" + form.getTownCode() + "'))";
        }

        if (ObjectUtil.isNotEmpty(form.getStaffCode())) {
            staffSql = " and p.mana_doctor_id = '" + form.getStaffCode() + "'";
        }
        if(ObjectUtil.equals("2", form.getSearchType())) {
            //中心 站的用户按照现住址查询时仅可以查询本机构的数据
            if(!ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue())
                    && !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CITY_HEALTH.getValue())
                    && !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())
                    ) {
                roleSql = orgSql.replace("create_organ_code", "p.examination_organ_code");
            }
            //按照现住址查询
            if (ObjectUtil.isNotEmpty(form.getPaStreet())) {//居委会
                orgSql = " and (pastreet = '" + form.getPaStreet() + "')";
            }else if (ObjectUtil.isNotEmpty(form.getPatownShip())) {//镇
                orgSql = " and (patown_ship = '" + form.getPatownShip() + "')";
            } else {
                orgSql = "";
            }
        }
        String lastSql = String.format(targetSql, beginStr, endStr, orgSql, staffSql, roleSql);
        return lastSql;
    }

	@Override
	public List<Map<String, Object>> getPhyCensusList(Criteria c) {
		String sql = PHY_CENSUS_ORG_SQL;
		String beginTime = (String)c.get("beginTime");
		String endTime = (String)c.get("endTime");
		String gbcode = (String)c.get("gbcode");
		String centerCode = (String)c.get("centerCode");
		String orgCode = (String)c.get("orgCode");
        String org3 = "";
        String col4 = " ORG.parent_code ";
        if (ObjectUtil.isNotEmpty(orgCode)) {//站
        	org3 = " and organ_code = '" + orgCode + "'";
        	col4 = " org.organ_code ";
        } else if (ObjectUtil.isNotEmpty(centerCode)) {//卫生院
        	org3 = " and (organ_code = '" + centerCode + "' or parent_code = '" + centerCode + "')";
        	col4 = " org.organ_code ";
        }else if (ObjectUtil.isNotEmpty(gbcode)) {//镇
        	org3 = " and gb_code = '" + gbcode + "'";
        }
        String lastSql = String.format(sql, beginTime, endTime, org3, col4);
        return this.getMapList(lastSql, new Criteria());
	}
	
	@Override
	public void updateEchIdentification(PhysiqueExamination phy) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ehr_Id FROM ECH_ELDERLY_PHY_EXAMINATION")
			.append(" WHERE  (IS_DELETE IS NULL OR IS_DELETE<>1 ) AND PERSON_ID = " + phy.getPersonId())
			.append(" AND ((physical_exam_type = '" + EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode() +"' AND TO_CHAR(EXAMINATION_DATE, 'YYYY') = '" + DateUtil.getDateYear(phy.getExaminationDate()) + "')")
			.append( " or (physical_exam_type = '" + EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode() +"' and physical_exam_code='"+ phy.getPhysicalExamCode() +"'))");
		List<Map<String, Object>> map =  getMapList(sql.toString(), new Criteria());
		
		if(ObjectUtil.isNotEmpty(map) ){
			List<String> list = new ArrayList<String>();  
			for(Map<String, Object> m :map){
				list.add((String) m.get("ehr_Id"));
			}
			Parameters parameters = new Parameters();
			parameters.add("tcmPeacefulQuality", phy.getTcmPeacefulQuality());
			parameters.add("tcmQiQuality", phy.getTcmQiQuality());
			parameters.add("tcmYangQuality", phy.getTcmYangQuality());
			parameters.add("tcmYinDeficiency", phy.getTcmYinDeficiency());
			parameters.add("tcmPhlegmWetness", phy.getTcmPhlegmWetness());
			
			parameters.add("tcmHeatMedium", phy.getTcmHeatMedium());
			parameters.add("tcmBloodQuality", phy.getTcmBloodQuality());
			parameters.add("tcmQiStagnation", phy.getTcmQiStagnation());
			parameters.add("tcmSpecialQuality", phy.getTcmSpecialQuality());
			Criteria criteria = new Criteria("ehrId", OP.IN, list);
			this.update( parameters, criteria);
		}
	}
	

	@Override
	public PageList<ElderlyPhyExamination> getPageListCdmTemp(Page page, long id) {
		StringBuilder sql = new StringBuilder("select PHY.id,ECH.id IDENTIFICATION_ID from ECH_ELDERLY_PHY_EXAMINATION phy "
				+ "inner join ECH_IDENTIFICATION ech  on ECH.person_id=PHY.PERSON_ID  and ECH.temp_year=to_char(phy.EXAMINATION_DATE, 'yyyy') "
				+ " where ECH.temp_year is not null and PHYSICAL_EXAM_TYPE='39' and IDENTIFICATION_ID is null and phy.id>="+id+" order by phy.id");
		
		return this.getPageList(page,sql.toString(), new Criteria());
	}
	@Override
	public PageList<ElderlyPhyExamination> getPageListHmTemp(Page page, long id) {
		StringBuilder sql = new StringBuilder("select PHY.id,ECH.id IDENTIFICATION_ID from ECH_ELDERLY_PHY_EXAMINATION phy "
				+ "inner join ECH_IDENTIFICATION ech  on ECH.person_id=PHY.PERSON_ID and ECH.temp_code=phy.PHYSICAL_EXAM_CODE"
				+ " where PHYSICAL_EXAM_TYPE='31' and IDENTIFICATION_ID is null and phy.id>="+id+" order by phy.id");
		
		return this.getPageList(page,sql.toString(), new Criteria());
	}
	@Override
	public PageList<ElderlyPhyExamination> getPageListHmYearTemp(Page page, long id) {
		StringBuilder sql = new StringBuilder("select PHY.id,TO_CHAR(RECORD.exam_YEAR,'yyyy') EXAM_YEAR from ECH_ELDERLY_PHY_EXAMINATION phy "
				+ "inner join ECH_PHYSICAL_EXAM_RECORD record on record.person_id=PHY.PERSON_ID and record.EXAM_NUMBER=PHY.PHYSICAL_EXAM_CODE"
				+ " where phy.PHYSICAL_EXAM_TYPE='31' and phy.EXAM_YEAR is null and EXAMINATION_ORGAN_CODE is not null and phy.id>="+id+" order by phy.id");
		
		return this.getPageList(page,sql.toString(), new Criteria());
	}
	
	
	@Override
	public PageList<ElderlyPhyExamination> getPageHmStatusTemp(Page page, long id) {
		StringBuilder sql = new StringBuilder("select PHY.* from ECH_ELDERLY_PHY_EXAMINATION phy where PHY.PHYSICAL_EXAM_TYPE='31' "
				+ " and phy.id>="+id+" and EXAMINATION_ORGAN_CODE is not null and not EXISTS(\n" +
				"	select 1 from ECH_ELDERLY_PHY_STATUS status \n" +
				"	where PHY.person_id=status.person_id and PHY.physical_Exam_Code=status.physical_Exam_Code\n" +
				")  order by phy.id");
		
		return this.getPageList(page, sql.toString(), new Criteria());
	}
}
