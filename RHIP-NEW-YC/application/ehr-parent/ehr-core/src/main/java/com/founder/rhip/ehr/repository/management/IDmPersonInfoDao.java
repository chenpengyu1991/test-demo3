package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;

import java.util.List;

/**
 * DAO interface of DmPersonInfo
 * 
 */
public interface IDmPersonInfoDao extends IDao<DmPersonInfo,Long> {
	
	/**
	 * 查询管理卡个人基本信息实体
	 * @param criteria
	 * @return
	 */
	public List<DmPersonInfo> getStandardizationPersonInfoList(Criteria criteria);
	
	/**
	 * 查询报卡个人基本信息实体
	 * @param criteria
	 * @return
	 */
	public List<DmPersonInfo> getReportCardPersonInfoList(Criteria criteria);

}