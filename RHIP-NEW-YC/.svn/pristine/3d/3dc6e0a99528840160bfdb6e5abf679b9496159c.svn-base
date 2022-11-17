package com.founder.rhip.ehr.controller.person;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IFollowupPlanService;
import com.founder.rhip.cdm.service.IPhyExaminationService;
import com.founder.rhip.ech.service.IEchManageService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.controller.FlashScope;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PersonInfoDTO;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalConsultationDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.FingerInfo;
import com.founder.rhip.ehr.entity.basic.ModifyTrace;
import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.clinic.Consultation;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.ExcelToDB;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.ech.EchIdentificationOption;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.repository.basic.IFingerInfoDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.repository.ech.IEchIdentificationDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.service.IExcelHealthRecordService;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IHealthHistoryService;
import com.founder.rhip.ehr.service.IModifyTraceService;
import com.founder.rhip.ehr.service.IReadHealthRecordService;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPersonCanceledService;
import com.founder.rhip.ehr.service.personal.IPersonMoveService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.statistics.IStatisticsService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.ehr.service.ta.IOutpatientInfoService;
import com.founder.rhip.ehr.util.StatisticsUtil;
import com.founder.rhip.hm.service.IConsultationService;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.uthealth.controller.util.HttpClientUtil;

@Controller
public class PersonalRecordController extends BaseController {

	private static final String acctionName = "个人健康档案";

	private static Logger logger = Logger.getLogger(PersonalRecordController.class);

	private final String SESSIONIDE = "ide";

	private String[] syncProperties = {"abdominalMassDesc","abdominalMassFlag","abdominalTendernessDesc","abdominalTendernessFlag","abdominalVoicedDesc","abdominalVoicedFlag","arteriopalmus","arteryDiseaseFlag","arteryDissectingAneurysm","arteryOther","arteryOtherDesc","arteryPaod","barrelChest","bloodUreaNitrogenValue","bodyWeight","cardioverter","cognitionScreenResult","cognitionScreenScore","covascularOther","covascularTransientIschemic","creatinine","cvascularFlag","cvascularHemorrhage","cvascularHemorrhageStroke","cvascularOtherDesc","cvascularSah","dailyDrink","dailySmoke","decayedToothFlg","decayedToothNumberDownl","decayedToothNumberDownr","decayedToothNumberUpl","decayedToothNumberUpr","dentitionAnomalyFlag","dentureToothFlg","dentureToothNumberDownl","dentureToothNumberDownr","dentureToothNumberUpl","dentureToothNumberUpr","depressionScore","dietAddictedOil","dietHalophilic","dietHunsuEquilibrium","dietMeatMain","dietSugarCravings","dietVegetarian","drinkAge","drinkBeer","drinkFrequency","drinkOther","drinkOtherDesc","drinkRedWine","drinkSpirit","drinkYellowWine","drunk","ecgAnomalyDesc","ecgAnomalyFlag","emotionScreenResult","eryQuantitativeValue","examinationDate","eyeCataract","eyeDiseasesFlag","eyeOpticPapilla","eyeOther","eyeOtherDesc","eyeRetinalOozing","fpgMg","fpgMmol","fundusOculiAnomalyDesc","fundusOculiAnomalyFlag","guideVaccination","guideVaccinationDesc","hdlcDetectValue","healthOther","healthOtherDesc","healthSelfAssessment","hearDetectResult","heartAnginaPectoris","heartCongestiveHeart","heartCoronary","heartDiseaseFlag","heartMiocardialInfarction","heartMurmurDesc","heartMurmurFlag","heartOther","heartOtherDesc","heartPrecordialPain","heartRate","height","hip","indexOfBodyCharacteristics","ketQuantitativeValue","kidneyAcuteNephritis","kidneyChronicNephritis","kidneyDiabeticNephropathy","kidneyDiseaseFlag","kidneyOther","kidneyOtherDesc","kidneyRenalFailure","ldlcDetectValue","leftDbp","leftSbp","legsEdemaCheckResult","lEyecorrection","lifeAbilitySelfAssessment","lipAppearanceCehckResult","liverDesc","liverFlag","lNakedEye","lungsAnomalyDesc","lungsAnomalySound","lungsRaleDesc","lungsRaleFlag","lymphNodeCheckDesc","lymphNodeCheckResult","missingToothFlg","missingToothNumberDownl","missingToothNumberDownr","missingToothNumberUpl","missingToothNumberUpr","motorFuncState","nervousDiseasesDesc","nervousDiseasesFlag","nodrink","nodrinkAge","pharynxCheckResult","potassiumConcentration","pulseRate","quitSmokeAge","respiratoryRate","rEyecorrection","riskOther","riskOtherDesc","riskWeightReduction","rNakedEye","scleraCheckDesc","scleraCheckResult","skinCheckDesc","skinCheckResult","smodeStatusCode","smokeAge","sodiumConcentration","splenomegalyDesc","splenomegalyFlag","symptomBlurredVision","symptomBreastTenderness","symptomChestPain","symptomChestTightness","symptomChronicCough","symptomConstipation","symptomCough","symptomDiarrhea","symptomDizzy","symptomDyspnea","symptomDysuria","symptomFatigue","symptomFlag","symptomHeadache","symptomJointPain","symptomNauseaVomiting","symptomNumbness","symptomOther","symptomOtherDesc","symptomPalpitations","symptomPolydipsia","symptomPolyuria","symptomTinnitus","symptomUrgency","symptomVertigo","symptomWeightLoss","tc","temperature","trainFrequencyTypeCode","trainingMin","trainingTotaltime","trainingWay","triglycerideValue","urineProQuantitativeValue","urineRoutinesOtherDesc","urineSugQuantitativeValue","waostline","whr"};

	@Autowired
	private IOutpatientInfoService outpatientInfoService;

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "personalConsultationService")
	private  IConsultationService consultationService;

	@Resource(name = "platformService")
	private IPlatformService platformService;
	@Resource
	private IChildHealthExaminationDao childHealthExaminationDao;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@Resource(name = "ehrSecurityService")
	private IEhrSecurityService ehrSecurityService;
	@Resource(name = "neonatalFamilyVisitDao")
	private INeonatalFamilyVisitDao neonatalFamilyVisitDao;  //新生儿家庭访视表
	@Autowired
	private IHealthEventService healthEventService;

	@Resource(name = "personCanceledInfoService")
	private IPersonCanceledService personCanceledInfoService;

	@Autowired
	private IPersonMoveService personMoveService;

	@Autowired
	private IModifyTraceService modifyTraceService;

	@Autowired
	private IStatisticsService statisticsService;

	@Autowired
	private IDictionaryApp dictionaryApp;

	@Autowired
	private IStaffService staffService;

	@Resource(name = "healthHistoryService")
	private IHealthHistoryService healthHistoryService;

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IReadHealthRecordService readHealthRecordService;

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

	@Resource(name = "excelhealthRecordService")
	private IExcelHealthRecordService excelHealthRecordService;

	@Resource(name = "physicalExamRecordService")
	private IPhysicalExamRecordService physicalExamRecordService;

	@Resource(name = "cdmPhyExaminationService")
	private IPhyExaminationService phyExaminationService;

	@Resource
	private IChildHealthExamineService childHealthExamineService;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "echManageService")
	private IEchManageService echManageService;

	@Resource(name = "wchSearchService")
	private IWchSearchService wchSearchService;

	@Resource(name = "followupPlanService")
	private IFollowupPlanService followupPlanService;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao dmDiseaseInfoDao;

	@Resource(name = "fingerInfoDao")
	private IFingerInfoDao fingerInfoDao;

	@Resource(name = "userOperationLogService")
	private IUserOperationLogService userOperationLogService;
	
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;

	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;

	@Resource(name = "echIdentificationDao")
	private IEchIdentificationDao echIdentificationDao;

	@RequestMapping("/personRecord/verify/sqz")
	public String verify() {
		return "rhip.ehr.verify.search";
	}

	@RequestMapping(value = "/personRecord/verify/list")
	public String list(HttpServletRequest request, Model model, Integer indexPage, PersonInfo personInfo) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		if (!StringUtil.isNullOrEmpty(personInfo.getName())) {
			criteria.add("name", OP.LIKE, personInfo.getName());
		}
		if (!StringUtil.isNullOrEmpty(personInfo.getIdcard())) {
			criteria.add("idcard", OP.LIKE, personInfo.getIdcard());
		}
		if (ObjectUtil.isNotEmpty(personInfo.getFilingFlag())) {
			criteria.add("filingFlag", personInfo.getFilingFlag());
			if ("1".equals(personInfo.getFilingFlag())) {
				criteria.add("inputOrganCode", getCurrentOrg(request).getOrganCode());
			} else {
				if (ObjectUtil.isNotEmpty(personInfo.getPastreet())) {
					criteria.add("pastreet", personInfo.getPastreet());
				}
				if (ObjectUtil.isNotEmpty(personInfo.getPatownShip())) {
					criteria.add("patownShip", personInfo.getPatownShip());
				}
			}
		}
		PageList<PersonInfo> personInfoList = personalRecordService.getPersonRecordList(criteria, page, null);
		request.setAttribute("personInfoList", personInfoList.getList());
		request.setAttribute("page", personInfoList.getPage());
		return "rhip.ehr.verify.list";
	}

	@RequestMapping(value = "/personRecord/verify/personInfoTemplist")
	public String personInfoTemplist(HttpServletRequest request, Model model, Integer indexPage, PersonInfoTemp personInfoTemp) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		if (!StringUtil.isNullOrEmpty(personInfoTemp.getName())) {
			criteria.add("s.name", OP.LIKE, personInfoTemp.getName());
		}
		if (!StringUtil.isNullOrEmpty(personInfoTemp.getIdcard())) {
			criteria.add("s.idcard", OP.LIKE, personInfoTemp.getIdcard());
		}
		if (ObjectUtil.isNotEmpty(personInfoTemp.getFilingFlag())) {
			criteria.add("s.filing_Flag", personInfoTemp.getFilingFlag());
		}
		criteria.add("p.INPUT_ORGAN_CODE", super.getCurrentOrg(request).getOrganCode());
		PageList<PersonInfoTemp> personInfoTempList = personalRecordService.getPersonRecordTempList(criteria, page, null);
		request.setAttribute("personInfoTempList", personInfoTempList.getList());
		request.setAttribute("page", personInfoTempList.getPage());
		return "rhip.ehr.verify.personInfoTemplist";
	}

	@RequestMapping(value = "/personRecord/verify/check")
	public String check(HttpServletRequest request) {
		String id = (String) request.getParameter("id");
		String operationType = (String) request.getParameter("operatorType");
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", id));
		String expenseInfoStr = "";

		String temp = personInfo.getPaymentUrbanWorkders();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "01".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentUrbanResident();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "02".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentNewRuralCooperation();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "03".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentPovertyRelief();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "04".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentCommercial();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "05".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentBursary();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "06".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentPersonalExpenses();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "07".equals(temp.trim())) ? temp.trim() + "," : "";
		temp = personInfo.getPaymentOther();
		expenseInfoStr += (StringUtil.isNotEmpty(temp) && "99".equals(temp.trim())) ? temp.trim() + "," : "";

		expenseInfoStr = expenseInfoStr.length() > 0 ? expenseInfoStr.substring(0, expenseInfoStr.length() - 1) : expenseInfoStr;
		request.setAttribute("personInfo", personInfo);
		request.setAttribute("expenseInfoStr", expenseInfoStr);
		request.setAttribute("operationType", operationType);
		return "rhip.ehr.verify.check";
	}

	@RequestMapping(value = "/personRecord/verify/doCheck")
	@ResponseBody
	public ModelMap doCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", id));
		personInfo.setFilingFlag("1");// //0：未建档 1：已建档，3 已退回 9已注销 5待审核
		// add by shenguimin 2013年7月18日17:36:28
		personInfo.setInputOrganCode(getCurrentOrg(request).getOrganCode());
		personInfo.setInputOrganName(getCurrentOrg(request).getOrganName());
		personInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
		personInfo.setUpdateName(getCurrentUser(request).getName());
		// end
		ModelMap modelMap = new ModelMap();
		platformService.updatePersonInfo(personInfo);
		modelMap.addAttribute("success", true);
		return modelMap;
	}

	@RequestMapping(value = "/personRecord/verify/checkUpdate")
	public String checkUpdate(HttpServletRequest request) {
		String id = (String) request.getParameter("id");
		if (ObjectUtil.isNotEmpty(id)) {
			PersonInfoTemp personInfoTemp = personalRecordService.getPersonInfoTemp(new Criteria("id", id));
			request.setAttribute("personInfoTemp", personInfoTemp);
		}
		String operationType = (String) request.getParameter("operatorType");
		request.setAttribute("operationType", operationType);
		return "rhip.ehr.verify.personInfoTempCheck";
	}

	@RequestMapping(value = "/personRecord/verify/doCheckUpdate")
	@ResponseBody
	public ModelMap doCheckUpdate(HttpServletRequest request) {
		String id = request.getParameter("id");
		PersonInfoTemp personInfoTemp = personalRecordService.getPersonInfoTemp(new Criteria("id", id));
		personInfoTemp.setFilingFlag("1");
		ModelMap modelMap = new ModelMap();
		platformService.updatePersonInfoTemp(personInfoTemp);
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", personInfoTemp.getPersonInfoId()));
		copyPersonInfoTempToPersonInfo(personInfoTemp, personInfo, request);

		String[] pram = { "name", "idcard", "gender", "birthday", "phoneNumber", "unitName", "firstGuardian", "guardianPhoneOne", "secondGuardian", "guardianPhoneTwo", "nation", "aboBloodType",
				"rhBloodType", "education", "occupation", "occupationOther", "marriage", "householdType", "outWindType", "fuel", "water", "hastoilet", "fowlType", "filingFlag",
				"paymentUrbanWorkders", "paymentUrbanResident", "paymentNewRuralCooperation", "paymentPovertyRelief", "paymentCommercial", "paymentBursary", "paymentPersonalExpenses", "paymentOther" };
		platformService.updatePersonInfo(personInfo, pram);

		modelMap.addAttribute("success", true);
		return modelMap;
	}

	private void copyPersonInfoTempToPersonInfo(PersonInfoTemp personInfoTemp, PersonInfo personInfo, HttpServletRequest request) {
		personInfo.setBirthday(personInfoTemp.getBirthday());
		personInfo.setAboBloodType(personInfoTemp.getAboBloodType());
		personInfo.setEducation(personInfoTemp.getEducation());
		String temp = personInfoTemp.getExpenseInfoStr();

		personInfo.setPaymentUrbanWorkders((StringUtil.isNotEmpty(temp) && temp.indexOf("01") != -1) ? "01" : "");
		personInfo.setPaymentUrbanResident((StringUtil.isNotEmpty(temp) && temp.indexOf("02") != -1) ? "02" : "");
		personInfo.setPaymentNewRuralCooperation((StringUtil.isNotEmpty(temp) && temp.indexOf("03") != -1) ? "03" : "");
		personInfo.setPaymentPovertyRelief((StringUtil.isNotEmpty(temp) && temp.indexOf("04") != -1) ? "04" : "");
		personInfo.setPaymentCommercial((StringUtil.isNotEmpty(temp) && temp.indexOf("05") != -1) ? "05" : "");
		personInfo.setPaymentBursary((StringUtil.isNotEmpty(temp) && temp.indexOf("06") != -1) ? "06" : "");
		personInfo.setPaymentPersonalExpenses((StringUtil.isNotEmpty(temp) && temp.indexOf("07") != -1) ? "07" : "");
		personInfo.setPaymentOther((StringUtil.isNotEmpty(temp) && temp.indexOf("99") != -1) ? "99" : "");

		personInfo.setFilingFlag(personInfoTemp.getFilingFlag());
		personInfo.setFirstGuardian(personInfoTemp.getFirstGuardian());
		personInfo.setFowlType(personInfoTemp.getFowlType());
		personInfo.setFuel(personInfoTemp.getFuel());
		personInfo.setGender(personInfoTemp.getGender());
		personInfo.setGuardianPhoneOne(personInfoTemp.getGuardianPhoneOne());
		personInfo.setSecondGuardian(personInfoTemp.getSecondGuardian());
		personInfo.setGuardianPhoneTwo(personInfoTemp.getGuardianPhoneTwo());
		personInfo.setHastoilet(personInfoTemp.getHastoilet());
		personInfo.setHouseholdType(personInfoTemp.getHouseholdType());
		personInfo.setIdcard(personInfoTemp.getIdcard());
		personInfo.setMarriage(personInfoTemp.getMarriage());
		personInfo.setName(personInfoTemp.getName());
		personInfo.setNation(personInfoTemp.getNation());
		personInfo.setOccupation(personInfoTemp.getOccupation());
		personInfo.setOccupationOther(personInfoTemp.getOccupationOther());
		personInfo.setOutWindType(personInfoTemp.getOutWindType());
		personInfo.setPhoneNumber(personInfoTemp.getPhoneNumber());
		personInfo.setRhBloodType(personInfoTemp.getRhBloodType());
		personInfo.setUnitName(personInfoTemp.getUnitName());
		personInfo.setWater(personInfoTemp.getWater());
		// add by 盛贵敏 2013-7-16 15:33:03
		personInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
		personInfo.setUpdateName(getCurrentUser(request).getName());
		// end add
	}

	/**
	 * 进入个人档案列表页面,根据社区站带出对应的村委会
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/personRecord")
	public String search(HttpServletRequest request, ModelMap model) {
		// Organization currentOrg =
		// SecurityUtils.getCurrentOrganization(request);
		// if(OrgGenreCode.STATION.getValue().equals(currentOrg.getGenreCode())){
		// Criteria criteria= new Criteria("organizationCode",
		// currentOrg.getOrganCode());
		// List<OrganizationArea> orgAreas =
		// organizationService.getOrganizationAreas(criteria);
		// if(ObjectUtil.isNotEmpty(orgAreas)){
		// Map<String,String> areaMap = new HashMap<>();
		// for (OrganizationArea area : orgAreas) {
		// String areaName = dictionaryApp.queryDicItemName("FS990001",
		// area.getAreaCode());
		// areaMap.put(area.getAreaCode(), areaName);
		// }
		// model.addAttribute("searchAreaMap", areaMap);
		// }
		// }
		return "rhip.ehr.personalRecord.list";
	}

	/**
	 * 进入健康体检页面
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/personPhysicalExam")
	public String personPhysicalExam(HttpServletRequest request, ModelMap model) {
		model.addAttribute("urlFromPhysicalExam","urlFromPhysicalExam");
		return "rhip.ehr.personalRecord.list";
	}

	/**
	 * 个人档案列表页面
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/personRecord/result")
	public String result(HttpServletRequest request,String urlFromPhysicalExam, ModelMap model) {
		searchResult(request);
		model.addAttribute("urlFromPhysicalExam",urlFromPhysicalExam);
		return "rhip.ehr.personalRecord.result";
	}

	/**
	 * 点击树时请求的Controller
	 *
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping("/personRecord/{orgCode}")
	public String searchById(@PathVariable("orgCode") String orgCode, HttpServletRequest request) {
		request.setAttribute("orgCode", orgCode);
		searchResult(request);
		return "rhip.ehr.personalRecord.result";
	}

	/**
	 * 进入新增个人档案页面
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/addPersonRecordIni")
	public String addPersonRecordIni(@RequestParam(value="password",required = false)String password, String urlFromPhysicalExam,HttpServletRequest request, ModelMap model) {
        request.getSession().removeAttribute("personInfo");
        String personId = request.getParameter("personId");
        int recordStatus = 0;
        if (!StringUtils.isEmpty(personId)) {
            Criteria criteria = new Criteria();
            criteria.add("id", personId);
            PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(criteria);
            int result=personalRecordManagmentService.checkRecordAccess(personInfo,password);
            model.put("personId",personId);
            if (result!=0&&result !=2){
                return checkAccessResultAndReturn(result,model);
            }

            if(ObjectUtil.equals(EHRConstants.UN_CREATE, personInfo.getFilingFlag())) {
                User user = SecurityUtils.getCurrentUser(request);
                personInfo.setInputerId(user.getStaffCode());
//                personInfo.setPhysiciansCaringId(user.getStaffCode());
                Organization currentOrganization = SecurityUtils.getCurrentOrganization(request);
                personInfo.setInputOrganName(currentOrganization.getOrganName());
                personInfo.setInputOrganCode(currentOrganization.getOrganCode());
            }
            getPersonAddress(personInfo);
            request.getSession().setAttribute("personInfo", personInfo);
            recordStatus = healthEventService.checkPersonRecordStatus(new Criteria("personId", personId));
			List<Consultation> consultations = consultationService.getConsultationList(new Criteria("personId", personId));
			if (ObjectUtil.isNullOrEmpty(consultations)){
				request.setAttribute("consultationFlag", "todo");
			}else{
				request.setAttribute("consultationFlag", "completed");
			}
			List<OutpatientInfo> outpatientInfos = outpatientInfoService.getDistinctList(new Criteria("personId", personId),new Order("CLINIC_DATE",false));
			if (ObjectUtil.isNullOrEmpty(outpatientInfos)){
				request.setAttribute("receptionFlag", "todo");
			}else{
				request.setAttribute("receptionFlag", "completed");
			}
		}else{//默认值为当前登录用户  add by bagen at 2016年9月5日
            PersonInfo personInfo = new PersonInfo();
            User user = SecurityUtils.getCurrentUser(request);
            personInfo.setInputerId(user.getStaffCode());
//            personInfo.setPhysiciansCaringId(user.getStaffCode());
            Organization currentOrganization = SecurityUtils.getCurrentOrganization(request);
            personInfo.setInputOrganName(currentOrganization.getOrganName());
            personInfo.setInputOrganCode(currentOrganization.getOrganCode());
            request.getSession().setAttribute("personInfo", personInfo);
        }
        request.setAttribute("recordStatus", recordStatus);
        //点击健康体检菜单列表页面按钮 设置urlFromPhysicalExam
        model.addAttribute("urlFromPhysicalExam",urlFromPhysicalExam);
        return "rhip.ehr.personalRecord.ini";
    }


	private String checkAccessResultAndReturn(int result,ModelMap model){
		String page="rhip.ehr.personalRecord.access";
		switch (result){
			case 1 :{
				model.put("accessMessage","请输入密码");
				break;
			}
			case 3 :{
				model.put("accessMessage","密码错误");
				break;
			}
			case 99:{
				model.put("accessMessage","无法验证密码,请联系管理员");
				break;
			}
			default:{
				model.put("accessMessage","发生位置错误");
			}
		}
		return page;
	}



	/**
	 * 进入新增封面页面
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/personRecord/addCover")
	public String addCover(HttpServletRequest request, ModelMap model) {
		if (model.get("hospitalStaff") == null) {
			List<User> hospitalStaffs = getHospitalStaff(request);
			model.addAttribute("hospitalStaff", hospitalStaffs);
		}
		if (request.getSession().getAttribute("personInfo") == null) {
			PersonInfo personInfo = new PersonInfo();
			// 建档机构
			Organization organ = SecurityUtils.getCurrentOrganization(request);
			personInfo.setInputOrganCode(organ.getOrganCode());
			personInfo.setInputOrganName(organ.getOrganName());
			// 获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			Staff staff = staffService.getStaffMain(SecurityUtils.getCurrentUser(request).getStaffCode());
			if (ObjectUtil.isNotEmpty(staff)) {
				personInfo.setInputerId(staff.getStaffCode());
			}
			model.addAttribute("townAddressList", dictionaryApp.queryDicItem(criteria));
			request.getSession().setAttribute("personInfo", personInfo);
		} else {
			PersonInfo personinfo = (PersonInfo) request.getSession().getAttribute("personInfo");
			if (ObjectUtil.isNotEmpty(personinfo.getPatownShip())) {
				DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personinfo.getPatownShip());
				if (ObjectUtil.isNotEmpty(paDicItem1)) {
					model.addAttribute("orgPaName", paDicItem1.getItemName());
				}
			}
			if (ObjectUtil.isNotEmpty(personinfo.getPastreet())) {
				DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personinfo.getPastreet());
				if (ObjectUtil.isNotEmpty(paDicItem2)) {
					model.addAttribute("orgPaNamePastreet", paDicItem2.getItemName());
				}
			}

			if (ObjectUtil.isNotEmpty(personinfo.getHrtownShip())) {
				DicItem hrDicItem1 = dictionaryApp.queryDicItem("FS990001", personinfo.getHrtownShip());
				if (ObjectUtil.isNotEmpty(hrDicItem1)) {
					model.addAttribute("orgHrName", hrDicItem1.getItemName());
				}
			}
			if (ObjectUtil.isNotEmpty(personinfo.getHrstreet())) {
				DicItem hrDicItem2 = dictionaryApp.queryDicItem("FS990001", personinfo.getHrstreet());
				if (ObjectUtil.isNotEmpty(hrDicItem2)) {
					model.addAttribute("orgHrNamePastreet", hrDicItem2.getItemName());
				}
			}
		}
		return "rhip.ehr.personalRecord.addCover";
	}

	/**
	 * 完成封面保存操作
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/personRecord/saveCover")
	public String saveCover(HttpServletRequest request, ModelMap model) {
		PersonInfoDTO personInfoDto = VoUtil.getFormData(request, PersonInfoDTO.class);
		PersonInfo sessionPersonInfo = (PersonInfo) request.getSession().getAttribute("personInfo");
		PersonInfo personInfo = personInfoDto.getPersonInfo();
		String rStatus = personInfoDto.getRecordStatus();
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");

		personInfo.setGBCode(personInfo.getPastreet());
		personInfo.setPaAddress((personInfo.getPaAddressDetail() != null ? personInfo.getPaAddressDetail() : "") + personInfo.getPahouseNumber());
		personInfo.setHrAddress((personInfo.getHrAddressDetail() != null && "1".equals(personInfo.getHouseholdType()) ? personInfo.getHrAddressDetail() : "") + personInfo.getHrhouseNumber());
		this.getCurrentInfo(request, personInfo);
		if (ObjectUtil.isNotEmpty(sessionPersonInfo)) {
			personInfo.setBirthday(sessionPersonInfo.getBirthday());
			//星级
			if(ObjectUtil.isNotEmpty(sessionPersonInfo.getStar())){
				personInfo.setStar(sessionPersonInfo.getStar());
			}
		}

		//modify by bagen at 2016年9月5日 修改查询staff表
		Staff inputer = staffService.getStaff(personInfo.getInputerId());
		if (ObjectUtil.isNotEmpty(inputer)) {
			personInfo.setInputName(inputer.getName());
		}
		// 冗余中心organCode和gbCode
		Organization inputOrg = organizationApp.queryOrgan(personInfo.getInputOrganCode());
		if (ObjectUtil.isNotEmpty(inputOrg)) {
			personInfo.setInputGbcode(inputOrg.getGbCode());
			//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
			if(ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.STATION.getValue()) ||
					ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.INFIRMARY.getValue()) ||
					ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.CLINIC.getValue())) {
				personInfo.setInputCenterOrganCode(inputOrg.getParentCode());
			} else if(ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
					ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.HOSPITAL.getValue()) ||
					ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())		) {
				//中心、卫生院、综合医院 建档InputCenterOrganCode赋值为自己的code
				personInfo.setInputCenterOrganCode(inputOrg.getOrganCode());
			}
		}

		Criteria c = new Criteria();
		Map<String, Object> testMap = new HashMap<String, Object>();
		//证件类型不同查询条件不同
		if("0".equals(personInfo.getOtherIdcardType()) || StringUtil.isNullOrEmpty(personInfo.getOtherIdcardType())){
			c.add("idcard", personInfo.getIdcard());
		}else if("9".equals(personInfo.getOtherIdcardType())){
			c.add("babyCardNo",personInfo.getIdcard());
		}else {
			c.add("otherIdcard",personInfo.getIdcard());
		}
		PersonInfo p = personalRecordManagmentService.getPersonalCover(c);
		if (ObjectUtil.isNotEmpty(p) && !p.getFilingFlag().equals("0")) {
			String filingFlag = p.getFilingFlag();
			if (EHRConstants.HAD_OFF.equals(filingFlag)) {
				return EHRMessageUtil.returnMsg(model, "hadOff");// 已注销判断
			} else if ("2".equals(filingFlag)) {
				return EHRMessageUtil.returnMsg(model, "checkFlag");// 审核中判断
			}
		}else {
			String isNew = "isNew";
			testMap.put("isNew",isNew);
		}

		//个人信息表保存其它证件和宝宝卡号
		//证件类型为宝宝卡号时
		if("9".equals(personInfo.getOtherIdcardType()) && StringUtil.isNotEmpty(personInfo.getIdcard()) &&
				ObjectUtil.isNullOrEmpty(personInfo.getBabyCardNo())){
			personInfo.setBabyCardNo(personInfo.getIdcard());
			personInfo.setIdcard("");
		}//为其它证件时
		else if (!"0".equals(personInfo.getOtherIdcardType()) && StringUtil.isNotEmpty(personInfo.getIdcard()) &&
				ObjectUtil.isNullOrEmpty(personInfo.getOtherIdcard())){
			personInfo.setOtherIdcard(personInfo.getIdcard());
			personInfo.setIdcard("");
		}

		if (personInfo.getId() == null) {
			if (ObjectUtil.isNotEmpty(p)) {
				return EHRMessageUtil.returnMsg(model, "duplicateIdCard");// 身份证重复判断
			}
			personInfo.setFilingFlag(EHRConstants.HAD_CREATE);// 设置默认建档类型为“已建档”,值“1”
			personInfo.setUpdateDate(new Date());
			//存在身份证，则证件类型为身份证
			if(StringUtil.isNotEmpty(personInfo.getIdcard())){
				personInfo.setOtherIdcardType("0");
			}
			if(personInfo.getIdcard().length()==15){
				personInfo.setIdcard(IDCardUtil.conver15CardTo18(personInfo.getIdcard()));
			}
			personInfo = personalRecordManagmentService.createCover(personInfo, currentLoginInfo);
			if(ObjectUtil.isNullOrEmpty(personInfo.getHealthFileNo())) {
				return EHRMessageUtil.returnMsg(model, "ehrNoError");// 档案编码生成异常
			}
			Integer newStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
			createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.ADD);
			syncStar(request, personInfo.getHouseholdType(), 0, newStar);
			// 更新创建个人档案份数
			statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_NEW
					: StatisticsUtil.UNHR_ARCHIVE_NEW, StatisticsUtil.ADD);
			if("9".equals(personInfo.getOtherIdcardType())){
				saveWomenChildHealth(personInfo,request);
			}else if("0".equals(personInfo.getOtherIdcardType())){
				int age=IdNOToAge(personInfo.getIdcard());
				if(age<=6){
					saveWomenChildHealth(personInfo,request);
				}
			}

		} else {
			//身份证和对应信息不吻合-将身份证改成正确的
			if(ObjectUtil.isNotEmpty(personInfoDao.get(personInfo.getId()).getIdcard())){
				personInfo.setIdcard(personInfoDao.get(personInfo.getId()).getIdcard());
			}

			if(StringUtil.isNotEmpty(personInfo.getIdcard())){
				personInfo.setOtherIdcardType("0");
				if(personInfo.getIdcard().length()==15){
					personInfo.setIdcard(IDCardUtil.conver15CardTo18(personInfo.getIdcard()));
				}
			}
			createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.UPDATE);
			// personInfo.setId(sessionPersonInfo.getId());
			if (ObjectUtil.isNotEmpty(sessionPersonInfo.getHealthFileNo())) {
				//后加身份证-判断出性别及生日
				if(StringUtil.isNotEmpty(personInfo.getIdcard())){
					personInfo.setGender(IDCardUtil.getGenderByIdCard(personInfo.getIdcard()));
					personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard()));
				}
				personInfo.setHealthFileNo(sessionPersonInfo.getHealthFileNo());
				personInfo.setFilingFlag(sessionPersonInfo.getFilingFlag());
				String[] properties = {"remarks", "birthday","gender","otherIdcardType","idcard","name", "gBCode", "pahouseNumber", "livingType","householdType", "areaCode", "hrhouseNumber", "phoneNumber", "patownShip", "pastreet", "hrtownShip", "hrstreet",
						"paAddress", "hrAddress", "inputOrganCode", "inputOrganName", "inputName", "inputerId", "guardianPhoneOne", "inputDate",
						"updateDate", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "healthFileNo", "filingFlag", "oneStarScore", "star", "integrity", "starUpdateDate" ,"pacounty","hrcounty", "inputCenterOrganCode","inputGbcode","paGroup","hrGroup","poverty","disabled","povertyType","veryPovertyType","veryPoverty"};

				boolean r = personalRecordManagmentService.upateCover(personInfo, currentLoginInfo, properties);
				if(!r)
					return EHRMessageUtil.returnMsg(model, "ehrNoError");
				// 更新个人档案份数
				statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), "1".equals(personInfo.getHouseholdType()) ? StatisticsUtil.HR_ARCHIVE_TOTAL
						: StatisticsUtil.UNHR_ARCHIVE_TOTAL, StatisticsUtil.ADD);
				// 更新档案迁出份数
				if (!sessionPersonInfo.getInputOrganCode().equals(personInfo.getInputOrganCode())) {
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_EMIGRATION
							: StatisticsUtil.UNHR_ARCHIVE_EMIGRATION, StatisticsUtil.ADD);
				}
				//迁入人员
				if(StringUtil.isNotEmpty(rStatus) && Integer.parseInt(rStatus) == 1){
					Criteria ca = new Criteria();
					ca.add("personId",personInfo.getId());
					String[] pro = { "personId","idcard","hbpFlag","diFlag"};
					List<DmDiseaseInfo>  infos = dmDiseaseInfoDao.getList(ca, new Order("UPDATE_DATE", false), pro);
					/*
					 * if(ObjectUtil.isNotEmpty(infos)){ //删除未做的高血压、糖尿病t随访，并生成新的慢病随访
					 * if(StringUtil.isNotEmpty(infos.get(0).getHbpFlag()) &&
					 * infos.get(0).getHbpFlag().equals("2")){
					 * followupPlanService.buildHbpAndDiPlan(EHRConstants.DM_HBP_TYPE,infos.get(0).
					 * getNextHbpFollowupDate()==null?new
					 * Date():infos.get(0).getNextHbpFollowupDate(),personInfo.getId(), true); }
					 * if(StringUtil.isNotEmpty(infos.get(0).getDiFlag()) &&
					 * infos.get(0).getDiFlag().equals("2")){
					 * followupPlanService.buildHbpAndDiPlan(EHRConstants.DM_DI_TYPE,infos.get(0).
					 * getNextDiFollowupDate()==null?new
					 * Date():infos.get(0).getNextDiFollowupDate(), personInfo.getId(), true); } }
					 */
				}
			} else { // 未建档人员建档
				//add by yejianfei 20140725 建档时间
				personInfo.setInputDate(new Date());
				//add by yejianfei 20140725 建档时间
				personInfo.setFilingFlag(EHRConstants.HAD_CREATE);
				//后加身份证-判断出性别及生日
				if(StringUtil.isNotEmpty(personInfo.getIdcard())){
					personInfo.setGender(IDCardUtil.getGenderByIdCard(personInfo.getIdcard()));
					personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard()));
				}
				String[] properties = { "remarks","birthday","gender","name", "gBCode", "pahouseNumber", "livingType","householdType", "areaCode", "hrhouseNumber", "phoneNumber", "patownShip", "pastreet", "hrtownShip", "hrstreet",
						"paAddress", "hrAddress", "inputOrganCode", "inputOrganName", "inputName", "inputerId", "guardianPhoneOne", "inputDate",
						"updateDate", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "healthFileNo", "filingFlag", "inputCenterOrganCode", "inputGbcode", "oneStarScore", "star",
						"integrity", "starUpdateDate","hrcounty","pacounty","otherIdcardType","idcard","paGroup","hrGroup","poverty","disabled","povertyType","veryPovertyType","veryPoverty"};
				personalRecordManagmentService.upateCover(personInfo, currentLoginInfo, properties);
				// 更新创建个人档案份数
				statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_NEW
						: StatisticsUtil.UNHR_ARCHIVE_NEW, StatisticsUtil.ADD);
			}
			if("9".equals(personInfo.getOtherIdcardType())){
				saveWomenChildHealth(personInfo,request);
			}else if("0".equals(personInfo.getOtherIdcardType())){
				int age=IdNOToAge(personInfo.getIdcard());
				if(age<=6){
					saveWomenChildHealth(personInfo,request);
				}
			}
		}
		request.getSession().setAttribute("personInfo", personInfo);
		/*if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
			//按日期算年龄
			Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			int age = DateUtil.getAgeByBirthday(birth);
			if(age>=EHRConstants.SIXTY_FIVE_ELDER && testMap.containsKey("isNew")){
				return EHRMessageUtil.returnMsg(model, "isElder");
			}
		}*/
		return addCover(request, model);
	}

	private void saveWomenChildHealth(PersonInfo personInfo,HttpServletRequest request){
		List<WomenChildHealth> womenChildHealthList=null;
		if(ObjectUtil.isNotEmpty(personInfo.getIdcard())||ObjectUtil.isNotEmpty(personInfo.getBabyCardNo())){
			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, personInfo.getIdcard()));
			if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
				womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("BABY_CARD_NO", OP.EQ, personInfo.getBabyCardNo()));
			}
		}
		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){

			WomenChildHealth childHealth=new WomenChildHealth();
			childHealth.setBabyCardNo(personInfo.getBabyCardNo());
			childHealth.setIdCard(personInfo.getIdcard());
			childHealth.setCreateDate(new Date());
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setGender(personInfo.getGender());
			childHealth.setOrgCode(personInfo.getInputOrganCode());
			childHealth.setOrgName(personInfo.getInputOrganName());
			childHealth.setChildBirthday(personInfo.getBirthday());
			childHealth.setName(personInfo.getName());
			childHealth.setIdentityType("1");
			childHealth.setIsDelete("0");
			childHealth.setUpdateDate(new Date());
			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setPersonId(personInfo.getId().toString());
			childHealth.setHealthFileNo(personInfo.getHealthFileNo());

			wchSearchService.inerstWomenChildHealth(childHealth);
		}else{
			WomenChildHealth childHealth=womenChildHealthList.get(0);
			childHealth.setBabyCardNo(childHealth.getBabyCardNo());
			childHealth.setIdCard(personInfo.getIdcard());
			childHealth.setUpdateDate(new Date());
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setIdentityType("1");
			childHealth.setGender(personInfo.getGender());
			childHealth.setOrgCode(personInfo.getUpdateOrganCode());
			childHealth.setOrgName(personInfo.getUpdateOrganName());
			childHealth.setChildBirthday(personInfo.getBirthday());
			childHealth.setName(personInfo.getName());
			childHealth.setPersonId(personInfo.getId().toString());
			childHealth.setHealthFileNo(personInfo.getHealthFileNo());
			wchSearchService.updateWomenChildHealth(childHealth);
			//-----------------------------------------------------
			List<NeonatalFamilyVisit> neonatalFamilyVisitList= neonatalFamilyVisitDao.getList(new Criteria("BABY_CARD_NO", childHealth.getBabyCardNo()));
			if(ObjectUtil.isNotEmpty(neonatalFamilyVisitList)){
				for (int i = 0; i < neonatalFamilyVisitList.size(); i++) {
					NeonatalFamilyVisit neonatalFamilyVisit=neonatalFamilyVisitList.get(i);
					neonatalFamilyVisit.setNeonatusName(personInfo.getName());
					neonatalFamilyVisitDao.update(neonatalFamilyVisit);
				}
			}

			List<ChildHealthExamination> childHealthExamList = childHealthExamineService.getChildHealthExamList(new Criteria("BABY_CARD_NO", childHealth.getBabyCardNo()), new Order("VISIT_DATE", false));
			if(ObjectUtil.isNotEmpty(childHealthExamList)){
				for (int i = 0; i < childHealthExamList.size(); i++) {
					ChildHealthExamination childHealthExamination=childHealthExamList.get(i);
					childHealthExamination.setName(personInfo.getName());
					childHealthExaminationDao.update(childHealthExamination);
				}
			}

		}
	}


	private int IdNOToAge(String IdNO){
		int leh = IdNO.length();
		String dates="";
		if (leh == 18) {
			//身份证去除int的转换
            /*int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;*/
			dates = IdNO.substring(6, 10);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year=df.format(new Date());
			int u=Integer.parseInt(year)-Integer.parseInt(dates);
			return u;
		}else{
			dates = IdNO.substring(6, 8);
			return Integer.parseInt(dates);
		}

	}

	/**
	 * 进入新增个人基本信息表页面
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/addPersonInfo")
	public String addPersonInfo(HttpServletRequest request) {
		if (null == request.getSession().getAttribute("personInfo") || null == ((PersonInfo) request.getSession().getAttribute("personInfo")).getId()
				|| EHRConstants.UN_CREATE.equals(((PersonInfo) request.getSession().getAttribute("personInfo")).getFilingFlag())) {
			FlashScope.getCurrent(request).put("msgError", "请先填写保存封面信息!");
			return "redirect:/personRecord/addCover";
		} else {
			PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute("personInfo");
			PersonInfo persInfoBirth = personInfoDao.get(new Criteria("id",personInfo.getId()));
			request.setAttribute("personInfo", personInfo);
			if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
				//按日期算年龄
				Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
				Calendar cal=Calendar.getInstance();
				Date date =cal.getTime();
				int age = DateUtil.getAgeByBirthday(birth);
				if ((age >= 18) && (age <65)) {
					request.setAttribute("isAdult", true);
				}else if(age < 18){
					request.setAttribute("isNotAdult", true);
				}else if(age >= 65){
					request.setAttribute("isElder", "1");
				}
			}else if(ObjectUtil.isNullOrEmpty(personInfo.getIdcard())){
				if(ObjectUtil.isNullOrEmpty(personInfo.getBirthday())){
					request.setAttribute("isAdult", true);
				}else {
					Date birth = personInfo.getBirthday();
					int age = DateUtil.getAgeByBirthday(birth);
					if ((age >= 18) && (age <65)) {
						request.setAttribute("isAdult", true);
					}else if(age < 18){
						request.setAttribute("isNotAdult", true);
					}else if(age >= 65){
						request.setAttribute("isElder", "1");
					}
				}
			}
			Criteria criteria = new Criteria();
			criteria.add("id", personInfo.getId());
			// 组装前台页面选中记录项
			PersonalBasicInfoDTO personInfoDTO = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo(criteria);
			// *获取体检数据*/
			Criteria criteriaEvent = new Criteria("PERSON_ID",personInfo.getId()).add("EHR_TYPE", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode());
			EHRHealthEvent ehrHealthEvent = healthEventService.getEHRHealthEvent(criteriaEvent);
			// 查看第三页是否勾选了勾选了‘纳入慢性病患者健康管理’
			if(ObjectUtil.isNotEmpty(ehrHealthEvent)) {
				Criteria ca = new Criteria("personId", personInfo.getId()).add("ehrId", ehrHealthEvent.getEhrId());
				PhysiqueExamination physiqueExamination = personalRecordManagmentService.getPersonalPhysicalOne(ca);
				if(ObjectUtil.isNotEmpty(physiqueExamination)
						&& ObjectUtil.equals(physiqueExamination.getGuideIntoChronicDisease(), "1"))
					request.setAttribute("guideIntoChronicDiseaseFlag", 1);
			}
			request.setAttribute("PersonalBasicInfoDTO", personInfoDTO);
			//判断档案管理机构与当前登录机构是否一致
			if(!getCurrentOrg(request).getOrganCode().equals(personInfo.getInputOrganCode())){
				request.setAttribute("isNotManageOrg", true);
			}
			return "rhip.ehr.personalRecord.addBasicPersonInfo";
		}
	}

	/**
	 * 完成基本信息保存操作
	 *
	 * @param request
	 */
	@RequestMapping("/personRecord/savePersonBasicInfo")
	public String savePersonInfo(HttpServletRequest request, ModelMap model) {
		createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.UPDATE);
		PersonalBasicInfoDTO personalBasicInfoDTO = VoUtil.getFormData(request, PersonalBasicInfoDTO.class);
		if(ObjectUtil.isNullOrEmpty(personalBasicInfoDTO)){
			return "redirect:/personRecord/generatePersonId";
		}
		PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
		// 由于保存基本信息时会保存联系人电话,封面上也有联系人电话,而封面取值是从session里去的,所以这边修改之后要对session里面的联系人电话进行修改
		PersonInfo psession = (PersonInfo) request.getSession().getAttribute("personInfo");
		psession.setGuardianPhoneOne(personInfo.getGuardianPhoneOne());
		request.getSession().setAttribute("personInfo", psession);
		Integer oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
		this.getCurrentInfo(request, personInfo);
		personalBasicInfoDTO.setModifyInputName(SecurityUtils.getCurrentUser(request).getName());
		personalBasicInfoDTO.setModifyInputerId(SecurityUtils.getCurrentUser(request).getStaffCode());
		personalBasicInfoDTO.setModifyInputOrg(SecurityUtils.getCurrentOrganization(request).getOrganName());
		personalBasicInfoDTO.setModifyInputOrganCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
		personalRecordManagmentService.createBasicInfo(personalBasicInfoDTO);
		Integer newStar = personalBasicInfoDTO.getPersonInfo().getStar() == null ? 0 : personalBasicInfoDTO.getPersonInfo().getStar();
		// 同步统计数据
		syncStar(request, personalBasicInfoDTO.getPersonInfo().getHouseholdType(), oldStar, newStar);
		// 65岁以上老年人直接放入老年人名单  add by bagen at 2018-05-07
		if(ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
			Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
			int age = DateUtil.getAgeByBirthday(birth);
			if(age>=EHRConstants.SIXTY_FIVE_ELDER) {
				physicalExamRecordService.addOlderExamination(personInfo.getId(), new Date());
			}
		}
		return "redirect:/personRecord/generatePersonId";
	}

	/**
	 * 进入新增健康体检表页面
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/addPersonPhyExam")
	public String addPersonPhyExam(HttpServletRequest request, ModelMap modelMap) {
		if (null == request.getSession().getAttribute("personInfo") || null == ((PersonInfo) request.getSession().getAttribute("personInfo")).getId()
				|| EHRConstants.UN_CREATE.equals(((PersonInfo) request.getSession().getAttribute("personInfo")).getFilingFlag())) {
			FlashScope.getCurrent(request).put("msgError", "请先填写保存封面信息!");
			return "redirect:/personRecord/addCover";
		} else {
			//判断是否有体检日期。有则为修改，无则为新增
			String operateType = request.getParameter("operateType");
			String loadPrePhyexamFlag = request.getParameter("loadPrePhyexamFlag");//是否点击上一次体检信息按钮
			modelMap.addAttribute("operateType", operateType);
			String ehrId = request.getParameter("ehrId");
			/* 取得同机构下的卫生人员 */
			PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute("personInfo");
			if (null == personInfo.getId())
				return "redirect:/personRecord/addCover";

			// 女人
			if ("2".equals(personInfo.getGender())) {
				modelMap.addAttribute("isWoman", true);
			}
			// 大于65的老人以及未成年人
			if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
				//按日期算年龄
				Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
				/*Date birth = personInfo.getBirthday();*/
				Calendar cal=Calendar.getInstance();
				Date date =cal.getTime();
				int age = DateUtil.getAgeByBirthday(birth);
				if(age>=EHRConstants.SIXTY_FIVE_ELDER){
					modelMap.addAttribute("isElder", true);
				}else if(age<EHRConstants.SIXTY_FIVE_ELDER && age>=18){
					modelMap.addAttribute("isYoung", true);
				}else if(age<18 && age>=7){
					modelMap.addAttribute("isTeen", true);
				}else if(age<7){
					modelMap.addAttribute("isChild", true);
				}
				//按年份算年龄
				/*Calendar cal = Calendar.getInstance();
				int thisYear = cal.get(Calendar.YEAR);
				cal.setTime(personInfo.getBirthday());
				if (thisYear - cal.get(Calendar.YEAR) >= EHRConstants.SIXTY_FIVE_ELDER) {
					modelMap.addAttribute("isElder", true);
				}else if(thisYear - cal.get(Calendar.YEAR) < EHRConstants.SIXTY_FIVE_ELDER){
					modelMap.addAttribute("isYoung", true);
				}*/
			}
			Criteria ca = new Criteria("id", personInfo.getId());
			PersonalPhyExamDTO phyExamDTO = "add".equals(operateType) ? null : personalRecordManagmentService.getPersonalPhysical(ca, ehrId);
			/* 如果查到体检信息将体检信息带入前台，为修改 */
			if (null != phyExamDTO&&phyExamDTO.getPhysiqueExamination()!=null) {//修复PhysiqueExamination为空时报异常问题
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getFundusOculiAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setFundusOculiAnomalyFlag("2");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getDreCheckResultType())){
					phyExamDTO.getPhysiqueExamination().setDreCheckResultType("0");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getBreastAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setBreastAnomalyFlag("2");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getVulvaAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setVulvaAnomalyFlag("2");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getVaginaAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setVaginaAnomalyFlag("2");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getCervicalAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setCervicalAnomalyFlag("2");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getCorpusAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setCorpusAnomalyFlag("2");
				}
				if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getAccessoriesAnomalyFlag())){
					phyExamDTO.getPhysiqueExamination().setAccessoriesAnomalyFlag("2");
				}
				if(StringUtil.isNotEmpty(loadPrePhyexamFlag)){//点击了上一次体检信息按钮
					phyExamDTO.getPhysiqueExamination().setExaminationDate(new Date());
					phyExamDTO.getPhysiqueExamination().setPhysicalExamCode(null);
					phyExamDTO.getPhysiqueExamination().setId(null);
					phyExamDTO.getPhysiqueExamination().setEhrId(null);
					modelMap.addAttribute("loadPrePhyExamClick", true);
				}
				modelMap.addAttribute("PersonalPhyExamDTO", phyExamDTO);
			} else {
				Staff staff = staffService.getStaff(SecurityUtils.getCurrentUser(request).getStaffCode());
				if (ObjectUtil.isNotEmpty(staff)) {
					phyExamDTO = new PersonalPhyExamDTO();
					PhysiqueExamination phy = new PhysiqueExamination();
					phy.setManaDoctorId(staff.getStaffCode());
					phyExamDTO.setPhysiqueExamination(phy);
					// 为了在体检页面显示健康档案编号
					PersonInfo personInfoPHY = personalRecordManagmentService.getPersonalCover(ca);
					phyExamDTO.setPersonInfo(personInfoPHY);
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getFundusOculiAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setFundusOculiAnomalyFlag("2");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getDreCheckResultType())){
						phyExamDTO.getPhysiqueExamination().setDreCheckResultType("0");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getBreastAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setBreastAnomalyFlag("2");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getVulvaAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setVulvaAnomalyFlag("2");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getVaginaAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setVaginaAnomalyFlag("2");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getCervicalAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setCervicalAnomalyFlag("2");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getCorpusAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setCorpusAnomalyFlag("2");
					}
					if(StringUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination().getAccessoriesAnomalyFlag())){
						phyExamDTO.getPhysiqueExamination().setAccessoriesAnomalyFlag("2");
					}
					//若健康档案第二页，既往史疾病中勾选了‘高血压’、‘糖尿病’、‘重性精神病’中的任何一种，第三页‘纳入慢性病患者健康管理’默认勾选
					Criteria criteriaDis = new Criteria("personId", personInfoPHY.getId());
					EHRHealthEvent ehrHealthEventBasic = healthEventService.getEHRHealthEvent(new Criteria("EHR_TYPE", EventType.PERSON_RECORD_BASIC_INFO.getCode()).add(criteriaDis));
					if(ObjectUtil.isNotEmpty(ehrHealthEventBasic)) {
						List<DiseaseHistory> diseaseHistoryList = healthHistoryService.getDiseaseHistorys(criteriaDis.add("ehrId", ehrHealthEventBasic.getEhrId()));
						for(DiseaseHistory diseaseHistory : diseaseHistoryList) {
							String diseaseCode = diseaseHistory.getDiseaseCode();
							Date confirmDate = diseaseHistory.getConfirmationDate();
							String other = diseaseHistory.getOtherDesc();
							if (diseaseCode.equals("201")|| //高血压
									diseaseCode.equals("202") || //糖尿病
									diseaseCode.equals("207")) {//重性精神病
								phy.setGuideIntoChronicDisease("1");
							}
						}
					}
					modelMap.addAttribute("PersonalPhyExamDTO", phyExamDTO);
				}
			}
			if (!"add".equals(operateType) && !"loadPrePhyexam".equals(operateType)) {
				List<EHRHealthEvent> ehrHealthEvents = healthEventService.getEHRHealthEvents(new Criteria("personId", personInfo.getId())
								.add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode()),
						new Order("CLINIC_DATE", false));
				if (ObjectUtil.isNullOrEmpty(ehrHealthEvents)) {
					modelMap.addAttribute("newPerson", true);
				} else {
					modelMap.addAttribute("newPerson", false);
				}
				modelMap.addAttribute("ehrHealthEvents", ehrHealthEvents);
				modelMap.addAttribute("currentEhrId", phyExamDTO != null ? phyExamDTO.getPhysiqueExamination().getEhrId() : null);
			}
		}
		return "rhip.ehr.personalRecord.addPersonPhyExam";
	}

	//判断之前有无个人健康体检
	@RequestMapping(value = "/personRecord/hasExam")
	@ResponseBody
	public String hasExam(@RequestParam("personId") Long personId,HttpServletRequest request, ModelMap model) {
		String hasExam ="";
		PersonalPhyExamDTO phyExamDTO =personalRecordManagmentService.getPersonalPhysical(new Criteria("id",personId));
		if(null != phyExamDTO && !ObjectUtil.isNullOrEmpty(phyExamDTO.getPhysiqueExamination())){//若做过体检返回EhrId
			hasExam =phyExamDTO.getPhysiqueExamination().getEhrId();
		}
		return hasExam;
	}


	//打印身份证条码页面
    @RequestMapping(value = "/personRecord/tjbhPrint")
    public String tjbhPrint(@RequestParam("personId") Long personId,HttpServletRequest request, ModelMap model) {
		// *获取基本信息*
		PersonInfo personBasicInfo =personalRecordManagmentService.getPersonalCover(new Criteria("id",personId));
		model.addAttribute("personBasicInfo",personBasicInfo);
        return "rhip.ehr.personalRecord.tjbhPrint";
    }

	//判断之前有无个人健康体检
	@RequestMapping(value = "/personRecord/getPhysicalExamList")
	@ResponseBody
	public Map<String, Object> getPhysicalExamList(@RequestParam("personId") Long personId,HttpServletRequest request, ModelMap model) {
		Map<String, Object> map = new HashMap<>();
		List<EHRHealthEvent> ehrHealthEvents = healthEventService.getEHRHealthEvents(new Criteria("personId", personId)
						.add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode()),
				new Order("CLINIC_DATE", false));
		if(ObjectUtil.isNotEmpty(ehrHealthEvents)){
			if(ehrHealthEvents.size()==1){
				map.put("result", "1");

			}else {
				map.put("result", "2");
			}
		}else {
			map.put("result", "0");
		}
		return map;
	}

	@RequestMapping("/personRecord/addDepressed")
	public String addDepressed(HttpServletRequest request, ModelMap modelMap,Long personId, Long examRecordId,String editflag,String sourceFlag,String ehrId) {
		String optionsData = "";
		PersonalPhyExamDTO phyExamDTO=new PersonalPhyExamDTO();
		Criteria ca = new Criteria("id", personId);
		PersonInfo personInfo = personalRecordService.getPersonRecord(ca);
		if(ObjectUtil.isNullOrEmpty(personId)){
			phyExamDTO=null;
		}else{
			phyExamDTO =  personalRecordManagmentService.getPersonalPhysical(ca, ehrId);
		}

		if( ObjectUtil.isNotEmpty(phyExamDTO)){
			if(ObjectUtil.isNotEmpty(phyExamDTO.getPhysiqueExamination())){
				if( ObjectUtil.isNotEmpty(phyExamDTO.getPhysiqueExamination().getEmotionScreenResultStr())){
					JSONArray jsonArray = JSONArray.fromObject(phyExamDTO.getPhysiqueExamination().getEmotionScreenResultStr());
					for (int i = 0; i < jsonArray.size(); i++) {
						optionsData += "option" + jsonArray.getJSONObject(i).get("optionNo") + "_" + jsonArray.getJSONObject(i).get("score") + ";";
					}
					modelMap.addAttribute("options", optionsData);
				}}}

		modelMap.put("personInfo", personInfo);
		modelMap.put("personId", personId);
		modelMap.put("editflag", editflag);
		return "rhip.ehr.personalRecord.addDepressed";
	}

	/*@RequestMapping("/personRecord/saveDepressed")
	public String saveCover(EchIdentification identification,String optionDatas,String sourceFlag, HttpServletRequest request, ModelMap model){
		String result = "rhip.ech.manage.result";
    	if(StringUtil.isNotEmpty(optionDatas)){
    		List<EchIdentificationOption>  options = json2Obj(optionDatas);
    		identification.setIdentificationOptions(options);
    		identification.calTcm();//计算体质分；
    	}
		//此时暂时先不保存
    	updateReportInfo(identification,request);
        //echManageService.saveEchIdentification(identification);
    	// modify by Kevin Ro 2017-4-11 此处不做保存，等整个体检表保存的时候才将数据进行保存，先将此值放到session中
    	request.getSession().setAttribute("identification", identification);
        model.addAttribute("report", identification);
        //如果页面来源（sourceFlag == 2）则返回结果页面健康档案返回时体质辨识结果
        if("2".equals(sourceFlag)){
        	result = EHRMessageUtil.returnMsg(model,getTcmMap(identification));
        }
        return result;

	}*/
	/**
	 * json数组转成List
	 *
	 * @param jsonArrayStr
	 * @param
	 * @return
	 */
	private static List<EchIdentificationOption> json2Obj(String jsonArrayStr){
		JsonConfig jsonConfig = new JsonConfig();
		JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
		List<EchIdentificationOption> resultList = new ArrayList<EchIdentificationOption>();
		for (int i = 0; i < jsonObjects.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
			EchIdentificationOption option = (EchIdentificationOption) JSONObject.toBean(jsonObj, EchIdentificationOption.class);
			resultList.add(option);
		}
		return resultList;
	}
	/**
	 * 完成个人体检表保存操作
	 *
	 * @param request
	 */
	@RequestMapping("/personRecord/savePersonPhyExam")
	public String savePersonPhyExam(HttpServletRequest request, ModelMap model) {
		createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.UPDATE);
		final PersonalPhyExamDTO personalPhyExamDTO = VoUtil.getFormData(request, PersonalPhyExamDTO.class);
		List<HealthEvaluateAnomaly> healthEvaluateAnomalyList = personalPhyExamDTO.getHealthEvaluateAnomalyList();
		if (healthEvaluateAnomalyList.size() >= 5) {
			healthEvaluateAnomalyList.remove(healthEvaluateAnomalyList.size()-1);
			personalPhyExamDTO.setHealthEvaluateAnomalyList(healthEvaluateAnomalyList);
		}
		PersonInfo personInfo = personalPhyExamDTO.getPersonInfo();
		Integer oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
		Organization org = SecurityUtils.getCurrentOrganization(request);
		personalPhyExamDTO.getPhysiqueExamination().setExaminationOrganCode(org.getOrganCode());
		personalPhyExamDTO.getPhysiqueExamination().setExaminationOrganName(org.getOrganName());
		personalPhyExamDTO.setModifyInputName(SecurityUtils.getCurrentUser(request).getName());
		personalPhyExamDTO.setModifyInputerId(SecurityUtils.getCurrentUser(request).getStaffCode());
		personalPhyExamDTO.setModifyInputOrganCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
		personalPhyExamDTO.setModifyInputOrg(SecurityUtils.getCurrentOrganization(request).getOrganName());
		Staff staff = staffService.getStaff(personalPhyExamDTO.getPhysiqueExamination().getManaDoctorId());
		if (ObjectUtil.isNotEmpty(staff)) {
			personalPhyExamDTO.getPhysiqueExamination().setManaDoctorName(staff.getName());
		}
		// 如果体检日期为空, 默认为当前日期
		if (null == personalPhyExamDTO.getPhysiqueExamination().getExaminationDate()) {
			personalPhyExamDTO.getPhysiqueExamination().setExaminationDate(new Date());
		}
		boolean flg = true;
		String ehrId = request.getParameter("ehrId");
		if (StringUtil.isNotEmpty(ehrId)) {
			personalPhyExamDTO.getPhysiqueExamination().setEhrId(ehrId);
		}
		// 如果没有体检编号,则自动生成
	    if (ObjectUtil.isNullOrEmpty(personalPhyExamDTO.getPhysiqueExamination().getPhysicalExamCode())) {
	        String examCode = EHRNumberService.getSerialNum(personalPhyExamDTO.getPhysiqueExamination().getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
	        personalPhyExamDTO.getPhysiqueExamination().setPhysicalExamCode(examCode);
	    }
		try {
			//更新个人体检表
			personalRecordManagmentService.createPhysical(personalPhyExamDTO);
			Organization currentOrganization = SecurityUtils.getCurrentOrganization(request);
			final User currentUser = SecurityUtils.getCurrentUser(request);
			//体质辨识保存的session的key值
            String ideKey = SESSIONIDE + personInfo.getIdcard();
            EchIdentification identification = null;
            //新增、更新体质辨识相关
            updateIdentification(request, ideKey, personalPhyExamDTO, identification);
            
            //同步更新老年人体检
			saveToElderly(personalPhyExamDTO, currentOrganization, currentUser);
			//同步更新慢病体检表
			saveToPhyExamination(personalPhyExamDTO, currentOrganization, currentUser);
		} catch (Exception e) {
			flg = false;
			logger.debug(e);
			e.printStackTrace();
		}
		Integer newStar = personalPhyExamDTO.getPersonInfo().getStar() == null ? 0 : personalPhyExamDTO.getPersonInfo().getStar();
		// 同步统计数据
		syncStar(request, personalPhyExamDTO.getPersonInfo().getHouseholdType(), oldStar, newStar);
		return EHRMessageUtil.returnMsg(model, flg ? "success" : "failed");
	}

	/**
	 * 新增、更新体质辨识相关
	 * @param request
	 * @param ideKey
	 * @param elderlyPhyExamination
	 * @param identification
	 */
	private void updateIdentification(HttpServletRequest request, String ideKey, PersonalPhyExamDTO personalPhyExamDTO, EchIdentification identification) {
        //更新关联的体质辨识中体检编号
		if((ObjectUtil.isNotEmpty(personalPhyExamDTO.getPhysiqueExamination().getOldIdentificationId()) || ObjectUtil.isNotEmpty(personalPhyExamDTO.getPhysiqueExamination().getIdentificationId()) )
				&& personalPhyExamDTO.getPhysiqueExamination().getOldIdentificationId() != personalPhyExamDTO.getPhysiqueExamination().getIdentificationId()){
			identification = echManageService.updateEchIdentification(personalPhyExamDTO.getPhysiqueExamination().getIdentificationId());
			if(ObjectUtil.isNotEmpty(identification)){
				personalPhyExamDTO.getPhysiqueExamination().setTcmConclusion(identification.getTcmConclusion());
			}
		}
		
		//取消关联体质辨识
		if(ObjectUtil.isNullOrEmpty(personalPhyExamDTO.getPhysiqueExamination().getIdentificationId())){
			personalPhyExamDTO.getPhysiqueExamination().setTcmQiQuality(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmYinDeficiency(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmYangQuality(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmPhlegmWetness(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmHeatMedium(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmBloodQuality(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmQiStagnation(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmSpecialQuality(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmPeacefulQuality(null);
			personalPhyExamDTO.getPhysiqueExamination().setTcmConclusion(null);
		}
	}
	
	private String getAnomalyDesc(List<HealthEvaluateAnomaly> healthEvaluateAnomalyList) {
		StringBuilder sb = new StringBuilder();
		if (ObjectUtil.isNotEmpty(healthEvaluateAnomalyList)) {
			for (HealthEvaluateAnomaly anomaly : healthEvaluateAnomalyList) {
				if (anomaly == null) {
					continue;
				}
				String desc = anomaly.getHealthEvaluateAnomalyDesc();
				if (StringUtil.isNotEmpty(desc)) {
					sb.append(desc).append(";");
				}
			}
		}
		String anomalyDesc = sb.toString();
		if (StringUtil.isNotEmpty(anomalyDesc)) {
			anomalyDesc = StringUtils.substring(anomalyDesc, 0, anomalyDesc.length() - 1);
		}
		return anomalyDesc;
	}

	/** 保存到老年人体检 */
	private void saveToElderly(PersonalPhyExamDTO personalPhyExamDTO, Organization organization, User currentUser) throws Exception {
		PhysiqueExamination physiqueExamination = personalPhyExamDTO.getPhysiqueExamination();
		physiqueExamination.setEhrId(null);
		ElderlyPhyExamination elderlyPhyExamination = convertToElderlyPhyExamination(physiqueExamination);
		elderlyPhyExamination.setEhrId(null);
		elderlyPhyExamination.setId(null);
		elderlyPhyExamination.setHealthEvaluateAnomalyFlag(personalPhyExamDTO.getHealthEvaluateAnomalyFlg());
		physicalExamRecordService.savePhyExamination(physiqueExamination.getPersonId(), elderlyPhyExamination,personalPhyExamDTO, organization, currentUser, EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), syncProperties);
	}

	/** 保存到慢病人体检 */
	private void saveToPhyExamination(PersonalPhyExamDTO personalPhyExamDTO, Organization organization, User user) {
		PhysiqueExamination physiqueExamination = personalPhyExamDTO.getPhysiqueExamination();
		physiqueExamination.setEhrId(null);
		ElderlyPhyExamination elderlyPhyExamination = convertToElderlyPhyExamination(physiqueExamination);
		elderlyPhyExamination.setEhrId(null);
		elderlyPhyExamination.setId(null);
		elderlyPhyExamination.setHealthEvaluateAnomalyFlag(personalPhyExamDTO.getHealthEvaluateAnomalyFlg());
		for (HealthEvaluateAnomaly healthEvaluateAnomaly : personalPhyExamDTO.getHealthEvaluateAnomalyList()) {
			healthEvaluateAnomaly.setEhrId(null);
		}
		for (HospitalizedHistory hospitalizedHistory : personalPhyExamDTO.getHospitalizedHistoryList()) {
			if(ObjectUtil.isNotEmpty(hospitalizedHistory)){
				hospitalizedHistory.setEhrId(null);
			}

		}
		for (FamilyBedHistory familyBedHistory : personalPhyExamDTO.getFamilyBedHistoryList()) {
			if(ObjectUtil.isNotEmpty(familyBedHistory)){
				familyBedHistory.setEhrId(null);
			}

		}
		for (DrugHistory drugHistory : personalPhyExamDTO.getDrugHistoryList()) {
			if(ObjectUtil.isNotEmpty(drugHistory)){
				drugHistory.setEhrId(null);
			}

		}for (VaccinationInfo vaccinationInfo : personalPhyExamDTO.getVaccinationInfoList()) {
			if(ObjectUtil.isNotEmpty(vaccinationInfo)){
				vaccinationInfo.setEhrId(null);
			}

		}
		phyExaminationService.savePhyExaminationFromEhrMeso(personalPhyExamDTO, elderlyPhyExamination, organization, user,syncProperties);
	}

	private ElderlyPhyExamination convertToElderlyPhyExamination(PhysiqueExamination physiqueExamination) {
		ElderlyPhyExamination result = new ElderlyPhyExamination();
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		//当integer为空时，不默认成0
		ConvertUtils.register(new IntegerConverter(null),Integer.class);
		try {
			BeanUtils.copyProperties(result, physiqueExamination);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		result.setHealthEvaluateAnomalyFlag(physiqueExamination.getHealthEvaluateAnomalyFlag());
		return result;

	}

	/**
	 * 进入注销个人档案页面
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/offPersonRecord")
	public String offPersonRecord(HttpServletRequest request) {
		String personId = request.getParameter("personId");
		String status = request.getParameter("status");
		String personName = request.getParameter("personName");
		String idCard = request.getParameter("idCard");
		request.setAttribute("personId", personId);
		request.setAttribute("status", status);
		request.setAttribute("cancelPersonName", personName);
		request.setAttribute("idCard", idCard);
		if (StringUtils.isNotBlank(personId)) {
			Criteria ca = new Criteria("personId", personId);
			List<PersonCanceledInfo> personCanceledInfos = personCanceledInfoService.getCancelPersonRecords(ca, new Order("CANCELED_DATE", false));
			PersonCanceledInfo personCanceledInfo = null;
			// 得到最新的一条注销记录
			if (ObjectUtil.isNotEmpty(personCanceledInfos) && !status.equals(EHRConstants.HAD_CREATE)) {
				personCanceledInfo = personCanceledInfos.get(0);
			}
			request.setAttribute("personCanceledInfo", personCanceledInfo);
		}
		return "rhip.ehr.personalRecord.offPersonRecord";
	}

	/**
	 * 注销个人档案信息
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/checkOffPersonRecord")
	public void checkOffPersonRecord(PersonCanceledInfo personCanceledInfo, HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("remsg", "操作失败");
		map.put("restatus", "0");
		if (request.getParameter("isApprove").equals(EHRConstants.CHECK_FLAG)) {
			// 审核
			createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.CHECK);
			approvePerson(request, map, personCanceledInfo);
		} else {
			// 注销

			createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.MERGE);
			logoffPerson(request, map, personCanceledInfo, EHRConstants.HAD_OFF);
		}
		MessageUtils.outputJSONResult(JSONObject.fromObject(map).toString(), response);
	}

	/**
	 * 查看修改痕迹
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/viewModifyTrace")
	public String viewModifyTrace(HttpServletRequest request,Integer indexPage) {
		Page page = super.getPage(request, indexPage);
		String personId = request.getParameter("personId");
		request.setAttribute("personId", personId);
		Criteria criteria = new Criteria();
		Date createBeginDate = DateUtil.parseSimpleDate(request.getParameter("inputBeginDate"), null);
		Date createEndDate = DateUtil.parseSimpleDate(request.getParameter("inputEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "inputDate", createBeginDate, createEndDate);
		criteria.add("personId", personId);
		String regionType = request.getParameter("regionType");
		if (regionType != null && !regionType.equals("-1"))
			criteria.add("regionType", regionType);
		Order order = new Order("ID", false);
		PageList<ModifyTrace> pageList = modifyTraceService.getModifyTraceList(criteria, page, order);
		request.setAttribute("pageList", pageList.getList());
		request.setAttribute("page", pageList.getPage());
		return "rhip.ehr.personalRecord.viewModifyTrace";
	}

	@RequestMapping("/personRecord/showModifyTrace")
	public String showModifyPage(@RequestParam(value = "modifyPersonId") String modifyPersonId, HttpServletRequest request) {
		request.setAttribute("modifyPersonId", modifyPersonId);
		return "rhip.ehr.personalRecord.showModifyTrace";
	}

	@RequestMapping("/personRecord/getPersonByIdcard")
	@ResponseBody
	public PersonInfo getPersonByIdcard(HttpServletRequest request, HttpServletResponse response) {
		Criteria c = new Criteria();
		String idCard=request.getParameter("idCard");
		//不同证件类型查询不同
		if(StringUtil.isNullOrEmpty(request.getParameter("otherIdcardType")) ||"0".equals(request.getParameter("otherIdcardType")) ){
			if(request.getParameter("idCard").length()==15){
				idCard=IDCardUtil.conver15CardTo18(request.getParameter("idCard"));
			}
			c.add("idcard", idCard);
		}else if("9".equals(request.getParameter("otherIdcardType"))){
			c.add("babyCardNo",idCard);
		}else{
			c.add("otherIdcard",idCard);
		}
		PersonInfo personInfo=personalRecordManagmentService.getPersonalCover(c);
		if(ObjectUtil.isNullOrEmpty(personInfo)){
			c.remove("idcard");
			c.add("idcard",request.getParameter("idCard"));
			personInfo=personalRecordManagmentService.getPersonalCover(c);
			if(ObjectUtil.isNotEmpty(personInfo)){
				if(ObjectUtil.isNotEmpty(personInfo.getIdcard())){
					if(personInfo.getIdcard().length()==15){
						personInfo.setIdcard(IDCardUtil.conver15CardTo18(personInfo.getIdcard()));
					}
				}
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo)) {
			getPersonAddress(personInfo);
		}/*else{             //新增健康档案-输入宝宝卡号及身份证会清空已填好的信息  modify by yuanzg
			personInfo = new PersonInfo();
		}
		personInfo.setIdcard(idCard);*/
		return personInfo;
	}

	@RequestMapping("/personRecord/removeSession")
	@ResponseBody
	public boolean removeSession(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("personInfo"))) {
			request.getSession().removeAttribute("personInfo");
		}
		return true;
	}

	@RequestMapping("/personRecord/readRecord")
	public String readRecord(@RequestParam(value = "recordPersonId") String recordPersonId, HttpServletRequest request, ModelMap model) {
		model.addAttribute("recordPersonId", recordPersonId);
		return "rhip.ehr.personalRecord.readRecord";
	}

	@RequestMapping("/personRecord/readRecordList")
	public String readRecordList(@RequestParam(value = "personId") String personId, @RequestParam(value = "beginDate") Date beginDate, @RequestParam(value = "endDate") Date endDate,
								 HttpServletRequest request, ModelMap model) {
		PersonInfo personinfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", personId));
		if (ObjectUtil.isNullOrEmpty(personinfo)) {
			return null;
		}
		Criteria criteria = new Criteria();
		criteria.add("personIdcard", personinfo.getIdcard());
		DateUtil.getCriteriaByDateRange(criteria, "readDate", beginDate, endDate);
		Order order = new Order("READ_DATE", false);
		List<ReadHealthRecord> readRecords = readHealthRecordService.getReadRecordList(criteria, buildPage(request), order);
		model.addAttribute("readHealthRecords", readRecords);
		return "rhip.ehr.personalRecord.readRecordList";
	}

	/**
	 * 档案撤销
	 *
	 * @param personId
	 * @param filingFlag
	 * @return
	 */
	@RequestMapping("/personRecord/personOffBack")
	public @ResponseBody
	String personOffBack(@RequestParam(value = "personId") Long personId, @RequestParam(value = "filingFlag") String filingFlag,
						 HttpServletRequest request) {
		PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", personId));
		if (ObjectUtil.isNotEmpty(personInfo)) {
			personInfo.setFilingFlag("1");
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			boolean flag = personalRecordManagmentService.upateCover(personInfo, currentLoginInfo,"filingFlag");
			filingFlag = flag ? personInfo.getFilingFlag() : filingFlag;
		}
		return filingFlag;
	}

	/**
	 * 档案迁出
	 * @param personId
	 * @return
	 */
	@RequestMapping("/personRecord/moveOut")
	public @ResponseBody
	String personMoveOut(@RequestParam(value = "personId") Long personId) {
		personalRecordManagmentService.updatePersonFilingFlag(personId, EHRConstants.MOVE_OUT);
		return "1";
	}

	/**
	 * 档案迁入审核
	 * @param personId
	 * @return
	 */
	@RequestMapping("/personRecord/moveInCheck")
	@ResponseBody
	public String personMoveCheck(@RequestParam(value = "personId") Long personId,HttpServletRequest request){
		Criteria criteria = new Criteria();
		criteria.add("personId",personId);
		criteria.add("oldStationCode",getCurrentOrg(request).getOrganCode());
		PersonMoveInfo personMoveInfo = personMoveService.getPersonMoveInfo(criteria);
		String flag = "";
		if(ObjectUtil.isNotEmpty(personMoveInfo)){
			Date moveOutDate = personMoveInfo.getOperationDate();
			long moveYear = moveOutDate.getYear()+1900;
			long moveMonth = moveOutDate.getMonth()+1;
			long moveDay = moveOutDate.getDay();
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				long threeMYear = (moveMonth + 3) / 12 + moveYear;
				long threeMMonth = (moveMonth + 3) % 12;
				Date threeMDate =  sdf.parse("" + threeMYear + "-" + threeMMonth + "-" + moveDay + "");
				if(threeMDate.getTime() - new Date().getTime()>=0){//距离上次迁档还不足三个月无法迁入
					flag = "1";
				}else{
					flag = "0";
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}else{
			flag = "0";
		}
		return flag;
	}

	/**
	 * 档案激活
	 *
	 * @param personId
	 * @param filingFlag
	 * @return
	 */
	@RequestMapping("/personRecord/personOffActive")
	public @ResponseBody
	String personOffActive(@RequestParam(value = "personId") Long personId, @RequestParam(value = "filingFlag") String filingFlag) {
		return personalRecordManagmentService.activePersonRecord(personId, filingFlag);
	}

	@RequestMapping("/personRecord/export")
	public void exportPersonInfoList(HttpServletRequest request, HttpServletResponse response) {
		final Criteria criteria = createSearchCriteria(request);
		final Order order = new Order("UPDATE_DATE", false);
		excelExportService.exportListExecl("人员列表", PersonInfo.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				return personalRecordService.exportPersonRecordList(page, criteria, order);
			}
		});
	}

	/**
	 * 获取居民本年度老年人健康体检信息记录表ID
	 *
	 * @param personId
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping(value="/personRecord/checkEchStatus")
	public String checkEchStatus(Long personId, ModelMap model){
		Long result = personalRecordManagmentService.getExamRecordId(personId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("examRecordId", result);
		map.put("personId", personId);
		return EHRMessageUtil.returnMsg(model,map);
	}
	
    /**
     * 获取体质辨识
     * @param personId
     * @return
     */
    @RequestMapping(value="/personRecord/queryIdentifications")
    public String queryIdentifications(Long personId, Long identificationId, HttpServletRequest request){
    	Criteria criteria_temp = new Criteria("personId", personId);
		List<EchIdentification> list = echManageService.getEchIdentification(criteria_temp);
    	request.setAttribute("identifications", list);
    	if(ObjectUtil.isNotEmpty(identificationId) && identificationId!=0){
    		request.setAttribute("identificationId", identificationId);
    	}
    	request.setAttribute("personId", personId);
    	return "rhip.ehr.personalRecord.identifications";
    }
    
	/**
	 * 查询列表
	 *
	 * @param request
	 */
	private void searchResult(HttpServletRequest request) {
		Criteria criteria = createSearchCriteria(request);
		Order order = new Order("B.UPDATE_DATE", false);
		order.desc("B.ID");
		PageList<PersonInfo> personRecordList = personalRecordService.queryPersonRecordList(criteria, buildPage(request), order);
		request.setAttribute("personRecordList", personRecordList.getList());
	}

	private void logoffPerson(HttpServletRequest request, Map<String, String> map, PersonCanceledInfo personCanceledInfo, String status) {
		User userInfo = SecurityUtils.getCurrentUser(request);
		Organization organization = SecurityUtils.getCurrentOrganization(request);
		personCanceledInfo.setCanceledIdcard(userInfo.getIdentityCard());
		personCanceledInfo.setCanceledName(userInfo.getName());
		personCanceledInfo.setCanceledOrganCode(organization.getOrganCode());
		personCanceledInfo.setCanceledOrganName(organization.getOrganName());
		personCanceledInfo.setRejectedReason(null);
		personCanceledInfo.setIsDelete(0);
		personCanceledInfo.setCanceledStatus(EHRConstants.CANCELED);
		personCanceledInfo.setCanceledIp(getRequestIp(request));
		boolean flg = personCanceledInfoService.offPersonCanceled(status, personCanceledInfo) > 0;
		if (flg) {
			map.put("remsg", "结案成功!");
			map.put("restatus", String.valueOf(status));
		}
	}

	/** 取得同机构下的卫生人员 */
	private List<User> getHospitalStaff(HttpServletRequest request) {
		Organization org = SecurityUtils.getCurrentOrganization(request);
		UserRole userRole = new UserRole();
		userRole.setOrganCode(org.getOrganCode());
		userRole.setRoleCode("02"); // 卫生人员角色Id
		return ehrSecurityService.getUserList(userRole,null);
	}

	private void approvePerson(HttpServletRequest request, Map<String, String> map, PersonCanceledInfo personCanceledInfo) {
		String status = request.getParameter("status").toString();
		boolean flg = personCanceledInfoService.approveCancelPerson(status, personCanceledInfo) > 0;
		if (flg) {
			String msg = EHRConstants.HAD_OFF.equals(status) ? "审核成功!" : "拒绝成功!";
			map.put("remsg", msg);
			map.put("restatus", String.valueOf(status));

			if (EHRConstants.CHECK_FLAG.equals(status)) {
				createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.DELETE);
				PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", personCanceledInfo.getPersonId()));
				Organization org = new Organization();
				org.setOrganCode(personInfo.getInputOrganCode());
				org.setOrganName(personInfo.getInputOrganName());
				statisticsService.syncStatisticsData(org, personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_CANCEL : StatisticsUtil.UNHR_ARCHIVE_CANCEL, StatisticsUtil.ADD);
			} else {
				createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.UPDATE);
			}
		}
	}

	private void syncStar(HttpServletRequest request, String householdType, Integer oldStar, Integer newStar) {
		// 星级发生改变
		if (!oldStar.equals(newStar)) {
			if (oldStar == 0) {
				if (newStar == 1)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_ONE_STAR : StatisticsUtil.UNHR_ONE_STAR,
							StatisticsUtil.ADD);
				else if (newStar == 2)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_TWO_STAR : StatisticsUtil.UNHR_TWO_STAR,
							StatisticsUtil.ADD);
				else if (newStar == 3)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_THREE_STAR : StatisticsUtil.UNHR_THREE_STAR,
							StatisticsUtil.ADD);
			} else if (oldStar == 1) {
				statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_ONE_STAR : StatisticsUtil.UNHR_ONE_STAR,
						StatisticsUtil.DELETE);
				if (newStar == 2)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_TWO_STAR : StatisticsUtil.UNHR_TWO_STAR,
							StatisticsUtil.ADD);
				else if (newStar == 3)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_THREE_STAR : StatisticsUtil.UNHR_THREE_STAR,
							StatisticsUtil.ADD);
			} else if (oldStar == 2) {
				statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_TWO_STAR : StatisticsUtil.UNHR_TWO_STAR,
						StatisticsUtil.DELETE);
				if (newStar == 1)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_ONE_STAR : StatisticsUtil.UNHR_ONE_STAR,
							StatisticsUtil.ADD);
				else if (newStar == 3)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_THREE_STAR : StatisticsUtil.UNHR_THREE_STAR,
							StatisticsUtil.ADD);
			} else if (oldStar == 3) {
				statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_THREE_STAR : StatisticsUtil.UNHR_THREE_STAR,
						StatisticsUtil.DELETE);
				if (newStar == 1)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_ONE_STAR : StatisticsUtil.UNHR_ONE_STAR,
							StatisticsUtil.ADD);
				else if (newStar == 2)
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), householdType.equals("1") ? StatisticsUtil.HR_TWO_STAR : StatisticsUtil.UNHR_TWO_STAR,
							StatisticsUtil.ADD);
			}
		}
	}

	/**
	 * 内部方法:创建查询条件对象
	 *
	 * @param request
	 * @return
	 */
	private Criteria createSearchCriteria(HttpServletRequest request) {
		Criteria criteria = new Criteria();
		// 姓名
		String likeFlag = request.getParameter("likeFlag");
		if (StringUtils.isNotEmpty(request.getParameter("personName")))
			if(StringUtils.isNotEmpty(likeFlag) && likeFlag.equalsIgnoreCase("like")){
				criteria.add("name", OP.LIKE, request.getParameter("personName"));
			}else{
				criteria.add("name", OP.EQ, request.getParameter("personName"));
			}
		//户籍居委会
		if(StringUtil.isNotEmpty(request.getParameter("hrtownShip"))){
			criteria.add("hrtownShip",request.getParameter("hrtownShip"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("hrstreet"))){
			criteria.add("hrstreet",request.getParameter("hrstreet"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("hrGroup"))){
			criteria.add("hrGroup",request.getParameter("hrGroup"));
		}
		//现住址居委会
		if(StringUtil.isNotEmpty(request.getParameter("patownShip"))){
			criteria.add("patownShip",request.getParameter("patownShip"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("pastreet"))){
			criteria.add("pastreet",request.getParameter("pastreet"));
		}
		// 建档时间
		if (StringUtils.isNotEmpty(request.getParameter("paAddress"))){
			criteria.add("paAddress", OP.LIKE, request.getParameter("paAddress"));
		}

		Date createBeginDate = DateUtil.parseSimpleDate(request.getParameter("createBeginDate"), null);
		Date createEndDate = DateUtil.parseSimpleDate(request.getParameter("createEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "inputDate", createBeginDate, createEndDate);
		// 更新时间
		Date updateBeginDate = DateUtil.parseSimpleDate(request.getParameter("updateBeginDate"), null);
		Date updateEndDate = DateUtil.parseSimpleDate(request.getParameter("updateEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "updateDate", updateBeginDate, updateEndDate);
		String orgCode = request.getParameter("orgCode");

		// 【健康档案】暂时开放待迁档查看权限，暂时 角色 可以看到所有待迁档
		if (StringUtils.isNotEmpty(request.getParameter("filingFlag")) &&
				!ObjectUtil.equals(request.getParameter("filingFlag"), "5")) {
			if(SecurityUtils.hasRole(RoleType.JKJKDN, request)){//疾控健康档案
				String searchCenter = request.getParameter("searchCenter");
				if(ObjectUtil.isNotEmpty(searchCenter)){
					List<String> orgCodes = this.getOrgCodeByOrgCode(searchCenter);
					criteria.add("inputOrganCode", OP.IN, orgCodes);
				}
				String searchstation = request.getParameter("searchstation");
				if(ObjectUtil.isNotEmpty(searchstation)){
					criteria.add("inputOrganCode", searchstation);
				}
			}else if(SecurityUtils.hasRole(RoleType.ZXJKDN, request)){//中心
				if(ObjectUtil.isNotEmpty(orgCode)){
					criteria.add("inputOrganCode", orgCode);
				}else{
					List<String> orgCodes = this.getOrgCodeByOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
					criteria.add("inputOrganCode", OP.IN, orgCodes);
				}
			} else if(SecurityUtils.hasRole(RoleType.ZJKDN, request)) {//站
				if(ObjectUtil.isNullOrEmpty(orgCode)) {
					orgCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
				}
				criteria.add("inputOrganCode",  orgCode);
			}else {
				if(ObjectUtil.isNullOrEmpty(orgCode)) {
					orgCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
				}
				criteria.add("inputOrganCode",  orgCode);
			}
		}

		// 常住类型
		if (StringUtils.isNotEmpty(request.getParameter("householdType"))) {
			int householdType = Integer.parseInt(request.getParameter("householdType"));
			if (householdType != -1)
				criteria.add("householdType", request.getParameter("householdType"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("poverty"))){
			int poverty = Integer.parseInt(request.getParameter("poverty"));
			if (poverty != -1)
				criteria.add("poverty", request.getParameter("poverty"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("disabled"))){
			int poverty = Integer.parseInt(request.getParameter("disabled"));
			if (poverty != -1)
				criteria.add("disabled", request.getParameter("disabled"));
		}if(StringUtils.isNotEmpty(request.getParameter("veryPoverty"))){
			int poverty = Integer.parseInt(request.getParameter("veryPoverty"));
			if (poverty != -1)
				criteria.add("veryPoverty", request.getParameter("veryPoverty"));
		}

		// 年龄段
		int eYear = -1;
		int bYear = -1;
		if (StringUtils.isNotEmpty(request.getParameter("beginAge"))) {
			eYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("beginAge")));
		}
		if (StringUtils.isNotEmpty(request.getParameter("endAge"))) {
			bYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("endAge")));
		}
		DateUtil.getCriteriaByYearRange(criteria, "birthday", bYear, eYear);
		// 性别
		if (StringUtils.isNotEmpty(request.getParameter("genderCode"))) {
			int genderCode = Integer.parseInt(request.getParameter("genderCode"));
			if (genderCode != -1)
				criteria.add("gender", request.getParameter("genderCode"));
		}
		// 身份证
		if (StringUtils.isNotEmpty(request.getParameter("idCard")))
			criteria.add("idCard", request.getParameter("idCard"));
		//健康档案编号
		if(StringUtil.isNotEmpty(request.getParameter("healthFileNo"))){
			criteria.add("healthFileNo", OP.LIKE,request.getParameter("healthFileNo"));
		}
		// 档案类型
		if (StringUtils.isNotEmpty(request.getParameter("filingFlag"))) {
			String filingflag = request.getParameter("filingFlag");
			if ("0".equals(filingflag) || "4".equals(filingflag)) {
				criteria.remove("inputOrganCode");
			}
			criteria.add("filingFlag", filingflag);
		}
		// 星级
		String starType = request.getParameter("starType");
		if (StringUtils.isNotBlank(starType) && !"-1".equals(starType)) {
			criteria.add("star", starType.trim());
		}
		String areaCode = request.getParameter("orgArea");
		if (StringUtils.isNotBlank(areaCode) && !"-1".equals(areaCode)) {
			criteria.add("pastreet", areaCode);
		}//建档医生
		String inputerId=request.getParameter("inputerId");
		if (StringUtils.isNotBlank(inputerId)) {
			criteria.add("inputerId", inputerId);
		}

		String povertyType=request.getParameter("povertyType");
		if (StringUtils.isNotBlank(povertyType)) {
			criteria.add("povertyType", povertyType);
		}
		String veryPovertyType=request.getParameter("veryPovertyType");
		if (StringUtils.isNotBlank(veryPovertyType)) {
			criteria.add("veryPovertyType", veryPovertyType);
		}
		// 动态档案
		if (StringUtils.isNotEmpty(request.getParameter("dynamicRecord"))) {
			int dynamicRecord = Integer.parseInt(request.getParameter("dynamicRecord"));
			if(dynamicRecord == 0){
				criteria.add("ID", OP.NOTIN, " SELECT PERSON_ID FROM BI_MODIFY_TRACE ");
			}else if(dynamicRecord == 1){
				criteria.add("ID", OP.IN, "SELECT PERSON_ID FROM BI_MODIFY_TRACE ");
			}
		}

		// 人群分类
		if (StringUtils.isNotEmpty(request.getParameter("groupClassification"))) {
			criteria.add("groupClassification", request.getParameter("groupClassification"));
		}

		//是否体检
		if(StringUtils.isNotEmpty(request.getParameter("isPhyExam"))){
			criteria.add("isPhyExam", request.getParameter("isPhyExam"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("clinicYear"))){
			criteria.add("clinicYear", request.getParameter("clinicYear"));
		}
		//健康体检页面 查询条件体检时间 或 体检录入时间 或 打印体检按编号 不为空时
		if(StringUtils.isNotEmpty(request.getParameter("urlFromPhysicalExam"))
				&& (StringUtils.isNotEmpty(request.getParameter("personPhyExamStartDate"))||
				StringUtils.isNotEmpty(request.getParameter("personPhyExamEndDate"))||
				StringUtils.isNotEmpty(request.getParameter("tjBeginDate"))||
				StringUtils.isNotEmpty(request.getParameter("tjEndDate"))||
				StringUtils.isNotEmpty(request.getParameter("tjbh")))){
			criteria.add("isPhyExam", "2");
		}
		//体检时间
		if(StringUtils.isNotEmpty(request.getParameter("personPhyExamStartDate"))){
			criteria.add("personPhyExamStartDate", request.getParameter("personPhyExamStartDate"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("personPhyExamEndDate"))){
			criteria.add("personPhyExamEndDate", request.getParameter("personPhyExamEndDate"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("tjBeginDate"))){
			criteria.add("tjBeginDate", request.getParameter("tjBeginDate"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("tjEndDate"))){
			criteria.add("tjEndDate", request.getParameter("tjEndDate"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("tjbh"))){
			criteria.add("tjbh", request.getParameter("tjbh"));
		}
		// 是否签约 modify by yejianfei 2019/01/07
		String signFlag = request.getParameter("signFlag");
		if (StringUtil.isNotEmpty(signFlag)) {
			if("0".equals(signFlag)){
				//签约状态字典：FS10399，0：表示未签约
				Criteria signCri = new Criteria();
				signCri.add("signFlag",signFlag);
				signCri.add(LOP.OR,"signFlag",OP.IS,null);
				criteria.add(signCri);
			}else{
				criteria.add("signFlag", NumberUtil.convert(signFlag,Integer.class));
			}
		}
		//0152922: 【团风健康档案-区域档案/个人档案】添加查询条件，是否有医疗记录，查询字段bi_person_info中ehr_flag
		String ehrFlag=request.getParameter("ehrFlag");//是否有医疗记录
		String ylTypes=request.getParameter("ylTypes");//医疗记录类型
		if(EHRConstants.EHR_FLAG_0.equals(ehrFlag)){//没有医疗记录
			criteria.add("ehrFlag", ehrFlag);
		}
		else if(EHRConstants.EHR_FLAG_1.equals(ehrFlag)){//有医疗记录
			if (StringUtils.isNotEmpty(ylTypes)) {//有选医疗记录类型
				criteria.add("ehrFlag", ylTypes);
			}else{//未选医疗记录类型
				criteria.add("ehrFlag",OP.IN,new String[]{EHRConstants.EHR_FLAG_1,EHRConstants.EHR_FLAG_2});
			}

		}
		return criteria;
	}

	// 获取当前登录者的信息和所在机构的信息
	private void getCurrentInfo(HttpServletRequest request, PersonInfo personInfo) {
		User currentUser = SecurityUtils.getCurrentUser(request);
		personInfo.setUpdateDate(new Date());
		personInfo.setUpdateIdcard(currentUser.getIdentityCard());
		personInfo.setUpdateName(currentUser.getName());
		personInfo.setUpdateInputerId(currentUser.getStaffCode());
		Organization currentOrganization = SecurityUtils.getCurrentOrganization(request);
		personInfo.setUpdateOrganName(currentOrganization.getOrganName());
		personInfo.setUpdateOrganCode(currentOrganization.getOrganCode());
	}

	private void getPersonAddress(PersonInfo personInfo) {
		String paAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getPacounty())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPatownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String pacountyName = paDicItem1.getItemName();
				paAddressDetail = pacountyName;
			}
		}

		if (ObjectUtil.isNotEmpty(personInfo.getPatownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPastreet());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String paStreetName = paDicItem1.getItemName();
				paAddressDetail += paStreetName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getPastreet())) {
			DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getPaGroup());
			if (ObjectUtil.isNotEmpty(paDicItem2)) {
				String paVillagName = paDicItem2.getItemName();
				paAddressDetail += paVillagName;
			}
		}

		String hrAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getHrcounty())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrtownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String hrcountyName = paDicItem1.getItemName();
				hrAddressDetail = hrcountyName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrtownShip())) {
			DicItem hrDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrstreet());
			if (ObjectUtil.isNotEmpty(hrDicItem1)) {
				String paTownName = hrDicItem1.getItemName();
				hrAddressDetail += paTownName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrstreet())) {
			DicItem hrDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrGroup());
			if (ObjectUtil.isNotEmpty(hrDicItem2)) {
				String paStreetName = hrDicItem2.getItemName();
				hrAddressDetail += paStreetName;
			}
		}
		personInfo.setHrAddressDetail(hrAddressDetail);
		personInfo.setPaAddressDetail(paAddressDetail);
	}

	@RequestMapping("/personRecord/importExcel")
	public String importExcel(HttpServletRequest request, Model model) {
		return "rhip.ehr.personRecord.importExcel";
	}

	@RequestMapping("/personRecord/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response, String format) throws IOException {
		String fileName = "xls".equals(format) ? "person_record.xls" : "person_record.xlsx";
		setExcelDownLoadResponse(response, fileName, format);
		downFile("../views/personRecord/template/"+fileName, response);
	}

	protected void setExcelDownLoadResponse(HttpServletResponse response, String fileName, String format) {
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		response.setContentType("text/"+format);
	}

	protected void downFile(String filePath, HttpServletResponse response) throws IOException {
		URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
		InputStream in = new BufferedInputStream(url.openStream());
		OutputStream out = new BufferedOutputStream(response.getOutputStream());
		try {
			byte[] buffer = new byte[1024 * 8];
			int j = -1;
			while ((j = in.read(buffer)) != -1) {
				out.write(buffer, 0, j);
			}
		} finally {
			in.close();
			out.flush();
			out.close();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/personRecord/upload")
	public void upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {
		ModelMap model = new ModelMap();
		try {
			List<String> errorMsgs = new ArrayList<String>();
			List<Record> list = readXlsFile(file.getInputStream());
			List<PersonInfo> personList = new ArrayList<PersonInfo>();
			PersonInfo personInfoDb = new PersonInfo();
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			//总条数
			int totalNum = 0;
			int haveNum = 0;
			//IE下很多空行也算 为了解决这个问题 火狐下没有问题
			boolean isEmpty = true;
			for(Record record : list) {
				if (ObjectUtil.isNotEmpty(record)) {
					totalNum++;
					isEmpty = false;
					String idcard = (String) record.get("idcard");
					PersonInfo personInfo = new PersonInfo();
					if (ObjectUtil.isNullOrEmpty(idcard)) {
						addErrorMsg(errorMsgs, "身份证号不能为空！");
						continue;
					} else if (!IDCardUtil.validateCard(idcard)) {
						addErrorMsg(errorMsgs, "身份证号不合法！");
						continue;
					} else {
						personInfoDb = personalRecordManagmentService.getPersonalCover(new Criteria("idcard", idcard.toUpperCase()));
						if (personInfoDb != null && !ObjectUtil.equals(personInfoDb.getFilingFlag(), EHRConstants.UN_CREATE)) {
							haveNum = haveNum + 1;
							addErrorMsg(errorMsgs, "身份证号(" + idcard + ")的患者健康档案已存在!");
							continue;
						}
						personInfo.setIdcard(idcard);
					}
					if (!validateMessage(record, personInfo, errorMsgs, request)) {
						continue;
					}
					// 冗余中心organCode和gbCode
					Organization inputOrg = organizationApp.queryOrgan(personInfo.getInputOrganCode());
					if (ObjectUtil.isNotEmpty(inputOrg)) {
						personInfo.setInputGbcode(inputOrg.getGbCode());
						//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
						if(ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.STATION.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.INFIRMARY.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.CLINIC.getValue())) {
							personInfo.setInputCenterOrganCode(inputOrg.getParentCode());
						} else if(ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.HOSPITAL.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())		) {
							//中心、卫生院、综合医院 建档InputCenterOrganCode赋值为自己的code
							personInfo.setInputCenterOrganCode(inputOrg.getOrganCode());
						}
					}
					this.setDefaultVaule(personInfo);
					try {
						if(ObjectUtil.isNotEmpty(personInfoDb) && ObjectUtil.equals(personInfoDb.getFilingFlag(), EHRConstants.UN_CREATE)) {//未建档
							personInfo.setId(personInfoDb.getId());
							personInfo.setHealthFileNo(personInfoDb.getHealthFileNo());
							personInfo.setInputDate(new Date());
							personInfo.setFilingFlag(EHRConstants.HAD_CREATE);
							String[] properties = { "name", "householdType", "phoneNumber", "guardianPhoneOne", "patownShip", "pastreet", "inputIdcard",
									"inputOrganCode", "inputOrganName", "inputName", "inputerId", "inputDate", "healthFileNo",
									"updateDate", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "filingFlag", "inputCenterOrganCode", "inputGbcode", "oneStarScore", "star",
									"integrity", "starUpdateDate" };
							personalRecordManagmentService.upateCover(personInfo, currentLoginInfo, properties);
						} else {
							personInfo = personalRecordManagmentService.createCover(personInfo, currentLoginInfo);
						}
					} catch (Exception e) {
						addErrorMsg(errorMsgs, "身份证号(" + idcard + ")的患者创建健康档案失败!");
						logger.error(e.getMessage());
						continue;
					}
					Integer newStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
					createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.ADD);
					syncStar(request, personInfo.getHouseholdType(), 0, newStar);
					// 更新创建个人档案份数
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_NEW
							: StatisticsUtil.UNHR_ARCHIVE_NEW, StatisticsUtil.ADD);
					personList.add(personInfo);
				}
			}
			String message = "总共导入" + totalNum + "条机构，成功" + personList.size() + "条，失败" + (totalNum - personList.size()) + "条\\r\\n";
			if(isEmpty) message = "请输入必填项\\: *姓名；身份证；常住类型；联系电话；联系人电话";
			if(errorMsgs.size() > 0) message+= getErrorMsg(errorMsgs);
			model.addAttribute("message", message);
			response.setContentType("text/html");
			response.getWriter().write("{\"message\":\"" + message + "\"}");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			response.setContentType("text/html");
			response.getWriter().write("{\"message\":\"健康档案批量导入出错\"}");
			throw new RuntimeException("健康档案批量导入出错",e);
		}
//		return model;
	}

	/**
	 * 数据库导入健康档案
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/personRecord/daBaseImport")
	public void upload( HttpServletResponse response, HttpServletRequest request) throws IOException {
		ModelMap model = new ModelMap();
		try {
			Organization organ = SecurityUtils.getCurrentOrganization(request);
			String orgCode = organ.getOrganCode();
			Criteria criteria = new Criteria();
			criteria.add("ORGAN_CODE",orgCode);
			List<String> errorMsgs = new ArrayList<String>();
			List<PersonInfo> personList = new ArrayList<PersonInfo>();
			PersonInfo personInfoDb = new PersonInfo();
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");

			int haveNum = 0;
			int totalNum = 0;
			//IE下很多空行也算 为了解决这个问题 火狐下没有问题
			boolean isEmpty = true;
			List<ExcelToDB> ExcelToDBList =  excelHealthRecordService.getExcelHealthRecord(criteria);
			for(ExcelToDB excelToDB : ExcelToDBList) {
				if (ObjectUtil.isNotEmpty(excelToDB)) {
					totalNum ++;
					String idcard = excelToDB.getIdCard();
					Criteria criteriaCard = new Criteria();
					criteriaCard.add("IDCARD",idcard);
					if(ObjectUtil.isNotEmpty(personInfoDao.get(criteriaCard))){
						continue;
					}
					isEmpty = false;
					PersonInfo personInfo = new PersonInfo();
					if (ObjectUtil.isNullOrEmpty(idcard)) {
						addErrorMsg(errorMsgs, "身份证号不能为空！");
						continue;
					} else if (!IDCardUtil.validateCard(idcard)) {
						addErrorMsg(errorMsgs, "身份证号不合法！");
						continue;
					} else {
						personInfoDb = personalRecordManagmentService.getPersonalCover(new Criteria("idcard", idcard));
						if (personInfoDb != null && !ObjectUtil.equals(personInfoDb.getFilingFlag(), EHRConstants.UN_CREATE)) {
							haveNum = haveNum + 1;
							addErrorMsg(errorMsgs, "身份证号(" + idcard + ")的患者健康档案已存在!");
							continue;
						}
						personInfo.setIdcard(idcard);
					}
					if (!validatePersonMessage(excelToDB, personInfo, errorMsgs, request)) {
						continue;
					}
					personInfo.setHealthFileNo(excelToDB.getHealthFileNo());
					// 冗余中心organCode和gbCode
					Organization inputOrg = organizationApp.queryOrgan(personInfo.getInputOrganCode());
					if (ObjectUtil.isNotEmpty(inputOrg)) {
						personInfo.setInputGbcode(inputOrg.getGbCode());
						//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
						if(ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.STATION.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.INFIRMARY.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.CLINIC.getValue())) {
							personInfo.setInputCenterOrganCode(inputOrg.getParentCode());
						} else if(ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.HOSPITAL.getValue()) ||
								ObjectUtil.equals(inputOrg.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())		) {
							//中心、卫生院、综合医院 建档InputCenterOrganCode赋值为自己的code
							personInfo.setInputCenterOrganCode(inputOrg.getOrganCode());
						}
					}
					this.setDefaultVaule(personInfo);
					try {
						if(ObjectUtil.isNotEmpty(personInfoDb) && ObjectUtil.equals(personInfoDb.getFilingFlag(), EHRConstants.UN_CREATE)) {//未建档
							personInfo.setId(personInfoDb.getId());
							personInfo.setHealthFileNo(personInfoDb.getHealthFileNo());
							personInfo.setInputDate(new Date());
							personInfo.setFilingFlag(EHRConstants.HAD_CREATE);
							String[] properties = { "name", "householdType", "phoneNumber", "guardianPhoneOne", "patownShip", "pastreet", "inputIdcard",
									"inputOrganCode", "inputOrganName", "inputName", "inputerId", "inputDate", "healthFileNo",
									"updateDate", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "filingFlag", "inputCenterOrganCode", "inputGbcode", "oneStarScore", "star",
									"integrity", "starUpdateDate","poverty" };
							personalRecordManagmentService.upateCover(personInfo, currentLoginInfo, properties);
						} else {
							personInfo = personalRecordManagmentService.createCover(personInfo, currentLoginInfo);
							if(ObjectUtil.isNullOrEmpty(personInfo.getHealthFileNo())) {
								addErrorMsg(errorMsgs, "档案编码生成异常！");
								continue;
							}
						}
					} catch (Exception e) {
						addErrorMsg(errorMsgs, "身份证号(" + idcard + ")的患者创建健康档案失败!");
						logger.error(e.getMessage());
						continue;
					}
					Integer newStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
					createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.ADD);
					syncStar(request, personInfo.getHouseholdType(), 0, newStar);
					// 更新创建个人档案份数
					statisticsService.syncStatisticsData(SecurityUtils.getCurrentOrganization(request), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_NEW
							: StatisticsUtil.UNHR_ARCHIVE_NEW, StatisticsUtil.ADD);
					personList.add(personInfo);
				}
			}
			String message = "总共导入" + totalNum + "条机构，成功" + personList.size() + "条，失败" + (ExcelToDBList.size() - personList.size()) + "条\\r\\n";
			if(isEmpty) message = "当前登录机构下不存在可导入的健康档案！";
			if(errorMsgs.size() > 0) message+= getErrorMsg(errorMsgs);
			model.addAttribute("message", message);
			response.setContentType("text/html");
			response.getWriter().write("{\"message\":\"" + message + "\"}");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			response.setContentType("text/html");
			response.getWriter().write("{\"message\":\"健康档案批量导入出错\"}");
			throw new RuntimeException("健康档案批量导入出错",e);
		}
	}

	private void addErrorMsg(List<String> errorMsg, String text){
		if(errorMsg.contains(text)) return;
		if(errorMsg.size() < 10) {
			errorMsg.add(text);
		} else if(errorMsg.size()==10) {
			errorMsg.add(text);
			errorMsg.add("......");
		}
	}

	private String getErrorMsg(List<String> errorMsg){
		String msg = "";
		for(String str : errorMsg){
			msg+= str + "\\r\\n";
		}
		return msg;
	}

	private boolean judgeLength(String str, int length, List<String> errorMsgs, String msg, boolean isCanEmpty) {
		if(StringUtil.isNotEmpty(str) && str.length() > length) {
			addErrorMsg(errorMsgs, msg + "请不要超过" + length + "汉字");
			return false;
		} else if(ObjectUtil.isNullOrEmpty(str) && !isCanEmpty) {
			addErrorMsg(errorMsgs, msg + "为必填项不可以为空");
		}
		return true;
	}

	private List<Record> readXlsFile(InputStream in) throws Exception{
		List<Record> records = new ArrayList<Record>();
		try {
			ExcelUtils reader = new ExcelUtils(in);
			// 读取字段信息
			List<Object> fieldLine = reader.readLine();
			// 读取字段描述
			reader.readLine();
			List<Object> nextLine;
			int row = 2;
			while ((nextLine = reader.readLine()) != null && nextLine.size() > 0) {
				Record record = new Record();
				for (int i = 0; i < fieldLine.size(); i++) {
					String fieldName = String.valueOf(fieldLine.get(i));
					String value = String.valueOf(reader.read(row, i)).trim();
					if ("".equals(value) || fieldName.equalsIgnoreCase("no")) {
						continue;
					}
					setValue(record, fieldName, value);

				}
				records.add(record);
				row++;
			}
			in.close();
		} catch(Exception e){
			throw e;
		}
		return records;
	}

	private void setValue(Record record, String fieldName, String value) throws ParseException {
		if (fieldName.contains("@")) {
			String[] vals = fieldName.split("@");
			SimpleDateFormat df = new SimpleDateFormat(vals[1]);
			Date date = df.parse(value);
			record.set(vals[0], date);
		} else {
			record.set(fieldName, value);
		}
	}

	/**
	 * 验证表格导入基本信息输入的合法性
	 * @param excelToDB
	 * @param personInfo
	 * @param errorMsgs
	 * @param request
	 * @return
	 */
	private boolean validatePersonMessage(ExcelToDB excelToDB, PersonInfo personInfo, List<String> errorMsgs, HttpServletRequest request) {
		String name = excelToDB.getName();
		if(this.judgeLength(name, 14, errorMsgs, "姓名", false)){
			personInfo.setName(name);
		} else {
			return false;
		}
		String householdType = excelToDB.getHouseholdType();
		if(ObjectUtil.equals(householdType, "1") || ObjectUtil.equals(householdType, "2")) {
			personInfo.setHouseholdType(householdType);
		} else {
			addErrorMsg(errorMsgs, "居民" + name + "的常住类型为空或者值不在（1，2）范围内！");
			return false;
		}

		String phoneNumber = excelToDB.getPhoneNumber();
		if(this.judgeLength(phoneNumber, 20, errorMsgs, "居民" + name + "的联系电话", false)){
			personInfo.setPhoneNumber(phoneNumber);
		} else {
			return false;
		}

		String guardianPhoneOne = excelToDB.getHomePhone();
		if(this.judgeLength(guardianPhoneOne, 20, errorMsgs, "居民" + name + "的联系人电话", false)){
			personInfo.setGuardianPhoneOne(guardianPhoneOne);
		} else {
			return false;
		}
		String patownShipCode = excelToDB.getPaTownshipCode();
		if(this.judgeLength(patownShipCode, 20, errorMsgs, "居民" + name + "现住址区编码", false)){
			DicItem town = dictionaryApp.queryDicItem("FS990001", patownShipCode);
			if(ObjectUtil.isNullOrEmpty(town)) {
				addErrorMsg(errorMsgs, "居民" + name + "的现住址区编码在平台系统中不存在！");
				return false;
			}
			personInfo.setPatownShip(patownShipCode);
		} else {
			return false;
		}
		String pastreetCode = excelToDB.getPaStreetCode();
		if(this.judgeLength(pastreetCode, 20, errorMsgs, "居民" + name + "的现住址居委会编码", false)){
			DicItem village = dictionaryApp.queryDicItem("FS990001", pastreetCode);
			if(ObjectUtil.isNullOrEmpty(village)) {
				addErrorMsg(errorMsgs, "居民" + name + "的现住址居委会在平台系统中不存在！");
				return false;
			}
			personInfo.setPastreet(pastreetCode);
		} else {
			return false;
		}

		//若是建档机构编码为空那么建档建档机构建档人管理医生均为当前用户
		//建档机构
		Organization organ = SecurityUtils.getCurrentOrganization(request);
		personInfo.setInputOrganCode(organ.getOrganCode());
		personInfo.setInputOrganName(organ.getOrganName());
		Staff staff = staffService.getStaff(SecurityUtils.getCurrentUser(request).getStaffCode());
		if (ObjectUtil.isNotEmpty(staff)) {
			personInfo.setInputIdcard(staff.getIdCard());
			personInfo.setInputerId(staff.getStaffCode());
			personInfo.setInputName(staff.getName());
		}

		return true;
	}

	/**
	 * 验证基本信息输入的合法性
	 * @param record
	 * @param personInfo
	 * @param errorMsgs
	 * @param request
	 * @return
	 */
	private boolean validateMessage(Record record, PersonInfo personInfo, List<String> errorMsgs, HttpServletRequest request) {
		String name = (String)record.get("name");
		if(this.judgeLength(name, 14, errorMsgs, "姓名", false)){
			personInfo.setName(name);
		} else {
			return false;
		}
		String householdType = (String)record.get("householdType");
		if(ObjectUtil.equals(householdType, "1") || ObjectUtil.equals(householdType, "2")) {
			personInfo.setHouseholdType(householdType);
		} else {
			addErrorMsg(errorMsgs, "居民" + name + "的常住类型为空或者值不在（1，2）范围内！");
			return false;
		}

		String phoneNumber = (String)record.get("phoneNumber");
		if(this.judgeLength(phoneNumber, 20, errorMsgs, "居民" + name + "的联系电话", false)){
			personInfo.setPhoneNumber(phoneNumber);
		} else {
			return false;
		}

		String guardianPhoneOne = (String)record.get("guardianPhoneOne");
		if(this.judgeLength(guardianPhoneOne, 20, errorMsgs, "居民" + name + "的联系人电话", false)){
			personInfo.setGuardianPhoneOne(guardianPhoneOne);
		} else {
			return false;
		}

		String patownShipCode = (String)record.get("patownShipCode");
		if(this.judgeLength(patownShipCode, 20, errorMsgs, "居民" + name + "现住址区编码", false)){
			DicItem town = dictionaryApp.queryDicItem("FS990001", patownShipCode);
			if(ObjectUtil.isNullOrEmpty(town)) {
				addErrorMsg(errorMsgs, "居民" + name + "的现住址区编码在平台系统中不存在！");
				return false;
			}
			personInfo.setPatownShip(patownShipCode);
		} else {
			return false;
		}

		String pastreetCode = (String)record.get("pastreetCode");
		if(this.judgeLength(pastreetCode, 20, errorMsgs, "居民" + name + "的现住址居委会编码", false)){
			DicItem village = dictionaryApp.queryDicItem("FS990001", pastreetCode);
			if(ObjectUtil.isNullOrEmpty(village)) {
				addErrorMsg(errorMsgs, "居民" + name + "的现住址居委会在平台系统中不存在！");
				return false;
			}
			personInfo.setPastreet(pastreetCode);
		} else {
			return false;
		}
		String inputOrganCode = (String)record.get("inputOrganCode");
		if(!ObjectUtil.isNullOrEmpty(inputOrganCode) && this.judgeLength(inputOrganCode, 15, errorMsgs, "居民" + name + "的建档机构编码", true)) {
			Organization organ = organizationApp.queryOrgan(inputOrganCode);
			if(ObjectUtil.isNullOrEmpty(organ)) {
				addErrorMsg(errorMsgs, "居民" + name + "建档机构在平台系统中不存在！");
				return false;
			}
			personInfo.setInputOrganCode(inputOrganCode);
			personInfo.setInputOrganName(organ.getOrganName());
			String inputIdcard = (String)record.get("inputIdcard");
			List<Staff> staffList = staffService.getStaffs(new Criteria("organCode", inputOrganCode).add("status", "1"));
			if(StringUtil.isNotEmpty(inputIdcard) && (inputIdcard.length() != 15 && inputIdcard.length() != 18)){
				addErrorMsg(errorMsgs, "居民" + name + "的建档人身份证号长度不正确！");
				return false;
			} else {
				for(Staff staff : staffList) {
					if(ObjectUtil.equals(staff.getIdCard(), inputIdcard)) {
						personInfo.setInputIdcard(inputIdcard);
						personInfo.setInputerId(staff.getStaffCode());
						personInfo.setInputName(staff.getName());
					}
				}
				//判断此条建档的身份证号是否在建档机构的医务人员中存在
				if(ObjectUtil.isNotEmpty(inputIdcard) && ObjectUtil.isNullOrEmpty(personInfo.getInputerId())) {
					addErrorMsg(errorMsgs, "居民" + name + "的建档人身份证号不在建档机构的医务人员中！");
					return false;
				} else if(ObjectUtil.isNullOrEmpty(inputIdcard)) {
					addErrorMsg(errorMsgs, "居民" + name + "的建档机构编码不为空时，建档人身份证号不可以为空！");
					return false;
				}
			}

			String getInputIdcard = (String)record.get("inputIdcard");
			if(StringUtil.isNotEmpty(getInputIdcard) && (getInputIdcard.length() != 15 && getInputIdcard.length() != 18)){
				addErrorMsg(errorMsgs, "居民" + name + "的管理医生身份证号长度不正确！");
				return false;
			}else{
				//判断此条管理医生身份证号是否在建档机构的医务人员中存在
				if(ObjectUtil.isNotEmpty(getInputIdcard) && ObjectUtil.isNullOrEmpty(personInfo.getInputIdcard())) {
					addErrorMsg(errorMsgs, "居民" + name + "的管理医生身份证号不在建档机构的医务人员中！");
					return false;
				} else if(ObjectUtil.isNullOrEmpty(getInputIdcard)) {
					addErrorMsg(errorMsgs, "居民" + name + "的建档机构编码不为空时，管理医生身份证号不可以为空！");
					return false;
				}
			}

		} else if (ObjectUtil.isNullOrEmpty(inputOrganCode)) {
			//若是建档机构编码为空那么建档建档机构建档人管理医生均为当前用户
			//建档机构
			Organization organ = SecurityUtils.getCurrentOrganization(request);
			personInfo.setInputOrganCode(organ.getOrganCode());
			personInfo.setInputOrganName(organ.getOrganName());
			Staff staff = staffService.getStaff(SecurityUtils.getCurrentUser(request).getStaffCode());
			if (ObjectUtil.isNotEmpty(staff)) {
				personInfo.setInputIdcard(staff.getIdCard());
				personInfo.setInputerId(staff.getStaffCode());
				personInfo.setInputName(staff.getName());
			}
		}
		return true;
	}

	private void setDefaultVaule(PersonInfo personInfo) {
		personInfo.setInputDate(new Date());
		personInfo.setFilingFlag(EHRConstants.HAD_CREATE);// 设置默认建档类型为“已建档”,值“1”
		personInfo.setUpdateDate(new Date());
		personInfo.setUpdateIdcard(personInfo.getInputIdcard());
		personInfo.setUpdateName(personInfo.getInputName());
		personInfo.setUpdateInputerId(personInfo.getInputerId());
		personInfo.setUpdateOrganName(personInfo.getInputOrganName());
		personInfo.setUpdateOrganCode(personInfo.getInputOrganCode());
	}

	@ResponseBody
	@RequestMapping(value="/personRecord/healthInfo")
	public Map<String, Object> healthInfo(String url, ModelMap model){
		Map<String ,Object> map=new HashMap<>();
		String str= HttpClientUtil.sendGet(url);
		//String str="2013/4/3 9:41:43|血压|140&2012/12/6 15:01:02|血糖|16.4&2013/4/18 12:14:39|体重|80.7&2013/4/3 10:15:16|身高|166.6&2012/8/21 11:00:59|血氧|70&2013/4/28 9:33:01|人体成分（脂肪）|22.1|15.73|1376||||||&2013/2/4 18:53:46|肺功能78.6|1894|2.45|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21&";
		//String  str="2017/7/19 15:43:01|血压|98|63|67&2017/7/19 15:41:34|血压|87|52|68&2017/7/19 11:01:55|血压|101|60|65&2017/7/19 10:59:26|血压|100|56|76&2017/7/17 8:53:00|血压|113|70|85&2017/7/17 8:48:33|血压|111|74|86&2017/7/13 11:18:37|血压|101|65|79&2017/7/13 11:02:35|血压|96|61|78&2017/7/12 16:00:23|血压|106|59|77&2017/7/19 15:44:14|体重|54.6&2017/7/19 15:43:49|体重|54.6&2017/7/19 11:18:20|体重|65.2&2017/7/19 11:18:19|体重|65.2&2017/7/19 11:01:50|体重|65.1&2017/7/19 11:01:04|体重|65.5&2017/7/13 11:16:56|体重|55.7&2017/7/19 15:44:14|身高|165.1&2017/7/19 15:43:49|身高|166&2017/7/19 11:18:20|身高|&2017/7/19 11:18:19|身高|&2017/7/19 11:01:50|身高|181.6&2017/7/19 11:01:04|身高|183.1&2017/7/13 11:16:56|身高|163.3&2017/7/19 11:18:19|人体成分（脂肪）|19.8|15.6|1442||9.7|0.79|36.5||65.2||||||||||||||||2.29|2.36|21.1|9.61|9.61|||||&2017/7/19 11:21:19|骨密度|-2.26|-2.12|left|38.3|1356.4|23.5|77.2|78.3";
		if(StringUtil.isNullOrEmpty(str.trim())){

			map.put("error","健康小屋没有该患者体检数据！");
			return map;
		}
		String strList[]=str.split("\\&");
		List<String> strxy=new ArrayList<>();
		List<String> strtz=new ArrayList<>();
		List<String> strsg=new ArrayList<>();
		List<String> strxt=new ArrayList<>();
		for (int i = 0; i < strList.length; i++) {
			if(strList[i].indexOf("血压")>0 ){
				strxy.add(strList[i].trim());
			}if(strList[i].indexOf("体重")>0){
				strtz.add(strList[i].trim());
			}if(strList[i].indexOf("身高")>0){
				strsg.add(strList[i].trim());
			}if(strList[i].indexOf("血糖")>0){
				strxt.add(strList[i].trim());
			}
		}

		if(ObjectUtil.isNotEmpty(strxy)==true){
			for (int i = 0; i < strxy.size() - 1; i++) {
				for (int j = 1; j < strxy.size() - i; j++) {
					String a;
					int num=strxy.get(j).indexOf("|血压|");
					int num1=strxy.get(j - 1).indexOf("|血压|");

					String str1=strxy.get(j).substring(0, num);
					String str2=strxy.get(j-1).substring(0, num1);
					if (DateUtil.parseDateString(str2).getTime() < DateUtil.parseDateString(str1).getTime()) { // 比较两个整数的大小
						a = strxy.get(j - 1);
						strxy.set((j - 1), strxy.get(j));
						strxy.set(j, a);
					}
				}
			}
        /*for (int i = 0; i < strxy.size(); i++) {
			System.out.println(strxy.get(i));
		}*/
		}
		if(ObjectUtil.isNotEmpty(strtz)==true){
			for (int i = 0; i < strtz.size() - 1; i++) {
				for (int j = 1; j < strtz.size() - i; j++) {
					String a;
					int num=strtz.get(j).indexOf("|体重|");
					int num1=strtz.get(j - 1).indexOf("|体重|");

					String str1=strtz.get(j).substring(0, num);
					String str2=strtz.get(j-1).substring(0, num1);
					if (DateUtil.parseDateString(str2).getTime() < DateUtil.parseDateString(str1).getTime()) { // 比较两个整数的大小

						a = strtz.get(j - 1);
						strtz.set((j - 1), strtz.get(j));
						strtz.set(j, a);
					}
				}
			}
		}
		if(ObjectUtil.isNotEmpty(strsg)==true){
			for (int i = 0; i < strsg.size() - 1; i++) {
				for (int j = 1; j < strsg.size() - i; j++) {
					String a;
					int num=strsg.get(j).indexOf("|身高|");
					int num1=strsg.get(j - 1).indexOf("|身高|");

					String str1=strsg.get(j).substring(0, num);
					String str2=strsg.get(j-1).substring(0, num1);
					if (DateUtil.parseDateString(str2).getTime() < DateUtil.parseDateString(str1).getTime()) { // 比较两个整数的大小
						a = strsg.get(j - 1);
						strsg.set((j - 1), strsg.get(j));
						strsg.set(j, a);
					}
				}
			}
		}
		if(ObjectUtil.isNotEmpty(strsg)==true){
			for (int i = 0; i < strxt.size() - 1; i++) {
				for (int j = 1; j < strxt.size() - i; j++) {
					String a;
					int num=strxt.get(j).indexOf("|血糖|");
					int num1=strxt.get(j - 1).indexOf("|血糖|");

					String str1=strxt.get(j).substring(0, num);
					String str2=strxt.get(j-1).substring(0, num1);
					if (DateUtil.parseDateString(str2).getTime() < DateUtil.parseDateString(str1).getTime()) { // 比较两个整数的大小
						a = strxt.get(j - 1);
						strxt.set((j - 1), strxt.get(j));
						strxt.set(j, a);
					}
				}
			}
		}
		//strsg=bubbleSort(strxy);
		map.put("strxy", ObjectUtil.isNotEmpty(strxy)==true? strxy.get(0):"");
		map.put("strsg", ObjectUtil.isNotEmpty(strsg)==true? strsg.get(0):"");
		map.put("strtz", ObjectUtil.isNotEmpty(strtz)==true? strtz.get(0):"");
		map.put("strxt", ObjectUtil.isNotEmpty(strxt)==true? strxt.get(0):"");
        /*System.out.println("《报文》："+str);
        if(ObjectUtil.isNotEmpty(strxy)==true){
        	System.out.println("《血压》："+strxy.get(strxy.size()-1));
        }
        if(ObjectUtil.isNotEmpty(strsg)==true){
        	System.out.println("《身高》："+strsg.get(strsg.size()-1));
        }
        if(ObjectUtil.isNotEmpty(strxt)==true){
        	System.out.println("《血糖》："+strxt.get(strxt.size()-1));
        }
        
        System.out.println("《Map》："+map);*/
		return map;
	}

    
/*    public static List<String> bubbleSort(List<String> a){
        int len = a.size();
        for(int i = len-1;i>=1;i--){
            for(int j = 0;j<=i-1;j++){
                if(a.get(j).split("|")[0].compareTo(a.get(j+1).split("|")[0]) > 0){
                    String temp =a.get(j).split("|")[0]; 
                    a.get(j).split("|")[0]=a.get(j+1).split("|")[0];
                     a.get(j+1).split("|")[0]=temp;
                }
            }
        }
        return a;
    }
*/



	private Date getBirthDateCri(int age){
		Date birthDate = new Date();
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date nowDate = new Date();
			String nowString = simpleDateFormat.format(nowDate);
			int year = Integer.parseInt(nowString.substring(0,4));
			int birthYear = year - age;
			String birthDateString = nowString.replaceAll(String.valueOf(year),String.valueOf(birthYear));
			birthDate = simpleDateFormat.parse(birthDateString);

		}catch (Exception e){
			e.printStackTrace();
		}
		return birthDate;
	}

	/**
	 * 指纹保存操作
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/personRecord/saveFingerInfo")
	@ResponseBody
	public Integer saveFingerInfo(FingerInfo fingerInfo,HttpServletRequest request, ModelMap model) {
//		fingerInfo.setFingerTemplate("9TUzIxAAAEPEEECAUHCc7QAAAEPXYBAAAAhOEiYTy1AHsPRgB5AP8zowCLACEPqQD/PCgOOQDmACkNPTzwAFMLlADWAS4ylwBXAJcPsgArPbEPXwA5ALsPhTwcAJEOVgDQAI89gwCgAB4P+gDAPGgPXgCDAMsPwTzNAB4PjQDMAa0yTgAHATUKdgAPPasPPQARAYQM4jyAAKAPVgCVAa4zswBQAZ4MtACKPIgPiAB/AFcPszzLAKMPxQBsAKYzXwAMATELqwBgPIIPggBVAN8PGjzyAFUMrQCAAKYzsAAmAKUPqwBbPZ8EfoDuXRf24Kt/gNIT8ZMPBnu8tPrK9GqBEZsGpF+F7GutA4sg+L9PgLp+bX0U91ors4p6g6YLf/Xu0x9negtWFz7sKjH//x9zBZbvjc6Z9XNifQryTIZCsXN/6XwifWp3BL9rgdoCWQR89erYT4BaApsL6A36zDsQPwFfg/aH6TO6/Itre/NWd6PLjH4ZbuH7nAsFTzd15YSuAeb7JrkzAX+A3fzoCs7M5GpSdR7xqIXJpqOLKQcaaIsXQTOn/FOIIgSiFDcuePer8NsD91yGFAEgOwECgeaMAjw8ABzE/YPKAGA8G8My/zf/vsEBPI0AGsAvCMW+BBhLZAUATAHJQwg8owEi/v9yvlYCPNoXKWv+D8V1BzAoT1zB/1vVAEIiAcAx/0NEBYIBPIQgGsBAEsVIIz9KK0r/eMD7EgR7MAD+wP/9Ov9X/MDB/2QEAJk5eUkIADJK9MA4w//BPAcAfVKTBpDEMAGFVRbANgVkZDQB91iiU/+pCQSLEC3BZMM2yQCAZR/B//9kWwcTBBFd8UAjVf8FwEFCBABtZImJygAtWfH/M/3A/p/+XygBJnL6aP86/DLDwVly/wkA5X/0AjH9DwBhgcMx+3jBWlcGAFlBfXz/BQDqhyL/HRQEIojwQU8x/5GETjUBo4wg/8EE/3A0AW6QhoTBRgcESpETO8L+CcV/m6yJwXgLAIdkGvvDwVfBbAwAQ6YadkVq/xUAE3Pm+sNBLi/ARP8HZAI8QL50lsAMxUm7yy01UcAHAPnGbbjAwRYAC8olM0DB/DVEwE5KwQDC8h9WFgAN1SXA+cP+wCP+NVgF/8VWEQA64+L9O/z5wf///8HAwjrBxDUBPefp/f8+/PsNCwA1616JvMLHMQE39FqJjgbAjTkBWPweKQrFbvka/1l1wwwQlwMwXoeBwAwQWcE0xFPAwMNxFxDMCd5qMCz//DjBOsHGwlUIEEoKQEGCDSxRCj3C/8IEwoQ2EWANLVnBBMF9NRE9EkPBwQHBwFkHEJUVKcC9GBQsM8ZBwf47OP/4wfz/wP7AwQTBUSgRVE6mKsA7+v/E+jZ1wlsY1bJUqyo6wMPBxgDEx/zDwsHEwsMFwB8svFKc/8D+Ov7AcsPFxMPFagbBx/7Dgw=,TWZTUzIxAAAEJSoECAUHCc7QAAAEJHYBAAAAhMgdgiWqAIIPiABJAAoqxQDbAJIIDQB/JZYPVwB5AKsNNyV2AGoLVgDdAUgq4AAZAZwPHQAnJZgP4gBCAVMPiSXJAIUPlgAlAIYqeABvAAkPbAD+JRIPowD9AEYPvyVLABYPrwD+AJUqbQAoAIcP6gApJE0PUQBYAX0OmiWUAI8OtQAmAJ0tuQDtAI8IvgD9JWUPjgBHAEwP2CVUAJYPRwCGAHIqrQAlAJQPggA6JDgPNvzCdCf0hae3jCIEXfiMBkqnvwNXCKOBz2WSICJhGv3n9tZjgjOjAxvoJgpCD3+uZwdTCEOEb/6Xoo4XLQeyBNLstdoH6C4ApvwrnUqm3ZJRhUF/KXLh0tfsEYV6gduGEVio/mIJYxDeAP/STBciA1uWvINrS45vgYJWDBr4GCrUCD2LpPuQfc3b/+Ui4h9QL/n+Uk+DeoE+A27999VaDkMKKQbbguraeIPh7xru0TwgICFCAQKnI7cHBEcBE2hWDAC4ABdi/sBtZQUAbQAY5X0HALMAFgX/+lYHAMQAEzYEEwQCAAP+wMMomMH55cP+/3wKAFEBFxvAwv5aBAAdARMdCwA4EAM9j1kOJTkZAz1VasAAPAYCwf7AEQDhMfPaP0ZUQlwIxSs930L9VwQAtPsXUyYBRUGAwwbFTUclR8EDAEZHscEMJZVJEERCBcW/SD/DRRIAIWE1wELb/ktU//6UzwB/SQL+P//AW80Ad0uCiMJqCgC+cghjwUrBDwAcsOL62v47/0Q+A8Uyc0P+BQBVd3QHwvsoAV15AP9AOv9SfAYAV31xizrBFiUYgOT+TP47wTflVFYOAFOIMf7628P9/MLB/gVvECXmzZfA/2cFacXmiMJyBgBBV2bF5X4NAISsiQaIxk/AaQ4AjMRMlWNdWg4AisqDBMON5MDBwf9bBcWSzirBZRMAw9hSwcTkwcLCwsPBBMHE58HBRA8AkxiJxubDkHbB/2/QABD61sD/Rv7/OP/62GnA/8BkEcWw26powp3CwcEE/scbBQDK3xfABQUEneETwEIDAF7hFOURAJPig40HfMSujgYAtOUXBU8RJenhmsBkaaR9cFUWAOfpmsE6wMVMwJHAxHLAqMAUJaX3jMLCwQB+xud8iwUArPjJNQ4leftkgnmEyACm2ILBxMPBkgfAweUHAKz+F8AEPxM16RaihMLBq8KZ533BjsMGEJMcVK3CBBAwMkwFxAM1jzpAxcLCRgkUujsewHjBwQUHFLQ9LcKLwQ7V4EWywVLBxcPFB8SeNBHpM5rAwTrAxbulw5IREPeAj/p0wY7DxcDFBaIANUZGN4kPED1QiOX+No3HxMQGwhU1+VqJ/zj/BMLA7MenfgkQ/pp0/mRIBxCaPCYEhMU,SjNTUzIxAAADcHcECAUHCc7QAAADcXYBAAAAg50cjXDtAJkPqAAdAJ5/eQCmAIoNQACjcBYNhwAyAWwOKXAMATsPZQC2ABJ+rQBSAZgODgBRcZsKfABMANIHbnDRABgPbgB2AAB9XwAHASgNnQAGcTgNawCDAE8Ol3BFAaMKxgD3ASN7mQBbAJoKGQBLcaMGiQD1AOAPUHDSAHEPTgApAAN+XACgAAoNbQCAcJUKtQA1AWwLUHB6AAoOYgCTAId/vABeAY4D+XfNjIeDSgRGe66H5gRQiIGD2YwLFA3+/ArbAPcQ+gQoTEIVoYjhCeiPAn1897bwSQ0U+Wl03Jd+fMILIKsqZ88bWXgh+gTv54IHKEsEVBI8O8BwqHiFgkqAQP72f8/92XiCgF+IffQbC2saSQlHhEVmMY8+iwMMnHIOK+9zSZKxy2vYmnqAg0qAnv+Xf1R/0IgmEEYJoPmG8q8C7W85d4t+1oWM+druGspCCCNcAAH+HGMDxWQGY/8EAB4z/fUFAxhHEP1vDQDyS/5APltxBQBhk4nB6gQAYFyDjM8AaywSwFf/wk/BAJ0sEjgEAJ5j2YQJcGZ1EMDAYAVCD3Aadun///3+VMNhARSD68A0BTDDsMD/RBEAEVXpTI4tf/9EwBHFEJ+S/8D//P7/BURHTRsAgZ6QhAXDwLHB5vv//DCDwTEkCgCJnxNMgWQPcImkF/9bQgf9wnYBcrAJKMDJAHLDiMHAwcWGBsDAdgFwtgwpwtIACrTW/jD+/cA6/cNOUsD/wk4KxXDSYPxE/l0OAJfUd7PDm8GEfAjFrd5QRGQYAAfeDCotW8EpTMDAwAVxDHCN657ChsIHo5OzDwBP7vT77zbC8cAYABPv0PH+K43A/UDBQmKPBgP79iD//mgJ1VYKR4HBhAMQuKEJ/HkRXQs0wcIEwYNrEQ0OvTM0O/38j//+wP/+wAT9wo/AwME9ChDsEjSwd5DAGxAa77Arjf7+//v+/zvB/4//wP/AwP8EwMI5ERCIL615AcfItMDBwsDCwAcDE/Qwov4IEGjRMJOxiQQQyjIc8RcTwTek/8D/wr/Cx9PEkmlzFhBuTZRYZsPDxMjFAMFz4MAEELJUFrYeE5ZZnML+K8C1f8HXxcHEw3dvRRsTkGSXXf/+/zt4wdDJw8XDwMOahQ==");
		String fingerTmp = fingerInfo.getFingerTemplate();
		if(fingerTmp.length()>4000){
			fingerInfo.setFingerTemplate(fingerTmp.substring(0,4000));
			fingerInfo.setFingerTemplateSec(fingerTmp.substring(4000,fingerTmp.length()));
		}
		Criteria c = new Criteria("idcard",fingerInfo.getIdcard());
		FingerInfo f = fingerInfoDao.get(c);
		Integer rs ;
		if(f==null)
			rs = fingerInfoDao.insert(fingerInfo);
		else {
			Parameters para = new Parameters();
			para.add("FINGER_ID",fingerInfo.getFingerId());
			para.add("FINGER_TEMPLATE",fingerInfo.getFingerTemplate());
			rs = fingerInfoDao.update(para, c);
		}
		return rs;
	}

	/**
	 * APP端创建健康档案封面
	 * @param request
	 * @param personInfoStr
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/personRecord/createCoverFromApp")
	public String createCoverFromApp(HttpServletRequest request, String personInfoStr, ModelMap model){
		/**
		 * result 返回代码
		 * 0：成功
		 * 1：居民信息为空
		 * 2：居民身份证号码为空
		 * 3：该居民档案已注销
		 * 4：该居民档案审核中
		 * 5：更新档案出错
		 * 6：创建档案出错
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isNullOrEmpty(personInfoStr)){
			map.put("success", false);
			//居民信息为空
			map.put("result", "1");
			return EHRMessageUtil.returnMsg(model,map);
		}else{
			PersonInfo personInfo =  JSON.parseObject(personInfoStr, PersonInfo.class);
			if(StringUtil.isNullOrEmpty(personInfo.getIdcard())){
				map.put("success", false);
				//居民身份证号码为空
				map.put("result", "2");
				return EHRMessageUtil.returnMsg(model,map);
			}

			PersonInfo p = platformService.queryPersonalInfo(new Criteria("idcard",personInfo.getIdcard()));
			if (ObjectUtil.isNotEmpty(p)) {
				String filingFlag = p.getFilingFlag();
				if (EHRConstants.HAD_OFF.equals(filingFlag)) {
					map.put("success", false);
					//已注销
					map.put("result", "3");
					// 已注销判断
					return EHRMessageUtil.returnMsg(model,map);
				} else if (EHRConstants.CHECK_FLAG.equals(filingFlag)) {
					map.put("success", false);
					//审核中
					map.put("result", "4");
					// 审核中判断
					return EHRMessageUtil.returnMsg(model,map);
				}
			}

			// 设置默认建档类型为“已建档”,值“1”
			personInfo.setFilingFlag(EHRConstants.HAD_CREATE);
			String userName = "";
			User currentUser = ehrSecurityService.getUser(new Criteria("staffCode",personInfo.getUpdateInputerId()));
			if(ObjectUtil.isNotEmpty(currentUser)){
				userName = currentUser.getUserName();
			}
			CurrentLoginInfo currentLoginInfo = getCurrentLoginInfoFromApp(personInfo.getInputOrganCode(),currentUser);
			//存在身份证，则证件类型为身份证
			if(StringUtil.isNotEmpty(personInfo.getIdcard())){
				personInfo.setOtherIdcardType("0");
			}
			if(15 == personInfo.getIdcard().length()){
				personInfo.setIdcard(IDCardUtil.conver15CardTo18(personInfo.getIdcard()));
			}
			//后加身份证-判断出性别及生日
			if(StringUtil.isNotEmpty(personInfo.getIdcard())){
				personInfo.setGender(IDCardUtil.getGenderByIdCard(personInfo.getIdcard()));
				personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard()));
			}
			//如果已经存在居民信息则更新
			if(ObjectUtil.isNotEmpty(p)){
				createOperationLog(userName,personInfo.getUpdateOrganCode(),request, RhipModuleName.EHR, "移动端" + acctionName, OperationName.UPDATE);
				personInfo.setId(p.getId());

				String[] properties;
				if (ObjectUtil.isNotEmpty(p.getHealthFileNo())) {
					personInfo.setHealthFileNo(p.getHealthFileNo());
					properties = new String[]{"remarks", "birthday","gender","otherIdcardType","idcard","name", "gBCode", "pahouseNumber", "livingType","householdType", "areaCode", "hrhouseNumber", "phoneNumber", "patownShip", "pastreet", "hrtownShip", "hrstreet",
							"paAddress", "hrAddress", "inputOrganCode", "inputOrganName", "inputName", "inputerId", "guardianPhoneOne", "inputDate",
							"updateDate", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "healthFileNo", "filingFlag", "oneStarScore"
							,"source", "star", "integrity", "starUpdateDate" ,"pacounty","hrcounty", "inputCenterOrganCode","inputGbcode","paGroup","hrGroup"
							,"poverty","disabled","povertyType","veryPovertyType","veryPoverty"};
				} else {
					// 未建档人员建档
					//管理机构
					personInfo.setHealthOrganCode(personInfo.getInputOrganCode());
					properties = new String[]{ "remarks","birthday","gender","name", "gBCode", "pahouseNumber", "livingType","householdType", "areaCode"
							,"hrhouseNumber", "phoneNumber", "patownShip", "pastreet", "hrtownShip", "hrstreet","paAddress", "hrAddress"
							,"inputOrganCode", "inputOrganName", "inputName", "inputerId", "guardianPhoneOne", "inputDate",
							"updateDate", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName"
							,"source","healthFileNo", "filingFlag", "inputCenterOrganCode", "inputGbcode", "oneStarScore", "star",
							"integrity", "starUpdateDate","hrcounty","pacounty","otherIdcardType","idcard"
							,"disabled","poverty","povertyType","veryPovertyType","veryPoverty","paGroup","hrGroup"};
				}
				try {
					personalRecordManagmentService.upateCover(personInfo,currentLoginInfo, properties);
					// 更新个人档案份数
					statisticsService.syncStatisticsData(currentLoginInfo.getOrganization(), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_TOTAL
							: StatisticsUtil.UNHR_ARCHIVE_TOTAL, StatisticsUtil.ADD);
					map.put("success", true);
					//更新成功
					map.put("result", "0");
				}catch (Exception ex){
					map.put("success", false);
					//更新出错
					map.put("result","5");
					logger.error("更新档案时出错",ex);
					return EHRMessageUtil.returnMsg(model,map);
				}
			}else{
				//新增
				createOperationLog(userName,personInfo.getUpdateOrganCode(),request, RhipModuleName.EHR, "移动端" + acctionName, OperationName.ADD);
				personInfo.setUpdateDate(new Date());
				//管理机构
				personInfo.setHealthOrganCode(personInfo.getInputOrganCode());
				try {
					personalRecordManagmentService.createCover(personInfo,currentLoginInfo);
					if(ObjectUtil.isNullOrEmpty(personInfo.getHealthFileNo())) {
						map.put("result","99");//档案编码生成异常
						logger.error("档案编码生成异常idcard:"+personInfo.getIdcard());
						return EHRMessageUtil.returnMsg(model,map);
					}
					// 更新创建个人档案份数
					statisticsService.syncStatisticsData(currentLoginInfo.getOrganization(), personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_NEW
							: StatisticsUtil.UNHR_ARCHIVE_NEW, StatisticsUtil.ADD);
					map.put("success", true);
					//创建成功
					map.put("result", "0");
				}catch (Exception ex){
					map.put("success", false);
					//创建档案出错
					map.put("result","6");
					logger.error("创建档案时出错",ex);
					return EHRMessageUtil.returnMsg(model,map);
				}
			}
		}
		return EHRMessageUtil.returnMsg(model,map);
	}

	/**
	 * APP端创建活更新日志
	 * @param userName
	 * @param organCode
	 * @param request
	 * @param moduleName
	 * @param actionName
	 * @param operationName
	 */
	private void createOperationLog(String userName,String organCode,HttpServletRequest request, RhipModuleName moduleName, String actionName, OperationName operationName) {
		UserOperationLog userOperationLog = new UserOperationLog();
		userOperationLog.setUserName(userName);
		userOperationLog.setUserIp(getRequestIp(request));
		userOperationLog.setUserRequest(request.getRequestURI());
		userOperationLog.setModuleName(moduleName.getZhName());
		userOperationLog.setActionName(actionName);
		userOperationLog.setOperationName(operationName.getZhName());
		userOperationLog.setOrgCode(organCode);
		userOperationLog.setOperationTime(new Date());
		userOperationLogService.createOperationLog(userOperationLog);
	}


	/**
	 * 获取APP传递过来的机构、用户信息
	 * @param organCode
	 * @param currentUser
	 * @return
	 */
	private CurrentLoginInfo getCurrentLoginInfoFromApp(String organCode,User currentUser){
		CurrentLoginInfo currentLoginInfo = new CurrentLoginInfo();
		Organization organization = organizationApp.queryOrgan(organCode);
		if(ObjectUtil.isNotEmpty(organization)){
			currentLoginInfo.setOrganization(organization);
		}
		if(ObjectUtil.isNotEmpty(currentUser)){
			currentLoginInfo.setUser(currentUser);
		}
		return currentLoginInfo;
	}

	/**
	 * 进入新增/修改会诊记录表页面
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/addConsultation")
	public String addConsultation(HttpServletRequest request) {
		if (null == request.getSession().getAttribute("personInfo") || null == ((PersonInfo) request.getSession().getAttribute("personInfo")).getId()
				|| EHRConstants.UN_CREATE.equals(((PersonInfo) request.getSession().getAttribute("personInfo")).getFilingFlag())) {
			FlashScope.getCurrent(request).put("msgError", "请先填写保存封面信息!");
			return "redirect:/personRecord/addCover";
		} else {
			String isNew = request.getParameter("isNew");
			PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute("personInfo");
			request.setAttribute("personInfo", personInfo);
			PersonalConsultationDTO personalConsultationDTO = (PersonalConsultationDTO) personalRecordManagmentService.getPersonalConsultationDto(personInfo.getId());
			if(ObjectUtil.isNullOrEmpty(personalConsultationDTO.getConsultations()) || "Y".equals(isNew)){
				return "rhip.ehr.personalRecord.addConsultation";
			}
			request.setAttribute("PersonalConsultationDTO", personalConsultationDTO);
			return "rhip.ehr.browser.basic.consultation";
		}
	}

	/**
	 * 保存会诊记录表
	 *
	 * @param request
	 */
	@RequestMapping("/personRecord/saveConsultation")
	public String saveConsultation(HttpServletRequest request, ModelMap model) {
		createOperationLog(request, RhipModuleName.EHR, acctionName, OperationName.UPDATE);
		Consultation consultation = VoUtil.getFormData(request, Consultation.class);
		if(ObjectUtil.isNullOrEmpty(consultation)){
			return "redirect:/personRecord/addConsultation";
		}
		PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute("personInfo");
		if( ObjectUtil.isNotEmpty(consultation.getId())){
			consultation.setUpdateUser(SecurityUtils.getCurrentUser(request).getStaffCode());
			consultation.setUpdateOrg(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			consultation.setUpdateDate(new Date());
		}else{
			consultation.setCreateUser(SecurityUtils.getCurrentUser(request).getStaffCode());
			consultation.setCreateOrg(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			consultation.setCreateDate(new Date());
		}
		consultation.setPersonId(personInfo.getId());
		consultation.setName(personInfo.getName());
		consultation.setIdcard(personInfo.getIdcard());
		consultation.setHealthFileNo(personInfo.getHealthFileNo());
		consultation.setGender(personInfo.getGender());
		consultationService.saveConsultation(consultation);
		return "redirect:/personRecord/addConsultation";
	}

	/**
	 * 进入单个会诊记录表详细页面
	 *
	 * @return
	 */
	@RequestMapping("/personRecord/getConsultation")
	public String getNewBornInterview(HttpServletRequest request, ModelMap model){
		String id = request.getParameter("id");
		String isView = request.getParameter("isView");
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		Consultation consultation = consultationService.getConsultation(criteria);
		if(ObjectUtil.isNotEmpty(consultation)){
			PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", consultation.getPersonId()));
			model.addAttribute("consultation", consultation);
			model.addAttribute("personInfo", personInfo);
			model.addAttribute("isShowAddBtn", true);
		}
		if ("Y".equals(isView)){
			return "rhip.ehr.browser.basic.consultation.view";
		}else {
			return "rhip.ehr.personalRecord.addConsultation";
		}
	}

	/**
	 * 双向转诊表
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/personRecord/referralList")
	public String referralInfoSearch( ModelMap model, HttpServletRequest request){
		if (null == request.getSession().getAttribute("personInfo") || null == ((PersonInfo) request.getSession().getAttribute("personInfo")).getId()
				|| EHRConstants.UN_CREATE.equals(((PersonInfo) request.getSession().getAttribute("personInfo")).getFilingFlag())) {
			FlashScope.getCurrent(request).put("msgError", "请先填写保存封面信息!");
			return "redirect:/personRecord/addCover";
		}
		request.getSession().setAttribute("requestUrlType","personRecord");
		return "redirect:/ehrbrowser/basic/referralInfo";
	}

	/**
	 * 接诊记录表列表
	 */
	@RequestMapping("/personRecord/getReceptionDate")
	public String getReception(HttpServletRequest request, ModelMap model) {

		if (null == request.getSession().getAttribute("personInfo") || null == ((PersonInfo) request.getSession().getAttribute("personInfo")).getId()
				|| EHRConstants.UN_CREATE.equals(((PersonInfo) request.getSession().getAttribute("personInfo")).getFilingFlag())) {
			FlashScope.getCurrent(request).put("msgError", "请先填写保存封面信息!");
			return "redirect:/personRecord/addCover";
		} else {
			List<OutpatientInfo> outpatientInfos = outpatientInfoService.getDistinctList(new Criteria("personId", ((PersonInfo) request.getSession().getAttribute("personInfo")).getId()), new Order("CLINIC_DATE",false));
			model.addAttribute("outpatientInfos", outpatientInfos);
			return "rhip.ehr.browser.receptionList";
		}

	}
}