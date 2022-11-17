/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 精神卫生规范管理
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmClueQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.ehr.service.ta.ICicTargetService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.dto.MhmClueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("mhmClueService")
public class MhmClueServiceImpl extends AbstractService implements IMhmClueService {

    @Resource(name = "mhmStatusInfoDao")
    private IMhmStatusInfoDao mhmStatusInfoDao;     //事件表    

    @Resource(name = "mhmEventInfoDao")
    private IMhmEventInfoDao eventInfoDao;     //状态表

    @Resource(name = "mhmBasicsInfoDao")
    private IMhmBasicsInfoDao mhmBasicsInfoDao;     //基本信息
    @Resource(name = "mhmSignDao")
    private IMhmSignDao mhmSignDao;     //体征表
    @Resource(name = "mhmDiagnosisDao")
    private IMhmDiagnosisDao mhmDiagnosisDao;     //诊断治疗表
    @Resource(name = "mhmOtherInfoDao")
    private IMhmOtherInfoDao mhmOtherInfoDao;     //其他表
    @Resource(name = "mhmPathHistoryDao")
    private IMhmPathHistoryDao mhmPathHistoryDao;     //其他表
    
    @Resource(name = "mhmInterfaceService")
    private IMhmInterfaceService  mhmInterfaceService;
    
	@Resource(name = "mhmApprovalInfoService")
	private IMhmApprovalInfoService mhmApprovalInfoService; 
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;		
	@Autowired
	private MhmParamUtil mhmParamUtil;

    @Resource(name = "cicTargetService")
    private ICicTargetService cicTargetService;

	@Override
	public PageList<MhmClueQueryDto> findMhmClueList(Criteria criteria, Page page) {
		PageList<MhmClueQueryDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = mhmStatusInfoDao.findClueList(page, criteria);
		}
		return result;
	}

	@Override
	public List<MhmClueQueryDto> findMhmClueList(Criteria criteria) {
		List<MhmClueQueryDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = mhmStatusInfoDao.findClueList(criteria);
		}
		return result;
	}

	@Override
	public MhmClueDto getMhmClue(Long statusId, MhmEvents event) {
		MhmClueDto result = new MhmClueDto();
		Long eventId = null;
    	if(ObjectUtil.isNotEmpty(statusId)){
    		MhmStatusInfo statusInfo = mhmStatusInfoDao.get(statusId);
    		if(ObjectUtil.isNotEmpty(statusInfo)){
    			result.setStatus(statusInfo.getStatus());
    			result.setPixId(statusInfo.getPixId());
    		}
    		result.setStatusId(statusId);
    		eventId = getEventId(statusId,event.getValue());
    	}
        if(ObjectUtil.isNotEmpty(eventId)){
	        Criteria ca = new Criteria("eventId",eventId);
	        result.setEventId(eventId);
	        MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
	        	result.setMhmBasicsInfo(mhmBasicsInfo);
	        }
	        MhmSign mhmSign = mhmSignDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmSign)) {
	        	result.setMhmSign(mhmSign);
	        }
	        MhmDiagnosis mhmDiagnosis = mhmDiagnosisDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmDiagnosis)) {
	        	result.setMhmDiagnosis(mhmDiagnosis);
	        }
	        MhmOtherInfo mhmOtherInfo = mhmOtherInfoDao.get(ca);
	        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
	        	result.setMhmOtherInfo(mhmOtherInfo);
	        }	        
        }    	
    	return result;
	}

    @Override
    public ManagementDto getMhmMgnt(Long eventId){
        ManagementDto result = new ManagementDto();

        Criteria ca = new Criteria("eventId",eventId);
        result.setEventId(eventId);
        MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
            result.setMhmBasicsInfo(mhmBasicsInfo);
        }
        MhmDiagnosis mhmDiagnosis = mhmDiagnosisDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmDiagnosis)) {
            result.setMhmDiagnosis(mhmDiagnosis);
        }
        MhmOtherInfo mhmOtherInfo = mhmOtherInfoDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
            result.setMhmOtherInfo(mhmOtherInfo);
        }
        MhmPathHistory mhmPathHistory = mhmPathHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmPathHistory)) {
            result.setMhmPathHistory(mhmPathHistory);
        }
        return result;
    }

	@Override
    @Transactional
	public boolean creatMhmClue(MhmClueDto dto) {
		if (ObjectUtil.isNullOrEmpty(dto.getCurrentUser())) {
			log.error("操作人员为空");
			return false;
		}
		if (ObjectUtil.isNullOrEmpty(dto.getCurrentOrg())) {
			log.error("当前机构为空");
			return false;
		} 		
		boolean result = false;
		dto.setEventType(MhmEvents.M_CLUE.getValue());
		result = initService(dto);
		if(result){
			result = saveBusiness(dto);
		}
		return result;
	}

	@Override
    @Transactional
	public boolean approveMhmClue(MhmClueDto dto) {
		if (ObjectUtil.isNullOrEmpty(dto.getCurrentUser())) {
			log.error("操作人员为空");
			return false;
		}
		if (ObjectUtil.isNullOrEmpty(dto.getCurrentOrg())) {
			log.error("当前机构为空");
			return false;
		} 		
		boolean result = false;
		dto.setEventType(MhmEvents.M_CLUE.getValue());
		result = initService(dto);
		if(result){
			result = saveBusiness(dto);
		}
		return result;
	} 
  
    /**
     * 线索登记审批历史记录
     * @param       statusId
     * @return      PageList<MhmApprovalInfo>
     */
	@Override
    public PageList<MhmApprovalInfo> findApprovalInfo(Long	statusId){
    	return null;
    }
	
	/**
	 * 获取事件表ID
	 * @param statusId
	 * @param eventType
	 * @return
	 */
    private Long getEventId(Long statusId, Integer eventType){
        Long eventId = null;
        Criteria eventCa = new Criteria("eventType", eventType).add("statusId", statusId);
        MhmEventInfo eventInfo = eventInfoDao.get(eventCa);
        if(ObjectUtil.isNotEmpty(eventInfo)){
        	eventId = eventInfo.getId();
        }
        return eventId;
    }
    
    /**
     * 更新业务表
     * @param       dto
     * @return      boolean
     */
    private boolean  saveBusiness(MhmClueDto dto){
    	int result = 0;
    	Long eventId = dto.getEventId();
        MhmBasicsInfo mhmBasicsInfo = dto.getMhmBasicsInfo();
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
        	mhmBasicsInfo.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmBasicsInfo.getId())){
        		result = mhmBasicsInfoDao.insert(mhmBasicsInfo);
        	}else{
        		result = mhmBasicsInfoDao.update(mhmBasicsInfo);
        	}        	
        }
        MhmSign mhmSign = dto.getMhmSign();
        if (ObjectUtil.isNotEmpty(mhmSign)) {
        	mhmSign.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmSign.getId())){
        		result = mhmSignDao.insert(mhmSign);
        	}else{
        		result = mhmSignDao.update(mhmSign);
        	} 
        } 
        MhmDiagnosis mhmDiagnosis = dto.getMhmDiagnosis();
        if (ObjectUtil.isNotEmpty(mhmDiagnosis)) {
        	mhmDiagnosis.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmDiagnosis.getId())){
        		result = mhmDiagnosisDao.insert(mhmDiagnosis);
        	}else{
        		result = mhmDiagnosisDao.update(mhmDiagnosis);
//                forCic(eventId, mhmDiagnosis.getReCheck(), mhmBasicsInfo.getIdcard());
        	} 
        }
        MhmOtherInfo mhmOtherInfo = dto.getMhmOtherInfo();
        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
        	mhmOtherInfo.setEventId(eventId);
    		if(ObjectUtil.isNullOrEmpty(mhmOtherInfo.getId())){
        		result = mhmOtherInfoDao.insert(mhmOtherInfo);
        	}else{
        		result = mhmOtherInfoDao.update(mhmOtherInfo);
        	} 
        }
        addApproval(dto);
    	return result != 0?true:false;
    } 
    /**
     * 执行业务逻辑
     * @param       dto
     * @return      
     */
    private boolean initService(MhmClueDto dto){
    	Long statusId = dto.getStatusId();
    	Long eventId = dto.getEventId();
    	RoleType roleType = dto.getRoleType();
    	Integer status = dto.getStatus();
    	Integer nextStatus = dto.getStatus();
    	MhmOtherInfo mhmOtherInfo = dto.getMhmOtherInfo();
    	MhmDiagnosis mhmDiagnosis = dto.getMhmDiagnosis();
		MhmBasicsInfo mhmBasicsInfo = dto.getMhmBasicsInfo();
        //存地址
		mhmBasicsInfo.setPaAddress(dto.getMhmBasicsInfo().getFloatPopulation().equalsIgnoreCase("1")
                ? dictionaryApp.queryDicItemName("FS990001", dto.getMhmBasicsInfo().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", dto.getMhmBasicsInfo().getPastreet()) +dictionaryApp.queryDicItemName("FS990001", dto.getMhmBasicsInfo().getPaGroup())+ dto.getMhmBasicsInfo().getPahouseNumber()
                : dto.getMhmBasicsInfo().getPahouseNumber());	
		MhmStatusInfo statusInfo = new MhmStatusInfo();
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
        	mhmBasicsInfo.setPatientResource("3");//设置患者来源值为3，线索登记
			try {
				SavePerson(dto);//调用接口新增或更新患者
				PersonInfo personInfo = dto.getPersonInfo();
				if(ObjectUtil.isNotEmpty(personInfo)){			
					statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
					statusInfo.setPersonId(personInfo.getId());
				}						
			} catch (Exception e) {
				log.error("精神卫生规范管理-患者保存失败。更新患者信息失败。" + e.getMessage());
				throw new RuntimeException("更新患者信息失败。", e);
            }
			dto.setMhmBasicsInfo(mhmBasicsInfo);
        }   
        if (ObjectUtil.isNotEmpty(mhmOtherInfo)) {
        	mhmOtherInfo.setBringIntoFlag("1");//管理方式，值为1，未管理
/*			Organization  org = dto.getCurrentOrg();
			mhmOtherInfo.setManagementTown(org.getGbCode());
			String managementCenterCode=org.getGenreCode().equals(OrgGenreCode.CENTRE.getValue())?org.getOrganCode():org.getParentCode();
			mhmOtherInfo.setManagementCenter(managementCenterCode);*/
        	dto.setMhmOtherInfo(mhmOtherInfo);
        }
        /*获取精防科审批状态*/
        if(ObjectUtil.isNotEmpty(roleType) && roleType.equals(RoleType.JKJFZX)){
	    	if(status.equals(MhmStatus.VERIFY_SQZX.getValue())){//诊断
	    		status = mhmDiagnosis.getDiagnosisResult() == 1?MhmStatus.ELIMINATION_DIAGNOSIS.getValue():MhmStatus.VERIFY_SQZX.getValue();
	    	}else if(status.equals(MhmStatus.VERIFY_DIAGNOSIS.getValue())){//复核
	    		status = mhmDiagnosis.getReCheck() == 1?MhmStatus.ELIMINATION_CHECK.getValue():MhmStatus.VERIFY_DIAGNOSIS.getValue();
	    	} 
        }
    	
    	/*生成状态表数据*/
    	nextStatus = getNextStatus(status,roleType);
    	dto.setStatus(nextStatus);
    	
    	if(ObjectUtil.isNotEmpty(statusId)){
    		statusInfo.setId(statusId);
    	}    	
    	statusInfo.setStatus(nextStatus);
    	statusInfo.setIsDelete(0);
    	statusInfo.setPatientResource("3");//患者来源（1出院，2门诊，3线索登记）
        statusInfo.setLogoff(dto.getLogoff());
    	statusId = updateStatus(statusInfo);
    	dto.setStatusId(statusId);
    	/*生成事件表数据*/
		if(ObjectUtil.isNullOrEmpty(eventId)){
			MhmEventInfo eventInfo = new MhmEventInfo();
			eventInfo.setStatusId(statusId);
			eventInfo.setEventType(MhmEvents.M_CLUE.getValue());
			eventId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
		} 
		dto.setEventId(eventId);
		
		Organization  org = dto.getCurrentOrg();
		User user = dto.getCurrentUser();
		/*如果是线索登记，则设置上报单位和上报时间*/
		if(ObjectUtil.isNullOrEmpty(mhmOtherInfo.getId())){
			mhmOtherInfo.setFillOrganCode(org.getOrganCode());//创建机构
			mhmOtherInfo.setFillDate(new Date());//创建时间
			String belongTownshipCode = org.getGbCode();
			
			String belongCenterCode = org.getGenreCode().equals(OrgGenreCode.CENTRE.getValue())?org.getOrganCode():org.getParentCode();
			mhmOtherInfo.setBelongTownship(belongTownshipCode);//所属乡镇
			mhmOtherInfo.setBelongCenter(belongCenterCode);//所属中心
			mhmOtherInfo.setFillDoctorId(user.getId().toString());//创建人
		}else if(nextStatus.equals(MhmStatus.VERIFY_SQZX.getValue())){
			//中心审批
			mhmOtherInfo.setModifyDate(new Date());//审批时间
			mhmOtherInfo.setModifyDoctorId(user.getId().toString());//审批人
			mhmOtherInfo.setModifyOrganCode(org.getOrganCode());//审批机构
		}else if(nextStatus.equals(MhmStatus.VERIFY_DIAGNOSIS.getValue()) || nextStatus.equals(MhmStatus.ELIMINATION_DIAGNOSIS.getValue())){
			//精防中心诊断
			mhmOtherInfo.setDiagnosisDate(new Date());//诊断时间
			mhmOtherInfo.setDiagnosisDoctorId(user.getId().toString());//诊断人
			mhmOtherInfo.setDiagnosisOrganCode(org.getOrganCode());//诊断机构
		}else if(nextStatus.equals(MhmStatus.VERIFY_CHECK.getValue()) || nextStatus.equals(MhmStatus.ELIMINATION_CHECK.getValue())){
			//精防中心复核
			mhmOtherInfo.setReDate(new Date());//复核时间
			mhmOtherInfo.setReDoctorId(user.getId().toString());//复核人
			mhmOtherInfo.setReOrganCode(org.getOrganCode());//复核机构
		}		
		return true;
    }
	/**
	 * 新增或状态记录
	 * @param statusInfo
	 * @return Long
	 */
	private Long updateStatus(MhmStatusInfo statusInfo) {
		Long statusId = statusInfo.getId();
		if(ObjectUtil.isNotEmpty(statusId)){
			mhmStatusInfoDao.updateStatus(statusInfo, new Criteria("ID",statusInfo.getId()));
		}else{
			if(statusInfo.getPixId().equals("-1")){
				statusInfo.setPixId(null);
			}
			statusId = mhmStatusInfoDao.generatedKey(statusInfo, "ID",null).longValue();
		}
		return statusId;
	} 
	
	/**
	 * 获取线索登记下一步状态
	 *
	 * @param currentStatus
	 * @param roleType
	 * @return
	 */
	private Integer getNextStatus(Integer currentStatus,RoleType roleType){
		Integer nextStatus = MhmStatus.SUBMIT.getValue();//下一步状态
		if(ObjectUtil.isNotEmpty(currentStatus)){
			if(currentStatus.equals(MhmStatus.ELIMINATION.getValue())
					&& (roleType.equals(RoleType.ZXJFYS) || roleType.equals(RoleType.JKJFZX))){
				nextStatus = MhmStatus.ELIMINATION.getValue();//排除
			}
			if(currentStatus.equals(MhmStatus.ELIMINATION_CHECK.getValue())
					&& roleType.equals(RoleType.JKJFZX)){
				nextStatus = MhmStatus.ELIMINATION_CHECK.getValue();//复核排除
			}
			if(currentStatus.equals(MhmStatus.ELIMINATION_DIAGNOSIS.getValue())
					&& roleType.equals(RoleType.JKJFZX)){
				nextStatus = MhmStatus.ELIMINATION_DIAGNOSIS.getValue();//诊断排除
			}			
			if(currentStatus.equals(MhmStatus.SUBMIT.getValue())
					&& roleType.equals(RoleType.ZXJFYS)){
				nextStatus = MhmStatus.VERIFY_SQZX.getValue();//中心审核
			}
			if(currentStatus.equals(MhmStatus.VERIFY_SQZX.getValue())
					&& roleType.equals(RoleType.JKJFZX)){
				nextStatus = MhmStatus.VERIFY_DIAGNOSIS.getValue();//诊断确诊
			}
			if(currentStatus.equals(MhmStatus.VERIFY_DIAGNOSIS.getValue())
					&& roleType.equals(RoleType.JKJFZX)){
				nextStatus = MhmStatus.VERIFY_CHECK.getValue();//复核确诊
			}
		}
		return nextStatus;
	}
	
	/**
	 * 新增日志记录
	 * @param dto
	 * @return int
	 */
	private int addApproval(MhmClueDto dto) {
		User user = dto.getCurrentUser();
		Organization org = dto.getCurrentOrg();
		MhmApprovalInfo approvalInfo = new MhmApprovalInfo();
		approvalInfo.setApprovalDate(new Date());
		String Comments = "";
		switch (dto.getStatus()){
			case 0:
				Comments = "线索登记";
				break;
			case 1:
				Comments = "中心审核";
				break;
			case 2:
				Comments = "诊断确诊";
				break;
			case 3:
				Comments = "复核确诊";
				break;
			case 4:
				Comments = "规范管理";
				break;
			case 5:
				Comments = "中心审核不通过";
				break;
			case 6:
				Comments = "诊断排除";
				break;	
			case 7:
				Comments = "复核排除";
				break;				
		}
		approvalInfo.setComments(Comments);
		approvalInfo.setStatusId(dto.getStatusId());
		approvalInfo.setStatus(dto.getStatus().toString());
		approvalInfo.setOrganCode(org.getOrganCode());
		approvalInfo.setOrganName(org.getOrganName());
		approvalInfo.setUserId(user.getId().toString());
		approvalInfo.setUserName(user.getName());
		return mhmApprovalInfoService.createApprovalInfo(approvalInfo);
	}
	/**
	 * 保存患者信息
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	private String SavePerson(MhmClueDto dto) throws Exception {
		String result="";
		String []param = new String[]{};
		Integer eventType = dto.getEventType();
		PersonInfo personInfo = dto.getPersonInfo();
		if(ObjectUtil.isNotEmpty(eventType)){
			param = mhmParamUtil.getParam(eventType);
		}
		result = mhmInterfaceService.updatePersonInfo(personInfo,param);
		dto.setPersonInfo(personInfo);
		return result;
	}

    /**
     * 根据idcard查询，该患者是否已经精卫系统中存在
     *
     * @param idcard
     * @return
     * @author Ye jianfei
     */
	@Override
	public Long getPersonCount(String idcard) {
		Long result = 0L;
		if(StringUtil.isNotEmpty(idcard)){
			PersonInfo person = mhmInterfaceService.queryPersonalInfo(null, idcard);
			if(ObjectUtil.isNotEmpty(person)){
                //要求如果之前排除的可以存在
                Criteria criteria = new Criteria();
				String pixId = person.getSmpiId();
                criteria.add("IS_DELETE", EHRConstants.DELETE_FLG_0);
				criteria.add("PIX_ID",pixId);
                criteria.add("STATUS", OP.NOTIN, new String[]{"5","6","7"});
                result = mhmStatusInfoDao.getCount(criteria, "PIX_ID", Long.class);
			}
		}
		return result;
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
     * 为新市民卡获取精神病人数
     * @param eventId
     * @param reCheck
     * @param idCard
     */
    private void forCic(Long eventId, Integer reCheck, String idCard){
        MhmEventInfo eventInfo = eventInfoDao.get(new Criteria("ID", eventId));
        MhmStatusInfo statusInfo = mhmStatusInfoDao.get(new Criteria("ID", eventInfo.getStatusId()));

        Set<String> properties = new HashSet<String>();
        properties.add("mentalFlag");
        properties.add("idcard");

        CicTarget cicTarget = new CicTarget();
        cicTarget.setPersonId(String.valueOf(statusInfo.getPersonId()));
        cicTarget.setIdcard(idCard);
        if(ObjectUtil.isNotEmpty(reCheck) && 2 == reCheck){
            cicTarget.setMentalFlag("T");
        }else {
            cicTarget.setMentalFlag("F");
        }
        cicTargetService.saveTargetValue(cicTarget, properties);

    }
}