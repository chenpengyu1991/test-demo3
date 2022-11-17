package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ncp.dto.NcpClassifyReport;
import com.founder.rhip.ncp.dto.NcpHealthReport;
import com.founder.rhip.ncp.dto.NcpManageReport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("ncpReportDao")
public class ReportDaoImpl extends AbstractDao<NcpManageReport,String> implements IReportDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<NcpManageReport> getNcpManageReports(Criteria criteria) {
        //统计各个指标总数sql
        String healthcardSql = "HEALTHCARD AS (SELECT %2$s, COUNT(ID) HEALTH_CARD_NUM FROM NCP_PATIENT WHERE IS_DELETE = 0 %1$s GROUP BY %2$s)";
        String monitorSql = "MONITOR AS (SELECT %2$s, COUNT(ID) MONITOR_NUM FROM NCP_MONITOR WHERE TYPE = 1 %1$s GROUP BY %2$s)";
        String followupSql = "FOLLOWUP AS (SELECT %2$s, COUNT(ID) FOLLOWUP_NUM FROM NCP_MONITOR WHERE TYPE = 3 %1$s GROUP BY %2$s)";
        String reviewSql = "REVIEW AS (SELECT %2$s, COUNT(ID) REVIEW_NUM FROM NCP_MONITOR WHERE TYPE = 2 %1$s GROUP BY %2$s)";
        String orgSql = "ORG as (select ORGAN_CODE, GB_CODE, ORGAN_NAME, GENRE_CODE, decode(GENRE_CODE, 'B200', PARENT_CODE, ORGAN_CODE) PARENT_CODE FROM MDM_ORGANIZATION WHERE GENRE_CODE IN ('B100', 'B200') AND STATUS = 1)";

        //获取查询条件
        String serviceBeginDate = (String) criteria.get("serviceBeginDate");
        String serviceEndDate = (String) criteria.get("serviceEndDate");
        String manageDoctor = (String) criteria.get("manageDoctor");
        String gbcode = (String) criteria.get("gbcode");
        String centerOrgCode = (String) criteria.get("centerOrgCode");
        String orgCode = (String) criteria.get("orgCode");
        String selectMethod = (String) criteria.get("selectMethod");

        //根据统计方式确定分组类型和查询sql
        StringBuilder groupBy1 = new StringBuilder();
        StringBuilder groupBy2 = new StringBuilder();
        StringBuilder selectSql = new StringBuilder();
        if ("1".equals(selectMethod)){
            groupBy1.append(" CREATE_DOCTOR_CODE, CREATE_DOCTOR_NAME, MANAGEMENT_ORG ");
            groupBy2.append(" MONITOR_DOCTOR, MONITOR_ORG ");
            selectSql.append("select HC.MANAGEMENT_ORG MANAGE_ORG_CODE, HC.CREATE_DOCTOR_CODE MANAGE_DOCTOR_CODE, HC.CREATE_DOCTOR_NAME MANAGE_DOCTOR_NAME, NVL(HC.HEALTH_CARD_NUM, 0) HEALTH_CARD_NUM, NVL(MO.MONITOR_NUM, 0) MONITOR_NUM, NVL(FU.FOLLOWUP_NUM, 0) FOLLOWUP_NUM, NVL(RE.REVIEW_NUM, 0) REVIEW_NUM\n" +
                    "from HEALTHCARD HC\n" +
                    "         LEFT JOIN MONITOR MO ON HC.MANAGEMENT_ORG = MO.MONITOR_ORG AND HC.CREATE_DOCTOR_CODE = MO.MONITOR_DOCTOR\n" +
                    "         LEFT JOIN FOLLOWUP FU ON HC.MANAGEMENT_ORG = FU.MONITOR_ORG AND HC.CREATE_DOCTOR_CODE = FU.MONITOR_DOCTOR\n" +
                    "         LEFT JOIN REVIEW RE ON HC.MANAGEMENT_ORG = RE.MONITOR_ORG AND HC.CREATE_DOCTOR_CODE = RE.MONITOR_DOCTOR\n" +
                    "         LEFT JOIN ORG ON ORG.ORGAN_CODE = HC.MANAGEMENT_ORG\n" +
                    "WHERE 1 = 1 ");
        }else if ("2".equals(selectMethod)){
            groupBy1.append(" MANAGEMENT_ORG ");
            groupBy2.append(" MONITOR_ORG ");
            selectSql.append("select HC.MANAGEMENT_ORG MANAGE_ORG_CODE, NVL(HC.HEALTH_CARD_NUM, 0) HEALTH_CARD_NUM, NVL(MO.MONITOR_NUM, 0) MONITOR_NUM, NVL(FU.FOLLOWUP_NUM, 0) FOLLOWUP_NUM, NVL(RE.REVIEW_NUM, 0) REVIEW_NUM\n" +
                    "from HEALTHCARD HC\n" +
                    "         LEFT JOIN MONITOR MO ON HC.MANAGEMENT_ORG = MO.MONITOR_ORG \n" +
                    "         LEFT JOIN FOLLOWUP FU ON HC.MANAGEMENT_ORG = FU.MONITOR_ORG \n" +
                    "         LEFT JOIN REVIEW RE ON HC.MANAGEMENT_ORG = RE.MONITOR_ORG \n" +
                    "         LEFT JOIN ORG ON ORG.ORGAN_CODE = HC.MANAGEMENT_ORG\n" +
                    "WHERE 1 = 1 ");
        }

        //添加日期筛选条件
        StringBuilder dateSql1 = new StringBuilder();
        StringBuilder dateSql2 = new StringBuilder();
        if (StringUtil.isNotEmpty(serviceBeginDate)){
            dateSql1.append(" AND TO_CHAR(CREATE_TIME,'yyyy/mm/dd') >= '" + serviceBeginDate + "' ");
            dateSql2.append(" AND TO_CHAR(MONITOR_DATE,'yyyy/mm/dd') >= '" + serviceBeginDate + "' ");
        }
        if (StringUtil.isNotEmpty(serviceEndDate)){
            dateSql1.append(" AND TO_CHAR(CREATE_TIME,'yyyy/mm/dd') <= '" + serviceEndDate + "' ");
            dateSql2.append(" AND TO_CHAR(MONITOR_DATE,'yyyy/mm/dd') <= '" + serviceEndDate + "' ");
        }

        //添加机构筛选条件
        StringBuilder orgaSql = getOrgSql(gbcode, centerOrgCode, orgCode);

        //添加姓名筛选条件
        StringBuilder doctorSql = new StringBuilder();
        if (ObjectUtil.isNotEmpty(manageDoctor)){
            doctorSql.append(" AND HC.CREATE_DOCTOR_NAME LIKE '%" + manageDoctor.trim() + "%'");
        }

        //拼接sql
        StringBuilder lastSql = new StringBuilder("WITH ");
        lastSql.append(String.format(healthcardSql, dateSql1.toString(), groupBy1.toString())).append(", ");
        lastSql.append(String.format(monitorSql, dateSql2.toString(), groupBy2.toString())).append(", ");
        lastSql.append(String.format(followupSql, dateSql2.toString(), groupBy2.toString())).append(", ");
        lastSql.append(String.format(reviewSql, dateSql2.toString(), groupBy2.toString())).append(", ");
        lastSql.append(orgSql);
        lastSql.append(selectSql);
        lastSql.append(orgaSql).append(doctorSql);

        return this.getList(NcpManageReport.class, lastSql.toString(), new Criteria());
    }

    private StringBuilder getOrgSql(String gbcode, String centerOrgCode, String orgCode){
        StringBuilder orgaSql = new StringBuilder();
        if (ObjectUtil.isNotEmpty(orgCode)) {//站
            orgaSql.append(" AND ORG.ORGAN_CODE = '" + orgCode + "'");
        } else if (ObjectUtil.isNotEmpty(centerOrgCode)) {//卫生院
            orgaSql.append(" AND (ORG.ORGAN_CODE = '" + centerOrgCode + "' OR ORG.PARENT_CODE = '" + centerOrgCode + "')");
        }else if (ObjectUtil.isNotEmpty(gbcode)) {//镇
            orgaSql.append(" AND ORG.GB_CODE = '" + gbcode + "'");
        }
        return orgaSql;
    }
}
