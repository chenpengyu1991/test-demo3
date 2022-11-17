package com.founder.rhip.ehr.repository.management;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.management.DmHighriskPersonInfo;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DAO implement of DmHighriskPersonInfo
 * 
 */
@Repository("dmHighriskPersonInfoDao")
public class DmHighriskPersonInfoDaoImpl extends AbstractDao<DmHighriskPersonInfo, Long> implements IDmHighriskPersonInfoDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public PageList<DmHighriskPersonInfo> getManagePlanPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] ageDateRange, Organization organization, RoleType roleType){
    	StringBuilder sql=new StringBuilder("SELECT * FROM DM_HIGHRISK_PERSON_INFO WHERE RISK_MANAGE_STATUS = '2' AND PERSON_ID IS NOT NULL ");
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	if("1".equals(dmHighriskPersonInfo.getManagesStatus())){
    		sql.append("AND PERSON_ID IN(SELECT PERSON_ID FROM DM_HIGHRISK_MANAGE_PLAN)");
    	}else if("2".equals(dmHighriskPersonInfo.getManagesStatus())){
    		sql.append("AND PERSON_ID NOT IN(SELECT PERSON_ID FROM DM_HIGHRISK_MANAGE_PLAN)");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getGender())){
    	    sql.append(" and riskManageStatus = ");
            sql.append("'"+dmHighriskPersonInfo.getGender()+"'");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getName())){
    	    sql.append(" and name like ");
            sql.append("'"+"%"+dmHighriskPersonInfo.getName()+"%"+"'");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getIdcard())){
    	    sql.append(" and idcard = ");
            sql.append("'"+dmHighriskPersonInfo.getIdcard().toUpperCase()+"'");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getGender())){
    	    sql.append(" and gender = ");
            sql.append("'"+dmHighriskPersonInfo.getGender()+"'");
    	} 
    	if (ageDateRange[0] != null) {  
    	    String date0=dateFormat.format(ageDateRange[0]);
			sql.append("AND BIRTHDAY >=to_date(");
			sql.append("'"+date0+"'");
			sql.append(",'yyyy-mm-dd')");
		}
		if (ageDateRange[1] != null) {
		    String date1=dateFormat.format(ageDateRange[1]);
			sql.append("AND BIRTHDAY <=to_date(");
			sql.append("'"+date1+"'");
			sql.append(",'yyyy-mm-dd')");
		}
		if (RoleType.ZMB.equals(roleType)) {
			 sql.append("AND CREATE_ORGAN_CODE = ");
	         sql.append("'"+organization.getOrganCode()+"'");
		}
		if (RoleType.ZXMB.equals(roleType)) {
			sql.append("AND (CREATE_CENTER_ORGAN_CODE = ");
			sql.append("'"+organization.getOrganCode()+"' OR CREATE_ORGAN_CODE = '"+organization.getOrganCode()+"')");
		}
    	return this.getPageList(page, sql.toString(), null); 
    }
    @Override
    public PageList<DmHighriskPersonInfo> getFollowPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] Ages, Organization organization, RoleType roleType){
    	StringBuilder sql=new StringBuilder("SELECT * FROM DM_HIGHRISK_PERSON_INFO WHERE RISK_MANAGE_STATUS = '2' AND PERSON_ID IN(SELECT PERSON_ID FROM DM_HIGHRISK_MANAGE_PLAN)");
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	if("1".equals(dmHighriskPersonInfo.getFollowUpStatus())){
    		sql.append("AND PERSON_ID IN(SELECT PERSON_ID FROM DM_HIGHRISK_FOLLOWUP)");
    	}else if("2".equals(dmHighriskPersonInfo.getFollowUpStatus())){
    		sql.append("AND PERSON_ID NOT IN(select PERSON_ID FROM DM_HIGHRISK_FOLLOWUP)");
    	}
    	if(ObjectUtil.isNotEmpty(dmHighriskPersonInfo.getFollowStatus())){
    		Date dateEnd = getFollowupNextDateEnd(dmHighriskPersonInfo.getFollowStatus());
    		sql.append("AND PERSON_ID IN(SELECT PERSON_ID FROM DM_FOLLOWUP_PLAN WHERE FOLLOWUP_ID IS NULL AND DIS_TYPE='6' AND PLAN_DATE<to_date(");
    		sql.append("'"+dateFormat.format(dateEnd)+"','yyyy-mm-dd')");
			if(ObjectUtil.equals(dmHighriskPersonInfo.getFollowStatus(), EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK) ||
					ObjectUtil.equals(dmHighriskPersonInfo.getFollowStatus(), EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH)	) {
				Date dateBegin = getFollowupNextDateBegin(dmHighriskPersonInfo.getFollowStatus());
				sql.append(" AND PLAN_DATE >= to_date(");
				sql.append("'"+dateFormat.format(dateBegin)+"','yyyy-mm-dd'))");
			}
    	}
    	if("1".equals(dmHighriskPersonInfo.getConclusionStatus())){
    		sql.append("AND PERSON_ID IN(SELECT PERSON_ID FROM DM_HIGHRISK_CONCLUSION)");
    	}else if("2".equals(dmHighriskPersonInfo.getConclusionStatus())){
    		sql.append("AND PERSON_ID NOT IN(select PERSON_ID FROM DM_HIGHRISK_CONCLUSION)");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getName())){
    	    sql.append(" and name like ");
            sql.append("'"+"%"+dmHighriskPersonInfo.getName()+"%"+"'");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getIdcard())){
    	    sql.append(" and idcard = ");
            sql.append("'"+dmHighriskPersonInfo.getIdcard().toUpperCase()+"'");
    	}
    	if(StringUtils.isNotBlank(dmHighriskPersonInfo.getGender())){
    	    sql.append(" and gender = ");
            sql.append("'"+dmHighriskPersonInfo.getGender()+"'");
    	}

     	if (Ages[0] != null) {  
    	    String date0=dateFormat.format(Ages[0]);
			sql.append("AND BIRTHDAY >=to_date(");
			sql.append("'"+date0+"'");
			sql.append(",'yyyy-mm-dd')");
		}
		if (Ages[1] != null) {
		    String date1=dateFormat.format(Ages[1]);
			sql.append("AND BIRTHDAY <=to_date(");
			sql.append("'"+date1+"'");
			sql.append(",'yyyy-mm-dd')");
		}
		if (RoleType.ZMB.equals(roleType)) {
			sql.append("AND CREATE_ORGAN_CODE = ");
			sql.append("'"+organization.getOrganCode()+"'");
		}
		if (RoleType.ZXMB.equals(roleType)) {
			sql.append("AND (CREATE_CENTER_ORGAN_CODE = ");
			sql.append("'"+organization.getOrganCode()+"'");
			sql.append("OR CREATE_ORGAN_CODE = ");
			sql.append("'"+organization.getOrganCode()+"')");
		}
    	return this.getPageList(page, sql.toString(), null);	
    }
	private Date getFollowupNextDateEnd(String followupFlag) {
		Date date = new Date();
		switch (followupFlag) {
		case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
			date = DateUtil.makeTimeToMax(date);
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.DAY_OF_MONTH, 7));
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, 1));
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED:
			date = DateUtil.makeTimeToZero(DateUtil.add(date, Calendar.MONTH, -1));
			break;
		}
		return date;
	}
	private Date getFollowupNextDateBegin(String followupFlag) {
		Date date = new Date();
		switch (followupFlag) {
			case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
				date = DateUtil.makeTimeToZero(date);
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
				date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.DAY_OF_MONTH, -7));
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
				date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, -1));
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED:
				date = DateUtil.makeTimeToZero(DateUtil.add(date, Calendar.MONTH, -1));
				break;
		}
		return date;
	}
}