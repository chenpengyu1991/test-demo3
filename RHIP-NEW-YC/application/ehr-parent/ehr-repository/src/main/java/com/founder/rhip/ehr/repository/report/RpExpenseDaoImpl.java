package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RpQueryConditionHelper;
import com.founder.rhip.ehr.entity.report.RpExpense;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("rpExpenseDao")
public class RpExpenseDaoImpl extends AbstractDao<RpExpense, Long> implements
		IRpExpenseDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String EXPENSE_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(chinese_medicine_fee, 0))chinese_medicine_fee,"
			+ " sum(NVL(medicine_fee, 0))medicine_fee,"
			+ " sum(NVL(western_medicine_fee, 0))western_medicine_fee,"
			+ " sum(NVL(inspecting_fee, 0))inspecting_fee,"
			+ " sum(NVL(inspection_fee, 0))inspection_fee,"
			+ " sum(NVL(laboratory_fee, 0))laboratory_fee,"
			+ " sum(NVL(radiation_fee, 0))radiation_fee,"
			+ " sum(NVL(treatment_fee, 0))treatment_fee,"
			+ " sum(NVL(operation_fee, 0))operation_fee,"
			+ " sum(NVL(blood_fee, 0))blood_fee,"
			+ " sum(NVL(bed_fee, 0))bed_fee,"
			+ " sum(NVL(nursing_fee, 0))nursing_fee,"
			+ " sum(NVL(anesthesia_fee, 0))anesthesia_fee,"
			+ " sum(NVL(other_fee, 0))other_fee,"
			+ " sum(NVL(consumables_fee, 0))consumables_fee,"
			+ " sum(NVL(chinese_medicine_fee, 0))+sum(NVL(medicine_fee, 0))+sum(NVL(western_medicine_fee, 0)) drug_fee,"
			+ " sum(NVL(fee_total, 0))fee_total,"
			+ " decode(sum(NVL(fee_total, 0)),0,0,(sum(NVL(chinese_medicine_fee, 0))+sum(NVL(medicine_fee, 0))+sum(NVL(western_medicine_fee, 0)))/sum(NVL(fee_total, 0)))drug_rate,"
			+ " decode(sum(NVL(fee_total, 0)),0,0,sum(NVL(consumables_fee, 0))/sum(NVL(fee_total, 0)))consumable_rate"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.chinese_medicine_fee,rp.medicine_fee,rp.western_medicine_fee,rp.inspecting_fee,"
			+ " rp.inspection_fee,rp.laboratory_fee,rp.radiation_fee,rp.treatment_fee,rp.operation_fee,rp.blood_fee,rp.bed_fee,rp.nursing_fee,"
			+ " rp.anesthesia_fee,rp.other_fee,rp.consumables_fee,rp.fee_total"
			+ " from rp_expense rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	private static final String BURDEN_STATISTICS_SQL = "select %7$s %4$s,"
			+ " nvl(round(out_medical_fee / nullif(out_person_num, 0), 2), 0)out_medical_fee,"
			+ " nvl(round(out_fee_total / nullif(out_person_num, 0), 2), 0)out_fee_total,"
			+ " nvl(round(inp_medical_fee / nullif(inp_person_num, 0), 2), 0)inp_medical_fee,"
			+ " nvl(round(inp_fee_total / nullif(inp_person_num, 0), 2), 0)inp_fee_total"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(chinese_medicine_fee, 0))+sum(NVL(medicine_fee, 0))+sum(NVL(western_medicine_fee, 0)) out_medical_fee,"
			+ " sum(NVL(fee_total, 0))out_fee_total,sum(NVL(rp_person_num, 0))out_person_num,"
			+ " sum(NVL(inp_chinese_medicine_fee, 0))+sum(NVL(inp_medicine_fee, 0))+sum(NVL(inp_western_medicine_fee, 0)) inp_medical_fee,"
			+ " sum(NVL(inp_fee_total, 0))inp_fee_total,sum(NVL(inp_rp_person_num, 0))inp_person_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*,inp.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.rp_person_num,rp.chinese_medicine_fee,"
			+ " rp.medicine_fee,rp.western_medicine_fee,rp.fee_total"
			+ " from rp_expense rp %2$s and rp_type in ('1','2')) t on t.orgCode =org.organ_code "
			+ " left join (select rp.organ_code orgCode,rp.rp_person_num inp_rp_person_num,rp.chinese_medicine_fee inp_chinese_medicine_fee,"
			+ " rp.medicine_fee inp_medicine_fee,rp.western_medicine_fee inp_western_medicine_fee,rp.fee_total inp_fee_total"
			+ " from rp_expense rp %2$s and rp_type='3') inp on inp.orgCode =org.organ_code "
			+ " where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )result";
	
	@Override
	public List<Map<String, Object>> getRpExpenseMapList(
			Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, EXPENSE_STATISTICS_SQL);
	}
	
	@Override
	public List<Map<String, Object>> getBurdenRpExpenseMapList(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, BURDEN_STATISTICS_SQL);
	}
	/**
	 * 统计住院出院相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<Map<String, Object>> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder rpDrugSqlBuilder = new StringBuilder();
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpExpense.class,rpDrugSqlBuilder, criteria);
		StringBuilder orgConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(conditionSql, "gb_code",rpDrugSqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(conditionSql, "gb_code,center_code,organ_code",rpDrugSqlBuilder,orgConditionBuilder,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(conditionSql, "gb_code,organ_code",rpDrugSqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		return getMapList(sql, criteria);
	}
}
