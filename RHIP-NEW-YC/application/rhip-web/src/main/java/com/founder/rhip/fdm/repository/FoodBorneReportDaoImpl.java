package com.founder.rhip.fdm.repository;

import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.fdm.entity.FoodBorneReport;

import java.util.List;
import java.util.Map;

/**
 * FoodborneReport
 *
 * @author liuk
 *
 */
@Repository("fdFoodborneReportDao")
public class FoodBorneReportDaoImpl extends AbstractDao<FoodBorneReport, Long> implements IFoodBorneReportDao {
    @SuppressWarnings("unused")
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<Map<String, Object>> getSummary(String begin, String end){
        StringBuilder sql = new StringBuilder("WITH ORG AS\n" +
                " (SELECT *\n" +
                "    FROM (SELECT FILL_ORGAN_CODE, --机构\n" +
                "                 SUM(DECODE(GRADE, 'B5', TOTAL, 0)) AS B5C, --5岁以下人数\n" +
                "                 SUM(DECODE(GRADE, 'B15', TOTAL, 0)) AS B15C, --5-15岁人数\n" +
                "                 SUM(DECODE(GRADE, 'B60', TOTAL, 0)) AS B60C, --15-60岁人数\n" +
                "                 SUM(DECODE(GRADE, 'U60', TOTAL, 0)) AS U60C --60岁以上人数\n" +
                "            FROM (SELECT T.*,\n" +
                "                         CASE\n" +
                "                           WHEN AGE <= 5 THEN\n" +
                "                            'B5'\n" +
                "                           WHEN AGE > 5 AND AGE <= 15 THEN\n" +
                "                            'B15'\n" +
                "                           WHEN AGE > 15 AND AGE <= 60 THEN\n" +
                "                            'B60'\n" +
                "                           WHEN AGE > 60 THEN\n" +
                "                            'U60'\n" +
                "                         END AS GRADE\n" +
                "                    FROM (select FILL_ORGAN_CODE, AGE, COUNT(AGE) AS TOTAL\n" +
                "                            from (SELECT FILL_ORGAN_CODE,\n" +
                "                                         FLOOR(MONTHS_BETWEEN(FILL_DATE,\n" +
                "                                                              BIRTHDAY) / 12) AS AGE\n" +
                "                                    FROM FD_FOODBORNE_REPORT\n" +
                "                                  WHERE FILL_DATE  >= TO_DATE('"+begin+"','yyyy/MM/dd') and FILL_DATE  < TO_DATE('"+end+"','yyyy/MM/dd'))\n" +
                "                           GROUP BY FILL_ORGAN_CODE, AGE) T)\n" +
                "           GROUP BY FILL_ORGAN_CODE) A,\n" +
                "         (SELECT T.*,\n" +
                "                 SALMONELLACOUN + VPACOUN + SHIGELLACOUN + STACOUN + PROMCOUN +\n" +
                "                 PECCOUN + EJPCOUN AS PATYXTOTAL, --细菌阳性合计\n" +
                "                 ROTAVIRUSCOUN + NOROVIRUSCOUN + ASTROVIRUSCOUN +\n" +
                "                 SAPOVIRUSCOUN + ADENOVIRUSCOUN AS VIRTOTAL, --病毒阳性合计\n" +
                "                 SALMONELLACOUN + VPACOUN + SHIGELLACOUN + STACOUN + PROMCOUN +\n" +
                "                 PECCOUN + EJPCOUN + ROTAVIRUSCOUN + NOROVIRUSCOUN +\n" +
                "                 ASTROVIRUSCOUN + SAPOVIRUSCOUN + ADENOVIRUSCOUN AS TOTAL --所有阳性合计\n" +
                "            FROM (SELECT ORGAN_CODE,\n" +
                "                         COUNT(PATHOGENS_TEST) AS PATESTCOUNT, --细菌样本数\n" +
                "                         COUNT(DECODE(SALMONELLA, 1, 1, NULL)) AS SALMONELLACOUN, --沙门氏菌\n" +
                "                         COUNT(DECODE(VPA, 1, 1, NULL)) AS VPACOUN, --副溶血性弧菌\n" +
                "                         COUNT(DECODE(SHIGELLA, 1, 1, NULL)) AS SHIGELLACOUN, --志贺氏菌\n" +
                "                         COUNT(DECODE(STA, 1, 1, NULL)) AS STACOUN, --金黄色葡萄球菌\n" +
                "                         COUNT(DECODE(PROTEUS_MIRABILIS, 1, 1, NULL)) AS PROMCOUN, --变形杆菌\n" +
                "                         COUNT(DECODE(PEC, 1, 1, NULL)) AS PECCOUN, --致病性大肠杆菌\n" +
                "                         COUNT(DECODE(EJP, 1, 1, NULL)) AS EJPCOUN, --小肠结肠炎耶尔森氏菌\n" +
                "                         COUNT(DECODE(VIRUSES_TEXT, 1, 1, NULL)) AS VIRTESTCOUN, --病毒样本数\n" +
                "                         COUNT(DECODE(ROTAVIRUS, 1, 1, NULL)) AS ROTAVIRUSCOUN, --轮状病毒\n" +
                "                         COUNT(DECODE(NOROVIRUS, 1, 1, NULL)) AS NOROVIRUSCOUN, --诺如病毒\n" +
                "                         COUNT(DECODE(ASTROVIRUS, 1, 1, NULL)) AS ASTROVIRUSCOUN, --星状病毒\n" +
                "                         COUNT(DECODE(SAPOVIRUS, 1, 1, NULL)) AS SAPOVIRUSCOUN, --札如病毒\n" +
                "                         COUNT(DECODE(ADENOVIRUS, 1, 1, NULL)) AS ADENOVIRUSCOUN --腺病毒\n" +
                "                    FROM FD_TEST\n" +
                "                   WHERE CHECK_DATE  >= TO_DATE('"+begin+"','yyyy/MM/dd') and CHECK_DATE  < TO_DATE('"+end+"','yyyy/MM/dd')\n" +
                "                   GROUP BY ORGAN_CODE) T) B\n" +
                "   WHERE A.FILL_ORGAN_CODE = B.ORGAN_CODE(+))\n" +
                "SELECT *\n" +
                "  FROM ORG\n" +
                "UNION ALL\n" +
                "SELECT '合计' AS FILL_ORGAN_CODE,\n" +
                "       SUM(B5C),\n" +
                "       SUM(B15C),\n" +
                "       SUM(B60C),\n" +
                "       SUM(U60C),\n" +
                "       '',\n" +
                "       SUM(PATESTCOUNT),\n" +
                "       SUM(SALMONELLACOUN),\n" +
                "       SUM(VPACOUN),\n" +
                "       SUM(SHIGELLACOUN),\n" +
                "       SUM(STACOUN),\n" +
                "       SUM(PROMCOUN),\n" +
                "       SUM(PECCOUN),\n" +
                "       SUM(EJPCOUN),\n" +
                "       SUM(VIRTESTCOUN),\n" +
                "       SUM(ROTAVIRUSCOUN),\n" +
                "       SUM(NOROVIRUSCOUN),\n" +
                "       SUM(ASTROVIRUSCOUN),\n" +
                "       SUM(SAPOVIRUSCOUN),\n" +
                "       SUM(ADENOVIRUSCOUN),\n" +
                "       SUM(PATYXTOTAL),\n" +
                "       SUM(VIRTOTAL),\n" +
                "       SUM(TOTAL)\n" +
                "  FROM ORG\n");

        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }

    public String generatedNumGroupByOrg(String orgIndex, Integer year){
        StringBuilder sql = new StringBuilder("select trim(TO_CHAR(count(1)+1,'000')) as NUM  from FD_FOODBORNE_REPORT where NO1='"+orgIndex+"' and YEAR = "+year);
        Criteria criteria=null;
        Map<String, Object> map =getMap(sql.toString(),criteria);
        return (String) map.get("NUM");
    }
}