package com.founder.rhip.ph.service.oh;

import java.lang.reflect.InvocationTargetException;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.oh.OhPoisonReport;

public interface IOhPoisonReportService {
	/**
	 * 
	 * @Title: searchOhPoisonReportList 
	 * @Description: 查询农药中毒报告
	 * @param page
	 * @param criteria
	 * @return 
	 * @return PageList<OhPoisonReport> 
	 * @throws
	 */
	public PageList<OhPoisonReport> searchOhPoisonReportList(Page page,Criteria criteria);
	
	/**
	 * 
	 * @Title: searchOhPoisonReportList 
	 * @Description: 查询农药中毒报告
	 * @param page
	 * @param criteria
	 * @return 
	 * @return PageList<OhPoisonReport> 
	 * @throws
	 */
	public OhPoisonReport searchOhPoisonReport(Criteria criteria);
	/**
	 * 
	 * @Title: addOhPoisonReport 
	 * @Description: 新增农药中毒报卡
	 * @param ohPoisonReport
	 * @return 
	 * @return int 
	 * @throws
	 */
	public int addOhPoisonReport(OhPoisonReport ohPoisonReport);
	
	/**
	 * 
	 * @Title: deleteOhPoisonReport 
	 * @Description: 删除农药中毒报卡
	 * @param criteria
	 * @return 
	 * @return int 
	 * @throws
	 */
	public int deleteOhPoisonReport(String isDelete,Criteria criteria);
	
	/**
	 * 
	 * @Title: updateOhPoisonReport 
	 * @Description: 更新农药中毒报卡
	 * @param ohPoisonReport
	 * @return 
	 * @return int 
	 * @throws
	 */
	public int updateOhPoisonReport(OhPoisonReport ohPoisonReport);
	
	/**
	 * 
	 * @Title: checkOhPoisonReport 
	 * @Description: 审核农药中毒报卡
	 * @param criteria
	 * @return 
	 * @return int 
	 * @throws
	 */
	public int checkOhPoisonReport(String verifier,String verifyState,Criteria criteria);

	 /**
     * 保存农药中毒新增个人健康档案数据
     * @param ohPoisonReport
     * @return
     */
    public int createPerson(OhPoisonReport ohPoisonReport) throws InvocationTargetException, IllegalAccessException;
	
}
