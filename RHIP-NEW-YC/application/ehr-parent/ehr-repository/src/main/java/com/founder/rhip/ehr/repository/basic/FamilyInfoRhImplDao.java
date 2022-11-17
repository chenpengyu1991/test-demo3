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
import com.founder.rhip.ehr.entity.basic.FamilyInfoRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;

@Repository("familyInfoRhDao")
public class FamilyInfoRhImplDao extends AbstractDao<FamilyInfoRh, Long> implements IFamilyInfoRhDao{
	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<FamilyInfoRh> getTransferFamilyInfo(Page page, TransferOperationLog transferLog) {
		StringBuilder sb = new StringBuilder("select a.name,a.idcard,a.INPUT_ORGAN_CODE,a.currentOrganCode,");
		sb.append(" a.RECORD_CHANGE_TIME,a.operator FROM (");
		sb.append(" select BI.HOUSEHOLDER_NAME as name,BI.HOUSEHOLDER_IDCARD as idcard,BIRH.INPUT_ORGAN_CODE,");
		sb.append(" BI.INPUT_ORGAN_CODE as currentOrganCode, BIRH.RECORD_CHANGE_TIME, SY.OPERATOR as operator");
		sb.append(" FROM BI_FAMILY_INFO_RH BIRH, BI_FAMILY_INFO BI ,MDM_ORGANIZATION SY");
		sb.append(" WHERE BIRH.ID = BI.ID AND BIRH.INPUT_ORGAN_CODE = SY.ORGAN_CODE");
		
		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND BI.HOUSEHOLDER_NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND BI.HOUSEHOLDER_IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sb.append(" AND BIRH.INPUT_ORGAN_CODE = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND BI.INPUT_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getOperatorname())) {
			sb.append(" AND SY.OPERATOR = '" + transferLog.getOperatorname() + "'");
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
				transferLog.getBeginTime(), transferLog.getEndTime());
		
		SqlBuilder.buildWhereStatement(FamilyInfoRh.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<FamilyInfoRh> familyList = this.getPageList(page, sb.toString(), criteria);
		return familyList;
	}

	@Override
	public PageList<FamilyInfoRh> getTransferVillageFamilyInfo(Page page,TransferOperationLog transferLog) {
		
		StringBuilder sb = new StringBuilder("select name, idcard, GBCODE, INPUT_ORGAN_CODE, currentOrganCode,");
		sb.append(" RECORD_CHANGE_TIME, operator FROM (");
		sb.append(" select BI.HOUSEHOLDER_NAME as name,BI.HOUSEHOLDER_IDCARD as idcard,BIRH.INPUT_ORGAN_CODE,");
		sb.append(" BIRH.GBCODE, BI.INPUT_ORGAN_CODE as currentOrganCode, BIRH.RECORD_CHANGE_TIME, SY.OPERATOR as operator");
		sb.append(" FROM BI_FAMILY_INFO_RH BIRH LEFT JOIN BI_FAMILY_INFO BI ON (BIRH.ID = BI.ID)");
		sb.append(" LEFT JOIN MDM_ORGANIZATION SY ON (BIRH.INPUT_ORGAN_CODE = SY.ORGAN_CODE)");
		sb.append(" WHERE 1=1 ");
		
		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND BI.HOUSEHOLDER_NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND BI.HOUSEHOLDER_IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND BI.INPUT_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getOperatorname())) {
			sb.append(" AND SY.OPERATOR = '" + transferLog.getOperatorname() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getItemCode())){
			sb.append(" AND BIRH.GBCODE = '" +transferLog.getItemCode() + "'");
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
				transferLog.getBeginTime(), transferLog.getEndTime());
		
		SqlBuilder.buildWhereStatement(FamilyInfoRh.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<FamilyInfoRh> familyVillageList = this.getPageList(page, sb.toString(), criteria);
		
		return familyVillageList;
	}
	
}
