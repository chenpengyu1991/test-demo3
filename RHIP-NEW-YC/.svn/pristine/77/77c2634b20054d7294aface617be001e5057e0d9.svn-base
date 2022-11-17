package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.FileManager;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.portal.common.OperationName;
import com.founder.rhip.portal.service.IFileManagerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

@Controller
@RequestMapping(value="/fileManager")
public class FileManagerController extends BaseController{

	@Resource(name = "fileManagerService")
	private IFileManagerService fileManagerService;

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	/**
	 * 资料下载首页
	 * @param request
	 * @param model
	 * @param indexPage
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/index")
	public String toFile(HttpServletRequest request, ModelMap model, Integer indexPage, String type) {
		Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
		Criteria criteria = new Criteria();
		criteria.add("is_delete", "0");
		criteria.add("status", "1");
		if(StringUtil.isNotEmpty(type)) {//资料类型判断，当前位置和选择资料下载的子菜单的时候用到
			criteria.add("file_type", type);
		}
		PageList<FileManager> filePageList = fileManagerService.getFileManagers(criteria, page);
		model.addAttribute("fileList", filePageList.getList());
		model.addAttribute("page", filePageList.getPage());
		model.addAttribute("type", type);
		model.addAttribute("operation", "fileManagerClick");
		return "lhportal.fileManager.index";
	}
	
	@RequestMapping(value="/fileDetail")
	public String fileDetail(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		FileManager fileDetail = fileManagerService.getFileManager(new Criteria("id", id));
		Long times = fileDetail.getTimes();
		times++;//浏览人数加1
		fileDetail.setTimes(times);
		fileManagerService.update(fileDetail);
		Criteria criteria = new Criteria();
		criteria.add("resourceId", id);
		criteria.add("fileResource", "lhpwdgl");
		List<UploadInfoRecord> uploadInfoRecord = uploadInfoRecordService.queryUploadInfoRecord(criteria);
		if (ObjectUtil.isNotEmpty(fileDetail)){
			String contents = fileDetail.getContents();
			if (ObjectUtil.isNotEmpty(contents)){
				contents=changeImageSrc(contents);
				fileDetail.setContents(contents);
			}
		}
		model.addAttribute("fileDetail", fileDetail);
		model.addAttribute("uploadInfoRecord", uploadInfoRecord);
		model.addAttribute("type", type);
		model.addAttribute("operation", "fileManagerClick");
		return "lhportal.fileManager.infoDetail";
	}
	
	@RequestMapping("/download/{id}")
	public void download(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		if (id == null) {
			return;
		}
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("ID", id));
		UploadInfoRecord uploadInfoRecord = null;
		String fileName = null;
		if (ObjectUtil.isNullOrEmpty(uploadInfoRecords) || (uploadInfoRecord = uploadInfoRecords.get(0)) == null
				|| ObjectUtil.isNullOrEmpty(fileName = uploadInfoRecord.getOriginalFileName())) {
			return;
		}
        createOperationLog(request, RhipModuleName.LHPORTAL, "文件下载", OperationName.EXP);
		// 设置对应的文件类型
		setContentType(fileName, response, request);
		
		OutputStream os = null;
		InputStream is = null;
		try {
			os = response.getOutputStream();
			is = new FileInputStream(uploadInfoRecord.getOriginalFilePath());
			int len = 0;
			byte buffer[] = new byte[3 * 1024];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * 设置不同类型文件
	 * @param fileName
	 * @param response
	 */
	private void setContentType(String fileName, HttpServletResponse response, HttpServletRequest request) {
		if (ObjectUtil.isNullOrEmpty(fileName)) {
			return;
		}
		
		try {
			String userAgent = request.getHeader("User-Agent").toLowerCase();
			StringTokenizer st = new StringTokenizer(userAgent,";");
			st.nextToken();
			//得到用户的浏览器名
			String accBrowser = st.nextToken().trim();
			//得到用户的操作系统名
			/*String accOs = st.nextToken().trim();*/
			String name = "";
			if(accBrowser.contains("mac")){
				name = new String(fileName.getBytes("UTF-8"),"ISO8859_1");
			}else{
				name = new String(fileName.getBytes("GBK"),"ISO8859_1");
			}
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
			if (StringUtils.endsWithIgnoreCase(fileName, "xls") || StringUtils.endsWithIgnoreCase(fileName, "xlsx")) {
				response.setContentType("application/vnd.ms-excel"); 
			} else if (StringUtils.endsWithIgnoreCase(fileName, "ppt")  || StringUtils.endsWithIgnoreCase(fileName, "pptx")) {
				response.setContentType("application/vnd.ms-powerpoint"); 
			} else if (StringUtils.endsWithIgnoreCase(fileName, "doc") || StringUtils.endsWithIgnoreCase(fileName, "docx")) {
				response.setContentType("application/vnd.ms-msword");
			} else if (StringUtils.endsWithIgnoreCase(fileName, "pdf")) {
				response.setContentType("application/pdf");
			} else if (StringUtils.endsWithIgnoreCase(fileName, "txt")) {
				response.setContentType("application/rtf");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
