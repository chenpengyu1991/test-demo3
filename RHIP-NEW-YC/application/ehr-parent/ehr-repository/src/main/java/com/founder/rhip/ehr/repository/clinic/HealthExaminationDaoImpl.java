package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HealthExamination
 * 
 */
@Repository("healthExaminationDao")
public class HealthExaminationDaoImpl extends AbstractDao<HealthExamination, Long> implements IHealthExaminationDao {
	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String HEALTH_EXAMINATION_PA_STATISTICS_SQL = "select hospital_code,to_char(examination_date, 'yyyy/MM/dd') rpDate,"
			+ " sum(decode(PHYSICAL_EXAM_TYPE,'32',1,0))commercial_examine_num,sum(decode(PHYSICAL_EXAM_TYPE,'31',1,0))old_examine_num,"
			+ " sum(decode(PHYSICAL_EXAM_TYPE,'33',1,0))student_examine_num,sum(decode(PHYSICAL_EXAM_TYPE,'34',1,0))women_examine_num,"
			+ " sum(decode(PHYSICAL_EXAM_TYPE,'35',1,0))occupation_examine_num,sum(decode(PHYSICAL_EXAM_TYPE,'39',1,0))chronic_disease_examine_num,"
			+ " sum(decode(PHYSICAL_EXAM_TYPE,'36',1,0))health_certificate_examine_num,sum(decode(PHYSICAL_EXAM_TYPE,'37',1,0))childcare_worker_examine_num,"
			+ " sum(decode(PHYSICAL_EXAM_TYPE,'9',1,0))other_examine_num,count(1)total_examine_num"
			+ " from MS_HEALTH_EXAMINATION %1$s group by hospital_code,to_char(examination_date, 'yyyy/MM/dd')";

	/**
	 * 获取体检关系列表
	 */
	@Override
	public PageList<HealthExamination> getHealthExaminations(Criteria criteria, Page page) {
		StringBuilder sql = new StringBuilder("SELECT T1.ID,T1.NAME,T1.AGE,T1.EXAMINATION_DATE,T1.EXAMINATION_ORGAN_NAME " + " FROM MS_PHYSIQUE_EXAMINATION T1 "
				+ " LEFT JOIN SY_MEID_BI_PERSON_INFO T2 " + " ON T1.PERSON_ID = T2.ID ");
		SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "T1.EXAMINATION_DATE DESC");
		PageList<HealthExamination> healthExaminations = this.getPageList(page, sql.toString(), criteria);
		return healthExaminations;
	}

	@Override
	public HealthExamination getMaxExamDate(Criteria criteria) {
		StringBuilder sql = new StringBuilder("SELECT MAX(EXAMINATION_DATE) EXAMINATION_DATE FROM MS_HEALTH_EXAMINATION ");
		SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
		return this.get(sql.toString(), criteria);
	}

    @Override
    public HealthExamination getLastHealthExamination(Criteria criteria) {
        StringBuilder sql = new StringBuilder("SELECT ROW_.* FROM ( SELECT * FROM MS_HEALTH_EXAMINATION ");
        SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
        SqlBuilder.buildOrderStatement(sql, "EXAMINATION_DATE DESC NULLS LAST ");
        sql.append(") ROW_  WHERE 	ROWNUM = 1 ");
        return this.get(sql.toString(), criteria);
    }

	@Override
	public HealthExamination getHealthExamination(String year, Long personId, String type) {
		if (StringUtil.isNullOrEmpty(year) || ObjectUtil.isNullOrEmpty(personId) || StringUtil.isNullOrEmpty(type)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MS_HEALTH_EXAMINATION")
				.append(" WHERE PERSON_ID = " + personId)
				.append(" AND PHYSICAL_EXAM_TYPE = '" + type + "'")
				.append(" AND TO_CHAR(EXAMINATION_DATE, 'YYYY') = '" + year + "'");
		return get(sql.toString(), null);
	}
    
	@Override
	public PageList<HealthExamination> getAnalyzeHealthExaminations(Page page,Criteria criteria,Order order ) {
		Object weigth = criteria.get("he_weigth");
		Object hepatitisB = criteria.get("he_hepatitisB");
		StringBuilder sql = new StringBuilder(" SELECT * FROM MS_HEALTH_EXAMINATION health");
		criteria.remove("he_weigth");
		criteria.remove("he_hepatitisB");
		SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
		if(ObjectUtil.isNotEmpty(weigth)){
			sql.append( " AND ( EXISTS(");
			sql.append(getObservationInfoSql(weigth.toString()));
			sql.append( " )");
		}
		if(ObjectUtil.isNotEmpty(hepatitisB)){
			sql.append( " OR  EXISTS(");
			sql.append(getExamineDetailSql(hepatitisB.toString()));
			sql.append( " )");
		}
		if(ObjectUtil.isNotEmpty(weigth)){
			sql.append( " )");
		}
		SqlBuilder.buildOrderStatement(sql, order.toString().replaceAll("ORDER BY ", ""));
 		PageList<HealthExamination> healthExaminations = this.getPageList(page, sql.toString(),criteria);
		return healthExaminations;
	}
	
	private String getObservationInfoSql(String weigth){
		StringBuilder sql = new StringBuilder();
		if(StringUtil.isNotEmpty(weigth)){
			sql.append("SELECT " +
					"	T1.EHR_ID " +
					" FROM " +
					"	( " +
					"		SELECT " +
					"			PERSON_ID, " +
					"			EHR_ID, " +
					"			DECODE(trim(translate(nvl(OBSERVATION_RESULT,0),'0123456789.',' ')),null,nvl(OBSERVATION_RESULT,0),0) as OBSERVATION_RESULT " +
					"		FROM " +
					"			MS_OBSERVATION_INFO " +
					"		WHERE " +
					"			OBSERVATION_ITEM_CODE = '010011' " +
					"  AND regexp_like(OBSERVATION_RESULT ,'^(-?[0-9]+)(.[0-9]+)?$') " + 
					"	) T1 " +
					" INNER JOIN ( " +
					"	SELECT " +
					"		EHR_ID,PERSON_ID, " +
	                "		DECODE(trim(translate(nvl(OBSERVATION_RESULT,0),'0123456789.',' ')),null,nvl(OBSERVATION_RESULT,0),0) as OBSERVATION_RESULT " +
					"	FROM " +
					"		MS_OBSERVATION_INFO " +
					"	WHERE " +
					"		OBSERVATION_ITEM_CODE = '010012' " +
					"  AND regexp_like(OBSERVATION_RESULT ,'^(-?[0-9]+)(.[0-9]+)?$') " + 
					" ) T2 ON T1.PERSON_ID = T2.PERSON_ID " +
					" AND T1.EHR_ID = T2.EHR_ID " +
	                " AND T2.OBSERVATION_RESULT <> 0 " );
			if("1".equals(weigth)){
				sql.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) > 24");
				sql.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) < 27.9999");
				
			}else if("2".equals(weigth)){
				sql.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) > 28");
			}
			sql.append(" WHERE T1.EHR_ID = health.EHR_ID ");
		}
		return sql.toString();
	}
	
	private String getExamineDetailSql(String hepatitisB){
		StringBuilder sql = new StringBuilder();
		if(StringUtil.isNotEmpty(hepatitisB)){
			sql.append(" SELECT EHR_ID FROM MS_EXAMINE_DETAIL examine" +
					" WHERE INSPECTION_ITEM_CODE='5446' AND INSPECTION_RESULT = '1' AND examine.EHR_ID = health.EHR_ID");
		}
		return sql.toString();
		
	}
	public static void main(String[] ad) {
		String source = "C_LETFOOD_HAVA_SHELVES,C_LETTABLEWAREROOMS_CLEANING_DPOOL,C_ANIMATE_COOKED_FOODSEPARATELY,C_WITH_FOUREVILS_CARRYPUT_FOUREVILS,C_OTHER,C_ATTACHMENT_WITHOUT_HEALTH_CERTIFICATES,D_HEALTH_MANAGE_SYSTEM,D_HEALTH_MANAGERS,D_SUPPLY_HEALTH_CERTIFICATES,D_WATERQUALITY_TESTREPORT,D_WATERPURIFICATION_DISPENSER_DISINFECTION,D_WATERHEALTH_PROTECTION_STORAGE_WAREHOUSE,D_HEALTHPERMIT,D_USEWADINGPRODUCTS_DHPERMITS,D_REGULAR_CLEANING_WATERQUALITY_TEST,D_SECONDWATER_DRINKING_WATER,D_SECONDWATER_SURROUNDED_POLLUTION,D_DWATER_ODOR_SENSORY_PROPERTIES,D_DWATER_ODOR_SENSORY_TRAITS_VOBJECTS,D_OTHER,D_ATTACHMENT_WITHOUT_HEALTH_CERTIFICATES,CDP_HEALTH_DISEASE_MANAGE_ORGANIZATIONS,CDP_EPIDEMIC_REPORTING_PROFESSIONALS,CDP_PUBLICHEALTH_EMERGENCY_PLAN,CDP_INFECTIOUS_DMSYSTEM,CDP_MORING_CHECK_RECORDS,CDP_SICKNESS_CAUSE_REGISTRATION,CDP_PRIMARY_VACCINATION_INSPECTION,CDP_STUDENT_HEALTH_RECORDS,CDP_KNOWLEDGE_TRAINING_CARRY,CDP_INFORMATION_REPORT_OUTBREAKS,CDP_OTHER,CDP_ATTACHMENT_WITHOUT_HEALTH_CERTIFICATES,PPLACE_HEALTH_MANAGE_SYSTEM,PPLACE_HEALTH_MANAGERS,PPLACE_SUPPLYHEALTH_CERTIFICATES_PROOF_TRAINING,PPLACE_WATER_RECORD_REPORT,PPLACE_WATER_PURFICATION_DISPENSER_DISINFECTION,PPLACE_WATER_HEALTH_PROTECTION_MEASURES,PPLACE_HEALTH_PERMIT_CENTRALIZED,PPLACE_USE_WADING_PRODUCTS,PPLACE_REGULAR_CLEANING,PPLACE_SECOND_WATER_TANK,PPLACE_SECOND_WATER_TANK_SURROUNDED,PPLACE_DWATER_ODOR_SENSORY_PROPERTIES,PPLACE_DWATER_ODOR_SENSORY_TRAITS_VOBJECTS,PPLACE_OTHER,PPLACE_ATTACHMENT_WITHOUT_HEALTH_CERTIFICATES,IS_DELETE";
		String[] arr = source.split(",");
		for (String string : arr) {
			if (string.length() > 15) {
				String[] to = string.split("_");
				int i = 0;
				String ss = "";
				for (String s : to) {
					if (i == 0) {
						ss += s + "_";
					} else {
						ss += s.substring(0, 1);
					}
					i++;
				}
				string = ss;

			}
			System.err.println(string);
		}
	}

	@Override
	public List<Map<String, Object>> getHealthExaminationMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(HEALTH_EXAMINATION_PA_STATISTICS_SQL, conditionSqlBuilder.toString());
		return getMapList(sql, new Criteria());
	}

	@Override
	public List<HealthExamination> getHealthExaminationList(String examYear, String idList, String type) {
		if (StringUtil.isNullOrEmpty(examYear) || ObjectUtil.isNullOrEmpty(idList) || StringUtil.isNullOrEmpty(type)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MS_HEALTH_EXAMINATION")
				.append(" WHERE PERSON_ID in( " + idList.replace("[", "").replace("]", "")+")")
				.append(" AND PHYSICAL_EXAM_TYPE = '" + type + "'")
				.append(" AND TO_CHAR(EXAMINATION_DATE, 'YYYY') = '" + examYear + "'");
		return getList(sql.toString(), null);
	}
}