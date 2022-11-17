/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.idm.TbQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.*;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.*;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.common.TbStatus;
import com.founder.rhip.idm.dto.TbSaveDto;
import net.sf.json.JSONObject;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 结核病service 
 * @author Jiang Haiying
 */
@Service("tbService")
public class TbServiceImpl extends AbstractService implements ITbService {

	@Resource(name = "idmStatusInfoDao")
	private IIdmStatusInfoDao idmStatusInfoDao;     //状态表

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;     //关联表

    @Resource(name = "generalConditionDao")
    private IGeneralConditionDao generalConditionDao;    //一般情况

    @Resource(name = "attackConditionDao")
    private IAttackConditionDao attackConditionDao;     //发病情况

    @Resource(name = "labExamineDao")
    private ILabExamineDao labExamineDao;     //实验室检查

    @Resource(name = "pastHistoryDao")
    private IPastHistoryDao pastHistoryDao;     //既往史

    @Resource(name = "clinicalManifestationsDao")
    private IClinicalManifestationsDao clinicalManifestationsDao;     //主要临床表现

    @Resource(name = "otherConditionDao")
    private IOtherConditionDao otherConditionDao;     //其他
    
    @Resource(name = "diagnosisDao")
    private IDiagnosisDao diagnosisDao;      //诊断依据、诊断结果
    
    @Resource(name = "exposureHistoryDao")
    private IExposureHistoryDao exposureHistoryDao;      //暴露史
    
    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息

    @Resource(name = "listTrDao")
    private IListTrDao listTrDao;     //追踪记录
    
    @Resource(name = "idmListSdDao")
    private IListSdDao idmListSdDao;     //督导服药
    
    @Resource(name = "idmListFrDao")
    private IListFrDao idmListFrDao;     //访视记录

	@Resource(name = "idmListSrDao")
	private IListSrDao idmListSrDao;     //服务记录

    @Resource(name = "idmListDdDao")
    private IListDdDao idmListDdDao;     //用药延误
  
	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;

    @Resource(name = "idmListAsDao")
    private IListAsDao idmListAsDao;

    @Resource(name = "idmListCcDao")
    private IListCcDao idmListCcDao;
	
    @Resource(name = "idmApprovalInfoDao")
	private IIdmApprovalInfoDao idmApprovalInfoDao;

	@Resource(name = "idmDrugCardDao")
	private IDrugCardDao idmDrugCardDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;//人员信息

	@Override
	public List<IdmStatusInfo> findTreatList(Criteria criteria, Criteria statusCr, Order order) {
		List<IdmStatusInfo> result = idmStatusInfoDao.findTreatList(criteria,statusCr,order);
		return result;
	}

	@Override
	public List<Map<String, Object>> downTreatList(Criteria criteria, Criteria statusCr, Order order) {
		List<Map<String, Object>> list = idmStatusInfoDao.downTreatList(criteria,statusCr,order);
		return list;
	}

	/**
	 * 查询结核病列表  专用病历 管理卡
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findTreatmentList(Page page, Criteria criteria, Criteria statusCr, Order order ,String firstVist) {
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findTreatmentList(page, criteria, statusCr, order, firstVist);
		}
		return result;
	}
	public List<IdmStatusInfo> findTreatmentList(Criteria criteria, Criteria statusCr, Order order) {
		List<IdmStatusInfo> result = null;

			result = idmStatusInfoDao.findTreatmentList(criteria, statusCr, order);

		return result;
	}

	@Override
	public List<Map<String, Object>> downTreatmentList(Criteria criteria, Criteria statusCr, Order order) {
		List<Map<String, Object>> list = idmStatusInfoDao.downTreatmentList(criteria,statusCr,order);
		return list;
	}

    public PageList<IdmStatusInfo> findMgntList(Page page, Criteria criteria, Criteria statusCr){
        PageList<IdmStatusInfo> result = null;
        if(ObjectUtil.isNotEmpty(page)){
            result = idmStatusInfoDao.findMgntList(page, criteria, statusCr);
        }
        return result;
    }

    public List<TbQueryDto> findMgntListTotal(Criteria criteria, Criteria statusCr){
        List<TbQueryDto> result = null;
        result = idmStatusInfoDao.findMgntListTotal(criteria, statusCr);
        return result;
    }

    public List<TbQueryDto> getTbList(Criteria criteria, Criteria statusCr){
        List<TbQueryDto> result = null;
        result = idmStatusInfoDao.getTbList(criteria, statusCr);
        return result;
    }

    public PageList<ListCc> getCcListForSt(Page page, Criteria criteria){
        return idmListCcDao.getCcListForSt(page, criteria);
    }

    public List<ListCc> getCcListForSt1(Criteria criteria){
        return idmListCcDao.getCcListForSt1(criteria);
    }

	/**
	 * 查询结核病追踪单
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findTraceList(Page page, Criteria criteria) {
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findTraceList(page, criteria);
		}
		return result;
	}
	/**
	 * 更新专项状态
	 * @param idmStatusInfo
	 * @param approvalInfo
	 * @return
	 */
	public int updateSpecialStatus(IdmStatusInfo idmStatusInfo, IdmApprovalInfo approvalInfo) {
		if(ObjectUtil.isNullOrEmpty(idmStatusInfo) || ObjectUtil.isNullOrEmpty(approvalInfo)){
			return -1;
		}
		idmApprovalInfoDao.insert(approvalInfo);
		return idmStatusInfoDao.update(idmStatusInfo);
	}
	
	/**
     * 添加
     * @param       tbSaveDto
     * @param       eventId
     * @return      int
     */
    @Transactional
    public boolean saveTbSaveDto(TbSaveDto tbSaveDto, Long eventId, String type) throws Exception {
        Long singleId = -1L;
        
        if(tbSaveDto.getSingleId() !=null && tbSaveDto.getSingleId() > 0l){
        	singleId = tbSaveDto.getSingleId();
        }
        singleId = this.saveGeneralCondition(tbSaveDto, singleId, eventId, type);

        AttackCondition attackCondition = tbSaveDto.getAttackCondition();
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            attackCondition.setIdmId(singleId);
            attackConditionDao.insert(attackCondition);
        }

        LabExamine LabExamine = tbSaveDto.getLabExamine();
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            LabExamine.setIdmId(singleId);
            labExamineDao.insert(LabExamine);
        }

        PastHistory pastHistory = tbSaveDto.getPastHistory();
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            pastHistory.setIdmId(singleId);
            pastHistoryDao.insert(pastHistory);
        }

        ClinicalManifestations clinicalManifestations = tbSaveDto.getClinicalManifestations();
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            clinicalManifestations.setIdmId(singleId);
            clinicalManifestationsDao.insert(clinicalManifestations);
        }

        OtherCondition otherCondition = tbSaveDto.getOtherCondition();
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            otherCondition.setIdmId(singleId);
            otherConditionDao.insert(otherCondition);
        }
        
        Diagnosis diagnosis = tbSaveDto.getDiagnosis();
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            diagnosis.setIdmId(singleId);
            diagnosisDao.insert(diagnosis);
        }
        
        ExposureHistory exposureHistory = tbSaveDto.getExposureHistory();
        if (ObjectUtil.isNotEmpty(exposureHistory)) {
        	exposureHistory.setIdmId(singleId);
        	exposureHistoryDao.insert(exposureHistory);
        }
        
        CaseInformation caseInformation = tbSaveDto.getCaseInformation();
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            caseInformation.setIdmId(singleId);
            caseInformationDao.insert(caseInformation);
        }
		//耐多药5大高危人群患者筛查
		if (ObjectUtil.isNotEmpty(otherCondition)) {
			IdmStatusInfo statusInfo = new IdmStatusInfo();
			statusInfo.setId(tbSaveDto.getIdmId());
			//复治时治疗分类
			String retreatmentType = otherCondition.getThisType1();
			if("1".equals(retreatmentType)||"2".equals(retreatmentType)){//复发或追回
				//与字典IDM00579中复发与返回患者对应
				statusInfo.setDangerFlag4("1");
			}else if("3".equals(retreatmentType)){ //初治失败
				//与字典 IDM00579 中初治失败患者值对应
				statusInfo.setDangerFlag3("1");
			}
			String chemotherapy = otherCondition.getChemotherapy();
			//治疗3个月末痰涂片仍阳性的初治涂阳患者
			com.founder.rhip.ehr.entity.control.idm.notifiabledisease.LabExamine labExam = tbSaveDto.getLabExamine();
			if(labExam!=null){
				String sputum_3 = labExam.getsputum_3();
				//与字典IDM00250对应的 涂阳
				if("1".equals(sputum_3)) {
					//与字典 IDM00579 治疗3个月末痰涂片仍阳性的初治涂阳患者值对应
					statusInfo.setDangerFlag5("1");
				}
			}
			//更新IDM_STATUS_INFO中5大高危患者人群分类标记
			int r = idmStatusInfoDao.update(statusInfo,"dangerFlag3","dangerFlag4","dangerFlag5");
		}
        return true;
    }
    
    /**
     * 修改
     * @param       tbSaveDto
     * @return      int
     */
    @Transactional
    public boolean updateTbSaveDto(TbSaveDto tbSaveDto) throws Exception {
        boolean result = false;
        deleteTb(tbSaveDto.getSingleId());
        saveTbSaveDto(tbSaveDto, tbSaveDto.getEventId(),"update");
        result = true;
        return result;
    }

    /**
     * 删除
     * @param       singleId
     * @return      int
     */
    @Transactional
    public boolean deleteTbSaveDto(Long singleId, Long idmId){
        boolean result = false;
        eventInfoDao.update(new Parameters("is_delete", EHRConstants.DELETE_FLG_1), new Criteria("id", singleId));
        //eventInfoDao.delete(singleId);
        //this.deleteTb(singleId);
        
        result = true;
        return result;
    }

    @Transactional
    private void deleteTb(Long singleId){
    	
    	Criteria ca = new Criteria("idmId", singleId);
    	generalConditionDao.delete(ca);

        attackConditionDao.delete(ca);

        labExamineDao.delete(ca);

        pastHistoryDao.delete(ca);

        clinicalManifestationsDao.delete(ca);

        otherConditionDao.delete(ca);

        diagnosisDao.delete(ca);
        
        exposureHistoryDao.delete(ca);
        
        caseInformationDao.delete(ca);
    }
    /**
     * 查看
     * @param       singleId
     * @return      MalariaDto
     */
    public TbSaveDto getTbSaveDto(String singleId){
    	TbSaveDto result = new TbSaveDto();
        Criteria ca = new Criteria("idmId",singleId);

        GeneralCondition generalCondition = BeanUtil.getWarpBean(GeneralCondition.class, generalConditionDao.getMap(ca));
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	if(ObjectUtil.isNotEmpty(generalCondition.getIdcard()) && ObjectUtil.isNullOrEmpty(generalCondition.getAge())) {
        		int age = IDCardUtil.getAgeByIdCard(generalCondition.getIdcard());
        		if(ObjectUtil.isNotEmpty(age)) {
					generalCondition.setAge(String.valueOf(age));
				}
			}
			if(ObjectUtil.isNotEmpty(generalCondition.getIdcard())){
				PersonInfo info =  personInfoDao.get(new Criteria("idcard", generalCondition.getIdcard()));
				if(ObjectUtil.isNotEmpty(info)){
					generalCondition.setNation(info.getNation());
					generalCondition.setNationOther(info.getOtherNationDesc());
					generalCondition.setOccupation(info.getOccupation());
					generalCondition.setHealthFileNo(info.getHealthFileNo());
				}
			}
			if(ObjectUtil.isNotEmpty(generalCondition.getShouldDoseNum()) && ObjectUtil.isNotEmpty(generalCondition.getActualDoseNum())){
				generalCondition.setDoseRate(((Math.round((double)generalCondition.getActualDoseNum()/generalCondition.getShouldDoseNum()*1000)/1000.0))*100);
			}
            result.setGeneralCondition(generalCondition);
        }

        AttackCondition attackCondition = attackConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            result.setAttackCondition(attackCondition);
        }


        LabExamine LabExamine = new LabExamine();
        if(ObjectUtil.isNotEmpty(labExamineDao.get(ca))) {
            LabExamine = BeanUtil.getWarpBean(com.founder.rhip.ehr.entity.control.idm.notifiabledisease.LabExamine.class, labExamineDao.getMap(ca));
        }
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            result.setLabExamine(LabExamine);
        }

        PastHistory pastHistory = pastHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            result.setPastHistory(pastHistory);
        }
        ClinicalManifestations clinicalManifestations = clinicalManifestationsDao.get(ca);//clinicalManifestationsDao.get(ca);
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            result.setClinicalManifestations(clinicalManifestations);
        }

        OtherCondition otherCondition = new OtherCondition();
        if(ObjectUtil.isNotEmpty(otherConditionDao.get(ca))) {
            otherCondition = BeanUtil.getWarpBean(OtherCondition.class, otherConditionDao.getMap(ca));
        }
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            result.setOtherCondition(otherCondition);
        }

        Diagnosis diagnosis = diagnosisDao.get(ca);
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            result.setDiagnosis(diagnosis);
        }
        
        ExposureHistory exposureHistory = exposureHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(exposureHistory)) {
            result.setExposureHistory(exposureHistory);
        }
        
        CaseInformation caseInformation = caseInformationDao.get(ca);
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            result.setCaseInformation(caseInformation);
        }
        getEvenInfo(result, singleId);
        IdmStatusInfo idmStatusInfo = idmStatusInfoDao.get(result.getIdmId());
        if(ObjectUtil.isNotEmpty(idmStatusInfo)) {
        	 result.setLogoff(idmStatusInfo.getLogoff());
        }
        return result;
    }
    
    /**
	 * 获取转诊后未到诊的人数
	 * @param criteria
	 * @return
	 */
	public int getNotSeeDoctorCount(Criteria criteria) {
		return idmStatusInfoDao.getNotSeeDoctorCount(criteria);
	}

	/**
	 * 新增或状态记录
	 * @param statusInfo
	 * @return
	 */
	 Long updateStatus(IdmStatusInfo statusInfo) {
		Long idmId = statusInfo.getId();
		if(ObjectUtil.isNotEmpty(idmId)){
			idmStatusInfoDao.updateStatus(statusInfo, new Criteria("ID",statusInfo.getId()));
		}else{
			/*当增加一个转诊时，默认为未到诊*/
			if(ObjectUtil.equals(statusInfo.getSpecialStatus(), TbStatus.TRANSFERTREAT.getValue())) {
				statusInfo.setPlaceStatus("4");
			}
			if(statusInfo.getPixId().equals("-1")){
				statusInfo.setPixId(null);
			}
			idmId = idmStatusInfoDao.generatedKey(statusInfo, "ID",null).longValue();
		}
		return idmId;
	}
	
	/**
	 * 更新状态表中的到位状态
	 * @param id
	 * @param placeStatus
	 * @return
	 */
	public Boolean updatePlaceStatus(Long id, String placeStatus, ListTr listTr) {
		//增加一条转诊跟踪记录
		IdmStatusInfo idmStatusInfo = idmStatusInfoDao.get(id);
    	if(Math.abs(listTr.getTransferDays()) >1 && !StringUtils.equals(idmStatusInfo.getPlaceStatus(), "5")) {
    		this.saveListTr(listTr);
    	} 
		idmStatusInfoDao.update(new Parameters("PLACE_STATUS", placeStatus), new Criteria("id", id));
		return true;
	}
	
	/**
	 * 更新诊断结果
	 * @param tbSaveDto
	 * @param listTr
	 * @return
	 */
	public boolean updateDiagnosis(TbSaveDto tbSaveDto, ListTr listTr) {
		
		Integer transferDays = DateUtil.getBetweenDays(this.findCaseInformation(tbSaveDto.getSingleId()).getTransferTreatmentDt(), new Date());
		IdmStatusInfo idmStatusInfo = idmStatusInfoDao.get(tbSaveDto.getIdmId());
    	if(Math.abs(transferDays) >1 && !StringUtils.equals(idmStatusInfo.getPlaceStatus(), "5")) {
    		//增加一条转诊跟踪记录
    		this.saveListTr(listTr);
    	} 
    	if (!StringUtils.equals(idmStatusInfo.getPlaceStatus(), "5")) {
    		//更新到诊状态
    		idmStatusInfoDao.update(new Parameters("PLACE_STATUS", "5"), new Criteria("id", tbSaveDto.getIdmId()));
    	}
    	if(ObjectUtil.isNotEmpty(tbSaveDto.getDiagnosis().getId())) {
    		diagnosisDao.update(tbSaveDto.getDiagnosis());
    	} else {
    		diagnosisDao.insert(tbSaveDto.getDiagnosis());
    	}
		otherConditionDao.insert(tbSaveDto.getOtherCondition());
		labExamineDao.insert(tbSaveDto.getLabExamine());
		return true;
	}
    
	/**
	 * 添加一条转诊追踪记录
	 * @param listTr
	 * @return
	 */
	public boolean saveListTr(ListTr listTr) {
		if(ObjectUtil.isNotEmpty(listTr)) {
			listTrDao.insert(listTr);
		}
		return true;
	}
	
	/**
	 * 查询结核病追踪记录
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<ListTr> findTraceRecordList(Page page, Criteria criteria) {
		PageList<ListTr> listTrs = null;
		Order order = new Order("CREATE_DT", false);
		if(ObjectUtil.isNotEmpty(page)) {
			listTrs = listTrDao.getPageList(page, criteria, order);
		}
		return listTrs;
	}
	
	/**
	 * 获取患者基本信息
	 * @param idmId
	 * @return
	 */
	public GeneralCondition findGeneralCondition(Long idmId) {
		return generalConditionDao.get(new Criteria("idm_id", idmId));
	}
	
	/**
	 * 获取报卡基本信息
	 * @param idmId
	 * @return
	 */
	public CaseInformation findCaseInformation(Long idmId) {
		return caseInformationDao.get(new Criteria("idm_id", idmId));
	}
	
	/**
	 * 获取OtherCondition
	 * @param idmId
	 * @return
	 */
	public OtherCondition findOtherCondition(Long idmId) {
		return otherConditionDao.get(new Criteria("idm_id", idmId));
	}
	
	/**
	 * 更新报卡基本信息
	 * @param caseInformation
	 * @return
	 */
	public Boolean updateCaseInformation(CaseInformation caseInformation) {
		caseInformationDao.update(caseInformation);
		return true;
	}
	
	/**
	 * 保存分派信息
	 * @param idmStatusInfo
	 * @return
	 */
	public Boolean saveAssign(IdmStatusInfo idmStatusInfo, IdmApprovalInfo idmApprovalInfo) {
		if(ObjectUtil.isNullOrEmpty(idmStatusInfo) || idmStatusInfo.getId() == null) {
			return false;
		}
		idmStatusInfoDao.update(idmStatusInfo);
		idmApprovalInfoDao.insert(idmApprovalInfo);
		return true;
	}
	
	/**
	 * 保存规范化管理中的信息
	 * @param tbSaveDto
	 * @return
	 */
	public Boolean saveStandardization(TbSaveDto tbSaveDto) {
        if (ObjectUtil.isNotEmpty(tbSaveDto.getListSd())) {
            idmListSdDao.delete(new Criteria("idm_id", tbSaveDto.getSingleId()));
            idmListSdDao.batchInsert(tbSaveDto.getListSd());
		}else{
            idmListSdDao.delete(new Criteria("idm_id", tbSaveDto.getSingleId()));
        }
		//访视情况
        if (ObjectUtil.isNotEmpty(tbSaveDto.getListFr())) {
            idmListFrDao.delete(new Criteria("idm_id", tbSaveDto.getSingleId()));
            idmListFrDao.batchInsert(tbSaveDto.getListFr());
		}else{
            idmListFrDao.delete(new Criteria("idm_id", tbSaveDto.getSingleId()));
        }
        //用药延误
        if (ObjectUtil.isNotEmpty(tbSaveDto.getListDd())) {
            idmListDdDao.delete(new Criteria("idm_id", tbSaveDto.getSingleId()));
            idmListDdDao.batchInsert(tbSaveDto.getListDd());
		}else{
            idmListDdDao.delete(new Criteria("idm_id", tbSaveDto.getSingleId()));
        }
		return true;
	}
	
	/**
	 * 获取规范化管理中的信息
	 * @param singleId
	 * @return
	 */
	public TbSaveDto getStandardization(String singleId) {
    	TbSaveDto result = new TbSaveDto();
        Criteria criteria = new Criteria("idm_Id",singleId);

        List<ListSd> listSdList = idmListSdDao.getList(criteria);
        if (ObjectUtil.isNotEmpty(listSdList)) {
            result.setListSd(listSdList);
        }
        Order odFr = new Order("VISIT_DT",false);//正序
        List<ListFr> listFrList = idmListFrDao.getList(criteria, odFr);
        if (ObjectUtil.isNotEmpty(listFrList)) {
            result.setListFr(listFrList);
        }
        Order odDd = new Order("RECORD_DATE",false);//正序
        List<ListDd> listDdList = idmListDdDao.getList(criteria,odDd);
        if (ObjectUtil.isNotEmpty(listDdList)) {
            result.setListDd(listDdList);
        }
		Order orSr = new Order("VISIT_TIME",false);//正序
		List<ListSr> listSr = idmListSrDao.getList(criteria,orSr);
		if (ObjectUtil.isNotEmpty(listSr)) {
			result.setListSr(listSr);
		}
        result.setSingleId(Long.valueOf(singleId));
        return result;
	}
	
    /**
	 * 保存患者信息
	 * @param tbSaveDto
	 * @return
	 * @throws Exception
	 */
	private String savePerson(TbSaveDto tbSaveDto) throws Exception {
		String result;
		PersonInfo personInfo = tbSaveDto.getPersonInfo();
		String[] param = tbSaveDto.getPersonInfoParam();
		if(ObjectUtil.isNotEmpty(param)){
			result = haInterfaceService.updatePersonInfo(personInfo,param);
		}else{
			result = haInterfaceService.updatePersonInfo(personInfo);
		}		
		tbSaveDto.setPersonInfo(personInfo);
		return result;
	}
	
	/**
	 * 处理患者的基本信息
	 * @param tbSaveDto
	 * @param singleId
	 * @param eventId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private Long saveGeneralCondition(TbSaveDto tbSaveDto, Long singleId, Long eventId, String type) throws Exception {
		IdmStatusInfo statusInfo = this.getIdmStatusInfo(tbSaveDto, type);
		Long idmId = statusInfo.getId();
		GeneralCondition generalCondition = tbSaveDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	savePerson(tbSaveDto);//调用接口新增或更新患者
			PersonInfo personInfo = tbSaveDto.getPersonInfo();
			if(ObjectUtil.isNotEmpty(personInfo)){
				statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
				statusInfo.setPersonId(personInfo.getId());
			}        	
	        idmId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID

            if(!"update".equals(type)){
                //业务表唯一标识singleId与状态表关联
                EventInfo eventInfo = new EventInfo();
                eventInfo.setStatusId(idmId);
                eventInfo.setEventId(eventId);
                singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
            }

            statusInfo.setId(singleId);
            generalCondition.setIdmId(singleId);
            generalConditionDao.insert(generalCondition);
        }
        return singleId;
	}
	
	/**
	 * 获取状态对象
	 * @param tbSaveDto
	 * @param type
	 * @return
	 */
	private IdmStatusInfo getIdmStatusInfo(TbSaveDto tbSaveDto, String type) {
		IdmStatusInfo statusInfo = new IdmStatusInfo();
		 if(!"update".equals(type)){ 
			 statusInfo.setIdmType(IdmType.TB.getValue());
			 statusInfo.setSpecialStatus(tbSaveDto.getSpecialStatus());
			 statusInfo.setLogoff(tbSaveDto.getLogoff());
			 if(ObjectUtil.equals(statusInfo.getSpecialStatus(), TbStatus.REGISTER.getValue()) || ObjectUtil.equals(statusInfo.getSpecialStatus(), TbStatus.RECOMMENDATION.getValue())) {
				 statusInfo.setPlaceStatus("4");
			 }
			 if(tbSaveDto.getIdmId() !=null && tbSaveDto.getIdmId() > 0l){
		        	statusInfo.setId(tbSaveDto.getIdmId());
		        } 
		 } else {
			 statusInfo = idmStatusInfoDao.get(tbSaveDto.getIdmId());
		 }
		
		if(ObjectUtil.isNotEmpty(tbSaveDto.getOtherCondition()) && ObjectUtil.isNotEmpty(tbSaveDto.getOtherCondition().getStopReasonDt())) {
			statusInfo.setSpecialStatus(TbStatus.STOP.getValue());
		}
		return statusInfo;
	}
	
	/**
	 * 根据idmId获取状态对象
	 * @param idmId
	 * @return
	 */
	public IdmStatusInfo getIdmStatusInfo(Long idmId) {
		return idmStatusInfoDao.get(idmId);
	}
	
	/**
	 * 根据EventInfo 的Id获取状态对象
	 * @param singleId
	 * @return
	 */
	@Override
	public IdmStatusInfo getIdmStatusInfoByEventId(Long singleId) {
		EventInfo eventInfo = eventInfoDao.get(new Criteria("id",singleId));
		if(ObjectUtil.isNullOrEmpty(eventInfo)) {
			return null;
		}
		return idmStatusInfoDao.get(eventInfo.getStatusId());
	}
	
	/**
	 * 根据条件生成事件对象
	 * @param result
	 * @param singleId
	 */
	private void getEvenInfo(TbSaveDto result, String singleId) {
		EventInfo eventInfo = eventInfoDao.get(new Criteria("id",singleId));
        result.setIdmId(eventInfo.getStatusId());
        result.setEventId(eventInfo.getEventId());
        result.setSingleId(eventInfo.getId());
	}

    /**
     * 查询预约查痰
     * @param ca
     * @return
     */
    public List<ListAs> getAsList(Criteria ca, Order od){
        return idmListAsDao.getList(ca, od);
    }

    /**
     * 添加预约查痰
     * @param listAs
     * @return
     */
    public void insertAs(ListAs listAs){
        idmListAsDao.insert(listAs);
    }

    /**
     * 保存预约查痰
     * @param listAs
     * @return
     */
    @Transactional
    public void saveAs(String singleId, List<ListAs> listAs){
        idmListAsDao.delete(new Criteria("IDM_ID", singleId)) ;
        idmListAsDao.batchInsert(listAs);
    }

    public void updateAs(List<ListAs> listAs){
		if (listAs != null && listAs.size() > 0){
			idmListAsDao.batchUpdate(listAs);
		}
	}

    /**
     * 保存督导服药
     * @param listSd
     * @return
     */
    @Transactional
    public void saveSd(Criteria criteria, List<ListSd> listSd){
        idmListSdDao.delete(criteria) ;
        idmListSdDao.batchInsert(listSd);
    }

    /**
     * 获取督导服药
     * @return
     */
    public List<ListSd> getSdList(Criteria criteria){

        return idmListSdDao.getList(criteria);
    }


    /**
     * 查询密切接触者
     * @param ca
     * @return
     */
    public List<ListCc> getCcList(Criteria ca, Order od){
        return idmListCcDao.getList(ca, od);
    }

	/**
	 * 查询密切接触者
	 * @param ca
	 * @return
	 */
	public List<Map<String, Object>> getCcMapList(Criteria ca, Order od){
		return idmListCcDao.getMapList(ca, od);
	}


    public PageList<ListCc> getCcList(Page page, Criteria criteria, Order od){
        return idmListCcDao.getPageList(page, criteria, od);
    }

    /**
     * 密切接触者-统计
     * @param criteria
     * @return
     */
    public PageList<ListCc> getCcListForSt(Page page, Criteria criteria, Order od){
         return idmListCcDao.getCcListForSt(page, criteria);
    }

    public List<ListCc> getCcListForSt1(Criteria criteria, Order od){
        return idmListCcDao.getCcListForSt1(criteria);
    }

    /**
     * 添加密切接触者
     * @param listCc
     * @return
     */
    public void insertCc(ListCc listCc){
        idmListCcDao.insert(listCc);
    }

    /**
     * 修改密切接触者
     * @param listCc
     * @return
     */
    public void updateCc(ListCc listCc){
        idmListCcDao.update(listCc);
    }

    /**
     * 删除密切接触者
     * @param id
     * @return
     */
    public void deleteCc(Long id){
        idmListCcDao.delete(id);
    }

    /**
     * 获取密切接触者
     * @param id
     * @return
     */
    public ListCc getCc(Long id){
        return idmListCcDao.get(id);
    }
    
    /**
     * 根据转诊的活动号  获取筛查的idmID
     * @param idmId
     * @return
     */
    @Override
    public ClinicalManifestations getClinicalManifestations(String idmId) {
    	EventInfo eventInfo = eventInfoDao.findEventInfo(idmId, SpecialEvents.T_REGISTER.getValue());
    	if(ObjectUtil.isNotEmpty(eventInfo)) {
    		return clinicalManifestationsDao.get(new Criteria("IDM_ID", eventInfo.getId()));
    	}
    	return null;
    }

	/**
	 * 获取患者ID
	 * @param idmId
	 * @return 患者ID
	 */
	public Long getPersonId(Long idmId) {
		IdmStatusInfo statusInfo = null;
		Long personId = null;
		if(ObjectUtil.isNotEmpty(idmId)){
			statusInfo = idmStatusInfoDao.get(idmId);
		}
		if(ObjectUtil.isNotEmpty(statusInfo)){
			personId = statusInfo.getPersonId();
		}
		return personId;
	}

	@Override
	@Transactional
	public void saveDrugCard(DrugCard drugCard, String dataJson, String userId) {
		BigDecimal singleId = drugCard.getIdmId();
		BigDecimal drugCardId = drugCard.getId();
			if(drugCardId!=null)
		idmDrugCardDao.delete(new Criteria("ID", drugCardId));
		Number drugId = idmDrugCardDao.generatedKey(drugCard,"ID",null);

		List<ListSd> listSds = new ArrayList<ListSd>();
		JSONObject jObject = JSONObject.fromObject(dataJson);
		HashMap objMap = (HashMap) JSONObject.toBean(jObject, HashMap.class);
		for(Object key : objMap.keySet()){
			ListSd listSd = new ListSd();
			listSd.setIdmId(singleId.longValue());
			String keyStr = key.toString();
			String keyParts[] = keyStr.split("-");
			listSd.setMonthNo(Integer.parseInt(keyParts[0]));
			Integer dayNo = Integer.parseInt(keyParts[1]);
			listSd.setDayNo(dayNo);
			//简要病程
			if(dayNo==18)
				listSd.setMethodDetail((String)objMap.get(key));
			else
				listSd.setDrudType((String)objMap.get(key));
			listSd.setDrugDoctor(userId);
			//耐多药患者
			listSd.setFlag("1");
			//服药卡ID
			listSd.setDrugCardId(drugId.longValue());
			listSds.add(listSd);
		}
		Criteria c = new Criteria("IDM_ID", singleId);
		c.add("drugCardId", drugCardId);
		saveSd(c, listSds);
	}

	@Override
	public DrugCard getDrugCard(Criteria criteria) {

		return idmDrugCardDao.get(criteria);
	}

	@Override
	public List<DrugCard> getDrugCardList(Criteria criteria) {
		List<DrugCard> list = idmDrugCardDao.getList(criteria);
		return list;
	}

	@Override
	public boolean saveListSr(ListSr listSr) {
		BigDecimal id = listSr.getId();
		int r = 0;
		if(id==null)
			r= idmListSrDao.insert(listSr);
		else
			r=idmListSrDao.update(listSr);
		return r>0?true:false;
	}

	@Override
	public ListSr findListSr(String id) {
		return idmListSrDao.get(Long.valueOf(id));
	}

	@Override
	public boolean delListSr(String id) {
		int r =idmListSrDao.delete(new Criteria("ID",id));
		return r>0?true:false;
	}

	@Override
	@Transactional
	public boolean delNdy(String drugCardId, String idmId) {
		idmDrugCardDao.delete(new Criteria("ID", drugCardId));
		Criteria c = new Criteria("IDM_ID",idmId);
		c.add("drugCardId", drugCardId);
		idmListSdDao.delete(c) ;
		return true;
	}


	@Override
	public IdmStatusInfo findIdmStatusInfo(String id) {
		IdmStatusInfo statusInfo = idmStatusInfoDao.get(Long.valueOf(id));
		return statusInfo;
	}

	@Override
	public int updateIdmStatusInfo(IdmStatusInfo statusInfo) {
		return idmStatusInfoDao.update(statusInfo,"discontinuedTime","discontinuedReason","planVisitCount"
				,"visitCount","planDoseCount","doseCount","doseRate","doctor");
	}

	@Override
	public Integer findFrCount(String singleId) {
		Criteria criteria = new Criteria("idm_Id",singleId);
		//BUG0096070
		List list = idmListSrDao.getList(criteria);
		return list.size();
	}

	@Override
	public int confirmOrCancelNdy(IdmStatusInfo statusInfo) {
		return idmStatusInfoDao.update(statusInfo,"ndyFlag");
	}
	
	/**
     * 根据转诊的活动号 ,卡片类型，获取主要临床表现
     * @param idmId
     * @param cardType 卡片类型
     * @return
     */
    @Override
    public ClinicalManifestations getClinicalManifestations(String idmId, String cardType) {
    	EventInfo eventInfo = eventInfoDao.findEventInfo(idmId, cardType);
    	if(ObjectUtil.isNotEmpty(eventInfo)) {
    		return clinicalManifestationsDao.get(new Criteria("IDM_ID", eventInfo.getId()));
    	}
    	return null;
    }
}