package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.Tuberculosis;
import com.founder.rhip.ehr.entity.basic.Populace;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Repository("tuberculosisDao")
public class TuberculosisDaoImpl extends AbstractDao<Tuberculosis, Long> implements ITuberculosisDao{
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String HEALTH_VIDEO_SQL = "SELECT NVL(SUM(T.REFERRAL_TB_NUM), 0) REFERRAL_TB_NUM, NVL(SUM(T.FOLLOW_UP_TUBERCULOSIS), 0) FOLLOW_UP_TUBERCULOSIS, NVL(SUM(T.TUBERC_NUM), 0) TUBERC_NUM, NVL(SUM(T.TUBERC_MANAGE_NUM), 0) TUBERC_MANAGE_NUM, NVL(SUM(T.TUBERC_CURE_NUM), 0) TUBERC_CURE_NUM, NVL(SUM(T.TUBERC_MEDICATION_NUM), 0) TUBERC_MEDICATION_NUM " +
			"FROM SR_TUBERCULOSIS T WHERE 1=1 %1$s";
	
	private static final String HOUSEHOLDSQL = "SELECT SUM(NVL(HOUSEHOLD_NUM, 0)+NVL(UN_HOUSE_HOLD_NUM, 0)) HOUSEHOLD_NUM " +
			"FROM BI_POPULACE WHERE 1=1 %s ";
	// 机构标识
		public static final String ORG_CODE = "orgCode";
		public static final String CENTER_ORG_CODE = "centerOrgCode";
		public static final String GBCODE = "gbcode";
		
		// 时间字段
		public static final String ACTIVE_TIME = "ACTIVE_TIME";
		public static final String RESOURCE_RECORD_TIME = "RESOURCE_RECORD_TIME";
		public static final String USE_TIME = "USE_TIME";
		public static final String ISSUE_TIME = "ISSUE_TIME";
		public static final String CREATE_TIME = "CREATE_TIME";
	
	@Override
	public Tuberculosis getTuberculosis(Criteria criteria) {
		String gbcode=(String) criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildOrganCondition("T.GB_CODE", "T.CENTER_ORG_CODE","T.ORG_CODE","T.YEAR", 
				criteria.get("year").toString(),gbcode,centerOrgCode,orgCode,where, sqlParameterSource,null,null,null);
		String finalSql = String.format(HEALTH_VIDEO_SQL, where.toString());
		
		return get(Tuberculosis.class, finalSql.toString(), sqlParameterSource);
	}
	
	@Override
	public Tuberculosis getTuberculosisSum(Criteria criteria, List<String> organCodeList) {
		String gbcode=(String) criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildOrganCondition("T.GB_CODE", "T.CENTER_ORG_CODE","T.ORG_CODE","T.YEAR", 
				criteria.get("year").toString(),gbcode,"",orgCode,where, sqlParameterSource,organCodeList,"T.MONTH",month);
		String finalSql = String.format(HEALTH_VIDEO_SQL, where.toString());
		
		return get(Tuberculosis.class, finalSql.toString(), sqlParameterSource);
	}
	
	@Override
	public Populace getPopulace(Criteria criteria, List<String> organCodeList) {
		String gbcode=(String) criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildOrganCondition("GBCODE", "ORGAN_PARENT_CODE","ORGAN_CODE","COUNT_YEAR", 
				criteria.get("year").toString(),gbcode,"",orgCode,where, sqlParameterSource, organCodeList, null, null);
		String finalSql = String.format(HOUSEHOLDSQL, where.toString());
		
		return get(Populace.class, finalSql.toString(), sqlParameterSource);
	}
	
	
	private void buildOrganCondition(String gbcodeColumn, String organColumn,String orgCodeColumn,String yearColumn,String year, String gbcode, 
			String centerCode,String orgCode, StringBuilder where, MapSqlParameterSource sqlParameterSource,List<String>organCodeList,String monthColumn,String month) {
		if(ObjectUtil.isNotEmpty(orgCode) && organCodeList==null){
			where.append(" AND ").append(orgCodeColumn).append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		}else{
			if(ObjectUtil.isNotEmpty(organCodeList)){
				where.append(" AND ").append(orgCodeColumn).append(" IN (:createOrgCode)");
				sqlParameterSource.addValue("createOrgCode", organCodeList);
			}
			
			if(ObjectUtil.isNotEmpty(month)){
				where.append(" AND ").append(monthColumn).append(" =:month");
				sqlParameterSource.addValue("month", month);
			}
		}
		
		
		if (ObjectUtil.isNotEmpty(centerCode)) {
			if(centerCode.split(",").length>1){
				centerCode=centerCode.replace("'", "");
				List<String> centerCodeList=new ArrayList<>();
				for (int i = 0; i < centerCode.split(",").length; i++) {
					centerCodeList.add(centerCode.split(",")[i]);
				}
				
				where.append(" AND ").append(orgCodeColumn).append(" IN (:createOrganCode)");
				sqlParameterSource.addValue("createOrganCode", centerCodeList);
			}else{
				where.append(" AND ").append(organColumn).append("=:createOrganCode");
				sqlParameterSource.addValue("createOrganCode", centerCode);
			}
			
		}
		if (ObjectUtil.isNotEmpty(gbcode)) {
			where.append(" AND ").append(gbcodeColumn).append(" =:createGbcode");
			sqlParameterSource.addValue("createGbcode", gbcode);
		}
		
		if(ObjectUtil.isNotEmpty(year)==true){
			where.append(" AND  " + yearColumn).append("=:year");
			sqlParameterSource.addValue("year", year);
		}
		
	}

}
