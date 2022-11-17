package com.founder.rhip.ihm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IPerformanceService;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 妇幼保健-绩效统计
 * @author Cary
 *
 */
@Controller
@RequestMapping("/pam/organ")
public class OrgPerformanceController extends BaseController {
    private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
    private static final String PAGE_KEY = "page";// page key

    @Resource(name = "performanceService")
    private IPerformanceService performanceService;
    
    /**
     * 进入查询页面(服务能力指标)
     * @return
     */
    @RequestMapping("/medicalEfficiency/index")

    public String birthCertificate(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/organ/medicalEfficiency/performance");
        model.addAttribute("listpath", "medicalEfficiencyList.jsp");
        return "pam.organPerformance.index";
    }

    /**
     * 进入查询页面(服务能力指标)
     * @return
     */
    @RequestMapping("/vaccination/index")
    public String vaccination(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/organ/vaccination/performance");
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
    @RequestMapping("/vaccination/performance")
    public String vaccinationP(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = performanceService.getVaccinationPerformance(form.getParamMap());
        model.addAttribute("summaryList", plist);
        return "pam.vaccination.list";
    }

    /**
     * 进入查询页面(服务能力指标)
     * @return
     */
    @RequestMapping("/healthExam/index")
    public String healthExam(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/organ/healthExam/performance");
        model.addAttribute("listpath", "healthExamList.jsp");
        return "pam.organPerformance.searchHealthExam.index";
    }

    /**
     * 体检次数、各体检项目次数
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/healthExam/performance")
    public String healthExamList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = performanceService.getHealthExamPerformance(form.getParamMap());
        model.addAttribute("summaryList", plist);
        return "pam.healthExam.list";
    }

    /**
     * 进入查询页面(基本医疗效率指标)
     * @return
     */
    @RequestMapping("/serviceCapacity/index")
    public String diabetes(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/organ/serviceCapacity/list");
        model.addAttribute("listpath", "serviceCapacityList.jsp");
        return "pam.organPerformance.index";
    }

    @RequestMapping("/serviceCapacity/list")
    public String serviceCapacitylist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
    	form.setCurrentResult(model);
		form.initMedical();
		List<Map<String, Object>> reports = performanceService.getServiceCapacityList(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "pam.serviceCapacity.list";
    }
    
    /**
     * 进入查询页面(基本医疗效率指标)
     * @return
     */
    @RequestMapping("/serviceCapacity/popChart")
    public String popChart(HttpServletRequest request, Model model) {
    	model.addAttribute("rangeType",request.getParameter("rangeType"));
        return "pam.serviceCapacity.popChart";
    }
    
    @RequestMapping("/serviceCapacity/monthOnMonth")
    public String monthOnMonth(HttpServletRequest request,TargetOrgQueryForm form, ModelMap model) throws IOException {
    	form.initMonthOnMonth();
    	Map<String, Object> result = performanceService.getServiceCapacity(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        JSONObject jsonObject = getJsonData(result);
        return EHRMessageUtil.returnMsg(model, jsonObject.toString());
    }
    
    @RequestMapping("/serviceCapacity/yearOnYear")
    public String yearOnYear(HttpServletRequest request,TargetOrgQueryForm form, ModelMap model) throws IOException {
    	form.initYearOnYear();
    	Map<String, Object> result = performanceService.getServiceCapacity(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        JSONObject jsonObject = null;
    	if(result != null && result.size()>0) {
             jsonObject = getJsonData(result);
        }
        return EHRMessageUtil.returnMsg(model, jsonObject == null ? "" : jsonObject);
    }
    
    private JSONObject getJsonData(Map<String, Object> mapData) {
        JSONObject jsonObject = new JSONObject();
        for (Object key : mapData.keySet()) {
            jsonObject.put(key, mapData.get(key));
        }
        return jsonObject;
    }
    
    /**
     * 进入查询页面(人员培训指标)
     * @return
     */
    @RequestMapping("/staffTraining/index")
    public String hypertension(HttpServletRequest request, Model model) {
//        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/organ/staffTraining/performance");
        model.addAttribute("listpath", "staffTrainingList.jsp");
        return "pam.organPerformance.searchTraning.index";
    }

    /**
     * 进入查询页面(公共卫生服务项目指标)
     * @return
     */
    @RequestMapping("/serviceProject/index")
    public String healthRecords(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/pam/organ/serviceProject/performance");
        model.addAttribute("listpath", "serviceProjectList.jsp");
        return "pam.organPerformance.index";
    }


    /**
     * 基本医疗效率指标
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/serviceCapacity/performance")
    public String healthRecords(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getWchPersonPerformance(form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.serviceCapacity.list";
    }



    /**
     * 服务能力指标
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/medicalEfficiency/performance")
    public String performance(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> plist = performanceService.getWchPersonPerformance(form.getParamMap(), page);
        model.addAttribute("summaryList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "pam.medicalEfficiency.list";
    }

    /**
     * 人员培训指标
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/staffTraining/performance")
    public String hypertension(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> list = performanceService.getTrainingPerformance(form.getParamMap());
        model.addAttribute("summaryList", list);
        return "pam.staffTraining.list";
    }

    /**
     * 公共卫生服务项目指标
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/serviceProject/performance")
    public String diabetes(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        form.setCurrentResult(model);
        form.initMedical();
        initOrg(request, model);
        List<Map<String, Object>> plist = performanceService.getServiceProjectPerformance(form.getBeginDate()
                ,form.getEndDate()
                ,form.getGenreCode()
                ,form.getGbCode()
                ,form.getSuperOrganCode()
                ,form.getOrganCode());
        model.addAttribute("summaryList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "pam.serviceProject.list";
    }

    /**
     * 进入查询页面(健康档案指标)
     * @return
     */
    @RequestMapping("/healthRecords/index")
    public String healthRecordsIndex(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("hospitalFlag", "1");//不要市级医院
        model.addAttribute("superOrganFlag", "1");//不要卫生院
        model.addAttribute("searchUrl", "/pam/organ/healthRecords/performance");
        model.addAttribute("listpath", "healthRecordsList.jsp");
        return "pam.organPerformance.index";
    }
    
    /**
     * 健康档案指标
     *
     * @param request
     * @param form
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/healthRecords/performance")
    public String healthRecordsPerformance(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> List = performanceService.getHRPerformanceList(form.getParamMap());
        model.addAttribute("reports", List);
        model.addAttribute("genreCode",form.getGenreCode());
        return "pam.orgHealthRecords.list";
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
    
    /**
     * 进入查询页面(抗菌药物使用情况)
     * @return
     */
    @RequestMapping("/viewAntibacterials/index")
    public String viewAntibacterials(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = super.getPage(request, 1);
 	    model.addAttribute("page", page);
        model.addAttribute("searchUrl", "/pam/organ/searchAntibacterials/list");
        model.addAttribute("listpath", "antibacterialsList.jsp");
        return "pam.organPerformance.searchAntibacterial.index";
    }

    /**
     * 查询列表页面(抗菌药物使用情况)
     * @return
     */
    @RequestMapping("/searchAntibacterials/list")
    public String viewAntibacterialsList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
        PageList<Map<String, Object>> mapPageList = performanceService.getAntibacterialsList(form.getParamMap(), page);
        model.addAttribute("antibacterialList", mapPageList.getList());
        model.addAttribute("page", mapPageList.getPage());
        return "pam.organPerformance.antibacterial.list";
    }
    
    /**
     * 查看使用抗菌药物医生
     * @param orgCode
     * @param medicalCode
     * @param model
     * @return
     */
    @RequestMapping("/viewDoctors")
    public String viewDoctors(String orgCode, String medicalCode,  String beginDateA, String endDateA, Model model) {
    	List<Map<String, Object>> results = performanceService.getDoctors(orgCode, medicalCode, beginDateA, endDateA);
    	model.addAttribute("results", results);
    	return "pam.organPerformance.antibacterial.doctor";
    }
    
    /**
     * 统计病案质量
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/viewInpatientMedicalRecordQuality/index")
    public String viewInpatientMedicalRecordQuality(HttpServletRequest request, Model model) {
    	   initOrg(request, model);
    	   Page page = super.getPage(request, 1);
    	   model.addAttribute("page", page);
           model.addAttribute("searchUrl", "/pam/organ/viewInpatientMedicalRecordQuality/list");
           model.addAttribute("listpath", "inpatientMedicalRecordQualityList.jsp");
           return "pam.organPerformance.searchInpatientMedicalRecordQuality.index";
    }

    /**
     * 查看病案质量列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/viewInpatientMedicalRecordQuality/list")
    public String viewInpatientMedicalRecordQualityList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		PageList<Map<String, Object>> mapList = performanceService.getInpatientMedicalRecordQuality(form.getParamMap(), page);
		model.addAttribute("results", mapList.getList());
		model.addAttribute("page", mapList.getPage());
		model.addAttribute("genreCode",form.getGenreCode());
		return "pam.organPerformance.searchInpatientMedicalRecordQuality.list";
    }
    
    @RequestMapping("/antibacterials/prescription/index")
	public String antibacterialsPrescriptionIndex(HttpServletRequest request, Model model) {
		initOrg(request, model);
		model.addAttribute("searchUrl", "/pam/organ/antibacterials/prescription/list");
		model.addAttribute("listpath", "antibacterialPrescriptionList.jsp");
		return "pam.organPerformance.searchAntibacterialsPrescription.index";
	}
    
    @RequestMapping("/antibacterials/prescription/list")
	public String antibacterialsPrescriptionList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		initOrg(request, model);
		List<Map<String, Object>> mapList = performanceService.getAntibacterialsPrescriptionList(form.getParamMap());
		model.addAttribute("antibacterialList", mapList);
		return "pam.organPerformance.searchAntibacterialsPrescription.list";
	}
}