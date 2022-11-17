package com.founder.rhip.cdm.controller.reportcard;

import com.founder.fasf.beans.*;
import com.founder.fasf.exception.BaseException;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IReportCardService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.ehr.entity.management.DmReportInfo;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.util.ConvertToolUtil;
import net.sf.json.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 慢病报卡
 *
 * @author liuk
 */
@Controller
@RequestMapping({ "/cdm/reportcard", "/cdm/reportCard" })
public class ReportCardController extends CdmBaseController {

    /**
     * The constant CONTROLLER_NAME.
     */
	private final static String CONTROLLER_NAME = "慢病报卡";

    /**
     * The Report card service.
     */
	@Resource(name = "reportCardService")
	private IReportCardService reportCardService;

    /**
     * 获取上报医生
     */
    @Autowired
    @Qualifier(value="cdmReportCardListCreateDoctorNameGetter")
    private IValueGetter createDoctorNameGetter;

    /**
     * The Organization app.
     */
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

    /**
     * The Platform service.
     */
	@Resource(name = "platformService")
	private IPlatformService platformService;

    /**
     * The Disease app.
     */
	@Resource(name = "diseaseApp")
	private IDiseaseApp diseaseApp;

    /**
     * The Report record service.
     */
	@Resource(name = "reportRecordService")
	private IReportRecordService reportRecordService;

    @Resource(name = "excelExportService")
    private IExcelExportService excelExportService;

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;

    /**
     * The Hos code type map.
     */
	private Map<String, String> hosCodeTypeMap = new HashMap<>();
    /**
     * The Hos report required fields.
     */
	private Set<String> hosReportRequiredFields = new HashSet<>();

    /**
     * The constant ERROR_PAGE_ID.
     */
	private static final String ERROR_PAGE_ID = "rhip.idm.report.error";
    /**
     * The constant ERROR_PAGE_MESSAGE_KEY.
     */
	private static final String ERROR_PAGE_MESSAGE_KEY = "errorMessage";
    /**
     * The constant CREATE_ORAGAN_CODE_KEY.
     */
	private static final String CREATE_ORAGAN_CODE_KEY = "fillOrganCode";
    /**
     * The constant DISEASE_TYPE.
     */
	private static final String DISEASE_TYPE = "diseaseType";
    /**
     * The constant DISEASE_CODE.
     */
	private static final String DISEASE_CODE = "diseaseCode";
    /**
     * The constant NAME.
     */
	private static final String NAME = "name";
    /**
     * The constant IDCARD.
     */
	private static final String IDCARD = "idcard";
    /**
     * The constant PARAM_KEY.
     */
	private static final String PARAM_KEY = "map";
    /**
     * The constant REPORT_RECORD_KEY.
     */
	private static final String REPORT_RECORD_KEY = "reportRecordId";
    /**
     * The constant EHR_NO.
     */
	private static final String EHR_NO = "ehrNo";
    /**
     * The constant ADMISSION_NO.
     */
	private static final String ADMISSION_NO = "admissionNo";
    /**
     * The constant DIAGNOSIS_ORGAN_CODE.
     */
	private static final String DIAGNOSIS_ORGAN_CODE = "diagnosisOrganCode";
    /**
     * The constant CREATE_DOCTOR_CODE_KEY.
     */
	private static final String CREATE_DOCTOR_CODE_KEY = "reportDoctorName";

	/**
	 * 发病日期
	 */
	private static final String PATHOGENESIS_DATE="pathogenesisDate";

    /**
     * 肿瘤疾病icd10 json数据缓存key
     */
    private static final String DIS_JSON_KEY = "disJsonKey";


    /**
     * 缓存
     */
    private final static Map<String, Object> CACHE = new ConcurrentHashMap<>();


    /**
     * Instantiates a new Report card controller.
     */
	public ReportCardController() {
		super();
		// 糖尿病
		hosCodeTypeMap.put("E10.900", "1");// 1型糖尿病 E10.900 DMD00007 1
		hosCodeTypeMap.put("E11.900", "2");// 2型糖尿病 E11.900 DMD00007 2
		hosCodeTypeMap.put("O24.900", "3");// 妊娠期糖尿病 O24.900 DMD00007 3
		hosCodeTypeMap.put("E13.900", "4"); // 其他特殊类型 E13.900 DMD00007 4
		// 冠心病
		hosCodeTypeMap.put("I21.900", "1");// 急性心梗 I21.900 DMD00008 1
		hosCodeTypeMap.put("I20.900", "2"); // 心绞痛 I20.900 DMD00008 2
		hosCodeTypeMap.put("I25.900", "3"); // 冠心病猝死 I25.900 / DMD00008 3
		hosCodeTypeMap.put("I25.902", "4"); // 其他 I25.902 DMD00008 4 其它
		// 脑卒中
		hosCodeTypeMap.put("I61.900", "1"); // 脑出血 I61.900 DMD00 09 1
		hosCodeTypeMap.put("I63.900", "2"); // 脑梗塞 I63.900 DMD00009 2
		hosCodeTypeMap.put("I60.900", "3"); // 蛛网膜下腔出血 I60.900 DMD00009 3
		hosCodeTypeMap.put("I64.x00", "4");// 未分类 I64.x00 DMD00009 4
		// 肿瘤无二级类型

		// 院内报卡上报必须字段
		hosReportRequiredFields.add(NAME);
		hosReportRequiredFields.add(DISEASE_TYPE);
		hosReportRequiredFields.add(DISEASE_CODE);
		hosReportRequiredFields.add(CREATE_ORAGAN_CODE_KEY);
		hosReportRequiredFields.add(CREATE_DOCTOR_CODE_KEY);

	}

    /**
     * 慢病报卡查看页面
     *
     * @param request             the request
     * @param model             the model
     * @return string string
     */
	@RequestMapping(value = "/viewList")
	public String viewListSearch(HttpServletRequest request, ModelMap model) {
		// model.addAttribute("approvalFlg",
		// SecurityUtils.hasRole(RoleType.ZXMB,request) ? true : false);
		return "rhip.cdm.base.reportCard.view";
	}

    /**
     * 慢病报卡审核页面
     *
     * @param request             the request
     * @param model             the model
     * @return string string
     */
	@RequestMapping(value = "/verifyList")
	public String verifyListSearch(HttpServletRequest request, ModelMap model, String reportStatus) {
		model.addAttribute("reportStatus", reportStatus);
		return "rhip.cdm.base.reportCard.verify";
	}

    /**
     * 慢病报卡纳入页面
     *
     * @param request             the request
     * @param model             the model
     * @return string string
     */
	@RequestMapping(value = "/manageList")
	public String manageListSearch(HttpServletRequest request, ModelMap model) {
		// model.addAttribute("approvalFlg",
		// SecurityUtils.hasRole(RoleType.ZXMB,request) ? true : false);
		return "rhip.cdm.base.reportCard.manage";
	}

    /**
     * 测试外部报卡页面
     *
     * @return string string
     */
	@RequestMapping("/test")
	public String hostest() {
		return "rhip.cdm.base.reportCard.hospitaltest";
	}

    /**
     * 接口上报
     *
     * @param model             the model
     * @param request             the request
     * @return string string
     */
	@RequestMapping("/hospitalreport")
	public String reportService(ModelMap model, HttpServletRequest request) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String, Object[]> map = (Map<String, Object[]>) request.getAttribute(PARAM_KEY);

		Long reportRecordId = null;
		try {
			reportRecordId = (Long) request.getAttribute(REPORT_RECORD_KEY);
		} catch (Exception e) {
			logger.error("外部慢病报卡上报记录id解析失败", e);
		}

		// 检查记录id
		if (ObjectUtil.isNullOrEmpty(reportRecordId)) {
			model.put(ERROR_PAGE_MESSAGE_KEY, "无法获取上报记录");
			return ERROR_PAGE_ID;// 错误页面
		}

		// 检查必须参数
		if (ObjectUtil.isNullOrEmpty(map) || !checkRequiredField(map)) {
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

		String subDisType = getFieldValue(map, "subDisType");// (null !=
																// request.getAttribute("subDisType")
																// ? (String)
																// request.getAttribute("subDisType")
																// : null);

		// 获取人员基本信息
		PersonInfo personInfo = BeanUtil.getBean(PersonInfo.class, map);

		// 获取上报疾病相关信息
		String diseaseType = getFieldValue(map, DISEASE_TYPE);
		String idcard = getFieldValue(map, IDCARD);
		String diseaseCode = getFieldValue(map, DISEASE_CODE);

        // Fix B130704-009 系统内部日期解析格式与此不同,故重新转换一次
        // TODO 系统日期转换一致性问题
        String birthday = getFieldValue(map, "birthday");
        if (ObjectUtil.isNotEmpty(birthday) && null == personInfo.getBirthday()) {
            Date birthdayDate = DateUtil.parseSimpleDate(birthday, EHRConstants.COMMON_DATE_PATTERN);
            personInfo.setBirthday(birthdayDate);
        }

        if(null==personInfo.getBirthday()&& ObjectUtil.isNotEmpty(idcard)){
            personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(idcard));
        }

        //接口中基本信息优先
		PersonInfo personInfoDB = platformService.queryPersonalInfo(new Criteria("idcard", personInfo.getIdcard()));
		if(ObjectUtil.isNullOrEmpty(personInfo.getInputOrganName())&&ObjectUtil.isNotEmpty(personInfoDB)) {
			personInfo.setInputOrganName(organizationApp.queryOrganName(personInfoDB.getInputOrganCode()));
		}

		// 计算上报疾病类型
		DmReportInfo reportInfo = new DmReportInfo();
		//发病日期
		String pathogenesisStr = getFieldValue(map, PATHOGENESIS_DATE);
		if (ObjectUtil.isNotEmpty(pathogenesisStr)) {
			Date pathogenesisDate = DateUtil.parseSimpleDate(birthday, EHRConstants.COMMON_DATE_PATTERN);
			reportInfo.setDiAccidentDate(pathogenesisDate);
		}
		boolean[] reportAbledFlags = new boolean[] { false, false, false, false, false };
		switch (diseaseType) {
		case EHRConstants.DM_DI_TYPE:
			String diDiseaseType = subDisType;// hosCodeTypeMap.get(diseaseCode);
			reportInfo.setDiFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setDiType(diDiseaseType);
			reportInfo.setDiIcdTenCode(diseaseCode);
			reportAbledFlags[0] = true;
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			String coronaryDiseaseType = subDisType;// hosCodeTypeMap.get(diseaseCode);
			reportInfo.setCoronaryFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setCoronaryType(coronaryDiseaseType);
			reportInfo.setCoronaryIcdTenCode(diseaseCode);
			reportAbledFlags[1] = true;
			break;
		case EHRConstants.DM_STROKE_TYPE:
			String strokeDiseaseType = subDisType;// hosCodeTypeMap.get(diseaseCode);
			reportInfo.setStrokeFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setStrokeType(strokeDiseaseType);
			reportInfo.setStrokeIcdTenCode(diseaseCode);
			reportAbledFlags[2] = true;
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			reportInfo.setTumorFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setTumorIcdTenCode(diseaseCode);
			reportAbledFlags[3] = true;
            Disease disease=diseaseApp.queryDisease(diseaseCode);
			try {
				if (null != disease) {
					reportInfo.setTumorType(disease.getDiseaseName());
				}
			} catch (Exception e) {
				logger.error("", e);
			}
			break;
		case EHRConstants.DM_HBP_TYPE:
			reportInfo.setHbpFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setHbpType(subDisType);
			reportInfo.setHbpIcdTenCode(diseaseCode);
			reportAbledFlags[4] = true;
			break;
		}

		// 设置诊断日期为当前日期
		reportInfo.setDiDiagnosisDate(new Date());
		reportInfo.setTumorDiagnosisDate(new Date());
		reportInfo.setCoronaryDiagnosisDate(new Date());
		reportInfo.setStrokeDiagnosisDate(new Date());

		// 有身份证,则根据身份证查到人员,如有存在此人员信息,则需要检查是否重复报卡
		if (ObjectUtil.isNotEmpty(idcard)) {
			PersonInfo ehrPerson = platformService.queryPersonalInfo(null, idcard);
			if (null != ehrPerson) {
				reportInfo.setPersonId(ehrPerson.getId());
				personInfo.setId(ehrPerson.getId());
				if (ObjectUtil.isNotEmpty(subDisType)|| EHRConstants.DM_TUMOR_TYPE.equals(diseaseType)) {
					// 检查重复
					// !!!因为报卡无法准确获取二级类型,所以暂时去掉重复检查 不要删掉此处
					Map<String, Boolean> checkedResults = reportCardService.checkDuplicateReport(reportInfo);
					//遍历result，有任何一种病不能上报则不能上报
					if (checkedResults.containsValue(false)) {
						if (null != reportRecordId) {
							try {
								reportRecordService.update(reportRecordId, null, EHRConstants.DM_REPEAT);
							} catch (Exception e) {
								logger.error("重复报卡状态保存失败", e);
								logger.error("该报卡身份证为:"+idcard);
							}
						}
						// 重复提示页面
						model.put(ERROR_PAGE_MESSAGE_KEY, ehrPerson.getName() + "无需报卡");
						return ERROR_PAGE_ID;
					}
				}
				// !!! 不要删掉此处 end
				// 根据平台人员信息,补充报卡人员信息
				setPersonInfo(personInfo, ehrPerson);
			}
		}

		// 设置报卡信息
		reportInfo.setEhrNo(getFieldValue(map, EHR_NO)); // ehrNo 门诊号
		reportInfo.setAdmissionNo(getFieldValue(map, ADMISSION_NO)); // 住院号
		reportInfo.setCreateOrganCode(createOrganCode); // 填报机构
		reportInfo.setCreateDoctorName(getFieldValue(map, CREATE_DOCTOR_CODE_KEY)); // 填报医生
		reportInfo.setDiagnosisOrganCode(getFieldValue(map, DIAGNOSIS_ORGAN_CODE)); // 诊断机构
		reportInfo.setCreateDate(new Date());
		reportInfo.setHosReportRecordId(reportRecordId);// 上报记录

		// 默认为已婚
		if (ObjectUtil.isNullOrEmpty(personInfo.getMarriage())) {
			personInfo.setMarriage("20");
		}

        //计算性别
        if (ObjectUtil.isNullOrEmpty(personInfo.getGender())&& ObjectUtil.isNotEmpty(idcard)){
            personInfo.setGender(IDCardUtil.getGenderByIdCard(idcard));
        }

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date disagDate = sdf.parse(ConvertToolUtil.getFieldValue(map, "diagnosisDate"));
		if (null == disagDate) {
			disagDate = new Date();
		}

		reportInfo.setHbpDiagnosisDate(disagDate);
		reportInfo.setDiDiagnosisDate(disagDate);
		reportInfo.setTumorDiagnosisDate(disagDate);
		reportInfo.setCoronaryDiagnosisDate(disagDate);
		reportInfo.setStrokeDiagnosisDate(disagDate);

		Date pathogenesisDate = sdf.parse(ConvertToolUtil.getFieldValue(map, "pathogenesisDate"));
		if (null == pathogenesisDate) {
			pathogenesisDate = new Date();
		}
		reportInfo.setHbpAccidentDate(pathogenesisDate);
		reportInfo.setDiAccidentDate(pathogenesisDate);
		reportInfo.setCoronaryAccidentDate(pathogenesisDate);
		reportInfo.setTumorAccidentDate(pathogenesisDate);
		reportInfo.setStrokeAccidentDate(pathogenesisDate);
		// 设置页面数据
		model.addAttribute("reportAbledFlags", reportAbledFlags);// 用于判断显示那些上报疾病..
		model.addAttribute("reportInfo", reportInfo);
		model.addAttribute("personInfo", personInfo);
		model.addAttribute("hospitalaReport", true);// 标志为院内上报
		model.addAttribute("hideAlloc", true);// 不显示分配
		return "rhip.cdm.base.reportCard.hospitaladd";
	}

    /**
     * Resubmit string.
     *
     * @param reportRecordId             the report record id
     * @param request             the request
     * @param model             the model
     * @return the string
     */
	@RequestMapping("/rereport")
	public String resubmit(@RequestParam(value = "reportRecordId") Long reportRecordId, HttpServletRequest request, ModelMap model) {
		// 检查并获取报卡记录数据
		if (ObjectUtil.isNullOrEmpty(reportRecordId)) {
			model.put("errorMessage", "报卡监控记录ID为空");
			return "rhip.idm.report.error";
		}
		ReportRecord reportRecord = reportRecordService.getReportRecord(reportRecordId);
		if (ObjectUtil.isNullOrEmpty(reportRecord)) {
			model.put("errorMessage", "报卡监控记录为空");
			return "rhip.idm.report.error";
		}

		// 根据报卡记录设置基本信息
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName(reportRecord.getName());
		personInfo.setBirthday(personInfo.getBirthday());
		personInfo.setGender(reportRecord.getGender());
		personInfo.setMarriage(reportRecord.getMarriage());
		personInfo.setEducation(reportRecord.getEducation());
		personInfo.setOccupation(reportRecord.getOccupation());
		personInfo.setNation(reportRecord.getNation());
		personInfo.setPhoneNumber(reportRecord.getPhoneNumber());
		personInfo.setUnitName(reportRecord.getUnitName());

        String idcard = reportRecord.getIdcard();
        if(null==personInfo.getBirthday()&& ObjectUtil.isNotEmpty(idcard)){
            personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(idcard));
        }

		// 根据报卡记录设置报卡信息
		DmReportInfo reportInfo = new DmReportInfo();
		reportInfo.setEhrNo(reportRecord.getEhrNo()); // ehrNo 门诊号
		reportInfo.setAdmissionNo(reportRecord.getAdmissionNo()); // 住院号
		reportInfo.setCreateOrganCode(getCurrentOrg(request).getOrganCode()); // 填报机构
		User user = getCurrentUser(request);
		reportInfo.setCreateDoctorName(user.getName()); // 填报医生
		reportInfo.setDiagnosisOrganCode(reportRecord.getDiagnosisOrganCode()); // 诊断机构
		reportInfo.setCreateDate(new Date());
		reportInfo.setHosReportRecordId(reportRecordId);// 上报记录
		Date disagDate = reportRecord.getDiagnosisDate();
		if (null == disagDate) {
			disagDate = new Date();
		}
		reportInfo.setDiDiagnosisDate(disagDate);
		reportInfo.setTumorDiagnosisDate(disagDate);
		reportInfo.setCoronaryDiagnosisDate(disagDate);
		reportInfo.setStrokeDiagnosisDate(disagDate);

		// 设置报卡疾病信息
		String diseaseType = reportRecord.getIllnessSecondCode();
		String subDisType = "";
		boolean[] reportAbledFlags = new boolean[] { false, false, false, false, false };
		switch (diseaseType) {
		case EHRConstants.DM_DI_TYPE:
			String diDiseaseType = subDisType;// hosCodeTypeMap.get(diseaseCode);
			reportInfo.setDiFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setDiType(diDiseaseType);
			reportAbledFlags[0] = true;
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			String coronaryDiseaseType = subDisType;// hosCodeTypeMap.get(diseaseCode);
			reportInfo.setCoronaryFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setCoronaryType(coronaryDiseaseType);
			reportAbledFlags[1] = true;
			break;
		case EHRConstants.DM_STROKE_TYPE:
			String strokeDiseaseType = subDisType;// hosCodeTypeMap.get(diseaseCode);
			reportInfo.setStrokeFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setStrokeType(strokeDiseaseType);
			reportAbledFlags[2] = true;
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			reportInfo.setTumorFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setTumorIcdTenCode(reportRecord.getIllnessCode());
			reportAbledFlags[3] = true;
            try {
                Disease disease=diseaseApp.queryDisease(reportRecord.getIllnessCode());
                if (null!=disease){
                    reportInfo.setTumorType(disease.getDiseaseName());
                }
            }catch (Exception e){
                logger.error("",e);
            }
			break;
		case EHRConstants.DM_HBP_TYPE:
			reportInfo.setHbpFlag(EHRConstants.DM_REPORTED_FLAG);
			reportInfo.setHbpType(subDisType);
			reportAbledFlags[4] = true;
			break;
		}

		// 获取健康档案人员信息

		if (ObjectUtil.isNotEmpty(idcard)) {
			personInfo.setIdcard(idcard);
			PersonInfo ehrPerson = platformService.queryPersonalInfo(null, idcard);
			if (null != ehrPerson) {
				reportInfo.setPersonId(ehrPerson.getId());
				personInfo.setId(ehrPerson.getId());
				setPersonInfo(personInfo, ehrPerson);
			}
		}

		// 默认为已婚
		if (ObjectUtil.isNullOrEmpty(personInfo.getMarriage())) {
			personInfo.setMarriage("20");
		}

        //计算性别
        if (ObjectUtil.isNullOrEmpty(personInfo.getGender())&& ObjectUtil.isNotEmpty(idcard)){
            personInfo.setGender(IDCardUtil.getGenderByIdCard(idcard));
        }

		// 设置页面数据
		model.addAttribute("reportAbledFlags", reportAbledFlags);// 用于判断显示那些上报疾病..
		model.addAttribute("reportInfo", reportInfo);
		model.addAttribute("personInfo", personInfo);
		model.addAttribute("hospitalaReport", true);// 标志为院内上报
		model.addAttribute("reportRecordId");// 标志为院内上报
		return "rhip.cdm.base.reportCard.hosRecordAdd";
	}

    /**
     * 获取报卡列表,根据人员id分组显示
     *
     * @param queryForm             the query form
     * @param viewType             the view type
     * @param request             the request
     * @param model             the model
     * @return reports group by person
     */
	@RequestMapping("/list")
	public String getReportsGroupByPerson(QueryForm queryForm, @RequestParam(value = "viewType", required = false) String viewType, HttpServletRequest request, ModelMap model) {
		Page pg = buildPage(request);
		Criteria criteria = queryForm.toCriteria();
		RoleType roleType = getRole(request);
		setViewAndAppDefaultParam(queryForm, criteria, roleType, getCurrentOrg(request));
		List<DmPersonInfo> reportes = reportCardService.getReportsGroupByPersonId(pg, criteria);
		model.addAttribute("personInfoList", reportes);
		model.addAttribute("viewType", viewType);
		model.addAttribute("selectedReportStatus", queryForm.getReportStatus());
		return "rhip.cdm.base.reportCard.viewList";
	}

    /**
     * 导出报卡
     *
     * @param queryForm the query form
     * @param request the request
     * @param response the response
     * @param model the model
     * @return reports group by person
     */
    @RequestMapping("/listExcel")
    public void exportReportCardList(QueryForm queryForm, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        try {
            final Criteria criteria = queryForm.toCriteria();
            RoleType roleType = getRole(request);
            setViewAndAppDefaultParam(queryForm, criteria, roleType, getCurrentOrg(request));
            //自定义上报医生取值
            Map<String,IValueGetter> cus=new HashMap<>(1);
            cus.put("CREATE_DOCTOR_CODE",createDoctorNameGetter);
            final String title="报卡列表";
            excelExportService.exportListExecl(title,DmReportInfo.class,cus,response,new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    List<Map<String, Object>> dataSource = reportCardService.getDetailReportCardMapList(criteria);
                    return dataSource;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("报卡导出失败", e);
        }
    }

    /**
     * 设置查看的权限
     *
     * @param queryForm             the query form
     * @param criteria             the criteria
     * @param roleType             the role type
     * @param organization             the organization
     */
	private void setViewAndAppDefaultParam(QueryForm queryForm, Criteria criteria, RoleType roleType, Organization organization) {
		if (roleType.equals(RoleType.ZXMB)) {
			// 报卡状态条件
			String[] reports = queryForm.getReportStatusArray();
			// 审核页面,在审核时,只能看到下级上报的报卡.在分配时,只能看到分配给自己的报卡
			if (ObjectUtil.isNotEmpty(reports)) {
				for (String string : reports) {
					if (null != string) {
						string = string.trim();
						// 分配
						if (ApprovalState.VERIFIED_SECOND.getValue().equals(string) || ApprovalState.ALLOC_REJECT_SECOND.getValue().equals(string)) {
							criteria.add("dmReportInfo.SUPER_MANAGE_ORGAN_CODE", organization.getOrganCode());
							return;
						}
						// 审核
						if (ApprovalState.READY.getValue().equals(string) || ApprovalState.REJECT.getValue().equals(string)) {
							//0135278
							String orgCode = organization.getOrganCode();
							Criteria cOr= new Criteria("dmReportInfo.CREATE_ORGAN_CODE", orgCode).add(LOP.OR,"dmReportInfo.CREATE_CENTER_ORGAN_CODE",orgCode);
							criteria.add(cOr);
							return;
						}
						//报卡待纳入的只能看到分配给本机构的
						if (ApprovalState.ALLOCATED.getValue().equals(string) && ObjectUtil.isNotEmpty(queryForm.getIsDNR())) {
							criteria.add("dmReportInfo.MANAGE_ORGAN_CODE", organization.getOrganCode());
							return;
						} else if (ApprovalState.ALLOCATED.getValue().equals(string)) {
							criteria.add("dmReportInfo.SUPER_MANAGE_ORGAN_CODE", organization.getOrganCode());
							return;
						}
					}
				}
			}

			Criteria criteriaOr = new Criteria("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
			criteriaOr.add(LOP.OR, "dmReportInfo.SUPER_MANAGE_ORGAN_CODE", organization.getOrganCode());
			criteria.add(criteriaOr);

		} else if (roleType.equals(RoleType.YYMB)) {
			criteria.add("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if (roleType.equals(RoleType.ZMB)) {
			criteria.add("dmReportInfo.MANAGE_ORGAN_CODE", organization.getOrganCode());
		}
	}

    /**
     * 报卡
     *
     * @param model             the model
     * @param request             the request
     * @return string string
     */
	@RequestMapping("/report")
	public String report(ModelMap model, HttpServletRequest request) {
		removeFileSession(request);//删除session遗留附件
		request.getSession().removeAttribute("personInfo");
		boolean[] reportAbledFlags = new boolean[] { true, true, true, true, true };
		DmReportInfo dmReportInfo = new DmReportInfo();
		dmReportInfo.setDiDiagnosisDate(new Date());
		dmReportInfo.setTumorDiagnosisDate(new Date());
		dmReportInfo.setCoronaryDiagnosisDate(new Date());
		dmReportInfo.setStrokeDiagnosisDate(new Date());
		setReportInputInfo(true, dmReportInfo, request);
		model.addAttribute("reportInfo", dmReportInfo);
		model.addAttribute("reportAbledFlags", reportAbledFlags);
		return "rhip.cdm.base.reportCard.add";
	}

	private void removeFileSession(HttpServletRequest request){
		request.getSession().removeAttribute("mbglkgxy_fileMap");
		request.getSession().removeAttribute("mbglktnb_fileMap");
		request.getSession().removeAttribute("mbglkgxb_fileMap");
		request.getSession().removeAttribute("mbglkncz_fileMap");
		request.getSession().removeAttribute("mbglkzl_fileMap");
	}
	private  Object checkAttachment(DmReportInfo dmReportInfo, HttpServletRequest request){
		Map<String, Object> map =new HashMap<>();
		Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件-高血压
		map = validateAttchement(map, linkMapGxy, dmReportInfo.getId(), true);

		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		map =new HashMap<>();
		Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件-糖尿病
		map = validateAttchement(map, linkMapTnb, dmReportInfo.getId(), true);

		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		map =new HashMap<>();
		Map<String, String> linkMapGxb = (Map<String, String>) request.getSession().getAttribute("mbglkgxb_fileMap");//附件-冠心病

		map = validateAttchement(map, linkMapGxb, dmReportInfo.getId(), true);
		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		map =new HashMap<>();
		Map<String, String> linkMapNcz = (Map<String, String>) request.getSession().getAttribute("mbglkncz_fileMap");//附件-脑卒中

		map = validateAttchement(map, linkMapNcz, dmReportInfo.getId(), true);
		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		map =new HashMap<>();
		Map<String, String> linkMapZl = (Map<String, String>) request.getSession().getAttribute("mbglkzl_fileMap");//附件-肿瘤
		map = validateAttchement(map, linkMapZl, dmReportInfo.getId(), true);
		if(ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		return null;
	}
    /**
     * 上报保存
     *
     * @param dmReportInfo             the dm report info
     * @param request             the request
     * @return object object
     */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(DmReportInfo dmReportInfo, HttpServletRequest request) {
		Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件-高血压
		Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件-糖尿病
		Map<String, String> linkMapGxb = (Map<String, String>) request.getSession().getAttribute("mbglkgxb_fileMap");//附件-冠心病
		Map<String, String> linkMapNcz = (Map<String, String>) request.getSession().getAttribute("mbglkncz_fileMap");//附件-脑卒中
		Map<String, String> linkMapZl = (Map<String, String>) request.getSession().getAttribute("mbglkzl_fileMap");//附件-肿瘤
		//保存附件
		Object rsObj = checkAttachment(dmReportInfo,request);
		if(rsObj!=null)
			return rsObj;
		RoleType roleType = getRole(request);
		Map<String, Boolean> checkedResults = reportCardService.checkDuplicateReport(dmReportInfo);

		//遍历result，有任何一种病不能上报则不能上报
		if (checkedResults.containsValue(false)) {
			return checkedResults;
		}
		setReportInputInfo(true, dmReportInfo, request);

        boolean saveResult=false;

		try {
            saveResult=reportCardService.saveReportCard(dmReportInfo, roleType, getCurrentUser(request), getCurrentOrg(request),linkMapGxy,
					linkMapTnb,linkMapGxb,linkMapNcz,linkMapZl);
		} catch (BaseException e) {
            saveResult=false;
            logger.error("报卡保存失败",e);
            return e.getMessage();
		}

        if(saveResult){
			//remove会话中附件信息
			removeFileSession(request);
            return "success";
        }

		return "error";
	}


	@RequestMapping("/tumor/history")
	public String roleList(String idcard,  ModelMap model,HttpServletRequest request) {
		List<DmReportInfo> tumorList = new ArrayList<DmReportInfo>();
		tumorList = reportCardService.getTumorReportInfos(idcard);
		model.addAttribute("tumors", tumorList);
		return "rhip.ehr.reportCard.tumorList";
	}

    /**
     * 院内上报保存方法
     *
     * @param dmReportInfo             the dm report info
     * @param request             the request
     * @return object object
     */
	@RequestMapping("/hossave")
	@ResponseBody
	public Object hosSave(DmReportInfo dmReportInfo, HttpServletRequest request) {
		Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件-高血压
		Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件-糖尿病
		//保存附件
		Object rsObj = checkAttachment(dmReportInfo,request);
		if(rsObj!=null)
			return rsObj;
		RoleType roleType = RoleType.YYMB;// 医生上报
		User user = getCurrentUser(request);
		if (null == user) {
			user = new User();
		}
		Organization organization = organizationApp.queryOrgan(dmReportInfo.getCreateOrganCode());

		if(ObjectUtil.equals(organization.getGenreCode(), OrgGenreCode.STATION.getValue())) {
			roleType = RoleType.ZMB;// 医生上报
		}

		if (null == organization) {
			organization = new Organization();
		}
		doHosSaveSync(dmReportInfo, roleType, organization, user,linkMapGxy,linkMapTnb);
		return "success";
	}

    /**
     * 院内上报补报保存方法
     *
     * @param dmReportInfo             the dm report info
     * @param request             the request
     * @return object object
     */
	@RequestMapping("/hosReSave")
	@ResponseBody
	public Object hosReSave(DmReportInfo dmReportInfo, HttpServletRequest request) {
		Map<String, String> linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件-高血压
		Map<String, String> linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件-糖尿病
		RoleType roleType = RoleType.YYMB;// 医生上报
		User user = getCurrentUser(request);
		Organization organization = getCurrentOrg(request);
		Object result = "success";
		try {
			doHosSave(dmReportInfo, roleType, organization, user,linkMapGxy,linkMapTnb);
		} catch (Exception e) {
			logger.error("报卡保存失败", e);
			result = "error";
		}
		return result;
	}

    /**
     * Do hos save sync.
     *
     * @param dmReportInfo             the dm report info
     * @param roleType             the role type
     * @param organization             the organization
     * @param user             the user
     */
	private void doHosSaveSync(final DmReportInfo dmReportInfo, final RoleType roleType, final Organization organization, final User user,final Map linkMapGxy,final Map linkMapTnb) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					doHosSave(dmReportInfo, roleType, organization, user,linkMapGxy,linkMapTnb);
				} catch (Exception e) {
					logger.error("报卡保存失败", e);
				}
			}
		}).start();
	}

    /**
     * Do hos save.
     *
     * @param dmReportInfo             the dm report info
     * @param roleType             the role type
     * @param organization             the organization
     * @param user             the user
     */
	private void doHosSave(final DmReportInfo dmReportInfo, final RoleType roleType, final Organization organization, final User user,Map linkMapGxy,Map linkMapTnb) {
		Map<String, Boolean> checkedResults = reportCardService.checkDuplicateReport(dmReportInfo);
		//遍历result，有任何一种病不能上报则不能上报
		if (checkedResults.containsValue(false)) {
			logger.info("已经报卡无须上报");
			Long reportRecordId = dmReportInfo.getHosReportRecordId();
			if (null != reportRecordId) {
				reportRecordService.update(reportRecordId, null, EHRConstants.DM_REPEAT);
			}
			return;
		}
		organization.setOrganCode(dmReportInfo.getCreateOrganCode());
		user.setUserName(dmReportInfo.getCreateDoctorName());
		user.setName(dmReportInfo.getCreateDoctorName());
		// check nothing
		reportCardService.saveReportCard(dmReportInfo, roleType, user, organization,linkMapGxy,linkMapTnb,null,null,null);
	}

    /**
     * 获取输入人员信息和可报卡信息
     *
     * @param name             the name
     * @param idCard             the id card
     * @param model             the model
     * @param request             the request
     * @return object object
     */
	@RequestMapping("/load")
	public @ResponseBody
	Object load(@RequestParam(value = "personInfo.name", required = false) String name, @RequestParam("personInfo.idcard") String idCard, ModelMap model, HttpServletRequest request) {
		PersonInfo personInfo = platformService.queryPersonalInfo(null, StringUtil.trimAllWhitespace(idCard));
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
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
		List<DmReportInfo> tumorList = reportCardService.getTumorReportInfos(personInfo.getIdcard());
		if(ObjectUtil.isNotEmpty(tumorList)) {
			record.put("isShowTumor", true);
		}
		return record;
	}

    /**
     * View string.
     *
     * @param personId             the person id
     * @param model             the model
     * @param request             the request
     * @return the string
     */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long personId, ModelMap model, HttpServletRequest request) {
		RoleType roleType = getRole(request);
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		if(ObjectUtil.isNullOrEmpty(personInfo.getInputOrganName())) {
			personInfo.setInputOrganName(organizationApp.queryOrganName(personInfo.getInputOrganCode()));
		}
		model.put("personInfo", personInfo);

		if (ObjectUtil.isNullOrEmpty(roleType)) {
			return "rhip.cdm.base.reportCard.viewReport";
		}
		Criteria criteria = new Criteria("dmReportInfo.PERSON_ID", personId);
		Organization organization = getCurrentOrg(request);
		buildViewParam(criteria, roleType, organization);
		List<DmReportInfo> reportInfos = reportCardService.getReportCard(criteria);
		// add by Kevin Ro 2018-10-24 慢病附件查询，需要循环显示判断是什么类型的慢病 ******start******
		List<UploadInfoRecord> uploadInfoRecordsHbp = new ArrayList<UploadInfoRecord>();
		List<UploadInfoRecord> uploadInfoRecordsDi = new ArrayList<UploadInfoRecord>();
		for(DmReportInfo report : reportInfos) {
			String disType = report.getDisType();
			if(EHRConstants.DM_HBP_TYPE.equals(disType)) { // 高血压
				uploadInfoRecordsHbp.addAll(uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", report.getId()).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKGXY)));
			} else if(EHRConstants.DM_DI_TYPE.equals(disType)) { // 糖尿病
				uploadInfoRecordsDi.addAll(uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",report.getId()).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKTNB)));
			}
		}
		model.addAttribute("attchesHbp", uploadInfoRecordsHbp);
		model.addAttribute("attchesDi", uploadInfoRecordsDi);
		model.addAttribute("attchesHbpShow", uploadInfoRecordsHbp != null ? "是" : ""); // 前端页面附件是否显示标志
		model.addAttribute("attchesDiShow", uploadInfoRecordsDi !=null ? "是" : "");
		/******end******/

		model.put("allowPersonEditable", false);
		model.put("reportInfos", reportInfos);
		return "rhip.cdm.base.reportCard.viewReport";
	}

    /**
     * 根据人员Id查看所有报卡
     *
     * @param personId             the person id
     * @param model             the model
     * @param request             the request
     * @return string string
     */
	@RequestMapping("/app/{id}")
	public String appAll(@PathVariable("id") Long personId, ModelMap model, HttpServletRequest request) {
		return app(personId, null, model, request);
	}

    /**
     * 根据人员Id查看报卡
     *
     * @param personId             the person id
     * @param viewType             the view type
     * @param model             the model
     * @param request             the request
     * @return string string
     */
	@RequestMapping("/app/{id}/{viewType}")
	public String app(@PathVariable("id") Long personId, @PathVariable(value = "viewType") String viewType, ModelMap model, HttpServletRequest request) {
		RoleType roleType = getRole(request);
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		model.put("personInfo", personInfo);

		if (ObjectUtil.isNullOrEmpty(roleType)) {
			return "rhip.cdm.base.reportCard.viewReport";
		}
		Criteria criteria = new Criteria("dmReportInfo.PERSON_ID", personId);
		if (ObjectUtil.isNotEmpty(viewType)) {
			if (viewType.indexOf(",") != -1) {
				String[] status = viewType.split(",");
				criteria.add("cdmStatusInfo.REPORT_STATUS", OP.IN, status);
			} else {
				criteria.add("cdmStatusInfo.REPORT_STATUS", viewType);
			}
		}
		Organization organization = getCurrentOrg(request);
		buildViewParam(criteria, roleType, organization);
		List<DmReportInfo> reportInfos = reportCardService.getReportCard(criteria);
		boolean allowPersonEditable = false;
		boolean needAlloc = false;
		if (null != reportInfos) {
			for (DmReportInfo dmReportInfo : reportInfos) {
				checkApp(dmReportInfo, request);
				if (!allowPersonEditable) {
					allowPersonEditable = dmReportInfo.isAllowEdit();
				}
				if (!needAlloc) {
					needAlloc = dmReportInfo.isNeedAlloc();
				}
			}
		}

		// 如果需要分配,则计算分配单位
		if (needAlloc) {
			Organization managedReportInfo = reportCardService.getAllocOrganization(personId);
			if (null != managedReportInfo) {
				model.put("superManageOrganCode", managedReportInfo.getParentCode());
				model.put("manageOrganCode", managedReportInfo.getOrganCode());
			}
		}

		// add by Kevin Ro 2018-10-24 慢病附件查询，需要循环显示判断是什么类型的慢病 ******start******
		List<UploadInfoRecord> uploadInfoRecordsHbp = null;
		List<UploadInfoRecord> uploadInfoRecordsDi = null;
		for(DmReportInfo report : reportInfos) {
			String disType = report.getDisType();
			if(EHRConstants.DM_HBP_TYPE.equals(disType)) { // 高血压
				uploadInfoRecordsHbp = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", report.getId()).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKGXY));
			} else if(EHRConstants.DM_DI_TYPE.equals(disType)) { // 糖尿病
				uploadInfoRecordsDi = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",report.getId()).add("FILE_RESOURCE", EHRConstants.FILE_TYPE_MBBKTNB));
			}
		}
		model.addAttribute("attchesHbp", uploadInfoRecordsHbp);
		model.addAttribute("attchesDi", uploadInfoRecordsDi);
		model.addAttribute("attchesHbpShow", uploadInfoRecordsHbp !=null ? "是" : ""); // 前端页面附件是否显示标志
		model.addAttribute("attchesDiShow", uploadInfoRecordsDi != null ? "是" : "");
		/******end******/

		model.put("allowPersonEditable", allowPersonEditable);
		model.put("reportInfos", reportInfos);
		model.put("selectedReportStatus", viewType);
		return "rhip.cdm.base.reportCard.appReport";
	}

    /**
     * Query disease.
     *
     * @param key             the key
     * @param response the response
     * @return the string
     */
	@RequestMapping("/complete/disease")
	public void queryDisease(@RequestParam(required = false, value = "inputValue") String key, HttpServletResponse response) {
		// 1）ICD编码为C开头的所有恶性肿瘤
		// 2）脑、中枢神经系统良性肿瘤：ICD编码为D32-33，D42-43，D44.3,D44.5
		Object result = CACHE.get(DIS_JSON_KEY);
		if (null == result) {
			try {diseaseApp.queryDiseases(new Criteria(Disease.STATUS, StatusValue.normalValue.getValue()));
				List<Disease> d4243 = diseaseApp.queryDiseasesByCategoryRange("D42", "D43");
				List<Disease> d443 = diseaseApp.queryDiseases(new Criteria(Disease.ICD10MAIN, OP.FLIKE, "D44.3"));
				List<Disease> d445 = diseaseApp.queryDiseases(new Criteria(Disease.ICD10MAIN, OP.FLIKE, "D44.5"));
				List<Disease> d3233 = diseaseApp.queryDiseasesByCategoryRange("D32", "D33");
				List<Disease> c00c97 = diseaseApp.queryDiseasesByCategoryRange("C00", "C97");
				List<Disease> diseases = new ArrayList<>();
				diseases.addAll(d3233);
				diseases.addAll(d4243);
				diseases.addAll(d443);
				diseases.addAll(d445);
				diseases.addAll(c00c97);
				String disJson = JSONSerializer.toJSON(diseases).toString();
				CACHE.put(DIS_JSON_KEY, disJson);
				result = disJson;
			} catch (Exception e) {
				logger.error("get tumor icd10 error", e);
			}
		}
		if (null != result) {
			try {
				response.getWriter().write(result.toString());
				response.getWriter().flush();
			} catch (Exception e) {
				logger.error("io error", e);
			}
		}

	}

	@RequestMapping("/complete/diseaseIcd10")
	public void queryDiseaseIcd10(@RequestParam(required = false, value = "inputValue") String key, HttpServletResponse response) {
		// 1）ICD编码为C开头的所有恶性肿瘤
		// 2）脑、中枢神经系统良性肿瘤：ICD编码为D32-33，D42-43，D44.3,D44.5
		Object result = CACHE.get(key);
		if (null == result) {
			try {
				/*List<Disease> d4243 = diseaseApp.queryDiseasesByCategoryRange("D42", "D43");
				List<Disease> d443 = diseaseApp.queryDiseases(new Criteria(Disease.ICD10MAIN, OP.FLIKE, "D44.3"));
				List<Disease> d445 = diseaseApp.queryDiseases(new Criteria(Disease.ICD10MAIN, OP.FLIKE, "D44.5"));
				List<Disease> d3233 = diseaseApp.queryDiseasesByCategoryRange("D32", "D33");
				List<Disease> c00c97 = diseaseApp.queryDiseasesByCategoryRange("C00", "C97");*/
				List<Disease> diseases = diseaseApp.queryDiseases(new Criteria(Disease.STATUS, StatusValue.normalValue.getValue()));
				/*diseases.addAll(d3233);
				diseases.addAll(d4243);
				diseases.addAll(d443);
				diseases.addAll(d445);
				diseases.addAll(c00c97);*/
				String disJson = JSONSerializer.toJSON(diseases).toString();
				CACHE.put(DIS_JSON_KEY, disJson);
				result = disJson;
			} catch (Exception e) {
				logger.error("get tumor icd10 error", e);
			}
		}
		if (null != result) {
			try {
				response.getWriter().write(result.toString());
				response.getWriter().flush();
			} catch (Exception e) {
				logger.error("io error", e);
			}
		}

	}
	
	
    /**
     * 创建树节点
     *
     * @param name             the name
     * @param code             the code
     * @param parent             the parent
     * @param type             the type
     * @return object object
     */
	private Object createNode(String name, String code, String parent, String type) {
		Map<String, String> node = new HashMap<>(4);
		node.put("id", code);
		node.put("pId", parent);
		node.put("type", type);
		node.put("name", name);
		return node;
	}

    /**
     * 设置查看的权限
     *
     * @param criteria             the criteria
     * @param roleType             the role type
     * @param organization             the organization
     */
	private void buildViewParam(Criteria criteria, RoleType roleType, Organization organization) {
		if (roleType.equals(RoleType.ZXMB)) {
			/** 对应上报机构 */
			Criteria criteriaOr = new Criteria("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
			criteriaOr.add(LOP.OR, "dmReportInfo.SUPER_MANAGE_ORGAN_CODE", organization.getOrganCode());
			criteria.add(criteriaOr);
		} else if (roleType.equals(RoleType.YYMB)) {
			criteria.add("dmReportInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if (roleType.equals(RoleType.ZMB)) {
			criteria.add("dmReportInfo.MANAGE_ORGAN_CODE", organization.getOrganCode());
		}
	}

    /**
     * 审核报卡
     *
     * @param report             the report
     * @param model             the model
     * @param request             the request
     * @return string string
     */
	@RequestMapping("/app")
	@ResponseBody
	public String app(ReportForm report, ModelMap model, HttpServletRequest request) {
		Map<String, Object> map =new HashMap<>();
		List<DmReportInfo> reportInfos = report.getReport();
		Map<String, String> linkMapGxy = null;
		Map<String, String> linkMapTnb = null;
		for(DmReportInfo rpt : reportInfos) {
			String type = rpt.getDisType();
			if(EHRConstants.DM_HBP_TYPE.equals(type)) {
				linkMapGxy = (Map<String, String>) request.getSession().getAttribute("mbglkgxy_fileMap");//附件-高血压
				map = validateAttchement(map, linkMapGxy, rpt.getId(), true);
				request.getSession().removeAttribute("mbglkgxy_fileMap");
				if(ObjectUtil.isNotEmpty(map)) {
					return "上传附件存在问题！";
				}
			} else if(EHRConstants.DM_DI_TYPE.equals(type)) {
				map =new HashMap<>();
				linkMapTnb = (Map<String, String>) request.getSession().getAttribute("mbglktnb_fileMap");//附件-糖尿病
				map = validateAttchement(map, linkMapTnb, rpt.getId(), true);
				request.getSession().removeAttribute("mbglktnb_fileMap");
				if(ObjectUtil.isNotEmpty(map)) {
					return "上传附件存在问题！";
				}
			}
		}
		RoleType roleType = getRole(request);
		User user = getCurrentUser(request);
		Long start = System.currentTimeMillis();
		try {
			reportCardService.approveReport(report.getPersonInfo(), reportInfos, roleType, user, getCurrentOrg(request),linkMapGxy,linkMapTnb);
		} catch (BaseException e) {
			return e.getMessage();
		}
		Long end = System.currentTimeMillis();
		if (logger.isDebugEnabled()) {
			logger.debug("===============审核耗时:" + (end - start));
		}
		record(request, OperationName.CHECK);
		// return "rhip.cdm.base.reportCard.viewReport";
		return "success";
	}

    /**
     * 检查审核权限
     *
     * @param dmReportInfo             the dm report info
     * @param request             the request
     */
	private void checkApp(DmReportInfo dmReportInfo, HttpServletRequest request) {
		boolean isSqzx = SecurityUtils.hasRole(RoleType.ZXMB, request);
		boolean isMbk = SecurityUtils.hasRole(RoleType.JKMBK, request);
		boolean isSQZ = SecurityUtils.hasRole(RoleType.ZMB, request);
		boolean isFbk = SecurityUtils.hasRole(RoleType.YYMB, request);
		dmReportInfo.setApprovalFlag(1);
		dmReportInfo.setAllowEdit(false);
		if (isFbk || isSqzx || isMbk || isSQZ) {
			String statusString = dmReportInfo.getCdmStatusInfo().getReportStatus();
			if (ApprovalState.ALLOCATED.getValue().equals(statusString)) {
				if (isSQZ ) {
					dmReportInfo.setApprovalFlag(3);
				}
			} else if (ApprovalState.ALLOC_REJECT_SECOND.getValue().equals(statusString) || ApprovalState.VERIFIED_SECOND.getValue().equals(statusString) || ApprovalState.ALLOC_REJECT_THREE.getValue().equals(statusString)) {
				if (isSqzx || isFbk) {
					dmReportInfo.setNeedAlloc(true);
					dmReportInfo.setApprovalFlag(3);
				}
			} else if (ApprovalState.ALLOC_REJECT_FIRST.getValue().equals(statusString)) {
				if (isMbk) {
					dmReportInfo.setNeedAlloc(true);
					dmReportInfo.setApprovalFlag(3);
				}
			} else if (ApprovalState.VERIFIED_FIRST.getValue().equals(statusString)) {
				// 慢病科
				if (isMbk) {
					dmReportInfo.setNeedAlloc(true);
					dmReportInfo.setApprovalFlag(2); // 可以审核
				}
			} else if (ApprovalState.READY.getValue().equals(statusString) || ApprovalState.REJECT.getValue().equals(statusString)) {
				// 防保科
				if (isSqzx || isFbk) {
					dmReportInfo.setApprovalFlag(2);// 可以审核
					dmReportInfo.setAllowEdit(true);
				}
			}
		}
	}

    /**
     * 设置报卡输入更新信息
     *
     * @param input             the input
     * @param dmReportInfo             the dm report info
     * @param request             the request
     */
	private void setReportInputInfo(boolean input, DmReportInfo dmReportInfo, HttpServletRequest request) {
		Organization organization = getCurrentOrg(request);
		User user = getCurrentUser(request);
		Assert.notNull(organization, "非法登录");
		Assert.notNull(user, "非法登录");
		if (input) {
			String parentCode = organization.getParentCode();
			String gCode= organization.getGenreCode();
			if(OrgGenreCode.STATION.getValue().equals(gCode)||OrgGenreCode.CLINIC.getValue().equals(gCode)){
				dmReportInfo.setCreateCenterOrganCode(parentCode);
			}else{
				dmReportInfo.setCreateCenterOrganCode(organization.getOrganCode());
			}
			dmReportInfo.setCreateOrganCode(organization.getOrganCode());
			dmReportInfo.setCreateOrganName(organization.getOrganName());
			dmReportInfo.setCreateDoctorCode(user.getUserCode());
			dmReportInfo.setCreateDoctorName(user.getUserName());
			dmReportInfo.setCreateDate(new Date());
			//dmReportInfo.setDiagnosisOrganCode(organization.getOrganCode());
		} else {
			dmReportInfo.setUpdateOrganCode(organization.getOrganCode());
			dmReportInfo.setUpdateOrganName(organization.getOrganName());
			dmReportInfo.setUpdateDoctorCode(user.getUserCode());
			dmReportInfo.setUpdateDoctorName(user.getUserName());
			dmReportInfo.setUpdateDate(new Date());
		}

	}

    /**
     * Repeat card list.
     *
     * @return the string
     */
	@RequestMapping("/repeat")
	public String repeatCardList() {
		return "rhip.cdm.base.reportCard.repeat";
	}

    /**
     * Repeat report card list.
     *
     * @param form             the form
     * @param request             the request
     * @param model             the model
     * @return the string
     */
	@RequestMapping("/repeatReportCardList")
	public String repeatReportCardList(RepeatForm form, HttpServletRequest request, ModelMap model) {
		Criteria criteria = form.toCriteria();
		PageList<DmReportInfo> list = reportCardService.getRepeatCardList(buildPage(request), criteria, form.getRepeatConditions());
		model.addAttribute("dmRepeatCardInfoList", list.getList());
		return "rhip.cdm.base.reportCard.repeatResult";
	}

    /**
     * Del repeat card.
     *
     * @param id             the id
     * @param model             the model
     * @param request             the request
     * @return the string
     */
	@RequestMapping("/del/{id}")
	@ResponseBody
	public String delRepeatCard(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request) {
		record(request, OperationName.UPDATE);
		return reportCardService.updateRepeatCard(id.toString());
	}

    /**
     * Repeat list.
     *
     * @return the string
     */
	@RequestMapping("/repeatList")
	public String repeatList() {
		return "rhip.cdm.base.reportCard.repeatResult";
	}

    /**
     * 设置人员信息 仅补充不存在的信息
     *
     * @param dmPersonInfo             the dm person info
     * @param personInfo             the person info
     */
	private void setPersonInfo(PersonInfo dmPersonInfo, PersonInfo personInfo) {
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getBirthday())) {
			dmPersonInfo.setBirthday(personInfo.getBirthday());
		}
		if (ObjectUtil.isNullOrEmpty(personInfo.getGender())) {
			dmPersonInfo.setGender(personInfo.getGender());
		}
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getMarriage())) {
			dmPersonInfo.setMarriage(personInfo.getMarriage());
		}

		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getEducation())) {
			dmPersonInfo.setEducation(personInfo.getEducation());
		}
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getOccupation())) {
			dmPersonInfo.setOccupation(personInfo.getOccupation());
		}
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getNation())) {
			dmPersonInfo.setNation(personInfo.getNation());
		}
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getHouseholdType())) {
			dmPersonInfo.setHouseholdType(personInfo.getHouseholdType());
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
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getUnitName())) {
			dmPersonInfo.setUnitName(personInfo.getUnitName());
		}

	}

    /**
     * map中获取String值 ,null则返回""
     *
     * @param map             the map
     * @param key             the key
     * @return field value
     */
	private String getFieldValue(Map<String, Object[]> map, String key) {
		if (!map.containsKey(key)) {
			return "";
		}
		return map.get(key)[0].toString();
	}

    /**
     * 将报卡参数字符串转换为map
     *
     * @param query             the query
     * @return map map
     */
	@SuppressWarnings("unused")
	private Map<String, Object[]> convertQueryToReport(String query) {
		Map<String, Object[]> map = new HashMap<String, Object[]>();
		String params[] = query.split("&");
		for (String param : params) {
			if (param.indexOf("=") > 0) {
				String keyValues[] = param.split("=");
				if (keyValues.length == 2) {
					map.put(keyValues[0], new Object[] { keyValues[1] });
				} else if (keyValues.length == 1) {
					map.put(keyValues[0], new Object[] { "" });
				}
			}
		}
		return map;
	}

    /**
     * 检查必须字段
     *
     * @param map             the map
     * @return boolean boolean
     */
	private boolean checkRequiredField(Map<String, Object[]> map) {
		for (String key : hosReportRequiredFields) {
			if (!map.containsKey(key) || map.get(key)[0].toString().length() < 1) {
				logger.error("院内慢病上报失败" + key + "参数没有传递或者为空");
				return false;
			}
		}
		return true;
	}

    /**
     * Check organ code.
     *
     * @param orgCode             the org code
     * @return the boolean
     */
	private boolean checkOrganCode(String orgCode) {
		Organization organization = organizationApp.queryOrgan(orgCode);
		return null != organization;
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
