/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.founder.rhip.ehr.repository.basic.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalConsultationDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.EhrDocLevel;
import com.founder.rhip.ehr.entity.basic.ModifyTrace;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.clinic.Consultation;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import com.founder.rhip.ehr.entity.summary.DeformityHistory;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
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
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.repository.clinic.IConsultationDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IExpenseInfoDao;
import com.founder.rhip.ehr.repository.clinic.IHealthEvaluateAnomalyDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.IDmPersonInfoDao;
import com.founder.rhip.ehr.repository.statistics.IEhrDocLevelDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.repository.summary.IDeformityHistoryDao;
import com.founder.rhip.ehr.repository.summary.IDiseaseHistoryDao;
import com.founder.rhip.ehr.repository.summary.IDrugAllergyHistoryDao;
import com.founder.rhip.ehr.repository.summary.IDrugHistoryDao;
import com.founder.rhip.ehr.repository.summary.IExposeHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyBedHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyHeredityHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.repository.summary.ISurgeryHistoryDao;
import com.founder.rhip.ehr.repository.summary.ITransBloodHistoryDao;
import com.founder.rhip.ehr.repository.summary.ITraumaHistoryDao;
import com.founder.rhip.ehr.repository.ta.ITargetResultValueDao;
import com.founder.rhip.ehr.service.IHasStudentExamSerivce;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IHealthHistoryService;
import com.founder.rhip.ehr.service.IIsStudentService;
import com.founder.rhip.ehr.service.IModifyTraceService;
import com.founder.rhip.ehr.service.IPopulaceService;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.ehr.service.personal.IPersonMoveService;
import com.founder.rhip.ehr.service.personal.IPersonRecordActivateService;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.star.IRecordStarService;
import com.founder.rhip.ehr.service.statistics.IStatisticsService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.ehr.util.EHRUtil;
import com.founder.rhip.ehr.util.StatisticsUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.app.IPersonApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import com.founder.rhip.mdm.service.IMergerTownListener;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

/**
 * The type Personal record managment service impl.
 */
@Service("personalRecordManagmentService")
@TaskBean(description = "同步健康档案地址信息")
public class PersonalRecordManagmentServiceImpl extends AbstractService implements IPersonalRecordManagmentService, IMergerTownListener, Task, IMergerOrganizationListener {
	@Resource
	private IChildHealthExaminationDao childHealthExaminationDao;
	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "drugHistoryDao")
	private IDrugHistoryDao drugHistoryDao;

	@Resource(name = "hospitalizedHistoryDao")
	private IHospitalizedHistoryDao hospitalizedHistoryDao;

	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;

	@Resource(name = "diseaseHistoryDao")
	private IDiseaseHistoryDao diseaseHistoryDao;

	@Resource(name = "surgeryHistoryDao")
	private ISurgeryHistoryDao surgeryHistoryDao;

	@Resource(name = "traumaHistoryDao")
	private ITraumaHistoryDao traumaHistoryDao;

	@Resource(name = "transBloodHistoryDao")
	private ITransBloodHistoryDao transBloodHistoryDao;

	@Resource(name = "familyBedHistoryDao")
	private IFamilyBedHistoryDao familyBedHistoryDao;

	@Resource(name = "familyHistoryDao")
	private IFamilyHistoryDao familyHistoryDao;

	@Resource(name = "familyHeredityHistoryDao")
	private IFamilyHeredityHistoryDao familyHeredityHistoryDao;

	@Resource(name = "expenseInfoDao")
	private IExpenseInfoDao expenseInfoDao;

	@Resource(name = "drugAllergyHistoryDao")
	private IDrugAllergyHistoryDao drugAllergyHistoryDao;

	@Resource(name = "exposeHistoryDao")
	private IExposeHistoryDao exposeHistoryDao;

	@Resource(name = "deformityHistoryDao")
	private IDeformityHistoryDao deformityHistoryDao;

	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;
	@Resource(name = "neonatalFamilyVisitDao")
	private INeonatalFamilyVisitDao neonatalFamilyVisitDao;  //新生儿家庭访视表
	//老年人健康体检信息记录表
	@Resource
	private IChildHealthExamineService childHealthExamineService;

	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;

	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;

	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;

	@Resource(name = "personMoveInfoService")
	private IPersonMoveService personMoveService;

	@Resource(name = "healthEvaluateAnomalyDao")
	private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;

	@Resource(name="dmPersonInfoDao")
	private IDmPersonInfoDao dmPersonInfoDao;

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao dmDiseaseInfoDao;

	@Resource(name = "consultationDao")
	private IConsultationDao consultationDao;

	@Resource(name="personMoveInfoDao")
	private IPersonMoveInfoDao personMoveInfoDao;

	@Autowired
	private IStatisticsService statisticsService;

	@Resource
	private IDictionaryApp dictionaryApp;

	@Autowired
	private IRecordStarService recordStarService;

	@Resource
	private IPersonApp personApp;

	@Autowired
	private IModifyTraceService modifyTraceService;

	@Autowired
	private IStaffService staffService;

	@Autowired(required = false)
	private List<IPersonRecordMoveService> personRecordMove;

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired(required = false)
	private IIsStudentService isStudentService;

	@Autowired
	private IHasStudentExamSerivce hasStudentExamService;

	@Autowired(required = false)
	private List<IPersonRecordActivateService> personRecordActivateService;

	@Autowired
	private IPopulaceService populaceService;

	@Resource(name = "populaceDao")
	private IPopulaceDao populaceDao;

	@Resource(name = "targetResultValueDao")
	private ITargetResultValueDao targetResultValueDao;

	@Autowired
	private IModifyTraceDao modifyTraceDao;

	@Resource(name = "ehrDocLevelDao")
	private IEhrDocLevelDao ehrDocLevelDao;

	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;
	
    @Resource(name = "userOperationLogService")
    private IUserOperationLogService userOperationLogService;
	
    @Resource(name = "healthHistoryService")
    private IHealthHistoryService healthHistoryService;
    
    @Autowired
    private IHealthEventService healthEventService;

	@Resource(name = "personCanceledInfoDao")
	private IPersonCanceledDao personCanceledInfoDao;
    
	public PersonInfo createCover(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo) {
		synchronized (PersonalRecordManagmentServiceImpl.class){
			return createCoverTran(personInfo, currentLoginInfo);
		}
	}

	/**
	 * 创建个人档案-封面
	 *
	 * @param personInfo
	 * @return PersonInfo
	 */
	@Transactional
	public PersonInfo createCoverTran(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo) {
		// 生成个人档案编号
		//判断档案编号是否存在（从表中获取数据则不需要生成个人档案编号）
		if(ObjectUtil.isNullOrEmpty(personInfo.getHealthFileNo())){
			String ehrNo = EHRNumberService.getSerialNum(personInfo.getPastreet(), EHRConstants.EHR_NUMBER_TYPE);
			if(ObjectUtil.isNullOrEmpty(ehrNo)) {
				return personInfo;
			}
			personInfo.setHealthFileNo(ehrNo);
		}
		// 根据身份证号获取性别和生日
		personInfo.setGender(IDCardUtil.getGenderByIdCard(personInfo.getIdcard()));
		personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard()));
		int oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
		// 星级统计
		PersonalBasicInfoDTO personalBasicInfoDTO = new PersonalBasicInfoDTO();
		personalBasicInfoDTO.setPersonInfo(personInfo);
		recordStarService.calOneStarRecord(personalBasicInfoDTO);
		personInfo.setStar(personalBasicInfoDTO.getPersonInfo().getStar());
		personInfo.setOneStarScore(personalBasicInfoDTO.getPersonInfo().getOneStarScore());
		personInfo.setIntegrity(personalBasicInfoDTO.getPersonInfo().getIntegrity());
		/*jianghaiying 2018/07/30 mantis编号0121228
		需求变更 当星级达到二星后建档人、建档单位、建档日期将不能再做修改（包含页面和迁档）
		*/
		setCreateInfo(personInfo, currentLoginInfo);
		// 插入基本信息
		Long personId = personInfoDao.generatedKey(personInfo, "ID", null).longValue();
		personInfo.setId(personId);
		try {
			Person p = personApp.registPerson(EHRUtil.getPersonFromPersonInfo(personInfo));
			personInfo.setSmpiId(p.getPmpiId());
			personInfoDao.update(personInfo, "smpiId");
		} catch (Exception e) {
			//2014年6月18日 16:26:12 liuk 增加异常处理
			log.error("注册人员失败",e);
			throw new RuntimeException("注册人员失败",e);
		}
		// 卫生事件表新增封面类型卫生事件
		createOrUpdateEhrHealthEvent(EventType.PERSON_RECORD_COVER.getCode(), "个人档案封面", personInfo);
		//TODO 园区是首页不算星级 每个地方不同有待完善
		int newStar = personInfo.getStar();
		syncWork(personInfo.getUpdateOrganCode(), personInfo.getUpdateInputerId(), personInfo.getId(), oldStar, newStar);

		return personInfo;
	}

	/**
	 * 将居民建档时的建档单位、建档人、建档日期存入表BI_PERSON_INPUT_INFO
	 * @param personInfo
	 */
	private void setCreateInfo(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo) {
		//若是currentLoginInfo为空 建档人相关信息既是管理单位相关信息
		if(ObjectUtil.isNullOrEmpty(currentLoginInfo)) {
			personInfo.setCreateDate(new Date());
			personInfo.setCreateId(personInfo.getInputerId());
			personInfo.setCreateIdcard(personInfo.getInputIdcard());
			personInfo.setCreateName(personInfo.getInputName());
			Organization currentOrganization = organizationApp.queryOrgan(personInfo.getInputOrganCode());
			//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
			setCreateCenterOrganCode(personInfo, currentOrganization);
			personInfo.setCreateOrganCode(personInfo.getInputOrganCode());
			personInfo.setCreateOrganName(personInfo.getInputOrganName());
			return;
		}
		User currentUser = currentLoginInfo.getUser();
		Organization currentOrganization = currentLoginInfo.getOrganization();

		personInfo.setCreateDate(new Date());
		if(ObjectUtil.isNullOrEmpty(personInfo.getCreateId())) {
			personInfo.setCreateId(currentUser.getStaffCode());
			personInfo.setCreateIdcard(currentUser.getIdentityCard());
		}
		Staff staff = staffService.getStaff(personInfo.getCreateId());
		if(ObjectUtil.isNotEmpty(staff)) {
			personInfo.setCreateName(staff.getName());
			personInfo.setCreateIdcard(staff.getIdCard());
		}
		personInfo.setCreateGbcode(currentOrganization.getGbCode());
		//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
		setCreateCenterOrganCode(personInfo, currentOrganization);
		personInfo.setCreateOrganCode(currentOrganization.getOrganCode());
		personInfo.setCreateOrganName(currentOrganization.getOrganName());
	}

	//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
	private void setCreateCenterOrganCode(PersonInfo personInfo, Organization currentOrganization) {
		//站、医务室、卫生室建档InputCenterOrganCode赋值为父类的code
		if(ObjectUtil.equals(currentOrganization.getGenreCode(), OrgGenreCode.STATION.getValue()) ||
				ObjectUtil.equals(currentOrganization.getGenreCode(), OrgGenreCode.INFIRMARY.getValue()) ||
				ObjectUtil.equals(currentOrganization.getGenreCode(), OrgGenreCode.CLINIC.getValue())) {
			personInfo.setCreateCenterOrganCode(currentOrganization.getParentCode());
		} else if(ObjectUtil.equals(currentOrganization.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
				ObjectUtil.equals(currentOrganization.getGenreCode(), OrgGenreCode.HOSPITAL.getValue()) ||
				ObjectUtil.equals(currentOrganization.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())		) {
			//中心、卫生院、综合医院 建档InputCenterOrganCode赋值为自己的code
			personInfo.setCreateCenterOrganCode(currentOrganization.getOrganCode());
		}
	}

	/**
	 * 创建个人档案-基本信息
	 *
	 * @param personalBasicInfoDTO
	 *            用来获得登录者的信息以及机构信息
	 * @return PersonalBasicInfoDTO
	 */
	@Transactional
	public PersonalBasicInfoDTO createBasicInfo(PersonalBasicInfoDTO personalBasicInfoDTO) {
		// 个人基本信息的部分更新
		PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
		// 费用支付方式
		String expenseInfoStr = personalBasicInfoDTO.getExpenseInfoStr();
		if (expenseInfoStr != null) {
			String[] strArr = expenseInfoStr.split(",");
			if (strArr != null && strArr.length > 0) {
				for (int i = 0; i < strArr.length; i++) {
					switch (strArr[i]) {
						case "01":
							personInfo.setPaymentUrbanWorkders(strArr[i]);
							break;
						case "02":
							personInfo.setPaymentUrbanResident(strArr[i]);
							break;
						case "03":
							personInfo.setPaymentNewRuralCooperation(strArr[i]);
							break;
						case "04":
							personInfo.setPaymentPovertyRelief(strArr[i]);
							break;
						case "05":
							personInfo.setPaymentCommercial(strArr[i]);
							break;
						case "06":
							personInfo.setPaymentBursary(strArr[i]);
							break;
						case "07":
							personInfo.setPaymentPersonalExpenses(strArr[i]);
							break;
						case "99":
							personInfo.setPaymentOther(strArr[i]);
							break;
					}
				}
			}
		}
		PersonInfo personInfoToUpdate = personInfoDao.get(personInfo.getId());
		int oldStar = personInfoToUpdate.getStar() == null ? 0 : personInfoToUpdate.getStar();
		this.genterPersonInfo(personInfo, personInfoToUpdate);
		personalBasicInfoDTO.setPersonInfo(personInfoToUpdate);
		// 卫生事件表新增封面类型卫生事件
		EHRHealthEvent ehrHealthEvent = this.createOrUpdateEhrHealthEvent(EventType.PERSON_RECORD_BASIC_INFO.getCode(), "个人基本信息表", personInfo);
		// 插入基本信息修改痕迹
		modifyTraceService.executeBasicInfo(personalBasicInfoDTO);
		// 计算档案星级
		recordStarService.calTwoStarRecord(personalBasicInfoDTO);
		if (hasStudentExam(personInfoToUpdate.getIdcard()) && isLess20Student(personInfoToUpdate.getBirthday(), personInfoToUpdate.getIdcard()) && ObjectUtil.isNotEmpty(personInfoToUpdate.getStar())
				&& EHRConstants.TWO_STAR == personInfoToUpdate.getStar()) {
			personInfoToUpdate.setStar(EHRConstants.THREE_STAR);
		}
		personInfoToUpdate.setUpdateDate(new Date());
		int newStar =  personInfoToUpdate.getStar() == null ? 0 : personInfoToUpdate.getStar();
		//谁把健康档案从二星以下变为二星 建档人就谁Bug0177300
		if(oldStar <=1 && newStar >= 2) {
			setCreateInfo(personInfoToUpdate, null);
		}
		if(oldStar ==1 && newStar == 2) {
			//0140958  一星变二星时，建档时间更新为当前时间
			personInfoToUpdate.setCreateDate(new Date());
		}
		personInfoDao.update(personInfoToUpdate);
		// 插入基本信息表除个人信息外其他内容
		insertBasicInfoWithOutPersonInfo((PersonalBasicInfoDTO) personalBasicInfoDTO, ehrHealthEvent.getEhrId(), personInfo);
		//保存市民卡指标
		//trySaveCicTarget(personInfoToUpdate);

		List<NeonatalFamilyVisit> neonatalFamilyVisitList= neonatalFamilyVisitDao.getList(new Criteria("BABY_CARD_NO", personInfoToUpdate.getBabyCardNo()));
		if(ObjectUtil.isNotEmpty(neonatalFamilyVisitList)){
			for (int i = 0; i < neonatalFamilyVisitList.size(); i++) {
				NeonatalFamilyVisit neonatalFamilyVisit=neonatalFamilyVisitList.get(i);
				neonatalFamilyVisit.setNeonatusName(personInfoToUpdate.getName());
				neonatalFamilyVisit.setNeonatalGender(personInfoToUpdate.getGender());
				neonatalFamilyVisit.setNeonatusBirthday(personInfoToUpdate.getBirthday());
				//neonatalFamilyVisitDao.update(neonatalFamilyVisit);
			}
			//批量更新 MODIFY BY YEJIANFEI
			neonatalFamilyVisitDao.batchUpdate(neonatalFamilyVisitList,new String[]{"neonatusName","neonatalGender","neonatusBirthday"});
		}

		List<ChildHealthExamination> childHealthExamList = childHealthExamineService.getChildHealthExamList(new Criteria("BABY_CARD_NO", personInfoToUpdate.getBabyCardNo()), new Order("VISIT_DATE", false));
		if(ObjectUtil.isNotEmpty(childHealthExamList)){
			for (int i = 0; i < childHealthExamList.size(); i++) {
				ChildHealthExamination childHealthExamination=childHealthExamList.get(i);
				childHealthExamination.setName(personInfoToUpdate.getName());
				childHealthExamination.setGender(personInfoToUpdate.getGender());
				childHealthExamination.setBirthday(personInfoToUpdate.getBirthday());
				//childHealthExaminationDao.update(childHealthExamination);
			}
			//批量更新 MODIFY BY YEJIANFEI
			childHealthExaminationDao.batchUpdate(childHealthExamList,new String[]{"name","gender","birthday"});
		}
		//TODO 园区是首页不算星级 每个地方不同有待完善
		syncWork(personalBasicInfoDTO.getModifyInputOrganCode(), personalBasicInfoDTO.getModifyInputerId(), personInfo.getId(),oldStar, newStar);
		return personalBasicInfoDTO;
	}

	/**
	 * 个人基本信息表对象转换
	 *
	 * @param oldPerson
	 *            the old person
	 * @param newPerson
	 *            页面传递对象
	 * @return 要保存入库的对象 person info
	 */
	private PersonInfo genterPersonInfo(PersonInfo oldPerson, PersonInfo newPerson) {
		newPerson.setGender(oldPerson.getGender());
		newPerson.setBirthday(oldPerson.getBirthday());
		newPerson.setUnitName(oldPerson.getUnitName());
		newPerson.setFirstGuardian(oldPerson.getFirstGuardian());
		newPerson.setGuardianPhoneOne(oldPerson.getGuardianPhoneOne());
		newPerson.setSecondGuardian(oldPerson.getSecondGuardian());
		newPerson.setGuardianPhoneTwo(oldPerson.getGuardianPhoneTwo());
		newPerson.setNation(oldPerson.getNation());
		newPerson.setOtherNationDesc(oldPerson.getOtherNationDesc());
		newPerson.setAboBloodType(oldPerson.getAboBloodType());
		newPerson.setRhBloodType(oldPerson.getRhBloodType());
		newPerson.setEducation(oldPerson.getEducation());
		newPerson.setOccupation(oldPerson.getOccupation());
		newPerson.setOccupationOther(oldPerson.getOccupationOther());
		newPerson.setMarriage(oldPerson.getMarriage());
		newPerson.setOutWindType(oldPerson.getOutWindType());
		newPerson.setFuel(oldPerson.getFuel());
		newPerson.setWater(oldPerson.getWater());
		newPerson.setHastoilet(oldPerson.getHastoilet());
		newPerson.setFowlType(oldPerson.getFowlType());
		newPerson.setPaymentUrbanWorkders(oldPerson.getPaymentUrbanWorkders());
		newPerson.setPaymentUrbanResident(oldPerson.getPaymentUrbanResident());
		newPerson.setPaymentNewRuralCooperation(oldPerson.getPaymentNewRuralCooperation());
		newPerson.setPaymentPovertyRelief(oldPerson.getPaymentPovertyRelief());
		newPerson.setPaymentCommercial(oldPerson.getPaymentCommercial());
		newPerson.setPaymentBursary(oldPerson.getPaymentBursary());
		newPerson.setPaymentPersonalExpenses(oldPerson.getPaymentPersonalExpenses());
		newPerson.setPaymentOther(oldPerson.getPaymentOther());
		newPerson.setMaternalFlag(oldPerson.getMaternalFlag());
		newPerson.setLastMenstrualDate(oldPerson.getLastMenstrualDate());
		newPerson.setEstimatedDueDate(oldPerson.getEstimatedDueDate());
		return newPerson;
	}

	/**
	 * 创建或更新卫生事件
	 *
	 * @param ehrType
	 *            the ehr type
	 * @param ehrName
	 *            the ehr name
	 * @param personInfo
	 *            the person info
	 * @return eHR health event
	 */
	private EHRHealthEvent createOrUpdateEhrHealthEvent(String ehrType, String ehrName, PersonInfo personInfo) {
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setUpdateDate(new Date());
		Long personId = personInfo.getId();
		if (ehrType != null && ehrType.trim().length() > 0 && personId != null) {
			Criteria c = new Criteria();
			c.add("ehrType", ehrType);
			c.add("personId", personId);
			List<EHRHealthEvent> ehrHealthEvents = ehrHealthEventDao.getList(c);
			if (ehrHealthEvents != null && ehrHealthEvents.size() > 0) {
				ehrHealthEvent = ehrHealthEvents.get(0);
				updateEhrHealthEvent(ehrHealthEvent, personInfo);
			} else {
				createEhrHealthEvent(ehrHealthEvent, ehrType, ehrName, personInfo, null);
			}
		}
		return ehrHealthEvent;
	}

	private EHRHealthEvent updatePhysicExamEvent(String ehrType, String ehrName, PersonInfo personInfo, PhysiqueExamination phyExam) {
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		Long personId = personInfo.getId();
		if (ehrType != null && ehrType.trim().length() > 0 && personId != null) {
			Criteria c = new Criteria();
			c.add("ehrType", ehrType).add("personId", personId);
			String ehrId = phyExam.getEhrId();
			if (StringUtil.isNotEmpty(ehrId)) {
				c.add("ehrId", ehrId);
			}

			if (StringUtil.isNotEmpty(ehrId)) {
				List<EHRHealthEvent> ehrHealthEvents = ehrHealthEventDao.getList(c);
				if (ObjectUtil.isNotEmpty(ehrHealthEvents)) {
					ehrHealthEvent = ehrHealthEvents.get(0);
					ehrHealthEvent.setUpdateDate(new Date());
					ehrHealthEvent.setClinicDate(phyExam.getExaminationDate());
					updateEhrHealthEvent(ehrHealthEvent, personInfo);
				}
			} else {
				ehrHealthEvent.setUpdateDate(new Date());
				createEhrHealthEvent(ehrHealthEvent, ehrType, ehrName, personInfo, phyExam.getExaminationDate());
			}
		}
		return ehrHealthEvent;
	}

	private void updateEhrHealthEvent(EHRHealthEvent ehrHealthEvent, PersonInfo personInfo) {
		ehrHealthEvent.setAge(IDCardUtil.getAgeByIdCard(personInfo.getIdcard()) + "岁");
		ehrHealthEvent.setClinicOrganCode(personInfo.getUpdateOrganCode());
		ehrHealthEvent.setClinicOrganName(personInfo.getUpdateOrganName());
		ehrHealthEvent.setCreateOrganCode(personInfo.getUpdateOrganCode());
		ehrHealthEvent.setCreateOrganName(personInfo.getUpdateOrganName());
		ehrHealthEventDao.update(ehrHealthEvent);
	}

	private void createEhrHealthEvent(EHRHealthEvent ehrHealthEvent, String ehrType, String ehrName, PersonInfo personInfo, Date examinationDate) {
		ehrHealthEvent.setEhrType(ehrType);
		ehrHealthEvent.setEhrName(ehrName);
		ehrHealthEvent.setName(personInfo.getName());
		ehrHealthEvent.setAge(IDCardUtil.getAgeByIdCard(personInfo.getIdcard()) + "岁");
		ehrHealthEvent.setPersonId(personInfo.getId());
		ehrHealthEvent.setCreateDate(new Date());
		ehrHealthEvent.setClinicDate(examinationDate);
		ehrHealthEvent.setClinicOrganCode(personInfo.getUpdateOrganCode());
		ehrHealthEvent.setClinicOrganName(personInfo.getUpdateOrganName());
		ehrHealthEvent.setCreateOrganCode(personInfo.getUpdateOrganCode());
		ehrHealthEvent.setCreateOrganName(personInfo.getUpdateOrganName());
		Long healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null).longValue();
		ehrHealthEvent.setId(healthEventId);
		ehrHealthEvent.setEhrId(String.valueOf(healthEventId));

		ehrHealthEventDao.update(ehrHealthEvent);
	}

	/**
	 * 内部方法，插入个人基本信息表中除人员基本信息其他内容
	 *
	 * @param personalBasicInfoDTO
	 *            the personal basic info dTO
	 * @param healthEventId
	 *            the health event id
	 * @param personInfo
	 *            the person info
	 */
	public void insertBasicInfoWithOutPersonInfo(PersonalBasicInfoDTO personalBasicInfoDTO, String healthEventId, PersonInfo personInfo) {
		Long personId = personInfo.getId();
		String name = personInfo.getName();
		int age = 0;
		if (personInfo.getBirthday() != null)
			age = DateUtil.getAgeByBirthday(personInfo.getBirthday());
		String gender = personInfo.getGender();
		String marriage = personInfo.getMarriage();

		// 清空旧数据
		this.updateBasicInfoWithOutPersonInfo(healthEventId, personId);

		// 药物过敏史
		String drugAllergyHistoryFlag = personalBasicInfoDTO.getDrugAllergyHistoryFlag();
		/*// 无过敏史
		if (drugAllergyHistoryFlag.equals(EHRConstants.UN_HAVE)) {
			DrugAllergyHistory drugAllergyHistory = new DrugAllergyHistory();
			drugAllergyHistory.setEhrId(healthEventId);
			drugAllergyHistory.setPersonId(personId);
			drugAllergyHistory.setAllergensFlag(EHRConstants.UN_HAVE);
			drugAllergyHistoryDao.insert(drugAllergyHistory);
		}*/
		// 有过敏史
		if (!drugAllergyHistoryFlag.equals(EHRConstants.UN_HAVE))
		{
			String drugAllergyHistoryStr = personalBasicInfoDTO.getDrugAllergyHistoryStr();
			if (StringUtils.isNotEmpty(drugAllergyHistoryStr)) {
				String[] drugAllergyHistoryStrArr = drugAllergyHistoryStr.split(",");
				if (drugAllergyHistoryStrArr != null && drugAllergyHistoryStrArr.length > 0) {
					List<DrugAllergyHistory> drugAllergyHistoryList = new ArrayList<DrugAllergyHistory>();
					for (int i = 0; i < drugAllergyHistoryStrArr.length; i++) {
						DrugAllergyHistory drugAllergyHistory = new DrugAllergyHistory();
						drugAllergyHistory.setEhrId(healthEventId);
						drugAllergyHistory.setPersonId(personId);
						drugAllergyHistory.setAllergensFlag(EHRConstants.HAVE);
						drugAllergyHistory.setAllergensCode(drugAllergyHistoryStrArr[i]);
						drugAllergyHistory.setAllergensName(dictionaryApp.queryDicItem(EHRConstants.DRUG_ALLERGY, drugAllergyHistoryStrArr[i]).getItemName());
						if(ObjectUtil.equals(drugAllergyHistoryStrArr[i], EHRConstants.DRUG_ALLERGY_HISTORY_OTHER)) {
							drugAllergyHistory.setOtherDesc(personalBasicInfoDTO.getDrugAllergyHistoryOtherDesc());
						}
						drugAllergyHistoryList.add(drugAllergyHistory);
					}
					drugAllergyHistoryDao.batchInsert(drugAllergyHistoryList);
				}
			}
		}

		// 既往疾病史;20180410修改,rose,根据最新规范删除及增补
		String DiseaseHistoryFlag = personalBasicInfoDTO.getDiseaseHistoryFlag();
		if (DiseaseHistoryFlag.equals(EHRConstants.HAVE)) {
			this.insertDiseaseHistory(personalBasicInfoDTO.getGxy(), "高血压", personalBasicInfoDTO.getGxyDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getTnb(), "糖尿病", personalBasicInfoDTO.getTnbDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getGxb(), "冠心病", personalBasicInfoDTO.getGxbDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getFjb(), "慢性阻塞性肺疾病", personalBasicInfoDTO.getFjbDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getExzl(), StringUtil.isNotEmpty(personalBasicInfoDTO.getExzlName())?personalBasicInfoDTO.getExzlName():"恶性肿瘤", personalBasicInfoDTO.getExzlDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getNzz(), "脑卒中", personalBasicInfoDTO.getNzzDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getZxjsb(), "重性精神障碍", personalBasicInfoDTO.getZxjsbDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getJhb(), "结核病", personalBasicInfoDTO.getJhbDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getGy(), "肝炎", personalBasicInfoDTO.getGyDate(), healthEventId, personId, null);
//			this.insertDiseaseHistory(personalBasicInfoDTO.getXtjx(), "先天畸形", personalBasicInfoDTO.getXtjxDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getQtidm(), "其他法定传染病", personalBasicInfoDTO.getQtidmDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getZyb(), StringUtil.isNotEmpty(personalBasicInfoDTO.getZybName())?personalBasicInfoDTO.getZybName():"职业病", personalBasicInfoDTO.getZybDate(), healthEventId, personId, null);
			this.insertDiseaseHistory(personalBasicInfoDTO.getQt(), "其他", personalBasicInfoDTO.getQtDate(), healthEventId, personId, personalBasicInfoDTO.getQtxx());
		}

		// 既往手术史
		String surgeryHistoryFlag = personalBasicInfoDTO.getSurgeryHistoryFlag();
		if (surgeryHistoryFlag.equals(EHRConstants.HAVE)) {
			List<SurgeryHistory> surgeryHistoryList = personalBasicInfoDTO.getSurgeryHistoryList();
			if (surgeryHistoryList != null && surgeryHistoryList.size() > 0) {
				List<SurgeryHistory> newSurgeryHistoryList = new ArrayList<>();
				for (SurgeryHistory surgeryHistory : surgeryHistoryList) {
					if (surgeryHistory != null && StringUtils.isNotEmpty(surgeryHistory.getOpsName())) {
						surgeryHistory.setEhrId(healthEventId);
						surgeryHistory.setPersonId(personId);
						newSurgeryHistoryList.add(surgeryHistory);
						//surgeryHistoryDao.insert(surgeryHistory);
					}
				}
				//批量插入 modify yejianfei 20181122
				if(ObjectUtil.isNotEmpty(newSurgeryHistoryList)) {
					surgeryHistoryDao.batchInsert(newSurgeryHistoryList);
				}
			}
		}

		// 外伤史
		String traumaHistoryFlag = personalBasicInfoDTO.getTraumaHistoryFlag();
		if (traumaHistoryFlag.equals(EHRConstants.HAVE)) {
			List<TraumaHistory> traumaHistoryList = personalBasicInfoDTO.getTraumaHistoryList();
			if (traumaHistoryList != null && traumaHistoryList.size() > 0) {
				List<TraumaHistory> newTraumaHistoryList = new ArrayList<>();
				for (TraumaHistory traumaHistory : traumaHistoryList) {
					if (traumaHistory != null && StringUtils.isNotEmpty(traumaHistory.getOpsName())) {
						traumaHistory.setEhrId(healthEventId);
						traumaHistory.setPersonId(personId);
						newTraumaHistoryList.add(traumaHistory);
						//traumaHistoryDao.insert(traumaHistory);
					}
				}
				//批量插入 modify yejianfei 20181122
				if(ObjectUtil.isNotEmpty(newTraumaHistoryList)){
					traumaHistoryDao.batchInsert(newTraumaHistoryList);
				}
			}
		}

		// 输血史
		String transBloodHistoryFlag = personalBasicInfoDTO.getTransBloodHistoryFlag();
		if (transBloodHistoryFlag.equals(EHRConstants.HAVE)) {
			List<TransBloodHistory> transBloodHistoryList = personalBasicInfoDTO.getTransBloodHistoryList();
			if (transBloodHistoryList != null && transBloodHistoryList.size() > 0) {
				List<TransBloodHistory> newTransBloodHistoryList = new ArrayList<>();
				for (TransBloodHistory transBloodHistory : transBloodHistoryList) {
					if (transBloodHistory != null && (StringUtils.isNotEmpty(transBloodHistory.getBloodReason())||ObjectUtil.isNotEmpty(transBloodHistory.getBloodDate()))) {
						transBloodHistory.setEhrId(healthEventId);
						transBloodHistory.setPersonId(personId);
						newTransBloodHistoryList.add(transBloodHistory);
						//transBloodHistoryDao.insert(transBloodHistory);
					}
				}
				//批量插入 modify yejianfei 20181122
				if(ObjectUtil.isNotEmpty(newTransBloodHistoryList)){
					transBloodHistoryDao.batchInsert(newTransBloodHistoryList);
				}
			}
		}

		// 家族史
		// 父亲
		String fatherFlag = personalBasicInfoDTO.getFatherFlag();
		if (fatherFlag.equals(EHRConstants.HAVE)) {
			String fatherStr = personalBasicInfoDTO.getFatherStr();
			String[] fatherStrArr = fatherStr.split(",");
			if (fatherStrArr != null && fatherStrArr.length > 0) {
				List<FamilyHistory> fatherList = new ArrayList<FamilyHistory>();
				for (int i = 0; i < fatherStrArr.length; i++) {
					FamilyHistory familyHistory = new FamilyHistory();
					familyHistory.setEhrId(healthEventId);
					familyHistory.setPersonId(personId);
					familyHistory.setRelation("01");
					familyHistory.setDiseaseCode(fatherStrArr[i]);
					familyHistory.setDiseaseName(dictionaryApp.queryDicItem(EHRConstants.FAMILY_DISEASE, fatherStrArr[i]).getItemName());
					familyHistory.setOtherDisease(personalBasicInfoDTO.getFatherStrDesc());
					fatherList.add(familyHistory);
				}
				familyHistoryDao.batchInsert(fatherList);
			}
		}
		// 母亲
		String motherFlag = personalBasicInfoDTO.getMotherFlag();
		if (motherFlag.equals(EHRConstants.HAVE)) {
			String motherStr = personalBasicInfoDTO.getMotherStr();
			String[] motherStrArr = motherStr.split(",");
			if (motherStrArr != null && motherStrArr.length > 0) {
				List<FamilyHistory> motherList = new ArrayList<FamilyHistory>();
				for (int i = 0; i < motherStrArr.length; i++) {
					FamilyHistory familyHistory = new FamilyHistory();
					familyHistory.setEhrId(healthEventId);
					familyHistory.setPersonId(personId);
					familyHistory.setRelation("02");
					familyHistory.setDiseaseCode(motherStrArr[i]);
					familyHistory.setDiseaseName(dictionaryApp.queryDicItem(EHRConstants.FAMILY_DISEASE, motherStrArr[i]).getItemName());
					familyHistory.setOtherDisease(personalBasicInfoDTO.getMotherStrDesc());
					motherList.add(familyHistory);
				}
				familyHistoryDao.batchInsert(motherList);
			}
		}
		// 兄妹
		String brotherFlag = personalBasicInfoDTO.getBrotherFlag();
		if (brotherFlag.equals(EHRConstants.HAVE)) {
			String brotherStr = personalBasicInfoDTO.getBrotherStr();
			String[] brotherStrArr = brotherStr.split(",");
			if (brotherStrArr != null && brotherStrArr.length > 0) {
				List<FamilyHistory> brotherList = new ArrayList<FamilyHistory>();
				for (int i = 0; i < brotherStrArr.length; i++) {
					FamilyHistory familyHistory = new FamilyHistory();
					familyHistory.setEhrId(healthEventId);
					familyHistory.setPersonId(personId);
					familyHistory.setRelation("03");
					familyHistory.setDiseaseCode(brotherStrArr[i]);
					familyHistory.setDiseaseName(dictionaryApp.queryDicItem(EHRConstants.FAMILY_DISEASE, brotherStrArr[i]).getItemName());
					familyHistory.setOtherDisease(personalBasicInfoDTO.getBrotherStrDesc());
					brotherList.add(familyHistory);
				}
				familyHistoryDao.batchInsert(brotherList);
			}
		}

		// 子女
		String childFlag = personalBasicInfoDTO.getChildFlag();
		if (childFlag.equals(EHRConstants.HAVE)) {
			String childStr = personalBasicInfoDTO.getChildStr();
			String[] childStrArr = childStr.split(",");
			if (childStrArr != null && childStrArr.length > 0) {
				List<FamilyHistory> childList = new ArrayList<FamilyHistory>();
				for (int i = 0; i < childStrArr.length; i++) {
					FamilyHistory familyHistory = new FamilyHistory();
					familyHistory.setEhrId(healthEventId);
					familyHistory.setPersonId(personId);
					familyHistory.setRelation("04");
					familyHistory.setDiseaseCode(childStrArr[i]);
					familyHistory.setDiseaseName(dictionaryApp.queryDicItem(EHRConstants.FAMILY_DISEASE, childStrArr[i]).getItemName());
					familyHistory.setOtherDisease(personalBasicInfoDTO.getChildStrDesc());
					childList.add(familyHistory);
				}
				familyHistoryDao.batchInsert(childList);
			}
		}

		// 家族遗传病史
		String familyHeredityHistoryFlag = personalBasicInfoDTO.getFamilyHeredityHistoryFlag();
		if (familyHeredityHistoryFlag.equals(EHRConstants.HAVE)) {
			List<FamilyHeredityHistory> familyHeredityHistoryList = personalBasicInfoDTO.getFamilyHeredityHistoryList();
			if (familyHeredityHistoryList != null && familyHeredityHistoryList.size() > 0) {
				List<FamilyHeredityHistory> newFamilyHeredityHistoryList = new ArrayList<>();
				for (FamilyHeredityHistory familyHeredityHistory : familyHeredityHistoryList) {
					if (familyHeredityHistory != null) {
						familyHeredityHistory.setEhrId(healthEventId);
						familyHeredityHistory.setPersonId(personId);
						familyHeredityHistory.setRelation("00");
						newFamilyHeredityHistoryList.add(familyHeredityHistory);
						//familyHeredityHistoryDao.insert(familyHeredityHistory);
					}
				}
				//批量插入 modify yejianfei 20181122
				if(ObjectUtil.isNotEmpty(newFamilyHeredityHistoryList)){
					familyHeredityHistoryDao.batchInsert(newFamilyHeredityHistoryList);
				}
			}
		}

		// 暴露史
		ExposeHistory exposeHistory = personalBasicInfoDTO.getExposeHistory();
		// 无暴露史
		String exposeHistoryFlag = exposeHistory.getExposeFlag();
		if (exposeHistoryFlag.equals(EHRConstants.UN_HAVE)) {
			exposeHistory.setChemical("");
			exposeHistory.setPoison("");
			exposeHistory.setRay("");
			personalBasicInfoDTO.setExposeHistoryFlag("1");
		}
		// ExposeHistory exposeHistory =
		// personalBasicInfoDTO.getExposeHistory();
		exposeHistory.setEhrId(healthEventId);
		exposeHistory.setPersonId(personId);
		exposeHistoryDao.insert(exposeHistory);

		// 残疾史
		DeformityHistory deformityHistory = personalBasicInfoDTO.getDeformityHistory();
		// 无残疾史
		String deformityFlag = deformityHistory.getDeformityFlag();
		if (deformityFlag.equals(EHRConstants.UN_HAVE)) {
			deformityHistory.setVisionDeformity("");
			deformityHistory.setHearingDeformity("");
			deformityHistory.setSpeechDeformity("");
			deformityHistory.setLimbDeformity("");
			deformityHistory.setIntellectDeformity("");
			deformityHistory.setMindDeformity("");
			deformityHistory.setOther("");
			deformityHistory.setOtherDesc("");
			personalBasicInfoDTO.setDeformityFlag("1");
		}
		deformityHistory.setEhrId(healthEventId);
		deformityHistory.setPersonId(personId);
		deformityHistoryDao.insert(deformityHistory);
	}

	/**
	 * 内部方法：插入既往疾病史
	 *
	 * @param diseaseCode
	 *            ：疾病code
	 * @param diseaseName
	 *            ：疾病名称
	 * @param confirmDate
	 *            ：确诊事件
	 * @param ehrId
	 *            ：卫生事件号
	 * @param personId
	 *            ：人员号
	 * @param other
	 *            ：其他描述信息
	 */
	private void insertDiseaseHistory(String diseaseCode, String diseaseName, Date confirmDate, String ehrId, Long personId, String other) {
		if (diseaseCode != null) {
			Criteria criteria = new Criteria("personId", personId);
			criteria.add("diseaseCode", diseaseCode);
			DiseaseHistory diseaseHistory = diseaseHistoryDao.get(criteria);
			if(diseaseHistory==null){
				diseaseHistory = new DiseaseHistory();
				diseaseHistory.setDiseaseCode(diseaseCode);
				diseaseHistory.setDiseaseName(diseaseName);
				diseaseHistory.setEhrId(ehrId);
				diseaseHistory.setPersonId(personId);
				diseaseHistory.setConfirmationDate(confirmDate);
				diseaseHistory.setOtherDesc(other);
				diseaseHistoryDao.insert(diseaseHistory);
			}else{
				diseaseHistory.setDiseaseName(diseaseName);
				diseaseHistory.setEhrId(ehrId);
				diseaseHistory.setConfirmationDate(confirmDate);
				diseaseHistory.setOtherDesc(other);
				diseaseHistoryDao.update(diseaseHistory);
			}
		}
	}

	/**
	 * 内部方法：更新个人基本信息表中除人员基本信息以外的内容
	 *
	 * @param ehrHealthEventId
	 *            事件号ID
	 * @param personId
	 *            个人交叉标识符
	 */
	public void updateBasicInfoWithOutPersonInfo(String ehrHealthEventId, Long personId) {
		// 更新之前数据，使其无效
		// 药物过敏史
		Criteria criteria = new Criteria();
		criteria.add("ehrId", ehrHealthEventId);
		criteria.add("personId", personId);
		// Parameters parameters = new Parameters();
		// parameters.add("state", "1");
		// drugAllergyHistoryDao.update(parameters,criteria);
		drugAllergyHistoryDao.delete(criteria);
		// //暴露史
		// exposeHistoryDao.update(parameters,criteria);
		exposeHistoryDao.delete(criteria);
		// //既往疾病史
		// diseaseHistoryDao.update(parameters,criteria);
		diseaseHistoryDao.delete(criteria);
		// //既往手术史
		// surgeryHistoryDao.update(parameters,criteria);
		surgeryHistoryDao.delete(criteria);
		// //外伤史
		// traumaHistoryDao.update(parameters,criteria);
		traumaHistoryDao.delete(criteria);
		// //输血史
		// transBloodHistoryDao.update(parameters,criteria);
		transBloodHistoryDao.delete(criteria);
		// //家族史
		// familyHistoryDao.update(parameters,criteria);
		familyHistoryDao.delete(criteria);
		// //家族遗传病史
		// familyHeredityHistoryDao.update(parameters,criteria);
		familyHeredityHistoryDao.delete(criteria);
		// 费用支付方式表
		// expenseInfoDao.update(parameters,criteria);
		expenseInfoDao.delete(criteria);
		// 残疾史
		// deformityHistoryDao.update(parameters,criteria);
		deformityHistoryDao.delete(criteria);
	}

	/**
	 * 创建个人档案-健康体检
	 *
	 * @param personalPhyExam
	 * @return PersonalPhyExamDTO
	 */
	@Transactional
	public void createPhysical(PersonalPhyExamDTO personalPhyExam) {
		PersonInfo personInfo = personalPhyExam.getPersonInfo();
		Assert.notNull(personInfo);
		final Long personId = personInfo.getId();
		Assert.notNull(personId);
		personInfo = personInfoDao.get(personId);
		int oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
		Assert.notNull(personInfo);
		if (null != personalPhyExam.getPhysiqueExamination()) {
			PhysiqueExamination physiqueExamination = personalPhyExam.getPhysiqueExamination();
			// 创建或更新卫生事件
			EHRHealthEvent ehrHealthEvent = updatePhysicExamEvent(EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), "个人健康档案体检信息", personInfo, physiqueExamination);
			modifyTraceService.executePhyExam(personalPhyExam);
			/* 体检表信息赋值 */
			String ehrId = ehrHealthEvent.getEhrId();
			physiqueExamination.setEhrId(ehrId);
			physiqueExamination.setPersonId(personId);
			if (null != ehrHealthEvent.getAge())
				physiqueExamination.setAge(ehrHealthEvent.getAge());
			if (null != personInfo.getBirthday())
				physiqueExamination.setBirthday(personInfo.getBirthday());
			if (null != personInfo.getMarriage())
				physiqueExamination.setMarriage(personInfo.getMarriage());
			physiqueExamination.setName(personInfo.getName());
			physiqueExamination.setHealthFileNo(personInfo.getHealthFileNo());
			physiqueExamination.setGender(personInfo.getGender());
			// physiqueExamination.setPhysicalExamCode();
			physiqueExamination.setInputDate(ehrHealthEvent.getCreateDate());
			physiqueExamination.setInputName(ehrHealthEvent.getCreatePerson());
			physiqueExamination.setInputIdcard(ehrHealthEvent.getCreateIdcard());
			// physiqueExamination.setManaDoctorIdcard()

			/* 如果有旧的体检信息则删除 */
			Criteria ca = new Criteria("personId", personId).add("ehrId", ehrId);
			PhysiqueExamination oldPhyExam = physiqueExaminationDao.get(ca);
			if (null != oldPhyExam) {
				/* 删除旧的体检信息 */
				physiqueExaminationDao.delete(oldPhyExam.getId());
				/* 删除关联表 */
				familyBedHistoryDao.delete(ca);
				vaccinationInfoDao.delete(ca);
				drugHistoryDao.delete(ca);
				hospitalizedHistoryDao.delete(ca);
				healthEvaluateAnomalyDao.delete(new Criteria("ehrId", oldPhyExam.getEhrId()));
				vaccinationInfoDao.delete(ca);
			}
			Thread thread = new Thread(new Runnable() {
				public void run() {
					Parameters param = new Parameters();
					param.add("updateDate", new Date());
					Criteria c = new Criteria("id", personId);
					personInfoDao.update(param, c);
				}
			});
			thread.start();

			/* 体格检查表新增 */
			physiqueExaminationDao.generatedKey(physiqueExamination, "ID", null).longValue();
			/* 健康体检表表中除体格检查表外其他内容新增 */
			insertPhysicalOfOther(personalPhyExam, personId, ehrId);
			// 计算档案星级
			// 如果是小于20岁的学生,在有学生体检的情况下是三星,则不在计算星级
			if (!(isLess20Student(personInfo.getBirthday(), personInfo.getIdcard()) && ObjectUtil.isNotEmpty(personInfo.getStar()) && EHRConstants.THREE_STAR == personInfo.getStar())) {
				personalPhyExam.setPersonInfo(personInfo);
				recordStarService.calThreeStarRecord(personalPhyExam);
				recordStarService.updateStar(personInfo);
			}
			Integer newStar = personalPhyExam.getPersonInfo().getStar() == null ? 0 : personalPhyExam.getPersonInfo().getStar();
			//TODO 园区是首页不算星级 每个地方不同有待完善
			syncWork(personalPhyExam.getModifyInputOrganCode(), personalPhyExam.getModifyInputerId(), personInfo.getId(), oldStar, newStar);
		}
	}

	/** 从慢病和老年人体检过来的数据保存到个人体检 */
	@Override
	public String savePhyExamFromElderly(User user, Organization organ,PersonInfo personInfo, PhysiqueExamination physiqueExamination, List<HealthEvaluateAnomaly> anomalyList,List<HospitalizedHistory> hospitalizedHistoryList,List<FamilyBedHistory> familyBedHistoryList,List<DrugHistory> drugHistoryHistoryList,List<VaccinationInfo> vaccinationInfoList, String... properties) {
		//根据体检编号获取个人体检
		Criteria cri = new Criteria("personId", personInfo.getId()).add("physicalExamCode", physiqueExamination.getPhysicalExamCode());
		PhysiqueExamination phyExam = physiqueExaminationDao.get(cri);
		PersonalPhyExamDTO phyExamDTO = null;
		Long personId = personInfo.getId();
		if (ObjectUtil.isNotEmpty(phyExam)) {
			String ehrId = phyExam.getEhrId();
			physiqueExamination.setEhrId(ehrId);
			//更新
			EHRHealthEvent event = ehrHealthEventDao.get(new Criteria("ehrId",phyExam.getEhrId()));
			//更新卫生事件
			updatePhysicExamEvent(event.getEhrType(), event.getEhrName(), personInfo, physiqueExamination);
			//查找之前的DTO
			phyExamDTO = getPersonalPhysical(new Criteria("id", personId), ehrId);
			phyExamDTO.setModifyInputName(user.getName());
			phyExamDTO.setModifyInputerId(user.getStaffCode());
			phyExamDTO.setModifyInputOrganCode(organ.getOrganCode());
			phyExamDTO.setModifyInputOrg(organ.getOrganName());

			PhysiqueExamination oldPhyExam = phyExamDTO.getPhysiqueExamination();
			phyExamDTO.setPhysiqueExamination(physiqueExamination);
			//开始更新操作
			modifyTraceService.executePhyExam(phyExamDTO);
			/* 体检表信息赋值 */
			physiqueExamination.setPersonId(personId);
			if(null != event.getAge()) {
				physiqueExamination.setAge(event.getAge());
			}
			if(null != personInfo.getBirthday()) {
				physiqueExamination.setBirthday(personInfo.getBirthday());
			}
			if(null != personInfo.getMarriage()) {
				physiqueExamination.setMarriage(personInfo.getMarriage());
			}
			physiqueExamination.setName(personInfo.getName());
			physiqueExamination.setHealthFileNo(personInfo.getHealthFileNo());
			physiqueExamination.setGender(personInfo.getGender());
			// physiqueExamination.setPhysicalExamCode();
			physiqueExamination.setInputDate(event.getCreateDate());
			physiqueExamination.setInputName(event.getCreatePerson());
			physiqueExamination.setInputIdcard(event.getCreateIdcard());
			// physiqueExamination.setManaDoctorIdcard()
			//原数据处理不被覆盖
			//keepOldPhyExamData(physiqueExamination, oldPhyExam, properties);

			if (ObjectUtil.isNotEmpty(anomalyList)) {
				//健康评价有异常
				physiqueExamination.setHealthEvaluateAnomalyFlag("1");
				phyExamDTO.setHealthEvaluateAnomalyList(anomalyList);
				phyExamDTO.setHealthEvaluateAnomalyFlg("1");
			} else {
				//无异常
				physiqueExamination.setHealthEvaluateAnomalyFlag("0");
				phyExamDTO.setHealthEvaluateAnomalyFlg("0");
			}

			if(ObjectUtil.isNotEmpty(hospitalizedHistoryList)){
				phyExamDTO.setHospitalizedHistoryList(hospitalizedHistoryList);
				phyExamDTO.setHospitalizedHistoryFlg("1");
			}
			if(ObjectUtil.isNotEmpty(familyBedHistoryList)){
				phyExamDTO.setFamilyBedHistoryList(familyBedHistoryList);
				phyExamDTO.setFamilyBedHistoryFlg("1");
			}
			if(ObjectUtil.isNotEmpty(drugHistoryHistoryList)){
				phyExamDTO.setDrugHistoryList(drugHistoryHistoryList);
				phyExamDTO.setDrugHistoryFlag("1");
			}if(ObjectUtil.isNotEmpty(vaccinationInfoList)){
				phyExamDTO.setVaccinationInfoList(vaccinationInfoList);
				phyExamDTO.setVaccinationInfoFlg("1");
			}

			if (null != oldPhyExam) {
				/* 删除旧的体检信息 */
				physiqueExaminationDao.delete(oldPhyExam.getId());
				healthEvaluateAnomalyDao.delete(new Criteria("ehrId", oldPhyExam.getEhrId()));
				Criteria ca = new Criteria("personId", personId).add("ehrId", ehrId);
				familyBedHistoryDao.delete(ca);
				hospitalizedHistoryDao.delete(ca);
				drugHistoryDao.delete(ca);
				vaccinationInfoDao.delete(ca);
			}
			physiqueExaminationDao.generatedKey(physiqueExamination, "ID", null).longValue();
			createHealthEvaluateAnomaly(phyExamDTO, ehrId);
			createHospitalizedHistory(phyExamDTO, personId, ehrId);
			createFamilyBedHistory(phyExamDTO, personId, ehrId);
			createDrugUsage(phyExamDTO, personId, ehrId);
			createVaccinationInfo(phyExamDTO, personId, ehrId);
			if(!ObjectUtil.isNullOrEmpty(personInfo.getStar())) {
				if (personInfo.getStar() != 3) {
					recordStarService.calThreeStarRecord(phyExamDTO);
					PersonInfo personStar = phyExamDTO.getPersonInfo();
					recordStarService.updateStar(personStar);
				}

			}
		} else {
			//新建
			physiqueExamination.setEhrId(null);
			phyExamDTO = new PersonalPhyExamDTO();
			Staff staff = staffService.getStaff(user.getStaffCode());
			if (ObjectUtil.isNotEmpty(staff)) {
				physiqueExamination.setManaDoctorId(staff.getStaffCode());
			}
			// 如果没有体检编号,则自动生成（家医履约同步过来的数据要新生成体检编号）
		    if (ObjectUtil.isNullOrEmpty(physiqueExamination.getPhysicalExamCode())) {
			   String examCode = EHRNumberService.getSerialNum(physiqueExamination.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
			   physiqueExamination.setPhysicalExamCode(examCode);
		    }
		    
			phyExamDTO.setPhysiqueExamination(physiqueExamination);   
			// 为了在体检页面显示健康档案编号
			phyExamDTO.setPersonInfo(personInfo);
			// modify by Kevin Ro at 2018-08-02 在老年人模块录入的体检结果，在健康档案痕迹浏览中出现修改人、修改机构为空的现象
			phyExamDTO.setModifyInputName(user.getName());
			phyExamDTO.setModifyInputerId(user.getStaffCode());
			phyExamDTO.setModifyInputOrganCode(organ.getOrganCode());
			phyExamDTO.setModifyInputOrg(organ.getOrganName());
			if (ObjectUtil.isNotEmpty(anomalyList)) {
				//健康评价有异常
				physiqueExamination.setHealthEvaluateAnomalyFlag("1");
				phyExamDTO.setHealthEvaluateAnomalyList(anomalyList);
				phyExamDTO.setHealthEvaluateAnomalyFlg("1");
			}
			if(ObjectUtil.isNotEmpty(hospitalizedHistoryList)){
				phyExamDTO.setHospitalizedHistoryList(hospitalizedHistoryList);
				phyExamDTO.setHospitalizedHistoryFlg("1");
			}if(ObjectUtil.isNotEmpty(familyBedHistoryList)){
				phyExamDTO.setFamilyBedHistoryList(familyBedHistoryList);
				phyExamDTO.setFamilyBedHistoryFlg("1");
			}if(ObjectUtil.isNotEmpty(drugHistoryHistoryList)){
				phyExamDTO.setDrugHistoryList(drugHistoryHistoryList);
				phyExamDTO.setDrugHistoryFlag("1");
			}if(ObjectUtil.isNotEmpty(vaccinationInfoList)){
				phyExamDTO.setVaccinationInfoList(vaccinationInfoList);
				phyExamDTO.setVaccinationInfoFlg("1");
			}
			createPhysical(phyExamDTO);
		}
		
		//体检信息存入家医履约表里，由定时任务更新到家医服务记录
		final PersonalPhyExamDTO dto = phyExamDTO ;
		final User currentUser = user;
		Thread thread = new Thread(new Runnable() {
			public void run() {
				serviceSyncLogService.insertExam(dto, currentUser, null, EHRConstants.EXAM_JSON_TYPE, null);
			}
		});
		thread.start();
		return physiqueExamination.getPhysicalExamCode();
	}

	/** 从慢病和老年人体检过来的数据保存到个人体检-----暂未使用 */
	@Override
	public void savePhyExamFromElderly(User user, PersonInfo personInfo, PhysiqueExamination physiqueExamination, List<HealthEvaluateAnomaly> anomalyList,List<HospitalizedHistory> hospitalizedHistoryList,List<FamilyBedHistory> familyBedHistoryList,List<DrugHistory> drugHistoryHistoryList,List<VaccinationInfo> vaccinationInfoList, String... properties) {
//		//先确定体检是否存在
//		Criteria eventCriteria = new Criteria("personId", personInfo.getId())
//				.add("ehrType", EHRTypeConstants.PERSON_RECORD_PHYSICIAL_EXAM)
//				.add("clinicDate", physiqueExamination.getExaminationDate());
//		List<EHRHealthEvent> events = ehrHealthEventDao.getList(eventCriteria);
//		PersonalPhyExamDTO phyExamDTO = null;
//		Long personId = personInfo.getId();
//		if (ObjectUtil.isNotEmpty(events)) {
//			//更新
//			EHRHealthEvent event = events.get(0);
//			String ehrId = event.getEhrId();
//			physiqueExamination.setEhrId(ehrId);
//			//查找之前的DTO
//			phyExamDTO = getPersonalPhysical(new Criteria("id", personId), ehrId);
//			PhysiqueExamination oldPhyExam = phyExamDTO.getPhysiqueExamination();
//			phyExamDTO.setPhysiqueExamination(physiqueExamination);
//			//开始更新操作
//			modifyTraceService.executePhyExam(phyExamDTO);
//			/* 体检表信息赋值 */
//			physiqueExamination.setPersonId(personId);
//			if (null != event.getAge()) {
//				physiqueExamination.setAge(event.getAge());
//			}
//			if (null != personInfo.getBirthday()) {
//				physiqueExamination.setBirthday(personInfo.getBirthday());
//			}
//			if (null != personInfo.getMarriage()) {
//				physiqueExamination.setMarriage(personInfo.getMarriage());
//			}
//			physiqueExamination.setName(personInfo.getName());
//			physiqueExamination.setHealthFileNo(personInfo.getHealthFileNo());
//			physiqueExamination.setGender(personInfo.getGender());
//			// physiqueExamination.setPhysicalExamCode();
//			physiqueExamination.setInputDate(event.getCreateDate());
//			physiqueExamination.setInputName(event.getCreatePerson());
//			physiqueExamination.setInputIdcard(event.getCreateIdcard());
//			// physiqueExamination.setManaDoctorIdcard()
//			//原数据处理不被覆盖
//			//keepOldPhyExamData(physiqueExamination, oldPhyExam, properties);
//
//			if (ObjectUtil.isNotEmpty(anomalyList)) {
//				//健康评价有异常
//				physiqueExamination.setHealthEvaluateAnomalyFlag("1");
//				phyExamDTO.setHealthEvaluateAnomalyList(anomalyList);
//				phyExamDTO.setHealthEvaluateAnomalyFlg("1");
//			} else {
//				//无异常
//				physiqueExamination.setHealthEvaluateAnomalyFlag("0");
//				phyExamDTO.setHealthEvaluateAnomalyFlg("0");
//			}
//
//			if(ObjectUtil.isNotEmpty(hospitalizedHistoryList)){
//				phyExamDTO.setHospitalizedHistoryList(hospitalizedHistoryList);
//				phyExamDTO.setHospitalizedHistoryFlg("1");
//			}
//			if(ObjectUtil.isNotEmpty(familyBedHistoryList)){
//				phyExamDTO.setFamilyBedHistoryList(familyBedHistoryList);
//				phyExamDTO.setFamilyBedHistoryFlg("1");
//			}
//			if(ObjectUtil.isNotEmpty(drugHistoryHistoryList)){
//				phyExamDTO.setDrugHistoryList(drugHistoryHistoryList);
//				phyExamDTO.setDrugHistoryFlag("1");
//			}if(ObjectUtil.isNotEmpty(vaccinationInfoList)){
//				phyExamDTO.setVaccinationInfoList(vaccinationInfoList);
//				phyExamDTO.setVaccinationInfoFlg("1");
//			}
//
//			if (null != oldPhyExam) {
//				/* 删除旧的体检信息 */
//				physiqueExaminationDao.delete(oldPhyExam.getId());
//				healthEvaluateAnomalyDao.delete(new Criteria("ehrId", oldPhyExam.getEhrId()));
//				Criteria ca = new Criteria("personId", personId).add("ehrId", ehrId);
//				familyBedHistoryDao.delete(ca);
//				hospitalizedHistoryDao.delete(ca);
//				drugHistoryDao.delete(ca);
//				vaccinationInfoDao.delete(ca);
//			}
//			physiqueExaminationDao.generatedKey(physiqueExamination, "ID", null).longValue();
//			createHealthEvaluateAnomaly(phyExamDTO, ehrId);
//			createHospitalizedHistory(phyExamDTO, personId, ehrId);
//			createFamilyBedHistory(phyExamDTO, personId, ehrId);
//			createDrugUsage(phyExamDTO, personId, ehrId);
//			createVaccinationInfo(phyExamDTO, personId, ehrId);
//			if(!ObjectUtil.isNullOrEmpty(personInfo.getStar())) {
//				if (personInfo.getStar() != 3) {
//					recordStarService.calThreeStarRecord(phyExamDTO);
//					PersonInfo personStar = phyExamDTO.getPersonInfo();
//					recordStarService.updateStar(personStar);
//				}
//			}
//		} else {
//			//新建
//			physiqueExamination.setEhrId(null);
//			phyExamDTO = new PersonalPhyExamDTO();
//			Staff staff = staffService.getStaff(user.getStaffCode());
//			if (ObjectUtil.isNotEmpty(staff)) {
//				physiqueExamination.setManaDoctorId(staff.getStaffCode());
//			}
//			phyExamDTO.setPhysiqueExamination(physiqueExamination);
//			// 为了在体检页面显示健康档案编号
//			phyExamDTO.setPersonInfo(personInfo);
//			if (ObjectUtil.isNotEmpty(anomalyList)) {
//				//健康评价有异常
//				physiqueExamination.setHealthEvaluateAnomalyFlag("1");
//				phyExamDTO.setHealthEvaluateAnomalyList(anomalyList);
//				phyExamDTO.setHealthEvaluateAnomalyFlg("1");
//			}
//			if(ObjectUtil.isNotEmpty(hospitalizedHistoryList)){
//				phyExamDTO.setHospitalizedHistoryList(hospitalizedHistoryList);
//				phyExamDTO.setHospitalizedHistoryFlg("1");
//			}if(ObjectUtil.isNotEmpty(familyBedHistoryList)){
//				phyExamDTO.setFamilyBedHistoryList(familyBedHistoryList);
//				phyExamDTO.setFamilyBedHistoryFlg("1");
//			}if(ObjectUtil.isNotEmpty(drugHistoryHistoryList)){
//				phyExamDTO.setDrugHistoryList(drugHistoryHistoryList);
//				phyExamDTO.setDrugHistoryFlag("1");
//			}if(ObjectUtil.isNotEmpty(vaccinationInfoList)){
//				phyExamDTO.setVaccinationInfoList(vaccinationInfoList);
//				phyExamDTO.setVaccinationInfoFlg("1");
//			}
//			createPhysical(phyExamDTO);
//		}
	}

	private List<HealthEvaluateAnomaly> getAnomalyList(String anomalyDesc) {
		List<HealthEvaluateAnomaly> anomalyList = new ArrayList<>();
		if (StringUtil.isNotEmpty(anomalyDesc)) {
			String[] anomalies = anomalyDesc.split(";");
			for (String anomaly : anomalies) {
				HealthEvaluateAnomaly hea = new HealthEvaluateAnomaly();
				hea.setHealthEvaluateAnomalyDesc(anomaly);
				anomalyList.add(hea);
			}
		}
		return anomalyList;
	}

	/** 原数据处理不被覆盖　*/
	private void keepOldPhyExamData(PhysiqueExamination physiqueExamination, PhysiqueExamination oldPhyExam, String...properties) {
		physiqueExamination.setRightSbp(oldPhyExam.getRightSbp());
		physiqueExamination.setRightDbp(oldPhyExam.getRightDbp());
        /*physiqueExamination.setHemoglobinValue(oldPhyExam.getHemoglobinValue());
        physiqueExamination.setPlateletCount(oldPhyExam.getPlateletCount());*/
		physiqueExamination.setTcmBloodQuality(oldPhyExam.getTcmBloodQuality());
		physiqueExamination.setTcmConclusion(oldPhyExam.getTcmConclusion());
		physiqueExamination.setTcmHeatMedium(oldPhyExam.getTcmHeatMedium());
		physiqueExamination.setTcmPeacefulQuality(oldPhyExam.getTcmPeacefulQuality());
		physiqueExamination.setTcmPhlegmWetness(oldPhyExam.getTcmPhlegmWetness());
		physiqueExamination.setTcmQiQuality(oldPhyExam.getTcmQiQuality());
		physiqueExamination.setTcmQiStagnation(oldPhyExam.getTcmQiStagnation());
		physiqueExamination.setTcmSpecialQuality(oldPhyExam.getTcmSpecialQuality());
		physiqueExamination.setTcmYangQuality(oldPhyExam.getTcmYangQuality());
		physiqueExamination.setTcmYinDeficiency(oldPhyExam.getTcmYinDeficiency());

		if (!ArrayUtil.contains(properties, "healthEvaluateAnomalyFlag")) {
			physiqueExamination.setHealthEvaluateAnomalyFlag(oldPhyExam.getHealthEvaluateAnomalyFlag());
		}
		if (!ArrayUtil.contains(properties, "guideRegularFollowup")) {
			physiqueExamination.setGuideRegularFollowup(oldPhyExam.getGuideRegularFollowup());
		}
		if (!ArrayUtil.contains(properties, "guideSuggestionReview")) {
			physiqueExamination.setGuideSuggestionReview(oldPhyExam.getGuideSuggestionReview());
		}
		if (!ArrayUtil.contains(properties, "guideSuggestionReferral")) {
			physiqueExamination.setGuideSuggestionReferral(oldPhyExam.getGuideSuggestionReferral());
		}
		if (!ArrayUtil.contains(properties, "riskQuitSmoking")) {
			physiqueExamination.setRiskQuitSmoking(oldPhyExam.getRiskQuitSmoking());
		}
		if (!ArrayUtil.contains(properties, "riskHealthDrink")) {
			physiqueExamination.setRiskHealthDrink(oldPhyExam.getRiskHealthDrink());
		}
		if (!ArrayUtil.contains(properties, "riskDiet")) {
			physiqueExamination.setRiskDiet(oldPhyExam.getRiskDiet());
		}
		if (!ArrayUtil.contains(properties, "riskExercise")) {
			physiqueExamination.setRiskExercise(oldPhyExam.getRiskExercise());
		}
		if (!ArrayUtil.contains(properties, "riskWeightReduction")) {
			physiqueExamination.setRiskWeightReduction(oldPhyExam.getRiskWeightReduction());
		}
		if (!ArrayUtil.contains(properties, "riskQuitSmoking")) {
			physiqueExamination.setRiskQuitSmoking(oldPhyExam.getRiskQuitSmoking());
		}
		if (!ArrayUtil.contains(properties, "guideVaccination")) {
			physiqueExamination.setGuideVaccination(oldPhyExam.getGuideVaccination());
		}
		if (!ArrayUtil.contains(properties, "guideVaccinationDesc")) {
			physiqueExamination.setGuideVaccinationDesc(oldPhyExam.getGuideVaccinationDesc());
		}
		if (!ArrayUtil.contains(properties, "riskOther")) {
			physiqueExamination.setRiskOther(oldPhyExam.getRiskOther());
		}
		if (!ArrayUtil.contains(properties, "riskOtherDesc")) {
			physiqueExamination.setRiskOtherDesc(oldPhyExam.getRiskOtherDesc());
		}

		//occupationExposureFlag
		physiqueExamination.setOccupationExposureFlag(oldPhyExam.getOccupationExposureFlag());
		physiqueExamination.setRiskOccupationDesc(oldPhyExam.getRiskOccupationDesc());
		physiqueExamination.setRiskOccupationTime(oldPhyExam.getRiskOccupationTime());
		physiqueExamination.setDustTypeDesc(oldPhyExam.getDustTypeDesc());
		physiqueExamination.setDustProtectionFlag(oldPhyExam.getDustProtectionFlag());
		physiqueExamination.setDustProtectionDesc(oldPhyExam.getDustProtectionDesc());
		physiqueExamination.setRadiationTypeDesc(oldPhyExam.getRadiationTypeDesc());
		physiqueExamination.setRadiationProtectionFlag(oldPhyExam.getRadiationProtectionFlag());
		physiqueExamination.setRadiationProtectionDesc(oldPhyExam.getRadiationProtectionDesc());
		physiqueExamination.setPhysicsTypeDesc(oldPhyExam.getPhysicsTypeDesc());
		physiqueExamination.setPhysicsProtectionFlag(oldPhyExam.getPhysicsProtectionFlag());
		physiqueExamination.setPhysicsProtectionDesc(oldPhyExam.getPhysicsProtectionDesc());
		physiqueExamination.setChemistryTypeDesc(oldPhyExam.getChemistryTypeDesc());
		physiqueExamination.setChemistryProtectionFlag(oldPhyExam.getChemistryProtectionFlag());
		physiqueExamination.setChemistryProtectionDesc(oldPhyExam.getChemistryProtectionDesc());
		physiqueExamination.setOtherTypeDesc(oldPhyExam.getOtherTypeDesc());
		physiqueExamination.setOtherProtectionFlag(oldPhyExam.getOtherProtectionFlag());
		physiqueExamination.setOtherProtectionDesc(oldPhyExam.getOtherProtectionDesc());

		physiqueExamination.setManaDoctorId(oldPhyExam.getManaDoctorId());
	}

	/**
	 * 内部方法，插入健康体检表表中除体格检查表外其他内容
	 *
	 * @param personalPhyExamDTO
	 *            the personal phy exam dTO
	 * @param personId
	 *            the person id
	 * @param ehrId
	 *            the ehr id
	 */
	private void insertPhysicalOfOther(PersonalPhyExamDTO personalPhyExamDTO, Long personId, String ehrId) {
		/* 住院史新增 */
		if (personalPhyExamDTO.getHospitalizedHistoryFlg().equals("1")) {
			createHospitalizedHistory(personalPhyExamDTO, personId, ehrId);
		}

		/* 家庭病床 */
		if (personalPhyExamDTO.getFamilyBedHistoryFlg().equals("1")) {
			createFamilyBedHistory(personalPhyExamDTO, personId, ehrId);
		}

		/* 用药新增 */
		if (personalPhyExamDTO.getDrugHistoryFlag().equals("1")) {
			createDrugUsage(personalPhyExamDTO, personId, ehrId);
		}
		/* 预防接种新增 */
		if (personalPhyExamDTO.getVaccinationInfoFlg().equals("1")) {
			createVaccinationInfo(personalPhyExamDTO, personId, ehrId);
		}

		/* 新增健康评价异常 */
		if (personalPhyExamDTO.getHealthEvaluateAnomalyFlg().equals("1")) {
			createHealthEvaluateAnomaly(personalPhyExamDTO, ehrId);
		}
	}

	@Transactional
	public void updatePersonFilingFlag(Long personId, String filingFlag) {
		personInfoDao.update(new Parameters("filingFlag", filingFlag), new Criteria("id", personId));
	}

	/**
	 * 修改个人档案-封面
	 *
	 * @param personInfo
	 * @return boolean
	 */
	@Transactional
	public boolean updateCoverTran(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo, String... properties) {

		if (ObjectUtil.isNotEmpty(personInfo.getId()) && StringUtil.isNullOrEmpty(personInfo.getHealthFileNo())) { // 未建档档案增加ehrNo，并且添加记录到EhrHealthEvent
			String ehrNo = EHRNumberService.getSerialNum(personInfo.getPastreet(), EHRConstants.EHR_NUMBER_TYPE);
			if(StringUtil.isNullOrEmpty(ehrNo))
				return false;
			personInfo.setHealthFileNo(ehrNo);
			createOrUpdateEhrHealthEvent(EventType.PERSON_RECORD_COVER.getCode(), "个人档案封面", personInfo);
		}

		// 单独处理迁档记录
		PersonInfo oldPerson = personInfoDao.get(personInfo.getId());
		int oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
		if (ObjectUtil.isNotEmpty(oldPerson)) {
			String OldInputOrganCode = oldPerson.getInputOrganCode();
			String newInputOrganCode = personInfo.getInputOrganCode();
			if (ObjectUtil.isNotEmpty(OldInputOrganCode) && ObjectUtil.isNotEmpty(newInputOrganCode) && !newInputOrganCode.equals(OldInputOrganCode)) {
				ModifyTrace modifyTrace = new ModifyTrace();
				modifyTrace.setItemCode(null);
				modifyTrace.setItemName("管理机构");
				modifyTrace.setOldValue(oldPerson.getInputOrganName());
				modifyTrace.setNewValue(personInfo.getInputOrganName());
				modifyTrace.setInputDate(new Date());
				modifyTrace.setPersonId(personInfo.getId());
				modifyTrace.setRegionType(EventType.PERSON_RECORD_BASIC_INFO.getCode());
				modifyTrace.setRegionName("个人基本信息表");
				modifyTrace.setInputName(personInfo.getUpdateName());
				modifyTrace.setInputOrg(personInfo.getUpdateOrganName());
				//add by yejianfei 20140724
				modifyTrace.setInputUserId(personInfo.getUpdateInputerId());
				modifyTrace.setInputOrgCode(personInfo.getUpdateOrganCode());
				//add by yejianfei 20140724
				modifyTraceService.setModifyTrace(modifyTrace);

				// 档案迁出的统计
				Organization org = new Organization();
				org.setOrganCode(oldPerson.getInputOrganCode());
				org.setOrganName(oldPerson.getInputOrganName());
				statisticsService
						.syncStatisticsData(org, personInfo.getHouseholdType().equals("1") ? StatisticsUtil.HR_ARCHIVE_EMIGRATION : StatisticsUtil.UNHR_ARCHIVE_EMIGRATION, StatisticsUtil.ADD);

				// 档案迁移记录
				savePersonMoveRecord(oldPerson, personInfo);

				// 处理档案迁移
				PersonInfo per = personInfoDao.get(new Criteria("id", personInfo.getId()), "smpiId");
				Organization oldOrg = organizationApp.queryOrgan(oldPerson.getInputOrganCode());
				Organization newOrg = organizationApp.queryOrgan(personInfo.getInputOrganCode());

				if (ObjectUtil.isNotEmpty(per) && ObjectUtil.isNotEmpty(oldOrg)) {
					personRecordMove(personInfo.getId(), per.getSmpiId(), oldOrg, newOrg);
				}
				if(ObjectUtil.equals(personInfo.getFilingFlag(), EHRConstants.MOVE_OUT)) {
					personInfo.setFilingFlag(EHRConstants.HAD_CREATE);
				}
				if(oldStar <= 1 || ObjectUtil.equals(oldPerson.getFilingFlag(), EHRConstants.UN_CREATE)) {
					properties = this.getUpdateProperties(properties);
				}
			}else if (newInputOrganCode.equals(OldInputOrganCode)){
				personInfo.setFilingFlag(EHRConstants.HAD_CREATE);
				//二星以下页面中建档人可编辑所以更新字段应该添加相应字段
				if(ObjectUtil.equals(oldPerson.getFilingFlag(), EHRConstants.UN_CREATE)) {
					properties = this.getUpdateProperties(properties);
				} else {
					properties = this.addCreateIdProperties(properties);
				}
			} else if ((ObjectUtil.isNotEmpty(oldPerson.getId()) && StringUtil.isNullOrEmpty(oldPerson.getHealthFileNo()))
					|| ObjectUtil.equals(oldPerson.getFilingFlag(), EHRConstants.UN_CREATE)) { // 未建档档案增加ehrNo，并且添加记录到EhrHealthEvent
					/*jianghaiying 2018/07/30 mantis编号0121228
					需求变更 当星级达到二星后建档人、建档单位、建档日期将不能再做修改（包含页面和迁档）
					*/
				setCreateInfo(personInfo, currentLoginInfo);
				properties = this.getUpdateProperties(properties);
			} else {
                //二星以下页面中建档人可编辑所以更新字段应该添加相应字段
                properties = this.addCreateIdProperties(properties);
            }
			Staff staff = staffService.getStaff(personInfo.getCreateId());
			if(ObjectUtil.isNotEmpty(staff)) {
				personInfo.setCreateName(staff.getName());
				personInfo.setCreateIdcard(staff.getIdCard());
			}
		}
		// 星级统计
		if (!(isLess20Student(personInfo.getBirthday(), personInfo.getIdcard()) && ObjectUtil.isNotEmpty(oldPerson.getStar()) && EHRConstants.THREE_STAR == oldPerson.getStar())) {
			PersonalBasicInfoDTO personalBasicInfoDTO = new PersonalBasicInfoDTO();
			personalBasicInfoDTO.setPersonInfo(personInfo);

			personInfo.setTwoStarDisplayScore(oldPerson.getTwoStarDisplayScore());
			personInfo.setThreeStarScore(oldPerson.getThreeStarScore());
			personInfo.setStar(oldPerson.getStar());
			if(ObjectUtil.isNullOrEmpty(personInfo.getCreateId())) {
				personInfo.setCreateId(oldPerson.getCreateId());
			}
			recordStarService.calOneStarRecord(personalBasicInfoDTO);
			personInfo.setStar(personalBasicInfoDTO.getPersonInfo().getStar());
			personInfo.setOneStarScore(personalBasicInfoDTO.getPersonInfo().getOneStarScore());
			personInfo.setIntegrity(personalBasicInfoDTO.getPersonInfo().getIntegrity());
		} else {
			personInfo.setOneStarScore(oldPerson.getOneStarScore());
			personInfo.setStar(EHRConstants.THREE_STAR);
			personInfo.setIntegrity(oldPerson.getIntegrity());
			personInfo.setStarUpdateDate(oldPerson.getStarUpdateDate());
		}

		List<DmPersonInfo> dmPersonInfoList= dmPersonInfoDao.getList(new Criteria("idCard",personInfo.getIdcard()));
		List<PhysicalExamRecord> physicalExamRecordList= physicalExamRecordDao.getList(new Criteria("personId",personInfo.getId()));
		if(ObjectUtil.isNotEmpty(dmPersonInfoList)){
			for (int i = 0; i < dmPersonInfoList.size(); i++) {
				dmPersonInfoList.get(i).setName(personInfo.getName());
				dmPersonInfoList.get(i).setPhoneNumber(personInfo.getPhoneNumber());
				dmPersonInfoDao.update(dmPersonInfoList.get(i));
			}

		}if(ObjectUtil.isNotEmpty(physicalExamRecordList)){
			for (int i = 0; i < physicalExamRecordList.size(); i++) {
				physicalExamRecordList.get(i).setName(personInfo.getName());
				String[] pro = {"name"};
				physicalExamRecordDao.update(physicalExamRecordList.get(i),pro);
			}

		}

		//保存封面修改痕迹
		String[] propertiesForCover = {"name", "paAddress", "hrAddress", "householdType", "phoneNumber", "poverty", "disabled", "veryPoverty", "guardianPhoneOne", "inputName", "inputDate", "createName", "remarks"};
		modifyTraceService.executeCover(personInfo, propertiesForCover);

		int count = 0;
		count = personInfoDao.update(personInfo, properties);
		Integer newStar = personInfo.getStar();
		//TODO 园区是首页不算星级 每个地方不同有待完善
		syncWork(personInfo.getUpdateOrganCode(), personInfo.getUpdateInputerId(), personInfo.getId(),oldStar, newStar);
		// 记录修改痕迹？？？
		return count > 0 ? true : false;

	}

    /**
     * 二星以下页面中建档人可编辑所以更新字段应该添加相应字段
     * @param properties
     * @return
     */
    private String[] addCreateIdProperties(String... properties) {
        String newProperties[];
        if (ObjectUtil.isNotEmpty(properties) && (properties.length > 0)) {
            newProperties = new String[properties.length+3];
            newProperties[0] = "createIdcard";
            newProperties[1] = "createId";
            newProperties[2] = "createName";
            int i = 3;
            for (String property : properties) {
                newProperties[i] = property;
                i++;
            }
        } else {
            return properties;
        }
        return newProperties;
    }

	private String[] getUpdateProperties(String... properties) {
		String newProperties[];
		if (ObjectUtil.isNotEmpty(properties) && (properties.length > 0)) {
			newProperties = new String[properties.length+8];
			newProperties[0] = "createIdcard";
			newProperties[1] = "createId";
			newProperties[2] = "createName";
			newProperties[3] = "createCenterOrganCode";
			newProperties[4] = "createGbcode";
			newProperties[5] = "createOrganCode";
			newProperties[6] = "createOrganName";
			newProperties[7] = "createDate";
			int i = 8;
			for (String property : properties) {
				newProperties[i] = property;
				i++;
			}
		} else {
			return properties;
		}
		return newProperties;
	}
	public boolean upateCover(PersonInfo personInfo, CurrentLoginInfo currentLoginInfo, String... properties) {
		synchronized (PersonalRecordManagmentServiceImpl.class){
			return updateCoverTran(personInfo, currentLoginInfo, properties);
		}
	}

	/**
	 * 修改个人档案-基本信息
	 *
	 * @param personalBasicInfoDTO
	 * @return boolean
	 */
	@Transactional
	public boolean upateBasicInfo(PersonalBasicInfoDTO personalBasicInfoDTO) {
		boolean result = true;
		// 个人基本信息的部分更新
		PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
		// 费用支付方式
		String expenseInfoStr = personalBasicInfoDTO.getExpenseInfoStr();
		if (expenseInfoStr != null) {
			String[] strArr = expenseInfoStr.split(",");
			if (strArr != null && strArr.length > 0) {
				for (int i = 0; i < strArr.length; i++) {
					switch (strArr[i]) {
						case "01":
							personInfo.setPaymentUrbanWorkders(strArr[i]);
							break;
						case "02":
							personInfo.setPaymentUrbanResident(strArr[i]);
							break;
						case "03":
							personInfo.setPaymentNewRuralCooperation(strArr[i]);
							break;
						case "04":
							personInfo.setPaymentPovertyRelief(strArr[i]);
							break;
						case "05":
							personInfo.setPaymentCommercial(strArr[i]);
							break;
						case "06":
							personInfo.setPaymentBursary(strArr[i]);
							break;
						case "07":
							personInfo.setPaymentPersonalExpenses(strArr[i]);
							break;
						case "99":
							personInfo.setPaymentOther(strArr[i]);
							break;
					}
				}
			}
		}
		personInfoDao.update(personInfo);
		// 根据事件类型，人员标识符逻辑删除个人基本信息表数据
		EHRHealthEvent healthEvent = ((PersonalBasicInfoDTO) personalBasicInfoDTO).getEhrHeathEvent();
		String ehrId = healthEvent.getEhrId();
		this.updateBasicInfoWithOutPersonInfo(ehrId, personInfo.getId());
		// 记录修改痕迹(后续考虑，暂不开展)
		insertBasicInfoWithOutPersonInfo((PersonalBasicInfoDTO) personalBasicInfoDTO, ehrId, personInfo);
		return result;
	}

	/**
	 * 修改个人档案-健康体检
	 *
	 * @param personalPhyExam
	 * @return boolean
	 */
	@Transactional
	public boolean updatePhysical(PersonalPhyExamDTO personalPhyExam) {
		boolean result = true;
		// 根据事件类型，人员标识符逻辑删除健康体检表数据
		EHRHealthEvent healthEvent = personalPhyExam.getEhrHeathEvent();
		String ehrId = healthEvent.getEhrId();
		this.updateBasicInfoWithOutPersonInfo(ehrId, personalPhyExam.getPersonInfo().getId());
		// 记录修改痕迹(后续考虑)
		insertPhysicalOfOther(personalPhyExam, personalPhyExam.getPersonInfo().getId(), ehrId);
		return result;
	}

	/**
	 * 查询个人档案-封面
	 *
	 * @param criteria
	 * @return PersonInfo
	 */
	@Override
	public PersonInfo getPersonalCover(Criteria criteria) {
		// 根据条件查询人员基本信息
		return personInfoDao.get(criteria);
	}

	/**
	 * 查询个人档案-基本信息
	 *
	 * @param criteria
	 * @return PersonalBasicInfoDTO
	 */
	@Override
	public PersonalBasicInfoDTO getPersonalBasicInfo(Criteria criteria) {
		PersonalBasicInfoDTO result = new PersonalBasicInfoDTO();
		PersonInfo personInfo = personInfoDao.get(criteria);
		if (personInfo != null) {
			if (personInfo.getBirthday() == null && personInfo.getIdcard() != null)
				personInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(personInfo.getIdcard()));
			if (personInfo.getGender() == null && personInfo.getIdcard() != null)
				personInfo.setGender(IDCardUtil.getGenderByIdCard(personInfo.getIdcard()));
			result.setPersonInfo(personInfo);

			Long personId = personInfo.getId();
			Criteria cri = new Criteria();
			cri.add("personId", personId);
			cri.add("ehrType", EventType.PERSON_RECORD_BASIC_INFO.getCode());
			EHRHealthEvent healthEvent = ehrHealthEventDao.get(cri);

			Criteria criSearch = new Criteria();
			if (healthEvent != null) {
				String ehrId = healthEvent.getEhrId();
				criSearch.add("ehrId", ehrId);
			} else
				criSearch.add("ehrId", "error");
			criSearch.add("personId", personId);
			// 费用支付方式表
			// List<ExpenseInfo> expenseInfoList =
			// expenseInfoDao.getList(criSearch);
			// if (expenseInfoList != null && expenseInfoList.size() > 0) {
			// StringBuffer sbExpense = new StringBuffer();
			// for (ExpenseInfo expenseInfo : expenseInfoList)
			// sbExpense.append(expenseInfo.getMedicalPayWay() + ",");
			// result.setExpenseInfoStr(sbExpense.substring(0,
			// sbExpense.length() - 1));
			// }
			StringBuffer sbExpense = new StringBuffer();
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentUrbanWorkders()) && "01".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentUrbanWorkders()))) {
				sbExpense.append(personInfo.getPaymentUrbanWorkders() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentUrbanResident()) && "02".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentUrbanResident()))) {
				sbExpense.append(personInfo.getPaymentUrbanResident() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentNewRuralCooperation()) && "03".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentNewRuralCooperation()))) {
				sbExpense.append(personInfo.getPaymentNewRuralCooperation() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentPovertyRelief()) && "04".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentPovertyRelief()))) {
				sbExpense.append(personInfo.getPaymentPovertyRelief() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentCommercial()) && "05".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentCommercial()))) {
				sbExpense.append(personInfo.getPaymentCommercial() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentBursary()) && "06".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentBursary()))) {
				sbExpense.append(personInfo.getPaymentBursary() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentPersonalExpenses()) && "07".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentPersonalExpenses()))) {
				sbExpense.append(personInfo.getPaymentPersonalExpenses() + ",");
			}
			if (ObjectUtil.isNotEmpty(personInfo.getPaymentOther()) && "99".equals(StringUtil.trimAllWhitespace(personInfo.getPaymentOther()))) {
				sbExpense.append(personInfo.getPaymentOther() + ",");
			}
			if (sbExpense.length() > 0) {
				result.setExpenseInfoStr(StringUtil.trimAllWhitespace(sbExpense.substring(0, sbExpense.length() - 1)));
			}

			// 药物过敏史
			getDrugAllergyHistoryList(result, criSearch);
			// 暴露史
			getExposeHistoryList(result, criSearch);

			// 既往疾病史
			getDiseaseHistoryList(result, criSearch);

			// 既往手术史
			getSurgeryHistoryList(result, criSearch);

			// 外伤史
			getTraumaHistoryList(result, criSearch);

			// 输血史
			getTransBloodHistoryList(result, criSearch);

			// 家族遗传病史
			getFamilyHeredityHistoryList(result, criSearch);

			// 残疾史
			getDeformityHistoryList(result, criSearch);
			// 家族史
			getFamilyHistory(result, criSearch);
		}
		return result;
	}

	@Override
	public void getDeformityHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<DeformityHistory> deformityHistoryList = deformityHistoryDao.getList(criSearch);
		if (deformityHistoryList != null && deformityHistoryList.size() > 0) {
			result.setDeformityFlag(deformityHistoryList.get(0).getDeformityFlag());
			result.setDeformityHistory(deformityHistoryList.get(0));
		}
	}

	@Override
	public void getFamilyHeredityHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<FamilyHeredityHistory> familyHeredityHistoryList = familyHeredityHistoryDao.getList(criSearch);
		if (familyHeredityHistoryList != null && familyHeredityHistoryList.size() > 0) {
			result.setFamilyHeredityHistoryFlag(EHRConstants.HAVE);
		} else {
			result.setFamilyHeredityHistoryFlag(EHRConstants.UN_HAVE);
			familyHeredityHistoryList.add(new FamilyHeredityHistory());
		}
		result.setFamilyHeredityHistoryList(familyHeredityHistoryList);
	}

	@Override
	public void getExposeHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<ExposeHistory> exposeHistoryList = exposeHistoryDao.getList(criSearch);
		if (exposeHistoryList != null && exposeHistoryList.size() > 0) {
			result.setExposeHistoryFlag(exposeHistoryList.get(0).getExposeFlag());
			result.setExposeHistory(exposeHistoryList.get(0));
		}
	}

	@Override
	public void getFamilyHistory(PersonalBasicInfoDTO result, Criteria criSearch) {
		// 父亲
		criSearch.add("relation", "01");
		List<FamilyHistory> fatherList = familyHistoryDao.getList(criSearch);
		String fatherFlag = null;
		if (fatherList != null && fatherList.size() > 0) {
			fatherFlag = EHRConstants.HAVE;
			StringBuffer sbFather = new StringBuffer();
			for (FamilyHistory familyHistory : fatherList) {
				sbFather.append(familyHistory.getDiseaseCode() + ",");
			}
			result.setFatherFlag(fatherFlag);
			result.setFatherStr(sbFather.substring(0, sbFather.length() - 1));
			if(StringUtil.isNotEmpty(fatherList.get(0).getOtherDisease())){
				result.setFatherStrDesc(fatherList.get(0).getOtherDisease());
			}
		}
		// 母亲
		criSearch.add("relation", "02");
		List<FamilyHistory> motherList = familyHistoryDao.getList(criSearch);
		String motherFlag = null;
		if (motherList != null && motherList.size() > 0) {
			motherFlag = EHRConstants.HAVE;
			StringBuffer sbMother = new StringBuffer();
			for (FamilyHistory familyHistory : motherList) {
				sbMother.append(familyHistory.getDiseaseCode() + ",");
			}
			result.setMotherFlag(motherFlag);
			result.setMotherStr(sbMother.substring(0, sbMother.length() - 1));
			if(StringUtil.isNotEmpty(motherList.get(0).getOtherDisease())){
				result.setMotherStrDesc(motherList.get(0).getOtherDisease());
			}
		}
		// 兄妹
		criSearch.add("relation", "03");
		List<FamilyHistory> brotherList = familyHistoryDao.getList(criSearch);
		String brotherFlag = null;
		if (brotherList != null && brotherList.size() > 0) {
			brotherFlag = EHRConstants.HAVE;
			StringBuffer sbBrother = new StringBuffer();
			for (FamilyHistory familyHistory : brotherList) {
				sbBrother.append(familyHistory.getDiseaseCode() + ",");
			}
			result.setBrotherFlag(brotherFlag);
			result.setBrotherStr(sbBrother.substring(0, sbBrother.length() - 1));
			if(StringUtil.isNotEmpty(brotherList.get(0).getOtherDisease())){
				result.setBrotherStrDesc(brotherList.get(0).getOtherDisease());
			}
		}
		// 子女
		criSearch.add("relation", "04");
		List<FamilyHistory> childList = familyHistoryDao.getList(criSearch);
		String childFlag = null;
		if (childList != null && childList.size() > 0) {
			childFlag = EHRConstants.HAVE;
			StringBuffer sbChild = new StringBuffer();
			for (FamilyHistory familyHistory : childList) {
				sbChild.append(familyHistory.getDiseaseCode() + ",");
			}
			result.setChildFlag(childFlag);
			result.setChildStr(sbChild.substring(0, sbChild.length() - 1));
			if(StringUtil.isNotEmpty(childList.get(0).getOtherDisease())){
				result.setChildStrDesc(childList.get(0).getOtherDisease());
			}
		}
	}

	@Override
	public void getTransBloodHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<TransBloodHistory> transBloodHistoryList = transBloodHistoryDao.getList(criSearch);
		if (transBloodHistoryList != null && transBloodHistoryList.size() > 0) {
			result.setTransBloodHistoryFlag(EHRConstants.HAVE);
		} else {
			result.setTransBloodHistoryFlag(EHRConstants.UN_HAVE);
			transBloodHistoryList.add(new TransBloodHistory());
		}
		result.setTransBloodHistoryList(transBloodHistoryList);
	}

	@Override
	public void getTraumaHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<TraumaHistory> traumaHistoryList = traumaHistoryDao.getList(criSearch);
		if (traumaHistoryList != null && traumaHistoryList.size() > 0) {
			result.setTraumaHistoryFlag(EHRConstants.HAVE);
		} else {
			result.setTraumaHistoryFlag(EHRConstants.UN_HAVE);
			traumaHistoryList.add(new TraumaHistory());
		}
		result.setTraumaHistoryList(traumaHistoryList);
	}

	@Override
	public void getSurgeryHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<SurgeryHistory> surgeryHistoryList = surgeryHistoryDao.getList(criSearch);
		if (surgeryHistoryList != null && surgeryHistoryList.size() > 0) {
			result.setSurgeryHistoryFlag(EHRConstants.HAVE);
		} else {
			result.setSurgeryHistoryFlag(EHRConstants.UN_HAVE);
			surgeryHistoryList.add(new SurgeryHistory());
		}
		result.setSurgeryHistoryList(surgeryHistoryList);
	}

	@Override
	public void getDiseaseHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		criSearch.add(new Criteria("IS_DELETE", EHRConstants.DELETE_FLG_0).add(LOP.OR, "isDelete", OP.IS,"NULL"));
		List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getList(criSearch);
		//疾病史有关慢病的优先使用慢病管理卡 jianghaiying
		Criteria criteria = new Criteria("idcard", result.getPersonInfo().getIdcard());
		criteria.add(getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo = dmDiseaseInfoDao.get(criteria);
		if(ObjectUtil.isNotEmpty(diseaseInfo)) {
			result.setDiseaseHistoryFlag(EHRConstants.HAVE);
			if(ObjectUtil.equals(diseaseInfo.getHbpFlag(), EHRConstants.DM_MANAGED_FLAG)) {
				result.setGxy("201");
				result.setGxyDate(diseaseInfo.getHbpDiagnosedDate());
			}
			if(ObjectUtil.equals(diseaseInfo.getDiFlag(), EHRConstants.DM_MANAGED_FLAG)) {
				result.setTnb("202");
				result.setTnbDate(diseaseInfo.getDiDiagnosedDate());
			}
			if(ObjectUtil.equals(diseaseInfo.getStrokeFlag(), EHRConstants.DM_MANAGED_FLAG)) {
				result.setNzz("206");
				result.setNzzDate(diseaseInfo.getStrokeDiagnosisDate());
			}
			if(ObjectUtil.equals(diseaseInfo.getCoronaryFlag(), EHRConstants.DM_MANAGED_FLAG)) {
				result.setGxb("203");
				result.setGxbDate(diseaseInfo.getCoronaryDiagnosisDate());
			}
			//ICD-10编码
			String tumorCode=diseaseInfo.getTumorIcdTenCode();
			if(ObjectUtil.equals(diseaseInfo.getTumorFlag(), EHRConstants.DM_MANAGED_FLAG) && tumorCode!=null&&tumorCode.startsWith("C")) {
				result.setExzl("205");
				result.setExzlName(diseaseInfo.getTumorType());
				result.setExzlDate(diseaseInfo.getTumorDiagnosisDate());
			}
		}
		if (diseaseHistoryList != null && diseaseHistoryList.size() > 0) {
			result.setDiseaseHistoryFlag(EHRConstants.HAVE);
			for (DiseaseHistory diseaseHistory : diseaseHistoryList) {
				String diseaseCode = diseaseHistory.getDiseaseCode();
				Date confirmDate = diseaseHistory.getConfirmationDate();
				String other = diseaseHistory.getOtherDesc();
				if (diseaseCode.equals("201")) {
					result.setGxy(diseaseCode);
					result.setGxyDate(confirmDate);
				}
				if (diseaseCode.equals("202")) {
					result.setTnb(diseaseCode);
					result.setTnbDate(confirmDate);
				}
				if (diseaseCode.equals("203")) {
					result.setGxb(diseaseCode);
					result.setGxbDate(confirmDate);
				}
				if (diseaseCode.equals("204")) {
					result.setFjb(diseaseCode);
					result.setFjbDate(confirmDate);
				}
				if (diseaseCode.equals("205")) {
					result.setExzl(diseaseCode);
					result.setExzlDate(confirmDate);
					result.setExzlName(diseaseHistory.getDiseaseName());
				}
				if (diseaseCode.equals("206")) {
					result.setNzz(diseaseCode);
					result.setNzzDate(confirmDate);
				}
				if (diseaseCode.equals("207")) {
					result.setZxjsb(diseaseCode);
					result.setZxjsbDate(confirmDate);
				}
				if (diseaseCode.equals("208")) {
					result.setJhb(diseaseCode);
					result.setJhbDate(confirmDate);
				}
				if (diseaseCode.equals("209")) {
					result.setGy(diseaseCode);
					result.setGyDate(confirmDate);
				}
//				if (diseaseCode.equals("210")) {
//					result.setXtjx(diseaseCode);
//					result.setXtjxDate(confirmDate);
//				}
				if (diseaseCode.equals("212")) {
					result.setQtidm(diseaseCode);
					result.setQtidmDate(confirmDate);
				}
				if (diseaseCode.equals("213")) {
					result.setZyb(diseaseCode);
					result.setZybName(diseaseHistory.getDiseaseName());
					result.setZybDate(confirmDate);
				}
				if (diseaseCode.equals("211")) {
					result.setQt(diseaseCode);
					result.setQtxx(other);
					result.setQtDate(confirmDate);
				}
			}
		}
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param flagValue 此值的可能值 EHRConstants.DM_MANAGED_FLAG EHRConstants.DELETE_FLG_0
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String flagValue) {
		Criteria criteria = new Criteria();
		criteria.add("hbp_flag", flagValue);
		criteria.add(LOP.OR, "di_flag", flagValue);
		criteria.add(LOP.OR, "stroke_flag", flagValue);
		criteria.add(LOP.OR, "coronary_flag", flagValue);
		criteria.add(LOP.OR, "tumor_flag", flagValue);
		return criteria;
	}

	@Override
	public void getDrugAllergyHistoryList(PersonalBasicInfoDTO result, Criteria criSearch) {
		List<DrugAllergyHistory> drugAllergyHistoryList = drugAllergyHistoryDao.getList(criSearch);
		if (drugAllergyHistoryList != null && drugAllergyHistoryList.size() > 0) {
			StringBuffer sbDrugAllergyHistory = new StringBuffer();
			String allergensFlag = null;
			for (DrugAllergyHistory drugAllergyHistory : drugAllergyHistoryList) {
				allergensFlag = drugAllergyHistory.getAllergensFlag();
				if(ObjectUtil.equals(drugAllergyHistory.getAllergensCode(), EHRConstants.DRUG_ALLERGY_HISTORY_OTHER)) {
					result.setDrugAllergyHistoryOtherDesc(drugAllergyHistory.getOtherDesc());
				}
				if (allergensFlag.equals(EHRConstants.UN_HAVE))
					break;
				else
					sbDrugAllergyHistory.append(drugAllergyHistory.getAllergensCode() + ",");
			}
			result.setDrugAllergyHistoryFlag(allergensFlag);
			if (allergensFlag.equals(EHRConstants.HAVE))
				result.setDrugAllergyHistoryStr(sbDrugAllergyHistory.substring(0, sbDrugAllergyHistory.length() - 1));
		}
	}

	/**
	 * 查询个人档案-健康体检
	 *
	 * @param criteria
	 * @return PersonalPhyExamDTO
	 */
	public PersonalPhyExamDTO getPersonalPhysical(Criteria criteria) {
		return getPersonalPhysical(criteria, null);
	}

	@Override
	public PersonalPhyExamDTO getPersonalPhysical(Criteria criteria, String ehrId) {
		PersonalPhyExamDTO result = new PersonalPhyExamDTO();

		/* 个人信息 */
		PersonInfo personInfo = personInfoDao.get(criteria);
		if(ObjectUtil.isNullOrEmpty(personInfo)){
			return null;
		}
		result.setPersonInfo(personInfo);
		Long personId = personInfo.getId(); // 个人ID

		/* 获取最新的活动数据 如果获取不到则返回空值 */
		Criteria eventCritera = new Criteria("personId", personId)
				.add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode());
		if (StringUtil.isNotEmpty(ehrId)) {
			eventCritera.add("ehrId", ehrId);
		}
		List<EHRHealthEvent> ehrHealthEvents = ehrHealthEventDao.getList(eventCritera, new Order("CLINIC_DATE", false));
		if(ObjectUtil.isNullOrEmpty(ehrHealthEvents) || ObjectUtil.isNullOrEmpty(ehrHealthEvents.get(0))) {
			return null;
		}
		EHRHealthEvent ehrHealthEvent = ehrHealthEvents.get(0);
		ehrId = ehrHealthEvent.getEhrId(); // 活动索引号

		Criteria ca = new Criteria("personId", personId).add("ehrId", ehrId);
		// *获取体检数据*/
		PhysiqueExamination phyExam = physiqueExaminationDao.get(ca);
		User user = null;
		if (null != phyExam) {
			Staff staff = staffService.getStaffMain(phyExam.getManaDoctorId());
			if (ObjectUtil.isNotEmpty(user)) {
				phyExam.setManaDoctorName(staff.getName());
			}
			result.setPhysiqueExamination(phyExam);
		} else {
			phyExam = new PhysiqueExamination();
		}
		//若健康档案第二页，既往史疾病中勾选了‘高血压’、‘糖尿病’、‘重性精神病’中的任何一种，第三页‘纳入慢性病患者健康管理’默认勾选
		Criteria criteriaDis = new Criteria("personId", personId);
		EHRHealthEvent ehrHealthEventBasic = ehrHealthEventDao.get(new Criteria("EHR_TYPE", EventType.PERSON_RECORD_BASIC_INFO.getCode()).add(criteriaDis));
		if(ObjectUtil.isNotEmpty(ehrHealthEventBasic)) {
			List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getList(criteriaDis.add("ehrId", ehrHealthEventBasic.getEhrId()));
			for(DiseaseHistory diseaseHistory : diseaseHistoryList) {
				String diseaseCode = diseaseHistory.getDiseaseCode();
				Date confirmDate = diseaseHistory.getConfirmationDate();
				String other = diseaseHistory.getOtherDesc();
				if (diseaseCode.equals("201")|| //高血压
						diseaseCode.equals("202") || //糖尿病
						diseaseCode.equals("207")) {//重性精神病
					phyExam.setGuideIntoChronicDisease("1");
				}
			}
		}

		/* 住院史新增 */
		List<HospitalizedHistory> hospitalizedHistoryList = hospitalizedHistoryDao.getList(ca);
		if (null != hospitalizedHistoryList && hospitalizedHistoryList.size() > 0) {
			if (hospitalizedHistoryList.size() < 3) {
				for (int i = 0; i <= (3 - hospitalizedHistoryList.size()); i++)
					hospitalizedHistoryList.add(new HospitalizedHistory());
			}
			result.setHospitalizedHistoryList(hospitalizedHistoryList);
			result.setHospitalizedHistoryFlg("1");
		}

		/* 用药新增 */
		List<DrugHistory> drugHistoryList = drugHistoryDao.getList(ca);
		if (null != drugHistoryList && drugHistoryList.size() > 0) {
			if (drugHistoryList.size() < 5) {
				int total = 5 - drugHistoryList.size();
				for (int i = 0; i < total; i++)
					drugHistoryList.add(new DrugHistory());
			}
			result.setDrugHistoryList(drugHistoryList);
			result.setDrugHistoryFlag("1");
		}

		/* 预防接种新增 */
		List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(ca);
		if (null != vaccinationInfoList && vaccinationInfoList.size() > 0) {
			if (vaccinationInfoList.size() < 4) {
				for (int i = 0; i <= (4 - vaccinationInfoList.size()); i++)
					vaccinationInfoList.add(new VaccinationInfo());
			}
			result.setVaccinationInfoList(vaccinationInfoList);
			result.setVaccinationInfoFlg("1");
		}

		/* 家庭病床 */
		List<FamilyBedHistory> familyBedHistoryList = familyBedHistoryDao.getList(ca);
		if (null != familyBedHistoryList && familyBedHistoryList.size() > 0) {
			if (familyBedHistoryList.size() < 3) {
				for (int i = 0; i <= (3 - familyBedHistoryList.size()); i++)
					familyBedHistoryList.add(new FamilyBedHistory());
			}
			result.setFamilyBedHistoryList(familyBedHistoryList);
			result.setFamilyBedHistoryFlg("1");
		}

		/* 健康异常 */
		if (null != phyExam && null != phyExam.getId()) {
			List<HealthEvaluateAnomaly> healthEvaluateAnomalyList = healthEvaluateAnomalyDao.getList(new Criteria("ehrId", phyExam.getEhrId()),new Order("SORT") );
			if (null != healthEvaluateAnomalyList && healthEvaluateAnomalyList.size() > 0) {
				if (healthEvaluateAnomalyList.size() < 4) {
					List<Integer> list = new ArrayList<>();
					for(HealthEvaluateAnomaly hea :healthEvaluateAnomalyList){
						list.add(hea.getSort());
					}
					for (int i = 1; i < 5; i++){
						if(!list.contains(i)){
							HealthEvaluateAnomaly hea = new HealthEvaluateAnomaly();
							hea.setSort(i);
							healthEvaluateAnomalyList.add(hea);
						}
					}
					healthEvaluateAnomalyList = getSortList(healthEvaluateAnomalyList);
				}
				result.setHealthEvaluateAnomalyList(healthEvaluateAnomalyList);
				result.setHealthEvaluateAnomalyFlg("1");
			}
			if(!ObjectUtil.isNullOrEmpty(phyExam.getHealthEvaluateCheck()) || !ObjectUtil.isNullOrEmpty(phyExam.getHealthEvaluateOtherDesc())){
				result.setHealthEvaluateAnomalyFlg("1");
			}
		}
		return result;
	}

	private List<HealthEvaluateAnomaly> getSortList(List<HealthEvaluateAnomaly> list){
        Collections.sort(list, new Comparator<HealthEvaluateAnomaly>() {
            @Override
            public int compare(HealthEvaluateAnomaly h1, HealthEvaluateAnomaly h2) {
            	if(ObjectUtil.isNotEmpty(h1.getSort()) && ObjectUtil.isNotEmpty(h2.getSort()))
            		return h1.getSort() - h2.getSort();
            	return 0;
            }
        });
        return list;
    }
	
	/**
	 * 根据personId,获取本年度老年人健康体检信息记录表记录ID
	 *
	 * @param personId
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public Long getExamRecordId(Long personId){
		Long result = null;
		/*老年人健康体检信息记录表 add by yejianfei 2014-04-02*/
		Criteria phCa = new Criteria("personId",personId);
		Date examinationBeginDate = DateUtil.parseDateString(DateUtil.getDateTime("yyyy", new Date()) + "/01/01");;
		Date examinationEndDate = DateUtil.parseDateString(DateUtil.getDateTime("yyyy", new Date()) + "/12/31");
		DateUtil.getCriteriaByDateRange(phCa, "EXAM_YEAR", examinationBeginDate,examinationEndDate);
		PhysicalExamRecord  physicalExamRecord = physicalExamRecordDao.get(phCa,new String[]{"id"});
		if(ObjectUtil.isNotEmpty(physicalExamRecord)){
			result = physicalExamRecord.getId();
		}
		return result;
	}
	/**
	 * Create health evaluate anomaly.
	 *
	 * @param personalPhyExamDTO
	 *            the personal phy exam dTO
	 * @param ehrId
	 *            the ehr id
	 */
	private void createHealthEvaluateAnomaly(PersonalPhyExamDTO personalPhyExamDTO, String ehrId) {
		List<HealthEvaluateAnomaly> healthEvaluateAnomalyList = personalPhyExamDTO.getHealthEvaluateAnomalyList();
		if (null != healthEvaluateAnomalyList && healthEvaluateAnomalyList.size() > 0) {
			List<HealthEvaluateAnomaly> olist = new ArrayList<>();
			for (HealthEvaluateAnomaly heal : healthEvaluateAnomalyList) {
				if (null == heal)
					continue;
				if (StringUtils.isBlank(heal.getHealthEvaluateAnomalyDesc()))
					continue;
				heal.setEhrId(ehrId);
				olist.add(heal);
			}
			healthEvaluateAnomalyDao.batchInsert(olist);
		}
	}

	/**
	 * Create vaccination info.
	 *
	 * @param personalPhyExamDTO
	 *            the personal phy exam dTO
	 * @param personId
	 *            the person id
	 * @param ehrId
	 *            the ehr id
	 */
	private void createVaccinationInfo(PersonalPhyExamDTO personalPhyExamDTO, Long personId, String ehrId) {
		List<VaccinationInfo> vaccinationInfoList = personalPhyExamDTO.getVaccinationInfoList();
		if (vaccinationInfoList != null && vaccinationInfoList.size() > 0) {
			List<VaccinationInfo> olist = new ArrayList<>();
			for (VaccinationInfo vaccinationInfo : vaccinationInfoList) {
				if (null == vaccinationInfo)
					continue;
				if (null == vaccinationInfo.getVaccinationDate() && StringUtils.isBlank(vaccinationInfo.getVaccineName()))
					continue;
				vaccinationInfo.setPersonId(personId);
				vaccinationInfo.setEhrId(ehrId);
				vaccinationInfo.setIsDelete(EHRConstants.DELETE_FLG_0);
				olist.add(vaccinationInfo);
			}
			if (ObjectUtil.isNotEmpty(olist)) {
				for (int i = 0; i < olist.size(); i++) {
					if(ObjectUtil.isNullOrEmpty(olist.get(i).getVaccineName())){
						olist.remove(i);
						i--;
					}
				}
				vaccinationInfoDao.batchInsert(olist);
			}
		}
	}

	/**
	 * Create drug usage.
	 *
	 * @param personalPhyExamDTO
	 *            the personal phy exam dTO
	 * @param personId
	 *            the person id
	 * @param ehrId
	 *            the ehr id
	 */
	private void createDrugUsage(PersonalPhyExamDTO personalPhyExamDTO, Long personId, String ehrId) {
		List<DrugHistory> drugHistoryList = personalPhyExamDTO.getDrugHistoryList();
		if (drugHistoryList != null && drugHistoryList.size() > 0) {
			List<DrugHistory> olist = new ArrayList<>();
			for (DrugHistory drugHistory : drugHistoryList) {
				if (null == drugHistory)
					continue;
				if (StringUtils.isBlank(drugHistory.getDrugGenericName()))
					continue;
				drugHistory.setPersonId(personId);
				drugHistory.setEhrId(ehrId);
				olist.add(drugHistory);
			}
			if (ObjectUtil.isNotEmpty(olist)) {
				for (int i = 0; i < olist.size(); i++) {
					if(ObjectUtil.isNullOrEmpty(olist.get(i).getDrugGenericName())){
						olist.remove(i);
						i--;
					}
				}
				drugHistoryDao.batchInsert(olist);
			}
		}
	}

	/**
	 * Create hospitalized history.
	 *
	 * @param personalPhyExamDTO
	 *            the personal phy exam dTO
	 * @param personId
	 *            the person id
	 * @param ehrId
	 *            the ehr id
	 */
	private void createHospitalizedHistory(PersonalPhyExamDTO personalPhyExamDTO, Long personId, String ehrId) {
		List<HospitalizedHistory> hospitalizedHistoryList = personalPhyExamDTO.getHospitalizedHistoryList();
		if (hospitalizedHistoryList != null && hospitalizedHistoryList.size() > 0) {
			List<HospitalizedHistory> olist = new ArrayList<>();
			for (HospitalizedHistory hospitalizedHistory : hospitalizedHistoryList) {
				if (null == hospitalizedHistory)
					continue;
				if (null == hospitalizedHistory.getInDate() && StringUtils.isBlank(hospitalizedHistory.getMedicalRecordNo()))
					continue;
				hospitalizedHistory.setPersonId(personId);
				hospitalizedHistory.setEhrId(ehrId);
				olist.add(hospitalizedHistory);
			}
			if (ObjectUtil.isNotEmpty(olist)) {
				for (int i = 0; i < olist.size(); i++) {
					if(ObjectUtil.isNullOrEmpty(olist.get(i).getInhosReason())){
						olist.remove(i);
						i--;
					}
				}
				hospitalizedHistoryDao.batchInsert(olist);
			}
		}
	}

	/**
	 * Create family bed history.
	 *
	 * @param personalPhyExamDTO
	 *            the personal phy exam dTO
	 * @param personId
	 *            the person id
	 * @param ehrId
	 *            the ehr id
	 */
	private void createFamilyBedHistory(PersonalPhyExamDTO personalPhyExamDTO, Long personId, String ehrId) {
		List<FamilyBedHistory> familyBedHistoryList = personalPhyExamDTO.getFamilyBedHistoryList();
		if (familyBedHistoryList != null && familyBedHistoryList.size() > 0) {
			List<FamilyBedHistory> olist = new ArrayList<>();
			for (FamilyBedHistory familyBedHistory : familyBedHistoryList) {
				if (null == familyBedHistory)
					continue;
				if (null == familyBedHistory.getBuiltBedDate() && StringUtils.isBlank(familyBedHistory.getMedicalRecordNo()))
					continue;
				familyBedHistory.setEhrId(ehrId);
				familyBedHistory.setPersonId(personId);
				familyBedHistory.setInputDate(new Date());
				olist.add(familyBedHistory);
			}
			if (ObjectUtil.isNotEmpty(olist)) {
				for (int i = 0; i < olist.size(); i++) {
					if(ObjectUtil.isNullOrEmpty(olist.get(i).getBuiltBedReason())){
						olist.remove(i);
						i--;
					}
				}
				familyBedHistoryDao.batchInsert(olist);
			}
		}
	}


	/**
	 * 档案迁移
	 *
	 * @param personId
	 *            the person id
	 * @param smpiId
	 *            the smpi id
	 * @param oldOrg
	 *            the old org
	 * @param newOrg
	 *            the new org
	 */
	private void personRecordMove(Long personId, String smpiId, Organization oldOrg, Organization newOrg) {
		// Criteria criteria =new Criteria("id",personId);
		// HistoryRecorder.record(PersonInfo.class, personInfoDao, criteria, new String[]{"id", "createOrganCode", "createCenterOrganCode", "createGbcode"});
		if (ObjectUtil.isNotEmpty(personRecordMove)) {
			for (IPersonRecordMoveService personMove : personRecordMove) {
				personMove.personRecordMove(personId, smpiId, oldOrg, newOrg);
			}
		}
	}

	@Override
	@Transactional
	public String activePersonRecord(Long personId, String filingFlag) {
		PersonInfo personInfo = getPersonalCover(new Criteria("id", personId));
		if (ObjectUtil.isNotEmpty(personInfo) && EHRConstants.HAD_OFF.equals(filingFlag)) {
			personInfo.setFilingFlag("1");
			boolean flag = upateCover(personInfo, null,"filingFlag");
			filingFlag = flag ? personInfo.getFilingFlag() : filingFlag;

			if (flag) {

				personActive(personRecordActivateService, personId);
				setPhysicalExamRecordStatus(personId);
			}
		}
		return filingFlag;
	}

	private void setPhysicalExamRecordStatus(Long personId){
		PhysicalExamRecord examRecord=physicalExamRecordDao.get(new Criteria("personId", personId));
		if(examRecord!=null){

			examRecord.setLogoff(Integer.parseInt("0"));
			physicalExamRecordDao.update(examRecord);
		}
	}
	/**
	 * 人口设置，插入新的机构人后信息，删除旧的机构人口信息
	 *
	 * @param newStation
	 *            新的社区占
	 * @param codes
	 *            被合并的站的code
	 */
	private void mergeStationForPopulace(Organization newStation, List<String> codes) {
		int countYear = DateUtil.getCurrentYear() - 1;
		Criteria populaceCriteria = new Criteria().add("countYear", countYear).add("organCode", OP.IN, codes);// 去年
		Integer householdNum = populaceService.getPopulaceNum(populaceCriteria, "householdNum");
		Integer unHouseHoldNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseHoldNum");
		Integer householdManNum = populaceService.getPopulaceNum(populaceCriteria, "householdManNum");
		Integer unHouseholdManNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseholdManNum");
		Integer householdWomanNum = populaceService.getPopulaceNum(populaceCriteria, "householdWomanNum");
		Integer unHouseholdWomanNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseholdWomanNum");
		Integer householdSixChildNum = populaceService.getPopulaceNum(populaceCriteria, "householdSixChildNum");
		Integer unHouseholdSixChildNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseholdSixChildNum");
		Integer householdFertileWomanNum = populaceService.getPopulaceNum(populaceCriteria, "householdFertileWomanNum");
		Integer unHouseholdFertileWomanNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseholdFertileWomanNum");
		Integer householdSixoToSixfNum = populaceService.getPopulaceNum(populaceCriteria, "householdSixoToSixfNum");
		Integer unHouseholdSixoToSixfNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseholdSixoToSixfNum");
		Integer householdGreatSixfNum = populaceService.getPopulaceNum(populaceCriteria, "householdGreatSixfNum");
		Integer unHouseholdGreatSixfNum = populaceService.getPopulaceNum(populaceCriteria, "unHouseholdGreatSixfNum");
		Populace populace = new Populace();
		populace.setCountYear(countYear);
		populace.setOrganCode(newStation.getOrganCode());
		populace.setOrganName(newStation.getOrganName());
		populace.setHouseholdNum(householdNum);
		populace.setUnHouseHoldNum(unHouseHoldNum);
		populace.setHouseholdManNum(householdManNum);
		populace.setUnHouseholdManNum(unHouseholdManNum);
		populace.setHouseholdWomanNum(householdWomanNum);
		populace.setUnHouseholdWomanNum(unHouseholdWomanNum);
		populace.setHouseholdSixChildNum(householdSixChildNum);
		populace.setUnHouseholdSixChildNum(unHouseholdSixChildNum);
		populace.setHouseholdFertileWomanNum(householdFertileWomanNum);
		populace.setUnHouseholdFertileWomanNum(unHouseholdFertileWomanNum);
		populace.setHouseholdSixoToSixfNum(householdSixoToSixfNum);
		populace.setUnHouseholdSixoToSixfNum(unHouseholdSixoToSixfNum);
		populace.setHouseholdGreatSixfNum(householdGreatSixfNum);
		populace.setUnHouseholdGreatSixfNum(unHouseholdGreatSixfNum);
		populace.setGbcode(newStation.getGbCode());
		populace.setOrganParentCode(newStation.getParentCode());
		populace.setIsDelete(EHRConstants.DELETE_FLG_0);
		// 插入新的机构人口记录
		populaceService.insertPopulaceInfo(populace);
		// 删除被合并的人口记录
		populaceService.deletePopulaceInfo(populaceCriteria);
	}

	/**
	 * 把原来为二星的学生的档案升级到三星
	 */
	@Override
	@Transactional
	public void updateStudentToThreeStar(String idcard) {
		Assert.notNull(idcard, "身份证不能为空");
		Criteria criteria = new Criteria().add("idcard", idcard).add("filingFlag", OP.NE, "0").add("star", 2);
		PersonInfo personInfo = personInfoDao.get(criteria);
		if (ObjectUtil.isNotEmpty(personInfo)) {
			if (ObjectUtil.isNullOrEmpty(personInfo.getBirthday())) {
				return;
			}
			if (isLess20Student(personInfo.getBirthday(), idcard)) {
				Parameters ps = new Parameters();
				ps.add("star", EHRConstants.THREE_STAR);
				personInfoDao.update(ps, criteria);
			}
		}
	}

	/**
	 * 更新档案星级到三星
	 *
	 * @param personId
	 */
	@Override
	@Transactional
	public boolean updateToThreeStar(Long personId) {
		if (personId != null) {
			Criteria criteria = new Criteria().add("id", personId).add("filingFlag", OP.NE, "0").add("star", 2);
			PersonInfo personInfo = personInfoDao.get(criteria);
			if (ObjectUtil.isNotEmpty(personInfo)) {
				Parameters ps = new Parameters("star", EHRConstants.THREE_STAR);
				ps.add("starUpdateDate", Calendar.getInstance().getTime());
				personInfoDao.update(ps, criteria);
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据生日判断是否小于20岁的学生
	 *
	 * @param birthday
	 *            the birthday
	 * @param idcard
	 *            the idcard
	 * @return boolean
	 */
	private boolean isLess20Student(Date birthday, String idcard) {
		boolean less20 = false;
		boolean siStu = false;
		String ageStr = DateUtil.getAge(birthday, null);
		int age = Integer.parseInt(ageStr.substring(0, ageStr.length() - 1));
		if (age < 20) {
			less20 = true;
			siStu = isStudentService.isStudent(idcard);
		}
		return less20 && siStu;
	}

	/**
	 * 是否有学生体检信息
	 *
	 * @param idcard
	 *            身份证号
	 * @return boolean
	 */
	private boolean hasStudentExam(String idcard) {
		return hasStudentExamService.hasStudentExam(idcard);
	}

	/**
	 * Save person move record.
	 *
	 * @param oldPerson
	 *            the old person
	 * @param newPerson
	 *            the new person
	 */
	private void savePersonMoveRecord(PersonInfo oldPerson, PersonInfo newPerson) {
		PersonMoveInfo pm = new PersonMoveInfo();
		pm.setPersonId(newPerson.getId());
		pm.setPersonName(newPerson.getName());
		pm.setIdCard(newPerson.getIdcard());
		pm.setOldStationCode(oldPerson.getInputOrganCode());
		pm.setOldStationName(oldPerson.getInputOrganName());
		pm.setNewStationCode(newPerson.getInputOrganCode());
		pm.setNewStationName(newPerson.getInputOrganName());
		pm.setOperatorId(newPerson.getInputerId());
		pm.setOperator(newPerson.getInputName());
		pm.setOperationDate(new Date());
		pm.setIsDelete(0);
		personMoveService.savePersonMoveRecoed(pm);
	}

	/**
	 * Person active.
	 *
	 * @param personRecordActivateService
	 *            the person record activate service
	 * @param personId
	 *            the person id
	 */
	// 调用实现IPersonRecordActivateService的类的activatePerson方法
	private void personActive(List<IPersonRecordActivateService> personRecordActivateService, Long personId) {
		if (ObjectUtil.isNotEmpty(personRecordActivateService)) {
			PersonInfo p = personInfoDao.get(personId);
			if (ObjectUtil.isNotEmpty(p)) {
				for (IPersonRecordActivateService activeService : personRecordActivateService) {
					activeService.activatePerson(personId, p.getSmpiId());
				}
			}
		}
	}


	@Override
	public int checkRecordAccess(PersonInfo personInfo,String password){
		if(EHRConstants.RECORD_ENCRYPTED_FLAG.equals(personInfo.getEncryptionFlag())){
			if(ObjectUtil.isNotEmpty(password)){
				String decryptionPassword=personInfo.getDecryptionPassword();
				if (ObjectUtil.isNullOrEmpty(decryptionPassword)){
					//非法加密密码
					return 99;
				}else{
					String passwordMd5= MD5Encoder.getMD5Str(password);
					if (decryptionPassword.equals(passwordMd5)){
						//有权限
						return 2;
					}else {
						//密码错误
						return 3;
					}
				}
			}else{
				//加密,请输入密码
				return 1;
			}
		}
		return 0;
	}

	// ==IMergerOrganizationListener 机构合并接口实现 start==//

	/**
	 * 站合并
	 */
	@Override
	@Transactional
	public void mergeStation(Organization newStation, List<Organization> oldStationList) {
		List<String> codes = new ArrayList<String>();
		for (Organization organ : oldStationList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("inputOrganCode", OP.IN, codes);
		criteria.add(LOP.OR, "createOrganCode", OP.IN, codes);
		criteria.add(LOP.OR, "updateOrganCode", OP.IN, codes);
		//增加历史记录
		HistoryRecorder.record(PersonInfo.class, personInfoDao, criteria, new String[]{"id", "inputOrganCode", "inputCenterOrganCode", "inputGbcode","GBCODE"});

		// 健康档案-管理机构
		criteria = new Criteria("inputOrganCode", OP.IN, codes);
		Parameters parameters = new Parameters();
		parameters.add("inputOrganCode", newStation.getOrganCode());
		parameters.add("inputOrganName", newStation.getOrganName());
		parameters.add("inputCenterOrganCode", newStation.getParentCode());
		parameters.add("inputGbcode", newStation.getGbCode());
		parameters.add("GBCODE", newStation.getGbCode());
		personMoveInfoDao.batchInsertMergeOrgan(codes, newStation, "admin-机构合并－站合并");
		personInfoDao.update(parameters, criteria);
		// 健康档案-建档机构
		criteria = new Criteria("createOrganCode", OP.IN, codes);
		parameters = new Parameters("createOrganCode", newStation.getOrganCode());
		parameters.add("createOrganName", newStation.getOrganName());
		parameters.add("createCenterOrganCode", newStation.getParentCode());
		parameters.add("createGbcode", newStation.getGbCode());
		personInfoDao.update(parameters, criteria);
		// 健康档案-更新机构
		criteria = new Criteria("updateOrganCode", OP.IN, codes);
		parameters = new Parameters("updateOrganCode", newStation.getOrganCode());
		parameters.add("updateOrganName", newStation.getOrganName());
		personInfoDao.update(parameters, criteria);

		//个人体检
		parameters = new Parameters("examinationOrganCode", newStation.getOrganCode());
		parameters.add("examinationOrganName", newStation.getOrganName());
		criteria = new Criteria("examinationOrganCode", OP.IN, codes);
		physiqueExaminationDao.update(parameters, criteria);

		parameters = new Parameters("clinicOrganCode", newStation.getOrganCode());
		parameters.add("clinicOrganName", newStation.getOrganName());
		criteria = new Criteria("clinicOrganCode", OP.IN, codes);
		criteria.add("ehr_type", OP.IN, new String[]{EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(),EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()});
		ehrHealthEventDao.update(parameters, criteria);

		parameters = new Parameters("createOrganCode", newStation.getOrganCode());
		parameters.add("createOrganName", newStation.getOrganName());
		criteria = new Criteria("createOrganCode", OP.IN, codes);
		criteria.add("ehr_type", OP.IN, new String[]{EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(),EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()});
		ehrHealthEventDao.update(parameters, criteria);

		//会诊记录表
		//双向转诊表
		//近期体征-血压&血糖
		parameters = new Parameters("createOrganCode", newStation.getOrganCode());
		criteria = new Criteria("createOrganCode", OP.IN, codes);
		targetResultValueDao.update(parameters, criteria);
		parameters = new Parameters("updateOrganCode", newStation.getOrganCode());
		criteria = new Criteria("updateOrganCode", OP.IN, codes);
		targetResultValueDao.update(parameters, criteria);
		// 人口设置
		mergeStationForPopulace(newStation, codes);
		//档案修改痕迹
		parameters = new Parameters("INPUT_ORG_CODE", newStation.getOrganCode());
		parameters.add("INPUT_ORG", newStation.getOrganName());
		criteria = new Criteria("INPUT_ORG_CODE", OP.IN, codes);
		modifyTraceDao.update(parameters, criteria);
		//档案结案 机构变更
		Parameters jaParameters = new Parameters("canceledOrganCode", newStation.getOrganCode());
		jaParameters.add("canceledOrganName", newStation.getOrganName());
		Criteria jaCriteria = new Criteria("canceledOrganCode", OP.IN, codes);
		personCanceledInfoDao.update(jaParameters,jaCriteria);
	}

	/**
	 * 中心合并
	 */
	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("inputOrganCode", OP.IN, codes);
		criteria.add(LOP.OR, "inputCenterOrganCode", OP.IN, codes);
		criteria.add(LOP.OR, "createOrganCode", OP.IN, codes);
		criteria.add(LOP.OR, "createCenterOrganCode", OP.IN, codes);
		criteria.add(LOP.OR, "updateOrganCode", OP.IN, codes);
		//增加历史记录
		HistoryRecorder.record(PersonInfo.class, personInfoDao, criteria, new String[]{"id", "inputOrganCode", "inputCenterOrganCode", "inputGbcode","GBCODE"});

		// 健康档案-建档机构
		criteria = new Criteria("inputOrganCode", OP.IN, codes);
		Parameters parameters = new Parameters();
		parameters.add("inputOrganCode", center.getOrganCode());
		parameters.add("inputOrganName", center.getOrganName());
		parameters.add("inputCenterOrganCode", center.getOrganCode());
		parameters.add("inputGbcode", center.getGbCode());
		parameters.add("GBCODE", center.getGbCode());
		personMoveInfoDao.batchInsertMergeOrgan(codes, center, "admin-机构合并－中心合并");
		personInfoDao.update(parameters, criteria);

		criteria = new Criteria("inputCenterOrganCode", OP.IN, codes);
		parameters = new Parameters();
		parameters.add("inputCenterOrganCode", center.getOrganCode());
		parameters.add("inputGbcode", center.getGbCode());
		parameters.add("GBCODE", center.getGbCode());
		personInfoDao.update(parameters, criteria);

		// 健康档案-建档机构
		criteria = new Criteria("createOrganCode", OP.IN, codes);
		parameters = new Parameters("createOrganCode", center.getOrganCode());
		parameters.add("createOrganName", center.getOrganName());
		parameters.add("createCenterOrganCode", center.getOrganCode());
		parameters.add("createGbcode", center.getGbCode());
		personInfoDao.update(parameters, criteria);

		criteria = new Criteria("createCenterOrganCode", OP.IN, codes);
		parameters = new Parameters("createCenterOrganCode", center.getOrganCode());
		parameters.add("createGbcode", center.getGbCode());
		personInfoDao.update(parameters, criteria);

		// 健康档案-更新机构
		criteria = new Criteria("updateOrganCode", OP.IN, codes);
		parameters = new Parameters("updateOrganCode", center.getOrganCode());
		parameters.add("updateOrganName", center.getOrganName());
		personInfoDao.update(parameters, criteria);
		//个人体检
		parameters = new Parameters();
		parameters.add("examinationOrganCode", center.getOrganCode());
		parameters.add("examinationOrganName", center.getOrganName());
		criteria = new Criteria("examinationOrganCode", OP.IN, codes);
		physiqueExaminationDao.update(parameters, criteria);

		parameters = new Parameters("clinicOrganCode", center.getOrganCode());
		parameters.add("clinicOrganName", center.getOrganName());
		criteria = new Criteria("clinicOrganCode", OP.IN, codes);
		criteria.add("ehr_type", OP.IN, new String[]{EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(),EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()});
		ehrHealthEventDao.update(parameters, criteria);

		parameters = new Parameters("createOrganCode", center.getOrganCode());
		parameters.add("createOrganName", center.getOrganName());
		criteria = new Criteria("createOrganCode", OP.IN, codes);
		criteria.add("ehr_type", OP.IN, new String[]{EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(),EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()});
		ehrHealthEventDao.update(parameters, criteria);
		//会诊记录表
		//双向转诊表
		//近期体征-血压&血糖
		parameters = new Parameters("createOrganCode", center.getOrganCode());
		criteria = new Criteria("createOrganCode", OP.IN, codes);
		targetResultValueDao.update(parameters, criteria);
		parameters = new Parameters("updateOrganCode", center.getOrganCode());
		criteria = new Criteria("updateOrganCode", OP.IN, codes);
		targetResultValueDao.update(parameters, criteria);

		//档案修改痕迹
		parameters = new Parameters("INPUT_ORG_CODE", center.getOrganCode());
		parameters.add("INPUT_ORG", center.getOrganName());
		criteria = new Criteria("INPUT_ORG_CODE", OP.IN, codes);
		modifyTraceDao.update(parameters, criteria);

		//档案结案 机构变更
		Parameters jaParameters = new Parameters("canceledOrganCode", center.getOrganCode());
		jaParameters.add("canceledOrganName", center.getOrganName());
		Criteria jaCriteria = new Criteria("canceledOrganCode", OP.IN, codes);
		personCanceledInfoDao.update(jaParameters,jaCriteria);
	}

	/**
	 * 站转移
	 */
	@Override
	@Transactional
	public void moveStation(Organization center, List<Organization> stationList) {
		List<String> codes = new ArrayList<String>();
		for (Organization organ : stationList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("inputOrganCode", OP.IN, codes);
		Parameters parameters = new Parameters();
		parameters.add("inputCenterOrganCode", center.getOrganCode());
		parameters.add("inputGbcode", center.getGbCode());
		parameters.add("GBCODE", center.getGbCode());
		HistoryRecorder.record(PersonInfo.class, personInfoDao, criteria, new String[]{"id", "inputCenterOrganCode", "inputGbcode","GBCODE"});
		personInfoDao.update(parameters, criteria);

	}

	@Override
	@Transactional
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		Assert.notNull(orgCode, "目标机构编码为空");
		Organization organization = organizationApp.queryOrgan(orgCode);
		Assert.notNull(organization, "目标机构在系统中不存在");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
		// 建档机构
		Parameters param = new Parameters("inputOrganCode", orgCode);
		param.add("inputOrganName", organization.getOrganName());
		// 冗余上级
		param.add("inputCenterOrganCode", organization.getParentCode());
		param.add("inputGbcode", organization.getGbCode());
		param.add("GBCODE", organization.getGbCode());
		Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		HistoryRecorder.record(PersonInfo.class,personInfoDao, criteria, new String[]{"id", "inputOrganCode", "inputCenterOrganCode", "inputGbcode","GBCODE"});
		personMoveInfoDao.batchInsertChangeRelationOrgVillage(newAddVillageCodes, organization, "admin-机构合并－机构村关系变化");
		personInfoDao.update(param, criteria);
		//档案结案 村对应机构变更
		personCanceledInfoDao.updatePersonCanceledInfo(organization.getOrganCode(),organization.getOrganName(),newAddVillageCodes);
	}

	/**
	 * 乡镇合并
	 *
	 */
	@Override
	@Transactional
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		Assert.hasText(newTownCode, "合并后的镇编码为空");
		Assert.notEmpty(oldTownCode, "需要和并的镇编码为空");

		Criteria criteria = new Criteria("hrtownShip", OP.IN, oldTownCode);
		criteria.add(LOP.OR, "patownShip", OP.IN, oldTownCode);
		criteria.add(LOP.OR, "inputGbcode", OP.IN, oldTownCode);
		criteria.add(LOP.OR, "inputGbcode", OP.IN, oldTownCode);
		HistoryRecorder.record(PersonInfo.class,personInfoDao, criteria, new String[]{"id", "hrtownShip","patownShip","inputGbcode"});

		criteria = new Criteria("hrtownShip", OP.IN, oldTownCode);
		criteria.add("householdType", EHRConstants.HOUSE_HOLDER);// 只有户籍类型需要更新
		Parameters parameters = new Parameters("hrtownShip", newTownCode);
		personInfoDao.update(parameters, criteria);

		criteria = new Criteria("patownShip", OP.IN, oldTownCode);
		parameters = new Parameters("patownShip", newTownCode);
		personInfoDao.update(parameters, criteria);

		criteria = new Criteria("inputGbcode", OP.IN, oldTownCode);
		parameters = new Parameters("inputGbcode", newTownCode);
		personInfoDao.update(parameters, criteria);

		criteria = new Criteria("createGbcode", OP.IN, oldTownCode);
		parameters = new Parameters("createGbcode", newTownCode);
		personInfoDao.update(parameters, criteria);
		//人口
		criteria = new Criteria("gbcode", OP.IN, oldTownCode);
		parameters = new Parameters("gbcode", newTownCode);
		populaceDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void sendTownVillageRelation(String newTownCode, String[] newAddVillageCodes) {
		Assert.hasText(newTownCode, "需要迁移到的镇编码为空");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的社区编码为空");
		Criteria criteria = new Criteria("hrstreet", OP.IN, newAddVillageCodes);
		criteria.add(LOP.OR, "pastreet", OP.IN, newAddVillageCodes);
		HistoryRecorder.record(PersonInfo.class,personInfoDao, criteria, new String[]{"id", "hrtownShip", "patownShip"});

		criteria = new Criteria("hrstreet", OP.IN, newAddVillageCodes);
		criteria.add("householdType", EHRConstants.HOUSE_HOLDER);// 只有户籍类型需要更新
		Parameters parameters = new Parameters("hrtownShip", newTownCode);
		personInfoDao.update(parameters, criteria);

		criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		parameters = new Parameters("patownShip", newTownCode);
		personInfoDao.update(parameters, criteria);
	}

	/**
	 * 乡镇合并
	 *
	 */
	@Transactional
	public void mergeTownWithUpdateAddress(String newTownCode, String[] oldTownCode) {
		Assert.hasText(newTownCode, "合并后的镇编码为空");
		Assert.notEmpty(oldTownCode, "需要和并的镇编码为空");

		Set<String> oldTownCodes = new HashSet<>(Arrays.asList(oldTownCode));

		// 建档所在镇 直接更新
		// Criteria criteria = new Criteria("inputGbcode", OP.IN, oldTownCode);
		// Parameters parameters = new Parameters("inputGbcode", newTownCode);
		// personInfoDao.update(parameters, criteria);

		// 现住址和户籍地址处理历史数据
		Criteria criteria = new Criteria();
		criteria.add(LOP.OR, "hrtownShip", OP.IN, oldTownCode);
		criteria.add(LOP.OR, "patownShip", OP.IN, oldTownCode);
		int current = 1;
		Page page = new Page(10000, current);
		String[] neededProperties = { "id", "hrtownShip", "patownShip", "hrstreet", "pastreet", "pahouseNumber", "hrhouseNumber" };
		PageList<PersonInfo> ps = personInfoDao.getPageList(page, criteria, neededProperties);

		if (null != ps) {
			deaTownl(ps.getList(), newTownCode, oldTownCodes);
			while (page.getTotalPages() > current) {
				page.next();
				current = page.getCurrentPage();
				ps = personInfoDao.getPageList(page, criteria, neededProperties);
				if (null != ps) {
					deaTownl(ps.getList(), newTownCode, oldTownCodes);
				}
			}
		}
	}

	/**
	 * Dea townl.
	 *
	 * @param ps
	 *            the ps
	 * @param newTownCode
	 *            the new town code
	 * @param oldTownCodes
	 *            the old town codes
	 */
	private void deaTownl(List<PersonInfo> ps, String newTownCode, Set<String> oldTownCodes) {
		for (PersonInfo p : ps) {
			String hrtownShip = p.getHrtownShip();
			String patownShip = p.getPatownShip();
			boolean pa = oldTownCodes.contains(patownShip);
			boolean hr = oldTownCodes.contains(hrtownShip);
			if (pa) {
				p.setPatownShip(newTownCode);
			}
			if (hr) {
				p.setHrtownShip(newTownCode);
			}
			buildPersonInfoAddress(pa, hr, p);
		}
		personInfoDao.batchUpdate(ps, "hrtownShip", "patownShip", "hrAddress", "paAddress");
	}

	public void sendTownVillageRelationWithUpdateAddress(String townCode, String[] newAddVillageCodes) {
		Criteria criteria = new Criteria();
		criteria.add(LOP.OR, "hrstreet", OP.IN, newAddVillageCodes);
		criteria.add(LOP.OR, "pastreet", OP.IN, newAddVillageCodes);
		Set<String> villageCodes = new HashSet<>(Arrays.asList(newAddVillageCodes));
		int current = 1;
		Page page = new Page(10000, current);
		String[] neededProperties = { "id", "hrstreet", "pastreet", "pahouseNumber", "hrhouseNumber" };
		while (true) {
			PageList<PersonInfo> ps = personInfoDao.getPageList(page, criteria, neededProperties);
			if (null == ps) {
				break;
			}
			List<PersonInfo> list = ps.getList();
			if (null == list || list.isEmpty()) {
				break;
			}
			dealVillage(ps.getList(), townCode, villageCodes);
			if (page.getCurrentPage() >= page.getTotalPages()) {
				break;
			}
			page.next();

		}

	}

	/**
	 * Deal village.
	 *
	 * @param ps
	 *            the ps
	 * @param townCode
	 *            the town code
	 * @param villageCodes
	 *            the village codes
	 */
	private void dealVillage(List<PersonInfo> ps, String townCode, Set<String> villageCodes) {
		for (PersonInfo p : ps) {
			String hrstreet = p.getHrstreet();
			String pastreet = p.getPastreet();
			boolean pa = villageCodes.contains(pastreet);
			boolean hr = villageCodes.contains(hrstreet);
			if (pa) {
				p.setPatownShip(townCode);
			}
			if (hr) {
				p.setHrtownShip(townCode);
			}
			buildPersonInfoAddress(pa, hr, p);
		}
		personInfoDao.batchUpdate(ps, "hrtownShip", "patownShip", "hrAddress", "paAddress");
	}

	/**
	 * Do build address.
	 *
	 * @param town
	 *            the town
	 * @param street
	 *            the street
	 * @param houseNumber
	 *            the house number
	 * @return the string
	 */
	private String doBuildAddress(String town, String street, String houseNumber) {
		String townName = "";
		if (ObjectUtil.isNotEmpty(town)) {
			DicItem dicItem = dictionaryApp.queryDicItem(EHRConstants.CS_TOWN_DICT_TYPE, town);
			townName = null == dicItem ? "" : dicItem.getItemName();
		}
		String streetName = "";
		if (ObjectUtil.isNotEmpty(street)) {
			DicItem dicItem = dictionaryApp.queryDicItem(EHRConstants.CS_TOWN_DICT_TYPE, street);
			streetName = null == dicItem ? "" : dicItem.getItemName();
		}
		houseNumber = houseNumber == null ? "" : houseNumber;
		return townName + streetName + houseNumber;
	}

	// ==IMergerTownListener 实现乡镇合并和镇村关系接口 end==//

	@Override
	public void run(Map<String, Object> data) {
		Object startDateParam = data.get(TaskConstants.TASK_PARAM_KEY);
		Date startDate = null;
		if (null != startDateParam) {
			startDate = DateUtil.parseSimpleDate(startDateParam.toString(), "yyyy/MM/dd");
		}
		if (null == startDate) {
			startDate = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH, -4);
		}
		Criteria criteria = new Criteria("updateDate", OP.GE, startDate);
		int current = 1;
		Page page = new Page(10000, current);
		String[] neededProperties = { "id", "householdType", "hrstreet", "hrtownShip", "patownShip", "pastreet", "pahouseNumber", "hrhouseNumber" };
		while (true) {
			PageList<PersonInfo> ps = personInfoDao.getPageList(page, criteria, neededProperties);
			if (null == ps) {
				break;
			}
			List<PersonInfo> list = ps.getList();
			if (null == list || list.isEmpty()) {
				break;
			}
			for (PersonInfo p : list) {
				buildPersonInfoAddress(true, true, p);
			}
			personInfoDao.batchUpdate(list, "hrAddress", "paAddress");
			if (page.getCurrentPage() >= page.getTotalPages()) {
				break;
			}
			page.next();
		}

	}

	/**
	 * Build person info address.
	 *
	 * @param calPa
	 *            the cal pa
	 * @param calHr
	 *            the cal hr
	 * @param personInfo
	 *            the person info
	 */
	private void buildPersonInfoAddress(boolean calPa, boolean calHr, PersonInfo personInfo) {
		if (calHr) {
			if (EHRConstants.HOUSE_HOLDER.equals(personInfo.getHouseholdType())) {
				String address = doBuildAddress(personInfo.getHrtownShip(), personInfo.getHrstreet(), personInfo.getHrhouseNumber());
				personInfo.setHrAddress(address);
			} else {
				personInfo.setHrAddress(personInfo.getPahouseNumber());
			}
		}
		if (calPa) {
			String address = doBuildAddress(personInfo.getPatownShip(), personInfo.getPastreet(), personInfo.getPahouseNumber());
			personInfo.setPaAddress(address);
		}
	}

	/**
	 * 修改 健康档案浏览器密码
	 * @param parameters
	 * @param criteria
	 */
	@Override
	public void updateDecryptionPassword(Parameters parameters, Criteria criteria){
		personInfoDao.update(parameters, criteria);
	}

	@Override
	public List<PhysiqueExamination> getPersonalPhysicalList(Criteria criteria,Order order) {
		// TODO Auto-generated method stub
		return physiqueExaminationDao.getList(criteria,order);
	}

	@Override
	public PhysiqueExamination getPersonalPhysicalOne(Criteria criteria) {
		return physiqueExaminationDao.get(criteria);
	}

	/**
	 * 仅仅是已建档的星级变化记录
	 * @param orgCode 变更人所属的机构编码
	 * @param staffCode 变更人的医务人员编码
	 * @param personId
	 * @param oldStar 老的星级
	 * @param newStar 变化后的新星级
	 */
	@Override
	public void syncWork(String orgCode, String staffCode, Long personId, Integer oldStar, Integer newStar) {
		if(ObjectUtil.equals(oldStar, newStar)) {
			return;
		}
		Criteria criteria = new Criteria("personId",personId).add("newStar",newStar);
		criteria.add("oldStar", oldStar);
		List<EhrDocLevel> rs = ehrDocLevelDao.getList(criteria);
		//先点击保存 在进行tab切换还会有一个保存 可是此时页面再次传过来的还是老的星级 此后的保存不计入变化表中
		if(ObjectUtil.isNotEmpty(rs)) {
			return;
		}
		EhrDocLevel entity = new EhrDocLevel();
		entity.setPersonId(personId);
		entity.setNewStar(newStar);
		entity.setOldStar(oldStar);
		entity.setCreateTime(new Date());
		entity.setUpdateOrgCode(orgCode);
		entity.setUpdateStaffCode(staffCode);
		// 星级发生改变执行以下
		statisticsService.syncWorkStatisticsData(entity);
	}

	@Override
	public PersonalConsultationDTO getPersonalConsultationDto(Long personId) {
		PersonalConsultationDTO result = new PersonalConsultationDTO();

		/* 个人信息 */
		Criteria criteria = new Criteria("id",personId);
		PersonInfo personInfo = personInfoDao.get(criteria);
		result.setPersonInfo(personInfo);


		/* 获取会诊记录 */
		Criteria ca = new Criteria("person_Id", personId);
		Order order = new Order("CONSULATION_DATE DESC");
		String[] properties = {"id", "CONSULATION_DATE"};
		List<Consultation> consultations = consultationDao.getList(ca,order,properties);

		result.setConsultations(consultations);

		return result;
	}
	
	/**
	 * 删除健康档案-体检表
	 * @param personId
	 * @param ehrId 本次删除体检对应的ehrId
	 * @param currentUser
	 * @param currentOrg
	 */
	@Override
	@Transactional
	public PhysiqueExamination deletePhysical(final Long personId, String ehrId,User currentUser,Organization currentOrg,String requestIp,String requestUri, String examCode) {
		PersonInfo personInfo = personInfoDao.get(personId);
		Assert.notNull(personInfo);
		PhysiqueExamination phyExam = null;
		Criteria ca = new Criteria("personId", personId);
		if(StringUtil.isNotEmpty(ehrId)){
			ca.add("ehrId", ehrId);
			phyExam = physiqueExaminationDao.get(ca);
		}else if(StringUtil.isNotEmpty(examCode)){
			phyExam = physiqueExaminationDao.get(new Criteria("physicalExamCode", examCode).add(ca));
			ca.add("ehrId", phyExam.getEhrId());
		}else{
			return phyExam;
		}
		if (ObjectUtil.isNotEmpty(phyExam)) {
			ca.add("ehrId", phyExam.getEhrId());
			//1.删除相关表
			physiqueExaminationDao.delete(phyExam.getId());
			/* 删除关联表 */
			familyBedHistoryDao.delete(ca);
			vaccinationInfoDao.delete(ca);
			drugHistoryDao.delete(ca);
			hospitalizedHistoryDao.delete(ca);
			healthEvaluateAnomalyDao.delete(new Criteria("ehrId", phyExam.getEhrId()));
			ehrHealthEventDao.delete(ca);
			//2.更新健康档案更新时间
			Thread thread = new Thread(new Runnable() {
				public void run() {
					Parameters param = new Parameters();
					param.add("updateDate", new Date());
					Criteria c = new Criteria("id", personId);
					personInfoDao.update(param, c);
				}
			});
			thread.start();
			//3.计算星级
			Integer oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
			deletePhysicalCalStar(personInfo, phyExam.getEhrId(), currentUser);
			Integer newStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
			syncWork(currentOrg.getOrganCode(),currentUser.getStaffCode(), personInfo.getId(), oldStar, newStar);
			//4.记录操作记录
			deletePhysicalOperationLog(requestIp,requestUri,personInfo,phyExam,currentUser,currentOrg);
		}
		return phyExam;
	}
	
	/**
	 * 删除体检表时，重新计算星级
	 * @param personInfo
	 * @param ehrId 本次删除操作的ehrId
	 * @param currentUser
	 */
	private void deletePhysicalCalStar(PersonInfo personInfo,String ehrId,User currentUser){
		//1.如果还有其他体检表信息，则按日期排序，按最新的体检表计算星级
		//2.如果没有体检表信息，则按空体检计算星级
		List<EHRHealthEvent> ehrHealthEvents = healthEventService.getEHRHealthEvents(new Criteria("personId", personInfo.getId())
						.add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode()).add("ehrId",OP.NE,ehrId),
				new Order("CLINIC_DATE", false));
		PersonalPhyExamDTO phyExamDTO = null;
		Criteria criteria = new Criteria("id", personInfo.getId());
		if(ObjectUtil.isNotEmpty(ehrHealthEvents)){
			//除了本次删除的体检，按最新体检计算星级
			phyExamDTO = getPersonalPhysical(criteria, ehrHealthEvents.get(0).getEhrId());
		}else {
			//本次删除的是唯一的体检信息
			Staff staff = staffService.getStaff(currentUser.getStaffCode());
			if (ObjectUtil.isNotEmpty(staff)) {
				phyExamDTO = new PersonalPhyExamDTO();
				PhysiqueExamination phy = new PhysiqueExamination();
				phy.setManaDoctorId(staff.getStaffCode());
				phyExamDTO.setPhysiqueExamination(phy);
				PersonInfo personInfoPHY = getPersonalCover(criteria);
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
						if (diseaseCode.equals("201")|| //高血压
								diseaseCode.equals("202") || //糖尿病
								diseaseCode.equals("207")) {//重性精神病
							phy.setGuideIntoChronicDisease("1");
						}
					}
				}
			}
		}
		// 计算档案星级
		// 如果是小于20岁的学生,在有学生体检的情况下是三星,则不在计算星级
		if (!(isLess20Student(personInfo.getBirthday(), personInfo.getIdcard()) && ObjectUtil.isNotEmpty(personInfo.getStar()) && EHRConstants.THREE_STAR == personInfo.getStar())) {
			phyExamDTO.setPersonInfo(personInfo);
			recordStarService.calThreeStarRecord(phyExamDTO);
			recordStarService.updateStar(personInfo);
		}
	}
	
	/**
	 * 删除体检表时记录日志
	 * @param requestIp
	 * @param requestUri
	 * @param personInfo
	 * @param phyExam
	 * @param user
	 * @param organization
	 */
	private void deletePhysicalOperationLog(String requestIp,String requestUri,PersonInfo personInfo,PhysiqueExamination phyExam,User user,Organization organization) {
		UserOperationLog userOperationLog = new UserOperationLog();
		userOperationLog.setUserName(user.getUserName());
		userOperationLog.setUserIp(requestIp);
		userOperationLog.setUserRequest(requestUri);
		userOperationLog.setModuleName(RhipModuleName.EHR.getZhName());
		userOperationLog.setActionName("个人健康档案");
		userOperationLog.setOperationName("删除");
		if (null!=organization) {
			userOperationLog.setOrgCode(organization.getOrganCode());
		}
		userOperationLog.setOperationTime(new Date());
		StringBuilder remarkSb = new StringBuilder();
		remarkSb.append("个人健康档案-体检信息删除，删除者：" + user.getName() + "(" + user.getUserCode() +  ");" );
		remarkSb.append("体检信息：体检日期（" + DateUtil.toFormatString("yyyy/MM/dd",phyExam.getExaminationDate())+"）,");
		remarkSb.append("EHR_ID（" + phyExam.getEhrId() +"）,");
		remarkSb.append("居民身份证（" + personInfo.getIdcard() +"）");
		userOperationLog.setRemark(remarkSb.toString());
		userOperationLogService.createOperationLog(userOperationLog);
	}
	
	@Override
	public void updateEchIdentification(PhysiqueExamination phy) {
		physiqueExaminationDao.updateEchIdentification(phy);
	}

}
