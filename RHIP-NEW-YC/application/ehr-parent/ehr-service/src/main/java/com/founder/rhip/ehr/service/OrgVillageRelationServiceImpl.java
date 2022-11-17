package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.OrgVillageRelation;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.repository.IOrgVillageRelationDao;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("orgVillageRelationService")
@TaskBean(cron = "0 0 4 * * ?", description = "行政区划机构区划历史记录定时任务")
public class OrgVillageRelationServiceImpl extends AbstractService implements
        IOrgVillageRelationService, Task {

	private static int ORG_AREA_HISTORY = 1;
	private static int ADMINISTRATIVE_AREA_HISTORY = 2;

	@Resource(name = "orgVillageRelationDao")
	private IOrgVillageRelationDao orgVillageRelationDao;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;

	@Override
	public void run(Map<String, Object> data) {
		Object param = data.get(TaskConstants.TASK_PARAM_KEY); // 参数格式yyyy 年份如2016
		Integer year = null;
		if(ObjectUtil.isNotEmpty(param)){
			year = NumberUtil.convert(param.toString(),Integer.class);
		}
		if(ObjectUtil.isNullOrEmpty(year)){
			year = DateUtil.getCurrentYear();
		}
		saveRelation(year);
	}

	/**
	 * 保存历史记录
	 */
	@Transactional
	private void saveRelation(Integer year){
		//所有机构区划历史记录
		Criteria criteria = new Criteria("GENRE_CODE", OrgGenreCode.STATION.getValue());
		criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		criteria.add(Organization.ORGAN_CODE, OP.NE, "320000000");
		List<Organization> stations = organizationService.getOrganizations(criteria);//获取卫生服站
		for(Organization org:stations){
			saveOrgAreaRelation(org.getOrganCode(),year);
		}

		//所有行政区划历史记录
		List<DicItem> towns = dictionaryApp.queryDicItems("FS990001", "320581000000");
		for(DicItem dicItem:towns){
			saveAdministrativeAreaRelation(dicItem.getItemCode(),year);
		}
	}
	/**
	 * 保存机构区划当年历史记录
	 * @param organCode
	 * @return
     */
	@Override
	public Boolean saveOrgAreaRelation(String organCode,Integer year) {
		//修改之前先清空以前的关系
		Criteria criteria = new Criteria("ORGAN_CODE", organCode);
		criteria.add("year",year);
		criteria.add("type",ORG_AREA_HISTORY);
		orgVillageRelationDao.delete(criteria);

		List<OrganizationArea> villages = organizationService.getOrganizationAreas(new Criteria("ORGANIZATION_CODE", organCode));
		List<OrgVillageRelation> orgVillageRelations = new ArrayList<>();
		for(OrganizationArea organizationArea:villages){
			OrgVillageRelation relation = new OrgVillageRelation();
			relation.setYear(year);
			relation.setOrganCode(organCode);
			relation.setType(ORG_AREA_HISTORY);
			relation.setVillageCode(organizationArea.getAreaCode());
			relation.setVillageName(dictionaryApp.queryDicItemName("FS990001", organizationArea.getAreaCode()));
			relation.setCreateTime(new Date());
			orgVillageRelations.add(relation);
		}
		orgVillageRelationDao.batchInsert(orgVillageRelations);
		return true;
	}

	/**
	 * 保存行政区划当年历史记录
	 * @param townCode
	 * @return
     */
	@Override
	public Boolean saveAdministrativeAreaRelation(String townCode,Integer year) {
		//修改之前先清空以前的关系
		Criteria criteria = new Criteria("TOWN_CODE", townCode);
		criteria.add("year",year);
		criteria.add("type",ADMINISTRATIVE_AREA_HISTORY);
		orgVillageRelationDao.delete(criteria);

		List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", townCode);
		List<OrgVillageRelation> orgVillageRelations = new ArrayList<>();
		for(DicItem dicItem:villages){
			OrgVillageRelation relation = new OrgVillageRelation();
			relation.setYear(year);
			relation.setTownCode(townCode);
			relation.setType(ADMINISTRATIVE_AREA_HISTORY);
			relation.setVillageCode(dicItem.getItemCode());
			relation.setVillageName(dicItem.getItemName());
			relation.setCreateTime(new Date());
			orgVillageRelations.add(relation);
		}
		orgVillageRelationDao.batchInsert(orgVillageRelations);
		return true;
	}

	/**
	 * 按年度获取机构区划或者行政区划历史数据
	 * type 1:行政区划历史 2：机构区划历史
	 * @param year
	 * @param type
     * @return
     */
	@Override
	public List<OrgVillageRelation> getRelation(String organCode,Integer year, Integer type) {
		Criteria ca = new Criteria();
		ca.add("year",year);
		ca.add("type",type);
		if(type.equals(ORG_AREA_HISTORY)){
			ca.add("organCode",organCode);
		}else{
			ca.add("townCode",organCode);
		}
		return orgVillageRelationDao.getList(ca,new Order("VILLAGE_CODE"));
	}
}
