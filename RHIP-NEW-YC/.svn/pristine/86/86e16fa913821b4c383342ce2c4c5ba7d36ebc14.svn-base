package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhEnterpriseInfo;

public interface IOhEnterpriseInfoDao extends IDao<OhEnterpriseInfo, Integer> {

	/**
	 * 重点企业查询
	 * @param       criteria
	 * @return      PageList<IdmReport>
	 */
	PageList<OhEnterpriseInfo> searchEnterpriseInfoList(Page page, Criteria criteria);
	
	/**
	 * 重点企业查询
	 * @param       criteria
	 * @return      OhEnterpriseInfo<IdmReport>
	 */
	OhEnterpriseInfo searchEnterpriseInfo(Criteria criteria);
	
	/**
	 * 企业基本信息保存
	 * @param       Long
	 * @return      OhEnterpriseInfo
	 */
	Long saveEnterpriseInfo(OhEnterpriseInfo enterpriseInfo);
}
