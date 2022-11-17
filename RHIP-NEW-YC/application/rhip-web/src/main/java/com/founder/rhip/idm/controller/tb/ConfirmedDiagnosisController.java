package com.founder.rhip.idm.controller.tb;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListTr;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.common.TbStatus;
import com.founder.rhip.idm.controller.form.TbQueryForm;
import com.founder.rhip.idm.dto.TbSaveDto;
import com.founder.rhip.idm.service.ITbService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 疑似推荐、筛查登记、转诊、追踪记录
 */
@Controller
@RequestMapping("/idm/tb/confirmed")
public class ConfirmedDiagnosisController extends BaseController {
	@Autowired
	private IDictionaryApp dictionaryApp;

	@Resource(name = "tbService")
	private ITbService tbService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;
	
	@RequestMapping("/index")
    public String index(HttpServletRequest request, ModelMap model) {
		request.getSession().setAttribute("typeTb", "1");
//        if (!hasRole(RoleType.JKJHB, request)) {
//            model.put("orgCode",this.getCurrentOrg(request).getOrganCode());
//        }
        addByZX(model, request);
        return "rhip.idm.tb.index";
    }

    private void addByZX(ModelMap model,HttpServletRequest request){
        if(hasRole(RoleType.ZXJHB, request)){
            List<Organization> orgList = new ArrayList<>();
            Organization org = getCurrentOrg(request);
            orgList.add(org);
            orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
            model.addAttribute("orgList", orgList);
            model.addAttribute("sqzx", org);
            model.addAttribute("isSqzx", "1");
        }else if(hasRole(RoleType.YYJHB, request)){
			model.addAttribute("currentOrg", getCurrentOrg(request).getOrganCode());
		}
    }
	
	@RequestMapping("/recommendation/search")
    public String recommendationSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.recommendation.search";
    }
	
	/**
     * 疑似推荐列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/recommendation/list")
    public String searchRecommendationList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_RECOMMENDATION.getValue()});
		//疾控-结核病查看所有数据
		if(!hasRole(RoleType.JKJHB,request)){
			//权限
			criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());
		}

		
		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);
		model.addAttribute("recommendations", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.recommendation.list";
    }

	@RequestMapping(value = "/recommendation/downLoad")
	public void downRecommendationExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/Recommendation.xls"));
			Criteria criteria = form.getCriteria();
			criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_RECOMMENDATION.getValue()});
			//疾控-结核病查看所有数据
			if(!hasRole(RoleType.JKJHB,request)){
				//权限
				criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());
			}
			List<Map<String, Object>> plist = tbService.downTreatmentList(criteria, null, null);

			int totalRows = 7;
			int beginRowIndex = 5;
			int line = 0;
			excel.shiftRows(line + beginRowIndex, totalRows + line,plist.size());
			for (Map<String, Object> transfer : plist) {
				List<Object> objects = getRecommendationExcelValues(transfer, line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex);
				line++;
			}
			excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
			setExcelContent(response, "疑似推荐汇总.xls");
			excel.save(response.getOutputStream());

			plist.clear();
//			transferList = null;
		} catch (Exception e) {
			log.error("下载《疑似推荐汇总》出错", e);
			throw e;
		}
	}

	/**
	 * 生成疑似与检查EXCEL一行数据
	 *
	 * @param transfer
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getRecommendationExcelValues(Map<String, Object> transfer, int lineNumber) {
		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(transfer.get("name"));
		Object gender = transfer.get("gender");
		if(gender!=null)
			line.add(dictionaryApp.queryDicItemName("GBT226112003", gender.toString()));
		else
			line.add("");
		line.add(transfer.get("idcard"));
		Object float_population = transfer.get("float_population");
		if(float_population!=null)
			line.add(dictionaryApp.queryDicItemName("FS10005",float_population.toString()));
		else
			line.add("");
		line.add(transfer.get("pa_address"));
		Object modify_survey_org = transfer.get("modify_survey_org");
		if(modify_survey_org==null)
			line.add("");
		else
			line.add(DictionaryCache.orgMap.get("0|"+modify_survey_org));
		Object modify_survey_date= transfer.get("modify_survey_date");
		if(modify_survey_date==null)
			line.add("");
		else
			line.add(DateUtil.convertDateToString((Date)modify_survey_date));
//		line.add(dictionaryApp.queryDicItemName("IDM00214",transfer.get("A33").toString()));
//		line.add("1".equals(transfer.get("A2").toString())?"未登记筛查":"已登记筛查");
//		line.add(transfer.get("AANAME"));
		return line;
	}

    /**
     * 删除结核病某个事件的数据
     * @param singleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(Long singleId, Long idmId, ModelMap model, HttpServletRequest request) {
    	boolean result = tbService.deleteTbSaveDto(singleId, idmId);
    	createOperationLog(request, RhipModuleName.IDM, "结核病专项", OperationName.DELETE);
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
	@RequestMapping("/register/search")
    public String registerSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.register.search";
    }
	
    /**
     * 筛查登记列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/register/list")
    public String searchRegisterList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		this.getEventId(form, criteria, SpecialEvents.T_RECOMMENDATION.getValue(), SpecialEvents.T_REGISTER.getValue());
		/*组装查询页面状态的条件*/
		this.getCriteriaForRegister(form, criteria);
		//疾控-结核病查看所有数据
		if(!hasRole(RoleType.JKJHB,request)){
			criteria.add("caseInfo.REVIEW_UNIT", getCurrentOrg(request).getOrganCode());
		}
		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);
		model.addAttribute("registers", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.register.list";
    }

    /**
	 * 导出筛查登记列表
     *
	 * @param request
     * @param model
     * @return
			 */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/register/downLoad")
	public void downRegisterExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/Register.xls"));
			Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
			this.getEventId(form, criteria, SpecialEvents.T_RECOMMENDATION.getValue(), SpecialEvents.T_REGISTER.getValue());;
		/*组装查询页面状态的条件*/
			this.getCriteriaForRegister(form, criteria);
			criteria.add("caseInfo.REVIEW_UNIT", getCurrentOrg(request).getOrganCode());
//			criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
//			List<IdmStatusInfo> plist = tbService.findTreatList( criteria, null, null);
			List<Map<String, Object>> plist = tbService.downTreatList(criteria, null, null);

			int totalRows = 7;
			int beginRowIndex = 5;
			int line = 0;
			excel.shiftRows(line + beginRowIndex, totalRows + line,plist.size());
			for (Map<String, Object> transfer : plist) {
				List<Object> objects = getRegisterExcelValues(transfer, line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex);
				line++;
			}
			excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
			setExcelContent(response, "结核病人疑似与检查汇总.xls");
			excel.save(response.getOutputStream());

			plist.clear();
//			transferList = null;
		} catch (Exception e) {
			log.error("下载《结核病人疑似与检查登记汇总》出错", e);
			throw e;
		}
	}





	/**
	 * 生成疑似与检查EXCEL一行数据
	 *
	 * @param transfer
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getRegisterExcelValues(Map<String, Object> transfer, int lineNumber) {
		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(transfer.get("A7"));
		line.add(dictionaryApp.queryDicItemName("GBT226112003", transfer.get("A8").toString()));
		line.add(transfer.get("A10"));
		if(transfer.get("A31")==null){
			line.add(" ");
		}else{
			line.add(dictionaryApp.queryDicItemName("IDM00216",transfer.get("A31").toString()));
		}
		if(transfer.get("A33")==null){
			line.add(" ");
		}else{
			line.add(dictionaryApp.queryDicItemName("IDM00214",transfer.get("A33").toString()));
		}
		line.add("1".equals(transfer.get("A2").toString())?"未登记筛查":"已登记筛查");
		line.add(transfer.get("AANAME"));
		return line;
	}

	@RequestMapping("/transfertreat/search")
    public String transfertreatSearch(HttpServletRequest request, ModelMap model) {
		/*待追踪患者*/
		model.addAttribute("notSeeDoctorCount", getNotSeeDoctorCount(request));
        return "rhip.idm.transfertreat.search";
    }
	
    /**
     * 转诊列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/transfertreat/list")
    public String searchTransfertreatList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		this.getEventId(form, criteria, SpecialEvents.T_REGISTER.getValue(), SpecialEvents.T_TRANSFERTREAT.getValue());
		/*组装查询页面状态的条件*/
		this.getCriteriaForTransfertreat(form, criteria);
		criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
		
		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);
		model.addAttribute("transfertreats", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.transfertreat.list";
    }
    
	@RequestMapping("/trace/search")
    public String traceSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.trace.search";
    }
	
    /**
     * 进入追踪单列表
     * @param form
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/trace/list")
    public String searchTraceList(TbQueryForm form, String specialStatus, String pageIndex, ModelMap model, HttpServletRequest request) {
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_TRANSFERTREAT.getValue()});
		criteria.add("IDM_TYPE", IdmType.TB.getValue());
		criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
		
		PageList<IdmStatusInfo> plist = tbService.findTraceList(page, criteria);
		model.addAttribute("traces", plist.getList());
		model.addAttribute("page", plist.getPage());
		model.addAttribute("nowDate", new Date());
        return "rhip.idm.trace.list";
    }
    
    /**
     * 添加一条追踪记录
     * @param idmId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/trace/add")
    public String saveTrace(Long idmId, ModelMap model, HttpServletRequest request) {
    	IdmStatusInfo statusInfo = tbService.getIdmStatusInfoByEventId(idmId);
    	if(ObjectUtil.isNotEmpty(statusInfo) && StringUtils.equals(statusInfo.getPlaceStatus(), "5")) {
    		return EHRMessageUtil.returnMsg(model, "placed");
    	}
    	boolean result = false;
		ListTr listTr = this.getListTr(idmId, "4", request);
		result = tbService.saveListTr(listTr);
		createOperationLog(request, RhipModuleName.IDM, "结核病专项-追踪记录", OperationName.ADD);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    /**
     * 查询追踪详情
     * @param idmId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/traceRecode/search")
    public String searchTraceRecord(Long idmId, ModelMap model, HttpServletRequest request) {
		model.addAttribute("generalCondition", tbService.findGeneralCondition(idmId));
		model.addAttribute("nowDate", new Date());
		model.addAttribute("idmId", idmId);
		return "rhip.idm.traceRecord.search";
    }
    
    /**
     * 查询追踪详情
     * @param idmId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/traceRecode/list")
    public String getTraceRecordList(Long idmId, ModelMap model, HttpServletRequest request) {
		Criteria criteria = new Criteria("idm_id", idmId);
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		
		PageList<ListTr> plist = tbService.findTraceRecordList(page, criteria);
		
		model.addAttribute("traceRecodes", plist.getList());
		model.addAttribute("page", plist.getPage());
		model.addAttribute("nowDate", new Date());
        return "rhip.idm.traceRecord.list";
    }
    

    /**
     * 转诊打印
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/print")
    public String initPirnt(String singleId, String pageIndex, ModelMap model, HttpServletRequest request) {
    	TbSaveDto tbSaveDto = new TbSaveDto();
    	if(StringUtil.isNotEmpty(singleId)) {
    		tbSaveDto = tbService.getTbSaveDto(singleId);
    	}
    	
        model.addAttribute("tbSaveDto", tbSaveDto);
        model.put("pageIndex", pageIndex);
        return "rhip.idm.transfertreat.print";
    }
    
    /*获取唯一事件编码*/
    private void getEventId(TbQueryForm form, Criteria criteria, String eventIdF, String eventIdS) {
		String arrays[] = {eventIdF, eventIdS};
		criteria.add("EVENT_ID", OP.IN, arrays);
    }
    
    /*获取转诊后未到诊的人数*/
    private int getNotSeeDoctorCount(HttpServletRequest request) {
    	Criteria criteria = new Criteria();
    	//指定查的是结核病
    	criteria.add("IDM_TYPE", IdmType.TB.getValue());
    	criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_TRANSFERTREAT.getValue()});
    	criteria.add(new Criteria("place_status","4").add(LOP.OR, new Criteria("place_status", OP.IS,"NULL")));
    	criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
		return tbService.getNotSeeDoctorCount(criteria);
    }
    
    private ListTr getListTr(Long idmId, String transferStatus, HttpServletRequest request) {
    	Organization org = getCurrentOrg(request);
    	String userId = getCurrentUser(request).getUserCode();
    	ListTr listTr = new ListTr();
    	listTr.setCreateDt(new Date());
    	listTr.setCreateUnit(org.getOrganCode());
    	listTr.setCreateUser(userId);
    	listTr.setFlag(IdmType.TB.getValue());
    	listTr.setIdmId(idmId);
    	listTr.setTransferStatus(transferStatus);
    	return listTr;
    }
    
    /**
     * 筛查登记的状态 未登记 状态为推荐   若已登记则不等于推荐状态 可也不一定要等于登记状态
     * @param form
     * @param criteria
     */
    private void getCriteriaForRegister(TbQueryForm form, Criteria criteria) {
    	Integer specialStatus = form.getSpecialStatus();
    	if (ObjectUtil.isNotEmpty(specialStatus)){
    		if(ObjectUtil.equals(specialStatus, TbStatus.RECOMMENDATION.getValue())) {
    			criteria.add("status.SPECIAL_STATUS", specialStatus);
    		} else if(ObjectUtil.equals(specialStatus, TbStatus.REGISTER.getValue())){
    			criteria.add("status.SPECIAL_STATUS", OP.NE, TbStatus.RECOMMENDATION.getValue());
    		}
    	}
    }
    
    /**
     * 转诊的状态 未转诊 状态为筛查登记  若已转诊则不等于筛查登记 可也不一定要等于筛查登记
     * @param form
     * @param criteria
     */
    private void getCriteriaForTransfertreat(TbQueryForm form, Criteria criteria) {
    	Integer specialStatus = form.getSpecialStatus();
    	if (ObjectUtil.isNotEmpty(specialStatus)){
    		if(ObjectUtil.equals(specialStatus, TbStatus.RECOMMENDATION.getValue())){
    			criteria.add("status.SPECIAL_STATUS", specialStatus);
    		} else if(ObjectUtil.equals(specialStatus, TbStatus.REGISTER.getValue())){
    			criteria.add("status.SPECIAL_STATUS", OP.NE, TbStatus.TRANSFERTREAT.getValue());
    		}
		}
    }
}
