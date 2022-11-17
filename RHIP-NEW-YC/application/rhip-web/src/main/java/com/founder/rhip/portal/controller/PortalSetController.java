package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.portal.PortalSet;
import com.founder.rhip.portal.service.IPortalSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/portalSet")
public class PortalSetController extends BaseController {

	@Resource(name = "portalSetService")
	private IPortalSetService portalSetService;


	@RequestMapping("/search")
	public String search(){
		return "portal.set.search";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,ModelMap model,
		String code,String name,String type,Integer indexPage){
		
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNotEmpty(code)){
			criteria.add("code", OP.LIKE ,code);
		}
		if(ObjectUtil.isNotEmpty(name)){
			criteria.add("name", OP.LIKE ,name);
		}
		if(ObjectUtil.isNotEmpty(type)){
			criteria.add("type", OP.LIKE ,type);
		}
		
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.YY_GLY, request)
				//|| SecurityUtils.hasRole(RoleType.SQZXYYGH, request)
				) {
			String orgCode = currentLoginInfo.getOrganization().getOrganCode();
			criteria.add("code", OP.IN, new String[]{"a_" + orgCode,"p_" + orgCode});
		}
		Page page = super.getPage(request, indexPage);
		PageList<PortalSet> pList =  portalSetService.getSetPageList(criteria,page);
		model.addAttribute("list", pList.getList());
		model.addAttribute("page", pList.getPage());
		return "portal.set.list";
	}
	
	@RequestMapping("/add")
	public String add(String code,ModelMap model){
		if(ObjectUtil.isNotEmpty(code)){
			Criteria criteria = new Criteria("code", code);
			PortalSet portalSet = portalSetService.getSet(criteria);
			model.addAttribute("portalSet", portalSet);
		}
		return "portal.set.add";
	}
	
	@RequestMapping("/save")
	public @ResponseBody
	String save(PortalSet portalSet,ModelMap model){
		Criteria criteria = new Criteria("code", portalSet.getCode());
		PortalSet oldPortalSet = portalSetService.getSet(criteria);
		
		if(ObjectUtil.isNullOrEmpty(oldPortalSet)){
			return portalSetService.save(portalSet).toString();
		}
		if(ObjectUtil.isNullOrEmpty(portalSet.getId())){
			return "编码不能重复";
		}
		if(ObjectUtil.isNotEmpty(portalSet.getId()) && !portalSet.getId().equals(oldPortalSet.getId())){
			return "编码不能重复";
		}
		return portalSetService.save(portalSet).toString();
	}
	
	@RequestMapping("/delete")
	public @ResponseBody
	String delete(Long setId,ModelMap model){
		return portalSetService.delete(setId).toString();
	}
}
