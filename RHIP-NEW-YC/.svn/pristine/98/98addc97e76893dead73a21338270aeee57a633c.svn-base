package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.ihm.service.IWchTargetService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 妇幼保健
 * @author Cary
 *
 */
@Controller
@RequestMapping("/ihm")
public class WCHTargetController extends BaseController {

    @Autowired
    private IOrganizationApp organizationApp;

    @Autowired
    private IStaffService staffService;

    @Resource(name = "wchTargetService")
    private IWchTargetService wchTargetService;

    @Resource(name = "wchSearchService")
    private IWchSearchService wchSearchService;

    @Resource(name = "brwHealthService")
    private IBrwHealthService brwHealthService;

    /**
     * 进入查询页面
     * @return
     */
    @RequestMapping("/child/birthCertificate/index")
    public String birthCertificate(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "1");
        return "ihm.child.bcSearch";
    }
    @RequestMapping("/child/birthDefect/index")
    public String birthDefect(HttpServletRequest request, Model model) {
        model.addAttribute("searchType", "2");
        initOrg(request, model);
        return "ihm.child.defectSearch";
    }
    @RequestMapping("/child/healthCard/index")
    public String healthCard(HttpServletRequest request, Model model) {
        model.addAttribute("searchType", "3");
        initOrg(request, model);
        return "ihm.child.cardSearch";
    }
    @RequestMapping("/child/neonatalVisit/index")
    public String neonatalVisit(HttpServletRequest request, Model model) {
        model.addAttribute("searchType", "4");
        initOrg(request, model);
        return "ihm.child.visitSearch";
    }
    
    @RequestMapping("/child/neonatalVisit/index1")
    public String neonatalVisit1(HttpServletRequest request, Model model) {
        model.addAttribute("searchType", "4");
        initOrg(request, model);
        return "ihm.child.visitSearch1";
    }
    @RequestMapping("/child/healthExamination/index")
    public String healthExamination(HttpServletRequest request, Model model) {
        model.addAttribute("searchType", "5");
        initOrg(request, model);
        return "ihm.child.examSearch";
    }
    @RequestMapping("/child/death/index")
    public String death(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        //默认按年查询
        model.addAttribute("yearRange",1);
        //默认查询日期为去年
        model.addAttribute("currentBeginDate", DateUtil.convert("yyyyMMdd",DateUtil.getCurrentYear() - 1 + "0101"));
        model.addAttribute("currentEndDate",DateUtil.convert("yyyyMMdd",DateUtil.getCurrentYear() - 1  + "0131"));
        Page page = new Page(0,0);
        model.addAttribute("searchUrl", "/ihm/child/statistics/childDeathList") ;
        return "ihm.child.deathSearch";
    }

    /**
     * 2-5岁儿童死亡率统计列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/childDeathList")
    public String c(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        String monthList = form.getMonthList();
        List<ChildDeathRecord> deathMortalityList = wchTargetService.getChildDeathMortality(monthList,form.getGbCode());
        for(ChildDeathRecord childDeathRecord : deathMortalityList){
            childDeathRecord.setUnderFiveMortality(Math.round(childDeathRecord.getUnderFiveMortality()*100)/100.0);
            childDeathRecord.setNewbornMortality(Math.round(childDeathRecord.getNewbornMortality()*100)/100.0);
            childDeathRecord.setBabyMortality(Math.round(childDeathRecord.getBabyMortality()*100)/100.0);
        }
        model.addAttribute("childDeathList", deathMortalityList);
        return "ihm.child.search.deathList";
    }

    /**
     * 医学出生证明查询
     * @return
     */
    @RequestMapping("/child/birthCertificate/list")
    public String birthCertificateList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<BirthCertificate> plist = wchSearchService.getChildBirthList(form.getParamMap(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.child.search.birthCertificateList";
    }

    /**
     * 出生缺陷登记查询
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/birthDefect/list")
    public String birthDefect(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<BirthDefectMonitor> plist = wchSearchService.getBirthDefectList(form.getParamMap(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.child.search.birthDefectList";
    }

    /**
     * 儿童登记管理查询
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/healthCard/list")
    public String healthCard(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<ChildHealthCard> plist = wchSearchService.getHealthCardList(form.getParamMap(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.child.search.healthCardList";
    }

    /**
     * 新生儿随访信息
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/neonatalVisit/list")
    public String neonatalVisit(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<NeonatalFamilyVisit> plist = wchSearchService.getNeonatalVisitList(form.getCriteria(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.child.search.neonatalVisitList";
    }

    /**
     * 儿童健康体检数据
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/healthExamination/list")
    public String healthExamination(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<ChildHealthExamination> plist = wchSearchService.getHealthExaminationList(form.getParamMap(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.child.search.healthExaminationList";
    }

    /**
     * 儿童死亡数据
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/death/list")
    public String deatl(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<ChildHealthExamination> plist = wchSearchService.getHealthExaminationList(form.getParamMap(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.child.search.deathList";
    }

    /**
     * 出生证明详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/newBornDetail")
    public String newBornDetail(String id, ModelMap model){
        Criteria criteria = new Criteria("ID", id);
        BirthCertificate chBirthCertificate = wchSearchService.getChBirthCertificate(criteria);
        if(ObjectUtil.isNullOrEmpty(chBirthCertificate)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("chBirthCertificate", chBirthCertificate);
        if(ObjectUtil.isNotEmpty(chBirthCertificate)){
            if(ObjectUtil.isNotEmpty(chBirthCertificate.getMotherIdcard())){
                model.addAttribute("midCard", chBirthCertificate.getMotherIdcard().toCharArray());
            }
            if(ObjectUtil.isNotEmpty(chBirthCertificate.getFatherIdcard())){
                model.addAttribute("fidCard", chBirthCertificate.getFatherIdcard().toCharArray());
            }
        }
        return "rhip.ehr.browser.newBornDetail";
    }

    /**
     * 出生缺陷详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/birthDefectDetail")
    public String bornDefect(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID", id);
        BirthDefectMonitor birthDefectMonitor = wchSearchService.getBirthDefect(criteria);
        if(ObjectUtil.isNullOrEmpty(birthDefectMonitor)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("birthDefectMonitor", birthDefectMonitor);
        return "rhip.ehr.browser.birthDefect";
    }

    /**
     * 儿童登记管理详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/healthCardDetail")
    public String healthCard(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID", id);
        ChildHealthCard childHealthCard = wchSearchService.getHealthCard(criteria);
        if(ObjectUtil.isNullOrEmpty(childHealthCard)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("childHealthCard", childHealthCard);
        return "rhip.ehr.browser.childHealthCard";
    }


    /**
     * 新生儿随访信息详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/neonatalVisitDetail")
    public String neonatalVisitDetail(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID", id);
        NeonatalFamilyVisit neonatalFamilyVisit = wchSearchService.getNeonatalVisit(criteria);
        if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
        return "rhip.ehr.browser.neonatalFamilyVisit";
    }

    /**
     * 新生儿随访信息详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/addNeonatalVisitDetail")
    public String addNeonatalVisitDetail(HttpServletRequest request, ModelMap model, String id, NeonatalFamilyVisit neonatalFamilyVisit, PersonalPhyExamDTO personalPhyExamDTO){
    	neonatalFamilyVisit=wchSearchService.getNeonatalVisit(new Criteria("ID", neonatalFamilyVisit.getId()));
    	request.getSession().setAttribute("PersonalPhyExamDTO", personalPhyExamDTO);
        model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
        return "rhip.ehr.browser.addNeonatalFamilyVisit";
    }
    @ResponseBody
    @RequestMapping("/saveNeonatalVisitDetail")
    public String saveNeonatalVisitDetail(HttpServletRequest request, String supervisionDoctor, ModelMap model, String id, NeonatalFamilyVisit neonatalFamilyVisit, PersonalPhyExamDTO personalPhyExamDTO){
    	Organization org = getCurrentOrg(request);
    	int num=wchSearchService.saveNeonatalFamilyVisit(neonatalFamilyVisit,org);
    	//model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
    	String str="";
    	if(num==0){
    		str="保存失败!";
    	}else{
    		str="保存成功";
    	}
        return str;
    }
    
    @ResponseBody
    @RequestMapping("/deleteNeonatalVisit")
    public String deleteNeonatalVisit(HttpServletRequest request, ModelMap model, String id, NeonatalFamilyVisit neonatalFamilyVisit, PersonalPhyExamDTO personalPhyExamDTO){
    	int num=wchSearchService.deleteNeonatalFamilyVisit(id);
    	String str="";
    	if(num==0){
    		str="删除失败!";
    	}else if(num==1){
    		str="删除成功!";
    	}
        return str;
    }
    
    /**
     * 儿童健康体检数据
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/healthExaminationDetail")
    public String healthExaminationDetail(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("ID", id);
        ChildHealthExamination childHealthExamination = wchSearchService.getHealthExamination(criteria);
        if(ObjectUtil.isNullOrEmpty(childHealthExamination)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("childHealthExamination", childHealthExamination);
        return "rhip.ehr.browser.childHealthExam";
    }



    /**
     * 进入儿童人数统计页面
     * @return
     */
    @RequestMapping("/child/statistics/childCount")
    public String childCount(HttpServletRequest request, Model model) {
        model.addAttribute("searchUrl", "/ihm/child/statistics/childCountList");
        initOrg(request, model);
        return "ihm.childCount.search";
    }

    /**
     * 儿童人数统计列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/childCountList")
    public String a(HttpServletRequest request, TargetOrgQueryForm form, Model model) {

        List<Map<String, Object>> resultList = wchTargetService.getChildCount(form.getParamMap());
        model.addAttribute("genreCode",form.getGenreCode());
        model.addAttribute("childCoundList", resultList);
        return "ihm.childCount.list";
    }

    /**
     * 进入基础统计页面
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/baseCount")
    public String baseInfoSearch(HttpServletRequest request, Model model) {
        model.addAttribute("searchUrl", "/ihm/child/statistics/baseCountList");
        model.addAttribute("listpath", "baseInfoList.jsp");
        initOrg(request, model);
        return "ihm.child.statisticsSearch";
    }

    /**
     * 基础统计列表
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/baseCountList")
    public String baseInfoList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> plist = wchTargetService.getChildBaseInfo(form.getParamMap());
        model.addAttribute("baseInfoList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.child.baseInfoList";
    }
    /**
     * 进入保健统计页面
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/serviceCount")
    public String serviceSearch(HttpServletRequest request, Model model) {
        model.addAttribute("searchUrl", "/ihm/child/statistics/serviceCountList");
        model.addAttribute("listpath", "serviceList.jsp");
        initOrg(request, model);
        return "ihm.child.statisticsSearch";
    }

    /**
     * 保健服务统计列表
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/serviceCountList")
    public String serviceList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> plist = wchTargetService.getChildService(form.getParamMap());
        model.addAttribute("serviceList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.child.serviceList";
    }

    /**
     * 进入营养评价统计页面
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/nutrition")
    public String nutritionSearch(HttpServletRequest request, Model model) {
        model.addAttribute("searchUrl", "/ihm/child/statistics/nutritionList");
        model.addAttribute("listpath", "nutritionList.jsp");
        initOrg(request, model);
        return "ihm.child.statisticsSearch";
    }

    /**
     * 营养评价统计列表
     * @param model
     * @return
     */
    @RequestMapping("/child/statistics/nutritionList")
    public String nutritionList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> plist = wchTargetService.getChildNutrition(form.getParamMap());
        model.addAttribute("nutritionList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.child.nutritionList";
    }

    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate", DateUtil.lastDateOfMonth(new Date()));
    }

    /**
     * 查询 孕产妇登记
     * @return
     */
    @RequestMapping("/woman/maternalCard/index ")
    public String maternalCard(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "1");
        return "ihm.woman.cardSearch";
    }

    /**
     * 查询 产前检查
     * @return
     */
    @RequestMapping("/woman/prenatalVisit/index ")
    public String prenatalVisit(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "2");
        return "ihm.woman.prenatalVisitSearch";
    }

    /**
     * 查询 产妇分娩记录
     * @return
     */
    @RequestMapping("/woman/delivery/index")
    public String delivery(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "3");
        model.addAttribute("searchUrl", "/ihm/woman/delivery/list") ;
        return "ihm.woman.deliverySearch";
    }

    /**
     * 查询 产后42天健康检查
     * @return
     */
    @RequestMapping("/woman/postpartum/index")
    public String postpartum(HttpServletRequest request, Model model) {
        initOrg(request, model);
//        boolean isAdmin = hasRole(RoleType.ADMIN, request) || hasRole(RoleType.FYBJS, request);
//        model.addAttribute("isAdmin",isAdmin);
        model.addAttribute("searchType", "4");
        return "ihm.woman.postpartumSearch";
    }

    /**
     * 查询 高危产妇管理
     * @return
     */
    @RequestMapping("/woman/highRisk/index")
    public String highRisk(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "5");
        model.addAttribute("searchUrl", "/ihm/woman/highRisk/list") ;
        return "ihm.woman.highRiskSearch";
    }

    /**
     * 查询 产妇死亡登记
     * @return
     */
    @RequestMapping("/woman/death/index")
    public String womanDeath(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "6");
        return "ihm.woman.deathSearch";
    }



    /**
     * 孕产妇登记列表
     * @return
     */
    @RequestMapping("/woman/maternalCard/list")
    public String maternalCardList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<MotherhoodPeriodFollowup> plist = wchSearchService.getMotherhoodPeriodList(form.getParamMap(), page);
        model.addAttribute("womanList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.maternalCardList";
    }

    /**
     * 产前检查列表
     * @return
     */
    @RequestMapping("/woman/prenatalVisit/list")
    public String prenatalVisitList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<PrenatalFollowup> plist = wchSearchService.getPrenatalFollowupList(form.getParamMap(), page);
        model.addAttribute("womanList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.prenatalVisitList";
    }

    /**
     * 产妇分娩记录
     * @return
     */
    @RequestMapping("/woman/delivery/list")
    public String deliveryList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<DeliveryRecordInfo> plist = wchSearchService.getDeliveryList(form.getParamMap(), page);
        model.addAttribute("womanList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.deliveryList";
    }

    /**
     * 产后42天健康检查
     * @return
     */
    @RequestMapping("/woman/postpartum/list")
    public String postpartumList(HttpServletRequest request, WChQueryForm form, Model model) {
        String curCode = getCurrentOrg(request).getOrganCode();
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
        List<String> orgCodes = this.getOrgCodeByOrgCode(request);
        PageList<PostpartumDaysHealthInfo> plist = wchSearchService.getPostpartumList(flg,orgCodes,form.getParamMap(), page);
        model.addAttribute("curCode",curCode);
        model.addAttribute("womanList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.postpartumList";
    }

    /**
     * 高危产妇管理
     * @return
     */
    @RequestMapping("/woman/highRisk/list")
    public String highRiskList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<MotherhoodPeriodFollowup> plist = wchSearchService.getMotherhoodPeriodList(form.getParamMap(), page);
        model.addAttribute("womanList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.highRiskList";
    }

    /**
     * 产妇死亡登记
     * @return
     */
    @RequestMapping("/woman/death/list")
    public String deathList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<MotherhoodPeriodFollowup> plist = wchSearchService.getMotherhoodPeriodList(form.getParamMap(), page);
        model.addAttribute("childList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "ihm.woman.deathList";
    }

    /**
     * 孕产期保健服务与高危管理随访详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/motherhoodPeriodFollowupDetail")
    public String getMotherhoodPeriodFollowup(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        MotherhoodPeriodFollowup motherhoodPeriodFollowup = brwHealthService.getMotherhoodPeriodFollowup(criteria);
        if(ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowup)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("motherhoodPeriodFollowup", motherhoodPeriodFollowup);
        return "rhip.ehr.browser.motherhoodPeriodFollowup";
    }

    /**
     * 产前访视详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/prenatalVisit")
    public String getPrenatalFollowup(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        PrenatalFollowup prenatalFollowup = brwHealthService.getPrenatalFollowup(criteria);
        model.addAttribute("prenatalFollowup", prenatalFollowup);
        return "rhip.ehr.browser.prenatalFollowup";
    }

    /**
     * 分娩登记
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping("/delivery")
    public String getDeliveryRecordInfo(String personId, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("personId", personId);
        DeliveryRecordInfo deliveryRecordInfo = brwHealthService.getDeliveryRecordInfo(criteria);
        if(ObjectUtil.isNullOrEmpty(deliveryRecordInfo)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("deliveryRecordInfo", deliveryRecordInfo);
        return "rhip.ehr.browser.deliveryRecord";
    }

    /**
     * 产后42天健康检查信息
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping("/postpartum")
    public String postpartumDaysHealthInfo(String personId, ModelMap model,String type){
        Criteria criteria = new Criteria();
        criteria.add("id", personId);
        PostpartumDaysHealthInfo postpartumDaysHealthInfo = brwHealthService.getPostpartumDaysHealthInfo(criteria);
/*        String doctorNo = postpartumDaysHealthInfo.getSupervisionDoctor();
        Criteria criteriaDoc = new Criteria();
        criteriaDoc.add("staffCode",doctorNo);
        Staff staff = staffService.getStaff(criteriaDoc);
        postpartumDaysHealthInfo.setSupervisionDoctor(staff.getName());*/
        if(ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfo)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("postpartumDaysHealthInfo", postpartumDaysHealthInfo);
        if("dialogView".equals(type)){
            return "rhip.ehr.browser.postpartumDays1";
        }
        return "rhip.ehr.browser.postpartumDays";
    }


    /**
     * 统计 孕产妇保健
     * @return
     */
    @RequestMapping("/woman/maternal/summary")
    public String maternalSummary(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = new Page(0,0);
        model.addAttribute("searchUrl", "/ihm/woman/maternalSummary/list") ;
        return "ihm.woman.summary.search";
    }

    /**
     * 孕产妇保健计划(统计)
     * @return
     */
    @RequestMapping("/woman/maternalSummary/list")
    public String maternalSummary(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("indexPage"));
        Page page = super.getPage(request, currentPage);
        List<Map<String,Object>> plist = wchTargetService.getMotherhoodPeriodFollowupStatistics(form.getParamMap());
        List<Object> deliveryTypes = (List<Object>)plist.get(plist.size() - 1).get("diffWayChirdbirthNumMapKey");
        model.addAttribute("motherhoodPeriodFollowupList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        model.addAttribute("deliveryTypes", deliveryTypes);
        model.addAttribute("deliveryTypesLength", deliveryTypes.size());
        return "ihm.woman.summary";
    }

    /**
     * 查询 妇女疾病筛查，即妇女病普查
     * @return
     */
    @RequestMapping("/woman/womanDiseaseCensus/index")
    public String womanDiseaseCensus(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "7");
        return "ihm.woman.womanDiseaseCensusSearch";
    }

    /**
     * 妇女疾病筛查，即妇女病普查
     * @return
     */
    @RequestMapping("/woman/womanDiseaseCensus/list")
    public String womanDiseaseCensusList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<WomanDiseaseCensus> plist = wchSearchService.getWomanDiseaseCensusList(form.getParamMap(), page);
        model.addAttribute("womanDiseaseCensusList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.womanDiseaseCensusList";
    }

    /**
     * 查询 产后访视
     * @return
     */
    @RequestMapping("/woman/postnatalFollowup/index")
    public String postnatalFollowup(HttpServletRequest request, Model model) {
        initOrg(request, model);
//        boolean isAdmin = hasRole(RoleType.ADMIN, request) || hasRole(RoleType.FYBJS, request);
//        model.addAttribute("isAdmin",isAdmin);
        model.addAttribute("searchType", "8");
        return "ihm.woman.postnatalFollowupSearch";
    }

    /**
     * 产后访视
     * @return
     */
    @RequestMapping("/woman/postnatalFollowup/list")
    public String postnatalFollowupList(HttpServletRequest request, WChQueryForm form, Model model) {
        String curCode = getCurrentOrg(request).getOrganCode();
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
        List<String> orgCodes = this.getOrgCodeByOrgCode(request);
        PageList<PostnatalFollowup> plist = wchSearchService.getPostnatalFollowupList(flg,orgCodes,form.getParamMap(), page);
        model.addAttribute("curCode",curCode);
        model.addAttribute("postnatalFollowupList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ihm.woman.postnatalFollowupList";
    }

    /**
     * 儿童疫苗接种率
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/child/vaccination/index")
    public String maternalD11(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = new Page(0,0);
        model.addAttribute("searchUrl", "/ihm/child/vaccination/list") ;
        return "ihm.child.vaccinationSearch";
    }

    @RequestMapping("/child/vaccination/list")
    public String md12(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> resultList = wchTargetService.getChildVacc(form.getParamMap());
        model.addAttribute("genreCode",form.getGenreCode());
        model.addAttribute("vaccinationList", resultList);
        model.addAttribute("countNum", resultList.size() - 1);
        return "ihm.child.vaccination.list";
    }

    /**
     * 住院分娩率
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/maternal/hospitalDelivery/index")
    public String hostipalDelivery(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = new Page(0,0);
        model.addAttribute("searchUrl", "/ihm/maternal/hostipalDelivery/list") ;
        return "ihm.maternal.hospitalDeliverySearch";
    }

    /**
     * 住院分娩率数据
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/maternal/hostipalDelivery/list")
    public String hostipalDeliveryList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> resultList = wchTargetService.getHospitalDelivery(form.getParamMap());
        model.addAttribute("genreCode",form.getGenreCode());
        model.addAttribute("maternalDeathList", resultList);
        return "ihm.maternal.search.hospitalDeliveryList";
    }

    @RequestMapping("/child/mgnt3/index")
    public String maternalD1(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = new Page(0,0);

        model.addAttribute("searchUrl", "/ihm/child/mgnt3/list") ;
        return "ihm.child.mgnt3Search";
    }

    /**
     * 3岁以下儿童系统管理率
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/child/mgnt3/list")
    public String md2(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        String criteria = form.getMonthList();

        List<ChildUnderThreeManage> systemManageList = wchTargetService.getNewChildMgnt3(criteria,form.getGbCode());

        for(ChildUnderThreeManage childSystemManage : systemManageList){
            childSystemManage.setManagementRate(Math.round(childSystemManage.getManagementRate()*100)/100.0);
        }

        model.addAttribute("childmgnt3List", systemManageList);
        return "ihm.child.mgnt3.list";
    }

    @RequestMapping("/maternal/death/index")
    public String maternalD(HttpServletRequest request, Model model) {
        initOrg(request, model);
        Page page = new Page(0,0);
        model.addAttribute("searchUrl", "/ihm/maternal/death/list") ;
        return "ihm.maternal.deathSearch";
    }

    /**
     * 孕产妇死亡数据
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/maternal/death/list")
    public String md(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> resultList = wchTargetService.getNewMaternalDeath(form.getParamMap());
        model.addAttribute("genreCode",form.getGenreCode());
        model.addAttribute("maternalDeathList", resultList);
        return "ihm.maternal.search.deathList";
    }



}