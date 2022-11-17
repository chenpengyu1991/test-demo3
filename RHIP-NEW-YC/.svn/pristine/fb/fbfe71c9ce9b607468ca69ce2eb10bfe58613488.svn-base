package com.founder.rhip.ehr.controller.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.founder.rhip.ehr.entity.basic.PersonInfoMoveExport;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPersonMoveService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
/**
 * 档案迁移
 * @author ggf
 *
 */
@Controller
@RequestMapping("/personMove")
public class PersonMoveController extends BaseController {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "personMoveInfoService")
	private IPersonMoveService personMoveService;
	
	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;
	
	@RequestMapping("/result")
	public String personMoveList(HttpServletRequest request, ModelMap model){
		Criteria criteria = getPersonMoveCriteria(request);
		criteria.add("oldStationCode", OP.IS,"NOT NULL");
		Order order = new Order("OPERATION_DATE", false);
		PageList<PersonMoveInfo> personMoves = personMoveService.getPersonMoveRecoedList(criteria, buildPage(request,"/personMove/result"), order);
		model.addAttribute("personMoveInfos", personMoves.getList());
		model.addAttribute("movePage", personMoves.getPage());
		return "rhip.ehr.personMove.result";
	}
	
	/**
	 * 查询条件组装
	 * @param request
	 * @return
	 */
	private Criteria getPersonMoveCriteria(HttpServletRequest request){
		Criteria criteria = new Criteria();
		String personName = request.getParameter("personMoveName");
		//姓名
		if(ObjectUtil.isNotEmpty(personName)){
			criteria.add("personName", OP.LIKE, personName);
		}
		//迁移时间
		Date moveBeginDate = DateUtil.parseSimpleDate(request.getParameter("moveBeginDate"), null);
		Date moveEndDate = DateUtil.parseSimpleDate(request.getParameter("moveEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "operationDate", moveBeginDate, moveEndDate);
		//迁入机构
		if(StringUtils.isNotEmpty((String) request.getParameter("moveInStation"))){
			String orgCode = (String) request.getParameter("moveInStation");
			criteria.add("newStationCode", orgCode);
		}else if(StringUtils.isNotEmpty((String) request.getParameter("moveInCenter"))){
			String orgCode = (String) request.getParameter("moveInCenter");
			List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("newStationCode", OP.IN, orgCodes);
			}else {
				criteria.add("newStationCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}else if(StringUtils.isNotEmpty((String) request.getParameter("moveInTown"))){
			String gBCode = (String) request.getParameter("moveInTown");
			List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("newStationCode", OP.IN, orgCodes);
			}else {
				criteria.add("newStationCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}
		//迁出机构
		if(StringUtils.isNotEmpty((String) request.getParameter("moveOutStation"))){
			String orgCode = (String) request.getParameter("moveOutStation");
			criteria.add("oldStationCode", orgCode);
		}else if(StringUtils.isNotEmpty((String) request.getParameter("moveOutCenter"))){
			String orgCode = (String) request.getParameter("moveOutCenter");
			List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("oldStationCode", OP.IN, orgCodes);
			}else {
				criteria.add("oldStationCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}else if(StringUtils.isNotEmpty((String) request.getParameter("moveOutTown"))){
			String gBCode = (String) request.getParameter("moveOutTown");
			List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("oldStationCode", OP.IN, orgCodes);
			}else {
				criteria.add("oldStationCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
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
		final Criteria criteria = getPersonMoveCriteria(request);
		final Order order = new Order("OPERATION_DATE", false);
		excelExportService.exportListExecl("档案迁移列表", PersonInfoMoveExport.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				return personMoveService.exportMovePersonRecordList(page, criteria, order);
			}
		});
	}
}