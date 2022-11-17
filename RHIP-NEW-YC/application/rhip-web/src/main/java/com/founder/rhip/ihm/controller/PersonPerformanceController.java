package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IPerformanceService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
//import com.founder.rhip.ihm.controller.form.WchTargetQueryForm;

/**
 * 妇幼保健-绩效统计
 * @author Cary
 *
 */
@Controller
@RequestMapping("/pam/person")
public class PersonPerformanceController extends BaseController {
    private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
    private static final String PAGE_KEY = "page";// page key

    @Resource(name = "performanceService")
    private IPerformanceService performanceService;

    /**
     * 进入查询页面
     * @return
     */
    @RequestMapping("/wch/index")
    public String birthCertificate(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/wch/performance");
        model.addAttribute("listpath", "materialChildList.jsp");
        return "pam.personPerformance.index";
    }

    //糖尿病
    @RequestMapping("/diabetes/index")
    public String diabetes(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/diabetes/performance");
        model.addAttribute("listpath", "diabetesList.jsp");
        return "pam.personPerformance.hmIndex";
    }

    //高血压
    @RequestMapping("/hypertension/index")
    public String hypertension(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/hypertension/performance");
        model.addAttribute("listpath", "hypertensionList.jsp");
        return "pam.personPerformance.hmIndex";
    }

    //冠心病
    @RequestMapping("/coronary/index")
    public String coronary(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/coronary/performance");
        model.addAttribute("listpath", "diabetesList.jsp");
        return "pam.personPerformance.hmIndex";
    }

    //肿瘤
    @RequestMapping("/tumor/index")
    public String tumor(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/tumor/performance");
        model.addAttribute("listpath", "diabetesList.jsp");
        return "pam.personPerformance.hmIndex";
    }

    //脑卒中
    @RequestMapping("/stroke/index")
    public String stroke(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/stroke/performance");
        model.addAttribute("listpath", "diabetesList.jsp");
        return "pam.personPerformance.hmIndex";
    }

    @RequestMapping("/healthRecords/index")
    public String healthRecords(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/healthRecords/performance");
        model.addAttribute("listpath", "healthRecordsList.jsp");
        return "pam.personPerformance.index";
    }

    /**
     * 妇幼保健考核
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/wch/performance")
    public String performance(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getWchPersonPerformance(form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.wch.list";
    }

    /**
     * 糖尿病考核 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/diabetes/performance")
    public String diabetes(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getCdmPersonPerformance("2", form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.diabetes.list";
    }

    /**
     * 高血压管理 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/hypertension/performance")
    public String hypertension(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getCdmPersonPerformance("1", form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.hypertension.list";
    }

    /**
     * 冠心病考核 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/coronary/performance")
    public String coronary(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getCdmPersonPerformance("4", form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.diabetes.list";
    }

    /**
     * 肿瘤考核 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/tumor/performance")
    public String tumor(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getCdmPersonPerformance("5", form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.diabetes.list";
    }

    /**
     * 脑卒中考核 1:高血压 2:糖尿病 3:脑卒中 4:冠心病 5:肿瘤
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/stroke/performance")
    public String stroke(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getCdmPersonPerformance("3", form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.diabetes.list";
    }

    /**
     * 健康档案
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/healthRecords/performance")
    public String healthRecords(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getHRPersonPerformance(form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.healthRecords.list";
    }


    /**
     * 医疗考核
     *
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/medical/index")
    public String medicalIndex(HttpServletRequest request, Model model) {
        return "pam.medical.index";
    }
 
    /**
     * 医疗考核-门诊摘要(挂号人次)
     *
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/medical/register")
    public String medicalRegister(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/medical/registerlist");
        model.addAttribute("listpath", "medical/registerList.jsp");
        model.addAttribute("unSelectType", "0");//镇
        model.addAttribute("organType", "A1,B1,B2");//市级医院,中心/站
        return "pam.medical.register";
    }
    
    /**
     * 医疗考核-门诊摘要(挂号人次)列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/medical/registerlist")
    public String medicalRegisterlist(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getOutpatientPersonPerformance(form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.medical.registerlist";
    }
    
    /**
     * 医疗考核-处方
     *
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/medical/prescription")
    public String medicalPrescription(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/person/medical/prescriptionlist");
        model.addAttribute("listpath", "medical/prescriptionList.jsp");
        model.addAttribute("unSelectType", "0");//镇
        model.addAttribute("organType", "A1,B1,B2");//市级医院,中心/站
        return "pam.medical.prescription";
    }
    
    /**
     * 医疗考核-处方列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/medical/prescriptionlist")
    public String medicalPrescriptionlist(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getPrescriptionPersonPerformance(form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.medical.prescriptionlist";
    }
    
    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
    }

    /**
     * 分页设置
     *
     * @param request
     * @return
     */
    public Page buildPage(HttpServletRequest request) {
        String indexPage = request.getParameter(INDEX_PAGE_KEY);
        int currentPage = 1;
        try {
            currentPage = Integer.valueOf(indexPage);
        } catch (Exception e) {
            logger.warn("没有当前页数");
        }
        Page page = super.getPage(request, currentPage);
        request.setAttribute(PAGE_KEY, page);
        return page;
    }

}