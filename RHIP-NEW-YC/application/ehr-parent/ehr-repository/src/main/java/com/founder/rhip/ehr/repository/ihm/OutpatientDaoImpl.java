package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;

@Repository("outpatientDao")
public class OutpatientDaoImpl extends	AbstractDao<HmOutpatient, Long> implements IOutpatientDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String CHECK_OUTPATIENT_SQL = "WITH ORG AS(\n" +
			"			SELECT  ORGAN_CODE FROM MDM_ORGANIZATION\n" +
			"			%1$s\n" +
			"			GROUP BY ORGAN_CODE\n" +
			"		)\n" +
			"			SELECT\n" +
			"				ORG.ORGAN_CODE,\n" +
			"				SUM(OUTPATIENT_OPERATION_FEE) OUTPATIENT_OPERATION_FEE,--门诊手术收入\n" +
			"				SUM(EMERGENCY_OPERATION_FEE) EMERGENCY_OPERATION_FEE,--急诊手术收入\n" +
			"				SUM(IN_HOS_OPERATION_FEE) IN_HOS_OPERATION_FEE--住院手术收入\n" +
			"				FROM ORG\n" +
			"				LEFT JOIN (\n" +
			"					SELECT  ORGAN_CODE,\n" +
			"									OUTPATIENT_OPERATION_FEE,--门诊手术收入\n" +
			"									EMERGENCY_OPERATION_FEE,--急诊手术收入\n" +
			"									0 as IN_HOS_OPERATION_FEE--住院手术收入\n" +
			"					FROM RP_HM_OUTPATIENT\n %2$s " +
			"                   UNION ALL\n" +
			"					SELECT  ORGAN_CODE,\n" +
			"									0 as OUTPATIENT_OPERATION_FEE,--门诊手术收入\n" +
			"									0 as EMERGENCY_OPERATION_FEE,--急诊手术收入\n" +
			"									IN_HOS_OPERATION_FEE--住院手术收入\n" +
			"					FROM RP_HM_HOSPITALIZE %2$s  \n" +
			
			"				) exam on ORG.ORGAN_CODE = exam.ORGAN_CODE\n" +
			"			GROUP BY rollup(ORG.ORGAN_CODE)\n" ;
	
	@Override
	public List<Map<String, Object>> getOutpatients(Map<String, String> paramMap) {
		String sql = getSql(paramMap,CHECK_OUTPATIENT_SQL);
		return this.getMapList(sql,new Criteria());
	}

	protected String getSql(Map<String, String> paramMap,String sqlDefine){
		String orgWhereSql = getOrgWhereSql(paramMap);
		String businessSql = getBusinessWhereSql(paramMap);
		return String.format(sqlDefine,orgWhereSql,businessSql);
	}

	/**
	 * 获得日期条件
	 */
	private String getBusinessWhereSql(Map<String,String> paramMap){
		StringBuilder result = new StringBuilder("WHERE 1 = 1");
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		if(StringUtil.isNotEmpty(beginDate)){
			result.append(" AND CREATE_DATE >= TO_DATE('" +beginDate + " 00:00:00', 'YYYY/MM/DD HH24:MI:SS')\n");
		}
		if(StringUtil.isNotEmpty(beginDate)){
			result.append(" AND CREATE_DATE <= TO_DATE('" +endDate + " 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n");
		}
		return result.toString();
	}



	/**
	 * 获得机构条件
	 * @param paramMap
	 * @return
	 */
	private String getOrgWhereSql(Map<String, String> paramMap){
		StringBuilder result = new StringBuilder(" WHERE 1=1 ");

		String genreCode = paramMap.get("genreCode");
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
		String organCode = paramMap.get("organCode");//站
		String gbCode = paramMap.get("gbCode");
		if(StringUtil.isNotEmpty(genreCode)){
			result.append(" AND GENRE_CODE = '" + genreCode + "'\n");
		}
		if(StringUtil.isNotEmpty(gbCode)){
			result.append(" AND GB_CODE = '"+gbCode+"' ");
		}
		if(("A100".equals(genreCode) ||"B100".equals(genreCode)) && StringUtil.isNotEmpty(superOrganCode)){
			result.append(" AND ORGAN_CODE = '"+superOrganCode+"'");
		}
		if("B200".equals(genreCode) ){
			if(StringUtil.isNotEmpty(superOrganCode)){
				result.append(" AND PARENT_CODE = '"+superOrganCode+"'");
			}
			if(StringUtil.isNotEmpty(organCode)){
				result.append(" AND ORGAN_CODE = '"+organCode+"'");
			}
		}
		return result.toString();
	}
}