package com.founder.rhip.lda.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ihm.service.IldaService;
import com.founder.rhip.lda.controller.form.ldaQueryForm;
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

@Controller
@RequestMapping("/lda/largeDataAnalysis")
public class LargeDataAnalysisController extends BaseController {

    private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
    private static final String PAGE_KEY = "page";// page key

    @Resource(name = "ldaService")
    private IldaService ldaService;

    /**
     * 体检数据综合查询(初始页面)
     * @param model
     * @return
     */
    @RequestMapping("/physicalExam/index")
    public String searchIndex(ModelMap model) {
        model.addAttribute("currentBeginDate",DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",new Date());
        model.addAttribute("flag","lda");//如果传递该参数，表示页面是从“综合查询-》体检数据综合查询”进入。不传表示“健康档案-》体检专项”
        return "lda.largeDataAnalysis.healthExam.index";
    }

    /**
     * 进入大处方监管(初始页面)
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/viewUnusual/index")
    public String unusualSearch(HttpServletRequest request,Model model) {
        initOrg(request, model);
        return "lda.largeDataAnalysis.searchUnusual.index";
    }

    /**
     * 进入大处方监管(查询)
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/searchUnusual/list")
    public String unusualList(ldaQueryForm form,HttpServletRequest request,ModelMap model) {
        Criteria ca = form.getUnusualCriteria();
        Map<String,String> paramMap = form.getUnusualParamMap();
        PageList<Map<String, Object>> plist = ldaService.getUnusualPrescriptionList(buildPage(request), ca, form.getUnusualOrder(),form.getMonitorIndex(),paramMap);
        model.addAttribute("unusuals", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("monitorIndex",form.getMonitorIndex());
        return "lda.largeDataAnalysis.unusual.list";
    }

    /**
     * 抗菌药物使用情况(初始页面)
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/viewAntibacterials/index")
    public String viewAntibacterials(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = super.getPage(request, 1);
        model.addAttribute("page", page);
        model.addAttribute("searchUrl", "/lda/largeDataAnalysis/searchAntibacterials/list");
        model.addAttribute("listpath", "antibacterialsList.jsp");
        return "lda.largeDataAnalysis.searchAntibacterial.index";
    }

    /**
     * 抗菌药物使用情况(查询)
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/searchAntibacterials/list")
    public String viewAntibacterialsList(HttpServletRequest request, ldaQueryForm form, Model model) {
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        PageList<Map<String, Object>> mapPageList = ldaService.getDrugStatisticsMapPageList(form.getParamMap(), page);
        model.addAttribute("drugUsageList", mapPageList.getList());
        model.addAttribute("page", mapPageList.getPage());
        model.addAttribute("genreCode", form.getGenreCode());
        return "lda.largeDataAnalysis.antibacterial.list";
    }

    /**
     * 抗菌药物使用情况查看医生
     * @param orgCode
     * @param medicalCode
     * @param model
     * @return
     */
    @RequestMapping("/viewDoctors")
    public String viewDoctors(String orgCode, String medicalCode,  String beginDateA, String endDateA, Model model) {
        List<Map<String, Object>> results = ldaService.getDoctors(orgCode, medicalCode, beginDateA, endDateA);
        model.addAttribute("medicalName", results.get(0).get("DRUG_NAME").toString());
        model.addAttribute("results", results);
        return "lda.largeDataAnalysis.antibacterial.doctor";
    }

    /**
     * 公用方法
     * @param request
     * @param model
     */
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
    protected Page buildPage(HttpServletRequest request) {
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