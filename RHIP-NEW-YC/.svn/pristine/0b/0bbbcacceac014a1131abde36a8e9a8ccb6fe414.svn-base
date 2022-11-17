package com.founder.rhip.ehr.repository.ism;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ism.ReportInfo;
import com.founder.rhip.ehr.entity.management.DmReportInfo;

/**
 * DAO interface of IsReportInfo
 * 
 */
public interface IReportInfoDao extends IDao<ReportInfo,Long> {
	/**
	 * 查询重复报卡
	 * @param criteria
	 * @return
	 */
	public PageList<ReportInfo> getRepeatCardList(Page page,Criteria criteria,String conditions);
}