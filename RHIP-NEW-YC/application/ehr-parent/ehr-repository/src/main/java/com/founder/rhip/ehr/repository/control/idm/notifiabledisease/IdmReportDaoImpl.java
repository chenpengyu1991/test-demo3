package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of DcInfectionDiseaseReport
 * 
 */
@Repository("idmReportDao")
public class IdmReportDaoImpl extends AbstractDao<IdmReport, Integer> implements IIdmReportDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<IdmReport> getReportRecord(Page page, Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
				"VALID_CASE_STATUS,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID," +
				"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
				"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
		sql.append(" FROM IDM_REPORT D " );
		sql.append(" LEFT JOIN " );
		sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
        sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
        sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
		SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");
		
		return this.getPageList(page, sql.toString(), criteria);				
	}

	@Override
	public List<IdmReport> getReportRecord(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
				"VALID_CASE_STATUS,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID," +
				"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
				"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
		sql.append(" FROM IDM_REPORT D " );
		sql.append(" LEFT JOIN " );
		sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
		sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
		sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
		SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");

		return this.getList(sql.toString(), criteria);
	}

    public PageList<IdmReport> getFrList(Page page, Criteria criteria) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT S.STATUS_ID, D.IDM_ID, D.NAME, D.GENDER, D.BIRTHDAY,D.IDCARD, D.AGE, D.PARENTS_NAME, D.PHONE_NUMBER, D.PA_ADDRESS, D.PATHOGENESIS_DATE, D.DIAGNOSIS_DATE, D.FILL_ORGAN_CODE, D.FILL_ORGAN_NAME,S.FR_STATUS, S.LOGOFF,  ");
        sql.append(" F.NAME AS nameF, F.GENDER AS genderF, F.AGE AS ageF, F.PARENTS_NAME AS parentsNameF, F.PHONE_NUMBER AS phoneNumberF, F.PA_ADDRESS AS paAddressF, F.ATTACK_DT , F.TREATMENT_DT, F.TREATMENT_UNIT, F.IN_HOSPITAL, F.VISIT_INST ");
        sql.append(" FROM IDM_REPORT D " );
        sql.append(" LEFT JOIN " );
        sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
        sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
        sql.append(" LEFT JOIN " );
        sql.append(" (select IDM_ID, NAME, GENDER, AGE, PARENTS_NAME, PHONE_NUMBER, PA_ADDRESS, ATTACK_DT, TREATMENT_DT, TREATMENT_UNIT, IN_HOSPITAL ,VISIT_INST from IDM_LIST_FR t1 where t1.id in (select max(t2.id) from IDM_LIST_FR t2 where t1.IDM_ID = t2.IDM_ID)) F ");
        sql.append(" ON S.SINGLE_ID = F.IDM_ID ");
        SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria);
        sql.append(" and ( assignment_status ='2' or assignment_status is null ) ");
        SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC ");
        return this.getPageList(page, sql.toString(), criteria);
    }

    public void updatePaAddress2(String paStreet, String townName, String villageName){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE IDM_REPORT SET PA_ADDRESS = '"+townName+villageName+"'||PAHOUSE_NUMBER");
//        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append(" WHERE PASTREET = " + "'" + paStreet + "'");
        this.execute(sql.toString());
    }
    
    @Override
	public List<IdmReport> getReportRecordTable(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
				"INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID," +
				"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
				"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
		sql.append(" FROM IDM_REPORT D " );
		sql.append(" LEFT JOIN " );
		sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
        sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
        sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
		SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");
		return this.getList(sql.toString(), criteria);	
    }
  /*  @Override
    public List<Map<String, Object>> getExportTableMap(Criteria criteria){
    	String sql = "";
    	return this.getMapList(sql, criteria);
    }*/
    
	@Override
	public PageList<IdmReport> getRepeatCases(Page page, Criteria criteria, String conditions) {
		StringBuilder sql = new StringBuilder();
		sql.append(" WITH AA as (");
		sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,BIRTHDAY,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
				"VALID_CASE_STATUS ,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID," +
				"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
				"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
		sql.append(" FROM IDM_REPORT D " );
		sql.append(" LEFT JOIN " );
		sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
        sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
        sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
		SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");
		sql.append(" ) ");
		sql.append(" select * from AA INNER JOIN ( select " + conditions + " from AA group by " + conditions + " having count(*)>1 ) BB ON ");
        String[] sourceStrArray = conditions.split(",");
        for (int i = 0; i < sourceStrArray.length; i++) {
        	sql.append( " AA." + sourceStrArray[i] + " = BB." + sourceStrArray[i] );
        	if(i != sourceStrArray.length - 1){
        		sql.append(" and ");
        	}
        }
        sql.append(" ORDER BY AA.NAME , FILL_DATE DESC ");   
		/*select * from AA INNER JOIN (select INFECTIOUS_CODE from AA group by INFECTIOUS_CODE  having count(*)>1) BB ON AA.INFECTIOUS_CODE = BB.INFECTIOUS_CODE  ORDER BY FILL_DATE DESC */
	       
		return this.getPageList(page, sql.toString(), criteria);	
		
	}
	
	@Override
	public PageList<IdmReport> getReportRecordList(Page page, Criteria criteria) {
		//2017/4/1修改  传染病上报报卡审核中心可见自己及所管辖站，医院，站只能看自己，疾控不审核报卡，但可见所有的报卡
		StringBuilder sql = new StringBuilder();
		if(!criteria.contains("role")){
			sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
					"VALID_CASE_STATUS,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID, CURRENT_DIAGNOSIS_TIME,  CURRENT_FILL_TIME,  " +
					"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
					"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
			sql.append(" FROM IDM_REPORT D " );
			sql.append(" LEFT JOIN " );
			sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
	        sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
	        sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
			SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
			SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");
			
		} else {
			criteria.remove("role");
			sql.append(" with O as (select * from mdm_organization where PARENT_CODE='" +criteria.get("currentCenterCode") + "' or ORGAN_CODE='" +criteria.get("currentCenterCode") + "' ) , R AS (  ");
			criteria.remove("currentCenterCode");
			sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
					"VALID_CASE_STATUS,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID,  CURRENT_DIAGNOSIS_TIME,  CURRENT_FILL_TIME, " +
					"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
					"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
			sql.append(" FROM IDM_REPORT D " );
			sql.append(" LEFT JOIN " );
			sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
	        sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
	        sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
			SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
			SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");
			sql.append(" ) SELECT R.* , O.* FROM R LEFT JOIN O ON R.FILL_ORGAN_CODE =  O.ORGAN_CODE WHERE  O.ORGAN_CODE IS NOT NULL ");
		}	
		return this.getPageList(page, sql.toString(), criteria);				
	}
	@Override
	public List<IdmReport> getReportRecordList(Criteria criteria) {
		//2017/4/1修改  传染病上报报卡审核中心可见自己及所管辖站，医院，站只能看自己，疾控不审核报卡，但可见所有的报卡
		StringBuilder sql = new StringBuilder();
		if(!criteria.contains("role")){
			sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
					"VALID_CASE_STATUS,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID," +
					"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
					"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
			sql.append(" FROM IDM_REPORT D " );
			sql.append(" LEFT JOIN " );
			sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
			sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
			sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
			SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
			SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");

		} else {
			criteria.remove("role");
			sql.append(" with O as (select * from mdm_organization where PARENT_CODE='" +criteria.get("currentCenterCode") + "' or ORGAN_CODE='" +criteria.get("currentCenterCode") + "' ) , R AS (  ");
			criteria.remove("currentCenterCode");
			sql.append(" SELECT D.ID,D.IDM_ID,D.DELETE_CONTENT,D.DELETE_CONTENT_OTHER,NAME,IDCARD,GENDER,AGE,AGE_UNIT,INFECTIOUS_NAME," +
					"VALID_CASE_STATUS,INFECTIOUS_CODE,INFECTIOUS_TYPE,CASE_CATEGORY,PATHOGENESIS_DATE,DIAGNOSIS_DATE,PA_ADDRESS,S.STATUS_ID," +
					"S.REPORT_STATUS,FILL_DATE,FILL_ORGAN_CODE,FILL_ORGAN_NAME,OCCUPATION,S.CASE_STATUS,S.IDM_TYPE,S.SPECIAL_STATUS," +
					"S.FR_STATUS,S.TS_STATUS, S.LOGOFF,  C. MODIFY_SURVEY_ORG , REPORT_SOURCE, ASSIGNMENT_STATUS, ASSIGNED_TO_UNIT ,CURRENT_UNIT");
			sql.append(" FROM IDM_REPORT D " );
			sql.append(" LEFT JOIN " );
			sql.append(" (SELECT A.ID AS SINGLE_ID,A.STATUS_ID, B.* FROM  IDM_EVENT_INFO A, IDM_STATUS_INFO B WHERE (B.IS_DELETE IS NULL OR B.IS_DELETE=0) AND A.STATUS_ID = B.ID(+)) S " );
			sql.append(" ON S.SINGLE_ID = D.IDM_ID " );
			sql.append(" LEFT JOIN IDM_CASE_INFORMATION C ON S.SINGLE_ID = C.IDM_ID " );
			SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria) ;
			SqlBuilder.buildOrderStatement(sql, "S.LOGOFF, REPORT_STATUS ASC,S.CASE_STATUS ASC,FILL_DATE DESC, IDM_ID DESC ");
			sql.append(" ) SELECT R.* , O.* FROM R LEFT JOIN O ON R.FILL_ORGAN_CODE =  O.ORGAN_CODE WHERE  O.ORGAN_CODE IS NOT NULL ");
		}
		return this.getList(sql.toString(), criteria);
	}
	
	@Override
	public List<Map<String, Object>> getDiseaseStatistic(Criteria criteria){
		
		
		/*WITH 
		   ORG_RESULT AS(SELECT CASE 
					      WHEN genre_code = 'B100' THEN organ_code
					      WHEN genre_code = 'B200' THEN parent_code
					      ELSE '-1' END parent_code, organ_code, genre_code,sort
					  FROM mdm_organization WHERE genre_code IN ('A100', 'B100', 'B200','J100') ORDER BY sort),
		  INFECTIOUS_NUM_RECORD AS
		    (SELECT FILL_ORGAN_CODE,
				NVL(SUM(DECODE(INFECTIOUS_code, '101', nums)),0) "101",
				NVL(SUM(DECODE(INFECTIOUS_code, '102', nums)),0) "102"
			FROM  
				(SELECT FILL_ORGAN_CODE ,
					INFECTIOUS_code, COUNT(*) AS nums
				FROM idm_report GROUP BY (FILL_ORGAN_CODE, INFECTIOUS_code )
			)  m GROUP BY rollup(FILL_ORGAN_CODE) ) 

		  select final_result.*, sort, genre_code, genre_code from (
				SELECT DECODE(grouping_id(parent_code, organ_code),3,'合计',parent_code) parent_code,organ_code,
				nvl(sum("101"), 0) "101", nvl(sum("102"), 0) "102" 
				FROM ORG_RESULT
				LEFT JOIN  INFECTIOUS_NUM_RECORD ON organ_code = FILL_ORGAN_CODE
				GROUP BY rollup(parent_code, organ_code)
				order by parent_code, organ_code ) final_result
				left join ORG_RESULT on final_result.organ_code = ORG_RESULT.organ_code
				order by sort*/

		/*List<String> tds = (List<String>)criteria.get("tds");
		String fillOrganCode = (String)criteria.get("ORGAN_CODE");
		criteria.remove("ORGAN_CODE");
		criteria.remove("tds");
		StringBuilder sql =  new StringBuilder();
		sql.append("   with m as ( select org.gb_code, org.parent_code, org.organ_code, r.*"
				+ " from mdm_organization org "
				+ " left join (select FILL_ORGAN_CODE,INFECTIOUS_code, count(*) as nums from idm_report ");	
		SqlBuilder.buildWhereStatement(IdmReport.class, sql, criteria);
		sql.append(" group by FILL_ORGAN_CODE, INFECTIOUS_code) r on r.FILL_ORGAN_CODE =org.organ_code  ");
		sql.append(" where org.organ_code in (" + fillOrganCode + ") )");
		sql.append(" select organ_code, ");
		for(int i=0; i<tds.size(); i++){
			sql.append("NVL(sum(decode(INFECTIOUS_code, '" + tds.get(i)  + "', nums)),0)  \""  + tds.get(i) +"\",");
		}
		String lastSql = sql.substring(0, sql.length()-1) +  " from m group by rollup(organ_code) ";
		return this.getMapList(lastSql, criteria);*/
		//2017-9-22 修改   机构的一级标签：医院和中心（中心=中心+下属站）
		List<String> tds = (List<String>)criteria.get("tds");
		StringBuffer sql = new StringBuffer("WITH ORG_RESULT AS(SELECT CASE \n" +
				"      WHEN genre_code = 'B100' THEN organ_code\n" +
				"      WHEN genre_code = 'B200' THEN parent_code\n" +
				"      ELSE '-1' END parent_code, organ_code, genre_code,sort\n" +
				"  FROM mdm_organization WHERE genre_code IN ('A100', 'B100', 'B200','J100')"  +
				" ORDER BY sort),\n" );
	    sql.append("  INFECTIOUS_NUM_RECORD AS ( SELECT FILL_ORGAN_CODE ");
		for(int i=0; i<tds.size(); i++){
			sql.append(", NVL(sum(decode(INFECTIOUS_code, '" + tds.get(i)  + "', nums)),0)  \""  + tds.get(i) +"\" ");
		}
		sql.append(" FROM  (SELECT FILL_ORGAN_CODE ,INFECTIOUS_code, COUNT(*) AS nums FROM idm_report where 1=1");

		if(ObjectUtil.isNotEmpty(criteria.get("fillBeginDate"))) {
			sql.append(" and to_char(FILL_DATE, 'yyyy/mm/dd') >= '"+ criteria.get("fillBeginDate").toString() + "'");
		}
		if(ObjectUtil.isNotEmpty(criteria.get("fillEndDate"))) {
			sql.append(" and to_char(FILL_DATE, 'yyyy/mm/dd') <= '"+ criteria.get("fillEndDate").toString() + "'");
		}
		sql.append(" GROUP BY (FILL_ORGAN_CODE, INFECTIOUS_code ) )   GROUP BY rollup(FILL_ORGAN_CODE) )");
			
		sql.append(" select final_result.*, sort, genre_code, genre_code from ( "
				 + " SELECT DECODE(grouping_id(parent_code, organ_code),3,'合计',parent_code) parent_code,organ_code " );
		for(int i=0; i<tds.size(); i++){
			sql.append(", NVL(sum(\"" + tds.get(i)  + "\"), 0) \""  + tds.get(i) +"\" ");
		}
		sql.append(" FROM ORG_RESULT LEFT JOIN  INFECTIOUS_NUM_RECORD ON organ_code = FILL_ORGAN_CODE GROUP BY rollup(parent_code, organ_code) order by parent_code, organ_code ) final_result ");
		sql.append(" left join ORG_RESULT on final_result.organ_code = ORG_RESULT.organ_code order by sort ");
	  
		return this.getMapList(sql.toString(), new Criteria());
		
	}

	@Override
	public void updateHrAddress2(String hrStreet, String townName, String villageName){
		StringBuilder sql =  new StringBuilder();
		sql.append("UPDATE IDM_REPORT SET HR_ADDRESS = '"+townName+villageName+"'||HRHOUSE_NUMBER");
//	        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
		sql.append(" WHERE HRSTREET = " + "'" + hrStreet + "'");
		this.execute(sql.toString());
	}
}