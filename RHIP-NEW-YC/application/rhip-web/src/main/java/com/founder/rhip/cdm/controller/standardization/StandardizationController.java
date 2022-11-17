package com.founder.rhip.cdm.controller.standardization;

import com.alibaba.fastjson.JSON;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.common.ManageCardErrorCode;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.ICdmPersonService;
import com.founder.rhip.cdm.service.IHealthPalnService;
import com.founder.rhip.cdm.service.IReportCardService;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.CdmManagerStatisticsDto;
import com.founder.rhip.ehr.dto.CdmManagerStatisticsVillageDto;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 管理卡和保健计划
 *
 * @author liuk
 */
@Controller
@RequestMapping("/cdm/standardization")
public class StandardizationController extends CdmBaseController {

    private final static String CONTROLLER_NAME = "慢病管理卡和保健计划";

    private static final String PLAN_CARD = "planCard";

    @Resource(name = "standardizationService")
    private IStandardizationService standardizationService;

    @Resource(name = "platformService")
    private IPlatformService platformService;

    @Resource(name = "cdmPersonService")
    private ICdmPersonService cdmPersonService;

    @Resource(name = "healthPalnService")
    private IHealthPalnService healthPalnService;

    @Resource(name = "excelExportService")
    private IExcelExportService excelExportService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

    @Resource(name = "uploadInfoRecordService")
    private IUploadInfoRecordService uploadInfoRecordService;

    @Resource(name = "reportCardService")
    private IReportCardService reportCardService;

    /**
     * 健康档案用慢病高血压糖尿病是否报卡检测
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/bkjc/{idcard}/{gxy}/{tnb}/{nzz}/{gxb}/{zl}")
    @ResponseBody
    public Map<String, Object> manageCardCheck(@PathVariable("idcard") String idcard,
                                               @PathVariable("gxy") boolean gxy,@PathVariable("tnb") boolean tnb,
                                               @PathVariable("nzz") boolean nzz,@PathVariable("gxb") boolean gxb,
                                               @PathVariable("zl") boolean zl, HttpServletRequest request, ModelMap model) {
        Map<String, Object> map = new HashMap<>();
        Criteria criteria = new Criteria("IDCARD",idcard);
        criteria.add(this.getHmCardDeleteStatus("",EHRConstants.DM_MANAGED_FLAG));
        DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);
        if(diseaseInfo==null){
            map.put("result", "1");
            map.put("diseaseInfo","0");
            return map;
        }
        String hbpFlag = diseaseInfo.getHbpFlag();
        String diFlag = diseaseInfo.getDiFlag();
        // 脑卒中
        String strokeFlag = diseaseInfo.getStrokeFlag();
        //冠心病
        String coronaryFlag = diseaseInfo.getCoronaryFlag();
        //肿瘤
        String tumorFlag = diseaseInfo.getTumorFlag();

        map.put("hbpFlag",hbpFlag);
        map.put("diFlag",diFlag);
        map.put("strokeFlag",strokeFlag);
        map.put("coronaryFlag",coronaryFlag);
        map.put("tumorFlag",tumorFlag);

        //判断未建高血压管理卡
        if(gxy&&!"2".equals(hbpFlag)){
            map.put("result", "1");
        }
        //判断未建糖尿病管理卡
        if(tnb&&!"2".equals(diFlag)){
            map.put("result", "1");
        }
        //判断未建脑卒中病管理卡
        if(nzz&&!"2".equals(strokeFlag)){
            map.put("result", "1");
        }
        //判断未建冠心病管理卡
        if(gxb&&!"2".equals(coronaryFlag)){
            map.put("result", "1");
        }
        //判断未建肿瘤病管理卡
        if(zl&&!"2".equals(tumorFlag)){
            map.put("result", "1");
        }
        //无需弹出管理卡
        if(map.get("result")==null) {
            map.put("result", "0");
            map.put("gxyFlag", false);
            map.put("tnbFlag", false);
            map.put("ncz", false);
            map.put("gxbFlag", false);
            map.put("zlFlag", false);

        }
        return map;
    }

    /**
     * 慢病健康管理卡列表页面
     *
     * @return
     */
    @RequestMapping(value = "/healthCard/list")
    public String healthCardListSearch(HttpServletRequest request, ModelMap model, String diseaseType, String isManagedFlag) {
        model.addAttribute("diseaseType" , diseaseType);
        model.addAttribute("isManagedFlag" , isManagedFlag);
        return "rhip.cdm.base.standardization.healthCard";
    }

    /**
     * 查询健康管理卡列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/healthCardList")
    public String manageCardRecord(QueryForm form, HttpServletRequest request, ModelMap model) {
        form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
        if(ObjectUtil.isNullOrEmpty(form.getDiseaseType())) {
            form.setDiseaseType("1,2,3,4,5");
        }
        Criteria criteria = form.toCriteria(true, EHRConstants.DM_MANAGED_FLAG);

		if(StringUtil.isNotEmpty(form.getGbcode()) && StringUtil.isEmpty(form.getCenterOrganCode())){
			List<String> orgCodes = this.getOrgCodeByGBCode(form.getGbcode());
			criteria.remove("dmPersonInfo.CREATE_GBCODE");
			criteria.add("dmDiseaseInfo.CREATE_ORGAN_CODE", OP.IN, orgCodes);
		}
        
        PageList<DmDiseaseInfo> list = standardizationService.getHmCardList(buildPage(request), criteria, getCurrentOrg(request), getRole(request));
        model.addAttribute("dmDiseaseInfoList", list.getList());
        return "rhip.cdm.base.standardization.diseaseResult";
    }

    
    /**
     * 新增管理卡获取人和管理卡信息
     *
     * @param idCard
     * @return
     */
    @RequestMapping("/load")
    @ResponseBody
    public Object load(@RequestParam("personInfo.idcard") String idCard, HttpServletRequest request) {
        PersonInfo personInfo = platformService.queryPersonalInfo(null, StringUtil.trimAllWhitespace(idCard));
        if (ObjectUtil.isNullOrEmpty(personInfo)) {
            return null;
        }
        //未建档
        if (ObjectUtil.isNotEmpty(personInfo) && !("1".equals(personInfo.getFilingFlag()) || "5".equals(personInfo.getFilingFlag()))) {
            return null;
        }
        if (ObjectUtil.isNotEmpty(personInfo)) {
            getPersonAddress(personInfo);
        }
        if (ObjectUtil.isNotEmpty(personInfo)) {
            getPersonAddress(personInfo);
        }
        Map<String, Object> record = new Record(personInfo);
        Date birthday = setBirthday(personInfo);
        if (ObjectUtil.isNotEmpty(birthday)) {
            SimpleDateFormat df = new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN);
            record.put("birthdayStr", df.format(birthday));
        }

        //检查疾病
        boolean[] dmManagedFlag = standardizationService.getPersonDmManagedFlag(personInfo);
        record.put("dmManagedFlag", dmManagedFlag);

        //检查人员
        Map<String, String> managedOrgMap = new HashMap<>();
        Set<String> personManagedFlag = standardizationService.checkToManagedPerson(getCurrentOrg(request).getOrganCode(), personInfo,managedOrgMap);
        record.put("personManagedFlag", personManagedFlag);
        if(ObjectUtil.isNotEmpty(managedOrgMap)){
            record.put("managedByOtherOrg", managedOrgMap.get("isManagedByOtherOrg"));
        }
        return record;
    }

    /**
     * 打开管理卡增加页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/input")
    public String input(ModelMap modelMap, HttpServletRequest request) {
        DmDiseaseInfo diseaseInfo = new DmDiseaseInfo();
        diseaseInfo.setDiType("2");
        String personIdStr=request.getParameter("personId");//HNYC-457【慢病管理】新增慢病管理卡报数据异常
        if(StringUtil.isNotEmpty(personIdStr)){
            Long personId = Long.valueOf(personIdStr);
            PersonInfo personInfo = platformService.queryPersonalInfo(personId);
            diseaseInfo.setPersonInfo(personInfo);
        }
        diseaseInfo.setTumorManagedFlag(EHRConstants.DM_SC_MANAGED_FLAG_YES);
        diseaseInfo.setStrokeManagedFlag(EHRConstants.DM_SC_MANAGED_FLAG_YES);
        diseaseInfo.setCoronaryManagedFlag(EHRConstants.DM_SC_MANAGED_FLAG_YES);
        diseaseInfo.setStrokeManagedFayFlag(EHRConstants.DM_MANAGED_FULL_ONE_YEAR_FLAG_YES);
        diseaseInfo.setCoronaryManagedFayFlag(EHRConstants.DM_MANAGED_FULL_ONE_YEAR_FLAG_YES);
        String gxyDateStr = request.getParameter("gxyDate"); // 高血压日期
        String tnbDateStr = request.getParameter("tnbDate"); // 糖尿病日期
        String exzlDateStr = request.getParameter("exzlDate"); // 肿瘤日期
        String gxbDateStr = request.getParameter("gxbDate"); // 冠心病日期
        String nzzDateStr = request.getParameter("nzzDate"); // 脑卒中日期
        
        Date gxyDate = null,tnbDate = null, gxbDate = null, nzzDate = null, exzlDate = null;
        if(StringUtil.isNotEmpty(gxyDateStr)) {
            gxyDate = DateUtil.parseSimpleDate(gxyDateStr,"yyyy/MM/dd");
        }
        if(StringUtil.isNotEmpty(tnbDateStr)) {
            tnbDate = DateUtil.parseSimpleDate(tnbDateStr,"yyyy/MM/dd");
        }
        if(StringUtil.isNotEmpty(exzlDateStr)) {
            exzlDate = DateUtil.parseSimpleDate(exzlDateStr,"yyyy/MM/dd");
        }
        if(StringUtil.isNotEmpty(gxbDateStr)) {
        	gxbDate = DateUtil.parseSimpleDate(gxbDateStr,"yyyy/MM/dd");
        }
        if(StringUtil.isNotEmpty(nzzDateStr)) {
        	nzzDate = DateUtil.parseSimpleDate(nzzDateStr,"yyyy/MM/dd");
        }
        diseaseInfo.setHbpDiagnosedDate(gxyDate);
        diseaseInfo.setDiDiagnosedDate(tnbDate);
        diseaseInfo.setTumorDiagnosisDate(exzlDate);
        diseaseInfo.setCoronaryDiagnosisDate(gxbDate);
        diseaseInfo.setStrokeDiagnosisDate(nzzDate);
        diseaseInfo.setTumorType(request.getParameter("exzlName"));//肿瘤名称
        modelMap.put("diseaseInfo", diseaseInfo);
        String personRecordFlag = request.getParameter("personRecordFlag");
        String diFlag = request.getParameter("diFlag");
        String hbpFlag = request.getParameter("hbpFlag");
        modelMap.put("diFlag", diFlag);
        modelMap.put("hbpFlag", hbpFlag);
        modelMap.put("strokeFlag", request.getParameter("strokeFlag"));
        modelMap.put("coronaryFlag", request.getParameter("coronaryFlag"));
        modelMap.put("tumorFlag", request.getParameter("tumorFlag"));
        modelMap.put("personRecordFlag", personRecordFlag);

        //婚姻
        String hy = request.getParameter("hy");
        //民族
        String mz = request.getParameter("mz");
        //少数民族
        String othermz = request.getParameter("othermz");
        //职业
        String zhiye = request.getParameter("zhiye");
        //职业
        String whcd = request.getParameter("whcd");
        //工作单位
        String unitName = request.getParameter("unitName");
        //判断是否从健康档案-基本信息中跳出慢病管理
        String judge = request.getParameter("judge");
        if(StringUtil.isNotEmpty(judge)){
            modelMap.put("judge",judge);
        }else {
            modelMap.put("judge",0);
        }
        modelMap.put("hy",hy);
        modelMap.put("mz",mz);
        modelMap.put("othermz",othermz);
        modelMap.put("zhiye",zhiye);
        modelMap.put("whcd",whcd);
        modelMap.put("unitName",unitName);
        return "rhip.cdm.base.standardization.add";
    }

    /**
     * 增加管理卡
     *
     * @param diseaseInfo
     * @param request
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(DmDiseaseInfo diseaseInfo, HttpServletRequest request) {
        setCurrentUserInfoToDis(diseaseInfo, request);
        //高血压附件
        Map<String, Object> map =new HashMap<>();
        Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");
        map = validateAttchement(map, linkMapGxy, diseaseInfo.getId(), true);
        if(ObjectUtil.isNotEmpty(map)) {
            return map;
        }
        map =new HashMap<>();
        //糖尿病附件
        Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");
        map = validateAttchement(map, linkMapTnb, diseaseInfo.getId(), true);
        if(ObjectUtil.isNotEmpty(map)) {
            return map;
        }
        Map<String, String> managedOrgMap = new HashMap<>();
        Set<String> result = standardizationService.addManage(diseaseInfo, linkMapGxy, linkMapTnb, getCurrentUser(request).getName(),managedOrgMap);
        if(ObjectUtil.isNotEmpty(managedOrgMap)) {
            return managedOrgMap;
        }
        if (ObjectUtil.isNullOrEmpty(result)) {
            record(request, BaseController.OperationName.ADD);
        }
        removeSessionFile(true, request, linkMapGxy, linkMapTnb);
        return result;
    }

    /**
     * 修改管理卡
     *
     * @param diseaseInfo
     * @param request
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(DmDiseaseInfo diseaseInfo, HttpServletRequest request) {
        setCurrentUserInfoToDis(diseaseInfo, request);
        Map<String, Object> map =new HashMap<>();
        Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件
        map = validateAttchement(map, linkMapGxy, diseaseInfo.getId(), true);
        if(ObjectUtil.isNotEmpty(map)) {
            return map;
        }
        map =new HashMap<>();
        Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件
        map = validateAttchement(map, linkMapTnb, diseaseInfo.getId(), true);
        if(ObjectUtil.isNotEmpty(map)) {
            return map;
        }
        boolean result = standardizationService.saveHmCard(diseaseInfo, linkMapGxy, linkMapTnb, getCurrentUser(request).getName());
        //logger.error("====保存管理卡StandardizationController save 168 " + (System.currentTimeMillis() - end));
        removeSessionFile(result, request, linkMapGxy, linkMapTnb);
        if (result) {
            //end = System.currentTimeMillis();
            record(request, BaseController.OperationName.UPDATE);
            //logger.error("====保存管理卡日志StandardizationController save 172 " + (System.currentTimeMillis() - end));
            return "success";
        }
        return "error";
    }

    /**
     * 清理高血压糖尿病相关的附件
     * @param result
     * @param request
     * @param linkMapGxy
     * @param linkMapTnb
     */
    private void removeSessionFile(boolean result, HttpServletRequest request,
                                   Map<String, String> linkMapGxy, Map<String, String> linkMapTnb) {
        // 保存成功清理session
        if(result && ObjectUtil.isNotEmpty(linkMapGxy)) {
            request.getSession().removeAttribute("mbglkgxy_fileMap");
        }
        // 保存成功清理session
        if(result && ObjectUtil.isNotEmpty(linkMapTnb)) {
            request.getSession().removeAttribute("mbglktnb_fileMap");
        }
    }
    /**
     * 查看管理卡
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, String isShow,  ModelMap model) {
        Criteria criteria = new Criteria("id", id);
        model.put("isShow", isShow);
        DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);
        if (ObjectUtil.isNotEmpty(diseaseInfo)) {
            PersonInfo personInfo = diseaseInfo.getPersonInfo();
            // 当查看管理卡时,如果此人没有生日,则计算出默认值
            setBirthday(personInfo);
            model.put("personInfo", personInfo);
            model.put("diseaseInfo", diseaseInfo);
            Long personId = diseaseInfo.getPersonId();
            if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
                PersonalBasicInfoDTO personalBasicInfo = cdmPersonService.getPersonBasicInfo(personId);
                model.put("personBasicInfoDto", personalBasicInfo);
                PhysiqueExamination physiqueExamination = cdmPersonService.getPersonPhyExamination(personId);
                model.put("physiqueExamination", physiqueExamination);
            } else if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
                PhysiqueExamination physiqueExamination = cdmPersonService.getPersonPhyExamination(personId);
                model.put("physiqueExamination", physiqueExamination);
            }
            String reportIdJson = diseaseInfo.getReportInfoId();
            List<UploadInfoRecord> uploadInfoRecordsHbp = null;
            List<UploadInfoRecord> uploadInfoRecordsDi = null;
            if(ObjectUtil.isNotEmpty(reportIdJson)) {
                Map<String,String> map = JSON.parseObject(reportIdJson,Map.class);
                if(ObjectUtil.isNotEmpty(map.get(EHRConstants.HBP))) {
                    String hbpTemp =  map.get(EHRConstants.HBP);
                    String hbpArr[] = hbpTemp.split(",");
                    uploadInfoRecordsHbp = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", OP.IN, hbpArr).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKGXY));
                    uploadInfoRecordsHbp.addAll(uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", diseaseInfo.getId()).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBGLKGXY)));
                }
                if(ObjectUtil.isNotEmpty(map.get(EHRConstants.DI))) {
                    String diTemp = map.get(EHRConstants.DI);
                    String diArr[] = diTemp.split(",");
                    uploadInfoRecordsDi = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",OP.IN,  map.get(EHRConstants.DI)).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKTNB));
                    uploadInfoRecordsDi.addAll(uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",diseaseInfo.getId()).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBGLKTNB)));
                }
            }
            model.addAttribute("attchesHbp", uploadInfoRecordsHbp);
            model.addAttribute("attchesDi", uploadInfoRecordsDi);
        }
        return "rhip.cdm.base.standardization.view";
    }

    /**
     * 选择撤销管理卡的慢病类型
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/rollback/selected/type")
    public String assign(Integer id, HttpServletRequest request, ModelMap model){
        DmDiseaseInfo dmDiseaseInfo = standardizationService.getHmCard(new Criteria("id", id));
        model.addAttribute("dmDiseaseInfo", dmDiseaseInfo);
        return "rhip.cdm.base.standardization.rollback.selected.type";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(DmDiseaseInfo dmDiseaseInfo, HttpServletRequest request) {
        boolean result = true;
        try {
            standardizationService.deleteHmCardBySelectedType(dmDiseaseInfo, getCurrentOrg(request), getCurrentUser(request));
            record(request, BaseController.OperationName.DELETE);
        } catch (Exception e) {
            result = false;
            logger.error("管理卡删除失败", e);
        }
        return result;
    }

    @RequestMapping("/view/personBasicAndExam")
    public String viewPersonBasicAndExamination(@RequestParam("personId") Long personId, ModelMap model) {
        // TODO
        PersonalBasicInfoDTO personalBasicInfo = cdmPersonService.getPersonBasicInfo(personId);
        model.put("personalBasicInfo", personalBasicInfo);
        PhysiqueExamination physiqueExamination = cdmPersonService.getPersonPhyExamination(personId);
        model.put("physiqueExamination", physiqueExamination);
        return "rhip.cdm.base.standardization.view";
    }

    /**
     * 检查报卡
     *
     * @param personId
     * @param request
     * @return
     */
    @RequestMapping("/checkReport")
    @ResponseBody
    public Object checkReport(@RequestParam("personId") Long personId, HttpServletRequest request) {
        Set<String> result = standardizationService.checkReport(personId, getCurrentOrg(request).getOrganCode());
        return result;
    }

    /**
     * 纳入管理卡,将报卡数据转换为管理卡数据
     *
     * @param personId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/manage")
    public String manage(@RequestParam("personId") Long personId, ModelMap model, HttpServletRequest request) {
        Set<String> result = standardizationService.checkReport(personId, getCurrentOrg(request).getOrganCode());
        if (result.size() > 0) {
            return EHRMessageUtil.returnMsg(model, result);
        }
        DmDiseaseInfo diseaseInfo = standardizationService.convertReportToDiseaseInfo(personId, getCurrentOrg(request));
        if (null == diseaseInfo) {
            result.add(ManageCardErrorCode.COVERT_TO_DIS_ERROR.getValue());
            return EHRMessageUtil.returnMsg(model, result);
        }
        String reportJson = diseaseInfo.getReportInfoId();
        Map<String,Long> map = JSON.parseObject(reportJson,Map.class);
        List<UploadInfoRecord> uploadInfoRecordsHbp = null;
        List<UploadInfoRecord> uploadInfoRecordsDi = null;
        if(!map.isEmpty()) {
            uploadInfoRecordsHbp = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", map.get(EHRConstants.HBP)).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKGXY));
            uploadInfoRecordsDi = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", map.get(EHRConstants.DI)).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKTNB));
        }
        /*if(ObjectUtil.isNotEmpty(uploadInfoRecordsHbp)) { // 高血压标志
            diseaseInfo.setHbpOtherDiagnosisOrganFlag("2");
        }
        if(ObjectUtil.isNotEmpty(uploadInfoRecordsDi)) { // 糖尿病
            diseaseInfo.setDiOtherDiagnosisOrganFlag("2");
        }*/
        model.addAttribute("attchesHbp", uploadInfoRecordsHbp);
        model.addAttribute("attchesDi", uploadInfoRecordsDi);

        model.put("diseaseInfo", diseaseInfo);
        model.put("personInfo", diseaseInfo.getPersonInfo());
        model.put("hbpReportId",map.get(EHRConstants.HBP)); // 高血压上报id(dm_report_info的ID，用于在纳入管理的时候附件保存和查询)
        model.put("diReportId",map.get(EHRConstants.DI)); // 糖尿病上报ID同上
        return "rhip.cdm.base.standardization.input";
    }

    /**
     * 执行纳入管理卡
     *
     * @param diseaseInfo
     * @return
     */
    @RequestMapping("/doManage")
    @ResponseBody
    public Object doManage(DmDiseaseInfo diseaseInfo, HttpServletRequest request) {
        setCurrentUserInfoToDis(diseaseInfo, request);
        // 获取附件的report_id
        String hbpReportId = request.getParameter("hbpReportId"); // 高血压上报资源ID
        String diReportId = request.getParameter("diReportId"); // 糖尿病上报资源ID
        // 附件上传
        Map<String, Object> map =new HashMap<>();
        Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件数量验证
        map = validateAttchement(map, linkMapGxy, diseaseInfo.getId(), true);
        if(ObjectUtil.isNotEmpty(map)) {
            return map;
        }
        map =new HashMap<>();
        Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件数量验证
        map = validateAttchement(map, linkMapTnb, diseaseInfo.getId(), true);
        if(ObjectUtil.isNotEmpty(map)) {
            return map;
        }

        //Long end = System.currentTimeMillis();
        Map<String, String> managedOrgMap =new HashMap<>();
        Set<String> result = standardizationService.bringIntoManage(diseaseInfo,hbpReportId,diReportId,linkMapGxy,linkMapTnb,managedOrgMap);
        //logger.error("====纳入管理卡StandardizationController save 168 " + (System.currentTimeMillis() - end));
        if (ObjectUtil.isNullOrEmpty(result)) {
            //end = System.currentTimeMillis();
            record(request, BaseController.OperationName.ADD);
            //logger.error("====纳入管理卡日志StandardizationController save 168 " + (System.currentTimeMillis() - end));
        }
        return result;
    }

    /**
     * 慢病保健计划列表页面
     *
     * @return
     */
    @RequestMapping(value = "/healthPlan/list")
    public String healthPlanListSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.cdm.base.standardization.healthPlan";
    }

    /**
     * 慢病撤销查看列表页面
     *
     * @return
     */
    @RequestMapping(value = "/cancel/list")
    public String cancelListSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.cdm.base.standardization.cancel";
    }

    /**
     * 查询保健计划列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/planList")
    public String planRecord(HttpServletRequest request, ModelMap model) {
        PageList<DmHypertensionConclusion> list = healthPalnService.getHealthPlanList(buildPage(request), searchParameter(request, PLAN_CARD));
        model.addAttribute("dmPlanList", list.getList());
        return "rhip.cdm.base.standardization.planResult";
    }

    private Criteria searchParameter(HttpServletRequest request, String card) {
        Criteria criteria = new Criteria();
        criteria.add("name", request.getParameter("personName"));
        criteria.add("idcard", request.getParameter("idCard"));
        criteria.add("gender", request.getParameter("genderCode"));
        Date[] ageList = DateUtil.getDateRangeByAge(request.getParameter("beginAge"), request.getParameter("endAge"));
        if (!ObjectUtil.isNullOrEmpty(ageList[0]))
            criteria.add("beginAge", ageList[0]);
        if (!ObjectUtil.isNullOrEmpty(ageList[1]))
            criteria.add("endAge", ageList[1]);
        if (!ObjectUtil.isNullOrEmpty(request.getParameter("disType")))
            criteria.add("diseaseType", request.getParameter("disType"));
        if (card == "manageCard")
            criteria.add("flag", 2);// 已经管理
        if (card == "planCard") {
            if (!ObjectUtil.isNullOrEmpty(request.getParameter("planStatus"))) {
                criteria.add("planStatus", request.getParameter("planStatus"));
            }
            Organization organization = getCurrentOrg(request);
            RoleType roleType = getRole(request);
            if (RoleType.ZMB.equals(roleType)) {
                criteria.add("createOrganCode", organization.getOrganCode());
            } else if (RoleType.ZXMB.equals(roleType)) {
                criteria.add("createCenterOrganCode", organization.getOrganCode());
            }
            if (ObjectUtil.isNotEmpty(request.getParameter("stationOrganCode"))) {
                criteria.add("createOrganCode", request.getParameter("stationOrganCode"));
            } else if (ObjectUtil.isNotEmpty(request.getParameter("centerOrganCode"))) {
                criteria.add("createCenterOrganCode", request.getParameter("centerOrganCode"));
            } else if (ObjectUtil.isNotEmpty(request.getParameter("gbcode"))) {
                criteria.add("createGbcode", request.getParameter("gbcode"));

            }
        }
        if (card == "cancelCard")
            criteria.add("flag", 3);// 注销
        return criteria;
    }

    @RequestMapping("/healthPlan/{personId}")
    public String healthPlan(@PathVariable("personId") Long id, ModelMap model, HttpServletRequest request) {
        DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(new Criteria("id", id));
        Assert.notNull(diseaseInfo, "无法查找慢病信息");
        //PersonInfo personInfo = diseaseInfo.getPersonInfo();
        //2018-02-11 jiang_haiying 保健计划的基本信息取自健康档案
        PersonInfo personInfo = platformService.queryPersonalInfo(diseaseInfo.getPersonId());
        model.put("personInfo", personInfo);
        model.put("diseaseInfo", diseaseInfo);
        return "rhip.cdm.base.standardization.planInfoTab";
    }

    @RequestMapping("/healthPlan/singlePlanList")
    public String singlePlanList(@RequestParam("personId") Long personId, @RequestParam("type") Long type, ModelMap model, HttpServletRequest request) {
        Criteria criteria = new Criteria();
        criteria.add("DM_HYPERTENSION_CONCLUSION.PERSON_ID", personId);
        criteria.add("DM_HYPERTENSION_CONCLUSION.DISEASE_TYPE", type);
        List<DmHypertensionConclusion> list = healthPalnService.getDmHypertensionConclusions(criteria);
        model.addAttribute("singlePlanList", list);
        return "rhip.cdm.base.standardization.planSingleInfoList";
    }

    /**
     * 查询年度列表
     *
     * @param personId 健康档案主键
     * @param model
     * @return
     */
    @RequestMapping("/inputPlanList")
    public String inputPlanList(String personId, ModelMap model) {
        List<DMFollowupPlan> dmPlanInfoList = healthPalnService.queryDmFollowupPlanList(new Criteria("personId", Long.valueOf(personId)).add("disType", OP.IN, new String[]{"1", "2"}), new Order(
                "planYear desc"));
        model.addAttribute("dmPlanInfoList", dmPlanInfoList);
        return "rhip.cdm.base.standardization.inputPlanList";
    }

    /**
     * 查询保健计划显示TAB
     *
     * @param personId 健康档案主键
     * @param model
     * @return
     */
    @RequestMapping("/inputPlanInfoTab")
    public String inputPlanInfoTab(@RequestParam("personId") Long personId, ModelMap model, HttpServletRequest request) {
        Criteria ca = new Criteria();
        ca.add("DM_DISEASE_INFO.PERSON_ID", personId);
        ca.add("DM_PERSON_INFO.TYPE", 2);// 已管理人员数据。
        DmDiseaseInfo dmDiseaseInfo = standardizationService.queryDmDiseaseInfo(personId);
        List<DmHypertensionConclusion> listConclusion = new ArrayList<DmHypertensionConclusion>();
        if (EHRConstants.DM_MANAGED_FLAG.equals(dmDiseaseInfo.getHbpFlag())) {
            DmHypertensionConclusion dmHypertensionConclusion = new DmHypertensionConclusion();
            createConclusionEntity(dmHypertensionConclusion, dmDiseaseInfo);
            dmHypertensionConclusion.setDiseaseType("1");
            dmHypertensionConclusion.setCreateDoctorCode(getCurrentUser(request).getUserCode().toString());
            dmHypertensionConclusion.setCreateOrganCode(getCurrentOrg(request).getOrganCode().toString());
            listConclusion.add(dmHypertensionConclusion);
        }
        if (EHRConstants.DM_MANAGED_FLAG.equals(dmDiseaseInfo.getDiFlag())) {
            DmHypertensionConclusion dmHypertensionConclusion1 = new DmHypertensionConclusion();
            createConclusionEntity(dmHypertensionConclusion1, dmDiseaseInfo);
            dmHypertensionConclusion1.setDiseaseType("2");
            dmHypertensionConclusion1.setCreateDoctorCode(getCurrentUser(request).getUserCode().toString());
            dmHypertensionConclusion1.setCreateOrganCode(getCurrentOrg(request).getOrganCode().toString());
            listConclusion.add(dmHypertensionConclusion1);
        }
        model.addAttribute("planInfoList", listConclusion);
        return "rhip.cdm.base.standardization.inputPlanInfoTab";
    }

    /**
     * 查询计划随访列表
     *
     * @param personId 健康档案主键
     * @param model
     * @return
     */
    @RequestMapping("/inputPlanFollowupList")
    public String inputPlanFollowupList(String personId, String planYear, ModelMap model) {
        Criteria criteria = new Criteria();
        criteria.add("personId", personId);
        criteria.add("planYear", planYear);
        criteria.add("disType", OP.IN, new String[]{"1", "2"});
        List<DMFollowupPlan> list = healthPalnService.searchDmFollowupPlanList(criteria, new Order("DIS_TYPE,PLAN_DATE"));
        model.addAttribute("dmPlanFollowupList", list);
        return "rhip.cdm.base.standardization.inputPlanFollowupList";
    }

    /**
     * 新增高血压
     *
     * @param personId 健康档案主键
     * @param model
     * @return
     */
    @RequestMapping("/inputHbpPlanForm")
    public String inputHbpPlanForm(@RequestParam("personId") Long personId, ModelMap model, HttpServletRequest request) {
        Criteria ca = new Criteria();
        ca.add("DM_DISEASE_INFO.PERSON_ID", personId);
        ca.add("DM_PERSON_INFO.TYPE", 2);// 已管理人员数据。
        DmDiseaseInfo dmDiseaseInfo = standardizationService.queryDmDiseaseInfo(personId);
        DmHypertensionConclusion dmHypertensionConclusion = new DmHypertensionConclusion();
        if (EHRConstants.DM_MANAGED_FLAG.equals(dmDiseaseInfo.getHbpFlag())) {
            createConclusionEntity(dmHypertensionConclusion, dmDiseaseInfo);
            dmHypertensionConclusion.setDiseaseType("1");
            dmHypertensionConclusion.setSbp(dmDiseaseInfo.getHbpSbp());
            dmHypertensionConclusion.setDbp(dmDiseaseInfo.getHbpDbp());
            dmHypertensionConclusion.setCreateDoctorCode(getCurrentUser(request).getUserCode().toString());
            dmHypertensionConclusion.setCreateOrganCode(getCurrentOrg(request).getOrganCode().toString());
        }
        model.addAttribute("planInfo", dmHypertensionConclusion);
        return "rhip.cdm.base.standardization.inputHbpPlanForm";
    }

    /**
     * 新增糖尿病
     *
     * @return
     */
    @RequestMapping("/inputDiPlanForm")
    public String inputDiPlanForm(@RequestParam("personId") Long personId, ModelMap model, HttpServletRequest request) {
        Criteria ca = new Criteria();
        ca.add("DM_DISEASE_INFO.PERSON_ID", personId);
        ca.add("DM_PERSON_INFO.TYPE", 2);// 已管理人员数据。
        DmDiseaseInfo dmDiseaseInfo = standardizationService.queryDmDiseaseInfo(personId);
        DmHypertensionConclusion dmHypertensionConclusion1 = new DmHypertensionConclusion();
        if (EHRConstants.DM_MANAGED_FLAG.equals(dmDiseaseInfo.getDiFlag())) {
            createConclusionEntity(dmHypertensionConclusion1, dmDiseaseInfo);
            dmHypertensionConclusion1.setDiseaseType("2");
            dmHypertensionConclusion1.setCreateDoctorCode(getCurrentUser(request).getUserCode().toString());
            dmHypertensionConclusion1.setCreateOrganCode(getCurrentOrg(request).getOrganCode().toString());
        }
        model.addAttribute("planInfo", dmHypertensionConclusion1);
        return "rhip.cdm.base.standardization.inputDiPlanForm";
    }

    /**
     * 保存保健计划
     *
     * @param dmHypertensionConclusion 保健计划表单实体hiddenPersonNameHbphiddenPersonNameHbp
     * @param request
     * @return
     */
    @RequestMapping("/insertPlanInfo")
    public
    @ResponseBody
    String insertPlanInfo(DmHypertensionConclusion dmHypertensionConclusion, HttpServletRequest request) {
        record(request, BaseController.OperationName.ADD);
        dmHypertensionConclusion.setCreateDoctorCode(getCurrentUser(request).getUserCode().toString());
        dmHypertensionConclusion.setCreateDoctorName(getCurrentUser(request).getName());
        dmHypertensionConclusion.setCreateOrganCode(getCurrentOrg(request).getOrganCode().toString());
        dmHypertensionConclusion.setCreateOrganName(getCurrentOrg(request).getOrganName());
        try {
            return healthPalnService.saveHealthPlan(dmHypertensionConclusion);
        } catch (Exception e) {
            logger.error("创建或修改保健计划失败", e);
            return "failure";
        }
    }

    /**
     * 点击保健计划界面左侧列表查询并且赋值
     *
     * @param id    保健计划主键
     * @param model
     * @return
     */
    @RequestMapping("/searchPlanInfo")
    public String searchPlanInfo(String id, String openStatus, ModelMap model) {
        Criteria ca = new Criteria();
        ca.add("DM_HYPERTENSION_CONCLUSION.ID", id);
        ca.add("DM_PERSON_INFO.TYPE", 2);// 已管理人员数据。
        List<DmHypertensionConclusion> planInfoList = healthPalnService.getHealthPlanDetailList(ca);
        if (!ObjectUtil.isNullOrEmpty(planInfoList)) {
            model.addAttribute("planInfo", planInfoList.get(0));
            if (planInfoList.get(0).getDiseaseType().equals("1")) {
                // 给checkBox绑赋属性
                if (!ObjectUtil.isNullOrEmpty(planInfoList.get(0).getCvdElement())) {
                    String[] cvdElementArr = planInfoList.get(0).getCvdElement().split(",");
                    for (int i = 0; i < cvdElementArr.length; i++) {
                        model.addAttribute("cvdElementArr" + cvdElementArr[i], true);
                    }
                }
                if (!ObjectUtil.isNullOrEmpty(planInfoList.get(0).getTrDamage())) {
                    String[] trDamageArr = planInfoList.get(0).getTrDamage().split(",");
                    for (int i = 0; i < trDamageArr.length; i++) {
                        model.addAttribute("trDamageArr" + trDamageArr[i], true);
                    }
                }
                if (!ObjectUtil.isNullOrEmpty(planInfoList.get(0).getRelatedDiseases())) {
                    String[] relatedDiseasesArr = planInfoList.get(0).getRelatedDiseases().split(",");
                    for (int i = 0; i < relatedDiseasesArr.length; i++) {
                        model.addAttribute("relatedDiseasesArr" + relatedDiseasesArr[i], true);
                    }
                }
                if (!ObjectUtil.isNullOrEmpty(openStatus) && openStatus.equals("view")) {
                    return "rhip.cdm.base.standardization.inputHbpPlanViewForm";
                } else {
                    return "rhip.cdm.base.standardization.inputHbpPlanForm";
                }
            } else if (planInfoList.get(0).getDiseaseType().equals("2")) {
                if (!ObjectUtil.isNullOrEmpty(openStatus) && openStatus.equals("view")) {
                    return "rhip.cdm.base.standardization.inputDiPlanViewForm";
                } else {
                    return "rhip.cdm.base.standardization.inputDiPlanForm";
                }
            }
        }
        return null;

    }

    /**
     * 查询撤销列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/cancelList")
    public String getCancelList(QueryForm form, HttpServletRequest request, ModelMap model) {
        model.addAttribute("deleteOrCancel", form.getDeleteOrCancel());
        Criteria criteria;
        // 增加查看已经删除的管理卡,如果不指定或者指定查看已注销,则查看已经注销,否则,查看已经删除的报卡
        if (ObjectUtil.isNullOrEmpty(form.getDeleteOrCancel()) || QueryForm.VIEW_CANCEL.equals(form.getDeleteOrCancel())) {
            form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_CANCEL);
            criteria = form.toCriteria(true, EHRConstants.DM_MANAGED_FLAG.toString());
        } else {
            form.setDiseaseStatus(null);
            criteria = form.toCriteria(true, EHRConstants.DELETE_FLG_1.toString());
        }
        PageList<DmDiseaseInfo> list = standardizationService.getHmCardList(buildPage(request), criteria, getCurrentOrg(request), getRole(request));
        model.addAttribute("dmDiseaseInfoList", list.getList());
        return "rhip.cdm.base.standardization.cancelResult";
    }

    /**
     * 选恢复管理卡的慢病类型
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/renew/selected/type")
    public String renewSelectType(Integer id, HttpServletRequest request, ModelMap model){
        DmDiseaseInfo dmDiseaseInfo = standardizationService.getHmCard(new Criteria("id", id));
        model.addAttribute("dmDiseaseInfo", dmDiseaseInfo);
        return "rhip.cdm.base.standardization.renew.selected.type";
    }

    @RequestMapping("/renew")
    @ResponseBody
    public boolean renewHmCard(DmDiseaseInfo dmDiseaseInfo, HttpServletRequest request) {
        boolean result = true;
        try {
            standardizationService.renewHmCardBySelectedType(dmDiseaseInfo, getCurrentOrg(request), getCurrentUser(request));
            record(request, BaseController.OperationName.UPDATE);
        } catch (Exception e) {
            result = false;
            logger.error("管理卡恢复失败", e);
        }
        return result;
    }


    /**
     * 删除保健计划
     *
     * @param personId    the person id
     * @param id          the id
     * @param diseaseType the disease type
     * @param healthPlan  the health plan
     * @param model       the model
     * @return the string
     */
    @RequestMapping("/deletePlan")
    @ResponseBody
    public String deletePlan(@RequestParam(value = "personId", required = false) Long personId, @RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "diseaseType", required = false) Long diseaseType, DmHypertensionConclusion healthPlan, ModelMap model) {
        healthPlan.setId(id);
        healthPlan.setPersonId(personId);
        healthPlan.setDiseaseType(diseaseType.toString());
        String result = null;
        try {
            healthPalnService.deleteHealthPlan(healthPlan);
            result = "success";
        } catch (Exception e) {
            logger.error("保健计划删除失败", e);
            result = "failure";
        }
        return result;
    }


    private void createConclusionEntity(DmHypertensionConclusion entity, DmDiseaseInfo dmDiseaseInfo) {
        entity.setHbpFlag(dmDiseaseInfo.getHbpFlag());
        entity.setDiFlag(dmDiseaseInfo.getDiFlag());
        entity.setDiDiagnosedOrganCode(dmDiseaseInfo.getDiDiagnosedOrganCode());
        entity.setDiDiagnosedDate(dmDiseaseInfo.getDiDiagnosedDate());
        entity.setDiType(dmDiseaseInfo.getDiType());
        entity.setName(dmDiseaseInfo.getName());
        entity.setIdcard(dmDiseaseInfo.getIdcard());
        entity.setPersonId(dmDiseaseInfo.getPersonId());
        entity.setCreateDate(new Date());
        entity.setConclusionsOfYear(DateUtil.getCurrentYear());
        entity.setId(null);
    }

    private void setCurrentUserInfoToDis(DmDiseaseInfo diseaseInfo, HttpServletRequest request) {
        if (ObjectUtil.isNotEmpty(diseaseInfo)) {
            diseaseInfo.setCurrentUser(getCurrentUser(request));
            diseaseInfo.setCurrentOrganization(getCurrentOrg(request));
        }
    }


    @Override
    protected String getActionName() {
        return CONTROLLER_NAME;
    }

    /**
     * 查询健康管理卡列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/excel")
    public void exportManageCard(QueryForm form, boolean isCancel, HttpServletRequest request, ModelMap model, HttpServletResponse response) throws UnsupportedEncodingException {

        if (ObjectUtil.isNotEmpty(form.getName())) {
            //中文乱码
            form.setName(new String(form.getName().getBytes("ISO-8859-1"), "UTF-8"));
        }

        String title = "";
        if (isCancel) {
            // 增加查看已经删除的管理卡,如果不指定或者指定查看已注销,则查看已经注销,否则,查看已经删除的报卡
            if (ObjectUtil.isNullOrEmpty(form.getDeleteOrCancel()) || QueryForm.VIEW_CANCEL.equals(form.getDeleteOrCancel())) {
                form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_CANCEL);
                title = "慢病管理卡-已注销";
            } else {
                form.setDiseaseStatus(null);
                title = "慢病管理卡-已删除";
            }
        } else {
            form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
            title = "慢病管理卡";
        }
        final Criteria criteria = form.toCriteria(false, EHRConstants.DM_MANAGED_FLAG);

        try {
            String disType = form.getDiseaseType();
            final RoleType roleType = getRole(request);
            final Organization organization = getCurrentOrg(request);
            excelExportService.exportListExecl(title, ManageCardExportRef.class, response, new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    List<Map<String, Object>> dataSource = standardizationService.exportManageCard(page, criteria, organization, roleType);
                    return dataSource;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("导出失败", e);
        }
    }

    @RequestMapping(value="/statistics/search")
    public String searchStarStatistics(HttpServletRequest request, ModelMap model) {
        model.addAttribute("beginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("endDate", DateUtil.lastDateOfMonth(new Date()));
        return "rhip.cdm.statistics.manager.search";
    }

    /**
     * 慢病纳入-工作量统计
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/statistics/list")
    public String getStarStatistics(HttpServletRequest request, ModelMap model, ReportQueryForm form) {
        setRoleCondition(request, form);
        Organization currentOrg = this.getCurrentOrg(request);
        PageList<Map<String, Object>> managerMapList = standardizationService.getMangerIntoStatistics(buildPage(request), form, currentOrg);
        model.addAttribute("managerMapList", managerMapList.getList());
        model.addAttribute("searchType", form.getSearchType());
        return "rhip.cdm.statistics.manager.list";
    }

    private void setRoleCondition(HttpServletRequest request, ReportQueryForm form) {
        Organization currentOrg = this.getCurrentOrg(request);
        if(ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.HOSPITAL.getValue())
                || ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ) {
            form.setCentreCode(currentOrg.getOrganCode());

        } else if(ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.STATION.getValue())) {
            form.setStationCode(currentOrg.getOrganCode());
        }

    }

    @RequestMapping("/statistics/export")
    public void exportStarStatistics(HttpServletRequest request, HttpServletResponse response, ReportQueryForm form) {
        setRoleCondition(request, form);
        final ReportQueryForm reportQueryForm = form;
        final Organization currentOrg = this.getCurrentOrg(request);
        if(ObjectUtil.equals("2", form.getSearchType())) {
            excelExportService.exportListExecl("慢病纳入统计", CdmManagerStatisticsVillageDto.class, response, new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    return standardizationService.exportMangerIntoStatistics(page, reportQueryForm, currentOrg);
                }
            });
        } else {
            excelExportService.exportListExecl("慢病纳入统计", CdmManagerStatisticsDto.class, response, new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    return standardizationService.exportMangerIntoStatistics(page, reportQueryForm, currentOrg);
                }
            });
        }
    }

    /**
     * 管理卡是否撤消的查询条件
     * @param alias
     * @param isDelete
     * @return
     */
    private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
        Criteria criteria = new Criteria();
        criteria.add(alias + "hbp_flag", isDelete);
        criteria.add(LOP.OR, alias + "di_flag", isDelete);
        criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
        criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
        criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
        return criteria;
    }
}
