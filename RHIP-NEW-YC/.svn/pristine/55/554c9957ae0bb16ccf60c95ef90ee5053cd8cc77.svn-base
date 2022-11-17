package com.founder.rhip.ehr.repository.management;

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
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;
import com.founder.rhip.ehr.entity.management.DmPersonInfoRh;

@Repository("dmPersonInfoRhDao")
public class DmPersonInfoRhDaoImpl extends AbstractDao<DmPersonInfoRh, Long> implements IDmPersonInfoRhDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    public PageList<DmPersonInfoRh> getTransferDmPersonInfo(Page page, TransferOperationLog transferLog){
    	StringBuilder sb = new StringBuilder("select a.NAME,a.IDCARD,a.HBP_FLAG,a.DI_FLAG, a.TUMOR_FLAG,");
    	sb.append(" a.CORONARY_FLAG,a.STROKE_FLAG, a.CREATE_ORGAN_CODE,a.currentOrganCode,a.RECORD_CHANGE_TIME,a.OPERATOR");
    	sb.append(" FROM ( select dmPersonInfo.NAME,dmPersonInfo.IDCARD,dmDiseaseInfo.HBP_FLAG,dmDiseaseInfo.DI_FLAG,");
        sb.append(" dmDiseaseInfo.TUMOR_FLAG,dmDiseaseInfo.CORONARY_FLAG,dmDiseaseInfo.STROKE_FLAG,");
		sb.append(" dmPersonInfoRh.CREATE_ORGAN_CODE,dmPersonInfo.CREATE_ORGAN_CODE as currentOrganCode,");
		sb.append(" dmPersonInfoRh.RECORD_CHANGE_TIME,org.OPERATOR ");
		sb.append(" FROM DM_PERSON_INFO_RH dmPersonInfoRh,DM_PERSON_INFO dmPersonInfo,");
		sb.append(" DM_DISEASE_INFO dmDiseaseInfo,MDM_ORGANIZATION org");
		sb.append(" where dmPersonInfoRh.ID = dmPersonInfo.ID AND dmPersonInfo.PERSON_ID = dmDiseaseInfo.PERSON_ID");
		sb.append(" AND dmPersonInfoRh.CREATE_ORGAN_CODE = org.ORGAN_CODE");

		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND dmPersonInfo.NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND dmPersonInfo.IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sb.append(" AND dmPersonInfoRh.CREATE_ORGAN_CODE = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND dmPersonInfo.CREATE_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getOperatorname())){
			sb.append(" AND org.OPERATOR= '" + transferLog.getOperatorname() + "'");
		}
		
		if (StringUtil.isNotEmpty(transferLog.getDiseaseType())) {
			String[] types = transferLog.getDiseaseType().split(",");
			if (types.length > 0) {
		       sb.append(" AND ( 1=2 ");
		       for (String type : types) {
			     switch (type) {
				  case EHRConstants.DM_HBP_TYPE:
					  sb.append(" or dmDiseaseInfo.HBP_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_DI_TYPE:
					  sb.append(" or dmDiseaseInfo.DI_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_CORONARY_TYPE:
					  sb.append(" or dmDiseaseInfo.CORONARY_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_TUMOR_TYPE:
					  sb.append(" or dmDiseaseInfo.TUMOR_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_STROKE_TYPE:
					  sb.append(" or dmDiseaseInfo.STROKE_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
			      }
		       }
		       
		       sb.append(" )");
		    }
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
        		transferLog.getBeginTime(), transferLog.getEndTime());
		SqlBuilder.buildWhereStatement(DmPersonInfoRh.class, sb, criteria);
		
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<DmPersonInfoRh> dmpersonList = this.getPageList(page, sb.toString(), criteria);
		
		return dmpersonList;
    }
    
    @Override
	public PageList<DmPersonInfoRh> getVillageTransferDmPersonInfo(Page page,
			TransferOperationLog transferLog) {
		StringBuilder sb = new StringBuilder("select a.NAME,a.IDCARD,a.HBP_FLAG,a.DI_FLAG, a.TUMOR_FLAG,");
    	sb.append(" a.CORONARY_FLAG,a.STROKE_FLAG, a.CREATE_ORGAN_CODE,a.currentOrganCode,a.RECORD_CHANGE_TIME,a.OPERATOR,a.PASTREET");
    	sb.append(" FROM ( select dmPersonInfo.NAME,dmPersonInfo.IDCARD,dmDiseaseInfo.HBP_FLAG,dmDiseaseInfo.DI_FLAG,");
        sb.append(" dmDiseaseInfo.TUMOR_FLAG,dmDiseaseInfo.CORONARY_FLAG,dmDiseaseInfo.STROKE_FLAG,");
		sb.append(" dmPersonInfoRh.CREATE_ORGAN_CODE,dmPersonInfo.CREATE_ORGAN_CODE as currentOrganCode,");
		sb.append(" dmPersonInfoRh.RECORD_CHANGE_TIME,org.OPERATOR,dmPersonInfoRh.PASTREET");
		sb.append(" FROM DM_PERSON_INFO_RH dmPersonInfoRh,DM_PERSON_INFO dmPersonInfo,");
		sb.append(" DM_DISEASE_INFO dmDiseaseInfo,MDM_ORGANIZATION org");
		sb.append(" where dmPersonInfoRh.ID = dmPersonInfo.ID AND dmPersonInfo.PERSON_ID = dmDiseaseInfo.PERSON_ID");
		sb.append(" AND dmPersonInfoRh.CREATE_ORGAN_CODE = org.ORGAN_CODE AND dmPersonInfoRh.PASTREET is not null");

		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sb.append(" AND dmPersonInfo.NAME like '%" + transferLog.getName() + "%'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sb.append(" AND dmPersonInfo.IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sb.append(" AND dmPersonInfoRh.CREATE_ORGAN_CODE = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sb.append(" AND dmPersonInfo.CREATE_ORGAN_CODE = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getOperatorname())){
			sb.append(" AND org.OPERATOR= '" + transferLog.getOperatorname() + "'");
		}
		if(ObjectUtil.isNotEmpty(transferLog.getItemCode())){
			sb.append(" AND dmPersonInfoRh.PASTREET= '" + transferLog.getItemCode() + "'");
		}
		if (StringUtil.isNotEmpty(transferLog.getDiseaseType())) {
			String[] types = transferLog.getDiseaseType().split(",");
			if (types.length > 0) {
		       sb.append(" AND ( 1=2 ");
		       for (String type : types) {
			     switch (type) {
				  case EHRConstants.DM_HBP_TYPE:
					  sb.append(" or dmDiseaseInfo.HBP_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_DI_TYPE:
					  sb.append(" or dmDiseaseInfo.DI_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_CORONARY_TYPE:
					  sb.append(" or dmDiseaseInfo.CORONARY_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_TUMOR_TYPE:
					  sb.append(" or dmDiseaseInfo.TUMOR_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
				  case EHRConstants.DM_STROKE_TYPE:
					  sb.append(" or dmDiseaseInfo.STROKE_FLAG='" + EHRConstants.DM_MANAGED_FLAG + "'");
					  break;
			      }
		       }
		       
		       sb.append(" )");
		    }
		}
		
		sb.append(" ) a ");
		
		Criteria criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria,"RECORD_CHANGE_TIME", 
        		transferLog.getBeginTime(), transferLog.getEndTime());
		SqlBuilder.buildWhereStatement(DmPersonInfoRh.class, sb, criteria);
		
		SqlBuilder.buildOrderStatement(sb, " RECORD_CHANGE_TIME DESC ");
		
		PageList<DmPersonInfoRh> dmpersonList = this.getPageList(page, sb.toString(), criteria);
		
		return dmpersonList;
	}

}
