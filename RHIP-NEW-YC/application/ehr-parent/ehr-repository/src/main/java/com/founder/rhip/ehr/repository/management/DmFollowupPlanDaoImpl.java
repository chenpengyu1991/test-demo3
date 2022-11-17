package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of DmDiseaseInfo
 * 
 */
@Repository("dmFollowupPlanDao")
public class DmFollowupPlanDaoImpl extends AbstractDao<DMFollowupPlan, Long> implements IDMFollowupPlanDao {
	@SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<DMFollowupPlan> queryFollowupPlan(Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder();
		sql.append("select PLAN_YEAR,PERSON_ID from DM_FOLLOWUP_PLAN");
		SqlBuilder.buildWhereStatement(DMFollowupPlan.class, sql, criteria);
		sql.append(" group by PLAN_YEAR,PERSON_ID");
		SqlBuilder.buildOrderStatement(sql, "PLAN_YEAR");
		return this.getList(sql.toString(), criteria);
	}

	@Override
	public List<DMFollowupPlan> queryStrokePlans(Criteria plan) {
		StringBuilder sql = new StringBuilder(
				"SELECT dmFollowupPlan.*, dmStrtumFollowup.FOLLOWUP_FLAG FROM DM_FOLLOWUP_PLAN dmFollowupPlan LEFT JOIN DM_STRTUM_FOLLOWUP dmStrtumFollowup ON dmFollowupPlan.FOLLOWUP_ID = dmStrtumFollowup. ID");
		SqlBuilder.buildWhereStatement(DMFollowupPlan.class, sql, plan);
		SqlBuilder.buildOrderStatement(sql, "dmFollowupPlan.PLAN_YEAR, dmFollowupPlan.PLAN_DATE");
		return this.getList(sql.toString(), plan);
	}

	@Override
	public DMFollowupPlan getNextFollowupPlanDate(Criteria plan) {
		plan.add("followupId", OP.IS, "NULL");
		plan.add("type", OP.IS, "NULL");
		StringBuilder sql = new StringBuilder("SELECT MIN(PLAN_DATE) as PLAN_DATE FROM DM_FOLLOWUP_PLAN");
		SqlBuilder.buildWhereStatement(DMFollowupPlan.class, sql, plan);
		return this.get(sql.toString(), plan);
	}

	@Override
	public DMFollowupPlan getLastFollowupPlanDate(Criteria plan) {
		plan.add("followupId", OP.UEMPTY, "");
		StringBuilder sql = new StringBuilder("SELECT MAX(PLAN_DATE) AS PLAN_DATE,  MAX(FOLLOWUP_DATE) AS FOLLOWUP_DATE,COUNT(ID) AS FOLLOWUP_COUNT  FROM DM_FOLLOWUP_PLAN ");
		SqlBuilder.buildWhereStatement(DMFollowupPlan.class, sql, plan);
		DMFollowupPlan dMFollowupPlan = this.get(sql.toString(), plan);
		return dMFollowupPlan;
	}

    @Override
    public List<DMFollowupPlan> getFollowupedPlanByPersonId(Long personId){
        Assert.notNull(personId,"人员id不能为空");
        Criteria criteria=new Criteria("DM_DISEASE_INFO.PERSON_ID",personId);
		criteria.add(getHmCardDeleteStatus("DM_DISEASE_INFO.", EHRConstants.DM_MANAGED_FLAG));
        criteria.add("DM_FOLLOWUP_PLAN.FOLLOWUP_ID", OP.IS,"NOT NULL");
        StringBuilder sqlStringBuilder=new StringBuilder("SELECT DM_FOLLOWUP_PLAN. ID, DM_FOLLOWUP_PLAN.PERSON_ID, DM_FOLLOWUP_PLAN.DIS_TYPE, DM_FOLLOWUP_PLAN.PLAN_DATE, DM_FOLLOWUP_PLAN.FOLLOWUP_DATE, DM_FOLLOWUP_PLAN.FACTOR_ID, DM_FOLLOWUP_PLAN. YEAR, DM_FOLLOWUP_PLAN. TYPE, DM_FOLLOWUP_PLAN.FOLLOWUP_ID, DM_FOLLOWUP_PLAN.PLAN_YEAR, DM_FOLLOWUP_PLAN.PLAN_ID,DM_DISEASE_INFO.CREATE_ORGAN_CODE FROM DM_DISEASE_INFO INNER JOIN DM_FOLLOWUP_PLAN ON DM_DISEASE_INFO.PERSON_ID = DM_FOLLOWUP_PLAN.PERSON_ID ");
        SqlBuilder.buildWhereStatement(DmDiabeticFollowup.class, sqlStringBuilder, criteria);
        return getList(sqlStringBuilder.toString(), criteria);
    }

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add(alias + "hbp_flag", isDelete);
		criteria.add(LOP.OR, alias + "di_flag", isDelete);
		criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
		criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
		criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
		return criteria;
	}


	@Override
	public List<DMFollowupPlan> getLifeEventByFollowupPlans(Long personId, String dmType) {
        Assert.notNull(personId,"人员id不能为空");
        String table = "";
        if (EHRConstants.DM_HBP_TYPE.equals(dmType)) {
        	table = "DM_HYPERTENSION_FOLLOWUP";
		} else if (EHRConstants.DM_DI_TYPE.equals(dmType)) {
			table = "DM_DIABETIC_FOLLOWUP";
		} else if (EHRConstants.DM_STROKE_TYPE.equals(dmType)) {
			table = "DM_STRTUM_FOLLOWUP"; 
		} else if (EHRConstants.DM_CORONARY_TYPE.equals(dmType)) {
			table = "DM_STRTUM_FOLLOWUP";
		} else if (EHRConstants.DM_TUMOR_TYPE.equals(dmType)) {
			table = "DM_TUMOR_FOLLOWUP";
		} else {
		     return null;
		}
        
        Criteria criteria=new Criteria("plan.PERSON_ID",personId);
		criteria.add("plan.DIS_TYPE", dmType);
        StringBuilder sqlStringBuilder=new StringBuilder("SELECT plan.ID, plan.PERSON_ID, plan.followup_id, plan.DIS_TYPE,plan.followup_date,followup.CREATE_ORGAN_CODE FROM	DM_FOLLOWUP_PLAN plan INNER JOIN ")
	        .append(table).append(" followup ON followup.PERSON_ID = plan.PERSON_ID and followup.id=plan.FOLLOWUP_ID ")
	        .append(" where plan.PERSON_ID=").append(personId)
	        .append(" and plan.DIS_TYPE=").append(dmType);
        
        return getList(sqlStringBuilder.toString(), criteria);

	}

	@Override
	public List<String> searchRepeatDate(Criteria criteria){
		StringBuilder sqlStringBuilder=new StringBuilder("select p.PLAN_DATE,count(*) from DM_FOLLOWUP_PLAN p " );
		SqlBuilder.buildWhereStatement(DMFollowupPlan.class, sqlStringBuilder, criteria);
		sqlStringBuilder.append(" and p.PLAN_DATE is not null GROUP BY p.PLAN_DATE having count(*) > 1");
		List<Map<String, Object>> mapList =getMapList(sqlStringBuilder.toString(), criteria);
		List<String> stringList = new ArrayList<>();
		if(ObjectUtil.isNotEmpty(mapList)){
			for (Map<String, Object> map :mapList){
				stringList.add((String) map.get("PLAN_DATE"));
			}
		}

		return stringList;
	}


}