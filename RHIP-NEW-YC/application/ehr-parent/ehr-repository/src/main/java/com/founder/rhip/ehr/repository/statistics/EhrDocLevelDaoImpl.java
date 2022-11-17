package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.EhrDocLevel;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * DAO implement of HaStatistics
 * 
 */
@Repository("ehrDocLevelDao")
public class EhrDocLevelDaoImpl extends AbstractDao<EhrDocLevel, Long> implements IEhrDocLevelDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String WORK_STATISTICS_SQL = "with person_info as (\n" +
            "select t.INPUT_ORGAN_CODE, t.inputer_id,count(1) cnt from BI_PERSON_INPUT_INFO t \n" +
            "where t.inputer_id is not null %1$s \n" +
            "group by t.INPUT_ORGAN_CODE, inputer_id),\n" +
            "star_result as (\n" +
            "select update_org_code, update_staff_code, sum(one) one, sum(two) two, sum(three) three\n" +
            "from (\n" +
            "  select update_org_code, update_staff_code,\n" +
            "  case when new_star=1 or (old_star=0 and new_star=2) or (old_star=0 and new_star=3) then 1 else 0 end one,\n" +
            "  case when new_star=2 or (old_star=0 and new_star=3) or (old_star=1 and new_star=3) then 1 else 0 end two,\n" +
            "  case when new_star=3 then 1 else 0 end three\n" +
            "  from ehr_doc_level where 1=1 %2$s )\n" +
            "group by update_org_code, update_staff_code)\n" +
            "select * from (\n" +
            "select nvl(INPUT_ORGAN_CODE, update_org_code) INPUT_ORGAN_CODE, nvl(inputer_id, update_staff_code) inputer_id, nvl(cnt, 0) cnt,\n" +
            "nvl(one, 0) one, nvl(two, 0) two, nvl(three, 0) three\n" +
            "from person_info full join star_result on INPUT_ORGAN_CODE = update_org_code and inputer_id = update_staff_code\n" +
            " where 1=1  %3$s %4$s \n" +
            ")order by INPUT_ORGAN_CODE desc,inputer_id desc";

    private static final String STAR_STATISTICS_SQL = "with person_info as (\n" +
            "select t.INPUT_ORGAN_CODE, t.inputer_id,count(1) cnt from BI_PERSON_INPUT_INFO t \n" +
            "where t.inputer_id is not null %1$s \n" +
            "group by t.INPUT_ORGAN_CODE, inputer_id),\n" +
            "star_result as (\n" +
            "select update_org_code, update_staff_code, sum(one) one, sum(two) two, sum(three) three\n" +
            "from (\n" +
            "  select update_org_code, update_staff_code,\n" +
            " case when max(new_star)=1 then 1 else 0 end one,\n" +
            "  case when max(new_star)=2 then 1 else 0 end two,\n" +
            "  case when max(new_star)=3 then 1 else 0 end three \n" +
            "  from ehr_doc_level where 1=1 %2$s group by update_org_code, update_staff_code,person_id)\n" +
            "group by update_org_code, update_staff_code)\n" +
            "select * from (\n" +
            "select nvl(INPUT_ORGAN_CODE, update_org_code) INPUT_ORGAN_CODE, nvl(inputer_id, update_staff_code) inputer_id, nvl(cnt, 0) cnt,\n" +
            "nvl(one, 0) one, nvl(two, 0) two, nvl(three, 0) three\n" +
            "from person_info full join star_result on INPUT_ORGAN_CODE = update_org_code and inputer_id = update_staff_code\n" +
            " where 1=1  %3$s %4$s \n" +
            ")order by INPUT_ORGAN_CODE desc,inputer_id desc";

    /**
     * 工作量统计 若是医务人员给患者建档直接从0-3星 那么总数为1 一星的为1 二星的为1 三星的为1
     * @param page
     * @param form
     * @return
     */
    @Override
    public PageList<Map<String, Object>> getWorkStatistics(Page page, ReportQueryForm form) {
        String lastSql = this.getLastSql(form, WORK_STATISTICS_SQL);
        PageList<Map<String,Object>> list = this.getPageMapList(page, lastSql, new Criteria());
        return list;
    }

    /**
     * 星级统计 若是医务人员给患者建档直接从0-3星 那么总数为1 一星的为0 二星的为0 三星的为1
     * @param page
     * @param form
     * @return
     */
    @Override
    public PageList<Map<String, Object>> getStarStatistics(Page page, ReportQueryForm form) {
        String lastSql = this.getLastSql(form, STAR_STATISTICS_SQL);
        PageList<Map<String,Object>> list = this.getPageMapList(page, lastSql, new Criteria());
        return list;
    }

    /**
     * 根据条件获取最终sql
     * @param form
     * @param targetSql
     * @return
     */
    private String getLastSql(ReportQueryForm form, String targetSql) {
        String beginStr = form.getBeginDate();
        String endStr = form.getEndDate();
        String orgSql = "";
        String staffSql = "";
        StringBuilder personDateSql = new StringBuilder();;
        StringBuilder starDateSql = new StringBuilder();;
        if(ObjectUtil.isNotEmpty(form.getStationCode())) {//站
            orgSql = " and (INPUT_ORGAN_CODE = '" + form.getStationCode() + "'" +
                    "or UPDATE_ORG_CODE = '" + form.getStationCode() + "')";
        } else if(ObjectUtil.isNotEmpty(form.getCentreCode())) {//卫生院
            orgSql = " and (INPUT_ORGAN_CODE in (select organ_code from mdm_organization " +
                    "where organ_code = '" + form.getCentreCode() + "' or parent_code = '" + form.getCentreCode() + "')" +
                    "or UPDATE_ORG_CODE in (select organ_code from mdm_organization " +
                    "where organ_code = '" + form.getCentreCode() + "' or parent_code = '" + form.getCentreCode() + "'))";
        }
        if(ObjectUtil.isNotEmpty(beginStr)) {
            personDateSql.append(" and to_char(input_date, 'yyyy/mm/dd') >= '"+ beginStr + "'");
            starDateSql.append(" and to_char(create_time, 'yyyy/mm/dd') >= '"+ beginStr + "'");
        }
        if(ObjectUtil.isNotEmpty(endStr)) {
            personDateSql.append(" and to_char(input_date, 'yyyy/mm/dd') <= '"+ endStr + "'");
            starDateSql.append(" and to_char(create_time, 'yyyy/mm/dd') <= '"+ endStr + "'");
        }
        if(ObjectUtil.isNotEmpty(form.getStaffCode())) {
            staffSql = " and (inputer_id = '" + form.getStaffCode() + "'" +
                    "or update_staff_code = '" + form.getStaffCode() + "')";
        }
        String lastSql = String.format(targetSql, personDateSql.toString(), starDateSql.toString(), orgSql, staffSql);
        return lastSql;
    }
}