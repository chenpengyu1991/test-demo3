package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RpQueryConditionHelper;
import com.founder.rhip.ehr.entity.report.RpChildHealthcare;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("rpChildHealthcareDao")
public class RpChildHealthcareDaoImpl extends
		AbstractDao<RpChildHealthcare, Long> implements IRpChildHealthcareDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String CHILD_HEALTHCARE_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(neonates_visit_num, 0))neonates_visit_num,sum(NVL(pku_screening_num, 0))pku_screening_num,"
			+ " sum(NVL(hypothyroidism_screening_num, 0))hypothyroidism_screening_num,sum(NVL(hearing_screening_num, 0))hearing_screening_num,"
			+ " sum(NVL(weight_check_num, 0))weight_check_num,sum(NVL(median_num, 0))median_num,"
			+ " sum(NVL(hgb_check_num, 0))hgb_check_num,sum(NVL(severe_anemia_num, 0))severe_anemia_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.neonates_visit_num,rp.pku_screening_num,"
			+ " rp.hypothyroidism_screening_num,rp.hearing_screening_num,"
			+ " rp.weight_check_num,rp.median_num,rp.hgb_check_num,rp.severe_anemia_num"
			+ " from rp_child_healthcare rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	private static final String CHILD_HEALTHCARE_PERFORMANCE_SQL = "select %7$s %4$s,"
			+ " nvl(round(neonates_visit_num / nullif(doctor_num, 0), 0), 0)neonates_visit_num,"
			+ " nvl(round(pku_screening_num / nullif(doctor_num, 0), 0), 0)pku_screening_num,"
			+ " nvl(round(hypothyroidism_screening_num / nullif(doctor_num, 0), 0), 0)hypothyroidism_screening_num,"
			+ " nvl(round(hearing_screening_num / nullif(doctor_num, 0), 0), 0)hearing_screening_num,"
			+ " nvl(round(system_management_num / nullif(doctor_num, 0), 0), 0)system_management_num,"
			+ " nvl(round(health_care_coverage_num / nullif(doctor_num, 0), 0), 0)health_care_coverage_num,"
			+ " nvl(round(weight_check_num / nullif(doctor_num, 0), 0), 0)weight_check_num,"
			+ " nvl(round(median_num / nullif(doctor_num, 0), 0), 0)median_num,"
			+ " nvl(round(hgb_check_num / nullif(doctor_num, 0), 0), 0)hgb_check_num,"
			+ " nvl(round(severe_anemia_num / nullif(doctor_num, 0), 0), 0)severe_anemia_num"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(doctor_num, 0))doctor_num,"
			+ " sum(NVL(neonates_visit_num, 0))neonates_visit_num,sum(NVL(pku_screening_num, 0))pku_screening_num,"
			+ " sum(NVL(hypothyroidism_screening_num, 0))hypothyroidism_screening_num,"
			+ " sum(NVL(system_management_num, 0))system_management_num,"
			+ " sum(NVL(hearing_screening_num, 0))hearing_screening_num,sum(NVL(health_care_coverage_num, 0))health_care_coverage_num,"
			+ " sum(NVL(weight_check_num, 0))weight_check_num,sum(NVL(median_num, 0))median_num,"
			+ " sum(NVL(hgb_check_num, 0))hgb_check_num,sum(NVL(severe_anemia_num, 0))severe_anemia_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.doctor_num,rp.neonates_visit_num,rp.pku_screening_num,"
			+ " rp.hypothyroidism_screening_num,rp.hearing_screening_num,rp.system_management_num,rp.health_care_coverage_num,"
			+ " rp.weight_check_num,rp.median_num,rp.hgb_check_num,rp.severe_anemia_num"
			+ " from rp_child_healthcare rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	@Override
	public List<Map<String, Object>> getChildHealthcareMapList(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, CHILD_HEALTHCARE_STATISTICS_SQL);
	}
	
	/**
	 * 儿童保健服务绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getChildHealthcarePerformanceOrg(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, CHILD_HEALTHCARE_PERFORMANCE_SQL);
	}
	
	/**
	 * 儿童保健服务相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<Map<String, Object>> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder rpSqlBuilder = new StringBuilder();
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpChildHealthcare.class,rpSqlBuilder, criteria);
		StringBuilder orgConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(conditionSql, "gb_code",rpSqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(conditionSql, "gb_code,center_code,organ_code",rpSqlBuilder,orgConditionBuilder,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(conditionSql, "gb_code,organ_code",rpSqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		return getMapList(sql, criteria);
	}
}
