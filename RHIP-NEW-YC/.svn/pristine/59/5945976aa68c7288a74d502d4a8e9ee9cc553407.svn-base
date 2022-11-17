package com.founder.rhip.mdm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.Domain;
import com.founder.rhip.mdm.service.IDomainService;

@Controller
@RequestMapping("/mdmDomain")
public class DomainController extends BaseController {
	
	@Resource(name="mdmDomainService")
	private IDomainService mdmDomainService;
	
	@RequestMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("criDomain", new Domain());
		return "com.founder.mdm.domainSearch";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,ModelMap model, Domain criDomain, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initCriteria(criDomain);
		PageList<com.founder.rhip.mdm.entity.Domain> pageList = mdmDomainService.queryDomains(page, criteria);
		model.addAttribute("domainList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.domainList";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("domain", new Domain());
		return "com.founder.mdm.domainInfoEdit";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model, String domainCode) {
		Domain domain = mdmDomainService.getDomain(domainCode);
		model.addAttribute("domain", domain);
		return "com.founder.mdm.domainInfoEdit";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ModelMap delete(String domainCode) {
		ModelMap model = new ModelMap();
		try {
			mdmDomainService.deleteDomain(domainCode);
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
		} catch (Exception e) {
			log.error("删除域出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(Domain domain, String type) {
		ModelMap model = new ModelMap();
		domain.setOperator(getOperator());
		domain.setOperateTime(getOperatorTime());
		
		String domainCode = domain.getDomainCode();
		Domain dbDomain = mdmDomainService.getDomain(domainCode);
		if (dbDomain == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的域不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同编码的域已经存在");
				return model;
			}
		}
		
		try {
			if ("add".equalsIgnoreCase(type)) {
				domain.setOperateType(OperateType.create.getName());
				mdmDomainService.insertDomain(domain);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				domain.setOperateType(OperateType.update.getName());
				mdmDomainService.updateDomain(domain);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存域出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private Criteria initCriteria(Domain criDomain) {
		Criteria criteria = new Criteria();
		String code = criDomain.getDomainCode();
		if (StringUtil.isNotEmpty(code)) {
			criteria.add("domainCode", OP.LIKE, code);
		}
		String name = criDomain.getDomainName();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("domainName", OP.LIKE, name);
		}
		return criteria;
	}

}
