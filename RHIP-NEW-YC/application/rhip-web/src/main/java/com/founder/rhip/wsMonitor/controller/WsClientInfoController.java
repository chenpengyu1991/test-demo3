package com.founder.rhip.wsMonitor.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceClient;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceInfo;
import com.founder.rhip.ehr.service.wsMonitor.IWsClientInfoService;
import com.founder.rhip.ehr.service.wsMonitor.IWsServiceInfoService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/wsMonitor/clientInfo")
public class WsClientInfoController extends BaseController {
	@Resource(name = "wsClientInfoService")
	private IWsClientInfoService wsClientInfoService;

	@Resource(name = "wsServiceInfoService")
	private IWsServiceInfoService wsServiceInfoService;

	@Resource
	private IOrganizationApp organizationApp;

	/**
	 * 客户端注册查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/register/search")
	public String searchRegister(ModelMap model, HttpServletRequest request) {
		model.addAttribute("serviceInfos", wsServiceInfoService.getList(new Criteria(), new Order("CREATE_DATE", false)));
		return "rhip.wsMonitor.clientRegister.search";
	}

	/**
	 * 客户端注册查询列表
	 * @param wsClientInfo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/list")
	public String listRegister(WsClientInfo wsClientInfo, String serviceId, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = this.getClientInfoCriteria(wsClientInfo, serviceId);
		String[] requiredProperties = new String[] {};
		Order order = new Order("CREATE_DATE", false);
		PageList<WsClientInfo> plist = wsClientInfoService.getPageList(page,criteria,order,requiredProperties);
		model.addAttribute("wsClientInfos", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.wsMonitor.clientRegister.list";
	}

	/**
	 * 客户端新增初始页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/register/add")
	public String addRegister(String id, ModelMap model, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		String[] requiredProperties = new String[] {};
		Order order = new Order("CREATE_DATE", false);
		/**所有服务器端**/
		List<WsServiceInfo> list = wsServiceInfoService.getList(criteria,order,requiredProperties);
		//是修改
		if(null != id && id != "") {
			/**关联的服务器端**/
			List<WsServiceClient> wsServiceClients = wsServiceInfoService.getWsServiceClientList(new Criteria("clientId", id));
			for(WsServiceInfo wsServiceInfo : list) {
				for (WsServiceClient selected : wsServiceClients) {
					if (wsServiceInfo.getId().equals(selected.getServiceId())) {
						wsServiceInfo.setCheck("1");//选中
						break;
					}
				}
			}
			WsClientInfo wsClientInfo = wsClientInfoService.getWsClientInfo(new Criteria("ID", id));
			model.addAttribute("clientInfo", wsClientInfo);
		}
		model.addAttribute("wsServiceInfos", list);
		return "rhip.wsMonitor.clientRegister.add";
	}

	/**
	 * 客户端新增
	 * @param wsClientInfo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/save")
	public String saveRegister(String serviceIds, WsClientInfo wsClientInfo, HttpServletRequest request, ModelMap model) {
		String returnFlag = "success";
		WsClientInfo wsClientInfoOld = wsClientInfoService.getWsClientInfo(new Criteria("userIp",wsClientInfo.getUserIp()));
		if(null != wsClientInfoOld && wsClientInfoOld.getId()>0 && wsClientInfo.getId()==null) {
//			userIp不能相同
			returnFlag = "exist";
			return EHRMessageUtil.returnMsg(model,returnFlag);
		}
		if(null != wsClientInfo.getId() && wsClientInfo.getId()>0){
			wsClientInfo.setUpdateDate(new Date());
			wsClientInfo.setUpdateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			wsClientInfo.setUpdateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
		}else{
			wsClientInfo.setCreateDate(new Date());
			wsClientInfo.setCreateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			wsClientInfo.setCreateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
		}
		wsClientInfo.setOrgName(organizationApp.queryOrganName(wsClientInfo.getOrgCode()));
		wsClientInfo.setIsOff(EHRConstants.IS_OFF_ENABLE);
		Long id = wsClientInfoService.saveWsClientInfo(wsClientInfo, serviceIds, request);
		if(id==0) {
			returnFlag = "fail";
		}
		return EHRMessageUtil.returnMsg(model,returnFlag);
	}

	/**
	 * 改变客户端禁用状态
	 * @param id
	 * @param isOff
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/changeOff")
	public String changeOffRegister(String id, String isOff, HttpServletRequest request, ModelMap model) {
		String returnFlag = "success";
		WsClientInfo wsClientInfo = wsClientInfoService.getWsClientInfo(new Criteria("ID", id));
		wsClientInfo.setIsOff(isOff);
		wsClientInfo.setUpdateDate(new Date());
		wsClientInfo.setUpdateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
		wsClientInfo.setUpdateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
		Long returnId = wsClientInfoService.editWsClientInfo(wsClientInfo, "isOff");
		if(!(returnId>0)) {
			returnFlag = "fail";
		}
		return EHRMessageUtil.returnMsg(model, returnFlag);
	}

	@RequestMapping("/monitor/search")
	public String searchMonitor(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentDate", new Date());
		return "rhip.wsMonitor.clientMonitor.search";
	}

	@RequestMapping("/monitor/list")
	public String searchMonitor(WsClientInfo wsClientInfo,HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);

		String beginDate = (String) request.getParameter("beginDate");
		String endDate = (String) request.getParameter("endDate");
		Criteria criteria = this.getServiceInfoCriteria(wsClientInfo);

		PageList<WsClientInfo> plist = wsClientInfoService.getAccessMap(page,beginDate,endDate,criteria);
		model.addAttribute("wsClientInfos", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.wsMonitor.clientMonitor.list";
	}

	private Criteria getServiceInfoCriteria(WsClientInfo wsClientInfo) {
		Criteria criteria = new Criteria();
		/*机构编码*/
		if(StringUtil.isNotEmpty(wsClientInfo.getOrgCode())) {
			criteria.add("info.ORG_CODE", wsClientInfo.getOrgCode());
		}
		/*禁用标志*/
		if(StringUtil.isNotEmpty(wsClientInfo.getIsOff())) {
			criteria.add("info.IS_OFF", wsClientInfo.getIsOff());
		}
		return criteria;
	}

	private Criteria getClientInfoCriteria(WsClientInfo wsClientInfo, String serviceId) {
		Criteria criteria = new Criteria();
		/*机构编码*/
		if(StringUtil.isNotEmpty(wsClientInfo.getOrgCode())) {
			criteria.add("ORG_CODE", wsClientInfo.getOrgCode());
		}
		/*来访机器IP地址*/
		if(StringUtil.isNotEmpty(wsClientInfo.getUserIp())) {
			criteria.add("USER_IP", OP.LIKE, wsClientInfo.getUserIp());
		}
		/*禁用标志*/
		if(StringUtil.isNotEmpty(wsClientInfo.getIsOff())) {
			criteria.add("IS_OFF", wsClientInfo.getIsOff());
		}
		if(StringUtil.isNotEmpty(serviceId)) {
			List<WsServiceClient> serviceClientList = wsServiceInfoService.getWsServiceClientList(new Criteria("SERVICE_ID", serviceId));
			List<Long> serviceList = new ArrayList<Long>();
			for(WsServiceClient serviceClient : serviceClientList) {
				serviceList.add(serviceClient.getClientId());
			}
			criteria.add("id", OP.IN, serviceList);
		}

		return criteria;
	}

	/**
	 * 禁用，启用客户端
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/changeOff")
	public String changeOff(HttpServletRequest request,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();
		model.addAttribute("success", false);
		String orgCode = (String) request.getParameter("orgCode");
		String isOff = (String) request.getParameter("isOff");
		if(StringUtil.isNotEmpty(orgCode)) {
			int result = wsClientInfoService.changeOff(orgCode,isOff);
			map.put("wsStatus", result);
		}else{
			map.put("wsStatus", 0);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}

	/**
	 * 删除客户端
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteClient(Long id, HttpServletRequest request, ModelMap model) {
		String returnFlag = "success";
		wsClientInfoService.deleteClient(id);
		return EHRMessageUtil.returnMsg(model,returnFlag);
	}
}
