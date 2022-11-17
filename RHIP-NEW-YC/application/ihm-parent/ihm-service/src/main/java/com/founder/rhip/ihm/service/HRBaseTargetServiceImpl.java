/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.ihm.IHRBaseTargetDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("hrBaseTargetService")
public class HRBaseTargetServiceImpl extends AbstractService implements IHRBaseTargetService {

	@Resource(name = "hrBaseTargetDao")
    private IHRBaseTargetDao hrBaseTargetDao; 
	
	@Resource(name="mdmDictionaryService")
    private IDictionaryService dictionaryService;
	
	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<Map<String, Object>> getHealthTargetList(String organCode, String superOrganCode, String gbCode, String genreCode) {
		List<Map<String, Object>> organs = getQueryOrgans(genreCode, gbCode, superOrganCode, organCode);
		List<Map<String, Object>> result = hrBaseTargetDao.getHealthTargetList(organCode, superOrganCode, gbCode, genreCode);
		if(null != result && result.size() > 0)
		{
			String name = "ORGAN_NAME";
			String code = "ORGAN_CODE";
			List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
			for(Map<String, Object> map: result)
			{
				Set<String> set = map.keySet();
				int countRow = 0;
				for(String key: set)
				{
					if(!name.equalsIgnoreCase(key) && !code.equalsIgnoreCase(key))
					{
						countRow = Integer.valueOf(map.get(key).toString()) + countRow;
					}
					
				}
				
				map.put("COUNT_ROW", countRow);
				tempList.add(map);
			}
			
			Set<String> keySet = tempList.get(0).keySet();
			Map<String, Object> countColMap = new HashMap<String, Object>();
			for(String key: keySet)
			{
				int countCol = 0;
				if(!name.equalsIgnoreCase(key) && !code.equalsIgnoreCase(key))
				{
					for(Map<String, Object> map: tempList)
					{
						countCol = Integer.valueOf(map.get(key).toString()) + countCol;
					}
					
					countColMap.put(key, countCol);
				}
			}
			
			//补充机构,没有的按0显示
			for(Map<String, Object> organ : organs){
				boolean flag = false;
				for(Map<String, Object> statis : tempList){
				    if(organ.get("ORGAN_CODE").equals(statis.get("ORGAN_CODE"))){
				    	flag = true;
				    	break;
				    }
				}
				if(!flag){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("ORGAN_CODE", organ.get("ORGAN_CODE"));
					map.put("ORGAN_NAME",organ.get("ORGAN_NAME"));
					map.put("COUNT1", 0);
					map.put("COUNT2", 0);
					map.put("COUNT3", 0);
					map.put("COUNT4", 0);
					map.put("COUNT5", 0);
					map.put("COUNT6", 0);
					map.put("COUNT7", 0);
					map.put("COUNT8", 0);
					map.put("COUNT9", 0);
					map.put("COUNT10", 0);
					map.put("COUNT11", 0);
					map.put("COUNT12", 0);
					tempList.add(map);
				}
			}
			countColMap.put(name, "<b>合计</b>");
			tempList.add(countColMap);
			return tempList;
		}else{
			List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
			//补充机构,没有的按0显示
			for(Map<String, Object> organ : organs){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("ORGAN_CODE", organ.get("ORGAN_CODE"));
				map.put("ORGAN_NAME",organ.get("ORGAN_NAME"));
				map.put("COUNT1", 0);
				map.put("COUNT2", 0);
				map.put("COUNT3", 0);
				map.put("COUNT4", 0);
				map.put("COUNT5", 0);
				map.put("COUNT6", 0);
				map.put("COUNT7", 0);
				map.put("COUNT8", 0);
				map.put("COUNT9", 0);
				map.put("COUNT10", 0);
				map.put("COUNT11", 0);
				map.put("COUNT12", 0);
				tempList.add(map);
			}
			Map<String, Object> countColMap = new HashMap<String, Object>();
			countColMap.put("ORGAN_NAME", "<b>合计</b>");
			countColMap.put("COUNT1", 0);
			countColMap.put("COUNT2", 0);
			countColMap.put("COUNT3", 0);
			countColMap.put("COUNT4", 0);
			countColMap.put("COUNT5", 0);
			countColMap.put("COUNT6", 0);
			countColMap.put("COUNT7", 0);
			countColMap.put("COUNT8", 0);
			countColMap.put("COUNT9", 0);
			countColMap.put("COUNT10", 0);
			countColMap.put("COUNT11", 0);
			countColMap.put("COUNT12", 0);
			tempList.add(countColMap); 
			return tempList;
		}
	}
	
	/**
     * 获取要统计的机构
     * @param genreCode
     * @param gbCode
     * @param superOrganCode
     * @param organCode
     * @return
     */
    private List<Map<String,Object>> getQueryOrgans(String genreCode, String gbCode, String superOrganCode, String organCode){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();

        if("A100".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "A100");
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("organCode", superOrganCode);
            }
            criteria.add("SUBSID", "0");
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("B100".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "B100");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("organCode", superOrganCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("B200".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "B200");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("parentCode", superOrganCode);
            }
            if(StringUtil.isNotEmpty(organCode)){
                criteria.add("organCode", organCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }if("G2".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "G2");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("parentCode", superOrganCode);
            }
            if(StringUtil.isNotEmpty(organCode)){
                criteria.add("organCode", organCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("0".equals(genreCode)){
            result = getGbCodes(new Criteria("gbCode", gbCode));
        }
        return result;
    }

    private List<Map<String,Object>> MapOrgans(List<Organization> organizations){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for(Organization organization : organizations){
            Map orgMap = new HashMap();
            orgMap.put("ORGAN_CODE", organization.getOrganCode());
            orgMap.put("ORGAN_NAME", organization.getOrganName());
            result.add(orgMap);
        }
        return result;
    }


    @Override
    public List<Map<String, Object>> getPracticeList(String organCode, String superOrganCode, String gbCode, String genreCode) {
        List<Map<String, Object>> organs = getQueryOrgans(genreCode, gbCode, superOrganCode, organCode);
        List<Map<String, Object>> result = hrBaseTargetDao.getPracticeList(organCode, superOrganCode, gbCode, genreCode);
        if(null != result && result.size() > 0)
        {
            String name = "ORGAN_NAME";
            String code = "ORGAN_CODE";
            List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
            for(Map<String, Object> map: result)
            {
                Set<String> set = map.keySet();
                int countRow = 0;
                for(String key: set)
                {
                    if(!name.equalsIgnoreCase(key) && !code.equalsIgnoreCase(key))
                    {
                        countRow = Integer.valueOf(map.get(key).toString()) + countRow;
                    }

                }
                map.put("COUNT_ROW", countRow);
                tempList.add(map);
            }

            Set<String> keySet = tempList.get(0).keySet();
            Map<String, Object> countColMap = new HashMap<String, Object>();
            for(String key: keySet)
            {
                int countCol = 0;
                if(!name.equalsIgnoreCase(key) && !code.equalsIgnoreCase(key))
                {
                    for(Map<String, Object> map: tempList)
                    {
                        countCol = Integer.valueOf(map.get(key).toString()) + countCol;
                    }

                    countColMap.put(key, countCol);
                }
            }

            //补充机构,没有的按0显示
            for(Map<String, Object> organ : organs){
                boolean flag = false;
                for(Map<String, Object> statis : tempList){
                    if(organ.get("ORGAN_CODE").equals(statis.get("ORGAN_CODE"))){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("ORGAN_CODE", organ.get("ORGAN_CODE"));
                    map.put("ORGAN_NAME",organ.get("ORGAN_NAME"));
                    map.put("COUNT1", 0);
                    map.put("COUNT2", 0);
                    map.put("COUNT3", 0);
                    map.put("COUNT4", 0);
                    map.put("COUNT5", 0);
                    map.put("COUNT6", 0);
                    map.put("COUNT7", 0);
                    map.put("COUNT8", 0);
                    map.put("COUNT9", 0);
                    map.put("COUNT10", 0);
                    tempList.add(map);
                }
            }
            countColMap.put(name, "<b>合计</b>");
            tempList.add(countColMap);
            return tempList;
        }else{
            List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
            //补充机构,没有的按0显示
            for(Map<String, Object> organ : organs){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("ORGAN_CODE", organ.get("ORGAN_CODE"));
                map.put("ORGAN_NAME",organ.get("ORGAN_NAME"));
                map.put("COUNT1", 0);
                map.put("COUNT2", 0);
                map.put("COUNT3", 0);
                map.put("COUNT4", 0);
                map.put("COUNT5", 0);
                map.put("COUNT6", 0);
                map.put("COUNT7", 0);
                map.put("COUNT8", 0);
                map.put("COUNT9", 0);
                map.put("COUNT10", 0);
                tempList.add(map);
            }
            Map<String, Object> countColMap = new HashMap<String, Object>();
            countColMap.put("ORGAN_NAME", "<b>合计</b>");
            countColMap.put("COUNT1", 0);
            countColMap.put("COUNT2", 0);
            countColMap.put("COUNT3", 0);
            countColMap.put("COUNT4", 0);
            countColMap.put("COUNT5", 0);
            countColMap.put("COUNT6", 0);
            countColMap.put("COUNT7", 0);
            countColMap.put("COUNT8", 0);
            countColMap.put("COUNT9", 0);
            countColMap.put("COUNT10", 0);
            tempList.add(countColMap);
            return tempList;
        }
    }
    /**
     * 获取镇机构列表
     *
     * @param criteria
     * @return
     * @author Cary
     */
    protected List<Map<String,Object>> getGbCodes( Criteria criteria){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        Object orgCode = criteria.get("gbCode");
        Criteria dicCa = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
        if(ObjectUtil.isNotEmpty(orgCode)){
            dicCa.add("item_code",orgCode.toString());
        }
        List<DicItem> dicitems = dictionaryApp.queryDicItem(dicCa);
//        List<DicItem> dicitems = dictionaryService.getDicItems(dicCa);
        if(ObjectUtil.isNotEmpty(dicitems)){
            for(DicItem dicitem:dicitems){
                Map<String,Object> org = new HashMap<String,Object>();
                org.put("ORGAN_CODE", dicitem.getItemCode());
                org.put("ORGAN_NAME", dicitem.getItemName());
                result.add(org);
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> getStaffCyTypeDate() {
        return hrBaseTargetDao.getStaffCyTypeDate();
    }
}