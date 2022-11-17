package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.VaccinationService;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of HaStatistics
 * 
 */
@Repository("healthVaccinationDao")
public class HealthVaccinationDaoImpl extends AbstractDao<VaccinationService, Long> implements IHealthVaccinationDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private static final String HEALTH_VIDEO_SQL = "select nvl(SUM(t.certificate_should_num),0)certificate_should_num,nvl(SUM(t.certificate_has_num),0)certificate_has_num,nvl(SUM(t.suspected_certificate_num),0)suspected_certificate_num,nvl(SUM(t.hepatitis_should_num),0)hepatitis_should_num,nvl(SUM(t.hepatitis_has_num),0)hepatitis_has_num,nvl(SUM(t.bcg_should_num),0)bcg_should_num,nvl(SUM(t.bcg_has_num),0)bcg_has_num,nvl(SUM(t.polio_should_num),0)polio_should_num,nvl(SUM(t.polio_has_num),0)polio_has_num,nvl(SUM(t.dpt_should_num),0)dpt_should_num,nvl(SUM(t.dpt_has_num),0)dpt_has_num,nvl(SUM(t.white_vaccine_should_num),0)white_vaccine_should_num,nvl(SUM(t.white_vaccine_has_num),0)white_vaccine_has_num,nvl(SUM(t.leprosy_should_num),0)leprosy_should_num,nvl(SUM(t.leprosy_has_num),0)leprosy_has_num,nvl(SUM(t.measles_should_num),0)measles_should_num,nvl(SUM(t.measles_has_num),0)measles_has_num,nvl(SUM(t.ameningococcal_should_num),0)ameningococcal_should_num,nvl(SUM(t.ameningococcal_has_num),0)ameningococcal_has_num,nvl(SUM(t.acmeningococcal_should_num),0)acmeningococcal_should_num,nvl(SUM(t.acmeningococcal_has_num),0)acmeningococcal_has_num,nvl(SUM(t.encephalitis_should_num),0)encephalitis_should_num,nvl(SUM(t.encephalitis_has_num),0)encephalitis_has_num,nvl(SUM(t.hav_should_num),0)hav_should_num,nvl(SUM(t.hav_has_num),0)hav_has_num,nvl(SUM(t.MEASLESCONSTIT_SHOULD_NUM), 0)MEASLESCONSTIT_SHOULD_NUM, nvl(SUM(t.MEASLESCONSTIT_HAS_NUM), 0)MEASLESCONSTIT_HAS_NUM from SR_VACCINATION_SERVICE t WHERE 1=1 %1$s";
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
	public VaccinationService getVaccinationService(Criteria criteria) {
		// TODO Auto-generated method stub
	/*	StringBuilder sqlBuilder = new StringBuilder(HEALTH_VIDEO_SQL).append(organizeDateStatisticsSQL(criteria, ISSUE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);*/
		String gbcode=(String) criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildOrganCondition("t.GB_CODE", "t.CENTER_ORG_CODE","t.ORG_CODE","t.year", 
				criteria.get("year").toString(),gbcode,centerOrgCode,orgCode,where, sqlParameterSource,null,null,null);
		String finalSql = String.format(HEALTH_VIDEO_SQL, where.toString());
		
		return get(VaccinationService.class, finalSql, sqlParameterSource);
	}
	@Override
	public VaccinationService getVaccinationServiceSum(Criteria criteria,List<String>organCodeList) {
		String gbcode=(String) criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		StringBuilder where = new StringBuilder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		buildOrganCondition("t.GB_CODE", "t.CENTER_ORG_CODE","t.ORG_CODE","t.year", 
				criteria.get("year").toString(),gbcode,centerOrgCode,orgCode,where, sqlParameterSource,organCodeList,"t.month",month);
		String finalSql = String.format(HEALTH_VIDEO_SQL, where.toString());
		
		return get(VaccinationService.class, finalSql, sqlParameterSource);
	}
	private void buildOrganCondition(String gbcodeColumn, String organColumn,String orgCodeColumn,String yearColumn,String year, String gbcode, 
			String centerCode,String orgCode, StringBuilder where, MapSqlParameterSource sqlParameterSource,List<String>organCodeList,String monthColumn,String month) {
		if(ObjectUtil.isNotEmpty(orgCode) && organCodeList==null){
			where.append(" AND ").append(orgCodeColumn).append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		}else{
			if(ObjectUtil.isNotEmpty(organCodeList)){
				where.append(" AND ").append(orgCodeColumn).append(" in(:createOrgCode)");
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
				
				where.append(" AND ").append(orgCodeColumn).append(" in(:createOrganCode)");
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
			where.append(" AND  "+yearColumn).append("=:year");
			sqlParameterSource.addValue("year", year);
		}
		
	}
	
	/**
	 * 组织不同机构类别查询条件
	 * @param criteria
	 * @return
	 */
	private String organizeOrganizationSQL(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder();
		if (criteria.contains("orgCode")) {
			sqlBuilder.append(" AND ORG_CODE ='");
			sqlBuilder.append(String.valueOf(criteria.get("orgCode")));
			sqlBuilder.append("'");
		} else if (criteria.contains("centerOrgCode")) {
			sqlBuilder.append(" AND ORG_CODE in (");
			sqlBuilder.append(String.valueOf(criteria.get("centerOrgCode")));
			sqlBuilder.append(")");
		} else if (criteria.contains("gbcode")) {
			sqlBuilder.append(" AND GBCODE ='");
			sqlBuilder.append(String.valueOf(criteria.get("gbcode")));
			sqlBuilder.append("'");
		}
		return sqlBuilder.toString();
	}

	public int getAllNum(Criteria criteria){
        StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select NVL(sum(CERTIFICATE_HAS_NUM),0) num FROM SR_VACCINATION_SERVICE ");
		if(criteria.contains("year")){
			int year = Integer.valueOf(criteria.get("year").toString());
			stringBuilder.append("where year = "+year+"");
		}
        Map<String,Object> map = this.getMap(stringBuilder.toString(),criteria);
		return Integer.valueOf(map.get("num").toString());
	};
}