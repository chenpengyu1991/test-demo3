/**
 * copyright Relax4J 2011
 * 
 * @date 2012-02-15
 * @author founder
 * @version V1.0
 * @describe 调查
 */

package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.portal.*;

import java.util.List;

public interface ISurveyService {

	/**
	 * 新建调查
	 * 
	 * @param survey
	 * @return Survey
	 */
	public Long createSurvey(Survey survey);

	/**
	 *更新调查表状态
	 * @param surveyId
	 * @param status
	 * @return
	 */
	public int updateStatus(Long surveyId, String status);

	/**
	 * 更新调查表
	 * 
	 * @param survey
	 * @return int
	 */
	public int updateSurvey(Survey survey);

	/**
	 * 查看调查表详情
	 * @param criteriaId
	 * @return
	 */
	public Survey getSurvey(Long criteriaId);
	
	/**
	 * 新建调查项
	 * @param surveyItem
	 * @return
	 */
	public int createSurveyItemsAndOptions(SurveyItem surveyItem, String surveyStatus);
	
	public int createPoll(Poll poll);
	
	public Survey getSurvey(Criteria criteria);
	
	public SurveyItem getSurveyItem(Criteria criteria);
	
	public SurveyOption getSurveyOption(Criteria criteria);
	
	public PageList<Survey> getSurveyList(Page page, Criteria criteria);
	
	public PageList<SurveyItem> getSurveyItemList(Page page, Criteria criteria, Order order);
	
	public List<SurveyItem> getSurveyItemList(Criteria criteria, Order order);
	
	public List<SurveyOption> getSurveyOptionList(Criteria criteria, Order order);
	
	public List<PollOption> getPollOptionList(Long itemId);
	
	public List<PollText> getPollTextList(Criteria criteria);
	
	public int deleteSurvey(Long surveryId);
	
	public int deleteSurveyItem(Long surveryItemId);
	
	public int deleteSurveyOption(Long surveryItemId);
	
	public int deleteOption(Long optionId);
	
	public int deletePollOption(Long pollId);
	
	public int deletePollText(Long itemId);
	
	public int updateSurveyItem(SurveyItem surveyItem, String surveyStatus);
	
	public int updateSurveyOption(SurveyOption surveyOption);
	
	Long getOptionCount(Criteria criteria);
	
	/**
	 * 根据起始日期 更新调查问卷的状态
	 */
	void updateSurveyStatus();

	/***
	 * 根据survey_id查相应的问题的radio,checkbox选项列表
	 * @param criteria
	 * @return
	 */
	public List<SurveyOption> getSurveyOptionsByItemIdLists(Criteria criteria);

	/***
	 * 查询某个问题的一个选项被选的次数
	 * @param criteria
	 * @return
	 */
	public List<PollOption> getOptionCountLists(Criteria criteria);

	/***
	 * 查询某个问题所有选项被选的次数
	 * @param criteria
	 * @return
	 */
	public List<PollOption> optionCountByItemLists(Criteria criteria);

	/***
	 * 根据survey_id查相应的问题的text选项列表
	 * @param add
	 * @return
	 */
	public List<PollText> getPollTextLists(Criteria add);
}