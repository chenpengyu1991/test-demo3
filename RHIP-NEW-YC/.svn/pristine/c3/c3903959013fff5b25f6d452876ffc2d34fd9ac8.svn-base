package com.founder.rhip.mdm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IExplorerSetService;

@Controller
@RequestMapping("/explorerSet")
public class ExplorerSetController {
	
	@Resource(name = "explorerSetService")
	private IExplorerSetService explorerSetService;
	
	@Resource(name = "mdmDictionaryService")
	private IDictionaryService mdmDictionaryService;

	@RequestMapping("/view")
	public String view(ModelMap model) {
		Map<String, List<String>> destMap = explorerSetService.getExplorerSetMap(new Criteria());
		List<DicItem> doctorTypeItems = mdmDictionaryService.getDicItems(new Criteria("dicCode", "FS990013"));
		List<DicItem> setTypeItems = mdmDictionaryService.getDicItems(new Criteria("dicCode", "FS990014"));
		model.addAttribute("doctorTypeItems", doctorTypeItems);
		model.addAttribute("setTypeItems", setTypeItems);
		model.addAttribute("map", destMap);
		return "com.founder.mdm.explorer.set";
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public List<String> save(String setRet) {
		List<String> messages = new ArrayList<String>();
		if (ObjectUtil.isNullOrEmpty(setRet) || !StringUtils.contains(setRet, ":")) {
			messages.add("参数错误，请与系统管理联系！");
			return messages;
		}
	
		// 保存医生设置
		Boolean cret = explorerSetService.saveSetResult(setRet);
		if (!cret) {
			messages.add("保存医生设置出错！");
		} else {
			messages.add("保存成功！");
		}
		
		return messages;
	}
	
}
