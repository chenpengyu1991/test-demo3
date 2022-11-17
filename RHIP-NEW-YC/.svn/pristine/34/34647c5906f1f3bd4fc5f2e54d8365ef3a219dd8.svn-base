package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wang_zhou on 2015/6/15.
 */
/**
 * DAO implement of ReferralInfo
 *
 */
@Repository("ReferralInfoDoubleDao")
public class ReferralInfoDoubleDaoImpl extends AbstractDao<ReferralInfo, Long> implements IReferralInfoDoubleDao {
    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public static final String REFERRAL_DATE = "REFERRAL_DATE";
    private static final String DOUBLE_OUT_SQL = "SELECT COUNT(1) OUT_QUANTITY  FROM V_RMSDB_MS_REFERRAL_INFO t where t.integrated_data=0 and t.is_delete=0";
    private static final String DOUBLE_IN_SQL = "SELECT COUNT(1) IN_QUANTITY  FROM V_RMSDB_MS_REFERRAL_INFO t where t.integrated_data=0 and t.is_delete=0";

    @Override
    public Integer getOutList(Criteria criteria) {
        StringBuilder sqlBuilder = new StringBuilder(DOUBLE_OUT_SQL).append(organizeDateStatisticsSQL(criteria, REFERRAL_DATE)).append(organizeOrganizationOutSQL(criteria));
        Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
        if (map != null && ObjectUtil.isNotEmpty(map.get("OUT_QUANTITY"))) {
            return Integer.valueOf(String.valueOf(map.get("OUT_QUANTITY")));
        } else {
            return 0;
        }
    }

    @Override
    public Integer getInList(Criteria criteria) {
        StringBuilder sqlBuilder = new StringBuilder(DOUBLE_IN_SQL).append(organizeDateStatisticsSQL(criteria, REFERRAL_DATE)).append(organizeOrganizationInSQL(criteria));
        Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
        if (map != null && ObjectUtil.isNotEmpty(map.get("IN_QUANTITY"))) {
            return Integer.valueOf(String.valueOf(map.get("IN_QUANTITY")));
        } else {
            return 0;
        }
    }

    /**
     * 组织按时间统计条件
     *
     * @param criteria 查询条件包含时间
     * @param timeColumn 时间字段
     * @return
     */
    private String organizeDateStatisticsSQL(Criteria criteria, String timeColumn) {
        if (criteria == null || ObjectUtil.isNullOrEmpty(timeColumn)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (criteria.contains("beginDate") && criteria.contains("endDate")&&!criteria.get("beginDate").equals("")&&!criteria.get("endDate").equals("")) {
            sb.append(" AND ");
            sb.append(timeColumn);
            sb.append(" BETWEEN TO_DATE('");
            sb.append(criteria.get("beginDate"));
            sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
            sb.append(criteria.get("endDate"));
            sb.append("', 'yyyy/MM/dd')");
        }

        return sb.toString();
    }

    /**
     * 组织不同机构类别查询条件OUT
     * @param criteria
     * @return
     */
    private String organizeOrganizationOutSQL(Criteria criteria) {
        StringBuilder sqlBuilder = new StringBuilder();
        if (criteria.contains("orgCode")) {
            sqlBuilder.append(" AND DEST_DEPT_CODE ='");
            sqlBuilder.append(String.valueOf(criteria.get("orgCode")));
            sqlBuilder.append("'");
        }else if (criteria.contains("gbCode")) {
            sqlBuilder.append(" AND DEST_DEPT_CODE in (");
            sqlBuilder.append(String.valueOf(criteria.get("gbCode")));
            sqlBuilder.append(") ");
        }
        return sqlBuilder.toString();
    }

    /**
     * 组织不同机构类别查询条件IN
     * @param criteria
     * @return
     */
    private String organizeOrganizationInSQL(Criteria criteria) {
        StringBuilder sqlBuilder = new StringBuilder();
        if (criteria.contains("orgCode")) {
            sqlBuilder.append(" AND REFERRAL_HOSPITAL_CODE ='");
            sqlBuilder.append(String.valueOf(criteria.get("orgCode")));
            sqlBuilder.append("'");
        }else if (criteria.contains("gbCode")) {
            sqlBuilder.append(" AND REFERRAL_HOSPITAL_CODE in (");
            sqlBuilder.append(String.valueOf(criteria.get("gbCode")));
            sqlBuilder.append(") ");
        }
        return sqlBuilder.toString();
    }
}