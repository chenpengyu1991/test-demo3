/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ICaseInformationDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("haInterfaceService")
public class HaInterfaceServiceImpl extends AbstractService implements IHaInterfaceService, IPersonRecordMoveService {

    @Autowired
    private IPlatformService personService;

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;        //状态表

    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    /**
     * 获取患者信息
     *
     * @param personName
     * @param idCard
     * @return PersonInfo
     */
    public PersonInfo queryPersonalInfo(String personName, String idCard) {
        return personService.queryPersonalInfo(personName, idCard);
    }

    /**
     * 获取患者信息
     *
     * @param id
     * @return PersonInfo
     */
    public PersonInfo queryPersonalInfo(Long id) {
        return personService.queryPersonalInfo(id);
    }
    
    /**
     * 更新患者信息
     *
     * @param personInfo //	 * @return      String
     */
    public String updatePersonInfo(PersonInfo personInfo) {
        String result = "";
        PersonInfo oldPerson = personService.queryPersonalInfo(personInfo.getId());
        String newIdcard = personInfo.getIdcard();
        if(ObjectUtil.isNullOrEmpty(personInfo.getId()) && ObjectUtil.isNotEmpty(newIdcard)){
        	oldPerson = personService.queryPersonalInfo("",newIdcard);
        } 
        
        //如果健康档案已经存在
        if(ObjectUtil.isNotEmpty(oldPerson)){
        	String oldIdcard = oldPerson.getIdcard();
        	//如果已经存在的健康档案身份证为空
        	if(StringUtil.isNullOrEmpty(oldIdcard) ){
        		//新身份证不为空，则删除已经存在的健康档案
        		if(StringUtil.isNotEmpty(newIdcard)){
	        		personService.deleteNoIdCardPerson(personInfo.getId());
	        		oldPerson = personService.queryPersonalInfo(null,newIdcard);
        		}
            }else{//如果已经存在的健康档案身份证不为空
            	//新老健康档案身份证号码不一致
            	if(!oldIdcard.equals(newIdcard)){
            		oldPerson = personService.queryPersonalInfo(null,newIdcard);
            	}
            }
        }
        if (ObjectUtil.isNotEmpty(oldPerson)) {
            personInfo.setId(oldPerson.getId());
            if(null != personInfo.getHouseholdType() && personInfo.getHouseholdType().equalsIgnoreCase("1")){
                personService.updatePersonInfo(personInfo, new String[]{"name", "birthday", "gender", "occupation", "patownShip", "pastreet", "paGroup", "pahouseNumber", "paAddress", "unitName",
                        "phoneNumber", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName"});
            }else{
                personService.updatePersonInfo(personInfo, new String[]{"name", "birthday", "gender", "occupation", "pahouseNumber", "paAddress", "unitName",
                        "phoneNumber", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName"});
            }
            personInfo.setSmpiId(oldPerson.getSmpiId());
            result = oldPerson.getSmpiId();
        } else {
            personInfo.setId(null);
            result = personService.createPerson(personInfo, null, false);
        }
        return result;
    }

    /**
     * 更新患者信息
     *
     * @param personInfo 	 
     * @return String
     */
    public String updatePersonInfo(PersonInfo personInfo, String...param) {
        String result = "";
        PersonInfo oldPerson = personService.queryPersonalInfo(personInfo.getId());
        String newIdcard = personInfo.getIdcard();
        if(ObjectUtil.isNullOrEmpty(personInfo.getId()) && ObjectUtil.isNotEmpty(newIdcard)){
        	oldPerson = personService.queryPersonalInfo("",newIdcard);
        } 
        
        //如果健康档案已经存在
        if(ObjectUtil.isNotEmpty(oldPerson)){
        	String oldIdcard = oldPerson.getIdcard();
        	//如果已经存在的健康档案身份证为空
        	if(StringUtil.isNullOrEmpty(oldIdcard) ){
        		//新身份证不为空，则删除已经存在的健康档案
        		if(StringUtil.isNotEmpty(newIdcard)){
	        		personService.deleteNoIdCardPerson(personInfo.getId());
	        		oldPerson = personService.queryPersonalInfo(null,newIdcard);
        		}
            }else{//如果已经存在的健康档案身份证不为空
            	//新老健康档案身份证号码不一致
            	if(!oldIdcard.equals(newIdcard)){
            		oldPerson = personService.queryPersonalInfo(null,newIdcard);
            	}
            }
        }

        if (ObjectUtil.isNotEmpty(oldPerson)) {
            personInfo.setId(oldPerson.getId());
            personService.updatePersonInfo(personInfo, param);
            String smpiId = oldPerson.getSmpiId();
            if(StringUtil.isNotEmpty(smpiId)){
            	personInfo.setSmpiId(smpiId);
            }
            result = smpiId;
        } else {
            personInfo.setId(null);
            result = personService.createPerson(personInfo, null, false);
        }
        return result;
    }
    
    /**
     * 更新患者信息(直报)
     *
     * @param personInfo //	 * @return      String
     */
    public String updatePersonInfoForReport(PersonInfo personInfo) {
        String result = "";
        PersonInfo oldPerson = personService.queryPersonalInfo(personInfo.getId());
        String newIdcard = personInfo.getIdcard();
        if(ObjectUtil.isNullOrEmpty(personInfo.getId()) && ObjectUtil.isNotEmpty(newIdcard)){
        	oldPerson = personService.queryPersonalInfo("",newIdcard);
        }        
        //如果健康档案已经存在
        if(ObjectUtil.isNotEmpty(oldPerson)){
        	String oldIdcard = oldPerson.getIdcard();
        	//如果已经存在的健康档案身份证为空
        	if(StringUtil.isNullOrEmpty(oldIdcard) ){
        		//新身份证不为空，则删除已经存在的健康档案
        		if(StringUtil.isNotEmpty(newIdcard)){
	        		personService.deleteNoIdCardPerson(personInfo.getId());
	        		oldPerson = personService.queryPersonalInfo(null,newIdcard);
        		}
            }else{//如果已经存在的健康档案身份证不为空
            	//新老健康档案身份证号码不一致
            	if(!oldIdcard.equals(newIdcard)){
            		oldPerson = personService.queryPersonalInfo(null,newIdcard);
            	}
            }
        }
        if (ObjectUtil.isNotEmpty(oldPerson)) {
            personInfo.setId(oldPerson.getId());
            if(null != personInfo.getHouseholdType() && personInfo.getHouseholdType().equalsIgnoreCase("1")){
                personService.updatePersonInfo(personInfo, new String[]{"name", "birthday", "gender", "occupation", "patownShip", "pastreet", "paGroup", "pahouseNumber", "paAddress", "unitName",
                        "phoneNumber", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "nation", "education", "hrtownShip", "hrstreet", "hrGroup", "hrhouseNumber", "hrAddress"});
            }else{
                personService.updatePersonInfo(personInfo, new String[]{"name", "birthday", "gender", "occupation", "pahouseNumber", "paAddress", "unitName",
                        "phoneNumber", "updateOrganCode", "updateOrganName", "updateIdcard", "updateName", "nation", "education", "hrtownShip", "hrstreet", "hrGroup", "hrhouseNumber", "hrAddress"});
            }
            personInfo.setSmpiId(oldPerson.getSmpiId());
            result = oldPerson.getSmpiId();
        } else {
            personInfo.setId(null);
        	personInfo.setMarriage("");//婚姻状况不取值，字典不一致
            result = personService.createPerson(personInfo, null, false);
        }
        return result;
    }

    /**
     * 获取事件号
     *
     * @return String
     */
    public String queryEhrId(Long pixId, String organCode, String organName) {
        String result = "0001";
        //result = personService.createEhrHealthEvent(EhrType.INFECTIOUS_DISEASE,pixId,new Date(),organCode,organName);
        return result;
    }

    /**
     *  档案迁移
     * @param personId
     * @param smpiId
     * @param oldOrg
     * @param newOrg
     */
    @Override
    public void personRecordMove(Long personId, String smpiId, Organization oldOrg, Organization newOrg) {
        List<IdmStatusInfo> idmStatusInfoList = idmStatusInfoDao.getList(new Criteria("pixId", smpiId));
        for(IdmStatusInfo statusInfo : idmStatusInfoList){
            String type = statusInfo.getIdmType();
            if(IdmType.LEGAL.getValue().equals(type)){//直报部分
                Parameters parameters = new Parameters();
                parameters.add("CURRENT_UNIT", newOrg.getParentCode());
                idmStatusInfoDao.update(parameters, new Criteria("id",statusInfo.getId()));
            }
            if (IdmType.TB.getValue().equals(type)){ //结核病
                updateTB(statusInfo, oldOrg, newOrg);
            }else{
                if (IdmType.FILARIASIS.getValue().equals(type)){ //丝虫病
                    EventInfo eventInfo = eventInfoDao.get(new Criteria("statusId", statusInfo.getId()).add("eventId", "5002"));
                    if(ObjectUtil.isNotEmpty(eventInfo)){
                        Parameters parameters = new Parameters();
                        parameters.add("SURVEY_ORG", newOrg.getParentCode());
                        caseInformationDao.update(parameters, new Criteria("idmId",eventInfo.getId()));
                    }
                }
                if (IdmType.SCHISTOSOME.getValue().equals(type)){ //血吸虫
//                    List<String> eventIds = new ArrayList<String>();
//                    eventIds.add(SpecialEvents.S_CASE.getValue()); //3002
//                    eventIds.add(SpecialEvents.S_ADVANCED_SURVEY.getValue());  //3004
//                    List<EventInfo> eventInfos = eventInfoDao.getList(new Criteria("statusId", statusInfo.getId()).add("eventId",OP.IN, eventIds.toArray()));
//
//                    if(ObjectUtil.isNotEmpty(eventInfos)){
//                        List<Long> ids = new ArrayList<Long>();
//                        for(EventInfo eventInfo : eventInfos){
//                            ids.add(eventInfo.getId());
//                        }
//                        Parameters parameters = new Parameters();
//                        parameters.add("REPORT_ORG", newOrg.getParentCode());
//                        caseInformationDao.update(parameters, new Criteria("idmId", OP.IN, ids.toArray()));
//                    }

                    Parameters parameters = new Parameters();
                    parameters.add("CURRENT_UNIT", newOrg.getParentCode());
                    idmStatusInfoDao.update(parameters, new Criteria("pixId",statusInfo.getPixId()));
                }
                if (IdmType.LEPROSY.getValue().equals(type)){ //麻风
                    EventInfo eventInfo = eventInfoDao.get(new Criteria("statusId", statusInfo.getId()).add("eventId", "6002"));
                    if(ObjectUtil.isNotEmpty(eventInfo)){
                        Parameters parameters = new Parameters();
                        parameters.add("MODIFY_SURVEY_ORG", newOrg.getParentCode());
                        caseInformationDao.update(parameters, new Criteria("idmId",eventInfo.getId()));
                    }
                }
                if (IdmType.MALARIA.getValue().equals(type)){ //疟疾
                    List<String> eventIds = new ArrayList<String>();
                    eventIds.add(SpecialEvents.M_BlOOD.getValue()); //1001疟疾-血检
                    eventIds.add(SpecialEvents.M_CASE.getValue()); //1002疟疾-个案
                    eventIds.add(SpecialEvents.M_DRUGREG.getValue());  //1004服药登记
                    eventIds.add(SpecialEvents.M_EPIDEMICFOCUS.getValue());  //1005疫点处理
                    eventIds.add(SpecialEvents.M_RESTDRUGREG.getValue());  //1006休止期间日疟服药登记
                    eventIds.add(SpecialEvents.M_FGRESTDRUGREG.getValue());  //1007休止期间日疟重点人群服药登记
                    List<EventInfo> eventInfos = eventInfoDao.getList(new Criteria("statusId", statusInfo.getId()).add("eventId", OP.IN, eventIds.toArray()));
                    if(ObjectUtil.isNotEmpty(eventInfos)){
//                        List<Long> ids = new ArrayList<Long>();
//                        for(EventInfo eventInfo : eventInfos){
//                            ids.add(eventInfo.getId());
//                        }
                        Long idmId = eventInfos.get(0).getStatusId();
                        Parameters parameters = new Parameters();
//                        parameters.add("ACCEPT_UNIT", newOrg.getParentCode());
//                        caseInformationDao.update(parameters, new Criteria("idmId", OP.IN, ids.toArray()));
                        parameters.add("CURRENT_TOWN", newOrg.getGbCode());
                        parameters.add("CURRENT_UNIT", newOrg.getParentCode());
                        idmStatusInfoDao.update(parameters, new Criteria("id", idmId));
                    }
                }
            }
        }
    }

    /**
     *
     * @param statusInfo
     * @param oldOrg
     * @param newOrg
     */
//    private void updateTB(IdmStatusInfo statusInfo, Organization oldOrg, Organization newOrg) {
//        String oldParentCode = oldOrg.getParentCode();
//        String newParentCode = newOrg.getParentCode();
//        if (oldParentCode.equals(newParentCode)) {//同一个中心
//            Organization currentOrg = organizationApp.queryOrgan(statusInfo.getCurrentUnit());
//            //当前管理单位是站的时候更新
//            if("B2".equals(currentOrg.getGenreCode())){
//                statusInfo.setCurrentUnit(newOrg.getOrganCode());
//                idmStatusInfoDao.update(statusInfo, new String[]{"currentUnit"});
//            }
//        } else {
//            if(statusInfo.getCurrentUnit().equals(oldOrg.getOrganCode())) {  //不同中心下，当前单位是站
//                statusInfo.setCurrentUnit(newOrg.getOrganCode());
//                statusInfo.setLastUnit(newParentCode);
//                idmStatusInfoDao.update(statusInfo, new String[]{"lastUnit", "currentUnit"});
//            }else if(statusInfo.getCurrentUnit().equals(oldOrg.getParentCode())){ //不同中心下，当前单位是中心
//                statusInfo.setCurrentUnit(newParentCode);
//                idmStatusInfoDao.update(statusInfo, new String[]{"currentUnit"});
//            }
//        }
//    }

    private void updateTB(IdmStatusInfo statusInfo, Organization oldOrg, Organization newOrg) {
        String oldParentCode = oldOrg.getParentCode();
        String newParentCode = newOrg.getParentCode();
        Organization currentOrg = organizationApp.queryOrgan(statusInfo.getCurrentUnit());
        if (oldParentCode.equals(newParentCode)) {//同一个中心
            //当前管理单位是站
            if(ObjectUtil.isNotEmpty(currentOrg) && OrgGenreCode.STATION.getValue().equals(currentOrg.getGenreCode())){
                statusInfo.setLastUnit(newParentCode);
                statusInfo.setCurrentUnit(newOrg.getOrganCode());
                idmStatusInfoDao.update(statusInfo, new String[]{"lastUnit","currentUnit"});
            }else{ //当前管理单位是中心
                statusInfo.setCurrentUnit(newOrg.getParentCode());
                statusInfo.setLastUnit(newOrg.getParentCode());
                idmStatusInfoDao.update(statusInfo, new String[]{"lastUnit","currentUnit"});
            }
        } else {
            if(ObjectUtil.isNotEmpty(currentOrg) && OrgGenreCode.STATION.getValue().equals(currentOrg.getGenreCode())) {  //不同中心下，当前单位是站
                statusInfo.setCurrentUnit(newOrg.getOrganCode());
                statusInfo.setLastUnit(newParentCode);
                idmStatusInfoDao.update(statusInfo, new String[]{"lastUnit", "currentUnit"});
            }else { //不同中心下，当前单位是中心
                statusInfo.setCurrentUnit(newParentCode);
                idmStatusInfoDao.update(statusInfo, new String[]{"currentUnit"});
            }
        }
    }
}