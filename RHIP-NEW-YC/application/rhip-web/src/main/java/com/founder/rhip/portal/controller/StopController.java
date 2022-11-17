package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.portal.service.IStopDoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: zheng_dandan Date: 13-6-14 Time: 上午9:44 To
 * change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/portal/stop")
public class StopController extends BaseController {

	@Resource(name = "stopDoctorService")
	private IStopDoctorService stopDoctorService;

	@RequestMapping("/search")
	public String getRecords(HttpServletRequest request) {
		return "portal.stop.search";
	}

	/**
	 * 查询停诊医生记录
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @return
	 */
	@RequestMapping("/records")
	public String getRecords(HttpServletRequest request, ModelMap model, Integer indexPage, Integer stopingStatus, String doctorName) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();

		if (ObjectUtil.isNotEmpty(doctorName)) {
			criteria.add("OT.NAME", OP.LIKE, doctorName);
		}
		if (stopingStatus == 1) {
			criteria.add("SD.STOPING_STATUS", stopingStatus);
		} else if (stopingStatus == 0) {
			criteria.add("SD.STOPING_STATUS", OP.IS, "null");
		}

//		if (super.hasRole(RoleType.YY_GLY, request) || super.hasRole(RoleType.SQZXYYGH, request)) {
//			criteria.add("OT.HOSPITAL_CODE", super.getCurrentOrg(request).getOrganCode());
//		}

		PageList<StopDoctor> list = stopDoctorService.getList(page, criteria);
		model.addAttribute("stopDoctorRecords", list.getList());
		model.addAttribute("page", list.getPage());
		return "portal.stop.records";

	}

	@RequestMapping("/stopDetailSearch")
	public String stopDetails(HttpServletRequest request, ModelMap model, StopDoctor record) {
		model.addAttribute("stopDoctor", record);
		return "portal.stop.stopDetailSearch";
	}

	/**
	 * 查询听诊医生的预约情况，并进行停诊处理
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @param type
	 * @return
	 */

	@RequestMapping("/stopDetails")
	public @ResponseBody
	String stopDetails(HttpServletRequest request, ModelMap model, String type, StopDoctor stopDoctor) {
		if (type.equals("2")) {
			Date oldStartDate = DateUtil.parseSimpleDate(request.getParameter("oldStartDate1"), "yyyy/MM/dd");
			Date oldEndDate = DateUtil.parseSimpleDate(request.getParameter("oldEndDate1"), "yyyy/MM/dd");
			
			/**
			 * 如果更改了停诊时间
			 * */
			if (stopDoctor.getStartDate().equals(oldStartDate) && stopDoctor.getEndDate().equals(oldEndDate)) {
				type = "2";
			} else {
				type = "1";
			}
		}
		String processResult = stopDoctorService.processUnResReg(stopDoctor, type);
		return processResult;
	}

	/**
	 * 查询听诊医生的预约记录
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @param stopDoctorInfo
	 * @return
	 */

	@RequestMapping("/stopDetailRecords")
	public String stopDetailRecords(HttpServletRequest request, ModelMap model, Integer indexPage, StopDoctor stopDoctor) {
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		PageList<ReserveRegister> reserveRegisters = stopDoctorService.getUnReserveRegister(stopDoctor, page);
		model.addAttribute("reserveRegisters", reserveRegisters.getList());
		model.addAttribute("page", reserveRegisters.getPage());
		model.addAttribute("startDate", stopDoctor.getStartDate());
		model.addAttribute("endDate", stopDoctor.getEndDate());
		return "portal.stop.stopDetailRecords";
	}

	@RequestMapping("/cancelStop")
	public @ResponseBody
	String cancelStop(HttpServletRequest request, ModelMap model, Long cancelId) {
		return stopDoctorService.cancelStop(cancelId);
	}

	@RequestMapping("/viewStop")
	public String viewStop(HttpServletRequest request, ModelMap model,StopDoctor record) {
		Criteria criteria = initCondition(record);
		List<StopDoctor> list = stopDoctorService.getStopDoctorDetails(criteria);
		request.setAttribute("stopDoctorDetails", list);
		return "portal.stop.viewStop";
	}

	private Criteria initCondition(StopDoctor stopDoctor) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNullOrEmpty(stopDoctor)) {
			return criteria;
		}
		if (ObjectUtil.isNotEmpty(stopDoctor.getDoctorSn())) {
			criteria.add("DOCTOR_SN", stopDoctor.getDoctorSn());
		}
		if (ObjectUtil.isNotEmpty(stopDoctor.getDeptSn())) {
			criteria.add("DEPT_SN", stopDoctor.getDeptSn());
		}
		if (ObjectUtil.isNotEmpty(stopDoctor.getHospitalCode())) {
			criteria.add("HOSPITAL_CODE", stopDoctor.getHospitalCode());
		}
		return criteria;
	}

}
