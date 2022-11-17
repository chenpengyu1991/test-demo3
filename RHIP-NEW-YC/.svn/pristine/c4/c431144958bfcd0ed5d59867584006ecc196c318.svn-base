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
import com.founder.rhip.ehr.entity.report.RpPhysicalExamination;
import com.founder.rhip.mdm.common.OrgGenreCode;

@Repository("rpPhysicalExaminationDao")
public class RpPhysicalExaminationDaoImpl extends
		AbstractDao<RpPhysicalExamination, Long> implements IRpPhysicalExaminationDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String PHYSICAL_EXAMINATION_PA_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(commercial_examine_num, 0))commercial_examine_num,sum(NVL(old_examine_num, 0))old_examine_num,"
			+ " sum(NVL(student_examine_num, 0))student_examine_num,sum(NVL(women_examine_num, 0))women_examine_num,"
			+ " sum(NVL(occupation_examine_num, 0))occupation_examine_num,sum(NVL(chronic_disease_examine_num, 0))chronic_disease_examine_num,"
			+ " sum(NVL(health_certificate_examine_num, 0))health_certificate_examine_num,sum(NVL(childcare_worker_examine_num, 0))childcare_worker_examine_num,"
			+ " sum(NVL(other_examine_num, 0))other_examine_num,sum(NVL(total_examine_num, 0))total_examine_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.commercial_examine_num,rp.old_examine_num,rp.student_examine_num,rp.women_examine_num,"
			+ " rp.occupation_examine_num,rp.chronic_disease_examine_num,rp.health_certificate_examine_num,"
			+ " rp.childcare_worker_examine_num,rp.other_examine_num,rp.total_examine_num"
			+ " from rp_physical_examination rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	@Override
	public List<Map<String, Object>> getPhysicalExaminationMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpPhysicalExamination.class,sqlBuilder, criteria);
		StringBuilder orgConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(PHYSICAL_EXAMINATION_PA_STATISTICS_SQL, "gb_code",sqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(PHYSICAL_EXAMINATION_PA_STATISTICS_SQL, "gb_code,center_code,organ_code",sqlBuilder,orgConditionBuilder,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(PHYSICAL_EXAMINATION_PA_STATISTICS_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		return getMapList(sql, criteria);
	}
}
