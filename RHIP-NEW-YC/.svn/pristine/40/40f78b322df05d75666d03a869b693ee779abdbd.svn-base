package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.HmQueryConditionHelper;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * DAO implement of HmOutpatient
 * 
 */
@Repository("ihmOutpatientDao")
public class HmOutpatientDaoImpl extends AbstractDao<HmOutpatient, Long> implements IHmOutpatientDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private static final String DRUG_USE_FEE_SQL = "WITH ORG AS(\n" +
			"			SELECT  ORGAN_CODE FROM MDM_ORGANIZATION\n" +
			"			%1$s\n" +
			"			GROUP BY ORGAN_CODE\n" +
			"		)\n" +
			"			SELECT\n" +
			"				ORG.ORGAN_CODE,\n" +
			"				SUM(IN_HOS_FEE) IN_HOS_FEE,--出院病人总费用\n" +
			"				SUM(IN_HOS_MEDICINAL_FEE) IN_HOS_MEDICINAL_FEE,--出院病人总费用药品费\n" +
			"				round(sum(IN_HOS_MEDICINAL_FEE)/decode(sum(IN_HOS_FEE),0,null,sum(IN_HOS_FEE)),4) CY_YP_RATE,--出院病人药品比例\n" +
			"				SUM(EMERGENCY_FEE)+SUM(OUTPATIENT_FEE)  MZ_TOTAL_FEE,--门急诊病人总费用\n" +
			"				SUM(OUTPATIENT_MEDICINAL_FEE)+SUM(EMERGENCY_MEDICINAL_FEE)  MZ_YP_FEE,--门急诊病人药品收入\n" +
			"				round((sum(OUTPATIENT_MEDICINAL_FEE)+sum(EMERGENCY_MEDICINAL_FEE))/decode((sum(EMERGENCY_FEE)+sum(OUTPATIENT_FEE)),0,null,(sum(EMERGENCY_FEE)+sum(OUTPATIENT_FEE))),4) MZ_YP_RATE --门急诊病人药品比例\n" +
			"				FROM ORG\n" +
			"				LEFT JOIN (\n" +
			"					SELECT  ORGAN_CODE,\n" +
			"									EMERGENCY_FEE,\n" +
			"									OUTPATIENT_FEE,\n" +
			"									OUTPATIENT_MEDICINAL_FEE,\n" +
			"									EMERGENCY_MEDICINAL_FEE,\n" +
			"									0 AS IN_HOS_FEE,\n" +
			"									0	AS IN_HOS_MEDICINAL_FEE\n" +
			"					FROM RP_HM_OUTPATIENT  %2$s \n" +
			"					UNION ALL\n" +
			"					SELECT  ORGAN_CODE,\n" +
			"									0 AS EMERGENCY_FEE,\n" +
			"									0 AS OUTPATIENT_FEE,\n" +
			"									0 AS OUTPATIENT_MEDICINAL_FEE,\n" +
			"									0 AS EMERGENCY_MEDICINAL_FEE,\n" +
			"									IN_HOS_FEE,--出院病人总费用\n" +
			"									IN_HOS_MEDICINAL_FEE--出院病人总费用药品费\n" +
			"					FROM RP_HM_HOSPITALIZE  %2$s \n" +
			"				) exam on ORG.ORGAN_CODE = exam.ORGAN_CODE\n" +
			"			GROUP BY rollup(ORG.ORGAN_CODE)";
	private static final String CHECK_EXAM_FEE_SQL = "WITH ORG AS(\n" +
			"			SELECT  ORGAN_CODE FROM MDM_ORGANIZATION\n" +
			"			%1$s\n" +
			"			GROUP BY ORGAN_CODE\n" +
			"		)\n" +
			"			SELECT\n" +
			"				ORG.ORGAN_CODE,\n" +
			"				SUM(OUTPATIENT_CHECK_FEE) OUTPATIENT_CHECK_FEE,--门诊检查收入\n" +
			"				SUM(EMERGENCY_CHECK_FEE) EMERGENCY_CHECK_FEE,--急诊检查收入\n" +
			"				SUM(OUTPATIENT_TEST_FEE) OUTPATIENT_TEST_FEE,--门诊检验收入\n" +
			"				SUM(EMERGENCY_TEST_FEE) EMERGENCY_TEST_FEE,--急诊检验收入\n" +
			"				SUM(IN_HOS_CHECK_FEE) IN_HOS_CHECK_FEE,--住院检查收入\n" +
			"				SUM(IN_HOS_TEST_FEE) IN_HOS_TEST_FEE --住院检验收入\n" +
			"				FROM ORG\n" +
			"				LEFT JOIN (\n" +
			"					SELECT  ORGAN_CODE,\n" +
			"									OUTPATIENT_CHECK_FEE,--门诊检查收入\n" +
			"									EMERGENCY_CHECK_FEE,--急诊检查收入\n" +
			"									OUTPATIENT_TEST_FEE,--门诊检验收入\n" +
			"									EMERGENCY_TEST_FEE,--急诊检验收入\n" +
			"									0 AS IN_HOS_CHECK_FEE,--住院检查收入\n" +
			"									0 AS IN_HOS_TEST_FEE --住院检验收入\n" +
			"					FROM RP_HM_OUTPATIENT %2$s \n" +
			"					UNION ALL\n" +
			"					SELECT  ORGAN_CODE,\n" +
			"									0 AS OUTPATIENT_CHECK_FEE,--门诊检查收入\n" +
			"									0 AS EMERGENCY_CHECK_FEE,--急诊检查收入\n" +
			"									0 AS OUTPATIENT_TEST_FEE,--门诊检验收入\n" +
			"									0 AS EMERGENCY_TEST_FEE,--急诊检验收入\n" +
			"									IN_HOS_CHECK_FEE,--住院检查收入\n" +
			"									IN_HOS_TEST_FEE --住院检验收入\n" +
			"					FROM RP_HM_HOSPITALIZE %2$s  \n" +
			"				) exam on ORG.ORGAN_CODE = exam.ORGAN_CODE\n" +
			"			GROUP BY rollup(ORG.ORGAN_CODE)\n" ;
    private static final String OUTPATIENT_RECORD_STATISTICS_SQL = "" +
            "select %8$s, " +
            " CASE\n" +
            "    WHEN REG_NUM = 0\n" +
            "    THEN treatment_num*1.2\n" +
            "    ELSE REG_NUM\n" +
            "  END REG_NUM, treatment_num, " +
            " CASE\n" +
            "    WHEN stay_num = 0\n" +
            "    THEN treatment_num*0.006\n" +
            "    ELSE stay_num\n" +
            "  END stay_num, " +
            " CASE\n" +
            "    WHEN cooperative_medical_fee = 0 and insurance_fee=0\n" +
            "    THEN (all_fee-personal_fee)*0.892\n" +
            "    when cooperative_medical_fee = 0 and insurance_fee!=0\n" +
            "    then insurance_fee*0.892\n" +
            "    ELSE cooperative_medical_fee\n" +
            "  END cooperative_medical_fee,\n" +
            "outpatient_num, emergency_num, arg_outp_emergency_fee, period,medicinal_fee_per,\n" +
            " check_fee, test_fee, antibiotic_rate, infusion_rate, all_num, all_fee,\n" +
            " medicinal_fee,personal_fee,  \n" +
            " case when insurance_fee = 0 then all_fee-personal_fee else insurance_fee END insurance_fee from("
            + " select %7$s"
            + " decode(grouping_id(%1$s), %5$s, %4$s) as %4$s,"
            + " nvl(SUM(REG_NUM),0) REG_NUM,"
            + " SUM(treatment_num) treatment_num,"
            + " nvl(SUM(stay_num),0) stay_num,"
            + " nvl(SUM(cooperative_medical_fee),0) cooperative_medical_fee,"
            + " sum(outpatient_num) outpatient_num,"
            + " sum(emergency_num) emergency_num,"
            + " round(sum(nvl(outpatient_fee,0)+nvl(emergency_fee,0))/decode(sum(nvl(outpatient_num,0)+nvl(emergency_num,0)),0,null,sum(nvl(outpatient_num,0)+nvl(emergency_num,0))),2) arg_outp_emergency_fee,"
            + " '2016/11/01-2016/11/29' period,"
            + " round(sum(nvl(outpatient_medicinal_fee,0))/decode(sum(nvl(outpatient_fee,0)+nvl(emergency_fee,0)),0,null,sum(nvl(outpatient_fee,0)+nvl(emergency_fee,0))),2)*100 medicinal_fee_per,"
            + " sum(outpatient_check_fee) check_fee,"
            + " sum(outpatient_test_fee) test_fee,"
            + " round(sum(nvl(antibiotic_op_num,0)    +nvl(antibiotic_eop_num,0))/decode(sum(nvl(prescription_count,0)),0,null,sum(nvl(prescription_count,0))),4)*100 antibiotic_rate,"
            + " round(sum(infusion_num)               /decode(sum(nvl(prescription_count,0)),0,null,sum(nvl(prescription_count,0))),4)*100 infusion_rate,"
            + " sum(nvl(t.outpatient_num,0)           + nvl(t.emergency_num,0)) all_num,"
            + " sum(nvl(t.outpatient_fee,0)           + nvl(t.emergency_fee,0)) all_fee,"
            + " sum(nvl(t.outpatient_medicinal_fee,0) + nvl(t.emergency_medicinal_fee,0)) medicinal_fee,"
            + " sum(nvl(t.outpatient_personal_fee,0)  + nvl(t.emergency_personal_fee,0)) personal_fee,"
            + " sum(nvl(t.outpatient_insurance_fee,0) + nvl(t.emergency_insurance_fee,0)) insurance_fee"
            + " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type,prescription_count,"
            + "  cooperative_medical_fee, treatment_num, REG_NUM,stay_num,"
            + " outpatient_num,emergency_num,outpatient_fee,emergency_fee,outpatient_medicinal_fee,outpatient_check_fee,"
            + " outpatient_test_fee,antibiotic_op_num,antibiotic_eop_num,outpatient_personal_fee,emergency_personal_fee,"
            + " outpatient_insurance_fee,emergency_insurance_fee,emergency_medicinal_fee,infusion_num "
            + " from v_mdm_organization@DL_MS org"
            + " left join (select organ_code,prescription_count,outpatient_num,emergency_num,outpatient_fee,emergency_fee,outpatient_medicinal_fee,outpatient_check_fee,"
            + "  cooperative_medical_fee, treatment_num, REG_NUM,stay_num,"
            + " outpatient_test_fee,antibiotic_op_num,antibiotic_eop_num,outpatient_personal_fee,emergency_personal_fee,"
            + " outpatient_insurance_fee,emergency_insurance_fee,emergency_medicinal_fee,infusion_num "
            + " from RP_HM_OUTPATIENT %2$s) o on o.organ_code =org.organ_code where 1=1 %3$s) t"
            + " group by rollup(%1$s) %6$s order by %1$s"
            + " )";
	
	@Override
	public PageList<HmOutpatient> statisticsOutpatient(Criteria criteria,
			Page page) {
		StringBuilder sql = new StringBuilder();
		String dateRange = this.getDateRange(criteria, "CREATE_DATE");
		sql.append("select  t.organ_code, sum(OUTPATIENT_NUM) OUTPATIENT_NUM,sum(EMERGENCY_NUM) EMERGENCY_NUM,round(sum(OUTPATIENT_FEE+EMERGENCY_FEE)/sum(OUTPATIENT_NUM+EMERGENCY_NUM),2) ARG_OUTP_EMERGENCY_FEE,'");
		sql.append(dateRange+ "' PERIOD, sum(OUTPATIENT_FEE+EMERGENCY_FEE) all_fee,round(sum(OUTPATIENT_MEDICINAL_FEE)/sum(OUTPATIENT_FEE+EMERGENCY_FEE),2)*100 medicinal_fee_per,sum(OUTPATIENT_MEDICAL_FEE) medical_fee,sum(OUTPATIENT_CHECK_FEE) check_fee,sum(OUTPATIENT_TEST_FEE) test_fee,round(sum(ANTIBIOTIC_OP_NUM+ANTIBIOTIC_2_NUM)/sum(OUTPATIENT_NUM+EMERGENCY_NUM),2) antibioticRate,round(sum(INFUSION_NUM)/sum(OUTPATIENT_NUM+EMERGENCY_NUM),2) infusionRate  from RP_HM_OUTPATIENT t ");
		SqlBuilder.buildWhereStatement(HmOutpatient.class, sql, criteria);
		sql.append(" group by organ_code");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public HmOutpatient statisticsOutpatient(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		String dateRange = this.getDateRange(criteria, "CREATE_DATE");
		sql.append("select sum(OUTPATIENT_NUM) OUTPATIENT_NUM,sum(EMERGENCY_NUM) EMERGENCY_NUM,round(sum(nvl(OUTPATIENT_FEE,0)+nvl(EMERGENCY_FEE,0))/decode(sum(nvl(OUTPATIENT_NUM,0)+nvl(EMERGENCY_NUM,0)),0,null,sum(nvl(OUTPATIENT_NUM,0)+nvl(EMERGENCY_NUM,0))),2) ARG_OUTP_EMERGENCY_FEE,'");
		sql.append(dateRange+ "' PERIOD,round(sum(nvl(OUTPATIENT_MEDICINAL_FEE,0))/decode(sum(nvl(OUTPATIENT_FEE,0)+nvl(EMERGENCY_FEE,0)),0,null,sum(nvl(OUTPATIENT_FEE,0)+nvl(EMERGENCY_FEE,0))),2)*100 medicinal_fee_per," +
				"sum(OUTPATIENT_CHECK_FEE) check_fee,sum(OUTPATIENT_TEST_FEE) test_fee,round(sum(nvl(ANTIBIOTIC_OP_NUM,0)+nvl(ANTIBIOTIC_2_NUM,0))/decode(sum(nvl(OUTPATIENT_NUM,0)+nvl(EMERGENCY_NUM,0)),0,null,sum(nvl(OUTPATIENT_NUM,0)+nvl(EMERGENCY_NUM,0))),2)*100 antibioticRate," +
				"round(sum(INFUSION_NUM)/decode(sum(nvl(OUTPATIENT_NUM,0)+nvl(EMERGENCY_NUM,0)),0,null,sum(nvl(OUTPATIENT_NUM,0)+nvl(EMERGENCY_NUM,0))),2)*100 infusionRate,");
		sql.append(" sum(nvl(t.outpatient_num,0) + nvl(t.emergency_num,0)) allNum, sum(nvl(t.outpatient_fee,0) + nvl(t.emergency_fee,0)) allFee, ");
		sql.append(" sum(nvl(t.outpatient_medicinal_fee,0) + nvl(t.emergency_medicinal_fee,0)) medicinalFee, sum(nvl(t.outpatient_personal_fee,0) + nvl(t.emergency_personal_fee,0)) personalFee,");
		sql.append(" sum(nvl(t.outpatient_insurance_fee,0) + nvl(t.emergency_insurance_fee,0)) insuranceFee  from RP_HM_OUTPATIENT t");
		SqlBuilder.buildWhereStatement(HmOutpatient.class, sql, criteria);
		return this.get(sql.toString(), criteria);
	}

	@Override
	public List<Map<String, Object>> getCheckExamList(Map<String, String> paramMap) {
		String sql = getSql(paramMap,CHECK_EXAM_FEE_SQL);
		return this.getMapList(sql,new Criteria());
	}

	@Override
	public List<Map<String, Object>> getDrugUseList(Map<String, String> paramMap) {
		String sql = getSql(paramMap,DRUG_USE_FEE_SQL);
		return this.getMapList(sql,new Criteria());
	}

	protected String getSql(Map<String, String> paramMap,String sqlDefine){
		String orgWhereSql = getOrgWhereSql(paramMap);
		String businessSql = getBusinessWhereSql(paramMap);
		return String.format(sqlDefine,orgWhereSql,businessSql);
	}

	/**
	 * 获得日期条件
	 */
	private String getBusinessWhereSql(Map<String,String> paramMap){
		StringBuilder result = new StringBuilder("WHERE 1 = 1");
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		if(StringUtil.isNotEmpty(beginDate)){
			result.append(" AND CREATE_DATE >= TO_DATE('" +beginDate + " 00:00:00', 'YYYY/MM/DD HH24:MI:SS')\n");
		}
		if(StringUtil.isNotEmpty(beginDate)){
			result.append(" AND CREATE_DATE <= TO_DATE('" +endDate + " 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n");
		}
		return result.toString();
	}


	/**
	 * 获得机构条件
	 * @param paramMap
	 * @return
	 */
	private String getOrgWhereSql(Map<String, String> paramMap){
		StringBuilder result = new StringBuilder(" WHERE 1=1 ");

		String genreCode = paramMap.get("genreCode");
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
		String organCode = paramMap.get("organCode");//站
		String gbCode = paramMap.get("gbCode");
		if(StringUtil.isNotEmpty(genreCode)){
			result.append(" AND GENRE_CODE = '" + genreCode + "'\n");
		}
		if(StringUtil.isNotEmpty(gbCode)){
			result.append(" AND GB_CODE = '"+gbCode+"' ");
		}
		if(("A100".equals(genreCode) ||"B100".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
			result.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
		}
		if("B200".equals(genreCode) ){
			if(StringUtil.isNotEmpty(superOrganCode)){
				result.append(" AND PARENT_CODE = '"+superOrganCode+"'");
			}
			if(StringUtil.isNotEmpty(organCode)){
				result.append(" AND ORGAN_CODE = '"+organCode+"'");
			}
		}
		return result.toString();
	}

	
	private String getDateRange(Criteria criteria, String col) {
		String dateRageStr = "";
		// Object<?> para = criteria.get(col);
		List<Criterion> list = criteria.getCriteria();
		Criterion criterion = null;
		for (Criterion crt : list) {
			if (col.equals(crt.getName()))
				criterion = crt;
		}
		if (criterion != null) {
			OP operation = criterion.getOperation();
			Date par;
			switch (operation) {
			case BETWEEN:
				Object[] para = (Object[]) criteria.get(col);
				dateRageStr = DateUtil.toDateString((Date) para[0], "yyyy/MM/dd")
						+ "-" + DateUtil.toDateString((Date) para[1], "yyyy/MM/dd");
				break;
			case GE:
				par = (Date) criteria.get(col);
				dateRageStr = DateUtil.toDateString(par, "yyyy/MM/dd") + "-";
				break;
			case LE:
				par = (Date) criteria.get(col);
				dateRageStr = "-" + DateUtil.toDateString(par, "yyyy/MM/dd");
				break;
			}

		}
		return dateRageStr;
	}
	
	public Boolean deleteOutpatientData(String start,String end){
		String sql = "delete RP_HM_OUTPATIENT t where t.create_date >= to_date('"
				+ start + "','yyyy/MM/dd') and t.create_date <= to_date('"
				+ end + "','yyyy/MM/dd')";
		int rs = this.delete(sql);
		return rs > 0 ? true : false;
	}

    public List<Map<String, Object>> getHmOutpatientMapList(Map<String, String> paramMap) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
        if (ObjectUtil.isNullOrEmpty(paramMap)) {
            return mapList;
        }
        String sql = "";
        Criteria criteria = HmQueryConditionHelper.organizeCriteria(paramMap);
        StringBuilder organizationCondition = HmQueryConditionHelper.getOrganizationCondition(paramMap);
        StringBuilder rpOutpatientBuilder = new StringBuilder();
        SqlBuilder.buildWhereStatement(HmOutpatient.class,rpOutpatientBuilder, criteria);
        String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
        String genreCode = paramMap.get("genreCode");
        if(StringUtils.equals("0", genreCode)) {
            sql=String.format(OUTPATIENT_RECORD_STATISTICS_SQL, "gb_code",rpOutpatientBuilder,organizationCondition,"gb_code","1, '合计'","","","gb_code");
        } else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
            sql=String.format(OUTPATIENT_RECORD_STATISTICS_SQL, "gb_code,center_code,organ_code",rpOutpatientBuilder,organizationCondition,
                    "organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,","gb_code,center_code,organ_code");
        } else {
            having = "having grouping_id(gb_code,organ_code)!=1";
            sql=String.format(OUTPATIENT_RECORD_STATISTICS_SQL, "gb_code,organ_code",rpOutpatientBuilder,organizationCondition,"organ_code","1,'小计', 3, '合计'",having,"gb_code,","gb_code,organ_code");
        }

        return getMapList(sql, criteria);
    }


}