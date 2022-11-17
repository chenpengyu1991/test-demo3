package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmEmergency;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.service.IMhmManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/mhm/management/emergency")
public class EmergencyController extends MhmBaseController {

	@Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
	private final static String CONTROLLER_NAME = "精神卫生-应急处置";		
	/**
	 * 进入应急处置主画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String emergencyMain(String statusId, HttpServletRequest request,ModelMap model) {
		model.addAttribute("statusId", statusId);
		return "rhip.mhm.management.emergency.main";
	}
	
	/**
	 * 查询应急处置列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String emergencyList(String statusId,  HttpServletRequest request,ModelMap model) {
		Criteria ca = new Criteria("event_type", MhmEvents.M_EMERGENCY.getValue());
        ca.add("statusId", statusId);
        PageList<MhmEmergency> plist = mhmManagementService.getMhmEmergencyList(ca, buildPage(request));
        model.addAttribute("statusId", statusId);
        model.addAttribute("plist", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "rhip.mhm.management.emergency.list";
	}
	
	/**
	 * 进入应急处置新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editEmergency(Long statusId, String id, HttpServletRequest request, ModelMap model) {

        MhmEmergency mhmEmergency = new MhmEmergency();
		if(StringUtil.isNotEmpty(id)) {//编辑页面
			mhmEmergency = mhmManagementService.getEmergency(new Criteria("id", id));
		}else{ //初始页面
            ManagementDto mhmDto = mhmManagementService.getMhmManagement(statusId, MhmEvents.M_ARCHIVES);
            mhmEmergency.setName(mhmDto.getMhmBasicsInfo().getName());
            mhmEmergency.setGender(mhmDto.getMhmBasicsInfo().getGender());
            mhmEmergency.setAge(mhmDto.getMhmBasicsInfo().getAge());
        }
		model.addAttribute("nowDate", new Date());
		model.addAttribute("statusId", statusId);
		model.addAttribute("mhmEmergency", mhmEmergency);
		return "rhip.mhm.management.emergency.edit";
	}
	
	/**
	 * 保存应急处置
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveEmergency(ManagementDto managementDto, HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		managementDto.setCurrentUser(getCurrentUser(request));
        result = mhmManagementService.saveMhmManagement(managementDto, MhmEvents.M_EMERGENCY, MhmStatus.MANAGEMENT.getValue());
        OperationName  opName = ObjectUtil.isNullOrEmpty(managementDto.getMhmEmergency().getId())?OperationName.ADD:OperationName.UPDATE;
    	record(request, opName);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除应急处置
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String deleteEmergency(Long eventId, HttpServletRequest request,ModelMap model) throws Exception{
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
