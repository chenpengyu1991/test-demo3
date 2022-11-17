package com.founder.rhip.ehr.service.statistics.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;

@Service("hmHealthTarget")
public class HMHealthTarget implements IPublicHealthTarget {
	
	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;

	@Override
	public Float getEHRTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		
		return null;
	}

	@Override
	public Float getHETarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		
		return null;
	}

	@Override
	public Float getVaccinateTarget(List<String> orgCode, Date startDate, Date endDate,
			String targetCode) {
		
		return null;
	}

	@Override
	public Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate,
			String targetCode) {
		
		return null;
	}

	@Override
	public Float getHmTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		Float ret = (float) 0;
		if (StringUtils.equalsIgnoreCase(TargetConstants.HM_APPLY_PERSON_QUANTITY, targetCode)
				|| StringUtils.equalsIgnoreCase(TargetConstants.HM_WHOLE_PHYSICAL_EXAMINATION_REPORT, targetCode)) {
			Criteria criteria = new Criteria();
			if (ObjectUtil.isNotEmpty(orgCode)) {
				criteria.add("INPUT_ORGAN_CODE", OP.IN, orgCode);
			}
            DateUtil.getCriteriaByDateRange(criteria, "examYear", startDate, endDate);
			ret = physicalExamRecordDao.getHMTarget(criteria, targetCode);
		}
		return ret;
	}

	@Override
	public Float getCDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		
		return null;
	}

	@Override
	public Float getIDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		
		return null;
	}

	@Override
	public Float getHSATarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		return null;
	}
}
