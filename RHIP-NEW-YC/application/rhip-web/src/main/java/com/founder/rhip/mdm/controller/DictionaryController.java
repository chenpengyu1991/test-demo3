package com.founder.rhip.mdm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.DicItemMap;
import com.founder.rhip.mdm.entity.DicVersion;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDicItemMapService;
import com.founder.rhip.mdm.service.IDicVersionService;
import com.founder.rhip.mdm.service.IDictionaryService;

@Controller
@RequestMapping("/mdmDictionary")
public class DictionaryController extends BaseController {
	
	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@Resource(name = "mdmDicVersionService")
	private IDicVersionService mdmDicVersionService;
	
	@Resource(name = "mdmDicItemMapService")
	private IDicItemMapService mdmDicItemMapService;
	
	@RequestMapping("/search")
	public String dictionarySearch(ModelMap model) {
		model.addAttribute("criDictionary", new Dictionary());
		model.addAttribute("categoryList", items);
		return "com.founder.mdm.dmpi.dictionarySearch";
	}
	@RequestMapping("/mapSearch")
	public String mapSearch(HttpServletRequest request, ModelMap map) {
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		Organization org = currentLoginInfo.getOrganization();
		String currentOrgCode = org.getOrganCode();
		String currentOrgName = org.getOrganName();
		List<DicItem> dicItemList = dictionaryService.getDicItems(new Criteria("dicCode", "ZDYS")); // 需要做映射的字典
		map.addAttribute("dicItemList", dicItemList);
		map.addAttribute("currentOrgCode",currentOrgCode);
		map.addAttribute("currentOrgName",currentOrgName);
		return "com.founder.mdm.map.mapSearch";
	}
	
	@RequestMapping("/queryDicVersionList/{dicCode}")
	@ResponseBody
	public List<DicVersion> queryDicVerisonList(@PathVariable("dicCode") String dicCode) {
		List<DicVersion> dicVersionList = mdmDicVersionService.getDicVersions(new Criteria("dicCode", dicCode).add("versionStatus", StatusValue.normalValue.getValue()).add("majorVersion", OP.NE, 1));
		return dicVersionList;
	}
	
	@RequestMapping("/showImport")
	public String showImport(ModelMap model) {
		return "com.founder.mdm.map.dicManager";
	}
	@RequestMapping("/dictionaryList")
	public String dictionaryList(HttpServletRequest request,int indexPage, ModelMap model, Dictionary criDictionary) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initCriteria(criDictionary);
		PageList<Dictionary> pageList = dictionaryService.getDicMetas(page, criteria);
		model.addAttribute("dictionaryList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		model.addAttribute("categoryList", items);
		return "com.founder.mdm.dmpi.dictionaryList";
	}
	
	@RequestMapping("/queryLocalDicItemList")
	public String queryLocalDicItemList(HttpServletRequest request,int indexPage, ModelMap model, DicItem dicItem) {
		request.getSession().removeAttribute("dic_code");
		request.getSession().removeAttribute("dic_organ_code");
		Page page = super.getPage(request,  indexPage);
		if(ObjectUtil.isNotEmpty(dicItem.getDicCode())) {
			request.getSession().setAttribute("dic_code", dicItem.getDicCode()); // 前端自动选择下拉框查询条件使用，解决自动下拉框无法传参问题
		}
		if(ObjectUtil.isNotEmpty(dicItem.getOrganCode())) {
			request.getSession().setAttribute("dic_organ_code", dicItem.getOrganCode()); // 前端自动选择下拉框查询条件使用，解决自动下拉框无法传参问题
		}
		if(ObjectUtil.isNotEmpty(dicItem.getVersion())) {
			request.getSession().setAttribute("dic_version", dicItem.getVersion()); // 前端自动选择下拉框查询条件使用，解决自动下拉框无法传参问题
		}
		dicItem.setItemCode(null); // 因为有重复项目名称，默认选择的时候会有itemcode，所以要设置为空，要不然查询不了其他
		PageList<DicItem> dicItemPagelist = dictionaryService.getDicItemPageList(page, dicItem, false);
		model.addAttribute("dicItemList", dicItemPagelist.getList());
		model.addAttribute("page", dicItemPagelist.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.map.mapDictionaryList";
	}
	
	@RequestMapping("/queryVersionDicItemList")
	public String queryVersionDicItemList(HttpServletRequest request,int indexPage, ModelMap model, DicItem dicItem) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = new Criteria("status", StatusValue.normalValue.getValue()).add("version", dicItem.getVersion()); // 1:状态可用
		if(StringUtil.isNotEmpty(dicItem.getDicCode())) {
			criteria.add("dicCode", dicItem.getDicCode());
		}
//		if(StringUtil.isNotEmpty(dicItem.getItemCode())) {
//			criteria.add("itemCode", dicItem.getItemCode());
//		}
		if(StringUtil.isNotEmpty(dicItem.getItemName())) {
			criteria.add("itemName", OP.LIKE, dicItem.getItemName());
		}
//		if(StringUtil.isNotEmpty(dicItem.getOrganCode())) {
//			criteria.add("cs1", dicItem.getOrganCode());
//		}
//		Dictionary dictionary = dictionaryService.getDictionary(new Criteria("dicCode", dicItem.getDicCode())); // 此方法关联查询有问题，对于字典项目非常多的情况不适用
		List<Dictionary> dictionaryList = dictionaryService.getDicmetas(new Criteria("dicCode", dicItem.getDicCode()));
		PageList<DicItem> dicItemPagelist = dictionaryService.getDicItems(page, criteria);
		model.addAttribute("dictionary", ObjectUtil.isNullOrEmpty(dictionaryList) ? null : dictionaryList.get(0));
		model.addAttribute("dicItemList", dicItemPagelist.getList());
		model.addAttribute("page", dicItemPagelist.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.map.standDictionaryList";
	}
	
	@RequestMapping("/queryDicItemMapList")
	public String queryDicItemMapList(HttpServletRequest request,int indexPage, ModelMap model, DicItemMap dicItemMap) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = new Criteria("status", "1").add("itemCodeVersion", dicItemMap.getItemCodeVersion()); // 1:状态可用
		if(StringUtil.isNotEmpty(dicItemMap.getDicCode())){
			criteria.add("dicCode", dicItemMap.getDicCode());
		}
		if(StringUtil.isNotEmpty(dicItemMap.getItemCode())) {
			criteria.add("itemCode", dicItemMap.getItemCode());
		}
		if(StringUtil.isNotEmpty(dicItemMap.getItemName())) {
			criteria.add("itemName", OP.LIKE, dicItemMap.getItemName());
		}
//		if(StringUtil.isNotEmpty(dicItemMap.getLocalItemCode())) {
//			criteria.add("localItemCode", dicItemMap.getLocalItemCode());
//		}
		if(StringUtil.isNotEmpty(dicItemMap.getLocalItemName())) {
			criteria.add("localItemName", OP.LIKE, dicItemMap.getLocalItemName());
		}
		if(StringUtil.isNotEmpty(dicItemMap.getDomainId())) {
			criteria.add("domainId", dicItemMap.getDomainId());
		}
//		Dictionary dictionary = dictionaryService.getDictionary(new Criteria("dicCode", dicItem.getDicCode()));// 管理字典项目查询效率太低
		List<Dictionary> dictionaryList = dictionaryService.getDicmetas(new Criteria("dicCode", dicItemMap.getDicCode()));
		PageList<DicItemMap> dicItemMapPagelist = mdmDicItemMapService.getDicItemMapPageList(criteria, page);
		model.addAttribute("dictionary", ObjectUtil.isNullOrEmpty(dictionaryList) ? null : dictionaryList.get(0));
		model.addAttribute("dicItemMapList", dicItemMapPagelist.getList());
		model.addAttribute("page", dicItemMapPagelist.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.map.hasMappingList";
	}
	
	
	/*@RequestMapping("/dictionaryLists")
	public String dictionaryLists(HttpServletRequest request,int indexPage, ModelMap model, HospitalDic hospitalDic) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(hospitalDic.getDicCode())){
			criteria.add("dicCode", OP.EQ, hospitalDic.getDicCode());
		}
		PageList<DicItem> pageList = dictionaryService.getDicItems(page, criteria);
		model.addAttribute("dictionaryList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.map.dictionaryLists";
	}*/
	
	
	@RequestMapping("/saveDicItemMapping")
	@ResponseBody
	public ModelMap saveDicItemMapping(DicItem dicItem, HttpServletRequest request) {
		String mappingResults = null;
		ModelMap model = new ModelMap();
		if (ObjectUtil.isNullOrEmpty(dicItem) || ObjectUtil.isNullOrEmpty(mappingResults = dicItem.getMappingResults())) {
			model.addAttribute("result", false);
			model.addAttribute("message", "映射参数为空！");
			return model;
		}
		String[] mappings = StringUtils.split(mappingResults, "^"); // 格式如 机构编码:机构字典编码:机构字典项目编码:映射字典编码:映射字典项目编码  a:b:c:d:e^f:g:h:i:j
		try {
			for (String mapping : mappings) {
				String[] orgDicCodes = StringUtils.split(mapping, ":");
				if (ObjectUtil.isNullOrEmpty(orgDicCodes) || orgDicCodes.length !=5) {
					continue;
				}
				
				// 查询映射对应的字典
				List<DicItem> dicItemList1 = dictionaryService.getDicItems(new Criteria("dicCode", orgDicCodes[3])
						.add("itemCode", orgDicCodes[4])
						.add("version", dicItem.getVersion()));
				
				// 查询需要映射的字典，DIC_ITEM表中无机构相关字段，用扩展字段cs1存放
				List<DicItem> dicItemList2 = dictionaryService.getDicItems(new Criteria("cs1", orgDicCodes[0])
						.add("dicCode", orgDicCodes[1])
						.add("itemCode", orgDicCodes[2]));
						
				if (ObjectUtil.isNullOrEmpty(dicItemList1) || ObjectUtil.isNullOrEmpty(dicItemList2)) {
					continue;
				}
				// 判断字段映射是否存在
//				DicItemMap dicItemMap = mdmDicItemMapService.getDicItemMap(new Criteria("domainId", orgDicCodes[0])
//						.add("dicCode", orgDicCodes[3])
//						.add("itemCode", orgDicCodes[4])
//						.add("itemCodeVersion", dicItem.getVersion()));
				DicItemMap dim = new DicItemMap();
				dim.setDomainId(orgDicCodes[0]);
				dim.setLocalDicCode(dicItemList2.get(0).getDicCode());
				dim.setLocalItemCode(dicItemList2.get(0).getItemCode());
				dim.setLocalItemName(dicItemList2.get(0).getItemName());
				dim.setItemCodeVersion(dicItemList1.get(0).getVersion());
				dim.setDicCode(dicItemList1.get(0).getDicCode());
				dim.setItemCode(dicItemList1.get(0).getItemCode());
				dim.setItemName(dicItemList1.get(0).getItemName());
				dim.setPyCode(dicItemList1.get(0).getPyCode());
				dim.setWbCode(dicItemList1.get(0).getWbCode());
				dim.setStatus(StatusValue.normalValue.getValue()); // 可用状态
				dim.setOperator(getOperator());
				dim.setOperateTime(getOperatorTime());
				dim.setOperateType(OperateType.create.getName());
				mdmDicItemMapService.createDicItemMap(dim);
				/*if (ObjectUtil.isNullOrEmpty(dicItemMap)) {
					dim.setOperateType(OperateType.create.getName());
					mdmDicItemMapService.createDicItemMap(dim);
				} else {
					dim.setOperateType(OperateType.update.getName());
					dim.setMapId(dicItemMap.getMapId());
					mdmDicItemMapService.updateDicItemMap(dim);
				}*/
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			model.addAttribute("result", false);
			model.addAttribute("message", "保存映射关系出错！");
			return model;
		}
		model.addAttribute("result", true);
		model.addAttribute("message", "保存成功！");
		return model;
	}
	
	@RequestMapping("/dicUpload")
	@ResponseBody
	public ModelMap upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) throws IOException {
		ModelMap model = new ModelMap();
		//setCostomerJsonlDownLoadResponse(response);
		try {
			InputStream in = file.getInputStream();
			List<Record> dicList = readCSVFile(in);
			if (dicList == null || dicList.size() == 0) {
				model.addAttribute("result", false);
				model.addAttribute("message", "导入文件为空");
				return model;
			}
			CheckResult results = new CheckResult();
			for (Record record : dicList) {
				record.set(Disease.OPERATOR, getOperator());
				record.set(Disease.OPERATE_TYPE,OperateType.batchImport.getName());
				record.set(Disease.OPERATE_TIME, getOperatorTime());
				record.set(Disease.STATUS, StatusValue.normalValue.getValue());
				//检查合法性
				List<String> chkMessageList = new ArrayList<String>();
				checkAll(chkMessageList, record, EntityType.DIC_ITEM);
				results.add(chkMessageList);
			}
			if (results.hasError()) {
				model.addAttribute("result", false);
				model.addAttribute("message", getCheckErrorStr(results));
				dicList.clear();
				dicList = null;
				//outputJsonData(response, model);
				return model;
			}
			int count = dictionaryService.importDic(dicList);
			model.addAttribute("message", "总共导入"+dicList.size()+"条字典项，成功"+count+"条，失败"+(dicList.size() - count)+"条");
			model.addAttribute("result", true);
			dicList.clear();
			dicList = null;
		} catch (Exception e) {
			log.error("导入字典项出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		//outputJsonData(response, model);
		return model;
	}
	@RequestMapping("/downSdTemplate")
	@ResponseBody
	public void downSdTemplate(HttpServletResponse response) throws IOException {
		    String fileName = "dicItemMap.csv";
	        setCSVDownLoadResponse(response, fileName);
	        downFile("../views/mdm/template/dicItemMap.csv", response);
	}
	/**
	 * 映射字典选择框,自动选择框用
	 *
	 * @param model
	 * @param name
	 * @param fullPyName
	 * @param pyName
	 * @param indexPage
	 * @return
	 * @author liuk
	 */
	@RequestMapping("/dictionarySelect")
	@ResponseBody
	public SelectDTO<DicItem> getOrganSelectData(
			HttpServletRequest request,
			ModelMap model,
			@RequestParam(required = false, value = "inputValue") String name,
			@RequestParam(required = false, value = "fullPyName") String fullPyName,
			@RequestParam(required = false, value = "pyName") String pyName,
			@RequestParam(required = false, value = "subsid") String subsid,
			@RequestParam(required = false, value = "dicCode") String dicCode,
			@RequestParam(required = false, value = "currentPage") int indexPage) {

		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(dicCode)) {
			criteria.add("dicCode", OP.EQ, dicCode);
		}
        if (ObjectUtil.isNotEmpty(subsid)) {
            criteria.add("SUBSID", subsid);
        }
        if (ObjectUtil.isNotEmpty(name)) {
			criteria.add("itemName", OP.LIKE, name);
		}
		PageList<DicItem> dicItemList = dictionaryService.getDicItems(page, criteria);
		SelectDTO<DicItem> result = new SelectDTO<>(dicItemList);
		return result;
	}
	@RequestMapping("/addDicMate")
	public String addDicMate(ModelMap model) {
		model.addAttribute("dictionary", new Dictionary());
		model.addAttribute("categoryList", items);
		return "com.founder.mdm.dmpi.dictionaryInfo";
	}
	
	@RequestMapping("/editDicMate")
	public String editDicMate(ModelMap model, String dicCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		Dictionary dictionary = dictionaryService.getDictionary(criteria);
		model.addAttribute("dictionary", dictionary);
		model.addAttribute("categoryList", items);
		return "com.founder.mdm.dmpi.dictionaryInfo";
	}
	
	@RequestMapping("/deleteDicMate")
	@ResponseBody
	public ModelMap deleteDicMate(String dicCode) {
		ModelMap model = new ModelMap();
		try {
			dictionaryService.deleteDictionary(dicCode);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("删除字典出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/changeStatus")
	@ResponseBody
	public ModelMap changeStatus(String dicCode, int oldStatus) {
		ModelMap model = new ModelMap();
		try {
			Dictionary dictionary = new Dictionary();
			dictionary.setDicCode(dicCode);
			dictionary.setOperator(getOperator());
			dictionary.setOperateTime(getOperatorTime());
			dictionary.setOperateType(OperateType.update.getName());
			if (oldStatus == StatusValue.normalValue.getValue()) {
				dictionary.setStatus(StatusValue.deleteValue.getValue());
			} else {
				dictionary.setStatus(StatusValue.normalValue.getValue());
			}
			dictionaryService.changeStatus(dictionary);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("更新字典状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	@RequestMapping("/changeVersionStatus")
	@ResponseBody
	public ModelMap changeVersionStatus(String id, int oldStatus) {
		ModelMap model = new ModelMap();
		try {
			DicVersion dicVersion = new DicVersion();
			dicVersion.setId(Long.parseLong(id));
			if (oldStatus == StatusValue.normalValue.getValue()) {
				dicVersion.setVersionStatus(StatusValue.deleteValue.getValue());
			} else {
				dicVersion.setVersionStatus(StatusValue.normalValue.getValue());
			}
			mdmDicVersionService.changeVersionStatus(dicVersion);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("更新字典状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	@RequestMapping("/changeMajorVersion")
	@ResponseBody
	public ModelMap changeMajorVersion(String id, int isMajor,String dicCode) {
		ModelMap model = new ModelMap();
		Criteria criteria = new Criteria(DicVersion.DIC_CODE,dicCode);
		List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(criteria);
		try {
			DicVersion dicVersion = new DicVersion();
			dicVersion.setId(Long.parseLong(id));
			if (isMajor == 0) {
				dicVersion.setMajorVersion(1);
			} else {
				dicVersion.setMajorVersion(0);
			}
			mdmDicVersionService.changeMajorVersion(dicVersion);

			for (DicVersion dv : dicVersions) {
				if(dv.getMajorVersion() == 1 && Long.parseLong(id) != dv.getId()){
					dv.setMajorVersion(0);
					mdmDicVersionService.changeMajorVersion(dv);
				}
			}
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("更新字典状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/saveDicMate")
	@ResponseBody
	public ModelMap saveDicMate(Dictionary dictionary, String type) {
		ModelMap model = new ModelMap();
		
		dictionary.setOperator(getOperator());
		dictionary.setOperateTime(getOperatorTime());
		
		//检查合法性
		Record record = new Record(dictionary);
		List<String> chkMessageList = new ArrayList<String>();
		notNullCheck(chkMessageList, record, EntityType.DICTIONARY);
		maxLengthCheck(chkMessageList, record, EntityType.DICTIONARY);
		
		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}
		
		String dicCode = dictionary.getDicCode();
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		Dictionary dbDictionary = dictionaryService.getDictionary(criteria);
		if (dbDictionary == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的字典不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				//int status = dbDictionary.getStatus();
				//if (status != Dictionary.STATUS_DELETE_VALUE) {
					model.addAttribute("result", false);
					model.addAttribute("message", "相同编码的字典已经存在");
					return model;
				//}
			}
		}
		
		try {
			if ("add".equalsIgnoreCase(type)) {
				dictionary.setOperateType(OperateType.create.getName());
				//if (dbDictionary == null) {
					dictionaryService.createDictionary(dictionary);
				//} else {
				//	setDictionaryValue(dbDictionary, dictionary);
				//	dbDictionary.setStatus(Dictionary.STATUS_DEFAULT_VALUE);
				//	dictionaryService.updateDicmeta(dbDictionary);
				//}
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				dictionary.setOperateType(OperateType.update.getName());
				setDictionaryValue(dbDictionary, dictionary);
				dictionaryService.updateDicmeta(dictionary);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存字典出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("publishVersion")
	@ResponseBody
	public ModelMap publishVersion(String dicCode) {
		ModelMap model = new ModelMap();
		try {
			dictionaryService.publishDictionary(dicCode);
			model.addAttribute("result", true);
			model.addAttribute("message", "发布成功");
		} catch (Exception e) {
			log.error("发布字典版本出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/dicItemsSearch")
	public String dicItemsSearch(ModelMap model, String dicCode) {
		Criteria criteria = new Criteria();
		criteria.add("dicCode", dicCode).add("versionStatus", "1"); // 状态-1为作废
		List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(criteria);
		DicItem item = new DicItem();
		item.setDicCode(dicCode);
		model.addAttribute("criDicItem", item);
		model.addAttribute("dicVersions", dicVersions);
		return "com.founder.mdm.dmpi.dicItemSearch";
	}
	
	@RequestMapping("/dicItemList")
	public String dicItemList(HttpServletRequest request,ModelMap model, DicItem criDicItem, int indexPage) {
		String dicCode = criDicItem.getDicCode();
		Long version = criDicItem.getVersion();
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initDicItemCriteria(criDicItem);
		DicVersion dicVersion = mdmDicVersionService.getDicVersion(dicCode, String.valueOf(version));
		List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(new Criteria("dicCode", criDicItem.getDicCode()).add("versionStatus", "1"));
		model.addAttribute("indexPage", indexPage);
		model.addAttribute("dicVersions", dicVersions);
		if(ObjectUtil.isNotEmpty(dicVersion)){
//		if (dicVersion.getMajorVersion() == 1) {
			PageList<DicItem> dicItems = dictionaryService.getDicItems(page, criteria);
			// 设置主版本标识符
			dictionaryService.setMajorVersion(dicItems.getList());
			model.addAttribute("page", dicItems.getPage());
			model.addAttribute("dicItemList", dicItems.getList());
			model.addAttribute("majorVersion", dicVersion.getMajorVersion());
//		} else {
//			criteria.add("itemCodeVersion", criteria.get("version"));
//			criteria.remove("version");
//			PageList<DicItemMap> dicItemMapPageList = mdmDicItemMapService.getDicItemMapPageList(criteria, page);
//			List<DicItemMap> list = dicItemMapPageList.getList();
//			for (DicItemMap dicItemMap : list) {
//				dicItemMap.setVersionDesc(dicVersion.getVersionDesc());
//			}
//			model.addAttribute("dicItemMapList", list);
//			model.addAttribute("page", dicItemMapPageList.getPage());
//		}
		}else{
			PageList<DicItem> dicItems = dictionaryService.getDicItems(page, criteria);
			// 设置主版本标识符
			dictionaryService.setMajorVersion(dicItems.getList());
			model.addAttribute("page", dicItems.getPage());
			model.addAttribute("dicItemList", dicItems.getList());
		}
		return "com.founder.mdm.dmpi.dicItemList";
	}
		
	
	@RequestMapping("/addDicItem")
	public String addDicItem(ModelMap model, String dicCode) {
		DicItem item = new DicItem();
		Criteria criteria = new Criteria();
		criteria.add("dicCode", dicCode).add("versionStatus", "1"); // 状态-1为作废;
		List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(criteria);
		item.setDicCode(dicCode);
		model.addAttribute("dicVersions", dicVersions);
		model.addAttribute("dicItem", item);
		return "com.founder.mdm.dmpi.dicItemInfo";
	}

	@RequestMapping("/addDicVersion")
	public String addDicVersion(ModelMap model, String dicCode) {
		DicVersion dicVersion = new DicVersion();
		dicVersion.setDicCode(dicCode);
		model.addAttribute("dicVersion", dicVersion);
		return "com.founder.mdm.dmpi.dicVersionInfo";
	}

	@RequestMapping("/dicVersionList")
	public String dicVersionList(HttpServletRequest request,ModelMap model, String dicCode, int indexPage){
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = new Criteria(DicVersion.DIC_CODE, dicCode);
		PageList<DicVersion> dicVersion = mdmDicVersionService.getDicVersions(page, criteria);
		model.addAttribute("page", dicVersion.getPage());
		model.addAttribute("indexPage", indexPage);
		model.addAttribute("dicVersionList", dicVersion.getList());
		return "com.founder.mdm.dmpi.dicVersionList";
	}
	
	@RequestMapping("/editDicItem")
	public String editDicItem(ModelMap model, Long itemId) {
		Criteria criteria = new Criteria(DicItem.ITEM_ID, itemId);
		List<DicItem> items = dictionaryService.getDicItems(criteria);
		if (ObjectUtil.isNotEmpty(items)) {
			DicItem dicItem = items.get(0);
			if (ObjectUtil.isNotEmpty(dicItem)) {
				model.addAttribute("dicItem", dicItem);
				if (ObjectUtil.isNotEmpty(dicItem.getDicCode())) {
					Criteria c = new Criteria();
					c.add("dicCode", dicItem.getDicCode()).add("versionStatus", "1"); // 状态-1为作废;
					List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(c);
					model.addAttribute("dicVersions", dicVersions);
				}
			}
		}
		return "com.founder.mdm.dmpi.dicItemInfo";
	}

	@RequestMapping("/editDicVersion")
	public String editDicVersion(ModelMap model, Long id) {
		Criteria criteria = new Criteria(DicVersion.ID, id);
		List<DicVersion> versions = mdmDicVersionService.getDicVersions(criteria);
		model.addAttribute("dicVersion", versions.get(0));
		return "com.founder.mdm.dmpi.dicVersionInfo";
	}
	
	@RequestMapping("/deleteDicItem")
	@ResponseBody
	public ModelMap deleteDicItem(Long itemId) {
		ModelMap model = new ModelMap();
		try {
			dictionaryService.deleteDicItem(itemId);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("删除字典项出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/changeItemStatus")
	@ResponseBody
	public ModelMap changeItemStatus(Long itemId, int oldStatus) {
		ModelMap model = new ModelMap();
		try {
			DicItem dicItem = new DicItem();
			dicItem.setItemId(itemId);
			dicItem.setOperator(getOperator());
			dicItem.setOperateTime(getOperatorTime());
			dicItem.setOperateType(OperateType.update.getName());
			if (oldStatus == StatusValue.normalValue.getValue()) {
				dicItem.setStatus(StatusValue.deleteValue.getValue());
			} else {
				dicItem.setStatus(StatusValue.normalValue.getValue());
			}
			dictionaryService.changeItemStatus(dicItem);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("修改字典项状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/showDicItemLogs")
	public String showDicItemLogs(HttpServletRequest request,ModelMap model, Long itemId, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		PageList<DicItem> pageList = dictionaryService.getDicItemLogs(page, itemId);
		model.addAttribute("logList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("itemId", itemId);
		return "com.founder.mdm.dmpi.dicItemLogList";
	}
	
	@RequestMapping("/saveDicItem")
	@ResponseBody
	public ModelMap saveDicItem(DicItem dicItem, String type) {
		ModelMap model = new ModelMap();
		
		dicItem.setOperator(getOperator());
		dicItem.setOperateTime(getOperatorTime());
		
		//检查合法性
		Record record = new Record(dicItem);
		List<String> chkMessageList = new ArrayList<String>();
		notNullCheck(chkMessageList, record, EntityType.DIC_ITEM);
		maxLengthCheck(chkMessageList, record, EntityType.DIC_ITEM);
		
		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}
		
		String dicCode = dicItem.getDicCode();
		String itemCode = dicItem.getItemCode();
		Long version = dicItem.getVersion();
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
//		DicItem dbItem = dictionaryService.getDicItem(dicCode, itemCode);
//		if (dbItem == null) {
//			if ("edit".equalsIgnoreCase(type)) {
//				model.addAttribute("result", false);
//				model.addAttribute("message", "需要更新的字典项不存在");
//				return model;
//			}
//		} else {
//			if ("add".equalsIgnoreCase(type)) {
//				model.addAttribute("result", false);
//				model.addAttribute("message", "相同编码的字典项已经存在");
//				return model;
//			}
//		}
		
		try {
			if ("add".equalsIgnoreCase(type)) {
				DicItem dbItem = dictionaryService.getDicItem(dicCode, itemCode, version);
				if (ObjectUtil.isNotEmpty(dbItem)) {
					model.addAttribute("result", false);
					model.addAttribute("message", "相同编码的字典项已经存在！如果想创建新版本请选择其他版本号！");
					return model;
				}
				dicItem.setOperateType(OperateType.create.getName());
				dictionaryService.createDicItem(dicItem);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				DicItem dbItem = dictionaryService.getDicItem(dicCode, itemCode);
				if (ObjectUtil.isNullOrEmpty(dbItem)) {
					model.addAttribute("result", false);
					model.addAttribute("message", "需要更新的字典项不存在");
					return model;
				}
				dicItem.setOperateType(OperateType.update.getName());
				setDicItemValue(dbItem, dicItem);
				dictionaryService.updateDicItem(dicItem);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存字典项出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	@RequestMapping("/saveDicVersion")
	@ResponseBody
	public ModelMap saveDicVersion(DicVersion dicVersion, String type) {
		ModelMap model = new ModelMap();

		//检查合法性
		Record record = new Record(dicVersion);
		List<String> chkMessageList = new ArrayList<String>();
		notNullCheck(chkMessageList, record, EntityType.DIC_VERSION);
		maxLengthCheck(chkMessageList, record, EntityType.DIC_VERSION);

		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}

		String dicCode = dicVersion.getDicCode();
		String versionNumber = dicVersion.getVersionNumber();
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicVersion.VERSION_NUMBER, versionNumber);
		DicVersion dbVersion = mdmDicVersionService.getDicVersion(dicCode, versionNumber);
		if (dbVersion == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新版本号不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同编码的版本号已经存在");
				return model;
			}
		}

		String versionDesc = dicVersion.getVersionDesc();
		DicVersion dbVersionSecond = mdmDicVersionService.getDicVersionDesc(dicCode, versionDesc);
		if (dbVersionSecond == null) {

		} else {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同编码的版本描述已经存在");
				return model;
		}

		try {
			if ("add".equalsIgnoreCase(type)) {
				dicVersion.setVersionStatus(1);
				dicVersion.setMajorVersion(0);
				mdmDicVersionService.createDicVersion(dicVersion);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				setDicVersionValue(dbVersion, dicVersion);
				mdmDicVersionService.updateDicVersion(dicVersion);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存版本号出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/deleteDicVersion")
	@ResponseBody
	public ModelMap deleteDicVersion(Long id,String dicCode) {
		ModelMap model = new ModelMap();
		try {
			mdmDicVersionService.deleteDicVersion(new Criteria("id", id));
			model.addAttribute("result", true);
			Criteria criteria = new Criteria(DicVersion.DIC_CODE, dicCode);
			List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(criteria);
			if(ObjectUtil.isNotEmpty(dicVersions)&&dicVersions.size()==1){
				DicVersion dv = dicVersions.get(0);
				dv.setMajorVersion(1);
				mdmDicVersionService.updateDicVersion(dv);
			}
		} catch (Exception e) {
			log.error("删除版本出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	@RequestMapping("/downloadSearch")
	public String downloadSearch(ModelMap model) {
		model.addAttribute("criDictionary", new Dictionary());
		model.addAttribute("categoryList", items);
		return "com.founder.mdm.dmpi.downloadSearch";
	}
	
	@RequestMapping("/downloadList")
	public String downloadSearch(HttpServletRequest request,ModelMap model, Dictionary criDictionary, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initDownloadCriteria(criDictionary);
		PageList<Dictionary> pageList = dictionaryService.getDicMetas(page, criteria);
		model.addAttribute("dictionaryList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		model.addAttribute("categoryList", items);
		return "com.founder.mdm.dmpi.downloadList";
	}
	
	@RequestMapping("/downLoadCurrent")
	public void downLoadCurrent(String dicCode, HttpServletResponse response) throws IOException {
        String fileName = "diction_" + dicCode + ".csv";
        setCSVDownLoadResponse(response, fileName);
        Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
        criteria.add(Dictionary.STATUS, StatusValue.normalValue.getValue());
        //final Dictionary dictionary = dictionaryService.getDictionary(criteria);
        final List<DicItem> items = dictionaryService.getDicItems(criteria);
        outputCSVData(response, new ICSVDataTemplement() {

			@Override
			public String getTitle() {
				//return "字典编码,字典项编码,字典值,版本";
				return "字典编码,字典项编码,字典值";
			}

			@Override
			public int getCount() {
				return items.size();
			}

			@Override
			public String getLine(int lineNo) {
				DicItem item = items.get(lineNo);
				StringBuilder sb = new StringBuilder();
				sb.append(formatProperty(item.getDicCode()));
				sb.append(",");
				sb.append(formatProperty(item.getItemCode()));
				sb.append(",");
				sb.append(formatProperty(item.getItemName()));
				//sb.append(",");
				//sb.append(formatProperty(dictionary.getVersion()));
				return sb.toString();
			}

		});
	}

	@RequestMapping("/viewImport")
	public String viewImport(ModelMap model, String dicCode) {
		Dictionary dictionary = dictionaryService.getDictionary(new Criteria(Dictionary.DIC_CODE, dicCode));
		model.addAttribute("dictionary", dictionary);
		return "com.founder.mdm.dmpi.viewImport";
	}
	
	@RequestMapping("/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response, String dicCode) throws IOException {
        String fileName = "dictionary_"+dicCode+".csv";
        setCSVDownLoadResponse(response, fileName);
        downFile("../views/mdm/template/dictionary.csv", response);
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public ModelMap upload(@RequestParam("file") CommonsMultipartFile file, 
			@RequestParam("dicCode") String dicCode) throws IOException {
		ModelMap model = new ModelMap();
		//setCostomerJsonlDownLoadResponse(response);
		try {
			InputStream in = file.getInputStream();
			List<Record> dicItemList = readCSVFile(in);
			if (dicItemList == null || dicItemList.size() == 0) {
				model.addAttribute("result", false);
				model.addAttribute("message", "导入文件为空");
				return model;
			}
			
			CheckResult results = new CheckResult();
			for (Record record : dicItemList) {
				record.set(Dictionary.DIC_CODE, dicCode);
				record.set(Disease.OPERATOR, getOperator());
				record.set(Disease.OPERATE_TYPE,OperateType.batchImport.getName());
				record.set(Disease.OPERATE_TIME, getOperatorTime());
				record.set(Disease.STATUS, StatusValue.normalValue.getValue());
				
				//检查合法性
				List<String> chkMessageList = new ArrayList<String>();
				checkAll(chkMessageList, record, EntityType.DIC_ITEM);
				results.add(chkMessageList);
			}
			
			if (results.hasError()) {
				model.addAttribute("result", false);
				model.addAttribute("message", getCheckErrorStr(results));
				dicItemList.clear();
				dicItemList = null;
				//outputJsonData(response, model);
				return model;
			}
			
			int count = dictionaryService.importDicItems(dicCode, dicItemList);
			model.addAttribute("message", "总共导入"+dicItemList.size()+"条字典项，成功"+count+"条，失败"+(dicItemList.size() - count)+"条");
			model.addAttribute("result", true);
			dicItemList.clear();
			dicItemList = null;
		} catch (Exception e) {
			log.error("导入字典项出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		//outputJsonData(response, model);
		return model;
	}
	
	@RequestMapping("/editDicItemMap")
	public String editDicItemMap(ModelMap model, String dicCode,String itemCode,Long itemCodeVersion) {
		DicItemMap dicItemMap = mdmDicItemMapService.getDicItemMap(dicCode, itemCode,itemCodeVersion);
		if(ObjectUtil.isNullOrEmpty(dicItemMap)){
			DicItemMap pageItemMap = new DicItemMap();
			pageItemMap.setLocalDicCode(dicCode);
			pageItemMap.setLocalItemCode(itemCode);
			pageItemMap.setItemCodeVersion(itemCodeVersion);
			model.addAttribute("dicItemMap", pageItemMap);
		}else{
			model.addAttribute("dicItemMap", dicItemMap);
		}
		return "com.founder.mdm.dmpi.dicItemMapInfo";
	}
	
	@RequestMapping("/mapDicItem")
	public String mapDicItem(ModelMap model, String dicCode,String itemCode,Long itemCodeVersion) {
		DicItemMap dicItemMap = mdmDicItemMapService.getDicItemMap(dicCode, itemCode,itemCodeVersion);
		model.addAttribute("dicItemMap", dicItemMap);
		if(ObjectUtil.isNullOrEmpty(dicItemMap)){
			DicItemMap pageItemMap = new DicItemMap();
			pageItemMap.setLocalDicCode(dicCode);
			pageItemMap.setLocalItemCode(itemCode);
			pageItemMap.setItemCodeVersion(itemCodeVersion);
			model.addAttribute("dicItemMap", pageItemMap);
		}
		if (ObjectUtil.isNotEmpty(itemCodeVersion)) {
			List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(new Criteria("dicCode", dicCode).add("versionNumber", itemCodeVersion));
			if (ObjectUtil.isNotEmpty(dicVersions)) {
				model.addAttribute("dicVersion", dicVersions.get(0));
			}
		}
		return "com.founder.mdm.dmpi.mapdicItem";
	}
	
	@RequestMapping("/saveMapping")
	@ResponseBody
	public ModelMap saveMapping(DicItemMap dicItemMap) {
		ModelMap model = new ModelMap();
		if (ObjectUtil.isNullOrEmpty(dicItemMap.getDomainId())) {
			dicItemMap.setDomainId("1"); // 默认为1
		}
		if (ObjectUtil.isNullOrEmpty(dicItemMap.getDicCode())) {
			dicItemMap.setDicCode(dicItemMap.getLocalDicCode());
		}
		dicItemMap.setOperator(getOperator());
		dicItemMap.setOperateTime(getOperatorTime());
		try {
			if (ObjectUtil.isNullOrEmpty(dicItemMap.getMapId())) {
				DicItemMap dim = mdmDicItemMapService.getDicItemMap(dicItemMap.getLocalDicCode(), dicItemMap.getLocalItemCode(), dicItemMap.getItemCodeVersion());
				if (ObjectUtil.isNotEmpty(dim)) {
					model.addAttribute("result", false);
					model.addAttribute("message", "映射的版本编码已经存在！");
					return model;
				}
				dicItemMap.setOperateType(OperateType.create.getName());
				mdmDicItemMapService.createDicItemMap(dicItemMap);
			} else {
				dicItemMap.setOperateType(OperateType.update.getName());
				mdmDicItemMapService.updateDicItemMap(dicItemMap);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			model.addAttribute("result", false);
			model.addAttribute("message", "保存出错！");
			return model;
		}
		model.addAttribute("result", true);
		model.addAttribute("message", "保存成功！");
		return model;
	}
	
	@RequestMapping("/saveDicItemMap")
	@ResponseBody
	public ModelMap saveDicItemMap(DicItemMap dicItemMap, String type) {
		ModelMap model = new ModelMap();
		
		dicItemMap.setOperator(getOperator());
		dicItemMap.setOperateTime(getOperatorTime());
		
		//检查合法性
		Record record = new Record(dicItemMap);
		List<String> chkMessageList = new ArrayList<String>();
		notNullCheck(chkMessageList, record, EntityType.DIC_ITEM_MAP);
		maxLengthCheck(chkMessageList, record, EntityType.DIC_ITEM_MAP);
		
		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}
		
		String dicCode = dicItemMap.getLocalDicCode();
		String itemCode = dicItemMap.getLocalItemCode();
		Long itemCodeVersion = dicItemMap.getItemCodeVersion();
		DicItemMap dbItemMap = mdmDicItemMapService.getDicItemMap(dicCode, itemCode,itemCodeVersion);
		if (dbItemMap == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的编码配置字典不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "创建的编码配置字典已经存在");
				return model;
			}
		}
		
		try {
			if ("add".equalsIgnoreCase(type)) {
				dicItemMap.setOperateType(OperateType.create.getName());
				dicItemMap.setDomainId("1");//暂定默认为1
				mdmDicItemMapService.createDicItemMap(dicItemMap);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				dicItemMap.setOperateType(OperateType.update.getName());
				setDicItemMapValue(dbItemMap, dicItemMap);
				mdmDicItemMapService.updateDicItemMap(dicItemMap);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存字典项出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void setDicItemValue(DicItem dbItem, DicItem pageItem) {
		pageItem.setItemId(dbItem.getItemId());
		pageItem.setVersion(dbItem.getVersion());
		pageItem.setStatus(dbItem.getStatus());
	}
	
	private void setDicItemMapValue(DicItemMap dbItem, DicItemMap pageItem) {
		pageItem.setDomainId(dbItem.getDomainId());
		pageItem.setLocalDicCode(dbItem.getLocalDicCode());
		pageItem.setLocalItemCode(dbItem.getLocalItemCode());
		pageItem.setItemCodeVersion(dbItem.getItemCodeVersion());
	}

	private void setDicVersionValue(DicVersion dbVersion, DicVersion pageVersion) {
		pageVersion.setId(dbVersion.getId());
		pageVersion.setDicCode(dbVersion.getDicCode());
		pageVersion.setVersionStatus(dbVersion.getVersionStatus());
		pageVersion.setMajorVersion(dbVersion.getMajorVersion());
	}
	
	private void setDictionaryValue(Dictionary dbDictionary, Dictionary pageDictionary) {
		pageDictionary.setVersion(dbDictionary.getVersion());
		pageDictionary.setStatus(dbDictionary.getStatus());
	}
	
	private Criteria initDicItemCriteria(DicItem item) {
		Criteria criteria = new Criteria();
		if (item == null) {
			return criteria;
		}
		String dicCode = item.getDicCode();
		if (StringUtil.isNotEmpty(dicCode)) {
			criteria.add(Dictionary.DIC_CODE, dicCode);
		}
		String itemCode = item.getItemCode();
		if (StringUtil.isNotEmpty(itemCode)) {
			criteria.add(DicItem.ITEM_CODE, OP.LIKE, itemCode);
		}
		String itemName = item.getItemName();
		if (StringUtil.isNotEmpty(itemName)) {
			criteria.add(DicItem.ITEM_NAME, OP.LIKE, itemName);
		}
		Long version = item.getVersion();
		if (ObjectUtil.isNotEmpty(version)) {
			criteria.add(DicItem.VERSION, version);
		}
		return criteria;
	}
	
	private Criteria initCriteria(Dictionary dictionary) {
		Criteria criteria = new Criteria();
		if (dictionary == null) {
			return criteria;
		}
		String dicCode = dictionary.getDicCode();
		if (StringUtil.isNotEmpty(dicCode)) {
			criteria.add(Dictionary.DIC_CODE, OP.LIKE, dicCode);
		}
		String dicName = dictionary.getDicName();
		if (StringUtil.isNotEmpty(dicName)) {
			criteria.add(Dictionary.DIC_NAME, OP.LIKE, dicName);
		}
		String categoryId = dictionary.getCategoryId();
		if (StringUtil.isNotEmpty(categoryId)) {
			criteria.add(Dictionary.CATEGORY_ID, categoryId);
		}
		return criteria;
	}
	
	private Criteria initDownloadCriteria(Dictionary dictionary) {
		Criteria criteria = initCriteria(dictionary);
		criteria.add(Dictionary.STATUS, StatusValue.normalValue.getValue());
		return criteria;
	}
	
	private static List<DicItem> items = new ArrayList<DicItem>();
	static {
		items.add(new DicItem("GBT", "国家字典"));
		items.add(new DicItem("WS", "卫生部字典"));
		items.add(new DicItem("ZDY", "自定义字典"));
	}
	
	@RequestMapping("/getDicVersions")
	@ResponseBody
	public ModelMap getDicVersions(String dicCode) {
		Criteria criteria = new Criteria();
		criteria.add("dicCode", dicCode).add("versionStatus", "1"); // 状态-1为作废;
		List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(criteria);
		ModelMap map = new ModelMap();
		map.addAttribute("versions", dicVersions);
		return map;
	}
	
	@RequestMapping("/choiceVersion")
	public String choiceVersion(String dicCode, String itemCode, ModelMap map) {
		Criteria criteria = new Criteria();
		criteria.add("dicCode", dicCode).add("versionStatus", "1"); // 状态-1为作废;
		List<DicVersion> dicVersions = mdmDicVersionService.getDicVersions(criteria);
		map.addAttribute("versions", dicVersions);
		map.addAttribute("dicCode", dicCode);
		map.addAttribute("itemCode", itemCode);
		return "com.founder.mdm.dmpi.dicItem.version";
	}
	
	@RequestMapping("/unbind/{mapId}")
	@ResponseBody
	public ModelMap unbind(@PathVariable("mapId") Long mapId) {
		ModelMap model = new ModelMap();
		if (ObjectUtil.isNullOrEmpty(mapId)) {
			model.addAttribute("result", false);
			model.addAttribute("message", "映射参数为空！");
			return model;
		}
		DicItemMap dicItemMap = mdmDicItemMapService.getDicItemMap(new Criteria("mapId", mapId));
		if (ObjectUtil.isNullOrEmpty(dicItemMap)) {
			model.addAttribute("result", false);
			model.addAttribute("message", "记录不存在，请重新查询再操作！");
			return model;
		}
		
		try {
			dicItemMap.setStatus(StatusValue.deleteValue.getValue());
			dicItemMap.setOperateType(OperateType.delete.getName());
			mdmDicItemMapService.updateDicItemMap(dicItemMap);;
			model.addAttribute("result", true);
			model.addAttribute("message", "解除绑定映射成功！");
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", false);
			model.addAttribute("message", "解除绑定映射关系出错，请与管理员联系！");
			return model;
		}
	}
	
	
	@RequestMapping("/getDicItemSelect")
	@ResponseBody
	public SelectDTO<DicItem> getDicItemSelect(
			HttpServletRequest request,
			ModelMap model,
			@RequestParam(required = false, value = "inputValue") String name,
			@RequestParam(required = false, value = "fullPyName") String fullPyName,
			@RequestParam(required = false, value = "pyName") String pyName,
			@RequestParam(required = false, value = "subsid") String subsid,
			@RequestParam(required = false, value = "currentPage") int indexPage,
			String majorVersionFlag) {

		Page page = super.getPage(request, indexPage);
		if (ObjectUtil.isNotEmpty(majorVersionFlag)) {
			DicItem dicItem = new DicItem();
			if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_organ_code"))) {
				dicItem.setOrganCode(String.valueOf(request.getSession().getAttribute("dic_organ_code")));
			}
			dicItem.setItemName(name);
			if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_code"))) {
				dicItem.setDicCode(String.valueOf(request.getSession().getAttribute("dic_code")));
			}
			
			if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_version"))) {
				dicItem.setVersion(Long.valueOf(String.valueOf(request.getSession().getAttribute("dic_version"))));
			}
			
			PageList<DicItem> dicItemList = dictionaryService.getDicItemPageList(page, dicItem, true);
			SelectDTO<DicItem> result = new SelectDTO<>(dicItemList);
			return result;
		} else {
			Criteria criteria = new Criteria("status", StatusValue.normalValue.getValue());
			criteria.add("version", request.getSession().getAttribute("dic_version"));
//			if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_organ_code"))) {
//				criteria.add("cs1", request.getSession().getAttribute("dic_organ_code")); // 字典表中没有机构字段，用扩展字段CS1存放
//			}
			
			if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_code"))) {
				criteria.add("dicCode", request.getSession().getAttribute("dic_code"));
			}
			
			// 可能是字典编码、名称、拼音、五笔码
			if (ObjectUtil.isNotEmpty(name)) {
				Criteria criteria2 = new Criteria("itemName", OP.LIKE, name)
						.add(LOP.OR, new Criteria("itemCode", OP.LIKE, name))
						.add(LOP.OR, new Criteria("pyCode", OP.LIKE, name))
						.add(LOP.OR, new Criteria("wbCode", OP.LIKE, name));
				criteria.add(criteria2);
			}
			PageList<DicItem> dicItemList = dictionaryService.getDicItems(page, criteria);
			SelectDTO<DicItem> result = new SelectDTO<>(dicItemList);
			return result;
		}
		
	}
	
	@RequestMapping("/getDicItemMapSelect")
	@ResponseBody
	public SelectDTO<DicItemMap> getDicItemMapSelect(
			HttpServletRequest request,
			ModelMap model,
			@RequestParam(required = false, value = "inputValue") String name,
			@RequestParam(required = false, value = "fullPyName") String fullPyName,
			@RequestParam(required = false, value = "pyName") String pyName,
			@RequestParam(required = false, value = "subsid") String subsid,
			@RequestParam(required = false, value = "currentPage") int indexPage,
			String hospitalFlag) {

		Page page = super.getPage(request, indexPage);
		
//		Criteria criteria = new Criteria("status", StatusValue.normalValue.getValue()).add("itemCodeVersion", request.getSession().getAttribute("dic_version")); // 1:状态可用
		
		DicItemMap dicItemMap = new DicItemMap();
		if (ObjectUtil.isNullOrEmpty(hospitalFlag)) {
			dicItemMap.setItemName(name);
		} else {
			dicItemMap.setLocalItemName(name);
		}
		
		if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_version"))) {
			dicItemMap.setItemCodeVersion(Long.valueOf(String.valueOf(request.getSession().getAttribute("dic_version"))));
		}
		
		if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_organ_code"))) {
			dicItemMap.setDomainId(String.valueOf(request.getSession().getAttribute("dic_organ_code")));
		}
		
		if (ObjectUtil.isNotEmpty(request.getSession().getAttribute("dic_code"))) {
			dicItemMap.setDicCode(String.valueOf(request.getSession().getAttribute("dic_code")));
		}
		// 可能是字典编码、名称、拼音、五笔码
//		if (ObjectUtil.isNotEmpty(name)) {
//			Criteria criteria2 = new Criteria("itemName", OP.LIKE, name)
//					.add(LOP.OR, new Criteria("itemCode", OP.LIKE, name))
//					.add(LOP.OR, new Criteria("pyCode", OP.LIKE, name))
//					.add(LOP.OR, new Criteria("wbCode", OP.LIKE, name));
//			criteria.add(criteria2);
//		}
//		PageList<DicItemMap> dicItemMapList = mdmDicItemMapService.getDicItemMapPageList(criteria, page);
		PageList<DicItemMap> dicItemMapList = mdmDicItemMapService.getDistinctDicItemMapPageList(dicItemMap, page, hospitalFlag);
		SelectDTO<DicItemMap> result = new SelectDTO<>(dicItemMapList);
		return result;
	}
	
}
