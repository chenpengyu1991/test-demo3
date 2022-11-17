package com.founder.rhip.wsMonitor.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceInfo;
import com.founder.rhip.ehr.service.wsMonitor.IWsServiceInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/wsMonitor/serviceInfo")
public class WsServiceInfoController extends BaseController {
	@Resource(name = "wsServiceInfoService")
	private IWsServiceInfoService wsServiceInfoService;

	/**
	 * 服务器注册查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/register/search")
	public String searchRegister(ModelMap model, HttpServletRequest request) {
		return "rhip.wsMonitor.serviceRegister.search";
	}

	/**
	 * 服务器注册查询列表
	 * @param wsServiceInfo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/list")
	public String listRegister(WsServiceInfo wsServiceInfo,HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = this.getServiceInfoCriteria(wsServiceInfo);
		String[] requiredProperties = new String[] {};
		Order order = new Order("CREATE_DATE", false);
		PageList<WsServiceInfo> plist = wsServiceInfoService.getPageList(page,criteria,order,requiredProperties);
		model.addAttribute("wsServiceInfos", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.wsMonitor.serviceRegister.list";
	}

	/**
	 * 服务端新增初始页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/register/add")
	public String addRegister(String id, ModelMap model, HttpServletRequest request) {
		WsServiceInfo wsServiceInfo = new WsServiceInfo();
		if(ObjectUtil.isNotEmpty(id)) {
			Criteria criteria = new Criteria("id", id);
			wsServiceInfo = wsServiceInfoService.getWsServiceInfo(criteria);
		}
		model.addAttribute("wsServiceInfo", wsServiceInfo);
		return "rhip.wsMonitor.serviceRegister.add";
	}
	/**
	 * 服务端新增
	 * @param wsServiceInfo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/save")
	public String saveRegister(WsServiceInfo wsServiceInfo, HttpServletRequest request, ModelMap model) {
		String returnFlag = this.validateMesg(wsServiceInfo, model);
		if(ObjectUtil.isNotEmpty(this.validateMesg(wsServiceInfo, model))) {
			return returnFlag;
		}
		returnFlag = "success";
		if(ObjectUtil.isNotEmpty(wsServiceInfo.getId()) && wsServiceInfo.getId()>0){
			wsServiceInfo.setUpdateDate(new Date());
			wsServiceInfo.setUpdateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			wsServiceInfo.setUpdateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
		}else{
			wsServiceInfo.setCreateDate(new Date());
			wsServiceInfo.setCreateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			wsServiceInfo.setCreateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
		}
		Long id = wsServiceInfoService.saveWsServiceInfo(wsServiceInfo);
		if(!(id>0)) {
			returnFlag = "fail";
		}
		return EHRMessageUtil.returnMsg(model,returnFlag);
	}

	private String validateMesg(WsServiceInfo wsServiceInfo, ModelMap model) {

		String returnFlag = "";
		WsServiceInfo wsServiceInfoOld = wsServiceInfoService.getWsServiceInfo(new Criteria("wsdl", wsServiceInfo.getWsdl()));
		WsServiceInfo wsServiceInfoOldName = wsServiceInfoService.getWsServiceInfo(new Criteria("WEB_SERVICE_NAME", wsServiceInfo.getWebServiceName()));

		Boolean nameFlagId  = ObjectUtil.isNotEmpty(wsServiceInfoOldName) && !ObjectUtil.equals(wsServiceInfo.getId(),wsServiceInfoOldName.getId());
		Boolean wsdlFlagId  = ObjectUtil.isNotEmpty(wsServiceInfoOld) && !ObjectUtil.equals(wsServiceInfo.getId(),wsServiceInfoOld.getId());

		Boolean nameFlag  = ObjectUtil.isNotEmpty(wsServiceInfoOldName);
		Boolean wsdlFlag  = ObjectUtil.isNotEmpty(wsServiceInfoOld);

		if(ObjectUtil.isNullOrEmpty(wsServiceInfo.getId())) {
			if(nameFlag && wsdlFlag) {
				//serviceName and wsdl 相同
				returnFlag = EHRMessageUtil.returnMsg(model,"all");
			} else if(nameFlag) {
				//serviceName 相同
				returnFlag =  EHRMessageUtil.returnMsg(model,"serviceName");
			} else if(wsdlFlag){
				//wsdl不能相同
				returnFlag =  EHRMessageUtil.returnMsg(model,"exist");
			}
		} else {
			if(nameFlagId && wsdlFlagId) {
				//serviceName and wsdl 相同
				returnFlag =  EHRMessageUtil.returnMsg(model,"all");
			} else if(nameFlagId) {
				//serviceName 相同
				returnFlag =  EHRMessageUtil.returnMsg(model,"serviceName");
			} else if(wsdlFlagId){
				//wsdl不能相同
				returnFlag =  EHRMessageUtil.returnMsg(model,"exist");
			}
		}
		return returnFlag;
	}
	/**
	 * 改变服务端开启状态
	 * @param id
	 * @param serverStatus
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/changeStatus")
	public String changeStatusRegister(String id, String serverStatus, HttpServletRequest request, ModelMap model) {
		String returnFlag = "success";
		WsServiceInfo wsServiceInfo = wsServiceInfoService.getWsServiceInfo(new Criteria("ID", id));
		wsServiceInfo.setServerStatus(serverStatus);
		wsServiceInfo.setUpdateDate(new Date());
		wsServiceInfo.setUpdateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
		wsServiceInfo.setUpdateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
		Long returnId = wsServiceInfoService.editWsServiceInfo(wsServiceInfo, "serverStatus");
		if(!(returnId>0)) {
			returnFlag = "fail";
		}
		return EHRMessageUtil.returnMsg(model,returnFlag);
	}

	/**
	 * 删除服务端
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteService(Long id, HttpServletRequest request, ModelMap model) {
		String returnFlag = "success";
		wsServiceInfoService.deleteService(id);
		return EHRMessageUtil.returnMsg(model,returnFlag);
	}

	@RequestMapping("/monitor/search")
	public String searchMonitor(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentDate", new Date());
		return "rhip.wsMonitor.serviceMonitor.search";
	}

	@RequestMapping("/monitor/list")
	public String searchMonitor(WsServiceInfo wsServiceInfo,HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = this.getServiceInfoCriteria(wsServiceInfo);
		model.addAttribute("beginDate", request.getParameter("beginDate"));
		model.addAttribute("endDate", request.getParameter("endDate"));
		String[] requiredProperties = new String[] {};
		Order order = new Order("CREATE_DATE", false);
		PageList<WsServiceInfo> plist = wsServiceInfoService.getPageList(page,criteria,order,requiredProperties);
		model.addAttribute("wsServiceInfos", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.wsMonitor.serviceMonitor.list";
	}

	private Criteria getServiceInfoCriteria(WsServiceInfo wsServiceInfo) {
		Criteria criteria = new Criteria();
		/*接口名称*/
		if(StringUtil.isNotEmpty(wsServiceInfo.getWebServiceName())) {
			criteria.add("WEB_SERVICE_NAME", OP.LIKE, wsServiceInfo.getWebServiceName());
		}
		/*服务器地址*/
		if(StringUtil.isNotEmpty(wsServiceInfo.getWsdl())) {
			criteria.add("WSDL", OP.LIKE, wsServiceInfo.getWsdl());
		}
		/*服务开关*/
		if(StringUtil.isNotEmpty(wsServiceInfo.getServerStatus())) {
			criteria.add("SERVER_STATUS", wsServiceInfo.getServerStatus());
		}
		return criteria;
	}

	/**
	 * 检测服务器是否正常，1：正常，0：异常
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/checkService")
	public String checkService(HttpServletRequest request,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();
		model.addAttribute("success", false);
		String wsdl = (String) request.getParameter("wsdl");
		String trId = (String) request.getParameter("trId");
		map.put("trId", trId);
		if(StringUtil.isNotEmpty(wsdl)) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(wsdl).openConnection();
				// 超时
				connection.setUseCaches(false);
				connection.setConnectTimeout(30000);
				connection.setReadTimeout(30000);
				if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
					map.put("wsStatus", 1);
				}else{
					map.put("wsStatus", 0);
				}
			}catch (IOException ex){
				map.put("wsStatus", 0);
			}
		}else{
			map.put("wsStatus", 0);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}

	/**
	 * 统计服务被访问次数
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getServiceAccessCount")
	public String getServiceAccessCount(@RequestParam("webServiceName") String webServiceName
			,@RequestParam("trId") String trId
			,HttpServletRequest request,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();
		model.addAttribute("success", false);
		String beginDate = (String) request.getParameter("beginDate");
		String endDate = (String) request.getParameter("endDate");
		Criteria criteria = new Criteria("WEB_SERVICE_NAME",webServiceName);
		/*请求时间*/
		Date begin = DateUtil.parseDateString(beginDate);
		Date end = DateUtil.parseDateString(endDate);
		DateUtil.getCriteriaByDateRange(criteria, "START_TIME", begin,end);
		map.put("trId", trId);
		map.put("accessCount", wsServiceInfoService.getServiceAccessCount(criteria));
		return EHRMessageUtil.returnMsg(model, map);
	}
}
