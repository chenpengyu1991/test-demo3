package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import com.founder.rhip.ehr.repository.management.IDMFollowupPlanDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.IDmHypertensionConclusionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("healthPalnService")
public class HealthPlanServiceImpl extends AbstractService implements IHealthPalnService {

	@Resource(name = "dmHypertensionConclusionDao")
	private IDmHypertensionConclusionDao dmHypertensionConclusionDao;// 保健计划dao

	@Resource(name = "dmFollowupPlanDao")
	private IDMFollowupPlanDao dMFollowupPlanDao;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao dmDiseaseInfoDao;// 健康管理卡dao

	@Resource(name = "followupPlanService")
	private IFollowupPlanService followupPlanService;

	@Override
	@Transactional
	public void deleteHealthPlan(DmHypertensionConclusion healthPlan) {
		Long planId = healthPlan.getId();
		String disType = healthPlan.getDiseaseType();
		Long personId = healthPlan.getPersonId();
		Assert.notNull(planId, "保健计划主键不可以为空！");
		Assert.notNull(disType, "保健计划类型不能为空！");
		Assert.notNull(personId, "保健计划主键人员id不能为空！");
		// 删除保健计划
		dmHypertensionConclusionDao.delete(planId);
		// 删除未完成的计划
		dMFollowupPlanDao.delete(new Criteria("planId", planId).add("followupId", OP.IS, "NULL"));
		// 更新已经随访的计划,将计划id更新为null
		dMFollowupPlanDao.update(new Parameters("planId", null), new Criteria("planId", planId));

		Criteria cr = new Criteria();
		cr.add("diseaseType", disType);
		cr.add("personId", personId);
		Integer year = dmHypertensionConclusionDao.getMax(cr, "conclusionsOfYear", Integer.class);
		Date date = followupPlanService.getNextPlanDate(personId, disType);
		// 更新下次随访时间和最后一次建立保健计划的年份
		Parameters parameters = null;
		if (EHRConstants.DM_HBP_TYPE.equals(disType)) {
			parameters = new Parameters("nextHbpFollowupDate", date);
			parameters.add("lastHbpPlanYear", year);
		} else {
			parameters = new Parameters("nextDiFollowupDate", date);
			parameters.add("lastDiPlanYear", year);
		}
		// 全部更新包含删除
		dmDiseaseInfoDao.update(parameters, new Criteria("personId", personId));
	}

	@Override
	public DMFollowupPlan searchLastPlan(Criteria criteria) {
		List<DMFollowupPlan> list = dMFollowupPlanDao.getList(criteria, new Order("PLAN_DATE",false));
		if(list!=null&&!list.isEmpty())
			return list.get(0);
		else
			return null;
	}

	@Override
	@Transactional
	public String saveHealthPlan(DmHypertensionConclusion healthPlan) {
		String disType = healthPlan.getDiseaseType();
		Long personId = healthPlan.getPersonId();
		Assert.notNull(disType, "保健计划类型不能为空");
		Assert.notNull(personId, "保健计划主键人员id不能为空");
		Assert.notNull(healthPlan.getConclusionsOfYear(), "保健计划年度未指定");

		Criteria criteria = new Criteria();
		criteria.add("personId", healthPlan.getPersonId());
		criteria.add("diseaseType", healthPlan.getDiseaseType());

		List<DMFollowupPlan> list = new ArrayList<>();

		// update
		if (!ObjectUtil.isNullOrEmpty(healthPlan.getId())) {
			// 当前随访计划,如果已经开始随访,则不可以再被修改
			List<DMFollowupPlan> dmFollowupPlanList = dMFollowupPlanDao.getList(new Criteria("PLAN_ID", healthPlan.getId()));
			for (DMFollowupPlan dMFollowupPlan : dmFollowupPlanList) {
				if (!ObjectUtil.isNullOrEmpty(dMFollowupPlan.getFollowupId())) {
					return "havaFollowup";
				}
			}
            DmHypertensionConclusion old = dmHypertensionConclusionDao.get(healthPlan.getId());
            if(null!=old){
                if (!healthPlan.getConclusionsOfYear().equals(old.getConclusionsOfYear())){
                    return "yearModify";
                }
                healthPlan.setCreateDate(old.getCreateDate());
                healthPlan.setCreateOrganCode(old.getCreateOrganCode());
                healthPlan.setCreateDoctorCode(old.getCreateDoctorCode());
                healthPlan.setIsDelete(old.getIsDelete());
                // 更新
                dmHypertensionConclusionDao.update(healthPlan);
                // 删除旧的随访计划并重新建立
                dMFollowupPlanDao.delete(new Criteria("PLAN_ID", healthPlan.getId()));
                getFollowupPlanEntity(healthPlan, healthPlan.getId(), list);
            }
		} else {
			// 检查是否可以建立保健计划
			int currentYear = DateUtil.getCurrentYear();
			int year = healthPlan.getConclusionsOfYear();
			if (year < currentYear) {
				return "before";
			} else if (year > currentYear) {
				return "after";
			}

			// 检查其他
			List<DmHypertensionConclusion> dmConclusions = dmHypertensionConclusionDao.getList(criteria,"conclusionsOfYear","createDate");
			if (ObjectUtil.isNotEmpty(dmConclusions)) {
				DmHypertensionConclusion max = null;
				for (DmHypertensionConclusion dmConclusion : dmConclusions) {
					// 检查重复
					int conclusionsOfYear = dmConclusion.getConclusionsOfYear();
					if (year == conclusionsOfYear) {
						return "repeat";
					}
					// 获取最后一年计划
					if (null == max) {
						max = dmConclusion;
						continue;
					} else if (max.getConclusionsOfYear() < conclusionsOfYear) {
						max = dmConclusion;
					}
				}

				// 检查上一年度保健计划周期已经满一年
				if (null != max) {
					Date maxCreateDate = DateUtil.add(max.getCreateDate(), Calendar.YEAR, 1);
					if (maxCreateDate.compareTo(healthPlan.getCreateDate()) >= 0) {
						return "less";
					}
				}
			}

			// 建立保健计划
			Number id = dmHypertensionConclusionDao.generatedKey(healthPlan, "ID", null);
			Assert.notNull(id, "保健计划保存失败!");

			// 建立随访计划
			getFollowupPlanEntity(healthPlan, id, list);

		}
		// 保存随访计划
		dMFollowupPlanDao.batchInsert(list);

		// 更新下次随访时间和最后一次建立保健计划的年份
		Integer year = dmHypertensionConclusionDao.getMax(criteria, "conclusionsOfYear", Integer.class);
		Date date = followupPlanService.getNextPlanDate(personId, disType);
		Parameters parameters = null;
		if (EHRConstants.DM_HBP_TYPE.equals(disType)) {
			parameters = new Parameters("nextHbpFollowupDate", date);
			parameters.add("lastHbpPlanYear", year);
		} else {
			parameters = new Parameters("nextDiFollowupDate", date);
			parameters.add("lastDiPlanYear", year);
		}
		dmDiseaseInfoDao.update(parameters, new Criteria("personId", personId));

		return "success";
	}

	private void getFollowupPlanEntity(DmHypertensionConclusion healthPlan, Number id, List<DMFollowupPlan> list) {
		Calendar calendar = Calendar.getInstance();
		if (healthPlan.getDiseaseType().equals("1")) {
			calendar.setTime(new Date());
			for (int i = 0; i < healthPlan.getFollowupTimes(); i++) {
				DMFollowupPlan dMFollowupPlan = new DMFollowupPlan();
				dMFollowupPlan.setPersonId(healthPlan.getPersonId());
				dMFollowupPlan.setPlanId(id.longValue());
				dMFollowupPlan.setDisType("1");
				dMFollowupPlan.setPlanYear(healthPlan.getConclusionsOfYear().toString());
				if(i >0) {
					getNextFollowupDate(calendar, healthPlan.getFollowupTimes());
				}
				dMFollowupPlan.setPlanDate(calendar.getTime());
				list.add(dMFollowupPlan);
			}
		} else if (healthPlan.getDiseaseType().equals("2")) {
			int count = 4;
			//2017.8.14客户提出的需求变更28.   慢病管理-高血压&糖尿病保健计划：分层：低、中、高、很高，默认的随访次数都是4次
			calendar.setTime(new Date());
			for (int i = 0; i < count; i++) {
				DMFollowupPlan dMFollowupPlan = new DMFollowupPlan();
				dMFollowupPlan.setPersonId(healthPlan.getPersonId());
				dMFollowupPlan.setPlanId(id.longValue());
				dMFollowupPlan.setDisType("2");
				dMFollowupPlan.setPlanYear(healthPlan.getConclusionsOfYear().toString());
				if(i > 0) {
					getNextFollowupDate(calendar, count);
				}
				dMFollowupPlan.setPlanDate(calendar.getTime());
				list.add(dMFollowupPlan);
			}
		}
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
	public List<DMFollowupPlan> searchDmFollowupPlanList(Criteria criteria, Order order) {
		return dMFollowupPlanDao.getList(criteria, order);
	}

	@Override
	public List<DMFollowupPlan> queryDmFollowupPlanList(Criteria criteria, Order order) {
		return dMFollowupPlanDao.queryFollowupPlan(criteria, order);
	}

	@Override
	public List<DmHypertensionConclusion> getDmHypertensionConclusions(Criteria criteria) {
		return dmHypertensionConclusionDao.getList(criteria);
	}

	@Override
	public List<DmHypertensionConclusion> getHealthPlanDetailList(Criteria criteria) {
		return dmHypertensionConclusionDao.getHealthPlanDetailList(criteria);
	}

	@Override
	public PageList<DmHypertensionConclusion> getHealthPlanList(Page page, Criteria criteria) {
		return dmHypertensionConclusionDao.getPlanList(page, criteria);
	}
}
