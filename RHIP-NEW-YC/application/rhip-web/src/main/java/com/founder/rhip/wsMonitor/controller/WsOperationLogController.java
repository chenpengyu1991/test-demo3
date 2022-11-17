package com.founder.rhip.wsMonitor.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import com.founder.rhip.ehr.service.wsMonitor.IWsServiceInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/wsMonitor/log")
public class WsOperationLogController extends BaseController {
	@Resource(name = "wsServiceInfoService")
	private IWsServiceInfoService wsServiceInfoService;

	@RequestMapping("/search")
	public String searchMonitor(ModelMap model, HttpServletRequest request) {
		return "rhip.wsMonitor.log.search";
	}

	@RequestMapping("/list")
	public String searchMonitor(WsOperationLog wsOperationLog,HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);

		String beginDate = (String) request.getParameter("beginDate");
		String endDate = (String) request.getParameter("endDate");
		Criteria criteria = this.getLogCriteria(wsOperationLog);
		/*请求时间*/
		Date begin = DateUtil.parseDateString(beginDate);
		Date end = DateUtil.parseDateString(endDate);
		DateUtil.getCriteriaByDateRange(criteria, "startTime", begin,end);

		PageList<WsOperationLog> plist = wsServiceInfoService.getLogList(page,criteria,new Order("START_TIME",false));

		for (WsOperationLog log:plist.getList()){
			WsClientInfo clientInfo = wsServiceInfoService.getWsClientInfo(new Criteria("USER_IP",log.getUserIp()));
			if(ObjectUtil.isNotEmpty(clientInfo)){
				log.setOrgCode(clientInfo.getOrgCode());
			}
		}
		model.addAttribute("logInfos", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.wsMonitor.log.list";
	}

	@RequestMapping("/view")
	public String viewMessage(HttpServletRequest request, ModelMap model){
		String id = (String) request.getParameter("id");
		if(StringUtil.isNotEmpty(id)){
			WsOperationLog log = wsServiceInfoService.getWsOperationLog(new Criteria("id",id));
			if(ObjectUtil.isNotEmpty(log)){
				WsClientInfo clientInfo = wsServiceInfoService.getWsClientInfo(new Criteria("USER_IP",log.getUserIp()));
				if(ObjectUtil.isNotEmpty(clientInfo)){
					log.setOrgCode(clientInfo.getOrgCode());
				}
				model.addAttribute("logInfo",log);
			}
		}
		return "rhip.wsMonitor.log.view";
	}
	private Criteria getLogCriteria(WsOperationLog wsOperationLog) {
		Criteria criteria = new Criteria();
		/*IP地址*/
		if(StringUtil.isNotEmpty(wsOperationLog.getUserIp())) {
			criteria.add("USER_IP", wsOperationLog.getUserIp());
		}
		/*处理成功标志*/
		if(StringUtil.isNotEmpty(wsOperationLog.getIsSuccess())) {
			criteria.add("IS_SUCCESS", wsOperationLog.getIsSuccess());
		}
		
		/*接口名称*/
		if(StringUtil.isNotEmpty(wsOperationLog.getWebServiceName())) {
			criteria.add("WEB_SERVICE_NAME", wsOperationLog.getWebServiceName());
		}
		/*方法名称*/
		if(StringUtil.isNotEmpty(wsOperationLog.getWsMethodName())) {
			criteria.add("WS_METHOD_NAME", wsOperationLog.getWsMethodName());
		}
		return criteria;
	}

}
