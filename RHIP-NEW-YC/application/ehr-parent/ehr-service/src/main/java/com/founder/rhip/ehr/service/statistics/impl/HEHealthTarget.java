package com.founder.rhip.ehr.service.statistics.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.repository.statistics.IHealthEducationActiveStatisticsDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;


@Service("heHealthTarget")
public class HEHealthTarget implements IPublicHealthTarget {

	@Resource(name = "healthEducationActiveStatisticsDao")
	private IHealthEducationActiveStatisticsDao healthEducationActiveStatisticsDao;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	@Override
	public Float getEHRTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHETarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		Float ret = (float) 0;
		if (ArrayUtils.contains(TargetConstants.HE_TARGETS, targetCode)) {
			if (StringUtils.equalsIgnoreCase(TargetConstants.HE_DELIVERY_MATERIAL_KIND, targetCode)) {
				List<DicItem> items = dictionaryApp.queryDicItem("HE00007"); // 健教教育资料类型字段代码
				return ObjectUtil.isNullOrEmpty(items) ? ret : Float.valueOf(items.size());
			}
			Criteria criteria = new Criteria();
			if (ObjectUtil.isNotEmpty(orgCode)) {
				criteria.add("orgCode", OP.IN, orgCode);
			}
			if (StringUtils.equalsIgnoreCase(TargetConstants.HE_DELIVERY_MATERIAL_QUANTITY, targetCode)) { // 健康资料发放
				DateUtil.getCriteriaByDateRange(criteria, "ISSUE_TIME", startDate, endDate);
			} else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_BULLETIN_BOARD_QUANTITY_UPDATE_QUANTITY, targetCode) ) { // 宣传栏使用频率
				DateUtil.getCriteriaByDateRange(criteria, "USE_TIME", startDate, endDate);
			} else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_SET_BULLETIN_BOARD_QUANTITY, targetCode)) { // 宣传栏数
				DateUtil.getCriteriaByDateRange(criteria, "RESOURCE_RECORD_TIME", startDate, endDate);
			} else {
				DateUtil.getCriteriaByDateRange(criteria, "ACTIVE_TIME", startDate, endDate);
			}
			ret = healthEducationActiveStatisticsDao.getHETarget(criteria, targetCode);
		}
		return ret;
	}

	@Override
	public Float getVaccinateTarget(List<String> orgCode, Date startDate, Date endDate,
			String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate,
			String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHmTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getCDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getIDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHSATarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		return null;
	}
}
