package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.service.*;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ihm.controller.form.ConsultationQueryForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 会诊信息
 * @author
 *
 */
@Controller
@RequestMapping("/ihm/consultation/")
public class ConsultationController extends IHMBaseController {

	@Resource(name = "consultationService")
	private IConsultationService consultationService;
	
	@Resource(name = "platformService")
	private IPlatformService platformService;

	/**
	 * 会诊信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("searchUrl", "/ihm/consultation/list");
		return "ihm.consultation.search";
	}


	/**
	 * 会诊信息列表
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String consultationInfoList(HttpServletRequest request, ConsultationQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<ConsultationInfo> consultationInfoPageList = consultationService.getConsultationInfoList(form.getCriteria(), page);
		List<ConsultationInfo> consultationInfoList = consultationInfoPageList.getList();
		if (ObjectUtil.isNotEmpty(consultationInfoList)) {
			for (ConsultationInfo consultationInfo : consultationInfoList) {
				if (ObjectUtil.isNotEmpty(consultationInfo.getPersonId())) {
					PersonInfo personInfo = platformService.queryPersonalInfo(consultationInfo.getPersonId());
					if (ObjectUtil.isNotEmpty(personInfo)) {
						consultationInfo.setIdCard(personInfo.getIdcard());
					}
				}
			}
		}
		model.addAttribute("consultationInfoPageList", consultationInfoList);
		model.addAttribute("page", consultationInfoPageList.getPage());
		return "ihm.consultation.list";
	}

	@RequestMapping("/view")
	public String consultationInfoView(HttpServletRequest request, String id, Model model) {
		ConsultationInfo result = consultationService.getConsultationInfo(new Criteria("ID", id));
		if (ObjectUtil.isNotEmpty(result) && ObjectUtil.isNotEmpty(result.getPersonId())) {
			PersonInfo personInfo = platformService.queryPersonalInfo(result.getPersonId());
			result.setIdCard(personInfo.getIdcard());
		}
		model.addAttribute("consultationInfo", result);
		return "ihm.consultation.view";
	}

}