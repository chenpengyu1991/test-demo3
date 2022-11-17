package com.founder.rhip.management.controller;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.ihm.IStatisticsService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IMedicalTargetService;
import com.founder.rhip.im.service.medical.IExanAnalyseService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 综合管理  医疗业务分析-医技服务监管
 *
 */
@Controller
@RequestMapping("/medical")
public class IntegrationManageController extends BaseController {

    @Resource(name="exanAnalyseService")
    private IExanAnalyseService exanAnalyseService;

    @Resource(name="medicalTargetService")
    private IMedicalTargetService medicalTargetService;

    @Resource(name = "ihmStatisticsService")
    private IStatisticsService ihmStatisticsService;


    @RequestMapping("/searchIndex/{searchType}")//searchType 1医技服务监管 2 检验检查分析  3用药分析
    public String serviceSupervision(HttpServletRequest request, Model model,@PathVariable("searchType")  String searchType) {
        Date today = new Date();
        Date startDate = DateUtil.firstDateOfMonth(today);
        model.addAttribute("currentBeginDate", startDate);
        model.addAttribute("currentEndDate", today);
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        //初始化统计报表类型
        if (ObjectUtil.isNotEmpty(searchType)) {
            model.addAttribute("searchType",searchType);
            if("1".equals(searchType)){
                model.addAttribute("breadMenu2","医疗业务分析");
                model.addAttribute("breadMenu3","医技服务监管");
            }else if("2".equals(searchType)){
                model.addAttribute("breadMenu2","财务管理");
                model.addAttribute("breadMenu3","检验检查分析");
            }else {
                model.addAttribute("breadMenu2","财务管理");
                model.addAttribute("breadMenu3","用药情况分析");
            }
        }
        return "rhip.ihm.zhgl.search";
    }

    /**
     * 医技服务监管
     */
    @RequestMapping("/serviceSupervisionList")
    public String serviceSupervisionList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = exanAnalyseService.getServiceAnalys(form.getParamMap());
        model.addAttribute("result", plist);
        model.addAttribute("genreCode", form.getGenreCode());
        return "rhip.ihm.zhgl.serviceSupervisionList";
    }

    /**
     * 检验检查分析
     */
    @RequestMapping("/checkExamList")
    public String checkExamList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = ihmStatisticsService.getCheckExamList(form.getParamMap());
        model.addAttribute("result", plist);
        model.addAttribute("genreCode", form.getGenreCode());
        return "rhip.ihm.zhgl.checkExamList";
    }

    /**
     * 用药分析
     */
    @RequestMapping("/drugUseList")
    public String drugUseList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = ihmStatisticsService.getDrugUseList(form.getParamMap());
        model.addAttribute("result", plist);
        model.addAttribute("genreCode", form.getGenreCode());
        return "rhip.ihm.zhgl.drugUseList";
    }
}