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
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;
import com.founder.rhip.ehr.entity.management.DmReportInfoRh;
@Repository("dmreportInfoRhDao")
public class DmReportInfoRhDaoImpl extends AbstractDao<DmReportInfoRh, Long> implements IDmReportInfoRhDao {

	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	  
	 public PageList<DmReportInfoRh> getTransferReportInfo(Page page,
			TransferOperationLog transferLog) {
		StringBuilder sql_all= new StringBuilder();
//		sql_all.append("select  idcard,name,dis_type,e.record_change_time,create_organ_code ,currentOrganCode from (select  c.idcard,c.name,c.dis_type,d.record_change_time,d.create_organ_code ,c.create_organ_code as currentOrganCode from(select a.idcard as idcard,a.name as name,b.dis_type as dis_type ,b.id as id,b.create_organ_code as create_organ_code from (");
//		sql_all.append("select idcard,name from dm_person_info  where idcard in(select dm.idcard from DM_DISEASE_INFO dm,DM_DISEASE_INFO_RH dmth where dm.id=dmth.id) )a,DM_REPORT_INFO b where a.idcard=b.idcard)c,DM_REPORT_INFO_RH d ");
		
		sql_all.append("select ID,NAME,IDCARD,DIS_TYPE,CREATE_ORGAN_CODE,currentOrganCode,");
		sql_all.append("RECORD_CHANGE_TIME,OPERATOR from (select dmReportInfoRH.ID,dmPersonInfo.NAME,");
		sql_all.append("dmPersonInfo.IDCARD,dmReportInfo.DIS_TYPE, dmReportInfoRH.CREATE_ORGAN_CODE,"
				+ "dmReportInfo.CREATE_ORGAN_CODE as currentOrganCode,dmReportInfoRH.RECORD_CHANGE_TIME,"
				+ "symdmorganization.OPERATOR");
		sql_all.append(" from DM_REPORT_INFO_RH dmReportInfoRH LEFT JOIN DM_REPORT_INFO dmReportInfo ON(dmReportInfoRH.ID= dmReportInfo.ID)");
		sql_all.append("LEFT JOIN DM_PERSON_INFO dmPersonInfo ON (dmPersonInfo.ID=dmReportInfo.DM_PERSON_ID )"
				+ "LEFT JOIN  MDM_ORGANIZATION symdmorganization on (symdmorganization.ORGAN_CODE=dmReportInfoRH.CREATE_ORGAN_CODE) "
				+ "where dmReportInfoRH.CREATE_ORGAN_CODE IS NOT NULL");
//		sql_all.append("where c.id=d.id");
		if (ObjectUtil.isNotEmpty(transferLog.getName())) {
			sql_all.append(" AND dmPersonInfo.name like '%"+transferLog.getName()+"%'");
		}
		if (ObjectUtil.isNotEmpty(transferLog.getIdcard())) {
			sql_all.append(" AND dmPersonInfo.IDCARD = '" + transferLog.getIdcard() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveOutOrgan())) {
			sql_all.append(" AND dmReportInfoRH.create_organ_code = '" + transferLog.getMoveOutOrgan() + "'");
		}
		
		if (ObjectUtil.isNotEmpty(transferLog.getMoveInOrgan())) {
			sql_all.append(" AND dmPersonInfo.create_organ_code  = '" + transferLog.getMoveInOrgan() + "'");
		}
		
		if(ObjectUtil.isNotEmpty(transferLog.getOperatorname())){
			sql_all.append(" AND symdmorganization.OPERATOR= '" + transferLog.getOperatorname() + "'");
		}
//		if (ObjectUtil.isNotEmpty(transferLog.getDiseasename())) {
//			sql_all.append(" AND c.dis_type  = '" + transferLog.getDiseasename() + "'");
//		}
		if (ObjectUtil.isNotEmpty(transferLog.getDiseaseType())) {
			String[] types = transferLog.getDiseaseType().split(",");
			if (types.length > 0) {
				sql_all.append(" AND ( 1=2 ");
		       for (String type : types) {
			     switch (type) {
				  case EHRConstants.DM_HBP_TYPE:
					  sql_all.append(" or dmReportInfo.dis_type='" + type + "'");
					  break;
				  case EHRConstants.DM_DI_TYPE:
					  sql_all.append(" or dmReportInfo.dis_type='" + type + "'");
					  break;
				  case EHRConstants.DM_CORONARY_TYPE:
					  sql_all.append(" or dmReportInfo.dis_type='" + type + "'");
					  break;
				  case EHRConstants.DM_TUMOR_TYPE:
					  sql_all.append(" or dmReportInfo.dis_type='" + type + "'");
					  break;
				  case EHRConstants.DM_STROKE_TYPE:
					  sql_all.append(" or dmReportInfo.dis_type='" + type + "'");
					  break;
			      }
		       }
		       
		       sql_all.append(" )");
		    }
		}
		sql_all.append(" ) e ");
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria,"e.record_change_time", 
				transferLog.getBeginTime(), transferLog.getEndTime());
		SqlBuilder.buildWhereStatement(DmReportInfoRh.class, sql_all, criteria);
		SqlBuilder.buildOrderStatement(sql_all, "e.record_change_time desc ");
		return this.getPageList(page,sql_all.toString(), criteria);
	}

}
