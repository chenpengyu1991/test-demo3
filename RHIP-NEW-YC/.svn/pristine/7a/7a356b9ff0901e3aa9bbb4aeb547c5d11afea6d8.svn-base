package com.founder.rhip.ehr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.entity.management.DmStrtumFollowup;
import com.founder.rhip.ehr.entity.management.DmTumorFollowup;
import com.founder.rhip.ehr.repository.management.IDmDiabeticFollowupDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.IDmHypertensionConclusionDao;
import com.founder.rhip.ehr.repository.management.IDmHypertensionFollowupDao;
import com.founder.rhip.ehr.repository.management.IDmStrtumFollowupDao;
import com.founder.rhip.ehr.repository.management.IDmTumorFollowupDao;

@Service("brwDiseaseManageService")
public class BrwDiseaseManageServiceImpl extends AbstractService implements IBrwDiseaseManageService {

	@Resource
	private IDmHypertensionFollowupDao dmHypertensionFollowupDao;

	@Resource
	private IDmDiabeticFollowupDao dmDiabeticFollowupDao;

	@Resource
	private IDmTumorFollowupDao dmTumorFollowupDao;

	@Resource
	private IDmStrtumFollowupDao dmStrtumFollowupDao;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao diseaseInfoDao;

	@Resource
	private IDmHypertensionConclusionDao dmHypertensionConclusionDao;

	@Override
	public List<DmHypertensionFollowup> getDmHypertensionFollowups(Criteria criteria) {
		return dmHypertensionFollowupDao.getUnDeList(criteria);
	}

	@Override
	public List<DmDiabeticFollowup> getDmDiabeticFollowups(Criteria criteria) {
		return dmDiabeticFollowupDao.getUnDeList(criteria);
	}

	@Override
	public List<DmTumorFollowup> getDmTumorFollowups(Criteria criteria) {
		return dmTumorFollowupDao.getUnDeList(criteria);
	}

	@Override
	public List<DmStrtumFollowup> getStrtumFollowups(Criteria criteria) {
		return dmStrtumFollowupDao.getUnDeList(criteria);
	}

	@Override
	public DmHypertensionFollowup getDmHypertensionFollowup(Criteria criteria) {
		return dmHypertensionFollowupDao.get(criteria);
	}

	@Override
	public DmDiabeticFollowup getDmDiabeticFollowup(Criteria criteria) {
		return dmDiabeticFollowupDao.get(criteria);
	}

	@Override
	public DmTumorFollowup getDmTumorFollowup(Criteria criteria) {
		return dmTumorFollowupDao.get(criteria);
	}

	@Override
	public DmStrtumFollowup getStrtumFollowup(Criteria criteria) {
		return dmStrtumFollowupDao.get(criteria);
	}

	@Override
	public DmHypertensionConclusion getHealthPlanDetail(Criteria criteria) {
		return dmHypertensionConclusionDao.get(criteria);
	}

	@Override
	public List<DmHypertensionConclusion> getDmHypertensionConclusions(Criteria criteria) {
		return dmHypertensionConclusionDao.getList(criteria);
	}

	@Override
	public DmDiseaseInfo getDmDiseaseInfo(Criteria criteria) {
		criteria.add("IS_DELETE", EHRConstants.DELETE_FLG_0);
		DmDiseaseInfo diseaseInfo = diseaseInfoDao.get(criteria);
		return diseaseInfo;
	}

}
