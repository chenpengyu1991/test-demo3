package com.founder.rhip.ehr.repository.hsa;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuk DAO implement of LocationInfo
 */
@Repository("hasLocationInfoDao")
public class LocationInfoDaoImpl extends AbstractDao<LocationInfo, Long> implements ILocationInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private final static String QUERY_WITH_COUNT_SQL_NEW =
//@foff
            "SELECT " +
                    "	l.UNIT_NAME,l.\"ID\",NVL(c.INSP_COUNT,0) INSP_COUNT ,NVL(c.GUIDE_COUNT,0) GUIDE_COUNT , " +
                    "	l.STATUS,l.PERSON_IN_CHARGE,l.LEGAL,l.CONTACT_PHONE,l.DUE_DATE,l.HEALTH_PROFESSIONAL,l.DATA_TYPE " +
                    "FROM " +
                    "	 (%1$s) l " +
                    "LEFT JOIN ( " +
                    "	SELECT " +
                    "		l.\"ID\", " +
                    "		\"COUNT\" (1) INSP_COUNT, " +
                    "	\"SUM\"(CASE IS_GUIDE WHEN '1' THEN 1 ELSE 0 END ) AS GUIDE_COUNT " +
                    "	FROM " +
                    "		HSA_INSPECTION_RECORD i, " +
                    "		HSA_LOCATION_INFO l " +
                    "	WHERE " +
                    "		l.\"ID\" = i.LOCATION_ID %3$s  " +
                    "	GROUP BY " +
                    "		l.\"ID\" " +
                    ") c ON l.\"ID\" = C.\"ID\" " +
                    "WHERE 1=1 %2$s  ORDER BY l.UPDATE_DATE desc, l.id";

    private final static String QUERY_ADD_SQL =
            "	 SELECT " +
                    "			HSA_LOCATION_INFO.UNIT_NAME, " +
                    "			HSA_LOCATION_INFO.\"ID\", " +
                    "			HSA_LOCATION_INFO.STATUS, " +
                    "			HSA_LOCATION_INFO.PERSON_IN_CHARGE, " +
                    "			HSA_LOCATION_INFO.LEGAL, " +
                    "			HSA_LOCATION_INFO.CONTACT_PHONE, " +
                    "			HSA_LOCATION_INFO.DATA_TYPE, " +
                    "			HSA_LOCATION_INFO.UPDATE_DATE, " +
                    "			HSA_LOCATION_INFO.DUE_DATE, " +
                    "			HSA_LOCATION_INFO.HEALTH_PROFESSIONAL, " +
                    "			HSA_LOCATION_INFO.MAIN_BUSINESS_CODE " +
                    "		FROM " +
                    "			HSA_LOCATION_INFO ";

    private final static String QUERY_IM_SQL =
            "			SELECT " +
                    "				HSA_LOCATION_INFO.UNIT_NAME, " +
                    "				HSA_LOCATION_INFO.\"ID\", " +
                    "				HSA_LOCATION_INFO.STATUS, " +
                    "				HSA_LOCATION_INFO.PERSON_IN_CHARGE, " +
                    "				HSA_LOCATION_INFO.LEGAL, " +
                    "				HSA_LOCATION_INFO.CONTACT_PHONE, " +
                    "				HSA_LOCATION_INFO.DATA_TYPE, " +
                    "				HSA_LOCATION_INFO.UPDATE_DATE, " +
                    "				HSA_BUSINESS_INFO.DUE_DATE, " +
                    "				HSA_BUSINESS_INFO.HEALTH_PROFESSIONAL, " +
                    "				HSA_BUSINESS_INFO.MAIN_BUSINESS_CODE " +
                    "			FROM " +
                    "				HSA_LOCATION_INFO " +
                    "			LEFT JOIN HSA_BUSINESS_INFO ON HSA_LOCATION_INFO. ID = HSA_BUSINESS_INFO.LOCATION_INFO_ID";

    //@fon

    @Override
    public PageList<Map<String, Object>> getPageLocationInfoMapList(Page page, Criteria cr) {
        String sql = getSql(page, cr);
        return this.getPageMapList(page, sql, cr);
    }

    @Override
    public PageList<LocationInfo> getPageLocationInfoList(Page page, Criteria cr) {
        String sql = getSql(page, cr);
        return this.getPageList(page, sql, cr);
    }

    private String getSql(final Page page, final Criteria cr) {
        List<Criterion> criterions = cr.getCriteria();
        Map<String, Criterion> criterionMap = new HashMap<>(criterions.size());
        for (Criterion criterion : criterions) {
            criterionMap.put(criterion.getName(), criterion);
        }

        StringBuilder countWhere = null;
        Object inspCountType = cr.get("HSA_LOCATION_INFO.INSP_COUNT_TYPE");
        if (ObjectUtil.isNotEmpty(inspCountType)) {
            countWhere = new StringBuilder();
            String inspCountTypeValue = inspCountType.toString();
            countWhere.append("AND NVL(c.INSP_COUNT,0) ");
            switch (inspCountTypeValue) {
                case "1":
                    countWhere.append("=0 ");
                    break;
                case "2":
                    countWhere.append("=1 ");
                    break;
                case "3":
                    countWhere.append("=2 ");
                    break;
                case "4":
                    countWhere.append("=3 ");
                    break;
                case "5":
                    countWhere.append(">3 ");
                    break;
            }
        }

        Object guideCountType = cr.get("HSA_LOCATION_INFO.GUIDE_COUNT_TYPE");
        if (ObjectUtil.isNotEmpty(guideCountType)) {
            if (null == countWhere) {
                countWhere = new StringBuilder(" AND ");
            } else {
                countWhere.append(" AND ");
            }
            String guideCountTypeVallue = guideCountType.toString();
            countWhere.append(" NVL(c.GUIDE_COUNT,0) ");
            switch (guideCountTypeVallue) {
                case "1":
                    countWhere.append("=0 ");
                    break;
                case "2":
                    countWhere.append("=1 ");
                    break;
                case "3":
                    countWhere.append(">1 ");
                    break;
            }
        }

        cr.remove("HSA_LOCATION_INFO.INSP_COUNT_TYPE");
        cr.remove("HSA_LOCATION_INFO.GUIDE_COUNT_TYPE");

        StringBuilder locationSql = new StringBuilder();

        //cr.remove("HSA_LOCATION_INFO.DATA_TYPE");
        locationSql.append(QUERY_ADD_SQL);
        if (cr.getCriteria().size() > 0) {
            SqlBuilder.buildWhereStatement(LocationInfo.class, locationSql, cr);
        } else {
            locationSql.append(" WHERE 1=1 ");
        }
        //locationSql.append(" AND HSA_LOCATION_INFO.DATA_TYPE='1'");

        Criterion HEALTH_PROFESSIONAL = criterionMap.get("HSA_LOCATION_INFO.HEALTH_PROFESSIONAL");

        if (null != HEALTH_PROFESSIONAL) {
            cr.remove("HSA_LOCATION_INFO.HEALTH_PROFESSIONAL");
            cr.addCriterion(new Criterion(HEALTH_PROFESSIONAL.getLogicOperation(), "HSA_BUSINESS_INFO.HEALTH_PROFESSIONAL", HEALTH_PROFESSIONAL.getOperation(), HEALTH_PROFESSIONAL.getValue()));
        } else {
            cr.add("HSA_BUSINESS_INFO.HEALTH_PROFESSIONAL", OP.NE, "99");
        }

        Criterion MAIN_BUSINESS_CODE = criterionMap.get("HSA_LOCATION_INFO.MAIN_BUSINESS_CODE");
        if (null != MAIN_BUSINESS_CODE) {
            cr.remove("HSA_LOCATION_INFO.MAIN_BUSINESS_CODE");
            cr.addCriterion(new Criterion(MAIN_BUSINESS_CODE.getLogicOperation(), "HSA_BUSINESS_INFO.MAIN_BUSINESS_CODE", MAIN_BUSINESS_CODE.getOperation(), MAIN_BUSINESS_CODE.getValue()));
        }

        Criterion STATUS = criterionMap.get("HSA_LOCATION_INFO.STATUS");
        if (null != STATUS) {
            cr.remove("HSA_LOCATION_INFO.STATUS");
        }

        Criterion DUE_DATE = criterionMap.get("HSA_LOCATION_INFO.DUE_DATE");

        if (null != DUE_DATE) {
            cr.remove("HSA_LOCATION_INFO.DUE_DATE");
            cr.addCriterion(new Criterion("HSA_BUSINESS_INFO.DUE_DATE", DUE_DATE.getOperation(), DUE_DATE.getValue()));
        }

        StringBuilder locationSql2 = new StringBuilder();
        locationSql2.append(QUERY_IM_SQL);
        if (cr.getCriteria().size() > 0) {
            SqlBuilder.buildWhereStatement(LocationInfo.class, locationSql2, cr);
        } else {
            locationSql2.append(" WHERE 1=1 ");
        }
        locationSql2.append(" AND HSA_LOCATION_INFO.DATA_TYPE in ('").append(EHRConstants.LOCATION_DATA_TYPE_IMPORT_NOT_SHOW).append("','").append(EHRConstants.LOCATION_DATA_TYPE_IMPORT).append("') ");
        locationSql2.append(" AND HSA_BUSINESS_INFO.DATA_TYPE='").append(EHRConstants.LOCATION_DATA_TYPE_IMPORT).append("'  ");

        if (null != STATUS) {
            if (EHRConstants.LOCATION_DATA_STATUS_CANCEL.equals(STATUS.getValue())) {
                locationSql2.append(" AND ((HSA_BUSINESS_INFO.BUSINESS_TYPE_CODE ='9' OR HSA_BUSINESS_INFO.LICENSE_STATE_CODE='2' )");
                locationSql2.append(" AND HSA_BUSINESS_INFO.NEW_RECORD_FLAG='").append(EHRConstants.LOCATION_NEW_RECORD_FLAG_YES).append("') ");
            }
            if (EHRConstants.LOCATION_DATA_STATUS_NORMAL.equals(STATUS.getValue())) {
                locationSql2.append(" AND NVL(HSA_BUSINESS_INFO.BUSINESS_TYPE_CODE,'0') !='9' AND NVL(HSA_BUSINESS_INFO.LICENSE_STATE_CODE,'0')!='2'");
                locationSql2.append(" AND HSA_BUSINESS_INFO.NEW_RECORD_FLAG='").append(EHRConstants.LOCATION_NEW_RECORD_FLAG_YES).append("'  ");
            }
        }

        locationSql.append(" UNION ALL ").append(locationSql2);

        String countWhereSql = "";
        if (null != countWhere) {
            countWhereSql = countWhere.toString();
        }

        String inspDateSql = "AND EXTRACT ( YEAR FROM i.INSP_DATE) =" + DateUtil.getCurrentYear();
        String sql = String.format(QUERY_WITH_COUNT_SQL_NEW, locationSql.toString(), countWhereSql, inspDateSql);

        if (null != HEALTH_PROFESSIONAL) {
            cr.addCriterion(HEALTH_PROFESSIONAL);
        }

        if (null != MAIN_BUSINESS_CODE) {
            cr.addCriterion(MAIN_BUSINESS_CODE);
        }

        if (null != STATUS) {
            cr.addCriterion(STATUS);
        }

        if (null != DUE_DATE) {
            cr.addCriterion(DUE_DATE);
        }
        return sql;
    }

    @Override
    @Deprecated
    public void updateBySelfCode(LocationInfo info) {

    }

    private final static String IMPORT_UPDATE_BY_MAIN_ID =
//@foff
            "UPDATE HSA_LOCATION_INFO " +
                    "SET MAIN_UUID =:mainUuid, " +
                    " NO_FILE =:noFile, " +
                    " UNIT_NAME =:unitName, " +
                    " REGISTER_ORGN_NAME =:registerOrgnName, " +
                    " BUSINESS_ADDRESS_NAME =:businessAddressName, " +
                    " ORGANIZATION_CODE =:organizationCode, " +
                    " ZIP_CODE =:zipCode, " +
                    " UNIT_TYPE_CODE =:unitTypeCode, " +
                    " ECONOMIC_NATURE_CODE =:economicNatureCode, " +
                    " TOWNSHIP_LOT_CODE =:townshipLotCode, " +
                    " LEGAL =:legal, " +
                    " PERSON_IN_CHARGE =:personInCharge, " +
                    " OWNER =:owner, " +
                    " CONTACT_PHONE =:contactPhone, " +
                    " CONTACT =:contact, " +
                    " HEALTH_PROFESSIONAL =:healthProfessional, " +
                    " MAIN_BUSINESS_CODE =:mainBusinessCode, " +
                    " DUE_DATE =:dueDate, " +
                    " DOCUMENT_TYPE_CODE =:documentTypeCode, " +
                    " IDCARD =:idcard, " +
                    " SUPERVISOR_CODE =:supervisorCode, " +
                    " SUPERVISOR_NAME =:supervisorName, " +
                    " BUSINESS_TYPE_CODE =:businessTypeCode, " +
                    " LICENSE_STATE_CODE =:licenseStateCode, " +
                    " STATUS =:status, " +
                    " UNIT_TYPE_CODE_ORI =:unitTypeCodeOri, " +
                    " ECONOMIC_NATURE_CODE_ORI =:economicNatureCodeOri, " +
                    " DOCUMENT_TYPE_CODE_ORI =:documentTypeCodeOri, " +
                    " TOWNSHIP_LOT_CODE_ORI =:townshipLotCodeOri, " +
                    " SCALE_ORI =:scaleOri, " +
                    " NO_FILE_ORI =:noFileOri, " +
                    " SUPERVISOR_CODE_ORI =:supervisorCodeOri, " +
                    " DATA_TYPE =:dataType " +
                    "WHERE " +
                    "	MAIN_ID =:mainId";
    //@fon

    @Override
    public void importOnUpdate(LocationInfo info) {
        getSimpleJdbcTemplate().update(IMPORT_UPDATE_BY_MAIN_ID, new BeanPropertySqlParameterSource(info));
    }

}
