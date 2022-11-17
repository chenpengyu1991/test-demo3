package com.founder.rhip.ehr.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.entity.management.DmStrtumFollowup;
import com.founder.rhip.ehr.entity.management.DmTumorFollowup;


public interface IBrwDiseaseManageService {
	
	public List<DmHypertensionFollowup> getDmHypertensionFollowups(Criteria criteria);
	
	public List<DmDiabeticFollowup> getDmDiabeticFollowups(Criteria criteria);
	
	public List<DmTumorFollowup> getDmTumorFollowups(Criteria criteria);
	
	public List<DmStrtumFollowup> getStrtumFollowups(Criteria criteria);
	
	public DmHypertensionFollowup getDmHypertensionFollowup(Criteria criteria);
	
	public DmDiabeticFollowup getDmDiabeticFollowup(Criteria criteria);
	
	public DmTumorFollowup getDmTumorFollowup(Criteria criteria);
	
	public DmStrtumFollowup getStrtumFollowup(Criteria criteria);
	
	/**
	 * 保健计划详细信息查看
	 * @param       Criteria
	 * @return      Entity
	 */
	public DmHypertensionConclusion getHealthPlanDetail(Criteria criteria);
	
	public List<DmHypertensionConclusion> getDmHypertensionConclusions(Criteria criteria);

	DmDiseaseInfo getDmDiseaseInfo(Criteria criteria);
	
}