package com.founder.rhip.ehr.repository.statistics;

import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecordRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;

@Repository("physicalExamRecordRhDao")
public class PhysicalExamRecordRhDaoImpl extends AbstractDao<PhysicalExamRecordRh, Long> implements IPhysicalExamRecordRhDao{

	public PageList<PhysicalExamRecordRh> getphysicalexamrecordInfo(Page page, TransferOperationLog transferLog){
		StringBuilder sb = new StringBuilder("select a.NAME, a.IDCARD,a.EXAM_STATUS,a.EXAM_YEAR,a.INPUT_ORGAN_CODE,");
    	sb.append(" a.currentOrganCode,a.RECORD_CHANGE_TIME,a.OPERATOR");
    	sb.append(" FROM (SELECT NAME, IDCARD,EXAM_STATUS,EXAM_YEAR,PEERH.INPUT_ORGAN_CODE,PEE.INPUT_ORGAN_CODE as currentOrganCode,");
        sb.append(" PEERH.RECORD_CHANGE_TIME,ORG.OPERATOR");
		sb.append(" from ech_PHYSICAL_EXAM_RECORD_RH PEERH LEFT JOIN ech_PHYSICAL_EXAM_RECORD PEE ON (PEERH.ID = PEE.ID)");
		sb.append(" LEFT JOIN MDM_ORGANIZATION ORG ON (ORG.ORGAN_CODE=PEERH.INPUT_ORGAN_CODE) ");
		sb.append(" WHERE 1=1 ");

		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND PEE.NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND PEE.IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sb.append(" AND PEERH.INPUT_ORGAN_CODE = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND PEE.INPUT_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getOperatorname())){
			sb.append(" AND ORG.OPERATOR= '" + transferLog.getOperatorname() + "'");
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
        		transferLog.getBeginTime(), transferLog.getEndTime());
		SqlBuilder.buildWhereStatement(PhysicalExamRecordRh.class, sb, criteria);
		
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<PhysicalExamRecordRh> physicalexamrecordList = this.getPageList(page, sb.toString(), criteria);
		
		return physicalexamrecordList;
	}
}
