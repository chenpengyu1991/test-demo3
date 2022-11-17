package com.founder.rhip.ehr.repository.portal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.portal.SurveyRecord;

/**
 * DAO interface of Survey
 * 
 */
public interface ISurveyRecordDao extends IDao<SurveyRecord,Long> {

	/**
	 * 开启调查（将状态改为1）
	 * @param surveyId
	 */
	int startSurvey(Long surveyId);
	
	/**
	 * 关闭调查（将状态改为2）
	 * @param surveyId
	 */
	int endSurvey(Long surveyId);

	PageList<SurveyRecord> getMySurveyList(Page page, Criteria crita, User user);
	
}