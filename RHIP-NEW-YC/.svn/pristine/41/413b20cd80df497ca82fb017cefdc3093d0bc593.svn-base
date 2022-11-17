package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.child.ChildHealthCard;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IMedicalTargetService;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.ihm.service.IWchTargetService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
//import com.founder.rhip.ihm.controller.form.WchTargetQueryForm;

/**
 * 统计分析
 * @author Cary
 *
 */
@Controller
@RequestMapping("/ihm/analys")
public class AnalysController extends BaseController {

    @Resource(name="medicalTargetService")
    private IMedicalTargetService medicalTargetService;

    /**
     * 治疗质量统计分析
     * @return
     */
    @RequestMapping("/cureResultAnalys/index")
    public String vaccination(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/ihm/analys/cureResultAnalys/list");
        model.addAttribute("listpath", "cureResultAnalysList.jsp");
        return "ihm.analys.search";
    }

    /**
     * 治疗质量统计分析
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/cureResultAnalys/list")
    public String healthExamList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = medicalTargetService.getCureResultAnalys(form.getParamMap());
        model.addAttribute("summaryList", plist);
        return "pam.analys.cureResultAnalys.list";
    }

    /**
     * 检查结果统计分析
     * @return
     */
    @RequestMapping("/studyAnalys/index")
    public String studyAnalys(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/ihm/analys/studyAnalys/list");
        model.addAttribute("listpath", "studyAnalysList.jsp");
        return "ihm.analys.search";
    }

    /**
     * 检查结果统计分析
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/studyAnalys/list")
    public String studyAnalysList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = medicalTargetService.getStudyAnalys(form.getParamMap());
        model.addAttribute("summaryList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "pam.analys.studyAnalys.list";
    }

    /**
     * 检验结果统计分析
     * @return
     */
    @RequestMapping("/examAnalys/index")
    public String examAnalys(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/ihm/analys/examAnalys/list");
        model.addAttribute("listpath", "examAnalysList.jsp");
        return "ihm.analys.search";
    }

    /**
     * 检验结果统计分析
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/examAnalys/list")
    public String examAnalysList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = medicalTargetService.getExamAnalys(form.getParamMap());
        model.addAttribute("summaryList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "pam.analys.examAnalys.list";
    }

    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
    }
    
    /**
     * 检验结果统计分析
     * @return
     */
    @RequestMapping("/examCount/index")
    public String examPeopleCount(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/ihm/analys/examCount/list");
        model.addAttribute("listpath", "examCountList.jsp");
        return "ihm.examCount.search";
    }

    @RequestMapping("/examCount/list")
    public String examexamCountList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = medicalTargetService.getExamCount(form.getParamMap());
        model.addAttribute("examCountList", plist);
        return "ihm.analys.examCount.list";
    }

}