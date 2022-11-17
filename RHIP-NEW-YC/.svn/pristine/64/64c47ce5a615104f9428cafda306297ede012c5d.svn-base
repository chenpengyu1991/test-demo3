package com.founder.rhip.ep.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ep.IddKnowledgeSurvey;

public interface IIodineNutritionKnowledgeService {

	/**
	 * 获取问卷调查列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IddKnowledgeSurvey> getPageList(Page page, Criteria criteria);

	/**
	 * 获取问卷调查详细
	 * @param id
	 * @return
	 */
	public IddKnowledgeSurvey getDetail(Long id);
	
	/**
	 * 保存问卷调查
	 * @param id
	 * @return
	 */
	public void save(IddKnowledgeSurvey knowledge);
	
	/**
	 * 删除问卷调查
	 * @param id
	 * @return
	 */
	public void delete(IddKnowledgeSurvey knowledge);

	/**
	 * 删除问卷调查
	 * @param id
	 */
	public void delete(Long id);

}
