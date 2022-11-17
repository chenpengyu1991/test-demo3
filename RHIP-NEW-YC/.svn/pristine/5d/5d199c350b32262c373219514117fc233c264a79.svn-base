package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;

import javax.annotation.Resource;
import java.util.*;

public class IhmService extends AbstractService {

	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;

	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;	
	
	/**
	 * 获取当前镇所属中心编码数组
	 *
	 * @param gbCode
	 * @return
	 * @author Ye jianfei
	 */
	protected String[] getCentre(String gbCode) {
		List<String> organCode = new ArrayList<String>();
		Criteria criteria = new Criteria("GB_CODE", gbCode);
		criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
		List<Organization> centres = organizationService.getOrganizationsUseCache(criteria);
		for(Organization org:centres){
			organCode.add(org.getOrganCode());
		}
		return StringUtil.toStringArray(organCode);
	}

	/**
	 * 获取当前镇所属机构编码数组
	 *
	 * @param gbCode
	 * @return
	 * @author Ye jianfei
	 */
	protected String[] getOrgList(String gbCode) {
		List<String> organCode = new ArrayList<String>();
		Criteria criteria = new Criteria("GB_CODE", gbCode);
		List<Organization> orgs = organizationService.getOrganizationsUseCache(criteria);
		for(Organization org:orgs){
			organCode.add(org.getOrganCode());
		}
		return StringUtil.toStringArray(organCode);
	}
	/**
	 * 获取镇机构列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	protected PageList<Map<String,Object>> getGbCodeList(Page page, Criteria criteria){
		PageList<Map<String,Object>> result = new PageList<Map<String,Object>>();
		List<Map<String,Object>> resultlist = new ArrayList<Map<String,Object>>();
		Object orgCode = criteria.get("gbCode");
		Criteria dicCa = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		if(ObjectUtil.isNotEmpty(orgCode)){
			dicCa.add("item_code",orgCode.toString());
		}
		PageList<DicItem> dicitems = dictionaryService.getDicItems(page, dicCa);	
		if(ObjectUtil.isNotEmpty(dicitems)){
			for(DicItem dicitem:dicitems.getList()){
				Map<String,Object> org = new HashMap<String,Object>();
				org.put("ORGAN_CODE", dicitem.getItemCode());
				resultlist.add(org);
			}
		}
		result.setList(resultlist);
		result.setPage(page);
		return result;
	}
	
    /**
     * 获取机构列表
     *
     * @param ca
     * @return
     * @author Ye jianfei
     */
	protected String [] getOrgList(Criteria ca) {
		List<Organization> orgs =  organizationService.getOrganizations(ca);
		List<String> result = new ArrayList<String>();
		for(Organization org:orgs){
			result.add(org.getOrganCode());
		}
		return result.toArray(new String[result.size()]);
	}	
	
	/**
	 * 将没有统计到的镇数据补齐
	 *
	 * @param reports
	 * @author Ye jianfei
	 */
	protected void fillTownData(List<Map<String, Object>> reports,String fieldName){
		//获取所有的镇
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		Map<String,String> townMap = dictionaryApp.queryDicItemMap(criteria);
		for(Map<String, Object> map:reports){
			townMap.remove(map.get(fieldName));
		}
		@SuppressWarnings("rawtypes")
		Iterator iter = townMap.entrySet().iterator();
		while (iter.hasNext()){
			Map<String, Object> reportMap = new HashMap<String,Object>();
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			reportMap.put(fieldName,entry.getKey().toString());
			reports.add(reports.size()-1,reportMap);
		}
	}
}
