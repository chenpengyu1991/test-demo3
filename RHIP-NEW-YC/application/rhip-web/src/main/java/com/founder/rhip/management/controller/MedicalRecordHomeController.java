package com.founder.rhip.management.controller;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IImrService;
import com.founder.rhip.ihm.service.IPerformanceService;
import com.founder.rhip.im.service.medical.IRealNameAnalyseService;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 综合管理-病案首页
 * @author Cary
 *
 */
@Controller
@RequestMapping("/medical/record/home")
public class MedicalRecordHomeController extends BaseController {

    @Resource(name = "imrService")
    private IImrService imrService;

    /**
     * 病案首页的费用 初始页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/fee/index")
    public String feeIndex(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/medical/record/home/fee/list");
        model.addAttribute("title", "病案首页费用");
        return "medical.record.home.index";
    }

    /**
     * 病案首页的费用 结果页面
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/fee/list")
    public String feeList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        form.setCurrentResult(model);
        form.initMedical();
        List<Map<String, Object>> reports = imrService.getImrFeeList(form.getBeginDate(), form.getEndDate(), form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "medical.record.home.fee.list";
    }

    /**
     * 手术切口 初始页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/incision/index")
    public String incisionIndex(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/medical/record/home/incision/list");
        model.addAttribute("title", "手术切口分析");
        return "medical.record.home.index";
    }

    /**
     * 手术切口 结果页面
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/incision/list")
    public String incisionList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        form.setCurrentResult(model);
        form.initMedical();
        List<Map<String, Object>> reports = imrService.getIncisionList(form.getBeginDate(), form.getEndDate(), form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "medical.record.home.incision.list";
    }

    /**
     * 诊断符合率分析 初始页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/consistency/index")
    public String consistencyIndex(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/medical/record/home/consistency/list");
        model.addAttribute("title", "诊断符合率分析");
        return "medical.record.home.index";
    }

    /**
     * 诊断符合率分析 结果页面
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/consistency/list")
    public String consistencyList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        form.setCurrentResult(model);
        form.initMedical();
        List<Map<String, Object>> reports = imrService.getConsistencyList(form.getBeginDate(), form.getEndDate(), form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "medical.record.home.consistency.list";
    }
}