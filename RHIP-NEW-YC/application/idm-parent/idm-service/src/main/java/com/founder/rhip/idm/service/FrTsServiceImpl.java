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
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListTs;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ICaseInformationDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IGeneralConditionDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmReportDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListFrDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListTsDao;
import com.founder.rhip.idm.dto.CaseDto;
import com.founder.rhip.mdm.app.IOrganizationApp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("frTsService")
public class FrTsServiceImpl extends AbstractService implements IFrTsService {

    @Resource(name = "idmListFrDao")
    private IListFrDao listFrDao;     //随访信息

    @Resource(name = "idmListTsDao")
    private IListTsDao listTsDao;     //采样信息

    @Resource(name = "generalConditionDao")
    private IGeneralConditionDao generalConditionDao;

    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;

    @Resource(name = "idmReportDao")
    private IIdmReportDao idmReportDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    public CaseDto getPersonInfo(Long singleId){
        CaseDto caseDto = new CaseDto();
        Criteria ca = new Criteria("idmId", singleId);
        GeneralCondition generalCondition = generalConditionDao.get(ca);
        CaseInformation caseInformation = caseInformationDao.get(ca);
        caseDto.setGeneralCondition(generalCondition);
        caseDto.setCaseInformation(caseInformation);
        return caseDto;
    }

    public IdmReport getReportInfo(Long singleId){
        Criteria ca = new Criteria("idmId", singleId);
        return idmReportDao.get(ca);
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

    @Override
    public ListFr findFr(Criteria criteria) {
        return listFrDao.get(criteria);
    }

    @Override
    public List<ListFr> findIdmListFrs(Criteria criteria){
        return listFrDao.getList(criteria);
    }

    /**
     * 保存随访
     * @param listFr
     * @return boolean
     */
    @Transactional
    public boolean addFr(ListFr listFr){
    	if("327".equals(listFr.getInfectiousCode()) || "204".equals(listFr.getInfectiousCode())){
    		if(ObjectUtil.isNullOrEmpty(listFr.getId())){
    			listFrDao.insert(listFr);
    		} else {
    			listFrDao.update(listFr);
    		}	
    	}else if ("311".equals(listFr.getInfectiousCode())){
    		listFrDao.delete(new Criteria("idmId",listFr.getIdmId()));
            List<ListFr> frs = listFr.getListFrs();
            if(ObjectUtil.isNotEmpty(frs) && frs.size() > 0){
                listFrDao.batchInsert(frs);
            }
            //更新最新的个人信息
            Parameters frPersonInfo= new Parameters();
            frPersonInfo.add("NAME", listFr.getName());
            frPersonInfo.add("GENDER", listFr.getGender());
            frPersonInfo.add("AGE", listFr.getAge());
            frPersonInfo.add("PARENTS_NAME", listFr.getParentsName());
            frPersonInfo.add("PATOWN_SHIP", listFr.getPatownShip());
            frPersonInfo.add("PASTREET", listFr.getPastreet());
            frPersonInfo.add("PAHOUSE_NUMBER", listFr.getPahouseNumber());
            frPersonInfo.add("PHONE_NUMBER", listFr.getPhoneNumber());
            frPersonInfo.add("TREATMENT_DT", listFr.getTreatmentDt());
            frPersonInfo.add("ATTACK_DT", listFr.getAttackDt());
            frPersonInfo.add("TREATMENT_UNIT", listFr.getTreatmentUnit());
            frPersonInfo.add("IN_HOSPITAL", listFr.getInHospital());
            listFrDao.update(frPersonInfo, new Criteria("idmId",listFr.getIdmId()));
           
            
    	}
    	 //状体更新为：已填写随访
        Parameters parameters = new Parameters();
        parameters.add("FR_STATUS", "2");
        //2017-5-4修改  不跟新current_unit(该字段跟个案的管理机构为同一字段)
        //状态表的current_unit更新（查询用）
        /*Organization org = organizationApp.queryOrganByVillage(listFr.getPastreet());
        if(null != org && !StringUtil.isNullOrEmpty(org.getParentCode())){
            parameters.add("CURRENT_UNIT", org.getParentCode());
        }*/
        
        /* //状态表的current_unit更新（查询用）
        Organization org = organizationApp.queryOrganByVillage(listFr.getPastreet());
        if(null != org && !StringUtil.isNullOrEmpty(org.getParentCode())){
            parameters.add("CURRENT_UNIT", org.getParentCode());
        }*/
    	 Long idmIdReal = eventInfoDao.get(listFr.getIdmId()).getStatusId();
         idmStatusInfoDao.update(parameters,new Criteria("id", idmIdReal));
        
        return true;
    }
    
    /**
     * 修改随访
     * @param listFr
     * @return boolean
     */
    public boolean updateFr(ListFr listFr){
        listFrDao.update(listFr);
        return true;
    }
    /**
     * 删除随访
     * @param id
     * @return boolean
     */
    public boolean deleteFr(Long id){
        listFrDao.delete(id);
        return true;
    }

    /**
     * 分页查询采样记录
     * @param       criteria
     * @param       page
     * @return      PageList<findTsList>
     */
    public PageList<ListTs> findTsList(Criteria criteria, Page page, Order od){
        return listTsDao.getPageList(page, criteria, od);
    }

    /**
     * 查询采样信息
     * @param       criteria
     * @return      ListTs
     */
    public ListTs findTs(Criteria criteria){
        return listTsDao.get(criteria);
    }

    /**
     * 保存采样
     * @param listTs
     * @return boolean
     */
    @Transactional
    public boolean addTs(ListTs listTs){
        listTsDao.insert(listTs);
        //状体跟新为：已填写采样
        Parameters parameters = new Parameters();
        parameters.add("TS_STATUS", "2");
        Long idmIdReal = eventInfoDao.get(listTs.getIdmId()).getStatusId();
        idmStatusInfoDao.update(parameters,new Criteria("ID", idmIdReal));
        return true;
    }
    /**
     * 修改采样
     * @param listTs
     * @return boolean
     */
    public boolean updateTs(ListTs listTs){
        listTsDao.update(listTs);
        return true;
    }
    /**
     * 删除采样
     * @param id
     * @return boolean
     */
    public boolean deleteTs(Long id){
        listTsDao.delete(id);
        return true;
    }
}