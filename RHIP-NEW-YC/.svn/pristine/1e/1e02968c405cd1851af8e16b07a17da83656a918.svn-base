package com.founder.rhip.im.repository.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.im.entity.medical.RdExamAnalys;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RdExamAnalys
 * 
 */
@Repository("rdExamAnalysDao")
public class RdExamAnalysDaoImpl extends AbstractDao<RdExamAnalys, Long> implements IRdExamAnalysDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;

    private String EXAM_ANALYS_SQL = "select HOSPITAL_CODE,\n" +
            "			sum(nvl(AA_NUMBER,0)) aaNumber,\n" +
            "			sum(nvl(AA_POSITIVE_NUMBER,0)) aaPositiveNumber,\n" +
            "      sum(nvl(WBC_NUMBER,0)) wbcNumber,\n" +
            "      sum(nvl(WBC_HIGH_NUMBER,0)) wbcHighNumber,\n" +
            "      sum(nvl(WBC_LOW_NUMBER,0)) wbcLowNumber,\n" +
            "      sum(nvl(RBC_NUMBER,0)) rbcNumber,\n" +
            "      sum(nvl(RBC_HIGH_NUMBER,0)) rbcHighNumber,\n" +
            "      sum(nvl(RBC_LOW_NUMBER,0)) rbcLowNumber,\n" +
            "      sum(nvl(PLT_NUMBER,0)) pltNumber,\n" +
            "      sum(nvl(PLT_HIGH_NUMBER,0)) pltHighNumber,\n" +
            "      sum(nvl(PLT_LOW_NUMBER,0)) pltLowNumber\n" +
            "from (\n" +
            " SELECT HOSPITAL_CODE, \n" +
            "				case when INSPECTION_ITEM_NAME like '乙型肝炎表面抗原%2$s' then count(*) end as AA_NUMBER,--乙型肝炎抗原检查人数\n" +
            "        case when INSPECTION_ITEM_NAME like '乙型肝炎表面抗原%2$s' and INSPECTION_RESULT LIKE '阳性%2$s' then count(*) end as AA_POSITIVE_NUMBER,--乙型肝炎抗原阳性人数\n" +
            "        case when INSPECTION_ITEM_NAME like '白细胞计数%2$s' then count(*) end as WBC_NUMBER,--白细胞计数\n" +
            "        case when INSPECTION_ITEM_NAME like '白细胞计数%2$s' and prompt = '↑' then count(*) end as WBC_HIGH_NUMBER,--白细胞计数UP\n" +
            "        case when INSPECTION_ITEM_NAME like '白细胞计数%2$s' and prompt = '↓' then count(*) end as WBC_LOW_NUMBER,--白细胞计数DOWN\n" +
            "        case when INSPECTION_ITEM_NAME like '红细胞计数%2$s' then count(*) end as RBC_NUMBER,--红细胞计数\n" +
            "        case when INSPECTION_ITEM_NAME like '红细胞计数%2$s' and prompt = '↑' then count(*) end as RBC_HIGH_NUMBER,--红细胞计数UP\n" +
            "        case when INSPECTION_ITEM_NAME like '红细胞计数%2$s' and prompt = '↓' then count(*) end as RBC_LOW_NUMBER,--红细胞计数DOWN\n" +
            "        case when INSPECTION_ITEM_NAME like '血小板计数%2$s' then count(*) end as PLT_NUMBER,--血小板计数\n" +
            "        case when INSPECTION_ITEM_NAME like '血小板计数%2$s' and prompt = '↑' then count(*) end as PLT_HIGH_NUMBER,--血小板计数UP\n" +
            "        case when INSPECTION_ITEM_NAME like '血小板计数%2$s' and prompt = '↓' then count(*) end as PLT_LOW_NUMBER--血小板计数DOWN\n" +
            " FROM ms_examine_detail@DL_MS\n" +
            " %1$s\n" +
            " group by HOSPITAL_CODE, \n" +
            " prompt\n" +
            " ,INSPECTION_ITEM_NAME\n" +
            " ,INSPECTION_RESULT,INSPECTION_ITEM_NAME,INSPECTION_RESULT\n" +
            ")\n" +
            "group by HOSPITAL_CODE";

    //%1$s 机构条件
    //%2$s 业务数据条件
    private String EXAM_STATIC_SQL = "WITH ORG AS(\n" +
            "			SELECT  ORGAN_CODE FROM V_MDM_ORGANIZATION_NOSUB --GB_CODE,ORGAN_CODE\n" +
            "			%1$s\n" +
            "			GROUP BY ORGAN_CODE\n" +
            "		)\n" +
            "		SELECT * FROM(\n" +
            "			SELECT\n" +
            "				ORGAN_CODE,\n" +
            "				SUM(WBC_NUMBER) wbcNumber,SUM(WBC_LOW_NUMBER) wbcLowNumber,SUM(WBC_HIGH_NUMBER) wbcHighNumber,\n" +
            "				SUM(RBC_NUMBER) rbcNumber,SUM(RBC_LOW_NUMBER) rbcLowNumber,SUM(RBC_HIGH_NUMBER) rbcHighNumber,\n" +
            "				SUM(PLT_NUMBER) pltNumber,SUM(PLT_LOW_NUMBER) pltLowNumber,SUM(PLT_HIGH_NUMBER) pltHighNumber,\n" +
            "				SUM(AA_NUMBER) aaNumber,SUM(AA_POSITIVE_NUMBER) aaPositiveNumber,\n" +
            "				ROUND(DECODE(SUM(WBC_NUMBER),0,0,(SUM(WBC_LOW_NUMBER) + SUM(WBC_HIGH_NUMBER))/SUM(WBC_NUMBER)),4) wbcRate,--白细胞检出率\n" +
            "				ROUND(DECODE(SUM(RBC_NUMBER),0,0,(SUM(RBC_LOW_NUMBER) + SUM(RBC_HIGH_NUMBER))/SUM(RBC_NUMBER)),4) rbcRate,--红细胞检出率\n" +
            "				ROUND(DECODE(SUM(PLT_NUMBER),0,0,(SUM(PLT_LOW_NUMBER) + SUM(PLT_HIGH_NUMBER))/SUM(PLT_NUMBER)),4) pltRate--血小板检出率\n" +
            "			FROM(\n" +
            "				SELECT ORG.ORGAN_CODE,\n" +
            "						exam.WBC_NUMBER,exam.WBC_LOW_NUMBER,exam.WBC_HIGH_NUMBER,\n" +
            "						exam.RBC_NUMBER,exam.RBC_LOW_NUMBER,exam.RBC_HIGH_NUMBER,\n" +
            "						exam.PLT_NUMBER,exam.PLT_LOW_NUMBER,exam.PLT_HIGH_NUMBER,\n" +
            "						exam.AA_NUMBER,exam.AA_POSITIVE_NUMBER\n" +
            "				FROM ORG\n" +
            "				LEFT JOIN (\n" +
            "					SELECT  ORGAN_CODE,\n" +
            "						SUM(WBC_NUMBER) WBC_NUMBER,--白细胞检验人次数\n" +
            "						SUM(WBC_LOW_NUMBER) WBC_LOW_NUMBER,--白细胞偏低人次数\n" +
            "						SUM(WBC_HIGH_NUMBER) WBC_HIGH_NUMBER,--白细胞偏高人次数\n" +
            "						SUM(RBC_NUMBER) RBC_NUMBER,--红细胞检验人次数\n" +
            "						SUM(RBC_LOW_NUMBER) RBC_LOW_NUMBER,--红细胞偏低人次数\n" +
            "						SUM(RBC_HIGH_NUMBER) RBC_HIGH_NUMBER,--红细胞偏高人次数\n" +
            "						SUM(PLT_NUMBER) PLT_NUMBER,--血小板检验人次数\n" +
            "						SUM(PLT_LOW_NUMBER) PLT_LOW_NUMBER,--血小板偏低人次数\n" +
            "						SUM(PLT_HIGH_NUMBER) PLT_HIGH_NUMBER,--血小板偏高人次数\n" +
            "						SUM(AA_NUMBER) AA_NUMBER,--乙型肝炎抗原检查人数\n" +
            "						SUM(AA_POSITIVE_NUMBER) AA_POSITIVE_NUMBER--乙型肝炎抗原阳性人数\n" +
            "					FROM RD_EXAM_ANALYS\n" +
            "					%2$s\n" +
            "					GROUP by ORGAN_CODE\n" +
            "					ORDER BY ORGAN_CODE\n" +
            "				) exam on ORG.ORGAN_CODE = exam.ORGAN_CODE\n" +
            "			)\n" +
            "			GROUP BY rollup(ORGAN_CODE)\n" +
            "			ORDER BY ORGAN_CODE\n" +
            "		)\n";

    private String EXAM_SERVICE_SQL = "WITH ORG AS(\n" +
            "			SELECT  ORGAN_CODE FROM MDM_ORGANIZATION --GB_CODE,ORGAN_CODE\n" +
            "			%1$s\n" +
            "			GROUP BY ORGAN_CODE\n" +
            "		)\n" +
            ", STUDY AS ( SELECT HOSPITAL_CODE, inspection_item_name FROM ms_study_event@DL_MS  %3$s ),\n" +
            " %4$s " +
            "		SELECT * FROM(\n" +
            "			SELECT\n" +
            "				ORGAN_CODE,\n" +
            "				SUM(WBC_NUMBER) wbcNumber,SUM(WBC_LOW_NUMBER) wbcLowNumber,SUM(WBC_HIGH_NUMBER) wbcHighNumber,\n" +
            "				SUM(RBC_NUMBER) rbcNumber,SUM(RBC_LOW_NUMBER) rbcLowNumber,SUM(RBC_HIGH_NUMBER) rbcHighNumber,\n" +
            "				SUM(PLT_NUMBER) pltNumber,SUM(PLT_LOW_NUMBER) pltLowNumber,SUM(PLT_HIGH_NUMBER) pltHighNumber,\n" +
            "				SUM(AA_NUMBER) aaNumber,SUM(AA_POSITIVE_NUMBER) aaPositiveNumber,\n" +
            "				ROUND(DECODE(SUM(WBC_NUMBER),0,0,(SUM(WBC_LOW_NUMBER) + SUM(WBC_HIGH_NUMBER))/SUM(WBC_NUMBER)),4) wbcRate,--白细胞检出率\n" +
            "				ROUND(DECODE(SUM(RBC_NUMBER),0,0,(SUM(RBC_LOW_NUMBER) + SUM(RBC_HIGH_NUMBER))/SUM(RBC_NUMBER)),4) rbcRate,--红细胞检出率\n" +
            "				ROUND(DECODE(SUM(PLT_NUMBER),0,0,(SUM(PLT_LOW_NUMBER) + SUM(PLT_HIGH_NUMBER))/SUM(PLT_NUMBER)),4) pltRate,--血小板检出率\n" +
            "				SUM(BUSNUM) BUSNUM, SUM(CXRNUM) CXRNUM, SUM(ECGNUM) ECGNUM, SUM(CTNUM) CTNUM"+
            "			FROM(\n" +
            "				SELECT ORG.ORGAN_CODE,\n" +
            "						exam.WBC_NUMBER,exam.WBC_LOW_NUMBER,exam.WBC_HIGH_NUMBER,\n" +
            "						exam.RBC_NUMBER,exam.RBC_LOW_NUMBER,exam.RBC_HIGH_NUMBER,\n" +
            "						exam.PLT_NUMBER,exam.PLT_LOW_NUMBER,exam.PLT_HIGH_NUMBER,\n" +
            "						exam.AA_NUMBER,exam.AA_POSITIVE_NUMBER,\n" +
            "						BUS.BUSNUM BUSNUM,\n" +
            "						CXR.CXRNUM CXRNUM,       \n" +
            "						ECG.ECGNUM ECGNUM,\n" +
            "						CT.CTNUM CTNUM \n"+
            "				FROM ORG\n" +
            "				LEFT JOIN (\n" +
            "					SELECT  ORGAN_CODE,\n" +
            "						SUM(WBC_NUMBER) WBC_NUMBER,--白细胞检验人次数\n" +
            "						SUM(WBC_LOW_NUMBER) WBC_LOW_NUMBER,--白细胞偏低人次数\n" +
            "						SUM(WBC_HIGH_NUMBER) WBC_HIGH_NUMBER,--白细胞偏高人次数\n" +
            "						SUM(RBC_NUMBER) RBC_NUMBER,--红细胞检验人次数\n" +
            "						SUM(RBC_LOW_NUMBER) RBC_LOW_NUMBER,--红细胞偏低人次数\n" +
            "						SUM(RBC_HIGH_NUMBER) RBC_HIGH_NUMBER,--红细胞偏高人次数\n" +
            "						SUM(PLT_NUMBER) PLT_NUMBER,--血小板检验人次数\n" +
            "						SUM(PLT_LOW_NUMBER) PLT_LOW_NUMBER,--血小板偏低人次数\n" +
            "						SUM(PLT_HIGH_NUMBER) PLT_HIGH_NUMBER,--血小板偏高人次数\n" +
            "						SUM(AA_NUMBER) AA_NUMBER,--乙型肝炎抗原检查人数\n" +
            "						SUM(AA_POSITIVE_NUMBER) AA_POSITIVE_NUMBER--乙型肝炎抗原阳性人数\n" +
            "					FROM RD_EXAM_ANALYS\n" +
            "					%2$s\n" +
            "					GROUP by ORGAN_CODE\n" +
            "					ORDER BY ORGAN_CODE\n" +
            "				) exam on ORG.ORGAN_CODE = exam.ORGAN_CODE\n" +
            "				LEFT JOIN BUS ON ORG.ORGAN_CODE = BUS.HOSPITAL_CODE\n" +
            "			  LEFT JOIN CXR ON ORG.ORGAN_CODE = CXR.HOSPITAL_CODE \n" +
            "				LEFT JOIN ECG ON ORG.ORGAN_CODE = ECG.HOSPITAL_CODE\n" +
            "				LEFT JOIN CT  ON ORG.ORGAN_CODE = CT.HOSPITAL_CODE\n"+
            "			)\n" +
            "			GROUP BY rollup(ORGAN_CODE)\n" +
            "			ORDER BY ORGAN_CODE\n" +
            "		)\n";

    @Override
    public List<Map<String, Object>> getOrganSummary(Date beginDate, Date endDate) {
        StringBuilder whereSql = new StringBuilder("WHERE 1=1 ");
        if(ObjectUtil.isNotEmpty(beginDate)){
            whereSql.append(" AND CHECK_DATE>=TO_DATE('" + DateUtil.toFormatString("yyyy-MM-dd HH:mm:ss",beginDate)+"','yyyy-MM-dd HH24:mi:ss')");
        }
        if(ObjectUtil.isNotEmpty(endDate)){
            whereSql.append(" AND CHECK_DATE<=TO_DATE('" + DateUtil.toFormatString("yyyy-MM-dd HH:mm:ss",endDate)+"','yyyy-MM-dd HH24:mi:ss')");
        }
        //SqlBuilder.buildWhereStatement(ExamineDetail.class, whereSql, ca) ;
        String sql = String.format(EXAM_ANALYS_SQL,whereSql.toString(),"%");
        return this.getMapList(sql,new Criteria());
    }

    @Override
    public List<Map<String, Object>> getExamAnalysList(Map<String, String> paramMap) {
        String sql = getSql(paramMap,EXAM_STATIC_SQL);
        return this.getMapList(sql,new Criteria());
    }

    @Override
    public List<Map<String, Object>> getServiceAnalys(Map<String, String> paramMap) {
        String sql1 = "BUS AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS BUSNUM\n" +
                "    FROM STUDY --B超\n" +
                "   WHERE inspection_item_name like '%B超%'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "CXR AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS CXRNUM\n" +
                "    FROM STUDY --胸透\n" +
                "   WHERE inspection_item_name like '%胸透%'\n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "ECG AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS ECGNUM\n" +
                "    FROM STUDY --心电图\n" +
                "   WHERE inspection_item_name like '%心电图%' \n" +
                "   GROUP BY HOSPITAL_CODE),\n" +
                "CT AS\n" +
                " (SELECT HOSPITAL_CODE, COUNT(1) AS CTNUM\n" +
                "    FROM STUDY --CT\n" +
                "   WHERE inspection_item_name like '%CT%' \n" +
                "   GROUP BY HOSPITAL_CODE)";
        String sql = getServiceSql(paramMap,EXAM_SERVICE_SQL,sql1);
        return this.getMapList(sql,new Criteria());
    }


    /**
     * 获取列表类统计SQL
     * @param paramMap
     * @return
     */
    protected String getSql(Map<String, String> paramMap,String sqlDefine){
        String orgWhereSql = getOrgWhereSql(paramMap);
        String businessSql = getBusinessWhereSql(paramMap);
        return String.format(sqlDefine,orgWhereSql,businessSql);
    }

    protected String getServiceSql(Map<String, String> paramMap,String sqlDefine,String jcSql){
        String orgWhereSql = getOrgWhereSql(paramMap);
        String jcWhereSql = getJcWhereSql(paramMap);
        String businessSql = getBusinessWhereSql(paramMap);
        return String.format(sqlDefine,orgWhereSql,businessSql,jcWhereSql,jcSql);
    }

    private String getJcWhereSql(Map<String,String> paramMap){
        StringBuilder result = new StringBuilder("WHERE 1 = 1");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        if(StringUtil.isNotEmpty(beginDate)){
            result.append(" AND CHECK_DATE >= TO_DATE('" +beginDate + " 00:00:00', 'YYYY/MM/DD HH24:MI:SS')\n");
        }
        if(StringUtil.isNotEmpty(beginDate)){
            result.append(" AND CHECK_DATE <= TO_DATE('" +endDate + " 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n");
        }
        return result.toString();
    }

    private String getBusinessWhereSql(Map<String,String> paramMap){
        StringBuilder result = new StringBuilder("WHERE 1 = 1");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        if(StringUtil.isNotEmpty(beginDate)){
            result.append(" AND YEAR_MONTH >= TO_DATE('" +beginDate + " 00:00:00', 'YYYY/MM/DD HH24:MI:SS')\n");
        }
        if(StringUtil.isNotEmpty(beginDate)){
            result.append(" AND YEAR_MONTH <= TO_DATE('" +endDate + " 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n");
        }
        return result.toString();
    }
    /**
     * 获得机构条件
     * @param paramMap
     * @return
     */
    private String getOrgWhereSql(Map<String, String> paramMap){
        StringBuilder result = new StringBuilder(" WHERE 1=1 ");

        String genreCode = paramMap.get("genreCode");
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");
        if(StringUtil.isNotEmpty(genreCode)){
            result.append(" AND GENRE_CODE = '" + genreCode + "'\n");
        }
        if(StringUtil.isNotEmpty(gbCode)){
            result.append(" AND GB_CODE = '"+gbCode+"' ");
        }
        if(("A100".equals(genreCode) ||"B100".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
            result.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
        }
        if("B200".equals(genreCode) ){
            if(StringUtil.isNotEmpty(superOrganCode)){
                result.append(" AND PARENT_CODE = '"+superOrganCode+"'");
            }
            if(StringUtil.isNotEmpty(organCode)){
                result.append(" AND ORGAN_CODE = '"+organCode+"'");
            }
        }
        return result.toString();
    }

}