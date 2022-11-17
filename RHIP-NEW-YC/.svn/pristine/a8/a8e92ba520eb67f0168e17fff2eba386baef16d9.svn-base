package com.founder.rhip.portal.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.Interaction;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.portal.service.IHospitalInfoService;
import com.founder.rhip.portal.service.IInteractionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;

/**
 * 互动管理
 */
@Controller
@RequestMapping(value = "/interaction")
public class InteractionController extends BaseController {
	@Resource(name="interactionService")
	private IInteractionService interactionService;
	
	@Resource(name="lhhospitalInfoService")
	private IHospitalInfoService lhhospitalInfoService;
	
	 @Resource(name = "excelExportService")
	 private IExcelExportService excelExportService;
	 
	@RequestMapping(value = "/search")
	public String getRecords(HttpServletRequest request, ModelMap model) {
		return "rhip.lhportal.interaction.search";
	}
	
	/**
	 * 互动列表
	 * 
	 * @param request
	 * @param model
	 * @param indexPage
	 * @param interaction
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String getRecods(HttpServletRequest request, ModelMap model, Integer indexPage, Interaction interaction) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = new Criteria();
		criteria = initSearchCondition(interaction);
		this.getRoleCriteria(criteria, request);
		PageList<Interaction> list = interactionService.getList(page, criteria);
		model.addAttribute("interactionRecords", list.getList());
		model.addAttribute("page", list.getPage());
		model.addAttribute("interaction", interaction);
		return "rhip.lhportal.interaction.list";
	}
	
	/**
	 * 获取互动管理的权限条件
	 * 
	 * @param criteria
	 * @param request
	 */
	private void getRoleCriteria(Criteria criteria, HttpServletRequest request) {
		String orgCode = getCurrentOrg(request).getOrganCode();
		if (!hasRole(RoleType.ADMIN, request))
			criteria.add("NEXT_UNIT", orgCode);
	}
	
	/**
	 * 互动管理接受和退回状态
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @param operation
	 * @return
	 */
	@RequestMapping(value = "/status")
	public String changeStatus(HttpServletRequest request, ModelMap model, String id, String operation) {
		if(ObjectUtil.isNotEmpty(id) && ObjectUtil.isNotEmpty(operation) && operation.trim().equals("accept")) {
			Parameters parameter = new Parameters();
			parameter.add("STATUS", "02").add("UNIT_CODE", getCurrentOrg(request).getOrganCode()).add("NEXT_UNIT", getCurrentOrg(request).getOrganCode());
			if(interactionService.update(parameter, new Criteria("ID", id)) > 0) {//修改状态为可接受
			return EHRMessageUtil.returnMsg(model, "1");
			}
		}
		if(ObjectUtil.isNotEmpty(id) && ObjectUtil.isNotEmpty(operation) && operation.trim().equals("retreat")) {
			Interaction interaction = interactionService.getInteraction(new Criteria("id", id));
			Parameters parameter = new Parameters();
			parameter.add("STATUS", "03").add("NEXT_UNIT", "").add("UNIT_CODE", interaction.getOrgCode());
			if(interactionService.update(parameter, new Criteria("ID", id))>0) {//修改状态为已退回
				return EHRMessageUtil.returnMsg(model, "1");
			}
		}
		return EHRMessageUtil.returnMsg(model, "-1");
	}
	
	
	/**
	 * 互动管理的查看和回复
	 * 
	 * @param request
	 * @param operatorType
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, ModelMap model, String operatorType) {
		String id = request.getParameter("id");
		Interaction i = null;
		if(ObjectUtil.isNotEmpty(id)) {
			//修改和查看
			Long idTemp=new Long(id);
			i = interactionService.get(idTemp);
			i.setOperatorType(operatorType);
		}
		model.addAttribute("Interaction", i);
		return "rhip.lhportal.interaction.edit";
	}
	
	/**
	 * 互动管理保存
	 * 
	 * @param request
	 * @param interaction
	 * @param model
	 * @param contents
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(HttpServletRequest request,Interaction interaction, ModelMap model, String contents) {
		if(ObjectUtil.isNotEmpty(interaction.getId()) && "2".equals(interaction.getOperatorType())) {//更新
			//interaction.setReplyContent(contents);
			interaction.setStatus("04");
			interaction.setUnitCode(getCurrentOrg(request).getOrganCode());
			interaction.setReplyName(this.getCurrentUser(request).getUserName());
			interaction.setReplyDate(new Date());
			interactionService.update(interaction,new String[] {"replyName", "replyDate", "replyContent","status","unitCode"});
			return EHRMessageUtil.returnMsg(model, "1");
		}else
			return EHRMessageUtil.returnMsg(model, "-1");
		
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response, Long id) {
		if(ObjectUtil.isNullOrEmpty(id)) {
			MessageUtils.outputJSONResult("idIsNull", response);
		}
		Interaction interaction = interactionService.getInteraction(new Criteria("id", id));
		interactionService.delete(interaction);
		createOperationLog(request, RhipModuleName.LHPORTAL,"罗湖门户互动管理记录删除", OperationName.DELETE);
	}

	/**
	 * 转交单位的查询
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/unitSearch")
	public String searchUnit(HttpServletRequest request, ModelMap model, Long id) {
		Criteria criteria=new Criteria();
		List<HospitalInfo> hospitalInfo = interactionService.getList(criteria);
		Interaction interaction = interactionService.get(id);
		model.addAttribute("interaction", interaction);
		model.addAttribute("hospitalInfo", hospitalInfo);
		return "rhip.lhportal.interaction.unitSearch";
	}
	
	/**
	 * 转交单位
	 * 
	 * @param request
	 * @param interaction
	 * @param id
	 * @param model
	 * @param nextUnit
	 * @return
	 */
	@RequestMapping(value = "/saveNextunit")
	public String unitsave(HttpServletRequest request, Interaction interaction, Long id, ModelMap model, String nextUnit) {
		if(ObjectUtil.isNotEmpty(id)) {
			interaction = interactionService.get(id);
			interaction.setUnitCode(nextUnit);
			interaction.setNextUnit(nextUnit);
			interaction.setStatus("01");
			interactionService.update(interaction,new String[] {"unitCode", "nextUnit", "status"});
			return EHRMessageUtil.returnMsg(model, "1");
		}else
			return EHRMessageUtil.returnMsg(model, "-1");
		
	}

	private Criteria initSearchCondition(Interaction interaction) {
		Date fromDate = interaction.getBeginTime();
		Date toDate = interaction.getEndTime();
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(interaction)) {
			return criteria;
		}
		if(ObjectUtil.isNotEmpty(interaction.getTitle())) {
			criteria.add("TITLE", OP.LIKE, interaction.getTitle());
		}
		if(ObjectUtil.isNotEmpty(interaction.getEventType()) && null != interaction.getEventType()) {
			criteria.add("EVENT_TYPE", OP.EQ, interaction.getEventType());
		}
		if(ObjectUtil.isNotEmpty(interaction.getStatus()) && null != interaction.getStatus()) {
			criteria.add("STATUS", OP.EQ, interaction.getStatus());
		}
		DateUtil.getCriteriaByDateRange(criteria, "INSERT_DATE", fromDate,toDate);
		return criteria;
	}
	
	

}
