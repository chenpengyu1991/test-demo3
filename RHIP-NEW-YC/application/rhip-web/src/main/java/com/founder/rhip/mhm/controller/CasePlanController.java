package com.founder.rhip.mhm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmCase;
import com.founder.rhip.ehr.entity.management.mhm.MhmCaseDetail;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.service.IMhmManagementService;

@Controller
@RequestMapping(value = "/mhm/management/caseplan")
public class CasePlanController extends MhmBaseController {

	@Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
	private final static String CONTROLLER_NAME = "精神卫生-规范化管理-个案管理计划";	
	/**
	 * 进入个案管理计划主画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String casePlanMain(String statusId, String bringIntoMode, HttpServletRequest request,ModelMap model) {
		model.addAttribute("statusId", statusId);
        model.addAttribute("bringIntoMode", bringIntoMode);
        return "rhip.mhm.management.caseplan.main";
	}
	
	/**
	 * 查询个案管理计划列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String casePlanList(String statusId, String pageIndex, HttpServletRequest request,ModelMap model) {
		Criteria ca = new Criteria("event_type", MhmEvents.M_CASE_PLAN.getValue());
        ca.add("statusId", statusId);
        PageList<MhmCase> plist = mhmManagementService.getCasePlanList(ca, buildPage(request));
        model.addAttribute("statusId", statusId);
        model.addAttribute("plist", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "rhip.mhm.management.caseplan.list";
	}
	
	/**
	 * 进入个案管理计划新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editCasePlan(HttpServletRequest request, Long statusId, String id, ModelMap model) {
		MhmCase mhmCase = new MhmCase();
		if(StringUtil.isNotEmpty(id)) {//编辑页面
			mhmCase = mhmManagementService.getCasePlan(new Criteria("id", id));
		}
		ManagementDto dto = mhmManagementService.getMhmManagement(statusId,MhmEvents.M_ARCHIVES);
		if(ObjectUtil.isNotEmpty(dto)){
			model.addAttribute("patientName", dto.getMhmBasicsInfo().getName());
		}
		model.addAttribute("statusId", statusId);
		model.addAttribute("mhmCase", mhmCase);
		return "rhip.mhm.management.caseplan.edit";
	}
	
	/**
	 * 保存个案管理计划
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	public String saveCasePlan(ManagementDto managementDto, HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		String caseDetailJson = managementDto.getMhmCase().getCaseDetailJson();
        if (StringUtil.isNotEmpty(caseDetailJson)) {
            List<MhmCaseDetail> caseDetails = (List<MhmCaseDetail>) json2Obj(caseDetailJson, MhmCaseDetail.class);
            managementDto.getMhmCase().setCaseDetails(caseDetails);
        }
        managementDto.setCurrentUser(getCurrentUser(request));
        /*获取PERSON_ID modify by yjf 20140107*/
    	Long personId = mhmManagementService.getPersonId(managementDto.getStatusId());
    	managementDto.setPersonId(personId);	            
        updatePersonInfo(managementDto.getPersonInfo(),request);        
        result = mhmManagementService.saveMhmManagement(managementDto, MhmEvents.M_CASE_PLAN, MhmStatus.MANAGEMENT.getValue());
        OperationName  opName = ObjectUtil.isNullOrEmpty(managementDto.getMhmCase().getId())?OperationName.ADD:OperationName.UPDATE;
    	record(request, opName);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除个案管理计划
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String deleteCasePlan(Long eventId, HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		result = mhmManagementService.deleteMul(eventId);

    	record(request, OperationName.DELETE);		
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	
	/**
	 * 进入个案管理明细计划单  子画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/popDetail")
    public String popDetail(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            @SuppressWarnings("unchecked")
			List<MhmCaseDetail> caseDetail = (List<MhmCaseDetail>) json2Obj(trData, MhmCaseDetail.class);
            model.put("caseDetail", caseDetail.get(0));
        }
		model.put("rowIndex", rowIndex);
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.mhm.management.caseplan.detail";
    }	
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}	
}
