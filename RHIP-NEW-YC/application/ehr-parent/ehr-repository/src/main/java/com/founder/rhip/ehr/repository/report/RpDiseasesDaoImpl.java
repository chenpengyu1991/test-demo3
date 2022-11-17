package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpDiseases;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RpDiseases
 *
 */
@Repository("rpDiseasesDao")
public class RpDiseasesDaoImpl extends AbstractDao<RpDiseases, Long> implements IRpDiseasesDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,PARENT_CODE,*/

	private static final String IDM_DISEASES_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(a_num, 0))a_num,"
			+ " sum(NVL(b_num, 0))b_num"
			+ " from (select org.gb_code,org.PARENT_CODE,org.organ_code,org.GENRE_CODE, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.a_num,rp.b_num"
			+ " from rp_diseases rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";

	/**
	 * 查询诊断记录中统计传染病
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<RpDiseases> getDiseases(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, IDM_DISEASES_SQL);
	}

	/**
	 * 1年内按月统计A、B类型传染病
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap){
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		String organCode = paramMap.get("organCode");
		String gbCode = paramMap.get("gbCode");
		String type = paramMap.get("type");
		StringBuilder sql = new StringBuilder("SELECT PMONTH, SUM("+type+"_NUM) as ABCOUNT\n" +
				"  FROM (SELECT TO_CHAR(rp_date, 'YYYY/MM') AS PMONTH, "+type+"_NUM \n" +
				"          FROM RP_DISEASES\n" +
				"         WHERE rp_date >= TO_DATE('"+beginDate+"', 'YYYY/MM')\n" +
				"           AND rp_date <= TO_DATE('"+endDate+"', 'YYYY/MM')\n");
		if(!organCode.isEmpty()){
			sql.append(" AND ORGAN_CODE='"+organCode+"'\n");
		}
		sql.append("	AND GB_CODE='"+gbCode+"')\n" +
				" GROUP BY PMONTH\n");
		List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
		return result;
	}

	/**
	 * 查询诊断记录中统计传染病-基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<RpDiseases> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = this.getCondition(paramMap);
		String sql = "";
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = this.getCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpDiseases.class, whereSQL1, criteria);

		String having = "having grouping_id(gb_code,PARENT_CODE,organ_code)!=3 and grouping_id(gb_code,PARENT_CODE,organ_code)!=1";
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(conditionSql, "gb_code",whereSQL1,whereSQL2,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(conditionSql, "gb_code,PARENT_CODE,organ_code",whereSQL1,whereSQL2,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,PARENT_CODE,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(conditionSql, "gb_code,organ_code",whereSQL1,whereSQL2,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}

		return this.getList(sql, criteria);
	}

	/**
	 * 依据时期并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private Criteria getCriteria(Map<String, String> paramMap){
		Criteria criteria = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
		String endDateStr = paramMap.get("endDate");
		Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate,endDate);
		return criteria;
	}

	/**
	 * 依据机构并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private StringBuilder getCondition(Map<String, String> paramMap) {
		StringBuilder whereSQL = new StringBuilder();
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
		String organCode = paramMap.get("organCode");//站
		String gbCode = paramMap.get("gbCode");// 镇
		String genreCode = paramMap.get("genreCode");
		//2017/4/10 更改 增加站统计
		if(StringUtils.equals("0", genreCode) ){
			if(ObjectUtil.isNotEmpty(superOrganCode) && ObjectUtil.isNullOrEmpty(organCode)){
				whereSQL.append(" and organ_Code= '" + superOrganCode + "'");
			}
			if(ObjectUtil.isNotEmpty(organCode)){
				whereSQL.append(" and organ_Code= '" + organCode + "'");
			}
		}else if(StringUtils.equals("B100", genreCode)){
			whereSQL.append(" and GENRE_CODE= '" + genreCode + "'");
			if(ObjectUtil.isNotEmpty(superOrganCode) && ObjectUtil.isNullOrEmpty(organCode)){
				whereSQL.append(" and organ_Code= '" + superOrganCode + "'");
			}
			if(ObjectUtil.isNotEmpty(organCode)){
				whereSQL.append(" and organ_Code= '" + organCode + "'");
			}
		}else if(StringUtils.equals("B200", genreCode)){
			whereSQL.append(" and GENRE_CODE= '" + genreCode + "'");
			if(ObjectUtil.isNotEmpty(superOrganCode)){
				whereSQL.append(" and PARENT_CODE= '" + superOrganCode + "'");
			}
			if(ObjectUtil.isNotEmpty(organCode)){
				whereSQL.append(" and organ_Code= '" + organCode + "'");
			}
		}else if(StringUtils.equals("A100", genreCode)){
			whereSQL.append(" and GENRE_CODE= '" + genreCode + "'");
			if(ObjectUtil.isNotEmpty(superOrganCode)){
				whereSQL.append(" and organ_Code= '" + superOrganCode + "'");
			}
		}
		if(ObjectUtil.isNotEmpty(gbCode)){
			whereSQL.append(" and GB_CODE= '" + gbCode + "'");
		}
		return whereSQL;
	}

}