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

@Repository("ncpHealthReportDao")
public class ReportHealthDaoImpl extends AbstractDao<NcpHealthReport,String> implements IReportHealthDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<NcpHealthReport> getNcpHealthReports(Criteria criteria) {
        //统计各个指标总数sql
        String healthcardSql = "HEALTHCARD AS (SELECT MANAGEMENT_ORG, COUNT(DISTINCT CARDNO) HEALTH_CARD_NUM FROM NCP_PATIENT WHERE IS_DELETE = 0 GROUP BY MANAGEMENT_ORG)";
        String monitorSql = "MONITOR AS (SELECT MONITOR_ORG, COUNT(DISTINCT CARDNO) MONITOR_NUM FROM NCP_MONITOR WHERE TYPE = 1 GROUP BY MONITOR_ORG)";
        String followupSql = "FOLLOWUP AS (SELECT MONITOR_ORG, COUNT(DISTINCT CARDNO) FOLLOWUP_NUM FROM NCP_MONITOR WHERE TYPE = 3 GROUP BY MONITOR_ORG)";
        String reviewSql = "REVIEW AS (SELECT MONITOR_ORG, COUNT(DISTINCT CARDNO) REVIEW_NUM FROM NCP_MONITOR WHERE TYPE = 2 GROUP BY MONITOR_ORG)";
        String orgSql = "ORG as (select ORGAN_CODE, GB_CODE, ORGAN_NAME, GENRE_CODE, decode(GENRE_CODE, 'B200', PARENT_CODE, ORGAN_CODE) PARENT_CODE FROM MDM_ORGANIZATION WHERE GENRE_CODE IN ('B100', 'B200') AND STATUS = 1)";

        String gbcode = (String) criteria.get("gbcode");
        String centerOrgCode = (String) criteria.get("centerOrgCode");
        String orgCode = (String) criteria.get("orgCode");

        StringBuilder orgaSql = getOrgSql(gbcode, centerOrgCode, orgCode);
        StringBuilder selectSql = new StringBuilder("select HC.MANAGEMENT_ORG          MANAGE_ORG_CODE,\n" +
                "       NVL(HC.HEALTH_CARD_NUM, 0) HEALTH_CARD_NUM,\n" +
                "       NVL(MO.MONITOR_NUM, 0)     MONITOR_NUM,\n" +
                "       NVL(FU.FOLLOWUP_NUM, 0)    FOLLOWUP_NUM,\n" +
                "       NVL(RE.REVIEW_NUM, 0)      REVIEW_NUM\n" +
                "from HEALTHCARD HC\n" +
                "         LEFT JOIN MONITOR MO ON HC.MANAGEMENT_ORG = MO.MONITOR_ORG\n" +
                "         LEFT JOIN FOLLOWUP FU ON HC.MANAGEMENT_ORG = FU.MONITOR_ORG\n" +
                "         LEFT JOIN REVIEW RE ON HC.MANAGEMENT_ORG = RE.MONITOR_ORG\n" +
                "         LEFT JOIN ORG ON ORG.ORGAN_CODE = HC.MANAGEMENT_ORG\n" +
                "WHERE 1 = 1");

        StringBuilder lastSql = new StringBuilder("WITH ");
        lastSql.append(healthcardSql).append(", ");
        lastSql.append(monitorSql).append(", ");
        lastSql.append(followupSql).append(", ");
        lastSql.append(reviewSql).append(", ");
        lastSql.append(orgSql);
        lastSql.append(selectSql);
        lastSql.append(orgaSql);
        return this.getList(NcpHealthReport.class, lastSql.toString(), new Criteria());
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
