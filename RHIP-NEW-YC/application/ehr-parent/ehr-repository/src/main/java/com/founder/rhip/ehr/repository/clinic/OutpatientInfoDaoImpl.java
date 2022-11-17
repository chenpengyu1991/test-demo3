package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.SqlBuilder;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;

/**
 * DAO implement of OutpatientInfo
 * 
 */
@Repository("outpatientInfoDao")
public class OutpatientInfoDaoImpl extends AbstractDao<OutpatientInfo, Long> implements IOutpatientInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	private static final String OUTPATIENT_STATISTICS_SQL = "SELECT T.CLINIC_ORGAN_CODE CODE, TO_CHAR(T.CLINIC_DATE, 'yyyy/MM/dd') DT,"
			+ " %2$s SUM(T.MEDICAL_INSURANCE_COST_SUM) N1,"
			+ " SUM(DECODE(T.MEDICAL_COST_PAY_WAY,'04',T.MEDICAL_INSURANCE_COST_SUM,0)) N2,"
			+ " SUM(T.PERSONAL_EXPENSES) N3,SUM(T.OUTPATIENT_COST_SUM) N4,"
			+ " SUM(DECODE(T.OBSERVED_PATIENT_FLAG, '1', 1, 0)) N5, "
			+ " count(distinct t.ehr_id) countEhrId"
			+ " FROM MS_OUTPATIENT_INFO T WHERE TO_CHAR(T.GATHER_DATE, 'yyyy/MM/dd')='%1$s' "
			+ " GROUP BY T.CLINIC_ORGAN_CODE, TO_CHAR(T.CLINIC_DATE, 'yyyy/MM/dd') %3$s";

	@Override
	public List<Map<String,Object>> getOutpatientStatistics(String dateStr, boolean isGroupByOutpatientType) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		String sql = "";
		if (isGroupByOutpatientType) {
			sql = String.format(OUTPATIENT_STATISTICS_SQL, dateStr, "T.OUTPATIENT_TYPE OUTPATIENT_TYPE,", ", T.OUTPATIENT_TYPE");
		} else {
			sql = String.format(OUTPATIENT_STATISTICS_SQL, dateStr, "", "");
		}
		return getMapList(sql, (Criteria) null);
	}
	@Override
	public List<Map<String,Object>> getPatientAllInfos(String personId){
		String sql = "select OI.CLINIC_ORGAN_NAME,OI.MEDICAL_ROOM_NAME,OI.CLINIC_DATE,OI.CLINIC_PEOPLE_NAME,OI.GENDER,OI.AGE,OI.CHIEF_COMPLAINT,OI.PATHOGENESIS_DATE, OI.OTHER_MEDICAL_TREATMENT,nvl(OI.OUTPATIENT_COST_SUM,0) OUTPATIENT_COST_SUM,\n" +
				"nvl(OI.PERSONAL_EXPENSES,0) PERSONAL_EXPENSES,nvl(OI.MEDICAL_INSURANCE_COST_SUM,0) MEDICAL_INSURANCE_COST_SUM,\n" +
				"nvl(OI.OTHER_SUBSIDIES_COST_SUM,0) OTHER_SUBSIDIES_COST_SUM,\n" +
				"OI.MANA_DOCTOR_NAME,OI.VISIT_STATUS,OI.OBSERVED_PATIENT_FLAG,OI.OUTPATIENT_TYPE,OP.PRESCRIPTION_TOTAL_COST,OP.PRESCRIPTION_NOTE,\n" +
				"DDI.DIAGNOSIS_DESC from MS_OUTPATIENT_INFO OI, MS_OUTPATIENT_PRESCRIPTION OP,MS_DISEASE_DIAGNOSIS_INFO DDI where OP.EHR_ID = OI.EHR_ID and DDI.EHR_ID = OI.EHR_ID\n" +
				" AND OI.PERSON_ID = ";
		StringBuilder sqlBuilder = new StringBuilder(sql);
		sqlBuilder.append(personId);
		return this.getMapList(sqlBuilder.toString(),new Criteria());
	}

	//根据EHR_ID查询出MS_OUTPATIENT_INFO、MS_OUTPATIENT_PRESCRIPTION、MS_DISEASE_DIAGNOSIS_INFO这三个表中的相关的字段。
	@Override
	public Map<String, Object> getOutPatientInfo(String EhrId) {
		String sql = "select OI.EHR_ID,OI.MEDICAL_ROOM_NAME,OI.CLINIC_ORGAN_NAME,OI.CLINIC_DATE,OI.CLINIC_PEOPLE_NAME,OI.GENDER,OI.AGE,OI.CHIEF_COMPLAINT,\n" +
				"OI.PATHOGENESIS_DATE,OI.OTHER_MEDICAL_TREATMENT,nvl(OI.OUTPATIENT_COST_SUM,0) OUTPATIENT_COST_SUM,\n" +
				"nvl(OI.PERSONAL_EXPENSES,0) PERSONAL_EXPENSES,nvl(OI.MEDICAL_INSURANCE_COST_SUM,0) MEDICAL_INSURANCE_COST_SUM,\n" +
				"nvl(OI.OTHER_SUBSIDIES_COST_SUM,0) OTHER_SUBSIDIES_COST_SUM,OI.MANA_DOCTOR_NAME,OI.VISIT_STATUS,\n" +
				"OI.OBSERVED_PATIENT_FLAG,OI.OUTPATIENT_TYPE,OP.PRESCRIPTION_TOTAL_COST,OP.PRESCRIPTION_NOTE,DDI.DIAGNOSIS_DESC\n" +
				"from MS_OUTPATIENT_INFO OI, MS_OUTPATIENT_PRESCRIPTION OP,MS_DISEASE_DIAGNOSIS_INFO DDI\n" +
				"where OP.EHR_ID = OI.EHR_ID and DDI.EHR_ID = OI.EHR_ID and OI.EHR_ID = '"+EhrId+"'";
		StringBuilder stringBuilder =  new StringBuilder(sql);
		return this.getMap(stringBuilder.toString(),new Criteria());
	}

	@Override
	public List<OutpatientInfo> getDistinctList(Criteria criteria, Order order) {
		ClassMetadata cMetadata = ClassMetadata.getMetadata(OutpatientInfo.class);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT EHR_ID, CLINIC_DATE, PERSON_ID FROM MS_OUTPATIENT_INFO");
		sql.append(" WHERE ").append(criteria.toSql(cMetadata, ":"));
		sql.append(order.toString());
		return this.getList(sql.toString(), criteria);
	}

	@Override
	public PageList<OutpatientInfo> getOutpatientInfoWithIdCard(Page page,
																Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder("SELECT S.CLINIC_PEOPLE_NAME, S.OUTPATIENT_NO,S.CLINIC_ORGAN_NAME,S.MEDICAL_ROOM_NAME,S.CLINIC_DATE,S.EHR_ID,S.PERSON_ID, P.IDCARD\n" +
				"  FROM MS_OUTPATIENT_INFO     S,\n" +
				"       SY_PHB_BI_PERSON_INFO              P\n" +
				" WHERE S.PERSON_ID = P.ID(+)\n");
		if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
			sql.append(" AND ");
			sql.append(criteria.toSql(ClassMetadata.getMetadata(OutpatientInfo.class), ":"));
		}
		SqlBuilder.buildOrderStatement(sql, " S.ID DESC");
		PageList<OutpatientInfo> pList = getPageList(page, sql.toString(), criteria);
		return pList;
	}
	/**
	 * 门诊记录无身份证
	 * @param page
	 * @param criteria
	 * @param order
	 * @return
	 */
	@Override
	public PageList<OutpatientInfo> getOutpatientInfoWithIdCard1(Page page,
																 Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder("SELECT S.CLINIC_PEOPLE_NAME, S.OUTPATIENT_NO,S.CLINIC_ORGAN_NAME,S.MEDICAL_ROOM_NAME,S.CLINIC_DATE,S.EHR_ID,S.PERSON_ID \n" +
				"  FROM MS_OUTPATIENT_INFO S" );
		SqlBuilder.buildWhereStatement(OutpatientInfo.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, " S.ID DESC");
		PageList<OutpatientInfo> pList = getPageList(page, sql.toString(), criteria);
		return pList;
	}
}