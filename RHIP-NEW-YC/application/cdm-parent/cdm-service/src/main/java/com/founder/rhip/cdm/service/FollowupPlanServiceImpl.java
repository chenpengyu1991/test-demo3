package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.repository.management.*;
import com.founder.rhip.scheduling.core.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 随访计划
 * 
 * @author liuk
 */
@Service("followupPlanService")
public class FollowupPlanServiceImpl extends AbstractService implements IFollowupPlanService{

	@Resource(name = "dmFollowupPlanDao")
	private IDMFollowupPlanDao followupPlanDao;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao diseaseInfoDao;

	@Resource(name = "dmHypertensionConclusionDao")
	private IDmHypertensionConclusionDao dmHypertensionConclusionDao;

	@Resource(name = "dmHypertensionFollowupDao")
	private IDmHypertensionFollowupDao hypertensionFollowupDao;

	@Resource(name = "dmDiabeticFollowupDao")
	private IDmDiabeticFollowupDao dmDiabeticFollowupDao;

	@Override
	@Transactional
	public DMFollowupPlan getLastPlanDate(Long personId, String disType) {
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("disType", disType);
		DMFollowupPlan dmFollowupPlan = followupPlanDao.getLastFollowupPlanDate(criteria);
		if (ObjectUtil.isNullOrEmpty(dmFollowupPlan)) {
			// dmFollowupPlan=new DMFollowupPlan();
		}
		return dmFollowupPlan;
	}

	@Override
	@Transactional
	public Date getNextPlanDate(Long personId, String disType) {
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("disType", disType);
		//criteria.add("planType", "1");
		criteria.add("planDate", OP.GE, DateUtil.makeTimeToZero(DateUtil.add(new Date(), Calendar.MONTH, -1)));
		DMFollowupPlan dmFollowupPlan = followupPlanDao.getNextFollowupPlanDate(criteria);
		Date date = null;
		if (ObjectUtil.isNullOrEmpty(dmFollowupPlan)) {
			// 没有建立随访计划或者计划已经全部执行完毕
		} else {
			date = dmFollowupPlan.getPlanDate();
		}
		return date;
	}

	@Override
	@Transactional
	public boolean generatePlans(int count, int add, String year, String disType, Long personId) {
		return generatePlans(new Date(), count, add, year, disType, personId);
	}

	@Override
	@Transactional
	public boolean generatePlans(Date start, int count, int add, String year, String disType, Long personId) {
		List<DMFollowupPlan> plans = new ArrayList<>(count);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		//TODO 配置文件获取
		int followupTimes = Integer.valueOf(WebProperties.getMsg("hbp.followup.times"));
		for (int i = 1; i <= followupTimes; i++) {
			DMFollowupPlan plan = new DMFollowupPlan();
			
			plan.setDisType(disType);
			plan.setPlanType(EHRConstants.CDM_FOLLOWUP_PLAN);
			//current = DateUtil.add(current, Calendar.MONTH, add);
			getNextFollowupDate(calendar, followupTimes);
			plan.setPlanYear(String.valueOf(calendar.get(Calendar.YEAR)));
			plan.setPlanDate(calendar.getTime());
			plan.setPersonId(personId);
			plans.add(plan);
		}
		followupPlanDao.batchInsert(plans);
		return true;
	}


	
	private DMFollowupPlan updatePlanDate(DMFollowupPlan followupPlan, Date visitDate) {
		String type = followupPlan.getType();
		// 计划类型,只要不为空,认为其是手动新增的计划,将随访日期作为计划日期
		// 添补历史计划用
		if (ObjectUtil.isNotEmpty(type)) {
			followupPlan.setPlanDate(visitDate);
		}
		return followupPlan;
	}

	@Override
	@Transactional
	public DMFollowupPlan updatePlanAndReturnPlan(Long id, Long followupId, Date visitDate) {
		Assert.notNull(id, "随访计划id不能为空");
		Assert.notNull(followupId, " 随访id不能为空");
		Criteria criteria = new Criteria("id", id);
		DMFollowupPlan followupPlan = followupPlanDao.get(criteria);
		Assert.notNull(followupPlan, "指定的随访计划不存在 id为:" + id);
		followupPlan.setFollowupId(followupId);
		followupPlan.setFollowupDate(visitDate);
		updatePlanDate(followupPlan, visitDate);
		followupPlanDao.update(followupPlan);
		return followupPlan;
	}

	@Override
	@Transactional
	public void updatePlan(Long id, Long followupId, Date visitDate) {
		updatePlanAndReturnPlan(id, followupId, visitDate);
	}

	@Override
	@Transactional
	public void updateNextFollowupDate(DMFollowupPlan dmfInfo, Long personId, String disType) {
		// 调用情况:
		// 高血压与糖尿病: 建立保健计划 每次新建随访
		if (ObjectUtil.isNotEmpty(dmfInfo) && "1".equals(dmfInfo.getType())) {
			// 手动新增计划
			return;
		} else {
			Date date = getNextPlanDate(personId,dmfInfo.getPlanDate(), disType);
			doUpdateNextFollowupDate(personId, disType, date);
		}
	}

	@Override
	public void removePlans(Long personId, String disType) {
		Criteria criteria = new Criteria();
		criteria.add("followupId", OP.IS, "NULL");
		criteria.add("personId", personId);
		criteria.add("disType", disType);
		followupPlanDao.delete(criteria);
	}

	// =====================更新管理卡的下次随访日期=================//

	@Override
	public void doUpdateNextFollowupDate(Long personId, String disType, Date date) {
		Criteria criteria = new Criteria("personId", personId);
		Parameters parameters = new Parameters();
		switch (disType) {
		case EHRConstants.DM_HBP_TYPE:
			parameters.add("nextHbpFollowupDate", date);
			break;
		case EHRConstants.DM_DI_TYPE:
			parameters.add("nextDiFollowupDate", date);
			break;
		case EHRConstants.DM_STROKE_TYPE:
			parameters.add("nextStrokeFollowupDate", date);
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			parameters.add("nextCoronaryFollowupDate", date);
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			parameters.add("nextTumorFollowupDate", date);
			break;
		default:
			throw new RuntimeException("疾病类型参数错误!");
		}
		diseaseInfoDao.update(parameters, criteria);
	}

	// =======================脑卒中和冠心病===================//

	@Override
	@Transactional
	public Date buildStrtumPlan(Date start, String followupFlag, String disType, Long personId) {
		// 移除没有随访的计划
		//removePlans(personId, disType);
		// 建立新的计划
		int currentYearString = DateUtil.getCurrentYear();

		if (null == start) {
			start = new Date();
		}
		generatePlans(start, 4, 3, String.valueOf(currentYearString), disType, personId);
		Date date = getNextPlanDate(personId,start, disType);
		Assert.notNull(date, "下次随访日期计算失败");
		return date;
	}
	
	@Override
	@Transactional
	public Date buildStrtumPlan(String followupFlag, String disType, Long personId) {
		// 移除没有随访的计划
		removePlans(personId, disType);
		// 建立新的计划
		int currentYearString = DateUtil.getCurrentYear();


		if (EHRConstants.DM_MANAGED_FULL_ONE_YEAR_FLAG_YES.equals(followupFlag)) {
			// 管理满一年四次
			generatePlans(new Date(), 4, 3, String.valueOf(currentYearString), disType, personId,true);
		} else {
			// 第一年12次
			generatePlans(new Date(), 12, 1, String.valueOf(currentYearString), disType, personId,true);
		}
		Date date = getNextPlanDate(personId,new Date(), disType);
		Assert.notNull(date, "下次随访日期计算失败");
		return date;
	}
	@Transactional
	private boolean generatePlans(Date start, int count, int add, String year, String disType, Long personId, Boolean b) {
		
		return generatePlan(new Date(), count, add, year, disType, personId,b);
	}
	@Override
	@Transactional
	public boolean generatePlan(Date start, int count, int add, String year, String disType, Long personId,Boolean flag) {
		List<DMFollowupPlan> plans = new ArrayList<>(count);
		Date current = start;
		for (int i = 1; i <= count; i++) {
			DMFollowupPlan plan = new DMFollowupPlan();
			plan.setPlanYear(String.valueOf(year));
			plan.setDisType(disType);
			plan.setPlanType(EHRConstants.CDM_FOLLOWUP_PLAN);
			if(i==1) {
				current = DateUtil.add(current, Calendar.MONTH, 0);
			}else {
				current = DateUtil.add(current, Calendar.MONTH, add);
			}
			plan.setPlanDate(current);
			plan.setPersonId(personId);
			plans.add(plan);
		}
		followupPlanDao.batchInsert(plans);
		return true;
	}
	
	@Override
	@Transactional
	public boolean buildStrtumPlanAndUpdNextFollowupDate(Date start, String followupFlag, String disType, Long personId) {
		doUpdateNextFollowupDate(personId, disType, buildStrtumPlan(start, followupFlag, disType, personId));
		return true;
	}

	@Override
	@Transactional
	public boolean buildHbpDiPlanAndUpdNextFollowupDate(String disType,Date date, Long personId) {
		doUpdateNextFollowupDate(personId, disType, buildHbpAndDiPlan(disType, date,personId, false));
		return true;
	}
	// =======================肿瘤===================//

	@Override
	@Transactional
	public void buildTumorPlans(Long personId,String year,Date next ) {
		DMFollowupPlan plan = new DMFollowupPlan();
		plan.setPlanYear(String.valueOf(year));
		plan.setDisType(EHRConstants.DM_TUMOR_TYPE);
		plan.setPlanType(EHRConstants.CDM_FOLLOWUP_PLAN);
		plan.setPlanDate(next);
		plan.setPersonId(personId);
		followupPlanDao.insert(plan);
	}

	@Override
	@Transactional
	public Date buildTumorPlan(Date start, String followupFlag, String disType, Long personId) {
		// 移除没有随访的计划
		//removePlans(personId, disType);
		// 建立新的计划
		int currentYearString = DateUtil.getCurrentYear();

		if (null == start) {
			start = new Date();
		}

        int year = DateUtil.getCurrentYear();
		Date current = start;

        if (EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL.equals(followupFlag)) {
            // 有过一次随访后是生成一年后随访计划
            current = DateUtil.add(current, Calendar.MONTH, 12);
            buildTumorPlans(personId, String.valueOf(year+1), current);
        } else {
            // 新建肿瘤管理卡产生一条30天内随访计划
            //current = DateUtil.add(current, Calendar.MONTH, 1);
            buildTumorPlans(personId, String.valueOf(year), current);
        }

		Date date = getNextPlanDate(personId,start, disType);
		Assert.notNull(date, "下次随访日期计算失败");
		return date;
	}

	@Override
	@Transactional
	public void calTumorPlan(DMFollowupPlan dmfInfo, DmTumorFollowup tumor, Date start, boolean remove) {
		if (ObjectUtil.isNotEmpty(dmfInfo) && "1".equals(dmfInfo.getType())) {
			return;
		}
		if (remove) {
			// 删除旧的随访计划
			removeTumorPlan(tumor);
		}
		int year = DateUtil.getCurrentYear();
		// 肿瘤默认只产生一条计划start, 1, add, String.valueOf(year),
		// EHRConstants.DM_TUMOR_TYPE, tumor.getPersonId()
		buildTumorPlans(tumor.getPersonId(), String.valueOf(year), tumor.getNextVisitDate());
	}

	@Override
	@Transactional
	public void removeTumorPlan(DmTumorFollowup tumor) {
		removePlans(tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
	}

	@Deprecated
	public boolean calTumorPlanByCrtValue(DmTumorFollowup tumor, Date start, boolean remove) {
		if (remove) {
			// 删除旧的随访计划
			removeTumorPlan(tumor);
		}

		/*
		 * 根据卡式评分 建立随访计划 ≥80，1次/年；50-80，2次/年；＜50，1次/月。
		 */
		int value = tumor.getCrtesianValue();// 卡式评分
		// 如果死亡,不需要
		if (value == 0) {
			return true;
		}
		// 年份
		int year = DateUtil.getCurrentYear();
		// 计算时间间隔
		int count = 0;
		if (value >= 80) {
			count = 1;
		} else if (value >= 50) {
			count = 2;
		} else {
			count = 12;
		}
		int add = 12 / count;
		// 生成计划
		// 肿瘤默认只产生一条计划
		boolean result = generatePlans(start, 1, add, String.valueOf(year), EHRConstants.DM_TUMOR_TYPE, tumor.getPersonId());
		if (!result) {
			log.error("新建随访计划失败");
		}
		return result;
	}

	//高血压糖尿病随访计划
	@Override
	@Transactional
	public Date buildHbpAndDiPlan(String disType,Date startDate, Long personId, boolean flag) {
		//BUG0171895: 【慢病管理】不论如何操作此居民，最开始生成的随访计划都不要变
		// 移除没有随访的计划
		//removePlans(personId, disType);
		// 建立新的计划
		getFollowupPlanEntity(personId, disType, flag,startDate);
		Date date = getNextPlanDate(personId, disType);
		Assert.notNull(date, "下次随访日期计算失败");
		return date;
	}

	@Override
	public List<DMFollowupPlan> getFollowPlanList(Criteria criteria) {
		return followupPlanDao.getList(criteria);
	}

	@Override
	public List<String> searchRepeatDate(Criteria criteria) {
		List<String> list = followupPlanDao.searchRepeatDate(criteria);
		return list;
	}

	@Override
	public int clearPlan(Long planId) {
		return followupPlanDao.delete(new Criteria("ID",planId));
	}

	/**
	 * 插入高血压糖尿病随访计划
	 * @param personId
	 * @param diseaseType
	 */
	private void getFollowupPlanEntity(Long personId, String diseaseType, boolean flag,Date date) {
		List<DMFollowupPlan> plans = new ArrayList<DMFollowupPlan>();
		Calendar calendar = Calendar.getInstance();
		if (diseaseType.equals(EHRConstants.DM_HBP_TYPE)) {
			calendar.setTime(new Date());
			//TODO 配置文件获取
			int followupTimes = Integer.valueOf(WebProperties.getMsg("hbp.followup.times"));
			for (int i = 0; i < followupTimes; i++) {
				DMFollowupPlan dMFollowupPlan = new DMFollowupPlan();
				dMFollowupPlan.setPersonId(personId);
				dMFollowupPlan.setDisType(EHRConstants.DM_HBP_TYPE);
				dMFollowupPlan.setPlanType(EHRConstants.CDM_FOLLOWUP_PLAN);
				if((flag && i > 0) || !flag){
					getNextFollowupDate(calendar, followupTimes);
				}
				dMFollowupPlan.setPlanYear(String.valueOf(calendar.get(Calendar.YEAR)));
				dMFollowupPlan.setPlanDate(calendar.getTime());
				plans.add(dMFollowupPlan);
			}
		} else if (diseaseType.equals(EHRConstants.DM_DI_TYPE)) {
			calendar.setTime(new Date());
			//TODO 配置文件获取
			int followupTimes = Integer.valueOf(WebProperties.getMsg("di.followup.times"));
			for (int i = 0; i < followupTimes; i++) {
				DMFollowupPlan dMFollowupPlan = new DMFollowupPlan();
				dMFollowupPlan.setPersonId(personId);
				dMFollowupPlan.setDisType(EHRConstants.DM_DI_TYPE);
				dMFollowupPlan.setPlanType(EHRConstants.CDM_FOLLOWUP_PLAN);
				if((flag && i > 0) || !flag){
					getNextFollowupDate(calendar, followupTimes);
				}
				dMFollowupPlan.setPlanYear(String.valueOf(calendar.get(Calendar.YEAR)));
				dMFollowupPlan.setPlanDate(calendar.getTime());
				plans.add(dMFollowupPlan);
			}
		}
		followupPlanDao.batchInsert(plans);
	}

	private void getNextFollowupDate(Calendar calendar, int times) {
		switch (times) {
			case 1:
				calendar.add(Calendar.MONTH, +12);
				break;
			case 2:
				calendar.add(Calendar.MONTH, +6);
				break;
			case 3:
				calendar.add(Calendar.MONTH, +4);
				break;
			case 4:
				calendar.add(Calendar.MONTH, +3);
				break;
			case 5:
				calendar.add(Calendar.DAY_OF_MONTH, +365 / 5);
				break;
			case 6:
				calendar.add(Calendar.MONTH, +2);
				break;
			case 7:
				calendar.add(Calendar.DAY_OF_MONTH, +365 / 7);
				break;
			case 8:
				calendar.add(Calendar.DAY_OF_MONTH, +365 / 8);
				break;
			case 9:
				calendar.add(Calendar.DAY_OF_MONTH, +365 / 9);
				break;
			case 10:
				calendar.add(Calendar.DAY_OF_MONTH, +365 / 10);
				break;
			case 11:
				calendar.add(Calendar.DAY_OF_MONTH, +365 / 11);
				break;
			case 12:
				calendar.add(Calendar.MONTH, +1);
				break;
		}

	}

	@Override
	public Date getNextPlanDate(Long personId, Date planDate, String disType) {

		Criteria criteria = new Criteria("personId", personId);
		criteria.add("disType", disType);
		//criteria.add("planType", "1");
		criteria.add("planDate",OP.GE, DateUtil.makeTimeToZero(DateUtil.add(new Date(), Calendar.MONTH, -1)));
		DMFollowupPlan dmFollowupPlan = followupPlanDao.getNextFollowupPlanDate(criteria);
		Date date = null;
		if (ObjectUtil.isNullOrEmpty(dmFollowupPlan)) {
			// 没有建立随访计划或者计划已经全部执行完毕
		} else {
			date = dmFollowupPlan.getPlanDate();
		}
		return date;
	
	}

}
