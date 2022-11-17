package com.founder.rhip.hsa.controller.insp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RoleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.InspectionRecord;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.hsa.controller.HsaController;
import com.founder.rhip.hsa.service.IInspRecordService;
import com.founder.rhip.hsa.service.ILocationService;
import com.founder.rhip.hsa.service.IReportRecordService;

/**
 * 工作登记
 * 
 * @author liuk
 * 
 */
@Controller
public class InspController extends HsaController {

	private final static String CONTROLLER_NAME = "日常巡查";
	@Resource(name = "uploadInfoRecordService")
    private IUploadInfoRecordService uploadInfoRecordService;
	@Resource(name = "hsaLocationService")
	private ILocationService locationService;

	@Resource(name = "hsaReportRecordService")
	private IReportRecordService reportRecordService;

	@Resource(name = "inspRecordService")
	private IInspRecordService inspRecordService;

	@RequestMapping(value = "hsa/inspRecord/list")
	public String list(ModelMap model) {
        model.addAttribute("currentYearStartDate",getCurrentYearStartDate());
		return "rhip.hsa.insp.list";
	}

	@RequestMapping(value = "hsa/inspRecord/listResult")
	public String listResult(QueryForm form, HttpServletRequest request, ModelMap model) {
		Criteria criteria = form.toCriteria();
		if(hasRole(RoleType.QWGZX,request)){
			if(!criteria.contains("HSA_INSPECTION_RECORD.CREATE_GBCODE")){
				criteria.add("HSA_INSPECTION_RECORD.CREATE_GBCODE",getCurrentOrg(request).getGbCode());
			}
		}
		//			else if (hasRole(RoleType.ZXWJ, request)) {
//			 criteria.add("HSA_INSPECTION_RECORD.CREATE_CENTER_ORGAN_CODE", getCurrentOrg(request).getOrganCode());
//		} else if (hasRole(RoleType.ZWJ, request)) {
//			criteria.add("HSA_INSPECTION_RECORD.CREATE_ORGAN_CODE", getCurrentOrg(request).getOrganCode());
//		}
		criteria.add("HSA_INSPECTION_RECORD.INSP_LOC_TYPE", EHRConstants.INSP_LOC_TYPE_LOCATION);
		PageList<InspectionRecord> list = inspRecordService.getPagedLocationRecordList(buildPage(request), criteria, getHrRole(request), getCurrentOrg(request));
		model.addAttribute("inspectionRecordList", list.getList());
		return "rhip.hsa.insp.listResult";
	}

	@RequestMapping(value = "/hsa/inspRecord/add")
	public String add(ModelMap model, HttpServletRequest request) {
		InspectionRecord inspRecord = new InspectionRecord();
		inspRecord.setInspDate(new Date());
		User user = getCurrentUser(request);
		ReportRecord record = reportRecordService.addRecord(getCurrentOrg(request), user, getHrRole(request));
		inspRecord.setReportRecord(record);
		inspRecord.setInspPersonCode(user.getStaffCode());
		model.addAttribute("inspRecord", inspRecord);
		model.addAttribute("flag", "add");
		return "rhip.hsa.insp.add";
	}

	@RequestMapping(value = "/hsa/inspRecord/view")
	public String view(@RequestParam(value = "locationId") Long locationId, @RequestParam(value = "id") Long id, @RequestParam(value = "flag") String flag, HttpServletRequest request, ModelMap model) {
		InspectionRecord inspRecord = inspRecordService.getRecordForUpdate(new Criteria("id", id));
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",inspRecord.getId()).add("FILE_RESOURCE", "inspectionRecord"));
        model.addAttribute("attchesHbp", uploadInfoRecords);
        List<UploadInfoRecord> uploadInfoHsoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",inspRecord.getId()).add("FILE_RESOURCE", "healthSupervisionOpinion"));
        model.addAttribute("attchesHso", uploadInfoHsoRecords);
        
		model.addAttribute("inspRecord", inspRecord);
		return "rhip.hsa.insp.view";
	}

	@RequestMapping(value = "/hsa/inspRecord/edit")
	public String addLocationSearchOrModify(@RequestParam(value = "id") Long id, HttpServletRequest request, ModelMap model) {
		InspectionRecord inspRecord = getInspForUpdate(id, request);
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",inspRecord.getId()).add("FILE_RESOURCE", "inspectionRecord"));
        model.addAttribute("attchesHbp", uploadInfoRecords);
        List<UploadInfoRecord> uploadInfoHsoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",inspRecord.getId()).add("FILE_RESOURCE", "healthSupervisionOpinion"));
        model.addAttribute("attchesHso", uploadInfoHsoRecords);
		model.addAttribute("locationInfo", inspRecord.getLocationInfo());
		model.addAttribute("locationId", id);
		model.addAttribute("inspRecord", inspRecord);
		model.addAttribute("flag", "modify");
		return "rhip.hsa.insp.edit";
	}

	@RequestMapping(value = "/hsa/inspRecord/save")
	@ResponseBody
	public String save(InspectionRecord inspectionRecord, HttpServletRequest request) {
		String result = "error";
		try { 
			 Map<String, Map<String, String>> linkMap =new HashMap<>();
			 this.getAttchementsValidateResult(inspectionRecord, request, linkMap);
			 /* String resultStr = this.getAttchementsValidateResult(inspectionRecord, request, linkMap);
		        if(ObjectUtil.isNotEmpty(resultStr)){
		            return resultStr;
		        }*/
			inspectionRecord.setInspLocType(EHRConstants.INSP_LOC_TYPE_LOCATION);
			inspRecordService.addRecord(inspectionRecord, getCurrentOrg(request), getCurrentUser(request), getHrRole(request),linkMap);
			result = "success";
			if (ObjectUtil.isNullOrEmpty(inspectionRecord.getId())) {
				record(request, OperationName.ADD);
			} else {
				record(request, OperationName.UPDATE);
			}
			if(ObjectUtil.isNotEmpty(linkMap)) {
                request.getSession().removeAttribute("inspectionRecord_fileMap");
                request.getSession().removeAttribute("healthSupervisionOpinion_fileMap");
            }
		} catch (Exception e) {
			result = "error";
			handleException("保存登记失败", e);
		}
		return result;
	}
	private void getAttchementsValidateResult(InspectionRecord inspectionRecord, HttpServletRequest request, Map<String, Map<String, String>> linkMap) {
        Map<String, Object> mapHbp =new HashMap<>();
        Map<String, String> inspMap = (Map<String, String>) request.getSession().getAttribute("inspectionRecord_fileMap");//附件
        Map<String, String> inspNameMap = (Map<String, String>) request.getSession().getAttribute("inspectionRecord_filenameMap");//附件
        /*mapHbp = validateAttchement(mapHbp, linkMapHbp, inspectionRecord.getId(), "inspectionRecord");
        String resultStr = "";
            if(ObjectUtil.isNotEmpty(mapHbp)) {
                resultStr = "inspMore";
            }*/
        Map<String, Object> mapDi =new HashMap<>();
        Map<String, String> inspHsoMap = (Map<String, String>) request.getSession().getAttribute("healthSupervisionOpinion_fileMap");//附件
        Map<String, String> inspHsoNameMap = (Map<String, String>) request.getSession().getAttribute("healthSupervisionOpinion_filenameMap");//附件
        /*mapDi = validateAttchement(mapDi, linkMapDi, inspectionRecord.getId(), "healthSupervisionOpinion");
            if(ObjectUtil.isNotEmpty(mapDi)) {
                resultStr = resultStr + ";" + "inspHsoMore";
            }*/
        linkMap.put("inspMap", inspMap);
		linkMap.put("inspNameMap", inspNameMap);
		linkMap.put("inspHsoMap", inspHsoMap);
		linkMap.put("inspHsoNameMap", inspHsoNameMap);
	}
    /**
     * 验证附件数量
     * @param map
     * @param fileMap
     * @param resourceId
     * @return
     */
    protected Map<String, Object> validateAttchement(Map<String, Object> map, Map<String, String> fileMap, Long resourceId, String fileResource) {
        if (map == null) {
            throw new IllegalArgumentException("map参数可以为空！");
        }
        int count = 0;
        List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", fileResource));
        if (ObjectUtil.isNotEmpty(fileMap)) {
            count += fileMap.size();
        }
        if (ObjectUtil.isNotEmpty(infoRecords)) {
            count += infoRecords.size();
        }
        if (count > 1) {
            map.put("message", "当慢病类型为高血压或糖尿病时，附件总数量不能大于1！");
            map.put("result", false);
            return map;
        }
        return map;
    }
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

	private InspectionRecord getInspForUpdate(Long id, HttpServletRequest request) {
		InspectionRecord inspRecord = inspRecordService.getRecordForUpdate(new Criteria("id", id));
		ReportRecord record = inspRecord.getReportRecord();
		if (null == record) {
			record = reportRecordService.addRecord(getCurrentOrg(request), getCurrentUser(request), getHrRole(request));
			inspRecord.setReportRecord(record);
		}
		return inspRecord;
	}

}
