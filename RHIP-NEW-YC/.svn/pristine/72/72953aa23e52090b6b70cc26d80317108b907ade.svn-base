/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ech.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.ech.EchIdentificationOption;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyStatusDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.ech.IEchIdentificationDao;
import com.founder.rhip.ehr.repository.ech.IEchIdentificationOptionDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;

@Service("echManageService")
public class EchManagerServiceImpl extends AbstractService implements IEchManageService {

	@Resource(name = "echIdentificationDao")
	private IEchIdentificationDao echIdentificationDao;

	@Resource(name = "echIdentificationOptionDao")
	private IEchIdentificationOptionDao echIdentificationOptionDao;
	
	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;

	@Resource(name = "elderlyPhyExaminationDao")
	private IElderlyPhyExaminationDao elderlyPhyExaminationDao;
	
	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;	

	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;
	
	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;
	
  	@Resource(name = "elderlyPhyStatusDao")
  	private IElderlyPhyStatusDao elderlyPhyStatusDao;

	@Override
	public EchIdentification getEchIdentification(Long id) {
		EchIdentification identification = echIdentificationDao.get(new Criteria("ID",id));
		if(ObjectUtil.isNotEmpty(identification)){
			//辨识表题目获取
			Criteria ca = new Criteria("IDENTIFICATION_ID",identification.getId());
			List<EchIdentificationOption>  identificationOptions = echIdentificationOptionDao.getList(ca);
			if(ObjectUtil.isNotEmpty(identificationOptions)){
				identification.setIdentificationOptions(identificationOptions);
			}
		}
//		else{
//			identification = new EchIdentification();
//			initData(examRecordId,identification);
//		}
		return identification;
	}
	/**
	 * 保存服务记录表
	 * @param       identification
	 * @return      void
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public EchIdentification saveEchIdentification(EchIdentification identification,String... resource){
    	if(ObjectUtil.isNotEmpty(identification)){
    		identification.calTcmFlag();
    		identification.setTcmConclusion(getConclusion(identification));
    		
    		if(ObjectUtil.isNullOrEmpty(identification.getId())){
    			Long id = echIdentificationDao.generatedKey(identification, "ID", null).longValue();
    			identification.setId(id);
    		}else{
        		echIdentificationDao.update(identification);
        	}
    		//保存题目
    		List<EchIdentificationOption>  options = identification.getIdentificationOptions();
            if (ObjectUtil.isNotEmpty(options)) {
                for(EchIdentificationOption option:options){
                	option.setIdentificationId(identification.getId());
                }        
                Criteria ca = new Criteria("IDENTIFICATION_ID", identification.getId());
                echIdentificationOptionDao.delete(ca);
                echIdentificationOptionDao.batchInsert(options);
            }
            //更新老年人、慢病体检表
            updatePhyExamination(identification);

            if(ObjectUtil.isNotEmpty(resource)) {
              if ("1".equals(resource[0])) {
                //更新健康档案体检信息表
                updatePhysiqueExamination(identification);
              }
            }
    	}
    	return identification;
	}

  @Override
  public List<EchIdentification> getEchIdentification(Criteria criteria) {
    return echIdentificationDao.getList(criteria);
  }

  /**
     * 初始化服务记录表
     * @param examRecordId
     * @param       identification
     * @return      void
     */   
    private void initData(Long examRecordId,EchIdentification identification){
       	PhysicalExamRecord record = physicalExamRecordDao.get(examRecordId);
       	if(ObjectUtil.isNotEmpty(record)){
       		identification.setName(record.getName());
       		identification.setIdcard(record.getIdcard());
//       		identification.setExamRecordId(record.getId());
//       		identification.setExaminationDate(record.getExamYear());
       	}
    }
    
//    /**
//     * 更新老年人体检主表
//     * TCM_STATUS 体质辨识状态(0:未管理，1:已管理) 
//     * TCM_CONCLUSION  体质辨识结论
//     * @param conclusion
//     * @param id
//     * @author Ye jianfei
//     */
//    private void updateExamRecord(String conclusion,Long id,String healthGuide){
//    	Parameters parameters = new Parameters();
//    	parameters.add("TCM_CONCLUSION", conclusion);
//    	parameters.add("Tcm_Status", 1);
//        parameters.add("HEALTH_GUIDE_STATUS",healthGuide);
//    	physicalExamRecordDao.update(parameters,new Criteria("ID",id));
//    }

	/**
	 * 更新老年人、慢病体检、个人体检表中体质辨识数据
	 * @param examRecordId
	 */
	private void updateElderlyPhyByTcm(Long personId, Long idenId,Parameters parameters) {
		//更新老年人体检、慢病体检
		Criteria ca = new Criteria("personId", personId).add("identificationId", idenId);
		elderlyPhyExaminationDao.update(parameters, ca); 
		//更新个人体检
        physiqueExaminationDao.update(parameters, ca);  
	}
	
	/**
	 * iden为null--删除体质辨识，iden不为空--修改体质辨识
	 * @param personId
	 * @param examCodes
	 * @param iden
	 */
	private void updateStatusByTcm(Long personId, List<String> examCodes, EchIdentification iden) {
		Parameters parameters = new Parameters();
		if(ObjectUtil.isNullOrEmpty(iden)){
	    	parameters.add("TCM_STATUS","0");
	    	parameters.add("HEALTH_GUIDE_STATUS","0");
		}else{
			parameters.add("TCM_STATUS","1");
			if(StringUtil.isNotEmpty(iden.getQiQualityGuidance())  || StringUtil.isNotEmpty(iden.getYangQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getYinDeficiencyGuidance()) || StringUtil.isNotEmpty(iden.getPhlegmWetnessGuidance())
    				|| StringUtil.isNotEmpty(iden.getHeatMediumGuidance()) || StringUtil.isNotEmpty(iden.getBloodQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getQiStagnationGuidance()) || StringUtil.isNotEmpty(iden.getSpecialQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getPeacefulQualityGuidance())){
    			parameters.add("HEALTH_GUIDE_STATUS","1");
    		}else{
    			parameters.add("HEALTH_GUIDE_STATUS","0");
    		}
		}
		Criteria ca = new Criteria("personId", personId).add("physicalExamCode",OP.IN, examCodes);
		elderlyPhyStatusDao.update(parameters, ca);
	}

	@Transactional
	public void delEchIdentification(Long id) {
		Criteria ca = new Criteria("id",id);
		EchIdentification identification = echIdentificationDao.get(ca);
		echIdentificationDao.delete(ca);
		
		//删除体质辨识答题表
		if(ObjectUtil.isNotEmpty(identification)){
			echIdentificationOptionDao.delete(new Criteria("IDENTIFICATION_ID", identification.getId()));
		}
    	
		//删除已关联的体检记录的id
		if(ObjectUtil.isNotEmpty(identification)){
			List<String> result = new ArrayList<>();
			Criteria cri = new Criteria("personId", identification.getPersonId());
			cri.add("identificationId", identification.getId());
			cri.add("physicalExamType",EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
			List<ElderlyPhyExamination> elders = elderlyPhyExaminationDao.getList(cri, "physicalExamCode");
			for(ElderlyPhyExamination elder : elders){
				result.add(elder.getPhysicalExamCode());
			}
			
			//更新老年人体检状态表
			updateStatusByTcm(identification.getPersonId(), result, null);
			
			Parameters parameters = new Parameters();
	    	parameters.add("TCM_CONCLUSION","");
	    	parameters.add("TCM_QI_QUALITY","");
	    	parameters.add("TCM_YANG_QUALITY","");
	    	parameters.add("TCM_YIN_DEFICIENCY","");
	    	parameters.add("TCM_PHLEGM_WETNESS","");
	    	parameters.add("TCM_HEAT_MEDIUM","");
	    	parameters.add("TCM_BLOOD_QUALITY","");
	    	parameters.add("TCM_QI_STAGNATION","");
	    	parameters.add("TCM_SPECIAL_QUALITY","");
	    	parameters.add("TCM_PEACEFUL_QUALITY","");  
	    	parameters.add("IDENTIFICATION_ID",""); 
	    	updateElderlyPhyByTcm(identification.getPersonId(), identification.getId(), parameters);
		}
	}
	
    /**
     * 更新老年人体检表
     * 如果数据不存在，则创建事件号、新建老年人健康体检数据  
     * @param identification
     * @param record
     * @author Ye jianfei
     */
    private void updatePhyExamination(EchIdentification identification){
    	Parameters parameters = new Parameters();
    	parameters.add("TCM_CONCLUSION",identification.getTcmConclusion());
    	parameters.add("TCM_QI_QUALITY",identification.getQiFlag());
    	parameters.add("TCM_YANG_QUALITY",identification.getYangFlag());
    	parameters.add("TCM_YIN_DEFICIENCY",identification.getYinDeficiencyFlag());
    	parameters.add("TCM_PHLEGM_WETNESS",identification.getPhlegmWetnessFlag());
    	parameters.add("TCM_HEAT_MEDIUM",identification.getHeatMediumFlag());
    	parameters.add("TCM_BLOOD_QUALITY",identification.getBloodFlag());
    	parameters.add("TCM_QI_STAGNATION",identification.getQiStagnationFlag());
    	parameters.add("TCM_SPECIAL_QUALITY",identification.getSpecialFlag());
    	parameters.add("TCM_PEACEFUL_QUALITY",identification.getPeacefulFlag());  
    	List<String> result = new ArrayList<>();
		Criteria cri = new Criteria("personId", identification.getPersonId());
		cri.add("identificationId", identification.getId());
		List<ElderlyPhyExamination> elders = elderlyPhyExaminationDao.getList(cri, "physicalExamCode");
		for(ElderlyPhyExamination elder : elders){
			result.add(elder.getPhysicalExamCode());
		}

		if(ObjectUtil.isNotEmpty(result)){
			Criteria ca = new Criteria("personId",identification.getPersonId()).add("physicalExamCode",OP.IN, result);
			elderlyPhyExaminationDao.update(parameters, ca);  
			
			//更新老年人体检状态表
			updateStatusByTcm(identification.getPersonId(), result, identification);
    	}
		
    	/*Criteria ca = new Criteria("personId",record.getPersonId());
		Criteria mbCa = new Criteria("personId",record.getPersonId());
        //体检编号
        if(StringUtil.isNotEmpty(record.getExamNumber())){
            ca.add("physicalExamCode",record.getExamNumber());
            //更新家医履约中间表内老年人体检信息
            syncHmExam(record.getExamNumber(), record.getPersonId(), identification);
        }else { 体检日期
            Date examinationBeginDate = DateUtil.parseSimpleDate(DateUtil.getDateTime("yyyy", record.getExamYear()) + "/01/01",null);
            Date examinationEndDate = DateUtil.parseSimpleDate(DateUtil.getDateTime("yyyy", record.getExamYear()) + "/12/31",null);
            DateUtil.getCriteriaByDateRange(ca, "examinationDate", examinationBeginDate,examinationEndDate);
        }
		//更新老年人体检
		result = elderlyPhyExaminationDao.update(parameters, ca.add("physicalExamType",EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()));
        //更新慢病体检(按体检日期)
		Date examinationBeginDate = DateUtil.parseSimpleDate(DateUtil.getDateTime("yyyy", record.getExamYear()) + "/01/01",null);
		Date examinationEndDate = DateUtil.parseSimpleDate(DateUtil.getDateTime("yyyy", record.getExamYear()) + "/12/31",null);
		DateUtil.getCriteriaByDateRange(mbCa, "examinationDate", examinationBeginDate,examinationEndDate);
		mbResult = elderlyPhyExaminationDao.update(parameters, mbCa.add("physicalExamType",EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode()));
        //如果更新不到数据，则新增数据
        if(result <=0){
          //老年人体检编号 add by bagen at 2018-05-22
//          String organCode = identification.getCreateOrg();
//          String examNoPre = organCode.substring(organCode.length() - 4, organCode.length()) + DateUtil.getCurrentYear();
//          int serNo = findMaxExamNo(examNoPre);
//          String examNumber = examNoPre + String.format("%05d", ++serNo);
          String examNumber = EHRNumberService.getSerialNum(identification.getCreateOrg(), EHRConstants.EXAM_NUMBER_TYPE);
        	// 体检事件
    		  EHRHealthEvent event = createEhrHealthEvent(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(), "老年人健康体检", identification.getExamRecordId());
        	ElderlyPhyExamination exam = new ElderlyPhyExamination();
        	copyDataToElder(exam,identification);
        	exam.setEhrId(event.getEhrId());
        	exam.setPhysicalExamCode(examNumber);
        	exam.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        	exam.setPersonId(record.getPersonId());
        	exam.setExaminationDate(identification.getExaminationDate());
        	elderlyPhyExaminationDao.insert(exam);
          //体检总表 ECH_PHYSICAL_EXAM_RECORD的体检编号更新 add by bagen at 2018-05-22
          Parameters parameterPhy = new Parameters();
          parameterPhy.add("EXAM_NUMBER", examNumber);
          physicalExamRecordDao.update(parameterPhy,new Criteria("ID",record.getId()));
        }*/
    }
    
	private void copyDataToElder(ElderlyPhyExamination exam,EchIdentification ech){
    	exam.setTcmConclusion(getConclusion(ech));
    	exam.setTcmQiQuality(ech.getQiFlag());
    	exam.setTcmYinDeficiency(ech.getYinDeficiencyFlag());
    	exam.setTcmYangQuality(ech.getYangFlag());
    	exam.setTcmPhlegmWetness(ech.getPhlegmWetnessFlag());
    	exam.setTcmHeatMedium(ech.getHeatMediumFlag());
    	exam.setTcmBloodQuality(ech.getBloodFlag());
    	exam.setTcmQiStagnation(ech.getQiStagnationFlag());
    	exam.setTcmSpecialQuality(ech.getSpecialFlag());
    	exam.setTcmPeacefulQuality(ech.getPeacefulFlag());      	
    }
    
    /**
     * 更新健康档案体检信息表
     *
     * @param identification
     * @param personId
     * @author Ye jianfei
     */
    private void updatePhysiqueExamination(EchIdentification identification){
    	int result = 0;
    	Parameters parameters = new Parameters();
    	parameters.add("TCM_CONCLUSION",identification.getTcmConclusion());
    	parameters.add("TCM_QI_QUALITY",identification.getQiFlag());
    	parameters.add("TCM_YANG_QUALITY",identification.getYangFlag());
    	parameters.add("TCM_YIN_DEFICIENCY",identification.getYinDeficiencyFlag());
    	parameters.add("TCM_PHLEGM_WETNESS",identification.getPhlegmWetnessFlag());
    	parameters.add("TCM_HEAT_MEDIUM",identification.getHeatMediumFlag());
    	parameters.add("TCM_BLOOD_QUALITY",identification.getBloodFlag());
    	parameters.add("TCM_QI_STAGNATION",identification.getQiStagnationFlag());
    	parameters.add("TCM_SPECIAL_QUALITY",identification.getSpecialFlag());
    	parameters.add("TCM_PEACEFUL_QUALITY",identification.getPeacefulFlag());    

		Criteria ca = new Criteria("personId",identification.getPersonId()).add("identificationId", identification.getId());
        physiqueExaminationDao.update(parameters, ca);  

		/* 获取活动数据 ,并更新体检数据 BUG0154737由于会出现多条数据，更新体检日期最新一条 */
/*			List<EHRHealthEvent> ehrHealthEventLs = ehrHealthEventDao.getList(new Criteria("personId", personId).add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode()),new Order("clinic_date",false));
		if (ObjectUtil.isNotEmpty(ehrHealthEventLs)){
			EHRHealthEvent ehrHealthEvent = ehrHealthEventLs.get(0);
			if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
				String ehrId = ehrHealthEvent.getEhrId(); // 活动索引号
				Criteria ca = new Criteria("personId", personId).add("ehrId", ehrId);
				result = physiqueExaminationDao.update(parameters, ca);
			}
		} */
		/*//根据体检日期，更新当年所有体检记录里的体质辨识
		Criteria ca = new Criteria("personId", personId);
		Date examinationBeginDate = DateUtil.parseSimpleDate(DateUtil.getDateTime("yyyy", identification.getExaminationDate()) + "/01/01",null);
		Date examinationEndDate = DateUtil.parseSimpleDate(DateUtil.getDateTime("yyyy", identification.getExaminationDate()) + "/12/31",null);
		DateUtil.getCriteriaByDateRange(ca, "EXAMINATION_DATE", examinationBeginDate,examinationEndDate);
		result = physiqueExaminationDao.update(parameters, ca);
        //如果更新不到数据，则新增数据
        if(result <=0){
    		EHRHealthEvent event = createEhrHealthEvent(EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(), "个人健康体检表", identification.getExamRecordId());
    		String ehrId = event.getEhrId(); // 活动索引号
        	PhysiqueExamination exam = new PhysiqueExamination();
        	copyDataToPhysi(exam,identification);
        	exam.setPersonId(personId);
        	exam.setEhrId(ehrId);
        	exam.setPhysicalExamType(EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode());
        	exam.setPersonId(personId);
        	exam.setExaminationDate(identification.getExaminationDate());
        	physiqueExaminationDao.insert(exam);
        } */   	
    }


    /**
     * 创建或更新卫生事件
     *
     * @param ehrType
     * @param ehrName
     * @param examRecordId
     * @return
     * @author Ye jianfei
     */
	private EHRHealthEvent createEhrHealthEvent(String ehrType, String ehrName,Long examRecordId) {
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setUpdateDate(new Date());
		PhysicalExamRecord physicalExamRecord = physicalExamRecordDao.get(examRecordId);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String examyear = format.format(physicalExamRecord.getExamYear());
		Date clinicDate = null;
		try {
			clinicDate = format.parse(examyear);
		}catch (Exception e){
			e.printStackTrace();
		}
		if (StringUtil.isNotEmpty(ehrType) && ObjectUtil.isNotEmpty(physicalExamRecord)) {
			ehrHealthEvent.setEhrType(ehrType);
			ehrHealthEvent.setEhrName(ehrName);
			ehrHealthEvent.setName(physicalExamRecord.getName());
			if(ObjectUtil.isNotEmpty(physicalExamRecord.getAge())){
				ehrHealthEvent.setAge(physicalExamRecord.getAge().toString());
			}
			ehrHealthEvent.setPersonId(physicalExamRecord.getPersonId());
			ehrHealthEvent.setCreateDate(new Date());
			ehrHealthEvent.setClinicOrganCode(physicalExamRecord.getInputOrganCode());
			ehrHealthEvent.setClinicDate(clinicDate);
			Number healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null);
			Assert.notNull(healthEventId, "事件生成失败");
			ehrHealthEvent.setId(healthEventId.longValue());
			ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
			ehrHealthEventDao.update(ehrHealthEvent, "ehrId");
		}
		return ehrHealthEvent;
	}
	
    private void copyDataToPhysi(PhysiqueExamination exam,EchIdentification ech){
    	exam.setTcmConclusion(ech.getTcmConclusion());
    	exam.setTcmQiQuality(ech.getQiFlag());
    	exam.setTcmYinDeficiency(ech.getYinDeficiencyFlag());
    	exam.setTcmYangQuality(ech.getYangFlag());
    	exam.setTcmPhlegmWetness(ech.getPhlegmWetnessFlag());
    	exam.setTcmHeatMedium(ech.getHeatMediumFlag());
    	exam.setTcmBloodQuality(ech.getBloodFlag());
    	exam.setTcmQiStagnation(ech.getQiStagnationFlag());
    	exam.setTcmSpecialQuality(ech.getSpecialFlag());
    	exam.setTcmPeacefulQuality(ech.getPeacefulFlag());     	
    }
    
    public String getConclusion(EchIdentification identification){
    	String result = "";
    	String mainStr = "";
    	String tendencyStr = "";
    	String basicStr = "";
    	
    	mainStr +=  "1".equals(identification.getQiFlag())?"气虚质 ":"";
    	mainStr +=  "1".equals(identification.getYangFlag())?"阳虚质 ":"";
    	mainStr +=  "1".equals(identification.getYinDeficiencyFlag())?"阴虚质 ":"";
    	mainStr +=  "1".equals(identification.getPhlegmWetnessFlag())?"痰湿质 ":"";
    	mainStr +=  "1".equals(identification.getHeatMediumFlag())?"湿热质 ":"";
    	mainStr +=  "1".equals(identification.getBloodFlag())?"血瘀质 ":"";
    	mainStr +=  "1".equals(identification.getQiStagnationFlag())?"气郁质 ":"";
    	mainStr +=  "1".equals(identification.getSpecialFlag())?"特禀质 ":"";
    	mainStr +=  "1".equals(identification.getPeacefulFlag())?"平和质 ":"";
    	
    	tendencyStr +=  "3".equals(identification.getQiFlag())?"气虚质 ":"";
    	tendencyStr +=  "3".equals(identification.getYangFlag())?"阳虚质 ":"";
    	tendencyStr +=  "3".equals(identification.getYinDeficiencyFlag())?"阴虚质 ":"";
    	tendencyStr +=  "3".equals(identification.getPhlegmWetnessFlag())?"痰湿质 ":"";
    	tendencyStr +=  "3".equals(identification.getHeatMediumFlag())?"湿热质 ":"";
    	tendencyStr +=  "3".equals(identification.getBloodFlag())?"血瘀质 ":"";
    	tendencyStr +=  "3".equals(identification.getQiStagnationFlag())?"气郁质 ":"";
    	tendencyStr +=  "3".equals(identification.getSpecialFlag())?"特禀质 ":"";
	
    	basicStr +=  "2".equals(identification.getPeacefulFlag())?"平和质 ":"";
    	
    	if(StringUtil.isNotEmpty(mainStr)){
    		result += "主要是：";
    		result += mainStr + "  ";
    	}
    	if(StringUtil.isNotEmpty(tendencyStr)){
    		result += "倾向是:";
    		result += tendencyStr + "  ";
    	}
    	if(StringUtil.isNotEmpty(basicStr)){
    		result += "基本是:";
    		result += basicStr;
    	}    	
    	return result;
    }

    /**
     * 取消关联的体质辨识时，personId不为null 
     */
    @Override
	public EchIdentification  updateEchIdentification(Long newIdenId) {
		EchIdentification iden = null;
		//新关联的体质辨识增加体检编号
		if(ObjectUtil.isNotEmpty(newIdenId)){
			iden = echIdentificationDao.get(newIdenId);
			if(ObjectUtil.isNotEmpty(iden)){
				iden.calTcmFlag();
				iden.setTcmConclusion(getConclusion(iden));
			}
		}
		return iden;
	}
	@Override
	public PageList<EchIdentification> getPageList(Page page, Criteria criteria, Order order) {
		return echIdentificationDao.getPageList(page, criteria, order);
	}
}