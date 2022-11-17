package com.founder.rhip.ehr.repository.clinic;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.common.RpQueryConditionHelper;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

import javax.annotation.Resource;

/**
 * DAO implement of InpatientDrugUsage
 * 
 */
@Repository("drugUsageDao")
public class DrugUsageDaoImpl extends AbstractDao<DrugUsage, Long> implements IDrugUsageDao {
	
	private static final String DRUG_STATISTICS_SQL = "select * from(select %3$s "
			+ " from (select t.referral_hospital_code orgCode,t.drug_medicare_code,max(t.drug_generic_name)drugName,count(1)drugNum "
			+ " from ms_drug_usage t %1$s group by t.referral_hospital_code, t.drug_medicare_code) dt "
			+ " left join mdm_organization v on dt.orgCode=v.organ_code where 1=1 %2$s)";
	
    private static final String GET_RELATION_ORGAN_CODES_SQL=	"SELECT REFERRAL_HOSPITAL_CODE AS ORGANCODE FROM MS_DRUG_USAGE WHERE PERSON_ID=:personId GROUP BY MS_DRUG_USAGE.REFERRAL_HOSPITAL_CODE\n" +
			"UNION ALL\n" +
			"SELECT HOSPITAL_CODE AS ORGANCODE FROM MS_EXAMINE_EVENT WHERE PERSON_ID=:personId GROUP BY HOSPITAL_CODE\n" +
			"UNION ALL\n" +
			"SELECT HOSPITAL_CODE AS ORGANCODE FROM MS_STUDY_EVENT WHERE PERSON_ID=:personId GROUP BY HOSPITAL_CODE";
    /**
     * 更新SQL
     */
    private static final String UPDATE_SQL = " MERGE INTO MS_DRUG_USAGE D USING ("
    		+ " SELECT %1$s UPDATE_VALUE,%2$s FROM %3$s "
    		+ " ) P ON (%4$s)"
    		+ " WHEN MATCHED THEN"
    		+ " UPDATE SET D.DOCTOR_NO = P.UPDATE_VALUE"
    		+ " WHERE DOCTOR_NO IS NULL AND P.UPDATE_VALUE IS NOT NULL AND %5$s ";
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Override
	public List<String> getRelationOrganCodes(Long personId) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("personId", personId);
		List<String> result = simpleJdbcTemplate.getNamedParameterJdbcOperations().queryForList(GET_RELATION_ORGAN_CODES_SQL, parameterSource, String.class);
		if (ObjectUtil.isNullOrEmpty(result)) {
			return Collections.emptyList();
		}
		return result;
	}
    
    /**
     * 更新医生工号：门诊
     *
     * @return
     * @author Ye jianfei
     */
    @Override
    public int updateOutpatientDoctorNo(){
    	String sql = String.format(UPDATE_SQL,"PRESCRIBE_DOCTOR_NO","EHR_ID,RECORD_NUMBER","MS_OUTPATIENT_PRESCRIPTION","D.EHR_ID = P.EHR_ID AND D.RECORD_NUMBER= P.RECORD_NUMBER","D.RECORD_NUMBER IS NOT NULL");
    	return this.execute(sql);
    }

    /**
     * 更新医生工号：住院
     *
     * @return
     * @author Ye jianfei
     */
    @Override
    public int updateInpatientDoctorNo(){
    	String sql = String.format(UPDATE_SQL,"ATTENDING_PHYSICIAN_NO","EHR_ID","MS_INPATIENT_INFO","D.EHR_ID = P.EHR_ID","D.RECORD_NUMBER IS NULL");
    	return this.execute(sql);
    }
    
    /**
     * 获取本次需要更新的EHR_ID列表
     *
     * @param page
     * @param criteria
     * @return
     * @author Ye jianfei
     */
    @Override
    public PageList<DrugUsage> getEhrIdList(Page page,Criteria criteria){
    	StringBuilder sql= new StringBuilder("SELECT DISTINCT EHR_ID FROM MS_DRUG_USAGE");
    	SqlBuilder.buildWhereStatement(DrugUsage.class, sql, criteria) ;
    	return getPageList(page,sql.toString(),criteria);
    }
    
    public int batchUpdate(String sql) {
    	return this.execute(sql);
    }
    
    /**
     * 根据ehr_id区分是住院还是门诊来填充CLINIC_MARK
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
	public void updateClinicMark() {
		this.execute("update ms_drug_usage t set t.CLINIC_MARK = '1' where t.CLINIC_MARK is null and t.ehr_id like 'mz%'");
    	this.execute("update ms_drug_usage t set t.CLINIC_MARK = '3' where t.CLINIC_MARK is null and t.ehr_id like 'zy%'");
	}

	@Override
	public PageList<Map<String, Object>> getDrugMapPageList(Map<String, String> paramMap, Page page) {
		String genreCode = paramMap.get("genreCode");
        String drugType = paramMap.get("drugType");
		String beginDateStr = paramMap.get("beginDateA");
        String endDateStr = paramMap.get("endDateA");
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		Criteria criteria = new Criteria();
		if (StringUtils.equals(drugType, "1")) {
			criteria.add("antibacterialsFlag", "1");
		} else if (StringUtils.equals(drugType, "2")) {
			criteria.add("antibioticFlag", "1");
		} else if (StringUtils.equals(drugType, "3")) {
			criteria.add("narcoticFlag", "1");
		} else if (StringUtils.equals(drugType, "4")) {
			criteria.add("toxicFlag", "1");
		}
		DateUtil.getCriteriaByDateRange(criteria, "clinicDate", beginDate,endDate);
        StringBuilder conditionBuilder = new StringBuilder();
        SqlBuilder.buildWhereStatement(DrugUsage.class, conditionBuilder, criteria);
        StringBuilder organizationConditionBuilder = RpQueryConditionHelper.getOrganizationCondition(paramMap);
        String columnNames = "gb_code,organ_code,drug_medicare_code,drugName,drugNum";
        if (StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)) {
        	columnNames = "gb_code,center_code,organ_code,drug_medicare_code,drugName,drugNum";
		} 
        String sql = String.format(DRUG_STATISTICS_SQL, conditionBuilder.toString(), organizationConditionBuilder.toString(),columnNames);
		return getPageMapList(page, sql, criteria);
	}
}