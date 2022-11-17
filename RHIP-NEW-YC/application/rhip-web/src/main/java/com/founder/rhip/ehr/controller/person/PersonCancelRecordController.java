package com.founder.rhip.ehr.controller.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoExport;
import com.founder.rhip.ehr.service.ILifeEventService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPersonCanceledService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
/**
 * 档案注销
 * @author ggf
 *
 */
@Controller
@RequestMapping("/personCancel")
public class PersonCancelRecordController extends BaseController {
	
	@Autowired
	private IPersonCanceledService personCanceledService;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "lifeEventService")
	private ILifeEventService lifeEventService;
	
	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;
	
	/**
	 * 进入档案注销查询页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String personCancelSearch(HttpServletRequest request, ModelMap model){
		return "rhip.ehr.personCancel.list";
	}
	
	/**
	 * 查询结果
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/result")
	public String personCancelList(HttpServletRequest request, ModelMap model){
		Criteria criteria = getCriteria(request);
		Order order = new Order("CANCELED_DATE DESC, PERSON_ID DESC");
		PageList<PersonCanceledInfo> personCancelInfos = personCanceledService.getCancelPersonRecordPageList(criteria, buildPage(request,"/personCancel/result"), order);
		model.addAttribute("personCancelInfos", personCancelInfos.getList());
		model.addAttribute("cancelPage", personCancelInfos.getPage());
		return "rhip.ehr.personCancel.result";
	}
	
	/**
	 * 查询结果
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String personCancelDetail(String idCard,HttpServletRequest request, ModelMap model){
		Criteria criteria = new Criteria("idCard", idCard);
		model.addAttribute("personDeathRecord", lifeEventService.query(criteria));
		return "rhip.ehr.personCancel.detail";
	}
	
	/**
	 * 查询条件组装
	 * @param request
	 * @return
	 */
	private Criteria getCriteria(HttpServletRequest request){
		Criteria criteria = new Criteria();
		criteria.add("canceledStatus", EHRConstants.CANCELED);
		String personName = request.getParameter("personName");
		//姓名
		if(ObjectUtil.isNotEmpty(personName)){
			criteria.add("personName", OP.LIKE, personName);
		}
		//注销时间
		Date cancelBeginDate = DateUtil.parseSimpleDate(request.getParameter("cancelBeginDate"), null);
		Date cancelEndDate = DateUtil.parseSimpleDate(request.getParameter("cancelEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "canceledDate", cancelBeginDate, cancelEndDate);

        //注销原因
		String calcenReason = request.getParameter("canceledReason");
		if(ObjectUtil.isNotEmpty(calcenReason)){
			criteria.add("canceledReason", calcenReason);
		}
        //死亡时间
        Date deathBeginDate = DateUtil.parseSimpleDate(request.getParameter("deathBeginDate"), null);
        Date deathEndDate = DateUtil.parseSimpleDate(request.getParameter("deathEndDate"), null);
        if(ObjectUtil.isNotEmpty(deathBeginDate) || ObjectUtil.isNotEmpty(deathEndDate)) {
            DateUtil.getCriteriaByDateRange(criteria, "canceledReasonDate", deathBeginDate, deathEndDate);
            //结案原因默认为 “死亡”
            criteria.add("canceledReason", "1");
        }
		//
		//注销机构
		if(StringUtils.isNotEmpty((String) request.getParameter("searchstation"))){
			String orgCode = (String) request.getParameter("searchstation");
			criteria.add("canceledOrganCode", orgCode);
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchCenter"))){
			String orgCode = (String) request.getParameter("searchCenter");
			List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("canceledOrganCode", OP.IN, orgCodes);
			}else {
				criteria.add("canceledOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchTown"))){
			String gBCode = (String) request.getParameter("searchTown");
			List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("canceledOrganCode", OP.IN, orgCodes);
			}else {
				criteria.add("canceledOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}
		
		return criteria;
	}
	
	/**
	 * 分页
	 * @param request
	 * @return
	 */
	private Page buildPage(HttpServletRequest request,String url) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = 1;
		try {
			currentPage = Integer.valueOf(indexPage);
		} catch (Exception e) {
			// log.warn("没有当前页数");
		}
		Page page = super.getPage(request, currentPage);
		//request.setAttribute("page", page);
		return page;
	}
	
	@RequestMapping("/export")
	public void exportPersonInfoList(HttpServletRequest request, HttpServletResponse response) {
		final Criteria criteria = getCriteria(request);
		final Order order = new Order("CANCELED_DATE DESC, PERSON_ID DESC");
		excelExportService.exportListExecl("档案结案列表", PersonInfoExport.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				return personCanceledService.exportCancelPersonRecordList(page, criteria, order);
			}
		});
	}
}