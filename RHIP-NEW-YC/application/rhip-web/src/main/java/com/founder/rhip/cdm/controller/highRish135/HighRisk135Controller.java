package com.founder.rhip.cdm.controller.highRish135;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IHighRisk135Service;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.healtheducation.HealthPrescription;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.he.service.IHealthPrescriptionService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by jingqiu on 17-4-13.
 */
@Controller
@RequestMapping("/cdm/highRisk135")
public class HighRisk135Controller extends CdmBaseController {

    /** EChart series */
    protected static final String SERIES_JSON = "seriesJSON";
    /** EChart legend */
    protected static final String LEGEND_JSON = "legendJSON";
    /** EChart xAxis */
    protected static final String XAXIS_JSON = "xAxisJSON";
    protected static final String YAXIS_JSON = "yAxisJSON";

    @Resource
    private IHighRisk135Service highRisk135Service;


    @Resource(name = "healthPrescriptionService")
    private IHealthPrescriptionService healthPrescriptionService;

    /**
     * 筛查标准页面
     * @param model
     * @return
     */
    @RequestMapping("/standard")
    public String standard(Model model) {
        List<Dm135Standard> standards = highRisk135Service.getStandards();
        for (Dm135Standard standard : standards) {
            if (standard.getSetStandardFlag() == 1) {
                model.addAttribute("attp", standard);
            } else {
                model.addAttribute("gb", standard);
            }
        }
        return "rhip.cdm.highRisk135.standard";
    }

    /**
     * 问卷调查查询页面
     * @param model
     * @return
     */
    @RequestMapping("/question/search")
    public String questionSearch(Model model) {
        return "rhip.cdm.highRisk135.question.search";
    }

    @RequestMapping("/question/list")
    public String questionList(HttpServletRequest request, QuestionForm questionForm, int indexPage, Model model) {
        Criteria criteria = questionForm.toCriteria();
        Page page = getPage(request, indexPage);
        addRoleCriteria(criteria, "mgUnit", request);
        PageList<Dm135Mgmt> pageList = highRisk135Service.getPagedMgmtList(page, criteria);
        model.addAttribute("questionList", pageList.getList());
        model.addAttribute("page", page);
        return "rhip.cdm.highRisk135.question.questionList";
    }

    /**
     * 首次问卷调查
     * @param meNumber
     * @param model
     * @return
     */
    @RequestMapping("/question/edit")
    public String questionEdit(String idNo, String meNumber, Model model) {
        Criteria criteriaQu = new Criteria();
        Criteria criteriaMg = new Criteria();

//        if(ObjectUtil.isNotEmpty(idNo)) {
//            criteriaQu.add("id_no", idNo);
//            criteriaMg.add("id_no", idNo);
//        }
        if(ObjectUtil.isNotEmpty(meNumber)) {
            criteriaQu.add("PHYSICAL_EXAM_NO", meNumber);
            criteriaMg.add("me_Number", meNumber);
        }
        if (ObjectUtil.isNotEmpty(meNumber)) {
            Dm135Question question = highRisk135Service.getQuestion(criteriaQu);
            model.addAttribute("question", question);
            Dm135Mgmt dm = highRisk135Service.getMgmt(criteriaMg);
            model.addAttribute("dm", dm);
            int abc = 1;
            if(ObjectUtil.isNullOrEmpty(question)){
                abc = 2;
            }
            model.addAttribute("abc", abc);
            model.addAttribute("type", "1");
        }
        return "rhip.cdm.highRisk135.question.editQuestion";
    }

    /**
     * 其他问卷调查
     * @param meNumber
     * @param model
     * @return
     */
    @RequestMapping("/otherQuestions/list")
    public String otherQuestionEdit(HttpServletRequest request,String meNumber, Integer type, Model model) {
        Page page = getPage(request, 1);
        if (ObjectUtil.isNotEmpty(meNumber)) {
            PageList<Dm135LastQuestion> questions = highRisk135Service.getLastQuestionList(new Criteria("PHYSICAL_EXAM_NO", meNumber), page);
            if(ObjectUtil.isNullOrEmpty(questions.getList())){
                model.addAttribute("num", 0);
                model.addAttribute("meNumber",meNumber);
                return "redirect:/cdm/highRisk135/otherQuestion/newEdit";
            }else {
                model.addAttribute("questions", questions.getList());
                model.addAttribute("num", 1);
                model.addAttribute("meNumber",meNumber);
                return "rhip.cdm.highRisk135.question.otherQuestion";
            }
        }else {
            model.addAttribute("meNumber", meNumber);
            return "redirect:/cdm/highRisk135/otherQuestion/newEdit";
        }
    }

    /**
     * 其他问卷调查详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/otherQuestion/edit")
    public String otherQuestionDetail(HttpServletRequest request,String id, Model model) {

        Dm135LastQuestion question = highRisk135Service.getLastQuestion(new Criteria("id", id));
        model.addAttribute("question", question);
        Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("me_Number", question.getPhysicalExamNo()));
        model.addAttribute("dm", dm);
        int abc=2;
        model.addAttribute("abc", abc);
        return "rhip.cdm.highRisk135.question.editLastQuestion";
       /* }*/
    }

    /**
     * 新建其他档案
     * @param meNumber
     * @param model
     * @return
     */
    @RequestMapping("/otherQuestion/newEdit")
    public String questionNewDetail(String meNumber, Model model) {
        Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("me_Number", meNumber));
        int abc=1;
        model.addAttribute("dm", dm);
        model.addAttribute("abc", abc);
        return "rhip.cdm.highRisk135.question.editLastQuestion";
       /* }*/
    }


    /**
     * 保存问卷调查
     * @param question
     * @return
     */
    @RequestMapping("/question/saveFirst")
    @ResponseBody
    public ModelMap questionSave(Dm135Question question) {
        ModelMap modelMap = new ModelMap();
        try {
            highRisk135Service.saveQuestion(question);
            Dm135Mgmt dm135Mgmt = highRisk135Service.getMgmt(new Criteria("ID_NO",question.getIdcard()));
            if(ObjectUtil.isNotEmpty(dm135Mgmt)) {
                dm135Mgmt.setDoneQuestion(1);
                highRisk135Service.updateMgmtCover(dm135Mgmt);
            }
            modelMap.put("success", true);
        } catch (Exception e) {
            logger.error(e);
            modelMap.put("success", false);
            modelMap.put("message", e.getMessage());
            throw new RuntimeException("保存首次調查問卷异常。", e);
        }
        return modelMap;
    }

    /**
     * 保存末次问卷调查
     * @param question
     * @return
     */
    @RequestMapping("/question/saveLast")
    @ResponseBody
    public ModelMap questionSave(Dm135LastQuestion question) {
        ModelMap modelMap = new ModelMap();
        try {
            highRisk135Service.saveLastQuestion(question);
            modelMap.put("success", true);
        } catch (Exception e) {
            logger.error(e.getMessage());
            modelMap.put("success", false);
            modelMap.put("message", e.getMessage());
            throw new RuntimeException("保存末次調查問卷异常。", e);
        }
        return modelMap;
    }

    /**
     * 删除问卷
     * @param id
     * @param type
     * @return
     */
    @RequestMapping("/question/delete")
    @ResponseBody
    public ModelMap questionDelete(String id, Integer type) {
        ModelMap modelMap = new ModelMap();
        try {
            if (type == 1) {
                highRisk135Service.deleteQuestion(id);
            } else {
                highRisk135Service.deleteLastQuestion(id);
            }
            modelMap.put("success", true);
        } catch (Exception e) {
            logger.error(e);
            modelMap.put("success", false);
            modelMap.put("message", e.getMessage());
        }
        return modelMap;
    }

    /**
     * 管理卡首页查询
     * @return
     */
    @RequestMapping("/mgmt/search")
    public String mgmtSearch() {
        return "rhip.cdm.highRisk135.mgmt.search";
    }

    /**
     * 管理卡列表
     * @param request
     * @param form
     * @param indexPage
     * @param model
     * @return
     */
    @RequestMapping("/mgmt/list")
    public String mgmtList(HttpServletRequest request, MgmtForm form, int indexPage, Model model) {
        Criteria criteria = form.toCriteria();
        criteria.add("DONE_QUESTION",1);
        Page page = getPage(request, indexPage);
        addRoleCriteria(criteria, "mgUnit", request);
        PageList<Dm135Mgmt> pageList = highRisk135Service.getPagedMgmtList(page, criteria);
        model.addAttribute("mgmtList", pageList.getList());
        model.addAttribute("page", page);
        return "rhip.cdm.highRisk135.mgmt.list";
    }

    /**
     * 筛查结果查询
     * @param request
     * @param indexPage
     * @param model
     * @return
     */
    @RequestMapping("/filterResult/search")
    public String standardResultsearch(HttpServletRequest request, int indexPage, Model model) {
        return "rhip.cdm.highRisk135.filterResult.search";
    }
    /**
     * 筛查结果列表
     * @param request
     * @param indexPage
     * @param model
     * @return
     */
    @RequestMapping("/filterResult/list")
    public String standardList(standardRestltForm form, HttpServletRequest request, int indexPage, Model model) {
        Criteria criteria = form.toCriteria();
        criteria.add("POPU_FLAG", OP.UEMPTY,null);
        Page page = getPage(request, indexPage);
        addRoleCriteria(criteria, "belongUnit", request);
        PageList<Dm135ManageCardTemp> pageList = highRisk135Service.getManageCardTempList(page, criteria);
        model.addAttribute("mgmtList", pageList.getList());
        model.addAttribute("page", page);
        return "rhip.cdm.highRisk135.filterResult.list";
    }

    /**
     * 管理卡纳入
     * @param request
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/mgmt/takeIn")
    public String mgmtTakeIn(HttpServletRequest request, String id, Model model) {
        Dm135Mgmt mgmt = highRisk135Service.getMgmt(new Criteria("id", id));
        List<Dm135Standard> standards = highRisk135Service.getStandards();
        model.addAttribute("mgmt", mgmt);
        for (Dm135Standard standard : standards) {
            if (standard.getSetStandardFlag().equals(mgmt.getFilterType())) {
                model.addAttribute("standard", standard);
                break;
            }
        }
        if (ObjectUtil.isNullOrEmpty(mgmt.getMgUnit())) {
            Organization org = getCurrentOrg(request);
            mgmt.setMgUnit(org.getOrganCode());
            mgmt.setMgUnitName(org.getOrganName());
        }
        if(ObjectUtil.isNullOrEmpty(mgmt.getMgDate())) {
            mgmt.setMgDate(new Date());
        }
        return "rhip.cdm.highRisk135.mgmt.editCover";
    }

    /**
     * 保存管理卡首页
     * @param mgmt
     * @return
     */
    @RequestMapping("/mgmt/saveCover")
    @ResponseBody
    public ModelMap mgmtSaveCover(Dm135Mgmt mgmt, HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();
        try {
            //纳入操作
            if(ObjectUtil.isNullOrEmpty(mgmt.getMgmtFlag()) || mgmt.getMgmtFlag() == 2) {
                mgmt.setMgmtFlag(1);
                mgmt.setCreateDate(new Date());
                mgmt.setCreateUnit(this.getCurrentOrg(request).getOrganCode());
                mgmt.setCreator(this.getCurrentUser(request).getId().intValue());
            }
            highRisk135Service.saveMgmtCover(mgmt);
            modelMap.put("success", true);
        } catch (Exception e) {
            logger.error(e);
            modelMap.put("success", false);
            modelMap.put("message", e.getMessage());
        }
        return modelMap;
    }


    /**
     * 随访首页查询
     * @return
     */
    @RequestMapping("/visit/search")
    public String visitSearch() {
        return "rhip.cdm.highRisk135.visit.search";
    }

    /**
     * 随访列表
     * @param request
     * @param form
     * @param indexPage
     * @param model
     * @return
     */
    @RequestMapping("/visit/list")
    public String visitList(HttpServletRequest request, MgmtForm form, int indexPage, Model model) {
        Criteria criteria = form.toCriteria();
        criteria.add("DONE_QUESTION",1);
        criteria.add("MGMT_FLAG",1);
        Page page = getPage(request, indexPage);
        addRoleCriteria(criteria, "mgUnit", request);
        PageList<Dm135Mgmt> pageList = highRisk135Service.getPagedMgmtList(page, criteria);
        model.addAttribute("mgmtList", pageList.getList());
        model.addAttribute("page", page);
        return "rhip.cdm.highRisk135.visit.list";
    }

    /**
     * 随访主页面
     * @param request
     * @param idNo
     * @param model
     * @return
     */
    @RequestMapping("/followup/main")
    public String followupMain(HttpServletRequest request, String idNo, Model model) {
        List<Dm135Followup> followupList = highRisk135Service.getFollowupList(new Criteria("idNo", idNo));
        Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("ID_NO", idNo));
        model.addAttribute("dm", dm);
        model.addAttribute("followups", followupList);
        model.addAttribute("idcard", idNo);
        model.addAttribute("today", new Date());
        return "rhip.cdm.highRisk135.followup.main";
    }

    /**
     * 随访编辑页面
     * @param request
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/followup/edit")
    public String followupEdit(HttpServletRequest request, String id, Model model) {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(id)) {
            criteria.add("id", id);
        }
        Dm135Followup followup = highRisk135Service.getFollowup(criteria);
        model.addAttribute("followup", followup);
        return "rhip.cdm.highRisk135.followup.editFollowup";
    }

    /**
     * 随访保存
     * @param followup
     * @return
     */
    @RequestMapping("/followup/save")
    @ResponseBody
    public ModelMap followupSave(Dm135Followup followup) {
        ModelMap modelMap = new ModelMap();
        try {
            highRisk135Service.saveFollowup(followup);
            modelMap.put("success", true);
        } catch (Exception e) {
            logger.error(e);
            modelMap.put("success", false);
            modelMap.put("message", e.getMessage());
        }
        return modelMap;
    }

    /**
     * 评价首页查询
     * @return
     */
    @RequestMapping("/evaluate/search")
    public String evaluateSearch() {
        return "rhip.cdm.highRisk135.evaluate.search";
    }

    /**
     * 评价列表
     * @param request
     * @param form
     * @param indexPage
     * @param model
     * @return
     */
    @RequestMapping("/evaluate/list")
    public String evaluateList(HttpServletRequest request, MgmtForm form, int indexPage, Model model) {
        Criteria criteria = form.toCriteria();
        Page page = getPage(request, indexPage);
        addRoleCriteria(criteria, "mgUnit", request);
        PageList<Dm135Mgmt> pageList = highRisk135Service.getDm135MgmtsFinishedFollow(page, criteria);
        model.addAttribute("mgmtList", pageList.getList());
        model.addAttribute("page", page);
        return "rhip.cdm.highRisk135.evaluate.list";
    }
    /**
     * 评价详细列表
     * @param request
     * @param
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/evaluate/editEvaluateList")
    public String editEvaluateList(HttpServletRequest request,String idNo, Model model) {
        Page page = getPage(request, 1);
        PageList<Dm135Appraise> evaluates = highRisk135Service.getDm315AppraiseList(new Criteria("id_NO", idNo), page);
        Boolean isCanAppraise = highRisk135Service.isCanAppraise(idNo);
        model.addAttribute("evaluates",evaluates.getList());
        model.addAttribute("idNo",idNo);
        model.addAttribute("isCanAppraise",isCanAppraise);
        return "rhip.cdm.highRisk135.evaluate.editEvaluateList";
    }

    /**
     * 填写评价详细
     * @param request
     * @param
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/evaluate/editEvaluate")
    public String editEvaluate(HttpServletRequest request,String id,String idNo, Model model) {
        String url = "rhip.cdm.highRisk135.evaluate.editEvaluate";
        Dm135Appraise evaluate = highRisk135Service.getDm315Appraise(new Criteria("id", id));
        Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("ID_NO", idNo));

        if(ObjectUtil.isNotEmpty(evaluate) && evaluate.getIsOld().equals(1)){
            url = "rhip.cdm.highRisk135.evaluate.oldEditEvaluate";
        } else if (ObjectUtil.isNullOrEmpty(evaluate)){
            evaluate = new Dm135Appraise();
            evaluate.setCreateDate(new Date());
            evaluate.setCreateUnit(this.getCurrentOrg(request).getOrganCode());
            evaluate.setCreator(this.getCurrentUser(request).getId().intValue());
        }
        model.addAttribute("evaluate",evaluate);
        model.addAttribute("dm",dm);
        return url;
    }


    /**
     * 保存评价
     * @param appraise
     * @return
     */
    @RequestMapping("/evaluate/save")
    @ResponseBody
    public ModelMap evaluateSave(Dm135Appraise appraise, HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();
        try {
            highRisk135Service.saveEvaluate(appraise);
            Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("ID_NO",appraise.getIdNo()));
            dm.setAppraiseResult(appraise.getAppraiseResult());
            highRisk135Service.updateMgmtCover(dm);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("message", e.getMessage());
            throw new RuntimeException("保存慢病135高危评价。", e);
        }
        return modelMap;
    }
/**
  *如果有高血压或者糖尿病就出现管理卡页面
  *
  * */
    @RequestMapping("/evaluate/saveNext")
    public String evaluateSaveNext(Dm135Appraise appraise, HttpServletRequest request, Model model) {
            highRisk135Service.saveEvaluate(appraise);
            Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("ID_NO",appraise.getIdNo()));
            dm.setAppraiseResult(appraise.getAppraiseResult());
            highRisk135Service.updateMgmtCover(dm);
                String str = appraise.getDiagnosesDiseases();
                String[] s = str.split(",");
                String hbpFlag = "1";
                String diFlag = "1";
                if(Arrays.asList(s).contains("1")){
                    hbpFlag = "2";
                }
                if(Arrays.asList(s).contains("1")){
                    diFlag = "2";
                }
                DmDiseaseInfo diseaseInfo = new DmDiseaseInfo();
                diseaseInfo.setDiType("2");
                diseaseInfo.setTumorManagedFlag(EHRConstants.DM_SC_MANAGED_FLAG_YES);
                diseaseInfo.setStrokeManagedFlag(EHRConstants.DM_SC_MANAGED_FLAG_YES);
                diseaseInfo.setCoronaryManagedFlag(EHRConstants.DM_SC_MANAGED_FLAG_YES);
                diseaseInfo.setStrokeManagedFayFlag(EHRConstants.DM_MANAGED_FULL_ONE_YEAR_FLAG_YES);
                diseaseInfo.setCoronaryManagedFayFlag(EHRConstants.DM_MANAGED_FULL_ONE_YEAR_FLAG_YES);
                diseaseInfo.setDiFlag(diFlag);
                diseaseInfo.setHbpFlag(hbpFlag);
                PersonInfo person = new PersonInfo();
                person.setIdcard(dm.getIdNo());
                person.setName(dm.getName());
                diseaseInfo.setPersonInfo(person);
                model.addAttribute("diseaseInfo", diseaseInfo);
                model.addAttribute("personInfo",  person);
                return "rhip.cdm.base.standardization.add";


    }

    /**
     * 新建评价详细
     * @param request
     * @param
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/evaluate/newEdit")
    public String newEvaluate(HttpServletRequest request,String idNo, Model model) {
        Dm135Mgmt dm = highRisk135Service.getMgmt(new Criteria("ID_NO",idNo));
        Dm135Appraise evaluate = new Dm135Appraise();
        model.addAttribute("dm",dm);
        evaluate.setCreateDate(new Date());
        evaluate.setCreateUnit(this.getCurrentOrg(request).getOrganCode());
        evaluate.setCreator(this.getCurrentUser(request).getId().intValue());
        model.addAttribute("evaluate",evaluate);

            return "rhip.cdm.highRisk135.evaluate.editEvaluate";
        }

    @RequestMapping("/print/edit")
    public String printEdit(String printType, ModelMap model) {

        Criteria criteria = new Criteria("type", printType);
        criteria.add("templet_flag", "1");
        HealthPrescription healthPrescription = healthPrescriptionService.getHealthPrescription(criteria);
        model.addAttribute("healthPrescription", healthPrescription);

        return "rhip.cdm.highRisk135.print.edit";
    }

    private void buildLineData(List<Map<String, Object>> series, List<Map<String, Object>> followupList, String field, String targetName) {
        List<String> seriesDatas = new ArrayList<>();
        for (Map<String, Object> followup : followupList) {
            String reportVal = "0";
            Object reportObj = followup.get(field);
            if (ObjectUtil.isNotEmpty(reportObj)) {
                reportVal = reportObj.toString();
            }
            seriesDatas.add(reportVal);
        }
        Map<String,Object> seriesMap = addSeries(targetName,"line",seriesDatas);
        addMakeLine("最大值","max",seriesMap);
        addMakeLine("最小值","min",seriesMap);
        series.add(seriesMap);
    }

    private void buildLineData(List<Map<String, Object>> series, List<Map<String, Object>> followupList, String field, String targetName, Integer yAxisIndex) {
        List<String> seriesDatas = new ArrayList<>();
        for (Map<String, Object> followup : followupList) {
            String reportVal = "0";
            Object reportObj = followup.get(field);
            if (ObjectUtil.isNotEmpty(reportObj)) {
                reportVal = reportObj.toString();
            }
            seriesDatas.add(reportVal);
        }
        Map<String,Object> seriesMap = addSeries(targetName,"line", yAxisIndex,seriesDatas);
        addMakeLine("最大值","max",seriesMap);
        addMakeLine("最小值","min",seriesMap);
        series.add(seriesMap);
    }

    private Map<String,Object> addSeries(String name,String type,List<String> seriesDataList){
        Map<String,Object> seriesMap = new HashMap<>();
        seriesMap.put("name",name);
        seriesMap.put("type",type);
        seriesMap.put("data",seriesDataList.toArray(new String[seriesDataList.size()]));
        return seriesMap;
    }

    private Map<String,Object> addSeries(String name,String type,Integer yAxisIndex,List<String> seriesDataList){
        Map<String, Object> seriesMap = addSeries(name, type, seriesDataList);
        seriesMap.put("yAxisIndex",yAxisIndex);
        return seriesMap;
    }

    private void addMakeLine(String name,String type,Map<String,Object> seriesMap){
        Map<String,List<Map<String,Object>>> makeLineMap = (Map<String,List<Map<String,Object>>>)seriesMap.get("markLine");
        if(ObjectUtil.isNullOrEmpty(makeLineMap)){
            makeLineMap = new HashMap<>();
        }
        List<Map<String,Object>> makeLineList = makeLineMap.get("data");
        if(ObjectUtil.isNullOrEmpty(makeLineList)){
            makeLineList = new ArrayList<>();
        }
        Map<String,Object> makeLineData = new HashMap<>();
        makeLineData.put("type",type);
        makeLineData.put("name",name);
        makeLineList.add(makeLineData);

        makeLineMap.remove("data");
        makeLineMap.put("data",makeLineList);

        seriesMap.remove("markLine");
        seriesMap.put("markLine",makeLineMap);
    }

    private  Map<String,Object> addYAxis(String name,String unit){
        Map<String,Object> yAxisMap = new HashMap<>();
        yAxisMap.put("name",name);
        yAxisMap.put("type","value");
        Map<String,Object> axisLabelMap = new HashMap<>();
        axisLabelMap.put("formatter","{value}");
        yAxisMap.put("axisLabel",axisLabelMap);
        return  yAxisMap;
    }
}
