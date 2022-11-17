package com.founder.rhip.ehr.service.statistics.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.repository.child.IChildHealthCardDao;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.repository.women.IMotherhoodPeriodFollowupDao;
import com.founder.rhip.ehr.repository.women.IPostnatalFollowupDao;
import com.founder.rhip.ehr.repository.women.IPostpartumDaysHealthInfoDao;
import com.founder.rhip.ehr.repository.women.IPrenatalFollowupDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;

@Service("womanChildrenService")
public class WomanChildrenServiceImpl implements IPublicHealthTarget{
	
	@Autowired
	private INeonatalFamilyVisitDao neonatalFamilyVisitDao;
	
	@Autowired
	private IChildHealthCardDao childHealthCardDao;
	
	@Autowired
	private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;
	
	@Autowired
	private IPrenatalFollowupDao prenatalFollowupDao;
	
	@Autowired
	private IPostnatalFollowupDao postnatalFollowupDao;
	
	@Autowired
	private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;

	@Override
	public Float getEHRTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHETarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getVaccinateTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHmTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getCDMTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getIDMTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHSATarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		switch(targetCode){
		case TargetConstants.FU_YOU_BAO_JIAN_XSEFS:
			//新生儿访视人数
			return neonatalVisitCount(startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_YEJKDA:
			//婴幼儿健康管理数
			return childHealthCardCount(startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_46GL:
			//4-6岁儿童健康管理数
			Calendar calendar = Calendar.getInstance();
			int beginYear46 = calendar.get(Calendar.YEAR) - 6;
			int endYear46 = calendar.get(Calendar.YEAR) - 4;
			return childHealthCardCount(beginYear46, endYear46, startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_06GL:
			//0-6岁儿童保健覆盖数
			calendar = Calendar.getInstance();
			int beginYear06 = calendar.get(Calendar.YEAR) - 6;
	    	int endYear06 = calendar.get(Calendar.YEAR);
	    	return childHealthCardCount(beginYear06, endYear06, startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_ZY:
			//早孕建册数(册)
			return earlyResponseCount(startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_CQ5:
			//产前检查5次及以上孕妇数(人)
			return PrenatalFollowupOver5Count(startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_CHFS:
			//产后访视产妇数(人)
			return postnatalFollowupCount(startDate, endDate);
		case TargetConstants.FU_YOU_BAO_JIAN_CHFS42:
			//产后42天健康检查产妇数
			return postpartumDaysCount(startDate, endDate);
		}
		return -1.0f;
	}
	
	/**
	 * 新生儿访视人数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float neonatalVisitCount(Date startDate, Date endDate){
    	Criteria criteria = new Criteria();
    	DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", startDate, endDate);
    	Long count = neonatalFamilyVisitDao.getNeonatalVisitCount(criteria);
    	return Float.valueOf(ObjectUtil.isNotEmpty(count) ? count : 0f);
	}
	
	/**
	 * 婴幼儿健康管理数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float childHealthCardCount(Date startDate, Date endDate){
		Criteria criteria = new Criteria();
    	DateUtil.getCriteriaByDateRange(criteria, "BUILD_CARD_DATE", startDate, endDate);
    	Long count = childHealthCardDao.getCount(criteria, "id", Long.class);
    	return Float.valueOf(count);
	}
	
	/**
	 * 婴幼儿健康管理数
	 * @param beginYear
	 * @param endYear
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float childHealthCardCount(int beginYear, int endYear, Date startDate, Date endDate){
		Criteria criteria = new Criteria();
    	DateUtil.getCriteriaByYear(criteria, "birthday", beginYear, endYear);
    	DateUtil.getCriteriaByDateRange(criteria, "BUILD_CARD_DATE", startDate, endDate);
    	Long count = childHealthCardDao.getCount(criteria, "id", Long.class);
    	return Float.valueOf(count);
	}
	
	/**
	 * 早孕建册数(册)
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float earlyResponseCount(Date startDate, Date endDate){
		Criteria criteria = new Criteria();
		criteria.add("earlyResponseFlag", 1);
    	DateUtil.getCriteriaByDateRange(criteria, "INTERVIEW_DATE", startDate, endDate);
    	Long count = motherhoodPeriodFollowupDao.getEarlyResponse(criteria);
		return Float.valueOf(ObjectUtil.isNotEmpty(count) ? count : 0f);
	}
	
	/**
	 * 产前检查5次及以上孕妇数(人)
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float PrenatalFollowupOver5Count(Date startDate, Date endDate){
		Criteria criteria = new Criteria();
    	DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", startDate, endDate);
    	Long count = prenatalFollowupDao.prenatalFollowOver5Count(criteria);
    	return Float.valueOf(ObjectUtil.isNotEmpty(count) ? count : 0f);
	}
	
	/**
	 * 产后访视产妇数(人)
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float postnatalFollowupCount(Date startDate, Date endDate){
		Criteria criteria = new Criteria();
    	DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", startDate, endDate);
    	Long count = postnatalFollowupDao.postnatalFollowupCount(criteria);
    	return Float.valueOf(ObjectUtil.isNotEmpty(count) ? count : 0f);
	}
	
	/**
	 * 产后42天健康检查产妇数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private Float postpartumDaysCount(Date startDate, Date endDate){
		Criteria criteria = new Criteria();
    	DateUtil.getCriteriaByDateRange(criteria, "SUPERVISION_DATE", startDate, endDate);
    	Long count = postpartumDaysHealthInfoDao.postpartumDaysCount(criteria);
    	return Float.valueOf(ObjectUtil.isNotEmpty(count) ? count : 0f);
	}

	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		return null;
	}
	

}
