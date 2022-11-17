package com.founder.rhip.ehr.controller.ehrbrowser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.elb.entity.Role;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.controller.EhrBaseController;
import com.founder.rhip.ehr.dto.HealthEventItemDTO;
import com.founder.rhip.ehr.dto.HealthHistoryDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.BrwAnonymousSet;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.IdmBrwRole;
import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.service.IBrwAnonymousSetService;
import com.founder.rhip.ehr.service.IDrugService;
import com.founder.rhip.ehr.service.IExamService;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IHealthHistoryService;
import com.founder.rhip.ehr.service.IIdmBrwRoleService;
import com.founder.rhip.ehr.service.ISecrecyDegreeService;
import com.founder.rhip.ehr.service.IStudyService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.sr.controller.form.SrQueryForm;

/**
 * 医疗服务
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/ehrbrowser/service")
public class BrwServiceController extends EhrBaseController {

	@Autowired
	private IDrugService drugService;

	@Autowired
	private IExamService examService;

	@Autowired
	private IHealthEventService healthEventService;

	@Autowired
	private IStudyService studyService;

	@Autowired
	private IHealthHistoryService healthHistoryService;
	
    @Autowired
    private ISecurityService securityService;
    
	@Autowired
	private ISecrecyDegreeService secrecyDegreeService;    
	
	@Autowired
	private IIdmBrwRoleService idmBrwRoleService;

    @Autowired
    private IBrwAnonymousSetService brwAnonymousSetService;
    
    private Properties properties =  PropertiesUtils.initProperties("idmPwd");
    
	/**
	 * 是否显示标志,1表示不显示
	 */
	private static final String IS_LIMIT = "1";

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	private final ExecutorService executor = new ThreadPoolExecutor(4, 4 * 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

	private final String[] drugProperties2 = { "referralHospitalCode", "referralHospitalName", "quantityUnit", "quantity", "startDate", "drugTradeName", "drugGenericName", "drugSpecifications" };

	@RequestMapping()
	public String index(HttpServletRequest request,@RequestParam("personId") Long id, Model model) {
		// left 健康历史
		Criteria criteria = new Criteria();
		criteria.add("personId", id);
		
		//传染病保密设置
		Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
		SecrecyDegreeSet secrecyDegreeSet = getSecrecyDegreeSet(request);
		//如果没有设置保密等级，默认不可见
		if(ObjectUtil.isNotEmpty(secrecyDegreeSet)){
			Integer degree = secrecyDegreeSet.getSecrecyDegree();
			//传染病保密等级中，1:可见，2：不可见
			if(Integer.valueOf(2).equals(degree)){
				criteria.add(limitc);
			}
		}else{
			criteria.add(limitc);
		}
		
		HealthHistoryDTO healthHistoryDTO = healthHistoryService.getHealthHistory(criteria);
		model.addAttribute("healthHistoryDTO", healthHistoryDTO);

		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", id), "name", "birthday", "gender","idcard");
		model.addAttribute("personInfo", personInfo);

		return "rhip.ehr.browser.service";
	}

	/**
	 * 根据疾病code查询此疾病的所有数据
	 * @param diseaseCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/sameDisease")
	public String searchSameDisease(Long personId, String diseaseCode,String diseaseName, ModelMap model, HttpServletRequest request, Integer indexPage) {
		//新的分页
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("diseaseCode", diseaseCode);
		
		PageList<DiseaseDiagnosisInfo> diseaseDiagnosisInfos = healthEventService.getDiseaseDiagnosisInfoPageList(page, criteria);
		model.addAttribute("diseaseDiagnosisInfos", diseaseDiagnosisInfos.getList());
		model.addAttribute("page", diseaseDiagnosisInfos.getPage());
		if(ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfos.getList())) {
			page = super.getPage(request, 1);
			PageList<DiseaseHistory> diseaseHistorys = healthHistoryService.getDiseaseHistorys(criteria, page);
			model.addAttribute("diseaseHistorys", diseaseHistorys.getList());
			model.addAttribute("page", diseaseHistorys.getPage());
		}
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", personId), "inputOrganCode");
		model.addAttribute("personInfo", personInfo);
		model.addAttribute("personId", personId);
		model.addAttribute("diseaseCode", diseaseCode);
		model.addAttribute("diseaseName", diseaseName);
		return "rhip.ehr.browser.service.disease";
	}
	
	@RequestMapping("/relationOrganCodes")
	public String relationOrganCodes(@RequestParam("personId") Long id, Model model) {
		Criteria criteria = new Criteria();
		criteria.add("personId", id);
		List<String> relationOrganCodes = healthEventService.getRelationOrganCodes(id);
        if (isLimitEnabled()){
            relationOrganCodes.removeAll(getLimitedOrganCode());
        }
		model.addAttribute("relationOrganCodes", StringUtils.join(relationOrganCodes, ","));
		return "rhip.ehr.browser.service.orgSelectResult";
	}

	@RequestMapping("/result")
	public String index(HttpServletRequest request, @RequestParam(value = "timeType", defaultValue = "1") String timeType, @RequestParam("personId") Long id, @RequestParam(value = "organCodes", required = false) String organCodes, ModelMap model) {

		final Page page = new Page(5, 1);
		Criterion criterion = new Criterion("personId", id);

		Set<String>organCodeSet = null;

		if (ObjectUtil.isNotEmpty(organCodes)) {
            organCodeSet=new HashSet<>();
			String[] organs= organCodes.split(",");
            for (String organ : organs) {
                organCodeSet.add(organ);
            }
        }

		// 时间间隔
		Date date = null;
		if ("1".equals(timeType.trim())) {
			date = DateUtils.addMonths(DateUtil.getCurrentWithoutTime(), -3);
		} else if ("2".equals(timeType.trim())) {
			date = DateUtils.addYears(DateUtil.getCurrentWithoutTime(), -1);
		}

		// 用药
		final Criteria drugCriteria = new Criteria();
		drugCriteria.addCriterion(criterion);
//		drugCriteria.add("IS_LIMIT",OP.LT,1);
		Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
		//敏感信息可见(IS_LIMIT字段为1的数据）
		boolean isLimitc = true;
		SecrecyDegreeSet secrecyDegreeSet = getSecrecyDegreeSet(request);
		//如果没有设置保密等级，默认不可见
		if(ObjectUtil.isNotEmpty(secrecyDegreeSet)){
			Integer degree = secrecyDegreeSet.getSecrecyDegree();
			//传染病保密等级中，1:可见，2：不可见
			if(Integer.valueOf(1).equals(degree)){
				isLimitc = false;
			}
		}
		//敏感信息不可见(IS_LIMIT字段为1的数据）
		if(isLimitc){
			drugCriteria.add(limitc);
		}
		if (null != date) {
			drugCriteria.add("startDate", OP.GE, date);
		}


        if (ObjectUtil.isNotEmpty(organCodeSet)) {
            if (isLimitEnabled()){
                organCodeSet.removeAll(getLimitedOrganCode());
            }
            drugCriteria.add("referralHospitalCode", OP.IN, organCodeSet);
        }else{
            if (isLimitEnabled()){
                drugCriteria.add("referralHospitalCode",OP.NOTIN,getLimitedOrganCode());
            }
        }

		final Order drguOrder = new Order("START_DATE", false).desc("rowid");
		Callable<PageList<DrugUsage>> drugUsageQuery = new Callable<PageList<DrugUsage>>() {
			@Override
			public PageList<DrugUsage> call() throws Exception {
				PageList<DrugUsage> drugUsages = drugService.getDrugUsage(page, drugCriteria, drguOrder, drugProperties2);
				return drugUsages;
			}
		};

		// 检验
		final Criteria examCriteria = new Criteria();
		examCriteria.addCriterion(criterion);
//		examCriteria.add("IS_LIMIT",OP.LT,1);
		//敏感信息不可见(IS_LIMIT字段为1的数据）
		if(isLimitc){
			examCriteria.add(limitc);
		}
	
		if (null != date) {
			examCriteria.add("checkDate", OP.GE, date);
		}

		if (ObjectUtil.isNotEmpty(organCodeSet)) {
            if (isLimitEnabled()){
                organCodeSet.removeAll(getLimitedOrganCode());
            }
			examCriteria.add("hospitalCode", OP.IN, organCodeSet);
		}else{
            if (isLimitEnabled()){
                examCriteria.add("hospitalCode",OP.NOTIN,getLimitedOrganCode());
            }
        }

		final Order examOrder = new Order("CHECK_DATE", false).desc("rowid");
		Callable<PageList<ExamineEvent>> examQuery = new Callable<PageList<ExamineEvent>>() {
			@Override
			public PageList<ExamineEvent> call() throws Exception {
				PageList<ExamineEvent> examineEvents = examService.getExamEventList(page, examCriteria, examOrder);
				return examineEvents;
			}
		};

		// 检查
		Callable<PageList<StudyEvent>> studyQuery = new Callable<PageList<StudyEvent>>() {
			@Override
			public PageList<StudyEvent> call() throws Exception {
				PageList<StudyEvent> studyEvents = studyService.getStudyEventList(page, examCriteria, examOrder);
				return studyEvents;
			}
		};

		// 事件活动
		final Criteria criteria = new Criteria();
		//删除标志,add by yejianfei 20140801 ,IS_DELETE<>1
		Criteria deleteCriteria = new Criteria("IS_DELETE",OP.NE,EHRConstants.DELETE_FLG_1);
		deleteCriteria.add(LOP.OR,"IS_DELETE",OP.IS,"NULL");
		criteria.add(deleteCriteria);
		criteria.addCriterion(criterion);
//		criteria.add("IS_LIMIT",OP.LT,1);
		//敏感信息不可见(IS_LIMIT字段为1的数据）
		if(isLimitc){
			criteria.add(limitc);
		}
		if (null != date) {
			criteria.add("clinicDate", OP.GE, date);
		}

        if (ObjectUtil.isNotEmpty(organCodeSet)) {
            if (isLimitEnabled()){
                organCodeSet.removeAll(getLimitedOrganCode());
            }
            criteria.add("clinicOrganCode", OP.IN, organCodeSet);
        }else{
            if (isLimitEnabled()){
                criteria.add("clinicOrganCode",OP.NOTIN,getLimitedOrganCode());
            }
        }

		final Order order = new Order("CLINIC_DATE", false).desc("rowid");
		criteria.add("ehrType", OP.IN, Arrays.asList(EventType.OUTPATIENT.getCode(), EventType.INPATIENT.getCode(), EventType.PHYSICAL_EXAMINATION.getCode(), EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(),
				EventType.COMMERCIAL_PHYSICAL_EXAMINATION.getCode(), EventType.STUDENT_PHYSICAL_EXAMINATION.getCode(), EventType.WOMEN_PHYSICAL_EXAMINATION.getCode(), EventType.OCCUPATION_PHYSICAL_EXAMINATION.getCode(),
				EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(), EventType.OTHER_PHYSICAL_EXAMINATION.getCode(), EventType.HEALTH_CERTIFICATE_EXAMINATION.getCode(), EventType.EMPLOYEE_PHYSICAL_EXAMINATION.getCode()));

		Callable<PageList<HealthEventItemDTO>> eventQuery = new Callable<PageList<HealthEventItemDTO>>() {
			@Override
			public PageList<HealthEventItemDTO> call() throws Exception {
				PageList<HealthEventItemDTO> HealthEventItem = healthEventService.getMedicalSeviceHealthEventList(page, criteria, order);
				return HealthEventItem;
			}
		};

		Future<PageList<DrugUsage>> drugUsageQueryFuture = null;
		Future<PageList<ExamineEvent>> examQueryFuture = null;
		Future<PageList<StudyEvent>> studyQueryFuture = null;
		Future<PageList<HealthEventItemDTO>> eventQueryFuture = null;
		try {
			drugUsageQueryFuture = executor.submit(drugUsageQuery);
			examQueryFuture = executor.submit(examQuery);
			studyQueryFuture = executor.submit(studyQuery);
			eventQueryFuture = executor.submit(eventQuery);
		} catch (RejectedExecutionException e) {
			logger.error("访问量太大", e);
		}

		try {
			if (null != drugUsageQueryFuture) {
				PageList<DrugUsage> drugUsages = drugUsageQueryFuture.get();
				model.addAttribute("drugUsages", null != drugUsages ? drugUsages.getList() : Collections.emptyList());
			}
		} catch (InterruptedException | ExecutionException e) {
			logger.error("", e);
		}

		try {
			if (null != examQueryFuture) {
				PageList<ExamineEvent> examineEvents = examQueryFuture.get();
				model.addAttribute("examineEvents", null != examineEvents ? examineEvents.getList() : Collections.emptyList());
			}
		} catch (InterruptedException | ExecutionException e) {
			logger.error("", e);
		}

		try {
			if (null != studyQueryFuture) {
				PageList<StudyEvent> studyEvents = studyQueryFuture.get();
				model.addAttribute("studyEvents", null != studyEvents ? studyEvents.getList() : Collections.emptyList());
			}
		} catch (InterruptedException | ExecutionException e) {
			logger.error("", e);
		}

		try {
			if (null != eventQueryFuture) {
				PageList<HealthEventItemDTO> healthEventItems = eventQueryFuture.get();
				model.addAttribute("healthEventItems", null != healthEventItems ? healthEventItems.getList() : Collections.emptyList());
			}
		} catch (InterruptedException | ExecutionException e) {
			logger.error("", e);
		}

		return "rhip.ehr.browser.service.result";
	}
	

	@RequestMapping("/secrecyDegreeSet")
	public String secrecyDegreeIndex() {
		return "rhip.ehr.secrecyDegreeSet.index";
	}

	@RequestMapping("/secrecyDegree/list")
	public String list(HttpServletRequest request, ModelMap modelMap, int pageIndex, SrQueryForm form) {
		Criteria criteria = new Criteria();
		Page page = super.getPage(request, pageIndex);
		String orgCode = form.getOrgCode();
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("organCode", orgCode);
		}
		PageList<SecrecyDegreeSet> pList = secrecyDegreeService.getSecrecyDegreeList(page, criteria);
		modelMap.addAttribute("resultList", pList.getList());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("pageIndex", pageIndex);
		return "rhip.ehr.secrecyDegreeSet.list";
	}

	@RequestMapping("/secrecyDegree/initAdd")
	public String initAdd(HttpServletRequest request, ModelMap model, Long id) {
		if (ObjectUtil.isNotEmpty(id)) {
			SecrecyDegreeSet secrecyDegreeSet = secrecyDegreeService.getSecrecyDegree(new Criteria("id", id));
			model.addAttribute("secrecyDegreeSet", secrecyDegreeSet);
		}
		return "rhip.ehr.secrecyDegreeSet.add";
	}

	@RequestMapping("/secrecyDegree/save")
	public String secrecyDegreeSave(SecrecyDegreeSet secrecyDegreeSet, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		secrecyDegreeSet.setCreateDate(new Date());
		if(StringUtil.isNotEmpty(secrecyDegreeSet.getOrganCode_name())){
			secrecyDegreeSet.setOrganName(secrecyDegreeSet.getOrganCode_name());
		}
		secrecyDegreeSet.setCreateUserCode(String.valueOf(getCurrentUser(request).getId()));
		secrecyDegreeService.save(secrecyDegreeSet);
		result = true;
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	@RequestMapping("/secrecyDegree/delete")
	public String secrecyDegreeDelete(SecrecyDegreeSet secrecyDegreeSet, Model model) {
		secrecyDegreeService.delete(secrecyDegreeSet);
		return "rhip.conifg.check.secrecyDegree";
	}

	@RequestMapping("/brwIdmRoleIndex")
	public String brwIdmRoleIndex(Model model) {
		List<Role> roles = securityService.getRoles();
		Criteria criteria = new Criteria();
		List<IdmBrwRole> idmBrwRoles = idmBrwRoleService.getIdmBrwRoles(criteria);
		for(IdmBrwRole idmBrwRole : idmBrwRoles){
			for(Role role : roles){
				if(idmBrwRole.getRoleType().equalsIgnoreCase(role.getRoleCode())){
					role.setIsCheck(EHRConstants.ROLE_SELECT_1);//1为被选中
					break;
				}
			}
		}
		model.addAttribute("roles", roles);
		return "rhip.ehr.brwIdmRole.index";
	}
	
	@RequestMapping("/brwIdmRole/save")
	public String brwIdmRoleSave(HttpServletRequest request, String roleNames, ModelMap model) {
		Boolean result = false;
		idmBrwRoleService.saveBath(request, roleNames);
		result = true;
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	//档案隐私匿名查询
    @RequestMapping("/anonymousSet")
    public String anonymousSetIndex(Model model) {
        List<Role> roles = securityService.getRoles();
        Criteria criteria = new Criteria();
        List<BrwAnonymousSet> brwAnonymousSets = brwAnonymousSetService.getBrwAnonymousSets(criteria);
        for(BrwAnonymousSet brwAnonymousSet : brwAnonymousSets){
            for(Role role : roles){
                if(brwAnonymousSet.getRoleType().equalsIgnoreCase(role.getRoleCode())){
                    role.setIsCheck(EHRConstants.ROLE_SELECT_1);//1为被选中
                    break;
                }
            }
        }
        model.addAttribute("roles", roles);
        return "rhip.ehr.anonymousSet.index";
    }

    //档案隐私匿名保存
    @RequestMapping("/anonymousSet/save")
    public String anonymousSetSave(HttpServletRequest request, String roleNames, String roleNamePwd, ModelMap model) {
        String result = "false";
        String idmpwd = properties.getProperty("idm.pwd");
        if(roleNamePwd.equalsIgnoreCase(idmpwd)){
            brwAnonymousSetService.saveBath(request, roleNames);

            request.getSession().setAttribute("brwAnonymousSetStr", roleNames);

            result = "success";
        }else{
            result = "error";
        }
        return EHRMessageUtil.returnMsg(model, result);
    }

    /**
	 * 获取当前机构的传染病保密登记设置
	 * @param request
	 * @return
	 */
	private SecrecyDegreeSet getSecrecyDegreeSet(HttpServletRequest request){
		Organization currentOrg = getCurrentOrg(request);
		String organCode = "";
		if(ObjectUtil.isNullOrEmpty(currentOrg)){
			Map<String, String>  explorerInfo = (HashMap)request.getSession().getAttribute("explorerInfo");
			organCode = explorerInfo.get("viewOrganCode");
		}else{
			organCode = getCurrentOrg(request).getOrganCode();
		}
		Criteria criteria = new Criteria("ORGAN_CODE",organCode);
		return  secrecyDegreeService.getSecrecyDegree(criteria);
	}
}
