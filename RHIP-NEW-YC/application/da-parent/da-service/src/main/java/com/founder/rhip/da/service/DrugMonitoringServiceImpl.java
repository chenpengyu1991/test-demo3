/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.da.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.clinic.IDrugUpkeepDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyCancelDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyCancelDetailDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyInDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyInDetailDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyOutDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyOutDetailDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyReturnDao;
import com.founder.rhip.ehr.repository.clinic.IPharmacyReturnDetailDao;
import com.founder.rhip.ehr.repository.clinic.IStorageDao;
import com.founder.rhip.ehr.repository.clinic.IStorageInDao;
import com.founder.rhip.ehr.repository.clinic.IStorageInDetailDao;
import com.founder.rhip.ehr.repository.clinic.IStorageOutDao;
import com.founder.rhip.ehr.repository.clinic.IStorageOutDetailDao;
import com.founder.rhip.ehr.repository.clinic.IStorageReturnDao;
import com.founder.rhip.ehr.repository.clinic.IStorageReturnDetailDao;

@Service("drugMonitoringService")
public class DrugMonitoringServiceImpl extends AbstractService implements IDrugMonitoringService {
 
	@Resource(name = "storageDao")
    private IStorageDao storageDao;
	
	@Resource(name = "storageInDao")
    private IStorageInDao storageInDao;
	
	@Resource(name = "storageInDetailDao")
    private IStorageInDetailDao storageInDetailDao;	

	@Resource(name = "storageOutDao")
    private IStorageOutDao storageOutDao;
	
	@Resource(name = "storageOutDetailDao")
    private IStorageOutDetailDao storageOutDetailDao;	
	
	@Resource(name = "storageReturnDao")
    private IStorageReturnDao storageReturnDao;
	
	@Resource(name = "storageReturnDetailDao")
    private IStorageReturnDetailDao storageReturnDetailDao;	
	
	@Resource(name = "pharmacyInDao")
    private IPharmacyInDao pharmacyInDao;
	
	@Resource(name = "pharmacyInDetailDao")
    private IPharmacyInDetailDao pharmacyInDetailDao;	
	
	@Resource(name = "pharmacyOutDao")
    private IPharmacyOutDao pharmacyOutDao;
	
	@Resource(name = "pharmacyOutDetailDao")
    private IPharmacyOutDetailDao pharmacyOutDetailDao;	
	
	@Resource(name = "pharmacyDao")
    private IPharmacyDao pharmacyDao;		

	@Resource(name = "pharmacyReturnDao")
    private IPharmacyReturnDao pharmacyReturnDao;
	
	@Resource(name = "pharmacyReturnDetailDao")
    private IPharmacyReturnDetailDao pharmacyReturnDetailDao;

	@Resource(name = "pharmacyCancelDao")
    private IPharmacyCancelDao pharmacyCancelDao;
	
	@Resource(name = "pharmacyCancelDetailDao")
    private IPharmacyCancelDetailDao pharmacyCancelDetailDao;
	
	@Resource(name = "drugUpkeepDao")
    private IDrugUpkeepDao drugUpkeepDao;
	
	@Override
	public PageList<Map<String, Object>> getStorageInList(Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageInDao.getPageMapList(page, criteria);
		}
		return result;		
	} 
	
	@Override
	public PageList<Map<String, Object>> getStorageInDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageInDetailDao.getDetailList(page, criteria);
		}
		return result;		
	}

	@Override
	public PageList<Map<String, Object>> getStorageOutList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageOutDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getStorageOutDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageOutDetailDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getStorageList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageDao.getPageMapList(page, criteria);
		}
		return result;			
	}	
	
	@Override
	public PageList<Map<String, Object>> getStorageReturnList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageReturnDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getStorageReturnDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = storageReturnDetailDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getPharmacyInList(Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyInDao.getPageMapList(page, criteria);
		}
		return result;		
	} 
	
	@Override
	public PageList<Map<String, Object>> getPharmacyInDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyInDetailDao.getPageMapList(page, criteria);
		}
		return result;		
	}	
	
	@Override
	public PageList<Map<String, Object>> getPharmacyOutList(Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyOutDao.getPageMapList(page, criteria);
		}
		return result;		
	} 
	
	@Override
	public PageList<Map<String, Object>> getPharmacyOutDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyOutDetailDao.getPageMapList(page, criteria);
		}
		return result;		
	}	
	
	@Override
	public PageList<Map<String, Object>> getPharmacyList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyDao.getPageMapList(page, criteria);
		}
		return result;		
	}	
	
	@Override
	public PageList<Map<String, Object>> getPharmacyReturnList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyReturnDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getPharmacyReturnDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyReturnDetailDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getPharmacyCancelList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyCancelDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getPharmacyCancelDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = pharmacyCancelDetailDao.getPageMapList(page, criteria);
		}
		return result;			
	}	
	
	/**
	 * 获取药品养护列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getUpkeepList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = drugUpkeepDao.getPageMapList(page, criteria);
		}
		return result;			
	}
}