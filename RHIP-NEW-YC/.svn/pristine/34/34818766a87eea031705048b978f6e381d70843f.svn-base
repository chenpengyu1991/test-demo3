package com.founder.rhip.hsa.controller.insp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RoleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.hsa.controller.HsaController;
import com.founder.rhip.hsa.service.IInspRecordService;
import com.founder.rhip.hsa.service.IReportRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 报告登记
 * 
 * @author liuk
 * 
 */
@Controller
public class ReportRecordController extends HsaController {

	private final static String CONTROLLER_NAME = "报告登记";

	@Resource(name = "hsaReportRecordService")
	private IReportRecordService reportRecordService;

	@Resource(name = "inspRecordService")
	private IInspRecordService inspRecordService;
	
    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

	@RequestMapping(value = "/hsa/inspRecord/reportRecordList")
	public String locationList(ModelMap model) {
        model.addAttribute("currentYearStartDate",getCurrentYearStartDate());
		return "rhip.hsa.insp.reportRecord.list";
	}

	@RequestMapping(value = "/hsa/inspRecord/reportRecordListResult")
	public String locationListResult(ReportReocrdQueryForm form, HttpServletRequest request, ModelMap model) {
		Criteria criteria = form.toCriteria();
        if(hasRole(RoleType.QWGZX,request) && !criteria.contains("createGbcode")){
            criteria.add("createGbcode",getCurrentOrg(request).getGbCode());
        }
        String orgCode = getCurrentOrg(request).getOrganCode();
        if(hasRole(RoleType.ZXWJ,request)){
            List<Organization> organizationList = organizationService.getOrganizations(new Criteria("parentCode",orgCode));
			organizationList.add(getCurrentOrg(request));
            String[] strings = new String[organizationList.size()];
			for(int i = 0;i<organizationList.size();i++){
				strings[i] = organizationList.get(i).getOrganCode();
			}
			criteria.add("CREATE_ORGAN_CODE",OP.IN,strings);
        }if(hasRole(RoleType.ZWJ,request)) {
        	criteria.add("CREATE_ORGAN_CODE",orgCode);
        }
        
		List<ReportRecord> reportRecords = reportRecordService.getPagedReportRecords(buildPage(request), criteria, getHrRole(request), getCurrentOrg(request));
		model.addAttribute("reportRecords", reportRecords);
		model.addAttribute("currentUserOrganCode", getCurrentOrg(request).getOrganCode());
		return "rhip.hsa.insp.reportRecord.listResult";
	}

	@RequestMapping(value = "/hsa/inspRecord/addReportRecord")
	public String addReportRecord(ModelMap model, HttpServletRequest request) {
		ReportRecord record = reportRecordService.addRecord(getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
		model.put("reportRecord", record);
		return "rhip.hsa.insp.reportRecord.add";
	}

	@RequestMapping(value = "/hsa/inspRecord/saveReportRecord")
	@ResponseBody
	public Object saveReportRecord(ReportRecord record, HttpServletRequest request) {
		Object result = true;
		try {
			if (ObjectUtil.isNullOrEmpty(record.getId())) {
				reportRecordService.saveRecord(record, getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
				record(request, OperationName.ADD);
			} else {
				reportRecordService.updateRecord(record, getCurrentOrg(request), getCurrentUser(request));
				record(request, OperationName.UPDATE);
			}
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("保存报告失败", e);
		}
		return result;
	}

	@RequestMapping(value = "/hsa/inspRecord/viewReportRecord")
	public String viewReportRecord(@RequestParam("id") Long id, ModelMap model, HttpServletRequest request) {
		ReportRecord record = getReportRecordByid(id);
		Long inspId = record.getInspReocrdId();
		if (null != inspId) {
			LocationInfo locationInfo = getLocationByInspId(inspId);
			model.put("locationInfo", locationInfo);
		}
		model.put("reportRecord", record);
		return "rhip.hsa.insp.reportRecord.view";
	}

	@RequestMapping(value = "/hsa/inspRecord/editReportRecord")
	public String editReportRecord(@RequestParam("id") Long id, ModelMap model, HttpServletRequest request) {
		ReportRecord record = getReportRecordByid(id);
		Long inspId = record.getInspReocrdId();
		if (null != inspId) {
			LocationInfo locationInfo = getLocationByInspId(id);
			model.put("locationInfo", locationInfo);
		}
		model.put("reportRecord", record);
		return "rhip.hsa.insp.reportRecord.add";
	}

	private LocationInfo getLocationByInspId(Long id) {
		LocationInfo locationInfo = inspRecordService.getInspLocationByInspId(id);
		return locationInfo;
	}

	private ReportRecord getReportRecordByid(Long id) {
		ReportRecord record = reportRecordService.getRecord(new Criteria("id", id));
		return record;
	}

	@RequestMapping(value = "/hsa/inspRecord/receiveReportRecord")
	@ResponseBody
	public Object receiveReportRecord(@RequestParam("id") Long id, ModelMap model, HttpServletRequest request) {
		boolean result = true;
		try {
			reportRecordService.receiveReportRecord(id, getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
			record(request, OperationName.CHECK);
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("接收失败", e);
		}
		return result;
	}

	@RequestMapping(value = "/hsa/inspRecord/showDealReportRecord")
	public String showDealReportRecord(@RequestParam("id") Long id, ModelMap model, HttpServletRequest request) {
		ReportRecord record = new ReportRecord();
		record.setId(id);
		record.setDealDate(new Date());
		model.put("reportRecord", record);
		return "rhip.hsa.insp.reportRecord.deal";
	}

	@RequestMapping(value = "/hsa/inspRecord/dealReportRecord")
	@ResponseBody
	public Object doDealReportRecord(ReportRecord record, ModelMap model, HttpServletRequest request) {
		boolean result = true;
		try {
			reportRecordService.dealReportRecord(record, getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
			record(request, OperationName.CHECK);
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("处理意见保存失败", e);
		}
		return result;
	}

	@RequestMapping(value = "/hsa/inspRecord/showVisitReportRecord")
	public String showVisitReportRecord(@RequestParam("id") Long id, ModelMap model, HttpServletRequest request) {
		ReportRecord record = new ReportRecord();
		record.setId(id);
		record.setVisitDate(new Date());
		model.put("reportRecord", record);
		return "rhip.hsa.insp.reportRecord.visit";
	}

	@RequestMapping(value = "/hsa/inspRecord/visitReportRecord")
	@ResponseBody
	public Object doVisitReportRecord(ReportRecord record, ModelMap model, HttpServletRequest request) {
		boolean result = true;
		try {
			reportRecordService.visitReportRecord(record, getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
			record(request, OperationName.CHECK);
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("回访意见保存失败", e);
		}
		return result;
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

}
