package com.founder.rhip.ehr.repository.healtheducation;
import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.healtheducation.HeCopy;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of HeCopy
 * 
 */
@Repository("heCopyDao")
public class HeCopyDaoImpl extends AbstractDao<HeCopy, Integer> implements IHeCopyDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<Map<String, Object>> getQuarterReport1(Map paramMap){
        String startDate = (String)paramMap.get("beginDate");
        String endDate = (String)paramMap.get("endDate");
        StringBuilder sql = new StringBuilder("WITH A AS\n" +
                " (SELECT DECODE(MATERIAL_TYPE, NULL, '总计', MATERIAL_TYPE) AS MATERIAL_TYPE,\n" +
                "         SUM(RESOURCEL_QUANTITY) AS TOTAL_YS," +
                "         COUNT(1) AS NUM_YS\n" +
                "    FROM HE_RESOURCE\n" +
                "   WHERE RESOURCE_TYPE = 3\n" +
                "     AND RESOURCE_RECORD_TIME >= TO_DATE('"+startDate+"', 'YYYY/MM/DD')\n" +
                "     AND RESOURCE_RECORD_TIME <= TO_DATE('"+endDate+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n" +
                "   GROUP BY ROLLUP(MATERIAL_TYPE)),\n" +
                "B AS\n" +
                " (SELECT DECODE(MATERIAL_TYPE, NULL, '总计', MATERIAL_TYPE) AS MATERIAL_TYPE,\n" +
                "         COUNT(1) AS NUM_FF\n" +
                "    FROM HE_AC_RE_LIST\n" +
                "   WHERE MATERIAL_TYPE IS NOT NULL\n" +
                "     AND PUBLISH_ORGAN IS NOT NULL\n" +
                "     AND PUBLISH_DATE >= TO_DATE('"+startDate+"', 'YYYY/MM/DD')\n" +
                "     AND PUBLISH_DATE <= TO_DATE('"+endDate+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n" +
                "   GROUP BY ROLLUP(MATERIAL_TYPE))\n" +
                "SELECT A.MATERIAL_TYPE, A.TOTAL_YS, A.NUM_YS, B.NUM_FF\n" +
                "  FROM A, B\n" +
                " WHERE A.MATERIAL_TYPE = B.MATERIAL_TYPE(+)\n" +
                "  ORDER BY A.MATERIAL_TYPE");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    public List<Map<String, Object>> getQuarterReport2(Map paramMap){
        String startDate = (String)paramMap.get("beginDate");
        String endDate = (String)paramMap.get("endDate");
        StringBuilder sql = new StringBuilder("SELECT PUBLISH_ORGAN,\n" +
                "       SUM(DECODE(TYPE, '1', 1, 0)) AS T1,\n" +
                "       SUM(DECODE(TYPE, '2', 1, 0)) AS T2,\n" +
                "       SUM(DECODE(TYPE, '3', 1, 0)) AS T3,\n" +
                "       SUM(DECODE(TYPE, '4', 1, 0)) AS T4\n" +
                "  FROM HE_COPY\n" +
                " WHERE PUBLISH_DATE >= TO_DATE('"+startDate+"', 'YYYY/MM/DD')\n" +
                "   AND PUBLISH_DATE <= TO_DATE('"+endDate+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n" +
                " GROUP BY ROLLUP(PUBLISH_ORGAN)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }
}