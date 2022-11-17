package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.women.PremaritalHealthService;

/**
 * DAO implement of 男妇婚检统计
 * 
 */
@Repository("premaritalCheckStatisticsDao")
public class PremaritalCheckStatisticsDaoImpl extends
		AbstractDao<PremaritalHealthService, Long> implements IPremaritalCheckStatisticsDao {

	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String ORGAN_BASE_SQL = "SELECT "
			+ " COALESCE(ddd.CREATE_ORGAN_CODE, ccc.CREATE_ORGAN_CODE, ggg.CREATE_ORGAN_CODE) AS organ_code, "
			+ " NVL(ddd.count1, 0) AS count1, " 
			+ " NVL(ggg.count3, 0) AS count3, "
			+ " NVL(ccc.count4, 0) AS count4, "
			+ " NVL(ccc.count5, 0) AS count5 "
			+ " FROM "
			+ " (SELECT bbb.CREATE_ORGAN_CODE, "
			+ "    MAX(DECODE(bbb.sex, 0, bbb.num, 0)) AS count4, "
			+ "    MAX(DECODE(bbb.sex, 1, bbb.num, 0)) AS count5 "
			+ "  FROM "
			+ "    (SELECT aaa.CREATE_ORGAN_CODE, "
			+ "      aaa.sex, "
			+ "      COUNT(1) AS num "
			+ "    FROM "
			+ "      (SELECT "
			+ "        CASE "
			+ "          WHEN LENGTH(id_card) = 18 "
			+ "          THEN mod(SUBSTR(id_card,17,1),2) "
			+ "          ELSE mod(SUBSTR(id_card,15,1),2) "
			+ "        END AS sex, "
			+ "        %3$s as CREATE_ORGAN_CODE "
			+ "      FROM V_wh_premarital_health_service %2$s) aaa "
			+ "    GROUP BY aaa.CREATE_ORGAN_CODE, "
			+ "      aaa.sex "
			+ "    ) bbb "
			+ "  GROUP BY bbb.CREATE_ORGAN_CODE) ccc "
			+ "FULL OUTER JOIN "
			+ "  (SELECT fff.CREATE_ORGAN_CODE, " 
			+ "     COUNT(1) AS count1 " 
			+ "   FROM " 
			+ "  (SELECT eee.CREATE_ORGAN_CODE " 
			+ "  FROM " 
			+ "    (SELECT %3$s as CREATE_ORGAN_CODE, " 
			+ "      id_card, " 
			+ "      CASE " 
			+ "        WHEN LENGTH(id_card) = 18 " 
			+ "        THEN mod(SUBSTR(id_card,17,1),2) " 
			+ "        ELSE mod(SUBSTR(id_card,15,1),2) " 
			+ "      END AS sex, " 
			+ "      CASE " 
			+ "        WHEN LENGTH(id_card) = 18 " 
			+ "        THEN to_number(TO_CHAR(FILL_DATE, 'yyyy')) - to_number(SUBSTR(id_card,7,4)) " 
			+ "        ELSE to_number(TO_CHAR(FILL_DATE, 'yyyy')) - to_number('19' " 
			+ "          ||SUBSTR(id_card,7,2)) " 
			+ "      END AS age " 
			+ "    FROM V_wh_premarital_health_service %2$s" 
			+ "    ) eee " 
			+ "  WHERE eee.sex = 0 " 
			+ "  AND eee.age  >= 15 " 
			+ "  AND eee.age  <= 49) fff " 
			+ "GROUP BY fff.CREATE_ORGAN_CODE ) ddd "
			+ "ON ccc.CREATE_ORGAN_CODE = ddd.CREATE_ORGAN_CODE "
			+ "FULL OUTER JOIN " 
			+ "  (SELECT %3$s as CREATE_ORGAN_CODE, "
			+ "    COUNT(1) AS count3 "
			+ "  FROM V_wh_woman_disease_census %1$s "
			+ "  GROUP BY %3$s) ggg " 
			+ "ON ccc.CREATE_ORGAN_CODE = ggg.CREATE_ORGAN_CODE";

	@Override
	public List<Map<String, Object>> getstatisticsList(String genreCode, Criteria criteria, String beginDate, String endDate) {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(PremaritalHealthService.class, sqlBuilder, criteria);
		String lastSql = null;
		
		String temp = sqlBuilder.toString();
		if(StringUtil.isNotEmpty(sqlBuilder))
		{
			sqlBuilder.append(" and ").append(" check_date  BETWEEN TO_DATE('" 
					+ beginDate + "', 'yyyy/MM/dd') AND TO_DATE('" 
					+  endDate + "', 'yyyy/MM/dd')");
		}else
		{
			sqlBuilder.append(" where ").append(" check_date  BETWEEN TO_DATE('" 
					+ beginDate + "', 'yyyy/MM/dd') AND TO_DATE('" 
					+  endDate + "', 'yyyy/MM/dd')");
		}
		
		String organCond = sqlBuilder.toString();
		String idcardCond = " (LENGTH(id_card) = 15 OR LENGTH(id_card) = 18) ";
		
		sqlBuilder.append(" and ").append(idcardCond);
		
		if("0".equalsIgnoreCase(genreCode))
		{
			lastSql = String.format(ORGAN_BASE_SQL, organCond, sqlBuilder.toString(), "PATOWN_SHIP");
		}else
		{
			String str = temp.replace("CREATE_ORGAN_CODE", "ORGAN_CODE");
			lastSql = "select yyy.organ_code as organ_code, NVL(zzz.count1, 0) AS count1, NVL(zzz.count3, 0) AS count3,  NVL(zzz.count4, 0) AS count4, NVL(zzz.count5, 0) AS count5  from "
					+ "(select distinct organ_code from MDM_ORGANIZATION "
					+ str + " order by ORGAN_CODE ) yyy left join ("  
					+ String.format(ORGAN_BASE_SQL, organCond, sqlBuilder.toString(), "CREATE_ORGAN_CODE")
					+ ") zzz on yyy.organ_code = zzz.organ_code ";
		}
		
		return this.getMapList(lastSql, criteria);
	}
}