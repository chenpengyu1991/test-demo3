/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.common.AreaType;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.*;
import com.founder.rhip.mdm.repository.IOrganizationAreaDao;
import com.founder.rhip.mdm.repository.IOrganizationAreaHistoryDao;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import com.founder.rhip.mdm.repository.IOrganizationHistoryDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mdmOrganizationService")
public class OrganizationService extends MDMService implements IOrganizationService, IMergerTownListener {

	public static final String SEQ_ORGANIZATION = "SEQ_MDM_ORGANIZATION";
	
	@Resource(name="mdmOrganizationDao")
	private IOrganizationDao organizationDao;

    @Resource(name="mdmOrganizationHistoryDao")
    private IOrganizationHistoryDao organizationHistoryDao;
	
	@Resource(name="mdmOrganizationAreaDao")
	private IOrganizationAreaDao mdmOrganizationAreaDao;

    @Resource(name="mdmOrganizationAreaHistoryDao")
    private IOrganizationAreaHistoryDao mdmOrganizationAreaHistoryDao;
	
	@Resource(name="mergerOrgListenerManager")
	private IMergerOrganizationListenerManager mergerOrgListenerManager;

	/**
	 * 查询所有机构
	 */
	@Override
	public PageList<Map<String, Object>> getOrganizations(Page page, Criteria criteria, String... properties) {
		Order order = new Order("ORGAN_CODE");
		if (criteria == null) {
			criteria = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		} else if (!criteria.contains(Organization.STATUS)) {
			criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		}		
		PageList<Map<String, Object>> result = organizationDao.getPageMapList(page, criteria, order,properties);
		return result;
	}

	/**
	 * 查询所有机构
	 * @return      List<Organization>
	 */
	@Override
	public PageList<Organization> getOrganizations(Page page, Criteria criteria, Order order) {
		if(ObjectUtil.isNullOrEmpty(order)) {
			order = new Order("ORGAN_CODE");
		}
		if (criteria == null) {
			criteria = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		} else if (!criteria.contains(Organization.STATUS)) {
			criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		}
		PageList<Organization> result = organizationDao.getPageList(page, criteria, order);
		return result;
	}
	
	/**
	 * 查询所有机构
	 * @return      List<Organization>
	 */
	@Override
	public PageList<Organization> getOrganizations(Page page, Criteria criteria) {
		Order order = new Order("ORGAN_CODE");
		if (criteria == null) {
			criteria = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		} else if (!criteria.contains(Organization.STATUS)) {
			criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		}		
		PageList<Organization> result = organizationDao.getPageList(page, criteria, order);
		return result;
	}
	
	/**
	 * 查询所有机构不包含中心（站）
	 * @return      List<Organization>
	 */
	@Override
	public PageList<Organization> getOrganizationsNoVirtual(Page page, Criteria criteria) {
		PageList<Organization> result = organizationDao.getOrganizationsNoVirtual(page, criteria);
		return result;
	}
	
	/**
	 * 查询所有机构
	 * @return      List<Organization>
	 */
	@Override
	public List<Organization> getOrganizations(Criteria criteria) {
		Order order = new Order("GB_CODE, ORGAN_CODE");
		List<Organization> result = organizationDao.getList(criteria, order);
		return result;
	}

    @Override
    public List<OrganizationHistory> getOrganizationsHistory(Criteria criteria) {
        Order order = new Order("GB_CODE, ORGAN_CODE");
        List<OrganizationHistory> result = organizationHistoryDao.getList(criteria, order);
        return result;
    }
	
	/**
	 * 查询所有机构,使用缓存
	 */
	@Override
	public List<Organization> getOrganizationsUseCache(Criteria criteria) {
		String key = LSIT_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<Organization> retList = (List<Organization>) getCache(EntityType.ORGANIZATION, key);
		if (retList == null) {
			Order order = new Order("nlssort(organ_name,'NLS_SORT=SCHINESE_PINYIN_M')", true);
			retList = organizationDao.getList(criteria, order);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.ORGANIZATION, key, retList);
			}
		}
		return retList;
	}

	/**
	 * 查询所有机构,使用缓存
	 *
	 * @param criteria
	 * @param order
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<Organization> getOrganizationsUseCache(Criteria criteria, Order order) {
		String key = "list_order_" + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<Organization> retList = (List<Organization>) getCache(EntityType.ORGANIZATION, key);
		if (retList == null) {
			if(ObjectUtil.isNullOrEmpty(order)){
				order = new Order("gb_Code", true);
			}
			retList = organizationDao.getList(criteria, order);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.ORGANIZATION, key, retList);
			}
		}
		return retList;
	}

	@Override
	public Map<String, String> getOrganizationsMapUseCache(Criteria criteria) {
		String key = MAP_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		Map<String, String> retMap = (Map<String, String>) getCache(EntityType.ORGANIZATION, key);
		if (retMap == null) {
			retMap = new HashMap<String, String>();
			List<Organization> organizations = organizationDao.getList(criteria);
			for (Organization organ : organizations) {
				retMap.put(organ.getOrganCode(), organ.getOrganName());
			}
			if (retMap.size() > 0) {
				setCache(EntityType.ORGANIZATION, key, retMap);
			}
		}
		return retMap;
	}

	/**
	 * 根据机构Code查询机构
	 * @param       organCode
	 * @return      Organization
	 */
	@Override
	public Organization getOrganization(String organCode) {
		Criteria criteria = new Criteria(Organization.ORGAN_CODE, organCode);
		return getOrganization(criteria);
	}
	
	/**
	 * 根据机构ID查询机构
	 * @param       organizationId
	 * @return      Organization
	 */
	@Override
	public Organization getOrganization(Long organizationId) {
		return organizationDao.get(organizationId);
	}
	
	/**
	 * 根据条件查询机构
	 * @param       criteria
	 * @return      Organization
	 */
	@Override
	public Organization getOrganization(Criteria criteria) {
		Organization organization = organizationDao.get(criteria);
		return organization;
	}

    /**
     * 根据条件查询机构
     * @param       criteria
     * @return      OrganizationHistory
     */
    @Override
    public OrganizationHistory getOrganizationHistory2(Criteria criteria) {
        OrganizationHistory organization = organizationHistoryDao.get(criteria);
        return organization;
    }

	/**
	 * 注册机构
	 * @return      String
	 */
	@Override
	@Transactional
	public void createOrganization(Organization organization, List<OrganizationArea> orgAreas) {

		if(StringUtils.equals(OrgGenreCode.STATION.getValue(), organization.getGenreCode())) {
			Organization organizationT = getOrganization( organization.getParentCode());
			if(ObjectUtil.isNotEmpty(organizationT)) {
				organization.setGbCode(organizationT.getGbCode());
			}
		}
		organizationDao.insertWithSeq(organization, SEQ_ORGANIZATION);
		//用户那边需要机构id
		organization.setOrganId(this.getOrganization(organization.getOrganCode()).getOrganId());
		/**if(StringUtils.equals(OrgGenreCode.CENTRE.getValue(), organization.getGenreCode())) {
			Organization orgVirtual = this.getOrgVirtual(organization);
			organizationDao.insertWithSeq(orgVirtual, SEQ_ORGANIZATION);
			this.saveRelation(orgVirtual.getOrganCode(), orgAreas);
		}**/
		if(ObjectUtil.isNotEmpty(orgAreas) && !StringUtils.equals(OrgGenreCode.CENTRE.getValue(), organization.getGenreCode())) {
			this.saveRelation(organization.getOrganCode(), orgAreas);
		}
		removeCache(EntityType.ORGANIZATION);
	}

	/**
	 * 根据中心对象获取其虚拟的站对象
	 * @param organization
	 * @return
	 */
	private Organization getOrgVirtual(Organization organization) {
		Organization orgVirtual = organization.clone();
		orgVirtual.setParentCode(organization.getOrganCode());
		orgVirtual.setOrganName(organization.getOrganName() + "(站)");
		orgVirtual.setOrganCode("X" + organization.getOrganCode());
		orgVirtual.setGenreCode(OrgGenreCode.STATION.getValue());
		orgVirtual.setGbCode(organization.getGbCode());
		return orgVirtual;
	}
	/**
	 * 更新机构
	 * @param organization
	 * @param orgAreas
	 * @param properties
	 * @return
	 */
	@Override
	@Transactional
	public void updateOrganization(Organization organization, List<OrganizationArea> orgAreas, String... properties) {
		Long organizationId = organization.getOrganId();
		Criteria criteria = new Criteria(Organization.ORGAN_ID, organizationId);
		organizationDao.insertOrganizationLog(criteria);
		organizationDao.update(organization, properties);
		this.updateVirtualOrg(organization);
		
		if(ObjectUtil.isNotEmpty(orgAreas) && !StringUtils.equals(OrgGenreCode.CENTRE.getValue(), organization.getGenreCode())) {
			this.saveRelation(organization.getOrganCode(), orgAreas);
		}
        if(ObjectUtil.isNullOrEmpty(orgAreas)){
//            Criteria criteria = new Criteria("ORGANIZATION_CODE", organization.getOrganCode());
            mdmOrganizationAreaDao.delete(new Criteria("ORGANIZATION_CODE", organization.getOrganCode()));
        }
		removeCache(EntityType.ORGANIZATION);
		DictionaryCache.destroyOrgCache();
		DictionaryCache.destroyOrgListCache();
	}

	/**
	 * 级联更新虚拟站
	 * @param organization
	 */
	private void updateVirtualOrg(Organization organization) {
		Organization oldOrgV = organizationDao.get(new Criteria(organization.ORGAN_CODE, "X" + organization.getOrganCode()));
		/*以往此机构不是中心 更新后此机构类型为中心   增加虚拟站*/
		if(ObjectUtil.isNullOrEmpty(oldOrgV) && StringUtils.equals(OrgGenreCode.CENTRE.getValue(), organization.getGenreCode())) {
			Organization orgVirtual = this.getOrgVirtual(organization);
			organizationDao.insertWithSeq(orgVirtual, SEQ_ORGANIZATION);
		} else if(ObjectUtil.isNotEmpty(oldOrgV) && !StringUtils.equals(OrgGenreCode.CENTRE.getValue(), organization.getGenreCode())) {
			/*以往此机构是中心 更新后此机构类型不是中心 删除以往的虚拟站*/
			//TODO 用户如何修改
			organizationDao.update(new Parameters(Organization.STATUS, StatusValue.deleteValue.getValue()),
					new Criteria(Organization.ORGAN_CODE, oldOrgV.getOrganCode()));
		} else if(ObjectUtil.isNotEmpty(oldOrgV) && StringUtils.equals(OrgGenreCode.CENTRE.getValue(), organization.getGenreCode())) {
			/*更新前后机构类型不便  级联更新虚拟站*/
			Organization orgVirtual = this.getOrgVirtual(organization);
			orgVirtual.setOrganId(oldOrgV.getOrganId());
			organizationDao.update(orgVirtual);
		}
	}
	/**
	 * 查询机构更新历史
	 * @param page
	 * @param organizationId
	 * @return      List<Organization>
	 */
	@Override
	public PageList<Organization> getUpdateHistory(Page page, Long organizationId) {
		PageList<Organization> pageList = organizationDao.getUpdateHistory(page, organizationId);
		return pageList;
	}
	
	/**
	 * 查询机构更新历史
	 */
	@Override
	public Organization getOrganizationHistory(Criteria criteria) {
		return organizationDao.getLog(criteria);
	}
	
	/**
	 * 删除机构
	 * @param organizationId
	 * @return      
	 */
	@Override
	@Transactional
	public void deleteOrganization(Long organizationId) {
		//修改为逻辑删除 HNYC-520 机构删除，做逻辑删除，打个删除标志，后续可以对机构进行恢复
		//注释掉删除机构方法
//		//organizationDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1),new Criteria("organId",organizationId));
//		removeCache(EntityType.ORGANIZATION);
	}
	
	/**
	 * 改变状态
	 */
	@Override
	@Transactional
	public void changeStatus(Organization organization) {
		Long organId = organization.getOrganId();
		Organization dbOrgan = organizationDao.get(organId);
		dbOrgan.setStatus(organization.getStatus());
		dbOrgan.setOperator(organization.getOperator());
		dbOrgan.setOperateTime(organization.getOperateTime());
		dbOrgan.setOperateType(organization.getOperateType());
		dbOrgan.setEndDate(organization.getEndDate());
		Criteria criteria = new Criteria(Organization.ORGAN_ID, organId);
		organizationDao.insertOrganizationLog(criteria);
		organizationDao.update(dbOrgan);
		this.updateVirtualOrg(dbOrgan);
		removeCache(EntityType.ORGANIZATION);
	}
	
	/**
	 * 批量导入
	 */
	@Override
	public int importOrganizations(List<Record> organizationList, String... properties) {
		List<Record> insertOrganList = new ArrayList<Record>();
		List<Record> updateOrganList = new ArrayList<Record>();
		List<Long> updateOrganCodes = new ArrayList<Long>();
		for (Record record : organizationList) {
			String organCode = record.getAsString(Organization.ORGAN_CODE);
			Organization organ = organizationDao.get(new Criteria(Organization.ORGAN_CODE, organCode));
			if (organ == null) {
				record.set(Organization.ORGAN_ID, organizationDao.getSequenceNextVal(SEQ_ORGANIZATION, Long.class));
				insertOrganList.add(record);
			} else {
				record.set(Organization.ORGAN_ID, organ.getOrganId());
				updateOrganCodes.add(organ.getOrganId());
				updateOrganList.add(record);
			}
		}
		
		List<List> logList = getInsertLogs(updateOrganCodes);
		for (List ids : logList) {
			Criteria criteria = new Criteria(Organization.ORGAN_ID, OP.IN, ids);
			organizationDao.insertOrganizationLog(criteria);
			ids.clear();
			ids = null;
		}
		logList.clear();
		logList = null;
		updateOrganCodes.clear();
		updateOrganCodes = null;
		
		properties = ArrayUtil.add(properties, "endDate");
		organizationDao.batchMapUpdate(updateOrganList, properties);
		String[] insertProperties = ArrayUtil.add(properties, Organization.ORGAN_ID);
		organizationDao.batchMapInsert(insertOrganList, insertProperties);

		insertOrganList.clear();
		insertOrganList = null;
		updateOrganList.clear();
		updateOrganList = null;
		removeCache(EntityType.ORGANIZATION);
		return organizationList.size();
	}

	/**
	 * 获取OrganizationArea对象集合
	 * @param criteria
	 * @return
	 */
	@Override
	public List<OrganizationArea> getOrganizationAreas(Criteria criteria){
		return mdmOrganizationAreaDao.getOrganizationAreas(criteria);
	}

    @Override
    public List<OrganizationAreaHistory> getOrganizationAreasHistory(Criteria criteria){
        return mdmOrganizationAreaHistoryDao.getOrganizationAreasHistory(criteria);
    }

	@Override
	@Transactional
	public Boolean saveRelation(String organCode, List<OrganizationArea> orgAreas) {
		//修改之前先清空以前的关系
		Criteria criteria = new Criteria("ORGANIZATION_CODE", organCode);
		List<OrganizationArea> oldRelations = mdmOrganizationAreaDao.getList(criteria);

		mdmOrganizationAreaDao.delete(criteria);
		//新增加的机构和行政村的关系
		if(ObjectUtil.isNotEmpty(orgAreas)) {
			//保存新的关系
			mdmOrganizationAreaDao.batchInsertWithSeq(orgAreas, "SEQ_MDM_ORGANIZATION_AREA");
			//20140516需求变更：站和村委会发生变化时，只迁移地址，不迁移管理单位，刘洋
			String []newAddVillageCodes = this.getNewAddRelation(oldRelations, orgAreas);
			if(ObjectUtil.isNotEmpty(newAddVillageCodes)) {
				mergerOrgListenerManager.changeRelationOrgVillage(organCode, newAddVillageCodes);
			}
		}
		return true;
	}

	/**
	 * 获取机构中新增加的新政村的code
	 * @param oldRelations
	 * @param orgAreas
	 * @return
	 */
	private String[] getNewAddRelation(List<OrganizationArea> oldRelations, List<OrganizationArea> orgAreas) {
		List<String> newAddVillageCodes = new ArrayList<String>();
		List<String> oldRelationVillageCodes = new ArrayList<String>();
		for(OrganizationArea oldRelation : oldRelations) {
			oldRelationVillageCodes.add(oldRelation.getAreaCode());
		}
		
		for(OrganizationArea orgArea : orgAreas) {
			if(!oldRelationVillageCodes.contains(orgArea.getAreaCode())) {
				newAddVillageCodes.add(orgArea.getAreaCode());
			}
		}
		return newAddVillageCodes.toArray(new String[newAddVillageCodes.size()]);
	}
	
	@Override
	public void mergeTown(String newTownCode, String[] oldTownCodes) {
		organizationDao.update(new Parameters("GB_CODE", newTownCode), new Criteria("GB_CODE", OP.IN, oldTownCodes));
	}
	
	/**
     * 保存合并 机构
     * @param newCode
     * @param oldCode
     * @param organization
     * @return
     */
	@Override
	@Transactional
    public String mergeOrganization(String newCode, String oldCode, Organization organization) {
		List<String> oldCodeArray = this.getListStr(oldCode.split(","));
		if (StringUtils.isNotEmpty(newCode)) {
			oldCodeArray.remove(newCode);
		}
		Organization organizationNew = organizationDao.get(new Criteria(Organization.ORGAN_CODE, newCode));
		List<Organization> organizationOlds = organizationDao.getList(new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
    	if(StringUtils.isEmpty(newCode)) {
    		if (isSameMerge(OrgGenreCode.STATION.getValue(), organization, organizationOlds)) {
    			mergeNewOrganization(oldCodeArray, organization);
    			mergerOrgListenerManager.notifyMergeStation(organization, organizationOlds);
    		} else if (isSameMerge(OrgGenreCode.CENTRE.getValue(), organization, organizationOlds)) {
    			//考虑虚拟站应该参与合并变，不是删除
    			mergeNewOrganization(oldCodeArray, organization);
    			mergerOrgListenerManager.notifyMergeCenter(organization, organizationOlds);
    		}
    	} else {
    		//删除其余数据
    		if (isSameMerge(OrgGenreCode.STATION.getValue(), organizationNew, organizationOlds)) {
    			mergeSameTypeOrganization(newCode, oldCodeArray);
    			mergerOrgListenerManager.notifyMergeStation(organizationNew, organizationOlds);
    		} else if (isSameMerge(OrgGenreCode.CENTRE.getValue(), organizationNew, organizationOlds)) {
    			//考虑虚拟站应该参与合并变，不是删除
    			List<String> oldCodes = this.convertOldCode(oldCodeArray, newCode);
    			organizationDao.update(new Parameters(Organization.STATUS, StatusValue.deleteValue.getValue()), new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodes));
    			mergeSameTypeOrganization(newCode, oldCodeArray);
    			mergerOrgListenerManager.notifyMergeCenter(organizationNew, organizationOlds);
    		} else if (isStationMove(organizationNew, organizationOlds))  {
    			moveOrganization(newCode, oldCodeArray);
    			mergerOrgListenerManager.notifyMoveStation(organizationNew, organizationOlds);
    		}
    	}
    	removeCache(EntityType.ORGANIZATION);
    	return "success";
    }
	
	private boolean isStationMove(Organization organizationNew, List<Organization> organizationOlds) {
		if (organizationNew == null) {
			return false;
		}
		if (!OrgGenreCode.CENTRE.getValue().equals(organizationNew.getGenreCode())) {
			return false;
		}
		for(Organization temp : organizationOlds) {
			if (!OrgGenreCode.STATION.getValue().equals(temp.getGenreCode())) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isSameMerge(String genreCode, Organization organizationNew, List<Organization> organizationOlds) {
		if (organizationNew != null) {
			if (!genreCode.equals(organizationNew.getGenreCode())) {
				return false;
			}
		}
		for(Organization temp : organizationOlds) {
			if (!genreCode.equals(temp.getGenreCode())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 机构合并 新建一个机构
	 * @param oldCodeArray
	 * @param organization
	 */
	private void mergeNewOrganization(List<String> oldCodeArray, Organization organization) {
		Parameters parametersDelete = new Parameters(Organization.STATUS, StatusValue.deleteValue.getValue());
		List<String> oldCodes = this.convertOldCode(oldCodeArray, "");
		Criteria criteriaOldParentCode = new Criteria(Organization.PARENT_CODE, OP.IN, oldCodeArray);
		
		organization.setOperateDetail(organization.getOrganName() + "是由" + this.getOrgName(oldCodeArray) + "合并而来");
		organization.setOperateType(OperateType.merge.getName());
		/*保存新形成的机构*/
		this.createOrganization(organization, null);
		Parameters parameters = new Parameters("operateDetail", this.getOrgName(oldCodeArray) + "被合并为" + organization.getOrganName()).
				add(Organization.STATUS, StatusValue.deleteValue.getValue()).add("operateType", OperateType.merge.getName());
		organizationDao.insertOrganizationLog(new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		organizationDao.update(parameters, new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		organizationDao.update(parametersDelete, new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodes));
		//某些机构和新的机构不在同一个镇下时解除关系
		deleteOldOrganizationAreaForVillage(organization, oldCodeArray);
		//行政村和机构的关系迁移
		this.updateOrganizationAreaForVillage(oldCodes, oldCodeArray, organization);
		//级联更新
		organizationDao.update(new Parameters(Organization.PARENT_CODE, organization.getOrganCode()).
								add("GB_CODE", organization.getGbCode()), criteriaOldParentCode);
		//乡镇地段和机构的关系迁移 
		this.updateOrganizationAreaForTown(oldCodeArray, organization.getOrganCode());
	}
	
	/**
	 * 被合并的机构和新机构不在同一个镇下时  将被合并的机构和行政村的关系解除
	 */
	private void deleteOldOrganizationAreaForVillage(Organization organization, List<String> oldCodeArray) {
		List<Organization> organizationOlds = organizationDao.getList(new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		if(StringUtils.equals(organization.getGenreCode(), OrgGenreCode.STATION.getValue())) {
			String newTownCode = "";
			Organization parentOrg = this.getOrganization(organization.getParentCode());
			if(ObjectUtil.isNotEmpty(parentOrg)) {
				newTownCode = parentOrg.getGbCode();
			}
			/*找出和新的站不在同一个镇下的机构*/
			List<String> notInSameTown = new ArrayList<String>();
			for(Organization temp : organizationOlds) {
				Organization parentOrgOld = this.getOrganization(temp.getParentCode());
				if(ObjectUtil.isNotEmpty(parentOrg) && !StringUtils.equals(newTownCode, parentOrgOld.getGbCode())) {
					notInSameTown.add(temp.getOrganCode());
				}
			}
			/*接触某些站和行政村的关系  这些站是和新的机构不在同一个镇下*/
			mdmOrganizationAreaDao.delete(new Criteria("ORGANIZATION_CODE", OP.IN, notInSameTown));
		} else {
			String newTownCode = organization.getGbCode();
			List<String> notInSameTown = new ArrayList<String>();
			/*找出和新的中心不在同一个镇下的机构*/
			for(Organization temp : organizationOlds) {
				if(!StringUtils.equals(newTownCode, temp.getGbCode())) {
					notInSameTown.add(temp.getOrganCode());
				}
			}
			/*找出中心下面所有的站 将这些站和行政村的关系解除*/
			List<String> deleteOrgCodes = new ArrayList<String>();
			List<Organization> stations = organizationDao.getList(new Criteria(Organization.PARENT_CODE, OP.IN, notInSameTown));
			for(Organization station : stations) {
				deleteOrgCodes.add(station.getOrganCode());
			}
			/*接触某些站和行政村的关系  这些站是和新的机构不在同一个镇下*/
			mdmOrganizationAreaDao.delete(new Criteria("ORGANIZATION_CODE", OP.IN, deleteOrgCodes));
		}
	}
	/**
	 * 同类型机构合并 站站合并 中心和中心合并
	 * @param newCode
	 * @param oldCodeArray
	 */
	private void mergeSameTypeOrganization(String newCode, List<String> oldCodeArray) {
		Parameters parametersDelete = new Parameters(Organization.STATUS, StatusValue.deleteValue.getValue());
		Organization organization = this.getOrganization(newCode);
		List<String> oldCodes = this.convertOldCode(oldCodeArray, newCode);
		Criteria criteriaOldParentCode = new Criteria(Organization.PARENT_CODE, OP.IN, oldCodeArray);
		
		Parameters parameters = new Parameters("operateDetail", this.getOrgName(oldCodeArray) + "被合并为" + organization.getOrganName()).
				add(Organization.STATUS, StatusValue.deleteValue.getValue()).add("operateType", OperateType.merge.getName());
		organizationDao.insertOrganizationLog(new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		organizationDao.update(parameters, new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		organizationDao.update(parametersDelete, new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodes));//中心也当做站
		//某些机构和新的机构不在同一个镇下时解除关系
		deleteOldOrganizationAreaForVillage(organization, oldCodeArray);
		//行政村和机构的关系迁移
		this.updateOrganizationAreaForVillage(oldCodes, oldCodeArray, organizationDao.get(new Criteria(Organization.ORGAN_CODE, newCode)));
		//级联更新 
		organizationDao.update(new Parameters(Organization.PARENT_CODE, newCode).add("GB_CODE", organization.getGbCode()), criteriaOldParentCode);
		//乡镇地段和机构的关系迁移 
		this.updateOrganizationAreaForTown(oldCodeArray, newCode);
	}
	
	/**
	 * 将站迁移到新的机构（中心）下
	 * @param newCode
	 * @param oldCodeArray
	 */
	private void moveOrganization(String newCode, List<String> oldCodeArray) {
		
		List<String> oldStationCode = new ArrayList<String>();
		List<String> oldCentreCode = new ArrayList<String>();
		Organization newOrganization = this.getOrganization(newCode);
		/*站迁移时找出和新中心不在同一个镇下的机构*/
		List<String> notInSameTown = new ArrayList<String>();
		List<Organization> organizationOlds = organizationDao.getList(new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		for(Organization temp : organizationOlds) {
			if(StringUtils.equals(OrgGenreCode.STATION.getValue(), temp.getGenreCode())) {
				oldStationCode.add(temp.getOrganCode());
				Organization parentOrg = this.getOrganization(temp.getParentCode());
				if(ObjectUtil.isNotEmpty(parentOrg) && !StringUtils.equals(newOrganization.getGbCode(), parentOrg.getGbCode())) {
					notInSameTown.add(temp.getOrganCode());
				}
			} else {
				oldCentreCode.add(temp.getOrganCode());
			}
		}
		Parameters parameters = new Parameters("operateDetail", this.getOrgName(oldStationCode) + "被迁移到" + newOrganization.getOrganName())
								.add("operateType", OperateType.move.getName());
		organizationDao.insertOrganizationLog(new Criteria(Organization.ORGAN_CODE, OP.IN, oldStationCode));
		organizationDao.update(parameters, new Criteria(Organization.ORGAN_CODE, OP.IN, oldStationCode));
		
		//将这些站迁移到新的中心机构下
		organizationDao.update(new Parameters(Organization.PARENT_CODE, newCode).add("GB_CODE", newOrganization.getGbCode()),
				new Criteria(Organization.ORGAN_CODE, OP.IN, oldStationCode));
		/*接触某些站和行政村的关系  这些站是和新的机构不在同一个镇下*/
		mdmOrganizationAreaDao.delete(new Criteria("ORGANIZATION_CODE", OP.IN, notInSameTown));
		
		if(ObjectUtil.isNotEmpty(oldCentreCode)) {
			this.mergeSameTypeOrganization(newCode, oldCentreCode);
		}
	}
	
	//行政村和机构的关系迁移
	private void updateOrganizationAreaForVillage(List<String> oldCodes, List<String> oldCodeArray, Organization organization) {
		mdmOrganizationAreaDao.update(new Parameters("organizationCode", organization.getOrganCode()),
				new Criteria("ORGANIZATION_CODE", OP.IN,oldCodeArray).add("AREA_TYPE", AreaType.VILLAGE.getValue()));
		if(StringUtils.equals(organization.getGenreCode(), OrgGenreCode.CENTRE.getValue())) {//中心也当做站
			mdmOrganizationAreaDao.update(new Parameters("organizationCode", "X"+organization.getOrganCode()),
					new Criteria("ORGANIZATION_CODE", OP.IN,oldCodes).add("AREA_TYPE", AreaType.VILLAGE.getValue()));
		} else {
			mdmOrganizationAreaDao.update(new Parameters("organizationCode", organization.getOrganCode()),
					new Criteria("ORGANIZATION_CODE", OP.IN,oldCodes).add("AREA_TYPE", AreaType.VILLAGE.getValue()));
		}
	}
	
	//乡镇地段和机构的关系迁移 
	private void updateOrganizationAreaForTown(List<String> oldCodeArray, String newOrgCode) {
		mdmOrganizationAreaDao.update(new Parameters("organizationCode", newOrgCode),
				new Criteria("ORGANIZATION_CODE", OP.IN, oldCodeArray).add("AREA_TYPE", AreaType.TOWN.getValue()));
	}
		
	private List<String> convertOldCode(List<String> oldCode, String newCode) {
		List<String> oldCodes = new ArrayList<String>();
		for(String code : oldCode) {
			if(StringUtils.isNotEmpty(newCode) && StringUtils.equals(newCode, code)) {
				continue;
			} else {
				oldCodes.add("X" + code);
			}
		}
		return oldCodes;
	}
	
	/**
	 * 根据机构code获取其name，若多个用","分隔
	 * @param codeList
	 * @return
	 */
	private String getOrgName(List<String> codeList) {
		String name = "";
		Criteria criteria = new Criteria(Organization.ORGAN_CODE, OP.IN, codeList);
		List<Organization> list = organizationDao.getList(criteria);
		if (list != null) {
			for (Organization org : list) {
				name += org.getOrganName() + "，";
			}
			if (name.length() > 0) {
				name = name.substring(0, name.length() - 1);
			}
		}
		return name;
	}
	
	/**
	 * Arrays.asList()获取的对象不能使用remove函数
	 * @param old
	 * @return
	 */
	private List<String> getListStr(String[] old) {
		List<String> oldList = new ArrayList<String>();
		for(String str : old ) {
			oldList.add(str);
		}
		return oldList;
	}

	@Override
	public Organization queryOrganByVillage(String villageCode) {
		return organizationDao.queryOrganByVillage(villageCode);
	}

	@Override
	public void sendTownVillageRelation(String townCode,
			String[] newAddVillageCodes) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Organization> sumEquipmentByTown(String gbCode){
		List<Map<String, Object>> list = organizationDao.sumEquipmentByTown(gbCode);
//		List<Map<String, Object>> list = pages.getList();
		List<Organization> organizations = new ArrayList<Organization>();
		for (Map<String, Object> map : list) {
			Organization organization = new Organization();
			organization.setOrganName((String)map.get("organName"));
//            organization.setOrganCode((String)map.get("organCode"));
			organization.setBedCount(Integer.valueOf(String.valueOf(map.get("bedCount") == null ? "0" : map.get("bedCount"))));
			organization.setOpenBedCount(Integer.valueOf(String.valueOf(map.get("openBedCount") == null ? "0" : map.get("openBedCount"))));
			organization.setEquipmentNum(Integer.valueOf(String.valueOf(map.get("equipmentNum") == null ? "0" : map.get("equipmentNum"))));
			organization.setEquipmentNumOne(Integer.valueOf(String.valueOf(map.get("equipmentNumOne") == null ? "0" : map.get("equipmentNumOne"))));
			organization.setEquipmentNumTwo(Integer.valueOf(String.valueOf(map.get("equipmentNumTwo") == null ? "0" : map.get("equipmentNumTwo"))));
			organization.setArea((BigDecimal)(map.get("area") == null ? new BigDecimal(0) : map.get("area")));
			organization.setBusinessArea((BigDecimal)(map.get("businessArea") == null ? new BigDecimal(0) : map.get("businessArea")));
			organization.setDilapidatedRatio((BigDecimal)(map.get("dilapidatedRatio") == null ? new BigDecimal(0) : map.get("dilapidatedRatio")));
			organization.setConstructionArea((BigDecimal)(map.get("constructionArea") == null ? new BigDecimal(0) : map.get("constructionArea")));
			organization.setCompletionArea((BigDecimal)(map.get("completionArea") == null ? new BigDecimal(0) : map.get("completionArea")));
			organizations.add(organization);
		}
		return organizations;
	}

	@Override
	public List<Organization> sumEquipment(String orgType, String gbCode, String organCode, String parentCode) {
		List<Map<String, Object>> list = organizationDao.sumEquipment(orgType, gbCode, organCode, parentCode);
		List<Organization> organizations = new ArrayList<Organization>();
		for (Map<String, Object> map : list) {
			Organization organization = new Organization();
			organization.setOrganName((String)map.get("organName"));
			organization.setBedCount(Integer.valueOf(String.valueOf(map.get("bedCount") == null ? "0" : map.get("bedCount"))));
			organization.setOpenBedCount(Integer.valueOf(String.valueOf(map.get("openBedCount") == null ? "0" : map.get("openBedCount"))));
			organization.setEquipmentNum(Integer.valueOf(String.valueOf(map.get("equipmentNum") == null ? "0" : map.get("equipmentNum"))));
			organization.setEquipmentNumOne(Integer.valueOf(String.valueOf(map.get("equipmentNumOne") == null ? "0" : map.get("equipmentNumOne"))));
			organization.setEquipmentNumTwo(Integer.valueOf(String.valueOf(map.get("equipmentNumTwo") == null ? "0" : map.get("equipmentNumTwo"))));
			organization.setArea((BigDecimal)(map.get("area") == null ? new BigDecimal(0) : map.get("area")));
			organization.setBusinessArea((BigDecimal)(map.get("businessArea") == null ? new BigDecimal(0) : map.get("businessArea")));
			organization.setDilapidatedRatio((BigDecimal)(map.get("dilapidatedRatio") == null ? new BigDecimal(0) : map.get("dilapidatedRatio")));
			organization.setConstructionArea((BigDecimal)(map.get("constructionArea") == null ? new BigDecimal(0) : map.get("constructionArea")));
			organization.setCompletionArea((BigDecimal)(map.get("completionArea") == null ? new BigDecimal(0) : map.get("completionArea")));
			organizations.add(organization);
		}
		return organizations;
	}


	@Override
	public List<Organization> getOrgansRecursion(String organCode) {
		return organizationDao.getOrgansRecursion(organCode);
	}

	/**
	 * 获取机构表中最大的sort为了给新建机构的sort赋值
	 * @return
	 */
	@Override
	public Integer getMaxSort(Criteria criteria) {
		return organizationDao.getMaxSort(criteria);
	}

	@Override
	public Map<String, Object> getEquipmentData() {
		return organizationDao.getEquipmentData();
	}

	@Override
	public List<Organization> sumEquipmentByHospital(Criteria ca) {
		List<Map<String, Object>> list = organizationDao.getHospitalEquipmentData(ca);
//		List<Map<String, Object>> list = pages.getList();
		List<Organization> organizations = new ArrayList<Organization>();
		for (Map<String, Object> map : list) {
			Organization organization = new Organization();
			organization.setOrganCode((String)map.get("ORGAN_CODE"));
			if(BigDecimal.ZERO.equals(map.get("bedCount")) && BigDecimal.ZERO.equals(map.get("openBedCount"))){
				continue;
			}
			organization.setBedCount(Integer.valueOf(String.valueOf(map.get("bedCount") == null ? "0" : map.get("bedCount"))));
			organization.setOpenBedCount(Integer.valueOf(String.valueOf(map.get("openBedCount") == null ? "0" : map.get("openBedCount"))));
			organization.setEquipmentNum(Integer.valueOf(String.valueOf(map.get("equipmentNum") == null ? "0" : map.get("equipmentNum"))));
			organization.setEquipmentNumOne(Integer.valueOf(String.valueOf(map.get("equipmentNumOne") == null ? "0" : map.get("equipmentNumOne"))));
			organization.setEquipmentNumTwo(Integer.valueOf(String.valueOf(map.get("equipmentNumTwo") == null ? "0" : map.get("equipmentNumTwo"))));
			organization.setArea((BigDecimal)(map.get("area") == null ? new BigDecimal(0) : map.get("area")));
			organization.setBusinessArea((BigDecimal)(map.get("businessArea") == null ? new BigDecimal(0) : map.get("businessArea")));
			organization.setDilapidatedRatio((BigDecimal)(map.get("dilapidatedRatio") == null ? new BigDecimal(0) : map.get("dilapidatedRatio")));
			organization.setConstructionArea((BigDecimal)(map.get("constructionArea") == null ? new BigDecimal(0) : map.get("constructionArea")));
			organization.setCompletionArea((BigDecimal)(map.get("completionArea") == null ? new BigDecimal(0) : map.get("completionArea")));
			organizations.add(organization);
		}
		return organizations;
	}
}