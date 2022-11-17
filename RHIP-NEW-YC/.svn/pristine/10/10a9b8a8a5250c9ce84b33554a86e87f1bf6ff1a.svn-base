package com.founder.rhip.whch.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.IntegrationMonitorRecorder;
import com.founder.rhip.ehr.common.ReflectionUtils;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.repository.child.*;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.women.*;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OtherCardType;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.whch.xml.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("whchService")
public class WhchServiceImpl extends AbstractService implements IWhchService {
	
	private static String EHR_ID = "EHR_ID";
	
	@Resource(name = "ehrHealthEventDao")
	protected IEHRHealthEventDao ehrHealthEventDao;

	@Resource(name = "birthCertificateDao")
	private IBirthCertificateDao birthCertificateDao;
	
	@Resource(name = "childHealthCardDao")
	private IChildHealthCardDao childHealthCardDao;
	
	@Resource(name = "childHealthExaminationDao")
	private IChildHealthExaminationDao childHealthExaminationDao;
	
	@Resource(name = "frailChildFollowupDao")
	private IFrailChildFollowupDao frailChildFollowupDao;
	
	@Resource(name = "neonatalDiseaseScreenDao")
	private INeonatalDiseaseScreenDao neonatalDiseaseScreenDao;
	
	@Resource(name = "neonatalFamilyVisitDao")
	private INeonatalFamilyVisitDao neonatalFamilyVisitDao;
	
	@Resource(name = "birthControlServiceDao")
	private IBirthControlServiceDao birthControlServiceDao;
	
	@Resource(name = "birthDefectMonitorDao")
	private IBirthDefectMonitorDao birthDefectMonitorDao;
	
	@Resource(name = "deliveryRecordInfoDao")
	private IDeliveryRecordInfoDao deliveryRecordInfoDao;
	
	@Resource(name = "motherhoodPeriodFollowupDao")
	private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;
	
	@Resource(name = "whPostnatalFollowupDao")
	private IPostnatalFollowupDao whPostnatalFollowupDao;
	
	@Resource(name = "postpartumDaysHealthInfoDao")
	private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;
	
	@Resource(name = "premaritalHealthServiceDao")
	private IPremaritalHealthServiceDao premaritalHealthServiceDao;
	
	@Resource(name = "prenatalFollowupDao")
	private IPrenatalFollowupDao prenatalFollowupDao;
	
	@Resource(name = "prenatalScreenDiagnosisDao")
	private IPrenatalScreenDiagnosisDao prenatalScreenDiagnosisDao;
	
	@Resource(name = "womanDiseaseCensusDao")
	private IWomanDiseaseCensusDao womanDiseaseCensusDao;
	
	@Resource(name = "platformService")
	private IPlatformService platformService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "reserveChildDao")
	private IReserveChildDao reserveChildDao;

	@Resource(name = "reserveMaternalDao")
	private IReserveMaternalDao reserveMaternalDao;

	@Resource(name = "reserveVaccinationDao")
	private IReserveVaccinationDao reserveVaccinationDao;
	
	private String exceptionFolder;
	
	@Override
	public int saveWhchInfo(String dataXml, String dataType, Map<String, Long[]> map) throws Exception {
		int ret = 0;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(dataType)) {
			return ret;
		}
		switch (dataType) {
			case "C01": // 出生医学证明
				processBirthCertificate(dataXml, map);
				break;
			case "C02": // 新生儿疾病筛查信息
				processNeonatalDiseaseScreen(dataXml, map);
				break;
			case "C03": // 新生儿家庭访视信息
				processNeonatalFamilyVisit(dataXml, map);
				break;
			case "C04": // 儿童保健卡信息
				processChildHealthCard(dataXml, map);
				break;
			case "C05": // 儿童健康体检信息
				processChildHealthExamination(dataXml, map);
				break;
			case "C06": // 体弱儿童管理随访信息
				processFrailChildFollowup(dataXml, map);
				break;
			case "W01": // 婚前保健服务信息
				processPremaritalHealthService(dataXml, map);
				break;
			case "W02": // 妇女病普查信息
				processWomanDiseaseCensus(dataXml, map);
				break;
			case "W03": // 计划生育技术服务信息
				processBirthControlService(dataXml, map);
				break;
			case "W04": // 孕产期保健服务与高危管理随访信息
				processMotherhoodPeriodFollowup(dataXml, map);
				break;
			case "W05": // 产前筛查与诊断信息
				processPrenatalScreenDiagnosis(dataXml, map);
				break;
			case "W06": // 分娩记录信息
				processDeliveryRecordInfo(dataXml, map);
				break;
			case "W07": // 出生缺陷监测信息
				processBirthDefectMonitor(dataXml, map);
				break;
			case "W08": // 产前随访服务信息
				processPrenatalFollowup(dataXml, map);
				break;
			case "W09": // 产后访视服务信息
				processPostnatalFollowup(dataXml, map);
				break;
			case "W10": // 产后42天健康检查信息
				processPostpartumDaysHealthInfo(dataXml, map);
				break;
			default:
				break;
		}
		return ret;
	}
	
	/**
	 * 处理出生证明
	 * 
	 * @param dataXml
	 * @param map 数据集成统计
	 * @throws Exception
	 */
	private void processBirthCertificate(String dataXml, Map<String, Long[]> map) throws Exception {
		BirthCertificateEntity birthCertificateEntity = null;
		List<BirthCertificate> birthCertificates = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(birthCertificateEntity = parseDataXml(dataXml, BirthCertificateEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(birthCertificates = birthCertificateEntity.getBirthCertificates())) {
			return;
		}

		for (BirthCertificate birthCertificate : birthCertificates) {
			if (ObjectUtil.isNullOrEmpty(birthCertificate)) {
				continue;
			}
			String ehrId = birthCertificate.getEhrId();
			BirthCertificate bcf = birthCertificateDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, birthCertificate);
				if (StringUtil.isNotEmpty(birthCertificate.getBabyCardNo())) {
					personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(birthCertificate.getBabyCardNo());
				}
				personInfo.setUpdateOrganCode(birthCertificate.getCreateOrganCode());
				personInfo.setUpdateName(birthCertificate.getMidwiferyName());
				personInfo.setDomainId(birthCertificate.getCreateOrganCode());
				//所属乡镇 修改成编号 Modify by:MeiXingjian
				birthCertificate.setPatownShip(queryLatownShipCode(birthCertificate.getPatownShip()));
				// 重复检查
				if (ObjectUtil.isNullOrEmpty(bcf)) {
					if (StringUtil.isNotEmpty(birthCertificate.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, birthCertificate.getCreateOrganCode(), ehrId);
						birthCertificate.setPersonId(personId);
					}
					birthCertificateDao.insert(birthCertificate);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.BIRTH_CERTIFICATE);
					saveHealthEvent(getHealthEvent(ehrId, birthCertificate.getPersonId(), EventType.BIRTH_CERTIFICATE, personInfo, null));
				} else {
					birthCertificate.setId(bcf.getId());
					birthCertificate.setPersonId(bcf.getPersonId());
					birthCertificateDao.update(birthCertificate);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.BIRTH_CERTIFICATE);
					saveHealthEvent(getHealthEvent(ehrId, birthCertificate.getPersonId(), EventType.BIRTH_CERTIFICATE, personInfo, bcf.getNeonatalBirthday()));
				}
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.BIRTH_CERTIFICATE);
				StringBuilder sb = new StringBuilder("保存儿童出生证明出错！出生证明编号为：");
				sb.append(birthCertificate.getBirthCertificateNo());
				sb.append("姓名：");
				sb.append(birthCertificate.getNeonatalName());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.BIRTH_CERTIFICATE);
			}
		}
	}
	
	/**
	 * 新生儿疾病筛查信息
	 * 
	 * @param dataXml
	 * @param map 记录集成数据量
	 * @throws Exception
	 */
	private void processNeonatalDiseaseScreen(String dataXml, Map<String, Long[]> map) throws Exception {
		NeonatalDiseaseScreenEntity neonatalDiseaseScreenEntity = null;
		List<NeonatalDiseaseScreen> neonatalDiseaseScreens = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(neonatalDiseaseScreenEntity = parseDataXml(dataXml, NeonatalDiseaseScreenEntity.class))
				|| ObjectUtil.isNullOrEmpty(neonatalDiseaseScreens = neonatalDiseaseScreenEntity.getNeonatalDiseaseScreens())) {
			return;
		}
		for (NeonatalDiseaseScreen neonatalDiseaseScreen : neonatalDiseaseScreens) {
			if (ObjectUtil.isNullOrEmpty(neonatalDiseaseScreen)) {
				continue;
			}
			String ehrId = neonatalDiseaseScreen.getEhrId();
			NeonatalDiseaseScreen nds = neonatalDiseaseScreenDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, neonatalDiseaseScreen);
				if (StringUtil.isNotEmpty(neonatalDiseaseScreen.getBabyCardNo())) {
					personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(neonatalDiseaseScreen.getBabyCardNo());
				}
				//所属乡镇 修改成编号 Modify by:MeiXingjian
				neonatalDiseaseScreen.setPatownShip(queryLatownShipCode(neonatalDiseaseScreen.getPatownShip()));
				personInfo.setUpdateOrganCode(neonatalDiseaseScreen.getCreateOrganCode());
				personInfo.setUpdateName(neonatalDiseaseScreen.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(nds)) {
					if (StringUtil.isNotEmpty(neonatalDiseaseScreen.getCreateOrganCode())) {
						Long personId = platformService.createPerson(personInfo, neonatalDiseaseScreen.getCreateOrganCode(), ehrId);
						neonatalDiseaseScreen.setPersonId(personId);
					}
					neonatalDiseaseScreenDao.insert(neonatalDiseaseScreen);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.NEONATAL_DISEASE_SCREEN);
				} else {
					neonatalDiseaseScreen.setId(nds.getId());
					neonatalDiseaseScreen.setPersonId(nds.getPersonId());
					neonatalDiseaseScreenDao.update(neonatalDiseaseScreen);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.NEONATAL_DISEASE_SCREEN);
				}
				saveHealthEvent(getHealthEvent(ehrId, neonatalDiseaseScreen.getPersonId(), EventType.NEWBORN_DISEASE_SCREEN, personInfo, neonatalDiseaseScreen.getSamplingDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.NEONATAL_DISEASE_SCREEN);
				StringBuilder sb = new StringBuilder("保存新生儿疾病筛查信息出错！记录表单号为：");
				sb.append(neonatalDiseaseScreen.getRecordNumber());
				sb.append("姓名：");
				sb.append(neonatalDiseaseScreen.getNeonatalName());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.NEONATAL_DISEASE_SCREEN);
			}
		}
	}
	
	private Long getPersonIdByMotherIdcard(String motherIdcard) {
		Long personId = null;
		if (StringUtil.isNotEmpty(motherIdcard)) {
			//根据母亲身份证查询小孩的出生证明
			//目前这里只考虑一个小孩的问题，后期注意处理一个母亲多个小孩的问题
			BirthCertificate bcf = birthCertificateDao.get(new Criteria("motherIdcard", motherIdcard), "personId");
			if (bcf != null) {
				personId = bcf.getPersonId();
			}
		}
		return personId;
	}
	
	/**
	 * 新生儿家庭访视信息
	 * 
	 * @param dataXml
	 * @param map 记录集成数据量
	 * @throws Exception
	 */
	private void processNeonatalFamilyVisit(String dataXml, Map<String, Long[]> map) throws Exception {
		NeonatalFamilyVisitEntity neonatalFamilyVisitEntity = null;
		List<NeonatalFamilyVisit> neonatalFamilyVisits = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(neonatalFamilyVisitEntity = parseDataXml(dataXml, NeonatalFamilyVisitEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(neonatalFamilyVisits = neonatalFamilyVisitEntity.getNeonatalFamilyVisits())) {
			return;
		}
		for (NeonatalFamilyVisit neonatalFamilyVisit : neonatalFamilyVisits) {
			if (ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)) {
				continue;
			}
			String ehrId = neonatalFamilyVisit.getEhrId();
			NeonatalFamilyVisit nfv = neonatalFamilyVisitDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, neonatalFamilyVisit);
				if (StringUtil.isNotEmpty(neonatalFamilyVisit.getBabyCardNo())) {
					personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(neonatalFamilyVisit.getBabyCardNo());
				}
				personInfo.setUpdateOrganCode(neonatalFamilyVisit.getCreateOrganCode());
				personInfo.setUpdateName(neonatalFamilyVisit.getCreateOrganName());
				personInfo.setDomainId(neonatalFamilyVisit.getCreateOrganCode());
				//所属乡镇 修改成编号 Modify by:MeiXingjian
				neonatalFamilyVisit.setPatownShip(queryLatownShipCode(neonatalFamilyVisit.getPatownShip()));
				if (ObjectUtil.isNullOrEmpty(nfv)) {
					if (StringUtil.isNotEmpty(neonatalFamilyVisit.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, neonatalFamilyVisit.getCreateOrganCode(), ehrId);
						neonatalFamilyVisit.setPersonId(personId);
					}
					neonatalFamilyVisit.setIsDelete(Short.valueOf("0"));
					neonatalFamilyVisitDao.insert(neonatalFamilyVisit);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.NEONATAL_FAMILY_VISIT);
				} else {
					neonatalFamilyVisit.setId(nfv.getId());
					neonatalFamilyVisit.setPersonId(nfv.getPersonId());
					neonatalFamilyVisitDao.update(neonatalFamilyVisit);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.NEONATAL_FAMILY_VISIT);
				}
				saveHealthEvent(getHealthEvent(ehrId, neonatalFamilyVisit.getPersonId(), EventType.NEWBORN_HOME_VISIT, personInfo, neonatalFamilyVisit.getVisitDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.NEONATAL_FAMILY_VISIT);
				StringBuilder sb = new StringBuilder("保存新生儿家庭访视信息出错！记录表单号为：");
				sb.append(neonatalFamilyVisit.getRecordNumber());
				sb.append("姓名：");
				sb.append(neonatalFamilyVisit.getNeonatusName());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.NEONATAL_FAMILY_VISIT);
			}
		}
	}
	
	public String queryLatownShipCode(String itemName) {
		String itemCode = itemName;
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, "FS990001");
		 //添加查询条件 modify by:MeiXingjian
		//Sample SQL：SELECT ITEM_CODE, ITEM_NAME FROM DIC_ITEM WHERE DIC_CODE='FS990001' AND PARENT_CODE = ' EHRConstants.FS990001_ROOT' AND ITEM_NAME LIKE '%东南开发区%';
		criteria.add(DicItem.ITEM_NAME, OP.LIKE, itemName);
		criteria.add(DicItem.PARENT_CODE, EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		if (dicItems != null && dicItems.size() > 0) {
			DicItem item = dicItems.get(0);
			itemCode = item.getItemCode();
		}
		return itemCode;
	}
	
	/**
	 * 儿童保健卡信息
	 * 
	 * @param dataXml
	 * @param map 记录集成数据量
	 * @throws Exception
	 */
	private void processChildHealthCard(String dataXml, Map<String, Long[]> map) throws Exception {
		ChildHealthCardEntity childHealthCardEntity = null;
		List<ChildHealthCard> childHealthCards = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(childHealthCardEntity = parseDataXml(dataXml, ChildHealthCardEntity.class))
				|| ObjectUtil.isNullOrEmpty(childHealthCards = childHealthCardEntity.getChildHealthCards())) {
			return;
		}
		for (ChildHealthCard childHealthCard : childHealthCards) {
			if (ObjectUtil.isNullOrEmpty(childHealthCard)) {
				continue;
			}
			String mageCardNo = childHealthCard.getMageCardNumber();
			ChildHealthCard chc = childHealthCardDao.get(new Criteria("MAGE_CARD_NUMBER", mageCardNo));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, childHealthCard);
				if (StringUtil.isNotEmpty(childHealthCard.getBabyCardNo())) {
					personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(childHealthCard.getBabyCardNo());
				}
				personInfo.setUpdateOrganCode(childHealthCard.getCreateOrganCode());
				personInfo.setUpdateName(childHealthCard.getCreateOrganName());
				childHealthCard.setLatownShip(queryLatownShipCode(childHealthCard.getLatownShip()));
				
				if (ObjectUtil.isNullOrEmpty(chc)) {
					if (StringUtil.isNotEmpty(childHealthCard.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, childHealthCard.getCreateOrganCode(), mageCardNo);
						childHealthCard.setPersonId(personId);
					}
					childHealthCardDao.insert(childHealthCard);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.CHILD_HEALTHCARD);
				} else {
					childHealthCard.setId(chc.getId());
					childHealthCard.setPersonId(chc.getPersonId());
					childHealthCardDao.update(childHealthCard);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.CHILD_HEALTHCARD);
				}
				createHealthEvent(getHealthEvent(childHealthCard.getPersonId(), EventType.CHILD_HEALTH_CARD, personInfo, childHealthCard.getBuildCardDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.CHILD_HEALTHCARD);
				StringBuilder sb = new StringBuilder("保存儿童保健卡信息出错！医保卡号为：");
				sb.append(childHealthCard.getIdcardHos());
				sb.append("姓名：");
				sb.append(childHealthCard.getName());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.CHILD_HEALTHCARD);
			}
		}
	}
	
	/**
	 * 儿童健康体检信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processChildHealthExamination(String dataXml, Map<String, Long[]> map) throws Exception {
		ChildHealthExaminationEntity childHealthExaminationEntity = null;
		List<ChildHealthExamination> childHealthExaminations = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(childHealthExaminationEntity = parseDataXml(dataXml, ChildHealthExaminationEntity.class))
				|| ObjectUtil.isNullOrEmpty(childHealthExaminations = childHealthExaminationEntity.getChildHealthExaminations())) {
			return;
		}
		for (ChildHealthExamination childHealthExamination : childHealthExaminations) {
			if (ObjectUtil.isNullOrEmpty(childHealthExamination)) {
				continue;
			}
			String ehrId = childHealthExamination.getEhrId();
			ChildHealthExamination che = childHealthExaminationDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, childHealthExamination);
				if (StringUtil.isNotEmpty(childHealthExamination.getBabyCardNo())) {
					personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(childHealthExamination.getBabyCardNo());
				}
				personInfo.setUpdateOrganCode(childHealthExamination.getCreateOrganCode());
				personInfo.setUpdateName(childHealthExamination.getCreateOrganName());
				//所属乡镇 修改成编号 Modify by:MeiXingjian
				childHealthExamination.setPatownShip(queryLatownShipCode(childHealthExamination.getPatownShip()));
				if (ObjectUtil.isNullOrEmpty(che)) {
					if (StringUtil.isNotEmpty(childHealthExamination.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, childHealthExamination.getCreateOrganCode(), ehrId);
						childHealthExamination.setPersonId(personId);
					}
					childHealthExaminationDao.insert(childHealthExamination);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.CHILD_HEALTHEXAMINATION);
				} else {
					childHealthExamination.setId(che.getId());
					childHealthExamination.setPersonId(che.getPersonId());
					childHealthExaminationDao.update(childHealthExamination);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.CHILD_HEALTHEXAMINATION);
				}
				saveHealthEvent(getHealthEvent(ehrId, childHealthExamination.getPersonId(), EventType.CHILD_PYSICAL_EXAMINATION, personInfo, childHealthExamination.getInputDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.CHILD_HEALTHEXAMINATION);
				StringBuilder sb = new StringBuilder("保存儿童健康体检信息出错！记录表单号为：");
				sb.append(childHealthExamination.getRecordNumber());
				sb.append("姓名：");
				sb.append(childHealthExamination.getName());
				sb.append("身份证号：");
				sb.append(childHealthExamination.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.CHILD_HEALTHEXAMINATION);
			}
		}
	}
	
	/**
	 * 体弱儿童管理随访信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processFrailChildFollowup(String dataXml, Map<String, Long[]> map) throws Exception {
		FrailChildFollowupEntity frailChildFollowupEntity = null;
		List<FrailChildFollowup> frailChildFollowups = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(frailChildFollowupEntity = parseDataXml(dataXml, FrailChildFollowupEntity.class))
				|| ObjectUtil.isNullOrEmpty(frailChildFollowups = frailChildFollowupEntity.getFrailChildFollowups())) {
			return;
		}
		for (FrailChildFollowup frailChildFollowup : frailChildFollowups) {
			if (ObjectUtil.isNullOrEmpty(frailChildFollowup)) {
				continue;
			}
			String ehrId = frailChildFollowup.getEhrId();
			FrailChildFollowup fcl = frailChildFollowupDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, frailChildFollowup);
				if (StringUtil.isNotEmpty(frailChildFollowup.getBabyCardNo())) {
					personInfo.setOtherIdcardType(OtherCardType.T91.getCode());
					personInfo.setOtherIdcard(frailChildFollowup.getBabyCardNo());
				}
				personInfo.setUpdateOrganCode(frailChildFollowup.getCreateOrganCode());
				personInfo.setUpdateName(frailChildFollowup.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(fcl)) {
					if (StringUtil.isNotEmpty(frailChildFollowup.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, frailChildFollowup.getCreateOrganCode(), ehrId);
						frailChildFollowup.setPersonId(personId);
					}
					frailChildFollowupDao.insert(frailChildFollowup);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.FRAIL_CHILD_FOLLOWUP);
				} else {
					frailChildFollowup.setId(fcl.getId());
					frailChildFollowup.setPersonId(fcl.getPersonId());
					frailChildFollowupDao.update(frailChildFollowup);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.FRAIL_CHILD_FOLLOWUP);
				}
				saveHealthEvent(getHealthEvent(ehrId, frailChildFollowup.getPersonId(), EventType.DEBILITY_CHILDREN_FOLLOW, personInfo, frailChildFollowup.getInputDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.FRAIL_CHILD_FOLLOWUP);
				StringBuilder sb = new StringBuilder("保存体弱儿童管理随访信息出错！记录表单号为：");
				sb.append(frailChildFollowup.getRecordNumber());
				sb.append("姓名：");
				sb.append(frailChildFollowup.getName());
				sb.append("身份证号：");
				sb.append(frailChildFollowup.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.FRAIL_CHILD_FOLLOWUP);
			}
		}
	}
	
	/**
	 * 婚前保健服务信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processPremaritalHealthService(String dataXml, Map<String, Long[]> map) throws Exception {
		PremaritalHealthServiceEntity premaritalHealthServiceEntity = null;
		List<PremaritalHealthService> premaritalHealthServices = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(premaritalHealthServiceEntity = parseDataXml(dataXml, PremaritalHealthServiceEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(premaritalHealthServices = premaritalHealthServiceEntity.getPremaritalHealthServices())) {
			return;
		}
		for (PremaritalHealthService premaritalHealthService : premaritalHealthServices) {
			if (ObjectUtil.isNullOrEmpty(premaritalHealthService)) {
				continue;
			}
			String ehrId = premaritalHealthService.getEhrId();
			PremaritalHealthService phs = premaritalHealthServiceDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, premaritalHealthService);
				personInfo.setUpdateOrganCode(premaritalHealthService.getCreateOrganCode());
				personInfo.setUpdateName(premaritalHealthService.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(phs)) {
					if (StringUtil.isNotEmpty(premaritalHealthService.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, premaritalHealthService.getCreateOrganCode(), ehrId);
						premaritalHealthService.setPersonId(personId);
					}
					premaritalHealthServiceDao.insert(premaritalHealthService);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.PREMARITAL_HEALTH_SERVICE);
				} else {
					premaritalHealthService.setId(phs.getId());
					premaritalHealthService.setPersonId(phs.getPersonId());
					premaritalHealthServiceDao.update(premaritalHealthService);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.PREMARITAL_HEALTH_SERVICE);
				}
				saveHealthEvent(getHealthEvent(ehrId, premaritalHealthService.getPersonId(), EventType.PREMARITAL_CARE, personInfo, premaritalHealthService.getCheckDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.PREMARITAL_HEALTH_SERVICE);
				StringBuilder sb = new StringBuilder("保存婚前保健服务信息出错！记录表单号为：");
				sb.append(premaritalHealthService.getRecordNumber());
				sb.append("姓名：");
				sb.append(premaritalHealthService.getName());
				sb.append("身份证号：");
				sb.append(premaritalHealthService.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.PREMARITAL_HEALTH_SERVICE);
			}
		}
	}
	
	/**
	 * 妇女病普查信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processWomanDiseaseCensus(String dataXml, Map<String, Long[]> map) throws Exception {
		WomanDiseaseCensusEntity womanDiseaseCensusEntity = null;
		List<WomanDiseaseCensus> womanDiseaseCensuses = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(womanDiseaseCensusEntity = parseDataXml(dataXml, WomanDiseaseCensusEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(womanDiseaseCensuses = womanDiseaseCensusEntity.getWomanDiseaseCensus())) {
			return;
		}
		for (WomanDiseaseCensus womanDiseaseCensus : womanDiseaseCensuses) {
			if (ObjectUtil.isNullOrEmpty(womanDiseaseCensus)) {
				continue;
			}
			String ehrId = womanDiseaseCensus.getEhrId();
			WomanDiseaseCensus wdc = womanDiseaseCensusDao.get(new Criteria(EHR_ID, ehrId));				
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, womanDiseaseCensus);
				personInfo.setUpdateOrganCode(womanDiseaseCensus.getCreateOrganCode());
				personInfo.setUpdateName(womanDiseaseCensus.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(wdc)) {
					if (StringUtil.isNotEmpty(womanDiseaseCensus.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, womanDiseaseCensus.getCreateOrganCode(), ehrId);
						womanDiseaseCensus.setPersonId(personId);
					}
					womanDiseaseCensusDao.insert(womanDiseaseCensus);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.WOMAN_DISEASE_CENSUS);
				} else {
					womanDiseaseCensus.setId(wdc.getId());
					womanDiseaseCensus.setPersonId(wdc.getPersonId());
					womanDiseaseCensusDao.update(womanDiseaseCensus);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.WOMAN_DISEASE_CENSUS);
				}
				saveHealthEvent(getHealthEvent(ehrId, womanDiseaseCensus.getPersonId(), EventType.WOMEN_DISEASES_SURVEY, personInfo, womanDiseaseCensus.getCheckDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.WOMAN_DISEASE_CENSUS);
				StringBuilder sb = new StringBuilder("保存妇女病普查信息出错！记录表单号为：");
				sb.append(womanDiseaseCensus.getRecordNumber());
				sb.append("姓名：");
				sb.append(womanDiseaseCensus.getName());
				sb.append("身份证号：");
				sb.append(womanDiseaseCensus.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.WOMAN_DISEASE_CENSUS);
			}
		}
	}
	
	/**
	 * 计划生育技术服务信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processBirthControlService(String dataXml, Map<String, Long[]> map) throws Exception {
		BirthControlServiceEntity birthControlServiceEntity = null;
		List<BirthControlService> birthControlServices = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(birthControlServiceEntity = parseDataXml(dataXml, BirthControlServiceEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(birthControlServices = birthControlServiceEntity.getBirthControlServices())) {
			return;
		}
		for (BirthControlService birthControlService : birthControlServices) {
			if (ObjectUtil.isNullOrEmpty(birthControlService)) {
				continue;
			}
			String ehrId = birthControlService.getEhrId();
			BirthControlService bcs = birthControlServiceDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, birthControlService);
				personInfo.setUpdateOrganCode(birthControlService.getCreateOrganCode());
				personInfo.setUpdateName(birthControlService.getCreateOrganName());
				personInfo.setDomainId(birthControlService.getCreateOrganCode());
				personInfo.setUpdateOrganCode(birthControlService.getCreateOrganCode());
				personInfo.setUpdateName(birthControlService.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(bcs)) {
					if (StringUtil.isNotEmpty(birthControlService.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, birthControlService.getCreateOrganCode(), ehrId);
						birthControlService.setPersonId(personId);
					}
					birthControlServiceDao.insert(birthControlService);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.BIRTH_CONTROL_SERVICE);
				} else {
					birthControlService.setId(bcs.getId());
					birthControlService.setPersonId(bcs.getPersonId());
					birthControlServiceDao.update(birthControlService);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.BIRTH_CONTROL_SERVICE);
				}
				saveHealthEvent(getHealthEvent(ehrId, birthControlService.getPersonId(), EventType.BIRTH_CONTROL, personInfo, birthControlService.getCheckDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.BIRTH_CONTROL_SERVICE);
				StringBuilder sb = new StringBuilder("保存计划生育技术服务信息出错！记录表单号为：");
				sb.append(birthControlService.getRecordNumber());
				sb.append("姓名：");
				sb.append(birthControlService.getName());
				sb.append("身份证号：");
				sb.append(birthControlService.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.BIRTH_CONTROL_SERVICE);
			}
		}
	}
	
	/**
	 * 孕产期保健服务与高危管理随访信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processMotherhoodPeriodFollowup(String dataXml, Map<String, Long[]> map) throws Exception {
		MotherhoodPeriodFollowupEntity motherhoodPeriodFollowupEntity = null;
		List<MotherhoodPeriodFollowup> motherhoodPeriodFollowups = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowupEntity = parseDataXml(dataXml, MotherhoodPeriodFollowupEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowups = motherhoodPeriodFollowupEntity.getMotherhoodPeriodFollowups())) {
			return;
		}
		for (MotherhoodPeriodFollowup motherhoodPeriodFollowup : motherhoodPeriodFollowups) {
			if (ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowup)) {
				continue;
			}
			
			String ehrId = motherhoodPeriodFollowup.getEhrId();
			MotherhoodPeriodFollowup mpf = motherhoodPeriodFollowupDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, motherhoodPeriodFollowup);
				personInfo.setUpdateOrganCode(motherhoodPeriodFollowup.getCreateOrganCode());
				personInfo.setUpdateName(motherhoodPeriodFollowup.getCreateOrganName());
				personInfo.setDomainId(motherhoodPeriodFollowup.getCreateOrganCode());
				personInfo.setUpdateOrganCode(motherhoodPeriodFollowup.getCreateOrganCode());
				personInfo.setUpdateName(motherhoodPeriodFollowup.getCreateOrganName());
				if (ObjectUtil.isNotEmpty(motherhoodPeriodFollowup.getRiskFactorCode())) {
					// 转换危害因素标准
					motherhoodPeriodFollowup.setRiskFactorCode(String.format("%02d", motherhoodPeriodFollowup.getRiskFactorCode()));
				}
				
				if (ObjectUtil.isNullOrEmpty(mpf)) {
					if (StringUtil.isNotEmpty(motherhoodPeriodFollowup.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, motherhoodPeriodFollowup.getCreateOrganCode(), ehrId);
						motherhoodPeriodFollowup.setPersonId(personId);
					}
					motherhoodPeriodFollowupDao.insert(motherhoodPeriodFollowup);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.MOTHERHOOD_PERIOD_FOLLOWUP);
				} else {
					motherhoodPeriodFollowup.setId(mpf.getId());
					motherhoodPeriodFollowup.setPersonId(mpf.getPersonId());
					motherhoodPeriodFollowupDao.update(motherhoodPeriodFollowup);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.MOTHERHOOD_PERIOD_FOLLOWUP);
				}
				saveHealthEvent(getHealthEvent(ehrId, motherhoodPeriodFollowup.getPersonId(), EventType.PERINATAL_PERIOD_CARE, personInfo, motherhoodPeriodFollowup.getCheckDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.MOTHERHOOD_PERIOD_FOLLOWUP);
				StringBuilder sb = new StringBuilder("保存孕产期保健服务与高危管理随访信息出错！记录表单号为：");
				sb.append(motherhoodPeriodFollowup.getRecordNumber());
				sb.append("姓名：");
				sb.append(motherhoodPeriodFollowup.getMotherName());
				sb.append("身份证号：");
				sb.append(motherhoodPeriodFollowup.getIdcard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.MOTHERHOOD_PERIOD_FOLLOWUP);
			}
		}
	}
	
	/**
	 * 产前筛查与诊断信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processPrenatalScreenDiagnosis(String dataXml, Map<String, Long[]> map) throws Exception {
		PrenatalScreenDiagnosisEntity prenatalScreenDiagnosisEntity = null;
		List<PrenatalScreenDiagnosis> prenatalScreenDiagnosises = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(prenatalScreenDiagnosisEntity = parseDataXml(dataXml, PrenatalScreenDiagnosisEntity.class))
				|| ObjectUtil.isNullOrEmpty(prenatalScreenDiagnosises = prenatalScreenDiagnosisEntity.getPrenatalScreenDiagnosises())) {
			return;
		}
		
		for (PrenatalScreenDiagnosis prenatalScreenDiagnosis : prenatalScreenDiagnosises) {
			if (ObjectUtil.isNullOrEmpty(prenatalScreenDiagnosis)) {
				continue;
			}
			String ehrId = prenatalScreenDiagnosis.getEhrId();
			PrenatalScreenDiagnosis psd = prenatalScreenDiagnosisDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, prenatalScreenDiagnosis);
				personInfo.setUpdateOrganCode(prenatalScreenDiagnosis.getCreateOrganCode());
				personInfo.setUpdateName(prenatalScreenDiagnosis.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(psd)) {
					if (StringUtil.isNotEmpty(prenatalScreenDiagnosis.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, prenatalScreenDiagnosis.getCreateOrganCode(), ehrId);
						prenatalScreenDiagnosis.setPersonId(personId);
					}
					prenatalScreenDiagnosisDao.insert(prenatalScreenDiagnosis);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.PRENATAL_SCREEN_DIAGNOSIS);
				} else {
					prenatalScreenDiagnosis.setId(psd.getId());
					prenatalScreenDiagnosis.setPersonId(psd.getPersonId());
					prenatalScreenDiagnosisDao.update(prenatalScreenDiagnosis);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.PRENATAL_SCREEN_DIAGNOSIS);
				}
				saveHealthEvent(getHealthEvent(ehrId, prenatalScreenDiagnosis.getPersonId(), EventType.PRENATAL_SCREENING_DIAGNOSIS, personInfo, prenatalScreenDiagnosis.getCheckDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.PRENATAL_SCREEN_DIAGNOSIS);
				StringBuilder sb = new StringBuilder("保存产前筛查与诊断信息出错！记录表单号为：");
				sb.append(prenatalScreenDiagnosis.getRecordNumber());
				sb.append("姓名：");
				sb.append(prenatalScreenDiagnosis.getName());
				sb.append("身份证号：");
				sb.append(prenatalScreenDiagnosis.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.PRENATAL_SCREEN_DIAGNOSIS);
			}
		}
	}
	
	/**
	 * 分娩记录信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processDeliveryRecordInfo(String dataXml, Map<String, Long[]> map) throws Exception {
		DeliveryRecordInfoEntity deliveryRecordInfoEntity = null;
		List<DeliveryRecordInfo> deliveryRecordInfos = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(deliveryRecordInfoEntity = parseDataXml(dataXml, DeliveryRecordInfoEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(deliveryRecordInfos = deliveryRecordInfoEntity.getDeliveryRecordInfos())) {
			return;
		}
		for (DeliveryRecordInfo deliveryRecordInfo : deliveryRecordInfos) {
			if (ObjectUtil.isNullOrEmpty(deliveryRecordInfo)) {
				continue;
			}
			String ehrId = deliveryRecordInfo.getEhrId();
			DeliveryRecordInfo dri = deliveryRecordInfoDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, deliveryRecordInfo);
				personInfo.setUpdateOrganCode(deliveryRecordInfo.getCreateOrganCode());
				personInfo.setUpdateName(deliveryRecordInfo.getCreateOrganName());
				personInfo.setDomainId(deliveryRecordInfo.getCreateOrganCode());
				personInfo.setUpdateOrganCode(deliveryRecordInfo.getCreateOrganCode());
				personInfo.setUpdateName(deliveryRecordInfo.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(dri)) {
					if (StringUtil.isNotEmpty(deliveryRecordInfo.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, deliveryRecordInfo.getCreateOrganCode(), ehrId);
						deliveryRecordInfo.setPersonId(personId);
					}
					deliveryRecordInfoDao.insert(deliveryRecordInfo);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.DELIVERY_RECORD_INFO);
				} else {
					deliveryRecordInfo.setId(dri.getId());
					deliveryRecordInfo.setPersonId(dri.getPersonId());
					deliveryRecordInfoDao.update(deliveryRecordInfo);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.DELIVERY_RECORD_INFO);
				}
				saveHealthEvent(getHealthEvent(ehrId, deliveryRecordInfo.getPersonId(), EventType.DELIVERY_RECORD, personInfo, deliveryRecordInfo.getDeliveryDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.DELIVERY_RECORD_INFO);
				StringBuilder sb = new StringBuilder("保存分娩记录信息出错！记录表单号为：");
				sb.append(deliveryRecordInfo.getRecordNumber());
				sb.append("姓名：");
				sb.append(deliveryRecordInfo.getName());
				sb.append("身份证号：");
				sb.append(deliveryRecordInfo.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.DELIVERY_RECORD_INFO);
			}
		}
	}
	
	/**
	 * 出生缺陷监测信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processBirthDefectMonitor(String dataXml, Map<String, Long[]> map) throws Exception {
		BirthDefectMonitorEntity birthDefectMonitorEntity = null;
		List<BirthDefectMonitor> birthDefectMonitors = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(birthDefectMonitorEntity = parseDataXml(dataXml, BirthDefectMonitorEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(birthDefectMonitors = birthDefectMonitorEntity.getBirthDefectMonitors())) {
			return;
		}
		for (BirthDefectMonitor birthDefectMonitor : birthDefectMonitors) {
			if (ObjectUtil.isNullOrEmpty(birthDefectMonitor)) {
				continue;
			}
			String ehrId = birthDefectMonitor.getEhrId();
			BirthDefectMonitor bdm = birthDefectMonitorDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, birthDefectMonitor);
				personInfo.setUpdateOrganCode(birthDefectMonitor.getCreateOrganCode());
				personInfo.setUpdateName(birthDefectMonitor.getCreateOrganName());
				personInfo.setDomainId(birthDefectMonitor.getCreateOrganCode());
				personInfo.setUpdateOrganCode(birthDefectMonitor.getCreateOrganCode());
				personInfo.setUpdateName(birthDefectMonitor.getCreateOrganName());
				//所属乡镇 修改成编号 modify by:MeiXingjian
				birthDefectMonitor.setPatownShip(queryLatownShipCode(birthDefectMonitor.getPatownShip()));
				
				//shu_shu:出生缺陷类别代码:CV0501016里个位数为("01", "02", "03"……), 数据库为("1","2","3"……) 
				String birthDefectType = birthDefectMonitor.getBirthDefectType();
			    if(birthDefectType != null && birthDefectType.length() == 1){
			    	birthDefectType = "0" + birthDefectType;
			    	birthDefectMonitor.setBirthDefectType(birthDefectType);
			    }
			
				if (ObjectUtil.isNullOrEmpty(bdm)) {
					if (StringUtil.isNotEmpty(birthDefectMonitor.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, birthDefectMonitor.getCreateOrganCode(), ehrId);
						birthDefectMonitor.setPersonId(personId);
					}
					birthDefectMonitorDao.insert(birthDefectMonitor);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.BIRTH_DEFECT_MONITOR);
				} else {
					birthDefectMonitor.setId(bdm.getId());
					birthDefectMonitor.setPersonId(bdm.getPersonId());
					birthDefectMonitorDao.update(birthDefectMonitor);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.BIRTH_DEFECT_MONITOR);
				}
				saveHealthEvent(getHealthEvent(ehrId, birthDefectMonitor.getPersonId(), EventType.BIRTH_DEFECTS_MONITOR, personInfo, birthDefectMonitor.getDeliveryDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.BIRTH_DEFECT_MONITOR);
				StringBuilder sb = new StringBuilder("保存出生缺陷监测信息出错！记录表单号为：");
				sb.append(birthDefectMonitor.getRecordNumber());
				sb.append("姓名：");
				sb.append(birthDefectMonitor.getName());
				sb.append("身份证号：");
				sb.append(birthDefectMonitor.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.BIRTH_DEFECT_MONITOR);
			}
		}
	}
	
	/**
	 * 产前随访服务信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processPrenatalFollowup(String dataXml, Map<String, Long[]> map) throws Exception {
		PrenatalFollowupEntity prenatalFollowupEntity = null;
		List<PrenatalFollowup> prenatalFollowups = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(prenatalFollowupEntity = parseDataXml(dataXml, PrenatalFollowupEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(prenatalFollowups = prenatalFollowupEntity.getPrenatalFollowups())) {
			return;
		}
		for (PrenatalFollowup prenatalFollowup : prenatalFollowups) {
			if (ObjectUtil.isNullOrEmpty(prenatalFollowup)) {
				continue;
			}
			String ehrId = prenatalFollowup.getEhrId();
			PrenatalFollowup pfw = prenatalFollowupDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, prenatalFollowup);
				personInfo.setUpdateOrganCode(prenatalFollowup.getCreateOrganCode());
				personInfo.setUpdateName(prenatalFollowup.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(pfw)) {
					if (StringUtil.isNotEmpty(prenatalFollowup.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, prenatalFollowup.getCreateOrganCode(), ehrId);
						prenatalFollowup.setPersonId(personId);
					}
					prenatalFollowupDao.insert(prenatalFollowup);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.PRENATAL_FOLLOWUP);
				} else {
					prenatalFollowup.setId(pfw.getId());
					prenatalFollowup.setPersonId(pfw.getPersonId());
					prenatalFollowupDao.update(prenatalFollowup);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.PRENATAL_FOLLOWUP);
				}
				saveHealthEvent(getHealthEvent(ehrId, prenatalFollowup.getPersonId(), EventType.PRENATAL_FOLLOW, personInfo, prenatalFollowup.getVisitDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.PRENATAL_FOLLOWUP);
				StringBuilder sb = new StringBuilder("保存产前随访服务信息出错！记录表单号为：");
				sb.append(prenatalFollowup.getRecordNumber());
				sb.append("姓名：");
				sb.append(prenatalFollowup.getName());
				sb.append("身份证号：");
				sb.append(prenatalFollowup.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.PRENATAL_FOLLOWUP);
			}
		}
	}
	
	/**
	 * 产后访视服务信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processPostnatalFollowup(String dataXml, Map<String, Long[]> map) throws Exception {
		PostnatalFollowupEntity postnatalFollowupEntity = null;
		List<PostnatalFollowup> postnatalFollowups = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(postnatalFollowupEntity = parseDataXml(dataXml, PostnatalFollowupEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(postnatalFollowups = postnatalFollowupEntity.getPostnatalFollowups())) {
			return;
		}
		for (PostnatalFollowup postnatalFollowup : postnatalFollowups) {
			if (ObjectUtil.isNullOrEmpty(postnatalFollowup)) {
				continue;
			}
			String ehrId = postnatalFollowup.getEhrId();
			PostnatalFollowup pf = whPostnatalFollowupDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, postnatalFollowup);
				personInfo.setUpdateOrganCode(postnatalFollowup.getCreateOrganCode());
				personInfo.setUpdateName(postnatalFollowup.getCreateOrganName());
				personInfo.setDomainId(postnatalFollowup.getCreateOrganCode());
				personInfo.setUpdateOrganCode(postnatalFollowup.getCreateOrganCode());
				personInfo.setUpdateName(postnatalFollowup.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(pf)) {
					if (StringUtil.isNotEmpty(postnatalFollowup.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, postnatalFollowup.getCreateOrganCode(), ehrId);
						postnatalFollowup.setPersonId(personId);
					}
					whPostnatalFollowupDao.insert(postnatalFollowup);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.POSTNATAL_FOLLOWUP);
				} else {
					postnatalFollowup.setId(pf.getId());
					postnatalFollowup.setPersonId(pf.getPersonId());
					whPostnatalFollowupDao.update(postnatalFollowup);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.POSTNATAL_FOLLOWUP);
				}
				saveHealthEvent(getHealthEvent(ehrId, postnatalFollowup.getPersonId(), EventType.POSTNATAL_VISIT, personInfo, postnatalFollowup.getVisitDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.POSTNATAL_FOLLOWUP);
				StringBuilder sb = new StringBuilder("保存产后访视服务信息出错！记录表单号为：");
				sb.append(postnatalFollowup.getRecordNumber());
				sb.append("姓名：");
				sb.append(postnatalFollowup.getName());
				sb.append("身份证号：");
				sb.append(postnatalFollowup.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.POSTNATAL_FOLLOWUP);
			}
		}
	}
	
	/**
	 * 产后42天健康检查信息
	 * 
	 * @param dataXml
	 * @param map 记录数据集成数据量统计
	 * @throws Exception
	 */
	private void processPostpartumDaysHealthInfo(String dataXml, Map<String, Long[]> map) throws Exception {
		PostpartumDaysHealthInfoEntity postpartumDaysHealthInfoEntity = null;
		List<PostpartumDaysHealthInfo> postpartumDaysHealthInfos = null;
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfoEntity = parseDataXml(dataXml, PostpartumDaysHealthInfoEntity.class)) 
				|| ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfos = postpartumDaysHealthInfoEntity.getPostpartumDaysHealthInfos())) {
			return;
		}
		for (PostpartumDaysHealthInfo postpartumDaysHealthInfo : postpartumDaysHealthInfos) {
			if (ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfo)) {
				continue;
			}
			String ehrId = postpartumDaysHealthInfo.getEhrId();
			PostpartumDaysHealthInfo pdi = postpartumDaysHealthInfoDao.get(new Criteria(EHR_ID, ehrId));
			try {
				PersonInfo personInfo = ReflectionUtils.wrapBean(PersonInfo.class, postpartumDaysHealthInfo);
				personInfo.setUpdateOrganCode(postpartumDaysHealthInfo.getCreateOrganCode());
				personInfo.setUpdateName(postpartumDaysHealthInfo.getCreateOrganName());
				personInfo.setDomainId(postpartumDaysHealthInfo.getCreateOrganCode());
				personInfo.setUpdateOrganCode(postpartumDaysHealthInfo.getCreateOrganCode());
				personInfo.setUpdateName(postpartumDaysHealthInfo.getCreateOrganName());
				if (ObjectUtil.isNullOrEmpty(pdi)) {
					if (StringUtil.isNotEmpty(postpartumDaysHealthInfo.getCreateOrganCode())) {
						long personId = platformService.createPerson(personInfo, postpartumDaysHealthInfo.getCreateOrganCode(), ehrId);
						postpartumDaysHealthInfo.setPersonId(personId);
					}
					postpartumDaysHealthInfoDao.insert(postpartumDaysHealthInfo);
					// 记录插入条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 0, IntegrationMonitorRecorder.POSTPARTUM_DAYS_HEALTHINFO);
				} else {
					postpartumDaysHealthInfo.setId(pdi.getId());
					postpartumDaysHealthInfo.setPersonId(pdi.getPersonId());
					postpartumDaysHealthInfoDao.update(postpartumDaysHealthInfo);
					// 记录更新条数
					IntegrationMonitorRecorder.recordHealthCareCount(map, 1, IntegrationMonitorRecorder.POSTPARTUM_DAYS_HEALTHINFO);
				}
				saveHealthEvent(getHealthEvent(ehrId, postpartumDaysHealthInfo.getPersonId(), EventType.POSTNATAL_VISIT, personInfo, postpartumDaysHealthInfo.getSupervisionDate()));
			} catch (Exception e) {
				// 记录失败条数
				IntegrationMonitorRecorder.recordHealthCareCount(map, 2, IntegrationMonitorRecorder.POSTPARTUM_DAYS_HEALTHINFO);
				StringBuilder sb = new StringBuilder("保存产后42天健康检查信息出错！记录表单号为：");
				sb.append(postpartumDaysHealthInfo.getRecordNumber());
				sb.append("姓名：");
				sb.append(postpartumDaysHealthInfo.getName());
				sb.append("身份证号：");
				sb.append(postpartumDaysHealthInfo.getIdCard());
				log.error(sb.toString(), e);
				saveDataFile(dataXml, IntegrationMonitorRecorder.POSTPARTUM_DAYS_HEALTHINFO);
			}
		}
	}
	
	/**
	 * 处理妇幼保健数据
	 * 
	 * @param dataXml XML格式的妇幼保健数据
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	private <T> T parseDataXml(String dataXml, Class<T> clazz) throws JAXBException, UnsupportedEncodingException {
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(clazz)) {
			return null;
		}
		//处理一些比较奇怪的字符串 shu_shu
		dataXml = dataXml.replaceAll("&#x0;", "");
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller um = context.createUnmarshaller();
		T t = (T) um.unmarshal(new ByteArrayInputStream(dataXml.getBytes("UTF-8")));
		return t;
	}
	
	private void saveHealthEvent(EHRHealthEvent ehrHealthEvent) {
		if (ObjectUtil.isNullOrEmpty(ehrHealthEvent)) {
			return;
		}
		Criteria criteria = new Criteria("ehrId", ehrHealthEvent.getEhrId()).add("ehrType", ehrHealthEvent.getEhrType());
		EHRHealthEvent dbEvent = ehrHealthEventDao.get(criteria , "id");
		if (dbEvent == null) {
			ehrHealthEventDao.insert(ehrHealthEvent);
		} else {
			ehrHealthEvent.setId(dbEvent.getId());
			ehrHealthEventDao.update(ehrHealthEvent);
		}
	}
	
	private EHRHealthEvent getHealthEvent(String ehrId, Long personId, EventType ehrType, PersonInfo personInfo, Date clinicDate) {
		if (ObjectUtil.isNullOrEmpty(ehrType) || ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setEhrId(ehrId);
		ehrHealthEvent.setEhrType(ehrType.getCode());
		ehrHealthEvent.setEhrName(ehrType.getName());
		ehrHealthEvent.setPersonId(personId);
		ehrHealthEvent.setName(personInfo.getName());
		ehrHealthEvent.setMarriage(personInfo.getMarriage());
		ehrHealthEvent.setAge(DateUtil.getAge(personInfo.getBirthday(), clinicDate) + "岁"); // 就诊者年龄
		ehrHealthEvent.setCreateDate(new Date());
		ehrHealthEvent.setClinicOrganCode(personInfo.getUpdateOrganCode()); // 诊疗机构代码
		ehrHealthEvent.setClinicOrganName(personInfo.getUpdateOrganName()); // 诊疗机构名称
		ehrHealthEvent.setCreateOrganCode(personInfo.getUpdateOrganCode()); // 创建机构代码
		ehrHealthEvent.setCreateOrganName(personInfo.getUpdateName()); // 创建机构名称
		ehrHealthEvent.setClinicDate(clinicDate);
		ehrHealthEvent.setDataSource(2); // 数据来源 1：来自系统 2：来自集成 默认为：1
		return ehrHealthEvent;
	}
	
	private void createHealthEvent(EHRHealthEvent ehrHealthEvent) {
		if (ObjectUtil.isNullOrEmpty(ehrHealthEvent)) {
			return;
		}
		Criteria criteria = new Criteria("personId", ehrHealthEvent.getPersonId()).add("ehrType", ehrHealthEvent.getEhrType());
		EHRHealthEvent dbEvent = ehrHealthEventDao.get(criteria , "id", "ehrId");
		if (dbEvent == null) {
			Long id = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null).longValue();
			ehrHealthEventDao.update(new Parameters("EHR_ID", id), new Criteria("ID", id));
		} else {
			ehrHealthEvent.setId(dbEvent.getId());
			ehrHealthEvent.setEhrId(dbEvent.getEhrId());
			ehrHealthEventDao.update(ehrHealthEvent);
		}
	}
	
	private EHRHealthEvent getHealthEvent(Long personId, EventType ehrType, PersonInfo personInfo, Date clinicDate) {
		if (ObjectUtil.isNullOrEmpty(ehrType) || ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setEhrType(ehrType.getCode());
		ehrHealthEvent.setEhrName(ehrType.getName());
		ehrHealthEvent.setPersonId(personId);
		ehrHealthEvent.setName(personInfo.getName());
		ehrHealthEvent.setMarriage(personInfo.getMarriage());
		ehrHealthEvent.setAge(DateUtil.getAge(personInfo.getBirthday(), clinicDate) + "岁"); // 就诊者年龄
		ehrHealthEvent.setCreateDate(new Date());
		ehrHealthEvent.setClinicOrganCode(personInfo.getUpdateOrganCode()); // 诊疗机构代码
		ehrHealthEvent.setClinicOrganName(personInfo.getUpdateOrganName()); // 诊疗机构名称
		ehrHealthEvent.setCreateOrganCode(personInfo.getUpdateOrganCode()); // 创建机构代码
		ehrHealthEvent.setCreateOrganName(personInfo.getUpdateOrganName()); // 创建机构名称
		ehrHealthEvent.setClinicDate(clinicDate);
		ehrHealthEvent.setDataSource(2); // 数据来源 1：来自系统 2：来自集成 默认为：1
		return ehrHealthEvent;
	}
	
	private void saveDataFile(String dataXml, String dataType) {
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(dataType) || ObjectUtil.isNullOrEmpty(exceptionFolder)) {
			return;
		}
		StringBuilder sb = new StringBuilder(exceptionFolder).append(dataType).append(File.separator).append(DateUtil.toDateString(new Date(), "yyyyMMdd")).append(File.separator);
		File file = new File(sb.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		String time = DateUtil.toDateString(new Date(), "yyyyMMddHHmmss");
		StringBuilder nb = new StringBuilder(time).append(".xml");
		File f = new File(file, nb.toString());
		InputStream in = null;
		OutputStream os = null;
		try {
			in = new ByteArrayInputStream(dataXml.getBytes("UTF-8"));
			os = new FileOutputStream(f);
			int len = 0;
			byte buffer[] = new byte[3 * 1024];
			while ((len = in.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}

	@Override
	public void setExceptionFolder(String exceptionFolder) {
		this.exceptionFolder = exceptionFolder;
	}

	/**
	 * 儿童体检预约
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<ReserveChild> getChildList(Page page, Criteria criteria){

		return reserveChildDao.getPageList(page, criteria);
	}

	/**
	 * 孕妇体检预约
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<ReserveMaternal> getMaternalList(Page page, Criteria criteria){
		return reserveMaternalDao.getPageList(page, criteria);
	}

	/**
	 * 预防接种预约
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<ReserveVaccination> getVaccinationList(Page page, Criteria criteria){
		return reserveVaccinationDao.getPageList(page, criteria);
	}

}
