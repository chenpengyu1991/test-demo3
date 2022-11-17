package com.founder.rhip.ehr.repository.management;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of DmHypertensionConclusion
 *
 */
@Repository("dmHypertensionConclusionDao")
public class DmHypertensionConclusionDaoImpl extends AbstractDao<DmHypertensionConclusion, Long> implements IDmHypertensionConclusionDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<DmHypertensionConclusion> getPlanList(Page page,
                                                          Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("WITH CONCLUSION_RESULT AS (SELECT tmp.person_id,\n" +
				"  MAX(tmp.hbp_flag)hbp_flag,\n" +
				"  MAX(tmp.DI_FLAG) DI_FLAG,\n" +
				"  MAX(tmp.HBP_PLAN_DATE) HBP_PLAN_DATE,\n" +
				"  MAX(tmp.DI_PLAN_DATE) DI_PLAN_DATE\n" +
				"FROM\n" +
				"  (select person_id, \n" +
				"case when DISEASE_TYPE = '1' then 2 else null end HBP_FLAG,\n" +
				"case when DISEASE_TYPE = '2' then 2 else null end DI_FLAG,\n" +
				"case when DISEASE_TYPE = '1' then max(create_date) else null end HBP_PLAN_DATE,\n" +
				"case when DISEASE_TYPE = '2' then max(create_date) else null end DI_PLAN_DATE\n" +
				" from DM_HYPERTENSION_CONCLUSION \n" +
				"group by person_id, DISEASE_TYPE order by person_id) tmp\n" +
				"GROUP BY tmp.person_id)\n" +
				"SELECT distinct DM_PERSON_INFO.ID,\n" +
				"      DM_PERSON_INFO.NAME,\n" +
				"      DM_PERSON_INFO.GENDER,\n" +
				"      DM_PERSON_INFO.IDCARD,\n" +
				"      DM_PERSON_INFO.BIRTHDAY,\n" +
				"      DM_PERSON_INFO.PHONE_NUMBER,\n" +
				"      DM_PERSON_INFO.PERSON_ID,\n" +
				"      --DM_PERSON_INFO.ID,\n" +
				"      DM_PERSON_INFO.EDUCATION,\n" +
				"      DM_PERSON_INFO.OCCUPATION,\n" +
				"      DM_PERSON_INFO.NATION,\n" +
				"      DM_PERSON_INFO.PAPROVINCE,\n" +
				"      DM_PERSON_INFO.PACITY,\n" +
				"      DM_PERSON_INFO.PACOUNTY,\n" +
				"      DM_PERSON_INFO.PATOWN_SHIP,\n" +
				"      DM_PERSON_INFO.PASTREET,\n" +
				"      DM_PERSON_INFO.PAHOUSE_NUMBER,\n" +
				"      DM_DISEASE_INFO.CREATE_DATE,\n" +
				"      DM_DISEASE_INFO.LAST_HBP_PLAN_YEAR,\n" +
				"      DM_DISEASE_INFO.LAST_DI_PLAN_YEAR,\n" +
				"      DM_DISEASE_INFO.DI_DIAGNOSIS_DATE,\n" +
				"      DM_DISEASE_INFO.DI_DIAGNOSED_ORGAN_NAME,\n" +
				"      DM_DISEASE_INFO.DI_TYPE,\n" +
				"      DM_DISEASE_INFO.HBP_FLAG,\n" +
				"      DM_DISEASE_INFO.DI_FLAG,\n" +
				"      DM_DISEASE_INFO.STROKE_FLAG,\n" +
				"      DM_DISEASE_INFO.CORONARY_FLAG,\n" +
				"      DM_DISEASE_INFO.TUMOR_FLAG,\n" +
				"      DM_DISEASE_INFO.ID AS DISEASE_ID\n" +
				"    FROM DM_PERSON_INFO\n" +
				"    LEFT JOIN CONCLUSION_RESULT ON CONCLUSION_RESULT.PERSON_ID = DM_PERSON_INFO.PERSON_ID \n" +
				"    INNER JOIN DM_DISEASE_INFO\n" +
				"    ON DM_DISEASE_INFO.PERSON_ID             =DM_PERSON_INFO.PERSON_ID\n" +
				"    where 1=1");
		if(criteria.get("name")!=null && !StringUtil.isNullOrEmpty(criteria.get("name").toString()))
			sql.append(" and DM_PERSON_INFO.name like'%'||:name||'%'");
		if(criteria.get("idcard")!=null && !StringUtil.isNullOrEmpty(criteria.get("idcard").toString()))
			sql.append(" and DM_PERSON_INFO.idcard like:idcard");
		if(criteria.get("gender")!=null && !StringUtil.isNullOrEmpty(criteria.get("gender").toString()))
			sql.append(" and DM_PERSON_INFO.gender=:gender");
		if(criteria.get("beginAge")!=null)
			sql.append(" and DM_PERSON_INFO.birthday>=:beginAge");
		if(criteria.get("endAge")!=null)
			sql.append(" and DM_PERSON_INFO.birthday<=:endAge");
		if(criteria.get("diseaseType")!=null){
			sql.append(" and ( 1!=1");
			if(criteria.get("diseaseType").toString().indexOf("1")!=-1){
				sql.append(" or (DM_DISEASE_INFO.HBP_FLAG=2 ");
				if(criteria.get("planStatus").toString().equals("1"))
					sql.append(" and ((CONCLUSION_RESULT.HBP_PLAN_DATE IS not NULL\n" +
							"    and to_char(add_months(CONCLUSION_RESULT.HBP_PLAN_DATE, 12), 'yyyy/mm/dd') < to_char(SYSDATE, 'yyyy/mm/dd'))" +
							"    or CONCLUSION_RESULT.HBP_PLAN_DATE IS NULL))\n");
				else
					sql.append(" and (CONCLUSION_RESULT.HBP_PLAN_DATE IS not NULL\n" +
							"    and to_char(add_months(CONCLUSION_RESULT.HBP_PLAN_DATE, 12), 'yyyy/mm/dd') >= to_char(SYSDATE, 'yyyy/mm/dd')))\n");
			}
			if(criteria.get("diseaseType").toString().indexOf("2")!=-1){
				sql.append(" or (DM_DISEASE_INFO.DI_FLAG=2");
				if(criteria.get("planStatus").toString().equals("1"))
					sql.append(" and ((CONCLUSION_RESULT.DI_PLAN_DATE  IS not NULL\n" +
							"    and to_char(add_months(CONCLUSION_RESULT.DI_PLAN_DATE, 12), 'yyyy/mm/dd') <  to_char(SYSDATE, 'yyyy/mm/dd'))" +
							" OR CONCLUSION_RESULT.DI_PLAN_DATE IS NULL))");
				else
					sql.append(" and (CONCLUSION_RESULT.DI_PLAN_DATE  IS not NULL\n" +
							"    and to_char(add_months(CONCLUSION_RESULT.DI_PLAN_DATE, 12), 'yyyy/mm/dd') >= to_char(SYSDATE, 'yyyy/mm/dd'))) ");
			}
			sql.append(")");
		} else {
			if(criteria.get("planStatus")!=null && criteria.get("planStatus").toString().equals("1")){
				sql.append(" and (((CONCLUSION_RESULT.HBP_PLAN_DATE IS not NULL\n" +
						"    and to_char(add_months(CONCLUSION_RESULT.HBP_PLAN_DATE, 12), 'yyyy/mm/dd')    < to_char(SYSDATE, 'yyyy/mm/dd'))\n" +
						"    or (DM_DISEASE_INFO.HBP_FLAG = 2 and CONCLUSION_RESULT.HBP_PLAN_DATE IS NULL))" +
						"    OR ((CONCLUSION_RESULT.DI_FLAG              =2\n" +
						"    AND CONCLUSION_RESULT.DI_PLAN_DATE  IS not NULL\n" +
						"    and to_char(add_months(CONCLUSION_RESULT.DI_PLAN_DATE, 12), 'yyyy/mm/dd')     <  to_char(SYSDATE, 'yyyy/mm/dd'))" +
						"    or (DM_DISEASE_INFO.DI_FLAG = 2 and CONCLUSION_RESULT.DI_PLAN_DATE IS NULL)\n))");
			}else{
				sql.append(" and ((CONCLUSION_RESULT.HBP_PLAN_DATE IS not NULL\n" +
						"    and to_char(add_months(CONCLUSION_RESULT.HBP_PLAN_DATE, 12), 'yyyy/mm/dd') >= to_char(SYSDATE, 'yyyy/mm/dd'))\n" +
						"    OR (CONCLUSION_RESULT.DI_FLAG              =2\n" +
						"    AND (CONCLUSION_RESULT.DI_PLAN_DATE  IS not NULL\n" +
						"    and to_char(add_months(CONCLUSION_RESULT.DI_PLAN_DATE, 12), 'yyyy/mm/dd') >= to_char(SYSDATE, 'yyyy/mm/dd'))))");

			}
		}
		sql.append(" and DM_DISEASE_INFO.status=1");
		sql.append(getHmCardDeleteStatusSql("DM_DISEASE_INFO.", EHRConstants.DM_MANAGED_FLAG));
		if(criteria.get("createOrganCode")!=null){
			sql.append(" and DM_DISEASE_INFO.CREATE_ORGAN_CODE=:createOrganCode");
		}
		if(criteria.get("createCenterOrganCode")!=null){
			sql.append(" and DM_PERSON_INFO.CREATE_CENTER_ORGAN_CODE=:createCenterOrganCode");
		}
		if(criteria.get("createGbcode")!=null){
			sql.append(" and DM_PERSON_INFO.CREATE_GBCODE=:createGbcode");
		}
		sql.append(" AND DM_PERSON_INFO.type =2 AND (DM_DISEASE_INFO.HBP_FLAG = 2 OR DM_DISEASE_INFO.DI_FLAG =2)");
		SqlBuilder.buildOrderStatement(sql, "DM_DISEASE_INFO.CREATE_DATE DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<DmHypertensionConclusion> getHealthPlanDetailList(
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DM_DISEASE_INFO.HBP_FLAG,DM_DISEASE_INFO.DI_FLAG,DM_DISEASE_INFO.DI_DIAGNOSED_ORGAN_CODE,DM_DISEASE_INFO.DI_DIAGNOSED_DATE,DM_DISEASE_INFO.DI_TYPE,DM_PERSON_INFO.NAME,DM_PERSON_INFO.IDCARD,DM_HYPERTENSION_CONCLUSION.CREATE_DOCTOR_NAME,DM_HYPERTENSION_CONCLUSION.ID,DM_HYPERTENSION_CONCLUSION.EHR_ID,DM_DISEASE_INFO.PERSON_ID," +
				" DM_HYPERTENSION_CONCLUSION.IDCARD,DM_HYPERTENSION_CONCLUSION.HEALTH_FILE_NO,DM_HYPERTENSION_CONCLUSION.SBP,DM_HYPERTENSION_CONCLUSION.DBP,DM_HYPERTENSION_CONCLUSION.HYPERTENSION_MANAGEMENT_LEVEL,DM_HYPERTENSION_CONCLUSION.CLASSIFICATION_OF_HEALTH,DM_HYPERTENSION_CONCLUSION.HYPERTENSION_RISK_HIERARCHY,DM_HYPERTENSION_CONCLUSION.FOLLOWUP_TIMES," +
				" DM_HYPERTENSION_CONCLUSION.CONCLUSIONS_OF_YEAR,DM_HYPERTENSION_CONCLUSION.FPG,DM_HYPERTENSION_CONCLUSION.GLU_VALUE,DM_HYPERTENSION_CONCLUSION.SACCHARIFICATION,DM_HYPERTENSION_CONCLUSION.AUXILIARY_EXAMINE_ITEM,DM_HYPERTENSION_CONCLUSION.DIAGNOSIS,DM_HYPERTENSION_CONCLUSION.MANAGE_LEVEL,DM_HYPERTENSION_CONCLUSION.UPDATE_ORGAN_CODE,DM_HYPERTENSION_CONCLUSION.UPDATE_ORGAN_NAME,DM_HYPERTENSION_CONCLUSION.UPDATE_DOCTOR_CODE," +
				" DM_HYPERTENSION_CONCLUSION.UPDATE_DOCTOR_NAME,DM_HYPERTENSION_CONCLUSION.UPDATE_DATE,DM_HYPERTENSION_CONCLUSION.IS_DELETE,DM_HYPERTENSION_CONCLUSION.DISEASE_TYPE,DM_HYPERTENSION_CONCLUSION.LAST_CONCLUSIONS_OF_YEAR,DM_HYPERTENSION_CONCLUSION.CVD_ELEMENT,DM_HYPERTENSION_CONCLUSION.TR_DAMAGE,DM_HYPERTENSION_CONCLUSION.RELATED_DISEASES,DM_HYPERTENSION_CONCLUSION.DEAL_TYPE,DM_HYPERTENSION_CONCLUSION.ANNUAL_VISIT_TIMES," +
				" DM_HYPERTENSION_CONCLUSION.CREATE_ORGAN_NAME,DM_HYPERTENSION_CONCLUSION.CREATE_ORGAN_CODE,DM_HYPERTENSION_CONCLUSION.CREATE_DOCTOR_NAME,DM_HYPERTENSION_CONCLUSION.CREATE_DOCTOR_CODE,DM_HYPERTENSION_CONCLUSION.CREATE_DATE,DM_HYPERTENSION_CONCLUSION.NEXT_FOLLOWUP_DATE,DM_HYPERTENSION_CONCLUSION.RBG,DM_HYPERTENSION_CONCLUSION.PROCESS,DM_HYPERTENSION_CONCLUSION.DOUBLE_CHECK  FROM 	DM_PERSON_INFO INNER JOIN DM_DISEASE_INFO ON DM_DISEASE_INFO.PERSON_ID=DM_PERSON_INFO.PERSON_ID LEFT JOIN DM_HYPERTENSION_CONCLUSION ON DM_DISEASE_INFO.PERSON_ID=DM_HYPERTENSION_CONCLUSION.PERSON_ID");
		SqlBuilder.buildWhereStatement(DmHypertensionConclusion.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "DISEASE_TYPE");
		return this.getList(sql.toString(),criteria);
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private String getHmCardDeleteStatusSql(String alias, String isDelete) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" and ( " +alias + "hbp_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "di_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "stroke_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "coronary_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "tumor_flag=" + isDelete + " )");
		return sqlBuffer.toString();
	}
}