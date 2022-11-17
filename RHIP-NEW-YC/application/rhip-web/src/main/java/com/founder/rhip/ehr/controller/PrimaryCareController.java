package com.founder.rhip.ehr.controller;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IHealthPalnService;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import com.founder.rhip.ehr.entity.management.DmReportInfo;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.IDmReportInfoDao;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 基层医疗接口
 */
@Controller
@RequestMapping("/primaryCare")
public class PrimaryCareController extends BaseController {

	private static Logger logger = Logger.getLogger(BaseController.class);

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

    @Resource(name = "mdmStaffService")
    private IStaffService staffService;

    @Resource(name = "dmDiseaseInfoDao")
    private IDmDiseaseInfoDao diseaseInfoDao;

    @Resource(name = "dmReportInfoDao")
    private IDmReportInfoDao dmReportInfoDao;

    @Resource
    private IStandardizationService standardizationService;

    @Resource(name = "reportService")
    private IReportService reportService;

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Autowired
    private IHealthEventService healthEventService;

    @Resource(name = "ehrSecurityService")
	private IEhrSecurityService securityService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

    @Resource(name = "healthPalnService")
    private IHealthPalnService healthPalnService;
	
    static private Set<String> notReportICd10 = new HashSet<>();

    private final static String CONTROLLER_NAME = "基层医疗慢病管理卡和保健计划";

    /**
     * 判断传染病是否需要报卡
     * @param request
     * @param response
     * @param queryString
     * @throws IOException
     */
    @RequestMapping("/report/needIDReport")
    public void needIDReport (HttpServletRequest request, HttpServletResponse response, String queryString) throws IOException{
        notReportICd10.add("I69");
        String result = "";
        try{
            Map<String, Object[]> paramMap = decrypt(queryString);
            String idCard = getFieldValue(paramMap, "idCard");
            String diseaseCode = getFieldValue(paramMap,"diseaseCode");

            //增加无需报卡的icd10判断 ,先根据前三位进行判断,然后是全部
            String parDiseaseCode = diseaseCode.length() >= 3 ? diseaseCode.substring(0, 3) : diseaseCode;
            if (notReportICd10.contains(parDiseaseCode) || (!parDiseaseCode.equals(diseaseCode)&&notReportICd10.contains(diseaseCode))) {
                result = "0"; // 不可上报
            }
            // 乙肝是只要报过的就不能上报
            if("2032".equals(diseaseCode)){
                Page page = super.getPage(request,  1);
                Criteria ca = new Criteria();
                ca.add("idcard", idCard);
                ca.add("infectiousCode", diseaseCode);
//                ca.add("REPORT_STATUS",OP.EQ, ReportStatus.CANCEL.getValue());
                PageList<IdmReport> plist = reportService.findReport(ca, page);
                boolean returnFlag;
                if(ObjectUtil.isNullOrEmpty(plist) || ObjectUtil.isNullOrEmpty(plist.getList()) || plist.getList().size() <= 0){
                    result = "1"; //该患者乙肝未上报过
                }else{
                    result = "0"; //该患者乙肝已经上报过
                }
            }else {
                //其他是一周内报过的不用上报
                Page page = super.getPage(request,  1);
                Criteria ca = new Criteria();
                ca.add("idcard", OP.LIKE, idCard);
                ca.add("infectiousCode", diseaseCode);
                Date fillEndDate = new Date();
                Date fillBeginDate = DateUtil.add(fillEndDate, Calendar.DATE, -7);
                DateUtil.getCriteriaByDateRange(ca, "fillDate", fillBeginDate,fillEndDate);
                PageList<IdmReport> plist = reportService.findReport(ca, page);
                if(ObjectUtil.isNullOrEmpty(plist) || ObjectUtil.isNullOrEmpty(plist.getList()) || plist.getList().size() <= 0){
                    result =  "1"; //未上报过, 可以上报
                }else{
                    result = "0"; //一周之内已经上报过, 不可上报
                }
            }

            response.getWriter().write("var result=[\"0\",\""+result+"\"];");
        }catch (Exception e){
            response.getWriter().write("var result=[\"-1\",\""+result+"\"];");
        }

    }

    /**
     * 判断慢病是否需要报卡（基层医疗 糖尿病）
     * @param request
     * @param response
     * @param queryString
     * @throws IOException
     */
    @RequestMapping("/report/needCDReport")
    public void needCDReport (HttpServletRequest request, HttpServletResponse response, String queryString) throws IOException{
        String result = "";
        try{
            Map<String, Object[]> paramMap = decrypt(queryString);
            String idCard = getFieldValue(paramMap, "idCard");
            String diType = getFieldValue(paramMap,"diType");

            String disTypeF = changeIcdCode(diType);
            Criteria criteria = new Criteria();
            criteria.add("DI_TYPE", disTypeF);
            criteria.add("IDCARD", idCard);
            List<DmReportInfo> reportInfos = dmReportInfoDao.getList(criteria);
            if(ObjectUtil.isNotEmpty(reportInfos) && reportInfos.size()>0){
                result = "0"; //已报卡， 无需再报卡
            }else {
                result = "1"; //未报卡， 可以报卡
            }
            response.getWriter().write("var result=[\"0\",\""+result+"\",\""+diType+"\"];");
        }catch (Exception e){
            response.getWriter().write("var result=[\"-1\",\""+result+"\" + \"0\"];");
        }

    }

    /**
     * 是否建档
     * @param request
     * @return
     */
    @RequestMapping("/personRecord/hasEHR")
    public void hasEHR(HttpServletRequest request, HttpServletResponse response, String queryString) throws IOException {
        String[] result = new String[]{"0", "0"};
        try{

            Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
            paramMap = decryptByCharset(queryString, paramMap);
            if (ObjectUtil.isNullOrEmpty(paramMap) || ObjectUtil.isNullOrEmpty(getFieldValue(paramMap,"idCard"))) {//没有参数或者参数解析失败
                response.getWriter().write("var result=[\"-2\",\"" + result[1] + "\"];");
                return;
            }
            Criteria criteria = new Criteria();
            criteria.add("IDCARD", getFieldValue(paramMap,"idCard"));
            PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
            if(ObjectUtil.isNotEmpty(personInfo)){
                result[0] = "0";  //0 处理成功; 1 人员信息不存在; -1 发生异常
            } else {
                result[0] = "1";
                response.getWriter().write("var result=[\"" + result[0] + "\",\"" + result[1] + "\"];");
                return;
            }
            String filingFlag = personInfo.getFilingFlag(); //0：未建档 1：已建档，3 已退回 9已注销 5待审核
            //0 没有健康档案;   1 有不规范的健康档案 2 有规范化健康档案（三星级）
            String star = ObjectUtil.isNotEmpty(personInfo.getStar()) ? personInfo.getStar().toString() : null;
            if ("0".equals(filingFlag)) {
                result[1] = "0";
            } else if (!"0".equals(filingFlag) && !"3".equals(star)) {
                result[1] = "1";
            } else {
                result[1] = "2";
            }
            response.getWriter().write("var result=[\""+result[0]+"\",\""+result[1]+"\"];");
        }catch (Exception e){
            e.getMessage();
            response.getWriter().write("var result=[\"-1\",\""+result[1]+"\"];");
        }
    }

    /**
     * 进入新增个人档案页面
     *
     * @return
     */
    @RequestMapping("/personRecord/addPersonRecordIni")
    public String addPersonRecordIni(HttpServletRequest request, HttpServletResponse response, ModelMap model, String queryString) {
        request.getSession().removeAttribute("personInfo");
        int recordStatus = 0;
        String url = "rhip.ehr.personalRecord.init";

        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            model.addAttribute("errorStr", "没有参数或者参数解析失败!");
            return url;
        }
        String idCard = getFieldValue(paramMap, "idCard");
        String orgCode = getFieldValue(paramMap, "orgCode");
        String userIdCard = getFieldValue(paramMap, "userIdCard");
        User user = securityService.getUser(new Criteria("IDENTITY_CARD", userIdCard).add("STATUS", "1"));
        Staff staff = staffService.getStaff(new Criteria("ID_CARD", userIdCard));

        Organization currentOrganization = organizationApp.queryOrgan(orgCode);
        this.setCurrentLoginInfo(currentOrganization, user, request);

        Criteria criteria = new Criteria();
        criteria.add("idcard", idCard);
        model.addAttribute("titleFlag", "ehr");
        if (!this.validateOrg(orgCode, currentOrganization, model) || !validateUser(userIdCard, user, model)) {
            return url;
        } else if (ObjectUtil.isNullOrEmpty(securityService.getUserRole(user.getUserCode(), currentOrganization.getOrganCode(), null))) {
            model.addAttribute("errorStr", "平台医疗机构" + currentOrganization.getOrganName() + "中不存在身份证编号为" + userIdCard + "的用户!");
            return url;
        } else if(ObjectUtil.isNullOrEmpty(idCard)) {
            model.addAttribute("errorStr", "居民身份证号码不能为空！");
            return url;
        }

        PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(criteria);

        if(ObjectUtil.isNotEmpty(personInfo)){
            recordStatus = healthEventService.checkPersonRecordStatus(new Criteria("personId", personInfo.getId()));
            this.setBasicPersonInfo(personInfo, paramMap);
            //未建档状态，将登录机构默认为建档单位
            if("0".equals(personInfo.getFilingFlag())){
                personInfo.setInputOrganName(currentOrganization.getOrganName());
                personInfo.setInputOrganCode(currentOrganization.getOrganCode());
                personInfo.setInputerId(staff.getStaffCode());
            }
            getPersonAddress(personInfo);
        } else {
            personInfo = new PersonInfo();
            if(paramMap.containsKey("idCard")){
                personInfo.setIdcard(getFieldValue(paramMap,"idCard"));
            }
            this.setBasicPersonInfo(personInfo, paramMap);
            personInfo.setInputOrganName(currentOrganization.getOrganName());
            personInfo.setInputOrganCode(currentOrganization.getOrganCode());
            getPersonAddress(personInfo);
            personInfo.setInputerId(staff.getStaffCode());
        }

        request.getSession().setAttribute("personInfo", personInfo);

        request.setAttribute("recordStatus", recordStatus);
        model.addAttribute("queryString", queryString.replaceAll(" ","+"));
        return url;
    }

    /**
     * 设置基本信息
     * @param personInfo
     * @param paramMap
     */
    private void setBasicPersonInfo(PersonInfo personInfo, Map<String, Object[]> paramMap) {
        String name = getFieldValue(paramMap, "name");
        String gender = getFieldValue(paramMap, "gender");
        String patownShip = getFieldValue(paramMap, "patownShip");//现住址所在街道
        String pastreet = getFieldValue(paramMap, "pastreet");//现住址所在居委会
        String paGroup = getFieldValue(paramMap, "paGroup");//现住址所在组
        String pahouseNumber = getFieldValue(paramMap, "pahouseNumber");//现住址门牌号码
        String hrtownShip = getFieldValue(paramMap, "hrtownShip");//户籍所在街道
        String hrstreet = getFieldValue(paramMap, "hrstreet");//户籍所在居委会
        String hrGroup = getFieldValue(paramMap, "hrGroup");//户籍所在区
        String hrhouseNumber = getFieldValue(paramMap, "hrhouseNumber");//户籍所在门牌号码
        String householdType = getFieldValue(paramMap, "householdType");//户籍类型
        String phoneNumber = getFieldValue(paramMap, "phoneNumber");//联系电话
        if(ObjectUtil.isNotEmpty(name)){
            personInfo.setName(name);
        }
        if(ObjectUtil.isNotEmpty(paGroup)){
            personInfo.setPaGroup(paGroup);
        }
        if(ObjectUtil.isNotEmpty(patownShip)){
            personInfo.setPatownShip(patownShip);
        }
        if(ObjectUtil.isNotEmpty(pastreet)){
            personInfo.setPastreet(pastreet);
        }
        if(ObjectUtil.isNotEmpty(pahouseNumber)){
            personInfo.setPahouseNumber(pahouseNumber);
        }
        if(ObjectUtil.isNotEmpty(hrGroup)){
            personInfo.setHrGroup(hrGroup);
        }
        if(ObjectUtil.isNotEmpty(hrtownShip)){
            personInfo.setHrtownShip(hrtownShip);
        }
        if(ObjectUtil.isNotEmpty(hrstreet)){
            personInfo.setHrstreet(hrstreet);
        }
        if(ObjectUtil.isNotEmpty(hrhouseNumber)){
            personInfo.setHrhouseNumber(hrhouseNumber);
        }
        if(ObjectUtil.isNotEmpty(householdType)){
            personInfo.setHouseholdType(householdType);
        }
        if(ObjectUtil.isNotEmpty(phoneNumber)){
            personInfo.setPhoneNumber(phoneNumber);
        }
        if(ObjectUtil.isNotEmpty(gender)){
            personInfo.setGender(gender);
        }
    }

    /**
     * 填写随访
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/cdm/addFollowUp")
    public String addFollowUp(HttpServletRequest request, ModelMap model, String queryString) {

        String url = "rhip.cdm.base.standardization.followup.add";
        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            model.addAttribute("errorStr", "没有参数或者参数解析失败!");
            return url;
        }
        if(!paramMap.containsKey("idCard")){
            model.addAttribute("errorStr", "缺少身份证参数!");
        }
        String idCard = getFieldValue(paramMap, "idCard");
        if(ObjectUtil.isNullOrEmpty(idCard)){
            model.addAttribute("errorStr", "参数中身份证号码不能为空!");
        }
//        String userIdCard = getFieldValue(paramMap, "userIdCard");
        if(!paramMap.containsKey("userCode")){
            model.addAttribute("errorStr", "缺少医务人员编码参数!");
        }
        String userCode = getFieldValue(paramMap, "userCode");
        if(!paramMap.containsKey("orgCode")){
            model.addAttribute("errorStr", "缺少机构参数!");
        }
        String orgCode = getFieldValue(paramMap, "orgCode");
        Organization currentOrganization = organizationApp.queryOrgan(orgCode);
//        User user = securityService.getUser(new Criteria("IDENTITY_CARD", userIdCard).add("STATUS", "1"));
        User user = securityService.getUser(new Criteria("USER_CODE", userCode).add("STATUS", "1"));
        this.setCurrentLoginInfo(currentOrganization, user, request);

        model.addAttribute("titleFlag", "follow");
        if (!this.validateOrg(orgCode, currentOrganization, model) || !validateUser("1", userCode, user, model)) {
            return url;
        } else if (ObjectUtil.isNullOrEmpty(securityService.getUserRole(user.getUserCode(), currentOrganization.getOrganCode(), null))) {
            model.addAttribute("errorStr", "平台医疗机构" + currentOrganization.getOrganName() + "中不存在编码为" + userCode + "的用户,或者无相关权限!");
            return url;
        }

        DmDiseaseInfo diseaseInfo = diseaseInfoDao.get(new Criteria("IDCARD", idCard));
        if (ObjectUtil.isNullOrEmpty(diseaseInfo)) {
            model.addAttribute("errorStr", "该患者未进行慢病管理!");
            return url;
        } else if (!ObjectUtil.equals(diseaseInfo.getHbpFlag(), "2") && !ObjectUtil.equals(diseaseInfo.getDiFlag(), "2")) {
            model.addAttribute("errorStr", "只有高血压和糖尿病的患者需要在外部填写随访!");
            return url;
        } else if (!ObjectUtil.equals(orgCode, diseaseInfo.getCreateOrganCode())) {
            model.addAttribute("warnStr", "该患者已经被" + organizationApp.queryOrganName(diseaseInfo.getCreateOrganCode()) + "社区站管理!");
        }

        PersonInfo personInfo = platformService.queryPersonalInfo(diseaseInfo.getPersonId());

        model.put("personInfo", personInfo);
        diseaseInfo.setTumorFlag("");
        diseaseInfo.setStrokeFlag("");
        diseaseInfo.setCoronaryFlag("");
        model.put("diseaseInfo", diseaseInfo);

        model.put("currentDate", new Date());
        model.put("oneYearBeforeDate", DateUtil.add(new Date(), Calendar.YEAR, -1));

        return url;
    }

    public Map<String, Object[]> decrypt(String queryString) {
        //先用UTF-8解析看有没有编码参数
        Map<String, Object[]> map = null;
        String parameters = "";
        parameters = Base64Util.decrypt((queryString.replaceAll(" ","+")), "UTF-8");

        if (ObjectUtil.isNotEmpty(parameters)){
            try{
                map = convertQueryToReport(parameters);
            }catch (Exception e) {
                logger.error("参数解析失败", e);
            }
        }
        return map;
    }

    /**
     * 将参数字符串转换为map
     * @param query
     * @return
     */
    private Map<String, Object[]> convertQueryToReport(String query) {
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        String params[] = query.split("&");
        for (String param : params) {
            if (param.indexOf("=") > 0) {
                String keyValues[] = param.split("=");
                if (keyValues.length == 2) {
                    String value=keyValues[1] ;
                    value=value==null?"":value.trim();
                    map.put(keyValues[0], new Object[] { value});
                } else if (keyValues.length == 1) {
                    map.put(keyValues[0], new Object[] { "" });
                }
            }
        }
        return map;
    }

    /**
     * map中获取String值 ,null则返回""
     *
     * @param map
     * @param key
     * @return
     */
    private String getFieldValue(Map<String, Object[]> map, String key) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key)[0].toString();
    }

    /**
     * 获取角色
     *
     * @param request
     * @return
     */
    public RoleType getRole(HttpServletRequest request) {
        RoleType role = null;
        if (hasRole(RoleType.DDCRBYY, request)) {
            role = RoleType.DDCRBYY;
        } else if (hasRole(RoleType.ZX_GLY, request)) {
            role = RoleType.ZX_GLY;
        } else if (hasRole(RoleType.JKMBK, request)) {
            role = RoleType.JKMBK;
        } else if (hasRole(RoleType.Z_GLY, request)) {
            role = RoleType.Z_GLY;
        } else if (hasRole(RoleType.ADMIN, request)) {
            role = RoleType.ADMIN;
        } else {
            Assert.notNull(role, "没有权限,请更换用户登录");
        }
        return role;
    }
    
    private void getPersonAddress(PersonInfo personInfo) {
        String paAddressDetail = "";
        if (ObjectUtil.isNotEmpty(personInfo.getPatownShip())) {
            DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPatownShip());
            if (ObjectUtil.isNotEmpty(paDicItem1)) {
                String paTownName = paDicItem1.getItemName();
                paAddressDetail = paTownName;
            }
        }
        if (ObjectUtil.isNotEmpty(personInfo.getPastreet())) {
            DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getPastreet());
            if (ObjectUtil.isNotEmpty(paDicItem2)) {
                String paStreetName = paDicItem2.getItemName();
                paAddressDetail += paStreetName;
            }
        }

        String hrAddressDetail = "";
        if (ObjectUtil.isNotEmpty(personInfo.getHrtownShip())) {
            DicItem hrDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrtownShip());
            if (ObjectUtil.isNotEmpty(hrDicItem1)) {
                String paTownName = hrDicItem1.getItemName();
                hrAddressDetail = paTownName;
            }
        }
        if (ObjectUtil.isNotEmpty(personInfo.getHrstreet())) {
            DicItem hrDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrstreet());
            if (ObjectUtil.isNotEmpty(hrDicItem2)) {
                String paStreetName = hrDicItem2.getItemName();
                hrAddressDetail += paStreetName;
            }
        }
        personInfo.setHrAddressDetail(hrAddressDetail);
        personInfo.setPaAddressDetail(paAddressDetail);
    }

    private String changeIcdCode(String code)
    {
        //1型糖尿病
        if("E10.900" ==  code)
        {
            return "1";
        }
        else if("E11.900" ==  code)//2型糖尿病
        {
            return "2";
        }
        else if("O24" ==  code)//妊娠期糖尿病
        {
            return "3";
        }
        else if("E13" ==  code)//其他特指的糖尿病
        {
            return "4";
        }else {
            return "";
        }

    }
    private Map<String, Object[]> decryptByCharset(String queryString, Map<String, Object[]> map) {
        String parameters = "";
        if (ObjectUtil.isNullOrEmpty(queryString)) {
            //没有参数或者参数错误
            return null;
        }
        queryString=queryString.replace(" ", "+");
        queryString=queryString.replace("\n", "");
        //先用UTF-8解析看有没有编码参数
        parameters = Base64Util.decrypt(queryString, "UTF-8");
        if (parameters.indexOf("=") == -1) {
            //没有参数或者参数解析失败
            return null;
        }

        if (ObjectUtil.isNotEmpty(parameters)) {
            try {
                map = convertQueryToReport(parameters);
            } catch (Exception e) {
                //参数解析失败
                return null;
            }
        }

        //以下判断按照什么编码原则解析参数
        String charsetName = "";
        charsetName = getFieldValue(map, "charsetName");
        //没有编码参数默认是GB2312
        if (ObjectUtil.isNullOrEmpty(charsetName)) {
            // 默认中文编码是GB2312
            parameters = Base64Util.decrypt(queryString, "GB2312");
        } else if (!charsetName.equalsIgnoreCase("UTF-8")) {//有编码参数但是不是UTF-8
            parameters = Base64Util.decrypt(queryString, charsetName);
        }

        //以下按照什么编码原则分拆参数
        try {
            if (ObjectUtil.isNotEmpty(parameters) && ObjectUtil.isNullOrEmpty(charsetName)) {
                map = convertQueryToReport(parameters);
            } else if (ObjectUtil.isNotEmpty(parameters) && !charsetName.equalsIgnoreCase("UTF-8")) {
                map = convertQueryToReport(parameters);
            }
        } catch (Exception e) {
            //参数解析失败
            return null;
        }
        return map;
    }

    private void setCurrentLoginInfo(Organization organization, User user, HttpServletRequest request) {
        organization = ObjectUtil.isNullOrEmpty(organization) ? new Organization() : organization;
        user = ObjectUtil.isNullOrEmpty(user) ? new User() : user;

        CurrentLoginInfo currentLoginInfo = new CurrentLoginInfo();
        currentLoginInfo.setUser(user);
        currentLoginInfo.setOrganization(organization);

        List<Role> roles = securityService.getRoles(user.getUserCode(), organization.getOrganCode(), 0);
        currentLoginInfo.setRoles(roles);
        request.getSession().setAttribute("currentLoginInfo", currentLoginInfo);
        request.getSession().setAttribute("currentUser", user);
        request.getSession().setAttribute("currentLoginInfo", currentLoginInfo);
    }

    private boolean validateOrg(String orgCode, Organization organization, ModelMap model) {
        if (ObjectUtil.isNullOrEmpty(orgCode)) {
            model.addAttribute("errorStr", "参数中机构编码不能为空!");
            return false;
        } else if (ObjectUtil.isNullOrEmpty(organization)) {
            model.addAttribute("errorStr", "参数中机构编码在平台系统中不存在!");
            return false;
        } else if (!ObjectUtil.equals(organization.getGenreCode(), OrgGenreCode.STATION.getValue()) && !ObjectUtil.equals(organization.getGenreCode(), OrgGenreCode.CENTRE.getValue())) {
            model.addAttribute("errorStr", "参数中机构类型必须为站或者中心!");
            return false;
        }
        return true;
    }

    private boolean validateUser(String userIdCard, User user, ModelMap model) {
        if (ObjectUtil.isNullOrEmpty(userIdCard)) {
            model.addAttribute("errorStr", "医务人员身份证号码不能为空!");
            return false;
        }
        if (ObjectUtil.isNullOrEmpty(user)) {
            model.addAttribute("errorStr", "平台系统中不存在此医务人员的用户信息!");
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/cdm/addPlan")
    public String addPlan(HttpServletRequest request, HttpServletResponse response, ModelMap model, String queryString) {

        String url = "rhip.cdm.base.standardization.planInfoTab.add";
        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            model.addAttribute("errorStr", "没有参数或者参数解析失败!");
            return url;
        }
        String idCard = getFieldValue(paramMap, "idCard");
        String userCode = getFieldValue(paramMap, "userCode");
        String orgCode = getFieldValue(paramMap, "orgCode");
        Organization currentOrganization = organizationApp.queryOrgan(orgCode);
        User user = securityService.getUser(new Criteria("USER_CODE", userCode).add("STATUS", "1"));
        if (ObjectUtil.isNullOrEmpty(user)) {
            model.addAttribute("errorStr", "平台系统中不存在此医务人员的用户信息!");
            return url;
        }
        this.setCurrentLoginInfo(currentOrganization, user, request);
        model.addAttribute("titleFlag", "plan");
        if (!this.validateOrg(orgCode, currentOrganization, model) || !validateUser("1", userCode, user, model)) {
            return url;
        } else if (ObjectUtil.isNullOrEmpty(securityService.getUserRole(user.getUserCode(), currentOrganization.getOrganCode(), null))) {
            model.addAttribute("errorStr", "平台医疗机构" + currentOrganization.getOrganName() + "中不存在编码为" + userCode + "的用户,或者无相关权限!");
            return url;
        }

        Criteria criteria = new Criteria("IDCARD", idCard);
        criteria.add("STATUS", EHRConstants.DM_MANAGE_STATUS_NORMAL);

        DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);
        if (ObjectUtil.isNullOrEmpty(diseaseInfo)) {
            model.addAttribute("errorStr", "该患者未进行慢病管理!");
            return url;
        }
        boolean cdmFlag = EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag()) ||
            EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag()) ||
            EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag()) ||
            EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag()) ||
            EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag());
       if (!ObjectUtil.equals(diseaseInfo.getHbpFlag(), "2") && !ObjectUtil.equals(diseaseInfo.getDiFlag(), "2")) {
            model.addAttribute("errorStr", "只有高血压和糖尿病的患者需要建立保健计划!");
            return url;
        } else if (!ObjectUtil.equals(orgCode, diseaseInfo.getCreateOrganCode()) && cdmFlag) {
            model.addAttribute("errorStr", "该患者已经被其它社区站管理!");
            return url;
        }
        PersonInfo personInfo = diseaseInfo.getPersonInfo();
        // 检查是否被注销
        if (EHRConstants.HAD_OFF.equals(personInfo.getFilingFlag())) {
            model.addAttribute("errorStr", "该患者已经被注销!");
            return "rhip.cdm.base.standardization.planInfoTab";
        }

        model.put("personInfo", personInfo);
        model.put("diseaseInfo", diseaseInfo);

        return url;
    }

    /**
     * 新增管理卡获取人和管理卡信息
     *
     * @param request
     * @param response
     * @param model
     * @param queryString
     * @return
     */
    @RequestMapping(value = "/cdm/addHmCard")
    public String addHmCard(HttpServletRequest request, HttpServletResponse response, ModelMap model, String queryString) {

        String url = "rhip.cdm.base.standardization.hmCard.add";
        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            model.addAttribute("errorStr", "没有参数或者参数解析失败!");
            return url;
        }
        String idCard = getFieldValue(paramMap, "idCard");
        String userCode = getFieldValue(paramMap, "userCode");
        String orgCode = getFieldValue(paramMap, "orgCode");
        Organization currentOrganization = organizationApp.queryOrgan(orgCode);
        User user = securityService.getUser(new Criteria("USER_CODE", userCode).add("STATUS", "1"));

        if (ObjectUtil.isNullOrEmpty(user)) {
            model.addAttribute("errorStr", "平台系统中不存在此医务人员的用户信息!");
            return url;
        }
        this.setCurrentLoginInfo(currentOrganization, user, request);
        model.addAttribute("titleFlag", "hmCard");
        if (!this.validateOrg(orgCode, currentOrganization, model) || !validateUser("1", userCode, user, model)) {
            return url;
        } else if (ObjectUtil.isNullOrEmpty(securityService.getUserRole(user.getUserCode(), currentOrganization.getOrganCode(), null))) {
            model.addAttribute("errorStr", "平台医疗机构" + currentOrganization.getOrganName() + "中不存在编码为" + userCode + "的用户,或者无相关权限!");
            return url;
        }
        Criteria criteria = new Criteria();
        criteria.add("idcard", idCard);
        PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(criteria);
        if(ObjectUtil.isNullOrEmpty(personInfo)) {
            personInfo = new PersonInfo();
            personInfo.setIdcard(idCard);
        }
        model.put("personInfo", personInfo);
        model.addAttribute("orgCode", orgCode);
        model.addAttribute("userIdCard", user.getIdentityCard());
        return url;
    }

    @RequestMapping(value = "/cdm/hmCard/save")
    @ResponseBody
    public Object saveHmCard(DmDiseaseInfo diseaseInfo, String orgCode, String userIdCard, HttpServletRequest request) {
        setCurrentUserInfoToDis(diseaseInfo, orgCode, userIdCard);
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
        Map<String, String> managedOrgMap = new HashMap<>();
        Set<String> result = standardizationService.addManage(diseaseInfo, linkMapGxy, linkMapTnb, getCurrentUser(request).getName(),managedOrgMap);
        if(ObjectUtil.isNotEmpty(managedOrgMap)) {
            return managedOrgMap;
        }
        if (ObjectUtil.isNullOrEmpty(result)) {
            record(request, OperationName.ADD);
        }
        removeSessionFile(true, request, linkMapGxy, linkMapTnb);
        return result;
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

    private void setCurrentUserInfoToDis(DmDiseaseInfo diseaseInfo, String orgCode, String userIdCard) {
        if (ObjectUtil.isNotEmpty(diseaseInfo)) {
            diseaseInfo.setCurrentUser(securityService.getUser(new Criteria("IDENTITY_CARD", userIdCard)));
            diseaseInfo.setCurrentOrganization(organizationApp.queryOrgan(orgCode));
        }
    }

    /**
     * 记录操作日志
     *
     * @param request
     * @param op
     */
    protected void record(HttpServletRequest request, OperationName op) {
        createOperationLog(request, RhipModuleName.CDM, CONTROLLER_NAME, op);
    }

    /**
     * 判断按随访计划是否需要填写随访
     * 0表示不需要随访 机构名称表示需要随访表示的是相应慢病的管理机构
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/cdm/needFollowup")
    public void needFollowup(HttpServletRequest request, HttpServletResponse response, ModelMap model, String queryString) throws IOException {
        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            response.getWriter().write("var result=[\"-2\",\"-1\"];");
            return;
        }
        String idCard = getFieldValue(paramMap,"idCard");
        if (ObjectUtil.isNullOrEmpty(idCard)) {
            response.getWriter().write("var result=[\"-1\",\"-1\"];\n");
            return;
        }

        Criteria criteria = new Criteria("dmDiseaseInfo.STATUS", EHRConstants.DM_MANAGE_STATUS_NORMAL);//管理状态正常
        criteria.add("dmPersonInfo.IDCARD", idCard);//

        //慢病随访过期类型 30天内
        Date date = DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.MONTH, 1));
        String diseaseType = "1,2";//慢病类型
        criteria.add(createToFollowupDateRange(date));
        com.founder.rhip.ehr.dto.QueryForm form = new com.founder.rhip.ehr.dto.QueryForm();
//        form.setFollowupFlag(EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH);
        form.setFollowupFlag(EHRConstants.DM_FOLLOWUP_NEXT_MONTH_EXPIRED);
        PageList<DmDiseaseInfo> list = standardizationService.getManageCardWithFollowupCountList(new Page(5, 1, ""), criteria, form);

        String resultHbp = "0";
        String resultDi = "0";
        if (ObjectUtil.isNotEmpty(list) && ObjectUtil.isNotEmpty(list.getList())) {
            DmDiseaseInfo dmDiseaseInfo = list.getList().get(0);
            Date hbp = dmDiseaseInfo.getNextHbpFollowupDate();
            if (null != hbp && hbp.getTime() <= date.getTime() && ObjectUtil.equals(dmDiseaseInfo.getHbpFlag(), EHRConstants.DM_MANAGED_FLAG.toString())) {
                resultHbp = organizationApp.queryOrgan(dmDiseaseInfo.getCreateOrganCode()).getOrganName();
            }
            Date di = dmDiseaseInfo.getNextDiFollowupDate();
            if (null != di && di.getTime() <= date.getTime() && ObjectUtil.equals(dmDiseaseInfo.getDiFlag(), EHRConstants.DM_MANAGED_FLAG.toString())) {
                resultDi = organizationApp.queryOrgan(dmDiseaseInfo.getCreateOrganCode()).getOrganName();
            }
        }
        //这句话的意思，是让浏览器用utf8来解析返回的数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");
        String result = "var result=[\""+resultHbp+"\",\""+resultDi+"\"];\n";
        response.getWriter().write(result);

    }

    private Criteria createToFollowupDateRange(Date date) {
        Criteria nextHbpFollowupDate = new Criteria();
        Criteria nextDiFollowupDate = new Criteria();
        Criteria nextStrokeFollowupDate = new Criteria();
        Criteria nextCoronaryFollowupDate = new Criteria();
        Criteria nextTumorFollowupDate = new Criteria();
        Date dateBegin = null;//DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.MONTH, -1));
        DateUtil.getCriteriaByDateRange(nextHbpFollowupDate,"nextHbpFollowupDate", dateBegin, date );
        DateUtil.getCriteriaByDateRange(nextDiFollowupDate,"nextDiFollowupDate", dateBegin, date );
        DateUtil.getCriteriaByDateRange(nextStrokeFollowupDate,"nextStrokeFollowupDate", dateBegin, date );
        DateUtil.getCriteriaByDateRange(nextCoronaryFollowupDate,"nextCoronaryFollowupDate", dateBegin, date );
        DateUtil.getCriteriaByDateRange(nextTumorFollowupDate,"nextTumorFollowupDate", dateBegin, date );

        Criteria dateParam = new Criteria();
        dateParam.add(LOP.OR, nextHbpFollowupDate);
        dateParam.add(LOP.OR, nextDiFollowupDate);
        dateParam.add(LOP.OR, nextStrokeFollowupDate);
        dateParam.add(LOP.OR, nextCoronaryFollowupDate);
        dateParam.add(LOP.OR, nextTumorFollowupDate);
        return new Criteria().add(dateParam);
    }

    /**
     * 是否纳入管理
     * @param request
     * @param response
     * @param model
     * @param queryString
     */
    @RequestMapping(value = "/cdm/needHmCard")
    public void needHmCard(HttpServletRequest request, HttpServletResponse response, ModelMap model, String queryString) throws IOException {
        String[] result = new String[]{"0", "0"};
        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            response.getWriter().write("var result=[\"-1\",\"-1\"];");
            return;
        }
        String idCard = getFieldValue(paramMap, "idCard");
        Criteria criteria = new Criteria("IDCARD", idCard);
        criteria.add("STATUS", EHRConstants.DM_MANAGE_STATUS_NORMAL);
        if (ObjectUtil.isNullOrEmpty(idCard)) {
            response.getWriter().write("var result=[\"-1\",\"-1\"];\n");
            return;
        }
        DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);

        if (ObjectUtil.isNotEmpty(diseaseInfo)) {
            if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
                result[0] = "1";
            }
            if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
                result[1] = "1";
            }
        }
        response.getWriter().write("var result=[\"" + result[0] + "\",\"" + result[1] + "\"];\n");
    }

    /**
     * 是否创建保健计划
     *
     * @param request
     * @param response
     * @param model
     * @param queryString
     */
    @RequestMapping(value = "/cdm/needPlan")
    public void needPlan(HttpServletRequest request, HttpServletResponse response, ModelMap model, String queryString) throws IOException {
        String[] result = new String[]{"0", "0"};
        Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
        paramMap = decryptByCharset(queryString, paramMap);
        if (ObjectUtil.isNullOrEmpty(paramMap)) {//没有参数或者参数解析失败
            response.getWriter().write("var result=[\"-2\",\"" + result[1] + "\"];");
            return;
        }
        String idCard = getFieldValue(paramMap, "idCard");
        if (ObjectUtil.isNullOrEmpty(idCard)) {
            response.getWriter().write("var result=[\"-1\"];\n");
            return;
        }
        String diseaseType = getFieldValue(paramMap, "diseaseType");
        result[0] = this.isPlan(request, idCard, "1");//高血压
        result[1] = this.isPlan(request, idCard, "2");//糖尿病
        response.getWriter().write("var result=[\"" + result[0] + "\",\"" + result[1] + "\"];\n");
    }

    private String isPlan(HttpServletRequest request, String idCard, String diseaseType) {
        // 检查是否可以建立保健计划
        int currentYear = DateUtil.getCurrentYear();
        Criteria criteriaD = new Criteria("idcard", idCard);
        if(ObjectUtil.equals(diseaseType, "1")) {
            criteriaD.add("HBP_FLAG", EHRConstants.DM_MANAGED_FLAG);
        } else if(ObjectUtil.equals(diseaseType, "2")) {
            criteriaD.add("DI_FLAG", EHRConstants.DM_MANAGED_FLAG);
        }
        DmDiseaseInfo dmDiseaseInfo = diseaseInfoDao.get(criteriaD);

        if(ObjectUtil.isNullOrEmpty(dmDiseaseInfo) || ObjectUtil.equals(dmDiseaseInfo.getStatus(), EHRConstants.DM_MANAGE_STATUS_CANCEL)) {
            return "0";//该患者未进行慢病管理
        }
        Criteria criteria = new Criteria();
        criteria.add("personId", dmDiseaseInfo.getPersonId());
        criteria.add("diseaseType", diseaseType);

        // 检查其他
        List<DmHypertensionConclusion> dmConclusions = healthPalnService.getDmHypertensionConclusions(criteria);
        if (ObjectUtil.isNotEmpty(dmConclusions)) {
            DmHypertensionConclusion max = null;
            for (DmHypertensionConclusion dmConclusion : dmConclusions) {
                // 检查重复
                int conclusionsOfYear = dmConclusion.getConclusionsOfYear();
                if (currentYear == conclusionsOfYear) {
                    return "2";//已建保健计划
                }
                // 获取最后一年计划
                if (null == max) {
                    max = dmConclusion;
                    continue;
                } else if (max.getConclusionsOfYear() < conclusionsOfYear) {
                    max = dmConclusion;
                }
            }

            // 检查上一年度保健计划周期已经满一年
            if (null != max) {
                Date maxCreateDate = DateUtil.add(max.getCreateDate(), Calendar.YEAR, 1);
                if (maxCreateDate.compareTo(new Date()) >= 0) {
                    return "2";//已建保健计划 保健计划还没满一周年
                }
            }
        }
        return "1";//未建保健计划
    }

    private Criteria searchParameter(String idCard, String diseaseType, String planStatus) {
        Criteria criteria = new Criteria();

        if (ObjectUtil.isNotEmpty(idCard)) {
            criteria.add("idcard", idCard);
        }
        if (!ObjectUtil.isNullOrEmpty(diseaseType)) {
            criteria.add("diseaseType", diseaseType);
        }
        if (!ObjectUtil.isNullOrEmpty(planStatus)) {
            criteria.add("planStatus", planStatus);
        }
        return criteria;
    }

    /**
     *
     * @param userType:0表示传过来的是userIdCard,1表示传过来的是userCode
     * @param userCodeOrIdCard
     * @param user
     * @param model
     * @return
     */
    private boolean validateUser(String userType, String userCodeOrIdCard, User user, ModelMap model) {
        if (userType.equalsIgnoreCase("0") && ObjectUtil.isNullOrEmpty(userCodeOrIdCard)) {
            model.addAttribute("errorStr", "医务人员身份证号码不能为空!");
            return false;
        }
        if (userType.equalsIgnoreCase("1") && ObjectUtil.isNullOrEmpty(userCodeOrIdCard)) {
            model.addAttribute("errorStr", "医务人员编码不能为空!");
            return false;
        }
        if (ObjectUtil.isNullOrEmpty(user)) {
            model.addAttribute("errorStr", "平台系统中不存在此医务人员的用户信息!");
            return false;
        }
        return true;
    }
}