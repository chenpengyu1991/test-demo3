package com.founder.rhip.report.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpVaccinationService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/rpVaccination")
public class RpVaccinationController extends BaseController {
	
	@Resource(name = "rpVaccinationService")
	private IRpVaccinationService rpVaccinationService;

    //接种疫苗绩效考核(机构)
	  /**
     * 进入查询页面(服务能力指标)
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpVaccination/list");
        model.addAttribute("listpath", "vaccinationList.jsp");
        return "pam.organPerformance.searchVaccination.index";
    }

    /**
     * 疫苗接种针次数
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = rpVaccinationService.getOrganizaitonVaccinationMapList(form.getParamMap());
        model.addAttribute("genreCode", form.getGenreCode());
        model.addAttribute("summaryList", plist);
        return "pam.vaccination.list";
    }
}