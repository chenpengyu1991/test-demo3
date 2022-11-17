package com.founder.rhip.mhm.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugRecord;
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;
import com.founder.rhip.ehr.entity.management.mhm.MhmSeverity;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.service.IMhmDrugService;
import com.founder.rhip.mhm.service.IMhmManagementService;

import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 精神卫生管理-规范化管理-随访记录
 * 
 * 
 */
@Controller
@RequestMapping(value = "/mhm/followUp")
public class FollowUpController extends MhmBaseController {

	@Resource(name = "mhmManagementService")
	private IMhmManagementService mhmManagementService;
	
	@Resource(name = "mhmDrugService")
	private IMhmDrugService mhmDrugService;	
	
	private final static String CONTROLLER_NAME = "精神卫生-规范化管理-随访";
    /**
     * 进入随访信息画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String initOutInfo(Long statusId,String searchType,HttpServletRequest request,ModelMap model) {
    	model.put("statusId", statusId);
    	if(StringUtil.isNotEmpty(searchType)){
    		model.put("searchType",searchType);
		}
		MhmFollowup lastFollowup = mhmManagementService.getLastFollowup(statusId);
		if(ObjectUtil.isNotEmpty(lastFollowup) && ObjectUtil.isNotEmpty(lastFollowup.getNextFollowupDt())){
			//获取最新一次随访的下次随访日期
			Date nextFollowUpDate =lastFollowup.getNextFollowupDt();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(nextFollowUpDate);
			calendar.add(Calendar.MONTH, -1);
			Date startDate = calendar.getTime();
			long currentDateTime= new Date().getTime();
			if(currentDateTime >=startDate.getTime() && currentDateTime <= nextFollowUpDate.getTime()){
				//下次随访日期提前一个月提醒
				model.addAttribute("nextFollowUpFlag", "1");
			}else if(currentDateTime > DateUtil.makeDateToMax(nextFollowUpDate).getTime()){//逾期
				model.addAttribute("nextFollowUpFlag", "2");
			}
		}
        return "rhip.mhm.management.followUp.main";
    }
	/**
	 * 查询随访信息列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String followUpList(Long statusId,HttpServletRequest request,ModelMap model) {
        PageList<MhmFollowup> plist = mhmManagementService.getFollowupList(statusId, buildPage(request));

		model.addAttribute("followUplist", plist.getList());
        model.addAttribute("page", plist.getPage());   
		return "rhip.mhm.management.followUp.list";
	}
	
	/**
	 * 进入随访信息新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String editFollowUp(HttpServletRequest request,Long statusId,Long eventId,ModelMap model) {
		ManagementDto mhmDto = mhmManagementService.getMulManagement(statusId, eventId, MhmEvents.M_FOLLOWUP);
		/*根据当前用户，设置页面中的调查者、调查日期*/
		MhmFollowup mhmFollowup = mhmDto.getMhmFollowup();
		Organization org = getCurrentOrg(request);
		Long userId = getCurrentUser(request).getId();
		if(ObjectUtil.isNullOrEmpty(mhmFollowup.getId())){
	       	mhmFollowup.setFillOrganCode(org.getOrganCode());//填写单位
	       	mhmFollowup.setFillDoctorId(userId.toString());//填写医生
	       	mhmFollowup.setFillDate(new Date());//填写日期
	       	if (!hasRole(RoleType.ZJSB, request)){
	       		mhmFollowup.setFollowupStatus("1");	//默认审核通过	
	       	}
		}
		mhmDto.setMhmFollowup(mhmFollowup);	
        model.put("managementDto", mhmDto);		
		return "rhip.mhm.management.followUp.edit";
	}
	
	/**
	 * 保存随访信息
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveFollowUp(ManagementDto mhmDto,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		getListData(mhmDto);
		/*根据当前用户，设置页面中的调查者、调查日期*/
		Organization org = getCurrentOrg(request);
		mhmDto.setEventType(MhmEvents.M_FOLLOWUP.getValue());
		mhmDto.setCurrentOrg(org);
		mhmDto.setCurrentUser(getCurrentUser(request));
        /*获取PERSON_ID modify by yjf 20140107*/
    	Long personId = mhmManagementService.getPersonId(mhmDto.getStatusId());
    	mhmDto.setPersonId(personId);	            
		updatePersonInfo(mhmDto.getPersonInfo(),request);
		Integer status = null;
		/*如果患者死亡，则更新状态表*/
		if(mhmDto.getMhmFollowup().getLoseReason().equals("1")){
			status = MhmStatus.DEAD.getValue();
		}
    	result = mhmManagementService.saveMhmManagement(mhmDto, MhmEvents.M_FOLLOWUP, status);
    	/*记录日志*/
    	Long followupId = mhmDto.getMhmFollowup().getId();
    	OperationName  opName = ObjectUtil.isNullOrEmpty(followupId)?OperationName.ADD:OperationName.UPDATE;
    	record(request, opName);
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	/**
	 * 删除随访信息
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String deleteFollowUp(Long eventId,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		if(ObjectUtil.isNotEmpty(eventId)){
			result = mhmManagementService.deleteMul(eventId);
	    	/*记录日志*/
	    	record(request, OperationName.DELETE);
		}		
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	
	/**
	 * 审批随访记录
	 *
	 * @param id
	 * @param status
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 * @author Ye jianfei
	 */
	@RequestMapping("/approval")
	public String approval(Long id,String status,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = false;
		if(ObjectUtil.isNotEmpty(id) && StringUtil.isNotEmpty(status)){
			result = mhmManagementService.approvalFollowup(id,status);
	    	/*记录日志*/
	    	record(request, OperationName.UPDATE);
		}		
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	/**
	 * 进入用药情况子画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/popupMedication")
    public String editCr(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            @SuppressWarnings("unchecked")
			List<MhmDrugRecord> listMhmDrugRecord = (List<MhmDrugRecord>) json2Obj(trData, MhmDrugRecord.class);
            model.put("mhmDrugRecord", listMhmDrugRecord.get(0));
            model.put("rowIndex", rowIndex);
        }else{
        	MhmDrugRecord mhmDrugRecord = new MhmDrugRecord();
        	model.put("mhmDrugRecord", mhmDrugRecord);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.mhm.management.followUp.popupMedication";
    }
	/**
	 * 查询药物列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/druglist")
	public String druglist(String drugName,String drugForm,HttpServletRequest request,ModelMap model) {
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(drugName)){
			criteria.add("T1.DRUG_NAME",OP.LIKE,drugName.trim());
		}
		if(StringUtil.isNotEmpty(drugForm)){
			criteria.add("T1.DRUG_FORM",OP.LIKE,drugForm.trim());
		}		
        PageList<MhmDrug> plist = mhmDrugService.findDrugList(criteria, buildPage(request));
        model.addAttribute("mhmDrugs", plist.getList());
        model.addAttribute("page", plist.getPage());   
		return "rhip.mhm.management.followUp.medicationList";
	}	
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
	
	/**
	 * 查找患者首次历史记录时间
	 * @param statusId
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/validateFollowupDt")
	public String validateFollowupDt(Long statusId,Date followupDt,ModelMap model){
		String result = "success";
		if(ObjectUtil.isNullOrEmpty(followupDt)){
			result = "";
		}
		MhmSeverity severity = mhmManagementService.getFirstPatientType(statusId);
		if(ObjectUtil.isNotEmpty(severity)){
			Date startDt = DateUtil.makeTimeToZero(severity.getStartDt());
			if(followupDt.getTime() < startDt.getTime()){
				result = DateUtil.getDateTime("yyyy/MM/dd", severity.getStartDt());
			}
		}else{
			result = "fail";
		}
		return EHRMessageUtil.returnMsg(model, result);
	}

	/**
	 * 根据病情分类，查找下次随访日期
	 * @param statusId
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/nextFollowupDt")
	public String nextFollowupDt(String followupType,Date followupDt,ModelMap model){
		String result = "";
		if(StringUtil.isNotEmpty(followupType) && ObjectUtil.isNotEmpty(followupDt)){
			Calendar dt = Calendar.getInstance();
			dt.setTime(followupDt);			
			if(followupType.equals("1")){//病情不稳定，加14天
				dt.add(Calendar.DAY_OF_YEAR, 14);    
			}
			if(followupType.equals("2") || followupType.equals("3")){//病情基本稳定、稳定，加3个月
				dt.add(Calendar.MONTH, 3);    
			}	
			result = DateUtil.getDateTime("yyyy/MM/dd", dt.getTime());
		}
		
		return EHRMessageUtil.returnMsg(model, result);
	}
    /**
     * 子表数据处理
     *
     * @param dto
     * @return ManagementDto
     */
    @SuppressWarnings("unchecked")
	private ManagementDto getListData(ManagementDto dto) throws InstantiationException, IllegalAccessException {
        //服药记录
        String followupMedication = dto.getFollowupMedication();
        if (StringUtil.isNotEmpty(followupMedication)) {
            List<MhmDrugRecord> mhmDrugRecords = (List<MhmDrugRecord>) json2Obj(followupMedication, MhmDrugRecord.class);
            dto.setFollowupMedicationRecords(mhmDrugRecords);
        }
        return dto;
    }	
}
