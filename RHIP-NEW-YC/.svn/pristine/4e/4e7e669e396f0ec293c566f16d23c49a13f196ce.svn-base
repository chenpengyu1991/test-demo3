package com.founder.rhip.hm.controller;

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

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IPhyExaminationService;
import com.founder.rhip.ech.service.IEchManageService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyStatus;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyStatusDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.ech.IEchIdentificationDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.repository.summary.IDrugHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyBedHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.service.IHealthExaminationService;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.hm.controller.form.ElderPersonInfoExcel;
import com.founder.rhip.hm.controller.form.ElderPersonInfoTableExcel;
import com.founder.rhip.hm.controller.form.HealthManageQueryForm;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.hm.service.IPhysiqueExaminationService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;

@Controller
@RequestMapping(value = "/hm/manage")
public class HealthManageController extends BaseController {

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

	@Resource
	private IPhysicalExamRecordService physicalExamRecordService;

	@Resource
	private IPhysiqueExaminationService physiqueExaminationService;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "healthExaminationService")
	private IHealthExaminationService healthExaminationService;

	@Resource(name = "cdmPhyExaminationService")
	private IPhyExaminationService phyExaminationService;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;

	@Resource(name = "echManageService")
	private IEchManageService echManageService;
	@Resource(name = "hospitalizedHistoryDao")
	private IHospitalizedHistoryDao hospitalizedHistoryDao;
	@Resource(name = "familyBedHistoryDao")
	private IFamilyBedHistoryDao familyBedHistoryDao;
	@Resource(name = "drugHistoryDao")
	private IDrugHistoryDao drugHistoryDao;
	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;
	@Resource(name = "echIdentificationDao")
	private IEchIdentificationDao echIdentificationDao;
	@Autowired
	private IStaffService staffService;
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;

	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;

	@Resource(name = "cdmPhyExaminationService")
	private IPhyExaminationService examinationService;
	
	@Resource(name = "elderlyPhyStatusDao")
	private IElderlyPhyStatusDao elderlyPhyStatusDao;
	
    @Resource(name = "physiqueExaminationDao")
    private IPhysiqueExaminationDao physiqueExaminationDao;

	private String[] syncProperties = {"abdominalMassDesc","abdominalMassFlag","abdominalTendernessDesc","abdominalTendernessFlag","abdominalVoicedDesc","abdominalVoicedFlag","arteriopalmus","arteryDiseaseFlag","arteryDissectingAneurysm","arteryOther","arteryOtherDesc","arteryPaod","barrelChest","bloodUreaNitrogenValue","bodyWeight","cardioverter","cognitionScreenResult","cognitionScreenScore","covascularOther","covascularTransientIschemic","creatinine","cvascularFlag","cvascularHemorrhage","cvascularHemorrhageStroke","cvascularOtherDesc","cvascularSah","dailyDrink","dailySmoke","decayedToothFlg","decayedToothNumberDownl","decayedToothNumberDownr","decayedToothNumberUpl","decayedToothNumberUpr","dentitionAnomalyFlag","dentureToothFlg","dentureToothNumberDownl","dentureToothNumberDownr","dentureToothNumberUpl","dentureToothNumberUpr","depressionScore","dietAddictedOil","dietHalophilic","dietHunsuEquilibrium","dietMeatMain","dietSugarCravings","dietVegetarian","drinkAge","drinkBeer","drinkFrequency","drinkOther","drinkOtherDesc","drinkRedWine","drinkSpirit","drinkYellowWine","drunk","ecgAnomalyDesc","ecgAnomalyFlag","emotionScreenResult","eryQuantitativeValue","examinationDate","eyeCataract","eyeDiseasesFlag","eyeOpticPapilla","eyeOther","eyeOtherDesc","eyeRetinalOozing","fpgMg","fpgMmol","fundusOculiAnomalyDesc","fundusOculiAnomalyFlag","guideVaccination","guideVaccinationDesc","hdlcDetectValue","healthOther","healthOtherDesc","healthSelfAssessment","hearDetectResult","heartAnginaPectoris","heartCongestiveHeart","heartCoronary","heartDiseaseFlag","heartMiocardialInfarction","heartMurmurDesc","heartMurmurFlag","heartOther","heartOtherDesc","heartPrecordialPain","heartRate","height","hip","indexOfBodyCharacteristics","ketQuantitativeValue","kidneyAcuteNephritis","kidneyChronicNephritis","kidneyDiabeticNephropathy","kidneyDiseaseFlag","kidneyOther","kidneyOtherDesc","kidneyRenalFailure","ldlcDetectValue","leftDbp","leftSbp","legsEdemaCheckResult","lEyecorrection","lifeAbilitySelfAssessment","lipAppearanceCehckResult","liverDesc","liverFlag","lNakedEye","lungsAnomalyDesc","lungsAnomalySound","lungsRaleDesc","lungsRaleFlag","lymphNodeCheckDesc","lymphNodeCheckResult","missingToothFlg","missingToothNumberDownl","missingToothNumberDownr","missingToothNumberUpl","missingToothNumberUpr","motorFuncState","nervousDiseasesDesc","nervousDiseasesFlag","nodrink","nodrinkAge","pharynxCheckResult","potassiumConcentration","pulseRate","quitSmokeAge","respiratoryRate","rEyecorrection","riskOther","riskOtherDesc","riskWeightReduction","rNakedEye","scleraCheckDesc","scleraCheckResult","skinCheckDesc","skinCheckResult","smodeStatusCode","smokeAge","sodiumConcentration","splenomegalyDesc","splenomegalyFlag","symptomBlurredVision","symptomBreastTenderness","symptomChestPain","symptomChestTightness","symptomChronicCough","symptomConstipation","symptomCough","symptomDiarrhea","symptomDizzy","symptomDyspnea","symptomDysuria","symptomFatigue","symptomFlag","symptomHeadache","symptomJointPain","symptomNauseaVomiting","symptomNumbness","symptomOther","symptomOtherDesc","symptomPalpitations","symptomPolydipsia","symptomPolyuria","symptomTinnitus","symptomUrgency","symptomVertigo","symptomWeightLoss","tc","temperature","trainFrequencyTypeCode","trainingMin","trainingTotaltime","trainingWay","triglycerideValue","urineProQuantitativeValue","urineRoutinesOtherDesc","urineSugQuantitativeValue","waostline","whr"};

	private String[] physiqueProp = {"physicalExamCode","name","examinationOrganCode","examinationDate","manaDoctorId"
			,"symptomFlag","symptomHeadache","symptomDizzy","symptomPalpitations","symptomChestTightness","symptomChestPain"
			,"symptomChronicCough","symptomCough","symptomDyspnea","symptomPolydipsia","symptomPolyuria","symptomWeightLoss"
			,"symptomFatigue","symptomJointPain","symptomBlurredVision","symptomNumbness","symptomUrgency","symptomDysuria"
			,"symptomConstipation","symptomDiarrhea","symptomNauseaVomiting","symptomVertigo","symptomTinnitus","symptomBreastTenderness"
			,"symptomOther","symptomOtherDesc","familyHistoryHbpFlg","familyHistoryCoronaryFlg","familyHistoryStrokeFlg"
			,"familyHistoryDiFlg","temperature","pulseRate","respiratoryRate","leftSbp","leftDbp","pastHighestSbp"
			,"pastHighesDbp","height","bodyWeight","waostline","indexOfBodyCharacteristics","hip","whr","trainFrequencyTypeCode"
			,"trainingMin","trainingTotaltime","trainingWay","dietHunsuEquilibrium","dietMeatMain","dietVegetarian","dietHalophilic"
			,"dietAddictedOil","dietSugarCravings","smodeStatusCode","dailySmoke","smokeAge","quitSmokeAge","drinkFrequency","dailyDrink"
			,"nodrink","nodrinkAge","drinkAge","drunk","drinkSpirit","drinkBeer","drinkRedWine","drinkYellowWine","drinkOther"
			,"drinkOtherDesc","lipAppearanceCehckResult","dentitionAnomalyFlag","missingToothFlg","missingToothNumberUpl"
			,"missingToothNumberUpr","missingToothNumberDownl","missingToothNumberDownr","decayedToothFlg","decayedToothNumberUpl"
			,"decayedToothNumberUpr","decayedToothNumberDownl","decayedToothNumberDownr","dentureToothFlg","dentureToothNumberUpl"
			,"dentureToothNumberUpr","dentureToothNumberDownl","dentureToothNumberDownr","pharynxCheckResult","lNakedEye","rNakedEye"
			,"lEyecorrection","rEyecorrection","hearDetectResult","motorFuncState","fundusOculiAnomalyFlag","fundusOculiAnomalyDesc"
			,"skinCheckResult","skinCheckDesc","scleraCheckResult","scleraCheckDesc","lymphNodeCheckResult","lymphNodeCheckDesc"
			,"barrelChest","lungsAnomalySound","lungsAnomalyDesc","lungsRaleFlag","lungsRaleDesc","heartRate","cardioverter","heartMurmurFlag"
			,"heartMurmurDesc","abdominalTendernessFlag","abdominalTendernessDesc","abdominalMassFlag","abdominalMassDesc","liverFlag"
			,"liverDesc","splenomegalyFlag","splenomegalyDesc","abdominalVoicedFlag","abdominalVoicedDesc","legsEdemaCheckResult"
			,"arteriopalmus","urineProQuantitativeValue","urineSugQuantitativeValue","ketQuantitativeValue","eryQuantitativeValue"
			,"urineRoutinesOtherDesc","fpgMmol","fpgMg","ecgAnomalyFlag","ecgAnomalyDesc","creatinine","bloodUreaNitrogenValue"
			,"potassiumConcentration","sodiumConcentration","tc","triglycerideValue","ldlcDetectValue","hdlcDetectValue","cvascularFlag"
			,"cvascularHemorrhageStroke","cvascularHemorrhage","cvascularSah","covascularTransientIschemic","covascularOther"
			,"cvascularOtherDesc","kidneyDiseaseFlag","kidneyDiabeticNephropathy","kidneyRenalFailure","kidneyAcuteNephritis"
			,"kidneyChronicNephritis","kidneyOther","kidneyOtherDesc","heartDiseaseFlag","heartMiocardialInfarction","heartAnginaPectoris"
			,"heartCoronary","heartCongestiveHeart","heartPrecordialPain","heartOther","heartOtherDesc","arteryDiseaseFlag"
			,"arteryDissectingAneurysm","arteryPaod","arteryOther","arteryOtherDesc","eyeDiseasesFlag","eyeRetinalOozing","eyeOpticPapilla"
			,"eyeCataract","eyeOther","eyeOtherDesc","nervousDiseasesFlag","nervousDiseasesDesc","hypertensionFlag","hypertensionDesc"
			,"diabetesMellitusFlag","diabetesMellituDesc","healthOther","healthOtherDesc","hypertensionLevel","riskAndCriorganDamage"
			,"bloodGluAssessment","overallAssessment","healthSelfAssessment","lifeAbilitySelfAssessment","eatingAssessment","cleaningAssessment"
			,"clothingAssessment","defecationAssessment","exerciseAssessment","cognitionScreenResult","cognitionScreenScore"
			,"emotionScreenResult","depressionScore","guideIntoChronicDisease"};

	private final static String SESSIONIDE = "ide";

	@RequestMapping("/list")
	public String search(ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "com.founder.rhip.hm.manage.search";
	}
	@RequestMapping("/tableList")
	public String searchTable(ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "com.founder.rhip.hm.manage.tableSearch";
	}
	@RequestMapping("/personRecord/export")
	public void exportPersonInfoList(HealthManageQueryForm form ,HttpServletRequest request, HttpServletResponse response) {
		String townCode = form.getTownCode();
		String centerCode = form.getCenterCode();
		String stationCode = form.getStationCode();
		final List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		final String examinationDateEnd = form.getExaminationDateEnd();
		final String examinationDateStart = form.getExaminationDateStart();
		if(StringUtil.isNotEmpty(stationCode)){
			form.setOrganCode(stationCode);
			form.setSelectCodeType("B2");
		}
		if(StringUtil.isNotEmpty(centerCode) && StringUtil.isNullOrEmpty(stationCode)){
			form.setOrganCode(centerCode);
			form.setSelectCodeType("B1");
		}
		if(StringUtil.isNotEmpty(townCode) && StringUtil.isNullOrEmpty(centerCode)){
			form.setOrganCode(townCode);
			form.setSelectCodeType("0");
		}
		form.setLogoff("0");
		final Criteria criteria = initCriteriaNew(form, request);
		      criteria.remove("orgCode");
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		excelExportService.exportListExecl("老年人员列表", ElderPersonInfoExcel.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				/*return personalRecordService.exportPersonRecordList(page, criteria, order);*/
				return physicalExamRecordService.exportPersonRecordList(orgCodes, page, criteria,examinationDateStart,examinationDateEnd);
			}
		});
	}
	@RequestMapping("/personRecord/exportTable")
	public void exportTable(final HealthManageQueryForm form ,HttpServletRequest request, HttpServletResponse response){

        String townCode = form.getTownCode();
        String centerCode = form.getCenterCode();
        String stationCode = form.getStationCode();
        final String examinationDateEnd = form.getExaminationDateEnd();
        final String examinationDateStart = form.getExaminationDateStart();

        if(StringUtil.isNotEmpty(stationCode)){
            form.setOrganCode(stationCode);
            form.setSelectCodeType("B2");
        }
        if(StringUtil.isNotEmpty(centerCode) && StringUtil.isNullOrEmpty(stationCode)){
            form.setOrganCode(centerCode);
            form.setSelectCodeType("B1");
        }
        if(StringUtil.isNotEmpty(townCode) && StringUtil.isNullOrEmpty(centerCode)){
            form.setOrganCode(townCode);
            form.setSelectCodeType("0");
        }
        final Criteria criteria = initCriteriaTable(form, request);

        criteria.add("record.exam_Status","1");
        criteria.add("he.PHYSICAL_EXAM_TYPE", "31");
        final String year=request.getParameter("examYear");

		/*List<PhysicalExamRecord> list = physicalExamRecordService.getPhysicalExamRecordList(criteria,examinationDateStart,examinationDateEnd);
		final List<Long> idList=new ArrayList<>();
		for(PhysicalExamRecord physicalExamRecord : list){
			idList.add(physicalExamRecord.getPersonId());
			}*/


        excelExportService.exportListExecl("老年人健康体检信息统计表", ElderPersonInfoTableExcel.class, response, new IDataSource() {
            @Override
            public List<Map<String, Object>> get(Page page) {
				/*return personalRecordService.exportPersonRecordList(page, criteria, order);*/
                return physicalExamRecordService.exportPhysiqueExaminationList(page,criteria,examinationDateStart,examinationDateEnd,year);
            }
        });
    }
	/**
	 * 查询体检记录
	 * @param form
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HealthManageQueryForm form, ModelMap model, HttpServletRequest request) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		String townCode = form.getTownCode();
		String centerCode = form.getCenterCode();
		String stationCode = form.getStationCode();
		String examinationDateEnd = form.getExaminationDateEnd();
		String examinationDateStart = form.getExaminationDateStart();

		if(StringUtil.isNotEmpty(stationCode)){
			form.setOrganCode(stationCode);
			form.setSelectCodeType("B2");
		}
		if(StringUtil.isNotEmpty(centerCode) && StringUtil.isNullOrEmpty(stationCode)){
			form.setOrganCode(centerCode);
			form.setSelectCodeType("B1");
		}
		if(StringUtil.isNotEmpty(townCode) && StringUtil.isNullOrEmpty(centerCode)){
			form.setOrganCode(townCode);
			form.setSelectCodeType("0");
		}
		form.setLogoff("0");
		Criteria criteria = initCriteriaNew(form, request);

		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		PageList<PhysicalExamRecord> list = physicalExamRecordService.getPhysicalExamRecordList(page, orgCodes, criteria,examinationDateStart,examinationDateEnd);
		for(PhysicalExamRecord physicalExamRecord : list.getList()){
			Criteria c = new Criteria();
			c.add("id",physicalExamRecord.getPersonId());
			PersonInfo personInfo = personInfoDao.get(c,new String[]{"HEALTH_FILE_NO","REMARKS"});
			if(ObjectUtil.isNotEmpty(personInfo)){
				physicalExamRecord.setHealthFileNo(personInfo.getHealthFileNo());
				physicalExamRecord.setRemarks(personInfo.getRemarks());
			}
		}
		model.addAttribute("physicalExamRecords", list.getList());
		model.addAttribute("page", list.getPage());
		return "com.founder.rhip.hm.manage.list";
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
		PhysicalExamRecord record = physicalExamRecordService.getPhysicalExamRecord(new Criteria("personId", personId));
		model.put("record", record);
		model.addAttribute("personInfo", personInfo);
		return "com.founder.rhip.hm.manage.perphylist";
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
		PhysicalExamRecord record = physicalExamRecordService.getPhysicalExamRecord(new Criteria("personId", personId));
		model.put("record", record);
		
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		Criteria criteria_temp = new Criteria("personId", personId);
		PageList<ElderlyPhyStatus> phys = elderlyPhyStatusDao.getPageList(page, criteria_temp, new Order("EXAMINATION_DATE desc"));
		
		model.addAttribute("phyList", phys.getList());
		model.addAttribute("page", phys.getPage());
		return "com.founder.rhip.hm.manage.perphylistresult";
	}
	
    @RequestMapping("/tableSearch")
    public String tableSearch(HealthManageQueryForm form, ModelMap model, HttpServletRequest request) {
        int currentPage = Integer.valueOf(request.getParameter("indexPage"));
        Page page = super.getPage(request, currentPage);
        String townCode = form.getTownCode();
        String centerCode = form.getCenterCode();
        String stationCode = form.getStationCode();
        String examinationDateEnd = form.getExaminationDateEnd();
        String examinationDateStart = form.getExaminationDateStart();

        if(StringUtil.isNotEmpty(stationCode)){
            form.setOrganCode(stationCode);
            form.setSelectCodeType("B2");
        }
        if(StringUtil.isNotEmpty(centerCode) && StringUtil.isNullOrEmpty(stationCode)){
            form.setOrganCode(centerCode);
            form.setSelectCodeType("B1");
        }
        if(StringUtil.isNotEmpty(townCode) && StringUtil.isNullOrEmpty(centerCode)){
            form.setOrganCode(townCode);
            form.setSelectCodeType("0");
        }
        Criteria criteria = initCriteriaTable(form, request);
//        criteria.add("record.exam_Status","1");
//        criteria.add("he.PHYSICAL_EXAM_TYPE", "31");
        String year="";
        if(ObjectUtil.isNotEmpty(request.getParameter("examYear"))){
            Date examYear = DateUtil.convert("yyyy", request.getParameter("examYear"));
            year = DateUtil.toFormatString("yyyy", examYear);
        }

        PageList<ElderlyPhyExamination> elderlyPhyExaminationList=new PageList<>();
        elderlyPhyExaminationList= physiqueExaminationService.getPhysiqueExaminationTableList(page,criteria,examinationDateStart,examinationDateEnd,year);

        // 大于60的老人
        if(ObjectUtil.isNotEmpty(elderlyPhyExaminationList)){
            for (int j = 0; j < elderlyPhyExaminationList.getList().size(); j++) {
                ElderlyPhyExamination elderlyPhyExamination=elderlyPhyExaminationList.getList().get(j);
                String str="";String str1="";
                if("1".equals(elderlyPhyExamination.getDietHunsuEquilibrium())){

                    str=str+"荤素均衡,";
                }if("2".equals(elderlyPhyExamination.getDietMeatMain())){

                    str=str+"荤食为主,";
                }if("3".equals(elderlyPhyExamination.getDietVegetarian())){

                    str=str+"素食为主,";
                }if("4".equals(elderlyPhyExamination.getDietHalophilic())){

                    str=str+"嗜盐,";
                }if("5".equals(elderlyPhyExamination.getDietAddictedOil())){

                    str=str+"嗜油,";
                }if("6".equals(elderlyPhyExamination.getDietSugarCravings())){

                    str=str+"嗜糖";
                }
                if(ObjectUtil.isNotEmpty(str)){
                    if(",".equals(str.substring(str.length()-1,str.length()))){
                        str=str.substring(0,str.length()-1);
                    }
                }
                if("1".equals(elderlyPhyExamination.getDrinkSpirit())){
                    str1=str1+"白酒,";
                }if("2".equals(elderlyPhyExamination.getDrinkBeer())){
                    str1=str1+"啤酒,";
                }if("3".equals(elderlyPhyExamination.getDrinkRedWine())){
                    str1=str1+"红酒,";
                }if("4".equals(elderlyPhyExamination.getDrinkYellowWine())){
                    str1=str1+"黄酒,";
                }if("5".equals(elderlyPhyExamination.getDrinkOther())){
                    str1=str1+"其他,"+elderlyPhyExamination.getDrinkOtherDesc();
                }
                elderlyPhyExamination.setDrinkSpirit(str1);


                elderlyPhyExamination.setDietHunsuEquilibrium(str);
                String str3="";
                if("1".equals(elderlyPhyExamination.getCvascularHemorrhageStroke())){
                    str3=str3+"缺血性卒中,";
                }if("1".equals(elderlyPhyExamination.getCvascularHemorrhage())){
                    str3=str3+"脑出血,";
                }if("1".equals(elderlyPhyExamination.getCvascularSah())){
                    str3=str3+"蛛网膜下腔出血";
                }if("1".equals(elderlyPhyExamination.getCovascularTransientIschemic())){
                    str3=str3+"短暂性脑缺血发作";
                }if("1".equals(elderlyPhyExamination.getCovascularOther())){
                    str3=str3+"其他,"+elderlyPhyExamination.getCvascularOtherDesc();
                }
                elderlyPhyExamination.setCvascularHemorrhageStroke(str3);
                String str4="";
                if("1".equals(elderlyPhyExamination.getKidneyDiabeticNephropathy())){
                    str4=str4+"糖尿病肾病,";
                }if("1".equals(elderlyPhyExamination.getKidneyRenalFailure())){
                    str4=str4+"肾功能衰竭,";
                }if("1".equals(elderlyPhyExamination.getKidneyAcuteNephritis())){
                    str4=str4+"急性肾炎,";
                }if("1".equals(elderlyPhyExamination.getKidneyChronicNephritis())){
                    str4=str4+"慢性肾炎,";
                }if("1".equals(elderlyPhyExamination.getKidneyOther())){
                    str4=str4+"其他,"+elderlyPhyExamination.getKidneyOtherDesc();
                }
                elderlyPhyExamination.setKidneyDiabeticNephropathy(str4);

                String str5="";
                if("1".equals(elderlyPhyExamination.getHeartMiocardialInfarction())){
                    str5=str5+"心肌梗死,";
                }if("1".equals(elderlyPhyExamination.getHeartAnginaPectoris())){
                    str5=str5+"心绞痛,";
                }if("1".equals(elderlyPhyExamination.getHeartCoronary())){
                    str5=str5+"冠状动脉血运重建,";
                }if("1".equals(elderlyPhyExamination.getHeartCongestiveHeart())){
                    str5=str5+"充血性心力,";
                }if("1".equals(elderlyPhyExamination.getHeartPrecordialPain())){
                    str5=str5+"心前区疼痛,";
                }if("1".equals(elderlyPhyExamination.getHeartOther())){
                    str5=str5+"其他,"+elderlyPhyExamination.getHeartOtherDesc();
                }

                elderlyPhyExamination.setHeartMiocardialInfarction(str5);

                String str6="";
                if("1".equals(elderlyPhyExamination.getArteryDissectingAneurysm())){
                    str6=str6+"夹层动脉瘤,";
                }if("1".equals(elderlyPhyExamination.getArteryPaod())){
                    str6=str6+"动脉闭塞性疾病,";
                }if("1".equals(elderlyPhyExamination.getArteryOther())){
                    str6=str6+"其他,"+elderlyPhyExamination.getArteryOtherDesc();
                }
                elderlyPhyExamination.setArteryDissectingAneurysm(str6);

                String str7="";
                if("1".equals(elderlyPhyExamination.getEyeRetinalOozing())){
                    str7=str7+"视网膜出血或者渗出,";
                }
                if("1".equals(elderlyPhyExamination.getEyeOpticPapilla())){
                    str7=str7+"视乳头水肿,";
                }if("1".equals(elderlyPhyExamination.getEyeCataract())){
                    str7=str7+"白内障,";
                }if("1".equals(elderlyPhyExamination.getEyeOther())){
                    str7=str7+"其他,"+elderlyPhyExamination.getEyeOtherDesc();
                }
                elderlyPhyExamination.setEyeRetinalOozing(str7);

				/*Criteria c = new Criteria();
				c.add("id",elderlyPhyExamination.getPersonId());
				PersonInfo personInfo = personInfoDao.get(c);*/
				/*if (ObjectUtil.isNotEmpty(personInfo.getBirthday())) {
					Calendar cal = Calendar.getInstance();
					int thisYear = cal.get(Calendar.YEAR);
					cal.setTime(personInfo.getBirthday());
					if (thisYear - cal.get(Calendar.YEAR) >= EHRConstants.SIXTY_ELDER) {
						model.addAttribute("isElder", true);
					}else if(thisYear - cal.get(Calendar.YEAR) < EHRConstants.SIXTY_ELDER){
						model.addAttribute("isYoung", true);
					}
				}*/
				/*if (ObjectUtil.isNotEmpty(personInfo.getPhoneNumber())){
					elderlyPhyExamination.setPhoneNumber(personInfo.getPhoneNumber());
				}*/
            }
            //------------------------------------------
            model.addAttribute("examinationList", elderlyPhyExaminationList.getList());
            model.addAttribute("page", elderlyPhyExaminationList.getPage());
        }else{
            model.addAttribute("examinationList", "");
            model.addAttribute("page", null);
        }


        return "com.founder.rhip.hm.manage.tableList";
    }

	/**
	 * 查看体检报告
	 * @param recordId
	 * @param model
	 * @return
	 */
	@RequestMapping("/report")
	public String viewReport(Long recordId, String operate, ModelMap model, HttpServletRequest request) {
		String examNumber = request.getParameter("examNumber");
		String personId = request.getParameter("personId");
		String type = EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode();
		Criteria recordCrt = new Criteria();
		recordCrt.add("personId",personId);
		if(StringUtil.isNotEmpty(request.getParameter("examNumber"))){
			recordCrt.add("physicalExamCode",examNumber);
		}
		recordCrt.add("physicalExamType",type);
		
		ElderlyPhyExamination examination = physiqueExaminationService.getPhysiqueExamination(recordCrt);
		HealthExamination healthExamination = healthExaminationService.getHealthExam(recordCrt);
		
		if (examination != null) {
			Criteria anomalyCrt = new Criteria("ehrId", examination.getEhrId());
			Criteria crt = new Criteria("isDelete", OP.IS, null).add(LOP.OR, "isDelete", OP.NE, 1);
			anomalyCrt.add(crt);
			List<HealthEvaluateAnomaly> anomalyList = physiqueExaminationService.getHealthEvaluateAnomaly(anomalyCrt);
			model.addAttribute("healthEvaluateAnomalyList", anomalyList);
		}
		
		model.addAttribute("physiqueExamination", examination);
		model.addAttribute("healthExamination", healthExamination);
		model.addAttribute("operate", operate);

		return "com.founder.rhip.hm.manage.physicalExamination";
	}

	/**
	 * 更新健康指导
	 * @param examination
	 * @param anomalyDesc
	 * @param examId
	 * @param examRecordId
	 * @return
	 */
	@RequestMapping("/healthGuide")
	@ResponseBody
	public int updateHealthGuide(ElderlyPhyExamination examination, String anomalyDesc, Long examId, Long examRecordId, String ehrId, HttpServletRequest request) {
		if (examId == null) {
			return 0;
		}
		int result = physiqueExaminationService.updateHealthGuide(examination, anomalyDesc, examId, examRecordId, ehrId);
		createOperationLog(request, RhipModuleName.HM_OLDMAN, "健康指导", OperationName.UPDATE);
		return result;

	}

	/**
	 * 更新自我评估
	 * @param examination
	 * @param examId
	 * @param examRecordId
	 * @return
	 */
	@RequestMapping("/selfAssessment")
	@ResponseBody
	public int updateAssessment(ElderlyPhyExamination examination, Long examId, Long examRecordId, HttpServletRequest request) {
		int result = physiqueExaminationService.updateSelfAssessment(examination, examId, examRecordId);
		createOperationLog(request, RhipModuleName.HM_OLDMAN, "自我评估", OperationName.UPDATE);
		return result;
	}

	private Criteria initCriteriaNew(HealthManageQueryForm form, HttpServletRequest request) {
        Criteria criteria = form.toCriteriaNew();
        if (!criteria.contains("inputOrganCode")) {
            Organization org = getCurrentOrg(request);
            if (hasRole(RoleType.ZXLNR, request) || hasRole(RoleType.ZX_GLY, request)) {
                List<String> orgCodes = this.getOrgsByOrgCode(org.getOrganCode());
                criteria.add("inputOrganCode", OP.IN, orgCodes);
            } else if (hasRole(RoleType.ZLNR, request) || hasRole(RoleType.Z_GLY, request)) {
                criteria.add("inputOrganCode", org.getOrganCode());
            }
        }
        return criteria;
    }
	
	private Criteria initCriteria(HealthManageQueryForm form, HttpServletRequest request) {
        Criteria criteria = form.toCriteria();
        if (!criteria.contains("inputOrganCode")) {
            Organization org = getCurrentOrg(request);
            if (hasRole(RoleType.ZXLNR, request)) {
                List<String> orgCodes = this.getOrgsByOrgCode(org.getOrganCode());
                criteria.add("inputOrganCode", OP.IN, orgCodes);
            } else if (hasRole(RoleType.ZLNR, request)) {
                criteria.add("inputOrganCode", org.getOrganCode());
            }
        }
        return criteria;
    }

	@RequestMapping(value = "/hasExam")
	@ResponseBody
	public String hasExam(@RequestParam("personId") Long personId,HttpServletRequest request, ModelMap model) {
		String hasExam ="";
		List<ElderlyPhyExamination> exams = phyExaminationService.getElderlyPhyExaminations(new Criteria("personId", personId), new Order("examination_date desc"), "examinationDate", "ehrId");
		if(!ObjectUtil.isNullOrEmpty(exams)){//若做过体检返回EhrId
			hasExam =exams.get(0).getEhrId();
		}
		return hasExam;
	}


		/**
         * 体检人员列表直接录入体检
         *
         * @param personId
         * @param request
         * @param model
         * @return
         */
	@RequestMapping(value = "/edit")
	public String addPhy(@RequestParam("personId") Long personId, Long isInfo, String ehrId,String loadPrePhyexamFlag,String editFlag,HttpServletRequest request, ModelMap model) {
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		ElderlyPhyExamination elderlyPhyExamination = null;
		if(StringUtil.isNotEmpty(ehrId)){//修改
			Criteria criteria = new Criteria("personId", personId);
	        criteria.add("ehrId", ehrId);
	        elderlyPhyExamination = examinationService.getPhyExamination(criteria);
		}
		// 女人
		if ("2".equals(personInfo.getGender())) {
			model.addAttribute("isWoman", true);
		}
		
		// 大于60的老人
		if (ObjectUtil.isNotEmpty(personInfo.getBirthday())) {
			Calendar cal = Calendar.getInstance();
			int thisYear = cal.get(Calendar.YEAR);
			cal.setTime(personInfo.getBirthday());
			if (thisYear - cal.get(Calendar.YEAR) >= EHRConstants.SIXTY_FIVE_ELDER) {
				model.addAttribute("isElder", true);
			}else if(thisYear - cal.get(Calendar.YEAR) < EHRConstants.SIXTY_FIVE_ELDER){
				model.addAttribute("isYoung", true);
			}
		}

		PersonalPhyExamDTO phyExamDTO = new PersonalPhyExamDTO();
		if (elderlyPhyExamination != null) {
			Criteria anomalyCrt = new Criteria("ehrId", elderlyPhyExamination.getEhrId());
			Criteria crt = new Criteria("isDelete", OP.IS, null).add(LOP.OR, "isDelete", OP.NE, 1);
			anomalyCrt.add(crt);
			List<HealthEvaluateAnomaly> anomalyList = physiqueExaminationService.getHealthEvaluateAnomaly(anomalyCrt);
			Criteria ca = new Criteria("personId", personId).add("ehrId",elderlyPhyExamination.getEhrId());
			/* 住院史新增 */
			List<HospitalizedHistory> hospitalizedHistoryList = hospitalizedHistoryDao.getList(ca);

			/* 家庭病床 */
			List<FamilyBedHistory> familyBedHistoryList = familyBedHistoryDao.getList(ca);
			if (null != familyBedHistoryList && familyBedHistoryList.size() > 0) {
				if (familyBedHistoryList.size() < 3) {
					for (int i = 0; i <= (3 - familyBedHistoryList.size()); i++)
						familyBedHistoryList.add(new FamilyBedHistory());
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
					for (int i = 0; i < total; i++)
						vaccinationInfoList.add(new VaccinationInfo());
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
					for (int i = 0; i <= (3 - hospitalizedHistoryList.size()); i++)
						hospitalizedHistoryList.add(new HospitalizedHistory());
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
				EchIdentification echIdentification = echIdentificationDao.get(new Criteria().add("id" ,elderlyPhyExamination.getIdentificationId()));
				model.put("echIdentification", echIdentification);
			}
			
			model.put("familyBedHistoryList",familyBedHistoryList);
			model.put("hospitalizedHistoryList",hospitalizedHistoryList);
			model.put("healthEvaluateAnomalyList", anomalyList);
			model.put("vaccinationInfoList", vaccinationInfoList);
			model.put("drugHistoryList",drugHistoryList);
		}
		if(ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			//CurrentLoginInfo currentLoginInfo=new CurrentLoginInfo();
			elderlyPhyExamination = this.initElderlyPhyExamination(personInfo, getCurrentOrg(request));
			elderlyPhyExamination.setManaDoctorId(((CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo")).getUser().getStaffCode());
		}else if(StringUtil.isNotEmpty(elderlyPhyExamination.getExamYear())){
		    elderlyPhyExamination.setExamYearDate(DateUtil.convert("yyyy", elderlyPhyExamination.getExamYear()));
		}
		model.put("phyExamDTO", phyExamDTO);
		if(StringUtil.isNotEmpty(loadPrePhyexamFlag)){//点击上一次体检信息按钮
			elderlyPhyExamination.setExaminationDate(new Date());
			elderlyPhyExamination.setPhysicalExamCode(null);
			elderlyPhyExamination.setId(null);
			elderlyPhyExamination.setEhrId(null);
		}
		if(StringUtil.isNotEmpty(editFlag)){
			model.put("editFlag", editFlag);
		}

		model.put("examination", elderlyPhyExamination);
		model.put("personInfo", personInfo);
		model.put("isInfo", isInfo);
		if(StringUtil.isNotEmpty(loadPrePhyexamFlag)){//点击上一次体检信息按钮
			return "com.founder.rhip.hm.manage.loadPrePhy";
		}
		return "com.founder.rhip.hm.manage.addPhy";
	}

	/**
	 * 体检人员列表直接查看体检
	 *
	 * @param personId
	 * @param request
	 * @param
	 * @return
	 */

	@RequestMapping("/addDepressed")
	public String addDepressed(HttpServletRequest request, ModelMap modelMap,Long personId, String physicalExamCode,String editflag,String sourceFlag,String ehrId) {
		String optionsData = "";
		PersonInfo personInfo = personInfoDao.getPersoninfo(personId);
		Criteria ca = new Criteria("personId", personId);
		ca.add("physicalExamCode", physicalExamCode);
		ca.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
		ElderlyPhyExamination elderlyPhyExamination = physiqueExaminationService.getPhysiqueExamination(ca);		
		if( ObjectUtil.isNotEmpty(elderlyPhyExamination)){
			if(ObjectUtil.isNotEmpty(elderlyPhyExamination.getEmotionScreenResultStr())){
				JSONArray jsonArray = JSONArray.fromObject(elderlyPhyExamination.getEmotionScreenResultStr());
				for (int i = 0; i < jsonArray.size(); i++) {
					optionsData += "option" + jsonArray.getJSONObject(i).get("optionNo") + "_" + jsonArray.getJSONObject(i).get("score") + ";";
				}
				modelMap.addAttribute("options", optionsData);
			}

		}
		modelMap.put("personInfo", personInfo);
		modelMap.put("personId", personId);
		modelMap.put("editflag", editflag);
		return "rhip.ehr.personalRecord.addDepressed";
	}

	@RequestMapping(value = "/view")
	public String view(Long personId, Long recordId, String physicalExamCode, String ehrId,HttpServletRequest request, ModelMap model,String status,String liciTiJianView) {
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
		if(StringUtil.isNotEmpty(ehrId)){
			criteria.add("ehrId", ehrId);
		}else if(StringUtil.isNotEmpty(physicalExamCode)){
			criteria.add("physicalExamCode", physicalExamCode);
		}
        ElderlyPhyExamination elderlyPhyExamination = examinationService.getPhyExamination(criteria);
        // 女人
		if ("2".equals(personInfo.getGender())) {
			model.addAttribute("isWoman", true);
		}
		// 大于60的老人
		if (ObjectUtil.isNotEmpty(personInfo.getBirthday())) {
			Calendar cal = Calendar.getInstance();
			int thisYear = cal.get(Calendar.YEAR);
			cal.setTime(personInfo.getBirthday());
			if (thisYear - cal.get(Calendar.YEAR) >= EHRConstants.SIXTY_ELDER) {
				model.put("isElder", true);
			}else if(thisYear - cal.get(Calendar.YEAR) < EHRConstants.SIXTY_ELDER){
				model.put("isYoung", true);
			}
		}

		PersonalPhyExamDTO phyExamDTO = new PersonalPhyExamDTO();
		if (elderlyPhyExamination != null) {
			if(ObjectUtil.isNotEmpty(elderlyPhyExamination.getIdentificationId())){
				EchIdentification echIdentification = echIdentificationDao.get(new Criteria().add("id" ,elderlyPhyExamination.getIdentificationId()));
				model.put("echIdentification", echIdentification);
			}
			if(StringUtil.isNotEmpty(elderlyPhyExamination.getExamYear())){
				elderlyPhyExamination.setExamYearDate(DateUtil.convert("yyyy", elderlyPhyExamination.getExamYear()));
			}

			Criteria anomalyCrt = new Criteria("ehrId", elderlyPhyExamination.getEhrId());
			Criteria crt = new Criteria("isDelete", OP.IS, null).add(LOP.OR, "isDelete", OP.NE, 1);
			anomalyCrt.add(crt);
			List<HealthEvaluateAnomaly> anomalyList = physiqueExaminationService.getHealthEvaluateAnomaly(anomalyCrt);
			Criteria ca = new Criteria("personId", personId).add("ehrId",elderlyPhyExamination.getEhrId());
			/* 住院史新增 */
			List<HospitalizedHistory> hospitalizedHistoryList = hospitalizedHistoryDao.getList(ca);

			List<FamilyBedHistory> familyBedHistoryList = familyBedHistoryDao.getList(ca);
			if (null != familyBedHistoryList && familyBedHistoryList.size() > 0) {
				if (familyBedHistoryList.size() < 3) {
					for (int i = 0; i <= (3 - familyBedHistoryList.size()); i++)
						familyBedHistoryList.add(new FamilyBedHistory());
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
					for (int i = 0; i < total; i++)
						vaccinationInfoList.add(new VaccinationInfo());
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
					for (int i = 0; i <= (3 - hospitalizedHistoryList.size()); i++)
						hospitalizedHistoryList.add(new HospitalizedHistory());
				}
				if(ObjectUtil.isNullOrEmpty(hospitalizedHistoryList.get(0).getInhosReason())){
					model.put("hospitalizedHistoryFlg", "0");
				}else{
					model.put("hospitalizedHistoryFlg", "1");
				}
			}else{
				model.put("hospitalizedHistoryFlg", "0");
			}

			model.put("familyBedHistoryList",familyBedHistoryList);
			model.put("hospitalizedHistoryList",hospitalizedHistoryList);
			model.put("healthEvaluateAnomalyList", anomalyList);
			model.put("vaccinationInfoList", vaccinationInfoList);
			model.put("drugHistoryList",drugHistoryList);
		}

		if (elderlyPhyExamination != null) {
			Criteria anomalyCrt = new Criteria("ehrId", elderlyPhyExamination.getEhrId());
			Criteria crt = new Criteria("isDelete", OP.IS, null).add(LOP.OR, "isDelete", OP.NE, 1);
			anomalyCrt.add(crt);
			List<HealthEvaluateAnomaly> anomalyList = physiqueExaminationService.getHealthEvaluateAnomaly(anomalyCrt);
			model.addAttribute("healthEvaluateAnomalyList", anomalyList);
			
			//卫计委角色查看页面-负责医生不能变成卫计委管理员
			if(StringUtil.isNotEmpty(elderlyPhyExamination.getManaDoctorId()) && hasRole(RoleType.ADMIN,request)){
				Staff staff = staffService.getStaff(elderlyPhyExamination.getManaDoctorId());
				model.put("staffName",staff.getName());
			}
		}

		model.put("phyExamDTO", phyExamDTO);
		model.put("status", status);
		model.put("examination", elderlyPhyExamination);
		model.put("personInfo", personInfo);
		model.put("liciTiJianView", liciTiJianView);//判断是否是历次体检查看
		return "com.founder.rhip.hm.manage.view";
	}

	/**
	 * 设置ElderlyPhyExamination的基本信息
	 * @param personInfo
	 * @param organization
	 * @return
	 */
	private ElderlyPhyExamination initElderlyPhyExamination(PersonInfo personInfo, Organization organization) {

		ElderlyPhyExamination elderlyPhyExamination = new ElderlyPhyExamination();
		// 覆盖人员相关信息
		elderlyPhyExamination.setPersonId(personInfo.getId());
		elderlyPhyExamination.setName(personInfo.getName());
		elderlyPhyExamination.setEhrId(null);
		if (null == elderlyPhyExamination.getExaminationDate()) {
			elderlyPhyExamination.setExaminationDate(new Date());
		}
		// 默认当前机构为体检机构
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationOrganCode())) {
			elderlyPhyExamination.setExaminationOrganCode(organization.getOrganCode());
		}
		return elderlyPhyExamination;
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
	public Object save(ElderlyPhyExamination elderlyPhyExamination, HttpServletRequest request, ModelMap model, Long physicalExamRecordId,String anomalyDesc) {
		PersonalPhyExamDTO personalPhyExamDTO = VoUtil.getFormData(request, PersonalPhyExamDTO.class);
		request.getParameter("emotionScreenResultStr");
		Map<Integer,String>  healthEvaluateAnomalyMap = new HashMap<Integer,String>();
		String healthAbnormal1 = request.getParameter("healthAbnormal1");
        String healthAbnormal2 = request.getParameter("healthAbnormal2");
        String healthAbnormal3 = request.getParameter("healthAbnormal3");
        String healthAbnormal4 = request.getParameter("healthAbnormal4");
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
		        elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
		    }
		    //体质辨识保存的session的key值
            String ideKey = SESSIONIDE + personInfo.getIdcard();
            EchIdentification identification = null;
            //新增、更新体质辨识相关
            updateIdentification(request, ideKey, elderlyPhyExamination, identification);
            
			Long id = elderlyPhyExamination.getId();

			if (ObjectUtil.isNullOrEmpty(id)) {
				physicalExamRecordService.savePhyExamination(personInfo, elderlyPhyExamination, getCurrentOrg(request), anomalyDesc);
				record(request, OperationName.ADD);
			} else {
				Assert.notNull(elderlyPhyExamination.getEhrId(), "事件id为空");
				physicalExamRecordService.updatePhyExamination(personInfo, elderlyPhyExamination);
				record(request, OperationName.UPDATE);
			}
			//调用慢病体检
			List<HospitalizedHistory> hospitalizedHistoryList=personalPhyExamDTO.getHospitalizedHistoryList();
			List<FamilyBedHistory> familyBedHistoryList=personalPhyExamDTO.getFamilyBedHistoryList();
			List<DrugHistory> drugHistoryList =personalPhyExamDTO.getDrugHistoryList();
			List<VaccinationInfo> vaccinationInfoList=personalPhyExamDTO.getVaccinationInfoList();
			PhysiqueExamination physiqueExamination = getPhyExamination(elderlyPhyExamination);
			personalPhyExamDTO.setPhysiqueExamination(physiqueExamination);
			phyExaminationService.savePhyExaminationFromEhrMeso(personalPhyExamDTO,elderlyPhyExamination, getCurrentOrg(request),getCurrentUser(request));
			
			//更新个人健康体检
			personalRecordManagmentService.savePhyExamFromElderly(getCurrentUser(request), getCurrentOrg(request),personInfo,physiqueExamination,tmpList,hospitalizedHistoryList,familyBedHistoryList,drugHistoryList,vaccinationInfoList,physiqueProp);
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
		if(elderlyPhyExamination.getOldIdentificationId() != elderlyPhyExamination.getIdentificationId()){
			identification = echManageService.updateEchIdentification(elderlyPhyExamination.getIdentificationId());
			elderlyPhyExamination.setTcmConclusion(ObjectUtil.isNotEmpty(identification)? identification.getTcmConclusion():null);
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
	 * 根据老年人体检信息获得个人体检表实体
	 * @param elderlyPhyExamination
	 * @return
	 * @throws Exception
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

	/**
	 * 删除体检
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public void delete(Long personId,String ehrId, String physicalExamCode, HttpServletRequest request, HttpServletResponse response) {
		boolean result = true;
		try {
			//删除老年人体检
			physicalExamRecordService.deleteByEhrId(personId, ehrId, physicalExamCode);
			//按体检编号删除慢病体检
			phyExaminationService.deleteElderlyPhyExamination(personId, null, physicalExamCode);
			
			//按体检编号删除个人体检----最后一条体检不可删除
			Criteria ca = new Criteria("personId", personId);
			List<PhysiqueExamination> phyExamList = physiqueExaminationDao.getList(ca);
            if(ObjectUtil.isNotEmpty(phyExamList) && phyExamList.size()>1){
            	User currentUser = getCurrentUser(request);
    			Organization organization = getCurrentOrg(request);
    			personalRecordManagmentService.deletePhysical(personId, null, currentUser, organization, getRequestIp(request), request.getRequestURI(),physicalExamCode);
            }	
            
			record(request, OperationName.DELETE);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			result = false;
		}
		MessageUtils.outputJSONResult(result? "success" : "fail", response);
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
		createOperationLog(request, RhipModuleName.HM_OLDMAN, getActionName(), op);
	}

    /**
     *  初始化统计条件
     * @param form
     * @param request
     * @return
     */
    private Criteria initCriteriaTable(HealthManageQueryForm form, HttpServletRequest request) {
        Criteria criteria = form.toCriteria();
        //criteria.add("confirm", 1);
        if (!criteria.contains("inputOrganCode")) {
            Organization org = getCurrentOrg(request);
            if (hasRole(RoleType.ZXLNR, request)) {
                List<String> orgCodes = this.getOrgsByOrgCode(org.getOrganCode());
                criteria.add("record.input_Organ_Code", OP.IN, orgCodes);
//				criteria.add("inputSuperOrganCode", org.getOrganCode());
            } else if (hasRole(RoleType.ZLNR, request)) {
                criteria.add("record.input_Organ_Code", org.getOrganCode());
            }
        }
        if(criteria.contains("inputOrganCode")==true){
            criteria.add("record.input_Organ_Code", criteria.get("inputOrganCode"));
            criteria.remove("inputOrganCode");
        }
        if (criteria.contains("idcard")==true) {
            criteria.add("record.IDCARD", request.getParameter("idcard"));
            criteria.remove("idcard");
        }
        if(criteria.contains("name")==true){
            criteria.add("record.name", request.getParameter("name"));
            criteria.remove("name");
        }if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
            criteria.add("record.GBCODE",getCurrentOrg(request).getGbCode());
        }if(criteria.contains("gbcode")==true){
            criteria.add("record.GBCODE",criteria.get("gbcode"));
            criteria.remove("gbcode");
        }
        return criteria;
    }

}
