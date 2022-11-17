package com.founder.rhip.idm.controller.tb;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.idm.TbQueryDto;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.common.TbStatus;
import com.founder.rhip.idm.controller.form.TbQueryForm;
import com.founder.rhip.idm.service.ITbService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  结核病统计
 */
@Controller
@RequestMapping("/idm/tb/statistics")
public class TbStatisticsController extends BaseController {

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name = "tbService")
    private ITbService tbService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "ehrSecurityService")
    private IEhrSecurityService ehrSecurityService;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 筛查登记列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/suspect/list")
    public String searchSuspectList(TbQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = getSuspectCriteria(form, request);

        PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);

        model.addAttribute("suspectList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.tb.statistics.suspectList";
    }
    /**
     * 转诊列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/transfer/list")
    public String searchTransferList(TbQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        Page page = super.getPage(request,  pageIndex);

        Criteria criteria = getTransferCriteria(form, request);

        PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);
        model.addAttribute("transferList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.tb.statistics.transferList";
    }



    /**
     *
     *下载转诊
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downTransferExcel")
    @ResponseBody
    public void downTransferExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/tbTransfer.xls"));

            Criteria criteria = getTransferCriteria(form, request);

            List<TbQueryDto> transferList = tbService.getTbList(criteria, null);
            int totalRows = 7;
            int beginRowIndex = 5;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line,transferList.size());
            for (TbQueryDto transfer : transferList) {
                List<Object> objects = getTransferExcelValues(transfer, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, " 转诊列表.xls");
            excel.save(response.getOutputStream());

            transferList.clear();
            transferList = null;
        } catch (Exception e) {
            log.error("下载《转诊列表》出错", e);
            throw e;
        }
    }

    /**
     * 生成转诊EXCEL一行数据
     *
     * @param transfer
     * @param lineNumber
     * @return
     */
    private List<Object> getTransferExcelValues(TbQueryDto transfer, int lineNumber) {
        String patownShip = dictionaryApp.queryDicItemName("FS990001", transfer.getPatownShip());//详细地址
        String pastreet = dictionaryApp.queryDicItemName("FS990001", transfer.getPastreet());
        String pahouseNumber = transfer.getPahouseNumber();

        String transferTreatmentDoctor ="";
        User user = null;
        String userId = transfer.getTransferTreatmentDoctor();
        if(StringUtil.isNotEmpty(userId)){
            //user = ehrSecurityService.getUser(NumberUtil.convert(userId, Long.class));
            user = ehrSecurityService.getUser(new Criteria("userCode",userId));
        }
        if(ObjectUtil.isNotEmpty(user)){
            transferTreatmentDoctor = user.getName();
        }

        List<Object> line = new ArrayList<Object>();
        line.add(lineNumber);
        line.add(transfer.getName());
        line.add(dictionaryApp.queryDicItemName("GBT226112003", transfer.getGender()));
        line.add(transfer.getAge());
        line.add(patownShip + pastreet + pahouseNumber);
        line.add(transfer.getPhoneNumber());
        if(StringUtil.isNotEmpty(transfer.getDiagnosisReason())){
            String diagnosisReason = transfer.getDiagnosisReason();
            String diagnosisReasonStr[] = diagnosisReason.split(",");
            String diagnosisReasonValue = "";
            for(int i = 0 ; i < diagnosisReasonStr.length; i++){
                diagnosisReasonValue = diagnosisReasonValue + dictionaryApp.queryDicItemName("IDM00218", diagnosisReasonStr[i]) + ",";
            }
            line.add(diagnosisReasonValue.substring(0, diagnosisReasonValue.length() - 1));
        }else {
            line.add("");
        }

        line.add(transferTreatmentDoctor);
        line.add(DateUtil.getDateTime("yyyy/MM/dd", transfer.getTransferTreatmentDt()));
        line.add("");
        return line;
    }

    /**
     *
     *下载筛查登记
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downSuspectExcel")
    @ResponseBody
    public void downSuspectExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/suspect.xls"));
            Criteria criteria = getSuspectCriteria(form, request);
		    /*获取唯一事件编码*/
            this.getEventId(criteria, SpecialEvents.T_RECOMMENDATION.getValue(), SpecialEvents.T_REGISTER.getValue());
            List<TbQueryDto> suspectList = tbService.getTbList(criteria, null);
            int totalRows = 7;
            int beginRowIndex = 5;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line, suspectList.size());
            for (TbQueryDto suspect : suspectList) {
                List<Object> objects = getSuspectExcelValues(suspect, line + 1);
                excel.writeLineWithFormat(objects, line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, "肺结核可疑症状者筛查登记本.xls");
            excel.save(response.getOutputStream());

            suspectList.clear();
            suspectList = null;
        } catch (Exception e) {
            log.error("下载《肺结核可疑症状者筛查登记本》出错", e);
            throw e;
        }
    }


    /**
     * 生成筛查登记EXCEL一行数据
     *
     * @param suspect
     * @param lineNumber
     * @return
     */
    private List<Object> getSuspectExcelValues(TbQueryDto suspect, int lineNumber) {
        String patownShip = dictionaryApp.queryDicItemName("FS990001", suspect.getPatownShip());//详细地址
        String pastreet = dictionaryApp.queryDicItemName("FS990001", suspect.getPastreet());
        String pahouseNumber = suspect.getPahouseNumber();

        String transferTreatmentDoctor ="";
        User user = null;
        String userId = suspect.getTransferTreatmentDoctor();
        if(StringUtil.isNotEmpty(userId)){
            //user = ehrSecurityService.getUser(NumberUtil.convert(userId, Long.class));
            user = ehrSecurityService.getUser(new Criteria("userCode",userId));
        }
        if(ObjectUtil.isNotEmpty(user)){
            transferTreatmentDoctor = user.getName();
        }

        List<Object> line = new ArrayList<Object>();
        line.add(lineNumber);
        line.add(DateUtil.getDateTime("yyyy/MM/dd", suspect.getModifySurveyDate()));
        line.add(suspect.getName());
        line.add(dictionaryApp.queryDicItemName("GBT226112003", suspect.getGender()));
        line.add(suspect.getAge());
        line.add(patownShip + pastreet + pahouseNumber);
        String originalSymptom = suspect.getOriginalSymptom();
        line.add("1".equals(originalSymptom)?"√":"");
        line.add("2".equals(originalSymptom)?"√":"");
        line.add("3".equals(originalSymptom)?"√":"");
        line.add("4".equals(originalSymptom)?"√":"");
        line.add("5".equals(originalSymptom)?"√":"");
        line.add("6".equals(originalSymptom)?"√":"");
        line.add("99".equals(originalSymptom)?"√":"");
//        line.add(originalSymptom.indexOf("1")!=-1?"√":"");
//        line.add(originalSymptom.indexOf("2")!=-1?"√":"");
//        line.add(originalSymptom.indexOf("3")!=-1?"√":"");
//        line.add(originalSymptom.indexOf("4")!=-1?"√":"");
//        line.add(originalSymptom.indexOf("5")!=-1?"√":"");
//        line.add(originalSymptom.indexOf("6")!=-1?"√":"");
//        line.add(originalSymptom.indexOf("99")!=-1?"√":"");

        line.add(dictionaryApp.queryDicItemName("IDM00214", suspect.getCaseSource()));
        line.add(dictionaryApp.queryDicItemName("IDM00216", suspect.getChestXrays())); //胸透/胸片结果
        line.add(dictionaryApp.queryDicItemName("PH00004", suspect.getPhlegmPcr()));  //查痰结果
        line.add(dictionaryApp.queryDicItemName("IDM00216", suspect.getTentativeDiagnosis()));  //初步诊断
        line.add(dictionaryApp.queryDicItemName("IDM00217", suspect.getHandlingWay()));  //处理情况
        line.add(transferTreatmentDoctor);
        return line;
    }

    /**
     * 结核病人管理列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/mgnt/list")
    public String searchMgntList(TbQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = getMgntCriteria(form, request);
        //以下代码已迁移到getMgntCriteria方法内和导出时通用
        /*String organCode = request.getParameter("organCode");
        String orgArrStr = addOrgCri(request,organCode);
        if(StringUtil.isNotEmpty(orgArrStr))
            criteria.add("status.CURRENT_UNIT", OP.IN,orgArrStr.split(","));*/
        PageList<IdmStatusInfo> plist = tbService.findMgntList(page, criteria, null);
        model.addAttribute("mgntList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.tb.statistics.mgntList";
    }

    /**
     *
     *下载结核病人管理
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downMgntExcel")
    @ResponseBody
    public void downMgntExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/mgnt.xls"));
            Criteria criteria = getMgntCriteria(form, request);
            List<TbQueryDto> mgntList = tbService.findMgntListTotal(criteria, null);
            int totalRows = 7;
            int beginRowIndex = 5;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line,mgntList.size());
            for (TbQueryDto mgnt : mgntList) {
                List<Object> objects = getMgntExcelValues(mgnt, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, "结核病人管理.xls");
            excel.save(response.getOutputStream());

            mgntList.clear();
            mgntList = null;
        } catch (Exception e) {
            log.error("下载《结核病人管理》出错", e);
            throw e;
        }
    }

    /**
     * 生成结核病人管理EXCEL一行数据
     *
     * @param mgnt
     * @param lineNumber
     * @return
     */
    private List<Object> getMgntExcelValues(TbQueryDto mgnt, int lineNumber) {
        String patownShip = dictionaryApp.queryDicItemName("FS990001", mgnt.getPatownShip());//详细地址
        String pastreet = dictionaryApp.queryDicItemName("FS990001", mgnt.getPastreet());
        String pahouseNumber = mgnt.getPahouseNumber();

//        String transferTreatmentDoctor ="";
//        User user = null;
//        String userId = mgnt.getTransferTreatmentDoctor();
//        if(StringUtil.isNotEmpty(userId)){
//            user = ehrSecurityService.getUser(NumberUtil.convert(userId, Long.class));
//        }
//        if(ObjectUtil.isNotEmpty(user)){
//            transferTreatmentDoctor = user.getName();
//        }

        List<Object> line = new ArrayList<Object>();
        line.add(lineNumber);
        line.add(mgnt.getName());
        line.add(dictionaryApp.queryDicItemName("GBT226112003", mgnt.getGender()));
        line.add(mgnt.getAge());
        line.add(patownShip + pastreet + pahouseNumber);
        //病人分类
        if("1".equals(mgnt.getThisType())){
            line.add(dictionaryApp.queryDicItemName("IDM00248", mgnt.getThisType()));
        }else if("99".equals(mgnt.getThisType())){
            line.add(dictionaryApp.queryDicItemName("IDM00241", mgnt.getThisTypeF()));
        }

        line.add(DateUtil.getDateTime("yyyy/MM/dd", mgnt.getThisDt()));
        //治疗方案
        if("1".equals(mgnt.getChemotherapy())){
            line.add(dictionaryApp.queryDicItemName("IDM00222", mgnt.getChemotherapy()) + dictionaryApp.queryDicItemName("IDM00330", mgnt.getChemotherapyF()));
        }else if("2".equals(mgnt.getChemotherapy())){
            line.add(dictionaryApp.queryDicItemName("IDM00222", mgnt.getChemotherapy()) + dictionaryApp.queryDicItemName("IDM00331", mgnt.getChemotherapyS()));
        }else if("3".equals(mgnt.getChemotherapy())){
            line.add(dictionaryApp.queryDicItemName("IDM00222", mgnt.getChemotherapy()) + dictionaryApp.queryDicItemName("IDM00332", mgnt.getChemotherapyT()));
        }else if("99".equals(mgnt.getChemotherapy())){
            line.add(dictionaryApp.queryDicItemName("IDM00222", mgnt.getChemotherapy()) + mgnt.getChemotherapyOther());
        }

        line.add(dictionaryApp.queryDicItemName("IDM00243", mgnt.getManageType()));
        line.add(dictionaryApp.queryDicItemName("CV0300404", mgnt.getSputumResultS()));
        line.add(dictionaryApp.queryDicItemName("CV0300404", mgnt.getSputumResultFi()));
        line.add(dictionaryApp.queryDicItemName("CV0300404", mgnt.getSputumResultSi()));
        line.add(dictionaryApp.queryDicItemName("CV0300404", mgnt.getSputumResultE()));
        line.add(dictionaryApp.queryDicItemName("IDM00244", mgnt.getOutcomeCode()));
        line.add(DateUtil.getDateTime("yyyy/MM/dd", mgnt.getStopReasonDt()));
        return line;
    }

    /**
     * 密切接触者列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/cc/list")
    public String searchCcList(TbQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = getCcCriteria(form, request);

        PageList<ListCc> plist = tbService.getCcListForSt(page, criteria, null);
        model.addAttribute("ccList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.idm.tb.statistics.ccList";
    }

    /**
     *
     *下载密切接触者
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downCcExcel")
    @ResponseBody
    public void downCcExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/cc.xls"));
            Criteria criteria = getCcCriteria(form, request);
            List<ListCc> plist = tbService.getCcListForSt1(criteria);
            int totalRows = 7;
            int beginRowIndex = 5;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line,plist.size());
            for (ListCc cc : plist) {
                List<Object> objects = getCcExcelValues(cc, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, "涂阳肺结核患者密切接触者汇总.xls");
            excel.save(response.getOutputStream());

            plist.clear();
            plist = null;
        } catch (Exception e) {
            log.error("下载《涂阳肺结核患者密切接触者汇总》出错", e);
            throw e;
        }
    }
    /**
     * 生成疑似病人EXCEL一行数据
     *
     * @param listCc
     * @param lineNumber
     * @return
     */
    private List<Object> getCcExcelValues(ListCc listCc, int lineNumber) {
        List<Object> line = new ArrayList<Object>();
        line.add(listCc.getPatientName());
        line.add(listCc.getRegistNo());
        line.add(listCc.getCloseName());
        line.add(dictionaryApp.queryDicItemName("GBT226112003", listCc.getSex()));
        line.add(listCc.getAge());
        line.add("1".equals(listCc.getCloseType())?"√":"");
        line.add("2".equals(listCc.getCloseType())?"√":"");
        line.add(DateUtil.getDateTime("yyyy/MM/dd", listCc.getCheckDt()));
        line.add("1".equals(listCc.getCheckSympton())?"√":"");
        line.add("2".equals(listCc.getCheckSympton())?"√":"");
        line.add(dictionaryApp.queryDicItemName("CV0300404", listCc.getPpd()));
        line.add(dictionaryApp.queryDicItemName("FS10039", listCc.getX()));
        line.add(dictionaryApp.queryDicItemName("PH00022", listCc.getPic()));
        line.add(dictionaryApp.queryDicItemName("IDM00254", listCc.getDiagnosisResult()));
        line.add(listCc.getNewRegistNo());
        return line;
    }

    private Criteria getTransferCriteria(TbQueryForm form, HttpServletRequest request){
        Criteria criteria = new Criteria();
        criteria.add("IDM_TYPE", IdmType.TB.getValue());
        Date startDt = form.getDateFrom();
        Date endDt = form.getDateTo();
        String orgCode = form.getOrgCode();
        DateUtil.getCriteriaByDateRange(criteria, "caseInfo.MODIFY_SURVEY_DATE", startDt,endDt);
        String events[] = {SpecialEvents.T_TRANSFERTREAT.getValue()};
        criteria.add("EVENT_ID", OP.IN, events);
//        this.getEventId(criteria,SpecialEvents.T_REGISTER.getValue(),SpecialEvents.T_TRANSFERTREAT.getValue()); //事件
//        criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
        //权限
        if (!hasRole(RoleType.JKJHB, request)) {
            if(StringUtil.isNotEmpty(orgCode)){
                criteria.add("caseInfo.MODIFY_SURVEY_ORG", orgCode);
            }else {
                getCenterAll(null, criteria, request);
            }
        }else {
            if(StringUtil.isNotEmpty(orgCode)){
                getCenterAll(orgCode, criteria, request);
            }
        }
        return criteria;
    }

    private Criteria getSuspectCriteria(TbQueryForm form, HttpServletRequest request){
        Criteria criteria = new Criteria();
        criteria.add("IDM_TYPE", IdmType.TB.getValue());
        Date startDt = form.getDateFrom();
        Date endDt = form.getDateTo();
        String orgCode = form.getOrgCode();
        DateUtil.getCriteriaByDateRange(criteria, "caseInfo.MODIFY_SURVEY_DATE", startDt,endDt);
        String events[] = {SpecialEvents.T_REGISTER.getValue()};
        criteria.add("EVENT_ID", OP.IN, events);
//        this.getEventId(criteria,SpecialEvents.T_RECOMMENDATION.getValue(),SpecialEvents.T_REGISTER.getValue()); //事件

        //权限
        if (!hasRole(RoleType.JKJHB, request)) {
            if(StringUtil.isNotEmpty(orgCode)){
                criteria.add("caseInfo.REVIEW_UNIT", orgCode);
            }else {
                getCenterSus(null, criteria, request);
            }
        }else {
            if(StringUtil.isNotEmpty(orgCode)){
                getCenterSus(orgCode, criteria, request);
            }
        }
//        criteria.add("caseInfo.REVIEW_UNIT", getCurrentOrg(request).getOrganCode()); //权限
        return criteria;
    }

    private Criteria getMgntCriteria(TbQueryForm form, HttpServletRequest request){
        Criteria criteria = new Criteria();
        criteria.add("IDM_TYPE", IdmType.TB.getValue());
        Date startDt = form.getDateFrom();
        Date endDt = form.getDateTo();
        String orgCode = form.getOrgCode();
        DateUtil.getCriteriaByDateRange(criteria, "other.THIS_DT", startDt,endDt);
//        this.getEventId(criteria,SpecialEvents.T_DCMR.getValue(),SpecialEvents.T_TREATMENT.getValue());
        String arrays[] = {SpecialEvents.T_TREATMENT.getValue()};
        criteria.add("EVENT_ID", OP.IN, arrays);
        criteria.add("event.is_delete", EHRConstants.DELETE_FLG_0);//筛选出未被删除的数据
//        getRoleCriteria(criteria, request);
        //权限
        if (!hasRole(RoleType.JKJHB, request)) {
            if(StringUtil.isNotEmpty(orgCode)){
                criteria.add("status.CURRENT_UNIT", orgCode);
            }else {
                getCenterAllMgnt(null, criteria, request);
            }
        }else {
            if(StringUtil.isNotEmpty(orgCode)){
                getCenterMgnt(orgCode, criteria, request);
            }
        }

        //所属单位所有子机构
        String town = request.getParameter("town");
        String village = request.getParameter("village");
        String station = request.getParameter("station");
        if(StringUtil.isNotEmpty(station)){
        	criteria.add("status.CURRENT_UNIT", station);
        }else if(StringUtil.isNotEmpty(village)){
        	criteria.add("village",village);
        }else if(StringUtil.isNotEmpty(town)){
        	criteria.add("town",town);
        }else{
	        String organCode = request.getParameter("organCode");
	        String orgArrStr = addOrgCri(request,organCode);
	        if(StringUtil.isNotEmpty(orgArrStr))
	            criteria.add("status.CURRENT_UNIT", OP.IN,orgArrStr.split(","));
        }
        return criteria;
    }

    private Criteria getCcCriteria(TbQueryForm form, HttpServletRequest request){
        Criteria criteria = new Criteria();
        criteria.add("S.IDM_TYPE", IdmType.TB.getValue());
        Date startDt = form.getDateFrom();
        Date endDt = form.getDateTo();
        String orgCode = form.getOrgCode();
        DateUtil.getCriteriaByDateRange(criteria, "C.CHECK_DT", startDt, endDt);
        //权限
        if (!hasRole(RoleType.JKJHB, request)) {
            if(StringUtil.isNotEmpty(orgCode)){
                criteria.add("C.MODIFY_UNIT", orgCode);
            }else {
                getCenterAllForCc(null, criteria, request);
            }
        }else {
            if(StringUtil.isNotEmpty(orgCode)){
                getCenterAllForCc(orgCode, criteria, request);
            }
        }
        //所属单位所有子机构
        String town = request.getParameter("town");
        String village = request.getParameter("village");
        String station = request.getParameter("station");
        if(StringUtil.isNotEmpty(station)){
        	criteria.add("C.MODIFY_UNIT", station);
        }else if(StringUtil.isNotEmpty(village)){
        	criteria.add("village",village);
        }else if(StringUtil.isNotEmpty(town)){
        	criteria.add("town",town);
        }else{
	        String organCode = request.getParameter("organCode");
	        String orgArrStr = addOrgCri(request,organCode);
	        if(StringUtil.isNotEmpty(orgArrStr))
	            criteria.add("C.MODIFY_UNIT", OP.IN,orgArrStr.split(","));
        }
        return criteria;
    }

    private Criteria getCenterSus (String orgCode, Criteria criteria, HttpServletRequest request){
        //乡镇卫生院
        if(!StringUtil.isNotEmpty(orgCode)){
            Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
            if ("B100".equals(currentOrg.getGenreCode())) {
                List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", currentOrg.getOrganCode()));
                List<String> codeList = new ArrayList<>();
                for (Organization org : orgList) {
                    codeList.add(org.getOrganCode());
                }
                codeList.add(currentOrg.getOrganCode());
                criteria.add("caseInfo.REVIEW_UNIT", OP.IN, codeList);
            }
        }
        else{//结防所
            List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", orgCode));
            List<String> codeList = new ArrayList<>();
            for (Organization org : orgList) {
                codeList.add(org.getOrganCode());
            }
            codeList.add(orgCode);
            criteria.add("caseInfo.REVIEW_UNIT", OP.IN, codeList);
        }
        return criteria;
    }

    private Criteria getCenterAll (String orgCode, Criteria criteria, HttpServletRequest request){
        //乡镇卫生院
        if(!StringUtil.isNotEmpty(orgCode)){
            Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
            if ("B100".equals(currentOrg.getGenreCode())) {
                List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", currentOrg.getOrganCode()));
                List<String> codeList = new ArrayList<>();
                for (Organization org : orgList) {
                    codeList.add(org.getOrganCode());
                }
                codeList.add(currentOrg.getOrganCode());
                criteria.add("caseInfo.MODIFY_SURVEY_ORG", OP.IN, codeList);
            }
        }else{//结防所
            List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", orgCode));
            List<String> codeList = new ArrayList<>();
            for (Organization org : orgList) {
                codeList.add(org.getOrganCode());
            }
            codeList.add(orgCode);
            criteria.add("caseInfo.MODIFY_SURVEY_ORG", OP.IN, codeList);
        }
        return criteria;
    }

    private Criteria getCenterAllMgnt (String orgCode, Criteria criteria, HttpServletRequest request){
        //乡镇卫生院
        if(!StringUtil.isNotEmpty(orgCode)){
            Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
            if ("B100".equals(currentOrg.getGenreCode())) {
                List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", currentOrg.getOrganCode()));
                List<String> codeList = new ArrayList<>();
                for (Organization org : orgList) {
                    codeList.add(org.getOrganCode());
                }
                codeList.add(currentOrg.getOrganCode());
                criteria.add("status.CURRENT_UNIT", OP.IN, codeList);
            }
        }
        return criteria;
    }

    private Criteria getCenterMgnt (String orgCode, Criteria criteria, HttpServletRequest request){
        //结防所
            List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", orgCode));
            List<String> codeList = new ArrayList<>();
            for (Organization org : orgList) {
                codeList.add(org.getOrganCode());
            }
            codeList.add(orgCode);
            criteria.add("status.CURRENT_UNIT", OP.IN, codeList);
        return criteria;
    }

    private Criteria getCenterAllForCc (String orgCode, Criteria criteria, HttpServletRequest request){
        //乡镇卫生院
        if(!StringUtil.isNotEmpty(orgCode)){
            Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
            if ("B100".equals(currentOrg.getGenreCode())) {
                List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", currentOrg.getOrganCode()));
                List<String> codeList = new ArrayList<>();
                for (Organization org : orgList) {
                    codeList.add(org.getOrganCode());
                }
                codeList.add(currentOrg.getOrganCode());
                criteria.add("C.MODIFY_UNIT", OP.IN, codeList);
            }
        }else{//结防所
            List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", orgCode));
            List<String> codeList = new ArrayList<>();
            for (Organization org : orgList) {
                codeList.add(org.getOrganCode());
            }
            codeList.add(orgCode);
            criteria.add("C.MODIFY_UNIT", OP.IN, codeList);
        }
        return criteria;
    }

    /*获取唯一事件编码*/
    private void getEventId(Criteria criteria, String eventIdF, String eventIdS) {
        String arrays[] = {eventIdF, eventIdS};
        criteria.add("EVENT_ID", OP.IN, arrays);
    }

    private void getRoleCriteria(Criteria criteria, HttpServletRequest request) {
        Criteria temp = new Criteria();
        String orgCode = getCurrentOrg(request).getOrganCode();
//        if (!hasRole(RoleType.JKJHB, request)) {
//            temp.add("status.LAST_UNIT", orgCode).add("status.special_status", TbStatus.REASSIGN.getValue())
//                    .add(LOP.OR, new Criteria("status.CURRENT_UNIT", orgCode));
//            criteria.add(temp);
//        }
        if (!hasRole(RoleType.JKJHB, request)) {
            temp.add("status.LAST_UNIT", orgCode).add("status.special_status",
                    OP.IN,new Integer[]{TbStatus.REASSIGN.getValue(), TbStatus.ACCEPT.getValue()})
                    .add(LOP.OR, new Criteria("status.CURRENT_UNIT", orgCode));
            criteria.add(temp);
        }
    }

    private String addOrgCri(HttpServletRequest request, String organCode){
        String organList = "";
        if(ObjectUtil.isNotEmpty(organCode)){
            if(ObjectUtil.equals("_hospital", organCode)) {
                List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue()));
                for(Organization organization : hospitals){
                    organList += organization.getOrganCode() + ",";
                }
            } else if(ObjectUtil.equals("_centre", organCode)) {
                List<Organization> centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.STATION.getValue()}));
                for(Organization organization : centres){
                    organList += organization.getOrganCode() + ",";
                }
            } else {
                organList = organCode;
            }
        }
        if(StringUtil.isEndsWithIgnoreCase(organList, ",")){
            organList = organList.substring(0, organList.length()-1);
        }
        return organList;
    }

}