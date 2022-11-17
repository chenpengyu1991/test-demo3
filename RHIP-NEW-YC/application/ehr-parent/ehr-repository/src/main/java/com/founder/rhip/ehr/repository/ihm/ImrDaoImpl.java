package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of 医疗服务
 * 
 */
@Repository("imrDao")
public class ImrDaoImpl extends	AbstractDao<InpatientMedicalRecord, Long> implements IImrDao {

    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String select_gb_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE";

    private static final String select_parent_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";

    private static final String select_organ_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    
    private static final String ORG_SQL="WITH ORGANIZATION AS("
    		+ " SELECT GB_CODE,PARENT_CODE,ORGAN_CODE,GENRE_CODE"
    		+ " FROM MDM_ORGANIZATION "
    		+ " %1$s )";

	//病案首页的信息
    private static final String IMR_INFO_SQL = ", IMR_INFO AS (SELECT * "
			+ " FROM RP_INPATIENT_MEDICAL_RECORD "
			+ " WHERE %6$s AND GATHER_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND GATHER_DATE<=TO_DATE('%3$s','yyyy/MM/dd') )";

    //诊断符合率信息
	private static final String HOSPITALIZE_INFO_SQL = ", HOSPITALIZE AS (SELECT ORGAN_CODE, CLINIC_DIAG_ACCORD_NUM, ADMIT_DIAG_ACCORD_NUM, OPERATE_ACCORD_NUM, INPATIENT_MEDICAL_RECORD_NUM "
			+ " FROM RP_HM_HOSPITALIZE "
			+ " WHERE %6$s AND CREATE_DATE >= TO_DATE('%2$s', 'yyyy/MM/dd') AND CREATE_DATE <= TO_DATE('%3$s', 'yyyy/MM/dd') ) ";

	private static final String IMR_FEE_SQL ="select %5$s, SUM(FEE_ALL) FEE_ALL, SUM(PATHOLOGY_FEE) PATHOLOGY_FEE,SUM(LAB_FEE) LAB_FEE, SUM(IMG_FEE) IMG_FEE, SUM(CLINICAL_FEE) CLINICAL_FEE "
			+ "	FROM ORGANIZATION ORG "
			+ " LEFT JOIN IMR_INFO ON IMR_INFO.ORGAN_CODE = ORG.ORGAN_CODE GROUP BY %4$s ";

	private static final String INCISION_SQL ="select %5$s, SUM(ONE_A) ONE_A, SUM(ONE_B) ONE_B,SUM(ONE_C) ONE_C, SUM(TWO_A) TWO_A, SUM(TWO_B) TWO_B, SUM(TWO_C) TWO_C, SUM(THREE_A) THREE_A, SUM(THREE_B) THREE_B, SUM(THREE_C) THREE_C "
			+ "	FROM ORGANIZATION ORG "
			+ " LEFT JOIN IMR_INFO ON IMR_INFO.ORGAN_CODE = ORG.ORGAN_CODE GROUP BY %4$s ";

	private static final String CONSISTENCY_SQL ="select %5$s, SUM(CLINIC_DIAG_ACCORD_NUM) CLINIC_DIAG_ACCORD_NUM, SUM(ADMIT_DIAG_ACCORD_NUM) ADMIT_DIAG_ACCORD_NUM, SUM(OPERATE_ACCORD_NUM) OPERATE_ACCORD_NUM, SUM(INPATIENT_MEDICAL_RECORD_NUM) INPATIENT_MEDICAL_RECORD_NUM "
			+ "	FROM ORGANIZATION ORG "
			+ " LEFT JOIN HOSPITALIZE ON HOSPITALIZE.ORGAN_CODE = ORG.ORGAN_CODE GROUP BY %4$s ";

	@Override
	public List<Map<String, Object>> getImrFeeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getImrFeeSql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getIncisionList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getIncisionSql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getConsistencyList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getConsistencySql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	}

	private String getImrFeeSql(String beginDate, String endDate, String genreCode, Criteria ca){
		StringBuilder sql = new StringBuilder(ORG_SQL + IMR_INFO_SQL + IMR_FEE_SQL);
		//机构条件
		StringBuilder orgWhere =  new StringBuilder();
		String expenseOrgWhere = "";
		//机构字段
		String orgField = getOrgField(genreCode,false);
		//SELECT字段
		String orgSelectField = getOrgField(genreCode,true);
		SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
		Object organCodeObj = ca.get("organ_Code");
		String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";
		Object gbCodeObj = ca.get("GB_CODE");
		String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
		Object parentCodeObj = ca.get("PARENT_CODE");
		String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";
		expenseOrgWhere =  " ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
		return String.format(sql.toString(), orgWhere.toString(), beginDate, endDate, orgField, orgSelectField, expenseOrgWhere);
	}

	private String getIncisionSql(String beginDate, String endDate, String genreCode, Criteria ca){
		StringBuilder sql = new StringBuilder(ORG_SQL + IMR_INFO_SQL + INCISION_SQL);
		//机构条件
		StringBuilder orgWhere =  new StringBuilder();
		String expenseOrgWhere = "";
		//机构字段
		String orgField = getOrgField(genreCode,false);
		//SELECT字段
		String orgSelectField = getOrgField(genreCode,true);
		SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
		Object organCodeObj = ca.get("organ_Code");
		String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";
		Object gbCodeObj = ca.get("GB_CODE");
		String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
		Object parentCodeObj = ca.get("PARENT_CODE");
		String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";
		expenseOrgWhere =  " ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
		return String.format(sql.toString(), orgWhere.toString(), beginDate, endDate, orgField, orgSelectField, expenseOrgWhere);
	}

	private String getConsistencySql(String beginDate, String endDate, String genreCode, Criteria ca){
		StringBuilder sql = new StringBuilder(ORG_SQL + HOSPITALIZE_INFO_SQL + CONSISTENCY_SQL);
		//机构条件
		StringBuilder orgWhere =  new StringBuilder();
		String expenseOrgWhere = "";
		//机构字段
		String orgField = getOrgField(genreCode,false);
		//SELECT字段
		String orgSelectField = getOrgField(genreCode,true);
		SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
		Object organCodeObj = ca.get("organ_Code");
		String organCode = ObjectUtil.isNotEmpty(organCodeObj)?organCodeObj.toString():"";
		Object gbCodeObj = ca.get("GB_CODE");
		String gbCode = ObjectUtil.isNotEmpty(gbCodeObj)?gbCodeObj.toString():"";
		Object parentCodeObj = ca.get("PARENT_CODE");
		String parentCode = ObjectUtil.isNotEmpty(parentCodeObj)?parentCodeObj.toString():"";
		expenseOrgWhere =  " ORGAN_CODE IN(" + getOrgSql(genreCode,gbCode,parentCode,organCode) + ")";
		return String.format(sql.toString(), orgWhere.toString(), beginDate, endDate, orgField, orgSelectField, expenseOrgWhere);
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
		return ca;
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

	private String getOrgSql(String genreCode, String gbCode, String parentCode, String organCode){
		StringBuilder result = new StringBuilder(" SELECT ORGAN_CODE FROM MDM_ORGANIZATION");
		result.append(" WHERE 1=1 ");
		if(StringUtil.isNotEmpty(genreCode) && !"0".equals(genreCode)){
			result.append(" AND GENRE_CODE = '" + genreCode + "'");
		}
		if(StringUtil.isNotEmpty(gbCode)){
			result.append(" AND GB_CODE = '" + gbCode + "'");
		}
		if(StringUtil.isNotEmpty(parentCode)){
			result.append(" AND PARENT_CODE = '" + parentCode + "'");
		}
		if(StringUtil.isNotEmpty(organCode)){
			result.append(" AND ORGAN_CODE = '" + organCode + "'");
		}
		return result.toString();
	}

}