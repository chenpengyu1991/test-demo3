package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of CaseInformation
 * 
 */
@Repository("caseInformationDao")
public class CaseInformationDaoImpl extends AbstractDao<CaseInformation, Integer> implements ICaseInformationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
     * 查看血吸虫调查列表
     * @param       criteria
     * @return      PageList<CaseInformation>
     */
	public PageList<CaseInformation> findSurveyList(Page page, Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ID,IDM_ID,REPORT_DATE,SURVEY_ORG,RESPONDENTS,SURVEY_DATE ");
		sql.append(" FROM IDM_CASE_INFORMATION cas WHERE IDM_ID IN ( ");
		sql.append(" SELECT ID FROM IDM_EVENT_INFO WHERE " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(" )");
		SqlBuilder.buildOrderStatement(sql, " SURVEY_DATE DESC");
		return getPageList(page,sql.toString(), criteria);		
	}
	
	@Override
	public List<Map<String, Object>> getCaseToStandardMapList(Map<String, String> paramMap){
		
		/*List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		Criteria criteria = organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(PhysicalExamRecord.class,sqlBuilder, criteria);
		StringBuilder orgConditionBuilder = getOrganizationCondition(paramMap);
		String genreCode = paramMap.get("genreCode");
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals(genreCode, "0")) {
			sql=String.format(PHYSICAL_EXAM_PROGRESS_STATISTICS_SQL, "gb_code",sqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		} else if (StringUtils.equals(genreCode, OrgGenreCode.STATION.getValue()) ){
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(PHYSICAL_EXAM_PROGRESS_STATISTICS_STATION_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		} else if (StringUtils.equals(genreCode, OrgGenreCode.HOSPITAL.getValue()) ){
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(PHYSICAL_EXAM_PROGRESS_STATISTICS_STATION_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(PHYSICAL_EXAM_PROGRESS_STATISTICS_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}*/
		
		/*SELECT org.gb_code,
		  org.parent_code,
		  org.organ_code ,
		  org.GENRE_CODE,
		  i.upTo ,
		  i.lowTo
		FROM mdm_organization org
		LEFT JOIN
		  (SELECT c.survey_Org ,
		    SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) upTo ,
		    SUM(DECODE(d.CASE_PASS_STATUS,0,1,0)) lowTo
		  FROM IDM_CASE_INFORMATION c
		  LEFT JOIN
		    (SELECT e.id,
		      e.STATUS_ID,
		      s.CASE_PASS_STATUS
		    FROM IDM_EVENT_INFO e
		    LEFT JOIN IDM_STATUS_INFO s
		    ON e.STATUS_ID  = s.id
		    ) d ON c.IDM_ID = d.id
		  WHERE 1           =1
		  AND c.survey_Org IS NOT NULL
		  GROUP BY c.survey_Org
		  ) i ON org.organ_code = i.survey_Org */

/*		with w ( SELECT org.gb_code,
		  org.parent_code,
		  org.organ_code ,
		  org.GENRE_CODE,
		  i.upTo ,
		  i.lowTo
		FROM mdm_organization org
		LEFT JOIN
		  (SELECT c.survey_Org ,
		    SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) upTo ,
		    SUM(DECODE(d.CASE_PASS_STATUS,0,1,0)) lowTo
		  FROM IDM_CASE_INFORMATION c
		  LEFT JOIN
		    (SELECT e.id,
		      e.STATUS_ID,
		      s.CASE_PASS_STATUS
		    FROM IDM_EVENT_INFO e
		    LEFT JOIN IDM_STATUS_INFO s
		    ON e.STATUS_ID  = s.id
		    ) d ON c.IDM_ID = d.id
		  WHERE 1           =1
		  AND c.survey_Org IS NOT NULL
		  GROUP BY c.survey_Org
		  ) i ON org.organ_code = i.survey_Org )

		单个机构
		select * from w where w.organ_code=''
		中心查站list
		select * from w where w.parent_code = ''
		疾控下的中心list
		select * from w where  org.GENRE_CODE='B100'
		疾控下的市级医院list
		select * from w where  org.GENRE_CODE='A100'*/
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		Criteria ca = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
     /*   Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(ca, "surveyDate", beginDate,endDate);
		SqlBuilder.getSqlParameterSource(ca);*/
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" with w as ( SELECT org.gb_code, org.parent_code, org.organ_code , org.GENRE_CODE, i.upTo , i.lowTo ,i.upToRate, i.lowToRate");
		sqlBuilder.append(" FROM mdm_organization org LEFT JOIN ");
		sqlBuilder.append("  ( SELECT c.MODIFY_SURVEY_ORG , SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) upTo , SUM(DECODE(d.CASE_PASS_STATUS,0,1,0)) lowTo , "
				+ " decode((SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) +  SUM(DECODE(d.CASE_PASS_STATUS,0,1,0))),0,0, SUM(DECODE(d.CASE_PASS_STATUS,1,1,0))/(SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) +  SUM(DECODE(d.CASE_PASS_STATUS,0,1,0)))) upToRate, "
				+ " decode((SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) +  SUM(DECODE(d.CASE_PASS_STATUS,0,1,0))),0,0, SUM(DECODE(d.CASE_PASS_STATUS,0,1,0))/(SUM(DECODE(d.CASE_PASS_STATUS,1,1,0)) +  SUM(DECODE(d.CASE_PASS_STATUS,0,1,0)))) lowToRate "
				+ " FROM IDM_CASE_INFORMATION c LEFT JOIN ");
		sqlBuilder.append("  (SELECT e.id,  e.STATUS_ID, s.CASE_PASS_STATUS FROM IDM_EVENT_INFO e LEFT JOIN IDM_STATUS_INFO s ON e.STATUS_ID  = s.id) d ");
		sqlBuilder.append("  ON c.IDM_ID = d.id ");
		sqlBuilder.append(" WHERE 1 = 1 ");
		sqlBuilder.append(" and to_char(c.MODIFY_SURVEY_DATE, 'yyyy/MM/dd') >= '" + beginDateStr + "' and  to_char(c.MODIFY_SURVEY_DATE, 'yyyy/MM/dd') <= '" + endDateStr + "'");
		sqlBuilder.append(" and c.MODIFY_SURVEY_ORG IS NOT NULL GROUP BY c.MODIFY_SURVEY_ORG");
		sqlBuilder.append("  ) i ON org.organ_code = i.MODIFY_SURVEY_ORG where org.status = '1') ");
		sqlBuilder.append(" select * from w  "); 
/*		%1$s*/
		
		/*sql=String.format(sql, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");*/
		SqlBuilder.buildWhereStatement(Organization.class, sqlBuilder, organizeCriteria(paramMap));
		return getMapList(sqlBuilder.toString(), organizeCriteria(paramMap));
	}
	
	private Criteria organizeCriteria(Map<String, String> paramMap) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return criteria;
		}
		/*String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(criteria, "surveyDate", beginDate,endDate);*/
       /* if (ObjectUtil.isNotEmpty(paramMap.get("gbcode"))) {
			criteria.add("gbcode", paramMap.get("gbcode"));
		}*/
		if(ObjectUtil.isNotEmpty(paramMap.get("organCode"))){//按机构查询
			criteria.add("organCode", paramMap.get("organCode"));
		}else if("B200".equals(paramMap.get("genreCode")) && ObjectUtil.isNotEmpty(paramMap.get("superOrganCode"))){//按站查询
			criteria.add("parentCode", paramMap.get("superOrganCode"));
		}else{//按医院和中心查询
			criteria.add("genreCode", paramMap.get("genreCode"));
		}
		if(ObjectUtil.isNotEmpty(paramMap.get("gbCode"))){
			criteria.add("gbCode", paramMap.get("gbCode"));
		}
		
        return criteria;
	}
}