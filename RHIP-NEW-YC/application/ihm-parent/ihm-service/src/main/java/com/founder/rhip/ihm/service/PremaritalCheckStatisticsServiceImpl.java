/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.ihm.IPremaritalCheckStatisticsDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;

@Service("premaritalCheckStatisticsService")
public class PremaritalCheckStatisticsServiceImpl extends AbstractService implements IPremaritalCheckStatisticsService {

	@Resource(name = "premaritalCheckStatisticsDao")
	private IPremaritalCheckStatisticsDao premaritalCheckStatisticsDao; 
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<Map<String, Object>> getstatisticsList(Map<String, String> map) {
		
		String organCode = map.get("organCode");
		String genreCode = map.get("genreCode");
		String superOrganCode = map.get("superOrganCode");
		String gbCode = map.get("gbCode");
        String orgG2 = map.get("orgG2");
		
		//育龄妇女统计、妇女疾病筛查数、女性婚检人数、男性婚检人数
		List<Map<String, Object>> result = null;
		Criteria criteriaTemp = null;
		if("0".equalsIgnoreCase(genreCode)) {
			if(StringUtil.isNotEmpty(gbCode)) {
				criteriaTemp = new Criteria("patownShip", gbCode);
			}else
			{
				criteriaTemp = new Criteria("patownShip", OP.IS, "NOT NULL");
			}
		}else {
			criteriaTemp = this.buildCriteria(orgG2, genreCode, organCode, superOrganCode, gbCode, "createOrganCode");
		}

		result = premaritalCheckStatisticsDao.getstatisticsList(genreCode, criteriaTemp, map.get("beginDate"), map.get("endDate"));
		
		if("0".equalsIgnoreCase(genreCode))
		{
			if(gbCode != null && (result == null || result.size() != 1))
			{
				result = new ArrayList<Map<String, Object>>();
				
				Map<String, Object> mapTemp = new HashMap<String, Object>();
				mapTemp.put("ORGAN_CODE", gbCode);
				mapTemp.put("COUNT1", 0);
				mapTemp.put("COUNT3", 0);
				mapTemp.put("COUNT4", 0);
				mapTemp.put("COUNT5", 0);
				
				result.add(mapTemp);
			}else if(gbCode == null){
				List<Map<String, Object>> resultTemp = new ArrayList<Map<String, Object>>();
				resultTemp.addAll(result);
				//获取所有的镇
				Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
				List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
				
				Object[] strArray = this.Convert2Array(dicItems, "itemCode");
				for(Map<String, Object> mapTemp: result)
				{
					boolean flag = false;
					for(int i = 0; i < strArray.length; i ++)
					{
						if(mapTemp.get("ORGAN_CODE").equals(strArray[i]))
						{
							flag = true;
							break;
						}
					}
					
					if(!flag)
					{
						resultTemp.remove(mapTemp);
					}
				}
				
				result = resultTemp;
				if(!CollectionUtils.isEmpty(dicItems))
				{
					for(DicItem dicItem: dicItems)
					{
						boolean flag = false;
						for(Map<String, Object> mapTemp: result)
						{
							if(mapTemp.get("ORGAN_CODE").equals(dicItem.getItemCode()))
							{
								flag = true;
								break;
							}
						}
						
						if(!flag)
						{
							Map<String, Object> mapTemp = new HashMap<String, Object>();
							mapTemp.put("ORGAN_CODE", dicItem.getItemCode());
							mapTemp.put("COUNT1", 0);
							mapTemp.put("COUNT3", 0);
							mapTemp.put("COUNT4", 0);
							mapTemp.put("COUNT5", 0);
							
							resultTemp.add(mapTemp);
						}
					}
				}
				result = resultTemp;
			}
			
		}
		return this.total(result);
	}
	
	/**
	 * 组装查询条件
	 * 
	 * @return
	 */
	private Criteria buildCriteria(String orgG2,String genreCode, String organCode, String superOrganCode, String gbCode, String fieldName) {
		Criteria criteria = new Criteria();
		Criteria criteriaTemp = null;
		
		// 机构
		if("0".equals(genreCode)) {// 按镇
			if (StringUtil.isNotEmpty(gbCode)) {
				criteriaTemp = new Criteria().add("gbCode", gbCode);
			} else {
				criteriaTemp = new Criteria().add("gbCode", OP.IS, "NOT NULL");
			}
			criteriaTemp.add("genreCode", OP.IN, new String[]{"B100","B200"});
		} else if ("A100".equals(genreCode)){ // 按市级医院

			criteriaTemp = new Criteria().add("genreCode", "A100");
			if (StringUtil.isNotEmpty(superOrganCode)) {
				criteriaTemp.add("organCode", superOrganCode);
			} else {
				criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
			}

		} else if ("B100".equals(genreCode)){ // 按卫生院
			
			criteriaTemp = new Criteria().add("genreCode", "B100");
			if(StringUtil.isNotEmpty(gbCode))
			{
				criteriaTemp.add("gbCode", gbCode);
			}
			
			if(StringUtil.isNotEmpty(superOrganCode))
			{
				criteriaTemp.add("organCode", superOrganCode);
			}else
			{
				criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
			}
		} else if ("B200".equals(genreCode)){ // 按社区卫服务站
			criteriaTemp = new Criteria().add("genreCode", "B200");
			if(StringUtil.isNotEmpty(gbCode))
			{
				criteriaTemp = criteriaTemp.add("gbCode", gbCode);
			}
			
			if(StringUtil.isNotEmpty(superOrganCode))
			{
				criteriaTemp = criteriaTemp.add("parentCode", superOrganCode);
			}
			
			if(StringUtil.isNotEmpty(organCode))
			{
				criteriaTemp = criteriaTemp.add("organCode", organCode);
			}else
			{
				criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
			}
		}else if ("G2".equals(genreCode)){ // 妇幼保健所

            criteriaTemp = new Criteria().add("genreCode", "G2");

            if(StringUtil.isNotEmpty(orgG2))
            {
                criteriaTemp.add("organCode", orgG2);
            }else
            {
                criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
            }
        }

        if (null != criteriaTemp) {
			criteriaTemp.add("status", "1");
			List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

			if (!CollectionUtils.isEmpty(orgs)) {
				criteria.add(fieldName, OP.IN, Convert2Array(orgs, "organCode"));
			}else
			{
				criteria.add(fieldName, gbCode);
			}
		}

		return criteria;
	}
	
	private <T> Object[] Convert2Array(List<T> list, String fieldName) {
		Object[] ta = new Object[list.size()];
		if (CollectionUtils.isEmpty(list))
			return ta;
		Method method;
		try {
			method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			for (int i = 0; i < list.size(); i++) {
				ta[i] = method.invoke(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}
	
	//添加合计项
	private List<Map<String, Object>> total(List<Map<String, Object>> result)
	{
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
			
			countColMap.put(code, "<b>合计</b>");
			tempList.add(countColMap);
			
			return tempList;
		}else
		{
			return result;
		}
	}
}