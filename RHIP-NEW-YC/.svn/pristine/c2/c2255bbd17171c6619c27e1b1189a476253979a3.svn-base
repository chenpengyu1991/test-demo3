package com.founder.rhip.vaccine.controller.hospital;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.dto.vaccine.VaccinationDetailsDTO;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;
import com.founder.rhip.ph.service.vaccine.IVaccinationSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author liu_jingyin 乙肝疫苗
 */
@Controller
@RequestMapping(value = "/ph/hepatitis")
public class HepatitisController extends BaseController {

	@Resource(name = "vaccineService")
	private IVaccinationReadService vaccineService;

	@Resource(name = "vaccineOperatorService")
	IVaccinationSaveService vaccineOperatorService;

	/**
	 * 新增
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
        //添加接种日期默认为当日
		model.addAttribute("examineDetailList", setDetailList());
        return "rhip.vaccine.hospital.add.hepatitis";
	}
	
	private List<ExamineDetail> setDetailList(){
		List<ExamineDetail> eList = new ArrayList<>();
		String [] nameArray = {"HbsAg","HbsAb","HbeAg","HbeAb","HbcAb"};
		for(int i = 0 ; i < nameArray.length; i++){
			ExamineDetail ed  = new ExamineDetail();
			ed.setInspectionItemName(nameArray[i]);
			eList.add(ed);
		}
		return eList;
	}
	

	/**
	 * 修改
	 * 
	 * @param ehrId
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String update(String ehrId, Model model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		List<ExamineDetail> examineDetailList = vaccineService.getExamineDetail(criteria);
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("examineDetailList", examineDetailList);
		return "rhip.vaccine.hospital.add.hepatitis";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param ehrId
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody String delete(HttpServletRequest request, String ehrId) {
        createOperationLog(request, RhipModuleName.VACCINE, "乙肝疫苗", OperationName.DELETE);
		vaccineOperatorService.deleteVaccine(ehrId,IVaccinationSaveService.VACCINE_HEPATITIS);
		return "1";
	}

    @RequestMapping("/printDetails")
    public String printDetail(HttpServletRequest request,String ehrId,ModelMap model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		List<ExamineDetail> examineDetailList = vaccineService.getExamineDetail(criteria);
		List<VaccinationInfo> infoList = vaccineService.getVaccinationList(criteria);
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccinationInfoList", infoList);
		model.addAttribute("examineDetailList", examineDetailList);
		
        return "rhip.vaccine.hospital.print.hepatitis";
    }

	/**
	 * 保存新增或修改
	 * 
	 * @param request
	 * @param ehrId
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(HttpServletRequest request, String ehrId,String comment,ModelMap model) {
		VaccinationDetailsDTO vaccinationDetailsDTO = VoUtil.getFormData(request, VaccinationDetailsDTO.class);
		vaccinationDetailsDTO.setCurrentOrg(getCurrentOrg(request));
		vaccinationDetailsDTO.setCurrentUser(super.getCurrentUser(request));			
		// 保存修改
		if (ObjectUtil.isNotEmpty(ehrId)) {
            createOperationLog(request, RhipModuleName.VACCINE, "乙肝疫苗注射", OperationName.UPDATE);
			vaccineOperatorService.updateVaccine(vaccinationDetailsDTO, ehrId,comment);
			return EHRMessageUtil.returnMsg(model, 1);
		}
        createOperationLog(request, RhipModuleName.VACCINE, "乙肝疫苗注射", OperationName.ADD);
		vaccineOperatorService.saveVaccine(vaccinationDetailsDTO,comment);
		return EHRMessageUtil.returnMsg(model, 1);	
	}
	
	/**
	 * 继续接种
	 * @param request
	 * @return
	 */
	@RequestMapping("/contine")
	public String contineHepatitisSave(HttpServletRequest request,VaccinationInfo vaccinationInfo,
			String comment,ModelMap model){
		Organization currentOrg = getCurrentOrg(request);
		User currentUser = super.getCurrentUser(request);		
		vaccinationInfo.setVaccineName("乙肝疫苗");
		vaccinationInfo.setImmuType(IVaccinationSaveService.VACCINE_HEPATITIS);
		vaccinationInfo.setImmuUnitId(getCurrentOrg(request).getOrganCode());
        createOperationLog(request, RhipModuleName.VACCINE, "继续接种", OperationName.ADD);
		vaccineOperatorService.contineSave(vaccinationInfo,currentOrg,currentUser,comment);
		return EHRMessageUtil.returnMsg(model, 1);
	}
	
	/** 
	* @Title: updateVaccine 
	* @Description: 查看疫苗注射情况
	* @param @param request
	* @param @param ehrId
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	*/
	@RequestMapping("/injectVaccine")
	public String injectVaccine(HttpServletRequest request,String ehrId, String operate, ModelMap model){
		getVaccine(ehrId, operate, model);
		return "rhip.vaccine.hospital.show.hepatitis"; 
	}

	/**
	 * @Title: updateVaccine
	 * @Description: 查看疫苗注射情况
	 * @param @param request
	 * @param @param ehrId
	 * @param @param model
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/searchVaccine")
	public String searchVaccine(HttpServletRequest request,String ehrId, String operate, ModelMap model){
		getVaccine(ehrId, operate, model);
		return "rhip.vaccine.hospital.hepatitis.list";
	}

	/**
	 * 获取疫苗接种列表
	 * @param ehrId
	 * @param operate
	 * @param model
	 */
	private void getVaccine(String ehrId, String operate, ModelMap model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		List<ExamineDetail> examineDetailList = vaccineService.getExamineDetail(criteria);

		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("examineDetailList", examineDetailList);
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("operate", operate);

		List<VaccinationInfo> infoList = vaccineService.getVaccinationList(criteria.add("immuType", IVaccinationSaveService.VACCINE_HEPATITIS));
		model.addAttribute("vaccinationInfoList", infoList);
		boolean continueInject = getInject(infoList);
		model.addAttribute("continueInject", continueInject);
	}

	@RequestMapping("/injectOne")
	public String injectOne(HttpServletRequest request,String ehrId,ModelMap model){
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete", 0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		List<VaccinationInfo> infoList = vaccineService.getVaccinationList(criteria.add("immuType", IVaccinationSaveService.VACCINE_HEPATITIS));
		model.addAttribute("ehrId", ehrId);
		String times = getTimes(infoList);
		model.addAttribute("timesString", times);
		model.addAttribute("currentDate",new Date());
		return "rhip.vaccine.hospital.inject.hepatitis"; 
	}
	
	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteVaccine")
	public String deleteVaccine(Long id, ModelMap model, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.VACCINE, "乙肝疫苗注射", OperationName.DELETE);
		vaccineOperatorService.deleteVaccine(id);
		return EHRMessageUtil.returnMsg(model, 1);
	}
	
	private String getTimes(List<VaccinationInfo> infoList){
		StringBuffer timesString = new StringBuffer();
		for (VaccinationInfo vaccinationInfo : infoList) {
			String times = vaccinationInfo.getInoculationTimes();
			timesString.append(times);
		}
		return timesString.toString();
	}
	
	/** 
	* @Title: getInject 
	* @Description: 获取可以继续接种的权限
	* @param @param request
	* @param @param model
	* @param @param traumaHistory
	* @param @param infoList
	* @param @return
	* @return boolean
	* @throws 
	*/
	private boolean getInject(List<VaccinationInfo> infoList){
		// 判断是否可以继续接种
		boolean continueInject = true;
		//已经注射5次则不能注射
		if(ObjectUtil.isNotEmpty(infoList) && infoList.size() >= 5){
			continueInject = false;
		}
		return continueInject;
	}
}
