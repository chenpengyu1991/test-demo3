package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * DAO implement of 慢病(绩效)
 */
@Repository("cdmPerformanceDao")
public class CdmPerformanceDaoImpl extends AbstractDao<DmPersonInfo, Long> implements ICdmPerformanceDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     *
     * @param type 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param paramMap
     * @param page
     * @return
     */
    @Override
    public PageList<Map<String, Object>> getCdmPerformance(String type, Map<String, String> paramMap, Page page) {
        String genreCode = paramMap.get("genreCode");
        String organCode = paramMap.get("organCode");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        StringBuilder sql = new StringBuilder();
        if("1".equals(type)){//高血压
             sql = new StringBuilder("WITH MGNT AS\n" +
                    " (SELECT CREATE_DOCTOR_CODE, COUNT(1) AS mgntCount\n" +
                    "    FROM (SELECT " +
                    "                 D.CREATE_DOCTOR_CODE,\n" +
                    "                 D.CREATE_ORGAN_NAME,\n" +
                    "                 D.CREATE_ORGAN_CODE\n" +
                    "            FROM DM_DISEASE_INFO D, DM_PERSON_INFO P\n" +
                    "           WHERE P.TYPE = 2\n" +
                    "             AND D.HBP_FLAG = 2\n" +
                    "             AND D.IS_DELETE = 0\n" );
             if("0".equals(genreCode)) {//"0" 按镇查询
                 sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
             }else {
                 sql.append("                AND D.CREATE_ORGAN_CODE = '"+organCode+"'\n");
             }
//                    "                AND D."+orgField+" = '"+organCode+"'\n" +
             sql.append("                AND D.CREATE_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "             AND P.PERSON_ID = D.PERSON_ID)\n" +
                    "   GROUP BY CREATE_DOCTOR_CODE\n" +
                    "   ORDER BY CREATE_DOCTOR_CODE),\n" +
                    "VISIT AS\n" +
                    " (SELECT  H.CREATE_DOCTOR_CODE, COUNT(1) AS visitCount\n" +
                    "    FROM DM_HYPERTENSION_FOLLOWUP H\n" +
                    "   where H.CREATE_DOCTOR_CODE is not null\n");
//                    "     AND "+orgField+" = '"+organCode+"'\n" +
//            if("0".equals(genreCode)) {//"0" 按镇查询
//                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
//            }else {
                sql.append("                AND H.CREATE_ORGAN_CODE = '"+organCode+"'\n");
//            }
            sql.append("     AND VISIT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "   GROUP BY H.CREATE_DOCTOR_CODE\n" +
                    "   ORDER BY H.CREATE_DOCTOR_CODE),\n" +
                    "PERSON AS\n" +
                    " (SELECT MGNT.CREATE_DOCTOR_CODE\n" +
                    "    FROM MGNT\n" +
                    "  UNION\n" +
                    "  SELECT VISIT.CREATE_DOCTOR_CODE\n" +
                    "    FROM VISIT)\n" +
                    "SELECT " +
                    "       PERSON.CREATE_DOCTOR_CODE,\n" +
                    "       MGNT.mgntCount,\n" +
                    "       VISIT.visitCount\n" +
                    "  FROM PERSON\n" +
                    "  LEFT JOIN VISIT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = VISIT.CREATE_DOCTOR_CODE\n" +
                    "  LEFT JOIN MGNT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = MGNT.CREATE_DOCTOR_CODE\n" +
                    "  ORDER BY PERSON.CREATE_DOCTOR_CODE  ");
        }
        if("2".equals(type)){//糖尿病
             sql = new StringBuilder("WITH MGNT AS\n" +
                    " (SELECT  CREATE_DOCTOR_CODE, COUNT(1) AS mgntCount\n" +
                    "    FROM (SELECT \n" +
                    "                 D.CREATE_DOCTOR_CODE,\n" +
                    "                 D.CREATE_ORGAN_NAME,\n" +
                    "                 D.CREATE_ORGAN_CODE\n" +
                    "            FROM DM_DISEASE_INFO D, DM_PERSON_INFO P\n" +
                    "           WHERE P.TYPE = 2\n" +
                    "             AND D.DI_FLAG = 2\n" +
                    "             AND D.IS_DELETE = 0\n");
//                    "                AND D."+orgField+" = '"+organCode+"'\n" +
                    if("0".equals(genreCode)) {//"0" 按镇查询
                        sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
                    }else {
                        sql.append("                AND D.CREATE_ORGAN_CODE = '"+organCode+"'\n");
                    }
                    sql.append("                AND D.CREATE_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "             AND P.PERSON_ID = D.PERSON_ID)\n" +
                    "   GROUP BY CREATE_DOCTOR_CODE\n" +
                    "   ORDER BY CREATE_DOCTOR_CODE),\n" +
                    "VISIT AS\n" +
                    " (SELECT DF.CREATE_DOCTOR_CODE, COUNT(1) AS visitCount\n" +
                    "    FROM DM_DIABETIC_FOLLOWUP DF \n" +
                    "   where   DF.CREATE_DOCTOR_CODE is not null\n");
//                    "     AND "+orgField+" = '"+organCode+"'\n" +
//            if("0".equals(genreCode)) {//"0" 按镇查询
//                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
//            }else {
                sql.append("                AND DF.CREATE_ORGAN_CODE = '"+organCode+"'\n");
//            }
            sql.append("     AND VISIT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                     "   GROUP BY DF.CREATE_DOCTOR_CODE\n" +
                     "   ORDER BY DF.CREATE_DOCTOR_CODE),\n" +
                    "PERSON AS\n" +
                    " (SELECT MGNT.CREATE_DOCTOR_CODE\n" +
                    "    FROM MGNT\n" +
                    "  UNION\n" +
                    "  SELECT VISIT.CREATE_DOCTOR_CODE\n" +
                    "    FROM VISIT)\n" +
                    "SELECT " +
                    "       PERSON.CREATE_DOCTOR_CODE,\n" +
                    "       MGNT.mgntCount,\n" +
                    "       VISIT.visitCount\n" +
                    "  FROM PERSON\n" +
                    "  LEFT JOIN VISIT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = VISIT.CREATE_DOCTOR_CODE\n" +
                    "  LEFT JOIN MGNT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = MGNT.CREATE_DOCTOR_CODE\n" +
                    "  ORDER BY PERSON.CREATE_DOCTOR_CODE  ");
        }
        if("3".equals(type)){//脑卒中
            sql = new StringBuilder("WITH MGNT AS\n" +
                    " (SELECT CREATE_DOCTOR_CODE, COUNT(1) AS mgntCount\n" +
                    "    FROM (SELECT " +
                    "                 D.CREATE_DOCTOR_CODE,\n" +
                    "                 D.CREATE_ORGAN_NAME,\n" +
                    "                 D.CREATE_ORGAN_CODE\n" +
                    "            FROM DM_DISEASE_INFO D, DM_PERSON_INFO P\n" +
                    "           WHERE P.TYPE = 2\n" +
                    "             AND D.STROKE_FLAG = 2\n" +
                    "             AND D.IS_DELETE = 0\n");
//                    "                AND D."+orgField+" = '"+organCode+"'\n" +
            if("0".equals(genreCode)) {//"0" 按镇查询
                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
            }else {
                sql.append("                AND D.CREATE_ORGAN_CODE = '"+organCode+"'\n");
            }
            sql.append("                AND D.CREATE_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "             AND P.PERSON_ID = D.PERSON_ID)\n" +
                    "   GROUP BY CREATE_DOCTOR_CODE \n" +
                    "   ORDER BY CREATE_DOCTOR_CODE ),\n" +
                    "VISIT AS\n" +
                    " (SELECT DF.CREATE_DOCTOR_CODE, COUNT(1) AS visitCount\n" +
                    "    FROM DM_STRTUM_FOLLOWUP DF \n" +
                    "   where   DF.CREATE_DOCTOR_CODE is not null\n");
//                    "     AND "+orgField+" = '"+organCode+"'\n" +
//            if("0".equals(genreCode)) {//"0" 按镇查询
//                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
//            }else {
                sql.append("                AND DF.CREATE_ORGAN_CODE = '"+organCode+"'\n");
//            }
            sql.append("     AND VISIT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD') AND DISEASE_TYPE = 3 \n" +
                    "   GROUP BY DF.CREATE_DOCTOR_CODE\n" +
                    "   ORDER BY DF.CREATE_DOCTOR_CODE),\n" +
                    "PERSON AS\n" +
                    " (SELECT MGNT.CREATE_DOCTOR_CODE\n" +
                    "    FROM MGNT\n" +
                    "  UNION\n" +
                    "  SELECT VISIT.CREATE_DOCTOR_CODE\n" +
                    "    FROM VISIT)\n" +
                    "SELECT \n" +
                    "       PERSON.CREATE_DOCTOR_CODE,\n" +
                    "       MGNT.mgntCount,\n" +
                    "       VISIT.visitCount\n" +
                    "  FROM PERSON\n" +
                    "  LEFT JOIN VISIT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = VISIT.CREATE_DOCTOR_CODE\n" +
                    "  LEFT JOIN MGNT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = MGNT.CREATE_DOCTOR_CODE\n" +
                    "  ORDER BY PERSON.CREATE_DOCTOR_CODE  ");
        }
        if("4".equals(type)){//冠心病
            sql = new StringBuilder("WITH MGNT AS\n" +
                    " (SELECT CREATE_DOCTOR_CODE, COUNT(1) AS mgntCount\n" +
                    "    FROM (SELECT \n" +
                    "                 D.CREATE_DOCTOR_CODE,\n" +
                    "                 D.CREATE_ORGAN_NAME,\n" +
                    "                 D.CREATE_ORGAN_CODE\n" +
                    "            FROM DM_DISEASE_INFO D, DM_PERSON_INFO P\n" +
                    "           WHERE P.TYPE = 2\n" +
                    "             AND D.CORONARY_FLAG = 2\n" +
                    "             AND D.IS_DELETE = 0\n");
//                    "                AND D."+orgField+" = '"+organCode+"'\n" +
            if("0".equals(genreCode)) {//"0" 按镇查询
                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
            }else {
                sql.append("                AND D.CREATE_ORGAN_CODE = '"+organCode+"'\n");
            }
            sql.append("                AND D.CREATE_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "             AND P.PERSON_ID = D.PERSON_ID)\n" +
                    "   GROUP BY CREATE_DOCTOR_CODE\n" +
                    "   ORDER BY CREATE_DOCTOR_CODE),\n" +
                    "VISIT AS\n" +
                    " (SELECT DF.CREATE_DOCTOR_CODE, COUNT(1) AS visitCount\n" +
                    "    FROM DM_STRTUM_FOLLOWUP DF \n" +
                    "   where DF.CREATE_DOCTOR_CODE is not null\n");
//                    "     AND "+orgField+" = '"+organCode+"'\n" +
//            if("0".equals(genreCode)) {//"0" 按镇查询
//                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
//            }else {
                sql.append("                AND DF.CREATE_ORGAN_CODE = '"+organCode+"'\n");
//            }
            sql.append("     AND VISIT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD') AND DISEASE_TYPE = 4 \n" +
                    "   GROUP BY DF.CREATE_DOCTOR_CODE\n" +
                    "   ORDER BY DF.CREATE_DOCTOR_CODE),\n" +
                    "PERSON AS\n" +
                    " (SELECT MGNT.CREATE_DOCTOR_CODE\n" +
                    "    FROM MGNT\n" +
                    "  UNION\n" +
                    "  SELECT VISIT.CREATE_DOCTOR_CODE\n" +
                    "    FROM VISIT)\n" +
                    "SELECT \n" +
                    "       PERSON.CREATE_DOCTOR_CODE,\n" +
                    "       MGNT.mgntCount,\n" +
                    "       VISIT.visitCount\n" +
                    "  FROM PERSON\n" +
                    "  LEFT JOIN VISIT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = VISIT.CREATE_DOCTOR_CODE\n" +
                    "  LEFT JOIN MGNT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = MGNT.CREATE_DOCTOR_CODE\n" +
                    "  ORDER BY PERSON.CREATE_DOCTOR_CODE  ");
        }
        if("5".equals(type)){//肿瘤
            sql = new StringBuilder("WITH MGNT AS\n" +
                    " (SELECT CREATE_DOCTOR_CODE, COUNT(1) AS mgntCount\n" +
                    "    FROM (SELECT " +
                    "                 D.CREATE_DOCTOR_CODE,\n" +
                    "                 D.CREATE_ORGAN_NAME,\n" +
                    "                 D.CREATE_ORGAN_CODE\n" +
                    "            FROM DM_DISEASE_INFO D, DM_PERSON_INFO P\n" +
                    "           WHERE P.TYPE = 2\n" +
                    "             AND D.TUMOR_FLAG = 2\n" +
                    "             AND D.IS_DELETE = 0\n");
//                    "                AND D."+orgField+" = '"+organCode+"'\n" +
            if("0".equals(genreCode)) {//"0" 按镇查询
                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
            }else {
                sql.append("                AND D.CREATE_ORGAN_CODE = '"+organCode+"'\n");
            }
            sql.append("                AND D.CREATE_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "             AND P.PERSON_ID = D.PERSON_ID)\n" +
                    "   GROUP BY CREATE_DOCTOR_CODE \n" +
                    "   ORDER BY CREATE_DOCTOR_CODE ),\n" +
                    "VISIT AS\n" +
                    " (SELECT DF.CREATE_DOCTOR_CODE, COUNT(1) AS visitCount\n" +
                    "    FROM DM_TUMOR_FOLLOWUP DF \n" +
                    "   where  DF.CREATE_DOCTOR_CODE is not null\n");
//                    "     AND "+orgField+" = '"+organCode+"'\n" +
//            if("0".equals(genreCode)) {//"0" 按镇查询
//                sql.append("                AND P.CREATE_GBCODE = '"+organCode+"'\n");
//            }else {
                sql.append("                AND DF.CREATE_ORGAN_CODE = '"+organCode+"'\n");
//            }
            sql.append("     AND VISIT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND TO_DATE('"+endDate+"', 'YYYY/MM/DD')\n" +
                    "   GROUP BY DF.CREATE_DOCTOR_CODE \n" +
                    "   ORDER BY DF.CREATE_DOCTOR_CODE),\n" +
                    "PERSON AS\n" +
                    " (SELECT MGNT.CREATE_DOCTOR_CODE \n" +
                    "    FROM MGNT\n" +
                    "  UNION\n" +
                    "  SELECT VISIT.CREATE_DOCTOR_CODE \n" +
                    "    FROM VISIT)\n" +
                    "SELECT \n" +
                    "       PERSON.CREATE_DOCTOR_CODE,\n" +
                    "       MGNT.mgntCount,\n" +
                    "       VISIT.visitCount\n" +
                    "  FROM PERSON\n" +
                    "  LEFT JOIN VISIT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = VISIT.CREATE_DOCTOR_CODE\n" +
                    "  LEFT JOIN MGNT\n" +
                    "    ON PERSON.CREATE_DOCTOR_CODE = MGNT.CREATE_DOCTOR_CODE\n" +
                    "  ORDER BY PERSON.CREATE_DOCTOR_CODE  ");
        }

        PageList<Map<String, Object>> result = getPageMapList(page, sql.toString(), new Criteria());
        return result;
    }



}