package com.founder.rhip.vaccine.controller.hospital;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.entity.basic.User;
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

/**
 * 
 * @author liu_jingyin 23价肺炎疫苗
 */
@Controller
@RequestMapping(value = "/ph/pneumonia")
public class PneumoniaController extends BaseController {

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
		return "rhip.vaccine.hospital.add.pneumonia";
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
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccineRecord", vaccineService.getVaccinationInfo(criteria));
		return "rhip.vaccine.hospital.add.pneumonia";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody
	String delete(HttpServletRequest request, String ehrId) {
        createOperationLog(request, RhipModuleName.VACCINE, "23价肺炎疫苗注射", OperationName.DELETE);
		vaccineOperatorService.deleteVaccine(ehrId,IVaccinationSaveService.VACCINE_INFLUENZA);
		return "1";
	}

    @RequestMapping("/details")
    public String detail(HttpServletRequest request,String ehrId, ModelMap model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccineRecord", vaccineService.getVaccinationInfo(criteria));
        return "rhip.vaccine.hospital.show.pneumonia";
    }

    @RequestMapping("/printDetails")
    public String printDetail(HttpServletRequest request,String ehrId, ModelMap model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccineRecord", vaccineService.getVaccinationInfo(criteria));
        return "rhip.vaccine.hospital.print.pneumonia";
    }

    @RequestMapping("/save")
	public String save(HttpServletRequest request,String comment ,String ehrId,ModelMap model) {
    	VaccinationDetailsDTO vaccinationDetailsDTO = VoUtil.getFormData(request, VaccinationDetailsDTO.class);
		vaccinationDetailsDTO.setCurrentOrg(getCurrentOrg(request));
		vaccinationDetailsDTO.setCurrentUser(super.getCurrentUser(request));		
		// 保存修改
		if (ObjectUtil.isNotEmpty(ehrId)) {
            createOperationLog(request, RhipModuleName.VACCINE, "23价肺炎疫苗注射", OperationName.UPDATE);
			vaccineOperatorService.updateVaccine(vaccinationDetailsDTO, ehrId,comment);
			return EHRMessageUtil.returnMsg(model, 1);
		}
        createOperationLog(request, RhipModuleName.VACCINE, "23价肺炎疫苗注射", OperationName.ADD);
		vaccineOperatorService.saveVaccine(vaccinationDetailsDTO,comment);
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
		return "rhip.vaccine.hospital.show.pneumonia"; 
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
		return "rhip.vaccine.hospital.pneumonia.list";
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

		model.addAttribute("ehrId", ehrId);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("operate", operate);

		VaccinationInfo info = vaccineService.getVaccinationInfo(criteria.add("immuType", IVaccinationSaveService.VACCINE_PNEUMONIA));
		model.addAttribute("vaccineRecord", info);

		if(ObjectUtil.isNullOrEmpty(info)){
			model.addAttribute("continueInject", true);
		}
	}

	@RequestMapping("/injectOne")
	public String injectOne(HttpServletRequest request,String ehrId,ModelMap model){
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("type", IVaccinationSaveService.VACCINE_PNEUMONIA);
		model.addAttribute("currentDate",new Date());
		return "rhip.vaccine.hospital.inject.pneumonia"; 
	}
	
	/**
	 * 继续接种
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/contine")
	public String contineRabiesSave(HttpServletRequest request, String comment, VaccinationInfo vaccinationInfo, ModelMap model) {
		Organization currentOrg = getCurrentOrg(request);
		User currentUser = super.getCurrentUser(request);			
		vaccinationInfo.setVaccineName("23价肺炎");
		vaccinationInfo.setImmuType(IVaccinationSaveService.VACCINE_PNEUMONIA);
		vaccinationInfo.setImmuUnitId(getCurrentOrg(request).getOrganCode());
        createOperationLog(request, RhipModuleName.VACCINE, "23价肺炎疫苗继续接种", OperationName.ADD);
		vaccineOperatorService.contineSave(vaccinationInfo,currentOrg,currentUser, comment);
		request.getSession().setAttribute("vaccinationInfo", vaccinationInfo); // 重复接种的时候自动带出上次接种的信息  修改人：高飞  修改日期：20180403
		return EHRMessageUtil.returnMsg(model, 1);
	}
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteVaccine")
	public String deleteVaccine(Long id, ModelMap model, HttpServletRequest request) {
        createOperationLog(request, RhipModuleName.VACCINE, "23价肺炎疫苗注射", OperationName.DELETE);
		vaccineOperatorService.deleteVaccine(id);
		return EHRMessageUtil.returnMsg(model, 1);
	}
}
