package com.founder.rhip.mhm.controller;

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
import com.founder.rhip.ehr.entity.management.mhm.MhmAssess;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.service.IMhmManagementService;

@Controller
@RequestMapping(value = "/mhm/management/evaluation")
public class EvaluationController extends MhmBaseController {

	@Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
	private final static String CONTROLLER_NAME = "精神卫生-效果评估";		
	/**
	 * 进入效果评估主画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String evaluationMain(String statusId, String bringIntoMode, HttpServletRequest request,ModelMap model) {
		model.addAttribute("statusId", statusId);
        model.addAttribute("bringIntoMode", bringIntoMode);
        return "rhip.mhm.management.evaluation.main";
	}
	
	/**
	 * 查询效果评估列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String evaluationList(String statusId,  HttpServletRequest request,ModelMap model) {
		Criteria ca = new Criteria("event_type", MhmEvents.M_EVALUATION.getValue());
        ca.add("statusId", statusId);
        PageList<MhmAssess> plist = mhmManagementService.getAssessList(ca, buildPage(request));
        model.addAttribute("statusId", statusId);
        model.addAttribute("plist", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "rhip.mhm.management.evaluation.list";
	}
	
	/**
	 * 进入效果评估新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editEvaluation(Long statusId, String id, HttpServletRequest request, ModelMap model) {
		MhmAssess mhmAssess = new MhmAssess();
		if(StringUtil.isNotEmpty(id)) {//编辑页面
			mhmAssess = mhmManagementService.getEvaluation(new Criteria("id", id));
		}
		model.addAttribute("statusId", statusId);
		model.addAttribute("mhmAssess", mhmAssess);
		return "rhip.mhm.management.evaluation.edit";
	}
	
	/**
	 * 保存效果评估
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveEvaluation(ManagementDto managementDto, HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		managementDto.setCurrentUser(getCurrentUser(request));
        /*获取PERSON_ID modify by yjf 20140107*/
    	Long personId = mhmManagementService.getPersonId(managementDto.getStatusId());
    	managementDto.setPersonId(personId);	            
        updatePersonInfo(managementDto.getPersonInfo(),request);  		
        result = mhmManagementService.saveMhmManagement(managementDto, MhmEvents.M_EVALUATION, MhmStatus.MANAGEMENT.getValue());
        OperationName  opName = ObjectUtil.isNullOrEmpty(managementDto.getMhmAssess().getId())?OperationName.ADD:OperationName.UPDATE;
    	record(request, opName);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除效果评估
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String deleteEvaluation(Long eventId, HttpServletRequest request, ModelMap model) throws Exception{
		boolean result = true;
		result = mhmManagementService.deleteMul(eventId);
		record(request, OperationName.DELETE);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}	
}
