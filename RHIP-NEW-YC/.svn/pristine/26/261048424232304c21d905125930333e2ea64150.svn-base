package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.common.FollowupErrorCode;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.ChronicFollowupInfo;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;
import com.founder.rhip.ehr.repository.management.*;
import com.founder.rhip.ehr.service.ta.ITargetService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 慢病随访管理
 *
 * @author liuk
 */
@Service("followupRecordService")
public class FollowupRecordServiceImpl extends AbstractService implements IFollowupRecordService {


    @Resource(name = "dmDiseaseInfoDao")
    private IDmDiseaseInfoDao dmDiseaseInfoDao;
	@Resource(name = "followupPlanService")
	private IFollowupPlanService followupPlanService;

    @Resource(name="targetService")
    private ITargetService targetService;

	/**
	 * The Hypertension followup dao.
	 */
	@Resource(name = "dmHypertensionFollowupDao")
	private IDmHypertensionFollowupDao hypertensionFollowupDao;

	/**
	 * The Followup plan dao.
	 */
	@Resource(name = "dmFollowupPlanDao")
	private IDMFollowupPlanDao followupPlanDao;

	/**
	 * The Dm diabetic followup dao.
	 */
	@Resource(name = "dmDiabeticFollowupDao")
	private IDmDiabeticFollowupDao dmDiabeticFollowupDao;

	/**
	 * The Dm tumor followup dao.
	 */
	@Resource(name = "dmTumorFollowupDao")
	private IDmTumorFollowupDao dmTumorFollowupDao;

	/**
	 * The Dm strtum followup dao.
	 */
	@Resource(name = "dmStrtumFollowupDao")
	private IDmStrtumFollowupDao dmStrtumFollowupDao;

	/**
	 * The Disease info dao.
	 */
	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao diseaseInfoDao;

	/**
	 * The Organization app.
	 */
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	/**
	 * The Cdm person service.
	 */
	@Resource(name = "cdmPersonService")
	private ICdmPersonService cdmPersonService;

	/**
	 * The Dm icd ten util.
	 */
	@Autowired
	private DmIcdTenUtil dmIcdTenUtil;

	/**
	 * Instantiates a new Followup record service impl.
	 */
	/*public FollowupRecordServiceImpl() {
	}*/

	@Override
	public List<ChronicFollowupInfo> queryNextFollowupInfo(PersonInfo personInfo) {
		Long personId = personInfo.getId();
		Criteria criteria = new Criteria("personId", personId);
		DmDiseaseInfo diseaseInfo = getDiseaseInfo(criteria, "hbpType", "diType", "strokeType", "coronaryType", "tumorType", "personId", "hbpFlag", "diFlag", "strokeFlag", "coronaryFlag",
				"tumorFlag", "nextHbpFollowupDate", "nextDiFollowupDate", "nextStrokeFollowupDate", "nextCoronaryFollowupDate", "nextTumorFollowupDate");
		if (ObjectUtil.isNullOrEmpty(diseaseInfo)) {
			return null;
		}
		return checkNextFollowupDate(diseaseInfo, EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH);
	}

	/**
	 * Gets icd 10 code.
	 *
	 * @param diseaseType
	 *            the disease type
	 * @param diseaseInfo
	 *            the disease info
	 * @return the icd 10 code
	 */
	private String getIcd10Code(String diseaseType, DmDiseaseInfo diseaseInfo) {
		String codeString = "";
		switch (diseaseType) {
		case EHRConstants.DM_HBP_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, diseaseInfo.getHbpType());
			break;
		case EHRConstants.DM_DI_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, diseaseInfo.getDiType());
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, diseaseInfo.getCoronaryType());
			break;
		case EHRConstants.DM_STROKE_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, diseaseInfo.getStrokeType());
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			codeString = diseaseInfo.getTumorIcdTenCode();
			break;
		default:
			log.warn("无法获取icd10code id为" + diseaseInfo.getId() + "当期疾病类型为" + diseaseType);
		}
		return codeString;
	}

	/**
	 * Cal to followup info.
	 *
	 * @param diseaseInfo
	 *            the disease info
	 * @param distype
	 *            the distype
	 * @param flag
	 *            the flag
	 * @param next
	 *            the next
	 * @param range
	 *            the range
	 * @param result
	 *            the result
	 */
	private void calToFollowupInfo(DmDiseaseInfo diseaseInfo, String distype, String flag, Date next, Date range, List<ChronicFollowupInfo> result) {
		if (EHRConstants.DM_MANAGED_FLAG.equals(flag)) {
			if (null != next && range.after(next)) {
				ChronicFollowupInfo followupInfo = new ChronicFollowupInfo();
				followupInfo.setDiseaseType(distype);
				followupInfo.setNextFollowupDate(next);
				DMFollowupPlan followupPlan = followupPlanService.getLastPlanDate(diseaseInfo.getPersonId(), distype);
				if (ObjectUtil.isNotEmpty(followupPlan)) {
					followupInfo.setFollowupDate(followupPlan.getFollowupDate());
					followupInfo.setFollowupTimes(followupPlan.getFollowupCount());
				}
				followupInfo.setIcdCode(getIcd10Code(distype, diseaseInfo));
				followupInfo.setDiseaseType(distype);
				result.add(followupInfo);
			}
		}
	}

	@Override
	public List<ChronicFollowupInfo> checkNextFollowupDate(DmDiseaseInfo diseaseInfo, String followupFlag) {
		Date date = getFollowupNextDateRange(followupFlag);
		List<ChronicFollowupInfo> result = new ArrayList<>();
		calToFollowupInfo(diseaseInfo, EHRConstants.DM_HBP_TYPE, diseaseInfo.getHbpFlag(), diseaseInfo.getNextHbpFollowupDate(), date, result);
		calToFollowupInfo(diseaseInfo, EHRConstants.DM_DI_TYPE, diseaseInfo.getDiFlag(), diseaseInfo.getNextDiFollowupDate(), date, result);
		calToFollowupInfo(diseaseInfo, EHRConstants.DM_STROKE_TYPE, diseaseInfo.getStrokeFlag(), diseaseInfo.getNextStrokeFollowupDate(), date, result);
		calToFollowupInfo(diseaseInfo, EHRConstants.DM_TUMOR_TYPE, diseaseInfo.getTumorFlag(), diseaseInfo.getNextTumorFollowupDate(), date, result);
		calToFollowupInfo(diseaseInfo, EHRConstants.DM_CORONARY_TYPE, diseaseInfo.getCoronaryFlag(), diseaseInfo.getNextCoronaryFollowupDate(), date, result);
		return result;
	}

	/**
	 * Sets disease info list default param.
	 *
	 * @param organization
	 *            the organization
	 * @param roleType
	 *            the role type
	 * @param criteria
	 *            the criteria
	 */
	private void setDiseaseInfoListDefaultParam(Organization organization, RoleType roleType, Criteria criteria) {
		criteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		if (RoleType.ZMB.equals(roleType)) {
			criteria.add("dmDiseaseInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if(RoleType.ZXMB.equals(roleType)) {
			//中心角色-查询条件新增中心本身
			Criteria caCenter = new Criteria("dmPersonInfo.CREATE_CENTER_ORGAN_CODE", organization.getOrganCode());
			Criteria caStation = new Criteria("dmPersonInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
			caCenter.add(LOP.OR,caStation);
			criteria.add(caCenter);
		}
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add("dmDiseaseInfo.hbp_flag", isDelete);
		criteria.add(LOP.OR, "dmDiseaseInfo.di_flag", isDelete);
		criteria.add(LOP.OR, "dmDiseaseInfo.stroke_flag", isDelete);
		criteria.add(LOP.OR, "dmDiseaseInfo.coronary_flag", isDelete);
		criteria.add(LOP.OR, "dmDiseaseInfo.tumor_flag", isDelete);
		return criteria;
	}

	@Override
	public Map<String, Long> getToFollowupCount(Organization organization, RoleType roleType) {
		Map<String, Long> result = new HashMap<String, Long>(4);
		Criteria criteria = new Criteria("DMDISEASEINFO.status", EHRConstants.DM_MANAGE_STATUS_NORMAL);
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		String orgCodeList="";
		if(RoleType.ZXMB.equals(roleType)){
			orgCodeList = organization.getOrganCode();
		}
		Date nowDate = new Date();
		// 今日
		Criteria criteriaToday = new Criteria();
		criteriaToday.add("beginDate", nowDate);
		criteriaToday.add("endDate", nowDate);
		criteriaToday.add(criteria);
		Long todayCount = diseaseInfoDao.getManageCardCount(criteriaToday, orgCodeList);
		// 本周
		Criteria thisWeekCriteria = new Criteria();
		thisWeekCriteria.add("beginDate", DateUtil.add(nowDate, Calendar.DAY_OF_MONTH, -7));
		thisWeekCriteria.add("endDate", DateUtil.add(nowDate, Calendar.DAY_OF_MONTH, 7));
		thisWeekCriteria.add(criteria);
		Long thisWeekCount = diseaseInfoDao.getManageCardCount(thisWeekCriteria, orgCodeList);
		// 本月
		Criteria thisMonthCriteria = new Criteria();
		thisMonthCriteria.add("beginDate", DateUtil.add(nowDate, Calendar.MONTH, -1));
		thisMonthCriteria.add("endDate", DateUtil.add(nowDate, Calendar.MONTH, 1));
		thisMonthCriteria.add(criteria);
		Long thisMonthCount = diseaseInfoDao.getManageCardCount(thisMonthCriteria, orgCodeList);
		// 过期 往年已过期的不算 既往不咎 新的一年就不会显示往年已过期的
		Date dateBegin =  DateUtil.getDateByYearMonthDay(DateUtil.getCurrentYear(), 0, 1);
		Date dateEnd =  DateUtil.add(nowDate, Calendar.MONTH, -1);
		Criteria expireCriteria = new Criteria();
		expireCriteria.add(criteria);
		expireCriteria.add("beginDate", dateBegin);
		expireCriteria.add("endDate", dateEnd);
		//DateUtil.getCriteriaByDateRange(expireCriteria,"plan_date", dateBegin, dateEnd);
		Long expireCount = diseaseInfoDao.getManageCardCount(expireCriteria, orgCodeList);
		// 结果
		result.put("todayCount", todayCount);
		result.put("thisWeekCount", thisWeekCount);
		result.put("thisMonthCount", thisMonthCount);
		result.put("expireCount", expireCount);
		return result;
	}

	@Override
	public Date getFollowupNextDateRange(String followupFlag) {
		Date date = new Date();
		switch (followupFlag) {
		case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
			date = DateUtil.makeTimeToMax(date);
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.DAY_OF_MONTH, 7));
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, 1));
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, -1));
			break;
		}
		return date;
	}

	@Override
	public Criteria createToFollowupDateRange(String followupFlag) {
		Date date = getFollowupNextDateRange(followupFlag);
		return createToFollowupDateRange(date, followupFlag);
	}

	@Override
	public Criteria createToFollowupDateRange(Date date, String followupFlag) {
		date = DateUtil.makeTimeToMax(date);
		Criteria nextHbpFollowupDate = new Criteria("dmDiseaseInfo.hbp_Flag", EHRConstants.DM_MANAGED_FLAG);
		Criteria nextDiFollowupDate = new Criteria("dmDiseaseInfo.di_Flag", EHRConstants.DM_MANAGED_FLAG);
		Criteria nextStrokeFollowupDate = new Criteria("dmDiseaseInfo.stroke_Flag", EHRConstants.DM_MANAGED_FLAG);
		Criteria nextCoronaryFollowupDate = new Criteria("dmDiseaseInfo.coronary_Flag", EHRConstants.DM_MANAGED_FLAG);
		Criteria nextTumorFollowupDate = new Criteria("dmDiseaseInfo.tumor_Flag", EHRConstants.DM_MANAGED_FLAG);
		switch (followupFlag) {
			case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
				Date dateBeginToday = DateUtil.makeTimeToZero(date);
				DateUtil.getCriteriaByDateRange(nextHbpFollowupDate,"nextHbpFollowupDate", dateBeginToday, date );
				DateUtil.getCriteriaByDateRange(nextDiFollowupDate,"nextDiFollowupDate", dateBeginToday, date );
				DateUtil.getCriteriaByDateRange(nextStrokeFollowupDate,"nextStrokeFollowupDate", dateBeginToday, date );
				DateUtil.getCriteriaByDateRange(nextCoronaryFollowupDate,"nextCoronaryFollowupDate", dateBeginToday, date );
				DateUtil.getCriteriaByDateRange(nextTumorFollowupDate,"nextTumorFollowupDate", dateBeginToday, date );
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
				Date dateBeginWeek = DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.DAY_OF_MONTH, -7));
				DateUtil.getCriteriaByDateRange(nextHbpFollowupDate,"nextHbpFollowupDate", dateBeginWeek, date );
				DateUtil.getCriteriaByDateRange(nextDiFollowupDate,"nextDiFollowupDate", dateBeginWeek, date );
				DateUtil.getCriteriaByDateRange(nextStrokeFollowupDate,"nextStrokeFollowupDate", dateBeginWeek, date );
				DateUtil.getCriteriaByDateRange(nextCoronaryFollowupDate,"nextCoronaryFollowupDate", dateBeginWeek, date );
				DateUtil.getCriteriaByDateRange(nextTumorFollowupDate,"nextTumorFollowupDate", dateBeginWeek, date );
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
				Date dateBeginMonth = DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.MONTH, -1));
				DateUtil.getCriteriaByDateRange(nextHbpFollowupDate,"nextHbpFollowupDate", dateBeginMonth, date );
				DateUtil.getCriteriaByDateRange(nextDiFollowupDate,"nextDiFollowupDate", dateBeginMonth, date );
				DateUtil.getCriteriaByDateRange(nextStrokeFollowupDate,"nextStrokeFollowupDate", dateBeginMonth, date );
				DateUtil.getCriteriaByDateRange(nextCoronaryFollowupDate,"nextCoronaryFollowupDate", dateBeginMonth, date );
				DateUtil.getCriteriaByDateRange(nextTumorFollowupDate,"nextTumorFollowupDate", dateBeginMonth, date );
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED:
				Date dateBegin =  DateUtil.getDateByYearMonthDay(DateUtil.getCurrentYear(), 0, 1);
				DateUtil.getCriteriaByDateRange(nextHbpFollowupDate,"nextHbpFollowupDate", dateBegin, date );
				DateUtil.getCriteriaByDateRange(nextDiFollowupDate,"nextDiFollowupDate", dateBegin, date );
				DateUtil.getCriteriaByDateRange(nextStrokeFollowupDate,"nextStrokeFollowupDate", dateBegin, date );
				DateUtil.getCriteriaByDateRange(nextCoronaryFollowupDate,"nextCoronaryFollowupDate", dateBegin, date );
				DateUtil.getCriteriaByDateRange(nextTumorFollowupDate,"nextTumorFollowupDate", dateBegin, date );
				break;
		}
		Criteria dateParam = new Criteria();
		dateParam.add(LOP.OR, nextHbpFollowupDate);
		dateParam.add(LOP.OR, nextDiFollowupDate);
		dateParam.add(LOP.OR, nextStrokeFollowupDate);
		dateParam.add(LOP.OR, nextCoronaryFollowupDate);
		dateParam.add(LOP.OR, nextTumorFollowupDate);
		return new Criteria().add(dateParam);
	}

	// ==高血压==//
	@Override
	@Transactional
	public boolean saveHbp(DmHypertensionFollowup hbp, Organization organization, User user) {
		doSaveHbp(hbp, organization, user);
        tryAddTargetValue(hbp, organization, user);
		return true;
	}



    @Override
	public DmHypertensionFollowup getHbp(Criteria criteria) {
		DmHypertensionFollowup hbpId = hypertensionFollowupDao.get(criteria);
		return hbpId;
	}

	/**
	 * 保存高血压随访记录
	 *
	 * @param hbp
	 *            the hbp
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 */
	private void doSaveHbp(DmHypertensionFollowup hbp, Organization organization, User user) {
		Long id = hbp.getId();
		DMFollowupPlan dmfInfo = followupPlanDao.get(hbp.getPlanId());
		Assert.notNull(dmfInfo, "无法获取计划id为:" + hbp.getPlanId());
		if (ObjectUtil.isNotEmpty(id)) {
			setInputInfo(false, hbp, organization, user);
			hypertensionFollowupDao.update(hbp);
			followupPlanService.updatePlan(hbp.getPlanId(), hbp.getId(), hbp.getVisitDate());
		} else {
			setInputInfo(true, hbp, organization, user);
			Number newId = hypertensionFollowupDao.generatedKey(hbp, "ID", null);
			Assert.notNull(newId, "高血压随访增加失败");
			id = newId.longValue();
			hbp.setId(id);
			/**
			 * 若此次随访分类为控制不满意或不良反应或者有药物不良反应
			 * （满足其一），需要生成两周内的随访，下次随访还是此类状况，需要开转诊单，再生成一次两周内的随访，
			 * 随访后此流程结束。然后再进行下一轮正常的随访。
			 */
			if(ObjectUtil.equals(hbp.getVisitType(), "2") || ObjectUtil.equals(hbp.getVisitType(), "3")
					|| ObjectUtil.equals(hbp.getSideEffects(), "2")) {
				DMFollowupPlan dmFollowupPlan = new DMFollowupPlan();
				this.setFollowupPlanValueForHBP(hbp, dmFollowupPlan);
				followupPlanDao.insert(dmFollowupPlan);
			}
			followupPlanService.updatePlan(hbp.getPlanId(), hbp.getId(), hbp.getVisitDate());
			Date date = followupPlanService.getNextPlanDate(hbp.getPersonId(),dmfInfo.getPlanDate(), EHRConstants.DM_HBP_TYPE);
			if (null != date) {
				followupPlanService.updateNextFollowupDate(dmfInfo, hbp.getPersonId(), EHRConstants.DM_HBP_TYPE);
			} else {
				DmDiseaseInfo dmDiseaseInfo = getDiseaseInfo(hbp.getPersonId());
				Assert.notNull(dmDiseaseInfo, "管理卡不存在,请检查是否删除或者已经注销");
				if(ObjectUtil.isNotEmpty( hbp.getPlanType())) {
					if(!hbp.getPlanType().equals("3")) {
						followupPlanService.buildHbpDiPlanAndUpdNextFollowupDate(EHRConstants.DM_HBP_TYPE,dmfInfo.getPlanDate(), hbp.getPersonId());
					}
				}
				
			}
		}
	}

	/**
	 *
	 * @param followup 高血压随访
	 * @param plan
	 */
	private void setFollowupPlanValueForHBP(DmHypertensionFollowup followup, DMFollowupPlan plan) {
		plan.setPersonId(followup.getPersonId());
		plan.setReasonFollowId(followup.getId());
		plan.setDisType(EHRConstants.DM_HBP_TYPE);
		Date visitDate = DateUtil.getAfterDay(followup.getVisitDate(), 15);
		plan.setPlanYear(String.valueOf(DateUtil.getYearByDate(visitDate)));
		plan.setPlanDate(visitDate);
		//plan.setFollowupDate(followup.getVisitDate());
		plan.setPlanType(EHRConstants.CDM_FOLLOWUP_DISCONTENT);
		plan.setIsDelete(EHRConstants.DELETE_FLG_0);
	}

	// ==糖尿病==//
	@Override
	@Transactional
	public boolean saveDi(DmDiabeticFollowup di, Organization organization, User user) {
		doSaveDi(di, organization, user);
        tryAddTargetValue(di, organization, user);
		return true;
	}

	@Override
	public DmDiabeticFollowup getDi(Criteria criteria) {
		DmDiabeticFollowup diabeticFollowup = dmDiabeticFollowupDao.get(criteria);
		return diabeticFollowup;
	}

	/**
	 * 保存糖尿病随访记录
	 *
	 * @param di
	 *            the di
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 */
	private void doSaveDi(DmDiabeticFollowup di, Organization organization, User user) {
		DMFollowupPlan dmfInfo = followupPlanDao.get(di.getPlanId());
		Assert.notNull(dmfInfo, "无法获取计划id为:" + di.getPlanId());
		Long id = di.getId();
		if (ObjectUtil.isNotEmpty(id)) {
			setInputInfo(false, di, organization, user);
			dmDiabeticFollowupDao.update(di);
			followupPlanService.updatePlan(di.getPlanId(), di.getId(), di.getVisitDate());
		} else {
			setInputInfo(true, di, organization, user);
			Number newId = dmDiabeticFollowupDao.generatedKey(di, "ID", null);
			Assert.notNull(newId, "新增糖尿病随访保存失败");
			id = newId.longValue();
			di.setId(id);
			/**
			 * 若此次随访分类为控制不满意或不良反应或者有药物不良反应
			 * （满足其一），需要生成两周内的随访，下次随访还是此类状况，需要开转诊单，再生成一次两周内的随访，
			 * 随访后此流程结束。然后再进行下一轮正常的随访。
			 */
			if(ObjectUtil.equals(di.getVisitType(), "2") || ObjectUtil.equals(di.getVisitType(), "3")
					|| ObjectUtil.equals(di.getDrugReaction(), "2")) {
				DMFollowupPlan dmFollowupPlan = new DMFollowupPlan();
				this.setFollowupPlanValueForDI(di, dmFollowupPlan);
				followupPlanDao.insert(dmFollowupPlan);
			}
			log.info("新增 糖尿病随访记录:" + id);
			followupPlanService.updatePlan(di.getPlanId(), di.getId(), di.getVisitDate());
			Date date = followupPlanService.getNextPlanDate(di.getPersonId(),dmfInfo.getPlanDate(), EHRConstants.DM_DI_TYPE);
			if (null != date) {
				followupPlanService.updateNextFollowupDate(dmfInfo, di.getPersonId(), EHRConstants.DM_DI_TYPE);
			} else {
				DmDiseaseInfo dmDiseaseInfo = getDiseaseInfo(di.getPersonId());
				Assert.notNull(dmDiseaseInfo, "管理卡不存在,请检查是否删除或者已经注销");
				if(ObjectUtil.isNotEmpty( di.getPlanType())) {
					if(!di.getPlanType().equals("3")) {
				followupPlanService.buildHbpDiPlanAndUpdNextFollowupDate(EHRConstants.DM_DI_TYPE,dmfInfo.getPlanDate(), di.getPersonId());
					}
				}
			}
		}
	}

	
	/**
	 * 保存脑卒中冠心病随访记录
	 *
	 * @param followup
	 *            the followup
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 */

	private void doSaveStrtum(DmStrtumFollowup followup, Organization organization, User user) {
		Long id = followup.getId();
		DMFollowupPlan dmfInfo = followupPlanDao.get(followup.getPlanId());
		Assert.notNull(dmfInfo, "无法获取计划id为:" + followup.getPlanId());
		String disType = followup.getDiseaseType();
		if (ObjectUtil.isNotEmpty(id)) {
			setInputInfo(false, followup, organization, user);
			dmStrtumFollowupDao.update(followup);
			followupPlanService.updatePlan(followup.getPlanId(), followup.getId(), followup.getVisitDate());
		} else {
			setInputInfo(true, followup, organization, user);
			Number newId = dmStrtumFollowupDao.generatedKey(followup, "ID", null);
			Assert.notNull(newId, "保存脑卒中冠心病随访失败");
			id = newId.longValue();
			followup.setId(id);
			log.info("新增 脑卒中冠心病随访记录:" + id);
//			followupPlanService.updatePlan(followup.getPlanId(), followup.getId(), followup.getVisitDate());
//			Long personId = followup.getPersonId();
//			updateNextPlanDateAndCheckToBuildNewPlan(dmfInfo, disType, personId);
			
			followupPlanService.updatePlan(followup.getPlanId(), followup.getId(), followup.getVisitDate());
			Date date = followupPlanService.getNextPlanDate(followup.getPersonId(),dmfInfo.getPlanDate(), dmfInfo.getDisType());
			if (null != date) {
				followupPlanService.updateNextFollowupDate(dmfInfo, followup.getPersonId(), dmfInfo.getDisType());
			} else {
				DmDiseaseInfo dmDiseaseInfo = getDiseaseInfo(followup.getPersonId());
				Assert.notNull(dmDiseaseInfo, "管理卡不存在,请检查是否删除或者已经注销");
				if(ObjectUtil.isNotEmpty( followup.getPlanType())) {
					if(!followup.getPlanType().equals("3")) {
				//followupPlanService.buildHbpDiPlanAndUpdNextFollowupDate(dmfInfo.getDisType(),dmfInfo.getPlanDate(), followup.getPersonId());
				updateNextPlanDateAndCheckToBuildNewPlan(dmfInfo, disType, followup.getPersonId());
					}
					}
			}
		}
	}
	/**
	 *
	 * @param followup 糖尿病隨訪
	 * @param plan
	 */
	private void setFollowupPlanValueForDI(DmDiabeticFollowup followup, DMFollowupPlan plan) {
		plan.setPersonId(followup.getPersonId());
		plan.setReasonFollowId(followup.getId());
		plan.setDisType(EHRConstants.DM_DI_TYPE);
		Date visitDate = DateUtil.getAfterDay(followup.getVisitDate(), 15);
		plan.setPlanYear(String.valueOf(DateUtil.getYearByDate(visitDate)));
		plan.setPlanDate(visitDate);
		plan.setPlanType(EHRConstants.CDM_FOLLOWUP_DISCONTENT);
		//plan.setFollowupDate(followup.getVisitDate());
		plan.setIsDelete(EHRConstants.DELETE_FLG_0);
	}

	// ==肿瘤==//
	@Override
	public DmTumorFollowup getTumor(Criteria criteria) {
		DmTumorFollowup tumor = dmTumorFollowupDao.get(criteria);
		return tumor;
	}

	@Override
	@Transactional
	public Set<String> saveTumor(DmTumorFollowup tumor, Organization organization, User user) {
		Long id = tumor.getId();
		if (ObjectUtil.isNotEmpty(id)) {
			return doUpdateTumor(tumor, organization, user, id);
		} else {
			return doAddTumor(tumor, organization, user);
		}
	}

	/**
	 * Do add tumor.
	 *
	 * @param tumor
	 *            the tumor
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 * @return the set
	 */
	private Set<String> doAddTumor(DmTumorFollowup tumor, Organization organization, User user) {
		Set<String> resutCodes = new HashSet<>();
		if (EHRConstants.DM_FOLLOWUP_TUMOR_LAST.equals(tumor.getFollowupFlag())) {
			if (!isHasTumorFirstrFollowup(tumor.getPersonId())) {
				resutCodes.add(FollowupErrorCode.TUMOR_NO_FIRST_FOLLOWUP.getValue());
				return resutCodes;
			}
		}
		Long id;
		setInputInfo(true, tumor, organization, user);
        //末次随访的
        if(ObjectUtil.isNotEmpty(tumor.getCancelDate())){
            tumor.setVisitDate(tumor.getCancelDate());
        }
		Number newNumberId = dmTumorFollowupDao.generatedKey(tumor, "ID", null);
		Assert.notNull(newNumberId, "肿瘤随访记录保存失败");
		id = newNumberId.longValue();
		tumor.setId(id);
				if (EHRConstants.DM_FOLLOWUP_TUMOR_FIRST.equals(tumor.getFollowupFlag())) {
					addTumorFirstFollowup(tumor);
				} else if (EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL.equals(tumor.getFollowupFlag())) {
					addTumorFollowup(tumor);
				} else if (EHRConstants.DM_FOLLOWUP_TUMOR_LAST.equals(tumor.getFollowupFlag())) {
					addTumorLastFollowup(tumor);
		}
		return resutCodes;
	}

	/**
	 * Check tumor.
	 *
	 * @param personId
	 *            the personId
	 * @return the boolean
	 */
    @Override
	public boolean isHasTumorFirstrFollowup(Long personId) {
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add("followupFlag", EHRConstants.DM_FOLLOWUP_TUMOR_FIRST);
		Integer firstCount = dmTumorFollowupDao.getCount(criteria, "ID", Integer.class);
		return firstCount > 0;
	}

	/**
	 * Check tumor.
	 *
	 * @param personId
	 *            the personId
	 * @return the boolean
	 */
	@Override
	public boolean isHasTumorFollowup(Long personId) {
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add("followupFlag", EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL);
		Integer count = dmTumorFollowupDao.getCount(criteria, "ID", Integer.class);
		return count > 0;
	}

	/**
	 * Do update tumor.
	 *
	 * @param tumor
	 *            the tumor
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 * @param id
	 *            the id
	 * @return the set
	 */
	private Set<String> doUpdateTumor(DmTumorFollowup tumor, Organization organization, User user, Long id) {
		Set<String> resutCodes = new HashSet<>();
		DmTumorFollowup oldFollowup = dmTumorFollowupDao.get(id);
		if (ObjectUtil.isNullOrEmpty(oldFollowup)) {
			log.error("肿瘤随访记录 获取失败 id:" + id);
			resutCodes.add(FollowupErrorCode.TUMOR_SAVE_ERROR.getValue());
			return resutCodes;
		}

		if (EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL.equals(tumor.getFollowupFlag())) {
			updateTumorFollowup(tumor, oldFollowup);
		} else if (EHRConstants.DM_FOLLOWUP_TUMOR_FIRST.equals(tumor.getFollowupFlag())) {
			updateTumorFirstFollowup(tumor, oldFollowup);
		} else if (EHRConstants.DM_FOLLOWUP_TUMOR_LAST.equals(tumor.getFollowupFlag())) {
			followupPlanService.removePlans(tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
		}
		setInputInfo(false, tumor, organization, user);
		dmTumorFollowupDao.update(tumor);
		return resutCodes;
	}

	/**
	 * Gets tumor last plan date.
	 *
	 * @param tumor
	 *            the tumor
	 * @return the tumor last plan date
	 */
	@SuppressWarnings("unused")
	private Date getTumorLastPlanDate(DmTumorFollowup tumor) {
		DMFollowupPlan last = followupPlanService.getLastPlanDate(tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
		Date startDate = null;
		if (ObjectUtil.isNotEmpty(last)) {
			startDate = last.getFollowupDate();
		}
		if (ObjectUtil.isNullOrEmpty(startDate)) {
			startDate = new Date();
		}
		return startDate;
	}

	/**
	 * Add tumor followup.
	 *
	 * @param tumor
	 *            the tumor
	 */
	private void addTumorFollowup(DmTumorFollowup tumor) {
		DMFollowupPlan dmfInfo = followupPlanDao.get(tumor.getPlanId());
		Assert.notNull(dmfInfo, "无法获取计划id为:" + tumor.getPlanId());
		// 更新随访计划
		DMFollowupPlan plan = followupPlanService.updatePlanAndReturnPlan(tumor.getPlanId(), tumor.getId(), tumor.getVisitDate());
		if (ObjectUtil.isNullOrEmpty(plan)) {
			return;
		}
		Date startDate = new Date();

        // followupPlanService.calTumorPlan(dmfInfo, tumor, startDate, true);
        if(!ObjectUtil.equals(tumor.getDeath(),"1") && !ObjectUtil.equals(tumor.getCancel(),"1")) {
            followupPlanService.buildTumorPlan(dmfInfo.getPlanDate(), tumor.getFollowupFlag(), EHRConstants.DM_TUMOR_TYPE, tumor.getPersonId());
        }

        followupPlanService.updateNextFollowupDate(dmfInfo, tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
	}

	/**
	 * Add tumor first followup.
	 *
	 * @param tumor
	 *            the tumor
	 */
	private void addTumorFirstFollowup(DmTumorFollowup tumor) {
		followupPlanService.calTumorPlan(null, tumor, new Date(), false);
        followupPlanService.updateNextFollowupDate(null, tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
	}

	/**
	 * Add tumor last followup.
	 *
	 * @param tumor
	 *            the tumor
	 */
	private void addTumorLastFollowup(DmTumorFollowup tumor) {
		followupPlanService.removePlans(tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
		followupPlanService.doUpdateNextFollowupDate(tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE, null);
	}

	/**
	 * Update tumor first followup.
	 *
	 * @param tumor
	 *            the tumor
	 * @param oldFollowup
	 *            the old followup
	 */
	private void updateTumorFirstFollowup(DmTumorFollowup tumor, DmTumorFollowup oldFollowup) {
		// 修改首次随访,只有没有随访时才可以修改随访计划
		if (!hasTumorLastFollowup(tumor) && !isHasTumorFollowup(tumor)) {
			followupPlanService.calTumorPlan(null, tumor, new Date(), true);
            followupPlanService.updateNextFollowupDate(null, tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
		}
	}

	/**
	 * Has tumor last followup.
	 *
	 * @param tumor
	 *            the tumor
	 * @return the boolean
	 */
	private boolean hasTumorLastFollowup(DmTumorFollowup tumor) {
		Criteria criteria = new Criteria();
		criteria.add("personId", tumor.getPersonId());
		criteria.add("followupFlag", EHRConstants.DM_FOLLOWUP_TUMOR_LAST);
		Long count = dmTumorFollowupDao.getCount(criteria, "id", Long.class);
		return count > 0;
	}


	private void updateTumorFollowup(DmTumorFollowup tumor, DmTumorFollowup oldFollowup) {
		DMFollowupPlan dmfInfo = followupPlanDao.get(tumor.getPlanId());
		Assert.notNull(dmfInfo, "无法获取计划id为:" + tumor.getPlanId());
		// 更新随访计划
		followupPlanService.updatePlanAndReturnPlan(tumor.getPlanId(), tumor.getId(), tumor.getVisitDate());

        /**
         * 若此次随访死亡选否或撤销随访选否
         * 需要生成下一年的随访，
         * 随访后此流程结束。然后再进行下一轮正常的随访。
         */
        if(!ObjectUtil.equals(tumor.getDeath(), "1") && !ObjectUtil.equals(tumor.getCancel(), "1")&&ObjectUtil.isNotEmpty(tumor.getDeath())&&ObjectUtil.isNotEmpty(tumor.getCancel())) {
            followupPlanService.buildTumorPlan(dmfInfo.getPlanDate(), tumor.getFollowupFlag(), EHRConstants.DM_TUMOR_TYPE, tumor.getPersonId());
        }

//		if (isLatestTumorFollowup(tumor) && !isHasEndTumorFollowup(tumor.getPersonId())) {
//			Date startDate =tumor.getDefinitionNextDate();
//			followupPlanService.calTumorPlan(dmfInfo, tumor, startDate, true);
//            followupPlanService.updateNextFollowupDate(dmfInfo, tumor.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
//		}
	}

	/**
	 * 肿瘤是否已经随访
	 *
	 * @param tumor
	 *            the tumor
	 * @return boolean
	 */
	private boolean isHasTumorFollowup(DmTumorFollowup tumor) {
		Criteria criteria = new Criteria();
		criteria.add("personId", tumor.getPersonId());
		criteria.add("followupFlag", "2");
		Long count = dmTumorFollowupDao.getCount(criteria, "id", Long.class);
		return count > 0;
	}

	/**
	 * 肿瘤是否已经随访
	 *
	 * @param personId
	 *            the tumor
	 * @return boolean
	 */
    @Override
	public boolean isHasEndTumorFollowup(Long personId) {
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add("followupFlag", EHRConstants.DM_FOLLOWUP_TUMOR_LAST);
		Long count = dmTumorFollowupDao.getCount(criteria, "id", Long.class);
		return count > 0;
	}

	/**
	 * 是不是最新一次的随访
	 *
	 * @param tumor
	 *            the tumor
	 * @return boolean
	 */
	private boolean isLatestTumorFollowup(DmTumorFollowup tumor) {
		Criteria criteria = new Criteria();
		criteria.add("personId", tumor.getPersonId());
		criteria.add("followupFlag", tumor.getFollowupFlag());
		Long id = dmTumorFollowupDao.getMax(criteria, "id", Long.class);
		return tumor.getId().equals(id);
	}

	// ==脑卒中冠心病==//
	@Override
	public List<DMFollowupPlan> getStrokeFollowupPlans(Criteria plan) {
		List<DMFollowupPlan> plans = followupPlanDao.queryStrokePlans(plan);
		return plans;
	}

	@Override
	public DmStrtumFollowup getStrtum(Criteria criteria) {
		DmStrtumFollowup followup = dmStrtumFollowupDao.get(criteria);
		String nonDrugs = followup.getNonDrugs();
		if (!StringUtil.isEmpty(nonDrugs)){
			String nonDrugsArray[] = nonDrugs.split(",");
			followup.setNonDrugsArray(nonDrugsArray);
		}
		return followup;
	}

	@Override
	@Transactional
	public boolean saveStrtum(DmStrtumFollowup followup, Organization organization, User user) {
		doSaveStrtum(followup, organization, user);
        tryAddTargetValue(followup, organization, user);
		return true;
	}

	@Override
	public String getFollowupType(DmDiseaseInfo dis, String diseaseType, String flag) {
		// return EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_ONE;
		return doGetFollowupType(dis, diseaseType, flag);
	}

	private String doGetFollowupType(DmDiseaseInfo dis, String diseaseType, String flag) {
		// 两种类型随访表单已经相同,仅次数不同
		if (!EHRConstants.DM_MANAGED_FULL_ONE_YEAR_FLAG_YES.equals(flag)) {
			// 无法判断次数
			// Criteria followup = new Criteria();
			// followup.add("followupFlag",
			// EHRConstants.DM_FOLLOWUP_TYPE_STANDARD);
			// followup.add("diseaseType", diseaseType);
			// followup.add("personId", dis.getPersonId());
			// Long count = dmStrtumFollowupDao.getCount(followup, "ID",
			// Long.class);
			// if (count >= 2 && count <= 5 || count >= 7 && count <= 11) {
			// return EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_OTHER;
			// }
			return EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_ONE;
		}
		return EHRConstants.DM_FOLLOWUP_TYPE_NORMAL;
	}

	

	/**
	 * Update next plan date and check to build new plan.
	 *
	 * @param dmfInfo
	 *            the dmf info
	 * @param disType
	 *            the dis type
	 * @param personId
	 *            the person id
	 */
	private void updateNextPlanDateAndCheckToBuildNewPlan(DMFollowupPlan dmfInfo, String disType, Long personId) {
		if (!"1".equals(dmfInfo.getType())) {
//			Date date = followupPlanService.getNextPlanDate(personId, disType);
//			if (null != date) {
//				followupPlanService.doUpdateNextFollowupDate(personId, disType, date);
//			} else {

				if (EHRConstants.DM_STROKE_TYPE.equals(disType)) {
					DmDiseaseInfo dmDiseaseInfo = getDiseaseInfo(personId, "strokeManagedFlag", "strokeManagedFayFlag");
					Assert.notNull(dmDiseaseInfo, "管理卡不存在,请检查是否删除或者已经注销");
					if (EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(dmDiseaseInfo.getStrokeManagedFlag())) {
                        followupPlanService.buildStrtumPlanAndUpdNextFollowupDate(dmfInfo.getPlanDate(), dmDiseaseInfo.getStrokeManagedFayFlag(), disType, personId);
					}

				} else if (EHRConstants.DM_CORONARY_TYPE.equals(disType)) {
					DmDiseaseInfo dmDiseaseInfo = getDiseaseInfo(personId, "coronaryManagedFlag", "coronaryManagedFayFlag");
					Assert.notNull(dmDiseaseInfo, "管理卡不存在,请检查是否删除或者已经注销");
					if (EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(dmDiseaseInfo.getCoronaryManagedFlag())) {
                        followupPlanService.buildStrtumPlanAndUpdNextFollowupDate(dmfInfo.getPlanDate(), dmDiseaseInfo.getCoronaryManagedFayFlag(), disType, personId);
					}

				}
			//}
		}
	}

	private DmDiseaseInfo getDiseaseInfo(Long personId, String... properties) {
		Criteria criteria = new Criteria("personId", personId);
		return getDiseaseInfo(criteria, properties);
	}

	private DmDiseaseInfo getDiseaseInfo(Criteria criteria, String... properties) {
		return diseaseInfoDao.get(criteria, properties);
	}

	/**
	 * Sets input info.
	 *
	 * @param input
	 *            the input
	 * @param followup
	 *            the followup
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 */
	public void setInputInfo(boolean input, Object followup, Organization organization, User user) {
		// Assert.notNull(organization, "非法登录");
		// Assert.notNull(user, "非法登录");
		if (followup.getClass().isAssignableFrom(DmHypertensionFollowup.class)) {
			DmHypertensionFollowup targetFollowup = (DmHypertensionFollowup) followup;
			if (input) {
				targetFollowup.setCreateOrganCode(organization.getOrganCode());
				targetFollowup.setCreateOrganName(organization.getOrganName());
				targetFollowup.setCreateDoctorCode(user.getUserCode());
				targetFollowup.setCreateDoctorName(user.getName());
				targetFollowup.setCreateDate(new Date());
			} else {
				targetFollowup.setUpdateOrganCode(organization.getOrganCode());
				targetFollowup.setUpdateOrganName(organization.getOrganName());
				targetFollowup.setUpdateDoctorCode(user.getUserCode());
				targetFollowup.setUpdateDoctorName(user.getName());
				targetFollowup.setUpdateDate(new Date());
			}
		} else if (followup.getClass().isAssignableFrom(DmDiabeticFollowup.class)) {
			DmDiabeticFollowup targetFollowup = (DmDiabeticFollowup) followup;
			if (input) {
				targetFollowup.setCreateOrganCode(organization.getOrganCode());
				targetFollowup.setCreateOrganName(organization.getOrganName());
				targetFollowup.setCreateDoctorCode(user.getUserCode());
				targetFollowup.setCreateDoctorName(user.getName());
				targetFollowup.setCreateDate(new Date());
			} else {
				targetFollowup.setUpdateOrganCode(organization.getOrganCode());
				targetFollowup.setUpdateOrganName(organization.getOrganName());
				targetFollowup.setUpdateDoctorCode(user.getUserCode());
				targetFollowup.setUpdateDoctorName(user.getName());
				targetFollowup.setUpdateDate(new Date());
			}
		} else if (followup.getClass().isAssignableFrom(DmTumorFollowup.class)) {
			DmTumorFollowup targetFollowup = (DmTumorFollowup) followup;
			if (input) {
				targetFollowup.setCreateOrganCode(organization.getOrganCode());
				targetFollowup.setCreateOrganName(organization.getOrganName());
				targetFollowup.setCreateDoctorCode(user.getUserCode());
				targetFollowup.setCreateDoctorName(user.getName());
				targetFollowup.setCreateDate(new Date());
			} else {
				targetFollowup.setUpdateOrganCode(organization.getOrganCode());
				targetFollowup.setUpdateOrganName(organization.getOrganName());
				targetFollowup.setUpdateDoctorCode(user.getUserCode());
				targetFollowup.setUpdateDoctorName(user.getName());
				targetFollowup.setUpdateDate(new Date());
			}
		} else if (followup.getClass().isAssignableFrom(DmStrtumFollowup.class)) {
			DmStrtumFollowup targetFollowup = (DmStrtumFollowup) followup;
			if (input) {
				targetFollowup.setCreateOrganCode(organization.getOrganCode());
				targetFollowup.setCreateOrganName(organization.getOrganName());
				targetFollowup.setCreateDoctorCode(user.getUserCode());
				targetFollowup.setCreateDoctorName(user.getName());
				targetFollowup.setCreateDate(new Date());
			} else {
				targetFollowup.setUpdateOrganCode(organization.getOrganCode());
				targetFollowup.setUpdateOrganName(organization.getOrganName());
				targetFollowup.setUpdateDoctorCode(user.getUserCode());
				targetFollowup.setUpdateDoctorName(user.getName());
				targetFollowup.setUpdateDate(new Date());
			}
		}

	}

	// 新增历史随访计划
	@Override
	public String saveHistoryFollowupData(Long personId, String disType, String planYear) {
		if (ObjectUtil.isNullOrEmpty(personId) && ObjectUtil.isNullOrEmpty(disType) && ObjectUtil.isNullOrEmpty(planYear)) {
			return "failure";
		}
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("disType", disType);
		criteria.add("type", "1");
		criteria.add("planType", EHRConstants.CDM_FOLLOWUP_NEW);
		criteria.add("planYear", planYear);
		criteria.add("followupId", OP.IS, null);
		List<DMFollowupPlan> dmFollowupPlanList = followupPlanDao.getList(criteria);
		if (ObjectUtil.isNotEmpty(dmFollowupPlanList)) {
			return "existUnfinishedPlan";
		}
		DMFollowupPlan dmFollowupPlan = new DMFollowupPlan();
		dmFollowupPlan.setPersonId(personId);
		dmFollowupPlan.setDisType(disType);
		dmFollowupPlan.setPlanYear(planYear);
		dmFollowupPlan.setType("1");
		dmFollowupPlan.setPlanType(EHRConstants.CDM_FOLLOWUP_NEW);
		Number followupId = followupPlanDao.generatedKey(dmFollowupPlan, "Id", null);
		if (followupId == null) {
			return "failure";
		}
		return "success";
	}

	// 新增随访判断随访日期不能大于已存在随访计划的最小日期
	@Override
	public String validateAddFollowupDate(Long planId, Long personId, Date visitDate, String disType) {
		if (ObjectUtil.isNullOrEmpty(planId) || ObjectUtil.isNullOrEmpty(visitDate)) {
			return "success";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String updatePlanDate = sdf.format(visitDate);
		DMFollowupPlan dmfInfo = followupPlanDao.get(planId);
		if (ObjectUtil.isNotEmpty(dmfInfo.getType()) && "1".equals(dmfInfo.getType())) {
			Criteria criteria = new Criteria("personId", personId);
			criteria.add("disType", disType);
			criteria.add("type", OP.IS, null);
			Long id = followupPlanDao.getMin(criteria, "id", Long.class);
			if (ObjectUtil.isNotEmpty(id)) {
				DMFollowupPlan dmfollowupPlan = followupPlanDao.get(new Criteria("id", id));
				if (ObjectUtil.isNullOrEmpty(dmfollowupPlan.getPlanDate())) {
					return "success";
				}
				String minPlanDate = sdf.format(dmfollowupPlan.getPlanDate().getTime());
				int status = minPlanDate.compareTo(updatePlanDate);
				if (status > 0) {
					return "success";
				} else {
					return "failure";
				}
			}
			return "success";
		} else {
			return "success";
		}
	}

	@Override
	@Transactional
	public void delUnDoFollowupPalnByPersonId(Long personId) {
		Assert.notNull(personId, "删除随访时指定的人员id不能为空");
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("followupId", OP.IS, "NULL");
		// 删除未完成的计划
		followupPlanDao.delete(criteria);
	}

	@Override
	@Transactional
	public void delUnDoFollowupPalnByPersonIdAndDisType(Long personId, String disType) {
		Assert.notNull(personId, "删除未完成随访计划时指定的人员id不能为空");
		Assert.notNull(disType, "删除未完成随访计划指定的疾病类型能为空");
		followupPlanService.removePlans(personId, disType);
	}

	@Override
	@Transactional
	public void delFollowupAfterDelHm(Long personId) {
		Assert.notNull(personId, "删除随访时指定的人员id不能为空");
		Criteria criteria = new Criteria("personId", personId);
		//criteria.add("followupId", OP.IS, "NULL");
		criteria.add("disType", OP.IN, new String[] { EHRConstants.DM_HBP_TYPE, EHRConstants.DM_DI_TYPE, EHRConstants.DM_STROKE_TYPE, EHRConstants.DM_TUMOR_TYPE, EHRConstants.DM_CORONARY_TYPE });
		// 删除未完成的计划
		followupPlanDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1), criteria);
		//followupPlanDao.delete(criteria);
		// 删除保健计划的id
//		criteria.remove("followupId");
//		followupPlanDao.update(new Parameters("planId", null), criteria);
	}

	@Override
	@Transactional
	public void renewFollowupAfterRenewlHm(Long personId) {
		Assert.notNull(personId, "删除随访时指定的人员id不能为空");
		Criteria criteria = new Criteria("personId", personId);
		//criteria.add("followupId", OP.IS, "NULL");
		criteria.add("disType", OP.IN, new String[] { EHRConstants.DM_HBP_TYPE, EHRConstants.DM_DI_TYPE, EHRConstants.DM_STROKE_TYPE, EHRConstants.DM_TUMOR_TYPE, EHRConstants.DM_CORONARY_TYPE });
		// 删除未完成的计划
		followupPlanDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_0), criteria);
		//followupPlanDao.delete(criteria);
		// 删除保健计划的id
//		criteria.remove("followupId");
//		followupPlanDao.update(new Parameters("planId", null), criteria);
	}

	/**
	 * Del followup by person id phy.
	 *
	 * @param personId
	 *            the person id
	 */
	@SuppressWarnings("unused")
	private void delFollowupByPersonIdPhy(Long personId) {
		Assert.notNull(personId, "删除随访时指定的人员id不能为空");
		Criteria criteria = new Criteria("personId", personId);
		// 删除随访
		hypertensionFollowupDao.delete(criteria);
		dmTumorFollowupDao.delete(criteria);
		dmDiabeticFollowupDao.delete(criteria);
		dmStrtumFollowupDao.delete(criteria);
		// 删除计划
		followupPlanDao.delete(criteria);
	}

	@Override
	@Transactional
	public void modifyManageOrganization(Long personId, String oldOrganCode, String newOrganCode) {
		Assert.notNull(personId, "迁移人员id不能为空");
		Assert.notNull(newOrganCode, "迁移目标机构不能为空");
		Assert.notNull(oldOrganCode, "当前机构不能为空");
		Organization newOrganization = organizationApp.queryOrgan(newOrganCode);
		Assert.notNull(newOrganization, "迁移目标机构不存在,指定的organcode:" + newOrganCode);
		Parameters parameters = new Parameters("createOrganCode", newOrganCode);
		Criteria criteria = new Criteria("createOrganCode", oldOrganCode);
		criteria.add("personId", personId);
		// 迁移随访数据
		hypertensionFollowupDao.update(parameters, criteria);
		dmTumorFollowupDao.update(parameters, criteria);
		dmDiabeticFollowupDao.update(parameters, criteria);
		dmStrtumFollowupDao.update(parameters, criteria);
		followupPlanDao.update(parameters, criteria);

	}

	// =================计算默认数据===============//

	@Override
	public DmHypertensionFollowup addHbp(Long personId) {
		DmHypertensionFollowup followup = hypertensionFollowupDao.getLastFollowup(personId);
		if (null == followup) {
			followup = new DmHypertensionFollowup();
			setHbpDefaultValueUsePhyExam(personId, followup);
		} else {
			followup.setId(null);
			followup.setVisitDate(null);
            followup.setSbp(null);
            followup.setDbp(null);
            followup.setVisitType(null);
            followup.setSideEffects(null);
            followup.setEffectsState(null);
            followup.setReferralHbpFlag(null);
	//		followup.setCurSymptomFlag(null);
	//		followup.setReferralHbpFlag(null);
	//		followup.setMedicateHbpFlag(null);
		}
		return followup;
	}

	@Override
	public DmDiabeticFollowup addDi(Long personId) {
		DmDiabeticFollowup followup = null;
		followup = dmDiabeticFollowupDao.getLastFollowup(personId);
		if (null == followup) {
			followup = new DmDiabeticFollowup();
			setDiDefaultValueUsePhyExam(personId, followup);

		} else {
			followup.setId(null);
			followup.setVisitDate(null);
            followup.setDbp(null);
            followup.setFpg(null);
            followup.setSbp(null);
            followup.setVisitType(null);
			followup.setDrugReaction(null);
			followup.setEffectsState(null);
			followup.setReferralDiFlag(null);
		//	followup.setCurSymptomFlag(null);
		//	followup.setReferralDiFlag(null);
		//	followup.setMedicateDiFlag(null);
		}
		return followup;
	}

    @Override
    public DmTumorFollowup addTumor(Long personId) {
        DmTumorFollowup followup = dmTumorFollowupDao.getLastFollowup(personId);
        if (null == followup) {
            followup = new DmTumorFollowup();
        } else {
            followup.setId(null);
            followup.setVisitDate(null);
        }
        return followup;
    }

    @Override
    public DmStrtumFollowup addCoronary(Long personId) {
        DmStrtumFollowup followup = null;
        followup = dmStrtumFollowupDao.getLastCoronaryFollowup(personId);
        if (null == followup) {
            followup = new DmStrtumFollowup();
        } else {
            followup.setId(null);
            followup.setVisitDate(null);
        }
        return followup;
    }

    @Override
    public DmStrtumFollowup addStroke(Long personId) {
        DmStrtumFollowup followup = null;
        followup = dmStrtumFollowupDao.getLastStrokeFollowup(personId);
        if (null == followup) {
            followup = new DmStrtumFollowup();
        } else {
            followup.setId(null);
            followup.setVisitDate(null);
        }
        return followup;
    }

	/**
	 * Sets hbp default value use phy exam.
	 *
	 * @param personId
	 *            the person id
	 * @param followup
	 *            the followup
	 */
	private void setHbpDefaultValueUsePhyExam(Long personId, DmHypertensionFollowup followup) {
		try {
			PhysiqueExamination examination = getPhysiqueExamination(personId);
			if (null != examination) {
				if (null != examination.getHeight()) {
					followup.setHeight(examination.getHeight());
				}
				if (null != examination.getDailySmoke()) {
					followup.setDailyDailySmokeber(examination.getDailySmoke());
				}
				if (null != examination.getDailyDrink()) {
					followup.setDailyDrink(new BigDecimal(String.valueOf(examination.getDailyDrink())).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());	
				}
			}
		} catch (Exception e) {
			log.warn("从健康档案获取默认数据失败");
			if (log.isDebugEnabled()) {
				log.debug("从健康档案获取默认数据失败", e);
			}
		}
	}

	/**
	 * Sets di default value use phy exam.
	 *
	 * @param personId
	 *            the person id
	 * @param followup
	 *            the followup
	 */
	private void setDiDefaultValueUsePhyExam(Long personId, DmDiabeticFollowup followup) {
		try {
			PhysiqueExamination examination = getPhysiqueExamination(personId);
			if (null != examination) {
				if (null != examination.getHeight()) {
					followup.setHeight(String.valueOf(examination.getHeight()));
				}
				if (null != examination.getDailySmoke()) {
					followup.setDailySmoke(BigDecimal.valueOf(examination.getDailySmoke()));
				}
				if (null != examination.getDailyDrink()) {
					followup.setDailyDrink(BigDecimal.valueOf(examination.getDailyDrink()));
				}
			}
		} catch (Exception e) {
			log.warn("从健康档案获取默认数据失败");
			if (log.isDebugEnabled()) {
				log.debug("从健康档案获取默认数据失败", e);
			}
		}
	}

	/**
	 * The DEFAULT _ pHY _ eXAM _ cOLUMNS.
	 */
	private final static String[] DEFAULT_PHY_EXAM_COLUMNS = { "height", "dailySmoke", "dailyDrink" };

	/**
	 * Gets physique examination.
	 *
	 * @param personId
	 *            the person id
	 * @return the physique examination
	 */
	private PhysiqueExamination getPhysiqueExamination(Long personId) {
		return cdmPersonService.getPhyExamWithSeletedProperties(personId, DEFAULT_PHY_EXAM_COLUMNS);
	}

	// 导出

	@Override
	public List<Map<String, Object>> exportDisAndFollowup(Page page, String disType, Criteria criteria, Organization organization, RoleType roleType) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		return diseaseInfoDao.exportDisAndFollowup(page, disType, criteria);
	}

	// 导出计划
	@Override
	public List<Map<String, Object>> exportFollowupPlan(Page page, String disType, Criteria criteria, Organization organization, RoleType roleType) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		return diseaseInfoDao.exportFollowupPlan(page, disType, criteria);
	}


    //===============指标=======================//
    private void tryAddTargetValue(Object followup, Organization organization, User user){
        try {
            this.addTargetValue(followup,organization,user);
        }catch (Exception e){
            log.error("保存随访指标值失败!",e);
        }
    }

	private void addTargetValue(Object followup, Organization organization, User user) {
		if (null == followup) {
			return;
		}
        TargetResultValue resultValue = null;
        Set<String> properties = null;
        if (followup instanceof DmHypertensionFollowup) {
            DmHypertensionFollowup hbp = (DmHypertensionFollowup) followup;
            Integer sbp = hbp.getSbp();
            Integer dbp = hbp.getDbp();
            if (null != sbp || null != dbp) {
                resultValue = new TargetResultValue();
                properties = new HashSet<>(2);
                resultValue.setPersonId(hbp.getPersonId());
                resultValue.setType("高血压随访");
            }
            if (null != sbp) {
                properties.add("valueA");
                resultValue.setValueA(BigDecimal.valueOf(sbp));
            }
            if (null != dbp) {
                properties.add("valueB");
                resultValue.setValueB(BigDecimal.valueOf(dbp));
            }
			resultValue.setCreateDate(hbp.getVisitDate());
			resultValue.setEhrId(hbp.getId().toString());
        } else if (followup instanceof DmDiabeticFollowup) {
            DmDiabeticFollowup di = (DmDiabeticFollowup) followup;
            BigDecimal sbp = di.getSbp();// TODO
            String dbp = di.getDbp();// TODO ..........
            BigDecimal fpg = di.getFpg();
            if (null != sbp || null != dbp || null != fpg) {
                resultValue = new TargetResultValue();
                resultValue.setPersonId(di.getPersonId());
                properties = new HashSet<>(3);
                resultValue.setType("糖尿病随访");
            }
            if (null != sbp) {
                properties.add("valueA");
                resultValue.setValueA(sbp);
            }
            if (null != dbp) {
                properties.add("valueB");
                resultValue.setValueB(new BigDecimal(dbp));
            }
            if (null != fpg) {
                properties.add("valueC");
                resultValue.setValueC(fpg);
            }
			resultValue.setCreateDate(di.getVisitDate());
			resultValue.setEhrId(di.getId().toString());
        } else if (followup instanceof DmStrtumFollowup) {
            DmStrtumFollowup sc = (DmStrtumFollowup) followup;
            Integer sbp = null;
            Integer dbp = null;
            BigDecimal fpg = null;
            BigDecimal glu = null;
            if ("1".equals(sc.getBpExamFlag())) {
                sbp = sc.getSbp();
                dbp = sc.getDbp();
            }
            if ("1".equals(sc.getBloodGlucoseFalg())) {
                fpg = sc.getFpg();
                glu = sc.getGluValue();
            }
            if (null != sbp || null != dbp || null != fpg || null != glu) {
                resultValue = new TargetResultValue();
                properties = new HashSet<>(4);
                resultValue.setPersonId(sc.getPersonId());
                if (EHRConstants.DM_STROKE_TYPE.equals(sc.getDiseaseType())) {
                    resultValue.setType("脑卒中随访");
                } else {
                    resultValue.setType("冠心病随访");
                }
            }
            if (null != sbp) {
                properties.add("valueA");
                resultValue.setValueA(BigDecimal.valueOf(sbp));
            }
            if (null != dbp) {
                properties.add("valueB");
                resultValue.setValueB(BigDecimal.valueOf(dbp));
            }

            if (null != fpg) {
                properties.add("valueC");
                resultValue.setValueC(fpg);
            }
            if (null != glu) {
                properties.add("valueD");
                resultValue.setValueD(glu);
            }
			resultValue.setCreateDate(sc.getVisitDate());
			resultValue.setEhrId(sc.getId().toString());
        }
        if (null != properties && properties.size() > 0) {
            targetService.addOrUpdateTargetResultValue(resultValue, organization.getOrganCode(), user.getUserCode(), properties);
        }
    }

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getNumGroupByVisitWayCode(Criteria criteria) {
		//高血压
		Map<String, Object> hbpMap = hypertensionFollowupDao.getNumGroupByVisitWayCode(criteria);
		//糖尿病
		Map<String, Object> diMap = dmDiabeticFollowupDao.getNumGroupByVisitWayCode(criteria);
		//脑卒中
		Map<String, Object> strokeMap = dmStrtumFollowupDao.getNumGroupByVisitWayCode(new Criteria("DISEASE_TYPE", EHRConstants.DM_STROKE_TYPE).add(criteria));
		//冠心病
		Map<String, Object> coronaryMap = dmStrtumFollowupDao.getNumGroupByVisitWayCode(new Criteria("DISEASE_TYPE", EHRConstants.DM_CORONARY_TYPE).add(criteria));
		//肿瘤
		Map<String, Object> tumorMap = dmTumorFollowupDao.getNumGroupByVisitWayCode(criteria);
		//合计
		Map<String, Object> totalMap = new HashMap<>();

		totalMap.put("MZ_NUM", Integer.valueOf(hbpMap.get("mz_num").toString()) + Integer.valueOf(diMap.get("mz_num").toString())
		+ Integer.valueOf(strokeMap.get("mz_num").toString()) + Integer.valueOf(coronaryMap.get("mz_num").toString()) + Integer.valueOf(tumorMap.get("mz_num").toString()));

		totalMap.put("SM_NUM", Integer.valueOf(hbpMap.get("sm_num").toString()) + Integer.valueOf(diMap.get("sm_num").toString())
				+ Integer.valueOf(strokeMap.get("sm_num").toString()) + Integer.valueOf(coronaryMap.get("sm_num").toString()) + Integer.valueOf(tumorMap.get("sm_num").toString()));

		totalMap.put("DH_NUM", Integer.valueOf(hbpMap.get("dh_num").toString()) + Integer.valueOf(diMap.get("dh_num").toString())
				+ Integer.valueOf(strokeMap.get("dh_num").toString()) + Integer.valueOf(coronaryMap.get("dh_num").toString()) + Integer.valueOf(tumorMap.get("dh_num").toString()));

		totalMap.put("JZ_NUM", Integer.valueOf(hbpMap.get("jz_num").toString()) + Integer.valueOf(diMap.get("jz_num").toString())
				+ Integer.valueOf(strokeMap.get("jz_num").toString()) + Integer.valueOf(coronaryMap.get("jz_num").toString()) + Integer.valueOf(tumorMap.get("jz_num").toString()));

		totalMap.put("HJ_NUM", Integer.valueOf(hbpMap.get("hj_num").toString()) + Integer.valueOf(diMap.get("hj_num").toString())
				+ Integer.valueOf(strokeMap.get("hj_num").toString()) + Integer.valueOf(coronaryMap.get("hj_num").toString()) + Integer.valueOf(tumorMap.get("hj_num").toString()));

		List<Map<String, Object>> resultMapList = new ArrayList<>();
		resultMapList.add(hbpMap);
		resultMapList.add(diMap);
		resultMapList.add(tumorMap);
		resultMapList.add(coronaryMap);
		resultMapList.add(strokeMap);
		resultMapList.add(totalMap);
		return resultMapList;
	}

	/**
	 * 随访统计
	 * @param page
	 * @param form
	 * @return
	 */
	public PageList<Map<String, Object>> getFollowupStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
		return hypertensionFollowupDao.getFollowupStatistics(page, form, currentOrg);
	}

	/**
	 * 导出随访统计
	 * @param page
	 * @param form
	 * @return
	 */
	@Override
	public List<Map<String, Object>> exportFollowupStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
		PageList<Map<String, Object>> pageList = hypertensionFollowupDao.getFollowupStatistics(page, form, currentOrg);
		List<Map<String, Object>> list = null;
		if (null != pageList) {
			list = pageList.getList();
		}
		if (null == list) {
			return Collections.emptyList();
		}
		return list;
	}


	/**
	 * 删除指定慢病类型的慢病随访计划（逻辑删除）
	 * @param personId
	 * @param disTypes
	 */
	@Override
	@Transactional
	public void delFollowupPlanByPersonIdAndDisType(Long personId, List<String> disTypes) {
		Assert.notNull(personId, "删除随访时指定的人员id不能为空");
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("disType", OP.IN, disTypes);
		followupPlanDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1), criteria);
	}

	/**
	 * 恢复已删除的指定慢病类型的慢病随访计划
	 * @param personId
	 * @param disTypes
	 */
	@Override
	@Transactional
	public void renewFollowupPlanByPersonIdAndDisType(Long personId, List<String> disTypes) {
		Assert.notNull(personId, "删除随访时指定的人员id不能为空");
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("disType", OP.IN, disTypes);
		followupPlanDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_0), criteria);
	}

    @Override
    public List<Map<String, Object>> exportPersonFollowup(Page page, Criteria criteria, QueryForm form) {
        if (null == criteria) {
            criteria = this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG);
        } else {
            criteria.add(this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG));
        }
        return dmDiseaseInfoDao.exportPersonFollowup(page, form.getDiseaseType(), form, criteria);
    }

    private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
        Criteria criteria = new Criteria();
        criteria.add(alias + "hbp_flag", isDelete);
        criteria.add(LOP.OR, alias + "di_flag", isDelete);
        criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
        criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
        criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
        return criteria;
    }

	@Override
	public List<DmHypertensionFollowup> getHbpList(Criteria criteria,Order order) {
		// TODO Auto-generated method stub
		List<DmHypertensionFollowup> hbpList = hypertensionFollowupDao.getList(criteria,order);
		return hbpList;
	}

	@Override
	public List<DmDiabeticFollowup> getDiList(Criteria criteria, Order order) {
		List<DmDiabeticFollowup> diList = dmDiabeticFollowupDao.getList(criteria,order);
		return diList;
	}
}
