/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.service.IAdministrativeAreaService;
import com.founder.rhip.ehr.service.IOrgVillageRelationService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.OrgVillageRelation;
import com.founder.rhip.mdm.service.IDictionaryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 机构维护
 */
@Controller
@RequestMapping("/administrative")
public class AdministrativeController extends BaseController {

	private static int ADMINISTRATIVE_AREA_HISTORY = 2;

	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	@Resource(name = "administrativeAreaService")
	private IAdministrativeAreaService administrativeAreaService;

	@Resource(name = "orgVillageRelationService")
	private IOrgVillageRelationService orgVillageRelationService;
	
	@RequestMapping("/init")
	public String manager(ModelMap model) {
		int currentYear = DateUtil.getCurrentYear();
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("years", new Integer[]{currentYear,currentYear-1,currentYear-2});
		return "com.founder.mdm.administrative.index";
	}

    @RequestMapping("/tabIndex")
    public String tabIndex(ModelMap model,Integer selectYear) {
		int currentYear = DateUtil.getCurrentYear();
		model.addAttribute("selectYear", selectYear);
		model.addAttribute("currentYear", currentYear);
		return "com.founder.mdm.administrative.init";
    }
	
	@RequestMapping("/getTowns")
	public String getTowns(ModelMap model) {
		//获取所有的镇
		List<DicItem> towns = dictionaryApp.queryDicItems("FS990001", EHRConstants.FS990001_ROOT);
		List<String> townCodes = new ArrayList<>();
		for(DicItem dicItem : towns) {
			townCodes.add(dicItem.getItemCode());
		}
		List<String> lstTree = new ArrayList<String>();  
		lstTree.add("{\"id\":\"1\", \"pId\":\"0\", \"name\":\"永城市\" , open:true, chkDisabled:true}");
		
		for(DicItem town : towns) {
			lstTree.add("{\"id\":\""+town.getItemCode()+"\", \"pId\":\"1\", \"name\":\""+town.getItemName()+"\" }");
		}

        return EHRMessageUtil.returnMsg(model, lstTree);
	}
	
	@RequestMapping("/getVillages")
	public String getVillages(String townCode, Integer selectYear, HttpServletRequest request, ModelMap model) {
		Integer currentYear = DateUtil.getCurrentYear();
		//如果是当年数据则从ORGANIZATION_AREA表中获取
		if(currentYear.equals(selectYear)) {
			List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", townCode);
			List<DicItem> noParents = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", OP.IS,"NULL"));
			model.addAttribute("villages", villages);
			model.addAttribute("noParents", noParents);
			model.addAttribute("townCode", townCode);
			model.addAttribute("type", 1);
		}else{
			//如果不是当年数据则从ORG_VILLAGE_RELATION表中获取历史记录
			List<OrgVillageRelation> orgVillageRelations = orgVillageRelationService.getRelation(townCode,selectYear,ADMINISTRATIVE_AREA_HISTORY);
			model.addAttribute("villages", orgVillageRelations);
			model.addAttribute("type", 2);
		}
		return "com.founder.mdm.administrative.list";
	}

	/**
	 * 查看地区详细信息
	 * @param model
	 * @param townCode
	 * @param year
	 * @return
	 */
	@RequestMapping("/areaInfo")
	public String areaInfo(ModelMap model,String townCode,String year) {
		model.addAttribute("areaYear", year);
		if(ObjectUtil.isNotEmpty(townCode)){
			DicItem dicItem = dictionaryApp.queryDicItem("FS990001", townCode);
			model.addAttribute("dicItem", dicItem);
		}
		return "com.founder.mdm.administrative.areaInfo";
	}

	/**
	 * 添加行政村
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/village/view")
	public String viewVillage(String itemCode,String selectYear, HttpServletRequest request,ModelMap model) throws Exception {
		if(StringUtils.isNotEmpty(itemCode)) {
			DicItem dicItem = dictionaryApp.queryDicItem("FS990001", itemCode);
			model.addAttribute("dicItem", dicItem);
		}
		model.addAttribute("areaYear", selectYear);
		return "com.founder.mdm.administrative.view";
	}

	/**
     * 添加行政村
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/village/add")
    public String addVillage(String itemCode,String selectYear, HttpServletRequest request,ModelMap model) throws Exception {
       if(StringUtils.isNotEmpty(itemCode)) {
    	   DicItem dicItem = dictionaryApp.queryDicItem("FS990001", itemCode);
    	   model.addAttribute("dicItem", dicItem);
       }
		model.addAttribute("areaYear", selectYear);
		return "com.founder.mdm.administrative.add";
    }
    
    /**
     * 保存行政村
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/village/save")
    public String addVillage(DicItem dicItem, HttpServletRequest request, ModelMap model) throws Exception {
        if(ObjectUtil.isNullOrEmpty(dicItem)){
            return EHRMessageUtil.returnMsg(model, "fail");
        } else {
        	//判断新编码是否已存在
    		if (isExistDicItem(dicItem) && ObjectUtil.isNullOrEmpty(dicItem.getItemId())) {
    			return EHRMessageUtil.returnMsg(model, "exist");
    		} else if(ObjectUtil.isNotEmpty(dicItem.getItemId())) {
    			this.updateVillage(dicItem, request, model);
    		} else {
    			try {
        			dicItem.setOperator(getOperator());
        			dicItem.setOperateTime(getOperatorTime());
    				dicItem.setOperateType(OperateType.create.getName());
    				administrativeAreaService.saveAdministrativeArea(dicItem);
    				EHRMessageUtil.returnMsg(model, "success");
        		} catch (Exception e) {
        			EHRMessageUtil.returnMsg(model, "failed");
        			throw new RuntimeException("保存行政村出错", e);
        		}
    		}
    		
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    /**
     * 修改行政村
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/village/update")
    public String updateVillage(DicItem dicItem, HttpServletRequest request, ModelMap model) throws Exception {
        if(ObjectUtil.isNullOrEmpty(dicItem)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
        	String dicCode = dicItem.getDicCode();
    		String itemCode = dicItem.getItemCode();
    		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
    		criteria.add(DicItem.ITEM_CODE, itemCode);
    		DicItem dbItem = dictionaryApp.queryDicItem(dicCode, itemCode);
    		if(ObjectUtil.isNullOrEmpty(dbItem)) {
    			return EHRMessageUtil.returnMsg(model, "notExist");
    		}
        	dicItem.setOperateType(OperateType.update.getName());
			setDicItemValue(dbItem, dicItem);
			administrativeAreaService.updateAdministrativeArea(dbItem);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    private void setDicItemValue(DicItem dbItem, DicItem pageItem) {
		pageItem.setItemId(dbItem.getItemId());
		pageItem.setVersion(dbItem.getVersion());
		pageItem.setStatus(dbItem.getStatus());
		pageItem.setItemId(dbItem.getItemId());
		pageItem.setOperator(getOperator());
		pageItem.setOperateTime(getOperatorTime());
		pageItem.setOperateType(OperateType.update.getName());
	}
    
    /**
     * 删除行政村
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/village/delete")
    public String deleteVillage(String itemCode, HttpServletRequest request,ModelMap model) throws Exception {
    	try {
    		DicItem dicItem = dictionaryService.getDicItem("FS990001", itemCode);
    		dicItem.setStatus(StatusValue.deleteValue.getValue());
    		administrativeAreaService.deleteAdministrativeArea(dicItem);
    		return EHRMessageUtil.returnMsg(model, "success");
		} catch (Exception e) {
			log.error("删除字典项出错", e);
			return EHRMessageUtil.returnMsg(model, "fail");
		}
    }
    
    /**
     * 删除行政村
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveRelation")
    public String saveRelation(String villageCodes, String townCode, HttpServletRequest request,ModelMap model) throws Exception {
        if(StringUtil.isNullOrEmpty(villageCodes) || StringUtil.isNullOrEmpty(townCode)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
        	dictionaryService.saveRelation(villageCodes, townCode);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }
    
    /**
     * 初始化加载合并镇的页面
     * @param townCodes
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initMergeDialog")
    public String initMergeDialog(String townCodes, HttpServletRequest request,ModelMap model) {
    	model.addAttribute("townCodes", townCodes);
    	return "com.founder.mdm.administrative.mergeTown";
    }
    
    /**
     * 保存合并镇
     * @param newCode
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/mergeTown")
    public String mergeTown(String newCode, String oldCode, DicItem dicItem, HttpServletRequest request, ModelMap model) {
    	if(ObjectUtil.isNotEmpty(dicItem)) {
    		dicItem.setOperator(getOperator());
			dicItem.setOperateTime(getOperatorTime());
			dicItem.setOperateType(OperateType.create.getName());
			dicItem.setParentCode(EHRConstants.FS990001_ROOT);
			dicItem.setDicCode("FS990001");
    	}
    	return EHRMessageUtil.returnMsg(model, dictionaryService.mergeTown(newCode, oldCode, dicItem));
    }
    
    /**
     * 判断新增时 判断ItemCode是否已存在
     * @param dicItem
     * @return
     */
    private Boolean isExistDicItem(DicItem dicItem) {
    	String dicCode = dicItem.getDicCode();
		String itemCode = dicItem.getItemCode();
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
		DicItem dbItem = dictionaryApp.queryDicItem(dicCode, itemCode);
		if (dbItem != null) {
			return true;
		}
		return false;
    }
}