package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.annotation.Resource;

/**
 * DAO implement of 居民体检分析
 * 
 */
@Repository("hmTargetDao")
public class HmTargetDaoImpl extends AbstractDao<HealthExamination, Long> implements IHmTargetDao {

    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String select_gb_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE";
    private static final String select_parent_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    private static final String select_organ_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    
    private static final String ORG_SQL="WITH mdm_organization_result AS("
    		+ " SELECT GB_CODE,PARENT_CODE,ORGAN_CODE,GENRE_CODE"
    		+ " FROM MDM_ORGANIZATION"
    		+ " %1$s )";//机构条件
 
    private static final String STATISTICS_SQL = " SELECT statistics.* FROM("
    		+ " SELECT %5$s"
    		+ " 		,SUM(COMMERCIAL) commercial"//商业体检
    		+ " 		,SUM(OLD_PEOPLE) oldPeople"//老年人健康体检
    		+ " 		,SUM(STUDENT) student"//学生体检
    		+ " 		,SUM(WOMEN) women"//妇女病体检
    		+ " 		,SUM(OCCUPATION) occupation"//职业健康体检
    		+ " 		,SUM(CHRONIC_DISEASE) chronicDisease"//慢病体检
    		+ " 		,SUM(HEALTH_CERTIFICATE) healthCertificate"//健康证体检
    		+ " 		,SUM(EMPLOYEE) employee"//托幼体检
    		+ " 		,SUM(OTHER) other"//其他体检
    		+ "			,SUM(EXAMINATION) examination"//合计
     		+ " FROM mdm_organization_result ORG"
    		+ " LEFT JOIN("
    		+ " 	SELECT HOSPITAL_CODE"
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.COMMERCIAL_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) COMMERCIAL"//商业体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) OLD_PEOPLE"//老年人健康体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.STUDENT_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) STUDENT"//学生体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.WOMEN_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) WOMEN"//妇女病体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.OCCUPATION_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) OCCUPATION"//职业健康体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) CHRONIC_DISEASE"//慢病体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.HEALTH_CERTIFICATE_EXAMINATION.getCode() + "',1,NULL)) HEALTH_CERTIFICATE"//健康证体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.EMPLOYEE_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) EMPLOYEE"//托幼体检
    		+ " 		,COUNT(DECODE(PHYSICAL_EXAM_TYPE,'" + EventType.OTHER_PHYSICAL_EXAMINATION.getCode() + "',1,NULL)) OTHER"//其他体检
    		+ "			,COUNT(1) EXAMINATION"
    		+ " 	FROM sy_ms_health_exam"
    		+ " 	WHERE (EXAMINATION_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND EXAMINATION_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) %6$s"
    		+ "		GROUP BY HOSPITAL_CODE"
    		+ " )health on org.ORGAN_CODE = health.HOSPITAL_CODE"
    		+ " GROUP BY %4$s) statistics";
 

    private String getPersonTimeSql(String beginDate
    		, String endDate
    		, String genreCode
    		, Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + STATISTICS_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	Object organCodeObj = ca.get("organ_Code");
    	String organCode = ObjectUtil.isNotEmpty(organCodeObj)?"AND HOSPITAL_CODE='" + organCodeObj.toString() + "'":"";
    	return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,organCode);
    }

    private String getOrgField(String genreCode,boolean isSelect){
    	String result = "";
    	switch(genreCode){
    		case "0":
    			result = isSelect?select_gb_code:"ROLLUP(GB_CODE)";
    			break;
    		case "B100":
    			result = isSelect?select_parent_code:"ROLLUP(GB_CODE,ORG.organ_code),parent_Code";
    			break;
    		case "B200":
    			result = isSelect?select_organ_code:"ROLLUP(GB_CODE,parent_Code,ORG.organ_Code)";
    			break;
    		case "A100":
    			result = isSelect?select_organ_code:"ROLLUP(GB_CODE,ORG.organ_code),parent_Code";
    			break;

    	}
    	return result;
    }
    
    private Criteria getOrgCriteria(String genreCode,String gbCode,String parentCode,String organCode){
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(genreCode) && (!"0".equals(genreCode))){
    		ca.add("genre_Code",genreCode);
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("gb_Code",gbCode);
    	}
    	if(StringUtil.isNotEmpty(parentCode)){
    		if(OrgGenreCode.STATION.getValue().equals(genreCode)){
    			ca.add("parent_Code",parentCode);
    		}else{
    			ca.add("organ_Code",parentCode);
    		}
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		ca.add("organ_Code",organCode);
    	}
    	ca.add("GB_CODE",OP.UEMPTY,"");
    	ca.add("parent_Code",OP.UEMPTY,"");
    	ca.add("organ_Code",OP.UEMPTY,"");
		ca.add("status","1");

		return ca;
    }
    
	
	@Override
	public List<Map<String, Object>> getPersonTimeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getPersonTimeSql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	} 
}