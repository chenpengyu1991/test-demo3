package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmReportInfo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * DAO implement of DmDiseaseInfo
 * 
 */
@Repository("dmReportInfoDao")
public class DmReportInfoDaoImpl extends AbstractDao<DmReportInfo, Long> implements IDmReportInfoDao {
	@SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<DmReportInfo> getReports(Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder("SELECT dmReportInfo.* FROM DM_REPORT_INFO dmReportInfo LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID ");
		SqlBuilder.buildWhereStatement(DmReportInfo.class, sql, criteria);
		if (ObjectUtil.isNotEmpty(order)) {
			sql.append(order.toString());
		}
		List<DmReportInfo> dmReportInfos = this.getList(sql.toString(), criteria);
		return dmReportInfos;
	}


    @Override
    public List<DmReportInfo> getPagedDetailReportCardListGroupByPerson(Page page, Criteria criteria) {
        criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_REPORT_TYPE);
        StringBuilder sqlForPersonId = new StringBuilder(
                "SELECT dmPersonInfo.PERSON_ID PERSON_ID, MAX (dmReportInfo.ID) ID FROM DM_REPORT_INFO dmReportInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID  ");
        SqlBuilder.buildWhereStatement(DmReportInfo.class, sqlForPersonId, criteria);
        sqlForPersonId.append(" GROUP BY dmPersonInfo.PERSON_ID ORDER BY ID DESC ");
        PageList<Map<String, Object>> personIds = this.getPageMapList(page, sqlForPersonId.toString(), criteria);
        List<Map<String, Object>> personIdList = personIds.getList();
        if (ObjectUtil.isNullOrEmpty(personIdList)) {
            return null;
        }
        Set<Object> targetPersonIds = new HashSet<>();
        for (Map<String, Object> map : personIdList) {
			if(ObjectUtil.isNotEmpty(map.get("PERSON_ID"))) {
				targetPersonIds.add(map.get("PERSON_ID"));
			}
        }
        StringBuilder sqlForReport = new StringBuilder(
                "SELECT cdmStatusInfo.REPORT_STATUS, dmReportInfo.*,dmPersonInfo.NAME,dmPersonInfo.IDCARD,dmPersonInfo.BIRTHDAY, dmPersonInfo.GENDER   FROM DM_REPORT_INFO dmReportInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID ");
        criteria.add("dmReportInfo.PERSON_ID", OP.IN, targetPersonIds);
        SqlBuilder.buildWhereStatement(DmReportInfo.class, sqlForReport, criteria);
        SqlBuilder.buildOrderStatement(sqlForReport,"dmReportInfo.CREATE_DATE DESC ,dmReportInfo.ID DESC");
        List<DmReportInfo> dmReportInfos = getList(sqlForReport.toString(), criteria);
        return dmReportInfos;
    }

    @Override
    public List<Map<String, Object>> getDetailReportCardMapList(Criteria criteria) {
        criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_REPORT_TYPE);
         StringBuilder sqlForReport = new StringBuilder(
                "SELECT cdmStatusInfo.REPORT_STATUS, dmReportInfo.*,dmPersonInfo.NAME,dmPersonInfo.IDCARD,dmPersonInfo.BIRTHDAY, dmPersonInfo.GENDER   FROM DM_REPORT_INFO dmReportInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID ");
        SqlBuilder.buildWhereStatement(DmReportInfo.class, sqlForReport, criteria);
        SqlBuilder.buildOrderStatement(sqlForReport,"dmReportInfo.CREATE_DATE DESC ,dmReportInfo.ID DESC");
        List<Map<String, Object>> dmReportInfos = getMapList(sqlForReport.toString(), criteria);
        return dmReportInfos;
    }

	//@Override
	public List<DmReportInfo> getDetailReportListWithoutOrder(Page page, Criteria criteria) {
		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_REPORT_TYPE);
		StringBuilder sqlForPersonId = new StringBuilder(
				"SELECT DISTINCT dmReportInfo.PERSON_ID FROM DM_REPORT_INFO dmReportInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID  ");
		SqlBuilder.buildWhereStatement(DmReportInfo.class, sqlForPersonId, criteria);
		PageList<Map<String, Object>> personIds = this.getPageMapList(page, sqlForPersonId.toString(), criteria);
		List<Map<String, Object>> personIdList = personIds.getList();
		if (ObjectUtil.isNullOrEmpty(personIdList)) {
			return null;
		}
		Set<Object> targetPersonIds = new HashSet<>();
		for (Map<String, Object> map : personIdList) {
			targetPersonIds.add(map.get("PERSON_ID"));
		}
		StringBuilder sqlForReport = new StringBuilder(
				"SELECT cdmStatusInfo.REPORT_STATUS, dmReportInfo.*,dmPersonInfo.NAME,dmPersonInfo.IDCARD,dmPersonInfo.BIRTHDAY, dmPersonInfo.GENDER   FROM DM_REPORT_INFO dmReportInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID ");
		criteria.add("dmReportInfo.PERSON_ID", OP.IN, targetPersonIds);
		SqlBuilder.buildWhereStatement(DmReportInfo.class, sqlForReport, criteria);
		List<DmReportInfo> dmReportInfos = getList(sqlForReport.toString(), criteria);
		return dmReportInfos;
	}


	@Override
	public PageList<DmReportInfo> getRepeatCardList(Page page, Criteria criteria, String conditions) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DM_REPORT_INFO.CDM_ID,DM_REPORT_INFO.ID,DM_PERSON_INFO.NAME,DM_REPORT_INFO.REPORT_TYPE,DM_PERSON_INFO.GENDER,DM_PERSON_INFO.IDCARD,DM_PERSON_INFO.BIRTHDAY,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.CREATE_ORGAN_NAME,DM_REPORT_INFO.CREATE_DATE,CDM_STATUS_INFO.REPORT_STATUS,DM_REPORT_INFO.PERSON_ID "
				+ " FROM DM_REPORT_INFO INNER JOIN DM_PERSON_INFO ON DM_REPORT_INFO.DM_PERSON_ID=DM_PERSON_INFO.ID LEFT JOIN CDM_STATUS_INFO ON DM_REPORT_INFO.CDM_ID=CDM_STATUS_INFO.ID INNER JOIN ");
		if (StringUtil.isNotEmpty(conditions)) {
			if (conditions.equals("2")) {
				sql.append(" ( SELECT DM_PERSON_INFO.NAME,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.SUB_DIS_TYPE FROM DM_REPORT_INFO INNER JOIN DM_PERSON_INFO ON DM_REPORT_INFO.DM_PERSON_ID=DM_PERSON_INFO.ID LEFT JOIN CDM_STATUS_INFO ON DM_REPORT_INFO.CDM_ID=CDM_STATUS_INFO.ID WHERE CDM_STATUS_INFO.REPORT_STATUS!=5  GROUP BY DM_PERSON_INFO.NAME,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.SUB_DIS_TYPE   HAVING COUNT(1)>1 ) A  "
						+ "   ON DM_PERSON_INFO.NAME=A.NAME AND DM_REPORT_INFO.DIS_TYPE=A.DIS_TYPE AND DM_REPORT_INFO.SUB_DIS_TYPE=A.SUB_DIS_TYPE  AND CDM_STATUS_INFO.REPORT_STATUS!=5 ");
			} else if (conditions.equals("3")) {
				sql.append(" ( SELECT DM_PERSON_INFO.BIRTHDAY,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.SUB_DIS_TYPE FROM DM_REPORT_INFO INNER JOIN DM_PERSON_INFO ON DM_REPORT_INFO.DM_PERSON_ID=DM_PERSON_INFO.ID LEFT JOIN CDM_STATUS_INFO ON DM_REPORT_INFO.CDM_ID=CDM_STATUS_INFO.ID WHERE CDM_STATUS_INFO.REPORT_STATUS!=5  GROUP BY DM_PERSON_INFO.BIRTHDAY,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.SUB_DIS_TYPE   HAVING COUNT(1)>1 ) A  "
						+ "   ON  DM_PERSON_INFO.BIRTHDAY=A.BIRTHDAY AND DM_REPORT_INFO.DIS_TYPE=A.DIS_TYPE AND DM_REPORT_INFO.SUB_DIS_TYPE=A.SUB_DIS_TYPE  AND CDM_STATUS_INFO.REPORT_STATUS!=5 ");
			} else {
				sql.append(" ( SELECT DM_PERSON_INFO.NAME,DM_PERSON_INFO.BIRTHDAY,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.SUB_DIS_TYPE FROM DM_REPORT_INFO INNER JOIN DM_PERSON_INFO ON DM_REPORT_INFO.DM_PERSON_ID=DM_PERSON_INFO.ID LEFT JOIN CDM_STATUS_INFO ON DM_REPORT_INFO.CDM_ID=CDM_STATUS_INFO.ID WHERE CDM_STATUS_INFO.REPORT_STATUS!=5  GROUP BY DM_PERSON_INFO.NAME,DM_PERSON_INFO.BIRTHDAY,DM_REPORT_INFO.DIS_TYPE,DM_REPORT_INFO.SUB_DIS_TYPE   HAVING COUNT(1)>1 ) A  "
						+ "   ON DM_PERSON_INFO.NAME=A.NAME AND DM_PERSON_INFO.BIRTHDAY=A.BIRTHDAY AND DM_REPORT_INFO.DIS_TYPE=A.DIS_TYPE AND DM_REPORT_INFO.SUB_DIS_TYPE=A.SUB_DIS_TYPE  AND CDM_STATUS_INFO.REPORT_STATUS!=5 ");
			}
		}
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "DM_PERSON_INFO.NAME,DM_REPORT_INFO.CREATE_DATE DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

    @Override
    public void updateOrganByVillage(String orgCode,String superOrgCode, String[] newAddVillageCodes,String status) {
        String sql = "UPDATE DM_REPORT_INFO SET DM_REPORT_INFO.MANAGE_ORGAN_CODE =:orgCode, DM_REPORT_INFO.SUPER_MANAGE_ORGAN_CODE=:superOrgCode WHERE EXISTS ( SELECT 1 FROM DM_PERSON_INFO, CDM_STATUS_INFO WHERE DM_PERSON_INFO.ID = DM_REPORT_INFO.DM_PERSON_ID AND DM_PERSON_INFO.TYPE =:type AND CDM_STATUS_INFO.ID = DM_REPORT_INFO.CDM_ID AND CDM_STATUS_INFO.REPORT_STATUS =:status AND DM_PERSON_INFO.PASTREET IN (:villages))";
        String historySql = "INSERT INTO DM_REPORT_INFO_RH(ID,SUPER_MANAGE_ORGAN_CODE,MANAGE_ORGAN_CODE,RECORD_CHANGE_TIME) SELECT DM_REPORT_INFO.ID, DM_REPORT_INFO.SUPER_MANAGE_ORGAN_CODE,DM_REPORT_INFO.MANAGE_ORGAN_CODE,to_date('" + DateUtil.toDateString(new Date(), "yyyy-MM-dd HH:mm:ss") + "','yyyy-mm-dd hh24:mi:ss') FROM  DM_PERSON_INFO, CDM_STATUS_INFO,DM_REPORT_INFO WHERE DM_PERSON_INFO.ID = DM_REPORT_INFO.DM_PERSON_ID AND DM_PERSON_INFO.TYPE =:type AND CDM_STATUS_INFO.ID = DM_REPORT_INFO.CDM_ID AND CDM_STATUS_INFO.REPORT_STATUS =:status AND DM_PERSON_INFO.PASTREET IN (:villages)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("type", EHRConstants.DM_PERSON_REPORT_TYPE);
        parameterSource.addValue("villages", Arrays.asList(newAddVillageCodes));
        parameterSource.addValue("orgCode", orgCode);
        parameterSource.addValue("superOrgCode", superOrgCode);
        parameterSource.addValue("status",status);
        simpleJdbcTemplate.update(historySql, parameterSource);
        simpleJdbcTemplate.update(sql, parameterSource);
    }

	@Override
	public Integer getPagedDetailReportCardListGroupByPersonCount(Criteria criteria){
		int count = 0;
		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_REPORT_TYPE);
		StringBuilder sqlForPersonId = new StringBuilder(
				"SELECT dmPersonInfo.PERSON_ID PERSON_ID, MAX (dmReportInfo.ID) ID FROM DM_REPORT_INFO dmReportInfo INNER JOIN DM_PERSON_INFO dmPersonInfo ON dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID LEFT JOIN CDM_STATUS_INFO cdmStatusInfo ON dmReportInfo.CDM_ID=cdmStatusInfo.ID  ");
		SqlBuilder.buildWhereStatement(DmReportInfo.class, sqlForPersonId, criteria);
		sqlForPersonId.append(" GROUP BY dmPersonInfo.PERSON_ID ");
		List<Map<String, Object>> personIds = this.getMapList(sqlForPersonId.toString(), criteria);
		if (ObjectUtil.isNullOrEmpty(personIds.size()<=0)) {
			count = 0;
		}else{
			count = personIds.size();
		}
		return count;
	}

}