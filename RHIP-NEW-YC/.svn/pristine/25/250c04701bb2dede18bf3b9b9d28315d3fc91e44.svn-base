package com.founder.rhip.portal.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.portal.InfoType;
import com.founder.rhip.portal.service.IInfoTypeService;

/**
 * 服务信息类别
 */
@Controller
@RequestMapping("/lhinfoType")
public class LHInfoTypeController extends BaseController {
	
	@Resource(name="lhinfoTypeService")
	private IInfoTypeService infoTypeService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request) {
		return "rhip.lhportal.infoType.search";
	}

	/**
	 * 服务信息类别列表
	 * 
	 * @param request
	 * @param model
	 * @param infoType
	 * @param indexPage
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model, InfoType infoType, Integer indexPage) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = initSearch(infoType);
		criteria.add("PARENT_CODE", OP.IS, null);
		PageList<InfoType> list = infoTypeService.getList(page, criteria);
		model.addAttribute("infoTypeList", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.lhportal.infoType.list";
	}
	
	/**
	 * 下属信息查询
	 * 
	 * @param request
	 * @param parentCode
	 * @return
	 */
	@RequestMapping("/subSearch")
	public String subSearch(HttpServletRequest request, ModelMap model, String parentCode) {
		model.addAttribute("parentCode", parentCode);
		return "rhip.lhportal.infoType.subSearch";
	}
	
	/**
	 * 下属信息列表
	 * 
	 * @param request
	 * @param model
	 * @param infoType
	 * @param indexPage
	 * @param parentCode
	 * @return
	 */
	@RequestMapping("/subLists")
	public String sublist(HttpServletRequest request, ModelMap model, InfoType infoType, Integer indexPage, Long parentCode) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = initSearch(infoType);
		criteria.add("PARENT_CODE", parentCode);
		PageList<InfoType> list = infoTypeService.getList(page, criteria);
		model.addAttribute("subLists", list.getList());
		model.addAttribute("page", list.getPage());
		model.addAttribute("parentCode", parentCode);
		return "rhip.lhportal.infoType.subList";
	}
	
	/**
	 * 新增服务信息类别和子类别
	 * 
	 * @param request
	 * @param model
	 * @param parentCode
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, ModelMap model, String parentCode) {
		if(ObjectUtil.isNotEmpty(parentCode)) {
			return "rhip.lhportal.infoType.subAdd";
		}else {
			return "rhip.lhportal.infoType.add";
		}
	}
	
	/**
	 * 修改服务信息类别和子类别
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @param parentCode
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, ModelMap model, Long id, String parentCode) {
		InfoType infoType = null;
		if(ObjectUtil.isNotEmpty(id) && ObjectUtil.isNotEmpty(parentCode)) {
			infoType = infoTypeService.get(id);
			model.addAttribute("subInfoType", infoType);
			model.addAttribute("id", id);
			return "rhip.lhportal.infoType.subAdd";
		}else {
			infoType = infoTypeService.get(id);
			model.addAttribute("infoType", infoType);
			return "rhip.lhportal.infoType.add";
		}
	}
	
	/**
	 * 保存服务信息类别和子类别
	 * 
	 * @param request
	 * @param model
	 * @param infoType
	 * @param infoTypeGrade
	 * @param parentCode
	 * @return
	 */
	@RequestMapping("/save")
	public String save(HttpServletRequest request, ModelMap model, InfoType infoType, String infoTypeGrade, String parentCode) {
		if(StringUtil.isNotEmpty(infoTypeGrade) && infoTypeGrade.trim().equals("1")) {//如果是一级添加，父编码为空
			infoType.setParentCode(null);
		}else {
			infoType.setParentCode(parentCode);
		}
			infoType.setCreator(this.getCurrentUser(request).getName());
		if(ObjectUtil.isNotEmpty(infoType.getId())) {//更新数据
			infoType.setUpdateTime(new Date());
			if(infoTypeService.update(infoType, new String[] {"name","updateTime","parentCode","creator"}) > 0)
				return EHRMessageUtil.returnMsg(model, "1");// 更新成功
			else
			return EHRMessageUtil.returnMsg(model, "-1");// 更新失败
			}
		else {
			infoType.setCreatTime(new Date());
			if(infoTypeService.save(infoType, new String[] {"name","creatTime","parentCode","creator"}) > 0)// 保存成功
				return EHRMessageUtil.returnMsg(model, "1");
			else// 保存失败
				return EHRMessageUtil.returnMsg(model, "-1");
		}
	} 
	
	/**
	 * 删除服务信息类别和子类别
	 * @param request
	 * @param model
	 * @param id
	 * @param deleteType
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, ModelMap model, Long id, String deleteType) {
		if(ObjectUtil.isNotEmpty(deleteType) && deleteType.trim().equals("1")) {//一级删除，将删除其下属信息
			if(infoTypeService.delete(new Criteria("ID", id)) > 0) {
				infoTypeService.delete(new Criteria("PARENT_CODE", id));
				super.createOperationLog(request, RhipModuleName.LHPORTAL, "服务信息类别", OperationName.DELETE);
				return EHRMessageUtil.returnMsg(model, "1");
			}else//删除失败
				return EHRMessageUtil.returnMsg(model, "-1");
		}else if (infoTypeService.delete(new Criteria("ID", id)) > 0) {
				super.createOperationLog(request, RhipModuleName.LHPORTAL, "服务信息子类别", OperationName.DELETE);
				return EHRMessageUtil.returnMsg(model, "1");
			}
			else//删除失败
				return EHRMessageUtil.returnMsg(model, "-1");
	}
	
	private Criteria initSearch(InfoType infoType) {
		Date fromDate = infoType.getBeginTime();
		Date endDate = infoType.getEndTime();
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNotEmpty(infoType.getName())) {
			criteria.add("NAME", OP.LIKE, infoType.getName());
		}
		DateUtil.getCriteriaByDateRange(criteria, "CREAT_TIME", fromDate, endDate);
		return criteria;
	}

}
