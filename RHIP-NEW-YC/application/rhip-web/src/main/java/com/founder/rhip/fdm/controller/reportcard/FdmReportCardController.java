package com.founder.rhip.fdm.controller.reportcard;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.OP;
import com.founder.fasf.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.founder.fasf.beans.BeanUtil;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.fdm.ReportStatus;
import com.founder.rhip.fdm.entity.FoodBorneReport;
import com.founder.rhip.fdm.entity.FoodTest;
import com.founder.rhip.fdm.repository.IFoodBorneReportDao;
import com.founder.rhip.fdm.service.IFoodBorneReportService;
import com.founder.rhip.fdm.service.IFoodTestService;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 食源性疾病 reportCard
 *
 * @author liuk
 */
@Controller
@RequestMapping({"/fdm/reportCard"})
public class FdmReportCardController extends BaseController {
    @Resource(name = "foodTestService")
    private IFoodTestService foodTestService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name = "platformService")
    private IPlatformService platformService;

    @Resource(name = "diseaseApp")
    private IDiseaseApp diseaseApp;

    @Resource(name = "reportRecordService")
    private IReportRecordService reportRecordService;

    @Resource(name = "foodBorneReportService")
    private IFoodBorneReportService foodBorneReportService;

    @Resource(name = "excelExportService")
    private IExcelExportService excelExportService;

    @Resource(name = "fdFoodborneReportDao")
    private IFoodBorneReportDao foodBorneReportDao;

    private static final String INDEX_PAGE_KEY = "indexPage";// resquest中的当前页的key
    private static final String PAGE_KEY = "page";// page key

    private static final String ERROR_PAGE_ID = "rhip.idm.report.error";
    private static final String ERROR_PAGE_MESSAGE_KEY = "errorMessage";
    private static final String CREATE_ORAGAN_CODE_KEY = "fillOrganCode";
    private static final String CREATE_ORAGAN_NAME_KEY = "fillOrganName";
    private static final String DISEASE_TYPE = "diseaseType";
    private static final String DISEASE_CODE = "diseaseCode";
    private static final String NAME = "name";
    private static final String IDCARD = "idcard";
    private static final String PARAM_KEY = "map";
    private static final String REPORT_RECORD_KEY = "reportRecordId";
    private static final String EHR_NO = "ehrNo";
    private static final String ADMISSION_NO = "admissionNo";
    private static final String DIAGNOSIS_ORGAN_CODE = "diagnosisOrganCode";
    private static final String CREATE_DOCTOR_CODE_KEY = "reportDoctorName";

    private static Properties properties;
    public FdmReportCardController() {
        super();
        properties = PropertiesUtils.initProperties("fdm");
    }

    @RequestMapping("/initAddReport")
    public String reportint(ModelMap model, HttpServletRequest request,String addFrom) {//食源性疾病内部报卡填写入口
        String url = "rhip.fdm.reportCard.report.csws";
        FoodBorneReport foodBorneReport = new FoodBorneReport();
        Organization org=getCurrentOrg(request);
        if(org!=null)
        {
            String orgCode=org.getOrganCode();
            foodBorneReport.setNo1(properties.getProperty(orgCode));
            foodBorneReport.setFillOrganCode(orgCode);
            foodBorneReport.setFillOrganName(org.getOrganName());
        }
        foodBorneReport.setReportDoctorName(getCurrentUser(request).getName());
        foodBorneReport.setFillDate(new Date());
        Calendar a=Calendar.getInstance();
        int current_year=a.get(Calendar.YEAR);
        // 设置年份  修改人：高飞  修改日期：20170810
        foodBorneReport.setYear(current_year);
        model.put("current_year", current_year);
        model.put("food", foodBorneReport);
        model.put("from", "csws");
        if(StringUtil.isNotEmpty(addFrom)){
            url = "rhip.fdm.reportCard.report.hsaRecordAdd";
            model.put("addFrom", addFrom);
        }
        return url;
    }

    @RequestMapping("/report")
    public String report(ModelMap model, HttpServletRequest request) {//食源性疾病外部报卡填写入口
        @SuppressWarnings("unchecked")
        Map<String, Object[]> map = (Map<String, Object[]>) request.getAttribute(PARAM_KEY);

        Long reportRecordId = null;
        try {
            reportRecordId = (Long) request.getAttribute(REPORT_RECORD_KEY);
        } catch (Exception e) {
            logger.error("报卡上报记录id解析失败", e);
        }

        // 检查记录id
        if (ObjectUtil.isNullOrEmpty(reportRecordId)) {
            model.put(ERROR_PAGE_MESSAGE_KEY, "无法获取上报记录");
            return ERROR_PAGE_ID;// 错误页面
        }

        // 检查必须参数
        if (ObjectUtil.isNullOrEmpty(map)) {
            model.put(ERROR_PAGE_MESSAGE_KEY, "参数错误");
            return ERROR_PAGE_ID;// 错误页面
        }

        // 检查字段合法性
        String createOrganCode = getFieldValue(map, CREATE_ORAGAN_CODE_KEY);
        if (!checkOrganCode(createOrganCode)) {
            String messageString = "机构参数不合法,无法找到此机构";
            logger.error(messageString);
            model.put(ERROR_PAGE_MESSAGE_KEY, messageString);
            return ERROR_PAGE_ID;// 错误页面
        }

        // bus
        // 获取人员基本信息
        FoodBorneReport foodBorneReport = BeanUtil.getBean(FoodBorneReport.class, map);
        foodBorneReport.setNo1(properties.getProperty(createOrganCode));
        Calendar a=Calendar.getInstance();
        int current_year=a.get(Calendar.YEAR);
        foodBorneReport.setYear(current_year);
        // 获取上报疾病相关信息
        String idcard = getFieldValue(map, IDCARD);

        // 有身份证,则根据身份证查到人员,如有存在此人员信息,则需要检查是否重复报卡
        if (ObjectUtil.isNotEmpty(idcard)) {
            PersonInfo ehrPerson = platformService.queryPersonalInfo(null, idcard);
            if (null != ehrPerson) {
                foodBorneReport.setPersonId(ehrPerson.getId());
                setPersonInfo(foodBorneReport, ehrPerson);
            }
        }

//        // 比对是否是从业人员  修改日期：20190314 修改人：高飞
//        Integer ret = platformService.isHealthCertPerson(idcard);
//        // 从业人员健康证体检，需要给前台返回标识，用来提醒
//        model.put("isHealthCertPerson", ret);

        // 设置报卡信息
        //设置门诊号
        foodBorneReport.setOutpatientNo(getFieldValue(map, EHR_NO)); // ehrNo
        foodBorneReport.setFillDate(new Date());
        foodBorneReport.setFillOrganCode(createOrganCode); // 填报机构
        foodBorneReport.setFillOrganName(organizationApp.queryOrganName(createOrganCode));
        foodBorneReport.setReportDoctorName(getFieldValue(map, CREATE_DOCTOR_CODE_KEY)); // 填报医生
        foodBorneReport.setDiagnosisDate(new Date());
        if(StringUtils.isEmpty(foodBorneReport.getIntestinalInfection()))
        {
            foodBorneReport.setIntestinalInfection("202");
        }
        if(StringUtils.isEmpty(foodBorneReport.getSpecimen()))
        {
            foodBorneReport.setSpecimen("1");
        }
        model.put("food", foodBorneReport);

        // 设置页面数据
        return "rhip.fdm.reportCard.report";
    }

    @RequestMapping("/reportSave")
    @ResponseBody
    public ModelMap reportSave(FoodBorneReport report, HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();
        try {
            final Organization organization = new Organization();
            organization.setOrganCode(report.getFillOrganCode());
            final User user = new User();
            user.setName(report.getReportDoctorName());
            resetDate(report, request);
//            doSaveAysn(report, organization, user);
            // 平台中填报的时候年份为空，这个地方需要判断为空的时候取当前年份 修改人：高飞  修改日期：20170810
            if (ObjectUtil.isNullOrEmpty(report.getYear())) {
                int year = DateUtil.getCurrentYear();
                report.setYear(year);
            }
            //获取当前登录用户角色并设置status
            if(hasRole(RoleType.YYCRB,request)||hasRole(RoleType.ZXCRB,request)||hasRole(RoleType.ZXWJ,request)||hasRole(RoleType.JKFYK,request)||hasRole(RoleType.ADMIN,request)){
                report.setStatus(ReportStatus.FBK_PASS.getValue());
            }else{//走外部报卡的情况,要先到医院-传染病、中心-传染病先审核
                report.setStatus(ReportStatus.REPORT_SAVED.getValue());
            }
            String num_2=  foodBorneReportService.saveReport(report, organization, user, null);
            modelMap.addAttribute("success", true);
            modelMap.addAttribute("message", "上报成功！");
            modelMap.addAttribute("num_2", num_2);
        } catch (Exception e) {
            logger.error("保存报卡失败", e);
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "上报失败！");
        }
        return modelMap;
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        return "rhip.fdm.reportCard.list";
    }


    @RequestMapping("/listResult")
    public String listResult(QueryForm form, HttpServletRequest request, Model model) {
        Page page = buildPage(request);
        Criteria criteria = form.toCriteria();
        Organization organization = getCurrentOrg(request);
        //医院-传染病、中心-传染病、中心-卫监角色登录时，看当前登录机构,并查询对应机构编码下的数据
        if (hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZXCRB, request)||hasRole(RoleType.ZXWJ, request)) {
            if("A100".equals(organization.getGenreCode())||"B100".equals(organization.getGenreCode())){
                criteria.add("fillOrganCode", organization.getOrganCode());
            }
        }
        //疾控、Admin角色登录时
        if(hasRole(RoleType.ADMIN,request)||hasRole(RoleType.JKFYK,request)){
            List<String> statusList = new ArrayList<>();
            statusList.add(ReportStatus.FBK_REJECT.getValue());
            criteria.add("status", OP.NOTIN, statusList);
        }
        List<FoodBorneReport> records = foodBorneReportService.getPagedReports(page, criteria, null, getCurrentOrg(request));
        model.addAttribute("records", records);
        return "rhip.fdm.reportCard.listResult";
    }

    /**
     * 报卡审核  modify by tuyz 20190814
     * @param op
     * @param report
     * @param request
     * @return
     */
    @RequestMapping("/app")
    @ResponseBody
    private Object app(@RequestParam("op") String op, FoodBorneReport report, HttpServletRequest request) {
        boolean result = false;
        //防保科（医院-传染病、中心传染病）
        if ((hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZXCRB, request))) {
            if ("1".equals(op)) {//医院-传染病、中心传染病 通过
                report.setStatus(ReportStatus.FBK_PASS.getValue());
            }
            if ("2".equals(op)) {//医院-传染病、中心传染病 不通过
                report.setStatus(ReportStatus.FBK_REJECT.getValue());
            }
        }
        //疾控卫生科
        if (hasRole(RoleType.JKFYK, request)) {
            if ("4".equals(op)) {//疾控-传染病 通过
                report.setStatus(ReportStatus.JK_PASS.getValue());
            }
            if ("6".equals(op)) {//疾控-传染病 打回
                report.setStatus(ReportStatus.JK_REJECT.getValue());
            }
            if ("5".equals(op)) {//疾控-传染病 作废
                report.setStatus(ReportStatus.JK_CALCEL.getValue());
            }
        }
        foodBorneReportService.updateReport(report);
        result = true;

        return result;
    }

    /**
     * 疾控打回后保存修改
     * @param report
     * @param request
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    private Object save(FoodBorneReport report, HttpServletRequest request) {
        boolean result = true;
        try {
            resetDate(report, request);
            foodBorneReportService.updateReport(report, getCurrentOrg(request), getCurrentUser(request));
        } catch (Exception e) {
            logger.error("修改失败", e);
            result = true;
        }
        return result;

    }

    @RequestMapping("/view")
    public String view(@RequestParam("id") Long id, HttpServletRequest request, Model model) {
        FoodBorneReport report = foodBorneReportService.getReport(id);
        Date date= report.getFillDate();
        Integer year=null;
        if(date!=null)
            year =1900+date.getYear();//获取年份
        model.addAttribute("current_year", year);
        model.addAttribute("food", report);
        return "rhip.fdm.reportCard.view";
    }

    /**
     * 疾控进入审核页面
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/lastAuth")
    public String lastAuth(@RequestParam("id") Long id, HttpServletRequest request, Model model) {
        FoodBorneReport report = foodBorneReportService.getReport(id);
        FoodTest foodTest = foodTestService.getFoodTest(new Criteria("reportId", id));
        model.addAttribute("food", report);
        model.addAttribute("foodTest", foodTest);
        return "rhip.fdm.reportCard.lastAuth";
    }

    /**
     * 医院-传染病、中心-传染病进入审核页面
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String edit(@RequestParam("id") Long id, HttpServletRequest request, Model model) {
        FoodBorneReport report = foodBorneReportService.getReport(id);
        model.addAttribute("food", report);
        return "rhip.fdm.reportCard.edit";
    }


    /**
     * 打印报卡
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/printReport")
    public String printReport(ModelMap model, Long id) {
//    	Long[] reportIds = getIds(ids);
        FoodBorneReport report = foodBorneReportService.getReport(id);
        Date date= report.getFillDate();
        Integer year=null;
        if(date!=null)
            year =1900+date.getYear();//获取年份
        model.addAttribute("current_year", year);
        model.addAttribute("food", report);
        return "rhip.fdm.reportCard.print";
    }


    /**
     * getFieldValue
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
     * checkOrganCode
     *
     * @param orgCode
     * @return
     */
    private boolean checkOrganCode(String orgCode) {
        Organization organization = organizationApp.queryOrgan(orgCode);
        return null != organization;
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
     * 获取角色
     *
     * @param request
     * @return
     */
    public RoleType getRole(HttpServletRequest request) {
        RoleType role = null;

        List<String> roles = getCurrentUserRoles(request);
        for (String string : roles) {
            if (RoleType.YYCRB.getValue().equals(string)) {//医院-传染病
                role = RoleType.YYCRB;
                break;
            } else if (RoleType.ADMIN.getValue().equals(string)) {
                role = RoleType.ADMIN;
                break;
            } else if (RoleType.ZXCRB.getValue().equals(string)) {//中心-传染病
                role = RoleType.ZXCRB;
                break;

            } else if (RoleType.ZXWJ.getValue().equals(string)) {//中心-卫监
                role = RoleType.ZXWJ;
                break;
            } else if (RoleType.JKFYK.getValue().equals(string)) {//疾控-传染病
                role = RoleType.JKFYK;
                break;
            }
        }
        //修正疾病信息科访问报错问题
//        Assert.notNull(role, "没有权限,请更换用户登录");
        return role;
    }

    /**
     * 如果人员生日为空,则根据身份证设置生日
     *
     * @param personInfo
     * @return
     */
    public Date setBirthday(PersonInfo personInfo) {
        Date birthday = personInfo.getBirthday();
        if (ObjectUtil.isNullOrEmpty(birthday)) {
            String idcard = personInfo.getIdcard();
            if (ObjectUtil.isNotEmpty(idcard)) {
                // 如果没有生日,根据身份证算出
                birthday = IDCardUtil.getBirthDateByIdCard(idcard);
                personInfo.setBirthday(birthday);
            }
        }
        return birthday;
    }

    /**
     * 当前controller类功能描述
     *
     * @return
     */
    protected String getActionName() {
        String clazzName = this.getClass().getName();
        return clazzName;
    }

    /**
     * 记录操作日志
     *
     * @param request
     * @param op
     */
    protected void record(HttpServletRequest request, OperationName op) {
    }

    @SuppressWarnings("unused")
    private void addTestData(HttpServletRequest request) {
        FoodBorneReport foodBorneReport = new FoodBorneReport();
        foodBorneReport.setName("刘凯");
        foodBorneReport.setBirthday(new Date());
        foodBorneReport.setGender("1");
        foodBorneReport.setIdcard("");
        foodBorneReport.setFillDate(new Date());
        foodBorneReportService.saveReport(foodBorneReport, getCurrentOrg(request), getCurrentUser(request), getRole(request));
    }

    /**
     * 设置人员信息 仅补充不存在的信息
     *
     * @param dmPersonInfo
     * @param personInfo
     */
    private void setPersonInfo(FoodBorneReport dmPersonInfo, PersonInfo personInfo) {
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getBirthday())) {
            setBirthday(personInfo);
            dmPersonInfo.setBirthday(personInfo.getBirthday());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getGender())) {
            dmPersonInfo.setGender(personInfo.getGender());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getPhoneNumber())) {
            dmPersonInfo.setPhoneNumber(personInfo.getPhoneNumber());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getPastreet())) {
            dmPersonInfo.setPastreet(personInfo.getPastreet());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getPatownShip())) {
            dmPersonInfo.setPatownShip(personInfo.getPatownShip());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getPahouseNumber())) {
            dmPersonInfo.setPahouseNumber(personInfo.getPahouseNumber());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getHrstreet())) {
            dmPersonInfo.setHrstreet(personInfo.getHrstreet());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getHrtownShip())) {
            dmPersonInfo.setHrtownShip(personInfo.getHrtownShip());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getHrhouseNumber())) {
            dmPersonInfo.setHrhouseNumber(personInfo.getHrhouseNumber());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getInfectedpersonOccupation())) {
            dmPersonInfo.setInfectedpersonOccupation(personInfo.getOccupation());
        }
        if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getFloatPopulation()) && "1".equalsIgnoreCase(personInfo.getHouseholdType())) {
            dmPersonInfo.setFloatPopulation(personInfo.getHouseholdType());
        }

    }

    private void resetDate(FoodBorneReport report, HttpServletRequest request) {
        String pathogenesisDate = request.getParameter("pathogenesisDate");
        if (ObjectUtil.isNotEmpty(pathogenesisDate)) {
            report.setPathogenesisDate(DateUtil.convert("yyyy/MM/dd HH:mm:ss", pathogenesisDate));
        }
        String diagnosisDate = request.getParameter("diagnosisDate");
        if (ObjectUtil.isNotEmpty(diagnosisDate)) {
            report.setDiagnosisDate(DateUtil.convert("yyyy/MM/dd HH:mm:ss", diagnosisDate));
        }
        String foodDate1 = request.getParameter("foodDate1");
        String foodDate2 = request.getParameter("foodDate2");
        if (ObjectUtil.isNotEmpty(foodDate1)) {
            report.setFoodDate1(DateUtil.convert("yyyy/MM/dd HH:mm:ss", foodDate1));
        }
        if (ObjectUtil.isNotEmpty(foodDate2)) {
            report.setFoodDate2(DateUtil.convert("yyyy/MM/dd HH:mm:ss", foodDate2));
        }
    }

}
