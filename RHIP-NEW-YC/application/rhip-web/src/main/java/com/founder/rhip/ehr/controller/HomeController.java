package com.founder.rhip.ehr.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.cdm.controller.reportcard.QueryForm;
import com.founder.rhip.cdm.service.IFollowupRecordService;
import com.founder.rhip.cdm.service.IReportCardService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.*;
import com.founder.rhip.ehr.entity.child.ChildWeekExamNum;
import com.founder.rhip.ehr.entity.clinic.BrwAnonymousSet;
import com.founder.rhip.ehr.entity.clinic.IdmBrwRole;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.service.IBrwAnonymousSetService;
import com.founder.rhip.ehr.service.IIdmBrwRoleService;
import com.founder.rhip.ehr.service.basic.IBulletinService;
import com.founder.rhip.ehr.service.basic.IOrganizationItemRelationService;
import com.founder.rhip.ehr.service.basic.IQuestionService;
import com.founder.rhip.ehr.service.child.IChildWeekExamNumService;
import com.founder.rhip.fdm.entity.FoodBorneReport;
import com.founder.rhip.fdm.service.IFoodBorneReportService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.ihm.service.IMessageService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.whch.service.IWhchService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController {
	
	@Autowired
	private IBulletinService bulletinService;
	
	@Autowired
	private IQuestionService questionService;

	@Resource(name = "followupRecordService")
	private IFollowupRecordService followupRecordService;

	@Resource(name = "whchService")
	private IWhchService whchService;

	@Resource(name = "physicalExamRecordService")
	private IPhysicalExamRecordService physicalExamRecordService;

	@Resource(name = "personInfoService")
	private IPersonInfoService personInfoService;

	@Resource(name = "organizationItemRelationService")
	private IOrganizationItemRelationService organizationItemRelationService;

	@Resource(name = "foodBorneReportService")
	private IFoodBorneReportService foodBorneReportService;

	@Resource(name = "reportService")
	private IReportService reportService;

	@Resource(name = "reportCardService")
	private IReportCardService reportCardService;

	@Resource(name = "messageService")
	private IMessageService messageService;

	@Autowired
	private IChildWeekExamNumService childWeekExamNumService;
	
    @Autowired
    private IBrwAnonymousSetService brwAnonymousSetService;

	@Autowired
	private IIdmBrwRoleService idmBrwRoleService;
    
	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("menus") == null) {
			if(ObjectUtil.isNotEmpty(request.getParameter("saas"))){
				request.getSession().setAttribute("saas",request.getParameter("saas"));
			}
            return "redirect:/access/cas";
        } else {
            request.getSession().setAttribute("ANONYMOUS_X", "*");
            request.getSession().setAttribute("ANONYMOUS_2X", "**");
            request.getSession().setAttribute("ANONYMOUS_3X", "***");
            request.getSession().setAttribute("ANONYMOUS_XS", "********");
        	initBulletin(request,model);
        	initQuestion(request,model);
			String saas = null;
			if(ObjectUtil.isNotEmpty(request.getParameter("saas"))){
				saas = request.getParameter("saas");
			}
			if(ObjectUtil.isNotEmpty(request.getSession().getAttribute("saas"))){
				saas = request.getSession().getAttribute("saas").toString();
			}
            model.addAttribute("saas", saas);
			List<Organization> orgList = (List<Organization>) request.getSession().getAttribute("organizations");
			if (orgList == null) {
				model.addAttribute("multiOrg", false);
			} else if (orgList.size() > 1) {
				model.addAttribute("multiOrg", true);
			}
			getBrwAnonymousSet(request);
			getIdmBrwRole(request);
//            return "rhip.ehr.login.after";
			return "rhip.ehr.login.x.admin.after";
        }
	}

	@RequestMapping("/welcome")
	public String welcome(Model model, HttpServletRequest request) {
		model.addAttribute("currentDate", new Date());
		initTodoList(request, model);
		initBulletin(request, model);
		initQuestion(request, model);
		return "rhip.home.welcome";
	}
	
	@RequestMapping(value = "/load")
	public String load(HttpServletRequest request, Model model) {
    	initBulletin(request,model);
    	initQuestion(request, model);
		initTodoList(request, model);
//        return "rhip.ehr.login.home";
        return "rhip.home.welcome";
	}
	
	private void initBulletin(HttpServletRequest request, Model model){
		Page page = new Page(5,1);
		Criteria criteria = new Criteria("isDelete",0);
		PageList<Bulletin> bulletinList = bulletinService.getBulletinPageList(page,criteria);
		model.addAttribute("bulletins", bulletinList.getList());
	}
	
	private void initQuestion(HttpServletRequest request, Model model){
		Page page = new Page(5,1);
		Criteria criteria = new Criteria();
		//bug0133518
		/*if(!super.hasRole(RoleType.ADMIN, request)){
			criteria.add("submitor", super.getCurrentUser(request).getId());
		}*/
		PageList<Question> questionList = questionService.getQuestionPageList(page, criteria);
		model.addAttribute("submitor", getCurrentUser(request).getId());
		model.addAttribute("questions", questionList.getList());
	}

	private void initTodoList(HttpServletRequest request, Model model){
		Organization organization = getCurrentOrg(request);
		String organCode = organization.getOrganCode();
		Map<String, Long> todoMap = new HashedMap();
		if(hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.JKFYK, request) || hasRole(RoleType.DDCRBYY, request)|| hasRole(RoleType.JKMBK, request) ){
			//传染病报卡
			todoMap.put("idmCount", Long.valueOf(getIdmReport(request, null, null)));
			//慢病报卡
			todoMap.put("cdmCount", Long.valueOf(getCmdReport(request, null, null)));
			//食源性疾病报卡
			todoMap.put("fdmCount", Long.valueOf(getFdmReport(request, null, null)));
		}

		if(hasRole(RoleType.Z_GLY, request)){
			//慢病随访
			Map<String, Long> todoMapTemp = followupRecordService.getToFollowupCount(getCurrentOrg(request), getRole(request));
			todoMap.put("todayCount", todoMapTemp.get("todayCount"));
			todoMap.put("thisWeekCount", todoMapTemp.get("thisWeekCount"));
			todoMap.put("thisMonthCount", todoMapTemp.get("thisMonthCount"));
			todoMap.put("expireCount", todoMapTemp.get("expireCount"));
			//计免、妇幼预约
			Criteria caReserve = new Criteria();
			if(!hasRole(RoleType.ADMIN, request)){
				caReserve.add("ORGAN_CODE", getCurrentOrg(request).getOrganCode());
			}
			/*PageList<ReserveChild> childPageList = whchService.getChildList(new Page(10, 1), caReserve);*/
			//PageList<ReserveMaternal> maternalPageList = whchService.getMaternalList(new Page(10, 1), caReserve);
			//PageList<ReserveVaccination> vaccinationPageList = whchService.getVaccinationList(new Page(10, 1), caReserve);
			/*todoMap.put("childCount", (long)childPageList.getPage().getTotalRows());*/
			//todoMap.put("maternalCount", (long)maternalPageList.getPage().getTotalRows());
			//todoMap.put("vaccinationCount", (long)vaccinationPageList.getPage().getTotalRows());
		}

        /*健康档案未建档（现住址属于这个站+未建档） start  add by wangzhou*/
		if(hasRole(RoleType.Z_GLY, request)){
			Criteria cah = new Criteria();
			cah.add("orgCode",organCode);
			//根据当前服务站查询下面的所有的居委会
			List<OrganizationItemRelation> oir = organizationItemRelationService.getOrganizationItemRelation(cah);
			List<String> strList = new ArrayList<String>();
			for(int i=0;i<oir.size();i++){
				strList.add(oir.get(i).getItemCode());
			}
			String[] arr = (String[])strList.toArray(new String[strList.size()]);
			Criteria cahealth = new Criteria();
			if(arr.length>0){
				cahealth.add("pastreet", OP.IN, arr);
			}else{
				cahealth.add("pastreet", OP.EQ, null);
			}
			cahealth.add("filingFlag", OP.EQ, "0");
			List<PersonInfo> pInfolist = personInfoService.getPersonInfo(cahealth);
			todoMap.put("personNofileCount", (long)pInfolist.size());
		}
        /*健康档案未建档（现住址属于这个站+未建档）  end add by wangzhou*/

        /*老年人待体检（现住址属于这个站+未建档） start  add by wangzhou*/
		if(hasRole(RoleType.Z_GLY, request)||hasRole(RoleType.ZX_GLY, request)){
			ChildWeekExamNum childWeekExamNum = childWeekExamNumService.getChildNum(new Criteria("organCode",getCurrentOrg(request).getOrganCode()));
			long childCount = 0;
			if(ObjectUtil.isNotEmpty(childWeekExamNum)){
				childCount = childWeekExamNum.getChildExamnum();
			}
			todoMap.put("childCount", childCount);
			Criteria caexam = new Criteria();
//			caexam.add("examStatus", OP.EQ, "0");
			caexam.add("examYear", OP.BETWEEN, DateUtil.getDateRangeByYear(DateUtil.getCurrentYear()));
			if (hasRole(RoleType.ZX_GLY, request)) {
				caexam.add("inputSuperOrganCode", OP.EQ, organCode);
			}else if (hasRole(RoleType.Z_GLY, request)) {
				caexam.add("inputOrganCode", OP.EQ, organCode);
			}
			List<PhysicalExamRecord> perlist = physicalExamRecordService.getPhysicalExamRecords(caexam);
			todoMap.put("physicalExamCount", (long) perlist.size());
		}
        /*老年人待体检（中心、站登录，是否体检为否的）  end add by wangzhou*/

		model.addAttribute("todoMap", todoMap);
	}

	/**
	 *获取传染病报卡（待审核）
	 */
	private int getIdmReport(HttpServletRequest request, Date beginDate, Date endDate){
		Criteria criteria = new Criteria("reportStatus", OP.EQ, 1);
		criteria.add("idmType", OP.EQ, "1");
		DateUtil.getCriteriaByDateRange(criteria, "fillDate", beginDate, endDate);
		Organization organization = getCurrentOrg(request);
		String organCode = organization.getOrganCode();
		if(hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.JKFYK, request) ||hasRole(RoleType.DDCRBYY, request)){
			Criteria ca = new Criteria("CURRENT_UNIT", OP.EQ, organCode);
			Criteria ca1 = new Criteria("fillOrganCode", OP.EQ, organCode);
			ca.add(LOP.OR, ca1);
			criteria.add(ca);
		}
		PageList<IdmReport> plist = reportService.findReport(criteria, new Page(10, 1));
		return plist.getPage().getTotalRows();
	}

	private int getCmdReport(HttpServletRequest request, Date beginDate, Date endDate){
		Criteria caCmd = new Criteria("cdmStatusInfo.REPORT_STATUS", OP.IN, new String[]{"1","2"});//待审批
		QueryForm queryForm = new QueryForm();
		queryForm.setReportStatusArray("1,2");
		setViewAndAppDefaultParam(queryForm, caCmd, getRole(request), getCurrentOrg(request));
		List<DmPersonInfo> reportes = reportCardService.getReportsGroupByPersonId(new Page(10, 1), caCmd);
		return reportes.size();
	}

	private int getFdmReport(HttpServletRequest request, Date beginDate, Date endDate){
		Criteria caFmd = new Criteria("STATUS", "1");//待审批
		List<FoodBorneReport> records = foodBorneReportService.getPagedReports(new Page(10, 1), caFmd, getRole(request), getCurrentOrg(request));
		return records.size();
	}

	/**
	 * 设置查看的权限
	 *
	 * @param queryForm             the query form
	 * @param criteria             the criteria
	 * @param roleType             the role type
	 * @param organization             the organization
	 */
	private void setViewAndAppDefaultParam(QueryForm queryForm, Criteria criteria, RoleType roleType, Organization organization) {
		if (roleType.equals(RoleType.ZX_GLY)) {
			// 报卡状态条件
			String[] reports = queryForm.getReportStatusArray();
			// 审核页面,在审核时,只能看到下级上报的报卡.在分配时,只能看到分配给自己的报卡
			if (ObjectUtil.isNotEmpty(reports)) {
				for (String string : reports) {
					if (null != string) {
						string = string.trim();
						// 分配
						if (ApprovalState.VERIFIED_SECOND.getValue().equals(string) || ApprovalState.ALLOC_REJECT_SECOND.getValue().equals(string)) {
							criteria.add("dmReportInfo.SUPER_MANAGE_ORGAN_CODE", organization.getOrganCode());
							return;
						}
						// 审核
						if (ApprovalState.READY.getValue().equals(string) || ApprovalState.REJECT.getValue().equals(string)) {
							criteria.add("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
							return;
						}
					}
				}
			}

			Criteria criteriaOr = new Criteria("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
			criteriaOr.add(LOP.OR, "dmReportInfo.SUPER_MANAGE_ORGAN_CODE", organization.getOrganCode());
			criteria.add(criteriaOr);

		} else if (roleType.equals(RoleType.DDCRBYY)) {
			criteria.add("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if (roleType.equals(RoleType.Z_GLY)) {
			criteria.add("dmReportInfo.MANAGE_ORGAN_CODE", organization.getOrganCode());
		}
	}

	/**
	 * 获取角色
	 *
	 * @param request
	 * @return
	 */
	public RoleType getRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.DDCRBYY, request)) {
			role = RoleType.DDCRBYY;
		} else if (hasRole(RoleType.ZX_GLY, request)) {
			role = RoleType.ZX_GLY;
		} else if (hasRole(RoleType.JKMBK, request)) {
			role = RoleType.JKMBK;
		} else if (hasRole(RoleType.Z_GLY, request)) {
			role = RoleType.Z_GLY;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		} else if (hasRole(RoleType.JKFYK, request)){
			role = RoleType.JKFYK;
		}
		return role;
	}

	@RequestMapping(value = "/getLatestReport")
	@ResponseBody
	public Map<String, Object> getLatestReport(HttpServletRequest request){
		Map<String, Object> result = new HashedMap();

		//获取传染病报卡，待提醒消息
		Criteria crIdm = new Criteria("type",1).add("status", 1).add("RECEIVING_UNIT", getCurrentOrg(request).getOrganCode());
		List<MessageSent> idmMsgs = messageService.getMessages(crIdm);

		//获取慢病报卡，待提醒消息
		Criteria crCmd = new Criteria("type",2).add("status", 1).add("RECEIVING_UNIT", getCurrentOrg(request).getOrganCode());
		List<MessageSent> cmdMsgs = messageService.getMessages(crCmd);

		//获取食源性疾病报卡，待提醒消息
		Criteria fdmCmd = new Criteria("type",3).add("status", 1).add("RECEIVING_UNIT", getCurrentOrg(request).getOrganCode());
		List<MessageSent> fdmMsgs = messageService.getMessages(fdmCmd);

//		int idmReport = getIdmReport(request, null, null);
//		int cmdReport = getCmdReport(request, null, null);
		result.put("idmCount", idmMsgs);
		result.put("cmdCount", cmdMsgs);
		result.put("fdmCount", fdmMsgs);
		return result;
	}
	

    /**
     * 匿名查看基本信息的角色
     * @param request
     */
    private void getBrwAnonymousSet(HttpServletRequest request){
        String brwAnonymousSetStr = "";
        brwAnonymousSetStr = (String) request.getSession().getAttribute("brwAnonymousSetStr");
        if(null != brwAnonymousSetStr && brwAnonymousSetStr!=""){
            return;
        }
        brwAnonymousSetStr = "";
        Criteria criteria = new Criteria();
        List<BrwAnonymousSet> brwAnonymousSets = brwAnonymousSetService.getBrwAnonymousSets(criteria);
        for(BrwAnonymousSet brwAnonymousSet : brwAnonymousSets){
            brwAnonymousSetStr += brwAnonymousSet.getRoleType()+",";
        }
        if(brwAnonymousSetStr.endsWith(",")){
            brwAnonymousSetStr = brwAnonymousSetStr.substring(0, brwAnonymousSetStr.length()-1);
        }
        request.getSession().setAttribute("brwAnonymousSetStr", brwAnonymousSetStr);
    }

	/**
	 * 查看健康档案浏览器疾病控制角色
	 */
	private void getIdmBrwRole(HttpServletRequest request){
		Criteria criteria = new Criteria();
		List<IdmBrwRole> idmBrwRoles = idmBrwRoleService.getIdmBrwRoles(criteria);
		String idmBrwRoleStr = "";
		for(IdmBrwRole idmBrwRole : idmBrwRoles){
			idmBrwRoleStr += idmBrwRole.getRoleType()+",";
		}
		if(idmBrwRoleStr.endsWith(",")){
			idmBrwRoleStr = idmBrwRoleStr.substring(0, idmBrwRoleStr.length()-1);
		}
		request.getSession().setAttribute("idmBrwRoleStr", idmBrwRoleStr);
	}
}
