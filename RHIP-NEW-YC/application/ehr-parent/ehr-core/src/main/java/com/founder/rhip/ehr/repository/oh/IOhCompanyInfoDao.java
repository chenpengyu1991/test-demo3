package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhCompanyInfo;

public interface IOhCompanyInfoDao extends IDao<OhCompanyInfo, Integer> {

	/**
	 * 职业病病人单位信息查询
	 * @param       criteria
	 * @return      OhCompanyInfo
	 */
	OhCompanyInfo searchCompanyInfo(Criteria criteria);
	
	/**
	 * 职业病病人单位信息保存
	 * @param       Long
	 * @return      OhCompanyInfo
	 */
	Long saveCompanyInfo(OhCompanyInfo companyInfo);
}
