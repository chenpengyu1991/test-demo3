package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.child.ChildHealthCard;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.women.BirthDefectMonitor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of 妇幼保健(绩效)
 */
@Repository("wchPerformanceDao")
public class WchPerformanceDaoImpl extends AbstractDao<IdmReport, Long> implements IWchPerformanceDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageList<Map<String, Object>> getWchPerformance(Map<String, String> paramMap, Page page) {

        String organCode = paramMap.get("organCode");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");

        StringBuilder sql = new StringBuilder(" WITH YCF AS\n" +
                " (SELECT CHECK_NAME, COUNT(1) AS ycfCount \n" +
                "    FROM WH_MOTHERHOOD_PERIOD_FOLLOWUP\n" +
                "   WHERE CHECK_NAME IS NOT NULL \n" +
                "   AND CREATE_ORGAN_CODE = '"+organCode+"' AND CHECK_DATE BETWEEN TO_DATE('"+beginDate+"','YYYY/MM/DD') AND TO_DATE('"+endDate+"','YYYY/MM/DD')\n" +
                "   GROUP BY (CHECK_NAME)),\n" +
                "MC AS\n" +
                " (SELECT FIRST_VISIT_DOCTOR_NAME, COUNT(1) AS mcCount \n" +
                "    FROM WH_PREMARITAL_HEALTH_SERVICE\n" +
                "   WHERE FIRST_VISIT_DOCTOR_NAME IS NOT NULL\n" +
                "   AND CREATE_ORGAN_CODE = '"+organCode+"' AND CHECK_DATE BETWEEN TO_DATE('"+beginDate+"','YYYY/MM/DD') AND TO_DATE('"+endDate+"','YYYY/MM/DD')\n" +
                "   GROUP BY (FIRST_VISIT_DOCTOR_NAME)),\n" +
                "YL AS\n" +
                " (SELECT FIRST_VISIT_DOCTOR_NAME, COUNT(1) AS ylCount \n" +
                "    FROM (SELECT *\n" +
                "            FROM WH_PREMARITAL_HEALTH_SERVICE A\n" +
                "           WHERE TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) - TO_NUMBER(SUBSTR(A.ID_CARD, 7, 4)) BETWEEN 15 AND 49\n" +
                "             AND LENGTH(A.ID_CARD) = 18\n" +
                "             AND SUBSTR(A.ID_CARD, 17, 1) IN (2, 4, 6, 8, 0)            \n" +
                "          UNION ALL\n" +
                "          SELECT *\n" +
                "            FROM WH_PREMARITAL_HEALTH_SERVICE A\n" +
                "           WHERE TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) - TO_NUMBER('19' || SUBSTR(A.ID_CARD, 7, 2)) BETWEEN 15 AND 49\n" +
                "             AND LENGTH(A.ID_CARD) = 15\n" +
                "             AND SUBSTR(A.ID_CARD, 15, 1) IN (2, 4, 6, 8, 0))\n" +
                "   WHERE FIRST_VISIT_DOCTOR_NAME IS NOT NULL\n" +
                "   AND CREATE_ORGAN_CODE = '"+organCode+"' AND CHECK_DATE BETWEEN TO_DATE('"+beginDate+"','YYYY/MM/DD') AND TO_DATE('"+endDate+"','YYYY/MM/DD')\n" +
                "   GROUP BY (FIRST_VISIT_DOCTOR_NAME)),\n" +
                "PERSON AS\n" +
                " (SELECT CHECK_NAME AS PERSON_NAME\n" +
                "    FROM YCF\n" +
                "  UNION\n" +
                "  SELECT FIRST_VISIT_DOCTOR_NAME AS PERSON_NAME\n" +
                "    FROM MC\n" +
                "  UNION \n" +
                "  SELECT FIRST_VISIT_DOCTOR_NAME AS PERSON_NAME\n" +
                "    FROM YL\n" +
                "    )   \n" +
                "SELECT PERSON.PERSON_NAME, YCF.ycfCount, MC.mcCount, YL.ylCount\n" +
                "  FROM PERSON\n" +
                "  LEFT JOIN YCF\n" +
                "    ON PERSON.PERSON_NAME = YCF.CHECK_NAME\n" +
                "  LEFT JOIN MC\n" +
                "    ON PERSON.PERSON_NAME = MC.FIRST_VISIT_DOCTOR_NAME\n" +
                "  LEFT JOIN YL\n" +
                "    ON PERSON.PERSON_NAME = YL.FIRST_VISIT_DOCTOR_NAME\n" +
                "ORDER BY PERSON_NAME    \n");

        PageList<Map<String, Object>> result = getPageMapList(page, sql.toString(), new Criteria());
        return result;
    }

}