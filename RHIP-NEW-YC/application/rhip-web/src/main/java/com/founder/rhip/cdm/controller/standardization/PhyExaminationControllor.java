package com.founder.rhip.cdm.controller.standardization;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IPhyExaminationService;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ech.service.IEchManageService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.CdmPhyStatisticsDto;
import com.founder.rhip.ehr.dto.CdmPhyStatisticsVillageDto;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.repository.clinic.IHealthEvaluateAnomalyDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.summary.IDrugHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyBedHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.hm.controller.form.HealthManageQueryForm;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;

/**
 * 慢病体检
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/cdm/standardization/phyExamination")
public class PhyExaminationControllor extends CdmBaseController {

	private final static String CONTROLLER_NAME = " 慢病体检";

	@Resource(name = "standardizationService")
	private IStandardizationService standardizationService;

	@Resource(name = "cdmPhyExaminationService")
	private IPhyExaminationService examinationService;

	@Resource(name = "platformService")
	private IPlatformService platformService;

    @Resource(name = "familyBedHistoryDao")
    private IFamilyBedHistoryDao familyBedHistoryDao;

    @Resource(name = "drugHistoryDao")
    private IDrugHistoryDao drugHistoryDao;

    @Resource(name = "vaccinationInfoDao")
    private IVaccinationInfoDao vaccinationInfoDao;

    @Resource(name = "hospitalizedHistoryDao")
    private IHospitalizedHistoryDao hospitalizedHistoryDao;

    @Resource(name = "physicalExamRecordService")
    private IPhysicalExamRecordService physicalExamRecordService;

    @Resource(name = "echManageService")
    private IEchManageService echManageService;

    @Resource(name = "personalRecordManagmentService")
    private IPersonalRecordManagmentService personalRecordManagmentService;

	@Resource(name = "healthEvaluateAnomalyDao")
	private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;
	
    @Autowired
    private IStaffService staffService;

    @Resource(name = "excelExportService")
    private IExcelExportService excelExportService;

	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;

	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;
	
    @Resource(name = "physiqueExaminationDao")
    private IPhysiqueExaminationDao physiqueExaminationDao;
    
    private final static String SESSIONIDE = "ide";

    //拷贝的相关信息
    private String[] physiqueProp = {"physicalExamCode", "name", "examinationOrganCode", "examinationDate", "manaDoctorId"
            , "symptomFlag", "symptomHeadache", "symptomDizzy", "symptomPalpitations", "symptomChestTightness", "symptomChestPain"
            , "symptomChronicCough", "symptomCough", "symptomDyspnea", "symptomPolydipsia", "symptomPolyuria", "symptomWeightLoss"
            , "symptomFatigue", "symptomJointPain", "symptomBlurredVision", "symptomNumbness", "symptomUrgency", "symptomDysuria"
            , "symptomConstipation", "symptomDiarrhea", "symptomNauseaVomiting", "symptomVertigo", "symptomTinnitus", "symptomBreastTenderness"
            , "symptomOther", "symptomOtherDesc", "familyHistoryHbpFlg", "familyHistoryCoronaryFlg", "familyHistoryStrokeFlg"
            , "familyHistoryDiFlg", "temperature", "pulseRate", "respiratoryRate", "leftSbp", "leftDbp", "pastHighestSbp"
            , "pastHighesDbp", "height", "bodyWeight", "waostline", "indexOfBodyCharacteristics", "hip", "whr", "trainFrequencyTypeCode"
            , "trainingMin", "trainingTotaltime", "trainingWay", "dietHunsuEquilibrium", "dietMeatMain", "dietVegetarian", "dietHalophilic"
            , "dietAddictedOil", "dietSugarCravings", "smodeStatusCode", "dailySmoke", "smokeAge", "quitSmokeAge", "drinkFrequency", "dailyDrink"
            , "nodrink", "nodrinkAge", "drinkAge", "drunk", "drinkSpirit", "drinkBeer", "drinkRedWine", "drinkYellowWine", "drinkOther"
            , "drinkOtherDesc", "lipAppearanceCehckResult", "dentitionAnomalyFlag", "missingToothFlg", "missingToothNumberUpl"
            , "missingToothNumberUpr", "missingToothNumberDownl", "missingToothNumberDownr", "decayedToothFlg", "decayedToothNumberUpl"
            , "decayedToothNumberUpr", "decayedToothNumberDownl", "decayedToothNumberDownr", "dentureToothFlg", "dentureToothNumberUpl"
            , "dentureToothNumberUpr", "dentureToothNumberDownl", "dentureToothNumberDownr", "pharynxCheckResult", "lNakedEye", "rNakedEye"
            , "lEyecorrection", "rEyecorrection", "hearDetectResult", "motorFuncState", "fundusOculiAnomalyFlag", "fundusOculiAnomalyDesc"
            , "skinCheckResult", "skinCheckDesc", "scleraCheckResult", "scleraCheckDesc", "lymphNodeCheckResult", "lymphNodeCheckDesc"
            , "barrelChest", "lungsAnomalySound", "lungsAnomalyDesc", "lungsRaleFlag", "lungsRaleDesc", "heartRate", "cardioverter", "heartMurmurFlag"
            , "heartMurmurDesc", "abdominalTendernessFlag", "abdominalTendernessDesc", "abdominalMassFlag", "abdominalMassDesc", "liverFlag"
            , "liverDesc", "splenomegalyFlag", "splenomegalyDesc", "abdominalVoicedFlag", "abdominalVoicedDesc", "legsEdemaCheckResult"
            , "arteriopalmus", "urineProQuantitativeValue", "urineSugQuantitativeValue", "ketQuantitativeValue", "eryQuantitativeValue"
            , "urineRoutinesOtherDesc", "fpgMmol", "fpgMg", "ecgAnomalyFlag", "ecgAnomalyDesc", "creatinine", "bloodUreaNitrogenValue"
            , "potassiumConcentration", "sodiumConcentration", "tc", "triglycerideValue", "ldlcDetectValue", "hdlcDetectValue", "cvascularFlag"
            , "cvascularHemorrhageStroke", "cvascularHemorrhage", "cvascularSah", "covascularTransientIschemic", "covascularOther"
            , "cvascularOtherDesc", "kidneyDiseaseFlag", "kidneyDiabeticNephropathy", "kidneyRenalFailure", "kidneyAcuteNephritis"
            , "kidneyChronicNephritis", "kidneyOther", "kidneyOtherDesc", "heartDiseaseFlag", "heartMiocardialInfarction", "heartAnginaPectoris"
            , "heartCoronary", "heartCongestiveHeart", "heartPrecordialPain", "heartOther", "heartOtherDesc", "arteryDiseaseFlag"
            , "arteryDissectingAneurysm", "arteryPaod", "arteryOther", "arteryOtherDesc", "eyeDiseasesFlag", "eyeRetinalOozing", "eyeOpticPapilla"
            , "eyeCataract", "eyeOther", "eyeOtherDesc", "nervousDiseasesFlag", "nervousDiseasesDesc", "hypertensionFlag", "hypertensionDesc"
            , "diabetesMellitusFlag", "diabetesMellituDesc", "healthOther", "healthOtherDesc", "hypertensionLevel", "riskAndCriorganDamage"
            , "bloodGluAssessment", "overallAssessment", "healthSelfAssessment", "lifeAbilitySelfAssessment", "cognitionScreenResult"
            , "emotionScreenResult", "healthEvaluateAnomalyFlag", "guideRegularFollowup", "guideIntoChronicDisease"
            , "guideSuggestionReview", "guideSuggestionReferral", "riskQuitSmoking", "riskHealthDrink", "riskDiet", "riskExercise"
            , "riskWeightReduction", "riskWeightTarget", "guideVaccination", "guideVaccinationDesc", "riskOther", "riskOtherDesc", "identificationId"};

	/**
	 * 体检人列表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, ModelMap model) {
		model.addAttribute("yearDt", new Date());
		return "rhip.cdm.base.standardization.phyExamination.list";
	}

	/**
	 * 体检人结果
	 * 
	 * @param form
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/result")
	public String result(QueryForm form, HttpServletRequest request, ModelMap model) {
		form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
        Criteria criteria = form.toCriteria(true, EHRConstants.DM_MANAGED_FLAG);
		if (ObjectUtil.isNullOrEmpty(form.getDiseaseType())) {
			Criteria disTypeCriteria = new Criteria();
			criteria.add(disTypeCriteria);
			disTypeCriteria.add(LOP.OR, "hbpFlag", EHRConstants.DM_MANAGED_FLAG);
			disTypeCriteria.add(LOP.OR, "diFlag", EHRConstants.DM_MANAGED_FLAG);
		}
		PageList<DmDiseaseInfo> list = standardizationService.getHmCardList(buildPage(request), criteria, getCurrentOrg(request), getRole(request));
		model.addAttribute("dmDiseaseInfoList", list.getList());
		return "rhip.cdm.base.standardization.phyExamination.listresult";
	}

    @RequestMapping(value = "/excel")
    public void exportManageCard(QueryForm form, HttpServletRequest request, ModelMap model, HttpServletResponse response) throws UnsupportedEncodingException {
        form.setDiseaseStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
        final Criteria criteria = form.toCriteria(true, EHRConstants.DM_MANAGED_FLAG);
        if (ObjectUtil.isNullOrEmpty(form.getDiseaseType())) {
            Criteria disTypeCriteria = new Criteria();
            criteria.add(disTypeCriteria);
            disTypeCriteria.add(LOP.OR, "hbpFlag", EHRConstants.DM_MANAGED_FLAG);
            disTypeCriteria.add(LOP.OR, "diFlag", EHRConstants.DM_MANAGED_FLAG);
        }
        final Organization org = getCurrentOrg(request);
        final RoleType roleType = getRole(request);
        excelExportService.exportListExecl("慢病体检", DmDiseaseInfo.class, response, new IDataSource() {
            @Override
            public List<Map<String, Object>> get(Page page) {
                List<Map<String, Object>> dataSource = standardizationService.exportHmCardList(page, criteria, org, roleType);
                return dataSource;
            }
        });
    }
	/**
	 * 体检列表
	 * 
	 * @param personId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/perPhyList")
	public String perPhyList(@RequestParam("personId") Long personId, HttpServletRequest request, ModelMap model) {
		Assert.notNull(personId, "人员id为空");
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		model.addAttribute("personInfo", personInfo);
		return "rhip.cdm.base.standardization.phyExamination.perphylist";
	}

	/**
	 * 体检列表结果
	 * 
	 * @param personId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/perPhyResult")
	public String perPhyResult(@RequestParam("personId") Long personId, HttpServletRequest request, ModelMap model) {
		Page page = buildPage(request);
		Criteria criteria_temp = new Criteria("personId", personId);
		criteria_temp.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
		List<HealthExamination> healthExaminations = examinationService.getHealthExaminations(criteria_temp, page);
		model.addAttribute("healthExaminations", healthExaminations);
		model.addAttribute("page", page);
		return "rhip.cdm.base.standardization.phyExamination.perphylistresult";
	}

	/**
	 * 查看体检
	 * 
	 * @param personId
	 * @param ehrId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(@RequestParam("personId") Long personId, @RequestParam("ehrId") String ehrId, HttpServletRequest request, ModelMap model) {
		doView(personId, ehrId, model);
		return "rhip.cdm.base.standardization.phyExamination.view";
	}
	
	/**
	 * 查看体检
	 * 
	 * @param personId
	 * @param ehrId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/externalView")
	public String externalView(@RequestParam("personId") Long personId, @RequestParam("ehrId") String ehrId, HttpServletRequest request, ModelMap model) {
		doView(personId, ehrId, model);
		return "rhip.cdm.base.standardization.phyExamination.externalView";
	}
	
	/**
	 * 查看体检
	 * 
	 * @param personId
	 * @param ehrId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/externalView/{personId}/{ehrId}")
	public String externalViewByUrlParam(@PathVariable("personId") Long personId, @PathVariable("ehrId") String ehrId, HttpServletRequest request, ModelMap model) {
		return externalView(personId, ehrId, request, model);
	}

	private void doView(Long personId, String ehrId, ModelMap model) {
        Criteria criteria = new Criteria("personId", personId);
        criteria.add("ehrId", ehrId);
        ElderlyPhyExamination elderlyPhyExamination = examinationService.getPhyExamination(criteria);
        if(elderlyPhyExamination==null)
            return;
        PersonInfo personInfo = platformService.queryPersonalInfo(personId);
        if ("2".equals(personInfo.getGender())) {
            model.put("isWoman", true);
        }
        doSynchronization( personInfo, model, elderlyPhyExamination);
        if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
            //按日期算年龄
            Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
            int age = DateUtil.getAgeByBirthday(birth);
            if(age>=EHRConstants.SIXTY_FIVE_ELDER){
                model.put("isElder", true);
            }else if(age<EHRConstants.SIXTY_FIVE_ELDER && age>=18){
                model.put("isYoung", true);
            }else if(age<18){
                model.put("isTeen", true);
            }
        }
	}

    /**
     * 同步病床，接种，家庭疾病史，住院史等信息
     *
     * @param personInfo
     * @param model
     * @param elderlyPhyExamination
     */
    private void doSynchronization(PersonInfo personInfo, ModelMap model,ElderlyPhyExamination elderlyPhyExamination){
        PersonalPhyExamDTO phyExamDTO = new PersonalPhyExamDTO();
        List<HealthEvaluateAnomaly> healthEvaluateAnomalylist = elderlyPhyExamination.getHealthEvaluateAnomalies();

        Criteria ca = new Criteria("personId", personInfo.getId()).add("ehrId",elderlyPhyExamination.getEhrId());
        List<HospitalizedHistory> hospitalizedHistoryList = hospitalizedHistoryDao.getList(ca);

        List<FamilyBedHistory> familyBedHistoryList = familyBedHistoryDao.getList(ca);
        if (null != familyBedHistoryList && familyBedHistoryList.size() > 0) {
            if (familyBedHistoryList.size() < 3) {
                for (int i = 0; i <= (3 - familyBedHistoryList.size()); i++) {
                    familyBedHistoryList.add(new FamilyBedHistory());
                }
            }
            if(ObjectUtil.isNullOrEmpty(familyBedHistoryList.get(0).getBuiltBedDate())){
                model.put("familyBedHistoryFlg", "0");
            }else{
                model.put("familyBedHistoryFlg", "1");
            }
        }else{
            model.put("familyBedHistoryFlg", "0");
        }

        List<DrugHistory> drugHistoryList = drugHistoryDao.getList(ca);
        if (null != drugHistoryList && drugHistoryList.size() > 0) {
            if (drugHistoryList.size() < 5) {
                int total = 5 - drugHistoryList.size();
                for (int i = 0; i < total; i++)
                    drugHistoryList.add(new DrugHistory());
            }
            if(ObjectUtil.isNullOrEmpty(drugHistoryList.get(0).getDrugGenericName())){
                model.put("drugHistoryFlag", "0");
            }else{
                model.put("drugHistoryFlag", "1");
            }
        }else{
            model.put("drugHistoryFlag", "0");
        }

        List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(ca);
        if (null != vaccinationInfoList && vaccinationInfoList.size() > 0) {
            if (vaccinationInfoList.size() < 5) {
                int total = 5 - vaccinationInfoList.size();
                for (int i = 0; i < total; i++) {
                    vaccinationInfoList.add(new VaccinationInfo());
                }
            }
            if(ObjectUtil.isNullOrEmpty(vaccinationInfoList.get(0).getVaccineName())){
                model.put("vaccinationInfoFlg", "0");
            }else{
                model.put("vaccinationInfoFlg", "1");
            }
        }else{
            model.put("vaccinationInfoFlg", "0");
        }

        if (null != hospitalizedHistoryList && hospitalizedHistoryList.size() > 0) {
            if (hospitalizedHistoryList.size() < 3) {
                for (int i = 0; i <= (3 - hospitalizedHistoryList.size()); i++) {
                    hospitalizedHistoryList.add(new HospitalizedHistory());
                }
            }
            if(ObjectUtil.isNullOrEmpty(hospitalizedHistoryList.get(0).getInhosReason())){
                model.put("hospitalizedHistoryFlg", "0");
            }else{
                model.put("hospitalizedHistoryFlg", "1");
            }
        }else{
            model.put("hospitalizedHistoryFlg", "0");
        }
        if(ObjectUtil.isNotEmpty(elderlyPhyExamination.getIdentificationId())){
        	//老年人中医体质辨识
			EchIdentification ech = echManageService.getEchIdentification(elderlyPhyExamination.getIdentificationId());
	       //获取老年人当年的体质辨识记录
			if(ObjectUtil.isNotEmpty(ech)){
		        ech.calTcmFlag();
		        elderlyPhyExamination.setTcmQiQuality(ech.getQiFlag());
		        elderlyPhyExamination.setTcmYinDeficiency(ech.getYinDeficiencyFlag());
		        elderlyPhyExamination.setTcmYangQuality(ech.getYangFlag());
		        elderlyPhyExamination.setTcmPhlegmWetness(ech.getPhlegmWetnessFlag());
		        elderlyPhyExamination.setTcmHeatMedium(ech.getHeatMediumFlag());
		        elderlyPhyExamination.setTcmBloodQuality(ech.getBloodFlag());
		        elderlyPhyExamination.setTcmQiStagnation(ech.getQiStagnationFlag());
		        elderlyPhyExamination.setTcmSpecialQuality(ech.getSpecialFlag());
		        elderlyPhyExamination.setTcmPeacefulQuality(ech.getPeacefulFlag());
			}
        }
        model.put("familyBedHistoryList",familyBedHistoryList);
        model.put("hospitalizedHistoryList",hospitalizedHistoryList);
        model.put("vaccinationInfoList", vaccinationInfoList);
        model.put("drugHistoryList",drugHistoryList);
        model.put("healthEvaluateAnomalylist", healthEvaluateAnomalylist);
        model.put("phyExamDTO", phyExamDTO);
        model.put("examination", elderlyPhyExamination);
    }

	/**
	 * 体检人员列表直接增加体检
	 * 
	 * @param personId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addPhy")
	public String addPhy(@RequestParam("personId") Long personId, HttpServletRequest request, ModelMap model) {
        String hbpFlag = "1";
        String diFlag = "1";
        //判断高血压/糖尿病
        DmDiseaseInfo dmDiseaseInfo = standardizationService.queryDmDiseaseInfo(personId);
        if(ObjectUtil.isNotEmpty(dmDiseaseInfo)){
            hbpFlag = dmDiseaseInfo.getHbpFlag();
            diFlag = dmDiseaseInfo.getDiFlag();
        }

        PersonInfo personInfo = platformService.queryPersonalInfo(personId);
        ElderlyPhyExamination elderlyPhyExamination = examinationService.add(personInfo, getCurrentOrg(request));
        if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getManaDoctorId())) {
            elderlyPhyExamination.setManaDoctorId(getCurrentUser(request).getStaffCode());
        }
        /*elderlyPhyExamination = initHealthManage(elderlyPhyExamination);*/
        if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
            //按日期算年龄
            Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
            int age = DateUtil.getAgeByBirthday(birth);
            if(age>=EHRConstants.SIXTY_FIVE_ELDER){
                model.put("isElder", true);
            }else if(age<EHRConstants.SIXTY_FIVE_ELDER && age>=18){
                model.put("isYoung", true);
            }else if(age<18){
                model.put("isTeen", true);
            }
        }
        doSynchronization( personInfo, model, elderlyPhyExamination);


        model.put("hbpFlag",hbpFlag);
        model.put("diFlag",diFlag);
        model.put("personInfo", personInfo);
        if ("2".equals(personInfo.getGender())) {
            model.put("isWoman", true);
        }
        return "rhip.cdm.base.standardization.phyExamination.addPhy";
    }

	/**
	 * 增加体检
	 * 
	 * @param personId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add(@RequestParam("personId") Long personId,String editFlag, HttpServletRequest request, ModelMap model) {
        String hbpFlag = "1";
        String diFlag = "1";
        //判断高血压/糖尿病
        DmDiseaseInfo dmDiseaseInfo = standardizationService.queryDmDiseaseInfo(personId);
        if(ObjectUtil.isNotEmpty(dmDiseaseInfo)){
            hbpFlag = dmDiseaseInfo.getHbpFlag();
            diFlag = dmDiseaseInfo.getDiFlag();
        }
        PersonInfo personInfo = platformService.queryPersonalInfo(personId);
        ElderlyPhyExamination elderlyPhyExamination = examinationService.add(personInfo, getCurrentOrg(request));
        elderlyPhyExamination.setManaDoctorId(getCurrentUser(request).getStaffCode());
        /*elderlyPhyExamination = initHealthManage(elderlyPhyExamination);*/
        if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
            //按日期算年龄
            Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
            int age = DateUtil.getAgeByBirthday(birth);
            if(age>=EHRConstants.SIXTY_FIVE_ELDER){
                model.put("isElder", true);
            }else if(age<EHRConstants.SIXTY_FIVE_ELDER && age>=18){
                model.put("isYoung", true);
            }else if(age<18){
                model.put("isTeen", true);
            }
        }

        if ("2".equals(personInfo.getGender())) {
            model.put("isWoman", true);
        }
        doSynchronization( personInfo, model, elderlyPhyExamination);
        model.put("hbpFlag",hbpFlag);
        model.put("diFlag",diFlag);
        if(StringUtil.isNotEmpty(editFlag)){
			model.put("editFlag", editFlag);
		}
        return "rhip.cdm.base.standardization.phyExamination.add";
    }
	
	@RequestMapping(value = "/hasExam")
	@ResponseBody
	public String hasExam(@RequestParam("personId") Long personId,HttpServletRequest request, ModelMap model) {
		String hasExam ="";
		List<ElderlyPhyExamination> exams = examinationService.getElderlyPhyExaminations(new Criteria("personId", personId), new Order("examination_date desc"), "examinationDate", "ehrId");
		if(!ObjectUtil.isNullOrEmpty(exams)){//若做过体检返回EhrId
			hasExam =exams.get(0).getEhrId();
		}
		return hasExam;
	}
	
	/**
	 * 修改体检
	 * 
	 * @param personId
	 * @param ehrId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(@RequestParam("personId") Long personId, String ehrId, String loadPrePhyexamFlag,String editFlag,HttpServletRequest request, ModelMap model) {
        String hbpFlag = "1";
        String diFlag = "1";
        //判断高血压/糖尿病
        DmDiseaseInfo dmDiseaseInfo = standardizationService.queryDmDiseaseInfo(personId);
        if(ObjectUtil.isNotEmpty(dmDiseaseInfo)){
            hbpFlag = dmDiseaseInfo.getHbpFlag();
            diFlag = dmDiseaseInfo.getDiFlag();
        }
        PersonInfo personInfo = platformService.queryPersonalInfo(personId);
        if ("2".equals(personInfo.getGender())) {
            model.put("isWoman", true);
        }
        if (ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
            //按日期算年龄
            Date birth = IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard());
            int age = DateUtil.getAgeByBirthday(birth);
            if(age>=EHRConstants.SIXTY_FIVE_ELDER){
                model.put("isElder", true);
            }else if(age<EHRConstants.SIXTY_FIVE_ELDER && age>=18){
                model.put("isYoung", true);
            }else if(age<18){
                model.put("isTeen", true);
            }
        }
        Criteria criteria = new Criteria("personId", personId);
        criteria.add("ehrId", ehrId);
        //phyExaminationService.getElderlyPhyExaminations(new Criteria("personId", personId), new Order("examination_date desc"), "examinationDate", "ehrId");
        ElderlyPhyExamination elderlyPhyExamination = examinationService.getPhyExamination(criteria);
        doSynchronization( personInfo, model, elderlyPhyExamination);
        if(StringUtil.isNotEmpty(loadPrePhyexamFlag)){//点击上一次体检信息按钮
			elderlyPhyExamination.setExaminationDate(new Date());
			elderlyPhyExamination.setPhysicalExamCode(null);
			elderlyPhyExamination.setId(null);
			elderlyPhyExamination.setEhrId(null);
		}
		if(StringUtil.isNotEmpty(editFlag)){
			model.put("editFlag", editFlag);
		}
        model.put("hbpFlag",hbpFlag);
        model.put("diFlag",diFlag);
        if(StringUtil.isNotEmpty(loadPrePhyexamFlag)){//点击上一次体检信息按钮
			return "rhip.cdm.base.standardization.phyExamination.loadPrePhy";
		}
        return "rhip.cdm.base.standardization.phyExamination.edit";
    }

	/**
	 * 保存体检,修改和新增
	 * 
	 * @param elderlyPhyExamination
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(ElderlyPhyExamination elderlyPhyExamination, HttpServletRequest request, ModelMap model) {
        PersonalPhyExamDTO personalPhyExamDTO = VoUtil.getFormData(request, PersonalPhyExamDTO.class);
//        String[] healthEvaluateAnomalyList = new String[4];
        Map<Integer,String>  healthEvaluateAnomalyMap = new HashMap<Integer,String>();
        String healthAbnormal1 = request.getParameter("healthAbnormal1");
        String healthAbnormal2 = request.getParameter("healthAbnormal2");
        String healthAbnormal3 = request.getParameter("healthAbnormal3");
        String healthAbnormal4 = request.getParameter("healthAbnormal4");
//        healthEvaluateAnomalyList[0] = healthAbnormal1;
//        healthEvaluateAnomalyList[1] = healthAbnormal2;
//        healthEvaluateAnomalyList[2] = healthAbnormal3;
//        healthEvaluateAnomalyList[3] = healthAbnormal4;
        healthEvaluateAnomalyMap.put(1, healthAbnormal1);
        healthEvaluateAnomalyMap.put(2, healthAbnormal2);
        healthEvaluateAnomalyMap.put(3, healthAbnormal3);
        healthEvaluateAnomalyMap.put(4, healthAbnormal4);
        Long personId = elderlyPhyExamination.getPersonId();
        Assert.notNull(personId, "人员id为空");
        PersonInfo personInfo = platformService.queryPersonalInfo(personId);
        Assert.notNull(personInfo, "人员为空");
        personalPhyExamDTO.setPersonInfo(personInfo);
        
        
        boolean result = true;
        //保存建档医生
        Staff staff = staffService.getStaff(elderlyPhyExamination.getManaDoctorId());
        if (ObjectUtil.isNotEmpty(staff)) {
            elderlyPhyExamination.setManaDoctorName(staff.getName());
        }
        try {
            List<HealthEvaluateAnomaly> tmpList = new ArrayList<>();
            //健康评价异常
            for(Integer key : healthEvaluateAnomalyMap.keySet()){
            	if(StringUtil.isNotEmpty(healthEvaluateAnomalyMap.get(key))) {
	            	 HealthEvaluateAnomaly health = new HealthEvaluateAnomaly();
	                 health.setHealthEvaluateAnomalyDesc(healthEvaluateAnomalyMap.get(key));
	                 health.setSort(key);
	                 tmpList.add(health);
            	}
            }
            elderlyPhyExamination.setHealthEvaluateAnomalies(tmpList);
            personalPhyExamDTO.setHealthEvaluateAnomalyList(tmpList);
//            if (ObjectUtil.isNotEmpty(healthEvaluateAnomalyList)) {
//                for (String anomaly : healthEvaluateAnomalyList) {
//                    if(StringUtil.isNotEmpty(anomaly)) {
//                        HealthEvaluateAnomaly health = new HealthEvaluateAnomaly();
//                        health.setHealthEvaluateAnomalyDesc(anomaly);
//                        tmpList.add(health);
//                    }
//                }
//                elderlyPhyExamination.setHealthEvaluateAnomalies(tmpList);
//            }
            if(ObjectUtil.isNotEmpty(personalPhyExamDTO.getHospitalizedHistoryList())){
                elderlyPhyExamination.setHospitalizedHistoryList(personalPhyExamDTO.getHospitalizedHistoryList());
            }

            if(ObjectUtil.isNotEmpty(personalPhyExamDTO.getFamilyBedHistoryList())){
                elderlyPhyExamination.setFamilyBedHistoryList(personalPhyExamDTO.getFamilyBedHistoryList());
            }if(ObjectUtil.isNotEmpty(personalPhyExamDTO.getDrugHistoryList())){
                elderlyPhyExamination.setDrugHistorylist(personalPhyExamDTO.getDrugHistoryList());
            }if(ObjectUtil.isNotEmpty(personalPhyExamDTO.getVaccinationInfoList())){
                elderlyPhyExamination.setVaccinationInfoList(personalPhyExamDTO.getVaccinationInfoList());
            }
            // 如果没有体检编号,则自动生成
		    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getPhysicalExamCode())) {
		    	String examCode = EHRNumberService.getSerialNum(elderlyPhyExamination.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
		        elderlyPhyExamination.setPhysicalExamCode(examCode);
		        elderlyPhyExamination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
		    }
            
            //体质辨识保存的session的key值
            String ideKey = SESSIONIDE + personInfo.getIdcard();
            EchIdentification identification = null;
            //新增、更新体质辨识相关
            updateIdentification(request, ideKey, elderlyPhyExamination, identification);
			
            PhysiqueExamination physiqueExamination = getPhyExamination(elderlyPhyExamination);
            personalPhyExamDTO.setPhysiqueExamination(physiqueExamination);
            personalPhyExamDTO.setEchIdentification(identification);
            
            //保存、修改慢病体检
            Long id = elderlyPhyExamination.getId();
            if (ObjectUtil.isNullOrEmpty(id)) {
            	String physicalExamCode = examinationService.savePhyExamination(personInfo, elderlyPhyExamination, getCurrentOrg(request), getCurrentUser(request));
            	record(request, OperationName.ADD);
            } else {
                Assert.notNull(elderlyPhyExamination.getEhrId(), "事件id为空");
                examinationService.updatePhyExamination(personInfo, elderlyPhyExamination, getCurrentOrg(request), getCurrentUser(request));
                record(request, OperationName.UPDATE);
            }
            //保存老年人体检
            physicalExamRecordService.savePhyExamination(personId, elderlyPhyExamination, personalPhyExamDTO, getCurrentOrg(request), getCurrentUser(request), EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(), physiqueProp);

            if(ObjectUtil.isNullOrEmpty(identification) && ObjectUtil.isNotEmpty(elderlyPhyExamination.getIdentificationId())){
		    	identification = echManageService.getEchIdentification(elderlyPhyExamination.getIdentificationId());
			}
            //保存个人体检            
            final User currentUser = getCurrentUser(request);
            List<HealthEvaluateAnomaly> list = elderlyPhyExamination.getHealthEvaluateAnomalies();
            personalRecordManagmentService.savePhyExamFromElderly(currentUser, getCurrentOrg(request), personInfo, physiqueExamination, list, personalPhyExamDTO.getHospitalizedHistoryList(),personalPhyExamDTO.getFamilyBedHistoryList(),personalPhyExamDTO.getDrugHistoryList(),personalPhyExamDTO.getVaccinationInfoList(), physiqueProp);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            result = false;
        }
        return result;
    }

	/**
	 * 新增、更新体质辨识相关
	 * @param request
	 * @param ideKey
	 * @param elderlyPhyExamination
	 * @param identification
	 */
	private void updateIdentification(HttpServletRequest request, String ideKey, ElderlyPhyExamination elderlyPhyExamination, EchIdentification identification) {
		if(ObjectUtil.isNotEmpty(request.getSession().getAttribute(ideKey))) {
            identification = (EchIdentification) request.getSession().getAttribute(ideKey);
            if(ObjectUtil.isNotEmpty(identification.getQiQualityGuidance())||ObjectUtil.isNotEmpty(identification.getYangQualityGuidance())||
                    ObjectUtil.isNotEmpty(identification.getYinDeficiencyGuidance())||ObjectUtil.isNotEmpty(identification.getPhlegmWetnessGuidance())
                    ||ObjectUtil.isNotEmpty(identification.getHeatMediumGuidance())||ObjectUtil.isNotEmpty(identification.getBloodQualityGuidance())
                    ||ObjectUtil.isNotEmpty(identification.getQiStagnationGuidance())||ObjectUtil.isNotEmpty(identification.getSpecialQualityGuidance())||ObjectUtil.isNotEmpty(identification.getPeacefulQualityGuidance())){
                elderlyPhyExamination.setHealthGuidance("1");
            }else{
                elderlyPhyExamination.setHealthGuidance("0");
            }
            
			identification = echManageService.saveEchIdentification(identification);
			elderlyPhyExamination.setIdentificationId(identification.getId());
			elderlyPhyExamination.setTcmConclusion(identification.getTcmConclusion());
			//保存后删除session
			request.getSession().removeAttribute(ideKey);
        }
        
        //更新关联的体质辨识中体检编号
		if((ObjectUtil.isNotEmpty(elderlyPhyExamination.getOldIdentificationId()) || ObjectUtil.isNotEmpty(elderlyPhyExamination.getIdentificationId()) )
				&& elderlyPhyExamination.getOldIdentificationId() != elderlyPhyExamination.getIdentificationId()){
			identification = echManageService.updateEchIdentification(elderlyPhyExamination.getIdentificationId());
			if(ObjectUtil.isNotEmpty(identification)){
				elderlyPhyExamination.setTcmConclusion(identification.getTcmConclusion());
			}
		}
		
		//取消关联体质辨识
		if(ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getIdentificationId())){
			elderlyPhyExamination.setTcmQiQuality(null);
	        elderlyPhyExamination.setTcmYinDeficiency(null);
	        elderlyPhyExamination.setTcmYangQuality(null);
	        elderlyPhyExamination.setTcmPhlegmWetness(null);
	        elderlyPhyExamination.setTcmHeatMedium(null);
	        elderlyPhyExamination.setTcmBloodQuality(null);
	        elderlyPhyExamination.setTcmQiStagnation(null);
	        elderlyPhyExamination.setTcmSpecialQuality(null);
	        elderlyPhyExamination.setTcmPeacefulQuality(null);
			elderlyPhyExamination.setTcmConclusion(null);
		}
	}
	
	/**
	 * 删除体检
	 * 
	 * @param personId
	 * @param ehrId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam("personId") Long personId, @RequestParam("ehrId") String ehrId, HttpServletRequest request, ModelMap model) {
		boolean result = true;
		try {
			User currentUser = getCurrentUser(request);
			Organization organization = getCurrentOrg(request);
					
			//删除慢病体检
			HealthExamination examination = examinationService.deleteElderlyPhyExamination(personId, ehrId, null);
			if(ObjectUtil.isNullOrEmpty(examination)){
				result = false;
			}else{
				//按体检编号删除个人体检----最后一条体检不可删除
				Criteria cri = new Criteria("personId", personId);
				List<PhysiqueExamination> phyExamList = physiqueExaminationDao.getList(cri);
	            if(ObjectUtil.isNotEmpty(phyExamList) && phyExamList.size()>1){
	            	personalRecordManagmentService.deletePhysical(personId, null, currentUser, organization, getRequestIp(request), request.getRequestURI(), examination.getPhysicalExamCode());
	            }
				//删除体检编号相同的老年人体检
				physicalExamRecordService.deleteByEhrId(personId, null, examination.getPhysicalExamCode());
	
	            record(request, BaseController.OperationName.DELETE);
			}
            
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			result = false;
		}
		return result;
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

	/**
     * 慢病体检信息复制到个人体检表
	 */
    private PhysiqueExamination getPhyExamination(ElderlyPhyExamination elderlyPhyExamination) {
        PhysiqueExamination result = new PhysiqueExamination();
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new IntegerConverter(null),Integer.class);
        try {
            BeanUtils.copyProperties(result, elderlyPhyExamination);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/statistics/search")
    public String searchStarStatistics(HttpServletRequest request, ModelMap model) {
        model.addAttribute("beginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("endDate", DateUtil.lastDateOfMonth(new Date()));
        return "rhip.cdm.statistics.phy.search";
    }

    /**
     * 慢病随访-工作量统计
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/statistics/list")
    public String getStarStatistics(HttpServletRequest request, ModelMap model, ReportQueryForm form) {
        setRoleCondition(request, form);
        Organization currentOrg = this.getCurrentOrg(request);
        PageList<Map<String, Object>> followupMapList = examinationService.getPhyExaminationStatistics(buildPage(request), form, currentOrg);
        model.addAttribute("followupMapList", followupMapList.getList());
        model.addAttribute("searchType", form.getSearchType());
        return "rhip.cdm.statistics.phy.list";
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
            excelExportService.exportListExecl("慢病体检统计", CdmPhyStatisticsVillageDto.class, response, new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    return examinationService.exportPhyExaminationStatistics(page, reportQueryForm, currentOrg);
                }
            });
        } else {
            excelExportService.exportListExecl("慢病体检统计", CdmPhyStatisticsDto.class, response, new IDataSource() {
                @Override
                public List<Map<String, Object>> get(Page page) {
                    return examinationService.exportPhyExaminationStatistics(page, reportQueryForm, currentOrg);
                }
            });
        }
    }
    
    /**
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/phyCensus/search")
    public String phyCensusSearch(HttpServletRequest request, ModelMap model) {
    	model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
        return "rhip.cdm.phy.census.search";
    }
    
    /**
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/phyCensus/list")
    public String phyCensusList(HttpServletRequest request, Model model, HealthManageQueryForm queryForm) {
    	Criteria criteria = queryForm.toCriteria();
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
        List<Map<String, Object>> list = examinationService.getPhyCensusList(criteria);
        model.addAttribute("followupMapList", list);
        return "rhip.cdm.phy.census.list";
    }
    
	/**
	 * 组织不同身份查询条件
	 * 
	 * @param criteria
	 * @param model
	 * @param request
	 */
	protected void organizeCriteria(Criteria criteria, Model model, HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.YY_GLY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.ZXJKDN, request)) {
				criteria.add("centerCode", org.getOrganCode());
			} else if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZJKDN, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}
		
		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode")); 
		} else if (criteria.contains("centerCode")) {
			model.addAttribute("centerCode", criteria.get("centerCode")); 
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode")); 
		}else{
			model.addAttribute("all", "all"); 
		}
	}
}
