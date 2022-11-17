package com.founder.rhip.portal.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.FileManager;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.portal.service.IFileManagerService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文档管理
 */
@Controller
@RequestMapping("/fileManager")
public class FileManagerController extends BaseController {

	@Resource(name = "fileManagerService")
	private IFileManagerService fileManagerService;

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@RequestMapping(value = "/search")
	public String search(ModelMap model,HttpServletRequest request) {
		return "rhip.lhportal.file.search";
	}
	
	/**
     * 文档列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String searchFileList(FileManager fileManager, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = this.formCriteria(fileManager);
		if(!hasRole(RoleType.ADMIN, request)){
			String organCode = SecurityUtils.getCurrentOrganization(request).getOrganCode();
			criteria.add("CREATE_ORG_CODE",organCode);
		}
		PageList<FileManager> plist = fileManagerService.getFileManagers(criteria, page);
		model.addAttribute("fileManagers", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.lhportal.file.list";
    }
    
	/**
	 * 初始化新增页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/add")
	public String initAdd(Long fileId, ModelMap model,HttpServletRequest request) {
		FileManager fileManager = new FileManager();
		if(ObjectUtil.isNotEmpty(fileId)) {
			fileManager = fileManagerService.getFileManager(new Criteria("id", fileId));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", fileId).add("FILE_RESOURCE", "lhpwdgl"));
			model.addAttribute("attches", uploadInfoRecords);
		}
		model.addAttribute("fileManager", fileManager);
		return "rhip.lhportal.file.add";
	}
	
	/**
	 * 查看页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/view")
	public String view(Long fileId, ModelMap model,HttpServletRequest request) {
		FileManager fileManager = new FileManager();
		if(ObjectUtil.isNotEmpty(fileId)) {
			fileManager = fileManagerService.getFileManager(new Criteria("id", fileId));
			List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", fileId).add("FILE_RESOURCE", "lhpwdgl"));
			model.addAttribute("attches", uploadInfoRecords);
		}
		model.addAttribute("fileManager", fileManager);
		return "rhip.lhportal.file.view";
	}
	
	/**
	 * 文档的新增和更新
	 * @param fileManager
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Map<String, Object> save(@Valid FileManager fileManager, HttpServletRequest request,ModelMap model)  throws Exception {
		boolean result = false;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("lhpwdgl_fileMap"); // 附件
		Map<String, String> filenameMap = (Map<String, String>) request.getSession().getAttribute("lhpwdgl_filenameMap"); //原文件名
		map = validateAttchement(map, fileMap, fileManager.getId(), false);
		if (ObjectUtil.isNotEmpty(map)) {
			return map;
		}
		String createUserCode = getCurrentUser(request).getUserCode();
		if(ObjectUtil.isNotEmpty(fileManager)){
			//新增
			if(ObjectUtil.isNullOrEmpty(fileManager.getId())) {
				this.setBasicInfo(fileManager, request, "1");
				result = fileManagerService.save(fileManager, fileMap,filenameMap, createUserCode);
			} else {//更新
				this.setBasicInfo(fileManager, request, "2");
				result = fileManagerService.update(fileManager, fileMap,filenameMap, createUserCode);
			}
		}
		// 保存成功清理session
		if (result && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("lhpwdgl_fileMap");
		}
		if (result && ObjectUtil.isNotEmpty(fileMap)) {
			request.getSession().removeAttribute("lhpwdgl_filenameMap");
		}
		map.put("message", result ? "success" : "fail");
		return map;
	}

	@RequestMapping("/publish")
	public void publish(Long fileId, String fileStatus, HttpServletResponse response, HttpServletRequest request) {
		boolean result = false;
		if(ObjectUtil.isNullOrEmpty(fileId)){
			MessageUtils.outputJSONResult("idIsNull", response);
			return;
		}
		result = fileManagerService.publish(fileId, "1");
		super.createOperationLog(request, RhipModuleName.LHPORTAL, "文档管理", OperationName.UPDATE);
		MessageUtils.outputJSONResult(result ? "success" : "fail", response);
	}
	
	/**
	 *撤回审核
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/unpublish")
	public void unpublish(Long fileId, HttpServletResponse response, HttpServletRequest request) {
		boolean result = false;
		if(ObjectUtil.isNullOrEmpty(fileId)){
			MessageUtils.outputJSONResult("idIsNull", response);
			return;
		}
		result = fileManagerService.publish(fileId, "0");
		super.createOperationLog(request, RhipModuleName.LHPORTAL, "文档管理", OperationName.UPDATE);
		MessageUtils.outputJSONResult(result ? "success" : "fail", response);
	}
	


	@RequestMapping("/delete")
	public void delete(Long fileId,HttpServletResponse response, HttpServletRequest request) {
		boolean result = false;
		if(ObjectUtil.isNullOrEmpty(fileId)){
			MessageUtils.outputJSONResult("idIsNull", response);
			return;
		}
		result = fileManagerService.delete(fileId);
		super.createOperationLog(request, RhipModuleName.LHPORTAL, "文档管理", OperationName.DELETE);
		MessageUtils.outputJSONResult(result ? "success" : "fail", response);
	}
	
	private void setBasicInfo(FileManager fileManager, HttpServletRequest request, String type) {
		Date nowDate = new Date();
		if(StringUtils.equals(type, "1")) {
			fileManager.setTimes(0L);
			fileManager.setCreateDate(nowDate);
			fileManager.setCreateOrgCode(this.getCurrentOrg(request).getOrganCode());
			fileManager.setCreateUserCode(getCurrentUser(request).getUserCode());
		} 
		fileManager.setUpdateDate(nowDate);
		fileManager.setUpdateOrgCode(this.getCurrentOrg(request).getOrganCode());
		fileManager.setUpdateUserCode(getCurrentUser(request).getUserCode());
	}
	
	private Criteria formCriteria(FileManager fileManager) {
		Criteria criteria = new Criteria();
		if(StringUtils.isNotBlank(fileManager.getTitle())) {
			Criteria criteriaOr = new Criteria("title",OP.LIKE ,fileManager.getTitle());
			criteria.add(criteriaOr);
		}
		if(StringUtils.isNotBlank(fileManager.getFileType())) {
			criteria.add("fileType",fileManager.getFileType());
		}
		
		Date fromDate = DateUtil.parseSimpleDate(fileManager.getDateFrom(), null);
		Date fromEnd = DateUtil.parseSimpleDate(fileManager.getDateTo(), null);
		DateUtil.getCriteriaByDateRange(criteria, "updateDate", fromDate,fromEnd);
		criteria.add("IS_DELETE", "0");
		return criteria;
	}
}