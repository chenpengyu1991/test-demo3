package com.founder.rhip.ep.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.ep.IddKnowledgeSurvey;
import com.founder.rhip.ehr.repository.ep.IIddKnowledgeSurveyDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;

@Service("iodineNutritionKnowledgeService")
public class IodineNutritionKnowledgeServiceImpl implements IIodineNutritionKnowledgeService, IMergerOrganizationListener {
	@Resource
	private IIddKnowledgeSurveyDao iddKnowledgeSurveyDao;
	
	/**
	 * 获取抽样列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IddKnowledgeSurvey> getPageList(Page page, Criteria criteria) {
		return iddKnowledgeSurveyDao.getPageList(page, criteria, new Order("INVESTIGATE_TIME", false).asc("SAMPLING_ID"));
	}
	
	/**
	 * 获取抽样详细
	 * @param id
	 * @return
	 */
	public IddKnowledgeSurvey getDetail(Long id) {
		return iddKnowledgeSurveyDao.get(id);
	}
	
	/**
	 * 保存抽样详细
	 * @param id
	 * @return
	 */
	@Transactional
	public void save(IddKnowledgeSurvey knowledge) {
		Long id = knowledge.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			iddKnowledgeSurveyDao.insertWithSeq(knowledge, "SEQ_IDD_KNOWLEDGE_SURVEY");
		} else {
			iddKnowledgeSurveyDao.update(knowledge, ServiceUtil.getUpdateProperties(IddKnowledgeSurvey.class));
		}
	}
	
	/**
	 * 删除抽样详细
	 * @param id
	 * @return
	 */
	@Transactional
	public void delete(IddKnowledgeSurvey knowledge) {
		iddKnowledgeSurveyDao.update(knowledge, ServiceUtil.getDeleteProperties());
	}
	
	/**
	 * 删除问卷调查
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		iddKnowledgeSurveyDao.delete(id);
	}
	
	@Override
	public void mergeStation(Organization station,
			List<Organization> stationList) {
		;
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("createOrgan", center.getOrganCode());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("createOrgan", OP.IN, codes);
		iddKnowledgeSurveyDao.update(parameters, criteria);
	}

	@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		;
	}

	@Override
	public void changeRelationOrgVillage(String orgCode,
			String[] newAddVillageCodes) {
		;
	}
}
