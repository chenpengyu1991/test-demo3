package com.founder.rhip.ehr.repository.pbusiness.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcFlyCaught;
import com.founder.rhip.ehr.repository.dmbc.IDmbcFlyCaughtDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of DmbcFlyCaught
 * 
 */
@Repository("dmbcFlyCaughtDao")
public class DmbcFlyCaughtDaoImpl extends AbstractDao<DmbcFlyCaught, Long> implements IDmbcFlyCaughtDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<DmbcFlyCaught> searchFlyCaughtList(Page page,
			Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append("select id, monitor_id, environment, place, cage_count, house_fly, musca_sorbens, lucillia_sericata, lucilia_cuprina, lucilia_illustris, chrysomyia_megacephala, phormia_regina, protophormia_terraenovae, aldrichina_grahami, calliphora_vicina, muscina_stabulans, fannia_canicularis, fannia_prisca, boettcherisca_peregrina, other, total, density, remarks, species_code, create_time, create_by, update_time, update_by, is_delete from DMBC_FLY_CAUGHT t ");
		SqlBuilder.buildWhereStatement(DmbcFlyCaught.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql, " RESULT_NUM DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<Map<String, Object>> report(String beginDate, String endDate, String townShip) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String sql = "SELECT C.ENVIRONMENT ENV, SUM(C.CAGE_COUNT) CAGE, SUM(C.TOTAL) TOTAL, ROUND(AVG(C.DENSITY)) DENSITY, WMSYS.WM_CONCAT(DISTINCT C.SPECIES_CODE) SPECIES " +
				"FROM DMBC_FLY_CAUGHT C, DMBC_FLY_MONITOR M " +
				"WHERE C.IS_DELETE = 0 AND M.IS_DELETE = 0 AND C.MONITOR_ID = M.ID ";
		if (StringUtil.isNotEmpty(beginDate)) {
			parameters.addValue("beginDate", beginDate);
			sql += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') >= :beginDate ";
		}
		if (StringUtil.isNotEmpty(endDate)) {
			parameters.addValue("endDate", endDate);
			sql += "AND TO_CHAR(M.MONITOR_DATE, 'YYYY/MM/DD') <= :endDate ";
		}
		if (StringUtil.isNotEmpty(townShip)) {
			parameters.addValue("townShip", townShip);
			sql += "AND M.TOWN_SHIP = :townShip ";
		}
		sql += "GROUP BY C.ENVIRONMENT ORDER BY C.ENVIRONMENT";
		return simpleJdbcTemplate.queryForList(sql, parameters);
	}
}