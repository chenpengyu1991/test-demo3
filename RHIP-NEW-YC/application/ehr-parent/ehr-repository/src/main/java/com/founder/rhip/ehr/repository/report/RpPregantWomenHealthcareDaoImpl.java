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
import com.founder.rhip.ehr.entity.report.RpChildHealthcare;
import com.founder.rhip.ehr.entity.report.RpPregantWomenHealthcare;
import com.founder.rhip.mdm.common.OrgGenreCode;

@Repository("rpPregantWomenHealthcareDao")
public class RpPregantWomenHealthcareDaoImpl extends
		AbstractDao<RpPregantWomenHealthcare, Long> implements IRpPregantWomenHealthcareDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String WOMEN_HEALTHCARE_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(maternal_registration_num, 0))maternal_registration_num,sum(NVL(spontaneous_vaginal_num, 0))spontaneous_vaginal_num,"
			+ " sum(NVL(cesarean_num, 0))cesarean_num,sum(NVL(breech_delivery_num, 0))breech_delivery_num,"
			+ " sum(NVL(fetal_head_suction_num, 0))fetal_head_suction_num,sum(NVL(vagina_surgical_delivery_num, 0))vagina_surgical_delivery_num,"
			+ " sum(NVL(perineal_incision_num, 0))perineal_incision_num,sum(NVL(perineal_uncut_num, 0))perineal_uncut_num,"
			+ " sum(NVL(lower_cesarean_num, 0))lower_cesarean_num,sum(NVL(uterine_cesarean_num, 0))uterine_cesarean_num,"
			+ " sum(NVL(extraperitoneal_cesarean_num, 0))extraperitoneal_cesarean_num,sum(NVL(delivery_num, 0))delivery_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.maternal_registration_num,rp.spontaneous_vaginal_num,"
			+ " rp.cesarean_num,rp.breech_delivery_num,"
			+ " rp.fetal_head_suction_num,rp.vagina_surgical_delivery_num,rp.perineal_incision_num,"
			+ " rp.perineal_uncut_num,rp.lower_cesarean_num,rp.uterine_cesarean_num,rp.extraperitoneal_cesarean_num,rp.delivery_num"
			+ " from rp_pregnant_women_healthcare rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	private static final String PREGANT_PERFORMANCE_SQL = "select %7$s %4$s,"
			+ " nvl(round(maternal_registration_num / nullif(doctor_num, 0), 0), 0)maternal_registration_num,"
			+ " nvl(round(prenatal_check_num / nullif(doctor_num, 0), 0), 0)prenatal_check_num,"
			+ " nvl(round(folic_acid_num / nullif(doctor_num, 0), 0), 0)folic_acid_num,"
			+ " nvl(round(delivery_num / nullif(doctor_num, 0), 0), 0)delivery_num,"
			+ " nvl(round(health_examination_num / nullif(doctor_num, 0), 0), 0)health_examination_num,"
			+ " nvl(round(spontaneous_vaginal_num / nullif(doctor_num, 0), 0), 0)spontaneous_vaginal_num,"
			+ " nvl(round(perineal_incision_num / nullif(doctor_num, 0), 0), 0)perineal_incision_num,"
			+ " nvl(round(perineal_uncut_num / nullif(doctor_num, 0), 0), 0)perineal_uncut_num,"
			+ " nvl(round(vagina_surgical_delivery_num / nullif(doctor_num, 0), 0), 0)vagina_surgical_delivery_num,"
			+ " nvl(round(forceps_delivery_num / nullif(doctor_num, 0), 0), 0)forceps_delivery_num,"
			+ " nvl(round(breech_delivery_num / nullif(doctor_num, 0), 0), 0)breech_delivery_num,"
			+ " nvl(round(fetal_head_suction_num / nullif(doctor_num, 0), 0), 0)fetal_head_suction_num,"
			+ " nvl(round(cesarean_num / nullif(doctor_num, 0), 0), 0)cesarean_num,"
			+ " nvl(round(lower_cesarean_num / nullif(doctor_num, 0), 0), 0)lower_cesarean_num,"
			+ " nvl(round(uterine_cesarean_num / nullif(doctor_num, 0), 0), 0)uterine_cesarean_num,"
			+ " nvl(round(extraperitoneal_cesarean_num / nullif(doctor_num, 0), 0), 0)extraperitoneal_cesarean_num,"
			+ " nvl(round(other_delivery_num / nullif(doctor_num, 0), 0), 0)other_delivery_num"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(doctor_num, 0))doctor_num,"
			+ " sum(NVL(maternal_registration_num, 0))maternal_registration_num,sum(NVL(prenatal_check_num, 0))prenatal_check_num,"
			+ " sum(NVL(folic_acid_num, 0))folic_acid_num,sum(NVL(delivery_num, 0))delivery_num,sum(NVL(health_examination_num, 0))health_examination_num,"
			+ " sum(NVL(spontaneous_vaginal_num, 0))spontaneous_vaginal_num,sum(NVL(perineal_incision_num, 0))perineal_incision_num,sum(NVL(perineal_uncut_num, 0))perineal_uncut_num,"
			+ " sum(NVL(vagina_surgical_delivery_num, 0))vagina_surgical_delivery_num,sum(NVL(forceps_delivery_num, 0))forceps_delivery_num,sum(NVL(breech_delivery_num, 0))breech_delivery_num,"
			+ " sum(NVL(fetal_head_suction_num, 0))fetal_head_suction_num,sum(NVL(cesarean_num, 0))cesarean_num,sum(NVL(lower_cesarean_num, 0))lower_cesarean_num,"
			+ " sum(NVL(uterine_cesarean_num, 0))uterine_cesarean_num,sum(NVL(extraperitoneal_cesarean_num, 0))extraperitoneal_cesarean_num,sum(NVL(other_delivery_num, 0))other_delivery_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.doctor_num,rp.maternal_registration_num,rp.prenatal_check_num,rp.folic_acid_num,"
			+ " rp.delivery_num,rp.health_examination_num,rp.spontaneous_vaginal_num,rp.perineal_incision_num,rp.perineal_uncut_num,"
			+ " rp.vagina_surgical_delivery_num,rp.forceps_delivery_num,rp.breech_delivery_num,rp.fetal_head_suction_num,rp.cesarean_num,"
			+ " rp.lower_cesarean_num,rp.uterine_cesarean_num,rp.extraperitoneal_cesarean_num,rp.other_delivery_num"
 			+ " from rp_pregnant_women_healthcare rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	private static final String GESTATIONAL_PERFORMANCE_SQL = "select %7$s %4$s,"
			+ " nvl(round(gestational_women_num / nullif(doctor_num, 0), 0), 0)gestational_women_num"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(doctor_num, 0))doctor_num,"
			+ " sum(NVL(gestational_women_num, 0))gestational_women_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.doctor_num,rp.gestational_women_num"
			+ " from rp_pregnant_women_healthcare rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	@Override
	public List<Map<String, Object>> getPregantWomenHealthcareMapList(
			Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, WOMEN_HEALTHCARE_STATISTICS_SQL);
	}
	
	/**
	 * 育龄妇女保健工作量考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getGestationalPerformanceOrg(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, GESTATIONAL_PERFORMANCE_SQL);
	}
	
	/**
	 * 孕产妇保健工作量考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPregantPerformanceOrg(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, PREGANT_PERFORMANCE_SQL);
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
		SqlBuilder.buildWhereStatement(RpPregantWomenHealthcare.class,rpSqlBuilder, criteria);
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
