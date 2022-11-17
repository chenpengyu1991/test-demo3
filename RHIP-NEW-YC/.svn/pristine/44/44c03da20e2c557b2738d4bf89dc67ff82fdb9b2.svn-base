package com.founder.rhip.mhm.controller;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;
import com.founder.rhip.mdm.entity.Organization;
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
@RequestMapping(value = "/mhm/lostfollowup")
public class LostFollowUpController extends MhmBaseController {

	@Resource(name = "mhmManagementService")
	private IMhmManagementService mhmManagementService;
	
	private final static String CONTROLLER_NAME = "精神卫生-规范化管理-失访信息";
	/**
	 * 进入失访信息新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editLostFollowUp(HttpServletRequest request,Long statusId,ModelMap model) {
		ManagementDto mhmDto = mhmManagementService.getMhmManagement(statusId, MhmEvents.M_LOST_FOLLOWUP);
		/*根据当前用户，设置页面中的调查者、调查日期*/
		MhmFollowup mhmFollowup = mhmDto.getMhmFollowup();
		Organization org = getCurrentOrg(request);
		Long userId = getCurrentUser(request).getId();
       	mhmFollowup.setFillOrganCode(org.getOrganCode());//填写单位
	    mhmFollowup.setFillDoctorId(userId.toString());//填写医生
	    mhmFollowup.setFillDate(new Date());//填写日期
       	if (!hasRole(RoleType.ZJSB, request)){
       		mhmFollowup.setFollowupStatus("1");	//默认审核通过	
       	}	    
		mhmDto.setMhmFollowup(mhmFollowup);	
        model.put("managementDto", mhmDto);		
		return "rhip.mhm.management.lostfollowup.edit";
	}
	
	/**
	 * 保存失访信息
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveLostFollowUp(ManagementDto mhmDto,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		mhmDto.setEventType(MhmEvents.M_LOST_FOLLOWUP.getValue());
		/*根据当前用户，设置页面中的调查者、调查日期*/
		Organization org = getCurrentOrg(request);
		mhmDto.setCurrentOrg(org);
		mhmDto.setCurrentUser(getCurrentUser(request));
       /*获取PERSON_ID modify by yjf 20140107*/
    	Long personId = mhmManagementService.getPersonId(mhmDto.getStatusId());
    	mhmDto.setPersonId(personId);		
		updatePersonInfo(mhmDto.getPersonInfo(),request);
        /*如果患者死亡，则更新状态表*/
        Integer status = -1;
        if(mhmDto.getMhmFollowup().getLoseReason().equals("1")){
            status = MhmStatus.DEAD.getValue();
        }
    	result = mhmManagementService.saveMhmManagement(mhmDto, MhmEvents.M_LOST_FOLLOWUP, status);
    	/*记录日志*/
    	Long followupId = mhmDto.getMhmFollowup().getId();
    	OperationName  opName = ObjectUtil.isNullOrEmpty(followupId)?OperationName.ADD:OperationName.UPDATE;
    	record(request, opName);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}	
}
