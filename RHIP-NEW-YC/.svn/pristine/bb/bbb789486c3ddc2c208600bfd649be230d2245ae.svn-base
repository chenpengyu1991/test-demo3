package com.founder.rhip.hsa.controller.insp;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.rhip.cdm.controller.standardization.DiFollowupExportDef;
import com.founder.rhip.cdm.controller.standardization.HbpFollowupExport;
import com.founder.rhip.cdm.controller.standardization.StrtumFollowupExportDef;
import com.founder.rhip.cdm.controller.standardization.TumorFollowupExportDef;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.hsa.controller.HsaController;
import com.founder.rhip.hsa.service.ILocationService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;

/**
 * 基础档案管理
 * 
 * @author liuk
 * 
 */
@Controller
public class LocationController extends HsaController {

	private final static String CONTROLLER_NAME = "基础档案管理";

	@Resource(name = "hsaLocationService")
	private ILocationService locationService;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

	@RequestMapping(value = "/hsa/inspRecord/locationList")
	public String locationList(HttpServletRequest request, ModelMap model) {
		if (hasRole(RoleType.JKWJ, request)){
            model.put("ROLE", RoleType.JKWJ.getValue());
            model.put("townValue", "");
        }
        if (hasRole(RoleType.ZXWJ, request) ){
            model.put("ROLE", RoleType.ZXWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
        if (hasRole(RoleType.ZWJ, request) ){
            model.put("ROLE", RoleType.ZWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
		
		model.addAttribute("type", EHRConstants.INSP_LOC_TYPE_LOCATION);
		addAreaCodeLimit(request, model);
		return "rhip.hsa.insp.locationList";
	}

	private void addAreaCodeLimit(HttpServletRequest request, ModelMap model) {
		RoleType roleType = getHrRole(request);
		if (roleType.equals(RoleType.ZXWJ)) {
			List<String> areaCodes = locationService.getManagedAreaCode(getCurrentOrg(request).getOrganCode());
			model.addAttribute("areaCodes", StringUtil.join(areaCodes, ","));
		}
	}

	@RequestMapping(value = "/hsa/inspRecord/locationListResult")
	public String locationListResult(QueryForm form, HttpServletRequest request, ModelMap model) {
		Criteria criteria = form.toCriteria();
		criteria.remove("HSA_INSPECTION_RECORD.CREATE_GBCODE");
		
        String orgCode = getCurrentOrg(request).getOrganCode();
        if(hasRole(RoleType.ZWJ,request)){
            criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",orgCode);
        }
        if(hasRole(RoleType.ZXWJ,request)){
//            List<Organization> organizationList = organizationService.getOrganizations(new Criteria("parentCode",orgCode));
//			organizationList.add(getCurrentOrg(request));
//            String[] strings = new String[organizationList.size()];
//			for(int i = 0;i<organizationList.size();i++){
//				strings[i] = organizationList.get(i).getOrganCode();
//			}
//			criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",OP.IN,strings);
			criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE", getCurrentOrg(request).getOrganCode());//站不做业务，只需查中心
        }else{
        	if (ObjectUtil.isNotEmpty(form.getCreateOrganCode())) {
        		criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE", form.getCreateOrganCode());
			} else if (ObjectUtil.isNotEmpty(form.getGbcode())) {
				if("_other".equals(form.getGbcode())){
					criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",OP.IS," NULL ");
				}else{
					List<Organization> organizationList = organizationService.getOrganizations(new Criteria("gbCode",form.getGbcode()));
	    			String[] strings = new String[organizationList.size()];
	    			for(int i = 0;i<organizationList.size();i++){
	    				strings[i] = organizationList.get(i).getOrganCode();
	    			}
	    			criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",OP.IN,strings);
				}
    		}
        }
		PageList<LocationInfo> list = locationService.getPagedLocInfosAddInspCount(buildPage(request), criteria, getHrRole(request), getCurrentOrg(request));
		model.addAttribute("locationInfoList", list.getList());
		return "rhip.hsa.insp.locationListResult";
	}

	@RequestMapping(value = "/hsa/inspRecord/locationSelectResult")
	public String locationSelectResult(QueryForm form, HttpServletRequest request, ModelMap model) {
		form.setLocationStatus(EHRConstants.LOCATION_DATA_STATUS_NORMAL);
		Criteria criteria = form.toCriteria();
		String orgCode = getCurrentOrg(request).getOrganCode();
        if(hasRole(RoleType.ZWJ,request)){
            criteria.add("CREATE_ORGAN_CODE",orgCode);
        }
        if(hasRole(RoleType.ZXWJ,request)){
            List<Organization> organizationList = organizationService.getOrganizations(new Criteria("parentCode",orgCode));
			organizationList.add(getCurrentOrg(request));
            String[] strings = new String[organizationList.size()];
			for(int i = 0;i<organizationList.size();i++){
				strings[i] = organizationList.get(i).getOrganCode();
			}
			criteria.add("CREATE_ORGAN_CODE",OP.IN,strings);
        }
		
		PageList<LocationInfo> list = locationService.getPagedLocInfosAddInspCount(buildPage(request), criteria, getHrRole(request), getCurrentOrg(request));
		model.addAttribute("locationInfoList", list.getList());
		return "rhip.hsa.insp.locationSelectResult";
	}

	@RequestMapping(value = "/hsa/inspRecord/addLocInfo")
	public String addLocInfo(HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		LocationInfo locationInfo = new LocationInfo();
		locationInfo.setDocumentTypeCode("01");
		locationInfo.setCreateOrganCode(org.getOrganCode());
		if (hasRole(RoleType.JKWJ, request)){
            model.put("ROLE", RoleType.JKWJ.getValue());
            model.put("townValue", "");
        }
        if (hasRole(RoleType.ZXWJ, request) ){
            model.put("ROLE", RoleType.ZXWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
        if (hasRole(RoleType.ZWJ, request) ){
            model.put("ROLE", RoleType.ZWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
		
		model.put("locationInfo", locationInfo);
		addAreaCodeLimit(request, model);
		return "rhip.hsa.insp.addLocInfo";
	}

	@RequestMapping(value = "/hsa/inspRecord/getLocInfoForUpdate")
	public String getLocInfoForUpdate(HttpServletRequest request, ModelMap model, @RequestParam(value = "locationId") Long id) {
		Criteria criteria = new Criteria("id", id);
		LocationInfo locationInfo = locationService.getLocationInfo(criteria);
		if (hasRole(RoleType.JKWJ, request)){
            model.put("ROLE", RoleType.JKWJ.getValue());
            model.put("townValue", "");
        }
        if (hasRole(RoleType.ZXWJ, request) ){
            model.put("ROLE", RoleType.ZXWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
        if (hasRole(RoleType.ZWJ, request) ){
            model.put("ROLE", RoleType.ZWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
		model.put("locationInfo", locationInfo);
		addAreaCodeLimit(request, model);
		return "rhip.hsa.insp.addLocInfo";
	}

	@RequestMapping(value = "/hsa/inspRecord/viewLocation")
	public String viewLocation(HttpServletRequest request, ModelMap model, @RequestParam(value = "locationId") Long id) {
		Criteria criteria = new Criteria("id", id);
		LocationInfo locationInfo = locationService.getLocationWithBusiInfo(criteria);
		if (hasRole(RoleType.JKWJ, request)){
            model.put("ROLE", RoleType.JKWJ.getValue());
            model.put("townValue", "");
        }
        if (hasRole(RoleType.ZXWJ, request) ){
            model.put("ROLE", RoleType.ZXWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
        if (hasRole(RoleType.ZWJ, request) ){
            model.put("ROLE", RoleType.ZWJ.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
		model.put("locationInfo", locationInfo);
		return "rhip.hsa.insp.viewLocInfo";
	}

	@RequestMapping(value = "/hsa/inspRecord/getLocInfo")
	@ResponseBody
	public LocationInfo getLocInfo(HttpServletRequest request, ModelMap model, @RequestParam(value = "locationId") Long id) {
		Criteria criteria = new Criteria("id", id);
		LocationInfo locationInfo = locationService.getLocationInfo(criteria);
		return locationInfo;
	}

	@RequestMapping(value = "/hsa/inspRecord/saveLocInfo")
	@ResponseBody
	public Object saveLocInfo(LocationInfo locationInfo, HttpServletRequest request) {
		Object result = true;
		try {
			if (ObjectUtil.isNullOrEmpty(locationInfo.getId())) {
				boolean isdul = locationService.checDulLocationInfo(locationInfo);
				if (isdul) {
					result = "dul";
					return result;
				}
				locationService.addLocationInfo(locationInfo, getCurrentOrg(request), getCurrentUser(request));
				record(request, OperationName.ADD);
			} else {
				locationService.updateLocationInfo(locationInfo, getCurrentOrg(request), getCurrentUser(request));
				record(request, OperationName.UPDATE);
			}
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("保存地点信息失败", e);
		}
		return result;
	}

	@RequestMapping(value = "/hsa/inspRecord/locationCancel")
	@ResponseBody
	public Object cancel(@RequestParam("id") Long id, HttpServletRequest request) {
		Object result = true;
		try {
			locationService.cancel(id);
			record(request, OperationName.CHECK);
			result = true;
		} catch (Exception e) {
			result = false;
			handleException("注销地点信息失败", e);
		}
		return result;
	}

	@RequestMapping("/hsa/inspRecord/locationSelect")
	@ResponseBody
	public SelectDTO<LocationInfo> getLocationInfosForSelect(HttpServletRequest request, ModelMap model, @RequestParam(required = false, value = "inputValue") String name,
			@RequestParam(required = false, value = "currentPage") int indexPage) {

		Page page = super.getPage(request, indexPage);

		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(name)) {
			criteria.add("unitName", OP.LIKE, name);
		}
		PageList<LocationInfo> locas = locationService.getPagedLocationInfos(page, criteria);
		SelectDTO<LocationInfo> result = new SelectDTO<>(locas);
		return result;
	}

	@RequestMapping("/hsa/inspRecord/getMfCode")
	@ResponseBody
	public Map<String, List<Map<String, String>>> getMfCode() {
		List<DicItem> dicItems = dictionaryApp.queryDicItem("HSA00006");
		Map<String, List<Map<String, String>>> result = new HashMap<String, List<Map<String, String>>>();
		Set<String> set = locationService.getNotShowBsCodes();
		for (DicItem dicItem : dicItems) {
			String code = dicItem.getItemCode();
			if (set.contains(code)) {
				continue;
			}
			String parent = dicItem.getParentCode();
			List<Map<String, String>> list = result.get(parent);
			if (null == list) {
				list = new ArrayList<>();
				result.put(parent, list);
			}
			Map<String, String> item = new HashMap<>(1);
			item.put("key", code);
			item.put("value", dicItem.getItemName());
			list.add(item);
		}
		return result;
	}

	@RequestMapping("/hsa/inspRecord/locationList/excel")
	public void excel(final QueryForm form, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		try {
			String title = "卫生监督协管基础档案列表";
			final Criteria criteria = form.toCriteria();
			final RoleType roleType = getHrRole(request);
			final Organization organization = getCurrentOrg(request);
			
            criteria.remove("HSA_INSPECTION_RECORD.CREATE_GBCODE");
			String orgCode = getCurrentOrg(request).getOrganCode();
            if(hasRole(RoleType.ZWJ,request)){
            	criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",orgCode);
            }
            if(hasRole(RoleType.ZXWJ,request)){
            	criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE", getCurrentOrg(request).getOrganCode());//站不做业务，只需查中心
            }else{
            	if (ObjectUtil.isNotEmpty(form.getCreateOrganCode())) {
            		criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE", form.getCreateOrganCode());
    			} else  if (ObjectUtil.isNotEmpty(form.getGbcode())) {
    				if("_other".equals(form.getGbcode())){
    					criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",OP.IS," NULL ");
    				}else{
	        			List<Organization> organizationList = organizationService.getOrganizations(new Criteria("gbCode",form.getGbcode()));
	                    String[] strings = new String[organizationList.size()];
	        			for(int i = 0;i<organizationList.size();i++){
	        				strings[i] = organizationList.get(i).getOrganCode();
	        			}
	        			criteria.add("HSA_LOCATION_INFO.CREATE_ORGAN_CODE",OP.IN,strings);
    				}
        		}
            }
			excelExportService.exportListExecl(title, LocationInfo.class, response, new IDataSource() {
				@Override
				public List<Map<String, Object>> get(Page page) {
                    
					List<Map<String, Object>> dataSource = locationService.getPagedLocInfoMapsAddInspCount(page, criteria,roleType,organization);
					return dataSource;
				}
			});
		} catch (Exception e) {
            logger.error("卫生监督协管基础档案列表导出失败",e);
            throw  e;
		}
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

}
