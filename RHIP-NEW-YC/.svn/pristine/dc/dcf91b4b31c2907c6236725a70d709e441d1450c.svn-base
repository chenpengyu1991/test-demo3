package com.founder.rhip.ehr.controller.ehrbrowser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IHealthPalnService;
import com.founder.rhip.dref.controller.form.DualReferralQueryForm;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.HealthHistoryDTO;
import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalConsultationDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonMerge;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.Reception;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.ehr.repository.summary.TraumaHistoryDaoImpl;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IHealthHistoryService;
import com.founder.rhip.ehr.service.ILifeEventService;
import com.founder.rhip.ehr.service.IOutpatientService;
import com.founder.rhip.ehr.service.ISecrecyDegreeService;
import com.founder.rhip.ehr.service.personal.IPersonMergeService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.ta.IOutpatientInfoService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;

/**
 * 基本信息
 *
 * @author liuk
 */
@Controller
@RequestMapping("/ehrbrowser/basic")
public class BrwBasicController extends BaseController {
    @Autowired
    private IDictionaryApp dictionaryApp;

    @Resource(name = "personalRecordManagmentService")
    private IPersonalRecordManagmentService personalRecordManagmentService;

    @Autowired
    private IHealthHistoryService healthHistoryService;

    @Autowired
    private IHealthEventService healthEventService;

    @Autowired
    private IHealthPalnService healthPalnService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource
    private IDualReferralService dualReferralService;

    @Resource(name = "personalRecordService")
    private IPersonalRecordService personalRecordService;

    @Resource(name = "vaccineService")
    private IVaccinationReadService vaccineService;

    @Resource(name = "brwHealthService")
    private IBrwHealthService brwHealthService;

    @Resource(name = "lifeEventService")
	private ILifeEventService lifeEventService;

    @Autowired
    private IOutpatientInfoService outpatientInfoService;

    @Autowired
    private IOutpatientService outpatientService;
    
    @Resource(name = "personMergeService")
    private IPersonMergeService personMergeService;
    
    @Resource(name = "secrecyDegreeService")
    private ISecrecyDegreeService secrecyDegreeService;
    
    @RequestMapping()
    public String index(@RequestParam("personId") Long id, Model model, HttpServletRequest request) {
        // left 健康历史
/*        Criteria criteria = new Criteria();
        criteria.add("personId", id);
        HealthHistoryDTO healthHistoryDTO = healthHistoryService.getHealthHistory(criteria);
        model.addAttribute("healthHistoryDTO", healthHistoryDTO);*/
        Criteria criteria = new Criteria();
        criteria.add("personId", id);

        HealthHistoryDTO healthHistoryDTO = healthHistoryService.getHealthHistory(criteria,"disease");
        model.addAttribute("healthHistoryDTO", healthHistoryDTO);

        PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", id), "name", "birthday", "gender","idcard");
        model.addAttribute("personInfo", personInfo);
        //2015年06月05日 ,关联档案personId, modify by yejianfei
        PersonMerge personMerge = personMergeService.getPersonMerge(new Criteria("relationPersonId",id));
        if(ObjectUtil.isNullOrEmpty(personMerge)) {
            List<PersonInfo> personMerges = personMergeService.getMergePersonList(personInfo.getId());
            model.addAttribute("personMerges", personMerges);
        }else{
            PersonInfo mainPersonInfo = personalRecordService.getPersonRecord(new Criteria("id", personMerge.getPersonId()),"id","name");
            model.addAttribute("mainPersonInfo", mainPersonInfo);
        }
        model.addAttribute("viewType", request.getParameter("viewType")); // 判断页面是否显示返回按钮
        return "rhip.ehr.browser.basic";
    }

    /**
     * 健康档案首页-既往史-疾病
     * @param id
     * @param historyType disease(疾病),surgery(手术),drugAllergy(过敏),vaccinationInfo(接种),hospitalized(住院),transBlood(输血)
     * @param model
     * @return
     */
    @RequestMapping(value = "/healthHistory")
    public String healthHistory(@RequestParam("personId") Long id, String historyType,Model model) {
        Criteria criteria = new Criteria();
        criteria.add("personId", id);
        //页面加载时，默认加载的既往史
        if(StringUtil.isNullOrEmpty(historyType)){
            historyType = "disease";
        }
        HealthHistoryDTO healthHistoryDTO = healthHistoryService.getHealthHistory(criteria,historyType);
        model.addAttribute("healthHistoryDTO", healthHistoryDTO);
        return "rhip.ehr.browser.basic.healthHistory";
    }


    /**
     * 健康档案首页-既往史-分类加载
     * @param id
     * @param historyType  disease(疾病),surgery(手术),drugAllergy(过敏),vaccinationInfo(接种),hospitalized(住院),transBlood(输血)
     * @param model
     * @return
     */
    @RequestMapping(value = "/healthHistoryContent")
    public String healthHistoryContent(@RequestParam("personId") Long id, String historyType,Model model) {
        Criteria criteria = new Criteria();
        criteria.add("personId", id);
        if(StringUtil.isNullOrEmpty(historyType)){
            historyType = "disease";
        }
        HealthHistoryDTO healthHistoryDTO = healthHistoryService.getHealthHistory(criteria,historyType);
        model.addAttribute("healthHistoryDTO", healthHistoryDTO);
        return getHealthHistoryUrl(historyType);
    }

    /**
     * 既往史页面路径
     * @param historyType
     * @return
     */
    private String getHealthHistoryUrl(String historyType){
        String result = "";
        switch (historyType){
            case "disease":
                //疾病史
                result = "rhip.ehr.browser.basic.healthHistory.disease";
                break;
            case "surgery":
                //手术史
                result = "rhip.ehr.browser.basic.healthHistory.surgery";
                break;
            case "drugAllergy":
                //过敏史
                result = "rhip.ehr.browser.basic.healthHistory.drugAllergy";
                break;
            case "vaccinationInfo":
                //接种
                result = "rhip.ehr.browser.basic.healthHistory.vaccinationInfo";
                break;
            case "hospitalized":
                //住院
                result = "rhip.ehr.browser.basic.healthHistory.hospitalized";
                break;
            case "transBlood":
                //输血
                result = "rhip.ehr.browser.basic.healthHistory.transBlood";
                break;
        }
        return result;
    }


    @RequestMapping("/basicIndex")
    public String basicIndex(@RequestParam("personId") Long id, Model model, HttpServletRequest request){
        model.addAttribute("personId", id);
        PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", id));
        if (ObjectUtil.isNotEmpty(personInfo.getBirthday())) {
            Calendar cal = Calendar.getInstance();
            int thisYear = cal.get(Calendar.YEAR);
            cal.setTime(personInfo.getBirthday());
            if (thisYear - cal.get(Calendar.YEAR) <= EHRConstants.SIX_OLDER) {
                model.addAttribute("isChild", true);
            }
        }
        model.addAttribute("region", request.getParameter("region"));// 用在页面判断返回
        return "rhip.ehr.browser.basic.index";
    }

    @RequestMapping(value = "/cover")
    public String cover(Long personId, ModelMap model) {
        PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", personId));
        model.addAttribute("personInfo", personInfo);
        return "rhip.ehr.browser.basic.cover";
    }

    @RequestMapping(value = "/info")
    public String info(Long personId, ModelMap model) {
        PersonalBasicInfoDTO personBasicInfoDto = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", personId)));
        if(StringUtil.isNotEmpty(personBasicInfoDto.getFatherStrDesc())){
            model.addAttribute("fatherFlag", true);
        }
        if(StringUtil.isNotEmpty(personBasicInfoDto.getMotherStrDesc())){
            model.addAttribute("motherFlag", true);
        }
        if(StringUtil.isNotEmpty(personBasicInfoDto.getBrotherStrDesc())){
            model.addAttribute("brotherFlag", true);
        }
        if(StringUtil.isNotEmpty(personBasicInfoDto.getChildStrDesc())){
            model.addAttribute("childFlag", true);
        }
        model.addAttribute("personBasicInfoDto", personBasicInfoDto);
        return "rhip.ehr.browser.basic.info";
    }

    /***
     * 健康档案-体检页-更多体检查询个人体检表
     * @param personId
     * @param ehrId
     * @param model
     * @return
     */
    @RequestMapping(value = "/viewPhysicalExam")
    public String physicalExamination(Long personId, String ehrId,ModelMap model) {
        PersonalBasicInfoDTO personBasicInfoDto = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", personId)));
        model.addAttribute("personBasicInfoDto", personBasicInfoDto);
        PersonalPhyExamDTO personalPhyExamDTO = personalRecordManagmentService.getPersonalPhysical((new Criteria("id", personId)),ehrId);

        if (ObjectUtil.isNotEmpty(personalPhyExamDTO) && ObjectUtil.isNotEmpty(personalPhyExamDTO.getPersonInfo())) {
            //女人
            if ("2".equals(personalPhyExamDTO.getPersonInfo().getGender())) {
                model.addAttribute("isWoman", true);
            }

            //大于60的老人
            Calendar cal = Calendar.getInstance();
            int thisYear = cal.get(Calendar.YEAR);
            if (ObjectUtil.isNotEmpty(personalPhyExamDTO.getPersonInfo().getBirthday())) {
                cal.setTime(personalPhyExamDTO.getPersonInfo().getBirthday());
                if (thisYear - cal.get(Calendar.YEAR) >= EHRConstants.SIXTY_ELDER) {
                    model.addAttribute("isElder", true);
                }
            }
        }
        model.addAttribute("personalPhyExamDTO", personalPhyExamDTO);
        return "rhip.ehr.browser.basic.viewPhysicalExam";
    }

    @RequestMapping(value = "/physicalExamination")
    public String physicalExamination(Long personId, Boolean feedback,ModelMap model) {
        PersonalBasicInfoDTO personBasicInfoDto = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", personId)));
        model.addAttribute("personBasicInfoDto", personBasicInfoDto);
        PersonalPhyExamDTO personalPhyExamDTO = personalRecordManagmentService.getPersonalPhysical((new Criteria("id", personId)));

        if (ObjectUtil.isNotEmpty(personalPhyExamDTO) && ObjectUtil.isNotEmpty(personalPhyExamDTO.getPersonInfo())) {
            //女人
            if ("2".equals(personalPhyExamDTO.getPersonInfo().getGender())) {
                model.addAttribute("isWoman", true);
            }

            //大于60的老人
            Calendar cal = Calendar.getInstance();
            int thisYear = cal.get(Calendar.YEAR);
            if (ObjectUtil.isNotEmpty(personalPhyExamDTO.getPersonInfo().getBirthday())) {
                cal.setTime(personalPhyExamDTO.getPersonInfo().getBirthday());
                if (thisYear - cal.get(Calendar.YEAR) >= EHRConstants.SIXTY_ELDER) {
                    model.addAttribute("isElder", true);
                }
            }
        }
        model.addAttribute("personalPhyExamDTO", personalPhyExamDTO);
        //判断是否进入健康服务结论反馈表页面
        if(ObjectUtil.isNotEmpty(feedback) && feedback){
            return "rhip.ehr.healthevent.healthServiceFeedback";
        }else {
            return "rhip.ehr.browser.basic.physicalExamination";
        }
    }

    @RequestMapping(value = "/childFimalyInterview")
    public String childFimalyInterview(Long personId, ModelMap model) {
        PersonalBasicInfoDTO personBasicInfoDto = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", personId)));
        model.addAttribute("personBasicInfoDto", personBasicInfoDto);
        return "rhip.ehr.browser.basic.childFimalyInterview";
    }

    @RequestMapping(value = "/lifeEventDialog")
    public String lifeEventDialog(Long personId, ModelMap model) {
        model.addAttribute("lifeEventPersonId", personId);
        return "rhip.ehr.browser.basic.lifeEventDialog";
    }

    @RequestMapping(value = "/ehrDialogDetail")
    public String lifeEventDialogDetail(Long personId, String ehrId, ModelMap model) {

        return "rhip.ehr.browser.basic.lifeEventDialog";
    }

    @RequestMapping(value = "/lifeEvent")
    @ResponseBody
    public Object lifeEvent(Long personId,HttpServletRequest request) {
        Criteria criteria = new Criteria("personId", personId).add("ehrType", OP.NOTIN, new Object[]{EventType.PERSON_RECORD_COVER.getCode(), EventType.PERSON_RECORD_BASIC_INFO.getCode()});
        Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
        SecrecyDegreeSet secrecyDegreeSet = getSecrecyDegreeSet(request);
        //如果没有设置保密等级，默认不可见
        if(ObjectUtil.isNotEmpty(secrecyDegreeSet)){
            Integer degree = secrecyDegreeSet.getSecrecyDegree();
            //传染病保密等级中，1:可见，2：不可见
            if(Integer.valueOf(2).equals(degree)){
                criteria.add(limitc);
            }
        }else{
            criteria.add(limitc);
        }
        
        List<EHRHealthEvent> events = healthEventService.getEHRHealthEvents(criteria, "id", "ehrType", "clinicDate", "clinicOrganName");
        Map<String, List<Object[]>> result = new HashMap<>();
        //医疗服务
        for (EHRHealthEvent ehrHealthEvent : events) {
            String type = ehrHealthEvent.getEhrType();
            String typeNum;
            Object[] item = new Object[4];
            if (null != ehrHealthEvent.getClinicDate()) {
                item[0] = ehrHealthEvent.getClinicDate().getTime();
            }
            item[2] = ehrHealthEvent.getId();
            item[3] = ehrHealthEvent.getClinicOrganName();
            if (EventType.OUTPATIENT.getCode().equals(type)) {
                item[1] = 100000;
                typeNum = "10";
            } else if (EventType.INPATIENT.getCode().equals(type)) {
                item[1] = 200000;
                typeNum = "20";
            } else if (EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode().equals(type)) {
                item[1] = 300000;
                typeNum = "30";
            } else {
                continue;
            }
            addItemToResult(result, typeNum, item);
        }

        //高血压
        List<DMFollowupPlan> hbpFollows =  healthEventService.getLifeEventByFollowupPlans(personId, EHRConstants.DM_HBP_TYPE);
        for (DMFollowupPlan dmFollowupPlan : hbpFollows) {
            Object[] item = new Object[4];
            item[0] = null != dmFollowupPlan.getFollowupDate() ? dmFollowupPlan.getFollowupDate().getTime() : null;
            item[2] = dmFollowupPlan.getFollowupId();
            String organCode = dmFollowupPlan.getCreateOrganCode();
            item[3] = null == ObjectUtil.isNullOrEmpty(organCode) ? "" : organizationApp.queryOrganName(organCode);
            item[1] = 500000;
            addItemToResult(result, "50", item);
        }
 
        //糖尿病
        List<DMFollowupPlan> diFollows =  healthEventService.getLifeEventByFollowupPlans(personId, EHRConstants.DM_DI_TYPE);
        for (DMFollowupPlan dmFollowupPlan : diFollows) {
            Object[] item = new Object[4];
            item[0] = null != dmFollowupPlan.getFollowupDate() ? dmFollowupPlan.getFollowupDate().getTime() : null;
            item[2] = dmFollowupPlan.getFollowupId();
            String organCode = dmFollowupPlan.getCreateOrganCode();
            item[3] = null == ObjectUtil.isNullOrEmpty(organCode) ? "" : organizationApp.queryOrganName(organCode);
            item[1] = 600000;
            addItemToResult(result, "60", item);
        }

        //脑卒中
        List<DMFollowupPlan> strokeFollows =  healthEventService.getLifeEventByFollowupPlans(personId, EHRConstants.DM_STROKE_TYPE);
        for (DMFollowupPlan dmFollowupPlan : strokeFollows) {
            Object[] item = new Object[4];
            item[0] = null != dmFollowupPlan.getFollowupDate() ? dmFollowupPlan.getFollowupDate().getTime() : null;
            item[2] = dmFollowupPlan.getFollowupId();
            String organCode = dmFollowupPlan.getCreateOrganCode();
            item[3] = null == ObjectUtil.isNullOrEmpty(organCode) ? "" : organizationApp.queryOrganName(organCode);
            item[1] = 700000;
            addItemToResult(result, "70", item);
        }
        
        //冠心病
        List<DMFollowupPlan> coronaryFollows =  healthEventService.getLifeEventByFollowupPlans(personId, EHRConstants.DM_CORONARY_TYPE);
        for (DMFollowupPlan dmFollowupPlan : coronaryFollows) {
            Object[] item = new Object[4];
            item[0] = null != dmFollowupPlan.getFollowupDate() ? dmFollowupPlan.getFollowupDate().getTime() : null;
            item[2] = dmFollowupPlan.getFollowupId();
            String organCode = dmFollowupPlan.getCreateOrganCode();
            item[3] = null == ObjectUtil.isNullOrEmpty(organCode) ? "" : organizationApp.queryOrganName(organCode);
            item[1] = 800000;
            addItemToResult(result, "80", item);
        }
        
        //肿瘤
        List<DMFollowupPlan> tumorFollows =  healthEventService.getLifeEventByFollowupPlans(personId, EHRConstants.DM_TUMOR_TYPE);
        for (DMFollowupPlan dmFollowupPlan : tumorFollows) {
            Object[] item = new Object[4];
            item[0] = null != dmFollowupPlan.getFollowupDate() ? dmFollowupPlan.getFollowupDate().getTime() : null;
            item[2] = dmFollowupPlan.getFollowupId();
            String organCode = dmFollowupPlan.getCreateOrganCode();
            item[3] = null == ObjectUtil.isNullOrEmpty(organCode) ? "" : organizationApp.queryOrganName(organCode);
            item[1] = 900000;
            addItemToResult(result, "90", item);
        }

         //预防接种
        Criteria personIdCri = new Criteria("personId", personId);
        personIdCri.add("isDelete", EHRConstants.DELETE_FLG_0);
        List<VaccinationInfo> list = vaccineService.getVaccinationList(personIdCri,"id","vaccinationDate","vaccinationUnitName","immuUnitId");
        if (ObjectUtil.isNotEmpty(list)) {
            List<Object[]> items = new ArrayList<>();
            String typeNum = "100";
            result.put(typeNum, items);
            for (VaccinationInfo vaccinationInfo : list) {
                Object[] item = new Object[4];
                item[0] = null != vaccinationInfo.getVaccinationDate() ? vaccinationInfo.getVaccinationDate().getTime() : null;
                item[2] = vaccinationInfo.getId();
                item[3] =ObjectUtil.isNullOrEmpty(vaccinationInfo.getImmuUnitId())? vaccinationInfo.getVaccinationUnitName():organizationApp.queryOrganName(vaccinationInfo.getImmuUnitId());
                item[1] = 1000000;
                items.add(item);
            }
        }

        PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", personId));
		/*if(null == personInfo){
			return "rhip.ehr.browser.error";
		}*/
		//死亡记录中personId并不是必填项 所以此处用idcard关联
        personIdCri = new Criteria("IDCARD", personInfo.getIdcard());
        //死亡记录
        List<PersonDeathRecord> personDeathRecords= personalRecordService.getDeathPersonRecords(personIdCri,null,"deathDate","id","inputOrgancode");
        if (ObjectUtil.isNotEmpty(personDeathRecords)) {
            List<Object[]> items = new ArrayList<>();
            String typeNum = "110";
            result.put(typeNum, items);
            for (PersonDeathRecord personDeathRecord : personDeathRecords) {
                Object[] item = new Object[4];
                item[0] = null != personDeathRecord.getDeathDate() ? personDeathRecord.getDeathDate().getTime() : null;
                item[2] = personDeathRecord.getId();
                item[3] = organizationApp.queryOrganName(personDeathRecord.getInputOrgancode());
                item[1] = 1100000;
                items.add(item);
            }
        }
        personIdCri = new Criteria("personId", personId);
        //出生记录
        List<BirthCertificate> birthCertificates=   brwHealthService.getChBirthCertificateList(personIdCri, "id", "visaOrganName", "neonatalBirthday");
        if (ObjectUtil.isNotEmpty(birthCertificates)) {
            List<Object[]> items= new ArrayList<>();
            String typeNum = "120";
            result.put(typeNum, items);
            for (BirthCertificate birthCertificate : birthCertificates) {
                Object[] item = new Object[4];
                item[0] = null != birthCertificate.getNeonatalBirthday() ? birthCertificate.getNeonatalBirthday().getTime() : null;
                item[2] = birthCertificate.getId();
                item[3] = birthCertificate.getVisaOrganName();
                item[1] = 1200000;
                items.add(item);
            }
        }

        return result;
    }
    
    private void addItemToResult(Map<String, List<Object[]>> result, String typeNum, Object[] item) {
        if (result.containsKey(typeNum)) {
            List<Object[]> items = result.get(typeNum);
            items.add(item);
        } else {
            List<Object[]> items = new ArrayList<>();
            result.put(typeNum, items);
            items.add(item);
        }
    }
    
    /**
	 * 查询结果
	 * @param
	 * @param model
	 * @return
	 */
	@RequestMapping("/death/detail")
	public String personCancelDetail(String personId, ModelMap model){
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", personId));
		model.addAttribute("personDeathRecord", lifeEventService.query(new Criteria("idCard", personInfo.getIdcard())));
		return "rhip.ehr.personCancel.detail";
	}

    /**
     * 生命周期中预防接种页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/injectVaccine")
    public String injectVaccine(String id, Model model) {
    	Criteria cri = new Criteria();
    	cri.add("id", id);
    	List<VaccinationInfo> infoList = vaccineService.getVaccinationList(cri);
        if (ObjectUtil.isNotEmpty(infoList)) {
        	VaccinationInfo vaccinationInfo = infoList.get(0);
            model.addAttribute("vaccinationInfo", vaccinationInfo);
            String immuType = vaccinationInfo.getImmuType();
            if (EHRConstants.VACCINE_RABIES.equals(immuType)) {
                TraumaHistory traumaHistory = getTraumaHistory(vaccinationInfo.getEhrId());
                model.addAttribute("traumaHistory", traumaHistory);
                model.addAttribute("situation", "人用狂犬病疫苗接种情况");
            } else if (EHRConstants.VACCINE_HEPATITIS.equals(immuType)) {
                model.addAttribute("situation", "乙肝疫苗接种情况");
            } else if (EHRConstants.VACCINE_INFLUENZA.equals(immuType)) {
                model.addAttribute("situation", "流感疫苗接种情况");
            } else if (EHRConstants.VACCINE_PNEUMONIA.equals(immuType)) {
                model.addAttribute("situation", "23价肺炎疫苗接种情况");
            }
        }
        return "rhip.ehr.injectionVaccine.injectionInfo";
    }
 
    /**
     * 生命周期中个人体检页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/physicalExam")
    public String physicalExam(String id, ModelMap model) {
    	Criteria cri = new Criteria();
    	cri.add("id", id);
    	EHRHealthEvent event = healthEventService.getEHRHealthEvent(cri);
    	return physicalExamination(event.getPersonId(), event.getEhrId(), model);
    }
    
    /**
     * @Title: getTraumaHistory
     * @Description: 获取咬伤历史
     * @param @param ehrId
     * @param @return
     * @return TraumaHistory
     * @throws
     */
    private TraumaHistory getTraumaHistory(String ehrId){
    	Criteria cri = new Criteria();
    	cri.add("ehrId", ehrId);
    	cri.add("isDelete", OP.NE, 1);
    	TraumaHistory traumaHistory = vaccineService.getTraumaHistory(cri);

        // 将咬伤类型值付给其他
        traumaHistory.setHurtOther(traumaHistory.getHurtType());
        String tp = traumaHistory.getHurtType();

        if (!tp.equals("狗")) {
            if (!tp.equals("猫")) {
                if (!tp.equals("鼠")) {
                    traumaHistory.setHurtType("0");
                }
            }
        }
        return traumaHistory;
    }
    /**
     * 双向转诊
     * @param personId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/referralInfo")
    public String referralInfo(Long personId, ModelMap model, HttpServletRequest request){
        if(ObjectUtil.isNullOrEmpty(personId)){
            request.getSession().setAttribute("personId", ((PersonInfo) request.getSession().getAttribute("personInfo")).getId());
        }else{
            request.getSession().setAttribute("personId", personId);
        }
        return "rhip.ehr.browser.basic.referralInfo";
    }

    /**
     * 双向转诊列表  查询
     * @param model
     * @param request
     * @param indexPage
     * @param form
     * @return
     */
    @RequestMapping(value = "/referralInfoSearch")
    public String referralInfoSearch( ModelMap model, HttpServletRequest request, int indexPage , DualReferralQueryForm form){
        Page page = super.getPage(request, indexPage);
        Criteria criteria = form.toCriteria();
        criteria.add("personId", request.getSession().getAttribute("personId"));
        if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.YY_GLY, request)) {
            Organization currentOrgan = getCurrentOrg(request);
            Criteria ca = new Criteria("destDeptCode", currentOrgan.getOrganCode());
            ca.add(LOP.OR, "referralHospitalCode" , currentOrgan.getOrganCode());
            criteria.add(ca);
        }
        String requestUrlType = form.getRequestUrlType();
        request.getSession().removeAttribute("requestUrlType");
        PageList<ReferralInfo> list = dualReferralService.getPageList(page, criteria);
        model.addAttribute("referralList", list.getList());
        model.addAttribute("page", page);
        model.addAttribute("indexPage", indexPage);
        model.addAttribute("requestUrlType", requestUrlType);
        return "rhip.ehr.browser.basic.referralInfoList";
    }

    @RequestMapping( value = "/addReferralInfo")
    public  String addReferralInfo(HttpServletRequest request, ModelMap modelMap, String dualReferralType){
        ReferralInfo referralInfo = new ReferralInfo();
        String url = "rhip.ehr.browser.basic.referralInfo.add";
        PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute("personInfo");
        referralInfo.setName(personInfo.getName());
        if(ObjectUtil.isNullOrEmpty(personInfo.getIdcard())){
            referralInfo.setIdCard(personInfo.getOtherIdcard());
        }else {
            referralInfo.setIdCard(personInfo.getIdcard());
        }
        referralInfo.setPatientPhone(personInfo.getPhoneNumber());
        referralInfo.setGender(personInfo.getGender());
        if(ObjectUtil.isNotEmpty(personInfo.getIdcard())) {
        	referralInfo.setBirthday(DateUtil.parseSimpleDate(IDCardUtil.getBirthByIdCard(personInfo.getIdcard()),"yyyyMMdd"));
        }
        referralInfo.setAge(IDCardUtil.getAgeByIdCard(personInfo.getIdcard()));
        referralInfo.setDualReferralType(dualReferralType);
        referralInfo.setPersonId(personInfo.getId());
        referralInfo.setHealthFileNo(personInfo.getHealthFileNo());
        referralInfo.setDestDeptCode(getCurrentOrg(request).getOrganCode());
        referralInfo.setDestDeptName(getCurrentOrg(request).getOrganName());
        referralInfo.setFatownShip(personInfo.getPatownShip());
        referralInfo.setFastreet(personInfo.getPastreet());
        referralInfo.setFahouseNumber(personInfo.getPahouseNumber());
        referralInfo.setFaGroup(personInfo.getPaGroup());

        PersonInfo personinfo = (PersonInfo) request.getSession().getAttribute("personInfo");
        if (ObjectUtil.isNotEmpty(personinfo.getPatownShip())) {
            DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personinfo.getPatownShip());
            if (ObjectUtil.isNotEmpty(paDicItem1)) {
                modelMap.addAttribute("orgPaName", paDicItem1.getItemName());
            }
        }
        if (ObjectUtil.isNotEmpty(personinfo.getPastreet())) {
            DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personinfo.getPastreet());
            if (ObjectUtil.isNotEmpty(paDicItem2)) {
                modelMap.addAttribute("orgPaNamePastreet", paDicItem2.getItemName());
            }
        }

        url = "rhip.ehr.browser.basic.referralInfo.add";
        modelMap.addAttribute("referral", referralInfo);
        return  url;
    }

    /**
     * 转诊单查看
     * @param request
     * @param modelMap
     * @param id
     * @param operation
     * @return
     */
    @RequestMapping( value = "/referralInfoOperation")
    public  String operateReferralInfo(HttpServletRequest request, ModelMap modelMap, Long id, String operation,String requestUrlType){
        ReferralInfo referralInfo = dualReferralService.getReferralInfo(new Criteria("id", id));
        String url = "";
        if(ObjectUtil.equals("edit", operation)) {
            if (ObjectUtil.isNotEmpty(referralInfo.getFatownShip())) {
                DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", referralInfo.getFatownShip());
                if (ObjectUtil.isNotEmpty(paDicItem1)) {
                    modelMap.addAttribute("orgPaName", paDicItem1.getItemName());
                }
            }
            if (ObjectUtil.isNotEmpty(referralInfo.getFastreet())) {
                DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", referralInfo.getFastreet());
                if (ObjectUtil.isNotEmpty(paDicItem2)) {
                    modelMap.addAttribute("orgPaNamePastreet", paDicItem2.getItemName());
                }
            }
            url = "rhip.ehr.browser.basic.referralInfo.add";
        }else {
            modelMap.addAttribute("requestUrlType", requestUrlType);
            url = "rhip.ehr.browser.basic.referralInfo.view";
        }
        modelMap.addAttribute("referral", referralInfo);
        return  url;
    }

    /**
     * 转诊单删除
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/deleteReferralInfo")
    @ResponseBody
    public ModelMap deleteReferralInfo(HttpServletRequest request, Long id) {
        ModelMap modelMap = new ModelMap();
        ReferralInfo referralInfo = new ReferralInfo();
        referralInfo.setId(id);
        try {
            int result = dualReferralService.delete(referralInfo);
            if (result != 0) {
                modelMap.addAttribute("success", true);
                modelMap.addAttribute("message", "删除成功！");
            } else {
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("message", "删除失败！");
            }
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "删除失败！" + e.getMessage());
        }
        return modelMap;
    }

    /**
     * 转诊单保存
     * @param request
     * @param referralInfo
     * @param from
     * @return
     */
    @RequestMapping("/saveReferralInfo")
    @ResponseBody
    public ModelMap save(HttpServletRequest request, ReferralInfo referralInfo, String from ) {
        ModelMap modelMap = new ModelMap();
        referralInfo.setIsDelete(0);
        referralInfo.setIntegratedData(0);
        //转诊状态 0：未接诊
        referralInfo.setReferralStatus(0);
        //转诊来源 2：平台
        referralInfo.setReferralSource(2);
        //转诊唯一码 18位唯一码
        if(ObjectUtil.isNullOrEmpty(referralInfo.getId())){
            referralInfo.setReferralCode(getReferralCode());
            referralInfo.setDestDeptCode(getCurrentOrg(request).getOrganCode());
            referralInfo.setDestDeptName(getCurrentOrg(request).getOrganName());
        }
        referralInfo.setUpdateOrgan(getCurrentOrg(request).getOrganCode());
        referralInfo.setUpdatePerson(getCurrentUser(request).getUserCode());
        referralInfo.setUpdateTime(new Date());
        try {
            int result = dualReferralService.save(referralInfo);
            if (result != 0) {
                modelMap.addAttribute("success", true);
                modelMap.addAttribute("message", "保存成功！");
            } else {
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("message", "保存失败！");
            }
            modelMap.addAttribute("id", result);
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "保存失败！" + e.getMessage());
        }
        return modelMap;
    }

    /***
     * 生成18位转诊唯一码
     * @return
     */
    private String getReferralCode() {
        long current = System.currentTimeMillis();
        String k  =String.valueOf(current);
        int length = 5;
        for (int i = 0; i < length; i++) {
            int temp = (int) (Math.random() * 9);
            k = k + temp;
        }
        return k;
    }

    /**
     * 接诊记录表
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping(value = "/reception")
    public String receptionView(Long personId, String ehrId, ModelMap model) {
        PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", personId));
        model.addAttribute("personInfo", personInfo);

        Criteria criteria = new Criteria("personId", personId);
        criteria.add("ehrId", ehrId);
        Reception reception = new Reception();

        //主观资料，接诊日期，管理医生
        List<OutpatientInfo> outpatientInfos = outpatientInfoService.getOutpatientInfoLists(criteria);
        if (ObjectUtil.isNotEmpty(outpatientInfos)){
            reception.setSubjectiveData(outpatientInfos.get(0).getChiefComplaint());
            reception.setReceptionDate(outpatientInfos.get(0).getClinicDate());
            reception.setManageDoctorName(outpatientInfos.get(0).getManaDoctorName());
        }

        //处方
        OutpatientReportDTO outpatientReportDTO = outpatientService.getOutpatientDrugDetail(criteria);

        //评估
        criteria.add("opEmHpMark","1");
        List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos = healthEventService.getDiseaseDiagnosisInfoList(criteria);
        String assessment = "";
        for (int i = 0; i < diseaseDiagnosisInfos.size() ; i++){
            assessment += diseaseDiagnosisInfos.get(i).getDiseaseName();
            if (i < diseaseDiagnosisInfos.size() - 1 ){
                assessment += "，";
            }
        }
        reception.setAssessment(assessment);

        //客观资料
        criteria = new Criteria("personId", personId);
        criteria.add("ehrId", ehrId);
        criteria.add("opEmInExMark","1");
        List<StudyEvent> studyEvents = healthEventService.getStudyEventList(criteria);
        criteria = new Criteria("personId", personId);
        criteria.add("ehrId", ehrId);
        criteria.add("opEmHpExMark","1");
        List<ExamineEvent> examineEvents = healthEventService.getExamineEventList(criteria);

        model.addAttribute("reception", reception);
        model.addAttribute("studyEvents", studyEvents);
        model.addAttribute("examineEvents", examineEvents);
        model.addAttribute("outpatientReportDTO", outpatientReportDTO);
        return "rhip.ehr.browser.reception";
    }

    /**
     * 会诊记录表
     */
    @RequestMapping(value = "/consultation")
    public String consultation(Long personId, ModelMap model) {
        PersonInfo personInfo = personalRecordManagmentService.getPersonalCover(new Criteria("id", personId));
        model.addAttribute("personInfo", personInfo);
        model.addAttribute("isView","Y");
        PersonalConsultationDTO personalConsultationDTO = (PersonalConsultationDTO) personalRecordManagmentService.getPersonalConsultationDto(personInfo.getId());

        if(ObjectUtil.isNullOrEmpty(personalConsultationDTO.getConsultations())){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("PersonalConsultationDTO", personalConsultationDTO);
        return "rhip.ehr.browser.basic.consultation";
    }

    /**
     * 接诊记录表列表
     */
    @RequestMapping("/getReceptionDate")
    public String getReception(Long personId, ModelMap model) {

            List<OutpatientInfo> outpatientInfos = outpatientInfoService.getDistinctList(new Criteria("personId", personId), new Order("CLINIC_DATE",false));
            model.addAttribute("outpatientInfos", outpatientInfos);
            return "rhip.ehr.browser.receptionList";
    }
    
    
    /**
     * 获取当前机构的传染病保密登记设置
     * @param request
     * @return
     */
    private SecrecyDegreeSet getSecrecyDegreeSet(HttpServletRequest request){
        Organization currentOrg = getCurrentOrg(request);
        String organCode = "";
        if(ObjectUtil.isNullOrEmpty(currentOrg)){
            Map<String, String>  explorerInfo = (HashMap)request.getSession().getAttribute("explorerInfo");
            organCode = explorerInfo.get("viewOrganCode");
        }else{
            organCode = getCurrentOrg(request).getOrganCode();
        }
        Criteria criteria = new Criteria("ORGAN_CODE",organCode);
        return  secrecyDegreeService.getSecrecyDegree(criteria);
    }

}