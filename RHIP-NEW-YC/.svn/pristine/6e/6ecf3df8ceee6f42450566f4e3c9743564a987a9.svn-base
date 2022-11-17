package com.founder.rhip.vaccine.controller.numSet;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.management.InoculationAppointmentParam;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.service.vaccine.IInoculationAppointmentParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * 预约数设置
 */
@Controller
@RequestMapping("/inoculationAppointmentParamSet")
public class InoculationAppointmentParamSetController extends BaseController{

	@Autowired
	private IInoculationAppointmentParamService appointmentNumService;


	@Autowired
	private IOrganizationApp organizationApp;
	/**
	 * 完成数设置
	 * 
	 * @return
	 */
	@RequestMapping("/setUp")
	public String appointmentNumSet(ModelMap model) {
		model.addAttribute("defaultYear", Integer.valueOf(DateUtil.getCurrentYear()));
		return "rhip.vaccine.appointmentNum.search";
	}

	/**
	 * 显示完成数结果
	 * 
	 * @param countYear
	 * @param model
	 * @return
	 */
	@RequestMapping("/listInoculationAppointmentParam")
	public String listInoculationAppointmentParam(@RequestParam("countYear") Integer countYear, @RequestParam("orgCode") String orgCode, ModelMap model) {
		String genre_code[] = {"A100","B100"};
		Criteria criteria = new Criteria("genre_code", OP.IN, genre_code).add("status", "1");
		List<Organization> orgs = organizationApp.queryOrganization(criteria);
		if (countYear == null) {
			countYear = Integer.valueOf(DateUtil.getCurrentYear());
		}
		List<InoculationAppointmentParam> appointmentNumInfos = appointmentNumService.buildInoculationAppointmentParams(countYear,orgCode, orgs);
		model.addAttribute("orgList", appointmentNumInfos);
		model.addAttribute("year", countYear);
		return "rhip.vaccine.appointmentNum.result";
	}

	/**
	 * 保存完成数设置
	 * 
	 * @param request
	 * @param inoculationAppointmentParamForm
	 * @return
	 */
	@RequestMapping("/saveInoculationAppointmentParam")
	@ResponseBody
	public String saveInoculationAppointmentParam(HttpServletRequest request, InoculationAppointmentParamForm inoculationAppointmentParamForm) {
		boolean status = appointmentNumService.saveOrUpdateInoculationAppointmentParam(inoculationAppointmentParamForm.getInoculationAppointmentParams());
		return status ? "success" : "failure";
	}

}
