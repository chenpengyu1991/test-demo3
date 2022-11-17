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
import com.founder.rhip.ehr.entity.report.RpChild;

@Repository("rpChildDao")
public class RpChildDaoImpl extends AbstractDao<RpChild, Long> implements
		IRpChildDao {
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String CHILD_AGE_STATISTICS_SQL =  " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(zero_num, 0))zero_num,sum(NVL(one_num, 0))one_num,"
			+ " sum(NVL(two_num, 0))two_num,sum(NVL(three_num, 0))three_num,"
			+ " sum(NVL(four_num, 0))four_num,sum(NVL(five_num, 0))five_num,sum(NVL(six_num, 0))six_num,sum(NVL(total_num, 0))total_num"
			+ " from rp_child rp %2$s GROUP BY rollup(%1$s) %6$s ORDER BY %1$s";

	@Override
	public List<Map<String, Object>> getChildMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder rpSqlBuilder = new StringBuilder();
		String paCounty = paramMap.get("paCounty");
		Criteria criteria = RpQueryConditionHelper.organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpChild.class,rpSqlBuilder, criteria);
		StringBuilder orgConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
		String sql = "";
		if (ObjectUtil.isNotEmpty(paCounty)) {
			String having = "having grouping_id(pa_county,pa_town_ship)!=1";
			sql=String.format(CHILD_AGE_STATISTICS_SQL, "pa_county,pa_town_ship",rpSqlBuilder,orgConditionBuilder,"pa_town_ship","1,'小计', 3, '合计'",having,"pa_county,");
		} else {
			sql=String.format(CHILD_AGE_STATISTICS_SQL, "pa_county",rpSqlBuilder,orgConditionBuilder,"pa_county","1, '合计'","","");
		}
		
		return getMapList(sql, criteria);
	}

}
