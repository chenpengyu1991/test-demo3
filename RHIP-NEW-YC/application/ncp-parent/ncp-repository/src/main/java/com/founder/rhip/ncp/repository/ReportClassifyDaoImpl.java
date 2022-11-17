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

@Repository("ncpClassifyReportDao")
public class ReportClassifyDaoImpl extends AbstractDao<NcpClassifyReport,String> implements IReportClassifyDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<NcpClassifyReport> getNcpClassifyReports(Criteria criteria) {
        String orgSql = "ORG as (select ORGAN_CODE, GB_CODE, ORGAN_NAME, GENRE_CODE, decode(GENRE_CODE, 'B200', PARENT_CODE, ORGAN_CODE) PARENT_CODE FROM MDM_ORGANIZATION WHERE GENRE_CODE IN ('B100', 'B200') AND STATUS = 1)";

        String gbcode = (String) criteria.get("gbcode");
        String centerOrgCode = (String) criteria.get("centerOrgCode");
        String orgCode = (String) criteria.get("orgCode");
        StringBuilder orgaSql = getOrgSql(gbcode, centerOrgCode, orgCode);
        StringBuilder selectSql = new StringBuilder("select MANAGEMENT_ORG MANAGE_ORG_CODE,\n" +
                "       count(case when PATIENT_TYPE = '2' AND ZL_TYPE = '1' AND IS_DELETE = 0 then 1 end) INSIDE_TREAT_NUM,\n" +
                "       count(case when PATIENT_TYPE = '2' AND ZL_TYPE = '2' AND IS_DELETE = 0 then 1 end) OUTSIDE_TREAT_NUM,\n" +
                "       count(case when PATIENT_TYPE = '1' AND IS_DELETE = 0 then  1 end) SUSPECTED_NUM,\n" +
                "       count(case when PATIENT_TYPE = '3' AND IS_DELETE = 0 then 1 end) ASYMPTOMATIC_NUM\n" +
                "from NCP_PATIENT NP\n" +
                "LEFT JOIN ORG ON ORG.ORGAN_CODE = NP.MANAGEMENT_ORG\n" +
                "where 1 = 1");

        StringBuilder lastSql = new StringBuilder("WITH ");
        lastSql.append(orgSql);
        lastSql.append(selectSql);
        lastSql.append(orgaSql);
        lastSql.append("group by MANAGEMENT_ORG");
        return this.getList(NcpClassifyReport.class, lastSql.toString(), new Criteria());

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
