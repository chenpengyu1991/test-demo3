package com.founder.rhip.ehr.service.modifytrace.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;

import com.founder.fasf.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.annotation.RecordTrace;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.ModifyTrace;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.summary.DeformityHistory;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.ExposeHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.FamilyHeredityHistory;
import com.founder.rhip.ehr.entity.summary.FamilyHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.entity.summary.SurgeryHistory;
import com.founder.rhip.ehr.entity.summary.TransBloodHistory;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.ehr.repository.basic.IModifyTraceDao;
import com.founder.rhip.ehr.service.IModifyTraceService;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;

@Service("modifyTraceService")
public class ModifyTraceServiceImpl implements IModifyTraceService {
	
	@Autowired
	private IModifyTraceDao modifyTraceDao;
	
	@Autowired
	private IPersonalRecordManagmentService personalRecordManagmentService;
	
	@Resource
	private IDictionaryApp dictionaryApp;
	
	@Autowired
	private IEhrSecurityService ehrSecurityService;


    @Override
    public void executeCover(PersonInfo newPersonInfo, String[] properties) {
        if (newPersonInfo == null) {
            return;
        }
        Long personId = newPersonInfo.getId();
        Criteria criteria = new Criteria("id", personId);
        PersonInfo oldPersonInfo = personalRecordManagmentService.getPersonalCover(criteria);

        List<ModifyTrace> modifyTraceList = new ArrayList<>();

        String regionType = EventType.PERSON_RECORD_COVER.getCode();
        String regionName = "个人档案封面";
        String inputName = newPersonInfo.getInputName();
        String inputerId = newPersonInfo.getInputerId();
        String inputOrg = newPersonInfo.getInputOrganName();
        String inputOrganCode = newPersonInfo.getInputOrganCode();
        if (StringUtil.isEmpty(inputName)){
            inputName = newPersonInfo.getUpdateName();
        }
        if (StringUtil.isEmpty(inputerId)){
            inputerId = newPersonInfo.getUpdateIdcard();
        }
        if (StringUtil.isEmpty(inputOrg)){
            inputOrg = newPersonInfo.getUpdateOrganName();
        }
        if (StringUtil.isEmpty(inputOrganCode)){
            inputOrganCode = newPersonInfo.getUpdateOrganCode();
        }

        modifyTraceList.addAll(CompareUtil.compare(regionType,regionName,PersonInfo.class, properties, oldPersonInfo, newPersonInfo,personId,inputerId, inputName,inputOrganCode, inputOrg));
        modifyTraceDao.batchInsert(modifyTraceList);
    }

	@Override
	@Transactional
	public void executeBasicInfo(PersonalBasicInfoDTO newPersonalBasicInfoDTO) {
        if (newPersonalBasicInfoDTO == null) return;
		Criteria criteria = new Criteria("id", newPersonalBasicInfoDTO.getPersonInfo().getId());
		PersonalBasicInfoDTO oldPersonalBasicInfoDTO = personalRecordManagmentService.getPersonalBasicInfo(criteria);
		
		List<ModifyTrace> modifyTraceList = new ArrayList<>();
		Long personId = newPersonalBasicInfoDTO.getPersonInfo().getId();
		String regionType = EventType.PERSON_RECORD_BASIC_INFO.getCode();
		String regionName = "个人基本信息表";
		String inputName = newPersonalBasicInfoDTO.getModifyInputName();
		String inputerId = newPersonalBasicInfoDTO.getModifyInputerId();
		String inputOrg = newPersonalBasicInfoDTO.getModifyInputOrg();
		String inputOrganCode = newPersonalBasicInfoDTO.getModifyInputOrganCode();
		//人员基本信息比较
		modifyTraceList.addAll(CompareUtil.compare(regionType,regionName,PersonInfo.class, oldPersonalBasicInfoDTO.getPersonInfo(), newPersonalBasicInfoDTO.getPersonInfo(),personId,inputerId, inputName,inputOrganCode, inputOrg));
		//医疗费用支付方式比较
		CompareUtil.compare(modifyTraceList,regionType,regionName,null, "医疗费用支付方式", getDictValueByCode("CV0710003", oldPersonalBasicInfoDTO.getExpenseInfoStr()), getDictValueByCode("CV0710003", newPersonalBasicInfoDTO.getExpenseInfoStr()), personId,inputerId, inputName,inputOrganCode, inputOrg);
		//药物过敏史
		modifyTraceList.addAll(CompareUtil.compare(regionType,regionName, "药物过敏史", DrugAllergyHistory.class,oldPersonalBasicInfoDTO.getDrugAllergyHistoryFlag(),newPersonalBasicInfoDTO.getDrugAllergyHistoryFlag(), getDictValueByCode("CV0501038",oldPersonalBasicInfoDTO.getDrugAllergyHistoryStr()), getDictValueByCode("CV0501038",newPersonalBasicInfoDTO.getDrugAllergyHistoryStr()), personId,inputerId, inputName,inputOrganCode, inputOrg));
		//暴露史
		if(ObjectUtil.isNotEmpty(newPersonalBasicInfoDTO.getExposeHistory())){
			modifyTraceList.addAll(CompareUtil.compare(regionType,regionName, "暴露史", ExposeHistory.class, oldPersonalBasicInfoDTO.getExposeHistoryFlag(),newPersonalBasicInfoDTO.getExposeHistory().getExposeFlag(),oldPersonalBasicInfoDTO.getExposeHistory(),newPersonalBasicInfoDTO.getExposeHistory(),personId,inputerId, inputName,inputOrganCode, inputOrg));
		}
		//既往疾病史
		modifyTraceList.addAll(CompareUtil.diseaseHistoryModifyTrace(regionType,regionName,oldPersonalBasicInfoDTO, newPersonalBasicInfoDTO, personId,inputerId, inputName,inputOrganCode, inputOrg));
		//手术
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "既往史-手术", SurgeryHistory.class, oldPersonalBasicInfoDTO.getSurgeryHistoryFlag(), newPersonalBasicInfoDTO.getSurgeryHistoryFlag(), oldPersonalBasicInfoDTO.getSurgeryHistoryList(), newPersonalBasicInfoDTO.getSurgeryHistoryList(), personId,inputerId, inputName,inputOrganCode, inputOrg));
		//外伤
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "既往史-外伤", TraumaHistory.class, oldPersonalBasicInfoDTO.getTraumaHistoryFlag(), newPersonalBasicInfoDTO.getTraumaHistoryFlag(), oldPersonalBasicInfoDTO.getTraumaHistoryList(), newPersonalBasicInfoDTO.getTraumaHistoryList(), personId,inputerId, inputName,inputOrganCode, inputOrg));
		//输血
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "既往史-输血", TransBloodHistory.class, oldPersonalBasicInfoDTO.getTransBloodHistoryFlag(), newPersonalBasicInfoDTO.getTransBloodHistoryFlag(), oldPersonalBasicInfoDTO.getTransBloodHistoryList(), newPersonalBasicInfoDTO.getTransBloodHistoryList(), personId,inputerId, inputName,inputOrganCode, inputOrg));
		//家族史-父亲
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "家族史-父亲", FamilyHistory.class, oldPersonalBasicInfoDTO.getFatherFlag(),newPersonalBasicInfoDTO.getFatherFlag(), getDictValueByCode("FS10240", oldPersonalBasicInfoDTO.getFatherStr()),getDictValueByCode("FS10240", newPersonalBasicInfoDTO.getFatherStr()),personId,inputerId, inputName,inputOrganCode, inputOrg));
		//家族史-母亲
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "家族史-母亲", FamilyHistory.class, oldPersonalBasicInfoDTO.getMotherFlag(),newPersonalBasicInfoDTO.getMotherFlag(), getDictValueByCode("FS10240", oldPersonalBasicInfoDTO.getMotherStr()),getDictValueByCode("FS10240", newPersonalBasicInfoDTO.getMotherStr()),personId,inputerId, inputName,inputOrganCode, inputOrg));
		//家族史-兄弟姐妹
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "家族史-兄弟姐妹", FamilyHistory.class, oldPersonalBasicInfoDTO.getBrotherFlag(),newPersonalBasicInfoDTO.getBrotherFlag(), getDictValueByCode("FS10240", oldPersonalBasicInfoDTO.getBrotherStr()),getDictValueByCode("FS10240", newPersonalBasicInfoDTO.getBrotherStr()),personId,inputerId, inputName,inputOrganCode, inputOrg));
		//家族史-子女
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "家族史-子女", FamilyHistory.class, oldPersonalBasicInfoDTO.getChildFlag(),newPersonalBasicInfoDTO.getChildFlag(), getDictValueByCode("FS10240", oldPersonalBasicInfoDTO.getChildStr()),getDictValueByCode("FS10240", newPersonalBasicInfoDTO.getChildStr()),personId,inputerId, inputName,inputOrganCode, inputOrg));
		//遗传病史
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "遗传病史", FamilyHeredityHistory.class, oldPersonalBasicInfoDTO.getFamilyHeredityHistoryFlag(), newPersonalBasicInfoDTO.getFamilyHeredityHistoryFlag(), oldPersonalBasicInfoDTO.getFamilyHeredityHistoryList(), newPersonalBasicInfoDTO.getFamilyHeredityHistoryList(), personId,inputerId, inputName,inputOrganCode, inputOrg));
		if(ObjectUtil.isNotEmpty(oldPersonalBasicInfoDTO.getDeformityFlag()) && ObjectUtil.isNotEmpty(newPersonalBasicInfoDTO.getDeformityHistory())){
			//残疾情况
			modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "残疾情况", "otherDesc", DeformityHistory.class, oldPersonalBasicInfoDTO.getDeformityFlag(),newPersonalBasicInfoDTO.getDeformityHistory().getDeformityFlag(),oldPersonalBasicInfoDTO.getDeformityHistory(),newPersonalBasicInfoDTO.getDeformityHistory(),personId,inputerId, inputName,inputOrganCode, inputOrg));
		}
		
		modifyTraceDao.batchInsert(modifyTraceList);
	}
	
	private String getDictValueByCode(String dicmeta,String code)
	{
		if(code != null)
		{
			String[] args = code.split(",");
			StringBuffer sb = new StringBuffer();
			for(String str:args)
			{
				DicItem dicItem = dictionaryApp.queryDicItem(dicmeta, str);
				if(ObjectUtil.isNotEmpty(dicItem)){
					sb.append(dicItem.getItemName() + ",");
				}
			}
			if(sb.length() >0){
				return sb.toString().substring(0,sb.toString().length()-1);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void executePhyExam(PersonalPhyExamDTO newPersonalPhyExamDTO) {
        if (null == newPersonalPhyExamDTO) return;
		Criteria criteria = new Criteria("id", newPersonalPhyExamDTO.getPersonInfo().getId());
		PersonalPhyExamDTO oldPersonalPhyExamDTO = (PersonalPhyExamDTO)personalRecordManagmentService.getPersonalPhysical(criteria);
		
		List<ModifyTrace> modifyTraceList = new ArrayList<>();
		Long personId = newPersonalPhyExamDTO.getPersonInfo().getId();
		String regionType = EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode();
		String regionName = "个人健康体检表";
		PhysiqueExamination oldObj = oldPersonalPhyExamDTO.getPhysiqueExamination();
		PhysiqueExamination newObj = newPersonalPhyExamDTO.getPhysiqueExamination();
		String inputName = newPersonalPhyExamDTO.getModifyInputName();
		String inputerId = newPersonalPhyExamDTO.getModifyInputerId();
		String inputOrg = newPersonalPhyExamDTO.getModifyInputOrg();
		String inputOrganCode = newPersonalPhyExamDTO.getModifyInputOrganCode();
        if(oldObj == null) {
            oldObj = new PhysiqueExamination();
        }

        if(newObj == null) {
            return;
        }
		
		if(ObjectUtil.isNotEmpty(ehrSecurityService.getUser(oldObj.getManaDoctorId())) && ObjectUtil.isNotEmpty(ehrSecurityService.getUser(newObj.getManaDoctorId()))){
			String oldUserName = ehrSecurityService.getUser(oldObj.getManaDoctorId()).getName();
			String newUserName = ehrSecurityService.getUser(newObj.getManaDoctorId()).getName();
			//责任医师ID转责任医师姓名
			addModifyTraceNest(modifyTraceList, CompareUtil.getManaDoctorName(regionType, regionName, null, "责任医师姓名", oldUserName, newUserName, personId,inputerId, inputName,inputOrganCode, inputOrg));
		}
		//体检信息比较
		modifyTraceList.addAll(CompareUtil.compare(regionType,regionName,PhysiqueExamination.class, oldPersonalPhyExamDTO.getPhysiqueExamination(), newPersonalPhyExamDTO.getPhysiqueExamination(),personId,inputerId,inputName,inputOrganCode,inputOrg));
		//责任医师ID转责任医师姓名
//		addModifyTraceNest(modifyTraceList, )
		//症状
		String[] zz = {"symptomHeadache","symptomDizzy","symptomPalpitations","symptomChestTightness","symptomChestPain","symptomChronicCough","symptomCough","symptomDyspnea","symptomPolydipsia",
				"symptomPolyuria","symptomWeightLoss","symptomFatigue","symptomJointPain","symptomBlurredVision","symptomNumbness","symptomUrgency","symptomDysuria","symptomConstipation","symptomDiarrhea",
				"symptomNauseaVomiting","symptomVertigo","symptomTinnitus","symptomBreastTenderness","symptomOther","symptomOtherDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "症状", oldObj.getSymptomFlag(), newObj.getSymptomFlag(), "无症状",zz, PhysiqueExamination.class, oldObj, newObj, personId,inputerId,inputName,inputOrganCode,inputOrg));
		//饮食习惯
		String[] ysxg = {"dietHunsuEquilibrium","dietMeatMain","dietVegetarian","dietHalophilic","dietAddictedOil","dietSugarCravings"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "饮食习惯", CompareUtil.HAVE, CompareUtil.HAVE,"",ysxg, PhysiqueExamination.class, oldObj, newObj, personId,inputerId,inputName,inputOrganCode,inputOrg));
		//饮酒种类
		String[] yjzl = {"drinkSpirit","drinkBeer","drinkRedWine","drinkYellowWine","drinkOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "饮酒种类", CompareUtil.HAVE, CompareUtil.HAVE,"", yjzl, PhysiqueExamination.class, oldObj, newObj, personId,inputerId,inputName,inputOrganCode,inputOrg));
		//眼底
		String[] yd = {"fundusOculiAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "眼底", oldObj.getFundusOculiAnomalyFlag(), newObj.getFundusOculiAnomalyFlag(), "正常",yd, PhysiqueExamination.class,oldObj, newObj,  personId ,inputerId,inputName,inputOrganCode,inputOrg));
		//皮肤
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceBySingleColumn(regionType, regionName, null, "皮肤", oldObj.getSkinCheckResult(), newObj.getSkinCheckResult(), "skinCheckResult", "skinCheckDesc", PhysiqueExamination.class, oldObj, newObj, personId ,inputerId,inputName,inputOrganCode,inputOrg));
		//巩膜
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceBySingleColumn(regionType, regionName, null, "巩膜", oldObj.getScleraCheckResult(), newObj.getScleraCheckResult(), "scleraCheckResult", "scleraCheckDesc", PhysiqueExamination.class, oldObj, newObj, personId ,inputerId,inputName,inputOrganCode,inputOrg));
		//淋巴结
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceBySingleColumn(regionType, regionName, null, "淋巴结", oldObj.getLymphNodeCheckResult(), newObj.getLymphNodeCheckResult(), "lymphNodeCheckResult", "lymphNodeCheckDesc", PhysiqueExamination.class, oldObj, newObj, personId ,inputerId,inputName,inputOrganCode,inputOrg));
		//呼吸音
		String[] hxy = {"lungsAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "呼吸音", oldObj.getLungsAnomalySound(), newObj.getLungsAnomalySound(), "正常",hxy, PhysiqueExamination.class,oldObj, newObj,  personId ,inputerId,inputName,inputOrganCode,inputOrg));
		//罗音
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceBySingleColumn(regionType, regionName, null, "罗音", oldObj.getLungsRaleFlag(), newObj.getLungsRaleFlag(), "lungsRaleFlag", "lungsRaleDesc", PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//杂音
		String[] zy = {"heartMurmurDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "杂音（次/分钟）", oldObj.getHeartMurmurFlag(), newObj.getHeartMurmurFlag(), "无",zy, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//压痛
		String[] yt = {"abdominalTendernessDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "压痛", oldObj.getAbdominalTendernessFlag(), newObj.getAbdominalTendernessFlag(), "无",yt, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//包块
		String[] bk = {"abdominalMassDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "包块", oldObj.getAbdominalMassFlag(), newObj.getAbdominalMassFlag(), "无",bk, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//肝大
		String[] gd = {"liverDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "肝大", oldObj.getLiverFlag(), newObj.getLiverFlag(), "无",gd, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//脾大
		String[] pd = {"splenomegalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "脾大", oldObj.getSplenomegalyFlag(), newObj.getSplenomegalyFlag(), "无",pd, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//移动性浊音
		String[] ydxzy = {"abdominalVoicedDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "移动性浊音", oldObj.getAbdominalVoicedFlag(), newObj.getAbdominalVoicedFlag(), "无",ydxzy, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//乳腺
		String[] rx = {"breastResection","breastAnomalyLactation","breastMass","breastOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "查体-乳腺", oldObj.getBreastAnomalyFlag(), newObj.getBreastAnomalyFlag(), "未见异常",rx, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//外阴
		String[] wy = {"vulvaAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "外阴", oldObj.getVulvaAnomalyFlag(), newObj.getVulvaAnomalyFlag(), "未见异常",wy, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//阴道
		String[] fkyd = {"vaginaAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "阴道", oldObj.getVaginaAnomalyFlag(), newObj.getVaginaAnomalyFlag(), "未见异常",fkyd, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//宫颈
		String[] gj = {"cervicalAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "宫颈", oldObj.getCervicalAnomalyFlag(), newObj.getCervicalAnomalyFlag(), "未见异常",gj, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//宫体
		String[] gt = {"corpusAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "宫体", oldObj.getCorpusAnomalyFlag(), newObj.getCorpusAnomalyFlag(), "未见异常",gt, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//附件
		String[] fj = {"accessoriesAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "附件", oldObj.getAccessoriesAnomalyFlag(), newObj.getAccessoriesAnomalyFlag(), "未见异常",fj, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//心电图
		String[] xdt = {"ecgAnomalyDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "心电图", oldObj.getEcgAnomalyFlag(), newObj.getEcgAnomalyFlag(), "正常",xdt, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//X线片
		String[] xp = {"chestXAnomalyfDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "胸部X线片", oldObj.getChestXAnomalyfFlag(), newObj.getChestXAnomalyfFlag(), "正常",xp, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//B超
		String[] bc = {"bmodeAnomalyfDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "B超", oldObj.getBmodeAnomalyfFlag(), newObj.getBmodeAnomalyfFlag(), "正常",bc, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//宫颈涂片
		String[] gjtp = {"cervicalSmearAnomalyfDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "宫颈涂片", oldObj.getCervicalSmearAnomalyfFlag(), newObj.getCervicalSmearAnomalyfFlag(), "正常",gjtp, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//脑血管
		String[] nxg = {"cvascularHemorrhageStroke","cvascularHemorrhage","cvascularSah","covascularTransientIschemic","covascularOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "脑血管", oldObj.getCvascularFlag(), newObj.getCvascularFlag(), "未发现",nxg, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//肾脏
		String[] sz = {"kidneyDiabeticNephropathy","kidneyRenalFailure","kidneyAcuteNephritis","kidneyChronicNephritis","kidneyOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "肾脏", oldObj.getKidneyDiseaseFlag(), newObj.getKidneyDiseaseFlag(), "未发现",sz, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//心脏
		String[] xz = {"heartMiocardialInfarction","heartAnginaPectoris","heartCoronary","heartCongestiveHeart","heartPrecordialPain","heartOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "心脏", oldObj.getHeartDiseaseFlag(), newObj.getHeartDiseaseFlag(),"未发现", xz, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//血管
		String[] xg = {"arteryDissectingAneurysm","arteryPaod","arteryOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "血管", oldObj.getArteryDiseaseFlag(), newObj.getArteryDiseaseFlag(),"未发现", xg, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//眼部
		String[] yb = {"eyeRetinalOozing","eyeOpticPapilla","eyeCataract","eyeOther"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "眼部", oldObj.getEyeDiseasesFlag(), newObj.getEyeDiseasesFlag(),"未发现", yb, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//神经系统
		String[] sjxt = {"nervousDiseasesDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "神经系统", oldObj.getNervousDiseasesFlag(), newObj.getNervousDiseasesFlag(), "未发现",sjxt, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//其他系统
		String[] qtxt = {"healthOtherDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "其他系统", oldObj.getHealthOther(), newObj.getHealthOther(), "未发现",qtxt, PhysiqueExamination.class,oldObj, newObj,  personId, inputerId,inputName,inputOrganCode,inputOrg));
		//住院治疗情况（list）
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "住院史", HospitalizedHistory.class, oldPersonalPhyExamDTO.getHospitalizedHistoryFlg(), newPersonalPhyExamDTO.getHospitalizedHistoryFlg(), oldPersonalPhyExamDTO.getHospitalizedHistoryList(), newPersonalPhyExamDTO.getHospitalizedHistoryList(), personId, inputerId,inputName,inputOrganCode,inputOrg));
		//家庭病床史（list）
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "家庭病床史", FamilyBedHistory.class, oldPersonalPhyExamDTO.getFamilyBedHistoryFlg(), newPersonalPhyExamDTO.getFamilyBedHistoryFlg(), oldPersonalPhyExamDTO.getFamilyBedHistoryList(), newPersonalPhyExamDTO.getFamilyBedHistoryList(), personId, inputerId,inputName,inputOrganCode,inputOrg));
		//主要用药（list）
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "主要用药情况", DrugHistory.class, oldPersonalPhyExamDTO.getDrugHistoryFlag(), newPersonalPhyExamDTO.getDrugHistoryFlag(), oldPersonalPhyExamDTO.getDrugHistoryList(), newPersonalPhyExamDTO.getDrugHistoryList(), personId, inputerId,inputName,inputOrganCode,inputOrg));
		//非免疫规划预防接种史（list）
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "非免疫规划预防接种史", VaccinationInfo.class, oldPersonalPhyExamDTO.getVaccinationInfoFlg(), newPersonalPhyExamDTO.getVaccinationInfoFlg(), oldPersonalPhyExamDTO.getVaccinationInfoList(), newPersonalPhyExamDTO.getVaccinationInfoList(), personId, inputerId,inputName,inputOrganCode,inputOrg));
		//健康评价（list）
		modifyTraceList.addAll(CompareUtil.compare(regionType, regionName, "健康评价", HealthEvaluateAnomaly.class, oldPersonalPhyExamDTO.getHealthEvaluateAnomalyFlg(), newPersonalPhyExamDTO.getHealthEvaluateAnomalyFlg(), oldPersonalPhyExamDTO.getHealthEvaluateAnomalyList(), newPersonalPhyExamDTO.getHealthEvaluateAnomalyList(), personId, inputerId,inputName,inputOrganCode,inputOrg));
		//健康指导
		String[] jkzd = {"guideRegularFollowup","guideIntoChronicDisease","guideSuggestionReview","guideSuggestionReferral"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "健康指导", CompareUtil.HAVE, CompareUtil.HAVE,"", jkzd, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		//危险因素控制
		String[] wxys = {"riskQuitSmoking","riskHealthDrink","riskDiet","riskExercise","riskWeightReduction","riskWeightTarget","guideVaccination","guideVaccinationDesc","riskOther","riskOtherDesc"};
		addModifyTraceNest(modifyTraceList, CompareUtil.getModifyTraceByMulColumn(regionType, regionName, null, "危险因素", CompareUtil.HAVE, CompareUtil.HAVE,"", wxys, PhysiqueExamination.class, oldObj, newObj, personId, inputerId,inputName,inputOrganCode,inputOrg));
		
		modifyTraceDao.batchInsert(modifyTraceList);
	}
	
	private void addModifyTraceNest(List<ModifyTrace> modifyTraceList,ModifyTrace mt)
	{
		if(mt != null)
			modifyTraceList.add(mt);
	}

	@Override
	public PageList<ModifyTrace> getModifyTraceList(Criteria criteria,Page page,Order order) {
		return modifyTraceDao.getPageList(page,criteria,order);
	}

	@Override
	public void setModifyTrace(ModifyTrace modifyTrace) {
		modifyTraceDao.insert(modifyTrace);
	}
}


/**
 * 比较器
 * @author donghong
 *
 */
class CompareUtil {
    private static Map<String,List<Field>> fieldCache = new HashMap<String, List<Field>>();

    public static final String HAVE = "1";

    public static final String UN_HAVE = "0";

    /**
     * 需要比较的字段放入cache
     * @param cls
     */
    private static void putCompareFieldsIntoCache(Class<?> cls)
    {
        List<Field> returnFields = new ArrayList<Field>();
        List<Field> allFields = new ArrayList<Field>();
        //遍历属性
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            allFields.add(field);
            if (field.isAnnotationPresent(RecordTrace.class))
                returnFields.add(field);
        }
        fieldCache.put(cls.getName(), returnFields);
        fieldCache.put(cls.getName() + "all", allFields);
    }

    /**
     * 简单实体对象比较
     *
     * @param regionType
     * @param regionName
     * @param cls
     * @param oldObject
     * @param newObject
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author Ye jianfei
     */
    public static List<ModifyTrace> compare(String regionType,String regionName,Class<?> cls,Object oldObject,Object newObject,Long personId, String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> returnList = new ArrayList<>();
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName());
        for(Field field:fields)
        {
            field.setAccessible(true);


            Column column = field.getAnnotation(Column.class);
            RecordTrace recordTrace = field.getAnnotation(RecordTrace.class);
            String[] arr = column.columnDefinition().split("[|]");
            String newValue = getStringForTCM(arr[1],getStringFromField(field, newObject),newObject)==null?"未填":getStringForTCM(arr[1],getStringFromField(field, newObject),newObject);
            String oldValue = getStringForTCM(arr[1],getStringFromField(field, oldObject),oldObject)==null?"未填":getStringForTCM(arr[1],getStringFromField(field, oldObject),oldObject);

            if(ObjectUtil.isNullOrEmpty(arr[0])){
            	continue;
            }
            
            int comNum = compareNumber(arr[0],newValue,oldValue);
            
            //不同的数字
            if(comNum == 1){
            	returnList.add(createModifyTrace(regionType,regionName, recordTrace.dictCode(), arr[1], oldValue, newValue,personId,inputUserId, inputName, inputOrgCode,inputOrg));
            	continue;
            }
            
            //相同的数字
            if(comNum == 0){
            	continue;
            }
            
            if(newValue != null && !newValue.equals(oldValue))
            {
                returnList.add(createModifyTrace(regionType,regionName, recordTrace.dictCode(), arr[1], oldValue, newValue,personId,inputUserId, inputName, inputOrgCode, inputOrg));
            }
        }
        return returnList;
    }

    /**
     * 比较实体对象的指定字段
     *
     * @param regionType
     * @param regionName
     * @param cls
     * @param properties
     * @param oldObject
     * @param newObject
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author huangdan
     */
    public static List<ModifyTrace> compare(String regionType,String regionName,Class<?> cls,String[] properties, Object oldObject,Object newObject,Long personId, String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> returnList = new ArrayList<>();
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName());
        for(Field field:fields)
        {
            for(String param : properties){
                if (field.getName().equals(param)){
                    field.setAccessible(true);

                    Column column = field.getAnnotation(Column.class);
                    RecordTrace recordTrace = field.getAnnotation(RecordTrace.class);
                    String[] arr = column.columnDefinition().split("[|]");
                    String newValue = getStringForTCM(arr[1],getStringFromField(field, newObject),newObject)==null?"未填":getStringForTCM(arr[1],getStringFromField(field, newObject),newObject);
                    String oldValue = getStringForTCM(arr[1],getStringFromField(field, oldObject),oldObject)==null?"未填":getStringForTCM(arr[1],getStringFromField(field, oldObject),oldObject);

                    if(ObjectUtil.isNullOrEmpty(arr[0])){
                        continue;
                    }

                    int comNum = compareNumber(arr[0],newValue,oldValue);

                    //不同的数字
                    if(comNum == 1){
                        returnList.add(createModifyTrace(regionType,regionName, recordTrace.dictCode(), arr[1], oldValue, newValue,personId,inputUserId, inputName, inputOrgCode,inputOrg));
                        continue;
                    }

                    //相同的数字
                    if(comNum == 0){
                        continue;
                    }

                    if(newValue != null && !newValue.equals(oldValue))
                    {
                        returnList.add(createModifyTrace(regionType,regionName, recordTrace.dictCode(), arr[1], oldValue, newValue,personId,inputUserId, inputName, inputOrgCode, inputOrg));
                    }
                }
            }
        }
        return returnList;
    }

    /**
     * 判断是否是相同数字
     * 不是数字返回-1，
     * 相同返回0,
     * 不同的数字返回1
     * 
     * */
    private static int compareNumber(String type,String newValue,String oldValue){
    	
    	if(!type.equals("NUMBER")){
    		return -1;
    	}
    	
    	try{
    		BigDecimal newBig = new BigDecimal(newValue);
        	BigDecimal oldBig = new BigDecimal(oldValue);
        	int k = newBig.compareTo(oldBig);
        	if(k == 0){
        		return 0;
        	}
        	return 1;
    	}catch(Exception e){
    		return -1;
    	}
    }

    /**
     * 处理特殊情况
     * @param type
     * @param value
     * @return
     */
    public static String getStringForTCM(String type,String value,Object obj)
    {
        if(type != null && value != null)
        {
            //老年人认知功能
            if(type.equals("老年人认知功能粗筛结果"))
            {
                PhysiqueExamination pe = (PhysiqueExamination)obj;
                return UN_HAVE.equals(value)?("粗筛阳性，简易智力状态检查，总分"+pe.getCognitionScreenScore()):"粗筛阴性";
            }
            //老年人情感状态
            if(type.equals("老年人情感状态粗筛结果"))
            {
                PhysiqueExamination pe = (PhysiqueExamination)obj;
                return UN_HAVE.equals(value)?("粗筛阳性，老年人抑郁评分检查，总分"+pe.getDepressionScore()):"粗筛阴性";
            }
            //职业病危害因素接触史
            if(type.equals("职业危害因素接触史"))
            {
                PhysiqueExamination pe = (PhysiqueExamination)obj;
                StringBuffer sb = new StringBuffer();
                if(value.equals(HAVE))
                {
                    if(pe.getRiskOccupationDesc() != null) sb.append("（工种："+pe.getRiskOccupationDesc()+"从业时间："+pe.getRiskOccupationTime()+"年）");
                    if(pe.getDustTypeDesc() != null) sb.append("粉尘："+pe.getDustTypeDesc()+" 防护措施:" + (UN_HAVE.equals(pe.getDustProtectionFlag())?"无":("有"+pe.getDustProtectionDesc())) + ";");
                    if(pe.getRadiationTypeDesc() != null) sb.append("放射物质："+pe.getRadiationTypeDesc()+" 防护措施:" + (UN_HAVE.equals(pe.getRadiationProtectionFlag())?"无":("有"+pe.getRadiationProtectionDesc())) + ";");
                    if(pe.getPhysicsTypeDesc() != null) sb.append("物理因素："+pe.getPhysicsTypeDesc()+" 防护措施:" + (UN_HAVE.equals(pe.getPhysicsProtectionFlag())?"无":("有"+pe.getPhysicsProtectionDesc())) + ";");
                    if(pe.getChemistryTypeDesc() != null) sb.append("化学物质："+pe.getChemistryTypeDesc()+" 防护措施:" + (UN_HAVE.equals(pe.getChemistryProtectionFlag())?"无":("有"+pe.getChemistryProtectionDesc())) + ";");
                    if(pe.getOtherTypeDesc() != null) sb.append("其他："+pe.getOtherTypeDesc()+" 防护措施:" + (UN_HAVE.equals(pe.getOtherProtectionFlag())?"无":("有"+pe.getOtherProtectionDesc())) + ";");
                }
                else
                    sb.append("无;");
                return getStringFromSB(sb);
            }
            //齿列
            if(type.equals("齿列异常标志"))
            {
                PhysiqueExamination pe = (PhysiqueExamination)obj;
                StringBuffer sb = new StringBuffer();
                if(value.equals(HAVE))
                {
                	sb.append("异常;");
                    if(pe.getMissingToothNumberUpl()!=null) sb.append("缺齿上左:"+pe.getMissingToothNumberUpl() + ";");
                    if(pe.getMissingToothNumberUpr()!=null) sb.append("缺齿上右:"+pe.getMissingToothNumberUpr() + ";");
                    if(pe.getMissingToothNumberDownl()!=null) sb.append("缺齿下左:"+pe.getMissingToothNumberDownl() + ";");
                    if(pe.getMissingToothNumberDownr()!=null) sb.append("缺齿下右:"+pe.getMissingToothNumberDownr() + ";");

                    if(pe.getDecayedToothNumberUpl()!=null) sb.append("龋齿上左:"+pe.getDecayedToothNumberUpl() + ";");
                    if(pe.getDecayedToothNumberUpr()!=null) sb.append("龋齿上右:"+pe.getDecayedToothNumberUpr() + ";");
                    if(pe.getDecayedToothNumberDownl()!=null) sb.append("龋齿下左:"+pe.getDecayedToothNumberDownl() + ";");
                    if(pe.getDecayedToothNumberDownr()!=null) sb.append("龋齿下右:"+pe.getDecayedToothNumberDownr() + ";");

                    if(pe.getDentureToothNumberUpl()!=null) sb.append("义齿上左:"+pe.getDentureToothNumberUpl() + ";");
                    if(pe.getDentureToothNumberUpr()!=null) sb.append("义齿上右:"+pe.getDentureToothNumberUpr() + ";");
                    if(pe.getDentureToothNumberDownl()!=null) sb.append("义齿下左:"+pe.getDentureToothNumberDownl() + ";");
                    if(pe.getDentureToothNumberDownr()!=null) sb.append("义齿下右:"+pe.getDentureToothNumberDownr() + ";");
                }
                else
                    sb.append("正常;");
                return getStringFromSB(sb);
            }
            //
            if(type.equals("桶状胸标志"))
                return HAVE.equals(value)?"是":"否";
            //中医体质辨识
            if(type.length() == 3 && type.endsWith("质"))
            {
                if(type.equals("平和质"))
                    return UN_HAVE.equals(value)?"是":"基本是";
                else
                    return UN_HAVE.equals(value)?"是":"倾向是";
            }
        }
        return value;
    }

    private static String getStringFromField(Field field,Object obj)
    {
        String str = null;
        try {
            field.setAccessible(true);
            if(obj != null && field.get(obj) != null)
            {
                if(field.getType().getName().equals("java.util.Date"))
                    str = DateUtil.toDateString((Date) field.get(obj), null);
                else
                    str = field.get(obj) + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 创建修改痕迹对象
     *
     * @param regionType
     * @param regionName
     * @param itemCode
     * @param itemName
     * @param oldValue
     * @param newValue
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author Ye jianfei
     */
    public static ModifyTrace createModifyTrace(String regionType,String regionName,String itemCode,String itemName,String oldValue,String newValue,Long personId, String inputUserId,String inputName,String inputOrgCode,String inputOrg)
    {
        ModifyTrace modifyTrace = new ModifyTrace();
        modifyTrace.setItemCode(itemCode);
        modifyTrace.setItemName(itemName);
        modifyTrace.setOldValue(oldValue);
        modifyTrace.setNewValue(newValue);
        modifyTrace.setInputDate(new Date());
        modifyTrace.setPersonId(personId);
        modifyTrace.setRegionType(regionType);
        modifyTrace.setRegionName(regionName);
        modifyTrace.setInputName(inputName);
        modifyTrace.setInputOrg(inputOrg);
        //add by yejianfei 20140724
        modifyTrace.setInputUserId(inputUserId);
        modifyTrace.setInputOrgCode(inputOrgCode);
      //add by yejianfei 20140724
        return modifyTrace;
    }

    private static <T> String createStringFromList(Class<?> cls,List<T> list)
    {
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName());
        StringBuffer sb = new StringBuffer();
        try {
            for(T t:list)
            {
                if(t != null)
                {
                    for(Field field:fields)
                    {
                        field.setAccessible(true);

                        if(field.get(t) != null && field.getType().getName().equals("java.util.Date"))
                            sb.append(DateUtil.toDateString((Date) field.get(t), null) + " ");
                        else if(field.get(t) != null)
                            sb.append(field.get(t) + " ");
                    }
                    sb = new StringBuffer(getStringFromSB(sb) + ";");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getStringFromSB(sb).replaceAll("其他,", "其他：");
    }

    /**
     * 根据集合比较
     * @param regionType
     * @param regionName
     * @param itemName
     * @param cls
     * @param oldList
     * @param newList
     * @param personId
     * @return
     */
    public static <T> List<ModifyTrace> compare(String regionType,String regionName,String itemName,Class<?> cls,List<T> oldList,List<T> newList,Long personId
    		,String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> returnList = new ArrayList<>();
        String oldValue = createStringFromList(cls, oldList);
        String newValue = createStringFromList(cls, newList);
        if(!oldValue.equals(newValue))
            returnList.add(createModifyTrace(regionType,regionName,null, itemName, oldValue, newValue,personId,inputUserId, inputName, inputOrgCode, inputOrg));
        return returnList;
    }

    /**
     *
     * @param regionType
     * @param regionName
     * @param itemName
     * @param cls
     * @param oldString
     * @param newString
     * @param personId
     * @return
     */
    public static <T> List<ModifyTrace> compare(String regionType,String regionName,String itemName,Class<?> cls,String oldString,String newString,Long personId 
    		,String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> returnList = new ArrayList<>();
        if(oldString == null) oldString = "未填";
        if(newString == null) newString = "未填";
        if(!oldString.equals(newString))
            returnList.add(createModifyTrace(regionType,regionName,null, itemName, oldString, newString,personId,inputUserId,inputName,inputOrgCode,inputOrg));
        return returnList;
    }

    /**
     * 根据标志位比较集合
     *
     * @param regionType
     * @param regionName
     * @param itemName
     * @param cls
     * @param oldFlag
     * @param newFlag
     * @param oldList
     * @param newList
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author Ye jianfei
     */
    public static <T> List<ModifyTrace> compare(String regionType,String regionName,String itemName,Class<?> cls,String oldFlag,String newFlag,List<T> oldList,List<T> newList,Long personId
    		,String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> returnList = new ArrayList<>();
        //标志不变
        if(oldFlag.equals(newFlag))
        {
            if(oldFlag.equals(CompareUtil.HAVE))
            {
                return compare(regionType,regionName,itemName, cls, oldList, newList,personId, inputUserId,inputName,inputOrgCode,inputOrg);
            }
        }
        else
        //标志改变
        {
            if(oldFlag.equals(CompareUtil.HAVE))
            {
                String oldValue = createStringFromList(cls, oldList);
                returnList.add(createModifyTrace(regionType,regionName,null, itemName, oldValue, "无",personId, inputUserId,inputName,inputOrgCode,inputOrg));
            }
            else
            {
                String newValue = createStringFromList(cls, newList);
                returnList.add(createModifyTrace(regionType,regionName,null, itemName, "无", newValue,personId, inputUserId,inputName,inputOrgCode,inputOrg));
            }
        }
        return returnList;
    }

    /**
     * 根据标志位比较字符串
     *
     * @param regionType
     * @param regionName
     * @param itemName
     * @param cls
     * @param oldFlag
     * @param newFlag
     * @param oldString
     * @param newString
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author Ye jianfei
     */
    public static <T> List<ModifyTrace> compare(String regionType,String regionName,String itemName,Class<?> cls,String oldFlag,String newFlag,String oldString,String newString,Long personId
    		,String inputUserId, String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> returnList = new ArrayList<>();
        //标志不变
        if(oldFlag.equals(newFlag))
        {
            if(oldFlag.equals(EHRConstants.HAVE))
            {
                return compare(regionType,regionName,itemName, cls, oldString, newString,personId, inputUserId,inputName,inputOrgCode,inputOrg);
            }
        }
        //标志改变
        else{
            if(oldFlag.equals(EHRConstants.HAVE))
            {
                returnList.add(createModifyTrace(regionType,regionName,null, itemName, oldString, "无",personId, inputUserId,inputName,inputOrgCode,inputOrg));
            }
            else
            {
                returnList.add(createModifyTrace(regionType,regionName,null, itemName, "无", newString,personId,inputUserId,inputName,inputOrgCode,inputOrg));
            }
        }
        return returnList;
    }

    public static List<? extends ModifyTrace> compare(String regionType, String regionName, String itemName,Class<?> cls, String oldFlag,String newFlag, Object oldObject,Object newObject, Long personId
    		,String inputUserId, String inputName,String inputOrgCode, String inputOrg) {
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName());
        StringBuffer newValue = new StringBuffer();
        StringBuffer oldValue = new StringBuffer();
        for(Field field:fields)
        {
            field.setAccessible(true);

            Column column = field.getAnnotation(Column.class);
            String[] arr = column.columnDefinition().split("[|]");
            try {
                if(field.get(newObject) != null)
                    newValue.append(arr[1] + ",");
                if(ObjectUtil.isNotEmpty(oldObject)){
                	if(field.get(oldObject) != null){
                		oldValue.append(arr[1] + ",");
                	}
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return compare(regionType, regionName, itemName, cls, oldFlag, newFlag, getStringFromSB(oldValue), getStringFromSB(newValue), personId,inputUserId,inputName,inputOrgCode,inputOrg);
    }

    public static List<? extends ModifyTrace> compare(String regionType, String regionName, String itemName, String desc, Class<?> cls, String oldFlag,String newFlag, Object oldObject,Object newObject, Long personId
    		,String inputUserId, String inputName,String inputOrgCode, String inputOrg) {
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName());
        StringBuffer newValue = new StringBuffer();
        StringBuffer oldValue = new StringBuffer();
        for(Field field:fields)
        {
            field.setAccessible(true);

            Column column = field.getAnnotation(Column.class);
            String[] arr = column.columnDefinition().split("[|]");
            if(field.getName().indexOf(desc) != -1)
            {
                try {
                    if(field.get(newObject) != null){
                        newValue.append(field.get(newObject) + ",");
                    }
                    if(ObjectUtil.isNotEmpty(oldObject)){
                    	if(field.get(oldObject) != null){
                            oldValue.append(field.get(oldObject) + ",");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    if(field.get(newObject) != null)
                        newValue.append(arr[1] + ",");
                    if(ObjectUtil.isNotEmpty(oldObject)){
                    	 if(field.get(oldObject) != null){
                    		 oldValue.append(arr[1] + ",");
                    	 }
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return compare(regionType, regionName, itemName, cls, oldFlag, newFlag, getStringFromSB(oldValue), getStringFromSB(newValue), personId,inputUserId, inputName,inputOrgCode, inputOrg);
    }

    /**
     * 处理末尾带结束符的StringBuffer
     * @param sb
     * @return
     */
    private static String getStringFromSB(StringBuffer sb)
    {
        if(sb != null && sb.length() > 0)
            return sb.substring(0, sb.length()-1);
        else
            return "";
    }

    /**
     * 疾病史修改痕迹
     *
     * @param regionType
     * @param regionName
     * @param oldPersonalBasicInfoDTO
     * @param newPersonalBasicInfoDTO
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author Ye jianfei
     */
    public static List<ModifyTrace> diseaseHistoryModifyTrace(String regionType,String regionName,PersonalBasicInfoDTO oldPersonalBasicInfoDTO,PersonalBasicInfoDTO newPersonalBasicInfoDTO,Long personId
    		,String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        List<ModifyTrace> modifyTraceList = new ArrayList<>();
        String oldFlag = oldPersonalBasicInfoDTO.getDiseaseHistoryFlag();
        String newFlag = newPersonalBasicInfoDTO.getDiseaseHistoryFlag();
        //标志位改变
        if(oldFlag != null && !oldFlag.equals(newFlag) || (newFlag!=null && !newFlag.equals(oldFlag)))
        {
            //原来有，现在无
            if(oldFlag != null && oldFlag.equals(EHRConstants.HAVE))
                modifyTraceList.add(createModifyTrace(regionType,regionName, null, "既往史-疾病", getDiseaseHistory(oldPersonalBasicInfoDTO), "无", personId, inputUserId,inputName,inputOrgCode,inputOrg));
            else
                modifyTraceList.add(createModifyTrace(regionType,regionName, null, "既往史-疾病", "无", getDiseaseHistory(newPersonalBasicInfoDTO), personId, inputUserId,inputName,inputOrgCode,inputOrg));
        }
        else
        {
            if(oldFlag != null && oldFlag.equals(EHRConstants.HAVE))
            {
                String oldS = getDiseaseHistory(oldPersonalBasicInfoDTO);
                String newS = getDiseaseHistory(newPersonalBasicInfoDTO);
                if(!oldS.equals(newS))
                    modifyTraceList.add(createModifyTrace(regionType,regionName, null, "既往史-疾病", oldS , newS, personId, inputUserId,inputName,inputOrgCode,inputOrg));
            }
        }
        return modifyTraceList;
    }

    private static String getDiseaseHistory(PersonalBasicInfoDTO personalBasicInfoDTO)
    {
        StringBuffer sb = new StringBuffer();
        //高血压
        if("201".equals(personalBasicInfoDTO.getGxy()))
            sb.append("高血压，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getGxyDate(), null) + ";");
        //糖尿病
        if("202".equals(personalBasicInfoDTO.getTnb()))
            sb.append("糖尿病，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getTnbDate(), null) + ";");
        //冠心病
        if("203".equals(personalBasicInfoDTO.getGxb()))
            sb.append("冠心病，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getGxbDate(), null) + ";");
        //慢性阻塞性肺疾病
        if("204".equals(personalBasicInfoDTO.getFjb()))
            sb.append("慢性阻塞性肺疾病，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getFjbDate(), null) + ";");
        //恶性肿瘤
        if("205".equals(personalBasicInfoDTO.getExzl()))
            sb.append("恶性肿瘤，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getExzlDate(), null) + ";");
        //脑卒中
        if("206".equals(personalBasicInfoDTO.getNzz()))
            sb.append("脑卒中，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getNzzDate(), null) + ";");
        //重性精神病
        if("207".equals(personalBasicInfoDTO.getZxjsb()))
            sb.append("重性精神病，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getZxjsbDate(), null) + ";");
        //结核病
        if("208".equals(personalBasicInfoDTO.getJhb()))
            sb.append("结核病，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getJhbDate(), null) + ";");
        //肝炎
        if("209".equals(personalBasicInfoDTO.getGy()))
            sb.append("肝炎，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getGyDate(), null) + ";");
        //先天畸形
        if("210".equals(personalBasicInfoDTO.getXtjx()))
            sb.append("先天畸形，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getXtjxDate(), null) + ";");
        //其他
        if("211".equals(personalBasicInfoDTO.getQt()))
            sb.append("其他，确诊时间 "+DateUtil.toDateString(personalBasicInfoDTO.getQtDate(), null) + ";");
        return getStringFromSB(sb);
    }

    /**
     * 
     *
     * @param regionType
     * @param regionName
     * @param itemCode
     * @param itemName
     * @param oldFlag
     * @param newFlag
     * @param firstS
     * @param properties
     * @param cls
     * @param oldObj
     * @param newObj
     * @param personId
     * @param inputUserId
     * @param inputName
     * @param inputOrgCode
     * @param inputOrg
     * @return
     * @author Ye jianfei
     */
    public static ModifyTrace getModifyTraceByMulColumn(String regionType,String regionName,String itemCode,String itemName
    		,String oldFlag,String newFlag,String firstS,String[] properties,Class<?> cls,Object oldObj,Object newObj,Long personId
            ,String inputUserId,String inputName,String inputOrgCode, String inputOrg)
    {
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()+"all"))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName()+"all");
        String newString = null;
        String oldString = null;
        Map<String,String> map = getMapFromMulColumn(properties, fields, newObj, oldObj);
        if(oldFlag == null) oldFlag = UN_HAVE;
        if(newFlag == null) newFlag = UN_HAVE;
        //标志位不变
        if(oldFlag.equals(newFlag))
        {
            if(oldFlag.equals(HAVE))
            {
                newString = map.get("newString");
                oldString = map.get("oldString");
            }
        }
        else
        {
            if(oldFlag.equals(HAVE))
            {
                oldString = map.get("oldString");
                newString = firstS;
            }
            else
            {
                oldString = firstS;
                newString = map.get("newString");
            }
        }
        if(newString != null && oldString != null && !newString.equals(oldString))
            return createModifyTrace(regionType, regionName, itemCode, itemName, oldString, newString, personId, inputUserId,inputName,inputOrgCode,inputOrg);
        return null;
    }

    /**
     * 内部方法
     * @param properties
     * @param fields
     * @param newObj
     * @param oldObj
     * @return
     */
    private static Map<String,String> getMapFromMulColumn(String[] properties,List<Field> fields,Object newObj,Object oldObj)
    {
        StringBuffer newSb = new StringBuffer();
        StringBuffer oldSb = new StringBuffer();
        for(String str:properties)
        {
            for(Field field:fields)
            {
                if(field.getName().indexOf(str) != -1)
                {
                    Column column = field.getAnnotation(Column.class);
                    String[] arr = column.columnDefinition().split("[|]");
                    if(arr[1].endsWith("描述"))
                    {
                        if(getStringFromField(field, newObj) != null)
                            newSb.append(getStringFromField(field, newObj) + ";");
                        if(getStringFromField(field, oldObj) != null)
                            oldSb.append(getStringFromField(field, oldObj) + ";");
                    }
                    else
                    {
                        if(getStringFromField(field, newObj) != null)
                            newSb.append(arr[1] + ";");
                        if(getStringFromField(field, oldObj) != null)
                            oldSb.append(arr[1] + ";");
                    }
                    break;
                }
            }
        }
        Map<String,String> map = new HashMap<>();
        map.put("newString", getStringFromSB(newSb));
        map.put("oldString", getStringFromSB(oldSb));
        return map;
    }

    public static ModifyTrace getModifyTraceBySingleColumn(String regionType,String regionName, String itemCode,String itemName,String oldValue,String newValue, String pro,String other,Class<?> cls,Object oldObj, Object newObj,Long personId,String inputUserId,String inputName,String inputOrgCode, String inputOrg) {
        //获取比较字段
        if(!fieldCache.containsKey(cls.getName()+"all"))
            putCompareFieldsIntoCache(cls);
        List<Field> fields = fieldCache.get(cls.getName()+"all");
        Map<String,String> map = PersonPhyExamMap.phyExamMap.get(itemName);
        String newString = getValueFrom(map.get(newValue),fields,other,newObj);
        String oldString = getValueFrom(map.get(oldValue),fields,other,oldObj);
        if(newString != null && !newString.equals(oldString))
            return createModifyTrace(regionType, regionName, itemCode, itemName, oldString, newString, personId, inputUserId,inputName,inputOrgCode,inputOrg);
        return null;
    }

    private static String getValueFrom(String str,List<Field> fields,String pro,Object obj)
    {
        if("其他".equals(str))
        {
            for(Field field:fields)
            {
                field.setAccessible(true);
                if(field.getName().indexOf(pro) != -1)
                {
                    try {
                        return field.get(obj)+"";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return str;
    }

    //简单新旧值比较
    public static ModifyTrace getManaDoctorName(String regionType, String regionName,  String itemCode, String itemName, String oldValue, String newValue, Long personId,String inputUserId,String inputName,String inputOrgCode, String inputOrg) {
        if(ObjectUtil.isNotEmpty(newValue) && !oldValue.equals(newValue)){
            return createModifyTrace( regionType, regionName, itemCode, itemName, oldValue, newValue, personId, inputUserId,inputName,inputOrgCode,inputOrg);
        }
        return null;
    }
    
    /**
     * 处理特殊的支付方式
     * @param regionType
     * @param regionName
     * @param itemName
     * @param oldValue
     * @param newValue
     * @param personId
     * @param inputName
     * @param inputOrg
     * @return
     */
    public static void compare(List<ModifyTrace> modifyTraceList, String regionType, String regionName ,String itemCode ,String itemName, String oldValue, String newValue, Long personId,String inputUserId,String inputName,String inputOrgCode, String inputOrg){
    	if(ObjectUtil.isNullOrEmpty(oldValue)){
    		oldValue = "未填";
    	}
    	if(ObjectUtil.isNullOrEmpty(newValue)){
    		newValue = "未填";
    	}
    	if(newValue.equals(oldValue)){
    		return ;
    	}
    	
    	ModifyTrace modufyTrace = createModifyTrace( regionType, regionName, null, itemName, oldValue, newValue, personId, inputUserId,inputName,inputOrgCode,inputOrg);
    	modifyTraceList.add(modufyTrace);
    }
}

