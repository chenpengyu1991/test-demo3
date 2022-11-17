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
import com.founder.rhip.ehr.entity.report.RpHealthyPhysicalExam;
import com.founder.rhip.mdm.common.OrgGenreCode;

@Repository("rpHealthyPhysicalExamDao")
public class RpHealthyPhysicalExamDaoImpl extends
		AbstractDao<RpHealthyPhysicalExam, Long> implements
		IRpHealthyPhysicalExamDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String HEALTHY_PHYSICAL_EXAM_PA_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(ecg_num, 0))ecg_num,sum(NVL(bus_num, 0))bus_num,"
			+ " sum(NVL(blood_examination_num, 0))blood_examination_num,sum(NVL(urine_examination_num, 0))urine_examination_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,sum(decode(examination_code,'ECG',examination_num,0))ecg_num,"
			+ " sum(decode(examination_code,'BUS',examination_num,0))bus_num,"
			+ " sum(decode(examination_code,'101',examination_num,0))blood_examination_num,"
			+ " sum(decode(examination_code,'102',examination_num,0))urine_examination_num"
			+ " from rp_healthy_physical_exam rp %2$s group by rp.organ_code,rp.examination_code) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	@Override
	public List<Map<String, Object>> getHealthyPhysicalExamMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpHealthyPhysicalExam.class,sqlBuilder, criteria);
		StringBuilder orgConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(HEALTHY_PHYSICAL_EXAM_PA_STATISTICS_SQL, "gb_code",sqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(HEALTHY_PHYSICAL_EXAM_PA_STATISTICS_SQL, "gb_code,center_code,organ_code",sqlBuilder,orgConditionBuilder,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(HEALTHY_PHYSICAL_EXAM_PA_STATISTICS_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		return getMapList(sql, criteria);
	}

	
}
