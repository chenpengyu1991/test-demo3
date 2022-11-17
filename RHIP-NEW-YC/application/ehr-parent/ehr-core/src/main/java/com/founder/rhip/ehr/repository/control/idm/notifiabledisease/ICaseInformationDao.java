package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of CaseInformation
 * 
 */
public interface ICaseInformationDao extends IDao<CaseInformation,Integer> {

	/**
     * 查看血吸虫调查列表
     * @param       criteria
     * @return      PageList<CaseInformation>
     */
	public PageList<CaseInformation> findSurveyList(Page page, Criteria criteria);
	
	public List<Map<String, Object>> getCaseToStandardMapList(Map<String, String> paramMap);
}