package com.founder.rhip.ph.service.vaccine;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.control.IVaccinationEventDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.control.IVaccinationMgmtDao;
import com.founder.rhip.ehr.repository.summary.IDiseaseHistoryDao;
import com.founder.rhip.ehr.repository.summary.ITraumaHistoryDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.dto.vaccine.VaccinationDetailsDTO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

/**
 * 
 * @author xu_bin
 * 
 */
@Service("vaccineOperatorService")
public class VaccineOperatorServiceImpl extends AbstractService implements IVaccinationSaveService {
	/**
	 * 一次医疗活动的第一次注射
	 * */
	public static final String VACCINE_FIRST = "1";
	public static final String VACCINE_SECOND = "2";
	
	@Autowired
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Autowired
	private IVaccinationMgmtDao vaccinationMgmtDao;
	
	@Autowired
	private IVaccinationInfoDao vaccinationInfoDao;
	
	@Autowired
	private IExamineEventDao examineEventDao;
	
	@Autowired
	private IExamineDetailDao examineDetailDao;
	
	@Autowired
	private ITraumaHistoryDao traumaHistoryDao;
	
	@Autowired
	private IPlatformService personService;
	
	@Autowired
	private IVaccinationEventDao vaccinationEventDao;
	
	@Autowired
	private IVaccinationReadService vaccinationReadService;
	
	@Resource(name="diseaseHistoryDao")
	private IDiseaseHistoryDao diseaseHistoryDao;
	
	@Override
	@Transactional
	public void deleteVaccine(Long id){
		Criteria criteria = new Criteria("id",id);
		vaccinationInfoDao.delete(criteria);
	}
	
	@Override
	public void saveVaccine(VaccinationDetailsDTO cDCVaccinationDetailsDTO,String comment){
		VaccinationMgmt vaccinationMgmt = cDCVaccinationDetailsDTO.getVaccinationMgmt();
		PersonInfo personInfo = savePerson(cDCVaccinationDetailsDTO);
		
		if (ObjectUtil.isNotEmpty(personInfo)) {
			cDCVaccinationDetailsDTO.setPersonInfo(personInfo);
			String ehrId = saveEHRHealthEvent(cDCVaccinationDetailsDTO);
			vaccinationMgmt = initVaccinationMgmt(ehrId, personInfo, vaccinationMgmt);
			saveVaccinationMgmt(vaccinationMgmt);
			Long eventId = saveVaccinationEvent(ehrId,cDCVaccinationDetailsDTO,comment);
			//更新条码字段：add by yjf 20140214
			updateBarcode(eventId);
			if(cDCVaccinationDetailsDTO.getVaccineType().equals(VACCINE_RABIES)){
				TraumaHistory traumaHistory = initTraumaHistory(ehrId, personInfo, cDCVaccinationDetailsDTO.getTraumaHistory());
				traumaHistoryDao.insert(traumaHistory);
			}else if(cDCVaccinationDetailsDTO.getVaccineType().equals(VACCINE_HEPATITIS)){
				examineEventDao.insert(initExamineEvent(ehrId, personInfo));
				examineDetailDao.batchInsert(initExamineDetailList(ehrId, personInfo, cDCVaccinationDetailsDTO.getExamineDetailList()));
			}
		}
	}
	
	/**
	 * 获取患者最近一次注射情况，包括是否正规注射
	 *
	 * @param personId
	 * @param hitDate 咬伤日期
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public HashMap<String,Object> getRabiesVaccine(Long personId,String hitDate){
		HashMap<String, Object> result = new HashMap<String, Object>();
		int vaccineType = 0;
		String ehrId = getLastEhrId(personId,hitDate);//获取最近一次注射事件号
		if(StringUtil.isNotEmpty(ehrId)){
			vaccineType = getVaccineType(ehrId);
			result.put("vaccineType", vaccineType);//是否正规注射
			TraumaHistory traumaHistory= traumaHistoryDao.get(new Criteria("ehrId", ehrId).add("isDelete",0));
			result.put("preOpsDate", DateUtil.toFormatString("yyyy/MM/dd", traumaHistory.getOpsDate()));//上次咬伤时间
			//上次注射疫苗情况：厂家、注射日期，针数
			getLastInjected(ehrId,result);
			VaccinationEvent vaccinationEvent = vaccinationEventDao.get(new Criteria("ehrId",ehrId));
			if(ObjectUtil.isNotEmpty(vaccinationEvent)){
				result.put("otherNote", vaccinationEvent.getOtherNote());
				result.put("completeFlag", vaccinationEvent.getCompleteFlag());
			}
		}else{
			result.put("vaccineType", 0);//未找到咬伤记录
		}
		return result;
	}
	
	/**
	 * 获取最近一次疫苗接种情况
	 *
	 * @param ehrId
	 * @param result
	 * @author Ye jianfei
	 */
	private void getLastInjected(String ehrId,HashMap<String, Object> result){
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",0).add("immuType",OP.IN,new String[]{VACCINE_RABIES});
		List<VaccinationInfo> vacInfoList = vaccinationInfoDao.getList(criteria,new Order("INOCULATION_TIMES DESC nulls last"));
		if(ObjectUtil.isNotEmpty(vacInfoList)){
			result.put("factory", vacInfoList.get(0).getVaccineCompanyCode());
			result.put("count", vacInfoList.size());
			result.put("lastInjectedDate", DateUtil.getDateTime("yyyy/MM/dd", vacInfoList.get(0).getVaccinationDate()));
		}
	}
	/**
	 * 查找上一次疫苗注射事件
	 *
	 * @param personId
	 * @return
	 * @author Ye jianfei
	 */
	private String getLastEhrId(Long personId,String hitDate){
		String result = "";
		/**
		 * 根据ehrId检查本次咬伤记录
		 */
		if(ObjectUtil.isNotEmpty(personId)){
//			Criteria ca = new Criteria("personId", personId).add("OPS_DATE",OP.UEMPTY,"").add("isDelete", 0);
			Criteria ca = new Criteria("personId", personId).add("isDelete", 0);
			if(StringUtil.isNotEmpty(hitDate)){
				Date endDate = DateUtil.parseDateString(hitDate);
				ca.add("OPS_DATE",OP.LT,endDate);
			}
			List<TraumaHistory> list = traumaHistoryDao.getList(ca,new Order("OPS_DATE DESC nulls last"));
			if(ObjectUtil.isNotEmpty(list)){
				result = list.get(0).getEhrId();
			}
		}
		return result;
	}
	
	/**
	 * 是否正规注射过疫苗
	 * 1：未注射
	 * 2：注射过，但未正规注射
	 * 3：正规注射
	 * @param ehrId
	 * @return
	 * @author Ye jianfei
	 */
	private int getVaccineType(String ehrId){
		int result = 1;
		if (StringUtil.isNotEmpty(ehrId)) {
			// 添加疫苗接种日期基本信息查询
			Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",0).add("immuType",OP.IN,new String[]{VACCINE_RABIES});
			List<VaccinationInfo> vacInfoList = vaccinationInfoDao.getList(criteria,new Order("INOCULATION_TIMES",true));
			//找到疫苗注射记录
			if(ObjectUtil.isNotEmpty(vacInfoList)){
				result = 2;//注射过
				//2-1-1注射法，全程3针，第一针2剂，第二、三针各1剂
				if(vacInfoList.size() >= 3){
					//第一针
					int firstMeasurement = NumberUtil.convert(vacInfoList.get(0).getVaccineMeasurement(),Integer.class);
					//第二针
					int secondMeasurement = NumberUtil.convert(vacInfoList.get(1).getVaccineMeasurement(),Integer.class);
					//第三针
					int thirdMeasurement = NumberUtil.convert(vacInfoList.get(2).getVaccineMeasurement(),Integer.class);
					if(firstMeasurement >= 2 && secondMeasurement >=1 && thirdMeasurement >=1){
						result = 3;//正规注射
					}
				}
			}
		}		
		return result;		
	}

	/**
	 * 根据身份证号获取详细信息
	 * 
	 * @return
	 */
	public VaccinationMgmt getDetailsByIdCard(String idCard) {
		PersonInfo personInfo = personService.queryPersonalInfo(null, idCard);

		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		VaccinationMgmt vaccinationMgmt = vaccinationReadService.getVaccinationMgmt(new Criteria("personId",personInfo.getId()));
		
		// 既往接种史 23价疫苗登记添加既往疾病史信息  修改人：高飞  修改日期：20180417
		//传染病保密设置
		Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
		List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getDiseaseHistoryListByDistinctDiseaseCode(new Criteria("personId",personInfo.getId()).add(limitc));
		if (ObjectUtil.isNotEmpty(diseaseHistoryList)) {
			List<String> strList = new ArrayList<>();
			for (DiseaseHistory diseaseHistory : diseaseHistoryList) {
				if (ObjectUtil.isNullOrEmpty(diseaseHistory) || ObjectUtil.isNullOrEmpty(diseaseHistory.getDiseaseName())) {
					continue;
				}
				StringBuilder builder = new StringBuilder();
				builder.append(DateUtil.getDateTime("yyyy/MM/dd", diseaseHistory.getConfirmationDate())).append(" ").append(diseaseHistory.getDiseaseName());
				strList.add(builder.toString());
			}
			if (ObjectUtil.isNotEmpty(strList)) {
				vaccinationMgmt.setDiseaseHistory(StringUtils.join(strList, ";   "));
			}
		}
		
		// 既往接种史 23价疫苗登记需要查看  添加人：高飞 添加日期 20180403
		if(ObjectUtil.isNotEmpty(vaccinationMgmt.getId())) {
			List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(new Criteria("personId", personInfo.getId()).add("isDelete", 0));
			if (ObjectUtil.isNotEmpty(vaccinationInfoList)) {
				List<String> strList = new ArrayList<>();
				for (VaccinationInfo vaccinationInfo : vaccinationInfoList) {
					if (ObjectUtil.isNullOrEmpty(vaccinationInfo) || ObjectUtil.isNullOrEmpty(vaccinationInfo.getVaccineName())) {
						continue;
					}
					StringBuilder builder = new StringBuilder();
					builder.append(DateUtil.getDateTime("yyyy/MM/dd", vaccinationInfo.getVaccinationDate())).append(" ").append(vaccinationInfo.getVaccineName());
					strList.add(builder.toString());
				}
				if (ObjectUtil.isNotEmpty(strList)) {
					vaccinationMgmt.setVaccineHistory(StringUtils.join(strList, ";   "));
				}
			}
			return vaccinationMgmt;
		}
		vaccinationMgmt.setName(personInfo.getName());
		
		vaccinationMgmt.setGender(personInfo.getGender());
		vaccinationMgmt.setAge(DateUtil.getAgeByBirthday(personInfo.getBirthday()));
		vaccinationMgmt.setIdCard(personInfo.getIdcard());
		vaccinationMgmt.setPastreet(personInfo.getPastreet());
		vaccinationMgmt.setPaGroup(personInfo.getPaGroup());
		vaccinationMgmt.setPatownShip(personInfo.getPatownShip());
		vaccinationMgmt.setPahouseNumber(personInfo.getPahouseNumber());
		vaccinationMgmt.setPhoneNumber(personInfo.getPhoneNumber());
		vaccinationMgmt.setPersonId(personInfo.getId());
		
		return vaccinationMgmt;
	}

	private PersonInfo savePerson(VaccinationDetailsDTO cDCVaccinationDetailsDTO) {
		VaccinationMgmt vaccinationMgmt = cDCVaccinationDetailsDTO.getVaccinationMgmt();
		Organization currentOrg = cDCVaccinationDetailsDTO.getCurrentOrg();
		User currentUser = cDCVaccinationDetailsDTO.getCurrentUser();
		
		PersonInfo personInfo = personService.queryPersonalInfo(null, vaccinationMgmt.getIdCard());

		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			personInfo = new PersonInfo();
		}

		personInfo = new PersonInfo();
		personInfo.setIdcard(vaccinationMgmt.getIdCard());
		personInfo.setName(vaccinationMgmt.getName());
		personInfo.setGender(vaccinationMgmt.getGender());
		personInfo.setBirthday(DateUtil.getBirthdayByAge(vaccinationMgmt.getAge()));
		personInfo.setPhoneNumber(vaccinationMgmt.getPhoneNumber());
		personInfo.setPastreet(vaccinationMgmt.getPastreet());
		personInfo.setPatownShip(vaccinationMgmt.getPatownShip());
		personInfo.setPahouseNumber(vaccinationMgmt.getPahouseNumber());
		personInfo.setUpdateOrganCode(currentOrg.getOrganCode());
		personInfo.setUpdateName(currentUser.getUserName());
		String pId = personService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, false);
		Long id = Long.parseLong(pId);
		personInfo.setId(id);
		return personInfo;
	}

	/**
	 * 继续接种
	 * */
	@Transactional
	public void contineSave(VaccinationInfo vaccineRecord,Organization currentOrg,User currentUser,String comment) {
		String ehrId = vaccineRecord.getEhrId();
		Criteria criteria = new Criteria("ehrId", ehrId);
		VaccinationEvent vaccinationEvent = vaccinationEventDao.get(criteria);
		vaccineRecord = initVaccinationInfo(ehrId, vaccinationEvent.getPersonId(), vaccineRecord);
		vaccinationInfoDao.insert(vaccineRecord);
		vaccinationEvent.setComments(comment);
		vaccinationEvent.setUpdateDate(new Date());
		vaccinationEvent.setUpdateIdcard(currentUser.getIdentityCard());
		vaccinationEvent.setUpdateName(currentUser.getName());
		vaccinationEvent.setUpdateOrg(currentOrg.getOrganCode());
		// 23价疫苗接种标记
		if (StringUtils.equals(vaccineRecord.getImmuType(), IVaccinationSaveService.VACCINE_PNEUMONIA)) {
			vaccinationEvent.setPneumoniaVaccFlag("1"); // 设置接种标记1：接种 修改人：高飞  修改日期：20180403
		}
		// 全程接种标记 修改人：高飞 修改日期：2017/01/17
//		vaccinationEvent.setCompleteFlag(completeFlag);
		vaccinationEventDao.update(vaccinationEvent);
//		if(vaccineRecord.getImmuType().equals(VACCINE_RABIES)){//只有狂犬疫苗才更新
//			//修改最近一次接种信息
//			if (ObjectUtil.isNotEmpty(vaccinationEvent)) {
//				String [] properties = new String[]{"isInjected","lastInjectedDate","count","factory"};
//				vaccinationEventDao.update(builderVaccinationEvent(vaccinationEvent,vaccineRecord),properties);
//			}	
//		}
	}
	
	/** 
	* @Title: saveVaccinationEvent 
	* @Description: 保存接种事件 
	* @param @param ehrId 事件ID
	* @param @param creator 创建者
	* @param @param type 类型
	* @param @param personId 人员ID
	* @param @return
	* @return Long
	* @throws 
	*/
	private Long saveVaccinationEvent(String ehrId,VaccinationDetailsDTO detailsDTO,String comment){
		Organization currentOrg = detailsDTO.getCurrentOrg();
		User currentUser = detailsDTO.getCurrentUser();
		PersonInfo personInfo = detailsDTO.getPersonInfo();		
		
		VaccinationEvent vaccinationEvent = new VaccinationEvent();
		vaccinationEvent.setEhrId(ehrId);
		vaccinationEvent.setCreator(currentUser.getName());
		vaccinationEvent.setCreateIdcard(currentUser.getIdentityCard());
		vaccinationEvent.setCreateDate(new Date());
		vaccinationEvent.setIsDelete(0);
		vaccinationEvent.setPersonId(personInfo.getId());
		vaccinationEvent.setImmuType(detailsDTO.getVaccineType());
		vaccinationEvent.setComments(comment);
		vaccinationEvent.setCreateOrg(currentOrg.getOrganCode());
		vaccinationEvent.setCompleteFlag(detailsDTO.getCompleteFlag());
		vaccinationEvent.setRabiesType(detailsDTO.getRabiesType()); // 狂犬疫苗接种类型
		//最近一次接种信息
		if(detailsDTO.getVaccineType().equals(VACCINE_RABIES)){//只有狂犬疫苗才更新	
			vaccinationEvent.setFlag(detailsDTO.getVacciantionFlag());//本次事件的性质,0、1、5、8表示重新接种，其他表示加强接种。
			vaccinationEvent.setOtherNote(detailsDTO.getOtherNote());
			vaccinationEvent.setFactory(detailsDTO.getFactory());
			vaccinationEvent.setCount(detailsDTO.getCount());
			vaccinationEvent.setLastInjectedDate(detailsDTO.getLastInjectedDate());
			vaccinationEvent.setIsInjected(detailsDTO.getIsInjected());
			vaccinationEvent.setIsOneYearInjected(detailsDTO.getIsOneYearInjected());
			vaccinationEvent.setIsThreeYearInjected(detailsDTO.getIsThreeYearInjected());
			vaccinationEvent.setIsPowerInjected(detailsDTO.getIsPowerInjected());
			vaccinationEvent.setLastFullInjectedDate(detailsDTO.getLastFullInjectedDate());
			vaccinationEvent.setLastPowerInjectedDate(detailsDTO.getLastPowerInjectedDate());
		}
		return vaccinationEventDao.generatedKey(vaccinationEvent, "ID", null).longValue();
	}

	/**
	 * 更新打印类型
	 *
	 * @param ehrId
	 * @param printFlag
	 * @author Ye jianfei
	 */
	public void updatePrintFlag(String ehrId,Integer printFlag){
		if(StringUtil.isNotEmpty(ehrId)){
			Parameters parameters = new Parameters();
			parameters.add("PRINT_FLAG", printFlag);
			vaccinationEventDao.update(parameters, new Criteria("EHR_ID",ehrId));
		}
	}
	/** 
	* @Title: updateVaccinationEvent 
	* @Description: 更新接种事件 
	* @param detailsDTO
	* @param comment
	*/
	private VaccinationEvent updateVaccinationEvent(String ehrId,VaccinationDetailsDTO detailsDTO,String comments){
		Organization currentOrg = detailsDTO.getCurrentOrg();
		User currentUser = detailsDTO.getCurrentUser();
		
		Criteria criteria = new Criteria("ehrId", ehrId);
		VaccinationEvent vaccinationEvent = vaccinationEventDao.get(criteria);
		if(ObjectUtil.isNotEmpty(vaccinationEvent)){
			vaccinationEvent.setUpdateDate(new Date());
			vaccinationEvent.setUpdateIdcard(currentUser.getIdentityCard());
			vaccinationEvent.setUpdateName(currentUser.getName());
			vaccinationEvent.setUpdateOrg(currentOrg.getOrganCode());
			vaccinationEventDao.update(vaccinationEvent);
			vaccinationEvent.setComments(comments);
			vaccinationEvent.setCompleteFlag(detailsDTO.getCompleteFlag());
			if(detailsDTO.getVaccineType().equals(VACCINE_RABIES)){//只有狂犬疫苗才更新
				vaccinationEvent.setFlag(detailsDTO.getVacciantionFlag());//本次事件的性质,0、1、5表示重新接种，其他表示加强接种。
				//修改最近一次接种信息
				String [] properties = new String[]{"flag","isInjected","lastInjectedDate","count","factory","comments","completeFlag","isOneYearInjected","isThreeYearInjected","isPowerInjected","lastFullInjectedDate","lastPowerInjectedDate"};
				vaccinationEvent.setIsInjected(detailsDTO.getIsInjected());
				vaccinationEvent.setLastInjectedDate(detailsDTO.getLastInjectedDate());//疫苗接种日期
				vaccinationEvent.setCount(detailsDTO.getCount());//接种针次数
				vaccinationEvent.setFactory(detailsDTO.getFactory());//生产厂家
				vaccinationEvent.setIsOneYearInjected(detailsDTO.getIsOneYearInjected());
				vaccinationEvent.setIsThreeYearInjected(detailsDTO.getIsThreeYearInjected());
				vaccinationEvent.setIsPowerInjected(detailsDTO.getIsPowerInjected());
				vaccinationEvent.setLastFullInjectedDate(detailsDTO.getLastFullInjectedDate());
				vaccinationEvent.setLastPowerInjectedDate(detailsDTO.getLastPowerInjectedDate());
				vaccinationEventDao.update(vaccinationEvent,properties);
			}
		}
		return vaccinationEvent;
	}	
	/** 
	* @Title: saveVaccinationMgmt 
	* @Description: 保存接种卡信息 
	* @param @param newVaccinationMgmt
	* @return void
	* @throws 
	*/
	private void saveVaccinationMgmt(VaccinationMgmt newVaccinationMgmt){
		Criteria criteria = new Criteria("personId",newVaccinationMgmt.getPersonId());
		criteria.add("vaccinationType", newVaccinationMgmt.getVaccinationType());
		criteria.add("is_delete", "0");
		VaccinationMgmt vaccinationMgmt = vaccinationMgmtDao.get(criteria);
		if(ObjectUtil.isNotEmpty(vaccinationMgmt)){
			newVaccinationMgmt.setId(vaccinationMgmt.getId());
			vaccinationMgmtDao.update(newVaccinationMgmt);
		}else{
			vaccinationMgmtDao.insert(newVaccinationMgmt);
		}
	}
	
	private void updateBarcode(Long id){
		String barcode = getBarcode(id);
		Assert.notNull(barcode, "条码不能为空");
		VaccinationEvent vaccinationEvent = new VaccinationEvent();
		vaccinationEvent.setId(id);
		vaccinationEvent.setBarcode(barcode);
		vaccinationEventDao.update(vaccinationEvent,new String [] {"barcode"});
	}
	/**
	 * 根据ID生成条码字符串
	 * V+年份（4位）+ ID(取后8位，不足，前面补零)
	 * @param id
	 * @return
	 * @author Ye jianfei
	 */
	private String getBarcode(Long id){
		String barcodeString = "V" + DateUtil.getDateTime("yyyy", new Date());
		String index = String.format("%08d", ++id);
		barcodeString += index.substring(index.length() - 8) ;
		return barcodeString;
	}

	@Override
	public void updateVaccine(VaccinationDetailsDTO vaccinationDetailsDTO, String ehrId,String comment) {
		Criteria criteria = new Criteria("ehrId", ehrId);
		
		//修改事件
		VaccinationEvent vaccinationEvent = updateVaccinationEvent(ehrId,vaccinationDetailsDTO,comment);
		Assert.notNull(vaccinationEvent, "事件不能为空");
		//修改接种卡信息
		VaccinationMgmt vaccinationMgmt = vaccinationMgmtDao.get(new Criteria("personId",vaccinationEvent.getPersonId()).add("vaccinationType","02"));
		if (ObjectUtil.isNotEmpty(vaccinationMgmt)) {
			vaccinationMgmtDao.update(builderVaccinationMgmt(vaccinationMgmt, vaccinationDetailsDTO.getVaccinationMgmt()));
		}
		//修改咬伤情况
		TraumaHistory traumaHistory = traumaHistoryDao.get(criteria);
		if (ObjectUtil.isNotEmpty(traumaHistory)) {
			///咬伤等级不能改
			vaccinationDetailsDTO.getTraumaHistory().setBiteLevel(traumaHistory.getBiteLevel());
			traumaHistory = builderTraumaHistory(traumaHistory, vaccinationDetailsDTO.getTraumaHistory());
			traumaHistoryDao.update(traumaHistory);
		}
		//修改乙肝两对半
		List<ExamineDetail> examineDetailList = vaccinationDetailsDTO.getExamineDetailList();
		if(ObjectUtil.isNotEmpty(examineDetailList)){
			for (ExamineDetail examineDetail : examineDetailList) {
				if (ObjectUtil.isNullOrEmpty(examineDetail)) {
					continue;
				}
				examineDetailDao.update(examineDetail, "inspectionResult", "inspectionItemName");
			}
		}
	}
	
	@Override
	@Transactional
	public void save(VaccinationDetailsDTO vaccinationDetailsDTO, String comment,String ehrId){
		if (ObjectUtil.isNotEmpty(ehrId)) {
			updateVaccine(vaccinationDetailsDTO, ehrId,comment);
		}else{
			saveVaccine(vaccinationDetailsDTO,comment);
		}
	}
	
	@Override
	@Transactional
	public void deleteVaccine(String ehrId,String VaccineType) {
		if(VaccineType.equals(VACCINE_RABIES)){
			deleteRabies(ehrId);
		}else if(VaccineType.equals(VACCINE_HEPATITIS)){
			deleteHepatitis(ehrId);
		}
		deleteVaccinationInfo(ehrId);
	}

	private void deleteRabies(String ehrId) {
		Integer isDelete = 1;
		TraumaHistory traumaHistory = traumaHistoryDao.get(new Criteria("ehrId", ehrId));
		if (ObjectUtil.isNotEmpty(traumaHistory)) {
			traumaHistory.setIsDelete(isDelete);
			traumaHistoryDao.update(traumaHistory);
		}
	}

	/**
	 * 删除VaccinationInfo
	 * 
	 * @param Criteria
	 */
	private void deleteVaccinationInfo(String ehrId) {
		Criteria criteria = new Criteria("ehrId", ehrId);
		EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(criteria);
		Integer isDelete = 1;
		
		if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
			ehrHealthEvent.setIsDelete(isDelete);
			ehrHealthEventDao.update(ehrHealthEvent);
		}
		
//		VaccinationMgmt vaccinationMgmt = vaccinationMgmtDao.get(criteria);
//		if (ObjectUtil.isNotEmpty(vaccinationMgmt)) {
//			vaccinationMgmt.setIsDelete(isDelete);
//			vaccinationMgmtDao.update(vaccinationMgmt);
//		}

		VaccinationEvent event = vaccinationEventDao.get(criteria);
		if (ObjectUtil.isNotEmpty(event)) {
			event.setIsDelete(isDelete);
			vaccinationEventDao.update(event);
		}
		
		List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(criteria);
		if (ObjectUtil.isNullOrEmpty(vaccinationInfoList)) {
			return;
		}

		for (VaccinationInfo vaccinationInfo1 : vaccinationInfoList) {
			vaccinationInfo1.setIsDelete(isDelete);
			vaccinationInfoDao.update(vaccinationInfo1);
		}
	}

	private void deleteHepatitis(String ehrId) {
		Criteria ehrCriteria = new Criteria("ehrId", ehrId);
		Integer isDelete = 1;
		VaccinationInfo vaccinationInfo = vaccinationInfoDao.get(ehrCriteria);
		if (ObjectUtil.isNotEmpty(vaccinationInfo)) {
			vaccinationInfo.setIsDelete(isDelete);
			vaccinationInfoDao.update(vaccinationInfo);

		}
		ExamineEvent examineEvent = examineEventDao.get(ehrCriteria);
		if (ObjectUtil.isNotEmpty(examineEvent)) {
			examineEvent.setIsDelete(isDelete);
			examineEventDao.update(examineEvent);
		}
		List<ExamineDetail> examineDetailList = examineDetailDao.getList(ehrCriteria);
		if (ObjectUtil.isNotEmpty(examineDetailList)) {
			for (ExamineDetail examineDetail : examineDetailList) {
				examineDetail.setIsDelete(isDelete);
			}
			examineDetailDao.batchUpdate(examineDetailList);
		}
	}

	/**
	 * 获取一个EHRHealthEvent对象 通过detailsDTO的一些信息 其中ehrType的信息获取是固定的 本系统为（狂犬二类接种）
	 * 
	 * @param detailsDTO
	 * @return EHRHealthEvent
	 */
	private String saveEHRHealthEvent(VaccinationDetailsDTO detailsDTO) {
		Organization currentOrg = detailsDTO.getCurrentOrg();
		PersonInfo personInfo = detailsDTO.getPersonInfo();
		
		EHRHealthEvent eHRHealthEvent = new EHRHealthEvent();
		eHRHealthEvent.setEhrName("疫苗接种");
		eHRHealthEvent.setEhrType(EventType.VACCINATION.getCode());
		eHRHealthEvent.setPersonId(personInfo.getId());
		eHRHealthEvent.setName(personInfo.getName());
		eHRHealthEvent.setCreateDate(new Date());
		eHRHealthEvent.setCreateOrganCode(currentOrg.getOrganCode());
		Long healthEventId = ehrHealthEventDao.generatedKey(eHRHealthEvent, "ID", null).longValue();
		eHRHealthEvent.setEhrId(String.valueOf(healthEventId));
		eHRHealthEvent.setId(healthEventId);
		eHRHealthEvent.setIsDelete(0);
		ehrHealthEventDao.update(eHRHealthEvent);
		return eHRHealthEvent.getEhrId();
	}

	/**
	 * 通过 PersonInfo 和 VaccineRecordDTO 实例化 VaccinationInfo 的基本信息。
	 * 
	 * @param personInfo
	 * @param ehrId
	 * @return vaccinationInfo
	 */
	private VaccinationInfo initVaccinationInfo(String ehrId, Long personId, VaccinationInfo vaccinationInfo) {
		vaccinationInfo.setPersonId(personId);
		vaccinationInfo.setEhrId(ehrId);
		vaccinationInfo.setAdultSecondaryVaccine(1);
		vaccinationInfo.setIsDelete(0);
		vaccinationInfo.setFillTime(new Date());
		return vaccinationInfo;
	}

	/**
	 * 组装数据
	 * 
	 * @param ehrId
	 * @param personInfo
	 * @param suffererBaseInfoDTO
	 * @return
	 */
	private VaccinationMgmt initVaccinationMgmt(String ehrId, PersonInfo personInfo, VaccinationMgmt vaccinationMgmt) {
		vaccinationMgmt.setPersonId(personInfo.getId());
		vaccinationMgmt.setEhrId(ehrId);
		vaccinationMgmt.setIsDelete(0);
		vaccinationMgmt.setVaccinationType("02");
		vaccinationMgmt.setBirthday(DateUtil.getBirthdayByAge(vaccinationMgmt.getAge()));
		vaccinationMgmt.setCreateCardDate(new Date());//建卡日期
		return vaccinationMgmt;
	}

	private VaccinationMgmt builderVaccinationMgmt(VaccinationMgmt vaccinationMgmt, VaccinationMgmt vaccinationMgmt2) {
		vaccinationMgmt.setCreateCardDate(vaccinationMgmt2.getCreateCardDate());//建卡日期
		vaccinationMgmt.setBarcode(vaccinationMgmt2.getBarcode());
		vaccinationMgmt.setName(vaccinationMgmt2.getName());
		vaccinationMgmt.setHouseholdType(vaccinationMgmt2.getHouseholdType());
		vaccinationMgmt.setPastreet(vaccinationMgmt2.getPastreet());
		vaccinationMgmt.setPatownShip(vaccinationMgmt2.getPatownShip());
		vaccinationMgmt.setPaGroup(vaccinationMgmt2.getPaGroup());
		vaccinationMgmt.setPahouseNumber(vaccinationMgmt2.getPahouseNumber());
		vaccinationMgmt.setBirthday(DateUtil.getBirthdayByAge(vaccinationMgmt2.getAge()));
		vaccinationMgmt.setIdCard(vaccinationMgmt2.getIdCard());
		vaccinationMgmt.setGender(vaccinationMgmt2.getGender());
		vaccinationMgmt.setPhoneNumber(vaccinationMgmt2.getPhoneNumber());
		vaccinationMgmt.setResidenceType(vaccinationMgmt2.getResidenceType()); // 户口性质
		vaccinationMgmt.setDomicileFalg(vaccinationMgmt2.getDomicileFalg()); // 常住类型
		vaccinationMgmt.setIsDelete(0);
		if(ObjectUtil.isNotEmpty(vaccinationMgmt2.getWeight())){
			vaccinationMgmt.setWeight(vaccinationMgmt2.getWeight());
		}
		if(ObjectUtil.isNotEmpty(vaccinationMgmt2.getGuardianNameText())){
			vaccinationMgmt.setGuardianNameText(vaccinationMgmt2.getGuardianNameText());
			
		}
		if(ObjectUtil.isNotEmpty(vaccinationMgmt2.getGuardianPhoneText())){
			vaccinationMgmt.setGuardianPhoneText(vaccinationMgmt2.getGuardianPhoneText());
		}
		vaccinationMgmt.setOccupation(vaccinationMgmt2.getOccupation());
		return vaccinationMgmt;
	}
	
	/**
	 * 疫苗继续接种时，更新VaccinationEvent
	 *
	 * @param vaccinationEvent
	 * @param vaccinationInfo
	 * @return
	 * @author Ye jianfei
	 */
	private VaccinationEvent builderVaccinationEvent(VaccinationEvent vaccinationEvent, VaccinationInfo vaccinationInfo) {
		// 添加疫苗接种日期基本信息查询
		Criteria criteria = new Criteria("ehrId", vaccinationInfo.getEhrId()).add("isDelete",0).add("immuType",OP.IN,new String[]{VACCINE_RABIES,VACCINE_GRAY});
		vaccinationEvent.setIsInjected("1");
		Integer vaccinationCount = vaccinationInfoDao.getCount(criteria, "ID",Integer.class);//接种针次
		vaccinationEvent.setLastInjectedDate(vaccinationInfo.getVaccinationDate());//疫苗接种日期
		vaccinationEvent.setCount(vaccinationCount);//接种针次数
		vaccinationEvent.setFactory(vaccinationInfo.getVaccineCompanyCode());//生产厂家
		return vaccinationEvent;
	}
	/**
	 * 检测事件
	 * 
	 * @param ehrId
	 * @param personInfo
	 * @return
	 */
	private ExamineEvent initExamineEvent(String ehrId, PersonInfo personInfo) {
		ExamineEvent examineEvent = new ExamineEvent();
		examineEvent.setPersonId(personInfo.getId());
		examineEvent.setEhrId(ehrId);
		examineEvent.setIsDelete(0);
		return examineEvent;
	}

	/**
	 * 
	 * 处理乙肝保存
	 * 
	 * @param ehrId
	 * @param personInfo
	 * @param examineDetailList
	 * @return
	 */
	private List<ExamineDetail> initExamineDetailList(String ehrId, PersonInfo personInfo, List<ExamineDetail> examineDetailList) {
		List<ExamineDetail> newList = new ArrayList<>();

		for (ExamineDetail examineDetail : examineDetailList) {
			if (ObjectUtil.isNullOrEmpty(examineDetail)) {
				continue;
			}
			examineDetail.setPersonId(personInfo.getId());
			examineDetail.setEhrId(ehrId);
			examineDetail.setInspectionType("乙肝二对半检测结果");
			examineDetail.setIsDelete(0);
			newList.add(examineDetail);
		}
		return newList;
	}

	/**
	 * 格式化咬伤情况
	 * 
	 * @param ehrId
	 * @param personInfo
	 * @param hitBaseInfoDTO
	 * @return
	 */
	private TraumaHistory initTraumaHistory(String ehrId, PersonInfo personInfo, TraumaHistory traumaHistory2) {
		TraumaHistory traumaHistory = new TraumaHistory();
		traumaHistory.setPersonId(personInfo.getId());
		traumaHistory.setEhrId(ehrId);
		builderTraumaHistory(traumaHistory, traumaHistory2);
		return traumaHistory;
	}

	private TraumaHistory builderTraumaHistory(TraumaHistory traumaHistory, TraumaHistory traumaHistory2) {
		traumaHistory.setOpsDate(traumaHistory2.getOpsDate());
		traumaHistory.setTreatmentTime(traumaHistory2.getTreatmentTime());
		traumaHistory.setHurtType(traumaHistory2.getHurtType());
		traumaHistory.setOpsName(traumaHistory2.getOpsName());
		traumaHistory.setPreOpsDate(traumaHistory2.getPreOpsDate());
		traumaHistory.setBiteLevel(traumaHistory2.getBiteLevel());
		traumaHistory.setDoctorAdvise(traumaHistory2.getDoctorAdvise());
		traumaHistory.setIsDelete(0);
		traumaHistory.setHurtSource(traumaHistory2.getHurtSource());
		traumaHistory.setHurtStatus(traumaHistory2.getHurtStatus());
		traumaHistory.setExposeType(traumaHistory2.getExposeType());
		traumaHistory.setHurtNature(traumaHistory2.getHurtNature());
		traumaHistory.setFlushMethod(traumaHistory2.getFlushMethod());
		traumaHistory.setFlushTime(traumaHistory2.getFlushTime());
		traumaHistory.setDisInfectant(traumaHistory2.getDisInfectant());
		if(ObjectUtil.isNotEmpty(traumaHistory2.getOtherFlushMethod())){
			traumaHistory.setOtherFlushMethod(traumaHistory2.getOtherFlushMethod());
		}
		if(ObjectUtil.isNotEmpty(traumaHistory2.getOtherFlushTime())){
			traumaHistory.setOtherFlushTime(traumaHistory2.getOtherFlushTime());
		}
		if(ObjectUtil.isNotEmpty(traumaHistory2.getOtherDisInfectant())){
			traumaHistory.setOtherDisInfectant(traumaHistory2.getOtherDisInfectant());
		}
		if(ObjectUtil.isNotEmpty(traumaHistory2.getOtherHandle())){
			traumaHistory.setOtherHandle(traumaHistory2.getOtherHandle());
		}
		if(ObjectUtil.isNotEmpty(traumaHistory2.getOtherHandles())){
			traumaHistory.setOtherHandles(traumaHistory2.getOtherHandles());
		}
		if(ObjectUtil.isNotEmpty(traumaHistory2.getNoTreat())){
			traumaHistory.setNoTreat(traumaHistory2.getNoTreat());
		}
		return traumaHistory;
	}
}
