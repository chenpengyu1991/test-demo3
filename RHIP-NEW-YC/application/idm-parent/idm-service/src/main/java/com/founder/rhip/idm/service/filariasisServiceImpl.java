/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 传染病上报
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListLc;
import com.founder.rhip.ehr.entity.control.idm.special.ListSc;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListFrDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListLcDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListScDao;
import com.founder.rhip.idm.common.FilStatus;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.dto.FilariasisDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("filariasisService")
public class filariasisServiceImpl extends AbstractService implements IFilariasisService {
	@Resource(name = "idmReportDao")
	private IIdmReportDao idmReportDao;     //报卡表

	@Resource(name = "idmStatusInfoDao")
	private IIdmStatusInfoDao idmStatusInfoDao;     //状态表

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;     //关联表

    @Resource(name = "generalConditionDao")
    private IGeneralConditionDao generalConditionDao;    //一般情况

    @Resource(name = "attackConditionDao")
    private IAttackConditionDao attackConditionDao;     //发病情况

    @Resource(name = "pastHistoryDao")
    private IPastHistoryDao pastHistoryDao;     //既往史

    @Resource(name = "labExamineDao")
    private ILabExamineDao labExamineDao;     //实验室检查

    @Resource(name = "clinicalManifestationsDao")
    private IClinicalManifestationsDao clinicalManifestationsDao;     //主要临床表现

    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息

    @Resource(name = "idmListFrDao")
    private IListFrDao listFrDao;     //随访信息

    @Resource(name = "idmListLcDao")
    private IListLcDao listLcDao;     //自我照料

    @Resource(name = "idmListScDao")
    private IListScDao listScDao;     //随访信息

    /*
	 * 查询丝虫病 登记
	 */
    @Override
    public PageList<IdmStatusInfo> findFilRegList(Criteria criteria, Page page, boolean isStandard){
        PageList<IdmStatusInfo> result = null;
        if(ObjectUtil.isNotEmpty(criteria)){
            result = idmStatusInfoDao.findFilRegList(page, criteria, isStandard);
        }
        return result;
    }

    /**
     * 保存监测登记
     * @param filariasisDto
     * @return boolean
     */
    @Transactional
    public boolean addRegister(FilariasisDto filariasisDto){
        String surveyOrg = filariasisDto.getCaseInformation().getSurveyOrg();
        Long idmId = CreateStatus(surveyOrg);//新增状态表，返回状态表ID
        //添加事件表记录，与专项一致。
        EventInfo eventInfo = new EventInfo();
        eventInfo.setStatusId(idmId);
        eventInfo.setEventId(Long.valueOf(SpecialEvents.F_REG.getValue()));
        Long singleId = eventInfoDao.generatedKey(eventInfo, "ID",null).longValue();
        GeneralCondition generalCondition = filariasisDto.getGeneralCondition();
        LabExamine labExamine = filariasisDto.getLabExamine();
        generalCondition.setIdmId(singleId);
        CaseInformation caseInformation = filariasisDto.getCaseInformation();
        caseInformation.setIdmId(singleId);
        caseInformationDao.insert(caseInformation);
        generalConditionDao.insert(generalCondition);
        if(ObjectUtil.isNotEmpty(labExamine)){
            labExamine.setIdmId(singleId);
            labExamineDao.insert(labExamine);
        }
        return true;
    }

    /**
     * 更新监测登记
     * @param filariasisDto
     * @return boolean
     */
    @Transactional
    public boolean updateRegister(FilariasisDto filariasisDto){
        generalConditionDao.update(filariasisDto.getGeneralCondition());
        if(ObjectUtil.isNotEmpty(filariasisDto.getLabExamine())){
            if(null !=filariasisDto.getLabExamine().getId()){
                labExamineDao.update(filariasisDto.getLabExamine());
            }else {
                labExamineDao.insert(filariasisDto.getLabExamine());
            }
            if(null !=filariasisDto.getCaseInformation().getId()){
                caseInformationDao.update(filariasisDto.getCaseInformation());
            }else {
                caseInformationDao.insert(filariasisDto.getCaseInformation());
            }
        }
        return true;
    }

    /**
     * 新增状态记录
     * @return
     */
    private Long CreateStatus(String surveyOrg) {
        IdmStatusInfo statusInfo = new IdmStatusInfo();
//        statusInfo.setType(reportInfo.getInfectiousCode());
        statusInfo.setSpecialStatus(Integer.valueOf(FilStatus.REGISTER.getValue()));
		/*专项与法定区分字段*/
        statusInfo.setIdmType(IdmType.FILARIASIS.getValue());
        //个案状态未填写
        statusInfo.setCaseStatus("1");
        statusInfo.setCurrentUnit(surveyOrg);
        return idmStatusInfoDao.generatedKey(statusInfo, "ID",null).longValue();
    }

    /**
     * 查询监测登记
     * @param singleId
     * @return FilariasisDto
     */
    public FilariasisDto getRegister(Long singleId){
        FilariasisDto filariasisDto = new FilariasisDto();
        GeneralCondition generalCondition = generalConditionDao.get(new Criteria("idmId", singleId));
        LabExamine labExamine = labExamineDao.get(new Criteria("idmId", singleId));
        CaseInformation caseInformation = caseInformationDao.get(new Criteria("idmId", singleId));
        filariasisDto.setGeneralCondition(generalCondition);
        if(ObjectUtil.isNotEmpty(labExamine)){
            filariasisDto.setLabExamine(labExamine);
        }
        if(ObjectUtil.isNotEmpty(caseInformation)){
            filariasisDto.setCaseInformation(caseInformation);
        }
        return filariasisDto;
    }

    /**
     * 查询个案
     * @param singleId
     * @return FilariasisDto
     */
    public FilariasisDto getCase(Long singleId){
        FilariasisDto filariasisDto = new FilariasisDto();
        CaseInformation caseInformation = caseInformationDao.get(new Criteria("idmId", singleId));
        GeneralCondition generalCondition = generalConditionDao.get(new Criteria("idmId", singleId));
        PastHistory pastHistory = pastHistoryDao.get(new Criteria("idmId", singleId));
        AttackCondition attackCondition = attackConditionDao.get(new Criteria("idmId", singleId));
        ClinicalManifestations clinicalManifestations = clinicalManifestationsDao.get(new Criteria("idmId", singleId));
        LabExamine labExamine = labExamineDao.get(new Criteria("idmId", singleId));
        filariasisDto.setGeneralCondition(generalCondition);
        if(ObjectUtil.isNotEmpty(caseInformation)){
            filariasisDto.setCaseInformation(caseInformation);
        }
        if(ObjectUtil.isNotEmpty(pastHistory)){
            filariasisDto.setPastHistory(pastHistory);
        }
        if(ObjectUtil.isNotEmpty(attackCondition)){
            filariasisDto.setAttackCondition(attackCondition);
        }
        if(ObjectUtil.isNotEmpty(clinicalManifestations)){
            filariasisDto.setClinicalManifestations(clinicalManifestations);
        }
        if(ObjectUtil.isNotEmpty(labExamine)){
            filariasisDto.setLabExamine(labExamine);
        }
        return filariasisDto;
    }

    /**
     * 保存个案
     * @param filariasisDto
     * @return FilariasisDto
     */
    @Transactional
    public boolean addCase(FilariasisDto filariasisDto, Long idmId){

        Parameters parameters = new Parameters();
        parameters.add("SPECIAL_STATUS", FilStatus.CASE.getValue());
        parameters.add("CASE_STATUS", "2");//已填写
        idmStatusInfoDao.update(parameters,new Criteria("id", idmId));//更新状态表 SPECIAL_STATUS

        EventInfo eventInfo = new EventInfo();
        eventInfo.setStatusId(idmId);
        eventInfo.setEventId(Long.parseLong(SpecialEvents.F_CASE.getValue()));
        Long singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();

        CaseInformation caseInformation = filariasisDto.getCaseInformation();
        GeneralCondition generalCondition = filariasisDto.getGeneralCondition();
        PastHistory pastHistory = filariasisDto.getPastHistory();
        AttackCondition attackCondition = filariasisDto.getAttackCondition();
        ClinicalManifestations clinicalManifestations = filariasisDto.getClinicalManifestations();
        LabExamine labExamine = filariasisDto.getLabExamine();

        generalCondition.setIdmId(singleId);
        generalConditionDao.insert(generalCondition);
        if(ObjectUtil.isNotEmpty(caseInformation)){
            caseInformation.setIdmId(singleId);
            caseInformationDao.insert(caseInformation);
        }
        if(ObjectUtil.isNotEmpty(pastHistory)){
            pastHistory.setIdmId(singleId);
            pastHistoryDao.insert(pastHistory);
        }
        if(ObjectUtil.isNotEmpty(attackCondition)){
            attackCondition.setIdmId(singleId);
            attackConditionDao.insert(attackCondition);
        }
        if(ObjectUtil.isNotEmpty(clinicalManifestations)){
            clinicalManifestations.setIdmId(singleId);
            clinicalManifestationsDao.insert(clinicalManifestations);
        }
        if(ObjectUtil.isNotEmpty(labExamine)){
            labExamine.setIdmId(singleId);
            labExamineDao.insert(labExamine);
        }
        return true;
    }

    /**
     * 修改个案
     * @param filariasisDto
     * @return FilariasisDto
     */
    @Transactional
    public boolean updateCase(FilariasisDto filariasisDto, Long singleId){
        CaseInformation caseInformation = filariasisDto.getCaseInformation();
        GeneralCondition generalCondition = filariasisDto.getGeneralCondition();
        PastHistory pastHistory = filariasisDto.getPastHistory();
        AttackCondition attackCondition = filariasisDto.getAttackCondition();
        ClinicalManifestations clinicalManifestations = filariasisDto.getClinicalManifestations();
        LabExamine labExamine = filariasisDto.getLabExamine();

        generalCondition.setIdmId(singleId);
        generalConditionDao.update(generalCondition);
        if(ObjectUtil.isNotEmpty(caseInformation)){
            caseInformation.setIdmId(singleId);
            caseInformationDao.update(caseInformation);
        }
        if(ObjectUtil.isNotEmpty(pastHistory)){
            pastHistory.setIdmId(singleId);
            pastHistoryDao.update(pastHistory);
        }
        if(ObjectUtil.isNotEmpty(attackCondition)){
            attackCondition.setIdmId(singleId);
            attackConditionDao.update(attackCondition);
        }
        if(ObjectUtil.isNotEmpty(clinicalManifestations)){
            clinicalManifestations.setIdmId(singleId);
            clinicalManifestationsDao.update(clinicalManifestations);
        }
        if(ObjectUtil.isNotEmpty(labExamine)){
            labExamine.setIdmId(singleId);
            labExamineDao.update(labExamine);
        }
        return true;
    }

    /**
     * 分页查询随访记录
     * @param       criteria
     * @param       page
     * @return      PageList<findFrList>
     */
    public PageList<ListFr> findFrList(Criteria criteria, Page page , Order od){
        return listFrDao.getPageList(page, criteria, od);
    }

    /**
     * 分页督导检查
     * @param       criteria
     * @param       page
     * @return      PageList<findFrList>
     */
    public PageList<ListSc> findScList(Criteria criteria, Page page, Order od){
        return listScDao.getPageList(page, criteria, od);
    }

    /**
     * @param       criteria
     * @return      GeneralCondition
     */
    public GeneralCondition findGenInfo(Criteria criteria){
        return generalConditionDao.get(criteria);
    }

    /**
     * 查询随访信息
     * @param       criteria
     * @return      ListFr
     */
    public ListFr findFollowUp(Criteria criteria){
        ListFr listFr = listFrDao.get(criteria);
        Criteria ca = new Criteria("flag", listFr.getId());
        List<ListLc> listLcs = listLcDao.getList(ca);
        if(ObjectUtil.isNotEmpty(listLcs)){
            listFr.setListLcs(listLcs);
        }
        return listFr;
    }

    /**
     * 保存随访
     * @param listFr
     * @return boolean
     */
    @Transactional
    public boolean addFr(ListFr listFr){
//        Parameters parameters = new Parameters();
//        parameters.add("SPECIAL_STATUS", FilStatus.VISIT.getValue());
//        idmStatusInfoDao.update(parameters,new Criteria("id", listFr.getIdmId()));//更新状态表 SPECIAL_STATUS
        String id = listFrDao.generatedKey(listFr, "ID",null).toString();

        List<ListLc> listLcs =listFr.getListLcs();
        if(ObjectUtil.isNotEmpty(listLcs)){
            for(ListLc listLc: listLcs){
                listLc.setFlag(id);
            }
            listLcDao.batchInsert(listLcs);
        }
        return true;
    }
    /**
     * 修改随访
     * @param listFr
     * @return boolean
     */
    @Transactional
    public boolean updateFr(ListFr listFr){
        listFrDao.update(listFr);
        List<ListLc> listLcs =listFr.getListLcs();
        Criteria ca = new Criteria("flag", listFr.getId());
        listLcDao.delete(ca);
        if(ObjectUtil.isNotEmpty(listLcs)){
            for(ListLc listLc: listLcs){
                listLc.setFlag(listFr.getId().toString());
            }
            listLcDao.batchInsert(listLcs);
        }
        return true;
    }

    /**
     * 保存督导检查
     * @param listSc
     * @return boolean
     */
    public boolean addSc(ListSc listSc){
//        Parameters parameters = new Parameters();
//        parameters.add("SPECIAL_STATUS", FilStatus.SC.getValue());
//        idmStatusInfoDao.update(parameters,new Criteria("id", listSc.getIdmId()));//更新状态表 SPECIAL_STATUS
        listScDao.insert(listSc);
        return true;
    }
    /**
     * 修改督导检查
     * @param listSc
     * @return boolean
     */
    public boolean updateSc(ListSc listSc){
        listScDao.update(listSc);
        return true;
    }

    /**
     * 查询督导查询
     * @param       criteria
     * @return      ListFr
     */
    public ListSc findSc(Criteria criteria){
        ListSc listSc = listScDao.get(criteria);
        return listSc;
    }

    @Override
    public List<Map<String, Object>> findChreport(Criteria criteria) {
        List<Map<String, Object>> list = idmStatusInfoDao.findChreport(criteria);

        return list;
    }

    @Override
    public List<Map<String, Object>> findChreportCount(Criteria criteria) {
        List<Map<String, Object>> list = idmStatusInfoDao.findChreportCount(criteria);

        return list;
    }

    @Override
    public List<Map<String, Object>> findPhreport(Criteria criteria) {
        List<Map<String, Object>> list = idmStatusInfoDao.findPhreport(criteria);

        return list;
    }
    @Override
    public List<Map<String, Object>> findPhreportCount(Criteria criteria) {
        List<Map<String, Object>> list = idmStatusInfoDao.findPhreportCount(criteria);

        return list;
    }


}