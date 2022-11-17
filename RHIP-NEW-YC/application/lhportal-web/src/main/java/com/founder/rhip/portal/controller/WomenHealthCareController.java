package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.child.NeonatalDiseaseScreen;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.portal.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/womenHealthCare")
public class WomenHealthCareController extends BaseController {
    @Resource
    private IBrwHealthService brwHealthService;

    /**
     * 产前访视列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/prenatalFollowupList")
    public String getPrenatalFollowups(HttpServletRequest request, ModelMap model) {
    	if (!checkLoginStatus(request)) return "lhportal.info.login";
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        String[] properties = {"id", "visitDate"};
        List<PrenatalFollowup> prenatalFollowups = brwHealthService.getPrenatalFollowups(criteria, properties);
        if (ObjectUtil.isNullOrEmpty(prenatalFollowups)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("prenatalFollowups", prenatalFollowups);
        return "protal.ehr.prenatalFollowupList";
    }

    /**
     * 产前访视详细
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/prenatalFollowup")
    public String getPrenatalFollowup(String id, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        PrenatalFollowup prenatalFollowup = brwHealthService.getPrenatalFollowup(criteria);
        model.addAttribute("prenatalFollowup", prenatalFollowup);
        return "protal.ehr.prenatalFollowup";
    }

    /**
     * 产前筛查与诊断
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/prenatalScreenDiagnosisList")
    public String prenatalScreenDiagnosisList(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        criteria.add("isDelete", 0);
        String[] properties = {"id", "checkDate"};
        List<PrenatalScreenDiagnosis> penatalScreenDiagnosisList = brwHealthService.getPrenatalScreenDiagnosiList(criteria, properties);
        if (ObjectUtil.isNullOrEmpty(penatalScreenDiagnosisList)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("penatalScreenDiagnosisList", penatalScreenDiagnosisList);
        return "protal.ehr.penatalScreenDiagnosisList";
    }

    @RequestMapping("/prenatalScreenDiagnosis")
    public String prenatalScreenDiagnosis(Long id, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        PrenatalScreenDiagnosis prenatalScreenDiagnosis = brwHealthService.getPrenatalScreenDiagnosis(criteria);
        model.addAttribute("prenatalScreenDiagnosis", prenatalScreenDiagnosis);
        return "protal.ehr.penatalScreenDiagnosis";
    }

    /**
     * 新生儿家庭访视详细
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/neonatalFamilyVisitDetail")
    public String getNeonatalFamilyVisit(String id, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        NeonatalFamilyVisit neonatalFamilyVisit = brwHealthService.getNeonatalFamilyVisit(criteria);
        if (ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
        return "protal.ehr.neonatalFamilyVisit";
    }

    /**
     * 孕产期保健服务与高危管理随访详细
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/motherhoodPeriodFollowupDetail")
    public String getMotherhoodPeriodFollowup(String id, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        MotherhoodPeriodFollowup motherhoodPeriodFollowup = brwHealthService.getMotherhoodPeriodFollowup(criteria);
        if (ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowup)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("motherhoodPeriodFollowup", motherhoodPeriodFollowup);
        return "protal.ehr.motherhoodPeriodFollowup";
    }

    /**
     * 分娩登记
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/deliveryRecord")
    public String getDeliveryRecordInfo(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        DeliveryRecordInfo deliveryRecordInfo = brwHealthService.getDeliveryRecordInfo(criteria);
        if (ObjectUtil.isNullOrEmpty(deliveryRecordInfo)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("deliveryRecordInfo", deliveryRecordInfo);
        return "protal.ehr.deliveryRecord";
    }

    /**
     * 本人出生证明
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/ownBornDetail")
    public String getOwnBornDetail(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        BirthCertificate birthCertificate = brwHealthService.getChBirthCertificate(criteria);
        if (ObjectUtil.isNullOrEmpty(birthCertificate)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("chBirthCertificate", birthCertificate);

        if (ObjectUtil.isNotEmpty(birthCertificate)) {
            if (ObjectUtil.isNotEmpty(birthCertificate.getMotherIdcard())) {
                model.addAttribute("midCard", birthCertificate.getMotherIdcard().toCharArray());
            }
            if (ObjectUtil.isNotEmpty(birthCertificate.getFaterIdcard())) {
                model.addAttribute("fidCard", birthCertificate.getFaterIdcard().toCharArray());
            }
        }
        return "protal.ehr.ownBornDetail";
    }

    /**
     * 计划生育技术服务
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/birthController")
    public String getBirthControllerService(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        BirthControlService birthControlService = brwHealthService.getBirthControlService(criteria);
        if (ObjectUtil.isNullOrEmpty(birthControlService)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("birthControlService", birthControlService);
        return "protal.ehr.birthController";
    }

    /**
     * 产后访视列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/postnatalFollowupList")
    public String getPostnatalFollowups(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        String[] properties = {"id", "visitDate"};
        List<PostnatalFollowup> postnatalFollowups = brwHealthService.getPostnatalFollowups(criteria, properties);
        if (ObjectUtil.isNullOrEmpty(postnatalFollowups)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("postnatalFollowups", postnatalFollowups);
        return "protal.ehr.postnatalFollowupList";
    }

    /**
     * 产后访视详细
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/postnatalFollowup")
    public String getPostnatalFollowup(String id, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        PostnatalFollowup postnatalFollowup = brwHealthService.getPostnatalFollowup(criteria);
        model.addAttribute("postnatalFollowup", postnatalFollowup);
        return "protal.ehr.postnatalFollowup";
    }

    /**
     * 产后42天健康检查信息
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/postpartumDaysHealthInfo")
    public String postpartumDaysHealthInfo(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        PostpartumDaysHealthInfo postpartumDaysHealthInfo = brwHealthService.getPostpartumDaysHealthInfo(criteria);
        if (ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfo)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("postpartumDaysHealthInfo", postpartumDaysHealthInfo);
        return "protal.ehr.postpartumDays";
    }

    /**
     * 出生缺陷
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/bornDefect")
    public String bornDefect(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        BirthDefectMonitor birthDefectMonitor = brwHealthService.getBirthDefectMonitor(criteria);
        if (ObjectUtil.isNullOrEmpty(birthDefectMonitor)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("birthDefectMonitor", birthDefectMonitor);
        return "protal.ehr.birthDefect";
    }

    /**
     * 新生儿家庭访视时间列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/neonatalFamilyVisitList")
    public String getNeonatalFamilyVisitList(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        String[] properties = {"id", "visitDate"};
        List<NeonatalFamilyVisit> neonatalFamilyVisits = brwHealthService.getNeonatalFamilyVisits(criteria, properties);
        if (ObjectUtil.isNullOrEmpty(neonatalFamilyVisits)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("neonatalFamilyVisits", neonatalFamilyVisits);
        return "protal.ehr.neonatalFamilyVisitList";
    }

    /**
     * 新生儿疾病筛查
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/neonatalDiseaseScreen")
    public String getNeonatalDiseaseScreen(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        NeonatalDiseaseScreen neonatalDiseaseScreen = brwHealthService.getNeonatalDiseaseScreen(criteria);
        if (ObjectUtil.isNullOrEmpty(neonatalDiseaseScreen)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("neonatalDiseaseScreen", neonatalDiseaseScreen);
        return "protal.ehr.neonatalDiseaseScreen";
    }

    /**
     * 孕产期保健服务与高危管理随访 随访时间列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/motherhoodPeriodFollowupList")
    public String getMotherhoodPeriodFollowups(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        String[] properties = {"id", "checkDate"};
        List<MotherhoodPeriodFollowup> motherhoodPeriodFollowups = brwHealthService.getMotherhoodPeriodFollowups(criteria, properties);
        if (ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowups)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("motherhoodPeriodFollowups", motherhoodPeriodFollowups);
        return "protal.ehr.motherhoodPeriodFollowupList";
    }

    /**
     * 婚前保健服务
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/premaritalHealthService")
    public String getPremaritalHealthService(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        PremaritalHealthService premaritalHealthService = brwHealthService.getPremaritalHealthService(criteria);
        if (ObjectUtil.isNullOrEmpty(premaritalHealthService)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("premaritalHealthService", premaritalHealthService);
        return "protal.ehr.premaritalHealthService";
    }

    /**
     * 妇女病普查 检查时间 列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/womanDiseaseCensusList")
    public String getWomanDiseaseCensuses(HttpServletRequest request, ModelMap model) {
        Criteria criteria = new Criteria();
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
        criteria.add("personId", personInfo.getId());
        String[] properties = {"id", "checkDate"};
        List<WomanDiseaseCensus> womanDiseaseCensuses = brwHealthService.getWomanDiseaseCensuses(criteria, properties);
        if (ObjectUtil.isNullOrEmpty(womanDiseaseCensuses)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("womanDiseaseCensuses", womanDiseaseCensuses);
        return "protal.ehr.womanDiseaseCensusList";
    }

    /**
     * 妇女病普查 详细
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/womanDiseaseCensus")
    public String getWomanDiseaseCensus(String id, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("id", id);
        WomanDiseaseCensus womanDiseaseCensus = brwHealthService.getWomanDiseaseCensus(criteria);
        if (ObjectUtil.isNullOrEmpty(womanDiseaseCensus)) {
            return "lhportal.ehr.brwNoRecord";
        }
        model.addAttribute("womanDiseaseCensus", womanDiseaseCensus);
        return "protal.ehr.womanDiseaseCensus";
    }
}
