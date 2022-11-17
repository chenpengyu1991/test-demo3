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
import com.founder.rhip.ehr.entity.report.RpPregantWomenHealthcare;
import com.founder.rhip.ehr.entity.report.RpPremaritalExamination;
import com.founder.rhip.mdm.common.OrgGenreCode;

@Repository("rpPremaritalExaminationDao")
public class RpPremaritalExaminationDaoImpl extends
		AbstractDao<RpPremaritalExamination, Long> implements
		IRpPremaritalExaminationDao {

	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String PREMARITAL_EXAMINATION_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(gestational_women_num, 0))gestational_women_num,sum(NVL(screening_women_num, 0))screening_women_num,"
			+ " sum(NVL(male_premarital_num, 0))male_premarital_num,sum(NVL(female_premarital_num, 0))female_premarital_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.gestational_women_num,rp.screening_women_num,"
			+ " rp.male_premarital_num,rp.female_premarital_num"
			+ " from rp_premarital_examination rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	private static final String PREMARITAL_PERFORMANCE_SQL = "select %7$s %4$s,"
			+ " nvl(round(gestational_women_num / nullif(doctor_num, 0), 0), 0)gestational_women_num,"
			+ " nvl(round(screening_women_num / nullif(doctor_num, 0), 0), 0)screening_women_num,"
			+ " nvl(round(male_premarital_num / nullif(doctor_num, 0), 0), 0)male_premarital_num,"
			+ " nvl(round(female_premarital_num / nullif(doctor_num, 0), 0), 0)female_premarital_num,"
			+ " nvl(round(premarital_num / nullif(doctor_num, 0), 0), 0)premarital_num"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(doctor_num, 0))doctor_num,"
			+ " sum(NVL(gestational_women_num, 0))gestational_women_num,sum(NVL(screening_women_num, 0))screening_women_num,"
			+ " sum(NVL(male_premarital_num, 0))male_premarital_num,sum(NVL(female_premarital_num, 0))female_premarital_num,"
			+ " sum(NVL(premarital_num, 0))premarital_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.doctor_num,rp.gestational_women_num,rp.screening_women_num,"
			+ " rp.male_premarital_num,rp.female_premarital_num,rp.premarital_num"
			+ " from rp_premarital_examination rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	@Override
	public List<Map<String, Object>> getPremaritalExaminationMapList(
			Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, PREMARITAL_EXAMINATION_STATISTICS_SQL);
	}

	/**
	 * 男女婚检绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPremaritalPerformanceOrg(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, PREMARITAL_PERFORMANCE_SQL);
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
