package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhEmployeeInfo;

public interface IOhEmployeeInfoDao extends IDao<OhEmployeeInfo, Integer> {

	/**
	 * 职业病人档案查询
	 * @param       criteria
	 * @return      PageList<OhEmployeeInfo>
	 */
	PageList<OhEmployeeInfo> searchEmployeeInfoList(Page page, Criteria criteria);
	
	/**
	 * 职业病人档案查询
	 * @param       criteria
	 * @return      OhEmployeeInfo
	 */
	OhEmployeeInfo searchEmployeeInfo(Criteria criteria);
	
	/**
	 * 职业病人档案信息保存
	 * @param       Long
	 * @return      OhEmployeeInfo
	 */
	Long saveEmployeeInfo(OhEmployeeInfo employeeInfo);
}
