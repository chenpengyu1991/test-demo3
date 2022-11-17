package com.founder.rhip.ehr.repository.basic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.ActivityInfoRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;

@Repository("activityInfoRhDao")
public class ActivityInfoRhImplDao  extends AbstractDao<ActivityInfoRh, Long> implements IActivityInfoRhDao{
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<ActivityInfoRh> getTransferActivityInfo(Page page,
			TransferOperationLog transferLog) {
		System.out.println(111);
		StringBuilder sb = new StringBuilder("select a.ACTIVITYTYPE, a.ACTIVITYNAME, a.ACTIVITYTIME, a.currentOrganCode,");
		sb.append(" a.inputOrganCode, a.RECORD_CHANGE_TIME, a.operator FROM(");
		sb.append(" select HE.ACTIVE_TYPE as ACTIVITYTYPE, HE.ACTIVE_THEME as ACTIVITYNAME, HE.ACTIVE_TIME as ACTIVITYTIME,");
		sb.append(" HE.ORG_CODE as currentOrganCode, HERH.ORG_CODE as inputOrganCode, HERH.RECORD_CHANGE_TIME,");
		sb.append(" SY.OPERATOR as operator");
		sb.append(" FROM HE_ACTIVE_RH HERH, HE_ACTIVE HE, MDM_ORGANIZATION SY");
		sb.append(" WHERE HE.ID = HERH.ID AND HERH.ORG_CODE = SY.ORGAN_CODE");
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sb.append(" AND HERH.ORG_CODE = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND HE.ORG_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getOperatorname())) {
			sb.append(" AND SY.OPERATOR = '" + transferLog.getOperatorname() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getActivityName())) {
			sb.append(" AND HE.ACTIVE_THEME like '%" + transferLog.getActivityName() + "%'");
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
				transferLog.getBeginTime(), transferLog.getEndTime());
		
		SqlBuilder.buildWhereStatement(ActivityInfoRh.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<ActivityInfoRh> activityList = this.getPageList(page, sb.toString(), criteria);
		
		return activityList;
	}
}
