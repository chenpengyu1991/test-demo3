package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.management.DiabeticFollowup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of DiabeticFollowup
 * 
 */
@Repository("diabeticFollowupDao")
public class DiabeticFollowupDaoImpl extends AbstractDao<DiabeticFollowup, String> implements IDiabeticFollowupDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String CDM_STATISTICS_REPORT_SQL = "WITH ORG_RESULT AS(\n" +
            "select * from (\n" +
            "  SELECT CASE \n" +
            "      WHEN genre_code = 'B100' THEN organ_code\n" +
            "      WHEN genre_code = 'B200' THEN parent_code\n" +
            "      ELSE '-1' END parent_code, organ_code, genre_code,sort\n" +
            "  FROM mdm_organization WHERE genre_code IN ('B100', 'B200') %1$s ORDER BY sort),\n" +
            "    (SELECT TO_CHAR(ADD_MONTHS(TO_DATE( '%3$s' , 'yyyy/MM'), ROWNUM - 1), 'yyyy/MM') as monthlist  \n" +
            "      FROM DUAL  \n" +
            "      CONNECT BY ROWNUM <=  months_between(to_date( '%4$s' , 'yyyy/MM'), to_date( '%3$s' , 'yyyy/MM')) + 1)\n" +
            "    order by sort,monthlist\n" +
            "  ),\n" +
            "  --新发现慢病患者首次登记报告人数\n" +
            "  disease_result as(select create_organ_code, to_char(create_date, 'yyyy/mm')create_date, count(*) manage_count from (\n" +
            "                select person_id, hbp_create_date create_date, hbp_create_organ_code create_organ_code from dm_disease_info where hbp_create_date is not null\n" +
            "                union all \n" +
            "                select person_id, di_create_date create_date, di_create_organ_code create_organ_code from dm_disease_info where di_create_date is not null\n" +
            "                union all  \n" +
            "                select person_id, STROKE_create_date create_date, STROKE_create_organ_code create_organ_code from dm_disease_info where STROKE_create_organ_code is not null\n" +
            "                union all \n" +
            "                select person_id, CORONARY_create_date create_date, CORONARY_create_organ_code create_organ_code from dm_disease_info where CORONARY_create_date is not null\n" +
            "                union all \n" +
            "                select person_id, TUMOR_create_date create_date, TUMOR_create_organ_code create_organ_code from dm_disease_info where TUMOR_create_date is not null\n" +
            "                ) \n" +
            "                where 1=1  %2$s\n" +
            "                group by create_organ_code,to_char(create_date, 'yyyy/mm')),\n" +
            "  --新发现慢病患者首次登记报告人数            \n" +
            "  follow_result as (\n" +
            "            select create_organ_code, to_char(create_date, 'yyyy/mm')create_date, count(*) follow_count from (select person_id, visit_date create_date, create_organ_code from dm_hypertension_followup\n" +
            "            union all \n" +
            "            select person_id, visit_date create_date, create_organ_code from dm_diabetic_followup\n" +
            "            union all  \n" +
            "            select person_id, visit_date create_date , create_organ_code from DM_STRTUM_FOLLOWUP\n" +
            "            union all \n" +
            "            select person_id, visit_date create_date, create_organ_code  from DM_TUMOR_FOLLOWUP\n" +
            "            ) \n" +
            "            where 1=1 %2$s\n" +
            "            group by create_organ_code, to_char(create_date, 'yyyy/mm')\n" +
            "            ),\n" +
            "     --糖尿病人免费空腹血糖测量人次\n" +
            "     fpg_result as (\n" +
            "        select CREATE_ORGAN_CODE, to_char(create_date, 'yyyy/mm') create_date, count(*) di_count from dm_diabetic_followup \n" +
            "        where (GLU_VALUE is not null or FPG is not null)\n" +
            "          %2$s\n" +
            "        group by CREATE_ORGAN_CODE,to_char(create_date, 'yyyy/mm')\n" +
            "        ),\n" +
            "    high_result as(\n" +
            "      ---高血压、糖尿病高危人群生活方式指导人次数\n" +
            "      select CREATE_ORGAN_CODE, create_date, sum(h_count) h_count from (\n" +
            "        select CREATE_ORGAN_CODE,to_char(create_date, 'yyyy/mm') create_date,count(*) h_count from DM_HIGHRISK_PERSON_INFO \n" +
            "        where 1=1 %2$s\n" +
            "        group by CREATE_ORGAN_CODE, to_char(create_date, 'yyyy/mm')\n" +
            "        union all  \n" +
            "        select CREATE_UNIT CREATE_ORGAN_CODE,to_char(create_date, 'yyyy/mm') create_date, count(*) h_count from DM_135MGMT\n" +
            "        where MGMT_FLAG = '1' %2$s\n" +
            "        group by CREATE_UNIT, to_char(create_date, 'yyyy/mm')\n" +
            "      )\n" +
            "      group by CREATE_ORGAN_CODE,create_date\n" +
            "      )\n" +
            "select final_result.*, sort, genre_code, genre_code from (\n" +
            "SELECT DECODE(grouping_id(parent_code, organ_code, monthlist),7,'总合计',parent_code) parent_code, organ_code,\n" +
            "monthlist create_date,\n" +
            "nvl(sum(manage_count), 0) manage_count, nvl(sum(follow_count), 0) follow_count,\n" +
            "nvl(sum(di_count), 0) di_count, nvl(sum(h_count), 0) h_count\n" +
            "FROM ORG_RESULT\n" +
            "LEFT JOIN disease_result ON organ_code = disease_result.create_organ_code and disease_result.create_date = monthlist\n" +
            "LEFT JOIN follow_result ON organ_code = follow_result.create_organ_code and follow_result.create_date = monthlist\n" +
            "LEFT JOIN fpg_result ON organ_code = fpg_result.create_organ_code and fpg_result.create_date = monthlist\n" +
            "LEFT JOIN high_result ON organ_code = high_result.create_organ_code and high_result.create_date = monthlist\n" +
            "GROUP BY rollup(parent_code, organ_code, monthlist)\n" +
            "union\n" +
            "SELECT DECODE(grouping_id(parent_code, organ_code, monthlist),7,'总合计',parent_code) parent_code, organ_code,\n" +
            "monthlist create_date,\n" +
            "nvl(sum(manage_count), 0) manage_count, nvl(sum(follow_count), 0) follow_count,\n" +
            "nvl(sum(di_count), 0) di_count, nvl(sum(h_count), 0) h_count\n" +
            "FROM ORG_RESULT\n" +
            "LEFT JOIN disease_result ON organ_code = disease_result.create_organ_code and disease_result.create_date = monthlist\n" +
            "LEFT JOIN follow_result ON organ_code = follow_result.create_organ_code and follow_result.create_date = monthlist\n" +
            "LEFT JOIN fpg_result ON organ_code = fpg_result.create_organ_code and fpg_result.create_date = monthlist\n" +
            "LEFT JOIN high_result ON organ_code = high_result.create_organ_code and high_result.create_date = monthlist\n" +
            "GROUP BY rollup(parent_code, monthlist, organ_code)\n" +
            ") final_result\n" +
            "left join ORG_RESULT on final_result.organ_code = ORG_RESULT.organ_code and final_result.create_date = monthlist\n" +
            "order by sort, monthlist";

    private static final String CDM_GOVERNMENT_SQL = "WITH" +
            " ORG_RESULT AS(SELECT CASE \n" +
            "      WHEN genre_code = 'B100' THEN organ_code\n" +
            "      WHEN genre_code = 'B200' THEN parent_code\n" +
            "      ELSE '-1' END parent_code, organ_code, genre_code,sort\n" +
            "  FROM mdm_organization WHERE genre_code IN ('A100', 'B100', 'B200','J100') %1$s ORDER BY sort),\n" +
            "  --新发现慢病患者首次登记报告人数\n" +
            "  disease_result as(select create_organ_code, count(*) manage_count from (select person_id, hbp_create_date create_date, hbp_create_organ_code create_organ_code from dm_disease_info where hbp_create_date is not null\n" +
            "                union all \n" +
            "                select person_id, di_create_date create_date, di_create_organ_code create_organ_code from dm_disease_info where di_create_date is not null\n" +
            "                union all  \n" +
            "                select person_id, STROKE_create_date create_date, STROKE_create_organ_code create_organ_code from dm_disease_info where STROKE_create_organ_code is not null\n" +
            "                union all \n" +
            "                select person_id, CORONARY_create_date create_date, CORONARY_create_organ_code create_organ_code from dm_disease_info where CORONARY_create_date is not null\n" +
            "                union all \n" +
            "                select person_id, TUMOR_create_date create_date, TUMOR_create_organ_code create_organ_code from dm_disease_info where TUMOR_create_date is not null\n" +
            "                ) \n" +
            "                where 1=1 %2$s\n" +
            "                group by create_organ_code),\n" +
            "  --新发现慢病患者首次登记报告人数            \n" +
            "  follow_result as (\n" +
            "            select create_organ_code,count(*) follow_count from (select person_id, visit_date create_date, create_organ_code from dm_hypertension_followup\n" +
            "            union all \n" +
            "            select person_id, visit_date create_date, create_organ_code from dm_diabetic_followup\n" +
            "            union all  \n" +
            "            select person_id, visit_date create_date , create_organ_code from DM_STRTUM_FOLLOWUP\n" +
            "            union all \n" +
            "            select person_id, visit_date create_date, create_organ_code  from DM_TUMOR_FOLLOWUP\n" +
            "            ) \n" +
            "            where 1=1 %2$s group by create_organ_code\n" +
            "            ),\n" +
            "     --糖尿病人免费空腹血糖测量人次\n" +
            "     fpg_result as (\n" +
            "        select CREATE_ORGAN_CODE, count(*) di_count from dm_diabetic_followup \n" +
            "        where (GLU_VALUE is not null or FPG is not null)\n" +
            "         %2$s\n" +
            "        group by CREATE_ORGAN_CODE\n" +
            "        ),\n" +
            "    high_result as(\n" +
            "      ---高血压、糖尿病高危人群生活方式指导人次数\n" +
            "      select CREATE_ORGAN_CODE, sum(h_count) h_count from (\n" +
            "        select CREATE_ORGAN_CODE,count(*) h_count from DM_HIGHRISK_PERSON_INFO \n" +
            "        where 1=1 %2$s\n" +
            "        group by CREATE_ORGAN_CODE\n" +
            "        union all  \n" +
            "        select CREATE_UNIT CREATE_ORGAN_CODE, count(*) h_count from DM_135MGMT\n" +
            "        where MGMT_FLAG = '1' %2$s\n" +
            "        group by CREATE_UNIT\n" +
            "      )\n" +
            "      group by CREATE_ORGAN_CODE\n" +
            "      )\n" +
            "select final_result.*, sort, genre_code, genre_code from (\n" +
            "SELECT DECODE(grouping_id(parent_code, organ_code),3,'合计',parent_code) parent_code,organ_code,\n" +
            "nvl(sum(manage_count), 0) manage_count, nvl(sum(follow_count), 0) follow_count,\n" +
            "nvl(sum(di_count), 0) di_count, nvl(sum(h_count), 0) h_count\n" +
            "FROM ORG_RESULT\n" +
            "LEFT JOIN disease_result ON organ_code = disease_result.create_organ_code\n" +
            "LEFT JOIN follow_result ON organ_code = follow_result.create_organ_code\n" +
            "LEFT JOIN fpg_result ON organ_code = fpg_result.create_organ_code\n" +
            "LEFT JOIN high_result ON organ_code = high_result.create_organ_code\n" +
            "GROUP BY rollup(parent_code, organ_code)\n" +
            "order by parent_code, organ_code) final_result\n" +
            "left join ORG_RESULT on final_result.organ_code = ORG_RESULT.organ_code\n" +
            "order by sort";
    /**
     * 慢性病患者健康管理数据
     * 1.新发慢病患者首次登记报告人数 统计对象为管理卡 一个病人同时管理五种慢病算五次
     * 2.慢病患者随访人次数（人次）
     * 3.高血压、糖尿病高危人群生活方式指导人次数
     * 4.糖尿病人免费空腹血糖测量人次
     * @param form
     * @return
     */
    public List<Map<String, Object>> getCdmStatistics(ReportQueryForm form) {
        StringBuilder dateSql = new StringBuilder();
        //卫生院
        String centreCode = form.getCentreCode();
        //站
        String stationCode = form.getStationCode();
        String beginStr = form.getBeginDate();
        String endStr = form.getEndDate();
        String orgSql = "";
        if(ObjectUtil.isNotEmpty(stationCode)) {
            orgSql = " and organ_code = '" + stationCode + "'";
        } else if(ObjectUtil.isNotEmpty(centreCode)) {
            orgSql = " and (organ_code = '" + centreCode + "' or parent_code = '" + centreCode + "')";
        }
        if(ObjectUtil.isNotEmpty(beginStr)) {
            dateSql.append(" and to_char(create_date, 'yyyy/mm') >= '"+ beginStr + "'");
        }
        if(ObjectUtil.isNotEmpty(endStr)) {
            dateSql.append(" and to_char(create_date, 'yyyy/mm') <= '"+ endStr + "'");
        }

        String lastSql = String.format(CDM_GOVERNMENT_SQL, orgSql, dateSql.toString());
        return this.getMapList(lastSql, new Criteria());
    }

    /**
     * 基本公卫工作量-慢性病患者健康管理数据
     * 1.新发慢病患者首次登记报告人数 统计对象为管理卡 一个病人同时管理五种慢病算五次
     * 2.慢病患者随访人次数（人次）
     * 3.高血压、糖尿病高危人群生活方式指导人次数
     * 4.糖尿病人免费空腹血糖测量人次
     * @param form
     * @return
     */
    public List<Map<String, Object>> getCdmStatisticsForBigReport(ReportQueryForm form) {
        StringBuilder dateSql = new StringBuilder();
        //卫生院
        String centreCode = form.getCentreCode();
        //站
        String stationCode = form.getStationCode();
        String beginStr = DateUtil.getDateTime("yyyy/MM", DateUtil.parseSimpleDate(form.getBeginDate(),"yyyy/MM"));
        String endStr = DateUtil.getDateTime("yyyy/MM", DateUtil.parseSimpleDate(form.getEndDate(),"yyyy/MM"));
        String orgSql = "";
        if(ObjectUtil.isNotEmpty(stationCode)) {
            orgSql = " and organ_code = '" + stationCode + "'";
        } else if(ObjectUtil.isNotEmpty(centreCode)) {
            orgSql = " and (organ_code = '" + centreCode + "' or parent_code = '" + centreCode + "')";
        }
        //按时间段查询
        if(ObjectUtil.equals(form.getRangeType(),"4")){
            if (ObjectUtil.isNotEmpty(beginStr)) {
                dateSql.append(" and to_char(create_date, 'yyyy/mm/dd') >= '" + form.getBeginDate() + "'");
            }
            if (ObjectUtil.isNotEmpty(endStr)) {
                dateSql.append(" and to_char(create_date, 'yyyy/mm/dd') <= '" + form.getEndDate() + "'");
            }
        }else {
            if (ObjectUtil.isNotEmpty(beginStr)) {
                dateSql.append(" and to_char(create_date, 'yyyy/mm') >= '" + beginStr + "'");
            }
            if (ObjectUtil.isNotEmpty(endStr)) {
                dateSql.append(" and to_char(create_date, 'yyyy/mm') <= '" + endStr + "'");
            }
        }

        String lastSql = String.format(CDM_STATISTICS_REPORT_SQL, orgSql, dateSql.toString(), beginStr, endStr);
        return this.getMapList(lastSql, new Criteria());
    }
}