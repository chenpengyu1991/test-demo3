package com.founder.rhip.ehr.repository.basic;

import java.util.List;

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
import com.founder.rhip.ehr.entity.basic.PersonInfoRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;

@Repository("personInfoRhDao")
public class PersonInfoRhImplDao extends AbstractDao<PersonInfoRh, Long> implements IPersonInfoRhDao{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    public PageList<PersonInfoRh> getTransferPersonInfo(Page page, TransferOperationLog transferLog){
    	StringBuilder sb = new StringBuilder("select a.NAME,a.IDCARD,a.INPUT_ORGAN_CODE,a.currentOrganCode,");
    	sb.append(" a.RECORD_CHANGE_TIME, a.OPERATOR FROM (");
        sb.append(" select BI.NAME,BI.IDCARD,BIRH.INPUT_ORGAN_CODE,");
		sb.append(" BI.INPUT_ORGAN_CODE as currentOrganCode,BIRH.RECORD_CHANGE_TIME,ORG.OPERATOR");
		sb.append(" FROM BI_PERSON_INFO_RH BIRH, BI_PERSON_INFO BI, MDM_ORGANIZATION ORG");
		sb.append(" WHERE BIRH.ID = BI.ID AND BIRH.INPUT_ORGAN_CODE = ORG.ORGAN_CODE");

		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND BI.NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND BI.IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sb.append(" AND BIRH.INPUT_ORGAN_CODE = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND BI.INPUT_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getOperatorname())){
			sb.append(" AND ORG.OPERATOR = '" + transferLog.getOperatorname() + "'");
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
				transferLog.getBeginTime(), transferLog.getEndTime());
		
		SqlBuilder.buildWhereStatement(PersonInfoRh.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<PersonInfoRh> personList = this.getPageList(page, sb.toString(), criteria);
		
		return personList;
    }
    
    public PageList<PersonInfoRh> getVillageTransferPersonInfo(Page page, TransferOperationLog transferLog){
    	StringBuilder sb = new StringBuilder("select NAME,IDCARD,GBCODE,INPUT_ORGAN_CODE, currentOrganCode,RECORD_CHANGE_TIME,OPERATOR");
    	sb.append(" FROM ( select BI.NAME,BI.IDCARD,BIRH.GBCODE,BIRH.INPUT_ORGAN_CODE, ");
		sb.append(" BI.INPUT_ORGAN_CODE as currentOrganCode,BIRH.RECORD_CHANGE_TIME,ORG.OPERATOR");
		sb.append(" FROM BI_PERSON_INFO_RH BIRH INNER JOIN BI_PERSON_INFO BI ON (BIRH.ID = BI.ID)");
		sb.append(" INNER JOIN MDM_ORGANIZATION ORG ON(BIRH.INPUT_ORGAN_CODE= ORG.ORGAN_CODE) ");
		sb.append(" WHERE 1=1 ");

		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND BI.NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND BI.IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND BI.INPUT_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getOperatorname())){
			sb.append(" AND ORG.OPERATOR = '" + transferLog.getOperatorname() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getItemCode())){
			sb.append(" AND BIRH.GBCODE = '" + transferLog.getItemCode() + "'");
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
				transferLog.getBeginTime(), transferLog.getEndTime());
		
		SqlBuilder.buildWhereStatement(PersonInfoRh.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<PersonInfoRh> personList = this.getPageList(page, sb.toString(), criteria);
		
		return personList;
    }

}
