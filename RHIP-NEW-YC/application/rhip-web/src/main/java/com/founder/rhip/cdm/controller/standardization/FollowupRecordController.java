package com.founder.rhip.cdm.controller.standardization;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.dto.CdmFollowupStatisticsVillageDto;

import com.founder.rhip.fds.entity.AttachmentRecord;
import com.founder.rhip.fds.service.IAttachmentRecordService;
import com.founder.rhip.mdm.entity.StandParameterCfg;
import com.founder.rhip.mdm.service.IStandParameterCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.common.FollowupErrorCode;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IFollowupPlanService;
import com.founder.rhip.cdm.service.IFollowupRecordService;
import com.founder.rhip.cdm.service.IHealthPalnService;
import com.founder.rhip.cdm.service.IPhyExaminationService;
import com.founder.rhip.cdm.service.IReportCardService;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.CdmFollowupStatisticsDto;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.FingerInfo;
import com.founder.rhip.ehr.entity.basic.FingerVerifyRecord;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.entity.management.DmStrtumFollowup;
import com.founder.rhip.ehr.entity.management.DmTumorFollowup;
import com.founder.rhip.ehr.entity.management.DmYiShare;
import com.founder.rhip.ehr.repository.basic.IFingerInfoDao;
import com.founder.rhip.ehr.repository.basic.IFingerVerifyRecordDao;
import com.founder.rhip.ehr.repository.management.IDMFollowupPlanDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 慢病随访
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/cdm/standardization/followup")
public class FollowupRecordController extends CdmBaseController {

	private final static String CONTROLLER_NAME = "慢病随访";
	private final static String HBP_DRUG_CODE = "DMD00068";
	private final static String DI_DRUG_CODE = "DMD00069";
	private final static String HBP_FOLLOWUP_FILE = "A00000006";
	private final static String DI_FOLLOWUP_FILE = "A00000007";

	@Resource
	private IStandardizationService standardizationService;

	@Resource(name = "followupRecordService")
	private IFollowupRecordService followupRecordService;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao diseaseInfoDao;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "healthPalnService")
	private IHealthPalnService healthPalnService;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

    @Resource(name = "reportCardService")
    private IReportCardService reportCardService;

	@Resource(name = "fingerInfoDao")
	private IFingerInfoDao fingerInfoDao;

	@Resource(name = "fingerVerifyRecordDao")
	private IFingerVerifyRecordDao fingerVerifyRecordDao;
	
	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;
	
	@Resource(name = "dmFollowupPlanDao")
	private IDMFollowupPlanDao followupPlanDao;
	
	
	@Resource(name = "cdmPhyExaminationService")
	private IPhyExaminationService examinationService;

	@Resource(name = "followupPlanService")
	private IFollowupPlanService followupPlanService;

	@Resource(name = "systemConfigService")
	private IStandParameterCfgService standParameterCfgService;

	@Resource(name = "attachmentRecordService")
	private IAttachmentRecordService attachmentRecordService;
	/**
	 * 一体机记录查询页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/yshare/search")
	public String yshareSearch(HttpServletRequest request, ModelMap model) {
		String idcard = request.getParameter("idcard");
		String name = request.getParameter("name");
		//来源模块
		String module = request.getParameter("module");
		model.addAttribute("idcard", idcard);
		model.addAttribute("name", name);
		model.addAttribute("module", module);
		return "rhip.cdm.base.standardization.yshareSearch";
	}

	/**
	 * 一体机记录列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/yshare/list")
	public String yshareList(HttpServletRequest request, ModelMap model) {
		String idcard = request.getParameter("idcard");
		String module = request.getParameter("module");
		model.addAttribute("idcard", idcard);
		Criteria criteria = new Criteria("idcard", idcard);
		PageList<DmYiShare> list = standardizationService.searchYshareList(buildPage(request),criteria);
		model.addAttribute("list", list.getList());
		model.addAttribute("module", module);
		return "rhip.cdm.base.standardization.ysharelist";
	}

	/**
	 * 慢病随访管理列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String followupListSearch(HttpServletRequest request, ModelMap model, Boolean fromHome, String followupFlag) {
		model.addAttribute("fromHome", fromHome);
		model.addAttribute("followupFlag", followupFlag);
		return "rhip.cdm.base.standardization.followup";
	}

	/**
	 * 待随访数量
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tofollowupcount")
	@ResponseBody
	public Object getToFollowupCount(HttpServletRequest request) {
		return followupRecordService.getToFollowupCount(getCurrentOrg(request), getRole(request));
	}

	/**
	 * 随访管理页面
	 *
	 * @param form
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listresult")
	public String list(com.founder.rhip.ehr.dto.QueryForm form, HttpServletRequest request, ModelMap model) {
		form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
		Criteria criteria = form.toCriteria(true);
//		if(!criteria.contains("dmPersonInfo.IDCARD")) {}
		setDiseaseInfoListDefaultParam(getCurrentOrg(request), getRole(request), criteria);
		Date date = null;
		if (ObjectUtil.isNotEmpty(form.getFollowupFlag())) {
			date = followupRecordService.getFollowupNextDateRange(form.getFollowupFlag());
			criteria.add(followupRecordService.createToFollowupDateRange(date, form.getFollowupFlag()));
		}
		if (ObjectUtil.isNotEmpty(form.getNextFollowupDate())) {
			criteria.add(followupRecordService.createToFollowupDateRange(form.getNextFollowupDate(), EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY));
		}

		PageList<DmDiseaseInfo> list = standardizationService.getManageCardWithFollowupCountList(buildPage(request), criteria, form);
		if (ObjectUtil.isNotEmpty(list) && ObjectUtil.isNotEmpty(list.getList()) && ObjectUtil.isNotEmpty(date)) {
			List<DmDiseaseInfo> dmDiseaseInfos = list.getList();
			for (DmDiseaseInfo dmDiseaseInfo : dmDiseaseInfos) {
				Date hbp = dmDiseaseInfo.getNextHbpFollowupDate();

				if (null != hbp && hbp.getTime() <= date.getTime()) {
					dmDiseaseInfo.setCheckHbpNextFollowupDateStatus(true);
				}
				Date di = dmDiseaseInfo.getNextDiFollowupDate();
				if (null != di && di.getTime() <= date.getTime()) {
					dmDiseaseInfo.setCheckDiNextFollowupDateStatus(true);
				}
				Date coronary = dmDiseaseInfo.getNextCoronaryFollowupDate();
				if (null != coronary && coronary.getTime() <= date.getTime()) {
					dmDiseaseInfo.setCheckCoronaryNextFollowupDateStatus(true);
				}
				Date stroke = dmDiseaseInfo.getNextStrokeFollowupDate();
				if (null != stroke && stroke.getTime() <= date.getTime()) {
					dmDiseaseInfo.setCheckStrokeNextFollowupDateStatus(true);
				}
				Date tumor = dmDiseaseInfo.getNextTumorFollowupDate();
				if (null != tumor && tumor.getTime() <= date.getTime()) {
					dmDiseaseInfo.setCheckTumorNextFollowupDateStatus(true);
				}
			}
		}
		model.addAttribute("dmDiseaseInfoList", list.getList());
		return "rhip.cdm.base.standardization.followupList";
	}

	/**
	 * 设置查询默认权限条件
	 *
	 * @param organization
	 *            the organization
	 * @param roleType
	 *            the role type
	 * @param criteria
	 *            the criteria
	 */
	private void setDiseaseInfoListDefaultParam(Organization organization, RoleType roleType, Criteria criteria) {
		if (RoleType.ZMB.equals(roleType)) {
			criteria.add("dmDiseaseInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if (RoleType.ZXMB.equals(roleType)) {
			criteria.add("dmPersonInfo.CREATE_CENTER_ORGAN_CODE", organization.getOrganCode());
		}
	}


	/**
	 * 查看所有随访
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewall")
	public String viewAll(@RequestParam("id") Long id, @RequestParam("followupStatus") String followupStatus, ModelMap model) {
		DmDiseaseInfo diseaseInfo = diseaseInfoDao.get(id);
		Assert.notNull(diseaseInfo, "无法查找慢病信息");
		PersonInfo personInfo = platformService.queryPersonalInfo(diseaseInfo.getPersonId());

		if (ObjectUtil.isNotEmpty(followupStatus)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			if (EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH.equals(followupStatus)) {
				calendar.add(Calendar.MONTH, +1);
			} else {
				calendar.add(Calendar.DAY_OF_MONTH, +10007);
			}
			Date aWeekLater = DateUtil.makeTimeToMax(calendar.getTime());
			model.addAttribute("aWeekLater", aWeekLater);
		}

		model.put("personInfo", personInfo);
		model.put("diseaseInfo", diseaseInfo);
		boolean hadTumorFollowuped = false;
		// 检查肿瘤随访信息
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag())) {
			Criteria criteria = new Criteria();
			criteria.add("personId", personInfo.getId());
			criteria.add("followupFlag", EHRConstants.DM_FOLLOWUP_TUMOR_FIRST);
			DmTumorFollowup tumorFollowup = followupRecordService.getTumor(criteria);
			if (ObjectUtil.isNotEmpty(tumorFollowup)) {
				hadTumorFollowuped = true;
			}
		}
		model.put("hadTumorFollowuped", hadTumorFollowuped);

		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {
			String strokeFollowType = followupRecordService.getFollowupType(diseaseInfo, EHRConstants.DM_STROKE_TYPE, diseaseInfo.getStrokeManagedFayFlag());
			model.put("strokeFollowType", strokeFollowType);
		}

		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag())) {
			String coronaryFollowType = followupRecordService.getFollowupType(diseaseInfo, EHRConstants.DM_CORONARY_TYPE, diseaseInfo.getCoronaryManagedFayFlag());
			model.put("coronaryFollowType", coronaryFollowType);
		}
		model.put("currentDate", new Date());
        model.put("oneYearBeforeDate", DateUtil.add(new Date(),Calendar.YEAR,-1));
        if(personInfo!=null) {
			String idcard = personInfo.getIdcard();
			if(StringUtil.isNotEmpty(idcard)){
				Criteria fingerCriteria = new Criteria("IDCARD",idcard);
				FingerInfo fingerInfo=fingerInfoDao.get(fingerCriteria);
				model.put("fingerInfo", fingerInfo);
			}
		}
        Boolean unplannedFlag= standParameterCfgService.isValid("mb.unplanned.switch");
        if(unplannedFlag) {
        	 model.addAttribute("unplannedFlag", "1");
        }else {
        	 model.addAttribute("unplannedFlag", "0");
        }
		return "rhip.cdm.base.standardization.followup.view";
	}

    /**
     * 获取计划列表
     *
     * @param disType the dis type
     * @param personId the person id
     * @param planYearStart the plan year start
     * @param planYearEnd the plan year end
     * @param model the model
     * @return string
     */
	@RequestMapping("/plan")
	public String inputPlanFollowupList(@RequestParam("disType") String disType, @RequestParam("personId") String personId, @RequestParam(value="planYearStart",required = false) String planYearStart,@RequestParam(value = "planYearEnd",required = false) String planYearEnd, ModelMap model, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.addCriterion(buildPlanYearCriterion("planYear",planYearStart, planYearEnd));
		criteria.add("disType", disType);
		List<DMFollowupPlan> list = healthPalnService.searchDmFollowupPlanList(criteria, new Order("PLAN_DATE"));
		//获取系统参数表里 按钮配置
		StandParameterCfg standCfg = standParameterCfgService.getSystemConfig(new Criteria("NAME","mb.delete.swtich"));
		if(ObjectUtil.isNotEmpty(standCfg)){
			model.addAttribute("standCfg", standCfg);
		}
		//获取计划内重复的日期
		List<String> dateList =followupPlanService.searchRepeatDate(criteria.add("planType",EHRConstants.CDM_FOLLOWUP_PLAN));
		if(dateList.size()>0){
			for (DMFollowupPlan dm :list){
				if(EHRConstants.CDM_FOLLOWUP_PLAN.equals(dm.getPlanType())&&dateList.contains(dm.getPlanDate())){
					dm.setRepeatDateFlag(true);
				}
			}
		}
		model.addAttribute("plans", list);
		//查询最后一条计划随访不限制填写
		Criteria cri = new Criteria();
		cri.add("personId", personId);
		cri.add("disType", disType);
		//cri.add("planType", EHRConstants.CDM_FOLLOWUP_PLAN);
		DMFollowupPlan lastPlan = healthPalnService.searchLastPlan(cri);
		model.addAttribute("lastPlan", lastPlan);
		Date date = new Date();
		model.addAttribute("aMonthLater", DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, 1)));
		model.addAttribute("aMonthBefore", DateUtil.makeTimeToZero(DateUtil.add(date, Calendar.MONTH, -1)));
//		Date aWeekLater = getFollowupLimitDate();
//		model.addAttribute("aWeekLater", DateUtil.makeTimeToMax(aWeekLater));
        List<Role> roles = getCurrentUserRole(request);
        String userRoles = "";
        for(Role role :roles){
            userRoles = userRoles + "," + role.getRoleCode();
        }
        Boolean unplannedFlag= standParameterCfgService.isValid("mb.unplanned.switch");
        if(unplannedFlag) {
        	 model.addAttribute("unplannedFlag", "1");
        }else {
        	 model.addAttribute("unplannedFlag", "0");
        }
        model.addAttribute("userRoles", userRoles);
		return "rhip.cdm.base.standardization.followup.hypertensionList";
	}

	@RequestMapping("/deletePlan")
	@ResponseBody
	public String deletePlan(@RequestParam(value = "id",required = false) long id, ModelMap model, HttpServletRequest request) {
		int result =0;
		result=followupPlanService.clearPlan(id);
		return  result>0 ? "success" : "fail";
	}


		private Criterion buildPlanYearCriterion(String property, String planYearStart, String planYearEnd){

       if( ObjectUtil.isNullOrEmpty(planYearEnd)){
           planYearEnd=String.valueOf(DateUtil.getCurrentYear());
        }

        if( ObjectUtil.isNullOrEmpty(planYearStart)){
            planYearStart="1900";
        }

        return new Criterion(property, OP.BETWEEN,new String[]{planYearStart,planYearEnd});
    }

	/**
	 * 高血压保存
	 * 
	 * @param hbp
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save/hbp")
	@ResponseBody
	public Object hbpSave(DmHypertensionFollowup hbp, ModelMap model, HttpServletRequest request,@RequestParam(value = "planType", required = false) String planTypes) {
		String status = validateAddFollowupDate(hbp.getPlanId(), hbp.getPersonId(), hbp.getVisitDate(), EHRConstants.DM_HBP_TYPE);
		if ("success".equals(status)) {
			Assert.notNull(hbp, "高血压随访表单数据为空");
			Long id = hbp.getId();
			boolean result;
			try {
				final User currentUser = getCurrentUser(request);
				if(ObjectUtil.isNotEmpty(planTypes)) {
					hbp.setPlanType(planTypes);
				}
				result = followupRecordService.saveHbp(hbp, getCurrentOrg(request), currentUser);
				
				//保存随访信息到 service_Sync_Log(家医履约专用)
				final String planType = followupPlanDao.get(hbp.getPlanId()).getPlanType();
				final DmHypertensionFollowup hbpFollowup = hbp;
				Thread thread = new Thread(new Runnable() {
					public void run() {
						serviceSyncLogService.insertHbp(hbpFollowup, currentUser, planType);
					}
				});
				thread.start();
				
				if (ObjectUtil.isNotEmpty(id)) {
					record(request, BaseController.OperationName.UPDATE);
				} else {
					record(request, BaseController.OperationName.ADD);
				}
			} catch (Exception e) {
				logger.error("高血压保存失败", e);
				result = false;
			}
			// model.addAttribute("hbp", hbp);
			// return
			// "rhip.cdm.base.standardization.followup.viewHypertensionDetail";
			return result;
		}
		return status;
	}

	/**
	 * @param personId
	 * @param hbpId
	 * @param planId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/view/hbp")
	public String hbpView(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "followupId", required = false) Long hbpId,
			@RequestParam(value = "planId", required = false) Long planId,@RequestParam(value = "planType", required = false) String planType,
			@RequestParam(value = "reasonFollowId", required = false) Long reasonFollowId, ModelMap model, HttpServletRequest request) {
		Assert.notNull(planId, "计划id不能为空");
		Assert.notNull(personId, "高血压随访患者id不能为空");
		DmHypertensionFollowup hbp = null;
		if (ObjectUtil.isNullOrEmpty(hbpId)) {
			hbp = followupRecordService.addHbp(personId);
			hbp.setCreateDoctorCode(String.valueOf(getCurrentUser(request).getUserCode()));
			hbp.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
		} else {
			hbp = followupRecordService.getHbp(new Criteria("id", hbpId));
			Assert.notNull(hbp);
		}
		if(ObjectUtil.isNullOrEmpty(hbp.getIndexOfBodyCharacteristics())) {
        	Criteria criteria = new Criteria("personId", personId);
        	//体检类型，39:慢病。31:老年人
        	criteria.add("physicalExamType","39");
        	criteria.add("isDelete",OP.IS,null);
            //criteria.add("ehrId", ehrId);
            List<ElderlyPhyExamination> elderlyPhyExaminations = examinationService.getElderlyPhyExaminations(criteria, new Order("examination_date desc"), "height","bodyWeight","indexOfBodyCharacteristics");
            if(ObjectUtil.isNotEmpty(elderlyPhyExaminations)) {
            	if(ObjectUtil.isNotEmpty(elderlyPhyExaminations.get(0).getHeight())) {
            		hbp.setHeight(elderlyPhyExaminations.get(0).getHeight());
            	}
            	if(ObjectUtil.isNotEmpty(elderlyPhyExaminations.get(0).getBodyWeight())) {
            		hbp.setBodyWeight(elderlyPhyExaminations.get(0).getBodyWeight());
            	}
            	if(ObjectUtil.isNotEmpty(elderlyPhyExaminations.get(0).getIndexOfBodyCharacteristics())) {
            		hbp.setIndexOfBodyCharacteristics(elderlyPhyExaminations.get(0).getIndexOfBodyCharacteristics());
            	}
            }else {
            	hbp.setHeight(null);
            }
            
            
        }
		hbp.setPlanId(planId);
		PersonInfo info= platformService.queryPersonalInfo(personId);
		//获取附件
		Criteria criteria = new Criteria("business_id", hbp.getId());
		criteria.add("file_src", HBP_FOLLOWUP_FILE);
		List<AttachmentRecord> attachmentRecords = attachmentRecordService.queryAttachmentRecord(criteria);
		model.addAttribute("attches", attachmentRecords);
		model.addAttribute("hbp", hbp);
		model.addAttribute("reasonFollowId", reasonFollowId);
		model.addAttribute("age", IdNOToAge(info.getIdcard()));
		model.addAttribute("personInfo", info);
		model.addAttribute("planType", planType);
		return "rhip.cdm.base.standardization.followup.viewHypertensionDetail";
	}

	@RequestMapping("/hbpSideEffectsStatus")
	@ResponseBody
	public Object hbpSideEffectsStatus(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "visitDate", required = false) String visitDate,
			 ModelMap model, HttpServletRequest request) throws ParseException {
		String status="";
		Criteria cre=new Criteria("personId", personId);
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy/MM/dd");
		cre.add("visitDate",OP.LT,sdf.parse(visitDate));
		List<DmHypertensionFollowup> hbp =followupRecordService.getHbpList(cre,new Order("VISIT_DATE DESC"));
		if(ObjectUtil.isNotEmpty(hbp)) {
			status=hbp.get(0).getSideEffects();
			if(ObjectUtil.isNotEmpty(status)) {
				if(!"2".equals(status)) {
					status="";
				}
			}
		}
		return status;
	}
	@RequestMapping("/diSideEffectsStatus")
	@ResponseBody
	public Object diSideEffectsStatus(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "visitDate", required = false) String visitDate,
			 ModelMap model, HttpServletRequest request) throws ParseException {
		String status="";
		Criteria cre=new Criteria("personId", personId);
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy/MM/dd");
		cre.add("visitDate",OP.LT,sdf.parse(visitDate));
		List<DmDiabeticFollowup> hbp =followupRecordService.getDiList(cre,new Order("VISIT_DATE DESC"));
		if(ObjectUtil.isNotEmpty(hbp)) {
			status=hbp.get(0).getSideEffects();
			if(ObjectUtil.isNotEmpty(status)) {
				if(!"2".equals(status)) {
					status="";
				}
			}
		}
		return status;
	}
	
	@RequestMapping("/hbpVisitType")
	@ResponseBody
	public Object hbpVisitType(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "visitDate", required = false) String visitDate,
			 ModelMap model, HttpServletRequest request) throws ParseException {
		String status="";
		Criteria cre=new Criteria("personId", personId);
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy/MM/dd");
		cre.add("visitDate",OP.LT,sdf.parse(visitDate));
		List<DmHypertensionFollowup> hbp =followupRecordService.getHbpList(cre,new Order("VISIT_DATE DESC"));
		if(ObjectUtil.isNotEmpty(hbp)) {
			status=hbp.get(0).getVisitType();
			if(ObjectUtil.isNotEmpty(status)) {
				if(!"2".equals(status)) {
					status="";
				}
			}
		}
		return status;
	}
	@RequestMapping("/diVisitType")
	@ResponseBody
	public Object diVisitType(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "visitDate", required = false) String visitDate,
			 ModelMap model, HttpServletRequest request) throws ParseException {
		String status="";
		Criteria cre=new Criteria("personId", personId);
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy/MM/dd");
		cre.add("visitDate",OP.LT,sdf.parse(visitDate));
		List<DmDiabeticFollowup> hbp =followupRecordService.getDiList(cre,new Order("VISIT_DATE DESC"));
		if(ObjectUtil.isNotEmpty(hbp)) {
			status=hbp.get(0).getVisitType();
			if(ObjectUtil.isNotEmpty(status)) {
				if(!"2".equals(status)) {
					status="";
				}
			}
		}
		return status;
	}
	/**
	 * 糖尿病保存
	 * 
	 * @param di
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save/di")
	@ResponseBody
	public Object diSave(DmDiabeticFollowup di, ModelMap model, HttpServletRequest request,@RequestParam(value = "planType", required = false) String planTypes) {
		Assert.notNull(di, "表单为空");
		String status =validateAddFollowupDate(di.getPlanId(), di.getPersonId(), di.getVisitDate(), EHRConstants.DM_DI_TYPE);
		if ("success".equals(status)) {
			Long id = di.getId();
			boolean result;
			try {
				final User currentUser = getCurrentUser(request);
				if(ObjectUtil.isNotEmpty(planTypes)) {
					di.setPlanType(planTypes);
				}
				result = followupRecordService.saveDi(di, getCurrentOrg(request), getCurrentUser(request));
				
				//保存随访信息到 service_Sync_Log(家医履约专用)
				final String planType = followupPlanDao.get(di.getPlanId()).getPlanType();
				final DmDiabeticFollowup diFollowup = di;
				Thread thread = new Thread(new Runnable() {
					public void run() {
						serviceSyncLogService.insertDi(diFollowup, currentUser, planType);
					}
				});
				thread.start();
				
				if (ObjectUtil.isNotEmpty(id)) {
					record(request, BaseController.OperationName.UPDATE);
				} else {
					record(request, BaseController.OperationName.ADD);
				}
			} catch (Exception e) {
				logger.error("糖尿病保存失败", e);
				result = false;
			}
			return result;
		}
		return status;
	}

	/**
	 * @param personId
	 * @param diId
	 * @param planId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/view/di")
	public String diView(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "followupId", required = false) Long diId,
			@RequestParam(value = "planId", required = false) Long planId,
			@RequestParam(value = "reasonFollowId", required = false) Long reasonFollowId,@RequestParam(value = "planType", required = false) String planType, ModelMap model, HttpServletRequest request) {
		Assert.notNull(personId);
		Assert.notNull(planId, "糖尿病随访患者id不能为空");
		DmDiabeticFollowup di = null;
		if (ObjectUtil.isNullOrEmpty(diId)) {
			di = followupRecordService.addDi(personId);
			di.setCreateDoctorCode(String.valueOf(getCurrentUser(request).getUserCode()));
			di.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
		} else {
			di = followupRecordService.getDi(new Criteria("id", diId));
			Assert.notNull(di, "随访记录无法找到");
		}
		di.setPlanId(planId);
        PersonInfo info= platformService.queryPersonalInfo(personId);
        if(ObjectUtil.isNullOrEmpty(di.getIndexOfBodyCharacteristics())) {
        	Criteria criteria = new Criteria("personId", personId);
            //criteria.add("ehrId", ehrId);
        	//体检类型，39:慢病。31:老年人
        	criteria.add("physicalExamType","39");
        	criteria.add("isDelete",OP.IS,null);
            List<ElderlyPhyExamination> elderlyPhyExaminations = examinationService.getElderlyPhyExaminations(criteria, new Order("examination_date desc"), "height","bodyWeight","indexOfBodyCharacteristics");
            if(ObjectUtil.isNotEmpty(elderlyPhyExaminations)) {
            	if(ObjectUtil.isNotEmpty(elderlyPhyExaminations.get(0).getHeight())) {
            		di.setHeight(elderlyPhyExaminations.get(0).getHeight().toString());
            	}
            	if(ObjectUtil.isNotEmpty(elderlyPhyExaminations.get(0).getBodyWeight())) {
            		di.setBodyWeight(elderlyPhyExaminations.get(0).getBodyWeight().toString());
            	}
            	if(ObjectUtil.isNotEmpty(elderlyPhyExaminations.get(0).getIndexOfBodyCharacteristics())) {
            		di.setIndexOfBodyCharacteristics(elderlyPhyExaminations.get(0).getIndexOfBodyCharacteristics());
            	}
            }else {
            	di.setHeight(null);
            }
            
            
        }
		//获取附件
		Criteria criteria = new Criteria("business_id", di.getId());
		criteria.add("file_src", DI_FOLLOWUP_FILE);
		List<AttachmentRecord> attachmentRecords = attachmentRecordService.queryAttachmentRecord(criteria);
		model.addAttribute("attches", attachmentRecords);
        model.addAttribute("planType", planType);
        model.addAttribute("di", di);
        model.addAttribute("reasonFollowId", reasonFollowId);
        model.addAttribute("personInfo", info);
		return "rhip.cdm.base.standardization.followup.viewDiabeticDetail";
	}

	/**
	 * 肿瘤查看基本信息
	 *
	 * @param followupFlag
	 * @param followupId
	 * @param planId
	 * @param personId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/view/tumorPersonInfo")
	public String tumorPersonInfo(@RequestParam(value = "followupFlag") String followupFlag, @RequestParam(value = "followupId", required = false) Long followupId,
							@RequestParam(value = "planId", required = false) Long planId,@RequestParam(value = "planType", required = false) String planType, @RequestParam(value = "personId") Long personId, ModelMap model, HttpServletRequest request){
//		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
//		model.put("personInfo", personInfo);
//
//        Criteria criteria = new Criteria("dmReportInfo.PERSON_ID", personId);
//        criteria.add("dmReportInfo.DIS_TYPE",5);
//		List<DmReportInfo> reportInfos = reportCardService.getReportCard(criteria);
//		model.put("reportInfos", reportInfos);

        Criteria criteria = new Criteria("PERSON_ID", personId);
        DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);
        if (ObjectUtil.isNotEmpty(diseaseInfo)) {
            PersonInfo personInfo = diseaseInfo.getPersonInfo();
            // 当查看管理卡时,如果此人没有生日,则计算出默认值
            setBirthday(personInfo);
            model.put("personInfo", personInfo);
            model.put("diseaseInfo", diseaseInfo);
            model.put("age", DateUtil.getAgeByBirthday(personInfo.getBirthday()));
        }

        if(ObjectUtil.isNullOrEmpty(diseaseInfo) || ObjectUtil.isNullOrEmpty(diseaseInfo.getTumorCreateDoctorCode()) || ObjectUtil.isNullOrEmpty(diseaseInfo.getTumorCreateOrganCode())){
            diseaseInfo.setTumorCreateDoctorCode(String.valueOf(getCurrentUser(request).getUserCode()));
            diseaseInfo.setTumorCreateOrganCode(getCurrentOrg(request).getOrganCode());
            diseaseInfo.setTumorCreateDate(new Date());
        }
        model.addAttribute("planType", planType);
		model.addAttribute("hospitalaReport", true);// 标志为院内上报

		return "rhip.cdm.base.standardization.followup.viewTumorPersonInfo";
	}

	/**
	 * 肿瘤查看
	 * 
	 * @param followupFlag
	 * @param followupId
	 * @param planId
	 * @param personId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/view/tumor")
	public String tumorView(@RequestParam(value = "followupFlag") String followupFlag, @RequestParam(value = "followupId", required = false) Long followupId,
			@RequestParam(value = "planId", required = false) Long planId, @RequestParam(value = "personId") Long personId,ModelMap model, HttpServletRequest request) {
		Assert.notNull(followupFlag, "肿瘤随访类型不能为空");
		Criteria criteria = new Criteria();
		DmTumorFollowup tumorFollowup = null;
		if (EHRConstants.DM_FOLLOWUP_TUMOR_FIRST.equals(followupFlag) || EHRConstants.DM_FOLLOWUP_TUMOR_LAST.equals(followupFlag)) {
			criteria.add("personId", personId);
			criteria.add("followupFlag", followupFlag);
			tumorFollowup = followupRecordService.getTumor(criteria);
			if (ObjectUtil.isNullOrEmpty(tumorFollowup)) {
				tumorFollowup = new DmTumorFollowup();
                tumorFollowup.setCreateDoctorCode(String.valueOf(getCurrentUser(request).getUserCode()));
                tumorFollowup.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
			}
		} else if (EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL.equals(followupFlag)) {
			criteria.add("id", followupId);
			if (ObjectUtil.isNullOrEmpty(followupId)) {
				tumorFollowup = followupRecordService.addTumor(personId);
                tumorFollowup.setCreateDoctorCode(String.valueOf(getCurrentUser(request).getUserCode()));
                tumorFollowup.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
			} else {
				tumorFollowup = followupRecordService.getTumor(new Criteria("id", followupId));
				Assert.notNull(tumorFollowup);
			}
			tumorFollowup.setPlanId(planId);
		}
		PersonInfo info= platformService.queryPersonalInfo(personId);
		model.addAttribute("personInfo", info);
		model.addAttribute("tumor", tumorFollowup);
		return getTumorInputViewId(followupFlag);
	}

	/**
	 * 肿瘤保存
	 * 
	 * @param tumor
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save/tumor")
	@ResponseBody
	public Object tumorSave(DmTumorFollowup tumor, ModelMap model, HttpServletRequest request) {
		Assert.notNull(tumor, "表单为空");
		Set<String> resutCodes = new HashSet<>();
		try {
			Long id = tumor.getId();
			resutCodes = followupRecordService.saveTumor(tumor, getCurrentOrg(request), getCurrentUser(request));
			resutCodes.addAll(resutCodes);
			if (resutCodes.size() < 1) {
				if (ObjectUtil.isNotEmpty(id)) {
					record(request, BaseController.OperationName.UPDATE);
				} else {
					record(request, BaseController.OperationName.ADD);
				}
			}

		} catch (Exception e) {
			resutCodes.add(FollowupErrorCode.TUMOR_SAVE_ERROR.getValue());
		}
		return resutCodes;
	}

	/**
	 * 肿瘤基本信息保存
	 *
	 * @param diseaseInfo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save/tumorPersonInfo")
	@ResponseBody
	public Object save(DmDiseaseInfo diseaseInfo, ModelMap model, HttpServletRequest request) {
		setCurrentUserInfoToDis(diseaseInfo, request);
		//Long end = System.currentTimeMillis();
		boolean result = standardizationService.saveTumorPersonInfo(diseaseInfo);
		//logger.error("====保存管理卡StandardizationController save 168 " + (System.currentTimeMillis() - end));
		if (result) {
			//end = System.currentTimeMillis();
			record(request, BaseController.OperationName.UPDATE);
			//logger.error("====保存管理卡日志StandardizationController save 172 " + (System.currentTimeMillis() - end));
			return result;
		}
		return "error";
	}

	private void setCurrentUserInfoToDis(DmDiseaseInfo diseaseInfo, HttpServletRequest request) {
		if (ObjectUtil.isNotEmpty(diseaseInfo)) {
			diseaseInfo.setCurrentUser(getCurrentUser(request));
			diseaseInfo.setCurrentOrganization(getCurrentOrg(request));
		}
	}

	/**
	 * 脑卒中保存
	 * 
	 * @param followup
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save/stroke")
	@ResponseBody
	public Object strokeSave(DmStrtumFollowup followup, ModelMap model, HttpServletRequest request,@RequestParam(value = "planType", required = false) String planTypes) {
		Assert.notNull(followup, "表单为空");
		String disType = null;
		if (followup.getDiseaseType().equals(EHRConstants.DM_STROKE_TYPE)) {
			disType = EHRConstants.DM_STROKE_TYPE;
		} else {
			disType = EHRConstants.DM_CORONARY_TYPE;
		}
		String status =validateAddFollowupDate(followup.getPlanId(), followup.getPersonId(), followup.getVisitDate(), disType);
		if ("success".equals(status)) {
			Long id = followup.getId();
			boolean result;
			try {
				if(ObjectUtil.isNotEmpty(planTypes)) {
					followup.setPlanType(planTypes);
				}
				
				result = followupRecordService.saveStrtum(followup, getCurrentOrg(request), getCurrentUser(request));
				if (ObjectUtil.isNotEmpty(id)) {
					record(request, BaseController.OperationName.UPDATE);
				} else {
					record(request, BaseController.OperationName.ADD);
				}
			} catch (Exception e) {
				logger.error("脑卒中/冠心病保存失败");
				result = false;
			}
			return result;
		}
		return status;
	}

    /**
     * 获取脑卒中计划
     *
     * @param plan the plan
     * @param planYearStart the plan year start
     * @param planYearEnd the plan year end
     * @param followupFlag the followup flag
     * @param model the model
     * @return stroke followup plans
     */
	@RequestMapping("/plan/stroke")
	public String getStrokeFollowupPlans(DMFollowupPlan plan, @RequestParam(value="planYearStart",required = false) String planYearStart, @RequestParam(value = "planYearEnd",required = false) String planYearEnd, @RequestParam(value = "followupFlag") String followupFlag, ModelMap model, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		Criteria ca = new Criteria();
		criteria.add("dmFollowupPlan.PERSON_ID", plan.getPersonId());
		criteria.addCriterion(buildPlanYearCriterion("dmFollowupPlan.PLAN_YEAR", planYearStart, planYearEnd));
		criteria.add("dmFollowupPlan.DIS_TYPE", plan.getDisType());
		ca.add("personId", plan.getPersonId());
		ca.addCriterion(buildPlanYearCriterion("planYear",planYearStart, planYearEnd));
		ca.add("disType",  plan.getDisType());
		// criteria.add(new Criteria("dmStrtumFollowup.FOLLOWUP_FLAG",
		// followupFlag).add(LOP.OR, "dmStrtumFollowup.FOLLOWUP_FLAG",
		// OP.IS,"NULL"));
		List<DMFollowupPlan> list = followupRecordService.getStrokeFollowupPlans(criteria);
		//获取系统参数表里 按钮配置
		StandParameterCfg standCfg = standParameterCfgService.getSystemConfig(new Criteria("NAME","mb.delete.swtich"));
		if(ObjectUtil.isNotEmpty(standCfg)){
			model.addAttribute("standCfg", standCfg);
		}
		//获取计划内重复的日期
		List<String> dateList =followupPlanService.searchRepeatDate(ca.add("planType",EHRConstants.CDM_FOLLOWUP_PLAN));
		if(dateList.size()>0){
			for (DMFollowupPlan dm :list){
				if(EHRConstants.CDM_FOLLOWUP_PLAN.equals(dm.getPlanType())&&dateList.contains(dm.getPlanDate())){
					dm.setRepeatDateFlag(true);
				}
			}
		}
		model.addAttribute("plans", list);
		//查询最后一条计划随访不限制填写
				Criteria cri = new Criteria();
				cri.add("personId", plan.getPersonId());
				cri.add("disType", plan.getDisType());
				//cri.add("planType", EHRConstants.CDM_FOLLOWUP_PLAN);
				DMFollowupPlan lastPlan = healthPalnService.searchLastPlan(cri);
				model.addAttribute("lastPlan", lastPlan);
		
		Date date = new Date();
		model.addAttribute("aMonthLater", DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, 1)));
		model.addAttribute("aMonthBefore", DateUtil.makeTimeToZero(DateUtil.add(date, Calendar.MONTH, -1)));
		List<Role> roles = getCurrentUserRole(request);
		String userRoles = "";
		for(Role role :roles){
			userRoles = userRoles + "," + role.getRoleCode();
		}

		model.addAttribute("userRoles", userRoles);
		return "rhip.cdm.base.standardization.followup.hypertensionList";
	}

    private Date getFollowupLimitDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, +7);
      //  calendar.add(Calendar.YEAR,10);
        return DateUtil.makeTimeToMax(calendar.getTime());
    }

    /**
	 * 脑卒中查看
	 * 
	 * @param followupId
	 * @param planId
	 * @param followupFlag
	 * @param diseaseType
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/view/stroke")
	public String strokeView(@RequestParam(value = "followupId", required = false) Long followupId, @RequestParam(value = "planId") Long planId,@RequestParam(value = "personId") Long personId,
			@RequestParam(value = "followupFlag") String followupFlag, @RequestParam(value = "diseaseType") String diseaseType,@RequestParam(value = "planType", required = false) String planType, ModelMap model, HttpServletRequest request) {
		Assert.notNull(planId);
		DmStrtumFollowup strtum = null;
		if (ObjectUtil.isNullOrEmpty(followupId)) {
            if (diseaseType.equals(EHRConstants.DM_STROKE_TYPE)) {
               strtum=followupRecordService.addStroke(personId);
            } else {
                strtum=followupRecordService.addCoronary(personId);
            }
			// strtum.setCreateDoctorName(getCurrentUser(request).getUserName());
			// strtum.setCreateOrganName(getCurrentOrg(request).getOrganName());
			strtum.setCreateDoctorCode(String.valueOf(getCurrentUser(request).getUserCode()));
			strtum.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
		} else {
			Criteria criteria = new Criteria("id", followupId);
			strtum = followupRecordService.getStrtum(criteria);
			Assert.notNull(strtum);
		}
		strtum.setPlanId(planId);
		PersonInfo info= platformService.queryPersonalInfo(personId);
		model.addAttribute("strtum", strtum);
		model.addAttribute("personInfo", info);
		model.addAttribute("planType", planType);
		if (EHRConstants.DM_STROKE_TYPE.equals(diseaseType)) {
			return getStrokeInputViewId(followupFlag);
		} else {
			return getCoronaryInputViewId(followupFlag);
		}
	}

	/**
	 * 高血压用药
	 * 
	 * @return
	 */
	@RequestMapping("/drug/hbp")
	@ResponseBody
	public Object getHbDrug() {
		return getDrug(HBP_DRUG_CODE);
	}

	/**
	 * 糖尿病用药
	 * 
	 * @return
	 */
	@RequestMapping("/drug/di")
	@ResponseBody
	public Object getDiDrug() {
		return getDrug(DI_DRUG_CODE);
	}

	private List<DicItem> getDrug(String dicCode) {
		List<DicItem> items = dictionaryApp.queryDicItem(dicCode);
		return items;
	}

	/**
	 * 获取脑卒中随访记录表单 常规和规范化
	 * 
	 * @param followupFlag
	 * @return
	 */
	private String getStrokeInputViewId(String followupFlag) {
		String name = null;
		switch (followupFlag) {
		case EHRConstants.DM_FOLLOWUP_TYPE_NORMAL:
			name = "rhip.cdm.base.standardization.followup.viewStrokeNormalFollowup";
			break;
		case EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_ONE:
			name = "rhip.cdm.base.standardization.followup.viewStrokeStandardFollowup";
			break;
		case EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_OTHER:
			name = "rhip.cdm.base.standardization.followup.viewStrokeStandardOtherFollowup";
			break;
		}
		return name;
	}

	/**
	 * 获取冠心病随访记录表单 常规和规范化
	 * 
	 * @param followupFlag
	 * @return
	 */
	private String getCoronaryInputViewId(String followupFlag) {
		String name = null;
		switch (followupFlag) {
		case EHRConstants.DM_FOLLOWUP_TYPE_NORMAL:
			name = "rhip.cdm.base.standardization.followup.viewCoronaryNormalFollowup";
			break;
		case EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_ONE:
			name = "rhip.cdm.base.standardization.followup.viewCoronaryStandardFollowup";
			break;
		case EHRConstants.DM_FOLLOWUP_TYPE_STANDARD_OTHER:
			name = "rhip.cdm.base.standardization.followup.viewCoronaryStandardOtherFollowup";
			break;
		}
		return name;
	}

	/**
	 * 获取肿瘤随访记录表单,首次,随访,末次
	 * 
	 * @param followupFlag
	 * @return
	 */
	private String getTumorInputViewId(String followupFlag) {
		String name = null;
		switch (followupFlag) {
		case EHRConstants.DM_FOLLOWUP_TUMOR_FIRST:
			name = "rhip.cdm.base.standardization.followup.viewTumorFirstFollowup";
			break;
		case EHRConstants.DM_FOLLOWUP_TUMOR_LAST:
			name = "rhip.cdm.base.standardization.followup.viewTumorLastFollowup";
			break;
		case EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL:
			name = "rhip.cdm.base.standardization.followup.viewTumorFollowup";
			break;
		}
		return name;
	}

	// 新增历史随访计划
	@RequestMapping("/addHbpHistoryData")
	@ResponseBody
	public String addHbpHistoryData(@RequestParam(value = "personId") Long personId, @RequestParam(value = "disType") String disType) {
		String status = followupRecordService.saveHistoryFollowupData(personId, disType, String.valueOf(DateUtil.getCurrentYear()));
		if ("success".equals(status)) {
			return "success";
		} else if ("existUnfinishedPlan".equals(status)) {
			return "existUnfinishedPlan";
		} else {
			return "failure";
		}
	}

	@RequestMapping("/excel")
	public void excel(final QueryForm form, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		try {

			String disType = form.getDiseaseType();
			String title = null;
			Class<?> def = null;
			switch (disType) {
			case EHRConstants.DM_HBP_TYPE:
				def = HbpFollowupExport.class;
				title = "高血压随访详情";
				break;
			case EHRConstants.DM_DI_TYPE:
				def = DiFollowupExportDef.class;
				title = "糖尿病随访详情";
				break;
			case EHRConstants.DM_STROKE_TYPE:
				def = StrtumFollowupExportDef.class;
				title = "脑卒中随访详情";
				break;
			case EHRConstants.DM_TUMOR_TYPE:
				def = TumorFollowupExportDef.class;
				title = "肿瘤随访详情";
				break;
			case EHRConstants.DM_CORONARY_TYPE:
				def = StrtumFollowupExportDef.class;
				title = "冠心病随访详情";
				break;

			default:
				break;
			}

			if (null == def) {
				return;
			}
			form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
			final String targerDistype=disType;
			final RoleType roleType=getRole(request);
			final Organization organization=getCurrentOrg(request);
			excelExportService.exportListExecl(title,def,response,new IDataSource() {
				@Override
				public List<Map<String, Object>> get(Page page) {
					Criteria criteria = form.toCriteria(true, EHRConstants.DM_MANAGED_FLAG);
                    if (ObjectUtil.isNotEmpty(form.getFollowupFlag())) {
                        Date date = followupRecordService.getFollowupNextDateRange(form.getFollowupFlag());
                        criteria.add(followupRecordService.createToFollowupDateRange(date, form.getFollowupFlag()));
                    }
					List<Map<String, Object>> dataSource = followupRecordService.exportDisAndFollowup(page,targerDistype, criteria, organization,roleType );
					return dataSource;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("导出失败", e);
		}
	}
	
	@RequestMapping("/excelPlan")
	public void excelPlan(final QueryForm form, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		try {
			//中文乱码
            if(StringUtil.isNotEmpty(form.getName())){
            	form.setName(new String(form.getName().getBytes("iso8859-1"), "utf-8"));
            }
			String disType = form.getDiseaseType();
			String title = "";
			Class<?> def = FollowupPlanExportDef.class;
			if(StringUtil.isNullOrEmpty(disType)){
				disType = EHRConstants.DM_HBP_TYPE+"," + EHRConstants.DM_DI_TYPE+"," + EHRConstants.DM_STROKE_TYPE+"," + EHRConstants.DM_TUMOR_TYPE+"," + EHRConstants.DM_CORONARY_TYPE;
			}
			
			if(disType.contains(EHRConstants.DM_HBP_TYPE)){
				title = "高血压 ";
			}
			if(disType.contains(EHRConstants.DM_DI_TYPE)){
				title = title + "糖尿病  ";
			}
			if(disType.contains(EHRConstants.DM_STROKE_TYPE)){
				title = title + "脑卒中  ";
			}
			if(disType.contains(EHRConstants.DM_CORONARY_TYPE)){
				title = title + "冠心病  ";
			}
			if(disType.contains(EHRConstants.DM_TUMOR_TYPE)){
				title = title + "肿瘤  ";
			}
			title = title +"随访计划";
			form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
			
			final String targerDistype=disType;
			final RoleType roleType=getRole(request);
			final Organization organization=getCurrentOrg(request);
			excelExportService.exportListExecl(title,def,response,new IDataSource() {
				@Override
				public List<Map<String, Object>> get(Page page) {
					Criteria criteria = form.toCriteria(true, EHRConstants.DM_MANAGED_FLAG);
                   // 有下次随访则以下次随访时间为准；没有则默认为30天内待访
                    Date date = null;
                    Date beginDate = null;
                    if (ObjectUtil.isNotEmpty(form.getNextFollowupDate())) {
                    	date = form.getNextFollowupDate();
                    	beginDate = date;
            		}else {
            			 if (ObjectUtil.isNullOrEmpty(form.getFollowupFlag())) {
            				 form.setFollowupFlag("3");//默认30天内待访
                         }
            			 date = followupRecordService.getFollowupNextDateRange(form.getFollowupFlag());              
                         switch (form.getFollowupFlag()) {
         				 case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
         					beginDate = DateUtil.makeTimeToZero(date);
         					break;
         				 case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
         					beginDate = DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.DAY_OF_MONTH, -7));
         					break;
         				 case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
         					beginDate = DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.MONTH, -1));
         					break;
         			     }
            		} 
                    criteria.add("endDate", DateUtil.toFormatString("yyyy/MM/dd", date));
                	criteria.add("beginDate", DateUtil.toFormatString("yyyy/MM/dd",beginDate));
					List<Map<String, Object>> dataSource = followupRecordService.exportFollowupPlan(page,targerDistype, criteria, organization,roleType );
					return dataSource;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("导出失败", e);
		}
	}

	@RequestMapping("/excelPerson")
	public void excelPerson(final com.founder.rhip.ehr.dto.QueryForm form, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		try {
			String disType = form.getDiseaseType();
			String title = "";
			if(disType.contains(EHRConstants.DM_HBP_TYPE)){
				title = "高血压 ";
			}
			if(disType.contains(EHRConstants.DM_DI_TYPE)){
				title = title + "糖尿病  ";
			}
			if(disType.contains(EHRConstants.DM_STROKE_TYPE)){
				title = title + "脑卒中  ";
			}
			if(disType.contains(EHRConstants.DM_CORONARY_TYPE)){
				title = title + "冠心病  ";
			}
			if(disType.contains(EHRConstants.DM_TUMOR_TYPE)){
				title = title + "肿瘤  ";
			}
			title += "随访人员";
			Class<?> def = PersonFollowupExport.class;
			form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
			final String targerDistype = disType;
			final RoleType roleType= getRole(request);
			final Organization organization=getCurrentOrg(request);
            excelExportService.exportListExecl(title,def,response,new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    Criteria criteria = form.toCriteria(true);
					setDiseaseInfoListDefaultParam(organization, roleType, criteria);
                    if (ObjectUtil.isNotEmpty(form.getFollowupFlag())) {
                        Date date = followupRecordService.getFollowupNextDateRange(form.getFollowupFlag());
                        criteria.add(followupRecordService.createToFollowupDateRange(date, form.getFollowupFlag()));
                    }

                    List<Map<String, Object>> dataSource = followupRecordService.exportPersonFollowup(page, criteria, form);
                    return dataSource;
                }
            });
		} catch (Exception e) {
			throw new RuntimeException("导出失败", e);
		}
	}


	private String validateAddFollowupDate(Long planId, Long personId, Date visitDate, String disType) {
       return "success";
        //不再检查,允许医生补填
       // return followupRecordService.validateAddFollowupDate(planId,personId,visitDate,disType);
    }


    @Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

	@RequestMapping(value="/statistics/search")
	public String searchStarStatistics(HttpServletRequest request, ModelMap model) {
		model.addAttribute("beginDate", DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("endDate", DateUtil.lastDateOfMonth(new Date()));
		return "rhip.cdm.statistics.followup.search";
	}

	/**
	 * 慢病随访-工作量统计
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/statistics/list")
	public String getStarStatistics(HttpServletRequest request, ModelMap model, ReportQueryForm form) {
		setRoleCondition(request, form);
		Organization currentOrg = this.getCurrentOrg(request);
		PageList<Map<String, Object>> followupMapList = followupRecordService.getFollowupStatistics(buildPage(request), form, currentOrg);
		model.addAttribute("followupMapList", followupMapList.getList());
		model.addAttribute("searchType", form.getSearchType());
		return "rhip.cdm.statistics.followup.list";
	}

	private void setRoleCondition(HttpServletRequest request, ReportQueryForm form) {
		Organization currentOrg = this.getCurrentOrg(request);
		if(ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.HOSPITAL.getValue())
				|| ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ) {
			form.setCentreCode(currentOrg.getOrganCode());

		} else if(ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.STATION.getValue())) {
			form.setStationCode(currentOrg.getOrganCode());
		}

	}

	@RequestMapping("/statistics/export")
	public void exportStarStatistics(HttpServletRequest request, HttpServletResponse response, ReportQueryForm form) {
		setRoleCondition(request, form);
		final ReportQueryForm reportQueryForm = form;
		final Organization currentOrg = this.getCurrentOrg(request);
		if(ObjectUtil.equals("2", form.getSearchType())) {
			excelExportService.exportListExecl("慢病随访统计", CdmFollowupStatisticsVillageDto.class, response, new IDataSource() {
				@Override
				public List<Map<String, Object>> get(Page page) {
					return followupRecordService.exportFollowupStatistics(page, reportQueryForm, currentOrg);
				}
			});
		} else {
			excelExportService.exportListExecl("慢病随访统计", CdmFollowupStatisticsDto.class, response, new IDataSource() {
				@Override
				public List<Map<String, Object>> get(Page page) {
					return followupRecordService.exportFollowupStatistics(page, reportQueryForm, currentOrg);
				}
			});
		}
	}


	/**
	 * 指纹验证记录保存
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/fingerVerify/saveRecord")
	@ResponseBody
	public Integer saveFingerVerify(FingerVerifyRecord fingerVerifyRecord, HttpServletRequest request, ModelMap model) {
		Integer rs = 0 ;
		if(fingerVerifyRecord==null)
			return rs;
		//创建时间
		fingerVerifyRecord.setCreateTime(new Date());
		rs = fingerVerifyRecordDao.insert(fingerVerifyRecord);
		return rs;
	}

	@RequestMapping("/diLastVisitInfo")
	@ResponseBody
	public Object diLastVisitInfo(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "visitDate", required = false) String visitDate,
								  @RequestParam(value = "queryType", required = false) String queryType,
								  ModelMap model, HttpServletRequest request) throws ParseException {
		String lastInfo="";
		Criteria cre=new Criteria("personId", personId);
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy/MM/dd");
		cre.add("visitDate",OP.LT,sdf.parse(visitDate));
		List<DmDiabeticFollowup> hbp =followupRecordService.getDiList(cre,new Order("VISIT_DATE DESC"));
		if(ObjectUtil.isNotEmpty(hbp)) {
			if(ObjectUtil.isNotEmpty(queryType)){//查询上次随访药物不良反应
				lastInfo=hbp.get(0).getDrugReaction();
			}else{//查询上次随访分类
				lastInfo=hbp.get(0).getVisitType();
			}
		}
		return lastInfo;
	}

    @RequestMapping("/hbpLastVisitInfo")
    @ResponseBody
    public Object hbpLastVisitInfo(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "visitDate", required = false) String visitDate,
                                  @RequestParam(value = "queryType", required = false) String queryType,
                                  ModelMap model, HttpServletRequest request) throws ParseException {
        String lastInfo="";
        Criteria cre=new Criteria("personId", personId);
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy/MM/dd");
        cre.add("visitDate",OP.LT,sdf.parse(visitDate));
        List<DmHypertensionFollowup> hbp =followupRecordService.getHbpList(cre,new Order("VISIT_DATE DESC"));
        if(ObjectUtil.isNotEmpty(hbp)) {
            if(ObjectUtil.isNotEmpty(queryType)){//查询上次随访药物不良反应
                lastInfo=hbp.get(0).getSideEffects();
            }else{//查询上次随访分类
                lastInfo=hbp.get(0).getVisitType();
            }
        }
        return lastInfo;
    }
}
