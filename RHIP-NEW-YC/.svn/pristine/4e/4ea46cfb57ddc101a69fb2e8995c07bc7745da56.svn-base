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
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmAssess;
import com.founder.rhip.ehr.entity.management.mhm.MhmBasicsInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmCase;
import com.founder.rhip.ehr.entity.management.mhm.MhmCaseDetail;
import com.founder.rhip.ehr.entity.management.mhm.MhmDiagnosis;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugPrice;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugRecord;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugUse;
import com.founder.rhip.ehr.entity.management.mhm.MhmEmergency;
import com.founder.rhip.ehr.entity.management.mhm.MhmEventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;
import com.founder.rhip.ehr.entity.management.mhm.MhmInhospital;
import com.founder.rhip.ehr.entity.management.mhm.MhmOtherInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmPathHistory;
import com.founder.rhip.ehr.repository.management.mhm.IMhmBasicsInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDrugDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDrugPriceDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDrugUseDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmEventInfoDao;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.dto.MhmDrugUseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Service("mhmDrugService")
public class MhmDrugServiceImpl extends AbstractService implements IMhmDrugService {

    @Resource(name = "mhmDrugDao")
    private IMhmDrugDao mhmDrugDao;
    
    @Resource(name = "mhmDrugPriceDao")
    private IMhmDrugPriceDao mhmDrugPriceDao;
 
    @Resource(name = "mhmDrugUseDao")
    private IMhmDrugUseDao mhmDrugUseDao;
    
    @Resource(name = "mhmEventInfoDao")
    private IMhmEventInfoDao eventInfoDao;     //状态表
    
    @Resource(name = "mhmBasicsInfoDao")
    private IMhmBasicsInfoDao mhmBasicsInfoDao;     //基本信息
    
	@Override
	public List<MhmDrug> findDrugList(Criteria criteria){
		return mhmDrugDao.findDrugList(criteria);
	}
	
	@Override
	public PageList<MhmDrug> findDrugList(Criteria criteria, Page page) {
		PageList<MhmDrug> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = mhmDrugDao.findDrugList(criteria,page);
		}
		return result;
	}

	@Override
	public MhmDrug getMhmDrug(Criteria criteria) {
		MhmDrug result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = mhmDrugDao.get(criteria);
		}
		return result;
	}
	
	@Override
    @Transactional
	public boolean saveDrug(MhmDrug drug) {
		if (ObjectUtil.isNullOrEmpty(drug)) {
			log.error("药品信息为空");
			return false;
		}
 		
		int result = 0;
		Long drugId = null;
		if(ObjectUtil.isNullOrEmpty(drug.getId())){
			drug.setVersion(1L);
			drugId = mhmDrugDao.generatedKey(drug, "ID", null).longValue();
			if(ObjectUtil.isNotEmpty(drugId)){
				result = 1;
				drug.setId(drugId);
			}
    	}else{
    		drug.setVersion(drug.getVersion() + 1);
    		result = mhmDrugDao.update(drug);
    	}
		saveDrugPrice(drug);//更新历史记录
		return result != 0?true:false;
	}
	/**
	 * 查询-药品修改记录
	 * @param       criteria
     *
	 * @return      PageList<MhmDrugPrice>
	 */
	public PageList<MhmDrugPrice> findDrugPriceList(Criteria criteria,Page page){
		PageList<MhmDrugPrice> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = mhmDrugPriceDao.getPageList(page, criteria,new Order("VERSION"));
		}
		return result;		
	}
	/**
	 * 查询-发药信息
	 * @param       criteria
     *
	 * @return      PageList<MhmDrugUse>
	 */
	public PageList<MhmDrugUse> findDrugUseList(Criteria criteria,Page page){
		PageList<MhmDrugUse> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = mhmDrugUseDao.findDrugUseList(criteria,page);
		}
		return result;			
	}
	/**
	 * 获取患者发药信息：患者基本信息
	 * @param       statusId
     *
	 * @return      MhmUseDrugDto
	 */
	public MhmDrugUseDto getDrugUse(Long statusId){
		MhmDrugUseDto result = new MhmDrugUseDto();

    	if(ObjectUtil.isNotEmpty(statusId)){
    		result.setStatusId(statusId);
    		getDrugUseBusiness(result);
    	}else{
    		log.error("状态表ID为空！");
    	}
    	return result;		
	}
	/**
	 * 获取发药信息
	 * @param       MhmDrugUse
	 * @return      MhmDrugUse
	 */
	public MhmDrugUse getDrugUse(Criteria criteria){
		MhmDrugUse result = null;
    	if(ObjectUtil.isNotEmpty(criteria)){
    		result = mhmDrugUseDao.getDrugUse(criteria);
    	}
    	return result;		
	}

	/**
	 * 保存发药登记信息
	 *
	 * @param drugUse
	 * @return
	 * @author Ye jianfei
	 */
	@Override
    @Transactional
	public boolean saveDrugUse(MhmDrugUse drugUse) {
		if (ObjectUtil.isNullOrEmpty(drugUse)) {
			log.error("发药信息为空");
			return false;
		}
 		
		int result = 0;
		if(ObjectUtil.isNullOrEmpty(drugUse.getId())){
			result = mhmDrugUseDao.insert(drugUse);
    	}else{
    		result = mhmDrugUseDao.update(drugUse,new String[]{"useDt","useCount","currentPrice","modifyOrganTown","modifyOrganCenter","modifyOrganStation","modifyDoctorId","modifyDate"});
    	}
		return result != 0?true:false;
	}

	/**
	 * 删除发药登记信息
	 *
	 * @param drugUseId
	 * @return
	 * @author Ye jianfei
	 */
	@Override
    @Transactional
	public boolean deleteDrugUse(Long drugUseId) {
		int result = 0;
		if (ObjectUtil.isNullOrEmpty(drugUseId)) {
			log.error("发药信息ID为空");
			return false;
		}
		result = mhmDrugUseDao.delete(drugUseId);
    	
		return result != 0?true:false;
	}
	
    /**
     * 发药登记基础数据获取
     * @param       dto
     * @return      void
     */    
    private void getDrugUseBusiness(MhmDrugUseDto dto){
		Long eventId = getEventId(dto.getStatusId(),new Integer[]{MhmEvents.M_ARCHIVES.getValue()});
		if(ObjectUtil.isNullOrEmpty(eventId)){
        	log.error("无法查找患者基本档案信息！");
        }
		Criteria ca = new Criteria("eventId",eventId);
        MhmBasicsInfo mhmBasicsInfo = mhmBasicsInfoDao.get(ca);
        if (ObjectUtil.isNotEmpty(mhmBasicsInfo)) {
        	dto.setMhmBasicsInfo(mhmBasicsInfo);
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
	 * 生成价格历史记录
	 *
	 * @param drug
	 * @author Ye jianfei
	 */
	private void saveDrugPrice(MhmDrug drug){
		MhmDrugPrice drugPrice = mhmDrugPriceDao.findDrugPrice(drug.getId());
		MhmDrugPrice newDrugPrice = new MhmDrugPrice();
		/*该药品属于新建，新建一条历史记录*/
		if(ObjectUtil.isNullOrEmpty(drugPrice)){
			newDrugPrice.setDrugId(drug.getId());
			newDrugPrice.setPrice(drug.getDrugPrice());
			newDrugPrice.setUnitPrice(drug.getUnitPrice());
			newDrugPrice.setStartDt(new Date());
			newDrugPrice.setStartOrgan(drug.getModifyOrganCode());
			newDrugPrice.setStartUser(drug.getModifyDoctorId());
			newDrugPrice.setVersion(1L);//一个药品的第一条历史记录版本为1
		}else{
			/*该药品属于更新，新建一条历史记录，同时更新上一个版本的历史记录*/
			 Parameters parameters = new Parameters();
             parameters.add("END_DT", new Date());
             parameters.add("END_ORGAN", drug.getModifyOrganCode());
             parameters.add("END_USER", drug.getModifyDoctorId());
             mhmDrugPriceDao.update(parameters, new Criteria("drugId", drugPrice.getDrugId()).add("version", drugPrice.getVersion()));	
             newDrugPrice.setDrugId(drug.getId());
             newDrugPrice.setPrice(drug.getDrugPrice());
             newDrugPrice.setUnitPrice(drug.getUnitPrice());
             newDrugPrice.setStartDt(new Date());
             newDrugPrice.setStartOrgan(drug.getModifyOrganCode());
             newDrugPrice.setStartUser(drug.getModifyDoctorId());
             newDrugPrice.setVersion(drugPrice.getVersion() + 1);//一个药品的第一条历史记录版本为1
		}
		mhmDrugPriceDao.insert(newDrugPrice);
	}

}