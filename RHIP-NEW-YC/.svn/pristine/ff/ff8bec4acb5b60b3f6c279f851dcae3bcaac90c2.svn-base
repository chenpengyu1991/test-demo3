package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RpQueryConditionHelper;
import com.founder.rhip.ehr.entity.report.RpPaVaccination;
import com.founder.rhip.ehr.entity.report.RpVaccination;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("rpVaccinationDao")
public class RpVaccinationDaoImpl extends AbstractDao<RpVaccination, Long>
		implements IRpVaccinationDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String VACCINATION_ORGANIZATION_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(vaccination_num, 0))vaccination_num "
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.vaccination_num"
			+ " from rp_vaccination rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	@Override
	public List<Map<String, Object>> getOrganizationVaccinationMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpPaVaccination.class,sqlBuilder, criteria);
		StringBuilder orgConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(VACCINATION_ORGANIZATION_STATISTICS_SQL, "gb_code",sqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(VACCINATION_ORGANIZATION_STATISTICS_SQL, "gb_code,center_code,organ_code",sqlBuilder,orgConditionBuilder,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(VACCINATION_ORGANIZATION_STATISTICS_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		return getMapList(sql, criteria);
	}

}
