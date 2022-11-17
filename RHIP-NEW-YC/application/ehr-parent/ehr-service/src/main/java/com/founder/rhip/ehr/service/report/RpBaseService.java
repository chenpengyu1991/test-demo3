package com.founder.rhip.ehr.service.report;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IStaffService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;

public class RpBaseService {
	
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

	protected void setRpOrganization(ConvertingWrapDynaBean dynaBean, Organization organization) {
		if (ObjectUtil.isNullOrEmpty(dynaBean) || ObjectUtil.isNullOrEmpty(organization)) {
			return;
		}
		dynaBean.set("organCode", organization.getOrganCode());
		dynaBean.set("centerCode", (organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		dynaBean.set("gbCode",organization.getGbCode());
		dynaBean.set("organType", organization.getGenreCode());
	}
	
	protected Criteria organizeCriteria(Map<String, String> paramMap) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return criteria;
		}
		if (ObjectUtil.isNotEmpty(paramMap.get("organCode"))) {
			criteria.add("organCode", paramMap.get("organCode"));
		}
		Date beginDate = ObjectUtil.isNullOrEmpty(paramMap.get("beginDate")) ? null: DateUtil.parseDateString(String.valueOf(paramMap.get("beginDate")));
		Date endDate = ObjectUtil.isNullOrEmpty(paramMap.get("endDate")) ? null: DateUtil.parseDateString(String.valueOf(paramMap.get("endDate")));
		DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate, endDate);
		return criteria;
	}
}
