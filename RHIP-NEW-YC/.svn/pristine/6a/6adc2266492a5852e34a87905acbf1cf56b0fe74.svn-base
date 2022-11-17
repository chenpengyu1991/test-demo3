package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("DmPopulaceInfoDao")
public class DmPopulaceInfoDaoImpl extends AbstractDao<DmPopulaceInfo, Long> implements IDmPopulaceInfoDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public DmPopulaceInfo getTotalCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder("SELECT SUM(MAN_NUM) MAN_NUM,SUM(WOMAN_NUM) WOMAN_NUM, SUM(TOTAL_NUM) TOTAL_NUM FROM DM_POPULACE ");
		SqlBuilder.buildWhereStatement(DmPopulaceInfo.class, sql, criteria);
		DmPopulaceInfo dmPopulaceInfo = get(sql.toString(), criteria);
		return dmPopulaceInfo;
	}
}
