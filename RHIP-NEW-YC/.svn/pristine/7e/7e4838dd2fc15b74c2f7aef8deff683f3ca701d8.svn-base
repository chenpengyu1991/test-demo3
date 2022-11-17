package com.founder.rhip.oh.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.control.oh.OhCautionAlarm;
import com.founder.rhip.ehr.entity.control.oh.OhDoseDetection;
import com.founder.rhip.ehr.entity.control.oh.OhHospitalInfo;
import com.founder.rhip.ehr.entity.control.oh.OhMachineRoom;
import com.founder.rhip.ehr.entity.control.oh.OhPersonalDose;
import com.founder.rhip.ehr.entity.control.oh.OhProtectiveEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalApparatus;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalPostion;
import com.founder.rhip.ehr.entity.control.oh.OhTraining;
import com.founder.rhip.ehr.entity.control.oh.OhWorkload;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.oh.controller.form.HospitalInfoForm;
import com.founder.rhip.ph.service.oh.IRadiologicalProtectionReportService;
@Controller
@RequestMapping("/oh/radiologicalProtectionReport")
public class RadiologicalProtectionReportController extends BaseController {

	@Resource(name = "radiologicalProtectionReportService")
	private IRadiologicalProtectionReportService radiologicalProtectionReportService;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	//医院基本情况===================================================================
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		return "rhip.oh.radiologicalProtectionReport.search";
	}
	
	@RequestMapping("/hospitalInfoRecords")
	public String getHospitalInfoRecords(HttpServletRequest request,HospitalInfoForm hospitalInfoForm,Integer indexPage){
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNotEmpty(hospitalInfoForm)){
			criteria = initSearchCondition(criteria,hospitalInfoForm);
		}else{ 
			criteria = null;
		}
        if(hasRole(RoleType.ZX_GLY, request)){
            criteria.add("CREATE_ORGAN_CODE",getCurrentOrg(request).getOrganCode());
        }
		PageList<OhHospitalInfo> ohHospitalInfoList = radiologicalProtectionReportService.searchOhHospitalInfoList(page, criteria);
		request.setAttribute("page", ohHospitalInfoList.getPage());
		request.setAttribute("infoRecords", ohHospitalInfoList.getList());
		return "rhip.oh.radiologicalProtectionReport.hospitalInfoRecords";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,String id,String operationType){
		request.setAttribute("id", id);
		request.setAttribute("operationType", operationType);
		return "rhip.oh.radiologicalProtectionReport.edit";
	}
	
	@RequestMapping("/hospitalInfo/edit")
	public String addHospitalInfo(HttpServletRequest request){
		return "rhip.oh.radiologicalProtectionReport.hospitalInfo.edit";
	}
	
	//获取单个医院基本情况
	@RequestMapping("/hospitalInfo")
	public String getHospitalInfo(HttpServletRequest request,String id,String operationType){
		request.setAttribute("record", radiologicalProtectionReportService.searchOhHospitalInfo(new Criteria("ID",id)));
		request.setAttribute("operationType", operationType);
		return "rhip.oh.radiologicalProtectionReport.yyjbqk";
	}
	//根据operationType更新或插入医院基本情况
	@RequestMapping("/hospitalInfo/save")
    public String saveHospitalInfo(HttpServletRequest request,ModelMap model,OhHospitalInfo ohHospitalInfo,String operationType){
		int i = 0;
		verifyStateSet(ohHospitalInfo, request);
		if(StringUtil.isNotEmpty(operationType)&&operationType.trim().equals("2")){//更新
			OhHospitalInfo temp = radiologicalProtectionReportService.searchOhHospitalInfo(new Criteria("id",ohHospitalInfo.getId()));
			ohHospitalInfo.setCreateOrganCode(temp.getCreateOrganCode());
			ohHospitalInfo.setCreateBy(temp.getCreateBy());
			ohHospitalInfo.setCreateTime(ohHospitalInfo.getCreateTime());
			ohHospitalInfo.setVerifier(this.getCurrentUser(request).getName());
			ohHospitalInfo.setVerifyDate(new Date());
			ohHospitalInfo.setUpdateTime(new Date());
            ohHospitalInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
			ohHospitalInfo.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhHospitalInfo(ohHospitalInfo);
			this.createOperationLog(request, RhipModuleName.OH, "医院基本情况", OperationName.UPDATE);
		}else{//新增
			ohHospitalInfo.setIsDelete(0);
			ohHospitalInfo.setCreateTime(new Date());
			ohHospitalInfo.setVerifyState("3");
			ohHospitalInfo.setCreateBy(this.getCurrentUser(request).getName());
            ohHospitalInfo.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
            ohHospitalInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
			ohHospitalInfo.setUpdateTime(new Date());
			ohHospitalInfo.setUpdateBy(this.getCurrentUser(request).getName());
			List<Role> roles = this.getCurrentUserRole(request);
			for(Role role:roles){
				if(role.getRoleCode().equals(OHConstants.ROLE_23)){
					ohHospitalInfo.setVerifyState("1");
					break;
				}
			}
			i = radiologicalProtectionReportService.addOhHospitalInfo(ohHospitalInfo);
			this.createOperationLog(request, RhipModuleName.OH, "医院基本情况", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	
	private void verifyStateSet(OhHospitalInfo hospitalInfo,HttpServletRequest request){
		Date now = new Date();
		if(hospitalInfo==null){
			hospitalInfo=new OhHospitalInfo();
			hospitalInfo.setUpdateBy(getCurrentUser(request).getUserName());
			hospitalInfo.setUpdateTime(now);
		}
		List<Role> roleList = this.getCurrentUserRole(request);
		for(Role role:roleList){
			//职业卫生科默认审核通过
			if(OHConstants.ROLE_23.equals(role.getRoleCode()))
			{
				hospitalInfo.setVerifyState(OHConstants.VERIFY_STATE_1);
				hospitalInfo.setVerifier(getCurrentUser(request).getName());
				hospitalInfo.setVerifyDate(now);
			}else{
				hospitalInfo.setVerifyState(OHConstants.VERIFY_STATE_3);
			}
		}
	}
	
	//逻辑删除医院基本情况
	@RequestMapping("/hospitalInfo/delete")
	public String deleteHospitalInfo(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhHospitalInfo("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "医院基本情况", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//审核医院基本情况
	@RequestMapping("/hospitalInfo/check")
	public String checkHospitalInfo(HttpServletRequest request,ModelMap model,String id,String verifyState){
		int i = radiologicalProtectionReportService.checkOhHospitalInfo(this.getCurrentUser(request).getName(),verifyState, new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "医院基本情况", OperationName.CHECK);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	private Criteria initSearchCondition(Criteria criteria,HospitalInfoForm hospitalInfoForm){
		if(ObjectUtil.isNotEmpty(hospitalInfoForm.getCheckCondition()))
			criteria.add("VERIFY_STATE",hospitalInfoForm.getCheckCondition());
		DateUtil.getCriteriaByDateRange(criteria,"UPDATE_TIME",hospitalInfoForm.getStartDate(),hospitalInfoForm.getEndDate());
		if(ObjectUtil.isNotEmpty(hospitalInfoForm.getHospitalLevel()))
			criteria.add("H_LEVEL",hospitalInfoForm.getHospitalLevel());
		if(ObjectUtil.isNotEmpty(hospitalInfoForm.getHospitalName()))
			criteria.add("HOSPITAL_NAME",OP.LIKE,hospitalInfoForm.getHospitalName());
		if(ObjectUtil.isNotEmpty(hospitalInfoForm.getProfileNo()))
			criteria.add("FILE_NO", hospitalInfoForm.getProfileNo());
		return criteria;
	}
	//医院放射设备情况===============================================================
	@RequestMapping("/radiologicalApparatus")
	public String getRadiologicalApparatusList(HttpServletRequest request,String hospitalId,Integer indexPage){
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		criteria.add("HOSPITAL_ID", hospitalId);
		
		PageList<OhRadiologicalApparatus> ohRadiologicalApparatusList= radiologicalProtectionReportService.searchOhRadiologicalApparatusList(page, criteria);
		request.setAttribute("page", ohRadiologicalApparatusList.getPage());
		request.setAttribute("infoRecords", ohRadiologicalApparatusList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.yyfssbqk";
	}
	@RequestMapping("/radiologicalApparatus/edit")
	public String radiologicalApparatusEdit(HttpServletRequest request,String ohRadiologicalApparatusId,String ohRadiologicalApparatusOperationType){
		if(!ObjectUtil.isNotEmpty(ohRadiologicalApparatusId))
			return "rhip.oh.radiologicalProtectionReport.yyfssbqk.edit";
		request.setAttribute("record", radiologicalProtectionReportService.searchOhRadiologicalApparatus(new Criteria("ID",ohRadiologicalApparatusId)));
		request.setAttribute("ohRadiologicalApparatusOperationType", ohRadiologicalApparatusOperationType);
		return "rhip.oh.radiologicalProtectionReport.yyfssbqk.edit";
	}
	@RequestMapping("/radiologicalApparatus/save")
	public String saveRadiologicalApparatus(HttpServletRequest request,ModelMap model,OhRadiologicalApparatus ohRadiologicalApparatus,String ohRadiologicalApparatusOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohRadiologicalApparatusOperationType)&&ohRadiologicalApparatusOperationType.trim().equals("2")){//更新
			ohRadiologicalApparatus.setUpdateTime(new Date());
			ohRadiologicalApparatus.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhRadiologicalApparatus(ohRadiologicalApparatus);
			this.createOperationLog(request, RhipModuleName.OH, "医院放射设备情况", OperationName.UPDATE);
		}else{//新增
			ohRadiologicalApparatus.setIsDelete(0);
			ohRadiologicalApparatus.setCreateTime(new Date());
			ohRadiologicalApparatus.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhRadiologicalApparatus(ohRadiologicalApparatus);
			this.createOperationLog(request, RhipModuleName.OH, "医院放射设备情况", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/radiologicalApparatus/delete")
	public String deleteRadiologicalApparatus(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhRadiologicalApparatus("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "医院放射设备情况", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//放射防护情况===============================================================
	@RequestMapping("/radiologicalProtection")
	public String radiologicalProtectionIndex(HttpServletRequest request,String hospitalId){
		request.setAttribute("totleArea", radiologicalProtectionReportService.getSumArea(new Criteria("HOSPITAL_ID",hospitalId)));
		request.setAttribute("machineHouseArea", radiologicalProtectionReportService.getMachineRoomArea(new Criteria("HOSPITAL_ID",hospitalId)));
		request.setAttribute("otherArea", radiologicalProtectionReportService.getOtherArea(new Criteria("HOSPITAL_ID",hospitalId)));
		request.setAttribute("record", radiologicalProtectionReportService.searchOhRadiologicalPostion(new Criteria("HOSPITAL_ID",hospitalId)));
		request.getSession().removeAttribute(OHConstants.RADIOLOGICAL_SITE_SESSION_KEY);
		request.getSession().removeAttribute(OHConstants.RADIOLOGICAL_LAYOUT_SESSION_KEY);
		return "rhip.oh.radiologicalProtectionReport.fsfhqk.index";
	}
	@RequestMapping("/radiologicalProtection/radiologicalPostion/edit")
	public String radiologicalPostionEdit(HttpServletRequest request,String id){
		if(StringUtil.isNotEmpty(id))
		    request.setAttribute("record", radiologicalProtectionReportService.searchOhRadiologicalPostion(new Criteria("ID",id)));
		return "rhip.oh.radiologicalProtectionReport.fsfhqk.fskwzbzqk";
	}
	//放射科位置布置情况
	@SuppressWarnings("unchecked")
	@RequestMapping("/radiologicalProtection/radiologicalPostion/save")
	public String saveRadiologicalPostion(HttpServletRequest request,ModelMap model,OhRadiologicalPostion ohRadiologicalPostion){
		int i = 0;
		 
		Map<String, String> ohfskwztFileMap = (Map<String, String>) request.getSession().getAttribute(OHConstants.RADIOLOGICAL_SITE_SESSION_KEY); // 附件
		// 放射科位置图图片存放路径
		if (ObjectUtil.isNotEmpty(ohfskwztFileMap)) {
			if(ohfskwztFileMap.size()>1)
			{
				return EHRMessageUtil.returnMsg(model, "-2");
			}
			for(String urlKey:ohfskwztFileMap.keySet())
			{
				ohRadiologicalPostion.setLocaltionUrl(ohfskwztFileMap.get(urlKey));
			}
			ohfskwztFileMap.clear();
		}
		
		Map<String, String> ohfskbztFileMap = (Map<String, String>) request.getSession().getAttribute(OHConstants.RADIOLOGICAL_LAYOUT_SESSION_KEY); // 附件
		// 放射科布置图图片存放路径
		if (ObjectUtil.isNotEmpty(ohfskbztFileMap)) {
			if(ohfskbztFileMap.size()>1)
			{
				return EHRMessageUtil.returnMsg(model, "-2");
			}
			for(String urlKey:ohfskbztFileMap.keySet())
			{
				ohRadiologicalPostion.setLayoutUrl(ohfskbztFileMap.get(urlKey));
			}
		    ohfskbztFileMap.clear();
		}
		
		if(ObjectUtil.isNotEmpty(ohRadiologicalPostion.getId())&&ohRadiologicalPostion.getId()!=0){//更新
			ohRadiologicalPostion.setUpdateTime(new Date());
			ohRadiologicalPostion.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhRadiologicalPostion(ohRadiologicalPostion);
			this.createOperationLog(request, RhipModuleName.OH, "放射科位置布置情况", OperationName.UPDATE);
		}else{//新增
			ohRadiologicalPostion.setIsDelete(0);
			ohRadiologicalPostion.setCreateTime(new Date());
			ohRadiologicalPostion.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhRadiologicalPostion(ohRadiologicalPostion);
			this.createOperationLog(request, RhipModuleName.OH, "放射科位置布置情况", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");

	}
	@RequestMapping("/radiologicalProtection/machineRoom")
	public String getMachineRoomList(HttpServletRequest request,String hospitalId,Integer indexPage){
		
		PageList<OhMachineRoom> ohMachineRoomPageList= radiologicalProtectionReportService.searchOhMachineRoomList(super.getPage(request, indexPage), new Criteria("HOSPITAL_ID",hospitalId));
		request.setAttribute("page", ohMachineRoomPageList.getPage());
		request.setAttribute("infoRecords", ohMachineRoomPageList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.fsfhqk.machineRoom";
	}
	@RequestMapping("/radiologicalProtection/cautionAlarm")
	public String getCautionAlarmList(HttpServletRequest request,String hospitalId,Integer indexPage){
		PageList<OhCautionAlarm> ohCautionAlarmPageList= radiologicalProtectionReportService.searchOhCautionAlarmList(super.getPage(request, indexPage), new Criteria("HOSPITAL_ID",hospitalId));
		request.setAttribute("page", ohCautionAlarmPageList.getPage());
		request.setAttribute("infoRecords", ohCautionAlarmPageList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.fsfhqk.cautionAlarm";
	}
	//放射科情况
	@RequestMapping("/radiologicalProtection/machineRoom/edit")
	public String machineRoomEdit(HttpServletRequest request,String ohMachineRoomId,String ohMachineRoomOperationType){
		if(!ObjectUtil.isNotEmpty(ohMachineRoomId)){
			OhMachineRoom ohMachineRoom = new OhMachineRoom();
			ohMachineRoom.setType("1");
			request.setAttribute("record", ohMachineRoom);
			return "rhip.oh.radiologicalProtectionReport.fsfhqk.machineRoom.edit";
		}
		request.setAttribute("record", radiologicalProtectionReportService.searchOhMachineRoom(new Criteria("ID",ohMachineRoomId)));
		request.setAttribute("ohMachineRoomOperationType", ohMachineRoomOperationType);
		return "rhip.oh.radiologicalProtectionReport.fsfhqk.machineRoom.edit";
	}
	@RequestMapping("/radiologicalProtection/machineRoom/save")
	public String saveMachineRoom(HttpServletRequest request,OhMachineRoom ohMachineRoom,ModelMap model,String ohMachineRoomOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohMachineRoomOperationType)&&ohMachineRoomOperationType.trim().equals("2")){//更新
			ohMachineRoom.setUpdateTime(new Date());
			ohMachineRoom.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhMachineRoom(ohMachineRoom);
			this.createOperationLog(request, RhipModuleName.OH, "放射科情况", OperationName.UPDATE);
		}else{//新增
			ohMachineRoom.setIsDelete(0);
			ohMachineRoom.setCreateTime(new Date());
			ohMachineRoom.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhMachineRoom(ohMachineRoom);
			this.createOperationLog(request, RhipModuleName.OH, "放射科情况", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/radiologicalProtection/machineRoom/delete")
	public String deleteMachineRoom(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhMachineRoom("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "放射科情况", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//其他防护措施
	@RequestMapping("/radiologicalProtection/cautionAlarm/edit")
	public String cautionAlarmEdit(HttpServletRequest request,String ohCautionAlarmId,String ohCautionAlarmOperationType){
		if(!ObjectUtil.isNotEmpty(ohCautionAlarmId)){
			OhCautionAlarm ohCautionAlarm = new OhCautionAlarm();
			ohCautionAlarm.setType("1");
			request.setAttribute("record", ohCautionAlarm);
			return "rhip.oh.radiologicalProtectionReport.fsfhqk.cautionAlarm.edit";
		}
		request.setAttribute("record", radiologicalProtectionReportService.searchOhCautionAlarm(new Criteria("ID",ohCautionAlarmId)));
		request.setAttribute("ohCautionAlarmOperationType", ohCautionAlarmOperationType);
		return "rhip.oh.radiologicalProtectionReport.fsfhqk.cautionAlarm.edit";
	}
	@RequestMapping("/radiologicalProtection/cautionAlarm/save")
	public String saveCautionAlarm(HttpServletRequest request,OhCautionAlarm ohCautionAlarm,ModelMap model,String ohCautionAlarmOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohCautionAlarmOperationType)&&ohCautionAlarmOperationType.trim().equals("2")){//更新
			ohCautionAlarm.setUpdateTime(new Date());
			ohCautionAlarm.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhCautionAlarm(ohCautionAlarm);
			this.createOperationLog(request, RhipModuleName.OH, "其他防护措施", OperationName.UPDATE);
		}else{//新增
			ohCautionAlarm.setIsDelete(0);
			ohCautionAlarm.setCreateTime(new Date());
			ohCautionAlarm.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhCautionAlarm(ohCautionAlarm);
			this.createOperationLog(request, RhipModuleName.OH, "其他防护措施", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/radiologicalProtection/cautionAlarm/delete")
	public String deleteCautionAlarm(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhCautionAlarm("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "其他防护措施", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//个人防护用品
	@RequestMapping("/protectiveEquipment")
	public String protectiveEquipmentIndex(HttpServletRequest request,String hospitalId,Integer indexPage){
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		criteria.add("HOSPITAL_ID", hospitalId);
		
		PageList<OhProtectiveEquipment> ohProtectiveEquipmentList = radiologicalProtectionReportService.searchOhProtectiveEquipmentList(page, criteria);
		request.setAttribute("page", ohProtectiveEquipmentList.getPage());
		request.setAttribute("infoRecords", ohProtectiveEquipmentList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.grfhyp";
	}
	@RequestMapping("/protectiveEquipment/edit")
	public String protectiveEquipmentEdit(HttpServletRequest request,String ohProtectiveEquipmentId,String ohProtectiveEquipmentOperationType){
		if(!ObjectUtil.isNotEmpty(ohProtectiveEquipmentId))
			return "rhip.oh.radiologicalProtectionReport.grfhyp.edit";
		request.setAttribute("record", radiologicalProtectionReportService.searchOhProtectiveEquipment(new Criteria("ID",ohProtectiveEquipmentId)));
		request.setAttribute("ohProtectiveEquipmentOperationType", ohProtectiveEquipmentOperationType);
		
		return "rhip.oh.radiologicalProtectionReport.grfhyp.edit"; 
	}
	@RequestMapping("/protectiveEquipment/save")
	public String saveProtectiveEquipment(HttpServletRequest request,OhProtectiveEquipment ohProtectiveEquipment,ModelMap model,String ohProtectiveEquipmentOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohProtectiveEquipmentOperationType)&&ohProtectiveEquipmentOperationType.trim().equals("2")){//更新
			ohProtectiveEquipment.setUpdateTime(new Date());
			ohProtectiveEquipment.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhProtectiveEquipment(ohProtectiveEquipment);
			this.createOperationLog(request, RhipModuleName.OH, "个人防护用品", OperationName.UPDATE);
		}else{//新增
			ohProtectiveEquipment.setIsDelete(0);
			ohProtectiveEquipment.setCreateTime(new Date());
			ohProtectiveEquipment.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhProtectiveEquipment(ohProtectiveEquipment);
			this.createOperationLog(request, RhipModuleName.OH, "个人防护用品", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/protectiveEquipment/delete")
	public String deleteProtectiveEquipment(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhProtectiveEquipment("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "个人防护用品", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//个人剂量档案=======================================================================
	@RequestMapping("/personalDose")
	public String personalDoseIndex(HttpServletRequest request,String hospitalId,Integer indexPage){
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		criteria.add("HOSPITAL_ID", hospitalId);
		
		PageList<OhPersonalDose> ohPersonalDoseList = radiologicalProtectionReportService.searchOhPersonalDoseList(page, criteria);
		request.setAttribute("page", ohPersonalDoseList.getPage());
		request.setAttribute("infoRecords", ohPersonalDoseList.getList());
		return "rhip.oh.radiologicalProtectionReport.grjlda";
	}
	@RequestMapping("/personalDose/edit")
	public String personalDoseEdit(HttpServletRequest request,String ohPersonalDoseId,String ohPersonalDoseOperationType){
		if(!ObjectUtil.isNotEmpty(ohPersonalDoseId)){
			return "rhip.oh.radiologicalProtectionReport.grjlda.edit";
		}
		request.setAttribute("record", radiologicalProtectionReportService.searchOhPersonalDose(new Criteria("ID",ohPersonalDoseId)));
		request.setAttribute("ohPersonalDoseOperationType", ohPersonalDoseOperationType);
		return "rhip.oh.radiologicalProtectionReport.grjlda.edit";
	}
	@RequestMapping("/personalDose/save")
	public String savePersonalDose(HttpServletRequest request,OhPersonalDose ohPersonalDose,ModelMap model,String ohPersonalDoseOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohPersonalDoseOperationType)&&ohPersonalDoseOperationType.trim().equals("2")){//更新
			ohPersonalDose.setUpdateTime(new Date());
			ohPersonalDose.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhPersonalDose(ohPersonalDose);
			this.createOperationLog(request, RhipModuleName.OH, "个人剂量档案", OperationName.UPDATE);
		}else{//新增
			ohPersonalDose.setIsDelete(0);
			ohPersonalDose.setCreateTime(new Date());
			ohPersonalDose.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhPersonalDose(ohPersonalDose);
			this.createOperationLog(request, RhipModuleName.OH, "个人剂量档案", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/personalDose/delete")
	public String deletePersonalDose(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhPersonalDose("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "个人剂量档案", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//放射工作人员个人剂量和健康监护档案==============================================
	@RequestMapping("/personalHealthRecord")
	public String personalHealthRecordIndex(HttpServletRequest request,String name,String doseId,String doseNo){
		request.setAttribute("name", name);
		request.setAttribute("doseId", doseId);
		request.setAttribute("doseNo", doseNo);
		return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda";
	}
	//个人计量检测结果
	@RequestMapping("/personalHealthRecord/doseDetection")
	public String getDoseDetectionList(HttpServletRequest request,String hospitalId,String doseId,Integer indexPage){
		PageList<OhDoseDetection> ohDoseDetectionPageList = radiologicalProtectionReportService.searchOhDoseDetectionList(super.getPage(request, indexPage), new Criteria("HOSPITAL_ID",hospitalId).add("DOSE_ID",doseId));
		request.setAttribute("page", ohDoseDetectionPageList.getPage());
		request.setAttribute("infoRecords", ohDoseDetectionPageList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda.grjljcjg";
	}
	@RequestMapping("/personalHealthRecord/doseDetection/edit")
	public String doseDetectionEdit(HttpServletRequest request,String ohDoseDetectionId,String ohDoseDetectionOperationType){
		if(!ObjectUtil.isNotEmpty(ohDoseDetectionId))
			return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda.grjljcjg.edit";
		request.setAttribute("record", radiologicalProtectionReportService.searchOhDoseDetection(new Criteria("ID",ohDoseDetectionId)));
		request.setAttribute("ohDoseDetectionOperationType", ohDoseDetectionOperationType);
		return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda.grjljcjg.edit";
	}
	@RequestMapping("/personalHealthRecord/doseDetection/save")
	public String saveDoseDetection(HttpServletRequest request,OhDoseDetection ohDoseDetection,ModelMap model,String ohDoseDetectionOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohDoseDetectionOperationType)&&ohDoseDetectionOperationType.trim().equals("2")){//更新
			ohDoseDetection.setUpdateTime(new Date());
			ohDoseDetection.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhDoseDetection(ohDoseDetection);
			this.createOperationLog(request, RhipModuleName.OH, "个人计量检测结果", OperationName.UPDATE);
		}else{//新增
			ohDoseDetection.setIsDelete(0);
			ohDoseDetection.setCreateTime(new Date());
			ohDoseDetection.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhDoseDetection(ohDoseDetection);
			this.createOperationLog(request, RhipModuleName.OH, "个人计量检测结果", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/personalHealthRecord/doseDetection/delete")
	public String deleteDoseDetection(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhDoseDetection("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "个人计量检测结果", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//放射工作人员年工作量
	@RequestMapping("/personalHealthRecord/workload")
	public String getWorkloadList(HttpServletRequest request,String hospitalId,String doseId,Integer indexPage){
		PageList<OhWorkload> ohWorkloadPageList = radiologicalProtectionReportService.searchOhWorkload(super.getPage(request, indexPage), new Criteria("HOSPITAL_ID",hospitalId).add("DOSE_ID", doseId));
		request.setAttribute("page", ohWorkloadPageList.getPage());
		request.setAttribute("infoRecords", ohWorkloadPageList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda.fsgzryngzl";
	}
	@RequestMapping("/personalHealthRecord/workload/edit")
	public String workloadEdit(HttpServletRequest request,String ohWorkloadId,String ohWorkloadOperationType){
		if(!ObjectUtil.isNotEmpty(ohWorkloadId))
			return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda.fsgzryngzl.edit";
		request.setAttribute("record", radiologicalProtectionReportService.searchOhWorkload(new Criteria("ID",ohWorkloadId)));
		request.setAttribute("ohWorkloadOperationType", ohWorkloadOperationType);
		return "rhip.oh.radiologicalProtectionReport.grjlda.grjlhjkjhda.fsgzryngzl.edit";
	}
	@RequestMapping("/personalHealthRecord/workload/save")
	public String saveWorkload(HttpServletRequest request,OhWorkload ohWorkload,ModelMap model,String ohWorkloadOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohWorkloadOperationType)&&ohWorkloadOperationType.trim().equals("2")){//更新
			ohWorkload.setUpdateTime(new Date());
			ohWorkload.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhWorkload(ohWorkload);
			this.createOperationLog(request, RhipModuleName.OH, "放射工作人员年工作量", OperationName.UPDATE);
		}else{//新增
			ohWorkload.setIsDelete(0);
			ohWorkload.setCreateTime(new Date());
			ohWorkload.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhWorkload(ohWorkload);
			this.createOperationLog(request, RhipModuleName.OH, "放射工作人员年工作量", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/personalHealthRecord/workload/delete")
	public String deleteWorkload(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhWorkload("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "放射工作人员年工作量", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	//培训情况=======================================================================
	@RequestMapping("/training")
	public String getTraining(HttpServletRequest request,String hospitalId,Integer indexPage){
		PageList<OhTraining> ohTrainingPageList = radiologicalProtectionReportService.searchOhTraining(super.getPage(request, indexPage), new Criteria("HOSPITAL_ID",hospitalId));
		request.setAttribute("page", ohTrainingPageList.getPage());
		request.setAttribute("infoRecords", ohTrainingPageList.getList());
		
		return "rhip.oh.radiologicalProtectionReport.pxqk";
	}
	@RequestMapping("/training/edit")
	public String trainingEdit(HttpServletRequest request,String ohTrainingId,String ohTrainingOperationType){
		if(!ObjectUtil.isNotEmpty(ohTrainingId))
			return "rhip.oh.radiologicalProtectionReport.pxqk.edit";
		request.setAttribute("record", radiologicalProtectionReportService.searchOhTraining(new Criteria("ID",ohTrainingId)));
		request.setAttribute("ohTrainingOperationType", ohTrainingOperationType);
		
		return "rhip.oh.radiologicalProtectionReport.pxqk.edit";
	}
	@RequestMapping("/training/save")
	public String saveTraining(HttpServletRequest request,OhTraining ohTraining,ModelMap model,String ohTrainingOperationType){
		int i = 0;
		if(StringUtil.isNotEmpty(ohTrainingOperationType)&&ohTrainingOperationType.trim().equals("2")){//更新
			ohTraining.setUpdateTime(new Date());
			ohTraining.setUpdateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.updateOhTraining(ohTraining);
			this.createOperationLog(request, RhipModuleName.OH, "培训情况", OperationName.UPDATE);
		}else{//新增
			ohTraining.setIsDelete(0);
			ohTraining.setCreateTime(new Date());
			ohTraining.setCreateBy(this.getCurrentUser(request).getName());
			i = radiologicalProtectionReportService.addOhTraining(ohTraining);
			this.createOperationLog(request, RhipModuleName.OH, "培训情况", OperationName.ADD);
		}
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	@RequestMapping("/training/delete")
	public String deleteTraining(HttpServletRequest request,ModelMap model,String id){
		int i = radiologicalProtectionReportService.deleteOhTraining("1", new Criteria("ID",id));
		this.createOperationLog(request, RhipModuleName.OH, "培训情况", OperationName.DELETE);
		if(i == 1)
			return EHRMessageUtil.returnMsg(model, "1");
		else
			return EHRMessageUtil.returnMsg(model, "-1");
	}
	
	
	//输入提示自动搜索
	@RequestMapping(value = "/autoComSel")
	@ResponseBody
	public SelectDTO<Organization> autoComSel(HttpServletRequest request,String inputValue,int currentPage) {
		Criteria criteria = new Criteria();
		Page page = super.getPage(request, currentPage); 
		criteria.add("genreCode",OP.NE,"B2");
		if(ObjectUtil.isNotEmpty(inputValue)){
			criteria.add("organName", OP.LIKE ,inputValue);
		}
		PageList<Organization> pageList = organizationService.getOrganizationsNoVirtual(page, criteria);
		return new SelectDTO<Organization>(pageList);
	}
}















