package com.founder.rhip.ehr.repository.report;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RpQueryConditionHelper;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.report.RpChildHealthcare;
import com.founder.rhip.ehr.entity.report.RpOutpatient;
import com.founder.rhip.mdm.common.OrgGenreCode;

@Repository("rpOutpatientDao")
public class RpOutpatientDaoImpl extends AbstractDao<RpOutpatient, Long>
		implements IRpOutpatientDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String OUTPATIENT_RECORD_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(register_num, 0))register_num,sum(NVL(treatment_num, 0))treatment_num,"
			+ " sum(NVL(stay_num, 0))stay_num,"
			+ " sum(NVL(medical_fee, 0))medical_fee,decode(sum(NVL(doctor_num,0)),0,0,sum(NVL(treatment_num, 0))/max(NVL(doctor_num,0)))work_load,"
			+ " sum(NVL(cooperative_medical_fee, 0))cooperative_medical_fee,"
			+ " sum(NVL(personal_fee, 0))personal_fee,sum(NVL(fee_total, 0))fee_total"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.register_num,rp.treatment_num,rp.stay_num,rp.doctor_num,rp.medical_fee,"
			+ " rp.cooperative_medical_fee,rp.personal_fee,rp.fee_total"
			+ " from rp_outpatient rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	private static final String OUTPATIENT_RECORD_PERFORMANCE_SQL = "select %7$s %4$s,"
			+ " nvl(round(treatment_num / nullif(doctor_num, 0), 0), 0)treatment_num,"
			+ " nvl(round(prescription_numm / nullif(doctor_num, 0), 0), 0)prescription_numm,"
			+ " nvl(round(fee_total / nullif(doctor_num, 0), 0), 0)fee_total"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(doctor_num, 0))doctor_num,"
			+ " sum(NVL(treatment_num, 0))treatment_num,sum(NVL(prescription_numm, 0))prescription_numm,"
			+ " sum(NVL(fee_total, 0))fee_total"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.doctor_num,rp.treatment_num,"
			+ " rp.prescription_numm,rp.fee_total"
			+ " from rp_outpatient rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	@Override
	public Map<String, Object> getRpOutpatientMap(String orgCode, String dateStr) {
		if (ObjectUtil.isNullOrEmpty(orgCode) || ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("机构代码或者日期不可以为空！");
		}
		StringBuilder sqlBuilder = new StringBuilder("SELECT T.ID ID  FROM RP_OUTPATIENT T WHERE T.ORGAN_CODE='");
		sqlBuilder.append(orgCode).append("' AND TO_CHAR(T.RP_DATE,'yyyy/MM/dd')='").append(dateStr).append("'");
		List<Map<String, Object>> mapList = getMapList(sqlBuilder.toString(), (Criteria) null);
		if (ObjectUtil.isNullOrEmpty(mapList)) {
			return null;
		} else {
			return mapList.get(0);
		}
	}


	@Override
	public List<Map<String, Object>> getRpoutpatientMapList(Map<String, String> paramMap) {
		return getBasicStatistics(paramMap, OUTPATIENT_RECORD_STATISTICS_SQL);
	}
	
	/**
	 * 门急诊服务绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOutpatientPerformanceOrg(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, OUTPATIENT_RECORD_PERFORMANCE_SQL);
	}
	
	/**
	 * 门急诊服务相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<Map<String, Object>> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		String sql = "";
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		StringBuilder organizationCondition = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		StringBuilder rpOutpatientBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(RpOutpatient.class,rpOutpatientBuilder, criteria);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String genreCode = paramMap.get("genreCode");
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(conditionSql, "gb_code",rpOutpatientBuilder,organizationCondition,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(conditionSql, "gb_code,center_code,organ_code",rpOutpatientBuilder,organizationCondition,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(conditionSql, "gb_code,organ_code",rpOutpatientBuilder,organizationCondition,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
	
		return getMapList(sql, criteria);
	}
	
	/**
	 * 综合管理首页住院统计(门急诊)
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> statisticsFeeOutpatient(String dateStr, String dateFormater){
		String sql = "select dd.*,ddd.*,round(nvl(fee_total/nullif(treatment_num,0),0),2) percent "
				+ " from (select nvl(sum(nvl(out.treatment_num,0)),0)treatment_num, nvl(sum(nvl(out.fee_total,0)),0)fee_total,"
				+ " nvl(sum(nvl(out.medical_fee,0)),0) + nvl(sum(nvl(out.cooperative_medical_fee,0)),0) medical_fee,"
				+ " nvl(sum(nvl(out.personal_fee,0)),0)personal_fee"
				+ " from rp_outpatient out where to_char(out.rp_date, '%1$s') = '%2$s')dd,"
				+ " (select nvl(sum(nvl(e.medicine_fee,0)),0) + nvl(sum(nvl(e.chinese_medicine_fee,0)),0) + nvl(sum(nvl(e.western_medicine_fee,0)),0) expenseFee"
				+ " from rp_expense e  where to_char(e.rp_date,'%1$s')='%2$s' and e.rp_type in ('1' ,'2'))ddd";
		
		sql = String.format(sql, dateFormater,dateStr);
		return getMap(sql, new Criteria());
	}
}
