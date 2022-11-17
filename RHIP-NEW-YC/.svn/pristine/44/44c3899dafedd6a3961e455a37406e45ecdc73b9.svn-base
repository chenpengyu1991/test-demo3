/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 精神卫生规范管理
 */

package com.founder.rhip.mhm.service;
import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.OrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.dto.ManagementDto;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("mhmManagementService")
public class MhmManagementServiceImpl extends AbstractService implements IMhmManagementService {

    @Resource(name = "mhmEventInfoDao")
    private IMhmEventInfoDao eventInfoDao;     //状态表
    @Resource(name = "mhmStatusInfoDao")
    private IMhmStatusInfoDao mhmStatusInfoDao;     //事件表
    @Resource(name = "mhmBasicsInfoDao")
    private IMhmBasicsInfoDao mhmBasicsInfoDao;     //基本信息
    @Resource(name = "mhmSignDao")
    private IMhmSignDao mhmSignDao;     //体征表
    @Resource(name = "mhmDiagnosisDao")
    private IMhmDiagnosisDao mhmDiagnosisDao;     //诊断治疗表
    @Resource(name = "mhmOtherInfoDao")
    private IMhmOtherInfoDao mhmOtherInfoDao;     //其他表
    @Resource(name = "mhmPathHistoryDao")
    private IMhmPathHistoryDao mhmPathHistoryDao;     //既往史
    @Resource(name = "mhmInhospitalDao")
    private IMhmInhospitalDao mhmInhospitalDao;     //住院
    @Resource(name = "mhmFollowupDao")
    private IMhmFollowupDao mhmFollowupDao;     //随访表
    @Resource(name = "mhmCaseDao")
    private IMhmCaseDao mhmCaseDao;     //个案计划
    @Resource(name = "mhmCaseDetailDao")
    private IMhmCaseDetailDao  mhmCaseDetailDao;     //个案明细
    @Resource(name = "mhmAssessDao")
    private IMhmAssessDao mhmAssessDao;     //评估表
    @Resource(name = "mhmEmergencyDao")
    private IMhmEmergencyDao  mhmEmergencyDao;     //应急处置
    @Resource(name = "mhmDrugRecordDao")
    private IMhmDrugRecordDao  mhmDrugRecordDao;     //用药记录
    @Resource(name = "mhmManageTypeDao")
    private IMhmManageTypeDao  mhmManageTypeDao;     //管理方式
    @Resource(name = "mhmDrugFreeDao")
    private IMhmDrugFreeDao  mhmDrugFreeDao;     //免费服药
    @Resource(name = "mhmSeverityDao")
    private IMhmSeverityDao  mhmSeverityDao;     //病人类型
    @Resource(name = "mhmEconomyDao")
    private IMhmEconomyDao  mhmEconomyDao;     //病人类型
    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "mhmPhysicalExaminationDao")
    private IMhmPhysicalExaminationDao  mhmPhysicalExaminationDao;     //健康体检

    @Resource(name = "uploadInfoRecordDao")
    private IUploadInfoRecordDao uploadInfoRecordDao;//保存附件

    @Resource(name = "mhmInterfaceService")
    private IMhmInterfaceService  mhmInterfaceService;
	@Autowired
	private MhmParamUtil mhmParamUtil;

    @Resource(name = "organizationApp")
    private OrganizationApp organizationApp;

	@Override
	public PageList<MhmManagementQueryDto> findManagementList(Criteria criteria, Page page) {
		PageList<MhmManagementQueryDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = mhmStatusInfoDao.findManagementList(page, criteria);
		}
		return result;
	}

	@Override
	public List<MhmManagementQueryDto> findManagementList(Criteria criteria) {
		List<MhmManagementQueryDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = mhmStatusInfoDao.findManagementList(criteria);
		}
		return result;
	}

    /**
     * 规范管理业务数据获取
     * @param       statusId
     * @param		event
     * @return      ManagementDto
     */
	@Override
	public ManagementDto getMhmManagement(Long statusId,MhmEvents event) {
		ManagementDto result = new ManagementDto();
		Long eventId = null;
    	if(ObjectUtil.isNotEmpty(statusId)){
    		result.setStatusId(statusId);
    		eventId = getEventId(statusId,new Integer[]{event.getValue()});
    	}
    	/*如果eventId为空，则初始化数据，如果eventId不为空，加载相应数据*/
        if(ObjectUtil.isNullOrEmpty(eventId)){
        	initBusiness(result,event);
        }else{
	        Criteria ca = new Criteria("eventId",eventId);
	        result.setEventId(eventId);
	        getBusiness(ca,result);
        }    	
    	return result;
	}
    /**
     * 查询出院列表
     * @param		criteria
     * @return      PageList<MhmFollowup>
     */
    public PageList<MhmInhospital> getDisChargeList(Criteria criteria,Page page){
        PageList<MhmInhospital> plist = null;
        if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
            plist = mhmInhospitalDao.findList(criteria,page);
        }
        return plist;
    }

    /**
     * 查询随访列表
     * @param       statusId
     * @param		page
     * @return      PageList<MhmFollowup>
     */
    public PageList<MhmFollowup> getFollowupList(Long statusId,Page page){
    	PageList<MhmFollowup> plist = null;
    	if(ObjectUtil.isNotEmpty(statusId) && ObjectUtil.isNotEmpty(page)){
    		Criteria criteria = new Criteria("STATUS_ID",statusId).add("EVENT_TYPE",MhmEvents.M_FOLLOWUP.getValue());
    		plist = mhmFollowupDao.findList(criteria,page);
    	}
    	return plist;
    }

    public MhmFollowup getLastFollowup(Long statusId){
       MhmFollowup mhmFollowup = null;
        if(ObjectUtil.isNotEmpty(statusId)){
            Criteria criteria = new Criteria("STATUS_ID",statusId).add("EVENT_TYPE",MhmEvents.M_FOLLOWUP.getValue());
            mhmFollowup = mhmFollowupDao.getLastFollowup(criteria);
        }
        return mhmFollowup;
    }

    
    /**
     * 查询个案计划列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmCase>
     */
    public PageList<MhmCase> getCasePlanList(Criteria criteria,Page page){
    	PageList<MhmCase> plist = null;
    	if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
    		plist = mhmCaseDao.findList(criteria,page);
    	}
    	return plist;
    } 
    
    /**
     * 获取个案计划详情
     * @param criteria
     * @return
     */
    public MhmCase getCasePlan(Criteria criteria) {
    	MhmCase mhmCase = mhmCaseDao.get(criteria);
    	if(ObjectUtil.isNotEmpty(mhmCase)) {
    		Order order = new Order("FINISH_TIME", false);
    		mhmCase.setCaseDetails(mhmCaseDetailDao.getList(new Criteria("EVENT_ID", mhmCase.getEventId()), order));
    	}
    	return mhmCase;
    }
    
    /**
     * 获取效果评估详情
     * @param criteria
     * @return
     */
    public MhmAssess getEvaluation(Criteria criteria) {
    	return mhmAssessDao.get(criteria);
    }
    
    /**
     * 获取应急处置详情
     * @param criteria
     * @return
     */
    public MhmEmergency getEmergency(Criteria criteria) {
    	return mhmEmergencyDao.get(criteria);
    }

    /**
     * 获取健康体检详情
     * @param criteria
     * @return
     */
    public MhmPhysicalExamination getHealthCheck(Criteria criteria){
           return  mhmPhysicalExaminationDao.get(criteria);
    }
    
    /**
     * 查询效果评估列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmAssess>
     */
    public PageList<MhmAssess> getAssessList(Criteria criteria,Page page){
    	PageList<MhmAssess> plist = null;
    	if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
    		plist = mhmAssessDao.findList(criteria,page);
    	}
    	return plist;
    } 
    
    /**
     * 查询应急处置列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmEmergency>
     */
    public PageList<MhmEmergency> getMhmEmergencyList(Criteria criteria,Page page){
    	PageList<MhmEmergency> plist = null;
    	if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
    		plist = mhmEmergencyDao.findList(criteria,page);
    	}
    	return plist;
    }

    /**
     * 查询健康体检列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmPhysicalExamination>
     */
    public PageList<MhmPhysicalExamination> getMhmHealthCheckList(Criteria criteria,Page page){
        PageList<MhmPhysicalExamination> plist = null;
        if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
            plist = mhmPhysicalExaminationDao.findList(criteria, page);
        }

        return plist;
    }
  
    /**
     * 规范管理业务数据获取:同一个事件存在多条数据
     * @param       statusId：新增必填
     * @param       eventId：编辑必填
     * @param		event：新增必填
     * @return      ManagementDto
     */
    public ManagementDto getMulManagement(Long statusId,Long eventId,MhmEvents event){
		ManagementDto result = new ManagementDto();
    	if(ObjectUtil.isNotEmpty(statusId)){
    		result.setStatusId(statusId);
    	}
	   	if(ObjectUtil.isNotEmpty(eventId)){
	   		result.setEventId(eventId);
	        Criteria ca = new Criteria("eventId",eventId);
	        getBusiness(ca,result);
    	}else{
	   		initBusiness(result,event);
    	}
    	return result;
    }
    
    /**
     * 规范管理业务数据保存
     * @param       mngDto
     * @param       event
     * @return      boolean
     */    
	@Override
    @Transactional
	public boolean saveMhmManagement(ManagementDto mngDto, MhmEvents event, Integer status) {
    	int result = 0;
        Long statusId = mngDto.getStatusId();
    	Long eventId = mngDto.getEventId();
        if(event.getValue().equals(MhmEvents.M_ARCHIVES.getValue())||event.getValue().equals(MhmEvents.I_DISCHARGED.getValue())){
            Integer [] integers = {event.getValue()};
            eventId = getEventId(statusId, integers);
        }

		if (ObjectUtil.isNullOrEmpty(mngDto.getStatusId())) {
			log.error("statusId为空");
			return false;
		}    	
		if (ObjectUtil.isNullOrEmpty(event)) {
			log.error("event为空");
			return false;
		}
		if (ObjectUtil.isNullOrEmpty(mngDto.getCurrentUser())) {
			log.error("操作人员为空");
			return false;
		} 
		mngDto.setEventType(event.getValue());
		if(ObjectUtil.isNullOrEmpty(eventId)){
			MhmEventInfo eventInfo = new MhmEventInfo();
			eventInfo.setStatusId(statusId);
			if(event.equals(MhmEvents.M_LOST_FOLLOWUP)){//失访信息，每次添加一条随访记录，随访方式为：未访到
				eventInfo.setEventType(MhmEvents.M_FOLLOWUP.getValue());
			}else{
				eventInfo.setEventType(event.getValue());
			}
			eventId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
		}
        mngDto.setEventId(eventId);
		MhmBasicsInfo mhmBasicsInfo = mngDto.getMhmBasicsInfo();
        //存地址
        if(ObjectUtil.isNotEmpty(mhmBasicsInfo)){
            mhmBasicsInfo.setPaAddress(dictionaryApp.queryDicItemName("FS990001", mhmBasicsInfo.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", mhmBasicsInfo.getPastreet()) +dictionaryApp.queryDicItemName("FS990001", mhmBasicsInfo.getPaGroup()) + mhmBasicsInfo.getPahouseNumber());
            mhmBasicsInfo.setHrAddress(dictionaryApp.queryDicItemName("FS990001", mhmBasicsInfo.getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", mhmBasicsInfo.getHrstreet()) +dictionaryApp.queryDicItemName("FS990001", mhmBasicsInfo.getHrGroup())+ mhmBasicsInfo.getHrhouseNumber());
        }
        
        MhmStatusInfo mhmStatusInfo = new MhmStatusInfo();
        
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
			try {
				SavePerson(mngDto);//调用接口新增或更新患者
				PersonInfo personInfo = mngDto.getPersonInfo();
				if(ObjectUtil.isNotEmpty(personInfo)){			
					mhmStatusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
					mhmStatusInfo.setPersonId(personInfo.getId());
				}					
			} catch (Exception e) {
				log.error("精神卫生规范管理-患者保存失败。更新患者信息失败。" + e.getMessage());
				throw new RuntimeException("更新患者信息失败。", e);
            }
        }
        
		result = saveBusiness(mngDto,eventId,event);
        if(null!=status && status >= 0){
            mhmStatusInfo.setId(statusId);
            mhmStatusInfo.setStatus(status);
            mhmStatusInfo.setLogoff(mngDto.getLogoff());
            mhmStatusInfoDao.updateStatus(mhmStatusInfo, new Criteria("ID",mhmStatusInfo.getId()));
        }
		return result != 0?true:false;
	}

    /**
     * 规范管理业务数据删除--同一个事件存在多条数据
     * @param       eventId
     * @return      boolean
     */
    @Transactional
    public boolean deleteMul(Long eventId){
		int result = 0;
		Criteria caBusiness = new Criteria("EVENT_ID", eventId);
		Criteria caEvent = new Criteria("ID", eventId);
		if(ObjectUtil.isNotEmpty(eventId)){
			result += mhmFollowupDao.delete(caBusiness);//随访
			result += mhmCaseDao.delete(caBusiness);//个案计划
			result += mhmCaseDetailDao.delete(caBusiness);//个案计划详情
			result += mhmAssessDao.delete(caBusiness);//效果评估
			result += mhmEmergencyDao.delete(caBusiness);//应急处置
			result += eventInfoDao.delete(caEvent);//事件表
		}
		return result >0?true:false;    	
    }

    /**
     * 逻辑删除规范化管理主表数据
     */
    @Override
    @Transactional
    public boolean delManageMentData(Long statusId,String pixId,String idcard){
        int result = 0;
        Criteria caEvent = new Criteria("STATUS_ID", statusId).add("EVENT_TYPE",MhmEvents.M_ARCHIVES.getValue());
        if(ObjectUtil.isNotEmpty(statusId)){
            //同时逻辑删除StatusInfo表数据 新增时会根据此表判断 是否存在患者数据
            mhmStatusInfoDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1), new Criteria("PIX_ID",pixId));
            result += eventInfoDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1),caEvent);//事件表
        }
        //需要删除此表数据 新增页面纳入管理会根据身份证号码判断是否已保存病人基本信息 HNYC-832【精神障碍患者管理】规范化管理-患者删除精神病管理卡，再新增后列表不显示
        mhmBasicsInfoDao.delete(new Criteria("IDCARD",idcard));
        return result >0?true:false;
    }

    /**
     * @param       eventId
     * @return      boolean
     */
    @Transactional
    public boolean deleteHealthCheck(Long eventId){
        int result = 0;
        Criteria caBusiness = new Criteria("EVENT_ID", eventId);
        Criteria caEvent = new Criteria("ID", eventId);
        if(ObjectUtil.isNotEmpty(eventId)){
            result += mhmPhysicalExaminationDao.delete(caBusiness);
            result += eventInfoDao.delete(caEvent);//事件表
        }
        return result >0?true:false;
    }

    /**
     * 审批随访记录
     * @param       id
     * @return      status
     */
    @Transactional
    public boolean approvalFollowup(Long id,String status){
		int result = 0;
		if(ObjectUtil.isNotEmpty(id) && StringUtil.isNotEmpty(status)){
			Parameters parameters = new Parameters();
			parameters.add("FOLLOWUP_STATUS", status);
			result = mhmFollowupDao.update(parameters, new Criteria("ID",id));
		}
		return result >0?true:false;    	
    }
    
	/**
	 * 保存患者信息
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	private void SavePerson(ManagementDto dto) throws Exception {
		String []param = new String[]{};
		Integer eventType = dto.getEventType();
		PersonInfo personInfo = dto.getPersonInfo();
		if(ObjectUtil.isNotEmpty(eventType)){
			param = mhmParamUtil.getParam(eventType);
		}
		mhmInterfaceService.updatePersonInfo(personInfo,param);
		dto.setPersonInfo(personInfo);
	}
    /**
     * 规范管理业务数据获取
     * @param       ca
     * @param       dto
     * @return      ManagementDto
     */    
    private void getBusiness(Criteria ca,ManagementDto dto){
        MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
        	dto.setMhmBasicsInfo(mhmBasicsInfo);
        }
        MhmDiagnosis mhmDiagnosis = mhmDiagnosisDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmDiagnosis)) {
        	dto.setMhmDiagnosis(mhmDiagnosis);
        }
        MhmOtherInfo mhmOtherInfo = mhmOtherInfoDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
        	dto.setMhmOtherInfo (mhmOtherInfo);
        }
        MhmPathHistory mhmPathHistory = mhmPathHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmPathHistory)) {
        	dto.setMhmPathHistory (mhmPathHistory);
        }
        MhmInhospital mhmInhospital = mhmInhospitalDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmInhospital)) {
        	dto.setMhmInhospital (mhmInhospital);
        }
        List<MhmDrugRecord> mhmFollowupDrugRecords = mhmDrugRecordDao.getList(new Criteria().add(ca).add("type", "3"));//随访用药
        if (ObjectUtil.isNotEmpty(mhmFollowupDrugRecords)) {
            dto.setFollowupMedicationRecords(mhmFollowupDrugRecords);
        }

        List<MhmDrugRecord> mhmDrugRecords = mhmDrugRecordDao.getList(new Criteria().add(ca).add("type", "1"));//住院用药
        if (ObjectUtil.isNotEmpty(mhmDrugRecords)) {
            dto.setInMedicationRecords(mhmDrugRecords);
        }

        List<MhmDrugRecord> nextDrugRecords = mhmDrugRecordDao.getList(new Criteria().add(ca).add("type", "2"));//住院用药
        if (ObjectUtil.isNotEmpty(nextDrugRecords)) {
            dto.setNextMedicationRecords(nextDrugRecords);
        }

        MhmFollowup mhmFollowup = mhmFollowupDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmFollowup)) {
        	dto.setMhmFollowup(mhmFollowup);
        } 
        MhmCase mhmCase = mhmCaseDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmCase)) {
        	dto.setMhmCase(mhmCase);
        } 
        MhmCaseDetail mhmCaseDetail = mhmCaseDetailDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmCaseDetail)) {
        	dto.setMhmCaseDetail(mhmCaseDetail);
        } 
        MhmAssess mhmAssess = mhmAssessDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmAssess)) {
        	dto.setMhmAssess(mhmAssess);
        } 
        MhmEmergency mhmEmergency = mhmEmergencyDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmEmergency)) {
        	dto.setMhmEmergency(mhmEmergency);
        }         
    }

    /**
     * 更新业务表
     * @param       dto
     * @param       eventId
     * @param       event
     * @return      int
     */
    private int  saveBusiness(ManagementDto dto,Long eventId,MhmEvents event){
    	int result = 0;
    	initService(dto,event);

        MhmBasicsInfo mhmBasicsInfo = dto.getMhmBasicsInfo();
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
        	mhmBasicsInfo.setEventId(eventId);
            if(ObjectUtil.isNullOrEmpty(mhmBasicsInfo.getId())){
                long basicsInfoKey=mhmBasicsInfoDao.generatedKey(mhmBasicsInfo, "ID", null).longValue();
                mhmBasicsInfo.setId(basicsInfoKey);
                result =1;
            }else {
                result = mhmBasicsInfoDao.update(mhmBasicsInfo);
            }

            //保存附件
            if (ObjectUtil.isNotEmpty(dto.getFileMap()) && ObjectUtil.isNotEmpty(dto.getFileNameMap())) {
                List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
                for (String uuid : dto.getFileMap().keySet()) {
                    String originalFilePath = dto.getFileMap().get(uuid);
                    UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
                    uploadInfoRecord.setResourceId(mhmBasicsInfo.getId());
                    uploadInfoRecord.setOriginalFilePath(originalFilePath);
                    uploadInfoRecord.setOriginalFileName(dto.getFileNameMap().get(uuid));
                    //StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
                    uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
                    //uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
                    uploadInfoRecord.setFileResource("jszahzbl");//精神障碍患者病历
                    uploadInfoRecord.setCreateTime(new Date());
                    uploadInfoRecord.setCreater(dto.getCurrentUser().getUserName());
                    uploadInfoRecords.add(uploadInfoRecord);
                }
                uploadInfoRecordDao.batchInsert(uploadInfoRecords);
            }
        }
        MhmDiagnosis mhmDiagnosis = dto.getMhmDiagnosis();
        if (ObjectUtil.isNotEmpty(mhmDiagnosis)) {
        	mhmDiagnosis.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmDiagnosis.getId())){
        		result = mhmDiagnosisDao.insert(mhmDiagnosis);
        	}else{
        		result = mhmDiagnosisDao.update(mhmDiagnosis);
        	} 
        }
        MhmOtherInfo mhmOtherInfo = dto.getMhmOtherInfo();
        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
        	mhmOtherInfo.setEventId(eventId);
            //增加所属镇和中心字段
            if(StringUtil.isNotEmpty(mhmOtherInfo.getManagementStation())){
                String orgCode = mhmOtherInfo.getManagementStation();
                Organization org = organizationApp.queryOrgan(orgCode);
                if(ObjectUtil.isNotEmpty(org)){
                    mhmOtherInfo.setBelongTownship(org.getGbCode());
                    mhmOtherInfo.setBelongCenter(org.getParentCode());
                }
            }else if(StringUtil.isNotEmpty(mhmOtherInfo.getManagementCenter())){
                String orgCode = mhmOtherInfo.getManagementCenter();
                Organization org = organizationApp.queryOrgan(orgCode);
                if(ObjectUtil.isNotEmpty(org)){
                    mhmOtherInfo.setBelongTownship(org.getGbCode());
                    mhmOtherInfo.setBelongCenter(orgCode);
                }
            }
    		if(ObjectUtil.isNullOrEmpty(mhmOtherInfo.getId())){
        		result = mhmOtherInfoDao.insert(mhmOtherInfo);
        	}else{
        		result = mhmOtherInfoDao.update(mhmOtherInfo);
        	} 
        }
        MhmPathHistory mhmPathHistory = dto.getMhmPathHistory();
        if (ObjectUtil.isNotEmpty(mhmPathHistory)) {
        	mhmPathHistory.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmPathHistory.getId())){
        		result = mhmPathHistoryDao.insert(mhmPathHistory);
        	}else{
        		result = mhmPathHistoryDao.update(mhmPathHistory);
        	} 
        }
        MhmInhospital mhmInhospital = dto.getMhmInhospital();
        if (ObjectUtil.isNotEmpty(mhmInhospital)) {
        	mhmInhospital.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmInhospital.getId())){
        		result = mhmInhospitalDao.insert(mhmInhospital);
        	}else{
        		result = mhmInhospitalDao.update(mhmInhospital);
        	} 
        }
//        MhmDrugRecord mhmDrugRecord = dto.getMhmDrugRecord();
//        if (ObjectUtil.isNotEmpty(mhmDrugRecord)) {
//        	mhmDrugRecord.setEventId(eventId);
//    		if(ObjectUtil.isNullOrEmpty(mhmDrugRecord.getId())){
//        		result = mhmDrugRecordDao.insert(mhmDrugRecord);
//        	}else{
//        		result = mhmDrugRecordDao.update(mhmDrugRecord);
//        	}
//        }
        MhmFollowup mhmFollowup = dto.getMhmFollowup();
        if (ObjectUtil.isNotEmpty(mhmFollowup)) {
        	mhmFollowup.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmFollowup.getId())){
        		result = mhmFollowupDao.insert(mhmFollowup);
        	}else{
        		result = mhmFollowupDao.update(mhmFollowup);
        	} 
        } 
        MhmCase mhmCase = dto.getMhmCase();
        if (ObjectUtil.isNotEmpty(mhmCase)) {
        	mhmCase.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmCase.getId())){
    			result = mhmCaseDao.insert(mhmCase);
        	}else{
        		result = mhmCaseDao.update(mhmCase);
        	}
            List<MhmCaseDetail> caseDetails = mhmCase.getCaseDetails();
            mhmCaseDetailDao.delete(new Criteria("EVENT_ID", eventId));
            if (ObjectUtil.isNotEmpty(caseDetails)) {
                mhmCaseDetailDao.batchInsert(caseDetails);
            }
        }

        MhmAssess mhmAssess = dto.getMhmAssess();
        if (ObjectUtil.isNotEmpty(mhmAssess)) {
        	mhmAssess.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmAssess.getId())){
        		result = mhmAssessDao.insert(mhmAssess);
        	}else{
        		result = mhmAssessDao.update(mhmAssess);
        	} 
        } 
        MhmEmergency mhmEmergency = dto.getMhmEmergency();
        if (ObjectUtil.isNotEmpty(mhmEmergency)) {
        	mhmEmergency.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmEmergency.getId())){
        		result = mhmEmergencyDao.insert(mhmEmergency);
        	}else{
        		result = mhmEmergencyDao.update(mhmEmergency);
        	} 
        }
        MhmPhysicalExamination physicalExamination = dto.getMhmPhysicalExamination();
        if(ObjectUtil.isNotEmpty(physicalExamination)){
            physicalExamination.setEventId(eventId);
            if(ObjectUtil.isNullOrEmpty(physicalExamination.getId())){
                result = mhmPhysicalExaminationDao.insert(physicalExamination);
            }else {
                result = mhmPhysicalExaminationDao.update(physicalExamination);
            }
        }
    	return result;
    }
 
    
    /**
     * 执行业务逻辑
     * @param       dto
     * @param       event
     * @return      
     */
    private void initService(ManagementDto dto,MhmEvents event){
    	switch (event){
    		case M_ARCHIVES:
    			archivesService(dto);
    			break;
    		case I_DISCHARGED:
    			dischargedService(dto);
    			break;
    		case M_FOLLOWUP:
    			followupService(dto);
    			break;
    		case M_LOST_FOLLOWUP:
    			lostFollowupService(dto);
    			break;
    		case M_CASE_PLAN:
    			casePlanService(dto);
    			break;
    		case M_EVALUATION:
    			evaluationService(dto);
    			break;  
    		case M_EMERGENCY:
    			emergencyService(dto);
    			break; 
    		case I_OUTPATIENT:
    			outpatientService(dto);
    			break; 
    		case M_REFERRAL:
    			referralService(dto);
    			break; 
    	}     	
    }
	/**
	 * 获取事件表ID
	 * @param statusId
	 * @param eventType
	 * @return
	 */
    private Long getEventId(Long statusId, Integer []eventType){
        Long eventId = null;
        Criteria eventCa = new Criteria("eventType",OP.IN, eventType).add("statusId", statusId);
        MhmEventInfo eventInfo = eventInfoDao.get(eventCa);
        if(ObjectUtil.isNotEmpty(eventInfo)){
        	eventId = eventInfo.getId();
        }
        return eventId;
    }
    
	/**
	 * 初始化业务数据
	 * @param dto
	 * @param event
	 * @return
	 */    
    private void initBusiness(ManagementDto dto, MhmEvents event){
    	switch (event){
    		case M_ARCHIVES:
    			initArchives(dto);
    			break;
    		case I_DISCHARGED:
    			initDischarged(dto);
    			break;
    		case M_FOLLOWUP:
    			initFollowup(dto);
    			break;
    		case M_LOST_FOLLOWUP:
    			initLostFollowup(dto);
    			break;
    		case M_CASE_PLAN:
    			initCasePlan(dto);
    			break;
    		case M_EVALUATION:
    			initEvaluation(dto);
    			break;  
    		case M_EMERGENCY:
    			initEmergency(dto);
    			break; 
    		case I_OUTPATIENT:
    			initOutpatient(dto);
    			break; 
    		case M_REFERRAL:
    			initReferral(dto);
    			break; 
    	}  
    }
    
    /**
     * 初始化规范管理-基本档案
     * @param       dto
     * @return      void
     */   
    private void initArchives(ManagementDto dto){
       	/*如果没有基础档案，初始化基本信息数据*/
    	Long statusId = dto.getStatusId();
    	if(ObjectUtil.isNotEmpty(statusId)){
	    	Long eventId = getEventId(statusId,
	    			new Integer[]{MhmEvents.M_CLUE.getValue(),MhmEvents.I_DISCHARGED.getValue(),MhmEvents.I_OUTPATIENT.getValue()});
	    	Criteria ca = new Criteria("EVENT_ID",eventId); 
	        MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
	        	mhmBasicsInfo.setId(null);
	        	dto.setMhmBasicsInfo(mhmBasicsInfo);
	        }
	        MhmSign mhmSign = mhmSignDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmSign)) {
	        	mhmSign.setId(null);
	        	dto.setMhmSign(mhmSign);
	        }
	        MhmDiagnosis mhmDiagnosis = mhmDiagnosisDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmDiagnosis)) {
	        	mhmDiagnosis.setId(null);
	        	dto.setMhmDiagnosis(mhmDiagnosis);
	        }
	        MhmOtherInfo mhmOtherInfo = mhmOtherInfoDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
//	        	mhmOtherInfo.setId(null);
	        	dto.setMhmOtherInfo(mhmOtherInfo);
	        }
    	}    	
    }
    /**
     * 初始化规范管理-出院信息
     * @param       dto
     * @return      void
     */   
    private void initDischarged(ManagementDto dto){
    	
    }
    /**
     * 初始化规范管理-随访记录
     * @param       dto
     * @return      void
     */   
    private void initFollowup(ManagementDto dto){
       	/*如果未进行个案调查，初始化基本信息数据*/
    	Long statusId = dto.getStatusId();
    	if(ObjectUtil.isNotEmpty(statusId)){
	    	Long eventId = getEventId(statusId,new Integer[]{MhmEvents.M_ARCHIVES.getValue()});
	    	Criteria ca = new Criteria("EVENT_ID",eventId); 
	    	MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
	    	MhmFollowup mhmFollowup = new MhmFollowup();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            try {
				BeanUtils.copyProperties(mhmFollowup, mhmBasicsInfo);
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
            mhmFollowup.setId(null);
            dto.setMhmFollowup(mhmFollowup);
    	}
    }
    /**
     * 初始化规范管理-失访信息
     * @param       dto
     * @return      void
     */   
    private void initLostFollowup(ManagementDto dto){
       	/*如果未进行个案调查，初始化基本信息数据*/
    	Long statusId = dto.getStatusId();
    	if(ObjectUtil.isNotEmpty(statusId)){
	    	Long eventId = getEventId(statusId,new Integer[]{MhmEvents.M_ARCHIVES.getValue()});
	    	Criteria ca = new Criteria("EVENT_ID",eventId); 
	    	MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
	    	MhmFollowup mhmFollowup = new MhmFollowup();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            try {
				BeanUtils.copyProperties(mhmFollowup, mhmBasicsInfo);
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
            if(ObjectUtil.isNullOrEmpty(mhmBasicsInfo.getAge())){
            	mhmFollowup.setAge(null);
            }
            mhmFollowup.setId(null);
            dto.setMhmFollowup(mhmFollowup);
    	}    	
    }
    /**
     * 初始化规范管理-个案管理计划
     * @param       dto
     * @return      void
     */   
    private void initCasePlan(ManagementDto dto){
    	
    }
    /**
     * 初始化规范管理-效果评估
     * @param       dto
     * @return      void
     */   
    private void initEvaluation(ManagementDto dto){
    	
    }
    /**
     * 初始化规范管理-应急处置
     * @param       dto
     * @return      void
     */   
    private void initEmergency(ManagementDto dto){
    	
    }
    /**
     * 初始化规范管理-门诊信息
     * @param       dto
     * @return      void
     */   
    private void initOutpatient(ManagementDto dto){
    	
    }
    /**
     * 初始化规范管理-转诊信息
     * @param       dto
     * @return      void
     */   
    private void initReferral(ManagementDto dto){
    	
    } 
    
    /**
     * 业务逻辑-基本档案
     * @param       dto
     * @return      void
     */   
    private void archivesService(ManagementDto dto){
        //管理方式变更历史
        String newStatus = dto.getMhmOtherInfo().getBringIntoMode();
        if(!"2".equals(dto.getMhmOtherInfo().getBringIntoFlag())){  //纳入管理
            MhmManageType mhmManageTypeOrg = mhmManageTypeDao.findMhmManageType(dto.getEventId().toString());
            MhmManageType mhmManageType = new MhmManageType();
            //已有记录，且状态改变时，更新原记录为的结束信息并 新建新的状态记录
            if(ObjectUtil.isNotEmpty(mhmManageTypeOrg)) {
                String oldStatus = mhmManageTypeOrg.getStatus();
                if(!newStatus.equals(oldStatus)) {
                    Parameters parameters = new Parameters();
                    parameters.add("END_DT", new Date());
                    parameters.add("END_ORGAN", dto.getMhmOtherInfo().getFillOrganCode());
                    parameters.add("END_USER", dto.getMhmOtherInfo().getFillDoctorId());
                    mhmManageTypeDao.update(parameters, new Criteria("eventId", dto.getEventId()).add("version", mhmManageTypeOrg.getVersion()));

                    mhmManageType.setEventId(dto.getEventId());
                    mhmManageType.setStatus(newStatus);
                    mhmManageType.setStartDt(new Date());
                    mhmManageType.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
                    mhmManageType.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
                    mhmManageType.setVersion(mhmManageTypeOrg.getVersion() + 1);
                    mhmManageTypeDao.insert(mhmManageType);
                }
            }
            else {//没有记录时，新增
                mhmManageType.setEventId(dto.getEventId());
                mhmManageType.setStatus(newStatus);
                mhmManageType.setStartDt(new Date());
                mhmManageType.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
                mhmManageType.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
                mhmManageType.setVersion(1L);
                mhmManageTypeDao.insert(mhmManageType);
            }
        }

        //免费服药变更历史
        String freeStatus = dto.getMhmOtherInfo().getFreeFlag();
        MhmDrugFree mhmDrugFreeOrg = mhmDrugFreeDao.findMhmDrugFree(dto.getEventId().toString());
        MhmDrugFree mhmDrugFree = new MhmDrugFree();
        //已有记录，且状态改变时，更新原记录为的结束信息并 新建新的状态记录
        if(ObjectUtil.isNotEmpty(mhmDrugFreeOrg)) {
            String oldStatus = mhmDrugFreeOrg.getStatus();
            if(!freeStatus.equals(oldStatus)){
                Parameters parameters = new Parameters();
                parameters.add("END_DT", new Date());
                parameters.add("END_ORGAN", dto.getMhmOtherInfo().getFillOrganCode());
                parameters.add("END_USER", dto.getMhmOtherInfo().getFillDoctorId());
                mhmDrugFreeDao.update(parameters, new Criteria("eventId", dto.getEventId()).add("version", mhmDrugFreeOrg.getVersion()));

                mhmDrugFree.setEventId(dto.getEventId());
                mhmDrugFree.setStatus(freeStatus);
                mhmDrugFree.setStartDt(new Date());
                mhmDrugFree.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
                mhmDrugFree.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
                mhmDrugFree.setVersion(mhmDrugFreeOrg.getVersion() + 1);
                mhmDrugFreeDao.insert(mhmDrugFree);
            }
        }
        else {//没有记录时，新增
            mhmDrugFree.setEventId(dto.getEventId());
            mhmDrugFree.setStatus(freeStatus);
            mhmDrugFree.setStartDt(new Date());
            mhmDrugFree.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
            mhmDrugFree.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
            mhmDrugFree.setVersion(1L);
            mhmDrugFreeDao.insert(mhmDrugFree);
        }

        //重性、非重性历史
        String patientType = dto.getMhmOtherInfo().getPatientType();
        MhmSeverity mhmSeverityOrg = mhmSeverityDao.findMhmSeverity(dto.getEventId().toString());
        MhmSeverity mhmSeverity = new MhmSeverity();
        //已有记录，且状态改变时，更新原记录为的结束信息并 新建新的状态记录
        if(ObjectUtil.isNotEmpty(mhmSeverityOrg)) {
            String oldStatus = mhmSeverityOrg.getStatus();
            if(!patientType.equals(oldStatus)){
                Parameters parameters = new Parameters();
                parameters.add("END_DT", new Date());
                parameters.add("END_ORGAN", dto.getMhmOtherInfo().getFillOrganCode());
                parameters.add("END_USER", dto.getMhmOtherInfo().getFillDoctorId());
                mhmSeverityDao.update(parameters, new Criteria("eventId", dto.getEventId()).add("version", mhmSeverityOrg.getVersion()));

                mhmSeverity.setEventId(dto.getEventId());
                mhmSeverity.setStatus(patientType);
                mhmSeverity.setStartDt(new Date());
                mhmSeverity.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
                mhmSeverity.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
                mhmSeverity.setVersion(mhmSeverityOrg.getVersion() + 1);
                mhmSeverityDao.insert(mhmSeverity);
            }
        }
        else {//没有记录时，新增
            mhmSeverity.setEventId(dto.getEventId());
            mhmSeverity.setStatus(patientType);
            mhmSeverity.setStartDt(new Date());
            mhmSeverity.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
            mhmSeverity.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
            mhmSeverity.setVersion(1L);
            mhmSeverityDao.insert(mhmSeverity);
        }

        //经济状况 历史
        String stateEconomy = dto.getMhmOtherInfo().getStateEconomy();
        MhmEconomy mhmEconomyOrg = mhmEconomyDao.findMhmEconomy(dto.getEventId().toString());
        MhmEconomy mhmEconomy = new MhmEconomy();
        //已有记录，且状态改变时，更新原记录为的结束信息并 新建新的状态记录
        if(ObjectUtil.isNotEmpty(mhmEconomyOrg)) {
            String oldStatus = mhmEconomyOrg.getStatus();
            if(!stateEconomy.equals(oldStatus)){
                Parameters parameters = new Parameters();
                parameters.add("END_DT", new Date());
                parameters.add("END_ORGAN", dto.getMhmOtherInfo().getFillOrganCode());
                parameters.add("END_USER", dto.getMhmOtherInfo().getFillDoctorId());
                mhmEconomyDao.update(parameters, new Criteria("eventId", dto.getEventId()).add("version", mhmEconomyOrg.getVersion()));

                mhmEconomy.setEventId(dto.getEventId());
                mhmEconomy.setStatus(stateEconomy);
                mhmEconomy.setStartDt(new Date());
                mhmEconomy.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
                mhmEconomy.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
                mhmEconomy.setVersion(mhmEconomyOrg.getVersion() + 1);
                mhmEconomyDao.insert(mhmEconomy);
            }
        }
        else {//没有记录时，新增
            mhmEconomy.setEventId(dto.getEventId());
            mhmEconomy.setStatus(stateEconomy);
            mhmEconomy.setStartDt(new Date());
            mhmEconomy.setStartOrgan(dto.getMhmOtherInfo().getFillOrganCode());
            mhmEconomy.setStartUser(dto.getMhmOtherInfo().getFillDoctorId());
            mhmEconomy.setVersion(1L);
            mhmEconomyDao.insert(mhmEconomy);
        }
    }
    /**
     * 业务逻辑-出院信息
     * @param       dto
     * @return      void
     */   
    private void dischargedService(ManagementDto dto){
        // 住院用药
        List<MhmDrugRecord> drugRecords = dto.getInMedicationRecords();
        mhmDrugRecordDao.delete(new Criteria("eventId", dto.getEventId()).add("type", "1"));
        mhmDrugRecordDao.batchInsert(drugRecords);
        //下一步治疗用药
        List<MhmDrugRecord> nextDrugRecords = dto.getNextMedicationRecords();
        mhmDrugRecordDao.delete(new Criteria("eventId", dto.getEventId()).add("type", "2"));
        mhmDrugRecordDao.batchInsert(nextDrugRecords);
    }
    /**
     * 业务逻辑-随访记录
     * @param       dto
     * @return      void
     */   
    private void followupService(ManagementDto dto){
		/*根据当前用户，设置页面中的调查者、调查日期*/
		MhmFollowup mhmFollowup = dto.getMhmFollowup();
		/*根据随访日期，查找Mhm_Severity得到病人当时的状态：重性精神病、非重性精神病*/
		if(!getPatientType(dto)){
			log.error("随访登记时无法获取病人状态：重性精神病、非重性精神病");
		}
		Organization org = dto.getCurrentOrg();
		User user = dto.getCurrentUser();
        if(ObjectUtil.isNullOrEmpty(mhmFollowup.getId())){
        	mhmFollowup.setFillOrganCode(org.getOrganCode());//填写单位
        	mhmFollowup.setFillDoctorId(user.getId().toString());//填写医生
        	mhmFollowup.setFillDate(new Date());//填写日期
        	if(StringUtil.isNullOrEmpty(mhmFollowup.getFollowupStatus())){
        		mhmFollowup.setFollowupStatus("0");//未审核
        	}
        }
        /*修改者、修改日期每次都更新*/
        mhmFollowup.setModifyOrganCode(org.getOrganCode());//修改单位
    	mhmFollowup.setModifyDoctorId(user.getId().toString());//修改医生
    	mhmFollowup.setModifyDate(new Date());//修改日期
    	mhmFollowup.setStatusId(dto.getStatusId());
    	dto.setMhmFollowup(mhmFollowup);
    	
        // 随访用药
        List<MhmDrugRecord> drugRecords = dto.getFollowupMedicationRecords();
        for(MhmDrugRecord record:drugRecords){
        	record.setEventId(dto.getEventId());
        	record.setFillDate(new Date());
        	record.setFillDoctorId(user.getId().toString());
        	record.setFillOrganCode(org.getOrganCode());
        }
        mhmDrugRecordDao.delete(new Criteria("eventId", dto.getEventId()).add("type", "3"));
        mhmDrugRecordDao.batchInsert(drugRecords);
        if (ObjectUtil.isNotEmpty(mhmFollowup)) {
			try {
				SavePerson(dto);//调用接口新增或更新患者
				PersonInfo personInfo = dto.getPersonInfo();
				if(ObjectUtil.isNotEmpty(personInfo)){			
					dto.setPixId(personInfo.getSmpiId());
					dto.setPersonId(personInfo.getId());
				}
			} catch (Exception e) {
				log.error("精神卫生规范管理-患者保存失败。更新患者信息失败。" + e.getMessage());
				throw new RuntimeException("更新患者信息失败。", e);
            }
        }        
    }
    /**
     * 业务逻辑-失访信息
     * @param       dto
     * @return      void
     */   
    private void lostFollowupService(ManagementDto dto){
		if(!getPatientType(dto)){
			log.error("随访登记时无法获取病人状态：重性精神病、非重性精神病");
		}    	
		/*根据当前用户，设置页面中的调查者、调查日期*/
		MhmFollowup mhmFollowup = dto.getMhmFollowup();
		Organization org = dto.getCurrentOrg();
		User user = dto.getCurrentUser();
		if(ObjectUtil.isNullOrEmpty(mhmFollowup.getId())){
	    	mhmFollowup.setFillOrganCode(org.getOrganCode());//填写单位
	    	mhmFollowup.setFillDoctorId(user.getId().toString());//填写医生
	    	mhmFollowup.setFillDate(new Date());//填写日期
	    	if(StringUtil.isNullOrEmpty(mhmFollowup.getFollowupStatus())){
        		mhmFollowup.setFollowupStatus("0");//未审核
        	}	    	
		}
        /*修改者、修改日期每次都更新*/
        mhmFollowup.setModifyOrganCode(org.getOrganCode());//修改单位
    	mhmFollowup.setModifyDoctorId(user.getId().toString());//修改医生
    	mhmFollowup.setModifyDate(new Date());//修改日期
    	mhmFollowup.setType("2");
    	
    	mhmFollowup.setStatusId(dto.getStatusId());
    	dto.setMhmFollowup(mhmFollowup);    
        if (ObjectUtil.isNotEmpty(mhmFollowup)) {
			/*身份证号码为空则不更新患者信息*/
			if(StringUtil.isNotEmpty(mhmFollowup.getIdcard())){			
				try {
					SavePerson(dto);//调用接口新增或更新患者
					PersonInfo personInfo = dto.getPersonInfo();
					if(ObjectUtil.isNotEmpty(personInfo)){			
						dto.setPixId(personInfo.getSmpiId());
						dto.setPersonId(personInfo.getId());
					}
				} catch (Exception e) {
					log.error("精神卫生规范管理-患者保存失败。更新患者信息失败。" + e.getMessage());
					throw new RuntimeException("更新患者信息失败。", e);
                }
			}
        }    	
    }
    /**
     * 业务逻辑-个案管理计划
     * @param       dto
     * @return      void
     */   
    private void casePlanService(ManagementDto dto){
    	MhmCase mhmCase = dto.getMhmCase();
    	if (ObjectUtil.isNotEmpty(mhmCase)) {
    		if(ObjectUtil.isNotEmpty(mhmCase.getCaseDetails())) {
    			mhmCaseDetailDao.delete(new Criteria("EVENT_ID", dto.getEventId()));
    			List<MhmCaseDetail> caseDetails = mhmCase.getCaseDetails();
    			for (MhmCaseDetail caseDetail : caseDetails) {
    				caseDetail.setEventId(dto.getEventId());
    			}
    			mhmCaseDetailDao.batchInsert(caseDetails);
    		}
        } 
    }
    
    /**
     * 业务逻辑-效果评估
     * @param       dto
     * @return      void
     */   
    private void evaluationService(ManagementDto dto){
    	
    }
    /**
     * 业务逻辑-应急处置
     * @param       dto
     * @return      void
     */   
    private void emergencyService(ManagementDto dto){
    	
    }
    /**
     * 业务逻辑-门诊信息
     * @param       dto
     * @return      void
     */   
    private void outpatientService(ManagementDto dto){
    	
    }
    /**
     * 业务逻辑-转诊信息
     * @param       dto
     * @return      void
     */   
    private void referralService(ManagementDto dto){
    	
    }

    /**
     * 查询免费服药明细列表
     * @param       criteria
     * @param		page
     * @return      PageList<MhmEmergency>
     */
    public PageList<MhmDrugFree> getDrugFreeList(Criteria criteria,Page page, Order order){
         return mhmDrugFreeDao.getPageList(page, criteria, order);
    }

    /**
     * 查询管理变更明细列表
     *
     * @param       criteria
     * @param        page
     * @return      PageList<MhmEmergency>
     */
    public PageList<MhmManageType> getManageTypeList(Criteria criteria, Page page, Order order){
        return mhmManageTypeDao.getPageList(page, criteria, order);
    }

    /**
     * 查询病人类型变更列表
     *
     * @param       criteria
     * @param        page
     * @return      PageList<MhmSeverity>
     */
    public PageList<MhmSeverity> getPatientTypeList(Criteria criteria, Page page, Order order){
        return mhmSeverityDao.getPageList(page, criteria, order);
    }

    /**
     * 查询经济状况变更明细列表
     *
     * @param       criteria
     * @param        page
     * @return      PageList<MhmEconomy>
     */
    public PageList<MhmEconomy> getEconomyHistory(Criteria criteria, Page page, Order order){
        return mhmEconomyDao.getPageList(page, criteria, order);
    }

    /**
     * 查询病人首次变更记录
     *
     * @param       statusId
     * @return      MhmSeverity
     */
    public MhmSeverity getFirstPatientType(Long statusId){
    	Long eventId = getEventId(statusId,new Integer[]{MhmEvents.M_ARCHIVES.getValue()});
        return mhmSeverityDao.getFirstMhmSeverity(eventId);
    }

	/**
	 * 获取患者ID
	 * @param statusId
	 * @return 患者ID
	 */
	public Long getPersonId(Long statusId) {
		MhmStatusInfo statusInfo = null;
		Long personId = null;
		if(ObjectUtil.isNotEmpty(statusId)){
			statusInfo = mhmStatusInfoDao.get(statusId);
		}
		if(ObjectUtil.isNotEmpty(statusInfo)){
			personId = statusInfo.getPersonId();
		}
		return personId;
	}

    /**
     * 根据idCard获取患者基本信息
     * @param idCard
     * @return
     */
    public MhmBasicsInfo findBasicInfoByIdCard(String idCard){
        Criteria ca = new Criteria("IDCARD",idCard);
        return mhmBasicsInfoDao.get(ca);
    }
	
    /**
     * 根据日期，从病人类型历史记录表(MHM_SEVERITY)中查询患者类型
     * 病人类型（1重性，2非重性）
     * @param dto
     * @return
     * @author Ye jianfei
     */
    private boolean getPatientType(ManagementDto dto){
    	boolean result = false;
    	Long statusId = dto.getStatusId();
    	Date followupDt = dto.getMhmFollowup().getFollowupDt();
    	Long eventId = getEventId(statusId,new Integer[]{MhmEvents.M_ARCHIVES.getValue()});
    	if(ObjectUtil.isNotEmpty(eventId) && ObjectUtil.isNotEmpty(followupDt)){
    		MhmSeverity mhmSeverity = mhmSeverityDao.getMhmSeverity(eventId,followupDt);
    		if(ObjectUtil.isNotEmpty(mhmSeverity)){
    			dto.getMhmFollowup().setPatientType(mhmSeverity.getStatus());
    			result = true;
    		}
    	}
    	return result;
    }
}