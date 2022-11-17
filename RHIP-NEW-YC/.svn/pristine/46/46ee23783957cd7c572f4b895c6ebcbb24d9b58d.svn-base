package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.management.DmHighriskPersonInfo;
import com.founder.rhip.mdm.entity.Organization;

import java.util.Date;

/**
 * DAO interface of DmHighriskPersonInfo
 * 
 */
public interface IDmHighriskPersonInfoDao extends IDao<DmHighriskPersonInfo,Long> {
	
	public PageList<DmHighriskPersonInfo> getManagePlanPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] ageDateRange, Organization organization, RoleType roleType);

	public PageList<DmHighriskPersonInfo> getFollowPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] Ages, Organization organization, RoleType roleType);
}