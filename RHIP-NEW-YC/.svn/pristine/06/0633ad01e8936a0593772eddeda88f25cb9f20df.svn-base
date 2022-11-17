package com.founder.rhip.hsa.controller.insp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.RoleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.hsa.InspGuideRecord;
import com.founder.rhip.ehr.entity.hsa.InspectionRecord;
import com.founder.rhip.hsa.controller.HsaController;
import com.founder.rhip.hsa.service.IInspRecordService;

/**
 * 家庭饮用水
 * 
 * @author liuk
 * 
 */
@Controller
public class FamilyController extends HsaController {

	private final static String CONTROLLER_NAME = "家庭饮用水";

	@Resource(name = "inspRecordService")
	private IInspRecordService inspRecordService;

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

	@RequestMapping(value = "/hsa/inspRecord/familyList")
	public String familyList(HttpServletRequest request, ModelMap model) {
		model.addAttribute("type", EHRConstants.INSP_LOC_TYPE_FAMILY);
        model.addAttribute("currentYearStartDate",getCurrentYearStartDate());
		return "rhip.hsa.insp.familyList";
	}

	@RequestMapping(value = "/hsa/inspRecord/familyListResult")
	public String searchFamily(QueryForm form, HttpServletRequest request, ModelMap model) {
		form.setLocationInfoPrefix("locationInfo");
		form.setFamilyInfoPrefix("familyInfo");
		form.setInspectionRecordPrefix("inspectionRecord");
		Criteria criteria = form.toCriteria();
		if(hasRole(RoleType.QWGZX,request)){
			if(!criteria.contains("inspectionRecord.CREATE_GBCODE")){
				criteria.add("inspectionRecord.CREATE_GBCODE",getCurrentOrg(request).getGbCode());
			}
		}
		Page page = buildPage(request);
		List<InspectionRecord> inspectionRecords = inspRecordService.getFamilyRecordList(page, criteria, getCurrentOrg(request), getHrRole(request));
		model.addAttribute("type", EHRConstants.INSP_LOC_TYPE_FAMILY);
		model.addAttribute("inspectionRecords", inspectionRecords);
		return "rhip.hsa.insp.familyListResult";
	}

	@RequestMapping(value = "/hsa/inspRecord/familyRecordAdd")
	public String familyRecordAdd(HttpServletRequest request, ModelMap model) {
		InspectionRecord inspRecord = new InspectionRecord();
		inspRecord.setInspDate(new Date());
		inspRecord.setInspPersonCode(getCurrentUser(request).getStaffCode());
		inspRecord.setInspLocType(EHRConstants.INSP_LOC_TYPE_FAMILY);
		InspGuideRecord inspGuideRecord = new InspGuideRecord();
		inspRecord.setInspGuideRecord(inspGuideRecord);
		inspRecord.setFindMainPro("无");
		inspGuideRecord.setDosp("2");
		inspGuideRecord.setDostv("2");
		model.addAttribute("type", EHRConstants.INSP_LOC_TYPE_FAMILY);
		model.addAttribute("inspRecord", inspRecord);
		return "rhip.hsa.insp.familyRecordAdd";
	}

	@RequestMapping(value = "/hsa/inspRecord/familyRecordModify")
	public String familyRecordModify(@RequestParam("id") Long id, ModelMap model) {
		InspectionRecord inspRecord = inspRecordService.getFamilyRecord(id);
		model.addAttribute("type", EHRConstants.INSP_LOC_TYPE_FAMILY);
		model.addAttribute("inspRecord", inspRecord);
		return "rhip.hsa.insp.familyRecordAdd";
	}
	
	@RequestMapping(value = "/hsa/inspRecord/familyRecordView")
	public String familyRecordView(@RequestParam("id") Long id, ModelMap model) {
		InspectionRecord inspRecord = inspRecordService.getFamilyRecord(id);
		model.addAttribute("inspRecord", inspRecord);
		return "rhip.hsa.insp.familyRecordView";
	}

	@RequestMapping(value = "/hsa/inspRecord/familyRecordSave")
	@ResponseBody
	public Object familyRecordSave(InspectionRecord inspRecord, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		try {
			Long id = inspRecord.getId();
			inspRecordService.saveFamilyRecord(inspRecord, getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
			if (ObjectUtil.isNullOrEmpty(id)) {
				record(request, OperationName.ADD);
			} else {
				record(request, OperationName.UPDATE);
			}
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("保存家庭工作登记失败", e);
		}
		return result;
	}

}
