package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of VaccinationInfo
 * 
 */
@Repository("vaccinationStatisticsDao")
public class VaccinationStatisticsDaoImpl extends AbstractDao<VaccinationInfo, String> implements IVaccinationStatisticsDao {
    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<Map<String,Object>> getCountByOrgCode(Criteria criteria){
    	StringBuilder sql = new StringBuilder("select count(*) count, IMMU_UNIT_ID orgCode from V_RDMDB_VACCINATION_INFO ");
    	SqlBuilder.buildWhereStatement(VaccinationInfo.class, sql, criteria);
    	sql.append(" GROUP BY IMMU_UNIT_ID ");
    	List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
    	return mapList;
    }

    /**
     * 预防接种总人数
     * @param criteria
     * @return
     */
    public int vaccinationNum(Criteria criteria){
        StringBuilder sql = new StringBuilder("select count(1)  as total \n" +
                "  from (select person_id from V_RDMDB_VACCINATION_INFO group by person_id)\n");
        Map<String, Object> result =  this.getMap(sql.toString(), criteria);
        return ((BigDecimal)result.get("total")).intValue();
    }

    /**
     * 本年接种人数
     * @param criteria
     * @return
     */
    public int vaccinationNumByYear(Criteria criteria){
        String year = (String) criteria.get("year");
        StringBuilder sql = new StringBuilder("select count(1) as currentYearNum\n" +
                "  from (select person_id\n" +
                "          from V_RDMDB_VACCINATION_INFO t\n" +
                "         where to_char(vaccination_date, 'yyyy') = '"+year+"'\n" +
                "         group by person_id)");
        Map<String, Object> result =  this.getMap(sql.toString(), criteria);
        return ((BigDecimal)result.get("currentYearNum")).intValue();
    }

    //乙肝疫苗接种
    @Override
    public List<Map<String, Object>> getVaccinationHBV(String month){
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '乙肝' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                        CASE WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) = 0) THEN 1\n" +
                "                             WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 1 AND \n" +
                "                               MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 6) THEN 2\n" +
                "                             WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 6) THEN 3 \n" +
                 "                          ELSE 0\n" +
                "                        END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE (VACCINE_NAME LIKE '%乙肝%' OR VACCINE_NAME LIKE '%乙型肝炎%')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE ((MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 1 AND\n" +
                "               MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 7))\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }


    //脊灰疫苗接种
    @Override
    public List<Map<String, Object>> getVaccinationJH(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '脊灰' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 2 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 3) THEN 1\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 3 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 4) THEN 2\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 4 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 36) THEN 3\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 48) THEN 4\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME LIKE '脊髓灰质%' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE ((MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 3 AND\n" +
                "               MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 49))\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    //百白破接
    @Override
    public List<Map<String, Object>> getVaccinationBBP(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '百白破' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 3 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 4) THEN 1\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 4 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 5) THEN 2\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 5 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 18) THEN 3\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 24) THEN 4\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME LIKE '%百白破%' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE ((MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 4 AND\n" +
                "               MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 25))\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    //流脑A接种
    @Override
    public List<Map<String, Object>> getVaccinationLNA(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '流脑A' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 6 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 8) THEN 1\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 8 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) <= 18) THEN 2\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME = 'A群脑膜炎球菌多糖疫苗' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 6 \n" +
                "            AND MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 19)\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }


    //麻风疫苗接种
    @Override
    public List<Map<String, Object>> getVaccinationMF(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '麻风' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 8 THEN 1\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME = '麻疹-风疹联合减毒疫苗' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 8 \n" +
                "            AND MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 9)\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    //乙脑（减毒）接种
    @Override
    public List<Map<String, Object>> getVaccinationYNJD(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '乙脑（减毒）' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 8 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 24) THEN 1\n" +
                "                  WHEN MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 24 THEN 2\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME = '乙型脑炎减毒活疫苗' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 8 \n" +
                "            AND MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 25)\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    //麻腮风疫苗接种
    @Override
    public List<Map<String, Object>> getVaccinationMSF(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '麻腮风' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 18 THEN 1\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME = '麻疹-腮腺炎-风疹联合减毒疫苗' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 18 \n" +
                "            AND MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 25)\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    //甲肝灭活接种
    @Override
    public List<Map<String, Object>> getVaccinationJGMH(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '甲肝灭活' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 18） THEN 1\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME = '甲型肝炎灭活疫苗' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 18 \n" +
                "            OR MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 19)\n" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    //群流脑A+C
    @Override
    public List<Map<String, Object>> getVaccinationQLNAC(String month) {
        StringBuilder sql = new StringBuilder("SELECT T2.GB_CODE, '群流脑A+C' AS VACCINATION, DECODE(T1.QUACOUNT, NULL, 0,T1.QUACOUNT) AS QUACOUNT, " +
                "DECODE(T2.CHILDCOUNT, NULL, 0, T2.CHILDCOUNT) AS CHILDCOUNT \n" +
                "  FROM (SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS QUACOUNT\n" +
                "          FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "                (SELECT PATOWN_SHIP, VACCINATION_CODE,\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 36 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 72) THEN 1\n" +
                "                  WHEN MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 72 THEN 2\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "                   FROM V_RDMDB_VACCINATION_MGMT\n" +
                "                  WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "                    AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "                (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "                   FROM V_RDMDB_VACCINATION_INFO\n" +
                "                  WHERE VACCINE_NAME = 'A+C群脑膜炎球菌多糖疫苗' \n" +
                "                    AND VACCINATION_CODE IS NOT NULL\n" +
                "                    AND VACCINATION_DATE >= TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'), 'MM')\n" +
                "                    AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS'))\n" +
                "                  GROUP BY VACCINATION_CODE)\n" +
                "                 SELECT A.PATOWN_SHIP,\n" +
                "                        DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "                   FROM A, B\n" +
                "                  WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+))\n" +
                "                  WHERE RESULT = 'Y' AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "                  GROUP BY ROLLUP(PATOWN_SHIP)\n" +
                "        ) T1, --接种合格人数\n" +
                "       (WITH TC AS ( \n" +
                "         SELECT DECODE(PATOWN_SHIP, NULL, '总计', PATOWN_SHIP) AS GB_CODE, COUNT(1) AS CHILDCOUNT\n" +
                "          FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "         WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) >= 36 \n" +
"                               AND MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) <= 73)" +
                "            AND PATOWN_SHIP IN (SELECT GB_CODE FROM V_MDM_TOWN)\n" +
                "         GROUP BY ROLLUP(PATOWN_SHIP))\n" +
                "        SELECT TOWN.GB_CODE, TOWN.GB_NAME, TC.CHILDCOUNT\n" +
                "        FROM (SELECT * FROM V_MDM_TOWN UNION ALL\n" +
                "              SELECT '总计' AS GB_CODE, '总计' AS GB_NAME FROM DUAL)TOWN, TC\n" +
                "        WHERE TOWN.GB_CODE = TC.GB_CODE(+) ) T2 --应接种人数\n" +
                " WHERE T2.GB_CODE = T1.GB_CODE(+)\n");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }
    //群流脑A+C接种合格人数
    private Map<String, Object> getQLNACNeed(String month){
        StringBuilder sql = new StringBuilder("SELECT DECODE(PATOWN_SHIP,NULL,'总计',PATOWN_SHIP) , COUNT(1) AS QUACOUNT\n" +
                "  FROM (WITH A AS --接种卡中获取应接种的针次\n" +
                "        (SELECT PATOWN_SHIP,\n" +
                "                VACCINATION_CODE,\n" +
                "                BIRTHDAY,\n" +
                "                REGISTER_DATE,\n" +
                "                MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY),\n" +
                "                CASE\n" +
                "                  WHEN (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 37 AND\n" +
                "                       MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) < 73) THEN 1\n" +
                "                  WHEN MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), BIRTHDAY) >= 73 THEN 2\n" +
                "                  ELSE 0\n" +
                "                END AS NEED\n" +
                "           FROM V_RDMDB_VACCINATION_MGMT\n" +
                "          WHERE BIRTHDAY < TO_DATE('"+month+"', 'YYYY/MM/DD')\n" +
                "            AND VACCINATION_CODE IS NOT NULL), B AS --接种记录中获取实际接种的针次\n" +
                "        (SELECT VACCINATION_CODE, COUNT(1) AS REAL\n" +
                "           FROM V_RDMDB_VACCINATION_INFO\n" +
                "          WHERE (VACCINE_NAME = '甲型肝炎灭活疫苗' )\n" +
                "            AND VACCINATION_CODE IS NOT NULL\n" +
                "            AND VACCINATION_DATE >=TRUNC(TO_DATE('"+month+"', 'YYYY/MM/DD'),'MM') \n" +
                "            AND VACCINATION_DATE <= LAST_DAY(TO_DATE('"+month+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS')) \n" +
                "          GROUP BY VACCINATION_CODE)\n" +
                "         SELECT A.PATOWN_SHIP,\n" +
                "                A.VACCINATION_CODE,\n" +
                "                A.BIRTHDAY,\n" +
                "                A.NEED,\n" +
                "                B.REAL,\n" +
                "                DECODE(SIGN(B.REAL - A.NEED), 1, 'Y', 0, 'Y', 'N') AS RESULT\n" +
                "           FROM A, B\n" +
                "          WHERE B.VACCINATION_CODE = A.VACCINATION_CODE(+)\n" +
                "         )\n" +
                "         WHERE RESULT = 'Y'\n" +
                "         GROUP BY PATOWN_SHIP ");
        Map<String, Object> result = getMap(sql.toString(), new Criteria());
        return result;
    }
    //群流脑A+C应接种人数
    public Map<String, Object> getQLNACPlan(String month){
        StringBuilder sql = new StringBuilder("SELECT COUNT(1) AS CHILDCOUNT \n" +
                "FROM V_WHCH_CH_BIRTH_CERTIFICATE T\n" +
                "WHERE (MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) = 37\n" +
                "AND MONTHS_BETWEEN(TO_DATE('"+month+"', 'YYYY/MM/DD'), NEONATAL_BIRTHDAY) = 73)\n");
        return getMap(sql.toString(), new Criteria());
    }
}