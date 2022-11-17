package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IStaffService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseHmService {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
    @Autowired
	private IDictionaryApp dictionaryApp;
    
	@Resource(name = "organizationApp")
	protected IOrganizationApp organizationApp;
    
    @Resource(name = "mdmStaffService")
    protected IStaffService mdmStaffService;
	
	protected List<Map<String, Object>> matchTowns(List<Map<String, Object>> mapList, Map<String, String> paramMap) {
		List<Map<String, Object>> destMapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(mapList) || ObjectUtil.isNullOrEmpty(paramMap)) {
			return destMapList;
		}
		List<Map<String, Object>> addMapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> totalMap = null;
		String genreCode = paramMap.get("genreCode");
		String gbCode = paramMap.get("gbCode");
		if (ObjectUtil.equals(genreCode, "0") && ObjectUtil.isNullOrEmpty(gbCode) && ObjectUtil.isNotEmpty(mapList)) {
			totalMap = mapList.get(mapList.size() - 1);
			mapList.remove(mapList.size() - 1);
			//获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
			for (DicItem dicItem : dicItems) {
				boolean flag = true;
				for (Map<String, Object> map : mapList) {
					if (StringUtils.equals(dicItem.getItemCode(), String.valueOf(map.get("gb_code")))) {
						flag = false;
					}
				}
				if (flag) {
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("gb_code", dicItem.getItemCode());
					addMapList.add(m);
				}
			}
		}
		if (ObjectUtil.isNotEmpty(addMapList)) {
			destMapList.addAll(mapList);
			destMapList.addAll(addMapList);
			destMapList.add(totalMap);
			return destMapList;
		} else {
			return mapList;
		}
	}
}
