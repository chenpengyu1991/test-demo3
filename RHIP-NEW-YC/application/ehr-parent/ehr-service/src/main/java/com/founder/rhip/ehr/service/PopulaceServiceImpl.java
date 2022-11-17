/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.Order;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.woman.IDeliveryService;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.CommunityInfoDTO;
import com.founder.rhip.ehr.entity.basic.OrganizationEconomicRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationEnvironmentRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationGarbageRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationOldPeopleHomeRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationSchoolRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationWaterRelation;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.ehr.repository.basic.IOrganizationEconomicRelationDao;
import com.founder.rhip.ehr.repository.basic.IOrganizationEnvironmentRelationDao;
import com.founder.rhip.ehr.repository.basic.IOrganizationGarbageRelationDao;
import com.founder.rhip.ehr.repository.basic.IOrganizationOldPeopleHomedRelationDao;
import com.founder.rhip.ehr.repository.basic.IOrganizationSchoolRelationDao;
import com.founder.rhip.ehr.repository.basic.IOrganizationWaterRelationDao;
import com.founder.rhip.ehr.repository.basic.IPopulaceDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;

@Service("populaceService")
public class PopulaceServiceImpl extends AbstractService implements IPopulaceService {

    @Resource(name="populaceDao")
    private IPopulaceDao populaceDao;
    
    @Resource(name="mdmOrganizationDao")
    private IOrganizationDao organizationDao;
    
    @Resource(name="organizationWaterRelationDao")
	private IOrganizationWaterRelationDao organizationWaterRelationDao;

    @Resource(name="organizationEnvironmentRelationDao")
	private IOrganizationEnvironmentRelationDao organizationEnvironmentRelationDao;
    
    @Resource(name="organizationGarbageRelationDao")
	private IOrganizationGarbageRelationDao organizationGarbageRelationDao;
    
    @Resource(name = "organizationEconomicRelationDao")
	private IOrganizationEconomicRelationDao organizationEconomicRelationDao;
    
    @Resource(name = "organizationSchoolRelationDao")
   	private IOrganizationSchoolRelationDao organizationSchoolRelationDao;
    
    @Resource(name = "organizationOldPeopleHomedRelationDao")
   	private IOrganizationOldPeopleHomedRelationDao organizationOldPeopleHomedRelationDao;
    
    @Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Autowired
	private IDeliveryService deliveryService;

    @Override
    @Transactional
    public void saveOrUpdatePopulace(Populace populace) {

        Populace populaceByYear = populaceDao.get(new Criteria("countYear", populace.getCountYear()).add("organizationId", populace.getOrganizationId()));

        if(null == populaceByYear){
            Long populaceId = populaceDao.generatedKey(populace,"ID",null).longValue();
            populace.setId(populaceId);
            populaceDao.update(populace);
            return;
        }
        populaceDao.update(populace);
    }

    /**
	 * 人口分类统计
 	 * @param       …
	 * @return      Map<String,String>
	 */
	public Map<String,String> getPoulaceStatistic(String... gBCodes) {
		Map<String,String> result = null;
		//TODO
		return result;
	}

    @Override
    public CommunityInfoDTO getPopulaceByOrganization(Organization organization) {
    	CommunityInfoDTO communityInfoDTO = new CommunityInfoDTO();
    	Populace populace = getPopulaceByCurrentYearAndOrganization(organization);
    	communityInfoDTO.setPopulace(populace);
        return communityInfoDTO;
    }
    
    @Override
	public CommunityInfoDTO getBasicInfoByOrganization(Organization organization) {
    	CommunityInfoDTO communityInfoDTO = new CommunityInfoDTO();
    	Criteria criteria = new Criteria("organizationId", organization.getOrganId());
    	List<OrganizationWaterRelation> orgWaterRelations = organizationWaterRelationDao.getList(criteria);
    	List<OrganizationEnvironmentRelation> orgEnvironmentRelations = organizationEnvironmentRelationDao.getList(criteria);
    	List<OrganizationGarbageRelation> orgGarbageRelations = organizationGarbageRelationDao.getList(criteria);
    	OrganizationSchoolRelation orgSchoolRelation = organizationSchoolRelationDao.get(criteria);
    	OrganizationOldPeopleHomeRelation orgOldPeopleHomeRelation = organizationOldPeopleHomedRelationDao.get(criteria);
    	OrganizationEconomicRelation orgEconomicRelation = organizationEconomicRelationDao.get(criteria);
    	if(ObjectUtil.isNotEmpty(orgWaterRelations)){
    		communityInfoDTO.setOrgWatersRelations(orgWaterRelations);
    	}
    	if(ObjectUtil.isNotEmpty(orgEnvironmentRelations)){
    		communityInfoDTO.setOrgEnvironmentRelations(orgEnvironmentRelations);
    	}
    	if(ObjectUtil.isNotEmpty(orgGarbageRelations)){
    		communityInfoDTO.setOrgGarbageRelations(orgGarbageRelations);
    	}
    	if(ObjectUtil.isNotEmpty(orgSchoolRelation) && ObjectUtil.isNotEmpty(orgSchoolRelation.getSchool())){
    		communityInfoDTO.setSchool(orgSchoolRelation.getSchool());
    	}
    	if(ObjectUtil.isNotEmpty(orgOldPeopleHomeRelation) && ObjectUtil.isNotEmpty(orgOldPeopleHomeRelation.getOldPeopleHome())){
    		communityInfoDTO.setOldPeopleHome(orgOldPeopleHomeRelation.getOldPeopleHome());
    	}
    	if(ObjectUtil.isNotEmpty(orgEconomicRelation) && ObjectUtil.isNotEmpty(orgEconomicRelation.getEconomic())){
    		communityInfoDTO.setEconomic(orgEconomicRelation.getEconomic());
    	}
    	organization = organizationDao.get(new Criteria("organId", organization.getOrganId()));
    	communityInfoDTO.setOrganization(organization);
		return communityInfoDTO;
	}

    private Populace getPopulaceByCurrentYearAndOrganization(Organization organization) {
        Criteria criteria = new Criteria();
        criteria.add("organCode", organization.getOrganCode()).add("countYear", DateUtil.getCurrentYear());
        return populaceDao.get(criteria);
    }
    
	public Map<String,Long> getPopulaceInfo(Organization organ){
		List<String> orgCodes = new ArrayList<>();
		Criteria criteria = new Criteria();
		List<Organization> organizations = new ArrayList<>();
		if(ObjectUtil.isNotEmpty(organ)){
			if(organ.getGenreCode().equals("R11")){
				organizations = organizationDao.getList(new Criteria("genreCode", OP.IN,new String[]{"B1","B2"}).add("gbCode",organ.getGbCode()));
			}else {
				organizations = organizationDao.getList(new Criteria(Organization.PARENT_CODE, organ.getOrganCode()));
			}
			if(ObjectUtil.isNotEmpty(organizations)){
				for (Organization organization : organizations) {
					orgCodes.add(organization.getOrganCode());
				}
				criteria.add("organCode", OP.IN, orgCodes);
			}
		}
		criteria.add("countYear", DateUtil.getCurrentYear());
		List<Populace> populaceList = populaceDao.getList(criteria);
		Long totalPopulace = 0l ;//总人口
		Long householdManNum = 0l;//常住男
		Long unHouseholdManNum = 0l;//临时男
		Long householdWomanNum = 0l;//常住女
		Long unHouseholdWomanNum = 0l;//临时女
		Long houseHoldNum = 0l;//常住
		Long unHouseHoldNum = 0l;//临时
		Long householdSixChildNum = 0l;//常住儿童
		Long unHouseholdSixChildNum = 0l;//临时儿童
		Long householdFertileWomanNum = 0l;//常住育龄
		Long unHouseholdFertileWomanNum = 0l;//临时育龄
		Long householdSixoToSixfNum = 0l;//常住60以下老人
		Long unHouseholdSixoToSixfNum = 0l;//临时60以下老人
		Long householdGreatSixfNum = 0l;//常住65以上老人
		Long unHouseholdGreatSixfNum = 0l;//临时65以上老人

		Long householdPhbNum = 0l;//户籍高血压患者
		Long unhouseholdPhbNum = 0l;//非户籍高血压患者
		Long householdDiNum = 0l;//户籍糖尿病患者
		Long unhouseholdDiNum = 0l;//非户籍糖尿病患者
		Long householdMentalNum = 0l;//户籍精神疾病患者
		Long unhouseholdMentalNum = 0l;//非户籍精神疾病患者
		if(null != populaceList && populaceList.size() > 0){
			for (Populace populace : populaceList) {
				Long HouseholdNumValue = 0l;
				Long UnHouseHoldNumValue = 0l;
				if(null != populace.getHouseholdNum()){
					HouseholdNumValue = Long.parseLong(populace.getHouseholdNum().toString());
				}
				if(null != populace.getUnHouseHoldNum()){
					UnHouseHoldNumValue = Long.parseLong(populace.getUnHouseHoldNum().toString());
				}
				Long total = HouseholdNumValue + UnHouseHoldNumValue;
				totalPopulace = totalPopulace + total;
				if(null != populace.getHouseholdManNum()){
					householdManNum = householdManNum + populace.getHouseholdManNum();
				}
				if(null != populace.getHouseholdWomanNum()){
					householdWomanNum = householdWomanNum + populace.getHouseholdWomanNum();
				}
				if(null != populace.getUnHouseholdManNum()){
					unHouseholdManNum = unHouseholdManNum + populace.getUnHouseholdManNum();
				}
				if(null != populace.getUnHouseholdWomanNum()){
					unHouseholdWomanNum = unHouseholdWomanNum + populace.getUnHouseholdWomanNum();
				}
				if(null != populace.getHouseholdNum()){
					houseHoldNum = houseHoldNum + populace.getHouseholdNum();
				}
				if(null != populace.getUnHouseHoldNum()){
					unHouseHoldNum = unHouseHoldNum + populace.getUnHouseHoldNum();
				}
				if(null != populace.getUnHouseHoldNum()){
					unHouseHoldNum = unHouseHoldNum + populace.getUnHouseHoldNum();
				}
				if(null != populace.getHouseholdSixChildNum()){
					householdSixChildNum = householdSixChildNum + populace.getHouseholdSixChildNum();
				}
				if(null != populace.getUnHouseholdSixChildNum()){
					unHouseholdSixChildNum = unHouseholdSixChildNum + populace.getUnHouseholdSixChildNum();
				}
				if(null != populace.getHouseholdFertileWomanNum()){
					householdFertileWomanNum = householdFertileWomanNum + populace.getHouseholdFertileWomanNum();
				}
				if(null != populace.getUnHouseholdFertileWomanNum()){
					unHouseholdFertileWomanNum = unHouseholdFertileWomanNum + populace.getUnHouseholdFertileWomanNum();
				}
				if(null != populace.getHouseholdSixoToSixfNum()){
					householdSixoToSixfNum = householdSixoToSixfNum + populace.getHouseholdSixoToSixfNum();
				}
				if(null != populace.getUnHouseholdSixoToSixfNum()){
					unHouseholdSixoToSixfNum = unHouseholdSixoToSixfNum + populace.getUnHouseholdSixoToSixfNum();
				}
				if(null != populace.getHouseholdGreatSixfNum()){
					householdGreatSixfNum = householdGreatSixfNum + populace.getHouseholdGreatSixfNum();
				}
				if(null != populace.getUnHouseholdGreatSixfNum()){
					unHouseholdGreatSixfNum = unHouseholdGreatSixfNum + populace.getUnHouseholdGreatSixfNum();
				}
				if(null != populace.getHouseholdPhbNum()){
					householdPhbNum = householdPhbNum + populace.getHouseholdPhbNum();
				}
				if(null != populace.getUnhouseholdPhbNum()){
					unhouseholdPhbNum = unhouseholdPhbNum + populace.getUnhouseholdPhbNum();
				}
				if(null != populace.getHouseholdDiNum()){
					householdDiNum = householdDiNum + populace.getHouseholdDiNum();
				}
				if(null != populace.getUnhouseholdDiNum()){
					unhouseholdDiNum = unhouseholdDiNum + populace.getUnhouseholdDiNum();
				}
				if(null != populace.getHouseholdMentalNum()){
					householdMentalNum  = householdMentalNum + populace.getHouseholdMentalNum();
				}
				if(null != populace.getUnhouseholdMentalNum()){
					unhouseholdMentalNum = unhouseholdMentalNum + populace.getUnhouseholdMentalNum();
				}
			}
		}
		Map<String,Long> populaceMap = new HashMap<String,Long>();
		populaceMap.put("totalPopulace", totalPopulace);
		populaceMap.put("houseHoldManNum", householdManNum);
		populaceMap.put("unHouseholdManNum", unHouseholdManNum);
		populaceMap.put("houseHoldWomanNum", householdWomanNum);
		populaceMap.put("unHouseholdWomanNum", unHouseholdWomanNum);
		populaceMap.put("houseHoldNum", houseHoldNum);
		populaceMap.put("unHouseHoldNum", unHouseHoldNum);
		populaceMap.put("householdSixChildNum", householdSixChildNum);
		populaceMap.put("unHouseholdSixChildNum", unHouseholdSixChildNum);
		populaceMap.put("householdFertileWomanNum", householdFertileWomanNum);
		populaceMap.put("unHouseholdFertileWomanNum", unHouseholdFertileWomanNum); 
		populaceMap.put("householdSixoToSixfNum", householdSixoToSixfNum); 
		populaceMap.put("unHouseholdSixoToSixfNum", unHouseholdSixoToSixfNum); 
		populaceMap.put("householdGreatSixfNum", householdGreatSixfNum); 
		populaceMap.put("unHouseholdGreatSixfNum", unHouseholdGreatSixfNum);

		populaceMap.put("householdPhbNum", householdPhbNum);
		populaceMap.put("unhouseholdPhbNum", unhouseholdPhbNum);
		populaceMap.put("householdDiNum", householdDiNum);
		populaceMap.put("unhouseholdDiNum", unhouseholdDiNum);
		populaceMap.put("householdMentalNum", householdMentalNum);
		populaceMap.put("unhouseholdMentalNum", unhouseholdMentalNum);
		return populaceMap;
	}

	@Override
	public Map<String,Long> getPopulaceByYear() {
		Map<String,Long> populaceMap = this.getPopulaceInfo(null);
		return populaceMap;
	}

	@Override
	public List<Populace> getOrganizationPopulaceListByYear(String gBCode, String organCode,String countYear) {
		List<Populace> populaceList = new ArrayList<>();
		List<String> orgCodes = new ArrayList<String>();
		Criteria criteria = new Criteria();
		//0137834中心需要维护人口数  查询站
		//机构条件：镇、中心/站
		if(ObjectUtil.isNotEmpty(organCode)){
			orgCodes.add(organCode);
			Criteria orgCri = new Criteria("organCode",organCode);
			orgCri.add(LOP.OR,"parentCode",organCode);
			criteria.add(orgCri);
		}else if(ObjectUtil.isNotEmpty(gBCode)){
			criteria.add("gbCode", gBCode);
		}
		criteria.add("genreCode", OP.IN,new String[]{OrgGenreCode.STATION.getValue(), OrgGenreCode.CENTRE.getValue()});
		//查询卫生院/卫生站
		Order order = new Order("GENRE_CODE").asc("ORGAN_CODE");
		List<Organization> organizationList = organizationApp.queryOrganization(criteria,order);
		if(ObjectUtil.isNotEmpty(organizationList)){
			for (Organization organization : organizationList) {
				orgCodes.add(organization.getOrganCode());
			}
		}
		//卫生站有人口统计
		populaceList = populaceDao.getList(new Criteria("organCode",OP.IN, orgCodes).add("countYear", countYear),new Order("ORGAN_CODE"));//当年
		//补全POPLUCE里面没有站所在的中心code
		if(ObjectUtil.isNotEmpty(populaceList)){
			for (Populace populace : populaceList) {
				Organization org = organizationApp.queryOrgan(populace.getOrganCode());
				populace.setOrganParentCode(org.getParentCode());
				/*populaceDao.update(populace, "organParentCode");*/
			}
			populaceDao.batchUpdate(populaceList,"organParentCode");
		}

		Set<String> orgCodeList = new HashSet<>();
		if(ObjectUtil.isNotEmpty(populaceList)){
			for (Populace populace : populaceList) {
				orgCodeList.add(populace.getOrganCode());
			}
		}
		List<Organization> orgOtherList= new ArrayList<>();
		//找出当年没有人口统计的卫生站的orgCode
		for (Organization organization : organizationList) {
			if(!orgCodeList.contains(organization.getOrganCode())){
				orgOtherList.add(organization);
			}
		}
		
		//补全没有人口统计的站的人口统计信息
		if(ObjectUtil.isNotEmpty(orgOtherList)){
			for (Organization organization : orgOtherList) {
				Criteria lastYear = new Criteria().add("countYear", DateUtil.getCurrentYear() - 1);//上年
				lastYear.add("organCode", organization.getOrganCode());
				Populace populace = populaceDao.get(lastYear);
				if(null != populace){
					populace.getOrganName();
					if(ObjectUtil.isNotEmpty(countYear)){
						populace.setCountYear(Integer.parseInt(countYear));	
					}
					populace.setGbcode(gBCode);
					populace.setOrganParentCode(organization.getParentCode());
					populaceList.add(populace);
					Number id=populaceDao.generatedKey(populace,"ID",null);
                    populace.setId(id.longValue());
				}else {
					Populace newPopulace = new Populace();
					newPopulace.setOrganName(organization.getOrganName());
					newPopulace.setOrganCode(organization.getOrganCode());
					if(ObjectUtil.isNotEmpty(countYear)){
						newPopulace.setCountYear(Integer.parseInt(countYear));	
					}
					newPopulace.setGbcode(gBCode);
					newPopulace.setOrganParentCode(organization.getParentCode());
					populaceList.add(newPopulace);
                    Number id=populaceDao.generatedKey(newPopulace,"ID",null);
                    newPopulace.setId(id.longValue());
				}
			}
		}
		return populaceList;
	}

	@Override
	@Transactional
	public void updateOrSavePopulace(List<Populace> populaces, String[] properties,String gbCode,String organCode) {
		List<Populace> populaceUpdates = new ArrayList<Populace>();
		for (Populace populace : populaces) {
			if (ObjectUtil.isNotEmpty(populace)) {
				populaceUpdates.add(populace);
                Organization org = organizationDao.get(new Criteria(Organization.ORGAN_CODE, populace.getOrganCode()));
                if (null!=org){
                    populace.setOrganParentCode(org.getParentCode());
                    populace.setGbcode(org.getGbCode());
                }else {
                    log.error("人口分布保存,无法获取指定机构,机构编码为:"+populace.getOrganCode());
                }
			}
		}
		populaceDao.batchUpdate(populaceUpdates, properties);
	}
	
	@Override
	public Map<String, Long> getPopulaceByYearAndOrgCode(Organization org) {
		Map<String,Long> populaceMap = this.getPopulaceInfo(org);
		return populaceMap;
	}
	
	@Override
	public List<Populace> getHealthManagementPopulaceListByYear(String superOrgCode) {
		List<Populace> populaceList = new ArrayList<Populace>();
		//拿到卫生院下面的卫生站
		List<Organization> organizationList = organizationDao.getList(new Criteria("parentCode", superOrgCode).add("genreCode", "B2"));
		List<String> orgCodes = new ArrayList<String>();
		if(ObjectUtil.isNotEmpty(organizationList)){
			for (Organization organization : organizationList) {
				orgCodes.add(organization.getOrganCode());
			}
		}
		//卫生站有人口统计
		populaceList = populaceDao.getList(new Criteria("organCode",OP.IN, orgCodes).add("countYear", DateUtil.getCurrentYear()));//当年
		List<String> orgCodeList = new ArrayList<String>();
		if(ObjectUtil.isNotEmpty(populaceList)){
			for (Populace populace : populaceList) {
				orgCodeList.add(populace.getOrganCode());
			}
		}
		List<Organization> orgOtherList = new ArrayList<Organization>();
		//找出当年没有人口统计的卫生站的orgCode
		for (Organization organization : organizationList) {
			if(!orgCodeList.contains(organization.getOrganCode())){
				orgOtherList.add(organization);
			}
		}
		//补全没有人口统计的站的人口统计信息
		if(ObjectUtil.isNotEmpty(orgOtherList)){
			for (Organization organization : orgOtherList) {
				Criteria lastYear = new Criteria().add("countYear", DateUtil.getCurrentYear() - 1);//上年
				lastYear.add("organCode", organization.getOrganCode());
				Populace populace = populaceDao.get(lastYear);
				if(null != populace){
					populace.getOrganName();
					populace.setCountYear(DateUtil.getCurrentYear());
					populaceList.add(populace);
					populaceDao.insert(populace);
				}else {
					Populace newPopulace = new Populace();
					newPopulace.setOrganName(organization.getOrganName());
					newPopulace.setOrganCode(organization.getOrganCode());
					newPopulace.setCountYear(DateUtil.getCurrentYear());
					populaceList.add(newPopulace);
					populaceDao.insert(newPopulace);
				}
			}
		}
		return populaceList;
	}

	@Override
	public List<Populace> getPopulaces(Criteria criteria) {
		return populaceDao.getList(criteria);
	}

	@Override
	public Integer getPopulaceNum(Criteria criteria,String countPropertyName) {
		return populaceDao.getSum(criteria, countPropertyName, Integer.class);
	}

	@Override
	@Transactional
	public void insertPopulaceInfo(Populace populace) {
		populaceDao.insert(populace);
	}

	@Override
	@Transactional
	public void deletePopulaceInfo(Criteria criteria) {
		populaceDao.delete(criteria);
	}
	
	/**
     * 根据镇 中心统计人口
     * @param
     * @return
     */
	@Override
    public List<Populace> getTarget(String gbCode, String organCode, Integer countYear, String genreCode) {
    	return populaceDao.getTarget(gbCode, organCode, countYear, genreCode);
    }

	public List<Populace> getPopolaceReport(Criteria criteria){
		List<Map<String, Object>> mapList = populaceDao.getPopolaceReport(criteria);
		//活产数
		List<Map<String,Object>> deliveryMapList = deliveryService.liveBirthNum(criteria);
		List<Populace> populaceList = new ArrayList<>();
		for(Map<String,Object> map: mapList){
			Populace populace = new Populace();
            String a = (String) map.get("orgCode");
            if(!criteria.get("countTotal").equals("1")){//合计
                populace.setOrganCode((String) map.get("orgCode"));
            }
			populace.setTotal(Integer.parseInt(map.get("total").toString()));
			populace.setElderNum(Integer.parseInt(map.get("elder").toString()));
			populace.setPhbNum(Integer.parseInt(map.get("phb").toString()));
			populace.setDiNum(Integer.parseInt(map.get("di").toString()));
			populace.setPsychosisNum(Integer.parseInt(map.get("mental").toString()));
			populace.setIdentificationNum(Integer.parseInt(map.get("identificationNum").toString()));
			populace.setChildNum(Integer.parseInt(map.get("childNum").toString()));
			populace.setMaternalNum(Integer.parseInt(map.get("maternalNum").toString()));
			//活产数
            if(criteria.get("countTotal").equals("1")){//合计
                populace.setLiveBirth(Integer.parseInt(deliveryMapList.get(0).get("liveBirthNum").toString()));
            }else{
                for(Map<String,Object> deliveryMap: deliveryMapList){
                    if(populace.getOrganCode().equals(deliveryMap.get("CREATE_ORGAN_CODE"))){
                        populace.setLiveBirth(Integer.parseInt(deliveryMap.get("liveBirthNum").toString()));
                    }
                }
            }
			populaceList.add(populace);
		}
		return populaceList;
	}

	/**
	 * 获取人口总数
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> getTotalCountByYear(Criteria criteria) {
		return populaceDao.getTotalCountByYear(criteria);
	}
}